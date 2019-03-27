package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import fr.unedic.cali.dom.AttributionAssuranceSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.OdAssuranceSpec;
import fr.unedic.cali.dom.affectation.ProduitAbstrait;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.fabriques.FabriqueStrategieControlePresenceFinDroitASP;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreActiviteSalarieSurMemeContratGAEC;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandeAsp;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieControlePresenceFinDroitASPSpec;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourClassement;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourReferenceExterneDemandeLiee;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreNegation;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.FiltresTemporel;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.Iterator;

public class OutilAsp
  extends OutilDroitAvecFinDroit
{
  private static final DureeCalendaire UN_AN = new DureeCalendaire(1, 0, 0);
  private static final DureeCalendaire DEUX_ANS = new DureeCalendaire(2, 0, 0);
  
  public static boolean estFinDroitAspNonInstalle(DemandeSpec p_demandeCourante, AttributionAssuranceSpec p_attributionPrecedente)
    throws CoucheLogiqueException
  {
    if (p_attributionPrecedente != null)
    {
      ProduitSpec produit = p_attributionPrecedente.getProduit();
      if (ProduitAbstrait.estDuType(5, produit)) {
        return false;
      }
      FabriqueStrategieControlePresenceFinDroitASP fabriqueControle = new FabriqueStrategieControlePresenceFinDroitASP();
      CritereStrategie critere = new CritereStrategie();
      critere.setDatePivot(p_attributionPrecedente.getOuvertureDroit().getDemande().getDateExamen());
      StrategieControlePresenceFinDroitASPSpec strategieControle = (StrategieControlePresenceFinDroitASPSpec)fabriqueControle.getStrategie(critere);
      if ((strategieControle.estUnDroitASP(p_attributionPrecedente)) && (!OutilDemande.estUneDemandeDeRevision(p_demandeCourante)) && (!OutilDemande.estUneDemandeDeRevisionAdmission(p_demandeCourante)) && (!OutilDemande.estUneDemandeFinDroitAsp(p_demandeCourante)))
      {
        DemandeSpec demandeFinAspSuivantDemandeAsp = rechercherDemandeFinAspSuivantDemandeAsp(p_attributionPrecedente.getDemande());
        if ((demandeFinAspSuivantDemandeAsp == null) || (p_demandeCourante.getDateExamen() == null) || ((!OutilDemande.estUneDemandeAsp(p_demandeCourante)) && (!demandeFinAspSuivantDemandeAsp.getDateRecherche().estAvantOuCoincideAvec(p_demandeCourante.getDateExamen()))) || ((OutilDemande.estUneDemandeAsp(p_demandeCourante)) && (!demandeFinAspSuivantDemandeAsp.getDateRecherche().estAvant(p_demandeCourante.getDateExamen())))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean estDemandeAspOuFinAsp(DemandeSpec p_demandeCourante)
  {
    return (OutilDemande.estUneDemandeAsp(p_demandeCourante)) || (OutilDemande.estUneDemandeFinDroitAsp(p_demandeCourante));
  }
  
  public static DemandeSpec rechercherDemandeFinAspSuivantDemandeAsp(DemandeSpec p_demande)
  {
    DemandeSpec demandeRetour = null;
    if ((p_demande != null) && 
      (estDeProduitAsp(p_demande)))
    {
      DemandeSpec demandeOuvertureDroit = p_demande;
      if ((demandeOuvertureDroit.getDossierAffectation().getDossierExamen() instanceof AttributionAssuranceSpec))
      {
        AttributionAssuranceSpec attributionAssuranceSpec = (AttributionAssuranceSpec)demandeOuvertureDroit.getDossierAffectation().getDossierExamen();
        demandeOuvertureDroit = attributionAssuranceSpec.getOuvertureDroit().getDemande();
      }
      int referenceExterne = Integer.parseInt(demandeOuvertureDroit.getFormulaire().getReferenceExterne());
      
      FiltreET filtreFinAsp = new FiltreET();
      filtreFinAsp.ajouterFiltre(new FiltreDemandePourReferenceExterneDemandeLiee(referenceExterne));
      filtreFinAsp.ajouterFiltre(new FiltreNegation(new FiltreDemandePourClassement("SO")));
      
      demandeRetour = OutilRecherche.rechercherDemandeSuivante(demandeOuvertureDroit.getChronologieDemandesAssuranceSansCourante(), Damj.NUIT_DES_TEMPS, filtreFinAsp);
    }
    return demandeRetour;
  }
  
  public static DemandeSpec getDemandeAspPrecedente(DemandeSpec p_demande, Damj p_dateRecherche)
  {
    FiltresTemporel listeFiltres = new FiltresTemporel();
    listeFiltres.ajouterFiltre(new FiltreDemandeAsp());
    
    DemandeSpec demandeRetour = null;
    Chronologie chronologieDemandes = p_demande.getDemandeur().getChronoDemandes().copier(listeFiltres);
    chronologieDemandes.setComparateur(new ComparateurSurDateDeclenchementDemandeDecroissante());
    chronologieDemandes.iterer();
    while (chronologieDemandes.encoreSuivant())
    {
      DemandeSpec demande = (DemandeSpec)chronologieDemandes.elementSuivant();
      if ((demande.estDecisionnee()) && (demande.getDateRecherche().estAvantOuCoincideAvec(p_dateRecherche)))
      {
        demandeRetour = demande;
        break;
      }
    }
    return demandeRetour;
  }
  
  public static boolean aAncienneteSuperieur1An(DemandeSpec p_demande, TravailSpec p_dernierSinistre)
  {
    boolean aAncienneteSuperieur1an = false;
    
    Periode contrat = rechercherAnciennete(p_demande, p_dernierSinistre);
    if (contrat != null) {
      if ((((ActiviteSalarie)p_dernierSinistre).getContrat() != null) && (((ActiviteSalarie)p_dernierSinistre).getContrat().getAncienneteCSP() != null))
      {
        int ancienneteCSP = ((ActiviteSalarie)p_dernierSinistre).getContrat().getAncienneteCSP().intValue();
        if ((ancienneteCSP == 2) || (ancienneteCSP == 3)) {
          return true;
        }
        if (ancienneteCSP == 1) {
          return false;
        }
        aAncienneteSuperieur1an = contrat.getDureeCalendaire().compareTo(UN_AN) >= 0;
      }
      else
      {
        aAncienneteSuperieur1an = contrat.getDureeCalendaire().compareTo(UN_AN) >= 0;
      }
    }
    return aAncienneteSuperieur1an;
  }
  
  public static boolean aAncienneteSuperieur2Ans(DemandeSpec p_demande, TravailSpec p_dernierSinistre)
  {
    boolean aAncienneteSuperieur2Ans = false;
    
    Periode contrat = rechercherAnciennete(p_demande, p_dernierSinistre);
    if (contrat != null) {
      if ((((ActiviteSalarie)p_dernierSinistre).getContrat() != null) && (((ActiviteSalarie)p_dernierSinistre).getContrat().getAncienneteCSP() != null))
      {
        int ancienneteCSP = ((ActiviteSalarie)p_dernierSinistre).getContrat().getAncienneteCSP().intValue();
        if (ancienneteCSP == 3) {
          return true;
        }
        if ((ancienneteCSP == 2) || (ancienneteCSP == 1)) {
          return false;
        }
        aAncienneteSuperieur2Ans = contrat.getDureeCalendaire().compareTo(DEUX_ANS) > 0;
      }
      else
      {
        aAncienneteSuperieur2Ans = contrat.getDureeCalendaire().compareTo(DEUX_ANS) > 0;
      }
    }
    return aAncienneteSuperieur2Ans;
  }
  
  private static Periode rechercherAnciennete(DemandeSpec p_demande, TravailSpec p_dernierSinistre)
  {
    Periode periode = null;
    if (p_dernierSinistre != null)
    {
      Chronologie chronoPeriodesFct = p_demande.getDemandeur().getChronoPeriodePasseProfessionnelLiquidation().copier(new FiltreActiviteSalarieSurMemeContratGAEC(p_dernierSinistre));
      
      Damj minCt = null;
      Damj maxCt = null;
      Damj debutCt = null;
      Damj finCt = null;
      if (!chronoPeriodesFct.estVide())
      {
        Iterator element = chronoPeriodesFct.iterer();
        while (element.hasNext())
        {
          ActiviteSalarie activiteSalarie = (ActiviteSalarie)element.next();
          
          debutCt = activiteSalarie.getDateDebut();
          if (activiteSalarie.getDateRuptureContratTravail() != null) {
            finCt = activiteSalarie.getDateRuptureContratTravail();
          } else {
            finCt = activiteSalarie.getDateFin();
          }
          if ((minCt == null) || (debutCt.estAvant(minCt))) {
            minCt = debutCt;
          }
          if ((maxCt == null) || (finCt.estApres(maxCt))) {
            maxCt = finCt;
          }
        }
        if ((minCt != null) && (maxCt != null)) {
          periode = new Periode(minCt, maxCt.lendemain());
        }
      }
    }
    return periode;
  }
}

/* Location:
 * Qualified Name:     OutilAsp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */