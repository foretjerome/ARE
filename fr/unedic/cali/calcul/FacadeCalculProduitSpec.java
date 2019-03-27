package fr.unedic.cali.calcul;

import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.EvenementFinQuantiteDroit;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.UniteTraitementForcee;
import fr.unedic.cali.calcul.dom.periode.DsmTravail;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAnalyseSpec;
import fr.unedic.cali.calcul.pbjc.dom.DroitPbjcNcp;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.FormuleMontantSpec;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.cali.dom.QuantiteDroitSpec;
import fr.unedic.cali.dom.QuantiteIndemnisationSpec;
import fr.unedic.cali.parcours.ResultatCalcul;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract interface FacadeCalculProduitSpec
{
  public abstract ConstituantsIndemnisation creationConstituantsIndemnisation(AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract CalendrierExecutionCalculSpec creerCalendrierExecutionCalcul(AttributionSpec paramAttributionSpec);
  
  public abstract UniteTraitementForcee creerUniteTraitementForcee(Damj paramDamj1, Damj paramDamj2);
  
  public abstract EvenementFinQuantiteDroit creerEvenementFinQuantiteDroit(Damj paramDamj, QuantiteDroitSpec paramQuantiteDroitSpec);
  
  public abstract FormuleMontantSpec getFormuleMontant(String paramString);
  
  public abstract MontantBaseSpec calculMontant(FormuleMontantSpec paramFormuleMontantSpec, ConstituantsIndemnisation paramConstituantsIndemnisation, Damj paramDamj)
    throws CoucheLogiqueException;
  
  public abstract ChronologiePeriodes recupererPeriodesProduit(AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract ResultatCalcul postTraitementResultatDetaille(AttributionSpec paramAttributionSpec, CalendrierExecutionCalculSpec paramCalendrierExecutionCalculSpec)
    throws CoucheLogiqueException;
  
  public abstract ResultatCalcul postTraitementResultatDetailleNotification(AttributionSpec paramAttributionSpec, CalendrierExecutionCalculSpec paramCalendrierExecutionCalculSpec)
    throws CoucheLogiqueException;
  
  public abstract ResultatCalcul postTraitementResultatDeterminationEtatDroit(AttributionSpec paramAttributionSpec, CalendrierExecutionCalculSpec paramCalendrierExecutionCalculSpec, Damj paramDamj)
    throws CoucheLogiqueException;
  
  public abstract ResultatCalcul postTraitementResultatMigrationCalcul(AttributionSpec paramAttributionSpec, CalendrierExecutionCalculSpec paramCalendrierExecutionCalculSpec)
    throws CoucheLogiqueException;
  
  public abstract Damj recupererDateFinDroitTheorique(CalendrierExecutionCalculSpec paramCalendrierExecutionCalculSpec, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract boolean estEnActiviteConservee(AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement)
    throws CoucheLogiqueException;
  
  public abstract void controlerPjiAttribution(AttributionSpec paramAttributionSpec, Damj paramDamj)
    throws CoucheLogiqueException;
  
  public abstract boolean neutralisationApplicableRetourUL961();
  
  public abstract Damj getIdeMaintienEuropeenDuDroit(AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract Damj getPjiMaintienEuropeenDuDroit(AttributionSpec paramAttributionSpec);
  
  public abstract Damj getDjiMaintienEuropeenDuDroit(AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract boolean enregistrerEnquetePBJCNCP();
  
  public abstract boolean enregistrerDroitPBJCNCP(AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract boolean enregistrerDispositifPBJCNCP(AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract boolean verifierEligibilitePaiementParAvance(UniteTraitement paramUniteTraitement);
  
  public abstract String recupererRsodPourSuivi(AttributionSpec paramAttributionSpec);
  
  public abstract BigDecimal recupererAnneeAffectation(AttributionSpec paramAttributionSpec);
  
  public abstract Damj recupererPremierJourExecutableNcp(AttributionSpec paramAttributionSpec);
  
  public abstract DsmTravail convertirDsmTravailVersDsmTravailProduit(DsmTravail paramDsmTravail);
  
  public abstract Quantite determinerQuantiteAvantPlafond(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, Unite paramUnite, UniteTraitement paramUniteTraitement)
    throws CoucheLogiqueException;
  
  public abstract void majCumulServiQuantitePlafonne(ConstituantsIndemnisation paramConstituantsIndemnisation, UniteTraitement paramUniteTraitement);
  
  public abstract void calculSommePlafond(Quantite paramQuantite1, Quantite paramQuantite2, UniteTraitement paramUniteTraitement, Damj paramDamj1, Damj paramDamj2, Damj paramDamj3, QuantiteIndemnisationSpec paramQuantiteIndemnisationSpec, PeriodeAnalyseSpec paramPeriodeAnalyseSpec, FacadeCalculProduitPeriodiqueSpec paramFacadeCalculProduitPeriodiqueSpec, MontantBaseSpec paramMontantBaseSpec)
    throws CoucheLogiqueException;
  
  public abstract boolean verifierApplicationForcageSurUT(UniteTraitement paramUniteTraitement, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract boolean verifierTraitementPasss(AttributionSpec paramAttributionSpec);
  
  public abstract void alimenterDonneesSpectacle(AttributionSpec paramAttributionSpec, CalendrierExecutionCalculSpec paramCalendrierExecutionCalculSpec, DroitPbjcNcp paramDroitPbjcNcp);
  
  public abstract void annulerReliquatPlafoneeSpecSuiteARCE(AttributionSpec paramAttributionSpec);
}

/* Location:
 * Qualified Name:     FacadeCalculProduitSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */