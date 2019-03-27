package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.dom.CalendrierExecutionAvantSpec;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.ObjetChronoPeriodeIndemnisationConcret;
import fr.unedic.cali.dom.affectation.ProduitForRfp04P01;
import fr.unedic.cali.dom.affectation.ProduitSolCge01P01;
import fr.unedic.cali.dom.affectation.ProduitSolCpa02P01;
import fr.unedic.cali.utilitaire.filtres.composites.FiltreAttributionStandardAssurance;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreAttributionSurDecisions;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionPourProduit;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreOU;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.OutilFonctionnel;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.ComparateurTemporelsSurDateDebut;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.ObjetChronoPeriodeConcrete;
import fr.unedic.util.temps.Periode;

public final class RechercherPeriodeIndemnisation
  implements OutilFonctionnel
{
  public static ObjetChronoPeriode rechercherPeriodeIndemniseeEffectiveAssurance(IndividuSpec individu, Damj date)
  {
    return rechercherPremierePeriodeIndemniseeEffectiveAssuranceChevauchantPeriode(individu, new Periode(date, date));
  }
  
  public static ObjetChronoPeriode rechercherPeriodeIndemniseeEffectiveAss(IndividuSpec individu, Damj date)
  {
    return rechercherPremierePeriodeIndemniseeEffectiveAssChevauchantPeriode(individu, new Periode(date, date));
  }
  
  public static ObjetChronoPeriode rechercherPremierePeriodeIndemniseeEffectiveAssuranceChevauchantPeriode(IndividuSpec individu, Periode periode)
  {
    ObjetChronoPeriode periodeIndemniseeAttribution = null;
    
    ChronologiePeriodes chronoPeriodesIndemnisation = getListePeriodesIndemnisationAssurance(individu, Damj.FIN_DES_TEMPS);
    
    chronoPeriodesIndemnisation.setComparateur(new ComparateurTemporelsSurDateDebut());
    
    chronoPeriodesIndemnisation.iterer();
    while (chronoPeriodesIndemnisation.encoreSuivant())
    {
      ObjetChronoPeriode periodeIndemnisable = (ObjetChronoPeriode)chronoPeriodesIndemnisation.elementSuivant();
      if (periodeIndemnisable.chevauche(periode))
      {
        periodeIndemniseeAttribution = periodeIndemnisable;
        break;
      }
    }
    return periodeIndemniseeAttribution;
  }
  
  public static ObjetChronoPeriode rechercherPremierePeriodeIndemniseeEffectiveRfpeChevauchantPeriode(IndividuSpec individu, Periode periode)
  {
    ObjetChronoPeriode periodeIndemniseeAttribution = null;
    
    ChronologiePeriodes chronoPeriodesIndemnisation = getListePeriodesIndemnisationRfpe(individu);
    
    chronoPeriodesIndemnisation.setComparateur(new ComparateurTemporelsSurDateDebut());
    
    chronoPeriodesIndemnisation.iterer();
    while (chronoPeriodesIndemnisation.encoreSuivant())
    {
      ObjetChronoPeriode periodeIndemnisable = (ObjetChronoPeriode)chronoPeriodesIndemnisation.elementSuivant();
      if (periodeIndemnisable.chevauche(periode))
      {
        periodeIndemniseeAttribution = periodeIndemnisable;
        break;
      }
    }
    return periodeIndemniseeAttribution;
  }
  
  public static ObjetChronoPeriode rechercherPremierePeriodeIndemniseeEffectiveAssChevauchantPeriode(IndividuSpec individu, Periode periode)
  {
    ObjetChronoPeriode periodeIndemniseeAttribution = null;
    
    ChronologiePeriodes chronoPeriodesIndemnisation = getListePeriodesIndemnisationAss(individu);
    
    chronoPeriodesIndemnisation.setComparateur(new ComparateurTemporelsSurDateDebut());
    
    chronoPeriodesIndemnisation.iterer();
    while (chronoPeriodesIndemnisation.encoreSuivant())
    {
      ObjetChronoPeriode periodeIndemnisable = (ObjetChronoPeriode)chronoPeriodesIndemnisation.elementSuivant();
      if (periodeIndemnisable.chevauche(periode))
      {
        periodeIndemniseeAttribution = periodeIndemnisable;
        break;
      }
    }
    return periodeIndemniseeAttribution;
  }
  
  public static ChronologiePeriodes getListePeriodesIndemnisationAssurance(IndividuSpec individu, Damj dateRecherche)
  {
    ChronologiePeriodes chronoPeriodesIndemnisation = new ChronologiePeriodes();
    Chronologie listeAttributionsAssurance = null;
    AttributionSpec attribution = null;
    
    listeAttributionsAssurance = OutilRecherche.rechercherDecisionsPrecedentes(individu.getChronoDemandeAssurance(), dateRecherche, new FiltreAttributionStandardAssurance(false, true, false, false, null));
    
    listeAttributionsAssurance.iterer();
    while (listeAttributionsAssurance.encoreSuivant())
    {
      attribution = (AttributionSpec)listeAttributionsAssurance.elementSuivant();
      
      Periode periode = getPeriodeIndemnisationPourAttribution(attribution);
      if (periode != null)
      {
        ObjetChronoPeriodeIndemnisationConcret periodeIndemnisation = new ObjetChronoPeriodeIndemnisationConcret(periode);
        periodeIndemnisation.setProduitAssociePeriode(attribution.getProduitExecution());
        chronoPeriodesIndemnisation.ajouter(periodeIndemnisation);
      }
    }
    return chronoPeriodesIndemnisation;
  }
  
  public static ChronologiePeriodes getListePeriodesIndemnisationRfpe(IndividuSpec individu)
  {
    ChronologiePeriodes chronoPeriodesIndemnisation = new ChronologiePeriodes();
    Chronologie listeAttributionsRfpe = null;
    AttributionSpec attribution = null;
    
    FiltreET filtre = new FiltreET();
    filtre.ajouterFiltre(new FiltreAttributionSurDecisions(true));
    filtre.ajouterFiltre(new FiltreDecisionPourProduit(ProduitForRfp04P01.getInstance().getCode()));
    
    listeAttributionsRfpe = OutilRecherche.rechercherDecisionsPrecedentes(individu.getChronoDemandeFormation(), Damj.FIN_DES_TEMPS, filtre);
    
    listeAttributionsRfpe.iterer();
    while (listeAttributionsRfpe.encoreSuivant())
    {
      attribution = (AttributionSpec)listeAttributionsRfpe.elementSuivant();
      
      Periode periode = getPeriodeIndemnisationPourAttribution(attribution);
      if (periode != null) {
        chronoPeriodesIndemnisation.ajouter(new ObjetChronoPeriodeConcrete(periode));
      }
    }
    return chronoPeriodesIndemnisation;
  }
  
  public static Periode getPeriodeIndemnisationPourAttribution(AttributionSpec attribution)
  {
    Periode periodeIndemnisation = null;
    if ((attribution.getCalendrierExecutionCalcul() != null) && (attribution.getCalendrierExecutionCalcul().getEtatAttribution() != 4))
    {
      if (OutilDemande.estUneDemandeFinDroit(attribution.getDemande())) {
        periodeIndemnisation = new Periode(attribution.getCalendrierExecutionCalcul().getPremierJourIndemnisable(), attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable());
      } else if (attribution.getDateEffet().estAvantOuCoincideAvec(attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable())) {
        periodeIndemnisation = new Periode(attribution.getDateEffet(), attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable());
      }
    }
    else if ((!attribution.getDemande().estEnReExamen()) && (attribution.estExecutable())) {
      if ((attribution.getCalendrierExecutionAvant() != null) && (attribution.getDateAttribution() != null))
      {
        Damj premierJourAvantPourLiquidation = Damj.max(attribution.getCalendrierExecutionAvant().getPremierJourAvant(), attribution.getDateAttribution());
        if ((premierJourAvantPourLiquidation == null) || (attribution.getCalendrierExecutionAvant().getDernierJourAvant() == null) || (attribution.getCalendrierExecutionAvant().getDernierJourAvant().estAvant(premierJourAvantPourLiquidation))) {
          return null;
        }
        periodeIndemnisation = new Periode(premierJourAvantPourLiquidation, attribution.getCalendrierExecutionAvant().getDernierJourAvant());
      }
      else
      {
        try
        {
          periodeIndemnisation = AppelCalculParLiquidation.determinerPeriodeAvantSansCalendrier(attribution);
        }
        catch (ApplicativeException ex)
        {
          periodeIndemnisation = null;
        }
      }
    }
    return periodeIndemnisation;
  }
  
  private static ChronologiePeriodes getListePeriodesIndemnisationAss(IndividuSpec individu)
  {
    ChronologiePeriodes chronoPeriodesIndemnisation = new ChronologiePeriodes();
    ObjetChronoPeriode periodeIndemnisation = null;
    Chronologie listeAttributionsAss = null;
    AttributionSpec attribution = null;
    
    FiltreET filtre = new FiltreET();
    FiltreOU filtreProduit = new FiltreOU();
    filtre.ajouterFiltre(new FiltreAttributionSurDecisions(true));
    filtre.ajouterFiltre(filtreProduit);
    
    filtreProduit.ajouterFiltre(new FiltreDecisionPourProduit(ProduitSolCge01P01.getInstance().getCode()));
    filtreProduit.ajouterFiltre(new FiltreDecisionPourProduit(ProduitSolCpa02P01.getInstance().getCode()));
    
    listeAttributionsAss = OutilRecherche.rechercherDecisionsPrecedentes(individu.getChronoDemandeSolidarite(), Damj.FIN_DES_TEMPS, filtre);
    if (listeAttributionsAss != null)
    {
      listeAttributionsAss.iterer();
      while (listeAttributionsAss.encoreSuivant())
      {
        attribution = (AttributionSpec)listeAttributionsAss.elementSuivant();
        if (attribution.getCalendrierExecutionCalcul() != null)
        {
          periodeIndemnisation = new ObjetChronoPeriodeConcrete(attribution.getDateEffet(), attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable());
          
          chronoPeriodesIndemnisation.ajouter(periodeIndemnisation);
        }
      }
    }
    return chronoPeriodesIndemnisation;
  }
  
  public static ChronologiePeriodes getListePeriodesIndemnisation(IndividuSpec individu, Chronologie attributions)
  {
    ChronologiePeriodes chronoPeriodesIndemnisation = new ChronologiePeriodes();
    Chronologie listeAttributions = null;
    AttributionSpec attribution = null;
    if (attributions != null) {
      listeAttributions = (ChronologieDebuts)attributions;
    } else {
      listeAttributions = OutilRecherche.rechercherDecisionsPrecedentes(individu.getChronoDemandes(), Damj.FIN_DES_TEMPS, new FiltreAttributionSurDecisions(true));
    }
    listeAttributions.iterer();
    while (listeAttributions.encoreSuivant())
    {
      attribution = (AttributionSpec)listeAttributions.elementSuivant();
      
      Periode periode = getPeriodeIndemnisationPourAttribution(attribution);
      if (periode != null) {
        chronoPeriodesIndemnisation.ajouter(new ObjetChronoPeriodeConcrete(periode));
      }
    }
    return chronoPeriodesIndemnisation;
  }
  
  public static ObjetChronoPeriode rechercherPremierePeriodeIndemniseeEffectiveTousProduitsChevauchantPeriode(IndividuSpec individu, Periode periode, Chronologie listeAttributions)
  {
    ObjetChronoPeriode periodeIndemniseeAttribution = null;
    
    ChronologiePeriodes chronoPeriodesIndemnisation = getListePeriodesIndemnisation(individu, listeAttributions);
    
    chronoPeriodesIndemnisation.setComparateur(new ComparateurTemporelsSurDateDebut());
    
    chronoPeriodesIndemnisation.iterer();
    while (chronoPeriodesIndemnisation.encoreSuivant())
    {
      ObjetChronoPeriode periodeIndemnisable = (ObjetChronoPeriode)chronoPeriodesIndemnisation.elementSuivant();
      if (periodeIndemnisable.chevauche(periode))
      {
        periodeIndemniseeAttribution = periodeIndemnisable;
        break;
      }
    }
    return periodeIndemniseeAttribution;
  }
  
  public static ChronologiePeriodes getListePeriodesIndemnisation(IndividuSpec individu)
  {
    ChronologiePeriodes chronoPeriodesIndemnisation = new ChronologiePeriodes();
    
    Chronologie listeAttributions = OutilRecherche.rechercherDecisionsPrecedentes(individu.getChronoDemandes(), Damj.FIN_DES_TEMPS, new FiltreAttributionSurDecisions(true));
    
    listeAttributions.iterer();
    while (listeAttributions.encoreSuivant())
    {
      AttributionSpec attribution = (AttributionSpec)listeAttributions.elementSuivant();
      
      Periode periode = getPeriodeIndemnisationPourAttribution(attribution);
      if (periode != null)
      {
        ObjetChronoPeriodeIndemnisationConcret periodeIndemnisation = new ObjetChronoPeriodeIndemnisationConcret(periode);
        periodeIndemnisation.setProduitAssociePeriode(attribution.getProduitExecution());
        periodeIndemnisation.setCodeSousProduitAssociePeriode(attribution.determinerCodeSousProduitPourSigma());
        chronoPeriodesIndemnisation.ajouter(periodeIndemnisation);
      }
    }
    return chronoPeriodesIndemnisation;
  }
}

/* Location:
 * Qualified Name:     RechercherPeriodeIndemnisation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */