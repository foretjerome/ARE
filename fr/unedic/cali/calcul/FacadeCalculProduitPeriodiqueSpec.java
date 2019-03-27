package fr.unedic.cali.calcul;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.dom.ArretProduitAvecRaison;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.ConstituantsCalculActiviteReduiteSpec;
import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.EtatAuDji;
import fr.unedic.cali.calcul.dom.QualificationPeriodes;
import fr.unedic.cali.calcul.dom.QuantiteNonIndemnises;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.periode.PeriodeSuspensionDDTEAvecImputation;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.ContexteUT;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.ElementBaseIndemnisationFacade;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAnalyseSpec;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodesPriseEnCompte;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.cali.dom.QuantiteDroitSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public abstract interface FacadeCalculProduitPeriodiqueSpec
  extends FacadeCalculProduitSpec
{
  public abstract UniteTraitement creerUT(Periode paramPeriode, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract void controlerAttribution(AttributionSpec paramAttributionSpec)
    throws ContexteException;
  
  public abstract ConstituantsIndemnisation miseAJourConstituantsIndemnisation(UniteTraitement paramUniteTraitement, AttributionSpec paramAttributionSpec, ConstituantsIndemnisation paramConstituantsIndemnisation, Damj paramDamj, Periode paramPeriode)
    throws CoucheLogiqueException;
  
  public abstract ConstituantsCalculActiviteReduiteSpec miseAJourCumulAR(UniteTraitement paramUniteTraitement, AttributionSpec paramAttributionSpec, ConstituantsCalculActiviteReduiteSpec paramConstituantsCalculActiviteReduiteSpec, ContexteUT paramContexteUT, ArretProduitAvecRaison paramArretProduitAvecRaison)
    throws CoucheLogiqueException;
  
  public abstract ConstituantsCalculActiviteReduiteSpec creationConstituantsCalculActiviteReduite(AttributionSpec paramAttributionSpec, ContexteUT paramContexteUT, ConstituantsIndemnisation paramConstituantsIndemnisation)
    throws CoucheLogiqueException;
  
  public abstract ConstituantsCalculActiviteReduiteSpec miseAjourConstituantsCalculActiviteReduite(AttributionSpec paramAttributionSpec, ConstituantsCalculActiviteReduiteSpec paramConstituantsCalculActiviteReduiteSpec, Damj paramDamj, ConstituantsIndemnisation paramConstituantsIndemnisation)
    throws CoucheLogiqueException;
  
  public abstract void initialisationQuantitesIndemnisation(ConstituantsIndemnisation paramConstituantsIndemnisation, AttributionSpec paramAttributionSpec, Periode paramPeriode)
    throws ApplicativeException;
  
  public abstract void initialiseElementBaseIndemnisationCourante(ConstituantsIndemnisation paramConstituantsIndemnisation, AttributionSpec paramAttributionSpec, Periode paramPeriode)
    throws CoucheLogiqueException;
  
  public abstract boolean epuisementQuantiteDroit(Damj paramDamj, AttributionSpec paramAttributionSpec, QuantiteDroitSpec paramQuantiteDroitSpec, ConstituantsIndemnisation paramConstituantsIndemnisation, UniteTraitement paramUniteTraitement)
    throws ApplicativeException;
  
  public abstract Quantite getQuantiteIndemnisableTheorique(Periode paramPeriode, AttributionSpec paramAttributionSpec, ConstituantsIndemnisation paramConstituantsIndemnisation, ContexteUT paramContexteUT);
  
  public abstract Damj getDateFinQuantiteDroit(Periode paramPeriode, AttributionSpec paramAttributionSpec, QuantiteDroitSpec paramQuantiteDroitSpec, ChronologiePeriodes paramChronologiePeriodes, Quantite paramQuantite, Damj paramDamj);
  
  public abstract Damj getDateFinProduit(AttributionSpec paramAttributionSpec, QuantiteDroitSpec paramQuantiteDroitSpec, Damj paramDamj);
  
  public abstract ChronologiePeriodes recupererPeriodesLieesAuContexte(ContexteUT paramContexteUT, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract ChronologiePeriodes recupererPeriodeAPartirDesPECs(ChronologiePeriodes paramChronologiePeriodes, Periode paramPeriode, Damj paramDamj)
    throws CoucheLogiqueException;
  
  public abstract QualificationPeriodes qualificationPeriodes(ChronologiePeriodes paramChronologiePeriodes, AttributionSpec paramAttributionSpec, ContexteUT paramContexteUT)
    throws CoucheLogiqueException;
  
  public abstract ChronologiePeriodes decoupageEtProratisationPeriodesActivites(PeriodesPriseEnCompte paramPeriodesPriseEnCompte, int paramInt, ChronologiePeriodes paramChronologiePeriodes, Periode paramPeriode)
    throws CoucheLogiqueException;
  
  public abstract void traitementPeriodesGelantes(AttributionSpec paramAttributionSpec, ChronologiePeriodes paramChronologiePeriodes, ConstituantsCalculActiviteReduiteSpec paramConstituantsCalculActiviteReduiteSpec, UniteTraitement paramUniteTraitement)
    throws CoucheLogiqueException;
  
  public abstract void traitementPeriodesDecalantes(AttributionSpec paramAttributionSpec, ChronologiePeriodes paramChronologiePeriodes, ConstituantsCalculActiviteReduiteSpec paramConstituantsCalculActiviteReduiteSpec, UniteTraitement paramUniteTraitement, ConstituantsIndemnisation paramConstituantsIndemnisation, ContexteUT paramContexteUT)
    throws CoucheLogiqueException;
  
  public abstract void traitementPeriodesSuspensives(AttributionSpec paramAttributionSpec, ChronologiePeriodes paramChronologiePeriodes, PeriodeAnalyseSpec paramPeriodeAnalyseSpec)
    throws CoucheLogiqueException;
  
  public abstract void traitementPeriodeSegmentante(AttributionSpec paramAttributionSpec, ObjetChronoPeriode paramObjetChronoPeriode, ConstituantsIndemnisation paramConstituantsIndemnisation, UniteTraitement paramUniteTraitement, PeriodeAnalyseSpec paramPeriodeAnalyseSpec, ArretProduitAvecRaison paramArretProduitAvecRaison, ChronologiePeriodes paramChronologiePeriodes)
    throws ApplicativeException;
  
  public abstract void traitementPeriodesAlertantes(AttributionSpec paramAttributionSpec, ObjetChronoPeriode paramObjetChronoPeriode, ConstituantsIndemnisation paramConstituantsIndemnisation, UniteTraitement paramUniteTraitement, PeriodeAnalyseSpec paramPeriodeAnalyseSpec, ArretProduitAvecRaison paramArretProduitAvecRaison)
    throws ApplicativeException;
  
  public abstract boolean verifierConditionExecutionEtEventuelAbandon(AttributionSpec paramAttributionSpec, ContexteUT paramContexteUT, Periode paramPeriode, CalendrierExecutionCalculSpec paramCalendrierExecutionCalculSpec)
    throws CoucheLogiqueException;
  
  public abstract boolean verifierImputationDuree(UniteTraitement paramUniteTraitement, ConstituantsIndemnisation paramConstituantsIndemnisation)
    throws CoucheLogiqueException;
  
  public abstract void filtrePriseEnComptePeriodesActiviteSurUT(PeriodesPriseEnCompte paramPeriodesPriseEnCompte, Periode paramPeriode, ContexteUT paramContexteUT, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract void controlerAPosterioriContexteUT(AttributionSpec paramAttributionSpec, ContexteUT paramContexteUT, UniteTraitement paramUniteTraitement, ArretProduitAvecRaison paramArretProduitAvecRaison)
    throws CoucheLogiqueException;
  
  public abstract AttributionSpec rechercherAttributionPrecedenteSurLUT(AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract ElementBaseIndemnisationFacade mapperUTVersElementBaseIndemnisation(UniteTraitement paramUniteTraitement, AttributionSpec paramAttributionSpec);
  
  public abstract Collection getEvtsChangementParametre(ConstituantsIndemnisation paramConstituantsIndemnisation, Damj paramDamj);
  
  public abstract void imputerQuantiteIndemnisationDuAuxPNDS(UniteTraitement paramUniteTraitement, ConstituantsIndemnisation paramConstituantsIndemnisation, ArretProduitAvecRaison paramArretProduitAvecRaison, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract void imputerQuantiteIndemnisationDuAuxSanctions(AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement, PeriodeSuspensionDDTEAvecImputation paramPeriodeSuspensionDDTEAvecImputation, ConstituantsIndemnisation paramConstituantsIndemnisation, ArretProduitAvecRaison paramArretProduitAvecRaison)
    throws ApplicativeException;
  
  public abstract void forcerImputationQuantiteIndemnisation(PeriodeAnalyseSpec paramPeriodeAnalyseSpec, ConstituantsIndemnisation paramConstituantsIndemnisation, ArretProduitAvecRaison paramArretProduitAvecRaison)
    throws CoucheLogiqueException;
  
  public abstract void determinerStatutUT(AttributionSpec paramAttributionSpec, ChronologiePeriodes paramChronologiePeriodes, ConstituantsCalculActiviteReduiteSpec paramConstituantsCalculActiviteReduiteSpec, UniteTraitement paramUniteTraitement, ArretProduitAvecRaison paramArretProduitAvecRaison, ContexteUT paramContexteUT)
    throws CoucheLogiqueException;
  
  public abstract void realiserDetectionFinDeProduitPourSuivi(AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement, ContexteUT paramContexteUT)
    throws CoucheLogiqueException;
  
  public abstract void traiterPeriodeInterruptiveDefinitive(AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement, ObjetChronoPeriode paramObjetChronoPeriode, ArretProduitAvecRaison paramArretProduitAvecRaison, CalendrierExecutionCalculPeriodique paramCalendrierExecutionCalculPeriodique)
    throws CoucheLogiqueException;
  
  public abstract EtatAuDji renseignerEtatAuDji(UniteTraitement paramUniteTraitement, CalendrierExecutionCalculPeriodique paramCalendrierExecutionCalculPeriodique, AttributionSpec paramAttributionSpec, EtatAuDji paramEtatAuDji)
    throws CoucheLogiqueException;
  
  public abstract void miseAJourMontantSurSommes(AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement, ConstituantsIndemnisation paramConstituantsIndemnisation, Damj paramDamj)
    throws CoucheLogiqueException;
  
  public abstract int initialiserCompteurFormation(AttributionSpec paramAttributionSpec);
  
  public abstract int calculerCompteurFormationSurUT(UniteTraitement paramUniteTraitement)
    throws CoucheLogiqueException;
  
  public abstract ChronologiePeriodes filtrerFormationsEffectives(ChronologiePeriodes paramChronologiePeriodes1, ChronologiePeriodes paramChronologiePeriodes2)
    throws CoucheLogiqueException;
  
  public abstract Collection filtrerRadiationSegmentante(Collection paramCollection, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract void ajouterConstituantsIndemnisationFuturs(ConstituantsIndemnisation paramConstituantsIndemnisation, AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement)
    throws CoucheLogiqueException;
  
  public abstract void miseAJourConstituantsIndemnisationADate(AttributionSpec paramAttributionSpec, ConstituantsIndemnisation paramConstituantsIndemnisation, Damj paramDamj, ChronologiePeriodes paramChronologiePeriodes)
    throws CoucheLogiqueException;
  
  public abstract void imputerAvant(ObjetChronoPeriode paramObjetChronoPeriode, ConstituantsIndemnisation paramConstituantsIndemnisation, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract void controlerDureeDetectionMaintien(ConstituantsIndemnisation paramConstituantsIndemnisation, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract BigDecimal determinerMontantRestantAvantPlafond(AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement, ContexteUT paramContexteUT, ConstituantsIndemnisation paramConstituantsIndemnisation, MontantBaseSpec paramMontantBaseSpec, PeriodeAnalyseSpec paramPeriodeAnalyseSpec)
    throws CoucheLogiqueException;
  
  public abstract void cumulerMontantGlobalServiAttribution(ConstituantsIndemnisation paramConstituantsIndemnisation, Quantite paramQuantite, MontantBaseSpec paramMontantBaseSpec, AttributionSpec paramAttributionSpec);
  
  public abstract BigDecimal recupererPlafondGlobal(AttributionSpec paramAttributionSpec, Damj paramDamj);
  
  public abstract BigDecimal recupererPlafondGlobalDerogatoire(AttributionSpec paramAttributionSpec);
  
  public abstract BigDecimal determinerCumulServiADate(AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement, ContexteUT paramContexteUT, ConstituantsIndemnisation paramConstituantsIndemnisation)
    throws CoucheLogiqueException;
  
  public abstract String recupererCategorieAttribution(AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement)
    throws CoucheLogiqueException;
  
  public abstract void incrementationNbMoisInactivite(ConstituantsCalculActiviteReduiteSpec paramConstituantsCalculActiviteReduiteSpec);
  
  public abstract int calculerCompteurNombreJoursIndemnisesSurUT(UniteTraitement paramUniteTraitement, int paramInt);
  
  public abstract void ajouterEvenementDebutImputation(PeriodeAnalyseSpec paramPeriodeAnalyseSpec, List paramList);
  
  public abstract int initialiserNombreMoisIndemnise(AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement, ContexteUT paramContexteUT)
    throws CoucheLogiqueException;
  
  public abstract int calculerCompteurNombreMoisIndemnisesSurUT(UniteTraitement paramUniteTraitement, int paramInt);
  
  public abstract boolean recuperationAlimentationNombreMoisIndemnise(AttributionSpec paramAttributionSpec);
  
  public abstract Quantite convertir(Quantite paramQuantite, Unite paramUnite, ConstituantsIndemnisation paramConstituantsIndemnisation, Damj paramDamj)
    throws CoucheLogiqueException;
  
  public abstract void controleActiviteReduiteMaintienEuropeen(AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement, ArretProduitAvecRaison paramArretProduitAvecRaison, ConstituantsIndemnisation paramConstituantsIndemnisation)
    throws CoucheLogiqueException;
  
  public abstract int initialiserCumulNombreJoursServi(AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract void alimenterGrapheAntecedentCalcul(AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract void miseAJourUtAvecDnjGaec(AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement)
    throws CoucheLogiqueException;
  
  public abstract boolean alimenterLA2K()
    throws CoucheLogiqueException;
  
  public abstract ConstituantsCalculActiviteReduiteSpec miseAJourCumulActivite(UniteTraitement paramUniteTraitement, AttributionSpec paramAttributionSpec, ConstituantsCalculActiviteReduiteSpec paramConstituantsCalculActiviteReduiteSpec, ContexteUT paramContexteUT)
    throws CoucheLogiqueException;
  
  public abstract void postTraitementQualification(UniteTraitement paramUniteTraitement, QualificationPeriodes paramQualificationPeriodes)
    throws CoucheLogiqueException;
  
  public abstract void miseAJourCompteurs(AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement);
  
  public abstract void traitementActiviteReduiteSurPa(PeriodeAnalyseSpec paramPeriodeAnalyseSpec, UniteTraitement paramUniteTraitement, AttributionSpec paramAttributionSpec, MontantBaseSpec paramMontantBaseSpec, BigDecimal paramBigDecimal)
    throws CoucheLogiqueException;
  
  public abstract void mettreAjourDateFinDispositif(AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement, CalendrierExecutionCalculPeriodique paramCalendrierExecutionCalculPeriodique, QualificationPeriodes paramQualificationPeriodes)
    throws CoucheLogiqueException;
  
  public abstract void miseAjourPeriodeAV(ChronologiePeriodes paramChronologiePeriodes, IndividuSpec paramIndividuSpec)
    throws CoucheLogiqueException;
  
  public abstract void traitementPeriodesNonIndemnises(UniteTraitement paramUniteTraitement, QualificationPeriodes paramQualificationPeriodes, QuantiteNonIndemnises paramQuantiteNonIndemnises, ConstituantsIndemnisation paramConstituantsIndemnisation)
    throws CoucheLogiqueException;
  
  public abstract void convertionCachets(ChronologiePeriodes paramChronologiePeriodes);
  
  public abstract Quantite determinerQteContexteFormation(AttributionSpec paramAttributionSpec, Quantite paramQuantite, String paramString, QuantiteDroitSpec paramQuantiteDroitSpec, List<QuantiteDroitSpec> paramList)
    throws CoucheLogiqueException;
  
  public abstract boolean estAspDcSuperieurUnAn(AttributionSpec paramAttributionSpec);
  
  public abstract FiltreTemporel ajouterFiltrePeriodeSurUT();
  
  public abstract void miseAjourCumulAllongementAREF(UniteTraitement paramUniteTraitement, ConstituantsIndemnisation paramConstituantsIndemnisation, AttributionSpec paramAttributionSpec);
  
  public abstract QuantiteDroitSpec determinerDureeProlongationprioritaire(AttributionSpec paramAttributionSpec, List<QuantiteDroitSpec> paramList, Quantite paramQuantite);
  
  public abstract void enrichirPeriodeDisponibilite(AttributionSpec paramAttributionSpec, IndividuSpec paramIndividuSpec)
    throws CoucheLogiqueException;
}

/* Location:
 * Qualified Name:     FacadeCalculProduitPeriodiqueSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */