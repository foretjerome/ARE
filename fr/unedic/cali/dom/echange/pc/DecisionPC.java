package fr.unedic.cali.dom.echange.pc;

import fr.unedic.cali.dom.echange.Decision;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.temps.Damj;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import javax.jdo.JDOFatalInternalException;
import javax.jdo.JDOUnsupportedOptionException;
import javax.jdo.JDOUserException;
import javax.jdo.PersistenceManager;
import javax.jdo.spi.JDOImplHelper;
import javax.jdo.spi.JDOPermission;
import javax.jdo.spi.PersistenceCapable;
import javax.jdo.spi.PersistenceCapable.ObjectIdFieldConsumer;
import javax.jdo.spi.PersistenceCapable.ObjectIdFieldSupplier;
import javax.jdo.spi.StateManager;
import xcalia.lido.internal.sm.CommonStateManager;

public class DecisionPC
  implements DomPCSpec, PersistenceCapable
{
  private transient Decision m_decisionOM;
  protected String m_identifiantEvenement;
  protected int m_etatDemande;
  protected String m_codeSegment;
  protected String m_referenceExterneDemande;
  protected String m_gamme;
  protected String m_ligne;
  protected int m_typeEchecExamen;
  protected int m_motifEchec;
  protected String m_classementAdministratif;
  protected int m_motifReexamenPrincipal;
  protected int m_identifiantOd;
  protected int m_identifiantReprise;
  protected String m_produit;
  protected int m_natureDecision;
  protected int m_origineDecision;
  protected int m_topContribSupplementaire;
  protected int m_topContribSpecifique;
  protected int m_topEchecDemandeExpresseEnCoursIndemnisation;
  protected int m_topRejetASUReliquatASS;
  protected int m_topRejetASUCpaASS;
  protected int m_topDroitOptionAss;
  protected String m_competenceAdministrative;
  protected int m_indicateurNotificationCourrier;
  protected BigDecimal m_montantAllocationJournalierBrutCourrier;
  protected BigDecimal m_montantAllocationJournalierNetCourrier;
  protected BigDecimal m_montantCrcCourrier;
  protected int m_dureeTheoriqueDroitServiCourrier;
  protected int m_dureeRenouvellementAreCourrier;
  protected BigDecimal m_montantPensionInvaliditeAreCourrier;
  protected BigDecimal m_montantArePourAerComplementCourrier;
  protected BigDecimal m_montantForfaitaireMensuelRpsCourrier;
  protected int m_identifiantActionFormation;
  protected BigDecimal m_fraisFthrAvant;
  protected BigDecimal m_fraisFpoAvant;
  protected BigDecimal m_fraisFthrApres;
  protected BigDecimal m_fraisFpoApres;
  protected int m_exerciceAvant;
  protected int m_exerciceApres;
  protected int m_statutAvant;
  protected int m_statutApres;
  protected int m_topAffDerogatoire;
  protected String m_libelleEmployeur;
  protected int m_motifRejet;
  protected Damj m_dateTraitement;
  protected BigDecimal m_montantSJC;
  protected BigDecimal m_montantSJCMax;
  protected BigDecimal m_montantAllocation;
  protected BigDecimal m_montantAllocationUn;
  protected BigDecimal m_montantAllocationDeux;
  protected int m_topCaisseInconnue;
  protected int m_dureeImputationAideSurDroit;
  protected String m_typeAide;
  protected int m_topIndividuStable;
  protected String m_typeExamen;
  protected String m_situationParticuliere;
  protected boolean m_investigationFraude;
  protected String m_codeSousProduit;
  protected Damj m_dateBanalisee;
  protected BigDecimal m_montantSJRSuiteRevision;
  protected int m_auMoinsUneActiviteConservee;
  protected String m_codeTypeAction;
  protected int m_creationDALSuiteRejet;
  protected String m_codeTypeAttente;
  protected Damj m_dateFCT;
  protected String m_typeExamenCreationDemande;
  protected BigDecimal m_contributionNonPropositionCTP;
  protected int m_estContribPreavis;
  protected int m_estContribDif;
  protected BigDecimal m_montantPreavisCR;
  protected BigDecimal m_montantFormationD;
  protected BigDecimal m_nombreHeureUn;
  protected BigDecimal m_nombreHeureDeux;
  protected int m_topAppelContributions;
  protected BigDecimal m_plafondMensuelRessourcesAss;
  protected BigDecimal m_nbEmploisSalariesRetenus;
  protected BigDecimal m_montantBrutTranche2;
  protected BigDecimal m_montantCrcTranche2;
  protected int m_dureeTranche2;
  protected BigDecimal m_montantBrutTranche3;
  protected BigDecimal m_montantCrcTranche3;
  protected int m_dureeTranche3;
  protected String m_validationDAPE;
  protected String m_typeActionReclassementAvant;
  protected String m_typeActionReclassementApres;
  protected int m_estDerogatoire;
  protected BigDecimal m_montantForfaitUnitaireRepas;
  protected BigDecimal m_montantForfaitUnitaireHebergement;
  protected BigDecimal m_montantIndiceKilometrique;
  protected Damj m_dateDepotAide;
  protected int m_attenteValidationDAPE;
  protected int m_attenteRetourJustificatif;
  protected Damj m_dateRetourJustificatif;
  private BigDecimal m_nombreEnfantsTotal;
  private String m_codeAffectation;
  private String m_numeroConventionGestion;
  private BigDecimal m_montantBonAvant;
  private BigDecimal m_montantBonAvantDerogatoire;
  private String m_typeBonAvant;
  private String m_typeBonAvantDerogatoire;
  private BigDecimal m_montantBonApres;
  private BigDecimal m_montantBonApresDerogatoire;
  private String m_typeBonApres;
  private String m_typeBonApresDerogatoire;
  private int m_objectifLiquidation;
  private BigDecimal m_dureePostPrime;
  private String m_indicateurPremiereDemandePostPrime;
  private String m_indicateurDiminutionMontantCSP;
  private String m_indicateurAllongementDureeCSP;
  private Damj m_dateDepartDelai121j;
  private Damj m_dateDebutDernierDelaiAttente;
  private Damj m_dateIDE;
  private Damj m_dateFaitGenerateurDroitPrecedent;
  private String m_reglementApplicableDroit;
  private int m_dureeActiviteEmployeursRAC;
  private int m_coeffTPAppliqueRAC;
  private int m_dureeActiviteEmployeursSP;
  private int m_coeffTPAppliqueSP;
  private int m_topDemandeASSSuiteDecheance;
  private String m_attenteBlocageLiquidationAutoRepriseAss;
  private String m_attenteNationaliteAValider;
  private int m_topDetectionClauseRattrapage;
  private int m_topSpectacle2016avantMepSI4;
  private int m_topAreSpectacleEnCoursClauseRattrapage;
  private BigDecimal m_nombreJoursFranchiseCP;
  private BigDecimal m_nombreJoursFranchiseSalaire;
  private int m_franchiseCpMensuelle;
  private int m_franchiseSalaireMensuelle;
  private BigDecimal m_baseCalculFranchiseCP;
  private BigDecimal m_baseCalculFranchiseSalaire;
  private int m_attenteIncoherenceSalaireNPDE;
  private BigDecimal m_identifiantPeriodeIncoherenceSalaireNPDE;
  private int m_estPresencePNDS;
  private String m_codeSousProduitRejet;
  private boolean m_presenceDerniersSalaires;
  private BigDecimal m_nombreMoisPreavis;
  private BigDecimal m_identifiantPeriodeIncoherenceRessortissant;
  private int m_dureeAllongementArefPossible;
  private int m_dureeAllongementArefRealisee;
  private BigDecimal m_coefficientReducteurSJR;
  private BigDecimal m_plancherCoefReducteur;
  private String m_topPresenceDiffereARCE;
  private BigDecimal m_diviseurIslr;
  private int m_naturePeriodeSuspensive;
  private Damj m_dateFinPeriodeSuspensive;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_identifiantEvenement", "m_etatDemande", "m_codeSegment", "m_referenceExterneDemande", "m_gamme", "m_ligne", "m_typeEchecExamen", "m_motifEchec", "m_classementAdministratif", "m_motifReexamenPrincipal", "m_identifiantOd", "m_identifiantReprise", "m_produit", "m_natureDecision", "m_origineDecision", "m_topContribSupplementaire", "m_topContribSpecifique", "m_topEchecDemandeExpresseEnCoursIndemnisation", "m_topRejetASUReliquatASS", "m_topRejetASUCpaASS", "m_topDroitOptionAss", "m_competenceAdministrative", "m_indicateurNotificationCourrier", "m_montantAllocationJournalierBrutCourrier", "m_montantAllocationJournalierNetCourrier", "m_montantCrcCourrier", "m_dureeTheoriqueDroitServiCourrier", "m_dureeRenouvellementAreCourrier", "m_montantPensionInvaliditeAreCourrier", "m_montantArePourAerComplementCourrier", "m_montantForfaitaireMensuelRpsCourrier", "m_identifiantActionFormation", "m_fraisFthrAvant", "m_fraisFpoAvant", "m_fraisFthrApres", "m_fraisFpoApres", "m_exerciceAvant", "m_exerciceApres", "m_statutAvant", "m_statutApres", "m_topAffDerogatoire", "m_libelleEmployeur", "m_motifRejet", "m_dateTraitement", "m_montantSJC", "m_montantSJCMax", "m_montantAllocation", "m_montantAllocationUn", "m_montantAllocationDeux", "m_topCaisseInconnue", "m_dureeImputationAideSurDroit", "m_typeAide", "m_topIndividuStable", "m_typeExamen", "m_situationParticuliere", "m_investigationFraude", "m_codeSousProduit", "m_dateBanalisee", "m_montantSJRSuiteRevision", "m_auMoinsUneActiviteConservee", "m_codeTypeAction", "m_creationDALSuiteRejet", "m_codeTypeAttente", "m_dateFCT", "m_typeExamenCreationDemande", "m_contributionNonPropositionCTP", "m_estContribPreavis", "m_estContribDif", "m_montantPreavisCR", "m_montantFormationD", "m_nombreHeureUn", "m_nombreHeureDeux", "m_topAppelContributions", "m_plafondMensuelRessourcesAss", "m_nbEmploisSalariesRetenus", "m_montantBrutTranche2", "m_montantCrcTranche2", "m_dureeTranche2", "m_montantBrutTranche3", "m_montantCrcTranche3", "m_dureeTranche3", "m_validationDAPE", "m_typeActionReclassementAvant", "m_typeActionReclassementApres", "m_estDerogatoire", "m_montantForfaitUnitaireRepas", "m_montantForfaitUnitaireHebergement", "m_montantIndiceKilometrique", "m_dateDepotAide", "m_attenteValidationDAPE", "m_attenteRetourJustificatif", "m_dateRetourJustificatif", "m_nombreEnfantsTotal", "m_codeAffectation", "m_numeroConventionGestion", "m_montantBonAvant", "m_montantBonAvantDerogatoire", "m_typeBonAvant", "m_typeBonAvantDerogatoire", "m_montantBonApres", "m_montantBonApresDerogatoire", "m_typeBonApres", "m_typeBonApresDerogatoire", "m_objectifLiquidation", "m_dureePostPrime", "m_indicateurPremiereDemandePostPrime", "m_indicateurDiminutionMontantCSP", "m_indicateurAllongementDureeCSP", "m_dateDepartDelai121j", "m_dateDebutDernierDelaiAttente", "m_dateIDE", "m_dateFaitGenerateurDroitPrecedent", "m_reglementApplicableDroit", "m_dureeActiviteEmployeursRAC", "m_coeffTPAppliqueRAC", "m_dureeActiviteEmployeursSP", "m_coeffTPAppliqueSP", "m_topDemandeASSSuiteDecheance", "m_attenteBlocageLiquidationAutoRepriseAss", "m_attenteNationaliteAValider", "m_topDetectionClauseRattrapage", "m_topSpectacle2016avantMepSI4", "m_topAreSpectacleEnCoursClauseRattrapage", "m_nombreJoursFranchiseCP", "m_nombreJoursFranchiseSalaire", "m_franchiseCpMensuelle", "m_franchiseSalaireMensuelle", "m_baseCalculFranchiseCP", "m_baseCalculFranchiseSalaire", "m_attenteIncoherenceSalaireNPDE", "m_identifiantPeriodeIncoherenceSalaireNPDE", "m_estPresencePNDS", "m_codeSousProduitRejet", "m_presenceDerniersSalaires", "m_nombreMoisPreavis", "m_identifiantPeriodeIncoherenceRessortissant", "m_dureeAllongementArefPossible", "m_dureeAllongementArefRealisee", "m_coefficientReducteurSJR", "m_plancherCoefReducteur", "m_topPresenceDiffereARCE", "m_diviseurIslr", "m_naturePeriodeSuspensive", "m_dateFinPeriodeSuspensive" };
  private static Class[] jdoFieldTypes = { String.class, Integer.TYPE, String.class, String.class, String.class, String.class, Integer.TYPE, Integer.TYPE, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class, Integer.TYPE, BigDecimal.class, BigDecimal.class, BigDecimal.class, Integer.TYPE, Integer.TYPE, BigDecimal.class, BigDecimal.class, BigDecimal.class, Integer.TYPE, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class, Integer.TYPE, Damj.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, Integer.TYPE, Integer.TYPE, String.class, Integer.TYPE, String.class, String.class, Boolean.TYPE, String.class, Damj.class, BigDecimal.class, Integer.TYPE, String.class, Integer.TYPE, String.class, Damj.class, String.class, BigDecimal.class, Integer.TYPE, Integer.TYPE, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, Integer.TYPE, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, Integer.TYPE, BigDecimal.class, BigDecimal.class, Integer.TYPE, String.class, String.class, String.class, Integer.TYPE, BigDecimal.class, BigDecimal.class, BigDecimal.class, Damj.class, Integer.TYPE, Integer.TYPE, Damj.class, BigDecimal.class, String.class, String.class, BigDecimal.class, BigDecimal.class, String.class, String.class, BigDecimal.class, BigDecimal.class, String.class, String.class, Integer.TYPE, BigDecimal.class, String.class, String.class, String.class, Damj.class, Damj.class, Damj.class, Damj.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, BigDecimal.class, BigDecimal.class, Integer.TYPE, Integer.TYPE, BigDecimal.class, BigDecimal.class, Integer.TYPE, BigDecimal.class, Integer.TYPE, String.class, Boolean.TYPE, BigDecimal.class, BigDecimal.class, Integer.TYPE, Integer.TYPE, BigDecimal.class, BigDecimal.class, String.class, BigDecimal.class, Integer.TYPE, Damj.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public DecisionPC()
  {
    jdoSetm_investigationFraude(this, false);
    
    jdoSetm_codeTypeAction(this, "  ");
  }
  
  public Object createOM()
  {
    if (m_decisionOM == null) {
      m_decisionOM = new Decision(this);
    }
    return m_decisionOM;
  }
  
  public String getIdentifiantEvenement()
  {
    return jdoGetm_identifiantEvenement(this);
  }
  
  public final void setIdentifiantEvenement(String p_identifiantEvenement)
  {
    jdoSetm_identifiantEvenement(this, p_identifiantEvenement);
  }
  
  public int getEtatDemande()
  {
    return jdoGetm_etatDemande(this);
  }
  
  public final void setEtatDemande(int p_etatDemande)
  {
    jdoSetm_etatDemande(this, p_etatDemande);
  }
  
  public String getCodeSegment()
  {
    return jdoGetm_codeSegment(this);
  }
  
  public final void setCodeSegment(String p_codeSegment)
  {
    jdoSetm_codeSegment(this, p_codeSegment);
  }
  
  public String getReferenceExterneDemande()
  {
    return jdoGetm_referenceExterneDemande(this);
  }
  
  public final void setReferenceExterneDemande(String p_referenceExterneDemande)
  {
    jdoSetm_referenceExterneDemande(this, p_referenceExterneDemande);
  }
  
  public String getGamme()
  {
    return jdoGetm_gamme(this);
  }
  
  public final void setGamme(String p_gamme)
  {
    jdoSetm_gamme(this, p_gamme);
  }
  
  public String getLigne()
  {
    return jdoGetm_ligne(this);
  }
  
  public final void setLigne(String p_ligne)
  {
    jdoSetm_ligne(this, p_ligne);
  }
  
  public int getTypeEchecExamen()
  {
    return jdoGetm_typeEchecExamen(this);
  }
  
  public final void setTypeEchecExamen(int p_typeEchecExamen)
  {
    jdoSetm_typeEchecExamen(this, p_typeEchecExamen);
  }
  
  public int getMotifEchec()
  {
    return jdoGetm_motifEchec(this);
  }
  
  public final void setMotifEchec(int p_motifEchec)
  {
    jdoSetm_motifEchec(this, p_motifEchec);
  }
  
  public String getClassementAdministratif()
  {
    return jdoGetm_classementAdministratif(this);
  }
  
  public final void setClassementAdministratif(String p_classementAdministratif)
  {
    jdoSetm_classementAdministratif(this, p_classementAdministratif);
  }
  
  public int getMotifReexamenPrincipal()
  {
    return jdoGetm_motifReexamenPrincipal(this);
  }
  
  public final void setMotifReexamenPrincipal(int p_motifReexamenPrincipal)
  {
    jdoSetm_motifReexamenPrincipal(this, p_motifReexamenPrincipal);
  }
  
  public int getIdentifiantOd()
  {
    return jdoGetm_identifiantOd(this);
  }
  
  public final void setIdentifiantOd(int p_identifiantOd)
  {
    jdoSetm_identifiantOd(this, p_identifiantOd);
  }
  
  public int getIdentifiantReprise()
  {
    return jdoGetm_identifiantReprise(this);
  }
  
  public final void setIdentifiantReprise(int p_identifiantReprise)
  {
    jdoSetm_identifiantReprise(this, p_identifiantReprise);
  }
  
  public String getProduit()
  {
    return jdoGetm_produit(this);
  }
  
  public final void setProduit(String p_produit)
  {
    jdoSetm_produit(this, p_produit);
  }
  
  public int getNatureDecision()
  {
    return jdoGetm_natureDecision(this);
  }
  
  public final void setNatureDecision(int p_natureDecision)
  {
    jdoSetm_natureDecision(this, p_natureDecision);
  }
  
  public int getOrigineDecision()
  {
    return jdoGetm_origineDecision(this);
  }
  
  public final void setOrigineDecision(int p_origineDecision)
  {
    jdoSetm_origineDecision(this, p_origineDecision);
  }
  
  public int getTopContribSupplementaire()
  {
    return jdoGetm_topContribSupplementaire(this);
  }
  
  public final void setTopContribSupplementaire(int p_topContribSupplementaire)
  {
    jdoSetm_topContribSupplementaire(this, p_topContribSupplementaire);
  }
  
  public int getTopContribSpecifique()
  {
    return jdoGetm_topContribSpecifique(this);
  }
  
  public final void setTopContribSpecifique(int p_topContribSpecifique)
  {
    jdoSetm_topContribSpecifique(this, p_topContribSpecifique);
  }
  
  public int getTopEchecDemandeExpresseEnCoursIndemnisation()
  {
    return jdoGetm_topEchecDemandeExpresseEnCoursIndemnisation(this);
  }
  
  public final void setTopEchecDemandeExpresseEnCoursIndemnisation(int p_topEchecDemandeExpresseEnCoursIndemnisation)
  {
    jdoSetm_topEchecDemandeExpresseEnCoursIndemnisation(this, p_topEchecDemandeExpresseEnCoursIndemnisation);
  }
  
  public int getTopRejetASUReliquatASS()
  {
    return jdoGetm_topRejetASUReliquatASS(this);
  }
  
  public final void setTopRejetASUReliquatASS(int p_topRejetASUReliquatASS)
  {
    jdoSetm_topRejetASUReliquatASS(this, p_topRejetASUReliquatASS);
  }
  
  public int getTopRejetASUCpaASS()
  {
    return jdoGetm_topRejetASUCpaASS(this);
  }
  
  public final void setTopRejetASUCpaASS(int p_topRejetASUCpaASS)
  {
    jdoSetm_topRejetASUCpaASS(this, p_topRejetASUCpaASS);
  }
  
  public int getTopDroitOptionAss()
  {
    return jdoGetm_topDroitOptionAss(this);
  }
  
  public final void setTopDroitOptionAss(int p_topDroitOptionAss)
  {
    jdoSetm_topDroitOptionAss(this, p_topDroitOptionAss);
  }
  
  public String getCompetenceAdministrative()
  {
    return jdoGetm_competenceAdministrative(this);
  }
  
  public final void setCompetenceAdministrative(String p_competenceAdministrative)
  {
    jdoSetm_competenceAdministrative(this, p_competenceAdministrative);
  }
  
  public int getIndicateurNotificationCourrier()
  {
    return jdoGetm_indicateurNotificationCourrier(this);
  }
  
  public final void setIndicateurNotificationCourrier(int p_indicateurNotificationCourrier)
  {
    jdoSetm_indicateurNotificationCourrier(this, p_indicateurNotificationCourrier);
  }
  
  public BigDecimal getMontantAllocationJournalierBrutCourrier()
  {
    return jdoGetm_montantAllocationJournalierBrutCourrier(this);
  }
  
  public final void setMontantAllocationJournalierBrutCourrier(BigDecimal p_montantAllocationJournalierBrutCourrier)
  {
    jdoSetm_montantAllocationJournalierBrutCourrier(this, p_montantAllocationJournalierBrutCourrier);
  }
  
  public BigDecimal getMontantAllocationJournalierNetCourrier()
  {
    return jdoGetm_montantAllocationJournalierNetCourrier(this);
  }
  
  public final void setMontantAllocationJournalierNetCourrier(BigDecimal p_montantAllocationJournalierNetCourrier)
  {
    jdoSetm_montantAllocationJournalierNetCourrier(this, p_montantAllocationJournalierNetCourrier);
  }
  
  public BigDecimal getMontantCrcCourrier()
  {
    return jdoGetm_montantCrcCourrier(this);
  }
  
  public final void setMontantCrcCourrier(BigDecimal p_montantCrcCourrier)
  {
    jdoSetm_montantCrcCourrier(this, p_montantCrcCourrier);
  }
  
  public int getDureeTheoriqueDroitServiCourrier()
  {
    return jdoGetm_dureeTheoriqueDroitServiCourrier(this);
  }
  
  public final void setDureeTheoriqueDroitServiCourrier(int p_dureeTheoriqueDroitServiCourrier)
  {
    jdoSetm_dureeTheoriqueDroitServiCourrier(this, p_dureeTheoriqueDroitServiCourrier);
  }
  
  public int getDureeRenouvellementAreCourrier()
  {
    return jdoGetm_dureeRenouvellementAreCourrier(this);
  }
  
  public final void setDureeRenouvellementAreCourrier(int p_dureeRenouvellementAreCourrier)
  {
    jdoSetm_dureeRenouvellementAreCourrier(this, p_dureeRenouvellementAreCourrier);
  }
  
  public BigDecimal getMontantPensionInvaliditeAreCourrier()
  {
    return jdoGetm_montantPensionInvaliditeAreCourrier(this);
  }
  
  public final void setMontantPensionInvaliditeAreCourrier(BigDecimal p_montantPensionInvaliditeAreCourrier)
  {
    jdoSetm_montantPensionInvaliditeAreCourrier(this, p_montantPensionInvaliditeAreCourrier);
  }
  
  public BigDecimal getMontantArePourAerComplementCourrier()
  {
    return jdoGetm_montantArePourAerComplementCourrier(this);
  }
  
  public final void setMontantArePourAerComplementCourrier(BigDecimal p_montantArePourAerComplementCourrier)
  {
    jdoSetm_montantArePourAerComplementCourrier(this, p_montantArePourAerComplementCourrier);
  }
  
  public BigDecimal getMontantForfaitaireMensuelRpsCourrier()
  {
    return jdoGetm_montantForfaitaireMensuelRpsCourrier(this);
  }
  
  public final void setMontantForfaitaireMensuelRpsCourrier(BigDecimal p_montantForfaitaireMensuelRpsCourrier)
  {
    jdoSetm_montantForfaitaireMensuelRpsCourrier(this, p_montantForfaitaireMensuelRpsCourrier);
  }
  
  public int getIdentifiantActionFormation()
  {
    return jdoGetm_identifiantActionFormation(this);
  }
  
  public final void setIdentifiantActionFormation(int p_identifiantActionFormation)
  {
    jdoSetm_identifiantActionFormation(this, p_identifiantActionFormation);
  }
  
  public BigDecimal getFraisFthrAvant()
  {
    return jdoGetm_fraisFthrAvant(this);
  }
  
  public final void setFraisFthrAvant(BigDecimal p_fraisFthrAvant)
  {
    jdoSetm_fraisFthrAvant(this, p_fraisFthrAvant);
  }
  
  public BigDecimal getFraisFpoAvant()
  {
    return jdoGetm_fraisFpoAvant(this);
  }
  
  public final void setFraisFpoAvant(BigDecimal p_fraisFpoAvant)
  {
    jdoSetm_fraisFpoAvant(this, p_fraisFpoAvant);
  }
  
  public BigDecimal getFraisFthrApres()
  {
    return jdoGetm_fraisFthrApres(this);
  }
  
  public final void setFraisFthrApres(BigDecimal p_fraisFthrApres)
  {
    jdoSetm_fraisFthrApres(this, p_fraisFthrApres);
  }
  
  public BigDecimal getFraisFpoApres()
  {
    return jdoGetm_fraisFpoApres(this);
  }
  
  public final void setFraisFpoApres(BigDecimal p_fraisFpoApres)
  {
    jdoSetm_fraisFpoApres(this, p_fraisFpoApres);
  }
  
  public int getExerciceAvant()
  {
    return jdoGetm_exerciceAvant(this);
  }
  
  public final void setExerciceAvant(int p_exerciceAvant)
  {
    jdoSetm_exerciceAvant(this, p_exerciceAvant);
  }
  
  public int getExerciceApres()
  {
    return jdoGetm_exerciceApres(this);
  }
  
  public final void setExerciceApres(int p_exerciceApres)
  {
    jdoSetm_exerciceApres(this, p_exerciceApres);
  }
  
  public int getStatutAvant()
  {
    return jdoGetm_statutAvant(this);
  }
  
  public final void setStatutAvant(int p_statutAvant)
  {
    jdoSetm_statutAvant(this, p_statutAvant);
  }
  
  public int getStatutApres()
  {
    return jdoGetm_statutApres(this);
  }
  
  public final void setStatutApres(int p_statutApres)
  {
    jdoSetm_statutApres(this, p_statutApres);
  }
  
  public int getTopAffDerogatoire()
  {
    return jdoGetm_topAffDerogatoire(this);
  }
  
  public final void setTopAffDerogatoire(int p_topAffDerogatoire)
  {
    jdoSetm_topAffDerogatoire(this, p_topAffDerogatoire);
  }
  
  public String getLibelleEmployeur()
  {
    return jdoGetm_libelleEmployeur(this);
  }
  
  public final void setLibelleEmployeur(String p_libelleEmployeur)
  {
    jdoSetm_libelleEmployeur(this, p_libelleEmployeur);
  }
  
  public int getMotifRejet()
  {
    return jdoGetm_motifRejet(this);
  }
  
  public final void setMotifRejet(int p_motifRejet)
  {
    jdoSetm_motifRejet(this, p_motifRejet);
  }
  
  public Damj getDateTraitement()
  {
    return jdoGetm_dateTraitement(this);
  }
  
  public final void setDateTraitement(Damj p_dateTraitement)
  {
    jdoSetm_dateTraitement(this, p_dateTraitement);
  }
  
  public BigDecimal getMontantSJC()
  {
    return jdoGetm_montantSJC(this);
  }
  
  public final void setMontantSJC(BigDecimal p_montantSJC)
  {
    jdoSetm_montantSJC(this, p_montantSJC);
  }
  
  public BigDecimal getMontantSJCMax()
  {
    return jdoGetm_montantSJCMax(this);
  }
  
  public final void setMontantSJCMax(BigDecimal p_montantSJCMax)
  {
    jdoSetm_montantSJCMax(this, p_montantSJCMax);
  }
  
  public BigDecimal getMontantAllocation()
  {
    return jdoGetm_montantAllocation(this);
  }
  
  public final void setMontantAllocation(BigDecimal p_montantAllocation)
  {
    jdoSetm_montantAllocation(this, p_montantAllocation);
  }
  
  public BigDecimal getMontantAllocationUn()
  {
    return jdoGetm_montantAllocationUn(this);
  }
  
  public final void setMontantAllocationUn(BigDecimal p_montantAllocationUn)
  {
    jdoSetm_montantAllocationUn(this, p_montantAllocationUn);
  }
  
  public BigDecimal getMontantAllocationDeux()
  {
    return jdoGetm_montantAllocationDeux(this);
  }
  
  public final void setMontantAllocationDeux(BigDecimal p_montantAllocationDeux)
  {
    jdoSetm_montantAllocationDeux(this, p_montantAllocationDeux);
  }
  
  public int getTopCaisseInconnue()
  {
    return jdoGetm_topCaisseInconnue(this);
  }
  
  public final void setTopCaisseInconnue(int p_topCaisseInconnue)
  {
    jdoSetm_topCaisseInconnue(this, p_topCaisseInconnue);
  }
  
  public int getDureeImputationAideSurDroit()
  {
    return jdoGetm_dureeImputationAideSurDroit(this);
  }
  
  public final void setDureeImputationAideSurDroit(int p_dureeImputationAideSurDroit)
  {
    jdoSetm_dureeImputationAideSurDroit(this, p_dureeImputationAideSurDroit);
  }
  
  public String getTypeAide()
  {
    return jdoGetm_typeAide(this);
  }
  
  public final void setTypeAide(String p_typeAide)
  {
    jdoSetm_typeAide(this, p_typeAide);
  }
  
  public int getTopIndividuStable()
  {
    return jdoGetm_topIndividuStable(this);
  }
  
  public final void setTopIndividuStable(int p_topIndividuStable)
  {
    jdoSetm_topIndividuStable(this, p_topIndividuStable);
  }
  
  public String getTypeExamen()
  {
    return jdoGetm_typeExamen(this);
  }
  
  public final void setTypeExamen(String p_typeExamen)
  {
    jdoSetm_typeExamen(this, p_typeExamen);
  }
  
  public String getSituationParticuliere()
  {
    return jdoGetm_situationParticuliere(this);
  }
  
  public final void setSituationParticuliere(String p_situationParticuliere)
  {
    jdoSetm_situationParticuliere(this, p_situationParticuliere);
  }
  
  public boolean isInvestigationFraude()
  {
    return jdoGetm_investigationFraude(this);
  }
  
  public final void setInvestigationFraude(boolean p_investigationFraude)
  {
    jdoSetm_investigationFraude(this, p_investigationFraude);
  }
  
  public String getCodeSousProduit()
  {
    return jdoGetm_codeSousProduit(this);
  }
  
  public final void setCodeSousProduit(String p_codeSousProduit)
  {
    jdoSetm_codeSousProduit(this, p_codeSousProduit);
  }
  
  public Damj getDateBanalisee()
  {
    return jdoGetm_dateBanalisee(this);
  }
  
  public final void setDateBanalisee(Damj p_dateBanalisee)
  {
    jdoSetm_dateBanalisee(this, p_dateBanalisee);
  }
  
  public BigDecimal getMontantSJRSuiteRevision()
  {
    return jdoGetm_montantSJRSuiteRevision(this);
  }
  
  public final void setMontantSJRSuiteRevision(BigDecimal p_montantSJRSuiteRevision)
  {
    jdoSetm_montantSJRSuiteRevision(this, p_montantSJRSuiteRevision);
  }
  
  public int getAuMoinsUneActiviteConservee()
  {
    return jdoGetm_auMoinsUneActiviteConservee(this);
  }
  
  public final void setAuMoinsUneActiviteConservee(int p_auMoinsUneActiviteConservee)
  {
    jdoSetm_auMoinsUneActiviteConservee(this, p_auMoinsUneActiviteConservee);
  }
  
  public String getCodeTypeAction()
  {
    return jdoGetm_codeTypeAction(this);
  }
  
  public final void setCodeTypeAction(String p_codeTypeAction)
  {
    jdoSetm_codeTypeAction(this, p_codeTypeAction);
  }
  
  public int getCreationDALSuiteRejet()
  {
    return jdoGetm_creationDALSuiteRejet(this);
  }
  
  public final void setCreationDALSuiteRejet(int p_creationDALSuiteRejet)
  {
    jdoSetm_creationDALSuiteRejet(this, p_creationDALSuiteRejet);
  }
  
  public String getCodeTypeAttente()
  {
    return jdoGetm_codeTypeAttente(this);
  }
  
  public final void setCodeTypeAttente(String p_codeTypeAttente)
  {
    jdoSetm_codeTypeAttente(this, p_codeTypeAttente);
  }
  
  public Damj getDateFCT()
  {
    return jdoGetm_dateFCT(this);
  }
  
  public final void setDateFCT(Damj p_dateFCT)
  {
    jdoSetm_dateFCT(this, p_dateFCT);
  }
  
  public String getTypeExamenCreationDemande()
  {
    return jdoGetm_typeExamenCreationDemande(this);
  }
  
  public final void setTypeExamenCreationDemande(String p_typeExamenCreationDemande)
  {
    jdoSetm_typeExamenCreationDemande(this, p_typeExamenCreationDemande);
  }
  
  public BigDecimal getContributionNonPropositionCTP()
  {
    return jdoGetm_contributionNonPropositionCTP(this);
  }
  
  public final void setContributionNonPropositionCTP(BigDecimal p_contributionNonPropositionCTP)
  {
    jdoSetm_contributionNonPropositionCTP(this, p_contributionNonPropositionCTP);
  }
  
  public int getEstContribPreavis()
  {
    return jdoGetm_estContribPreavis(this);
  }
  
  public final void setEstContribPreavis(int p_estContribPreavis)
  {
    jdoSetm_estContribPreavis(this, p_estContribPreavis);
  }
  
  public int getEstContribDif()
  {
    return jdoGetm_estContribDif(this);
  }
  
  public final void setEstContribDif(int p_estContribDif)
  {
    jdoSetm_estContribDif(this, p_estContribDif);
  }
  
  public BigDecimal getMontantPreavisCR()
  {
    return jdoGetm_montantPreavisCR(this);
  }
  
  public final void setMontantPreavisCR(BigDecimal p_montantPreavisCR)
  {
    jdoSetm_montantPreavisCR(this, p_montantPreavisCR);
  }
  
  public BigDecimal getMontantFormationD()
  {
    return jdoGetm_montantFormationD(this);
  }
  
  public final void setMontantFormationD(BigDecimal p_montantFormationD)
  {
    jdoSetm_montantFormationD(this, p_montantFormationD);
  }
  
  public BigDecimal getNombreHeureUn()
  {
    return jdoGetm_nombreHeureUn(this);
  }
  
  public final void setNombreHeureUn(BigDecimal p_nombreHeureUn)
  {
    jdoSetm_nombreHeureUn(this, p_nombreHeureUn);
  }
  
  public BigDecimal getNombreHeureDeux()
  {
    return jdoGetm_nombreHeureDeux(this);
  }
  
  public final void setNombreHeureDeux(BigDecimal p_nombreHeureDeux)
  {
    jdoSetm_nombreHeureDeux(this, p_nombreHeureDeux);
  }
  
  public int getTopAppelContributions()
  {
    return jdoGetm_topAppelContributions(this);
  }
  
  public final void setTopAppelContributions(int p_topAppelContributions)
  {
    jdoSetm_topAppelContributions(this, p_topAppelContributions);
  }
  
  public BigDecimal getPlafondMensuelRessourcesAss()
  {
    return jdoGetm_plafondMensuelRessourcesAss(this);
  }
  
  public final void setPlafondMensuelRessourcesAss(BigDecimal p_plafondMensuelRessourcesAss)
  {
    jdoSetm_plafondMensuelRessourcesAss(this, p_plafondMensuelRessourcesAss);
  }
  
  public BigDecimal getNbEmploisSalariesRetenus()
  {
    return jdoGetm_nbEmploisSalariesRetenus(this);
  }
  
  public final void setNbEmploisSalariesRetenus(BigDecimal p_nbEmploisSalariesRetenus)
  {
    jdoSetm_nbEmploisSalariesRetenus(this, p_nbEmploisSalariesRetenus);
  }
  
  public BigDecimal getMontantBrutTranche2()
  {
    return jdoGetm_montantBrutTranche2(this);
  }
  
  public final void setMontantBrutTranche2(BigDecimal p_montantBrutTranche2)
  {
    jdoSetm_montantBrutTranche2(this, p_montantBrutTranche2);
  }
  
  public BigDecimal getMontantCrcTranche2()
  {
    return jdoGetm_montantCrcTranche2(this);
  }
  
  public final void setMontantCrcTranche2(BigDecimal p_montantCrcTranche2)
  {
    jdoSetm_montantCrcTranche2(this, p_montantCrcTranche2);
  }
  
  public int getDureeTranche2()
  {
    return jdoGetm_dureeTranche2(this);
  }
  
  public final void setDureeTranche2(int p_dureeTranche2)
  {
    jdoSetm_dureeTranche2(this, p_dureeTranche2);
  }
  
  public BigDecimal getMontantBrutTranche3()
  {
    return jdoGetm_montantBrutTranche3(this);
  }
  
  public final void setMontantBrutTranche3(BigDecimal p_montantBrutTranche3)
  {
    jdoSetm_montantBrutTranche3(this, p_montantBrutTranche3);
  }
  
  public BigDecimal getMontantCrcTranche3()
  {
    return jdoGetm_montantCrcTranche3(this);
  }
  
  public final void setMontantCrcTranche3(BigDecimal p_montantCrcTranche3)
  {
    jdoSetm_montantCrcTranche3(this, p_montantCrcTranche3);
  }
  
  public int getDureeTranche3()
  {
    return jdoGetm_dureeTranche3(this);
  }
  
  public final void setDureeTranche3(int p_dureeTranche3)
  {
    jdoSetm_dureeTranche3(this, p_dureeTranche3);
  }
  
  public String getValidationDAPE()
  {
    return jdoGetm_validationDAPE(this);
  }
  
  public final void setValidationDAPE(String p_validationDAPE)
  {
    jdoSetm_validationDAPE(this, p_validationDAPE);
  }
  
  public String getTypeActionReclassementAvant()
  {
    return jdoGetm_typeActionReclassementAvant(this);
  }
  
  public final void setTypeActionReclassementAvant(String p_typeActionReclassementAvant)
  {
    jdoSetm_typeActionReclassementAvant(this, p_typeActionReclassementAvant);
  }
  
  public String getTypeActionReclassementApres()
  {
    return jdoGetm_typeActionReclassementApres(this);
  }
  
  public final void setTypeActionReclassementApres(String p_typeActionReclassementApres)
  {
    jdoSetm_typeActionReclassementApres(this, p_typeActionReclassementApres);
  }
  
  public int getEstDerogatoire()
  {
    return jdoGetm_estDerogatoire(this);
  }
  
  public final void setEstDerogatoire(int p_estDerogatoire)
  {
    jdoSetm_estDerogatoire(this, p_estDerogatoire);
  }
  
  public BigDecimal getMontantForfaitUnitaireRepas()
  {
    return jdoGetm_montantForfaitUnitaireRepas(this);
  }
  
  public final void setMontantForfaitUnitaireRepas(BigDecimal p_montantForfaitUnitaireRepas)
  {
    jdoSetm_montantForfaitUnitaireRepas(this, p_montantForfaitUnitaireRepas);
  }
  
  public BigDecimal getMontantForfaitUnitaireHebergement()
  {
    return jdoGetm_montantForfaitUnitaireHebergement(this);
  }
  
  public final void setMontantForfaitUnitaireHebergement(BigDecimal p_montantForfaitUnitaireHebergement)
  {
    jdoSetm_montantForfaitUnitaireHebergement(this, p_montantForfaitUnitaireHebergement);
  }
  
  public BigDecimal getMontantIndiceKilometrique()
  {
    return jdoGetm_montantIndiceKilometrique(this);
  }
  
  public final void setMontantIndiceKilometrique(BigDecimal p_montantIndiceKilometrique)
  {
    jdoSetm_montantIndiceKilometrique(this, p_montantIndiceKilometrique);
  }
  
  public Damj getDateDepotAide()
  {
    return jdoGetm_dateDepotAide(this);
  }
  
  public final void setDateDepotAide(Damj p_dateDepotAide)
  {
    jdoSetm_dateDepotAide(this, p_dateDepotAide);
  }
  
  public int getAttenteValidationDAPE()
  {
    return jdoGetm_attenteValidationDAPE(this);
  }
  
  public final void setAttenteValidationDAPE(int p_attenteValidationDAPE)
  {
    jdoSetm_attenteValidationDAPE(this, p_attenteValidationDAPE);
  }
  
  public int getAttenteRetourJustificatif()
  {
    return jdoGetm_attenteRetourJustificatif(this);
  }
  
  public final void setAttenteRetourJustificatif(int p_attenteRetourJustificatif)
  {
    jdoSetm_attenteRetourJustificatif(this, p_attenteRetourJustificatif);
  }
  
  public Damj getDateRetourJustificatif()
  {
    return jdoGetm_dateRetourJustificatif(this);
  }
  
  public final void setDateRetourJustificatif(Damj p_dateRetourJustificatif)
  {
    jdoSetm_dateRetourJustificatif(this, p_dateRetourJustificatif);
  }
  
  public BigDecimal getNombreEnfantsTotal()
  {
    return jdoGetm_nombreEnfantsTotal(this);
  }
  
  public final void setNombreEnfantsTotal(BigDecimal p_nombreEnfantsTotal)
  {
    jdoSetm_nombreEnfantsTotal(this, p_nombreEnfantsTotal);
  }
  
  public String getCodeAffectation()
  {
    return jdoGetm_codeAffectation(this);
  }
  
  public final void setCodeAffectation(String p_codeAffectation)
  {
    jdoSetm_codeAffectation(this, p_codeAffectation);
  }
  
  public String getNumeroConventionGestion()
  {
    return jdoGetm_numeroConventionGestion(this);
  }
  
  public final void setNumeroConventionGestion(String p_numeroConventionGestion)
  {
    jdoSetm_numeroConventionGestion(this, p_numeroConventionGestion);
  }
  
  public BigDecimal getMontantBonAvant()
  {
    return jdoGetm_montantBonAvant(this);
  }
  
  public final void setMontantBonAvant(BigDecimal p_montantBonAvant)
  {
    jdoSetm_montantBonAvant(this, p_montantBonAvant);
  }
  
  public BigDecimal getMontantBonAvantDerogatoire()
  {
    return jdoGetm_montantBonAvantDerogatoire(this);
  }
  
  public final void setMontantBonAvantDerogatoire(BigDecimal p_montantBonAvantDerogatoire)
  {
    jdoSetm_montantBonAvantDerogatoire(this, p_montantBonAvantDerogatoire);
  }
  
  public String getTypeBonAvant()
  {
    return jdoGetm_typeBonAvant(this);
  }
  
  public final void setTypeBonAvant(String p_typeBonAvant)
  {
    jdoSetm_typeBonAvant(this, p_typeBonAvant);
  }
  
  public String getTypeBonAvantDerogatoire()
  {
    return jdoGetm_typeBonAvantDerogatoire(this);
  }
  
  public final void setTypeBonAvantDerogatoire(String p_typeBonAvantDerogatoire)
  {
    jdoSetm_typeBonAvantDerogatoire(this, p_typeBonAvantDerogatoire);
  }
  
  public BigDecimal getMontantBonApres()
  {
    return jdoGetm_montantBonApres(this);
  }
  
  public final void setMontantBonApres(BigDecimal p_montantBonApres)
  {
    jdoSetm_montantBonApres(this, p_montantBonApres);
  }
  
  public BigDecimal getMontantBonApresDerogatoire()
  {
    return jdoGetm_montantBonApresDerogatoire(this);
  }
  
  public final void setMontantBonApresDerogatoire(BigDecimal p_montantBonApresDerogatoire)
  {
    jdoSetm_montantBonApresDerogatoire(this, p_montantBonApresDerogatoire);
  }
  
  public String getTypeBonApres()
  {
    return jdoGetm_typeBonApres(this);
  }
  
  public final void setTypeBonApres(String p_typeBonApres)
  {
    jdoSetm_typeBonApres(this, p_typeBonApres);
  }
  
  public String getTypeBonApresDerogatoire()
  {
    return jdoGetm_typeBonApresDerogatoire(this);
  }
  
  public final void setTypeBonApresDerogatoire(String p_typeBonApresDerogatoire)
  {
    jdoSetm_typeBonApresDerogatoire(this, p_typeBonApresDerogatoire);
  }
  
  public int getObjectifLiquidation()
  {
    return jdoGetm_objectifLiquidation(this);
  }
  
  public final void setObjectifLiquidation(int p_objectifLiquidation)
  {
    jdoSetm_objectifLiquidation(this, p_objectifLiquidation);
  }
  
  public BigDecimal getDureePostPrime()
  {
    return jdoGetm_dureePostPrime(this);
  }
  
  public final void setDureePostPrime(BigDecimal p_dureePostPrime)
  {
    jdoSetm_dureePostPrime(this, p_dureePostPrime);
  }
  
  public String getIndicateurPremiereDemandePostPrime()
  {
    return jdoGetm_indicateurPremiereDemandePostPrime(this);
  }
  
  public final void setIndicateurPremiereDemandePostPrime(String p_indicateurPremiereDemandePostPrime)
  {
    jdoSetm_indicateurPremiereDemandePostPrime(this, p_indicateurPremiereDemandePostPrime);
  }
  
  public String getIndicateurDiminutionMontantCSP()
  {
    return jdoGetm_indicateurDiminutionMontantCSP(this);
  }
  
  public final void setIndicateurDiminutionMontantCSP(String p_indicateurDiminutionMontantCSP)
  {
    jdoSetm_indicateurDiminutionMontantCSP(this, p_indicateurDiminutionMontantCSP);
  }
  
  public String getIndicateurAllongementDureeCSP()
  {
    return jdoGetm_indicateurAllongementDureeCSP(this);
  }
  
  public final void setIndicateurAllongementDureeCSP(String p_indicateurAllongementDureeCSP)
  {
    jdoSetm_indicateurAllongementDureeCSP(this, p_indicateurAllongementDureeCSP);
  }
  
  public Damj getDateDepartDelai121j()
  {
    return jdoGetm_dateDepartDelai121j(this);
  }
  
  public final void setDateDepartDelai121j(Damj p_dateDepartDelai121j)
  {
    jdoSetm_dateDepartDelai121j(this, p_dateDepartDelai121j);
  }
  
  public Damj getDateDebutDernierDelaiAttente()
  {
    return jdoGetm_dateDebutDernierDelaiAttente(this);
  }
  
  public final void setDateDebutDernierDelaiAttente(Damj p_dateDebutDernierDelaiAttente)
  {
    jdoSetm_dateDebutDernierDelaiAttente(this, p_dateDebutDernierDelaiAttente);
  }
  
  public Damj getDateIDE()
  {
    return jdoGetm_dateIDE(this);
  }
  
  public final void setDateIDE(Damj p_dateIDE)
  {
    jdoSetm_dateIDE(this, p_dateIDE);
  }
  
  public Damj getDateFaitGenerateurDroitPrecedent()
  {
    return jdoGetm_dateFaitGenerateurDroitPrecedent(this);
  }
  
  public final void setDateFaitGenerateurDroitPrecedent(Damj p_dateFaitGenerateurDroitPrecedent)
  {
    jdoSetm_dateFaitGenerateurDroitPrecedent(this, p_dateFaitGenerateurDroitPrecedent);
  }
  
  public String getReglementApplicableDroit()
  {
    return jdoGetm_reglementApplicableDroit(this);
  }
  
  public final void setReglementApplicableDroit(String p_reglementApplicableDroit)
  {
    jdoSetm_reglementApplicableDroit(this, p_reglementApplicableDroit);
  }
  
  public int getDureeActiviteEmployeursRAC()
  {
    return jdoGetm_dureeActiviteEmployeursRAC(this);
  }
  
  public final void setDureeActiviteEmployeursRAC(int p_dureeActiviteEmployeursRAC)
  {
    jdoSetm_dureeActiviteEmployeursRAC(this, p_dureeActiviteEmployeursRAC);
  }
  
  public int getCoeffTPAppliqueRAC()
  {
    return jdoGetm_coeffTPAppliqueRAC(this);
  }
  
  public final void setCoeffTPAppliqueRAC(int p_coeffTPAppliqueRAC)
  {
    jdoSetm_coeffTPAppliqueRAC(this, p_coeffTPAppliqueRAC);
  }
  
  public int getDureeActiviteEmployeursSP()
  {
    return jdoGetm_dureeActiviteEmployeursSP(this);
  }
  
  public final void setDureeActiviteEmployeursSP(int p_dureeActiviteEmployeursSP)
  {
    jdoSetm_dureeActiviteEmployeursSP(this, p_dureeActiviteEmployeursSP);
  }
  
  public int getCoeffTPAppliqueSP()
  {
    return jdoGetm_coeffTPAppliqueSP(this);
  }
  
  public final void setCoeffTPAppliqueSP(int p_coeffTPAppliqueSP)
  {
    jdoSetm_coeffTPAppliqueSP(this, p_coeffTPAppliqueSP);
  }
  
  public int getTopDemandeASSSuiteDecheance()
  {
    return jdoGetm_topDemandeASSSuiteDecheance(this);
  }
  
  public final void setTopDemandeASSSuiteDecheance(int p_topDemandeASSSuiteDecheance)
  {
    jdoSetm_topDemandeASSSuiteDecheance(this, p_topDemandeASSSuiteDecheance);
  }
  
  public String getAttenteBlocageLiquidationAutoRepriseAss()
  {
    return jdoGetm_attenteBlocageLiquidationAutoRepriseAss(this);
  }
  
  public final void setAttenteBlocageLiquidationAutoRepriseAss(String p_attenteBlocageLiquidationAutoRepriseAss)
  {
    jdoSetm_attenteBlocageLiquidationAutoRepriseAss(this, p_attenteBlocageLiquidationAutoRepriseAss);
  }
  
  public String getAttenteNationaliteAValider()
  {
    return jdoGetm_attenteNationaliteAValider(this);
  }
  
  public final void setAttenteNationaliteAValider(String p_attenteNationaliteAValider)
  {
    jdoSetm_attenteNationaliteAValider(this, p_attenteNationaliteAValider);
  }
  
  public int getTopDetectionClauseRattrapage()
  {
    return jdoGetm_topDetectionClauseRattrapage(this);
  }
  
  public final void setTopDetectionClauseRattrapage(int p_topDetectionClauseRattrapage)
  {
    jdoSetm_topDetectionClauseRattrapage(this, p_topDetectionClauseRattrapage);
  }
  
  public int getTopSpectacle2016avantMepSI4()
  {
    return jdoGetm_topSpectacle2016avantMepSI4(this);
  }
  
  public final void setTopSpectacle2016avantMepSI4(int p_topSpectacle2016avantMepSI4)
  {
    jdoSetm_topSpectacle2016avantMepSI4(this, p_topSpectacle2016avantMepSI4);
  }
  
  public int getTopAreSpectacleEnCoursClauseRattrapage()
  {
    return jdoGetm_topAreSpectacleEnCoursClauseRattrapage(this);
  }
  
  public final void setTopAreSpectacleEnCoursClauseRattrapage(int p_topAreSpectacleEnCoursClauseRattrapage)
  {
    jdoSetm_topAreSpectacleEnCoursClauseRattrapage(this, p_topAreSpectacleEnCoursClauseRattrapage);
  }
  
  public BigDecimal getNombreJoursFranchiseCP()
  {
    return jdoGetm_nombreJoursFranchiseCP(this);
  }
  
  public final void setNombreJoursFranchiseCP(BigDecimal p_nombreJoursFranchiseCP)
  {
    jdoSetm_nombreJoursFranchiseCP(this, p_nombreJoursFranchiseCP);
  }
  
  public BigDecimal getNombreJoursFranchiseSalaire()
  {
    return jdoGetm_nombreJoursFranchiseSalaire(this);
  }
  
  public final void setNombreJoursFranchiseSalaire(BigDecimal p_nombreJoursFranchiseSalaire)
  {
    jdoSetm_nombreJoursFranchiseSalaire(this, p_nombreJoursFranchiseSalaire);
  }
  
  public int getFranchiseCpMensuelle()
  {
    return jdoGetm_franchiseCpMensuelle(this);
  }
  
  public final void setFranchiseCpMensuelle(int p_franchiseCpMensuelle)
  {
    jdoSetm_franchiseCpMensuelle(this, p_franchiseCpMensuelle);
  }
  
  public int getFranchiseSalaireMensuelle()
  {
    return jdoGetm_franchiseSalaireMensuelle(this);
  }
  
  public final void setFranchiseSalaireMensuelle(int p_franchiseSalaireMensuelle)
  {
    jdoSetm_franchiseSalaireMensuelle(this, p_franchiseSalaireMensuelle);
  }
  
  public BigDecimal getBaseCalculFranchiseCP()
  {
    return jdoGetm_baseCalculFranchiseCP(this);
  }
  
  public final void setBaseCalculFranchiseCP(BigDecimal p_baseCalculFranchiseCP)
  {
    jdoSetm_baseCalculFranchiseCP(this, p_baseCalculFranchiseCP);
  }
  
  public BigDecimal getBaseCalculFranchiseSalaire()
  {
    return jdoGetm_baseCalculFranchiseSalaire(this);
  }
  
  public final void setBaseCalculFranchiseSalaire(BigDecimal p_baseCalculFranchiseSalaire)
  {
    jdoSetm_baseCalculFranchiseSalaire(this, p_baseCalculFranchiseSalaire);
  }
  
  public int getAttenteIncoherenceSalaireNPDE()
  {
    return jdoGetm_attenteIncoherenceSalaireNPDE(this);
  }
  
  public final void setAttenteIncoherenceSalaireNPDE(int p_attenteIncoherenceSalaireNPDE)
  {
    jdoSetm_attenteIncoherenceSalaireNPDE(this, p_attenteIncoherenceSalaireNPDE);
  }
  
  public BigDecimal getIdentifiantPeriodeIncoherenceSalaireNPDE()
  {
    return jdoGetm_identifiantPeriodeIncoherenceSalaireNPDE(this);
  }
  
  public final void setIdentifiantPeriodeIncoherenceSalaireNPDE(BigDecimal p_identifiantPeriodeIncoherenceSalaireNPDE)
  {
    jdoSetm_identifiantPeriodeIncoherenceSalaireNPDE(this, p_identifiantPeriodeIncoherenceSalaireNPDE);
  }
  
  public int getEstPresencePNDS()
  {
    return jdoGetm_estPresencePNDS(this);
  }
  
  public final void setEstPresencePNDS(int p_estPresencePNDS)
  {
    jdoSetm_estPresencePNDS(this, p_estPresencePNDS);
  }
  
  public String getCodeSousProduitRejet()
  {
    return jdoGetm_codeSousProduitRejet(this);
  }
  
  public final void setCodeSousProduitRejet(String p_codeSousProduitRejet)
  {
    jdoSetm_codeSousProduitRejet(this, p_codeSousProduitRejet);
  }
  
  public boolean isPresenceDerniersSalaires()
  {
    return jdoGetm_presenceDerniersSalaires(this);
  }
  
  public final void setPresenceDerniersSalaires(boolean p_presenceDerniersSalaires)
  {
    jdoSetm_presenceDerniersSalaires(this, p_presenceDerniersSalaires);
  }
  
  public BigDecimal getNombreMoisPreavis()
  {
    return jdoGetm_nombreMoisPreavis(this);
  }
  
  public final void setNombreMoisPreavis(BigDecimal p_nombreMoisPreavis)
  {
    jdoSetm_nombreMoisPreavis(this, p_nombreMoisPreavis);
  }
  
  public BigDecimal getIdentifiantPeriodeIncoherenceRessortissant()
  {
    return jdoGetm_identifiantPeriodeIncoherenceRessortissant(this);
  }
  
  public final void setIdentifiantPeriodeIncoherenceRessortissant(BigDecimal p_identifiantPeriodeIncoherenceRessortissant)
  {
    jdoSetm_identifiantPeriodeIncoherenceRessortissant(this, p_identifiantPeriodeIncoherenceRessortissant);
  }
  
  public int getDureeAllongementArefPossible()
  {
    return jdoGetm_dureeAllongementArefPossible(this);
  }
  
  public final void setDureeAllongementArefPossible(int p_dureeAllongementArefPossible)
  {
    jdoSetm_dureeAllongementArefPossible(this, p_dureeAllongementArefPossible);
  }
  
  public int getDureeAllongementArefRealisee()
  {
    return jdoGetm_dureeAllongementArefRealisee(this);
  }
  
  public final void setDureeAllongementArefRealisee(int p_dureeAllongementArefRealisee)
  {
    jdoSetm_dureeAllongementArefRealisee(this, p_dureeAllongementArefRealisee);
  }
  
  public BigDecimal getCoefficientReducteurSJR()
  {
    return jdoGetm_coefficientReducteurSJR(this);
  }
  
  public final void setCoefficientReducteurSJR(BigDecimal p_coefficientReducteurSJR)
  {
    jdoSetm_coefficientReducteurSJR(this, p_coefficientReducteurSJR);
  }
  
  public BigDecimal getPlancherCoefReducteur()
  {
    return jdoGetm_plancherCoefReducteur(this);
  }
  
  public final void setPlancherCoefReducteur(BigDecimal p_plancherCoefReducteur)
  {
    jdoSetm_plancherCoefReducteur(this, p_plancherCoefReducteur);
  }
  
  public String getTopPresenceDiffereARCE()
  {
    return jdoGetm_topPresenceDiffereARCE(this);
  }
  
  public final void setTopPresenceDiffereARCE(String p_topPresenceDiffereARCE)
  {
    jdoSetm_topPresenceDiffereARCE(this, p_topPresenceDiffereARCE);
  }
  
  public BigDecimal getDiviseurIslr()
  {
    return jdoGetm_diviseurIslr(this);
  }
  
  public final void setDiviseurIslr(BigDecimal p_diviseurIslr)
  {
    jdoSetm_diviseurIslr(this, p_diviseurIslr);
  }
  
  public int getNaturePeriodeSuspensive()
  {
    return jdoGetm_naturePeriodeSuspensive(this);
  }
  
  public final void setNaturePeriodeSuspensive(int p_naturePeriodeSuspensive)
  {
    jdoSetm_naturePeriodeSuspensive(this, p_naturePeriodeSuspensive);
  }
  
  public Damj getDateFinPeriodeSuspensive()
  {
    return jdoGetm_dateFinPeriodeSuspensive(this);
  }
  
  public final void setDateFinPeriodeSuspensive(Damj p_dateFinPeriodeSuspensive)
  {
    jdoSetm_dateFinPeriodeSuspensive(this, p_dateFinPeriodeSuspensive);
  }
  
  static
  {
    JDOImplHelper.registerClass(DecisionPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new DecisionPC());
  }
  
  protected static final String jdoGetm_identifiantEvenement(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantEvenement;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_identifiantEvenement;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 0, m_identifiantEvenement);
    }
    return m_identifiantEvenement;
  }
  
  protected static final int jdoGetm_etatDemande(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_etatDemande;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_etatDemande;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 1, m_etatDemande);
    }
    return m_etatDemande;
  }
  
  protected static final String jdoGetm_codeSegment(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeSegment;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_codeSegment;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 2, m_codeSegment);
    }
    return m_codeSegment;
  }
  
  protected static final String jdoGetm_referenceExterneDemande(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_referenceExterneDemande;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_referenceExterneDemande;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 3, m_referenceExterneDemande);
    }
    return m_referenceExterneDemande;
  }
  
  protected static final String jdoGetm_gamme(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_gamme;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_gamme;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 4, m_gamme);
    }
    return m_gamme;
  }
  
  protected static final String jdoGetm_ligne(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_ligne;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_ligne;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 5, m_ligne);
    }
    return m_ligne;
  }
  
  protected static final int jdoGetm_typeEchecExamen(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeEchecExamen;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_typeEchecExamen;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 6, m_typeEchecExamen);
    }
    return m_typeEchecExamen;
  }
  
  protected static final int jdoGetm_motifEchec(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_motifEchec;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_motifEchec;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 7, m_motifEchec);
    }
    return m_motifEchec;
  }
  
  protected static final String jdoGetm_classementAdministratif(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_classementAdministratif;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_classementAdministratif;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 8, m_classementAdministratif);
    }
    return m_classementAdministratif;
  }
  
  protected static final int jdoGetm_motifReexamenPrincipal(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_motifReexamenPrincipal;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 9)) {
        return m_motifReexamenPrincipal;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 9, m_motifReexamenPrincipal);
    }
    return m_motifReexamenPrincipal;
  }
  
  protected static final int jdoGetm_identifiantOd(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantOd;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 10)) {
        return m_identifiantOd;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 10, m_identifiantOd);
    }
    return m_identifiantOd;
  }
  
  protected static final int jdoGetm_identifiantReprise(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantReprise;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 11)) {
        return m_identifiantReprise;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 11, m_identifiantReprise);
    }
    return m_identifiantReprise;
  }
  
  protected static final String jdoGetm_produit(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_produit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 12)) {
        return m_produit;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 12, m_produit);
    }
    return m_produit;
  }
  
  protected static final int jdoGetm_natureDecision(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_natureDecision;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 13)) {
        return m_natureDecision;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 13, m_natureDecision);
    }
    return m_natureDecision;
  }
  
  protected static final int jdoGetm_origineDecision(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_origineDecision;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 14)) {
        return m_origineDecision;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 14, m_origineDecision);
    }
    return m_origineDecision;
  }
  
  protected static final int jdoGetm_topContribSupplementaire(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_topContribSupplementaire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 15)) {
        return m_topContribSupplementaire;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 15, m_topContribSupplementaire);
    }
    return m_topContribSupplementaire;
  }
  
  protected static final int jdoGetm_topContribSpecifique(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_topContribSpecifique;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 16)) {
        return m_topContribSpecifique;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 16, m_topContribSpecifique);
    }
    return m_topContribSpecifique;
  }
  
  protected static final int jdoGetm_topEchecDemandeExpresseEnCoursIndemnisation(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_topEchecDemandeExpresseEnCoursIndemnisation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 17)) {
        return m_topEchecDemandeExpresseEnCoursIndemnisation;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 17, m_topEchecDemandeExpresseEnCoursIndemnisation);
    }
    return m_topEchecDemandeExpresseEnCoursIndemnisation;
  }
  
  protected static final int jdoGetm_topRejetASUReliquatASS(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_topRejetASUReliquatASS;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 18)) {
        return m_topRejetASUReliquatASS;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 18, m_topRejetASUReliquatASS);
    }
    return m_topRejetASUReliquatASS;
  }
  
  protected static final int jdoGetm_topRejetASUCpaASS(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_topRejetASUCpaASS;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 19)) {
        return m_topRejetASUCpaASS;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 19, m_topRejetASUCpaASS);
    }
    return m_topRejetASUCpaASS;
  }
  
  protected static final int jdoGetm_topDroitOptionAss(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_topDroitOptionAss;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 20)) {
        return m_topDroitOptionAss;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 20, m_topDroitOptionAss);
    }
    return m_topDroitOptionAss;
  }
  
  protected static final String jdoGetm_competenceAdministrative(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_competenceAdministrative;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 21)) {
        return m_competenceAdministrative;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 21, m_competenceAdministrative);
    }
    return m_competenceAdministrative;
  }
  
  protected static final int jdoGetm_indicateurNotificationCourrier(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_indicateurNotificationCourrier;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 22)) {
        return m_indicateurNotificationCourrier;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 22, m_indicateurNotificationCourrier);
    }
    return m_indicateurNotificationCourrier;
  }
  
  protected static final BigDecimal jdoGetm_montantAllocationJournalierBrutCourrier(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantAllocationJournalierBrutCourrier;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 23)) {
        return m_montantAllocationJournalierBrutCourrier;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 23, m_montantAllocationJournalierBrutCourrier);
    }
    return m_montantAllocationJournalierBrutCourrier;
  }
  
  protected static final BigDecimal jdoGetm_montantAllocationJournalierNetCourrier(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantAllocationJournalierNetCourrier;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 24)) {
        return m_montantAllocationJournalierNetCourrier;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 24, m_montantAllocationJournalierNetCourrier);
    }
    return m_montantAllocationJournalierNetCourrier;
  }
  
  protected static final BigDecimal jdoGetm_montantCrcCourrier(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantCrcCourrier;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 25)) {
        return m_montantCrcCourrier;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 25, m_montantCrcCourrier);
    }
    return m_montantCrcCourrier;
  }
  
  protected static final int jdoGetm_dureeTheoriqueDroitServiCourrier(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeTheoriqueDroitServiCourrier;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 26)) {
        return m_dureeTheoriqueDroitServiCourrier;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 26, m_dureeTheoriqueDroitServiCourrier);
    }
    return m_dureeTheoriqueDroitServiCourrier;
  }
  
  protected static final int jdoGetm_dureeRenouvellementAreCourrier(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeRenouvellementAreCourrier;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 27)) {
        return m_dureeRenouvellementAreCourrier;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 27, m_dureeRenouvellementAreCourrier);
    }
    return m_dureeRenouvellementAreCourrier;
  }
  
  protected static final BigDecimal jdoGetm_montantPensionInvaliditeAreCourrier(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantPensionInvaliditeAreCourrier;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 28)) {
        return m_montantPensionInvaliditeAreCourrier;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 28, m_montantPensionInvaliditeAreCourrier);
    }
    return m_montantPensionInvaliditeAreCourrier;
  }
  
  protected static final BigDecimal jdoGetm_montantArePourAerComplementCourrier(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantArePourAerComplementCourrier;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 29)) {
        return m_montantArePourAerComplementCourrier;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 29, m_montantArePourAerComplementCourrier);
    }
    return m_montantArePourAerComplementCourrier;
  }
  
  protected static final BigDecimal jdoGetm_montantForfaitaireMensuelRpsCourrier(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantForfaitaireMensuelRpsCourrier;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 30)) {
        return m_montantForfaitaireMensuelRpsCourrier;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 30, m_montantForfaitaireMensuelRpsCourrier);
    }
    return m_montantForfaitaireMensuelRpsCourrier;
  }
  
  protected static final int jdoGetm_identifiantActionFormation(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantActionFormation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 31)) {
        return m_identifiantActionFormation;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 31, m_identifiantActionFormation);
    }
    return m_identifiantActionFormation;
  }
  
  protected static final BigDecimal jdoGetm_fraisFthrAvant(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_fraisFthrAvant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 32)) {
        return m_fraisFthrAvant;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 32, m_fraisFthrAvant);
    }
    return m_fraisFthrAvant;
  }
  
  protected static final BigDecimal jdoGetm_fraisFpoAvant(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_fraisFpoAvant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 33)) {
        return m_fraisFpoAvant;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 33, m_fraisFpoAvant);
    }
    return m_fraisFpoAvant;
  }
  
  protected static final BigDecimal jdoGetm_fraisFthrApres(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_fraisFthrApres;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 34)) {
        return m_fraisFthrApres;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 34, m_fraisFthrApres);
    }
    return m_fraisFthrApres;
  }
  
  protected static final BigDecimal jdoGetm_fraisFpoApres(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_fraisFpoApres;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 35)) {
        return m_fraisFpoApres;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 35, m_fraisFpoApres);
    }
    return m_fraisFpoApres;
  }
  
  protected static final int jdoGetm_exerciceAvant(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_exerciceAvant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 36)) {
        return m_exerciceAvant;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 36, m_exerciceAvant);
    }
    return m_exerciceAvant;
  }
  
  protected static final int jdoGetm_exerciceApres(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_exerciceApres;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 37)) {
        return m_exerciceApres;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 37, m_exerciceApres);
    }
    return m_exerciceApres;
  }
  
  protected static final int jdoGetm_statutAvant(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutAvant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 38)) {
        return m_statutAvant;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 38, m_statutAvant);
    }
    return m_statutAvant;
  }
  
  protected static final int jdoGetm_statutApres(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutApres;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 39)) {
        return m_statutApres;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 39, m_statutApres);
    }
    return m_statutApres;
  }
  
  protected static final int jdoGetm_topAffDerogatoire(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_topAffDerogatoire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 40)) {
        return m_topAffDerogatoire;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 40, m_topAffDerogatoire);
    }
    return m_topAffDerogatoire;
  }
  
  protected static final String jdoGetm_libelleEmployeur(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_libelleEmployeur;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 41)) {
        return m_libelleEmployeur;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 41, m_libelleEmployeur);
    }
    return m_libelleEmployeur;
  }
  
  protected static final int jdoGetm_motifRejet(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_motifRejet;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 42)) {
        return m_motifRejet;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 42, m_motifRejet);
    }
    return m_motifRejet;
  }
  
  protected static final Damj jdoGetm_dateTraitement(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateTraitement;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 43)) {
        return m_dateTraitement;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 43, m_dateTraitement);
    }
    return m_dateTraitement;
  }
  
  protected static final BigDecimal jdoGetm_montantSJC(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantSJC;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 44)) {
        return m_montantSJC;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 44, m_montantSJC);
    }
    return m_montantSJC;
  }
  
  protected static final BigDecimal jdoGetm_montantSJCMax(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantSJCMax;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 45)) {
        return m_montantSJCMax;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 45, m_montantSJCMax);
    }
    return m_montantSJCMax;
  }
  
  protected static final BigDecimal jdoGetm_montantAllocation(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantAllocation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 46)) {
        return m_montantAllocation;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 46, m_montantAllocation);
    }
    return m_montantAllocation;
  }
  
  protected static final BigDecimal jdoGetm_montantAllocationUn(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantAllocationUn;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 47)) {
        return m_montantAllocationUn;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 47, m_montantAllocationUn);
    }
    return m_montantAllocationUn;
  }
  
  protected static final BigDecimal jdoGetm_montantAllocationDeux(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantAllocationDeux;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 48)) {
        return m_montantAllocationDeux;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 48, m_montantAllocationDeux);
    }
    return m_montantAllocationDeux;
  }
  
  protected static final int jdoGetm_topCaisseInconnue(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_topCaisseInconnue;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 49)) {
        return m_topCaisseInconnue;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 49, m_topCaisseInconnue);
    }
    return m_topCaisseInconnue;
  }
  
  protected static final int jdoGetm_dureeImputationAideSurDroit(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeImputationAideSurDroit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 50)) {
        return m_dureeImputationAideSurDroit;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 50, m_dureeImputationAideSurDroit);
    }
    return m_dureeImputationAideSurDroit;
  }
  
  protected static final String jdoGetm_typeAide(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeAide;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 51)) {
        return m_typeAide;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 51, m_typeAide);
    }
    return m_typeAide;
  }
  
  protected static final int jdoGetm_topIndividuStable(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_topIndividuStable;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 52)) {
        return m_topIndividuStable;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 52, m_topIndividuStable);
    }
    return m_topIndividuStable;
  }
  
  protected static final String jdoGetm_typeExamen(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeExamen;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 53)) {
        return m_typeExamen;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 53, m_typeExamen);
    }
    return m_typeExamen;
  }
  
  protected static final String jdoGetm_situationParticuliere(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_situationParticuliere;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 54)) {
        return m_situationParticuliere;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 54, m_situationParticuliere);
    }
    return m_situationParticuliere;
  }
  
  protected static final boolean jdoGetm_investigationFraude(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_investigationFraude;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 55)) {
        return m_investigationFraude;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 55, m_investigationFraude);
    }
    return m_investigationFraude;
  }
  
  protected static final String jdoGetm_codeSousProduit(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeSousProduit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 56)) {
        return m_codeSousProduit;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 56, m_codeSousProduit);
    }
    return m_codeSousProduit;
  }
  
  protected static final Damj jdoGetm_dateBanalisee(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateBanalisee;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 57)) {
        return m_dateBanalisee;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 57, m_dateBanalisee);
    }
    return m_dateBanalisee;
  }
  
  protected static final BigDecimal jdoGetm_montantSJRSuiteRevision(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantSJRSuiteRevision;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 58)) {
        return m_montantSJRSuiteRevision;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 58, m_montantSJRSuiteRevision);
    }
    return m_montantSJRSuiteRevision;
  }
  
  protected static final int jdoGetm_auMoinsUneActiviteConservee(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_auMoinsUneActiviteConservee;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 59)) {
        return m_auMoinsUneActiviteConservee;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 59, m_auMoinsUneActiviteConservee);
    }
    return m_auMoinsUneActiviteConservee;
  }
  
  protected static final String jdoGetm_codeTypeAction(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeTypeAction;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 60)) {
        return m_codeTypeAction;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 60, m_codeTypeAction);
    }
    return m_codeTypeAction;
  }
  
  protected static final int jdoGetm_creationDALSuiteRejet(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_creationDALSuiteRejet;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 61)) {
        return m_creationDALSuiteRejet;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 61, m_creationDALSuiteRejet);
    }
    return m_creationDALSuiteRejet;
  }
  
  protected static final String jdoGetm_codeTypeAttente(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeTypeAttente;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 62)) {
        return m_codeTypeAttente;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 62, m_codeTypeAttente);
    }
    return m_codeTypeAttente;
  }
  
  protected static final Damj jdoGetm_dateFCT(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFCT;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 63)) {
        return m_dateFCT;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 63, m_dateFCT);
    }
    return m_dateFCT;
  }
  
  protected static final String jdoGetm_typeExamenCreationDemande(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeExamenCreationDemande;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 64)) {
        return m_typeExamenCreationDemande;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 64, m_typeExamenCreationDemande);
    }
    return m_typeExamenCreationDemande;
  }
  
  protected static final BigDecimal jdoGetm_contributionNonPropositionCTP(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_contributionNonPropositionCTP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 65)) {
        return m_contributionNonPropositionCTP;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 65, m_contributionNonPropositionCTP);
    }
    return m_contributionNonPropositionCTP;
  }
  
  protected static final int jdoGetm_estContribPreavis(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estContribPreavis;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 66)) {
        return m_estContribPreavis;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 66, m_estContribPreavis);
    }
    return m_estContribPreavis;
  }
  
  protected static final int jdoGetm_estContribDif(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estContribDif;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 67)) {
        return m_estContribDif;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 67, m_estContribDif);
    }
    return m_estContribDif;
  }
  
  protected static final BigDecimal jdoGetm_montantPreavisCR(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantPreavisCR;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 68)) {
        return m_montantPreavisCR;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 68, m_montantPreavisCR);
    }
    return m_montantPreavisCR;
  }
  
  protected static final BigDecimal jdoGetm_montantFormationD(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantFormationD;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 69)) {
        return m_montantFormationD;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 69, m_montantFormationD);
    }
    return m_montantFormationD;
  }
  
  protected static final BigDecimal jdoGetm_nombreHeureUn(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nombreHeureUn;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 70)) {
        return m_nombreHeureUn;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 70, m_nombreHeureUn);
    }
    return m_nombreHeureUn;
  }
  
  protected static final BigDecimal jdoGetm_nombreHeureDeux(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nombreHeureDeux;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 71)) {
        return m_nombreHeureDeux;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 71, m_nombreHeureDeux);
    }
    return m_nombreHeureDeux;
  }
  
  protected static final int jdoGetm_topAppelContributions(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_topAppelContributions;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 72)) {
        return m_topAppelContributions;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 72, m_topAppelContributions);
    }
    return m_topAppelContributions;
  }
  
  protected static final BigDecimal jdoGetm_plafondMensuelRessourcesAss(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_plafondMensuelRessourcesAss;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 73)) {
        return m_plafondMensuelRessourcesAss;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 73, m_plafondMensuelRessourcesAss);
    }
    return m_plafondMensuelRessourcesAss;
  }
  
  protected static final BigDecimal jdoGetm_nbEmploisSalariesRetenus(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbEmploisSalariesRetenus;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 74)) {
        return m_nbEmploisSalariesRetenus;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 74, m_nbEmploisSalariesRetenus);
    }
    return m_nbEmploisSalariesRetenus;
  }
  
  protected static final BigDecimal jdoGetm_montantBrutTranche2(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantBrutTranche2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 75)) {
        return m_montantBrutTranche2;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 75, m_montantBrutTranche2);
    }
    return m_montantBrutTranche2;
  }
  
  protected static final BigDecimal jdoGetm_montantCrcTranche2(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantCrcTranche2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 76)) {
        return m_montantCrcTranche2;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 76, m_montantCrcTranche2);
    }
    return m_montantCrcTranche2;
  }
  
  protected static final int jdoGetm_dureeTranche2(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeTranche2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 77)) {
        return m_dureeTranche2;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 77, m_dureeTranche2);
    }
    return m_dureeTranche2;
  }
  
  protected static final BigDecimal jdoGetm_montantBrutTranche3(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantBrutTranche3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 78)) {
        return m_montantBrutTranche3;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 78, m_montantBrutTranche3);
    }
    return m_montantBrutTranche3;
  }
  
  protected static final BigDecimal jdoGetm_montantCrcTranche3(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantCrcTranche3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 79)) {
        return m_montantCrcTranche3;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 79, m_montantCrcTranche3);
    }
    return m_montantCrcTranche3;
  }
  
  protected static final int jdoGetm_dureeTranche3(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeTranche3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 80)) {
        return m_dureeTranche3;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 80, m_dureeTranche3);
    }
    return m_dureeTranche3;
  }
  
  protected static final String jdoGetm_validationDAPE(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_validationDAPE;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 81)) {
        return m_validationDAPE;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 81, m_validationDAPE);
    }
    return m_validationDAPE;
  }
  
  protected static final String jdoGetm_typeActionReclassementAvant(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeActionReclassementAvant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 82)) {
        return m_typeActionReclassementAvant;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 82, m_typeActionReclassementAvant);
    }
    return m_typeActionReclassementAvant;
  }
  
  protected static final String jdoGetm_typeActionReclassementApres(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeActionReclassementApres;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 83)) {
        return m_typeActionReclassementApres;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 83, m_typeActionReclassementApres);
    }
    return m_typeActionReclassementApres;
  }
  
  protected static final int jdoGetm_estDerogatoire(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estDerogatoire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 84)) {
        return m_estDerogatoire;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 84, m_estDerogatoire);
    }
    return m_estDerogatoire;
  }
  
  protected static final BigDecimal jdoGetm_montantForfaitUnitaireRepas(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantForfaitUnitaireRepas;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 85)) {
        return m_montantForfaitUnitaireRepas;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 85, m_montantForfaitUnitaireRepas);
    }
    return m_montantForfaitUnitaireRepas;
  }
  
  protected static final BigDecimal jdoGetm_montantForfaitUnitaireHebergement(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantForfaitUnitaireHebergement;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 86)) {
        return m_montantForfaitUnitaireHebergement;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 86, m_montantForfaitUnitaireHebergement);
    }
    return m_montantForfaitUnitaireHebergement;
  }
  
  protected static final BigDecimal jdoGetm_montantIndiceKilometrique(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantIndiceKilometrique;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 87)) {
        return m_montantIndiceKilometrique;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 87, m_montantIndiceKilometrique);
    }
    return m_montantIndiceKilometrique;
  }
  
  protected static final Damj jdoGetm_dateDepotAide(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDepotAide;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 88)) {
        return m_dateDepotAide;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 88, m_dateDepotAide);
    }
    return m_dateDepotAide;
  }
  
  protected static final int jdoGetm_attenteValidationDAPE(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_attenteValidationDAPE;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 89)) {
        return m_attenteValidationDAPE;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 89, m_attenteValidationDAPE);
    }
    return m_attenteValidationDAPE;
  }
  
  protected static final int jdoGetm_attenteRetourJustificatif(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_attenteRetourJustificatif;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 90)) {
        return m_attenteRetourJustificatif;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 90, m_attenteRetourJustificatif);
    }
    return m_attenteRetourJustificatif;
  }
  
  protected static final Damj jdoGetm_dateRetourJustificatif(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateRetourJustificatif;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 91)) {
        return m_dateRetourJustificatif;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 91, m_dateRetourJustificatif);
    }
    return m_dateRetourJustificatif;
  }
  
  private static final BigDecimal jdoGetm_nombreEnfantsTotal(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nombreEnfantsTotal;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 92)) {
        return m_nombreEnfantsTotal;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 92, m_nombreEnfantsTotal);
    }
    return m_nombreEnfantsTotal;
  }
  
  private static final String jdoGetm_codeAffectation(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeAffectation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 93)) {
        return m_codeAffectation;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 93, m_codeAffectation);
    }
    return m_codeAffectation;
  }
  
  private static final String jdoGetm_numeroConventionGestion(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_numeroConventionGestion;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 94)) {
        return m_numeroConventionGestion;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 94, m_numeroConventionGestion);
    }
    return m_numeroConventionGestion;
  }
  
  private static final BigDecimal jdoGetm_montantBonAvant(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantBonAvant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 95)) {
        return m_montantBonAvant;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 95, m_montantBonAvant);
    }
    return m_montantBonAvant;
  }
  
  private static final BigDecimal jdoGetm_montantBonAvantDerogatoire(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantBonAvantDerogatoire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 96)) {
        return m_montantBonAvantDerogatoire;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 96, m_montantBonAvantDerogatoire);
    }
    return m_montantBonAvantDerogatoire;
  }
  
  private static final String jdoGetm_typeBonAvant(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeBonAvant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 97)) {
        return m_typeBonAvant;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 97, m_typeBonAvant);
    }
    return m_typeBonAvant;
  }
  
  private static final String jdoGetm_typeBonAvantDerogatoire(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeBonAvantDerogatoire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 98)) {
        return m_typeBonAvantDerogatoire;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 98, m_typeBonAvantDerogatoire);
    }
    return m_typeBonAvantDerogatoire;
  }
  
  private static final BigDecimal jdoGetm_montantBonApres(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantBonApres;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 99)) {
        return m_montantBonApres;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 99, m_montantBonApres);
    }
    return m_montantBonApres;
  }
  
  private static final BigDecimal jdoGetm_montantBonApresDerogatoire(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantBonApresDerogatoire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 100)) {
        return m_montantBonApresDerogatoire;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 100, m_montantBonApresDerogatoire);
    }
    return m_montantBonApresDerogatoire;
  }
  
  private static final String jdoGetm_typeBonApres(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeBonApres;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 101)) {
        return m_typeBonApres;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 101, m_typeBonApres);
    }
    return m_typeBonApres;
  }
  
  private static final String jdoGetm_typeBonApresDerogatoire(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeBonApresDerogatoire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 102)) {
        return m_typeBonApresDerogatoire;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 102, m_typeBonApresDerogatoire);
    }
    return m_typeBonApresDerogatoire;
  }
  
  private static final int jdoGetm_objectifLiquidation(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_objectifLiquidation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 103)) {
        return m_objectifLiquidation;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 103, m_objectifLiquidation);
    }
    return m_objectifLiquidation;
  }
  
  private static final BigDecimal jdoGetm_dureePostPrime(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureePostPrime;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 104)) {
        return m_dureePostPrime;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 104, m_dureePostPrime);
    }
    return m_dureePostPrime;
  }
  
  private static final String jdoGetm_indicateurPremiereDemandePostPrime(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_indicateurPremiereDemandePostPrime;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 105)) {
        return m_indicateurPremiereDemandePostPrime;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 105, m_indicateurPremiereDemandePostPrime);
    }
    return m_indicateurPremiereDemandePostPrime;
  }
  
  private static final String jdoGetm_indicateurDiminutionMontantCSP(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_indicateurDiminutionMontantCSP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 106)) {
        return m_indicateurDiminutionMontantCSP;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 106, m_indicateurDiminutionMontantCSP);
    }
    return m_indicateurDiminutionMontantCSP;
  }
  
  private static final String jdoGetm_indicateurAllongementDureeCSP(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_indicateurAllongementDureeCSP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 107)) {
        return m_indicateurAllongementDureeCSP;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 107, m_indicateurAllongementDureeCSP);
    }
    return m_indicateurAllongementDureeCSP;
  }
  
  private static final Damj jdoGetm_dateDepartDelai121j(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDepartDelai121j;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 108)) {
        return m_dateDepartDelai121j;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 108, m_dateDepartDelai121j);
    }
    return m_dateDepartDelai121j;
  }
  
  private static final Damj jdoGetm_dateDebutDernierDelaiAttente(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebutDernierDelaiAttente;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 109)) {
        return m_dateDebutDernierDelaiAttente;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 109, m_dateDebutDernierDelaiAttente);
    }
    return m_dateDebutDernierDelaiAttente;
  }
  
  private static final Damj jdoGetm_dateIDE(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateIDE;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 110)) {
        return m_dateIDE;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 110, m_dateIDE);
    }
    return m_dateIDE;
  }
  
  private static final Damj jdoGetm_dateFaitGenerateurDroitPrecedent(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFaitGenerateurDroitPrecedent;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 111)) {
        return m_dateFaitGenerateurDroitPrecedent;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 111, m_dateFaitGenerateurDroitPrecedent);
    }
    return m_dateFaitGenerateurDroitPrecedent;
  }
  
  private static final String jdoGetm_reglementApplicableDroit(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reglementApplicableDroit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 112)) {
        return m_reglementApplicableDroit;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 112, m_reglementApplicableDroit);
    }
    return m_reglementApplicableDroit;
  }
  
  private static final int jdoGetm_dureeActiviteEmployeursRAC(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeActiviteEmployeursRAC;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 113)) {
        return m_dureeActiviteEmployeursRAC;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 113, m_dureeActiviteEmployeursRAC);
    }
    return m_dureeActiviteEmployeursRAC;
  }
  
  private static final int jdoGetm_coeffTPAppliqueRAC(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_coeffTPAppliqueRAC;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 114)) {
        return m_coeffTPAppliqueRAC;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 114, m_coeffTPAppliqueRAC);
    }
    return m_coeffTPAppliqueRAC;
  }
  
  private static final int jdoGetm_dureeActiviteEmployeursSP(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeActiviteEmployeursSP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 115)) {
        return m_dureeActiviteEmployeursSP;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 115, m_dureeActiviteEmployeursSP);
    }
    return m_dureeActiviteEmployeursSP;
  }
  
  private static final int jdoGetm_coeffTPAppliqueSP(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_coeffTPAppliqueSP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 116)) {
        return m_coeffTPAppliqueSP;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 116, m_coeffTPAppliqueSP);
    }
    return m_coeffTPAppliqueSP;
  }
  
  private static final int jdoGetm_topDemandeASSSuiteDecheance(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_topDemandeASSSuiteDecheance;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 117)) {
        return m_topDemandeASSSuiteDecheance;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 117, m_topDemandeASSSuiteDecheance);
    }
    return m_topDemandeASSSuiteDecheance;
  }
  
  private static final String jdoGetm_attenteBlocageLiquidationAutoRepriseAss(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_attenteBlocageLiquidationAutoRepriseAss;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 118)) {
        return m_attenteBlocageLiquidationAutoRepriseAss;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 118, m_attenteBlocageLiquidationAutoRepriseAss);
    }
    return m_attenteBlocageLiquidationAutoRepriseAss;
  }
  
  private static final String jdoGetm_attenteNationaliteAValider(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_attenteNationaliteAValider;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 119)) {
        return m_attenteNationaliteAValider;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 119, m_attenteNationaliteAValider);
    }
    return m_attenteNationaliteAValider;
  }
  
  private static final int jdoGetm_topDetectionClauseRattrapage(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_topDetectionClauseRattrapage;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 120)) {
        return m_topDetectionClauseRattrapage;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 120, m_topDetectionClauseRattrapage);
    }
    return m_topDetectionClauseRattrapage;
  }
  
  private static final int jdoGetm_topSpectacle2016avantMepSI4(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_topSpectacle2016avantMepSI4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 121)) {
        return m_topSpectacle2016avantMepSI4;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 121, m_topSpectacle2016avantMepSI4);
    }
    return m_topSpectacle2016avantMepSI4;
  }
  
  private static final int jdoGetm_topAreSpectacleEnCoursClauseRattrapage(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_topAreSpectacleEnCoursClauseRattrapage;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 122)) {
        return m_topAreSpectacleEnCoursClauseRattrapage;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 122, m_topAreSpectacleEnCoursClauseRattrapage);
    }
    return m_topAreSpectacleEnCoursClauseRattrapage;
  }
  
  private static final BigDecimal jdoGetm_nombreJoursFranchiseCP(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nombreJoursFranchiseCP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 123)) {
        return m_nombreJoursFranchiseCP;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 123, m_nombreJoursFranchiseCP);
    }
    return m_nombreJoursFranchiseCP;
  }
  
  private static final BigDecimal jdoGetm_nombreJoursFranchiseSalaire(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nombreJoursFranchiseSalaire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 124)) {
        return m_nombreJoursFranchiseSalaire;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 124, m_nombreJoursFranchiseSalaire);
    }
    return m_nombreJoursFranchiseSalaire;
  }
  
  private static final int jdoGetm_franchiseCpMensuelle(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_franchiseCpMensuelle;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 125)) {
        return m_franchiseCpMensuelle;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 125, m_franchiseCpMensuelle);
    }
    return m_franchiseCpMensuelle;
  }
  
  private static final int jdoGetm_franchiseSalaireMensuelle(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_franchiseSalaireMensuelle;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 126)) {
        return m_franchiseSalaireMensuelle;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 126, m_franchiseSalaireMensuelle);
    }
    return m_franchiseSalaireMensuelle;
  }
  
  private static final BigDecimal jdoGetm_baseCalculFranchiseCP(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_baseCalculFranchiseCP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 127)) {
        return m_baseCalculFranchiseCP;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 127, m_baseCalculFranchiseCP);
    }
    return m_baseCalculFranchiseCP;
  }
  
  private static final BigDecimal jdoGetm_baseCalculFranchiseSalaire(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_baseCalculFranchiseSalaire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 128)) {
        return m_baseCalculFranchiseSalaire;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 128, m_baseCalculFranchiseSalaire);
    }
    return m_baseCalculFranchiseSalaire;
  }
  
  private static final int jdoGetm_attenteIncoherenceSalaireNPDE(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_attenteIncoherenceSalaireNPDE;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 129)) {
        return m_attenteIncoherenceSalaireNPDE;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 129, m_attenteIncoherenceSalaireNPDE);
    }
    return m_attenteIncoherenceSalaireNPDE;
  }
  
  private static final BigDecimal jdoGetm_identifiantPeriodeIncoherenceSalaireNPDE(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantPeriodeIncoherenceSalaireNPDE;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 130)) {
        return m_identifiantPeriodeIncoherenceSalaireNPDE;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 130, m_identifiantPeriodeIncoherenceSalaireNPDE);
    }
    return m_identifiantPeriodeIncoherenceSalaireNPDE;
  }
  
  private static final int jdoGetm_estPresencePNDS(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estPresencePNDS;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 131)) {
        return m_estPresencePNDS;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 131, m_estPresencePNDS);
    }
    return m_estPresencePNDS;
  }
  
  private static final String jdoGetm_codeSousProduitRejet(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeSousProduitRejet;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 132)) {
        return m_codeSousProduitRejet;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 132, m_codeSousProduitRejet);
    }
    return m_codeSousProduitRejet;
  }
  
  private static final boolean jdoGetm_presenceDerniersSalaires(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_presenceDerniersSalaires;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 133)) {
        return m_presenceDerniersSalaires;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 133, m_presenceDerniersSalaires);
    }
    return m_presenceDerniersSalaires;
  }
  
  private static final BigDecimal jdoGetm_nombreMoisPreavis(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nombreMoisPreavis;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 134)) {
        return m_nombreMoisPreavis;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 134, m_nombreMoisPreavis);
    }
    return m_nombreMoisPreavis;
  }
  
  private static final BigDecimal jdoGetm_identifiantPeriodeIncoherenceRessortissant(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantPeriodeIncoherenceRessortissant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 135)) {
        return m_identifiantPeriodeIncoherenceRessortissant;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 135, m_identifiantPeriodeIncoherenceRessortissant);
    }
    return m_identifiantPeriodeIncoherenceRessortissant;
  }
  
  private static final int jdoGetm_dureeAllongementArefPossible(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeAllongementArefPossible;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 136)) {
        return m_dureeAllongementArefPossible;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 136, m_dureeAllongementArefPossible);
    }
    return m_dureeAllongementArefPossible;
  }
  
  private static final int jdoGetm_dureeAllongementArefRealisee(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeAllongementArefRealisee;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 137)) {
        return m_dureeAllongementArefRealisee;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 137, m_dureeAllongementArefRealisee);
    }
    return m_dureeAllongementArefRealisee;
  }
  
  private static final BigDecimal jdoGetm_coefficientReducteurSJR(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_coefficientReducteurSJR;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 138)) {
        return m_coefficientReducteurSJR;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 138, m_coefficientReducteurSJR);
    }
    return m_coefficientReducteurSJR;
  }
  
  private static final BigDecimal jdoGetm_plancherCoefReducteur(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_plancherCoefReducteur;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 139)) {
        return m_plancherCoefReducteur;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 139, m_plancherCoefReducteur);
    }
    return m_plancherCoefReducteur;
  }
  
  private static final String jdoGetm_topPresenceDiffereARCE(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_topPresenceDiffereARCE;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 140)) {
        return m_topPresenceDiffereARCE;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 140, m_topPresenceDiffereARCE);
    }
    return m_topPresenceDiffereARCE;
  }
  
  private static final BigDecimal jdoGetm_diviseurIslr(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_diviseurIslr;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 141)) {
        return m_diviseurIslr;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 141, m_diviseurIslr);
    }
    return m_diviseurIslr;
  }
  
  private static final int jdoGetm_naturePeriodeSuspensive(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_naturePeriodeSuspensive;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 142)) {
        return m_naturePeriodeSuspensive;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 142, m_naturePeriodeSuspensive);
    }
    return m_naturePeriodeSuspensive;
  }
  
  private static final Damj jdoGetm_dateFinPeriodeSuspensive(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinPeriodeSuspensive;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 143)) {
        return m_dateFinPeriodeSuspensive;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 143, m_dateFinPeriodeSuspensive);
    }
    return m_dateFinPeriodeSuspensive;
  }
  
  protected static final void jdoSetm_identifiantEvenement(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantEvenement = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 0, m_identifiantEvenement, newValue);
    } else {
      m_identifiantEvenement = newValue;
    }
  }
  
  protected static final void jdoSetm_etatDemande(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_etatDemande = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 1, m_etatDemande, newValue);
    } else {
      m_etatDemande = newValue;
    }
  }
  
  protected static final void jdoSetm_codeSegment(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeSegment = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 2, m_codeSegment, newValue);
    } else {
      m_codeSegment = newValue;
    }
  }
  
  protected static final void jdoSetm_referenceExterneDemande(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_referenceExterneDemande = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 3, m_referenceExterneDemande, newValue);
    } else {
      m_referenceExterneDemande = newValue;
    }
  }
  
  protected static final void jdoSetm_gamme(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_gamme = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 4, m_gamme, newValue);
    } else {
      m_gamme = newValue;
    }
  }
  
  protected static final void jdoSetm_ligne(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_ligne = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 5, m_ligne, newValue);
    } else {
      m_ligne = newValue;
    }
  }
  
  protected static final void jdoSetm_typeEchecExamen(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeEchecExamen = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 6, m_typeEchecExamen, newValue);
    } else {
      m_typeEchecExamen = newValue;
    }
  }
  
  protected static final void jdoSetm_motifEchec(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_motifEchec = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 7, m_motifEchec, newValue);
    } else {
      m_motifEchec = newValue;
    }
  }
  
  protected static final void jdoSetm_classementAdministratif(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_classementAdministratif = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 8, m_classementAdministratif, newValue);
    } else {
      m_classementAdministratif = newValue;
    }
  }
  
  protected static final void jdoSetm_motifReexamenPrincipal(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_motifReexamenPrincipal = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 9, m_motifReexamenPrincipal, newValue);
    } else {
      m_motifReexamenPrincipal = newValue;
    }
  }
  
  protected static final void jdoSetm_identifiantOd(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantOd = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 10, m_identifiantOd, newValue);
    } else {
      m_identifiantOd = newValue;
    }
  }
  
  protected static final void jdoSetm_identifiantReprise(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantReprise = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 11, m_identifiantReprise, newValue);
    } else {
      m_identifiantReprise = newValue;
    }
  }
  
  protected static final void jdoSetm_produit(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_produit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 12, m_produit, newValue);
    } else {
      m_produit = newValue;
    }
  }
  
  protected static final void jdoSetm_natureDecision(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_natureDecision = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 13, m_natureDecision, newValue);
    } else {
      m_natureDecision = newValue;
    }
  }
  
  protected static final void jdoSetm_origineDecision(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_origineDecision = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 14, m_origineDecision, newValue);
    } else {
      m_origineDecision = newValue;
    }
  }
  
  protected static final void jdoSetm_topContribSupplementaire(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_topContribSupplementaire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 15, m_topContribSupplementaire, newValue);
    } else {
      m_topContribSupplementaire = newValue;
    }
  }
  
  protected static final void jdoSetm_topContribSpecifique(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_topContribSpecifique = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 16, m_topContribSpecifique, newValue);
    } else {
      m_topContribSpecifique = newValue;
    }
  }
  
  protected static final void jdoSetm_topEchecDemandeExpresseEnCoursIndemnisation(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_topEchecDemandeExpresseEnCoursIndemnisation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 17, m_topEchecDemandeExpresseEnCoursIndemnisation, newValue);
    } else {
      m_topEchecDemandeExpresseEnCoursIndemnisation = newValue;
    }
  }
  
  protected static final void jdoSetm_topRejetASUReliquatASS(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_topRejetASUReliquatASS = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 18, m_topRejetASUReliquatASS, newValue);
    } else {
      m_topRejetASUReliquatASS = newValue;
    }
  }
  
  protected static final void jdoSetm_topRejetASUCpaASS(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_topRejetASUCpaASS = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 19, m_topRejetASUCpaASS, newValue);
    } else {
      m_topRejetASUCpaASS = newValue;
    }
  }
  
  protected static final void jdoSetm_topDroitOptionAss(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_topDroitOptionAss = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 20, m_topDroitOptionAss, newValue);
    } else {
      m_topDroitOptionAss = newValue;
    }
  }
  
  protected static final void jdoSetm_competenceAdministrative(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_competenceAdministrative = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 21, m_competenceAdministrative, newValue);
    } else {
      m_competenceAdministrative = newValue;
    }
  }
  
  protected static final void jdoSetm_indicateurNotificationCourrier(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_indicateurNotificationCourrier = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 22, m_indicateurNotificationCourrier, newValue);
    } else {
      m_indicateurNotificationCourrier = newValue;
    }
  }
  
  protected static final void jdoSetm_montantAllocationJournalierBrutCourrier(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantAllocationJournalierBrutCourrier = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 23, m_montantAllocationJournalierBrutCourrier, newValue);
    } else {
      m_montantAllocationJournalierBrutCourrier = newValue;
    }
  }
  
  protected static final void jdoSetm_montantAllocationJournalierNetCourrier(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantAllocationJournalierNetCourrier = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 24, m_montantAllocationJournalierNetCourrier, newValue);
    } else {
      m_montantAllocationJournalierNetCourrier = newValue;
    }
  }
  
  protected static final void jdoSetm_montantCrcCourrier(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantCrcCourrier = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 25, m_montantCrcCourrier, newValue);
    } else {
      m_montantCrcCourrier = newValue;
    }
  }
  
  protected static final void jdoSetm_dureeTheoriqueDroitServiCourrier(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeTheoriqueDroitServiCourrier = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 26, m_dureeTheoriqueDroitServiCourrier, newValue);
    } else {
      m_dureeTheoriqueDroitServiCourrier = newValue;
    }
  }
  
  protected static final void jdoSetm_dureeRenouvellementAreCourrier(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeRenouvellementAreCourrier = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 27, m_dureeRenouvellementAreCourrier, newValue);
    } else {
      m_dureeRenouvellementAreCourrier = newValue;
    }
  }
  
  protected static final void jdoSetm_montantPensionInvaliditeAreCourrier(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantPensionInvaliditeAreCourrier = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 28, m_montantPensionInvaliditeAreCourrier, newValue);
    } else {
      m_montantPensionInvaliditeAreCourrier = newValue;
    }
  }
  
  protected static final void jdoSetm_montantArePourAerComplementCourrier(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantArePourAerComplementCourrier = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 29, m_montantArePourAerComplementCourrier, newValue);
    } else {
      m_montantArePourAerComplementCourrier = newValue;
    }
  }
  
  protected static final void jdoSetm_montantForfaitaireMensuelRpsCourrier(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantForfaitaireMensuelRpsCourrier = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 30, m_montantForfaitaireMensuelRpsCourrier, newValue);
    } else {
      m_montantForfaitaireMensuelRpsCourrier = newValue;
    }
  }
  
  protected static final void jdoSetm_identifiantActionFormation(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantActionFormation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 31, m_identifiantActionFormation, newValue);
    } else {
      m_identifiantActionFormation = newValue;
    }
  }
  
  protected static final void jdoSetm_fraisFthrAvant(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_fraisFthrAvant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 32, m_fraisFthrAvant, newValue);
    } else {
      m_fraisFthrAvant = newValue;
    }
  }
  
  protected static final void jdoSetm_fraisFpoAvant(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_fraisFpoAvant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 33, m_fraisFpoAvant, newValue);
    } else {
      m_fraisFpoAvant = newValue;
    }
  }
  
  protected static final void jdoSetm_fraisFthrApres(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_fraisFthrApres = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 34, m_fraisFthrApres, newValue);
    } else {
      m_fraisFthrApres = newValue;
    }
  }
  
  protected static final void jdoSetm_fraisFpoApres(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_fraisFpoApres = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 35, m_fraisFpoApres, newValue);
    } else {
      m_fraisFpoApres = newValue;
    }
  }
  
  protected static final void jdoSetm_exerciceAvant(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_exerciceAvant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 36, m_exerciceAvant, newValue);
    } else {
      m_exerciceAvant = newValue;
    }
  }
  
  protected static final void jdoSetm_exerciceApres(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_exerciceApres = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 37, m_exerciceApres, newValue);
    } else {
      m_exerciceApres = newValue;
    }
  }
  
  protected static final void jdoSetm_statutAvant(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutAvant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 38, m_statutAvant, newValue);
    } else {
      m_statutAvant = newValue;
    }
  }
  
  protected static final void jdoSetm_statutApres(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutApres = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 39, m_statutApres, newValue);
    } else {
      m_statutApres = newValue;
    }
  }
  
  protected static final void jdoSetm_topAffDerogatoire(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_topAffDerogatoire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 40, m_topAffDerogatoire, newValue);
    } else {
      m_topAffDerogatoire = newValue;
    }
  }
  
  protected static final void jdoSetm_libelleEmployeur(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_libelleEmployeur = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 41, m_libelleEmployeur, newValue);
    } else {
      m_libelleEmployeur = newValue;
    }
  }
  
  protected static final void jdoSetm_motifRejet(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_motifRejet = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 42, m_motifRejet, newValue);
    } else {
      m_motifRejet = newValue;
    }
  }
  
  protected static final void jdoSetm_dateTraitement(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateTraitement = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 43, m_dateTraitement, newValue);
    } else {
      m_dateTraitement = newValue;
    }
  }
  
  protected static final void jdoSetm_montantSJC(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantSJC = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 44, m_montantSJC, newValue);
    } else {
      m_montantSJC = newValue;
    }
  }
  
  protected static final void jdoSetm_montantSJCMax(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantSJCMax = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 45, m_montantSJCMax, newValue);
    } else {
      m_montantSJCMax = newValue;
    }
  }
  
  protected static final void jdoSetm_montantAllocation(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantAllocation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 46, m_montantAllocation, newValue);
    } else {
      m_montantAllocation = newValue;
    }
  }
  
  protected static final void jdoSetm_montantAllocationUn(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantAllocationUn = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 47, m_montantAllocationUn, newValue);
    } else {
      m_montantAllocationUn = newValue;
    }
  }
  
  protected static final void jdoSetm_montantAllocationDeux(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantAllocationDeux = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 48, m_montantAllocationDeux, newValue);
    } else {
      m_montantAllocationDeux = newValue;
    }
  }
  
  protected static final void jdoSetm_topCaisseInconnue(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_topCaisseInconnue = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 49, m_topCaisseInconnue, newValue);
    } else {
      m_topCaisseInconnue = newValue;
    }
  }
  
  protected static final void jdoSetm_dureeImputationAideSurDroit(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeImputationAideSurDroit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 50, m_dureeImputationAideSurDroit, newValue);
    } else {
      m_dureeImputationAideSurDroit = newValue;
    }
  }
  
  protected static final void jdoSetm_typeAide(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeAide = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 51, m_typeAide, newValue);
    } else {
      m_typeAide = newValue;
    }
  }
  
  protected static final void jdoSetm_topIndividuStable(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_topIndividuStable = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 52, m_topIndividuStable, newValue);
    } else {
      m_topIndividuStable = newValue;
    }
  }
  
  protected static final void jdoSetm_typeExamen(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeExamen = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 53, m_typeExamen, newValue);
    } else {
      m_typeExamen = newValue;
    }
  }
  
  protected static final void jdoSetm_situationParticuliere(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_situationParticuliere = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 54, m_situationParticuliere, newValue);
    } else {
      m_situationParticuliere = newValue;
    }
  }
  
  protected static final void jdoSetm_investigationFraude(DecisionPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_investigationFraude = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 55, m_investigationFraude, newValue);
    } else {
      m_investigationFraude = newValue;
    }
  }
  
  protected static final void jdoSetm_codeSousProduit(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeSousProduit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 56, m_codeSousProduit, newValue);
    } else {
      m_codeSousProduit = newValue;
    }
  }
  
  protected static final void jdoSetm_dateBanalisee(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateBanalisee = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 57, m_dateBanalisee, newValue);
    } else {
      m_dateBanalisee = newValue;
    }
  }
  
  protected static final void jdoSetm_montantSJRSuiteRevision(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantSJRSuiteRevision = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 58, m_montantSJRSuiteRevision, newValue);
    } else {
      m_montantSJRSuiteRevision = newValue;
    }
  }
  
  protected static final void jdoSetm_auMoinsUneActiviteConservee(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_auMoinsUneActiviteConservee = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 59, m_auMoinsUneActiviteConservee, newValue);
    } else {
      m_auMoinsUneActiviteConservee = newValue;
    }
  }
  
  protected static final void jdoSetm_codeTypeAction(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeTypeAction = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 60, m_codeTypeAction, newValue);
    } else {
      m_codeTypeAction = newValue;
    }
  }
  
  protected static final void jdoSetm_creationDALSuiteRejet(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_creationDALSuiteRejet = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 61, m_creationDALSuiteRejet, newValue);
    } else {
      m_creationDALSuiteRejet = newValue;
    }
  }
  
  protected static final void jdoSetm_codeTypeAttente(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeTypeAttente = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 62, m_codeTypeAttente, newValue);
    } else {
      m_codeTypeAttente = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFCT(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFCT = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 63, m_dateFCT, newValue);
    } else {
      m_dateFCT = newValue;
    }
  }
  
  protected static final void jdoSetm_typeExamenCreationDemande(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeExamenCreationDemande = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 64, m_typeExamenCreationDemande, newValue);
    } else {
      m_typeExamenCreationDemande = newValue;
    }
  }
  
  protected static final void jdoSetm_contributionNonPropositionCTP(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_contributionNonPropositionCTP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 65, m_contributionNonPropositionCTP, newValue);
    } else {
      m_contributionNonPropositionCTP = newValue;
    }
  }
  
  protected static final void jdoSetm_estContribPreavis(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_estContribPreavis = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 66, m_estContribPreavis, newValue);
    } else {
      m_estContribPreavis = newValue;
    }
  }
  
  protected static final void jdoSetm_estContribDif(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_estContribDif = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 67, m_estContribDif, newValue);
    } else {
      m_estContribDif = newValue;
    }
  }
  
  protected static final void jdoSetm_montantPreavisCR(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantPreavisCR = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 68, m_montantPreavisCR, newValue);
    } else {
      m_montantPreavisCR = newValue;
    }
  }
  
  protected static final void jdoSetm_montantFormationD(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantFormationD = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 69, m_montantFormationD, newValue);
    } else {
      m_montantFormationD = newValue;
    }
  }
  
  protected static final void jdoSetm_nombreHeureUn(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_nombreHeureUn = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 70, m_nombreHeureUn, newValue);
    } else {
      m_nombreHeureUn = newValue;
    }
  }
  
  protected static final void jdoSetm_nombreHeureDeux(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_nombreHeureDeux = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 71, m_nombreHeureDeux, newValue);
    } else {
      m_nombreHeureDeux = newValue;
    }
  }
  
  protected static final void jdoSetm_topAppelContributions(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_topAppelContributions = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 72, m_topAppelContributions, newValue);
    } else {
      m_topAppelContributions = newValue;
    }
  }
  
  protected static final void jdoSetm_plafondMensuelRessourcesAss(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_plafondMensuelRessourcesAss = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 73, m_plafondMensuelRessourcesAss, newValue);
    } else {
      m_plafondMensuelRessourcesAss = newValue;
    }
  }
  
  protected static final void jdoSetm_nbEmploisSalariesRetenus(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbEmploisSalariesRetenus = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 74, m_nbEmploisSalariesRetenus, newValue);
    } else {
      m_nbEmploisSalariesRetenus = newValue;
    }
  }
  
  protected static final void jdoSetm_montantBrutTranche2(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantBrutTranche2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 75, m_montantBrutTranche2, newValue);
    } else {
      m_montantBrutTranche2 = newValue;
    }
  }
  
  protected static final void jdoSetm_montantCrcTranche2(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantCrcTranche2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 76, m_montantCrcTranche2, newValue);
    } else {
      m_montantCrcTranche2 = newValue;
    }
  }
  
  protected static final void jdoSetm_dureeTranche2(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeTranche2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 77, m_dureeTranche2, newValue);
    } else {
      m_dureeTranche2 = newValue;
    }
  }
  
  protected static final void jdoSetm_montantBrutTranche3(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantBrutTranche3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 78, m_montantBrutTranche3, newValue);
    } else {
      m_montantBrutTranche3 = newValue;
    }
  }
  
  protected static final void jdoSetm_montantCrcTranche3(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantCrcTranche3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 79, m_montantCrcTranche3, newValue);
    } else {
      m_montantCrcTranche3 = newValue;
    }
  }
  
  protected static final void jdoSetm_dureeTranche3(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeTranche3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 80, m_dureeTranche3, newValue);
    } else {
      m_dureeTranche3 = newValue;
    }
  }
  
  protected static final void jdoSetm_validationDAPE(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_validationDAPE = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 81, m_validationDAPE, newValue);
    } else {
      m_validationDAPE = newValue;
    }
  }
  
  protected static final void jdoSetm_typeActionReclassementAvant(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeActionReclassementAvant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 82, m_typeActionReclassementAvant, newValue);
    } else {
      m_typeActionReclassementAvant = newValue;
    }
  }
  
  protected static final void jdoSetm_typeActionReclassementApres(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeActionReclassementApres = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 83, m_typeActionReclassementApres, newValue);
    } else {
      m_typeActionReclassementApres = newValue;
    }
  }
  
  protected static final void jdoSetm_estDerogatoire(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_estDerogatoire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 84, m_estDerogatoire, newValue);
    } else {
      m_estDerogatoire = newValue;
    }
  }
  
  protected static final void jdoSetm_montantForfaitUnitaireRepas(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantForfaitUnitaireRepas = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 85, m_montantForfaitUnitaireRepas, newValue);
    } else {
      m_montantForfaitUnitaireRepas = newValue;
    }
  }
  
  protected static final void jdoSetm_montantForfaitUnitaireHebergement(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantForfaitUnitaireHebergement = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 86, m_montantForfaitUnitaireHebergement, newValue);
    } else {
      m_montantForfaitUnitaireHebergement = newValue;
    }
  }
  
  protected static final void jdoSetm_montantIndiceKilometrique(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantIndiceKilometrique = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 87, m_montantIndiceKilometrique, newValue);
    } else {
      m_montantIndiceKilometrique = newValue;
    }
  }
  
  protected static final void jdoSetm_dateDepotAide(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDepotAide = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 88, m_dateDepotAide, newValue);
    } else {
      m_dateDepotAide = newValue;
    }
  }
  
  protected static final void jdoSetm_attenteValidationDAPE(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_attenteValidationDAPE = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 89, m_attenteValidationDAPE, newValue);
    } else {
      m_attenteValidationDAPE = newValue;
    }
  }
  
  protected static final void jdoSetm_attenteRetourJustificatif(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_attenteRetourJustificatif = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 90, m_attenteRetourJustificatif, newValue);
    } else {
      m_attenteRetourJustificatif = newValue;
    }
  }
  
  protected static final void jdoSetm_dateRetourJustificatif(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateRetourJustificatif = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 91, m_dateRetourJustificatif, newValue);
    } else {
      m_dateRetourJustificatif = newValue;
    }
  }
  
  private static final void jdoSetm_nombreEnfantsTotal(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_nombreEnfantsTotal = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 92, m_nombreEnfantsTotal, newValue);
    } else {
      m_nombreEnfantsTotal = newValue;
    }
  }
  
  private static final void jdoSetm_codeAffectation(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeAffectation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 93, m_codeAffectation, newValue);
    } else {
      m_codeAffectation = newValue;
    }
  }
  
  private static final void jdoSetm_numeroConventionGestion(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_numeroConventionGestion = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 94, m_numeroConventionGestion, newValue);
    } else {
      m_numeroConventionGestion = newValue;
    }
  }
  
  private static final void jdoSetm_montantBonAvant(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantBonAvant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 95, m_montantBonAvant, newValue);
    } else {
      m_montantBonAvant = newValue;
    }
  }
  
  private static final void jdoSetm_montantBonAvantDerogatoire(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantBonAvantDerogatoire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 96, m_montantBonAvantDerogatoire, newValue);
    } else {
      m_montantBonAvantDerogatoire = newValue;
    }
  }
  
  private static final void jdoSetm_typeBonAvant(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeBonAvant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 97, m_typeBonAvant, newValue);
    } else {
      m_typeBonAvant = newValue;
    }
  }
  
  private static final void jdoSetm_typeBonAvantDerogatoire(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeBonAvantDerogatoire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 98, m_typeBonAvantDerogatoire, newValue);
    } else {
      m_typeBonAvantDerogatoire = newValue;
    }
  }
  
  private static final void jdoSetm_montantBonApres(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantBonApres = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 99, m_montantBonApres, newValue);
    } else {
      m_montantBonApres = newValue;
    }
  }
  
  private static final void jdoSetm_montantBonApresDerogatoire(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantBonApresDerogatoire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 100, m_montantBonApresDerogatoire, newValue);
    } else {
      m_montantBonApresDerogatoire = newValue;
    }
  }
  
  private static final void jdoSetm_typeBonApres(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeBonApres = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 101, m_typeBonApres, newValue);
    } else {
      m_typeBonApres = newValue;
    }
  }
  
  private static final void jdoSetm_typeBonApresDerogatoire(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeBonApresDerogatoire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 102, m_typeBonApresDerogatoire, newValue);
    } else {
      m_typeBonApresDerogatoire = newValue;
    }
  }
  
  private static final void jdoSetm_objectifLiquidation(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_objectifLiquidation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 103, m_objectifLiquidation, newValue);
    } else {
      m_objectifLiquidation = newValue;
    }
  }
  
  private static final void jdoSetm_dureePostPrime(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureePostPrime = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 104, m_dureePostPrime, newValue);
    } else {
      m_dureePostPrime = newValue;
    }
  }
  
  private static final void jdoSetm_indicateurPremiereDemandePostPrime(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_indicateurPremiereDemandePostPrime = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 105, m_indicateurPremiereDemandePostPrime, newValue);
    } else {
      m_indicateurPremiereDemandePostPrime = newValue;
    }
  }
  
  private static final void jdoSetm_indicateurDiminutionMontantCSP(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_indicateurDiminutionMontantCSP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 106, m_indicateurDiminutionMontantCSP, newValue);
    } else {
      m_indicateurDiminutionMontantCSP = newValue;
    }
  }
  
  private static final void jdoSetm_indicateurAllongementDureeCSP(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_indicateurAllongementDureeCSP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 107, m_indicateurAllongementDureeCSP, newValue);
    } else {
      m_indicateurAllongementDureeCSP = newValue;
    }
  }
  
  private static final void jdoSetm_dateDepartDelai121j(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDepartDelai121j = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 108, m_dateDepartDelai121j, newValue);
    } else {
      m_dateDepartDelai121j = newValue;
    }
  }
  
  private static final void jdoSetm_dateDebutDernierDelaiAttente(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebutDernierDelaiAttente = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 109, m_dateDebutDernierDelaiAttente, newValue);
    } else {
      m_dateDebutDernierDelaiAttente = newValue;
    }
  }
  
  private static final void jdoSetm_dateIDE(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateIDE = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 110, m_dateIDE, newValue);
    } else {
      m_dateIDE = newValue;
    }
  }
  
  private static final void jdoSetm_dateFaitGenerateurDroitPrecedent(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFaitGenerateurDroitPrecedent = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 111, m_dateFaitGenerateurDroitPrecedent, newValue);
    } else {
      m_dateFaitGenerateurDroitPrecedent = newValue;
    }
  }
  
  private static final void jdoSetm_reglementApplicableDroit(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_reglementApplicableDroit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 112, m_reglementApplicableDroit, newValue);
    } else {
      m_reglementApplicableDroit = newValue;
    }
  }
  
  private static final void jdoSetm_dureeActiviteEmployeursRAC(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeActiviteEmployeursRAC = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 113, m_dureeActiviteEmployeursRAC, newValue);
    } else {
      m_dureeActiviteEmployeursRAC = newValue;
    }
  }
  
  private static final void jdoSetm_coeffTPAppliqueRAC(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_coeffTPAppliqueRAC = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 114, m_coeffTPAppliqueRAC, newValue);
    } else {
      m_coeffTPAppliqueRAC = newValue;
    }
  }
  
  private static final void jdoSetm_dureeActiviteEmployeursSP(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeActiviteEmployeursSP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 115, m_dureeActiviteEmployeursSP, newValue);
    } else {
      m_dureeActiviteEmployeursSP = newValue;
    }
  }
  
  private static final void jdoSetm_coeffTPAppliqueSP(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_coeffTPAppliqueSP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 116, m_coeffTPAppliqueSP, newValue);
    } else {
      m_coeffTPAppliqueSP = newValue;
    }
  }
  
  private static final void jdoSetm_topDemandeASSSuiteDecheance(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_topDemandeASSSuiteDecheance = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 117, m_topDemandeASSSuiteDecheance, newValue);
    } else {
      m_topDemandeASSSuiteDecheance = newValue;
    }
  }
  
  private static final void jdoSetm_attenteBlocageLiquidationAutoRepriseAss(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_attenteBlocageLiquidationAutoRepriseAss = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 118, m_attenteBlocageLiquidationAutoRepriseAss, newValue);
    } else {
      m_attenteBlocageLiquidationAutoRepriseAss = newValue;
    }
  }
  
  private static final void jdoSetm_attenteNationaliteAValider(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_attenteNationaliteAValider = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 119, m_attenteNationaliteAValider, newValue);
    } else {
      m_attenteNationaliteAValider = newValue;
    }
  }
  
  private static final void jdoSetm_topDetectionClauseRattrapage(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_topDetectionClauseRattrapage = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 120, m_topDetectionClauseRattrapage, newValue);
    } else {
      m_topDetectionClauseRattrapage = newValue;
    }
  }
  
  private static final void jdoSetm_topSpectacle2016avantMepSI4(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_topSpectacle2016avantMepSI4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 121, m_topSpectacle2016avantMepSI4, newValue);
    } else {
      m_topSpectacle2016avantMepSI4 = newValue;
    }
  }
  
  private static final void jdoSetm_topAreSpectacleEnCoursClauseRattrapage(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_topAreSpectacleEnCoursClauseRattrapage = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 122, m_topAreSpectacleEnCoursClauseRattrapage, newValue);
    } else {
      m_topAreSpectacleEnCoursClauseRattrapage = newValue;
    }
  }
  
  private static final void jdoSetm_nombreJoursFranchiseCP(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_nombreJoursFranchiseCP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 123, m_nombreJoursFranchiseCP, newValue);
    } else {
      m_nombreJoursFranchiseCP = newValue;
    }
  }
  
  private static final void jdoSetm_nombreJoursFranchiseSalaire(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_nombreJoursFranchiseSalaire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 124, m_nombreJoursFranchiseSalaire, newValue);
    } else {
      m_nombreJoursFranchiseSalaire = newValue;
    }
  }
  
  private static final void jdoSetm_franchiseCpMensuelle(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_franchiseCpMensuelle = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 125, m_franchiseCpMensuelle, newValue);
    } else {
      m_franchiseCpMensuelle = newValue;
    }
  }
  
  private static final void jdoSetm_franchiseSalaireMensuelle(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_franchiseSalaireMensuelle = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 126, m_franchiseSalaireMensuelle, newValue);
    } else {
      m_franchiseSalaireMensuelle = newValue;
    }
  }
  
  private static final void jdoSetm_baseCalculFranchiseCP(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_baseCalculFranchiseCP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 127, m_baseCalculFranchiseCP, newValue);
    } else {
      m_baseCalculFranchiseCP = newValue;
    }
  }
  
  private static final void jdoSetm_baseCalculFranchiseSalaire(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_baseCalculFranchiseSalaire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 128, m_baseCalculFranchiseSalaire, newValue);
    } else {
      m_baseCalculFranchiseSalaire = newValue;
    }
  }
  
  private static final void jdoSetm_attenteIncoherenceSalaireNPDE(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_attenteIncoherenceSalaireNPDE = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 129, m_attenteIncoherenceSalaireNPDE, newValue);
    } else {
      m_attenteIncoherenceSalaireNPDE = newValue;
    }
  }
  
  private static final void jdoSetm_identifiantPeriodeIncoherenceSalaireNPDE(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantPeriodeIncoherenceSalaireNPDE = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 130, m_identifiantPeriodeIncoherenceSalaireNPDE, newValue);
    } else {
      m_identifiantPeriodeIncoherenceSalaireNPDE = newValue;
    }
  }
  
  private static final void jdoSetm_estPresencePNDS(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_estPresencePNDS = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 131, m_estPresencePNDS, newValue);
    } else {
      m_estPresencePNDS = newValue;
    }
  }
  
  private static final void jdoSetm_codeSousProduitRejet(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeSousProduitRejet = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 132, m_codeSousProduitRejet, newValue);
    } else {
      m_codeSousProduitRejet = newValue;
    }
  }
  
  private static final void jdoSetm_presenceDerniersSalaires(DecisionPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_presenceDerniersSalaires = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 133, m_presenceDerniersSalaires, newValue);
    } else {
      m_presenceDerniersSalaires = newValue;
    }
  }
  
  private static final void jdoSetm_nombreMoisPreavis(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_nombreMoisPreavis = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 134, m_nombreMoisPreavis, newValue);
    } else {
      m_nombreMoisPreavis = newValue;
    }
  }
  
  private static final void jdoSetm_identifiantPeriodeIncoherenceRessortissant(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantPeriodeIncoherenceRessortissant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 135, m_identifiantPeriodeIncoherenceRessortissant, newValue);
    } else {
      m_identifiantPeriodeIncoherenceRessortissant = newValue;
    }
  }
  
  private static final void jdoSetm_dureeAllongementArefPossible(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeAllongementArefPossible = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 136, m_dureeAllongementArefPossible, newValue);
    } else {
      m_dureeAllongementArefPossible = newValue;
    }
  }
  
  private static final void jdoSetm_dureeAllongementArefRealisee(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeAllongementArefRealisee = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 137, m_dureeAllongementArefRealisee, newValue);
    } else {
      m_dureeAllongementArefRealisee = newValue;
    }
  }
  
  private static final void jdoSetm_coefficientReducteurSJR(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_coefficientReducteurSJR = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 138, m_coefficientReducteurSJR, newValue);
    } else {
      m_coefficientReducteurSJR = newValue;
    }
  }
  
  private static final void jdoSetm_plancherCoefReducteur(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_plancherCoefReducteur = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 139, m_plancherCoefReducteur, newValue);
    } else {
      m_plancherCoefReducteur = newValue;
    }
  }
  
  private static final void jdoSetm_topPresenceDiffereARCE(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_topPresenceDiffereARCE = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 140, m_topPresenceDiffereARCE, newValue);
    } else {
      m_topPresenceDiffereARCE = newValue;
    }
  }
  
  private static final void jdoSetm_diviseurIslr(DecisionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_diviseurIslr = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 141, m_diviseurIslr, newValue);
    } else {
      m_diviseurIslr = newValue;
    }
  }
  
  private static final void jdoSetm_naturePeriodeSuspensive(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_naturePeriodeSuspensive = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 142, m_naturePeriodeSuspensive, newValue);
    } else {
      m_naturePeriodeSuspensive = newValue;
    }
  }
  
  private static final void jdoSetm_dateFinPeriodeSuspensive(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinPeriodeSuspensive = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 143, m_dateFinPeriodeSuspensive, newValue);
    } else {
      m_dateFinPeriodeSuspensive = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedStringField(this, fieldNumber, m_identifiantEvenement);
      break;
    case 1: 
      jdoStateManager.providedIntField(this, fieldNumber, m_etatDemande);
      break;
    case 2: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeSegment);
      break;
    case 3: 
      jdoStateManager.providedStringField(this, fieldNumber, m_referenceExterneDemande);
      break;
    case 4: 
      jdoStateManager.providedStringField(this, fieldNumber, m_gamme);
      break;
    case 5: 
      jdoStateManager.providedStringField(this, fieldNumber, m_ligne);
      break;
    case 6: 
      jdoStateManager.providedIntField(this, fieldNumber, m_typeEchecExamen);
      break;
    case 7: 
      jdoStateManager.providedIntField(this, fieldNumber, m_motifEchec);
      break;
    case 8: 
      jdoStateManager.providedStringField(this, fieldNumber, m_classementAdministratif);
      break;
    case 9: 
      jdoStateManager.providedIntField(this, fieldNumber, m_motifReexamenPrincipal);
      break;
    case 10: 
      jdoStateManager.providedIntField(this, fieldNumber, m_identifiantOd);
      break;
    case 11: 
      jdoStateManager.providedIntField(this, fieldNumber, m_identifiantReprise);
      break;
    case 12: 
      jdoStateManager.providedStringField(this, fieldNumber, m_produit);
      break;
    case 13: 
      jdoStateManager.providedIntField(this, fieldNumber, m_natureDecision);
      break;
    case 14: 
      jdoStateManager.providedIntField(this, fieldNumber, m_origineDecision);
      break;
    case 15: 
      jdoStateManager.providedIntField(this, fieldNumber, m_topContribSupplementaire);
      break;
    case 16: 
      jdoStateManager.providedIntField(this, fieldNumber, m_topContribSpecifique);
      break;
    case 17: 
      jdoStateManager.providedIntField(this, fieldNumber, m_topEchecDemandeExpresseEnCoursIndemnisation);
      break;
    case 18: 
      jdoStateManager.providedIntField(this, fieldNumber, m_topRejetASUReliquatASS);
      break;
    case 19: 
      jdoStateManager.providedIntField(this, fieldNumber, m_topRejetASUCpaASS);
      break;
    case 20: 
      jdoStateManager.providedIntField(this, fieldNumber, m_topDroitOptionAss);
      break;
    case 21: 
      jdoStateManager.providedStringField(this, fieldNumber, m_competenceAdministrative);
      break;
    case 22: 
      jdoStateManager.providedIntField(this, fieldNumber, m_indicateurNotificationCourrier);
      break;
    case 23: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantAllocationJournalierBrutCourrier);
      break;
    case 24: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantAllocationJournalierNetCourrier);
      break;
    case 25: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantCrcCourrier);
      break;
    case 26: 
      jdoStateManager.providedIntField(this, fieldNumber, m_dureeTheoriqueDroitServiCourrier);
      break;
    case 27: 
      jdoStateManager.providedIntField(this, fieldNumber, m_dureeRenouvellementAreCourrier);
      break;
    case 28: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantPensionInvaliditeAreCourrier);
      break;
    case 29: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantArePourAerComplementCourrier);
      break;
    case 30: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantForfaitaireMensuelRpsCourrier);
      break;
    case 31: 
      jdoStateManager.providedIntField(this, fieldNumber, m_identifiantActionFormation);
      break;
    case 32: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_fraisFthrAvant);
      break;
    case 33: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_fraisFpoAvant);
      break;
    case 34: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_fraisFthrApres);
      break;
    case 35: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_fraisFpoApres);
      break;
    case 36: 
      jdoStateManager.providedIntField(this, fieldNumber, m_exerciceAvant);
      break;
    case 37: 
      jdoStateManager.providedIntField(this, fieldNumber, m_exerciceApres);
      break;
    case 38: 
      jdoStateManager.providedIntField(this, fieldNumber, m_statutAvant);
      break;
    case 39: 
      jdoStateManager.providedIntField(this, fieldNumber, m_statutApres);
      break;
    case 40: 
      jdoStateManager.providedIntField(this, fieldNumber, m_topAffDerogatoire);
      break;
    case 41: 
      jdoStateManager.providedStringField(this, fieldNumber, m_libelleEmployeur);
      break;
    case 42: 
      jdoStateManager.providedIntField(this, fieldNumber, m_motifRejet);
      break;
    case 43: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateTraitement);
      break;
    case 44: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantSJC);
      break;
    case 45: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantSJCMax);
      break;
    case 46: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantAllocation);
      break;
    case 47: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantAllocationUn);
      break;
    case 48: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantAllocationDeux);
      break;
    case 49: 
      jdoStateManager.providedIntField(this, fieldNumber, m_topCaisseInconnue);
      break;
    case 50: 
      jdoStateManager.providedIntField(this, fieldNumber, m_dureeImputationAideSurDroit);
      break;
    case 51: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeAide);
      break;
    case 52: 
      jdoStateManager.providedIntField(this, fieldNumber, m_topIndividuStable);
      break;
    case 53: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeExamen);
      break;
    case 54: 
      jdoStateManager.providedStringField(this, fieldNumber, m_situationParticuliere);
      break;
    case 55: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_investigationFraude);
      break;
    case 56: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeSousProduit);
      break;
    case 57: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateBanalisee);
      break;
    case 58: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantSJRSuiteRevision);
      break;
    case 59: 
      jdoStateManager.providedIntField(this, fieldNumber, m_auMoinsUneActiviteConservee);
      break;
    case 60: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeTypeAction);
      break;
    case 61: 
      jdoStateManager.providedIntField(this, fieldNumber, m_creationDALSuiteRejet);
      break;
    case 62: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeTypeAttente);
      break;
    case 63: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFCT);
      break;
    case 64: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeExamenCreationDemande);
      break;
    case 65: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_contributionNonPropositionCTP);
      break;
    case 66: 
      jdoStateManager.providedIntField(this, fieldNumber, m_estContribPreavis);
      break;
    case 67: 
      jdoStateManager.providedIntField(this, fieldNumber, m_estContribDif);
      break;
    case 68: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantPreavisCR);
      break;
    case 69: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantFormationD);
      break;
    case 70: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_nombreHeureUn);
      break;
    case 71: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_nombreHeureDeux);
      break;
    case 72: 
      jdoStateManager.providedIntField(this, fieldNumber, m_topAppelContributions);
      break;
    case 73: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_plafondMensuelRessourcesAss);
      break;
    case 74: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_nbEmploisSalariesRetenus);
      break;
    case 75: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantBrutTranche2);
      break;
    case 76: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantCrcTranche2);
      break;
    case 77: 
      jdoStateManager.providedIntField(this, fieldNumber, m_dureeTranche2);
      break;
    case 78: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantBrutTranche3);
      break;
    case 79: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantCrcTranche3);
      break;
    case 80: 
      jdoStateManager.providedIntField(this, fieldNumber, m_dureeTranche3);
      break;
    case 81: 
      jdoStateManager.providedStringField(this, fieldNumber, m_validationDAPE);
      break;
    case 82: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeActionReclassementAvant);
      break;
    case 83: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeActionReclassementApres);
      break;
    case 84: 
      jdoStateManager.providedIntField(this, fieldNumber, m_estDerogatoire);
      break;
    case 85: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantForfaitUnitaireRepas);
      break;
    case 86: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantForfaitUnitaireHebergement);
      break;
    case 87: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantIndiceKilometrique);
      break;
    case 88: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDepotAide);
      break;
    case 89: 
      jdoStateManager.providedIntField(this, fieldNumber, m_attenteValidationDAPE);
      break;
    case 90: 
      jdoStateManager.providedIntField(this, fieldNumber, m_attenteRetourJustificatif);
      break;
    case 91: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateRetourJustificatif);
      break;
    case 92: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_nombreEnfantsTotal);
      break;
    case 93: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeAffectation);
      break;
    case 94: 
      jdoStateManager.providedStringField(this, fieldNumber, m_numeroConventionGestion);
      break;
    case 95: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantBonAvant);
      break;
    case 96: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantBonAvantDerogatoire);
      break;
    case 97: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeBonAvant);
      break;
    case 98: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeBonAvantDerogatoire);
      break;
    case 99: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantBonApres);
      break;
    case 100: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantBonApresDerogatoire);
      break;
    case 101: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeBonApres);
      break;
    case 102: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeBonApresDerogatoire);
      break;
    case 103: 
      jdoStateManager.providedIntField(this, fieldNumber, m_objectifLiquidation);
      break;
    case 104: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dureePostPrime);
      break;
    case 105: 
      jdoStateManager.providedStringField(this, fieldNumber, m_indicateurPremiereDemandePostPrime);
      break;
    case 106: 
      jdoStateManager.providedStringField(this, fieldNumber, m_indicateurDiminutionMontantCSP);
      break;
    case 107: 
      jdoStateManager.providedStringField(this, fieldNumber, m_indicateurAllongementDureeCSP);
      break;
    case 108: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDepartDelai121j);
      break;
    case 109: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebutDernierDelaiAttente);
      break;
    case 110: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateIDE);
      break;
    case 111: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFaitGenerateurDroitPrecedent);
      break;
    case 112: 
      jdoStateManager.providedStringField(this, fieldNumber, m_reglementApplicableDroit);
      break;
    case 113: 
      jdoStateManager.providedIntField(this, fieldNumber, m_dureeActiviteEmployeursRAC);
      break;
    case 114: 
      jdoStateManager.providedIntField(this, fieldNumber, m_coeffTPAppliqueRAC);
      break;
    case 115: 
      jdoStateManager.providedIntField(this, fieldNumber, m_dureeActiviteEmployeursSP);
      break;
    case 116: 
      jdoStateManager.providedIntField(this, fieldNumber, m_coeffTPAppliqueSP);
      break;
    case 117: 
      jdoStateManager.providedIntField(this, fieldNumber, m_topDemandeASSSuiteDecheance);
      break;
    case 118: 
      jdoStateManager.providedStringField(this, fieldNumber, m_attenteBlocageLiquidationAutoRepriseAss);
      break;
    case 119: 
      jdoStateManager.providedStringField(this, fieldNumber, m_attenteNationaliteAValider);
      break;
    case 120: 
      jdoStateManager.providedIntField(this, fieldNumber, m_topDetectionClauseRattrapage);
      break;
    case 121: 
      jdoStateManager.providedIntField(this, fieldNumber, m_topSpectacle2016avantMepSI4);
      break;
    case 122: 
      jdoStateManager.providedIntField(this, fieldNumber, m_topAreSpectacleEnCoursClauseRattrapage);
      break;
    case 123: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_nombreJoursFranchiseCP);
      break;
    case 124: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_nombreJoursFranchiseSalaire);
      break;
    case 125: 
      jdoStateManager.providedIntField(this, fieldNumber, m_franchiseCpMensuelle);
      break;
    case 126: 
      jdoStateManager.providedIntField(this, fieldNumber, m_franchiseSalaireMensuelle);
      break;
    case 127: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_baseCalculFranchiseCP);
      break;
    case 128: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_baseCalculFranchiseSalaire);
      break;
    case 129: 
      jdoStateManager.providedIntField(this, fieldNumber, m_attenteIncoherenceSalaireNPDE);
      break;
    case 130: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_identifiantPeriodeIncoherenceSalaireNPDE);
      break;
    case 131: 
      jdoStateManager.providedIntField(this, fieldNumber, m_estPresencePNDS);
      break;
    case 132: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeSousProduitRejet);
      break;
    case 133: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_presenceDerniersSalaires);
      break;
    case 134: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_nombreMoisPreavis);
      break;
    case 135: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_identifiantPeriodeIncoherenceRessortissant);
      break;
    case 136: 
      jdoStateManager.providedIntField(this, fieldNumber, m_dureeAllongementArefPossible);
      break;
    case 137: 
      jdoStateManager.providedIntField(this, fieldNumber, m_dureeAllongementArefRealisee);
      break;
    case 138: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_coefficientReducteurSJR);
      break;
    case 139: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_plancherCoefReducteur);
      break;
    case 140: 
      jdoStateManager.providedStringField(this, fieldNumber, m_topPresenceDiffereARCE);
      break;
    case 141: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_diviseurIslr);
      break;
    case 142: 
      jdoStateManager.providedIntField(this, fieldNumber, m_naturePeriodeSuspensive);
      break;
    case 143: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinPeriodeSuspensive);
      break;
    default: 
      throw new JDOFatalInternalException("index of field is out of bound");
    }
  }
  
  public void jdoReplaceField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      m_identifiantEvenement = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 1: 
      m_etatDemande = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 2: 
      m_codeSegment = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 3: 
      m_referenceExterneDemande = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 4: 
      m_gamme = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 5: 
      m_ligne = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 6: 
      m_typeEchecExamen = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 7: 
      m_motifEchec = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 8: 
      m_classementAdministratif = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 9: 
      m_motifReexamenPrincipal = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 10: 
      m_identifiantOd = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 11: 
      m_identifiantReprise = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 12: 
      m_produit = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 13: 
      m_natureDecision = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 14: 
      m_origineDecision = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 15: 
      m_topContribSupplementaire = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 16: 
      m_topContribSpecifique = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 17: 
      m_topEchecDemandeExpresseEnCoursIndemnisation = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 18: 
      m_topRejetASUReliquatASS = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 19: 
      m_topRejetASUCpaASS = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 20: 
      m_topDroitOptionAss = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 21: 
      m_competenceAdministrative = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 22: 
      m_indicateurNotificationCourrier = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 23: 
      m_montantAllocationJournalierBrutCourrier = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 24: 
      m_montantAllocationJournalierNetCourrier = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 25: 
      m_montantCrcCourrier = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 26: 
      m_dureeTheoriqueDroitServiCourrier = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 27: 
      m_dureeRenouvellementAreCourrier = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 28: 
      m_montantPensionInvaliditeAreCourrier = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 29: 
      m_montantArePourAerComplementCourrier = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 30: 
      m_montantForfaitaireMensuelRpsCourrier = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 31: 
      m_identifiantActionFormation = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 32: 
      m_fraisFthrAvant = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 33: 
      m_fraisFpoAvant = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 34: 
      m_fraisFthrApres = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 35: 
      m_fraisFpoApres = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 36: 
      m_exerciceAvant = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 37: 
      m_exerciceApres = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 38: 
      m_statutAvant = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 39: 
      m_statutApres = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 40: 
      m_topAffDerogatoire = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 41: 
      m_libelleEmployeur = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 42: 
      m_motifRejet = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 43: 
      m_dateTraitement = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 44: 
      m_montantSJC = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 45: 
      m_montantSJCMax = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 46: 
      m_montantAllocation = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 47: 
      m_montantAllocationUn = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 48: 
      m_montantAllocationDeux = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 49: 
      m_topCaisseInconnue = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 50: 
      m_dureeImputationAideSurDroit = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 51: 
      m_typeAide = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 52: 
      m_topIndividuStable = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 53: 
      m_typeExamen = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 54: 
      m_situationParticuliere = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 55: 
      m_investigationFraude = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 56: 
      m_codeSousProduit = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 57: 
      m_dateBanalisee = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 58: 
      m_montantSJRSuiteRevision = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 59: 
      m_auMoinsUneActiviteConservee = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 60: 
      m_codeTypeAction = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 61: 
      m_creationDALSuiteRejet = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 62: 
      m_codeTypeAttente = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 63: 
      m_dateFCT = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 64: 
      m_typeExamenCreationDemande = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 65: 
      m_contributionNonPropositionCTP = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 66: 
      m_estContribPreavis = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 67: 
      m_estContribDif = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 68: 
      m_montantPreavisCR = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 69: 
      m_montantFormationD = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 70: 
      m_nombreHeureUn = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 71: 
      m_nombreHeureDeux = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 72: 
      m_topAppelContributions = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 73: 
      m_plafondMensuelRessourcesAss = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 74: 
      m_nbEmploisSalariesRetenus = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 75: 
      m_montantBrutTranche2 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 76: 
      m_montantCrcTranche2 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 77: 
      m_dureeTranche2 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 78: 
      m_montantBrutTranche3 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 79: 
      m_montantCrcTranche3 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 80: 
      m_dureeTranche3 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 81: 
      m_validationDAPE = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 82: 
      m_typeActionReclassementAvant = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 83: 
      m_typeActionReclassementApres = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 84: 
      m_estDerogatoire = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 85: 
      m_montantForfaitUnitaireRepas = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 86: 
      m_montantForfaitUnitaireHebergement = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 87: 
      m_montantIndiceKilometrique = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 88: 
      m_dateDepotAide = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 89: 
      m_attenteValidationDAPE = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 90: 
      m_attenteRetourJustificatif = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 91: 
      m_dateRetourJustificatif = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 92: 
      m_nombreEnfantsTotal = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 93: 
      m_codeAffectation = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 94: 
      m_numeroConventionGestion = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 95: 
      m_montantBonAvant = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 96: 
      m_montantBonAvantDerogatoire = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 97: 
      m_typeBonAvant = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 98: 
      m_typeBonAvantDerogatoire = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 99: 
      m_montantBonApres = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 100: 
      m_montantBonApresDerogatoire = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 101: 
      m_typeBonApres = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 102: 
      m_typeBonApresDerogatoire = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 103: 
      m_objectifLiquidation = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 104: 
      m_dureePostPrime = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 105: 
      m_indicateurPremiereDemandePostPrime = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 106: 
      m_indicateurDiminutionMontantCSP = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 107: 
      m_indicateurAllongementDureeCSP = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 108: 
      m_dateDepartDelai121j = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 109: 
      m_dateDebutDernierDelaiAttente = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 110: 
      m_dateIDE = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 111: 
      m_dateFaitGenerateurDroitPrecedent = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 112: 
      m_reglementApplicableDroit = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 113: 
      m_dureeActiviteEmployeursRAC = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 114: 
      m_coeffTPAppliqueRAC = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 115: 
      m_dureeActiviteEmployeursSP = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 116: 
      m_coeffTPAppliqueSP = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 117: 
      m_topDemandeASSSuiteDecheance = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 118: 
      m_attenteBlocageLiquidationAutoRepriseAss = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 119: 
      m_attenteNationaliteAValider = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 120: 
      m_topDetectionClauseRattrapage = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 121: 
      m_topSpectacle2016avantMepSI4 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 122: 
      m_topAreSpectacleEnCoursClauseRattrapage = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 123: 
      m_nombreJoursFranchiseCP = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 124: 
      m_nombreJoursFranchiseSalaire = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 125: 
      m_franchiseCpMensuelle = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 126: 
      m_franchiseSalaireMensuelle = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 127: 
      m_baseCalculFranchiseCP = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 128: 
      m_baseCalculFranchiseSalaire = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 129: 
      m_attenteIncoherenceSalaireNPDE = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 130: 
      m_identifiantPeriodeIncoherenceSalaireNPDE = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 131: 
      m_estPresencePNDS = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 132: 
      m_codeSousProduitRejet = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 133: 
      m_presenceDerniersSalaires = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 134: 
      m_nombreMoisPreavis = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 135: 
      m_identifiantPeriodeIncoherenceRessortissant = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 136: 
      m_dureeAllongementArefPossible = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 137: 
      m_dureeAllongementArefRealisee = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 138: 
      m_coefficientReducteurSJR = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 139: 
      m_plancherCoefReducteur = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 140: 
      m_topPresenceDiffereARCE = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 141: 
      m_diviseurIslr = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 142: 
      m_naturePeriodeSuspensive = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 143: 
      m_dateFinPeriodeSuspensive = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    default: 
      throw new JDOFatalInternalException("index of field is out of bound");
    }
  }
  
  public void jdoProvideFields(int[] fieldNumbers)
  {
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int fieldNumber = fieldNumbers[i];
      jdoProvideField(fieldNumber);
    }
  }
  
  public void jdoReplaceFields(int[] fieldNumbers)
  {
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int fieldNumber = fieldNumbers[i];
      jdoReplaceField(fieldNumber);
    }
  }
  
  public synchronized void jdoReplaceStateManager(StateManager sm)
  {
    if (jdoStateManager != null)
    {
      jdoStateManager = jdoStateManager.replacingStateManager(this, sm);
    }
    else
    {
      SecurityManager securityManager = System.getSecurityManager();
      if (securityManager != null) {
        securityManager.checkPermission(JDOPermission.SET_STATE_MANAGER);
      }
      jdoStateManager = sm;
    }
  }
  
  public boolean jdoIsPersistent()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.isPersistent(this);
    }
    return false;
  }
  
  public boolean jdoIsTransactional()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.isTransactional(this);
    }
    return false;
  }
  
  public boolean jdoIsNew()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.isNew(this);
    }
    return false;
  }
  
  public boolean jdoIsDirty()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.isDirty(this);
    }
    return false;
  }
  
  public boolean jdoIsDeleted()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.isDeleted(this);
    }
    return false;
  }
  
  public void jdoMakeDirty(String fieldName)
  {
    if (jdoStateManager != null) {
      jdoStateManager.makeDirty(this, fieldName);
    }
  }
  
  public void jdoReplaceFlags()
  {
    if (jdoStateManager != null)
    {
      jdoFlags = jdoStateManager.replacingFlags(this);
      return;
      jdoFlags = 0;
    }
  }
  
  public boolean jdoIsDetached()
  {
    if (jdoStateManager != null) {
      return ((CommonStateManager)jdoStateManager).isDetached();
    }
    return false;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm)
  {
    DecisionPC pc = new DecisionPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    DecisionPC pc = new DecisionPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 144;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof DecisionPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    DecisionPC other = (DecisionPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_identifiantEvenement = m_identifiantEvenement;
        break;
      case 1: 
        m_etatDemande = m_etatDemande;
        break;
      case 2: 
        m_codeSegment = m_codeSegment;
        break;
      case 3: 
        m_referenceExterneDemande = m_referenceExterneDemande;
        break;
      case 4: 
        m_gamme = m_gamme;
        break;
      case 5: 
        m_ligne = m_ligne;
        break;
      case 6: 
        m_typeEchecExamen = m_typeEchecExamen;
        break;
      case 7: 
        m_motifEchec = m_motifEchec;
        break;
      case 8: 
        m_classementAdministratif = m_classementAdministratif;
        break;
      case 9: 
        m_motifReexamenPrincipal = m_motifReexamenPrincipal;
        break;
      case 10: 
        m_identifiantOd = m_identifiantOd;
        break;
      case 11: 
        m_identifiantReprise = m_identifiantReprise;
        break;
      case 12: 
        m_produit = m_produit;
        break;
      case 13: 
        m_natureDecision = m_natureDecision;
        break;
      case 14: 
        m_origineDecision = m_origineDecision;
        break;
      case 15: 
        m_topContribSupplementaire = m_topContribSupplementaire;
        break;
      case 16: 
        m_topContribSpecifique = m_topContribSpecifique;
        break;
      case 17: 
        m_topEchecDemandeExpresseEnCoursIndemnisation = m_topEchecDemandeExpresseEnCoursIndemnisation;
        break;
      case 18: 
        m_topRejetASUReliquatASS = m_topRejetASUReliquatASS;
        break;
      case 19: 
        m_topRejetASUCpaASS = m_topRejetASUCpaASS;
        break;
      case 20: 
        m_topDroitOptionAss = m_topDroitOptionAss;
        break;
      case 21: 
        m_competenceAdministrative = m_competenceAdministrative;
        break;
      case 22: 
        m_indicateurNotificationCourrier = m_indicateurNotificationCourrier;
        break;
      case 23: 
        m_montantAllocationJournalierBrutCourrier = m_montantAllocationJournalierBrutCourrier;
        break;
      case 24: 
        m_montantAllocationJournalierNetCourrier = m_montantAllocationJournalierNetCourrier;
        break;
      case 25: 
        m_montantCrcCourrier = m_montantCrcCourrier;
        break;
      case 26: 
        m_dureeTheoriqueDroitServiCourrier = m_dureeTheoriqueDroitServiCourrier;
        break;
      case 27: 
        m_dureeRenouvellementAreCourrier = m_dureeRenouvellementAreCourrier;
        break;
      case 28: 
        m_montantPensionInvaliditeAreCourrier = m_montantPensionInvaliditeAreCourrier;
        break;
      case 29: 
        m_montantArePourAerComplementCourrier = m_montantArePourAerComplementCourrier;
        break;
      case 30: 
        m_montantForfaitaireMensuelRpsCourrier = m_montantForfaitaireMensuelRpsCourrier;
        break;
      case 31: 
        m_identifiantActionFormation = m_identifiantActionFormation;
        break;
      case 32: 
        m_fraisFthrAvant = m_fraisFthrAvant;
        break;
      case 33: 
        m_fraisFpoAvant = m_fraisFpoAvant;
        break;
      case 34: 
        m_fraisFthrApres = m_fraisFthrApres;
        break;
      case 35: 
        m_fraisFpoApres = m_fraisFpoApres;
        break;
      case 36: 
        m_exerciceAvant = m_exerciceAvant;
        break;
      case 37: 
        m_exerciceApres = m_exerciceApres;
        break;
      case 38: 
        m_statutAvant = m_statutAvant;
        break;
      case 39: 
        m_statutApres = m_statutApres;
        break;
      case 40: 
        m_topAffDerogatoire = m_topAffDerogatoire;
        break;
      case 41: 
        m_libelleEmployeur = m_libelleEmployeur;
        break;
      case 42: 
        m_motifRejet = m_motifRejet;
        break;
      case 43: 
        m_dateTraitement = m_dateTraitement;
        break;
      case 44: 
        m_montantSJC = m_montantSJC;
        break;
      case 45: 
        m_montantSJCMax = m_montantSJCMax;
        break;
      case 46: 
        m_montantAllocation = m_montantAllocation;
        break;
      case 47: 
        m_montantAllocationUn = m_montantAllocationUn;
        break;
      case 48: 
        m_montantAllocationDeux = m_montantAllocationDeux;
        break;
      case 49: 
        m_topCaisseInconnue = m_topCaisseInconnue;
        break;
      case 50: 
        m_dureeImputationAideSurDroit = m_dureeImputationAideSurDroit;
        break;
      case 51: 
        m_typeAide = m_typeAide;
        break;
      case 52: 
        m_topIndividuStable = m_topIndividuStable;
        break;
      case 53: 
        m_typeExamen = m_typeExamen;
        break;
      case 54: 
        m_situationParticuliere = m_situationParticuliere;
        break;
      case 55: 
        m_investigationFraude = m_investigationFraude;
        break;
      case 56: 
        m_codeSousProduit = m_codeSousProduit;
        break;
      case 57: 
        m_dateBanalisee = m_dateBanalisee;
        break;
      case 58: 
        m_montantSJRSuiteRevision = m_montantSJRSuiteRevision;
        break;
      case 59: 
        m_auMoinsUneActiviteConservee = m_auMoinsUneActiviteConservee;
        break;
      case 60: 
        m_codeTypeAction = m_codeTypeAction;
        break;
      case 61: 
        m_creationDALSuiteRejet = m_creationDALSuiteRejet;
        break;
      case 62: 
        m_codeTypeAttente = m_codeTypeAttente;
        break;
      case 63: 
        m_dateFCT = m_dateFCT;
        break;
      case 64: 
        m_typeExamenCreationDemande = m_typeExamenCreationDemande;
        break;
      case 65: 
        m_contributionNonPropositionCTP = m_contributionNonPropositionCTP;
        break;
      case 66: 
        m_estContribPreavis = m_estContribPreavis;
        break;
      case 67: 
        m_estContribDif = m_estContribDif;
        break;
      case 68: 
        m_montantPreavisCR = m_montantPreavisCR;
        break;
      case 69: 
        m_montantFormationD = m_montantFormationD;
        break;
      case 70: 
        m_nombreHeureUn = m_nombreHeureUn;
        break;
      case 71: 
        m_nombreHeureDeux = m_nombreHeureDeux;
        break;
      case 72: 
        m_topAppelContributions = m_topAppelContributions;
        break;
      case 73: 
        m_plafondMensuelRessourcesAss = m_plafondMensuelRessourcesAss;
        break;
      case 74: 
        m_nbEmploisSalariesRetenus = m_nbEmploisSalariesRetenus;
        break;
      case 75: 
        m_montantBrutTranche2 = m_montantBrutTranche2;
        break;
      case 76: 
        m_montantCrcTranche2 = m_montantCrcTranche2;
        break;
      case 77: 
        m_dureeTranche2 = m_dureeTranche2;
        break;
      case 78: 
        m_montantBrutTranche3 = m_montantBrutTranche3;
        break;
      case 79: 
        m_montantCrcTranche3 = m_montantCrcTranche3;
        break;
      case 80: 
        m_dureeTranche3 = m_dureeTranche3;
        break;
      case 81: 
        m_validationDAPE = m_validationDAPE;
        break;
      case 82: 
        m_typeActionReclassementAvant = m_typeActionReclassementAvant;
        break;
      case 83: 
        m_typeActionReclassementApres = m_typeActionReclassementApres;
        break;
      case 84: 
        m_estDerogatoire = m_estDerogatoire;
        break;
      case 85: 
        m_montantForfaitUnitaireRepas = m_montantForfaitUnitaireRepas;
        break;
      case 86: 
        m_montantForfaitUnitaireHebergement = m_montantForfaitUnitaireHebergement;
        break;
      case 87: 
        m_montantIndiceKilometrique = m_montantIndiceKilometrique;
        break;
      case 88: 
        m_dateDepotAide = m_dateDepotAide;
        break;
      case 89: 
        m_attenteValidationDAPE = m_attenteValidationDAPE;
        break;
      case 90: 
        m_attenteRetourJustificatif = m_attenteRetourJustificatif;
        break;
      case 91: 
        m_dateRetourJustificatif = m_dateRetourJustificatif;
        break;
      case 92: 
        m_nombreEnfantsTotal = m_nombreEnfantsTotal;
        break;
      case 93: 
        m_codeAffectation = m_codeAffectation;
        break;
      case 94: 
        m_numeroConventionGestion = m_numeroConventionGestion;
        break;
      case 95: 
        m_montantBonAvant = m_montantBonAvant;
        break;
      case 96: 
        m_montantBonAvantDerogatoire = m_montantBonAvantDerogatoire;
        break;
      case 97: 
        m_typeBonAvant = m_typeBonAvant;
        break;
      case 98: 
        m_typeBonAvantDerogatoire = m_typeBonAvantDerogatoire;
        break;
      case 99: 
        m_montantBonApres = m_montantBonApres;
        break;
      case 100: 
        m_montantBonApresDerogatoire = m_montantBonApresDerogatoire;
        break;
      case 101: 
        m_typeBonApres = m_typeBonApres;
        break;
      case 102: 
        m_typeBonApresDerogatoire = m_typeBonApresDerogatoire;
        break;
      case 103: 
        m_objectifLiquidation = m_objectifLiquidation;
        break;
      case 104: 
        m_dureePostPrime = m_dureePostPrime;
        break;
      case 105: 
        m_indicateurPremiereDemandePostPrime = m_indicateurPremiereDemandePostPrime;
        break;
      case 106: 
        m_indicateurDiminutionMontantCSP = m_indicateurDiminutionMontantCSP;
        break;
      case 107: 
        m_indicateurAllongementDureeCSP = m_indicateurAllongementDureeCSP;
        break;
      case 108: 
        m_dateDepartDelai121j = m_dateDepartDelai121j;
        break;
      case 109: 
        m_dateDebutDernierDelaiAttente = m_dateDebutDernierDelaiAttente;
        break;
      case 110: 
        m_dateIDE = m_dateIDE;
        break;
      case 111: 
        m_dateFaitGenerateurDroitPrecedent = m_dateFaitGenerateurDroitPrecedent;
        break;
      case 112: 
        m_reglementApplicableDroit = m_reglementApplicableDroit;
        break;
      case 113: 
        m_dureeActiviteEmployeursRAC = m_dureeActiviteEmployeursRAC;
        break;
      case 114: 
        m_coeffTPAppliqueRAC = m_coeffTPAppliqueRAC;
        break;
      case 115: 
        m_dureeActiviteEmployeursSP = m_dureeActiviteEmployeursSP;
        break;
      case 116: 
        m_coeffTPAppliqueSP = m_coeffTPAppliqueSP;
        break;
      case 117: 
        m_topDemandeASSSuiteDecheance = m_topDemandeASSSuiteDecheance;
        break;
      case 118: 
        m_attenteBlocageLiquidationAutoRepriseAss = m_attenteBlocageLiquidationAutoRepriseAss;
        break;
      case 119: 
        m_attenteNationaliteAValider = m_attenteNationaliteAValider;
        break;
      case 120: 
        m_topDetectionClauseRattrapage = m_topDetectionClauseRattrapage;
        break;
      case 121: 
        m_topSpectacle2016avantMepSI4 = m_topSpectacle2016avantMepSI4;
        break;
      case 122: 
        m_topAreSpectacleEnCoursClauseRattrapage = m_topAreSpectacleEnCoursClauseRattrapage;
        break;
      case 123: 
        m_nombreJoursFranchiseCP = m_nombreJoursFranchiseCP;
        break;
      case 124: 
        m_nombreJoursFranchiseSalaire = m_nombreJoursFranchiseSalaire;
        break;
      case 125: 
        m_franchiseCpMensuelle = m_franchiseCpMensuelle;
        break;
      case 126: 
        m_franchiseSalaireMensuelle = m_franchiseSalaireMensuelle;
        break;
      case 127: 
        m_baseCalculFranchiseCP = m_baseCalculFranchiseCP;
        break;
      case 128: 
        m_baseCalculFranchiseSalaire = m_baseCalculFranchiseSalaire;
        break;
      case 129: 
        m_attenteIncoherenceSalaireNPDE = m_attenteIncoherenceSalaireNPDE;
        break;
      case 130: 
        m_identifiantPeriodeIncoherenceSalaireNPDE = m_identifiantPeriodeIncoherenceSalaireNPDE;
        break;
      case 131: 
        m_estPresencePNDS = m_estPresencePNDS;
        break;
      case 132: 
        m_codeSousProduitRejet = m_codeSousProduitRejet;
        break;
      case 133: 
        m_presenceDerniersSalaires = m_presenceDerniersSalaires;
        break;
      case 134: 
        m_nombreMoisPreavis = m_nombreMoisPreavis;
        break;
      case 135: 
        m_identifiantPeriodeIncoherenceRessortissant = m_identifiantPeriodeIncoherenceRessortissant;
        break;
      case 136: 
        m_dureeAllongementArefPossible = m_dureeAllongementArefPossible;
        break;
      case 137: 
        m_dureeAllongementArefRealisee = m_dureeAllongementArefRealisee;
        break;
      case 138: 
        m_coefficientReducteurSJR = m_coefficientReducteurSJR;
        break;
      case 139: 
        m_plancherCoefReducteur = m_plancherCoefReducteur;
        break;
      case 140: 
        m_topPresenceDiffereARCE = m_topPresenceDiffereARCE;
        break;
      case 141: 
        m_diviseurIslr = m_diviseurIslr;
        break;
      case 142: 
        m_naturePeriodeSuspensive = m_naturePeriodeSuspensive;
        break;
      case 143: 
        m_dateFinPeriodeSuspensive = m_dateFinPeriodeSuspensive;
      }
    }
  }
  
  public void jdoCopyKeyFieldsToObjectId(Object object)
  {
    throw new JDOUnsupportedOptionException("Can't be used without Application Identity");
  }
  
  public void jdoCopyKeyFieldsToObjectId(PersistenceCapable.ObjectIdFieldSupplier supplier, Object object)
  {
    throw new JDOUnsupportedOptionException("Can't be used without Application Identity");
  }
  
  protected void jdoCopyKeyFieldsFromObjectId(Object object) {}
  
  public void jdoCopyKeyFieldsFromObjectId(PersistenceCapable.ObjectIdFieldConsumer consumer, Object object)
  {
    throw new JDOUnsupportedOptionException("Can't be used without Application Identity");
  }
  
  public Object jdoNewObjectIdInstance()
  {
    return null;
  }
  
  public Object jdoNewObjectIdInstance(Object str)
  {
    return null;
  }
  
  public Object jdoGetObjectId()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.getObjectId(this);
    }
    return null;
  }
  
  public PersistenceManager jdoGetPersistenceManager()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.getPersistenceManager(this);
    }
    return null;
  }
  
  private void jdoPreSerialize()
  {
    if (jdoStateManager != null) {
      jdoStateManager.preSerialize(this);
    }
  }
  
  private void writeObject(ObjectOutputStream out)
    throws IOException
  {
    jdoPreSerialize();
    out.defaultWriteObject();
  }
  
  public Object jdoGetTransactionalObjectId()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.getTransactionalObjectId(this);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     DecisionPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */