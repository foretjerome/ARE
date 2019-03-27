package fr.unedic.cali.parcours.population;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionForcage;
import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.parcours.DomTraitementOccasionnel;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.ResultatReexecutionCali;
import fr.unedic.cali.utilitaire.filtres.composites.FiltreAttributionStandardAssurance;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreAttributionPourRsod;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.metiers.FiltreAttributionEnCoursIndemnisationPourDate;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.QuantiteJour;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import java.util.Iterator;

public class ParcoursPopulationNeutralisationIndusForcageDecalage
  extends ParcoursPopulationAbstraite
  implements ParcoursPopulationSpec
{
  private static final String DEBUT_FIN_DE_DIFFERE = "AF";
  private static final int STATUT_DEFINITIF = 3;
  private static final int STATUT_ATTENTE_JUSTIFICATIF = 4;
  
  public Resultat demarrer(Contexte contexte)
    throws ApplicativeException
  {
    ResultatReexecutionCali resultatReexecutionCali = new ResultatReexecutionCali();
    DomTraitementOccasionnel domReexecutionCali = (DomTraitementOccasionnel)contexte.getDonnees();
    IndividuSpec individu = domReexecutionCali.getIndividu();
    
    PbjcNcp pbjc = null;
    PbjcNcp pbjcPivot = null;
    ParcoursPopulationNeutralisationIndusForcageDecalage.Tupple tupple = new ParcoursPopulationNeutralisationIndusForcageDecalage.Tupple(this, null);
    Damj dateEcart = domReexecutionCali.getDate();
    Damj datePrecedentEcart = dateEcart.getDebutMois().veille();
    
    Damj dateDebutUtForce = null;
    Damj dateFinUtForce = null;
    DemandeSpec demandeAForcer = null;
    
    Chronologie chronoPbjc = individu.getChronoPbjcs();
    Iterator<?> ite = chronoPbjc.iterer();
    while ((ite.hasNext()) && (pbjcPivot == null))
    {
      pbjc = (PbjcNcp)ite.next();
      if ((estChevauchementEntrePbjc(pbjc, dateEcart)) && ((pbjc.getRefOdPjcFaitGenerateurOrigine() > 0) || (pbjc.getIdentifiantReprise() > 0))) {
        pbjcPivot = pbjc;
      }
    }
    if (pbjcPivot != null)
    {
      traitementUtPrecedentes(individu, pbjcPivot, tupple, datePrecedentEcart);
      if (tupple.getPbjcAForcer() != null)
      {
        dateDebutUtForce = tupple.getPbjcAForcer().getDateDebut().getDebutMois();
        dateFinUtForce = tupple.getPbjcAForcer().getDateFin().getFinMois();
        
        Chronologie chronoDemandesAsu = individu.getChronoDemandeAssurance();
        FiltreET filtre = new FiltreET();
        filtre.ajouterFiltre(new FiltreAttributionStandardAssurance(true, true, false, false, null));
        filtre.ajouterFiltre(new FiltreAttributionPourRsod(Integer.toString(tupple.getPbjcAForcer().getRefOdPjcFaitGenerateurOrigine())));
        filtre.ajouterFiltre(new FiltreAttributionEnCoursIndemnisationPourDate(domReexecutionCali.getDate().getDebutMois()));
        demandeAForcer = OutilRecherche.rechercherDemandeSuivante(chronoDemandesAsu, Damj.NUIT_DES_TEMPS, filtre);
        
        GestionForcage.forcerCreditDecalage(demandeAForcer, dateDebutUtForce, dateFinUtForce, new QuantiteJour(Integer.toString(tupple.getNbrJourDecalage())));
        GestionForcage.forcerStatut(demandeAForcer, dateDebutUtForce, dateFinUtForce, 3);
      }
    }
    resultatReexecutionCali = effectuerReexecution(contexte);
    resultatReexecutionCali.setEtat(0);
    resultatReexecutionCali.setFailure(false);
    return resultatReexecutionCali;
  }
  
  private void traitementUtPrecedentes(IndividuSpec individu, PbjcNcp pbjcPivot, ParcoursPopulationNeutralisationIndusForcageDecalage.Tupple tupple, Damj datePrecedentEcart)
  {
    boolean estRSODDifferent = false;
    Chronologie chronoPbjc = individu.getChronoPbjcs();
    Iterator<?> ite = chronoPbjc.iterer();
    while (ite.hasNext())
    {
      PbjcNcp pbjc = (PbjcNcp)ite.next();
      if (estChevauchementEntrePbjc(pbjc, datePrecedentEcart)) {
        if ((pbjcPivot.getRefOdPjcFaitGenerateurOrigine() == pbjc.getRefOdPjcFaitGenerateurOrigine()) && (pbjcPivot.getIdentifiantReprise() == pbjc.getIdentifiantReprise()))
        {
          tupple.setNbrJourDecalage(tupple.getNbrJourDecalage() + pbjc.getNbJoursDecalage());
          if ((pbjc.getStatutPaiement() == 4) && (pbjc.getNbJoursDecalage() == 0)) {
            tupple.setNbrJourDecalage(tupple.getNbrJourDecalage() + pbjc.getDuree());
          }
          if (pbjc.contientComplementDeJustification("AF")) {
            tupple.setPbjcAForcer(pbjc);
          }
        }
        else
        {
          estRSODDifferent = true;
        }
      }
    }
    if ((tupple.getPbjcAForcer() == null) && (!estRSODDifferent))
    {
      tupple.setNbrJourDecalage(0);
      traitementUtPrecedentes(individu, pbjcPivot, tupple, datePrecedentEcart.getDebutMois().veille());
    }
  }
  
  private boolean estChevauchementEntrePbjc(PbjcNcp pbjc, Damj dateEcart)
  {
    return (pbjc.getDateDebut().getMois() == dateEcart.getMois()) && (pbjc.getDateDebut().getAnnee() == dateEcart.getAnnee());
  }
  
  private ResultatReexecutionCali effectuerReexecution(Contexte contexte)
    throws ApplicativeException
  {
    ParcoursPopulationReexecution parcours = new ParcoursPopulationReexecution();
    ResultatReexecutionCali resultat = (ResultatReexecutionCali)parcours.demarrer(contexte);
    return resultat;
  }
}

/* Location:
 * Qualified Name:     ParcoursPopulationNeutralisationIndusForcageDecalage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */