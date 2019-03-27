package fr.unedic.cali.calcul;

import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnCharge;
import fr.unedic.cali.avant.FacadeAvantProduitFactory;
import fr.unedic.cali.avant.FacadeAvantProduitSpec;
import fr.unedic.cali.calcul.dom.CalendrierExecutionAvant;
import fr.unedic.cali.calcul.dom.EtatAuDernierJourAvant;
import fr.unedic.cali.calcul.dom.QualificationPeriodes;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeArretCalcul;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionSuivi;
import fr.unedic.cali.calcul.outilsfonctionnels.OutilGestionPoursuite;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.PoursuiteSpec;
import fr.unedic.cali.dom.RevisionSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.OutillagePEC;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreConflitGaec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreNegation;
import fr.unedic.cali.parcours.ResultatAvant;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.FiltreChevauchePeriode;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;

public class TraitementAvant
{
  protected static final int CENT = 100;
  
  public static ResultatAvant executerAvant(AttributionSpec attribution, boolean avecPriseEnCompteEvenement, Damj dateEtude, boolean executionPersistante)
    throws CoucheLogiqueException
  {
    ResultatAvant resultatAvant = null;
    Damj premierJourIndemnisable = null;
    Collection carencesEffectives = new ArrayList();
    ObjetChronoPeriodePriseEnCharge periodePriseEnCharge = null;
    ChronologiePeriodes chronologiePeriodes = new ChronologiePeriodes();
    ChronologiePeriodes chronologiePeriodesSansConflitGAEC = new ChronologiePeriodes();
    int etatCalendrierAvant = 0;
    Periode periodeUtAvant = null;
    Damj dateDebutUtAvant = null;
    Damj dateFinUtAvant = null;
    Damj finPriseEnCharge = null;
    CalendrierExecutionAvant calendrierAvant = new CalendrierExecutionAvant();
    calendrierAvant.setEtatExecutionAvant(1);
    IndividuSpec individu = attribution.getDemandeur();
    FacadeAvantProduitSpec facadeAvant = recupererFacadeAvantProduit(attribution);
    if (!facadeAvant.doitExecuterAvant(attribution))
    {
      resultatAvant = new ResultatAvant(attribution.getDateAttribution(), new ArrayList(), false);
      resultatAvant.setDernierJourAvant(attribution.getDateAttribution());
      resultatAvant.setEtat(0);
      return resultatAvant;
    }
    Collection listeCarrence = facadeAvant.recupererCarrence(attribution);
    if (facadeAvant.estUnContexteDeChomageEnCoursDeSuspensionAvecRupture(attribution, dateEtude)) {
      dateEtude = null;
    } else if (facadeAvant.estUnContexteDeChomageEnCoursDeSuspension(attribution)) {
      return facadeAvant.construireResultatAvantPourChomageSansRupture(attribution, listeCarrence);
    }
    calendrierAvant.setPremierJourAvant(facadeAvant.rechercherPremierJourAvant(attribution));
    
    dateDebutUtAvant = calendrierAvant.getPremierJourAvant().getDebutMois();
    dateFinUtAvant = dateDebutUtAvant.getFinMois();
    Damj dateAttribOuPjp = OutilGestionPoursuite.getInstance().recupererDateAttributionOuPjpSiPoursuite(attribution);
    if (avecPriseEnCompteEvenement)
    {
      chronologiePeriodes = facadeAvant.recupererPeriodeGAEC(attribution.getDemandeur(), attribution, dateAttribOuPjp, null);
      if (facadeAvant.ajouterFiltrePeriodeSurUT() != null) {
        chronologiePeriodes = (ChronologiePeriodes)chronologiePeriodes.copier(facadeAvant.ajouterFiltrePeriodeSurUT());
      }
      periodePriseEnCharge = OutillagePeriodes.recupererPeriodePECContenant(attribution.getDemandeur(), dateAttribOuPjp);
      if (estContexteDePecNullOuRevisionSurPecArce(attribution, periodePriseEnCharge))
      {
        if (verifierAttributionNonConforme(attribution)) {
          throw new CoucheLogiqueException("HG_PR_CALI_L_PAS_DE_PEC_POUR_EXECUTION_AVANT", "Attention lors de l'execution de l'avant, impossible de retrouver une periode de prise en charge.", null);
        }
        resultatAvant = new ResultatAvant(premierJourIndemnisable, facadeAvant.mettreAJourCarrenceSurRevisionHorsPec(listeCarrence, attribution.getDateAttribution()), false);
        resultatAvant.setDernierJourAvant(attribution.getDateAttribution());
        resultatAvant.setEtat(1);
        return resultatAvant;
      }
      finPriseEnCharge = periodePriseEnCharge.getDateFin();
    }
    else
    {
      chronologiePeriodes = (ChronologiePeriodes)facadeAvant.recupererPeriodeGAEC(attribution.getDemandeur(), attribution, dateAttribOuPjp, dateAttribOuPjp).copier(new FiltreChevauchePeriode(new Periode(dateAttribOuPjp, dateAttribOuPjp)));
      if (facadeAvant.ajouterFiltrePeriodeSurUT() != null) {
        chronologiePeriodes = (ChronologiePeriodes)chronologiePeriodes.copier(facadeAvant.ajouterFiltrePeriodeSurUT());
      }
      chronologiePeriodesSansConflitGAEC = (ChronologiePeriodes)chronologiePeriodes.copier(new FiltreNegation(new FiltreConflitGaec()));
      
      chronologiePeriodes = chronologiePeriodesSansConflitGAEC;
      
      QualificationPeriodes periodesQualifie = new QualificationPeriodes();
      periodesQualifie = facadeAvant.qualificationPeriodesPourAvant(chronologiePeriodes, attribution);
      
      chronologiePeriodes = periodesQualifie.getPeriodesSuspensives();
      chronologiePeriodes.ajouter(periodesQualifie.getPeriodesInterruptives());
    }
    if (dateEtude != null) {
      chronologiePeriodes.ajouter(new ObjetChronoPeriodeArretCalcul(dateEtude.lendemain()));
    }
    while ((calendrierAvant.getEtatExecutionAvant() != 3) && (!listeCarrence.isEmpty()))
    {
      periodeUtAvant = new Periode(dateDebutUtAvant, dateFinUtAvant);
      
      verifierBlocageExecution(periodeUtAvant, individu, attribution);
      
      dateDebutUtAvant = dateFinUtAvant.getDebutMoisSuivant();
      dateFinUtAvant = dateDebutUtAvant.getFinMois();
      
      etatCalendrierAvant = facadeAvant.executerUtAvant(attribution, calendrierAvant, periodeUtAvant, chronologiePeriodes);
    }
    if (etatCalendrierAvant == 0) {
      premierJourIndemnisable = calendrierAvant.getDernierJourAvant().lendemain();
    }
    if (avecPriseEnCompteEvenement)
    {
      if ((finPriseEnCharge != null) && (premierJourIndemnisable != null) && (finPriseEnCharge.estAvantOuCoincideAvec(calendrierAvant.getDernierJourAvant())) && (facadeAvant.mettreAjourPjiSurPecESSI(attribution, finPriseEnCharge, premierJourIndemnisable) != null)) {
        premierJourIndemnisable = facadeAvant.mettreAjourPjiSurPecESSI(attribution, finPriseEnCharge, premierJourIndemnisable);
      }
      genererEnqueteMaintiensESSI(finPriseEnCharge, calendrierAvant, attribution, premierJourIndemnisable);
    }
    resultatAvant = construireResultatAvant(listeCarrence, executionPersistante, attribution, calendrierAvant, carencesEffectives, resultatAvant, premierJourIndemnisable, etatCalendrierAvant);
    
    return resultatAvant;
  }
  
  private static FacadeAvantProduitSpec recupererFacadeAvantProduit(AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    return FacadeAvantProduitFactory.getInstance().getInstanceFacadeAvantProduit(attribution.getProduitExecution());
  }
  
  private static boolean estContexteDeRevisionSurPecArce(AttributionSpec attribution, ObjetChronoPeriodePriseEnCharge periodePEC)
  {
    return ((attribution instanceof RevisionSpec)) && (periodePEC.estDeTypeArce());
  }
  
  private static boolean estContexteDePecNullOuRevisionSurPecArce(AttributionSpec attribution, ObjetChronoPeriodePriseEnCharge periodePriseEnCharge)
  {
    return (periodePriseEnCharge == null) || (estContexteDeRevisionSurPecArce(attribution, periodePriseEnCharge));
  }
  
  private static void verifierBlocageExecution(Periode periodeUtAvant, IndividuSpec individu, AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    if ((individu != null) && (individu.getDateNaissance() != null) && (periodeUtAvant.getDebut().estApres(individu.getDateNaissance().deplacerVersAvant(new DureeCalendaire(100))))) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_EXECUTION_ATTRIBUTION_DEMARRE_JAMAIS", new Object[] { attribution.getDateAttribution() });
    } else if (periodeUtAvant.getDebut().estApres(new Damj("2200, 01, 01"))) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_EXECUTION_ATTRIBUTION_DEMARRE_JAMAIS", new Object[] { attribution.getDateAttribution() });
    } else if (periodeUtAvant.getDebut().estApres(Damj.FIN_DES_TEMPS)) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_EXECUTION_ATTRIBUTION_DEMARRE_JAMAIS", new Object[] { attribution.getDateAttribution() });
    }
  }
  
  private static boolean verifierAttributionNonConforme(AttributionSpec attribution)
  {
    return (!(attribution instanceof RevisionSpec)) && (!"ASU_17".equals(attribution.getTypeExamen())) && (!"ASU_25".equals(attribution.getTypeExamen())) && (!"ASU_19".equals(attribution.getTypeExamen())) && (((!"ASU_22".equals(attribution.getTypeExamen())) && (!"ASU_23".equals(attribution.getTypeExamen()))) || ((attribution instanceof PoursuiteSpec)));
  }
  
  private static void genererEnqueteMaintiensESSI(Damj finPriseEnCharge, CalendrierExecutionAvant calendrierAvant, AttributionSpec attribution, Damj premierJourIndemnisable)
    throws CoucheLogiqueException
  {
    if ((finPriseEnCharge != null) && (premierJourIndemnisable != null) && (finPriseEnCharge.estAvantOuCoincideAvec(calendrierAvant.getDernierJourAvant()))) {
      if (OutillagePEC.estPecSuivanteAutreEtatMembreCoordination(attribution.getDemandeur(), finPriseEnCharge))
      {
        Chronologie chronologiePecEuropeenne = OutillagePEC.getPeriodesPecAutreEtatMembreCoordinationDebutApresDate(attribution.getDemandeur(), finPriseEnCharge);
        ObjetChronoPeriodePriseEnCharge pec = (ObjetChronoPeriodePriseEnCharge)chronologiePecEuropeenne.premierElement();
        if (pec.getDateDebut().estContenueDans(calendrierAvant.getPeriode()))
        {
          FacadeCalculProduitSpec facadeCalculProduit = FacadeCalculProduitFactory.getInstance().getInstanceGestionnaireCalculProduit(attribution.getProduitExecution());
          
          GestionSuivi.enregistrerEnquetePbjcNcp(attribution, premierJourIndemnisable, 31, 0, true, null, facadeCalculProduit, null);
        }
      }
    }
  }
  
  private static ResultatAvant construireResultatAvant(Collection listeCarrence, boolean executionPersistante, AttributionSpec attribution, CalendrierExecutionAvant calendrierAvant, Collection carencesEffectives, ResultatAvant resultatAvant, Damj premierJourIndemnisable, int etatCalendrierAvant)
    throws CoucheLogiqueException
  {
    if (!listeCarrence.isEmpty())
    {
      if (executionPersistante) {
        attribution.setCalendrierExecutionAvant(calendrierAvant);
      }
      recupererFacadeAvantProduit(attribution).mettreAJourCarencesSurResultatAvant(calendrierAvant, attribution, carencesEffectives);
      
      resultatAvant = new ResultatAvant(premierJourIndemnisable, new ArrayList(carencesEffectives), calendrierAvant.getEtatAuDernierJourAvant().isDelaiAttenteEntame());
      resultatAvant.setEtat(etatCalendrierAvant);
      resultatAvant.setPremierJourAvant(calendrierAvant.getDateDebut());
      resultatAvant.setDernierJourAvant(calendrierAvant.getDateFin());
      resultatAvant.setCalendrierExecutionAvantCalcul(calendrierAvant);
      resultatAvant.setPeriodePECEvenementReducteur(calendrierAvant.getEtatAuDernierJourAvant().getPeriodePECEvenementReducteur());
    }
    else
    {
      attribution.setCalendrierExecutionAvant(null);
      if ((attribution instanceof PoursuiteSpec))
      {
        Damj pjiPoursuite = recupererFacadeAvantProduit(attribution).determinerPJIPoursuite(attribution);
        resultatAvant = new ResultatAvant(pjiPoursuite, new ArrayList(carencesEffectives), false);
        resultatAvant.setEtat(etatCalendrierAvant);
        resultatAvant.setPremierJourAvant(attribution.getDateAttribution());
        resultatAvant.setDernierJourAvant(pjiPoursuite.veille());
      }
      else
      {
        resultatAvant = new ResultatAvant(attribution.getDateAttribution(), new ArrayList(carencesEffectives), false);
        resultatAvant.setEtat(etatCalendrierAvant);
        resultatAvant.setPremierJourAvant(attribution.getDateAttribution());
        resultatAvant.setDernierJourAvant(attribution.getDateAttribution());
      }
    }
    if (etatCalendrierAvant == 1) {
      resultatAvant.setMessageErreur("Impossible de determiner le PJI : Un événement interruptif est survenu avant la fin du différé.");
    }
    return resultatAvant;
  }
}

/* Location:
 * Qualified Name:     TraitementAvant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */