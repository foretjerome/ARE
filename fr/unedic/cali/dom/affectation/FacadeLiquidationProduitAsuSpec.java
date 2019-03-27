package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.ConstituantsCalculActiviteReduiteSpec;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DomSimulationAffiliation;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.DureeIndemnisationAbstraite;
import fr.unedic.cali.dom.ElementBaseIndemnisationSpec;
import fr.unedic.cali.dom.FormuleMontantSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.JustificationAppelGaecReduit;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.cali.dom.SalaireJournalierSpec;
import fr.unedic.cali.dom.conteneurs.DonneesEntreesRecuperationMontant;
import fr.unedic.cali.dom.conteneurs.spec.DonneesEntreeDeterminationSjrSpec;
import fr.unedic.cali.dom.conteneurs.spec.DonneesResultatDeterminationSjrSpec;
import fr.unedic.cali.dom.spec.CalculAppartenanceSpec;
import fr.unedic.cali.dom.spec.ComportementAffiliationSpec;
import fr.unedic.cali.dom.spec.ConstructionPRASpec;
import fr.unedic.cali.dom.spec.ConventionGestionSpec;
import fr.unedic.cali.dom.spec.ParametresAffiliationSpec;
import fr.unedic.cali.fabriques.FabriqueOutilFonctionnelSpec;
import fr.unedic.cali.occasionnel.outilsfonctionnels.CriteresTraitementPopulation;
import fr.unedic.cali.occasionnel.outilsfonctionnels.ResultatTraitementPopulation;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.cali.parcours.ResultatExecutionCalculSpec;
import fr.unedic.cali.util.TableQuantites;
import fr.unedic.util.Convertisseur;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public abstract interface FacadeLiquidationProduitAsuSpec
  extends FacadeLiquidationProduitSpec, ProduitAvecEpuisementSpec
{
  public abstract void initialiserDossierExamen(DossierAffectationSpec paramDossierAffectationSpec);
  
  public abstract DelaiRechercheProduitSpec obtenirDelaiRechercheProduit(DossierAffectationSpec paramDossierAffectationSpec, DureeCalendaire paramDureeCalendaire)
    throws CoucheLogiqueException;
  
  public abstract ValidationProduitSpec obtenirValidationProduit(ActiviteSalarie paramActiviteSalarie, IndividuSpec paramIndividuSpec, DemandeSpec paramDemandeSpec, boolean paramBoolean)
    throws ApplicativeException;
  
  public abstract MontantBaseSpec recupererMontant(DonneesEntreesRecuperationMontant paramDonneesEntreesRecuperationMontant)
    throws ApplicativeException;
  
  public abstract boolean estFiliereCourte(AttributionSpec paramAttributionSpec);
  
  public abstract BigDecimal getSJR(AttributionSpec paramAttributionSpec);
  
  public abstract boolean estCompetenceAdministrativeRac(AttributionSpec paramAttributionSpec);
  
  public abstract Damj getDateFaitGenerateur(AttributionSpec paramAttributionSpec);
  
  public abstract boolean determinerRepriseInvalide(DemandeSpec paramDemandeSpec);
  
  public abstract Object creerObjectifExamen(int paramInt, List<ContexteDemandeSpec> paramList);
  
  public abstract Resultat traiterReliquat(ResultatExecutionCalculSpec paramResultatExecutionCalculSpec, Damj paramDamj)
    throws ApplicativeException;
  
  public abstract void determinerOrdreObjectifs(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract void verifierValiditeObjectif(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionRechercheEmploi(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionFaitGenerateur(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionAge(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionQuantiteAffiliation(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionChomageInvolontaire(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionMontant(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionCumulActiviteConservee(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionChomageTotal(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionCumulPrestationFamiliale(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionCSRAccordCP(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionCSRDateAttributionPendantSuspension(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionBeneficeAutreProduit(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerReglementApplicable(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerSalaireJournalierDeReference(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerSalaireJournalierConserve(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerQuantiteAffiliation(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerCoefficientTempsPartiel(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerCaractereSaisonnier(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerCoefficientSaisonnier(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerDureesReglementaires(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerDelaisReports(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerMontantsBruts(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerMontantsEffectifs(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerDateAttribution(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerProduitResultant(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerPointDeDepart(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerDureeEffective(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerCapitalAvecDureeEffective(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerCapitalDroitCourant(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerNbHeuresTravaillees(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerDateLimiteIndemnisation(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract void miseAJourDossierExamen(DossierExamenSpec paramDossierExamenSpec, AttributionSpec paramAttributionSpec);
  
  public abstract void determinerCompetencesDroitResultant(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract void determinerCompetencesDroitCourant(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract void sauvegardeElementsJustificatifs(DossierExamenSpec paramDossierExamenSpec)
    throws CoucheLogiqueException;
  
  public abstract Periode determinerPraLaPlusLongue(DemandeSpec paramDemandeSpec, ActiviteSalarie paramActiviteSalarie)
    throws CoucheLogiqueException;
  
  public abstract void postTraiterPourJustificationAffiliation(DemandeSpec paramDemandeSpec);
  
  public abstract boolean verifierCapasPreliminaires(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat detecterContributionParticuliere(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionAgePourMaintien(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Damj getDateObtentionAgePourMaintien(DemandeSpec paramDemandeSpec);
  
  public abstract Damj getDateObtentionDesTrimestres(DemandeSpec paramDemandeSpec);
  
  public abstract Damj getDateObtentionIndemnisation(DemandeSpec paramDemandeSpec)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionNombreTrimestresPourMaintien(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionActivitePourMaintien(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionAppartenancePourMaintien(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionDureeIndemnisationPourMaintien(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionDecisionCPPourMaintien(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract FormuleMontantSpec getFormuleMontant(String paramString);
  
  public abstract Quantite determinerReliquatHorsMaintien(AttributionSpec paramAttributionSpec, Damj paramDamj)
    throws ApplicativeException;
  
  public abstract Quantite determinerReliquatAvecMaintien(AttributionSpec paramAttributionSpec, Damj paramDamj)
    throws ApplicativeException;
  
  public abstract Damj getDateRuptureContratTravail(AttributionSpec paramAttributionSpec);
  
  public abstract boolean estRejetChomageVolontaire(DecisionSpec paramDecisionSpec);
  
  public abstract Quantite getDureeAServirEffective(AttributionSpec paramAttributionSpec);
  
  public abstract Resultat verifierCondition28JoursSuspension(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Quantite getDureeInitiale(AttributionSpec paramAttributionSpec);
  
  public abstract boolean estEntameDiffereStandard(DemandeSpec paramDemandeSpec)
    throws ApplicativeException;
  
  public abstract void installerCompetenceConventionGestion(AttributionSpec paramAttributionSpec);
  
  public abstract void recalculerSurAnnulerReexamen(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract ObjetMetierSpec recupererSJRPourDelaisReport(DemandeSpec paramDemandeSpec);
  
  public abstract ConstructionPRASpec getOutilConstructionPRA();
  
  public abstract DureeIndemnisationAbstraite creerDureeCalcul(AttributionSpec paramAttributionSpec);
  
  public abstract DureeIndemnisationAbstraite creerDureeCalculTranche(Quantite paramQuantite);
  
  public abstract Resultat executerSimulationAffiliation(DomSimulationAffiliation paramDomSimulationAffiliation)
    throws ApplicativeException;
  
  public abstract void positionnerQuantiteAssimilationMaximum(Periode paramPeriode, TableQuantites paramTableQuantites);
  
  public abstract int getDureeMinimumPourImputationFormation();
  
  public abstract void recalculerActivitesConserveesPourDemandeMigree(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract BigDecimal plafonnerDiviseurPrc(BigDecimal paramBigDecimal);
  
  public abstract int getNombreJoursIndemnisationNecessairesMaintien();
  
  public abstract boolean estCompetenceFinanciereSecteurPublic(AttributionSpec paramAttributionSpec);
  
  public abstract MontantBaseSpec obtenirMontantDroitPrecedentSecteurPublicProduitResultant(DemandeSpec paramDemandeSpec, DossierExamenSpec paramDossierExamenSpec, IndividuSpec paramIndividuSpec)
    throws CoucheLogiqueException;
  
  public abstract SalaireJournalierSpec revaloriserSalaireJournalier(ElementBaseIndemnisationSpec paramElementBaseIndemnisationSpec, Damj paramDamj);
  
  public abstract Resultat verifierConditionAnciennete(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionDureeNonNulle(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract boolean estCapitalPrecedentRetenu(AttributionSpec paramAttributionSpec);
  
  public abstract Resultat constituerRevisionAutomatique(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerNouvelleRevisionAutomatique(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Reglement recupererReglementApplicable(AttributionSpec paramAttributionSpec);
  
  public abstract boolean estPresenceDiffere(AttributionSpec paramAttributionSpec);
  
  public abstract SalaireJournalierSpec getSalaireJournalier(AttributionSpec paramAttributionSpec, Damj paramDamj);
  
  public abstract SalaireJournalierSpec getSalaireConserve(AttributionSpec paramAttributionSpec, Damj paramDamj);
  
  public abstract SalaireJournalierSpec getSJC(AttributionSpec paramAttributionSpec);
  
  public abstract Chronologie getListeActivitesConserveesAttributionAreLiee(AttributionSpec paramAttributionSpec);
  
  public abstract int getCodeEmploiA2b(DemandeSpec paramDemandeSpec);
  
  public abstract int getCodeEmploiA2b(DonneesEntreeDeterminationSjrSpec paramDonneesEntreeDeterminationSjrSpec);
  
  public abstract Damj getDateFaitGenerateurAttributionMaitre(AttributionSpec paramAttributionSpec);
  
  public abstract JustificationAppelGaecReduit getDateDebutFenetrageAppelGaec(DemandeSpec paramDemandeSpec);
  
  public abstract Damj getDateFinDelaiDecheance(AttributionSpec paramAttributionSpec, DemandeSpec paramDemandeSpec);
  
  public abstract boolean determinePriseEnCompteObjectifReprise(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract void traitementPeriodesDecalantes(AttributionSpec paramAttributionSpec, ChronologiePeriodes paramChronologiePeriodes, ConstituantsCalculActiviteReduiteSpec paramConstituantsCalculActiviteReduiteSpec, UniteTraitement paramUniteTraitement)
    throws CoucheLogiqueException;
  
  public abstract void traitementPeriodesGelantes(AttributionSpec paramAttributionSpec, ChronologiePeriodes paramChronologiePeriodes, ConstituantsCalculActiviteReduiteSpec paramConstituantsCalculActiviteReduiteSpec, UniteTraitement paramUniteTraitement)
    throws CoucheLogiqueException;
  
  public abstract Resultat liquiderDemandeAssociee(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract void alimenterDonneesComplementairesDossierExamen(DossierExamenSpec paramDossierExamenSpec);
  
  public abstract Resultat creerGrapheDemandeAntecedent(Contexte paramContexte)
    throws CoucheLogiqueException;
  
  public abstract BigDecimal determinerDureeMaximumPourProduit();
  
  public abstract ResultatTraitementPopulation effectuerTraitementOccasionnel(CriteresTraitementPopulation paramCriteresTraitementPopulation)
    throws ApplicativeException;
  
  public abstract void verifierPropositionAttribution(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract SalaireJournalierSpec revaloriserSalaireJournalierReference(BigDecimal paramBigDecimal, Damj paramDamj1, Damj paramDamj2, String paramString)
    throws CoucheLogiqueException;
  
  public abstract FabriqueOutilFonctionnelSpec determinerFabriqueOutilFonctionnelDeterminationSjr(Damj paramDamj)
    throws CoucheLogiqueException;
  
  public abstract DonneesResultatDeterminationSjrSpec determinerSjrip(DonneesEntreeDeterminationSjrSpec paramDonneesEntreeDeterminationSjrSpec)
    throws CoucheLogiqueException;
  
  public abstract boolean estUnProduitGerantA9();
  
  public abstract boolean estUnProduitLevantAlerteA8A10();
  
  public abstract void verifierPropositionRejet(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract ConventionGestionSpec getConventionGestion(AttributionSpec paramAttributionSpec);
  
  public abstract Convertisseur determinerConvertisseurUniteAffiliation();
  
  public abstract Collection determinerListePlafonnementAffiliation(AttributionSpec paramAttributionSpec)
    throws ApplicativeException;
  
  public abstract boolean isPlafonnementAffiliationActif();
  
  public abstract ElementBaseIndemnisationSpec recupererElementBaseIndemnisationPourReadmissionAvecMontantRetenuPrecedent(int paramInt1, int paramInt2, DemandeSpec paramDemandeSpec, AttributionSpec paramAttributionSpec);
  
  public abstract ProduitAsuSpec getProduitMontantRetenu(AttributionSpec paramAttributionSpec);
  
  public abstract String getSituationParticuliere(AttributionSpec paramAttributionSpec);
  
  public abstract Resultat verifierConditionValiditeReliquat(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract String determinerCodeSousProduitPourSigma(DecisionSpec paramDecisionSpec);
  
  public abstract CalculAppartenanceSpec getOutilCalculAppartenance(DemandeSpec paramDemandeSpec, boolean paramBoolean);
  
  public abstract void initialiserComportementCalculAffiliation(ComportementAffiliationSpec paramComportementAffiliationSpec, ParametresAffiliationSpec paramParametresAffiliationSpec);
  
  public abstract String determinerSituationParticuliere(AttributionSpec paramAttributionSpec);
  
  public abstract boolean estProduitGerantPensionInvalidite(DemandeSpec paramDemandeSpec);
  
  public abstract Collection determinerPensionInvaliditeDroitCourant(AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract Collection determinerPensionInvaliditeDroitResultant(AttributionSpec paramAttributionSpec);
  
  public abstract boolean estProduitGerantIccpEnContexteRepriseSimplifiee();
  
  public abstract Damj determinerDateExclueAuPlusTardDebutActiviteConservee(ActiviteSalarie paramActiviteSalarie, Damj paramDamj)
    throws CoucheLogiqueException;
  
  public abstract Quantite getDureeAServirTheorique(AttributionSpec paramAttributionSpec);
  
  public abstract Resultat constituerTranchesExecutables(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract BigDecimal recupererCoefficientSaisonnierMontantRetenu(AttributionSpec paramAttributionSpec);
  
  public abstract BigDecimal recupererCoeficientTempsPartielMontantRetenu(AttributionSpec paramAttributionSpec);
  
  public abstract boolean estTrancheActivee(DemandeSpec paramDemandeSpec);
  
  public abstract boolean effectuerTraitementSpecifiqueAssistanceMaternellePourAffiliation();
  
  public abstract StrategieSpec retournerStrategieAvantDeterminationChomageInvolontaire();
  
  public abstract boolean estForcerTempsPleinPourPeriodeA8A10(Damj paramDamj);
  
  public abstract CalendrierExecutionCalculSpec creerCalendrierCalcul();
  
  public abstract UniteTraitement creerUT(Periode paramPeriode, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
}

/* Location:
 * Qualified Name:     FacadeLiquidationProduitAsuSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */