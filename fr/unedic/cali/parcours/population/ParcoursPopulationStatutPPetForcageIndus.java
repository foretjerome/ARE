package fr.unedic.cali.parcours.population;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
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

public class ParcoursPopulationStatutPPetForcageIndus
  extends ParcoursPopulationAbstraite
  implements ParcoursPopulationSpec
{
  public static final int STATUT_PAIEMENT_PAR_AVANCE = 5;
  public static final int STATUT_DEFINITIF = 3;
  
  public Resultat demarrer(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatReexecutionCali resultatReexecutionCali = new ResultatReexecutionCali();
    
    DomTraitementOccasionnel domReexecutionCali = (DomTraitementOccasionnel)p_contexte.getDonnees();
    PbjcNcp pbjc = null;
    PbjcNcp pbjcAForcer = null;
    int nbrJourDecalage = 0;
    Damj dateDebutUtForce = null;
    Damj dateFinUtForce = null;
    DemandeSpec demandeAForcer = null;
    
    IndividuSpec individu = domReexecutionCali.getIndividu();
    
    Chronologie chronoPbjc = individu.getChronoPbjcs();
    Iterator ite = chronoPbjc.iterer();
    while (ite.hasNext())
    {
      pbjc = (PbjcNcp)ite.next();
      if ((pbjc.getStatutPaiement() == 5) && (pbjc.getDateDebut().getMois() == domReexecutionCali.getDate().getMois()) && (pbjc.getDateDebut().getAnnee() == domReexecutionCali.getDate().getAnnee()))
      {
        nbrJourDecalage += pbjc.getNbJoursDecalage();
        pbjcAForcer = pbjc;
      }
    }
    dateDebutUtForce = pbjcAForcer.getDateDebut().getDebutMois();
    dateFinUtForce = pbjcAForcer.getDateFin().getFinMois();
    
    Chronologie chronoDemandesAsu = individu.getChronoDemandeAssurance();
    FiltreET filtre = new FiltreET();
    filtre.ajouterFiltre(new FiltreAttributionStandardAssurance(true, true, false, false, null));
    filtre.ajouterFiltre(new FiltreAttributionPourRsod(Integer.toString(pbjcAForcer.getRefOdPjcFaitGenerateurOrigine())));
    filtre.ajouterFiltre(new FiltreAttributionEnCoursIndemnisationPourDate(domReexecutionCali.getDate()));
    demandeAForcer = OutilRecherche.rechercherDemandeSuivante(chronoDemandesAsu, Damj.NUIT_DES_TEMPS, filtre);
    
    GestionForcage.forcerCreditDecalage(demandeAForcer, dateDebutUtForce, dateFinUtForce, new QuantiteJour(Integer.toString(nbrJourDecalage)));
    GestionForcage.forcerStatut(demandeAForcer, dateDebutUtForce, dateFinUtForce, 3);
    
    domReexecutionCali.setDate(dateDebutUtForce);
    if (dateDebutUtForce.estApres(PopulationSpec.DATE_LIMITE_NON_REEXECUTION)) {
      resultatReexecutionCali = effectuerReexecution(p_contexte);
    }
    resultatReexecutionCali.setEtat(0);
    resultatReexecutionCali.setFailure(false);
    return resultatReexecutionCali;
  }
  
  private ResultatReexecutionCali effectuerReexecution(Contexte p_contexte)
    throws ApplicativeException
  {
    ParcoursPopulationReexecution parcours = new ParcoursPopulationReexecution();
    ResultatReexecutionCali resultat = (ResultatReexecutionCali)parcours.demarrer(p_contexte);
    return resultat;
  }
}

/* Location:
 * Qualified Name:     ParcoursPopulationStatutPPetForcageIndus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */