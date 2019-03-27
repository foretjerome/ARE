package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.ConstituantsCalculActiviteReduiteSpec;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
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

public abstract class ProduitAsuAbstrait
  extends ProduitAbstrait
  implements ProduitAsuSpec
{
  private static final long serialVersionUID = 1L;
  
  protected ProduitAsuAbstrait()
  {
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_CALCULE", this));
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_SANCTION_CALCULE", this));
    ajouterElementForcable(ElementForcable.getInstance("STATUT_UT_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("NEUTRALISE_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("TYPE_NEUTRALISATION_FORCE", this));
  }
  
  private ProduitAsuDelegueSpec getProduitAsuDelegue()
  {
    return (ProduitAsuDelegueSpec)getProduitDelegue();
  }
  
  public Resultat verifierConditionAnciennete(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionAnciennete(contexte);
  }
  
  public Resultat constituerDateLimiteIndemnisation(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerDateLimiteIndemnisation(contexte);
  }
  
  public void initialiserDossierExamen(DossierAffectationSpec dossierAffecte)
  {
    if (getProduitAsuDelegue() != null) {
      getProduitAsuDelegue().initialiserDossierExamen(dossierAffecte);
    }
  }
  
  public DelaiRechercheProduitSpec obtenirDelaiRechercheProduit(DossierAffectationSpec dossierAffectation, DureeCalendaire delaiAllongement)
    throws CoucheLogiqueException
  {
    if (getProduitDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().obtenirDelaiRechercheProduit(dossierAffectation, delaiAllongement);
  }
  
  public ValidationProduitSpec obtenirValidationProduit(ActiviteSalarie activiteSalarie, IndividuSpec individu, DemandeSpec demande, boolean avecPeriodeNonAttestee)
    throws ApplicativeException
  {
    if (getProduitDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().obtenirValidationProduit(activiteSalarie, individu, demande, avecPeriodeNonAttestee);
  }
  
  public Resultat constituerCaractereSaisonnier(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerCaractereSaisonnier(contexte);
  }
  
  public Resultat constituerCoefficientSaisonnier(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerCoefficientSaisonnier(contexte);
  }
  
  public Resultat constituerCoefficientTempsPartiel(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerCoefficientTempsPartiel(contexte);
  }
  
  public Resultat constituerDelaisReports(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerDelaisReports(contexte);
  }
  
  public Resultat constituerDureesReglementaires(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerDureesReglementaires(contexte);
  }
  
  public Resultat constituerMontantsBruts(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerMontantsBruts(contexte);
  }
  
  public Resultat constituerQuantiteAffiliation(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerQuantiteAffiliation(contexte);
  }
  
  public Resultat constituerReglementApplicable(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerReglementApplicable(contexte);
  }
  
  public Resultat constituerSalaireJournalierConserve(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerSalaireJournalierConserve(contexte);
  }
  
  public Resultat constituerSalaireJournalierDeReference(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerSalaireJournalierDeReference(contexte);
  }
  
  public Resultat constituerNbHeuresTravaillees(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerNbHeuresTravaillees(contexte);
  }
  
  public Object creerObjectifExamen(int sousType, List<ContexteDemandeSpec> contexteDemande)
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().creerObjectifExamen(sousType, contexteDemande);
  }
  
  public Resultat traiterReliquat(ResultatExecutionCalculSpec resultatExecutionCalcul, Damj dateEtude)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().traiterReliquat(resultatExecutionCalcul, dateEtude);
  }
  
  public Resultat verifierConditionAge(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionAge(contexte);
  }
  
  public Resultat verifierConditionBeneficeAutreProduit(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionBeneficeAutreProduit(contexte);
  }
  
  public Resultat verifierConditionChomageInvolontaire(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionChomageInvolontaire(contexte);
  }
  
  public Resultat verifierConditionCSRAccordCP(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionCSRAccordCP(contexte);
  }
  
  public Resultat verifierConditionCSRDateAttributionPendantSuspension(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionCSRDateAttributionPendantSuspension(contexte);
  }
  
  public Resultat verifierConditionChomageTotal(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionChomageTotal(contexte);
  }
  
  public Resultat verifierConditionCumulActiviteConservee(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionCumulActiviteConservee(contexte);
  }
  
  public Resultat verifierConditionFaitGenerateur(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionFaitGenerateur(contexte);
  }
  
  public Resultat verifierConditionMontant(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionMontant(contexte);
  }
  
  public Resultat verifierConditionQuantiteAffiliation(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionQuantiteAffiliation(contexte);
  }
  
  public Resultat verifierConditionDureeNonNulle(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionDureeNonNulle(contexte);
  }
  
  public Resultat verifierConditionRechercheEmploi(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionRechercheEmploi(contexte);
  }
  
  public Resultat verifierConditionCumulPrestationFamiliale(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionCumulPrestationFamiliale(contexte);
  }
  
  public void miseAJourDossierExamen(DossierExamenSpec dossier, AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() != null) {
      getProduitAsuDelegue().miseAJourDossierExamen(dossier, attribution);
    }
  }
  
  public Resultat constituerDateAttribution(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerDateAttribution(contexte);
  }
  
  public Resultat constituerProduitResultant(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerProduitResultant(contexte);
  }
  
  public Resultat constituerPointDeDepart(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerPointDeDepart(contexte);
  }
  
  public Resultat constituerDureeEffective(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerDureeEffective(contexte);
  }
  
  public Resultat constituerCapitalAvecDureeEffective(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerCapitalAvecDureeEffective(contexte);
  }
  
  public Damj recupererDJIParEpuisement(DemandeSpec demande, AttributionSpec attribution, boolean verifierEpuisementHPec)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().recupererDJIParEpuisement(demande, attribution, verifierEpuisementHPec);
  }
  
  public boolean estFiliereCourte(AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() == null) {
      return false;
    }
    return getProduitAsuDelegue().estFiliereCourte(attribution);
  }
  
  public boolean estCompetenceAdministrativeRac(AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() == null) {
      return false;
    }
    return getProduitAsuDelegue().estCompetenceAdministrativeRac(attribution);
  }
  
  public Damj getDateFaitGenerateur(AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().getDateFaitGenerateur(attribution);
  }
  
  public Resultat detecterContributionParticuliere(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().detecterContributionParticuliere(contexte);
  }
  
  public void determinerOrdreObjectifs(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() != null) {
      getProduitAsuDelegue().determinerOrdreObjectifs(contexte);
    }
  }
  
  public void verifierValiditeObjectif(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() != null) {
      getProduitAsuDelegue().verifierValiditeObjectif(contexte);
    }
  }
  
  public void determinerCompetencesDroitCourant(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() != null) {
      getProduitAsuDelegue().determinerCompetencesDroitCourant(contexte);
    }
  }
  
  public void determinerCompetencesDroitResultant(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() != null) {
      getProduitAsuDelegue().determinerCompetencesDroitResultant(contexte);
    }
  }
  
  public void sauvegardeElementsJustificatifs(DossierExamenSpec decision)
    throws CoucheLogiqueException
  {
    if (getProduitAsuDelegue() != null) {
      getProduitAsuDelegue().sauvegardeElementsJustificatifs(decision);
    }
  }
  
  public Periode determinerPraLaPlusLongue(DemandeSpec demandeCourante, ActiviteSalarie periodeFctCourante)
    throws CoucheLogiqueException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().determinerPraLaPlusLongue(demandeCourante, periodeFctCourante);
  }
  
  public void postTraiterPourJustificationAffiliation(DemandeSpec demande)
  {
    if (getProduitAsuDelegue() != null) {
      getProduitAsuDelegue().postTraiterPourJustificationAffiliation(demande);
    }
  }
  
  public boolean verifierCapasPreliminaires(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().verifierCapasPreliminaires(contexte);
    }
    return true;
  }
  
  public Resultat verifierConditionAgePourMaintien(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionAgePourMaintien(contexte);
  }
  
  public Resultat verifierConditionNombreTrimestresPourMaintien(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionNombreTrimestresPourMaintien(contexte);
  }
  
  public Resultat verifierConditionActivitePourMaintien(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionActivitePourMaintien(contexte);
  }
  
  public Resultat verifierConditionAppartenancePourMaintien(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionAppartenancePourMaintien(contexte);
  }
  
  public Resultat verifierConditionDureeIndemnisationPourMaintien(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionDureeIndemnisationPourMaintien(contexte);
  }
  
  public Resultat verifierConditionDecisionCPPourMaintien(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionDecisionCPPourMaintien(contexte);
  }
  
  public FormuleMontantSpec getFormuleMontant(String code)
  {
    return getProduitAsuDelegue().getFormuleMontant(code);
  }
  
  public BigDecimal getSJR(AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().getSJR(attribution);
  }
  
  public Damj getDateObtentionAgePourMaintien(DemandeSpec demande)
  {
    return getProduitAsuDelegue().getDateObtentionAgePourMaintien(demande);
  }
  
  public Damj getDateObtentionDesTrimestres(DemandeSpec demande)
  {
    return getProduitAsuDelegue().getDateObtentionDesTrimestres(demande);
  }
  
  public Damj getDateObtentionIndemnisation(DemandeSpec demande)
    throws ApplicativeException
  {
    return getProduitAsuDelegue().getDateObtentionIndemnisation(demande);
  }
  
  public boolean estRejetChomageVolontaire(DecisionSpec decision)
  {
    if (getProduitAsuDelegue() == null) {
      return false;
    }
    return getProduitAsuDelegue().estRejetChomageVolontaire(decision);
  }
  
  public Quantite determinerReliquatHorsMaintien(AttributionSpec attribution, Damj dateCalcul)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().determinerReliquatHorsMaintien(attribution, dateCalcul);
  }
  
  public Quantite determinerReliquatAvecMaintien(AttributionSpec attribution, Damj dateCalcul)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().determinerReliquatAvecMaintien(attribution, dateCalcul);
  }
  
  public Damj getDateRuptureContratTravail(AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().getDateRuptureContratTravail(attribution);
  }
  
  public void controlerContexteDonneesForcees(Contexte contexte)
    throws ApplicativeException
  {
    getProduitAsuDelegue().controlerContexteDonneesForcees(contexte);
  }
  
  public void controlerContexteDonneesForceesPostLiquidation(Contexte contexte)
    throws ApplicativeException
  {
    getProduitAsuDelegue().controlerContexteDonneesForceesPostLiquidation(contexte);
  }
  
  public Quantite getDureeAServirEffective(AttributionSpec attribution)
  {
    return getProduitAsuDelegue().getDureeAServirEffective(attribution);
  }
  
  public Resultat verifierCondition28JoursSuspension(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierCondition28JoursSuspension(contexte);
  }
  
  public Quantite getDureeInitiale(AttributionSpec attribution)
  {
    return getProduitAsuDelegue().getDureeInitiale(attribution);
  }
  
  public void installerCompetenceConventionGestion(AttributionSpec attribution)
  {
    getProduitAsuDelegue().installerCompetenceConventionGestion(attribution);
  }
  
  public boolean determinerRepriseInvalide(DemandeSpec demande)
  {
    return getProduitAsuDelegue().determinerRepriseInvalide(demande);
  }
  
  public boolean estEntameDiffereStandard(DemandeSpec demande)
    throws ApplicativeException
  {
    return getProduitAsuDelegue().estEntameDiffereStandard(demande);
  }
  
  public void recalculerSurAnnulerReexamen(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    getProduitAsuDelegue().recalculerSurAnnulerReexamen(demande);
  }
  
  public ObjetMetierSpec recupererSJRPourDelaisReport(DemandeSpec demande)
  {
    return getProduitAsuDelegue().recupererSJRPourDelaisReport(demande);
  }
  
  public ConstructionPRASpec getOutilConstructionPRA()
  {
    return getProduitAsuDelegue().getOutilConstructionPRA();
  }
  
  public DureeIndemnisationAbstraite creerDureeCalcul(AttributionSpec attribution)
  {
    return getProduitAsuDelegue().creerDureeCalcul(attribution);
  }
  
  public DureeIndemnisationAbstraite creerDureeCalculTranche(Quantite quantite)
  {
    return getProduitAsuDelegue().creerDureeCalculTranche(quantite);
  }
  
  public Resultat executerSimulationAffiliation(DomSimulationAffiliation domSimulationAffiliation)
    throws ApplicativeException
  {
    return getProduitAsuDelegue().executerSimulationAffiliation(domSimulationAffiliation);
  }
  
  public void positionnerQuantiteAssimilationMaximum(Periode periode, TableQuantites tableQuantitesAffiliationAcquises)
  {
    getProduitAsuDelegue().positionnerQuantiteAssimilationMaximum(periode, tableQuantitesAffiliationAcquises);
  }
  
  public int getDureeMinimumPourImputationFormation()
  {
    return getProduitAsuDelegue().getDureeMinimumPourImputationFormation();
  }
  
  public BigDecimal plafonnerDiviseurPrc(BigDecimal dureePRC)
  {
    return getProduitAsuDelegue().plafonnerDiviseurPrc(dureePRC);
  }
  
  public void recalculerActivitesConserveesPourDemandeMigree(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    getProduitAsuDelegue().recalculerActivitesConserveesPourDemandeMigree(demande);
  }
  
  public int getNombreJoursIndemnisationNecessairesMaintien()
  {
    return getProduitAsuDelegue().getNombreJoursIndemnisationNecessairesMaintien();
  }
  
  public boolean estCompetenceFinanciereSecteurPublic(AttributionSpec attribution)
  {
    return getProduitAsuDelegue().estCompetenceFinanciereSecteurPublic(attribution);
  }
  
  public MontantBaseSpec obtenirMontantDroitPrecedentSecteurPublicProduitResultant(DemandeSpec demande, DossierExamenSpec dossierExamen, IndividuSpec individu)
    throws CoucheLogiqueException
  {
    return getProduitAsuDelegue().obtenirMontantDroitPrecedentSecteurPublicProduitResultant(demande, dossierExamen, individu);
  }
  
  public SalaireJournalierSpec revaloriserSalaireJournalier(ElementBaseIndemnisationSpec ebi, Damj date)
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().revaloriserSalaireJournalier(ebi, date);
    }
    return null;
  }
  
  public boolean estCapitalPrecedentRetenu(AttributionSpec attribution)
  {
    return getProduitAsuDelegue().estCapitalPrecedentRetenu(attribution);
  }
  
  public Resultat constituerRevisionAutomatique(Contexte contexte)
    throws ApplicativeException
  {
    return getProduitAsuDelegue().constituerRevisionAutomatique(contexte);
  }
  
  public DureeCalendaire getAgeMinimumObtentionMaintien(DemandeSpec demande)
  {
    return getProduitAsuDelegue().getAgeMinimumObtentionMaintien(demande);
  }
  
  public Reglement recupererReglementApplicable(AttributionSpec attribution)
  {
    return getProduitAsuDelegue().recupererReglementApplicable(attribution);
  }
  
  public boolean estPresenceDiffere(AttributionSpec attribution)
  {
    return getProduitAsuDelegue().estPresenceDiffere(attribution);
  }
  
  public SalaireJournalierSpec getSalaireJournalier(AttributionSpec attribution, Damj date)
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().getSalaireJournalier(attribution, date);
    }
    return null;
  }
  
  public Chronologie getListeActivitesConserveesAttributionAreLiee(AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().getListeActivitesConserveesAttributionAreLiee(attribution);
    }
    return null;
  }
  
  public String getCodeSirenEmployeurFaitGenerateur(AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().getCodeSirenEmployeurFaitGenerateur(attribution);
    }
    return null;
  }
  
  public BigDecimal recupererCoeficientTempsPartielMontantRetenu(AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().recupererCoeficientTempsPartielMontantRetenu(attribution);
    }
    return null;
  }
  
  public int getCodeEmploiA2b(DemandeSpec demande)
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().getCodeEmploiA2b(demande);
    }
    return 0;
  }
  
  public int getCodeEmploiA2b(DonneesEntreeDeterminationSjrSpec donneesEntreeDeterminationSjr)
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().getCodeEmploiA2b(donneesEntreeDeterminationSjr);
    }
    return 0;
  }
  
  public BigDecimal recupererSeuilMensuelHoraireActiviteReduite()
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().recupererSeuilMensuelHoraireActiviteReduite();
    }
    return null;
  }
  
  public int recupererNombreMoisCumulMaxActiviteReduite()
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().recupererNombreMoisCumulMaxActiviteReduite();
    }
    return 0;
  }
  
  public int recupererNombreMoisCumulCourrierKC6F()
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().recupererNombreMoisCumulCourrierKC6F();
    }
    return 0;
  }
  
  public int recupererNombreMoisIndemnisation(AttributionSpec attribution, Damj dateEtude)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().recupererNombreMoisIndemnisation(attribution, dateEtude);
    }
    return 0;
  }
  
  public Damj getDateFaitGenerateurAttributionMaitre(AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().getDateFaitGenerateurAttributionMaitre(attribution);
    }
    return null;
  }
  
  public List recupererParametresPourLiquidationSimplifiee(Periode periode)
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().recupererParametresPourLiquidationSimplifiee(periode);
    }
    return null;
  }
  
  public BigDecimal recupererSeuilRemuneration(AttributionSpec attribution, Damj dateCalcul)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().recupererSeuilRemuneration(attribution, dateCalcul);
    }
    return null;
  }
  
  public boolean recupererLeverBornageRetraite(AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().recupererLeverBornageRetraite(attribution);
    }
    return false;
  }
  
  public Damj getDateFinDelaiDecheance(AttributionSpec attributionOrigine, DemandeSpec demandeCourante)
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().getDateFinDelaiDecheance(attributionOrigine, demandeCourante);
    }
    return null;
  }
  
  public boolean determinePriseEnCompteObjectifReprise(DemandeSpec demandeCourante)
    throws CoucheLogiqueException
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().determinePriseEnCompteObjectifReprise(demandeCourante);
    }
    return true;
  }
  
  public void traitementPeriodesDecalantes(AttributionSpec attribution, ChronologiePeriodes periodesDecalantes, ConstituantsCalculActiviteReduiteSpec constituantsCalculActiviteReduite, UniteTraitement ut)
    throws CoucheLogiqueException
  {
    if (getProduitAsuDelegue() != null) {
      getProduitAsuDelegue().traitementPeriodesDecalantes(attribution, periodesDecalantes, constituantsCalculActiviteReduite, ut);
    }
  }
  
  public void traitementPeriodesGelantes(AttributionSpec attribution, ChronologiePeriodes periodesGelantes, ConstituantsCalculActiviteReduiteSpec constituantsCalculActiviteReduite, UniteTraitement ut)
    throws CoucheLogiqueException
  {
    if (getProduitAsuDelegue() != null) {
      getProduitAsuDelegue().traitementPeriodesGelantes(attribution, periodesGelantes, constituantsCalculActiviteReduite, ut);
    }
  }
  
  public SalaireJournalierSpec getSalaireConserve(AttributionSpec attribution, Damj date)
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().getSalaireConserve(attribution, date);
    }
    return null;
  }
  
  public Resultat liquiderDemandeAssociee(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().liquiderDemandeAssociee(contexte);
  }
  
  public void alimenterDonneesComplementairesDossierExamen(DossierExamenSpec dossierExamenDecisionne)
  {
    if (getProduitAsuDelegue() != null) {
      getProduitAsuDelegue().alimenterDonneesComplementairesDossierExamen(dossierExamenDecisionne);
    }
  }
  
  public String determinerPeriodeGaecAChargerSurLectureDecision(DemandeSpec demandeDecisionne)
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().determinerPeriodeGaecAChargerSurLectureDecision(demandeDecisionne);
  }
  
  public JustificationAppelGaecReduit getDateDebutFenetrageAppelGaec(DemandeSpec demande)
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().getDateDebutFenetrageAppelGaec(demande);
  }
  
  public SalaireJournalierSpec getSJC(AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().getSJC(attribution);
  }
  
  public Resultat creerGrapheDemandeAntecedent(Contexte contexte)
    throws CoucheLogiqueException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().creerGrapheDemandeAntecedent(contexte);
  }
  
  public BigDecimal determinerDureeMaximumPourProduit()
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().determinerDureeMaximumPourProduit();
  }
  
  public ResultatTraitementPopulation effectuerTraitementOccasionnel(CriteresTraitementPopulation criteres)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().effectuerTraitementOccasionnel(criteres);
    }
    return null;
  }
  
  public void verifierPropositionAttribution(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    if (getProduitAsuDelegue() != null) {
      getProduitAsuDelegue().verifierPropositionAttribution(demande);
    }
  }
  
  public SalaireJournalierSpec revaloriserSalaireJournalierReference(BigDecimal montantSjr, Damj dateEffetSjr, Damj dateRevalorisation, String contexteParticulier)
    throws CoucheLogiqueException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().revaloriserSalaireJournalierReference(montantSjr, dateEffetSjr, dateRevalorisation, contexteParticulier);
  }
  
  public FabriqueOutilFonctionnelSpec determinerFabriqueOutilFonctionnelDeterminationSjr(Damj dateFaitGenerateur)
    throws CoucheLogiqueException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().determinerFabriqueOutilFonctionnelDeterminationSjr(dateFaitGenerateur);
  }
  
  public DonneesResultatDeterminationSjrSpec determinerSjrip(DonneesEntreeDeterminationSjrSpec donneesEntree)
    throws CoucheLogiqueException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().determinerSjrip(donneesEntree);
  }
  
  public boolean estUnProduitGerantA9()
  {
    if (getProduitAsuDelegue() == null) {
      return false;
    }
    return getProduitAsuDelegue().estUnProduitGerantA9();
  }
  
  public boolean estUnProduitLevantAlerteA8A10()
  {
    if (getProduitAsuDelegue() == null) {
      return true;
    }
    return getProduitAsuDelegue().estUnProduitLevantAlerteA8A10();
  }
  
  public void verifierPropositionRejet(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    if (getProduitAsuDelegue() != null) {
      getProduitAsuDelegue().verifierPropositionRejet(demande);
    }
  }
  
  public MontantBaseSpec recupererMontant(DonneesEntreesRecuperationMontant donneeEntreeRecuperationMontant)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() != null) {
      return getProduitAsuDelegue().recupererMontant(donneeEntreeRecuperationMontant);
    }
    return null;
  }
  
  public ConventionGestionSpec getConventionGestion(AttributionSpec attribution)
  {
    ConventionGestionSpec convention = null;
    if (getProduitAsuDelegue() != null) {
      convention = getProduitAsuDelegue().getConventionGestion(attribution);
    }
    return convention;
  }
  
  public Convertisseur determinerConvertisseurUniteAffiliation()
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().determinerConvertisseurUniteAffiliation();
  }
  
  public Collection determinerListePlafonnementAffiliation(AttributionSpec attribution)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().determinerListePlafonnementAffiliation(attribution);
  }
  
  public boolean isPlafonnementAffiliationActif()
  {
    if (getProduitAsuDelegue() == null) {
      return false;
    }
    return getProduitAsuDelegue().isPlafonnementAffiliationActif();
  }
  
  public ElementBaseIndemnisationSpec recupererElementBaseIndemnisationPourReadmissionAvecMontantRetenuPrecedent(int natureDecision, int montantRetenu, DemandeSpec demande, AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().recupererElementBaseIndemnisationPourReadmissionAvecMontantRetenuPrecedent(natureDecision, montantRetenu, demande, attribution);
  }
  
  public ProduitAsuSpec getProduitMontantRetenu(AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().getProduitMontantRetenu(attribution);
  }
  
  public String getSituationParticuliere(AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().getSituationParticuliere(attribution);
  }
  
  public Resultat verifierConditionValiditeReliquat(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().verifierConditionValiditeReliquat(contexte);
  }
  
  public String determinerCodeSousProduitPourSigma(DecisionSpec decision)
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().determinerCodeSousProduitPourSigma(decision);
  }
  
  public CalculAppartenanceSpec getOutilCalculAppartenance(DemandeSpec demande, boolean utiliserNouveauOutilCalcul)
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().getOutilCalculAppartenance(demande, utiliserNouveauOutilCalcul);
  }
  
  public void initialiserComportementCalculAffiliation(ComportementAffiliationSpec comportement, ParametresAffiliationSpec parametres)
  {
    if (getProduitAsuDelegue() != null) {
      getProduitAsuDelegue().initialiserComportementCalculAffiliation(comportement, parametres);
    }
  }
  
  public String determinerSituationParticuliere(AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().determinerSituationParticuliere(attribution);
  }
  
  public boolean estProduitGerantPensionInvalidite(DemandeSpec demande)
  {
    if (getProduitAsuDelegue() == null) {
      return false;
    }
    return getProduitAsuDelegue().estProduitGerantPensionInvalidite(demande);
  }
  
  public Collection determinerPensionInvaliditeDroitCourant(AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().determinerPensionInvaliditeDroitCourant(attribution);
  }
  
  public Collection determinerPensionInvaliditeDroitResultant(AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().determinerPensionInvaliditeDroitResultant(attribution);
  }
  
  public boolean estProduitGerantIccpEnContexteRepriseSimplifiee()
  {
    if (getProduitAsuDelegue() == null) {
      return false;
    }
    return getProduitAsuDelegue().estProduitGerantIccpEnContexteRepriseSimplifiee();
  }
  
  public Damj determinerDateExclueAuPlusTardDebutActiviteConservee(ActiviteSalarie pas, Damj dateFaitGenerateur)
    throws CoucheLogiqueException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().determinerDateExclueAuPlusTardDebutActiviteConservee(pas, dateFaitGenerateur);
  }
  
  public Resultat determinerContexteExamen(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().determinerContexteExamen(contexte);
  }
  
  public Quantite getDureeAServirTheorique(AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().getDureeAServirTheorique(attribution);
  }
  
  public Resultat constituerTranchesExecutables(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerTranchesExecutables(contexte);
  }
  
  public MontantBaseSpec calculerMontantAUneDate(AttributionSpec attribution, Damj dateCalcul)
    throws ApplicativeException
  {
    MontantBaseSpec montantCalcule = null;
    DonneesEntreesRecuperationMontant donneesEntree = ((GammeAsuSpec)attribution.getGamme()).mapperDonneesEntreesRecuperationMontant(attribution);
    if (donneesEntree != null)
    {
      donneesEntree.setDateCalculMontant(dateCalcul);
      montantCalcule = getProduitAsuDelegue().recupererMontant(donneesEntree);
    }
    return montantCalcule;
  }
  
  public BigDecimal recupererCoefficientSaisonnierMontantRetenu(AttributionSpec attribution)
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().recupererCoefficientSaisonnierMontantRetenu(attribution);
  }
  
  public boolean estTrancheActivee(DemandeSpec demande)
  {
    if (getProduitAsuDelegue() == null) {
      return false;
    }
    return getProduitAsuDelegue().estTrancheActivee(demande);
  }
  
  public boolean effectuerTraitementSpecifiqueAssistanceMaternellePourAffiliation()
  {
    if (getProduitAsuDelegue() == null) {
      return false;
    }
    return getProduitAsuDelegue().effectuerTraitementSpecifiqueAssistanceMaternellePourAffiliation();
  }
  
  public boolean estGestionDroitOptionReadmissionForce()
  {
    return false;
  }
  
  public StrategieSpec retournerStrategieAvantDeterminationChomageInvolontaire()
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().retournerStrategieAvantDeterminationChomageInvolontaire();
  }
  
  public boolean estForcerTempsPleinPourPeriodeA8A10(Damj dateExamen)
  {
    return getProduitAsuDelegue().estForcerTempsPleinPourPeriodeA8A10(dateExamen);
  }
  
  public CalendrierExecutionCalculSpec creerCalendrierCalcul()
  {
    return getProduitAsuDelegue().creerCalendrierCalcul();
  }
  
  public UniteTraitement creerUT(Periode periodeUT, AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    return getProduitAsuDelegue().creerUT(periodeUT, attribution);
  }
  
  public Resultat constituerCapitalDroitCourant(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerCapitalDroitCourant(contexte);
  }
  
  public Resultat constituerMontantsEffectifs(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerMontantsEffectifs(contexte);
  }
  
  public Resultat constituerNouvelleRevisionAutomatique(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().constituerNouvelleRevisionAutomatique(contexte);
  }
  
  public boolean estUnProduitSansDuree()
  {
    return false;
  }
  
  public String recupererIdAeBatimentPourICCPConservatoire(AttributionSpec attribution)
  {
    String idPeriodeGaec = null;
    if (getProduitAsuDelegue() != null) {
      idPeriodeGaec = getProduitAsuDelegue().recupererIdAeBatimentPourICCPConservatoire(attribution);
    }
    return idPeriodeGaec;
  }
}

/* Location:
 * Qualified Name:     ProduitAsuAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */