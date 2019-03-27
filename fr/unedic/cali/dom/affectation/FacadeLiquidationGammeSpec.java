package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.dom.DonneesAuDJIMigration;
import fr.unedic.cali.dom.AttributionAssuranceSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.echange.Decision;
import fr.unedic.cali.occasionnel.outilsfonctionnels.CriteresExecutionPopulation;
import fr.unedic.cali.occasionnel.outilsfonctionnels.CriteresTraitementPopulation;
import fr.unedic.cali.occasionnel.outilsfonctionnels.ResultatTraitementPopulation;
import fr.unedic.cali.outilsfonctionnels.IOutilFonctionnelTraitementsErreurs;
import fr.unedic.cali.parcours.DomLiquidationDemande;
import fr.unedic.cali.parcours.ParcoursCali;
import fr.unedic.cali.parcours.ParcoursLiquidation;
import fr.unedic.cali.parcours.ResultatMigrationCalculProduit;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Parcours;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public abstract interface FacadeLiquidationGammeSpec
{
  public abstract ParcoursLiquidation getParcoursLiquidation(fr.unedic.cali.dom.DemandeSpec paramDemandeSpec);
  
  public abstract DomLiquidationDemande creerDomLiquidationDemande();
  
  public abstract ParcoursCali getParcoursCreationDemande();
  
  public abstract Parcours getParcoursCreationFormulaire();
  
  public abstract void enregistrerBasePivot(fr.unedic.cali.dom.DemandeSpec paramDemandeSpec)
    throws ApplicativeException;
  
  public abstract void enregistrerBasePivotAides(fr.unedic.cali.dom.DemandeSpec paramDemandeSpec)
    throws ApplicativeException;
  
  public abstract void alimenterBaseEchanges(fr.unedic.cali.dom.DemandeSpec paramDemandeSpec, Decision paramDecision)
    throws ApplicativeException;
  
  public abstract Hashtable<String, String> recupererDonneesImposees(fr.unedic.cali.dom.DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract Hashtable<String, String> getElementsDonneesImposeesVides()
    throws CoucheLogiqueException;
  
  public abstract Hashtable<String, String> getElementsConstituantVides()
    throws CoucheLogiqueException;
  
  public abstract Hashtable<String, String> getElementsDecisionVides()
    throws CoucheLogiqueException;
  
  public abstract Hashtable<String, String> recupererElementsDecision(fr.unedic.cali.dom.DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract FormulaireSpec creerFormulaire(fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec paramDemandeSpec);
  
  public abstract void alimenterDomResultatMigrationCalcul(ResultatMigrationCalculProduit paramResultatMigrationCalculProduit, DonneesAuDJIMigration paramDonneesAuDJIMigration);
  
  public abstract void stockerIdDecorSurDemande(fr.unedic.cali.dom.DemandeSpec paramDemandeSpec, String paramString);
  
  public abstract boolean contientAlerteNonBloquanteProvoquantRemiseEnCause(fr.unedic.cali.dom.DemandeSpec paramDemandeSpec);
  
  public abstract boolean estDecisionRenoncement(fr.unedic.cali.dom.DemandeSpec paramDemandeSpec);
  
  public abstract void setTopRenoncementDecision(fr.unedic.cali.dom.DemandeSpec paramDemandeSpec, boolean paramBoolean);
  
  public abstract void verifierPossibiliteAnnulerReexamen(fr.unedic.cali.dom.DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract ArrayList getParametres();
  
  public abstract boolean estReexecutable(CriteresExecutionPopulation paramCriteresExecutionPopulation);
  
  public abstract void controlerInvestigationFrauduleuse(DomLiquidationDemande paramDomLiquidationDemande);
  
  public abstract void recalculerSurAnnulerReexamen(fr.unedic.cali.dom.DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract void mettreEnReexamen(fr.unedic.cali.dom.DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract void initialiserDemandeAssociee(Individu paramIndividu, fr.unedic.cali.dom.DemandeSpec paramDemandeSpec);
  
  public abstract ResultatTraitementPopulation effectuerTraitementOccasionnel(CriteresTraitementPopulation paramCriteresTraitementPopulation)
    throws ApplicativeException;
  
  public abstract Class getClassGestionnaireErreur();
  
  public abstract void traiterMiseEnReexamen(fr.unedic.cali.dom.DemandeSpec paramDemandeSpec, List paramList);
  
  public abstract void controlerPresenceDemandeRevision(fr.unedic.cali.dom.DemandeSpec paramDemandeSpec, AttributionAssuranceSpec paramAttributionAssuranceSpec)
    throws CoucheLogiqueException;
  
  public abstract void controlerPresenceDemandeRevisionPostLiquidation(fr.unedic.cali.dom.DemandeSpec paramDemandeSpec, AttributionAssuranceSpec paramAttributionAssuranceSpec)
    throws CoucheLogiqueException;
  
  public abstract IOutilFonctionnelTraitementsErreurs getOutilFonctionnelTraitementErreurLiquidationAutomatique();
  
  public abstract boolean controlerPrescription(FormulaireSpec paramFormulaireSpec);
  
  public abstract void traitementPostValidation(fr.unedic.cali.dom.DemandeSpec paramDemandeSpec)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     FacadeLiquidationGammeSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */