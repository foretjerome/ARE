package fr.unedic.cali.avant;

import fr.unedic.cali.calcul.dom.ArretProduitAvecRaison;
import fr.unedic.cali.calcul.dom.CalendrierExecutionAvant;
import fr.unedic.cali.calcul.dom.DureeConsommableAvant;
import fr.unedic.cali.calcul.dom.EvenementFinQuantiteDroit;
import fr.unedic.cali.calcul.dom.QualificationPeriodes;
import fr.unedic.cali.calcul.dom.UniteTraitementAvant;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAnalyseSpec;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodesPriseEnCompte;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.QuantiteDroitSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.parcours.ResultatAvant;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;

public abstract interface FacadeAvantProduitSpec
{
  public abstract ResultatAvant executerAvant(AttributionSpec paramAttributionSpec, boolean paramBoolean1, Damj paramDamj, boolean paramBoolean2)
    throws CoucheLogiqueException;
  
  public abstract ResultatAvant executerAvant(IndividuSpec paramIndividuSpec, Damj paramDamj, ProduitSpec paramProduitSpec, Collection paramCollection1, Collection paramCollection2)
    throws CoucheLogiqueException;
  
  public abstract ResultatAvant postTraitementResultatDeterminationEtatAvant(AttributionSpec paramAttributionSpec);
  
  public abstract void traitementPeriodesAlertantes(AttributionSpec paramAttributionSpec, ObjetChronoPeriode paramObjetChronoPeriode, PeriodeAnalyseSpec paramPeriodeAnalyseSpec, ArretProduitAvecRaison paramArretProduitAvecRaison)
    throws CoucheLogiqueException;
  
  public abstract Collection<?> recupererCarrence(AttributionSpec paramAttributionSpec);
  
  public abstract Damj rechercherPremierJourAvant(AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract ChronologiePeriodes recupererPeriodeGAEC(IndividuSpec paramIndividuSpec, AttributionSpec paramAttributionSpec, Damj paramDamj1, Damj paramDamj2)
    throws CoucheLogiqueException;
  
  public abstract ArrayList mettreAJourCarrenceSurRevisionHorsPec(Collection paramCollection, Damj paramDamj);
  
  public abstract QualificationPeriodes qualificationPeriodesPourAvant(ChronologiePeriodes paramChronologiePeriodes, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract void mettreAJourCarencesSurResultatAvant(CalendrierExecutionAvant paramCalendrierExecutionAvant, AttributionSpec paramAttributionSpec, Collection paramCollection);
  
  public abstract Damj determinerPJIPoursuite(AttributionSpec paramAttributionSpec);
  
  public abstract int executerUtAvant(AttributionSpec paramAttributionSpec, CalendrierExecutionAvant paramCalendrierExecutionAvant, Periode paramPeriode, ChronologiePeriodes paramChronologiePeriodes)
    throws CoucheLogiqueException;
  
  public abstract boolean estUnContexteDeChomageEnCoursDeSuspensionAvecRupture(AttributionSpec paramAttributionSpec, Damj paramDamj);
  
  public abstract boolean estUnContexteDeChomageEnCoursDeSuspension(AttributionSpec paramAttributionSpec);
  
  public abstract ResultatAvant construireResultatAvantPourChomageSansRupture(AttributionSpec paramAttributionSpec, Collection paramCollection);
  
  public abstract boolean estUnProduitGerantLaRefonte();
  
  public abstract boolean doitExecuterAvant(AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract Damj mettreAjourPjiSurPecESSI(AttributionSpec paramAttributionSpec, Damj paramDamj1, Damj paramDamj2);
  
  public abstract void convertionCachets(ChronologiePeriodes paramChronologiePeriodes);
  
  public abstract Damj determinerDateDepartAttribution(AttributionSpec paramAttributionSpec);
  
  public abstract ChronologiePeriodes traitementPeriodesSegmentantes(Periode paramPeriode, UniteTraitementAvant paramUniteTraitementAvant, ChronologiePeriodes paramChronologiePeriodes)
    throws CoucheLogiqueException;
  
  public abstract void creerDureeIndemnisation(AttributionSpec paramAttributionSpec, CalendrierExecutionAvant paramCalendrierExecutionAvant, UniteTraitementAvant paramUniteTraitementAvant);
  
  public abstract ArretProduitAvecRaison traitementPeriodesInterruptivesDefinitives(PeriodesPriseEnCompte paramPeriodesPriseEnCompte, UniteTraitementAvant paramUniteTraitementAvant, AttributionSpec paramAttributionSpec, CalendrierExecutionAvant paramCalendrierExecutionAvant)
    throws CoucheLogiqueException;
  
  public abstract boolean traitementPeriodesSuspensivesPourDebutConsommationDelaiAttente(PeriodeAnalyseSpec paramPeriodeAnalyseSpec, QualificationPeriodes paramQualificationPeriodes, Damj paramDamj)
    throws CoucheLogiqueException;
  
  public abstract Quantite simulerImputationEtImputerLaQuantite(Quantite paramQuantite, DureeConsommableAvant paramDureeConsommableAvant, UniteTraitementAvant paramUniteTraitementAvant, Damj paramDamj)
    throws CoucheLogiqueException;
  
  public abstract void simulerImputationEtImputerLaQuantiteEtTerminerProduit(Quantite paramQuantite, PeriodeAnalyseSpec paramPeriodeAnalyseSpec, DureeConsommableAvant paramDureeConsommableAvant, UniteTraitementAvant paramUniteTraitementAvant, Damj paramDamj1, ArretProduitAvecRaison paramArretProduitAvecRaison, Damj paramDamj2)
    throws CoucheLogiqueException;
  
  public abstract boolean estUnCarenceGereeParLeProduit(DureeConsommableAvant paramDureeConsommableAvant);
  
  public abstract boolean estCarenceTerminantProduit(DureeConsommableAvant paramDureeConsommableAvant);
  
  public abstract Quantite traitementActiviteReduiteSurUt(UniteTraitementAvant paramUniteTraitementAvant, ChronologiePeriodes paramChronologiePeriodes, Damj paramDamj, AttributionSpec paramAttributionSpec, QualificationPeriodes paramQualificationPeriodes, DureeConsommableAvant paramDureeConsommableAvant)
    throws CoucheLogiqueException;
  
  public abstract boolean estUneCarenceSeConsommantApresDateAttribution(DureeConsommableAvant paramDureeConsommableAvant);
  
  public abstract boolean estUneCarenceSuspendueParSuspensif(DureeConsommableAvant paramDureeConsommableAvant);
  
  public abstract boolean doitTraiterLAR();
  
  public abstract EvenementFinQuantiteDroit creerEvtFinQteDroit(Damj paramDamj, QuantiteDroitSpec paramQuantiteDroitSpec);
  
  public abstract void postTraitementQualification(UniteTraitementAvant paramUniteTraitementAvant, QualificationPeriodes paramQualificationPeriodes)
    throws CoucheLogiqueException;
  
  public abstract FiltreTemporel ajouterFiltrePeriodeSurUT();
}

/* Location:
 * Qualified Name:     FacadeAvantProduitSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */