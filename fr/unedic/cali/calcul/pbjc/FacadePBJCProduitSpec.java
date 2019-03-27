package fr.unedic.cali.calcul.pbjc;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnCharge;
import fr.unedic.cali.calcul.dom.ConstituantsCalculActiviteReduiteSpec;
import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.Somme;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import java.util.Collection;

public abstract interface FacadePBJCProduitSpec
{
  public abstract boolean controlerExecutionPBJCs(AttributionSpec paramAttributionSpec);
  
  public abstract void positionnerPBJCASupprimer(PbjcNcp paramPbjcNcp, ObjetChronoPeriode paramObjetChronoPeriode);
  
  public abstract ChronologiePeriodes creerChronologiePBJCsAvant(AttributionSpec paramAttributionSpec, Damj paramDamj1, Damj paramDamj2, String paramString)
    throws ApplicativeException;
  
  public abstract void ajouterGroupeMontantProduit(PbjcNcp paramPbjcNcp, AttributionSpec paramAttributionSpec, Somme paramSomme, UniteTraitement paramUniteTraitement)
    throws CoucheLogiqueException;
  
  public abstract void positionnerMontantSalaireRevalorisePlafonne(PbjcNcp paramPbjcNcp, AttributionSpec paramAttributionSpec, ConstituantsIndemnisation paramConstituantsIndemnisation, MontantBaseSpec paramMontantBaseSpec)
    throws CoucheLogiqueException;
  
  public abstract void positionnerMontantSjc(PbjcNcp paramPbjcNcp, AttributionSpec paramAttributionSpec, ConstituantsIndemnisation paramConstituantsIndemnisation)
    throws CoucheLogiqueException;
  
  public abstract void positionnerCoefficientTempsPartiel(PbjcNcp paramPbjcNcp, UniteTraitement paramUniteTraitement, AttributionSpec paramAttributionSpec);
  
  public abstract String retournerReglementApplicable(AttributionSpec paramAttributionSpec);
  
  public abstract void positionnerCategorieAttribution(PbjcNcp paramPbjcNcp, AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement);
  
  public abstract void positionnerJustificationOuverturePJI(PbjcNcp paramPbjcNcp, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract void positionnerJustificationFermetureDJI(PbjcNcp paramPbjcNcp, AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement);
  
  public abstract void positionnerComplementJustification(PbjcNcp paramPbjcNcp, UniteTraitement paramUniteTraitement, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract void positionnerInformationDecisionSanction(PbjcNcp paramPbjcNcp, UniteTraitement paramUniteTraitement);
  
  public abstract void positionnerInformationDecisionSanction(PbjcNcp paramPbjcNcp, ObjetChronoPeriode paramObjetChronoPeriode);
  
  public abstract void positionnerNombreMoisEnPaiementProvisoire(PbjcNcp paramPbjcNcp, UniteTraitement paramUniteTraitement);
  
  public abstract int retournerMaxDureeReglementaireCourante(AttributionSpec paramAttributionSpec);
  
  public abstract int retournerReliquatDureeReglementaireCourante(UniteTraitement paramUniteTraitement);
  
  public abstract void positionnerRangProlongation(PbjcNcp paramPbjcNcp, UniteTraitement paramUniteTraitement, AttributionSpec paramAttributionSpec);
  
  public abstract int retournerReferenceBaseCalcul(AttributionSpec paramAttributionSpec);
  
  public abstract void positionnerDonneesAvantageVieillesse(PbjcNcp paramPbjcNcp, UniteTraitement paramUniteTraitement, AttributionSpec paramAttributionSpec);
  
  public abstract int retournerReliquatDureeMax(UniteTraitement paramUniteTraitement, ChronologiePeriodes paramChronologiePeriodes, AttributionSpec paramAttributionSpec);
  
  public abstract void positionnerRessources(PbjcNcp paramPbjcNcp, AttributionSpec paramAttributionSpec);
  
  public abstract void positionnerActiviteReduite(PbjcNcp paramPbjcNcp, ConstituantsCalculActiviteReduiteSpec paramConstituantsCalculActiviteReduiteSpec);
  
  public abstract Quantite retournerQuantiteIndemnisationInitialeDroit(AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement);
  
  public abstract void positionnerPriseEnChargeAER(PbjcNcp paramPbjcNcp, Collection paramCollection);
  
  public abstract void positionnerPriseEnChargeAER(PbjcNcp paramPbjcNcp, UniteTraitement paramUniteTraitement);
  
  public abstract void traiterPBJCsAPosteriori(ChronologiePeriodes paramChronologiePeriodes, AttributionSpec paramAttributionSpec, Chronologie paramChronologie)
    throws CoucheLogiqueException;
  
  public abstract void positionnerReferencesOuvertureDroit(PbjcNcp paramPbjcNcp, AttributionSpec paramAttributionSpec);
  
  public abstract void positionnerEtatsReglementaireEtAdministratif(PbjcNcp paramPbjcNcp);
  
  public abstract void positionnerIndicateurInterruptionIndemnisationParPensionInvalidite(PbjcNcp paramPbjcNcp)
    throws CoucheLogiqueException;
  
  public abstract ChronologiePeriodes supprimerPBJCsANePasPrendreEnCompte(ChronologiePeriodes paramChronologiePeriodes);
  
  public abstract void traiterBlocageActuPourLAvant(PbjcNcp paramPbjcNcp, Damj paramDamj, String paramString);
  
  public abstract boolean retournerTopPlafonnementDureeDroitParDate();
  
  public abstract boolean creerPBJCsurUT(AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement);
  
  public abstract void qualifierPbjcSuspensive(PbjcNcp paramPbjcNcp, ObjetChronoPeriode paramObjetChronoPeriode);
  
  public abstract Collection getEvtsChangementParametre(Damj paramDamj1, Damj paramDamj2, AttributionSpec paramAttributionSpec);
  
  public abstract void miseAJourNombreJoursImputes(UniteTraitement paramUniteTraitement, PbjcNcp paramPbjcNcp);
  
  public abstract boolean retournerTopPeriodeRessourcesSuperieuresPlafond(Somme paramSomme);
  
  public abstract void positionnerSituationParticuliere(PbjcNcp paramPbjcNcp, AttributionSpec paramAttributionSpec, UniteTraitement paramUniteTraitement);
  
  public abstract ChronologiePeriodes traitementPeriodesSuspensives(ChronologiePeriodes paramChronologiePeriodes, UniteTraitement paramUniteTraitement);
  
  public abstract void positionnerInfoConventionGestion(PbjcNcp paramPbjcNcp, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract void mapperPecSurPbjc(PbjcNcp paramPbjcNcp, ObjetChronoPeriodePriseEnCharge paramObjetChronoPeriodePriseEnCharge);
  
  public abstract boolean creerPBJCsurSomme(AttributionSpec paramAttributionSpec, Somme paramSomme);
  
  public abstract void positionnerInformationSuspension(PbjcNcp paramPbjcNcp, UniteTraitement paramUniteTraitement);
}

/* Location:
 * Qualified Name:     FacadePBJCProduitSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */