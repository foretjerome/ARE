package fr.unedic.cali.dom.pivot.pc;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.cali.dom.pivot.Attribution;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.temps.Damj;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
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

public class AttributionPC
  implements DomPCSpec, PersistenceCapable
{
  private transient Attribution m_attributionOM;
  protected int m_identifiantOuvertureDroit;
  protected int m_identifiantReprise;
  protected String m_identifiantDemandeCali;
  protected int m_identifiantOuvertureDroitAttributionPrecedente;
  protected String m_referenceExterneDemande;
  protected Damj m_dateEffetAttribution;
  protected Damj m_pji;
  protected String m_codeProduit;
  protected String m_codeProduitDroitCourant;
  protected String m_codeValidation;
  protected String m_codeValidationComplementaire;
  protected int m_nbJoursNonConsoDelaiDechance;
  protected int m_typeAerDroitRetenu;
  protected int m_typeAerDroitCourant;
  protected Damj m_djtp;
  protected String m_referenceReglementaireAffiliationDroitCourant;
  protected int m_dureeTheoriqueDroitCourant;
  protected Damj m_dateFinDelaiDecheance;
  protected String m_origineDecision;
  protected BigDecimal m_capitalOdPrecedente;
  protected BigDecimal m_capitalOdCourante;
  protected String m_typeChomageSaisonnier;
  protected BigDecimal m_capitalDroitPrecedentSp;
  protected Damj m_dateTheoriqueFinDroit;
  protected String m_plus100trimestres;
  protected int m_dureeTheoriqueDroitRetenu;
  protected String m_referenceReglementaireAffiliationDroitRetenu;
  protected String m_reglementApplicableCourant;
  protected String m_reglementApplicableRetenu;
  protected String m_idGaecPeriodeFg;
  protected String m_idGaecPeriodeRa;
  protected Damj m_fctRetenueOD;
  protected String m_motifFctRetenueOD;
  protected Damj m_dateDerniereFctDansDelaiForclusion;
  protected String m_motifDerniereFctDansDelaiForclusion;
  protected String m_complementSs;
  protected int m_regimeSs;
  protected String m_codeQualification;
  protected String m_codeQualificationDroitCourant;
  protected int m_codeMetier;
  protected int m_codeMetierDroitCourant;
  protected int m_codeStatutIndividu;
  protected String m_prcSjrForces;
  protected Damj m_dateDebutPrcDroitCourant;
  protected Damj m_dateFinPrcDroitCourant;
  protected BigDecimal m_montantSjrCourantNonPlafonne;
  protected BigDecimal m_montantSjrCourantCalculePlafonne;
  protected BigDecimal m_montantSjrCourantPlafonne;
  protected BigDecimal m_montantSalaireReferenceSjrCourant;
  protected BigDecimal m_nbJoursDiviseurSjrCourant;
  protected int m_nbHeuresTravailleesA8A10SjrCourant;
  protected BigDecimal m_coeffTempsPartielSjrCourant;
  protected BigDecimal m_coeffSaisonnierCalcSjrCourant;
  protected BigDecimal m_coeffSaisonnierForceSjrCourant;
  protected Damj m_finPrcSjrRetenu;
  protected BigDecimal m_montantSjrRetenuPlafonne;
  protected Damj m_dateEffetSjc;
  protected BigDecimal m_montantSjc;
  protected int m_nbJoursIccp;
  protected String m_uniteDureeIccp;
  protected Damj m_dateDebutIccp;
  protected Damj m_dateFinIccp;
  protected int m_nbJoursIslr;
  protected String m_uniteDureeIslr;
  protected Damj m_dateDebutIslr;
  protected Damj m_dateFinIslr;
  protected BigDecimal m_montantIslr;
  protected int m_nbJoursDiffere;
  protected String m_uniteDureeDiffere;
  protected Damj m_dateDebutDiffere;
  protected Damj m_dateFinDiffere;
  protected BigDecimal m_montantInitialCapitalMax;
  protected int m_flagReadmission;
  protected String m_regimeParticulier;
  protected int m_nbJoursActiviteCourrierASS;
  protected BigDecimal m_montantCarenceIccp;
  protected String m_codeSousProduitCourant;
  protected String m_codeSousProduitRetenu;
  protected int m_nombreHeureTravailleEtendu;
  protected int m_rangAllongementPRA;
  protected String m_situationParticuliereDroitCourant;
  protected String m_situationParticuliereDroitRetenu;
  protected String m_codeActiviteHorsFrance;
  protected String m_codePaysActivite;
  protected BigDecimal m_montantSalaireReferenceA10FNA;
  protected int m_rangAttributionAFDFiliereFNA;
  protected String m_typeFinancement;
  protected BigDecimal m_nbMoisRemboursesCoordEuropeenne;
  private String m_numeroConvention;
  private String m_codeAffectationConvention;
  private String m_idExterneEmployeurSp;
  private String m_fctEmployeurCompetent;
  protected Damj m_dateLimiteIndemnisation;
  private String m_auMoinsUneActiviteConservee;
  private String m_estDroitOption;
  private String m_estDroitApprenti;
  private BigDecimal m_nbJourEcretementPlafDuree;
  private int m_deltaDiffereSpectacle;
  protected BigDecimal m_montantAllocationJournaliereBrut;
  private String m_estDroitInterimaire;
  protected Collection m_collectionPeriodeAffiliation;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_identifiantOuvertureDroit", "m_identifiantReprise", "m_identifiantDemandeCali", "m_identifiantOuvertureDroitAttributionPrecedente", "m_referenceExterneDemande", "m_dateEffetAttribution", "m_pji", "m_codeProduit", "m_codeProduitDroitCourant", "m_codeValidation", "m_codeValidationComplementaire", "m_nbJoursNonConsoDelaiDechance", "m_typeAerDroitRetenu", "m_typeAerDroitCourant", "m_djtp", "m_referenceReglementaireAffiliationDroitCourant", "m_dureeTheoriqueDroitCourant", "m_dateFinDelaiDecheance", "m_origineDecision", "m_capitalOdPrecedente", "m_capitalOdCourante", "m_typeChomageSaisonnier", "m_capitalDroitPrecedentSp", "m_dateTheoriqueFinDroit", "m_plus100trimestres", "m_dureeTheoriqueDroitRetenu", "m_referenceReglementaireAffiliationDroitRetenu", "m_reglementApplicableCourant", "m_reglementApplicableRetenu", "m_idGaecPeriodeFg", "m_idGaecPeriodeRa", "m_fctRetenueOD", "m_motifFctRetenueOD", "m_dateDerniereFctDansDelaiForclusion", "m_motifDerniereFctDansDelaiForclusion", "m_complementSs", "m_regimeSs", "m_codeQualification", "m_codeQualificationDroitCourant", "m_codeMetier", "m_codeMetierDroitCourant", "m_codeStatutIndividu", "m_prcSjrForces", "m_dateDebutPrcDroitCourant", "m_dateFinPrcDroitCourant", "m_montantSjrCourantNonPlafonne", "m_montantSjrCourantCalculePlafonne", "m_montantSjrCourantPlafonne", "m_montantSalaireReferenceSjrCourant", "m_nbJoursDiviseurSjrCourant", "m_nbHeuresTravailleesA8A10SjrCourant", "m_coeffTempsPartielSjrCourant", "m_coeffSaisonnierCalcSjrCourant", "m_coeffSaisonnierForceSjrCourant", "m_finPrcSjrRetenu", "m_montantSjrRetenuPlafonne", "m_dateEffetSjc", "m_montantSjc", "m_nbJoursIccp", "m_uniteDureeIccp", "m_dateDebutIccp", "m_dateFinIccp", "m_nbJoursIslr", "m_uniteDureeIslr", "m_dateDebutIslr", "m_dateFinIslr", "m_montantIslr", "m_nbJoursDiffere", "m_uniteDureeDiffere", "m_dateDebutDiffere", "m_dateFinDiffere", "m_montantInitialCapitalMax", "m_flagReadmission", "m_regimeParticulier", "m_nbJoursActiviteCourrierASS", "m_montantCarenceIccp", "m_codeSousProduitCourant", "m_codeSousProduitRetenu", "m_nombreHeureTravailleEtendu", "m_rangAllongementPRA", "m_situationParticuliereDroitCourant", "m_situationParticuliereDroitRetenu", "m_codeActiviteHorsFrance", "m_codePaysActivite", "m_montantSalaireReferenceA10FNA", "m_rangAttributionAFDFiliereFNA", "m_typeFinancement", "m_nbMoisRemboursesCoordEuropeenne", "m_numeroConvention", "m_codeAffectationConvention", "m_idExterneEmployeurSp", "m_fctEmployeurCompetent", "m_dateLimiteIndemnisation", "m_auMoinsUneActiviteConservee", "m_estDroitOption", "m_estDroitApprenti", "m_nbJourEcretementPlafDuree", "m_deltaDiffereSpectacle", "m_montantAllocationJournaliereBrut", "m_estDroitInterimaire", "m_collectionPeriodeAffiliation" };
  private static Class[] jdoFieldTypes = { Integer.TYPE, Integer.TYPE, String.class, Integer.TYPE, String.class, Damj.class, Damj.class, String.class, String.class, String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Damj.class, String.class, Integer.TYPE, Damj.class, String.class, BigDecimal.class, BigDecimal.class, String.class, BigDecimal.class, Damj.class, String.class, Integer.TYPE, String.class, String.class, String.class, String.class, String.class, Damj.class, String.class, Damj.class, String.class, String.class, Integer.TYPE, String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class, Damj.class, Damj.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, Integer.TYPE, BigDecimal.class, BigDecimal.class, BigDecimal.class, Damj.class, BigDecimal.class, Damj.class, BigDecimal.class, Integer.TYPE, String.class, Damj.class, Damj.class, Integer.TYPE, String.class, Damj.class, Damj.class, BigDecimal.class, Integer.TYPE, String.class, Damj.class, Damj.class, BigDecimal.class, Integer.TYPE, String.class, Integer.TYPE, BigDecimal.class, String.class, String.class, Integer.TYPE, Integer.TYPE, String.class, String.class, String.class, String.class, BigDecimal.class, Integer.TYPE, String.class, BigDecimal.class, String.class, String.class, String.class, String.class, Damj.class, String.class, String.class, String.class, BigDecimal.class, Integer.TYPE, BigDecimal.class, String.class, Collection.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.MEDIATE_READ + PersistenceCapable.MEDIATE_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public AttributionPC()
  {
    jdoSetm_montantCarenceIccp(this, null);
  }
  
  public Object createOM()
  {
    if (m_attributionOM == null) {
      m_attributionOM = new Attribution(this);
    }
    return m_attributionOM;
  }
  
  public int getIdentifiantOuvertureDroit()
  {
    return jdoGetm_identifiantOuvertureDroit(this);
  }
  
  public final void setIdentifiantOuvertureDroit(int p_identifiantOuvertureDroit)
  {
    jdoSetm_identifiantOuvertureDroit(this, p_identifiantOuvertureDroit);
  }
  
  public int getIdentifiantReprise()
  {
    return jdoGetm_identifiantReprise(this);
  }
  
  public final void setIdentifiantReprise(int p_identifiantReprise)
  {
    jdoSetm_identifiantReprise(this, p_identifiantReprise);
  }
  
  public String getIdentifiantDemandeCali()
  {
    return jdoGetm_identifiantDemandeCali(this);
  }
  
  public final void setIdentifiantDemandeCali(String p_identifiantDemandeCali)
  {
    jdoSetm_identifiantDemandeCali(this, p_identifiantDemandeCali);
  }
  
  public int getIdentifiantOuvertureDroitAttributionPrecedente()
  {
    return jdoGetm_identifiantOuvertureDroitAttributionPrecedente(this);
  }
  
  public final void setIdentifiantOuvertureDroitAttributionPrecedente(int p_identifiantOuvertureDroitAttributionPrecedente)
  {
    jdoSetm_identifiantOuvertureDroitAttributionPrecedente(this, p_identifiantOuvertureDroitAttributionPrecedente);
  }
  
  public String getReferenceExterneDemande()
  {
    return jdoGetm_referenceExterneDemande(this);
  }
  
  public final void setReferenceExterneDemande(String p_referenceExterneDemande)
  {
    jdoSetm_referenceExterneDemande(this, p_referenceExterneDemande);
  }
  
  public Damj getDateEffetAttribution()
  {
    return jdoGetm_dateEffetAttribution(this);
  }
  
  public final void setDateEffetAttribution(Damj p_dateEffetAttribution)
  {
    jdoSetm_dateEffetAttribution(this, p_dateEffetAttribution);
  }
  
  public Damj getPji()
  {
    return jdoGetm_pji(this);
  }
  
  public final void setPji(Damj p_pji)
  {
    jdoSetm_pji(this, p_pji);
  }
  
  public String getCodeProduit()
  {
    return jdoGetm_codeProduit(this);
  }
  
  public final void setCodeProduit(String p_codeProduit)
  {
    jdoSetm_codeProduit(this, p_codeProduit);
  }
  
  public String getCodeProduitDroitCourant()
  {
    return jdoGetm_codeProduitDroitCourant(this);
  }
  
  public final void setCodeProduitDroitCourant(String p_codeProduitDroitCourant)
  {
    jdoSetm_codeProduitDroitCourant(this, p_codeProduitDroitCourant);
  }
  
  public String getCodeValidation()
  {
    return jdoGetm_codeValidation(this);
  }
  
  public final void setCodeValidation(String p_codeValidation)
  {
    jdoSetm_codeValidation(this, p_codeValidation);
  }
  
  public String getCodeValidationComplementaire()
  {
    return jdoGetm_codeValidationComplementaire(this);
  }
  
  public final void setCodeValidationComplementaire(String p_codeValidationComplementaire)
  {
    jdoSetm_codeValidationComplementaire(this, p_codeValidationComplementaire);
  }
  
  public int getNbJoursNonConsoDelaiDechance()
  {
    return jdoGetm_nbJoursNonConsoDelaiDechance(this);
  }
  
  public final void setNbJoursNonConsoDelaiDechance(int p_nbJoursNonConsoDelaiDechance)
  {
    jdoSetm_nbJoursNonConsoDelaiDechance(this, p_nbJoursNonConsoDelaiDechance);
  }
  
  public int getTypeAerDroitRetenu()
  {
    return jdoGetm_typeAerDroitRetenu(this);
  }
  
  public final void setTypeAerDroitRetenu(int p_typeAerDroitRetenu)
  {
    jdoSetm_typeAerDroitRetenu(this, p_typeAerDroitRetenu);
  }
  
  public int getTypeAerDroitCourant()
  {
    return jdoGetm_typeAerDroitCourant(this);
  }
  
  public final void setTypeAerDroitCourant(int p_typeAerDroitCourant)
  {
    jdoSetm_typeAerDroitCourant(this, p_typeAerDroitCourant);
  }
  
  public Damj getDjtp()
  {
    return jdoGetm_djtp(this);
  }
  
  public final void setDjtp(Damj p_djtp)
  {
    jdoSetm_djtp(this, p_djtp);
  }
  
  public String getReferenceReglementaireAffiliationDroitCourant()
  {
    return jdoGetm_referenceReglementaireAffiliationDroitCourant(this);
  }
  
  public final void setReferenceReglementaireAffiliationDroitCourant(String p_referenceReglementaireAffiliationDroitCourant)
  {
    jdoSetm_referenceReglementaireAffiliationDroitCourant(this, p_referenceReglementaireAffiliationDroitCourant);
  }
  
  public int getDureeTheoriqueDroitCourant()
  {
    return jdoGetm_dureeTheoriqueDroitCourant(this);
  }
  
  public final void setDureeTheoriqueDroitCourant(int p_dureeTheoriqueDroitCourant)
  {
    jdoSetm_dureeTheoriqueDroitCourant(this, p_dureeTheoriqueDroitCourant);
  }
  
  public Damj getDateFinDelaiDecheance()
  {
    return jdoGetm_dateFinDelaiDecheance(this);
  }
  
  public final void setDateFinDelaiDecheance(Damj p_dateFinDelaiDecheance)
  {
    jdoSetm_dateFinDelaiDecheance(this, p_dateFinDelaiDecheance);
  }
  
  public String getOrigineDecision()
  {
    return jdoGetm_origineDecision(this);
  }
  
  public final void setOrigineDecision(String p_origineDecision)
  {
    jdoSetm_origineDecision(this, p_origineDecision);
  }
  
  public BigDecimal getCapitalOdPrecedente()
  {
    return jdoGetm_capitalOdPrecedente(this);
  }
  
  public final void setCapitalOdPrecedente(BigDecimal p_capitalOdPrecedente)
  {
    jdoSetm_capitalOdPrecedente(this, p_capitalOdPrecedente);
  }
  
  public BigDecimal getCapitalOdCourante()
  {
    return jdoGetm_capitalOdCourante(this);
  }
  
  public final void setCapitalOdCourante(BigDecimal p_capitalOdCourante)
  {
    jdoSetm_capitalOdCourante(this, p_capitalOdCourante);
  }
  
  public String getTypeChomageSaisonnier()
  {
    return jdoGetm_typeChomageSaisonnier(this);
  }
  
  public final void setTypeChomageSaisonnier(String p_typeChomageSaisonnier)
  {
    jdoSetm_typeChomageSaisonnier(this, p_typeChomageSaisonnier);
  }
  
  public BigDecimal getCapitalDroitPrecedentSp()
  {
    return jdoGetm_capitalDroitPrecedentSp(this);
  }
  
  public final void setCapitalDroitPrecedentSp(BigDecimal p_capitalDroitPrecedentSp)
  {
    jdoSetm_capitalDroitPrecedentSp(this, p_capitalDroitPrecedentSp);
  }
  
  public Damj getDateTheoriqueFinDroit()
  {
    return jdoGetm_dateTheoriqueFinDroit(this);
  }
  
  public final void setDateTheoriqueFinDroit(Damj p_dateTheoriqueFinDroit)
  {
    jdoSetm_dateTheoriqueFinDroit(this, p_dateTheoriqueFinDroit);
  }
  
  public String getPlus100trimestres()
  {
    return jdoGetm_plus100trimestres(this);
  }
  
  public final void setPlus100trimestres(String p_plus100trimestres)
  {
    jdoSetm_plus100trimestres(this, p_plus100trimestres);
  }
  
  public int getDureeTheoriqueDroitRetenu()
  {
    return jdoGetm_dureeTheoriqueDroitRetenu(this);
  }
  
  public final void setDureeTheoriqueDroitRetenu(int p_dureeTheoriqueDroitRetenu)
  {
    jdoSetm_dureeTheoriqueDroitRetenu(this, p_dureeTheoriqueDroitRetenu);
  }
  
  public String getReferenceReglementaireAffiliationDroitRetenu()
  {
    return jdoGetm_referenceReglementaireAffiliationDroitRetenu(this);
  }
  
  public final void setReferenceReglementaireAffiliationDroitRetenu(String p_referenceReglementaireAffiliationDroitRetenu)
  {
    jdoSetm_referenceReglementaireAffiliationDroitRetenu(this, p_referenceReglementaireAffiliationDroitRetenu);
  }
  
  public String getReglementApplicableCourant()
  {
    return jdoGetm_reglementApplicableCourant(this);
  }
  
  public final void setReglementApplicableCourant(String p_reglementApplicableCourant)
  {
    jdoSetm_reglementApplicableCourant(this, p_reglementApplicableCourant);
  }
  
  public String getReglementApplicableRetenu()
  {
    return jdoGetm_reglementApplicableRetenu(this);
  }
  
  public final void setReglementApplicableRetenu(String p_reglementApplicableRetenu)
  {
    jdoSetm_reglementApplicableRetenu(this, p_reglementApplicableRetenu);
  }
  
  public String getIdGaecPeriodeFg()
  {
    return jdoGetm_idGaecPeriodeFg(this);
  }
  
  public final void setIdGaecPeriodeFg(String p_idGaecPeriodeFg)
  {
    jdoSetm_idGaecPeriodeFg(this, p_idGaecPeriodeFg);
  }
  
  public String getIdGaecPeriodeRa()
  {
    return jdoGetm_idGaecPeriodeRa(this);
  }
  
  public final void setIdGaecPeriodeRa(String p_idGaecPeriodeRa)
  {
    jdoSetm_idGaecPeriodeRa(this, p_idGaecPeriodeRa);
  }
  
  public Damj getFctRetenueOD()
  {
    return jdoGetm_fctRetenueOD(this);
  }
  
  public final void setFctRetenueOD(Damj p_fctRetenueOD)
  {
    jdoSetm_fctRetenueOD(this, p_fctRetenueOD);
  }
  
  public String getMotifFctRetenueOD()
  {
    return jdoGetm_motifFctRetenueOD(this);
  }
  
  public final void setMotifFctRetenueOD(String p_motifFctRetenueOD)
  {
    jdoSetm_motifFctRetenueOD(this, p_motifFctRetenueOD);
  }
  
  public Damj getDateDerniereFctDansDelaiForclusion()
  {
    return jdoGetm_dateDerniereFctDansDelaiForclusion(this);
  }
  
  public final void setDateDerniereFctDansDelaiForclusion(Damj p_dateDerniereFctDansDelaiForclusion)
  {
    jdoSetm_dateDerniereFctDansDelaiForclusion(this, p_dateDerniereFctDansDelaiForclusion);
  }
  
  public String getMotifDerniereFctDansDelaiForclusion()
  {
    return jdoGetm_motifDerniereFctDansDelaiForclusion(this);
  }
  
  public final void setMotifDerniereFctDansDelaiForclusion(String p_motifDerniereFctDansDelaiForclusion)
  {
    jdoSetm_motifDerniereFctDansDelaiForclusion(this, p_motifDerniereFctDansDelaiForclusion);
  }
  
  public String getComplementSs()
  {
    return jdoGetm_complementSs(this);
  }
  
  public final void setComplementSs(String p_complementSs)
  {
    jdoSetm_complementSs(this, p_complementSs);
  }
  
  public int getRegimeSs()
  {
    return jdoGetm_regimeSs(this);
  }
  
  public final void setRegimeSs(int p_regimeSs)
  {
    jdoSetm_regimeSs(this, p_regimeSs);
  }
  
  public String getCodeQualification()
  {
    return jdoGetm_codeQualification(this);
  }
  
  public final void setCodeQualification(String p_codeQualification)
  {
    jdoSetm_codeQualification(this, p_codeQualification);
  }
  
  public String getCodeQualificationDroitCourant()
  {
    return jdoGetm_codeQualificationDroitCourant(this);
  }
  
  public final void setCodeQualificationDroitCourant(String p_codeQualificationDroitCourant)
  {
    jdoSetm_codeQualificationDroitCourant(this, p_codeQualificationDroitCourant);
  }
  
  public int getCodeMetier()
  {
    return jdoGetm_codeMetier(this);
  }
  
  public final void setCodeMetier(int p_codeMetier)
  {
    jdoSetm_codeMetier(this, p_codeMetier);
  }
  
  public int getCodeMetierDroitCourant()
  {
    return jdoGetm_codeMetierDroitCourant(this);
  }
  
  public final void setCodeMetierDroitCourant(int p_codeMetierDroitCourant)
  {
    jdoSetm_codeMetierDroitCourant(this, p_codeMetierDroitCourant);
  }
  
  public int getCodeStatutIndividu()
  {
    return jdoGetm_codeStatutIndividu(this);
  }
  
  public final void setCodeStatutIndividu(int p_codeStatutIndividu)
  {
    jdoSetm_codeStatutIndividu(this, p_codeStatutIndividu);
  }
  
  public String getPrcSjrForces()
  {
    return jdoGetm_prcSjrForces(this);
  }
  
  public final void setPrcSjrForces(String p_prcSjrForces)
  {
    jdoSetm_prcSjrForces(this, p_prcSjrForces);
  }
  
  public Damj getDateDebutPrcDroitCourant()
  {
    return jdoGetm_dateDebutPrcDroitCourant(this);
  }
  
  public final void setDateDebutPrcDroitCourant(Damj p_dateDebutPrcDroitCourant)
  {
    jdoSetm_dateDebutPrcDroitCourant(this, p_dateDebutPrcDroitCourant);
  }
  
  public Damj getDateFinPrcDroitCourant()
  {
    return jdoGetm_dateFinPrcDroitCourant(this);
  }
  
  public final void setDateFinPrcDroitCourant(Damj p_dateFinPrcDroitCourant)
  {
    jdoSetm_dateFinPrcDroitCourant(this, p_dateFinPrcDroitCourant);
  }
  
  public BigDecimal getMontantSjrCourantNonPlafonne()
  {
    return jdoGetm_montantSjrCourantNonPlafonne(this);
  }
  
  public final void setMontantSjrCourantNonPlafonne(BigDecimal p_montantSjrCourantNonPlafonne)
  {
    jdoSetm_montantSjrCourantNonPlafonne(this, p_montantSjrCourantNonPlafonne);
  }
  
  public BigDecimal getMontantSjrCourantCalculePlafonne()
  {
    return jdoGetm_montantSjrCourantCalculePlafonne(this);
  }
  
  public final void setMontantSjrCourantCalculePlafonne(BigDecimal p_montantSjrCourantCalculePlafonne)
  {
    jdoSetm_montantSjrCourantCalculePlafonne(this, p_montantSjrCourantCalculePlafonne);
  }
  
  public BigDecimal getMontantSjrCourantPlafonne()
  {
    return jdoGetm_montantSjrCourantPlafonne(this);
  }
  
  public final void setMontantSjrCourantPlafonne(BigDecimal p_montantSjrCourantPlafonne)
  {
    jdoSetm_montantSjrCourantPlafonne(this, p_montantSjrCourantPlafonne);
  }
  
  public BigDecimal getMontantSalaireReferenceSjrCourant()
  {
    return jdoGetm_montantSalaireReferenceSjrCourant(this);
  }
  
  public final void setMontantSalaireReferenceSjrCourant(BigDecimal p_montantSalaireReferenceSjrCourant)
  {
    jdoSetm_montantSalaireReferenceSjrCourant(this, p_montantSalaireReferenceSjrCourant);
  }
  
  public BigDecimal getNbJoursDiviseurSjrCourant()
  {
    return jdoGetm_nbJoursDiviseurSjrCourant(this);
  }
  
  public final void setNbJoursDiviseurSjrCourant(BigDecimal p_nbJoursDiviseurSjrCourant)
  {
    jdoSetm_nbJoursDiviseurSjrCourant(this, p_nbJoursDiviseurSjrCourant);
  }
  
  public int getNbHeuresTravailleesA8A10SjrCourant()
  {
    return jdoGetm_nbHeuresTravailleesA8A10SjrCourant(this);
  }
  
  public final void setNbHeuresTravailleesA8A10SjrCourant(int p_nbHeuresTravailleesA8A10SjrCourant)
  {
    jdoSetm_nbHeuresTravailleesA8A10SjrCourant(this, p_nbHeuresTravailleesA8A10SjrCourant);
  }
  
  public BigDecimal getCoeffTempsPartielSjrCourant()
  {
    return jdoGetm_coeffTempsPartielSjrCourant(this);
  }
  
  public final void setCoeffTempsPartielSjrCourant(BigDecimal p_coeffTempsPartielSjrCourant)
  {
    jdoSetm_coeffTempsPartielSjrCourant(this, p_coeffTempsPartielSjrCourant);
  }
  
  public BigDecimal getCoeffSaisonnierCalcSjrCourant()
  {
    return jdoGetm_coeffSaisonnierCalcSjrCourant(this);
  }
  
  public final void setCoeffSaisonnierCalcSjrCourant(BigDecimal p_coeffSaisonnierCalcSjrCourant)
  {
    jdoSetm_coeffSaisonnierCalcSjrCourant(this, p_coeffSaisonnierCalcSjrCourant);
  }
  
  public BigDecimal getCoeffSaisonnierForceSjrCourant()
  {
    return jdoGetm_coeffSaisonnierForceSjrCourant(this);
  }
  
  public final void setCoeffSaisonnierForceSjrCourant(BigDecimal p_coeffSaisonnierForceSjrCourant)
  {
    jdoSetm_coeffSaisonnierForceSjrCourant(this, p_coeffSaisonnierForceSjrCourant);
  }
  
  public Damj getFinPrcSjrRetenu()
  {
    return jdoGetm_finPrcSjrRetenu(this);
  }
  
  public final void setFinPrcSjrRetenu(Damj p_finPrcSjrRetenu)
  {
    jdoSetm_finPrcSjrRetenu(this, p_finPrcSjrRetenu);
  }
  
  public BigDecimal getMontantSjrRetenuPlafonne()
  {
    return jdoGetm_montantSjrRetenuPlafonne(this);
  }
  
  public final void setMontantSjrRetenuPlafonne(BigDecimal p_montantSjrRetenuPlafonne)
  {
    jdoSetm_montantSjrRetenuPlafonne(this, p_montantSjrRetenuPlafonne);
  }
  
  public Damj getDateEffetSjc()
  {
    return jdoGetm_dateEffetSjc(this);
  }
  
  public final void setDateEffetSjc(Damj p_dateEffetSjc)
  {
    jdoSetm_dateEffetSjc(this, p_dateEffetSjc);
  }
  
  public BigDecimal getMontantSjc()
  {
    return jdoGetm_montantSjc(this);
  }
  
  public final void setMontantSjc(BigDecimal p_montantSjc)
  {
    jdoSetm_montantSjc(this, p_montantSjc);
  }
  
  public int getNbJoursIccp()
  {
    return jdoGetm_nbJoursIccp(this);
  }
  
  public final void setNbJoursIccp(int p_nbJoursIccp)
  {
    jdoSetm_nbJoursIccp(this, p_nbJoursIccp);
  }
  
  public String getUniteDureeIccp()
  {
    return jdoGetm_uniteDureeIccp(this);
  }
  
  public final void setUniteDureeIccp(String p_uniteDureeIccp)
  {
    jdoSetm_uniteDureeIccp(this, p_uniteDureeIccp);
  }
  
  public Damj getDateDebutIccp()
  {
    return jdoGetm_dateDebutIccp(this);
  }
  
  public final void setDateDebutIccp(Damj p_dateDebutIccp)
  {
    jdoSetm_dateDebutIccp(this, p_dateDebutIccp);
  }
  
  public Damj getDateFinIccp()
  {
    return jdoGetm_dateFinIccp(this);
  }
  
  public final void setDateFinIccp(Damj p_dateFinIccp)
  {
    jdoSetm_dateFinIccp(this, p_dateFinIccp);
  }
  
  public int getNbJoursIslr()
  {
    return jdoGetm_nbJoursIslr(this);
  }
  
  public final void setNbJoursIslr(int p_nbJoursIslr)
  {
    jdoSetm_nbJoursIslr(this, p_nbJoursIslr);
  }
  
  public String getUniteDureeIslr()
  {
    return jdoGetm_uniteDureeIslr(this);
  }
  
  public final void setUniteDureeIslr(String p_uniteDureeIslr)
  {
    jdoSetm_uniteDureeIslr(this, p_uniteDureeIslr);
  }
  
  public Damj getDateDebutIslr()
  {
    return jdoGetm_dateDebutIslr(this);
  }
  
  public final void setDateDebutIslr(Damj p_dateDebutIslr)
  {
    jdoSetm_dateDebutIslr(this, p_dateDebutIslr);
  }
  
  public Damj getDateFinIslr()
  {
    return jdoGetm_dateFinIslr(this);
  }
  
  public final void setDateFinIslr(Damj p_dateFinIslr)
  {
    jdoSetm_dateFinIslr(this, p_dateFinIslr);
  }
  
  public BigDecimal getMontantIslr()
  {
    return jdoGetm_montantIslr(this);
  }
  
  public final void setMontantIslr(BigDecimal p_montantIslr)
  {
    jdoSetm_montantIslr(this, p_montantIslr);
  }
  
  public int getNbJoursDiffere()
  {
    return jdoGetm_nbJoursDiffere(this);
  }
  
  public final void setNbJoursDiffere(int p_nbJoursDiffere)
  {
    jdoSetm_nbJoursDiffere(this, p_nbJoursDiffere);
  }
  
  public String getUniteDureeDiffere()
  {
    return jdoGetm_uniteDureeDiffere(this);
  }
  
  public final void setUniteDureeDiffere(String p_uniteDureeDiffere)
  {
    jdoSetm_uniteDureeDiffere(this, p_uniteDureeDiffere);
  }
  
  public Damj getDateDebutDiffere()
  {
    return jdoGetm_dateDebutDiffere(this);
  }
  
  public final void setDateDebutDiffere(Damj p_dateDebutDiffere)
  {
    jdoSetm_dateDebutDiffere(this, p_dateDebutDiffere);
  }
  
  public Damj getDateFinDiffere()
  {
    return jdoGetm_dateFinDiffere(this);
  }
  
  public final void setDateFinDiffere(Damj p_dateFinDiffere)
  {
    jdoSetm_dateFinDiffere(this, p_dateFinDiffere);
  }
  
  public BigDecimal getMontantInitialCapitalMax()
  {
    return jdoGetm_montantInitialCapitalMax(this);
  }
  
  public final void setMontantInitialCapitalMax(BigDecimal p_montantInitialCapitalMax)
  {
    jdoSetm_montantInitialCapitalMax(this, p_montantInitialCapitalMax);
  }
  
  public int getFlagReadmission()
  {
    return jdoGetm_flagReadmission(this);
  }
  
  public final void setFlagReadmission(int p_flagReadmission)
  {
    jdoSetm_flagReadmission(this, p_flagReadmission);
  }
  
  public String getRegimeParticulier()
  {
    return jdoGetm_regimeParticulier(this);
  }
  
  public final void setRegimeParticulier(String p_regimeParticulier)
  {
    jdoSetm_regimeParticulier(this, p_regimeParticulier);
  }
  
  public int getNbJoursActiviteCourrierASS()
  {
    return jdoGetm_nbJoursActiviteCourrierASS(this);
  }
  
  public final void setNbJoursActiviteCourrierASS(int p_nbJoursActiviteCourrierASS)
  {
    jdoSetm_nbJoursActiviteCourrierASS(this, p_nbJoursActiviteCourrierASS);
  }
  
  public BigDecimal getMontantCarenceIccp()
  {
    return jdoGetm_montantCarenceIccp(this);
  }
  
  public final void setMontantCarenceIccp(BigDecimal p_montantCarenceIccp)
  {
    jdoSetm_montantCarenceIccp(this, p_montantCarenceIccp);
  }
  
  public String getCodeSousProduitCourant()
  {
    return jdoGetm_codeSousProduitCourant(this);
  }
  
  public final void setCodeSousProduitCourant(String p_codeSousProduitCourant)
  {
    jdoSetm_codeSousProduitCourant(this, p_codeSousProduitCourant);
  }
  
  public String getCodeSousProduitRetenu()
  {
    return jdoGetm_codeSousProduitRetenu(this);
  }
  
  public final void setCodeSousProduitRetenu(String p_codeSousProduitRetenu)
  {
    jdoSetm_codeSousProduitRetenu(this, p_codeSousProduitRetenu);
  }
  
  public int getNombreHeureTravailleEtendu()
  {
    return jdoGetm_nombreHeureTravailleEtendu(this);
  }
  
  public final void setNombreHeureTravailleEtendu(int p_nombreHeureTravailleEtendu)
  {
    jdoSetm_nombreHeureTravailleEtendu(this, p_nombreHeureTravailleEtendu);
  }
  
  public int getRangAllongementPRA()
  {
    return jdoGetm_rangAllongementPRA(this);
  }
  
  public final void setRangAllongementPRA(int p_rangAllongementPRA)
  {
    jdoSetm_rangAllongementPRA(this, p_rangAllongementPRA);
  }
  
  public String getSituationParticuliereDroitCourant()
  {
    return jdoGetm_situationParticuliereDroitCourant(this);
  }
  
  public final void setSituationParticuliereDroitCourant(String p_situationParticuliereDroitCourant)
  {
    jdoSetm_situationParticuliereDroitCourant(this, p_situationParticuliereDroitCourant);
  }
  
  public String getSituationParticuliereDroitRetenu()
  {
    return jdoGetm_situationParticuliereDroitRetenu(this);
  }
  
  public final void setSituationParticuliereDroitRetenu(String p_situationParticuliereDroitRetenu)
  {
    jdoSetm_situationParticuliereDroitRetenu(this, p_situationParticuliereDroitRetenu);
  }
  
  public String getCodeActiviteHorsFrance()
  {
    return jdoGetm_codeActiviteHorsFrance(this);
  }
  
  public final void setCodeActiviteHorsFrance(String p_codeActiviteHorsFrance)
  {
    jdoSetm_codeActiviteHorsFrance(this, p_codeActiviteHorsFrance);
  }
  
  public String getCodePaysActivite()
  {
    return jdoGetm_codePaysActivite(this);
  }
  
  public final void setCodePaysActivite(String p_codePaysActivite)
  {
    jdoSetm_codePaysActivite(this, p_codePaysActivite);
  }
  
  public BigDecimal getMontantSalaireReferenceA10FNA()
  {
    return jdoGetm_montantSalaireReferenceA10FNA(this);
  }
  
  public final void setMontantSalaireReferenceA10FNA(BigDecimal p_montantSalaireReferenceA10FNA)
  {
    jdoSetm_montantSalaireReferenceA10FNA(this, p_montantSalaireReferenceA10FNA);
  }
  
  public int getRangAttributionAFDFiliereFNA()
  {
    return jdoGetm_rangAttributionAFDFiliereFNA(this);
  }
  
  public final void setRangAttributionAFDFiliereFNA(int p_rangAttributionAFDFiliereFNA)
  {
    jdoSetm_rangAttributionAFDFiliereFNA(this, p_rangAttributionAFDFiliereFNA);
  }
  
  public String getTypeFinancement()
  {
    return jdoGetm_typeFinancement(this);
  }
  
  public final void setTypeFinancement(String p_typeFinancement)
  {
    jdoSetm_typeFinancement(this, p_typeFinancement);
  }
  
  public BigDecimal getNbMoisRemboursesCoordEuropeenne()
  {
    return jdoGetm_nbMoisRemboursesCoordEuropeenne(this);
  }
  
  public final void setNbMoisRemboursesCoordEuropeenne(BigDecimal p_nbMoisRemboursesCoordEuropeenne)
  {
    jdoSetm_nbMoisRemboursesCoordEuropeenne(this, p_nbMoisRemboursesCoordEuropeenne);
  }
  
  public String getNumeroConvention()
  {
    return jdoGetm_numeroConvention(this);
  }
  
  public final void setNumeroConvention(String p_numeroConvention)
  {
    jdoSetm_numeroConvention(this, p_numeroConvention);
  }
  
  public String getCodeAffectationConvention()
  {
    return jdoGetm_codeAffectationConvention(this);
  }
  
  public final void setCodeAffectationConvention(String p_codeAffectationConvention)
  {
    jdoSetm_codeAffectationConvention(this, p_codeAffectationConvention);
  }
  
  public String getIdExterneEmployeurSp()
  {
    return jdoGetm_idExterneEmployeurSp(this);
  }
  
  public final void setIdExterneEmployeurSp(String p_idExterneEmployeurSp)
  {
    jdoSetm_idExterneEmployeurSp(this, p_idExterneEmployeurSp);
  }
  
  public String getFctEmployeurCompetent()
  {
    return jdoGetm_fctEmployeurCompetent(this);
  }
  
  public final void setFctEmployeurCompetent(String p_fctEmployeurCompetent)
  {
    jdoSetm_fctEmployeurCompetent(this, p_fctEmployeurCompetent);
  }
  
  public Damj getDateLimiteIndemnisation()
  {
    return jdoGetm_dateLimiteIndemnisation(this);
  }
  
  public final void setDateLimiteIndemnisation(Damj p_dateLimiteIndemnisation)
  {
    jdoSetm_dateLimiteIndemnisation(this, p_dateLimiteIndemnisation);
  }
  
  public String getAuMoinsUneActiviteConservee()
  {
    return jdoGetm_auMoinsUneActiviteConservee(this);
  }
  
  public final void setAuMoinsUneActiviteConservee(String p_auMoinsUneActiviteConservee)
  {
    jdoSetm_auMoinsUneActiviteConservee(this, p_auMoinsUneActiviteConservee);
  }
  
  public String getEstDroitOption()
  {
    return jdoGetm_estDroitOption(this);
  }
  
  public final void setEstDroitOption(String p_estDroitOption)
  {
    jdoSetm_estDroitOption(this, p_estDroitOption);
  }
  
  public String getEstDroitApprenti()
  {
    return jdoGetm_estDroitApprenti(this);
  }
  
  public final void setEstDroitApprenti(String p_estDroitApprenti)
  {
    jdoSetm_estDroitApprenti(this, p_estDroitApprenti);
  }
  
  public BigDecimal getNbJourEcretementPlafDuree()
  {
    return jdoGetm_nbJourEcretementPlafDuree(this);
  }
  
  public final void setNbJourEcretementPlafDuree(BigDecimal p_nbJourEcretementPlafDuree)
  {
    jdoSetm_nbJourEcretementPlafDuree(this, p_nbJourEcretementPlafDuree);
  }
  
  public int getDeltaDiffereSpectacle()
  {
    return jdoGetm_deltaDiffereSpectacle(this);
  }
  
  public final void setDeltaDiffereSpectacle(int p_deltaDiffereSpectacle)
  {
    jdoSetm_deltaDiffereSpectacle(this, p_deltaDiffereSpectacle);
  }
  
  public BigDecimal getMontantAllocationJournaliereBrut()
  {
    return jdoGetm_montantAllocationJournaliereBrut(this);
  }
  
  public final void setMontantAllocationJournaliereBrut(BigDecimal p_montantAllocationJournaliereBrut)
  {
    jdoSetm_montantAllocationJournaliereBrut(this, p_montantAllocationJournaliereBrut);
  }
  
  public String getEstDroitInterimaire()
  {
    return jdoGetm_estDroitInterimaire(this);
  }
  
  public final void setEstDroitInterimaire(String p_estDroitInterimaire)
  {
    jdoSetm_estDroitInterimaire(this, p_estDroitInterimaire);
  }
  
  public final Collection getCollectionPeriodeAffiliation()
  {
    if (jdoGetm_collectionPeriodeAffiliation(this) == null) {
      jdoSetm_collectionPeriodeAffiliation(this, new ArrayList());
    }
    return jdoGetm_collectionPeriodeAffiliation(this);
  }
  
  public final void ajouterPeriodeAffiliation(DomPCSpec p_periodeAffiliation)
    throws NullPointerException
  {
    if (p_periodeAffiliation == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periodeAffiliation ne devrait pas être nul.", p_periodeAffiliation);
    }
    getCollectionPeriodeAffiliation().add(p_periodeAffiliation);
  }
  
  public final void supprimerPeriodeAffiliation(DomPCSpec p_periodeAffiliation)
    throws NullPointerException
  {
    if (p_periodeAffiliation == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periodeAffiliation ne devrait pas être nul.", p_periodeAffiliation);
    }
    getCollectionPeriodeAffiliation().remove(p_periodeAffiliation);
  }
  
  static
  {
    JDOImplHelper.registerClass(AttributionPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new AttributionPC());
  }
  
  protected static final int jdoGetm_identifiantOuvertureDroit(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantOuvertureDroit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_identifiantOuvertureDroit;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 0, m_identifiantOuvertureDroit);
    }
    return m_identifiantOuvertureDroit;
  }
  
  protected static final int jdoGetm_identifiantReprise(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantReprise;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_identifiantReprise;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 1, m_identifiantReprise);
    }
    return m_identifiantReprise;
  }
  
  protected static final String jdoGetm_identifiantDemandeCali(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantDemandeCali;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_identifiantDemandeCali;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 2, m_identifiantDemandeCali);
    }
    return m_identifiantDemandeCali;
  }
  
  protected static final int jdoGetm_identifiantOuvertureDroitAttributionPrecedente(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantOuvertureDroitAttributionPrecedente;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_identifiantOuvertureDroitAttributionPrecedente;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 3, m_identifiantOuvertureDroitAttributionPrecedente);
    }
    return m_identifiantOuvertureDroitAttributionPrecedente;
  }
  
  protected static final String jdoGetm_referenceExterneDemande(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_referenceExterneDemande;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_referenceExterneDemande;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 4, m_referenceExterneDemande);
    }
    return m_referenceExterneDemande;
  }
  
  protected static final Damj jdoGetm_dateEffetAttribution(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateEffetAttribution;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_dateEffetAttribution;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 5, m_dateEffetAttribution);
    }
    return m_dateEffetAttribution;
  }
  
  protected static final Damj jdoGetm_pji(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_pji;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_pji;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 6, m_pji);
    }
    return m_pji;
  }
  
  protected static final String jdoGetm_codeProduit(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeProduit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_codeProduit;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 7, m_codeProduit);
    }
    return m_codeProduit;
  }
  
  protected static final String jdoGetm_codeProduitDroitCourant(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeProduitDroitCourant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_codeProduitDroitCourant;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 8, m_codeProduitDroitCourant);
    }
    return m_codeProduitDroitCourant;
  }
  
  protected static final String jdoGetm_codeValidation(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeValidation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 9)) {
        return m_codeValidation;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 9, m_codeValidation);
    }
    return m_codeValidation;
  }
  
  protected static final String jdoGetm_codeValidationComplementaire(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeValidationComplementaire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 10)) {
        return m_codeValidationComplementaire;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 10, m_codeValidationComplementaire);
    }
    return m_codeValidationComplementaire;
  }
  
  protected static final int jdoGetm_nbJoursNonConsoDelaiDechance(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJoursNonConsoDelaiDechance;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 11)) {
        return m_nbJoursNonConsoDelaiDechance;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 11, m_nbJoursNonConsoDelaiDechance);
    }
    return m_nbJoursNonConsoDelaiDechance;
  }
  
  protected static final int jdoGetm_typeAerDroitRetenu(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeAerDroitRetenu;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 12)) {
        return m_typeAerDroitRetenu;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 12, m_typeAerDroitRetenu);
    }
    return m_typeAerDroitRetenu;
  }
  
  protected static final int jdoGetm_typeAerDroitCourant(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeAerDroitCourant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 13)) {
        return m_typeAerDroitCourant;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 13, m_typeAerDroitCourant);
    }
    return m_typeAerDroitCourant;
  }
  
  protected static final Damj jdoGetm_djtp(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_djtp;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 14)) {
        return m_djtp;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 14, m_djtp);
    }
    return m_djtp;
  }
  
  protected static final String jdoGetm_referenceReglementaireAffiliationDroitCourant(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_referenceReglementaireAffiliationDroitCourant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 15)) {
        return m_referenceReglementaireAffiliationDroitCourant;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 15, m_referenceReglementaireAffiliationDroitCourant);
    }
    return m_referenceReglementaireAffiliationDroitCourant;
  }
  
  protected static final int jdoGetm_dureeTheoriqueDroitCourant(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeTheoriqueDroitCourant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 16)) {
        return m_dureeTheoriqueDroitCourant;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 16, m_dureeTheoriqueDroitCourant);
    }
    return m_dureeTheoriqueDroitCourant;
  }
  
  protected static final Damj jdoGetm_dateFinDelaiDecheance(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinDelaiDecheance;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 17)) {
        return m_dateFinDelaiDecheance;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 17, m_dateFinDelaiDecheance);
    }
    return m_dateFinDelaiDecheance;
  }
  
  protected static final String jdoGetm_origineDecision(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_origineDecision;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 18)) {
        return m_origineDecision;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 18, m_origineDecision);
    }
    return m_origineDecision;
  }
  
  protected static final BigDecimal jdoGetm_capitalOdPrecedente(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_capitalOdPrecedente;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 19)) {
        return m_capitalOdPrecedente;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 19, m_capitalOdPrecedente);
    }
    return m_capitalOdPrecedente;
  }
  
  protected static final BigDecimal jdoGetm_capitalOdCourante(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_capitalOdCourante;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 20)) {
        return m_capitalOdCourante;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 20, m_capitalOdCourante);
    }
    return m_capitalOdCourante;
  }
  
  protected static final String jdoGetm_typeChomageSaisonnier(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeChomageSaisonnier;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 21)) {
        return m_typeChomageSaisonnier;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 21, m_typeChomageSaisonnier);
    }
    return m_typeChomageSaisonnier;
  }
  
  protected static final BigDecimal jdoGetm_capitalDroitPrecedentSp(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_capitalDroitPrecedentSp;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 22)) {
        return m_capitalDroitPrecedentSp;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 22, m_capitalDroitPrecedentSp);
    }
    return m_capitalDroitPrecedentSp;
  }
  
  protected static final Damj jdoGetm_dateTheoriqueFinDroit(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateTheoriqueFinDroit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 23)) {
        return m_dateTheoriqueFinDroit;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 23, m_dateTheoriqueFinDroit);
    }
    return m_dateTheoriqueFinDroit;
  }
  
  protected static final String jdoGetm_plus100trimestres(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_plus100trimestres;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 24)) {
        return m_plus100trimestres;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 24, m_plus100trimestres);
    }
    return m_plus100trimestres;
  }
  
  protected static final int jdoGetm_dureeTheoriqueDroitRetenu(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeTheoriqueDroitRetenu;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 25)) {
        return m_dureeTheoriqueDroitRetenu;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 25, m_dureeTheoriqueDroitRetenu);
    }
    return m_dureeTheoriqueDroitRetenu;
  }
  
  protected static final String jdoGetm_referenceReglementaireAffiliationDroitRetenu(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_referenceReglementaireAffiliationDroitRetenu;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 26)) {
        return m_referenceReglementaireAffiliationDroitRetenu;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 26, m_referenceReglementaireAffiliationDroitRetenu);
    }
    return m_referenceReglementaireAffiliationDroitRetenu;
  }
  
  protected static final String jdoGetm_reglementApplicableCourant(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reglementApplicableCourant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 27)) {
        return m_reglementApplicableCourant;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 27, m_reglementApplicableCourant);
    }
    return m_reglementApplicableCourant;
  }
  
  protected static final String jdoGetm_reglementApplicableRetenu(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reglementApplicableRetenu;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 28)) {
        return m_reglementApplicableRetenu;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 28, m_reglementApplicableRetenu);
    }
    return m_reglementApplicableRetenu;
  }
  
  protected static final String jdoGetm_idGaecPeriodeFg(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_idGaecPeriodeFg;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 29)) {
        return m_idGaecPeriodeFg;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 29, m_idGaecPeriodeFg);
    }
    return m_idGaecPeriodeFg;
  }
  
  protected static final String jdoGetm_idGaecPeriodeRa(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_idGaecPeriodeRa;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 30)) {
        return m_idGaecPeriodeRa;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 30, m_idGaecPeriodeRa);
    }
    return m_idGaecPeriodeRa;
  }
  
  protected static final Damj jdoGetm_fctRetenueOD(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_fctRetenueOD;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 31)) {
        return m_fctRetenueOD;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 31, m_fctRetenueOD);
    }
    return m_fctRetenueOD;
  }
  
  protected static final String jdoGetm_motifFctRetenueOD(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_motifFctRetenueOD;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 32)) {
        return m_motifFctRetenueOD;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 32, m_motifFctRetenueOD);
    }
    return m_motifFctRetenueOD;
  }
  
  protected static final Damj jdoGetm_dateDerniereFctDansDelaiForclusion(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDerniereFctDansDelaiForclusion;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 33)) {
        return m_dateDerniereFctDansDelaiForclusion;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 33, m_dateDerniereFctDansDelaiForclusion);
    }
    return m_dateDerniereFctDansDelaiForclusion;
  }
  
  protected static final String jdoGetm_motifDerniereFctDansDelaiForclusion(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_motifDerniereFctDansDelaiForclusion;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 34)) {
        return m_motifDerniereFctDansDelaiForclusion;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 34, m_motifDerniereFctDansDelaiForclusion);
    }
    return m_motifDerniereFctDansDelaiForclusion;
  }
  
  protected static final String jdoGetm_complementSs(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementSs;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 35)) {
        return m_complementSs;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 35, m_complementSs);
    }
    return m_complementSs;
  }
  
  protected static final int jdoGetm_regimeSs(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_regimeSs;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 36)) {
        return m_regimeSs;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 36, m_regimeSs);
    }
    return m_regimeSs;
  }
  
  protected static final String jdoGetm_codeQualification(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeQualification;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 37)) {
        return m_codeQualification;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 37, m_codeQualification);
    }
    return m_codeQualification;
  }
  
  protected static final String jdoGetm_codeQualificationDroitCourant(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeQualificationDroitCourant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 38)) {
        return m_codeQualificationDroitCourant;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 38, m_codeQualificationDroitCourant);
    }
    return m_codeQualificationDroitCourant;
  }
  
  protected static final int jdoGetm_codeMetier(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeMetier;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 39)) {
        return m_codeMetier;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 39, m_codeMetier);
    }
    return m_codeMetier;
  }
  
  protected static final int jdoGetm_codeMetierDroitCourant(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeMetierDroitCourant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 40)) {
        return m_codeMetierDroitCourant;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 40, m_codeMetierDroitCourant);
    }
    return m_codeMetierDroitCourant;
  }
  
  protected static final int jdoGetm_codeStatutIndividu(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeStatutIndividu;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 41)) {
        return m_codeStatutIndividu;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 41, m_codeStatutIndividu);
    }
    return m_codeStatutIndividu;
  }
  
  protected static final String jdoGetm_prcSjrForces(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_prcSjrForces;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 42)) {
        return m_prcSjrForces;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 42, m_prcSjrForces);
    }
    return m_prcSjrForces;
  }
  
  protected static final Damj jdoGetm_dateDebutPrcDroitCourant(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebutPrcDroitCourant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 43)) {
        return m_dateDebutPrcDroitCourant;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 43, m_dateDebutPrcDroitCourant);
    }
    return m_dateDebutPrcDroitCourant;
  }
  
  protected static final Damj jdoGetm_dateFinPrcDroitCourant(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinPrcDroitCourant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 44)) {
        return m_dateFinPrcDroitCourant;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 44, m_dateFinPrcDroitCourant);
    }
    return m_dateFinPrcDroitCourant;
  }
  
  protected static final BigDecimal jdoGetm_montantSjrCourantNonPlafonne(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantSjrCourantNonPlafonne;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 45)) {
        return m_montantSjrCourantNonPlafonne;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 45, m_montantSjrCourantNonPlafonne);
    }
    return m_montantSjrCourantNonPlafonne;
  }
  
  protected static final BigDecimal jdoGetm_montantSjrCourantCalculePlafonne(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantSjrCourantCalculePlafonne;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 46)) {
        return m_montantSjrCourantCalculePlafonne;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 46, m_montantSjrCourantCalculePlafonne);
    }
    return m_montantSjrCourantCalculePlafonne;
  }
  
  protected static final BigDecimal jdoGetm_montantSjrCourantPlafonne(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantSjrCourantPlafonne;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 47)) {
        return m_montantSjrCourantPlafonne;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 47, m_montantSjrCourantPlafonne);
    }
    return m_montantSjrCourantPlafonne;
  }
  
  protected static final BigDecimal jdoGetm_montantSalaireReferenceSjrCourant(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantSalaireReferenceSjrCourant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 48)) {
        return m_montantSalaireReferenceSjrCourant;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 48, m_montantSalaireReferenceSjrCourant);
    }
    return m_montantSalaireReferenceSjrCourant;
  }
  
  protected static final BigDecimal jdoGetm_nbJoursDiviseurSjrCourant(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJoursDiviseurSjrCourant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 49)) {
        return m_nbJoursDiviseurSjrCourant;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 49, m_nbJoursDiviseurSjrCourant);
    }
    return m_nbJoursDiviseurSjrCourant;
  }
  
  protected static final int jdoGetm_nbHeuresTravailleesA8A10SjrCourant(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbHeuresTravailleesA8A10SjrCourant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 50)) {
        return m_nbHeuresTravailleesA8A10SjrCourant;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 50, m_nbHeuresTravailleesA8A10SjrCourant);
    }
    return m_nbHeuresTravailleesA8A10SjrCourant;
  }
  
  protected static final BigDecimal jdoGetm_coeffTempsPartielSjrCourant(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_coeffTempsPartielSjrCourant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 51)) {
        return m_coeffTempsPartielSjrCourant;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 51, m_coeffTempsPartielSjrCourant);
    }
    return m_coeffTempsPartielSjrCourant;
  }
  
  protected static final BigDecimal jdoGetm_coeffSaisonnierCalcSjrCourant(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_coeffSaisonnierCalcSjrCourant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 52)) {
        return m_coeffSaisonnierCalcSjrCourant;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 52, m_coeffSaisonnierCalcSjrCourant);
    }
    return m_coeffSaisonnierCalcSjrCourant;
  }
  
  protected static final BigDecimal jdoGetm_coeffSaisonnierForceSjrCourant(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_coeffSaisonnierForceSjrCourant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 53)) {
        return m_coeffSaisonnierForceSjrCourant;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 53, m_coeffSaisonnierForceSjrCourant);
    }
    return m_coeffSaisonnierForceSjrCourant;
  }
  
  protected static final Damj jdoGetm_finPrcSjrRetenu(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_finPrcSjrRetenu;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 54)) {
        return m_finPrcSjrRetenu;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 54, m_finPrcSjrRetenu);
    }
    return m_finPrcSjrRetenu;
  }
  
  protected static final BigDecimal jdoGetm_montantSjrRetenuPlafonne(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantSjrRetenuPlafonne;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 55)) {
        return m_montantSjrRetenuPlafonne;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 55, m_montantSjrRetenuPlafonne);
    }
    return m_montantSjrRetenuPlafonne;
  }
  
  protected static final Damj jdoGetm_dateEffetSjc(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateEffetSjc;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 56)) {
        return m_dateEffetSjc;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 56, m_dateEffetSjc);
    }
    return m_dateEffetSjc;
  }
  
  protected static final BigDecimal jdoGetm_montantSjc(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantSjc;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 57)) {
        return m_montantSjc;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 57, m_montantSjc);
    }
    return m_montantSjc;
  }
  
  protected static final int jdoGetm_nbJoursIccp(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJoursIccp;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 58)) {
        return m_nbJoursIccp;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 58, m_nbJoursIccp);
    }
    return m_nbJoursIccp;
  }
  
  protected static final String jdoGetm_uniteDureeIccp(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_uniteDureeIccp;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 59)) {
        return m_uniteDureeIccp;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 59, m_uniteDureeIccp);
    }
    return m_uniteDureeIccp;
  }
  
  protected static final Damj jdoGetm_dateDebutIccp(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebutIccp;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 60)) {
        return m_dateDebutIccp;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 60, m_dateDebutIccp);
    }
    return m_dateDebutIccp;
  }
  
  protected static final Damj jdoGetm_dateFinIccp(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinIccp;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 61)) {
        return m_dateFinIccp;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 61, m_dateFinIccp);
    }
    return m_dateFinIccp;
  }
  
  protected static final int jdoGetm_nbJoursIslr(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJoursIslr;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 62)) {
        return m_nbJoursIslr;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 62, m_nbJoursIslr);
    }
    return m_nbJoursIslr;
  }
  
  protected static final String jdoGetm_uniteDureeIslr(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_uniteDureeIslr;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 63)) {
        return m_uniteDureeIslr;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 63, m_uniteDureeIslr);
    }
    return m_uniteDureeIslr;
  }
  
  protected static final Damj jdoGetm_dateDebutIslr(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebutIslr;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 64)) {
        return m_dateDebutIslr;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 64, m_dateDebutIslr);
    }
    return m_dateDebutIslr;
  }
  
  protected static final Damj jdoGetm_dateFinIslr(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinIslr;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 65)) {
        return m_dateFinIslr;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 65, m_dateFinIslr);
    }
    return m_dateFinIslr;
  }
  
  protected static final BigDecimal jdoGetm_montantIslr(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantIslr;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 66)) {
        return m_montantIslr;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 66, m_montantIslr);
    }
    return m_montantIslr;
  }
  
  protected static final int jdoGetm_nbJoursDiffere(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJoursDiffere;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 67)) {
        return m_nbJoursDiffere;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 67, m_nbJoursDiffere);
    }
    return m_nbJoursDiffere;
  }
  
  protected static final String jdoGetm_uniteDureeDiffere(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_uniteDureeDiffere;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 68)) {
        return m_uniteDureeDiffere;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 68, m_uniteDureeDiffere);
    }
    return m_uniteDureeDiffere;
  }
  
  protected static final Damj jdoGetm_dateDebutDiffere(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebutDiffere;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 69)) {
        return m_dateDebutDiffere;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 69, m_dateDebutDiffere);
    }
    return m_dateDebutDiffere;
  }
  
  protected static final Damj jdoGetm_dateFinDiffere(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinDiffere;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 70)) {
        return m_dateFinDiffere;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 70, m_dateFinDiffere);
    }
    return m_dateFinDiffere;
  }
  
  protected static final BigDecimal jdoGetm_montantInitialCapitalMax(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantInitialCapitalMax;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 71)) {
        return m_montantInitialCapitalMax;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 71, m_montantInitialCapitalMax);
    }
    return m_montantInitialCapitalMax;
  }
  
  protected static final int jdoGetm_flagReadmission(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_flagReadmission;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 72)) {
        return m_flagReadmission;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 72, m_flagReadmission);
    }
    return m_flagReadmission;
  }
  
  protected static final String jdoGetm_regimeParticulier(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_regimeParticulier;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 73)) {
        return m_regimeParticulier;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 73, m_regimeParticulier);
    }
    return m_regimeParticulier;
  }
  
  protected static final int jdoGetm_nbJoursActiviteCourrierASS(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJoursActiviteCourrierASS;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 74)) {
        return m_nbJoursActiviteCourrierASS;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 74, m_nbJoursActiviteCourrierASS);
    }
    return m_nbJoursActiviteCourrierASS;
  }
  
  protected static final BigDecimal jdoGetm_montantCarenceIccp(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantCarenceIccp;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 75)) {
        return m_montantCarenceIccp;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 75, m_montantCarenceIccp);
    }
    return m_montantCarenceIccp;
  }
  
  protected static final String jdoGetm_codeSousProduitCourant(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeSousProduitCourant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 76)) {
        return m_codeSousProduitCourant;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 76, m_codeSousProduitCourant);
    }
    return m_codeSousProduitCourant;
  }
  
  protected static final String jdoGetm_codeSousProduitRetenu(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeSousProduitRetenu;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 77)) {
        return m_codeSousProduitRetenu;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 77, m_codeSousProduitRetenu);
    }
    return m_codeSousProduitRetenu;
  }
  
  protected static final int jdoGetm_nombreHeureTravailleEtendu(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nombreHeureTravailleEtendu;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 78)) {
        return m_nombreHeureTravailleEtendu;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 78, m_nombreHeureTravailleEtendu);
    }
    return m_nombreHeureTravailleEtendu;
  }
  
  protected static final int jdoGetm_rangAllongementPRA(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_rangAllongementPRA;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 79)) {
        return m_rangAllongementPRA;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 79, m_rangAllongementPRA);
    }
    return m_rangAllongementPRA;
  }
  
  protected static final String jdoGetm_situationParticuliereDroitCourant(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_situationParticuliereDroitCourant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 80)) {
        return m_situationParticuliereDroitCourant;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 80, m_situationParticuliereDroitCourant);
    }
    return m_situationParticuliereDroitCourant;
  }
  
  protected static final String jdoGetm_situationParticuliereDroitRetenu(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_situationParticuliereDroitRetenu;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 81)) {
        return m_situationParticuliereDroitRetenu;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 81, m_situationParticuliereDroitRetenu);
    }
    return m_situationParticuliereDroitRetenu;
  }
  
  protected static final String jdoGetm_codeActiviteHorsFrance(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeActiviteHorsFrance;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 82)) {
        return m_codeActiviteHorsFrance;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 82, m_codeActiviteHorsFrance);
    }
    return m_codeActiviteHorsFrance;
  }
  
  protected static final String jdoGetm_codePaysActivite(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codePaysActivite;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 83)) {
        return m_codePaysActivite;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 83, m_codePaysActivite);
    }
    return m_codePaysActivite;
  }
  
  protected static final BigDecimal jdoGetm_montantSalaireReferenceA10FNA(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantSalaireReferenceA10FNA;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 84)) {
        return m_montantSalaireReferenceA10FNA;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 84, m_montantSalaireReferenceA10FNA);
    }
    return m_montantSalaireReferenceA10FNA;
  }
  
  protected static final int jdoGetm_rangAttributionAFDFiliereFNA(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_rangAttributionAFDFiliereFNA;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 85)) {
        return m_rangAttributionAFDFiliereFNA;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 85, m_rangAttributionAFDFiliereFNA);
    }
    return m_rangAttributionAFDFiliereFNA;
  }
  
  protected static final String jdoGetm_typeFinancement(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeFinancement;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 86)) {
        return m_typeFinancement;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 86, m_typeFinancement);
    }
    return m_typeFinancement;
  }
  
  protected static final BigDecimal jdoGetm_nbMoisRemboursesCoordEuropeenne(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbMoisRemboursesCoordEuropeenne;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 87)) {
        return m_nbMoisRemboursesCoordEuropeenne;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 87, m_nbMoisRemboursesCoordEuropeenne);
    }
    return m_nbMoisRemboursesCoordEuropeenne;
  }
  
  private static final String jdoGetm_numeroConvention(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_numeroConvention;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 88)) {
        return m_numeroConvention;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 88, m_numeroConvention);
    }
    return m_numeroConvention;
  }
  
  private static final String jdoGetm_codeAffectationConvention(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeAffectationConvention;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 89)) {
        return m_codeAffectationConvention;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 89, m_codeAffectationConvention);
    }
    return m_codeAffectationConvention;
  }
  
  private static final String jdoGetm_idExterneEmployeurSp(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_idExterneEmployeurSp;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 90)) {
        return m_idExterneEmployeurSp;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 90, m_idExterneEmployeurSp);
    }
    return m_idExterneEmployeurSp;
  }
  
  private static final String jdoGetm_fctEmployeurCompetent(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_fctEmployeurCompetent;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 91)) {
        return m_fctEmployeurCompetent;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 91, m_fctEmployeurCompetent);
    }
    return m_fctEmployeurCompetent;
  }
  
  protected static final Damj jdoGetm_dateLimiteIndemnisation(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateLimiteIndemnisation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 92)) {
        return m_dateLimiteIndemnisation;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 92, m_dateLimiteIndemnisation);
    }
    return m_dateLimiteIndemnisation;
  }
  
  private static final String jdoGetm_auMoinsUneActiviteConservee(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_auMoinsUneActiviteConservee;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 93)) {
        return m_auMoinsUneActiviteConservee;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 93, m_auMoinsUneActiviteConservee);
    }
    return m_auMoinsUneActiviteConservee;
  }
  
  private static final String jdoGetm_estDroitOption(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estDroitOption;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 94)) {
        return m_estDroitOption;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 94, m_estDroitOption);
    }
    return m_estDroitOption;
  }
  
  private static final String jdoGetm_estDroitApprenti(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estDroitApprenti;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 95)) {
        return m_estDroitApprenti;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 95, m_estDroitApprenti);
    }
    return m_estDroitApprenti;
  }
  
  private static final BigDecimal jdoGetm_nbJourEcretementPlafDuree(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJourEcretementPlafDuree;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 96)) {
        return m_nbJourEcretementPlafDuree;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 96, m_nbJourEcretementPlafDuree);
    }
    return m_nbJourEcretementPlafDuree;
  }
  
  private static final int jdoGetm_deltaDiffereSpectacle(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_deltaDiffereSpectacle;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 97)) {
        return m_deltaDiffereSpectacle;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 97, m_deltaDiffereSpectacle);
    }
    return m_deltaDiffereSpectacle;
  }
  
  protected static final BigDecimal jdoGetm_montantAllocationJournaliereBrut(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantAllocationJournaliereBrut;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 98)) {
        return m_montantAllocationJournaliereBrut;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 98, m_montantAllocationJournaliereBrut);
    }
    return m_montantAllocationJournaliereBrut;
  }
  
  private static final String jdoGetm_estDroitInterimaire(AttributionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estDroitInterimaire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 99)) {
        return m_estDroitInterimaire;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 99, m_estDroitInterimaire);
    }
    return m_estDroitInterimaire;
  }
  
  protected static final Collection jdoGetm_collectionPeriodeAffiliation(AttributionPC pc)
  {
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 100)) {
        return m_collectionPeriodeAffiliation;
      }
      return (Collection)sm.getObjectField(pc, jdoInheritedFieldCount + 100, m_collectionPeriodeAffiliation);
    }
    return m_collectionPeriodeAffiliation;
  }
  
  protected static final void jdoSetm_identifiantOuvertureDroit(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantOuvertureDroit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 0, m_identifiantOuvertureDroit, newValue);
    } else {
      m_identifiantOuvertureDroit = newValue;
    }
  }
  
  protected static final void jdoSetm_identifiantReprise(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantReprise = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 1, m_identifiantReprise, newValue);
    } else {
      m_identifiantReprise = newValue;
    }
  }
  
  protected static final void jdoSetm_identifiantDemandeCali(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantDemandeCali = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 2, m_identifiantDemandeCali, newValue);
    } else {
      m_identifiantDemandeCali = newValue;
    }
  }
  
  protected static final void jdoSetm_identifiantOuvertureDroitAttributionPrecedente(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantOuvertureDroitAttributionPrecedente = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 3, m_identifiantOuvertureDroitAttributionPrecedente, newValue);
    } else {
      m_identifiantOuvertureDroitAttributionPrecedente = newValue;
    }
  }
  
  protected static final void jdoSetm_referenceExterneDemande(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_referenceExterneDemande = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 4, m_referenceExterneDemande, newValue);
    } else {
      m_referenceExterneDemande = newValue;
    }
  }
  
  protected static final void jdoSetm_dateEffetAttribution(AttributionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateEffetAttribution = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 5, m_dateEffetAttribution, newValue);
    } else {
      m_dateEffetAttribution = newValue;
    }
  }
  
  protected static final void jdoSetm_pji(AttributionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_pji = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 6, m_pji, newValue);
    } else {
      m_pji = newValue;
    }
  }
  
  protected static final void jdoSetm_codeProduit(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeProduit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 7, m_codeProduit, newValue);
    } else {
      m_codeProduit = newValue;
    }
  }
  
  protected static final void jdoSetm_codeProduitDroitCourant(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeProduitDroitCourant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 8, m_codeProduitDroitCourant, newValue);
    } else {
      m_codeProduitDroitCourant = newValue;
    }
  }
  
  protected static final void jdoSetm_codeValidation(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeValidation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 9, m_codeValidation, newValue);
    } else {
      m_codeValidation = newValue;
    }
  }
  
  protected static final void jdoSetm_codeValidationComplementaire(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeValidationComplementaire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 10, m_codeValidationComplementaire, newValue);
    } else {
      m_codeValidationComplementaire = newValue;
    }
  }
  
  protected static final void jdoSetm_nbJoursNonConsoDelaiDechance(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJoursNonConsoDelaiDechance = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 11, m_nbJoursNonConsoDelaiDechance, newValue);
    } else {
      m_nbJoursNonConsoDelaiDechance = newValue;
    }
  }
  
  protected static final void jdoSetm_typeAerDroitRetenu(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeAerDroitRetenu = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 12, m_typeAerDroitRetenu, newValue);
    } else {
      m_typeAerDroitRetenu = newValue;
    }
  }
  
  protected static final void jdoSetm_typeAerDroitCourant(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeAerDroitCourant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 13, m_typeAerDroitCourant, newValue);
    } else {
      m_typeAerDroitCourant = newValue;
    }
  }
  
  protected static final void jdoSetm_djtp(AttributionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_djtp = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 14, m_djtp, newValue);
    } else {
      m_djtp = newValue;
    }
  }
  
  protected static final void jdoSetm_referenceReglementaireAffiliationDroitCourant(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_referenceReglementaireAffiliationDroitCourant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 15, m_referenceReglementaireAffiliationDroitCourant, newValue);
    } else {
      m_referenceReglementaireAffiliationDroitCourant = newValue;
    }
  }
  
  protected static final void jdoSetm_dureeTheoriqueDroitCourant(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeTheoriqueDroitCourant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 16, m_dureeTheoriqueDroitCourant, newValue);
    } else {
      m_dureeTheoriqueDroitCourant = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinDelaiDecheance(AttributionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinDelaiDecheance = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 17, m_dateFinDelaiDecheance, newValue);
    } else {
      m_dateFinDelaiDecheance = newValue;
    }
  }
  
  protected static final void jdoSetm_origineDecision(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_origineDecision = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 18, m_origineDecision, newValue);
    } else {
      m_origineDecision = newValue;
    }
  }
  
  protected static final void jdoSetm_capitalOdPrecedente(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_capitalOdPrecedente = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 19, m_capitalOdPrecedente, newValue);
    } else {
      m_capitalOdPrecedente = newValue;
    }
  }
  
  protected static final void jdoSetm_capitalOdCourante(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_capitalOdCourante = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 20, m_capitalOdCourante, newValue);
    } else {
      m_capitalOdCourante = newValue;
    }
  }
  
  protected static final void jdoSetm_typeChomageSaisonnier(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeChomageSaisonnier = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 21, m_typeChomageSaisonnier, newValue);
    } else {
      m_typeChomageSaisonnier = newValue;
    }
  }
  
  protected static final void jdoSetm_capitalDroitPrecedentSp(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_capitalDroitPrecedentSp = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 22, m_capitalDroitPrecedentSp, newValue);
    } else {
      m_capitalDroitPrecedentSp = newValue;
    }
  }
  
  protected static final void jdoSetm_dateTheoriqueFinDroit(AttributionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateTheoriqueFinDroit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 23, m_dateTheoriqueFinDroit, newValue);
    } else {
      m_dateTheoriqueFinDroit = newValue;
    }
  }
  
  protected static final void jdoSetm_plus100trimestres(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_plus100trimestres = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 24, m_plus100trimestres, newValue);
    } else {
      m_plus100trimestres = newValue;
    }
  }
  
  protected static final void jdoSetm_dureeTheoriqueDroitRetenu(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeTheoriqueDroitRetenu = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 25, m_dureeTheoriqueDroitRetenu, newValue);
    } else {
      m_dureeTheoriqueDroitRetenu = newValue;
    }
  }
  
  protected static final void jdoSetm_referenceReglementaireAffiliationDroitRetenu(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_referenceReglementaireAffiliationDroitRetenu = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 26, m_referenceReglementaireAffiliationDroitRetenu, newValue);
    } else {
      m_referenceReglementaireAffiliationDroitRetenu = newValue;
    }
  }
  
  protected static final void jdoSetm_reglementApplicableCourant(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_reglementApplicableCourant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 27, m_reglementApplicableCourant, newValue);
    } else {
      m_reglementApplicableCourant = newValue;
    }
  }
  
  protected static final void jdoSetm_reglementApplicableRetenu(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_reglementApplicableRetenu = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 28, m_reglementApplicableRetenu, newValue);
    } else {
      m_reglementApplicableRetenu = newValue;
    }
  }
  
  protected static final void jdoSetm_idGaecPeriodeFg(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_idGaecPeriodeFg = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 29, m_idGaecPeriodeFg, newValue);
    } else {
      m_idGaecPeriodeFg = newValue;
    }
  }
  
  protected static final void jdoSetm_idGaecPeriodeRa(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_idGaecPeriodeRa = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 30, m_idGaecPeriodeRa, newValue);
    } else {
      m_idGaecPeriodeRa = newValue;
    }
  }
  
  protected static final void jdoSetm_fctRetenueOD(AttributionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_fctRetenueOD = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 31, m_fctRetenueOD, newValue);
    } else {
      m_fctRetenueOD = newValue;
    }
  }
  
  protected static final void jdoSetm_motifFctRetenueOD(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_motifFctRetenueOD = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 32, m_motifFctRetenueOD, newValue);
    } else {
      m_motifFctRetenueOD = newValue;
    }
  }
  
  protected static final void jdoSetm_dateDerniereFctDansDelaiForclusion(AttributionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDerniereFctDansDelaiForclusion = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 33, m_dateDerniereFctDansDelaiForclusion, newValue);
    } else {
      m_dateDerniereFctDansDelaiForclusion = newValue;
    }
  }
  
  protected static final void jdoSetm_motifDerniereFctDansDelaiForclusion(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_motifDerniereFctDansDelaiForclusion = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 34, m_motifDerniereFctDansDelaiForclusion, newValue);
    } else {
      m_motifDerniereFctDansDelaiForclusion = newValue;
    }
  }
  
  protected static final void jdoSetm_complementSs(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementSs = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 35, m_complementSs, newValue);
    } else {
      m_complementSs = newValue;
    }
  }
  
  protected static final void jdoSetm_regimeSs(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_regimeSs = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 36, m_regimeSs, newValue);
    } else {
      m_regimeSs = newValue;
    }
  }
  
  protected static final void jdoSetm_codeQualification(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeQualification = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 37, m_codeQualification, newValue);
    } else {
      m_codeQualification = newValue;
    }
  }
  
  protected static final void jdoSetm_codeQualificationDroitCourant(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeQualificationDroitCourant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 38, m_codeQualificationDroitCourant, newValue);
    } else {
      m_codeQualificationDroitCourant = newValue;
    }
  }
  
  protected static final void jdoSetm_codeMetier(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeMetier = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 39, m_codeMetier, newValue);
    } else {
      m_codeMetier = newValue;
    }
  }
  
  protected static final void jdoSetm_codeMetierDroitCourant(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeMetierDroitCourant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 40, m_codeMetierDroitCourant, newValue);
    } else {
      m_codeMetierDroitCourant = newValue;
    }
  }
  
  protected static final void jdoSetm_codeStatutIndividu(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeStatutIndividu = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 41, m_codeStatutIndividu, newValue);
    } else {
      m_codeStatutIndividu = newValue;
    }
  }
  
  protected static final void jdoSetm_prcSjrForces(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_prcSjrForces = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 42, m_prcSjrForces, newValue);
    } else {
      m_prcSjrForces = newValue;
    }
  }
  
  protected static final void jdoSetm_dateDebutPrcDroitCourant(AttributionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebutPrcDroitCourant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 43, m_dateDebutPrcDroitCourant, newValue);
    } else {
      m_dateDebutPrcDroitCourant = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinPrcDroitCourant(AttributionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinPrcDroitCourant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 44, m_dateFinPrcDroitCourant, newValue);
    } else {
      m_dateFinPrcDroitCourant = newValue;
    }
  }
  
  protected static final void jdoSetm_montantSjrCourantNonPlafonne(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantSjrCourantNonPlafonne = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 45, m_montantSjrCourantNonPlafonne, newValue);
    } else {
      m_montantSjrCourantNonPlafonne = newValue;
    }
  }
  
  protected static final void jdoSetm_montantSjrCourantCalculePlafonne(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantSjrCourantCalculePlafonne = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 46, m_montantSjrCourantCalculePlafonne, newValue);
    } else {
      m_montantSjrCourantCalculePlafonne = newValue;
    }
  }
  
  protected static final void jdoSetm_montantSjrCourantPlafonne(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantSjrCourantPlafonne = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 47, m_montantSjrCourantPlafonne, newValue);
    } else {
      m_montantSjrCourantPlafonne = newValue;
    }
  }
  
  protected static final void jdoSetm_montantSalaireReferenceSjrCourant(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantSalaireReferenceSjrCourant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 48, m_montantSalaireReferenceSjrCourant, newValue);
    } else {
      m_montantSalaireReferenceSjrCourant = newValue;
    }
  }
  
  protected static final void jdoSetm_nbJoursDiviseurSjrCourant(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJoursDiviseurSjrCourant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 49, m_nbJoursDiviseurSjrCourant, newValue);
    } else {
      m_nbJoursDiviseurSjrCourant = newValue;
    }
  }
  
  protected static final void jdoSetm_nbHeuresTravailleesA8A10SjrCourant(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbHeuresTravailleesA8A10SjrCourant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 50, m_nbHeuresTravailleesA8A10SjrCourant, newValue);
    } else {
      m_nbHeuresTravailleesA8A10SjrCourant = newValue;
    }
  }
  
  protected static final void jdoSetm_coeffTempsPartielSjrCourant(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_coeffTempsPartielSjrCourant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 51, m_coeffTempsPartielSjrCourant, newValue);
    } else {
      m_coeffTempsPartielSjrCourant = newValue;
    }
  }
  
  protected static final void jdoSetm_coeffSaisonnierCalcSjrCourant(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_coeffSaisonnierCalcSjrCourant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 52, m_coeffSaisonnierCalcSjrCourant, newValue);
    } else {
      m_coeffSaisonnierCalcSjrCourant = newValue;
    }
  }
  
  protected static final void jdoSetm_coeffSaisonnierForceSjrCourant(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_coeffSaisonnierForceSjrCourant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 53, m_coeffSaisonnierForceSjrCourant, newValue);
    } else {
      m_coeffSaisonnierForceSjrCourant = newValue;
    }
  }
  
  protected static final void jdoSetm_finPrcSjrRetenu(AttributionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_finPrcSjrRetenu = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 54, m_finPrcSjrRetenu, newValue);
    } else {
      m_finPrcSjrRetenu = newValue;
    }
  }
  
  protected static final void jdoSetm_montantSjrRetenuPlafonne(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantSjrRetenuPlafonne = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 55, m_montantSjrRetenuPlafonne, newValue);
    } else {
      m_montantSjrRetenuPlafonne = newValue;
    }
  }
  
  protected static final void jdoSetm_dateEffetSjc(AttributionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateEffetSjc = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 56, m_dateEffetSjc, newValue);
    } else {
      m_dateEffetSjc = newValue;
    }
  }
  
  protected static final void jdoSetm_montantSjc(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantSjc = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 57, m_montantSjc, newValue);
    } else {
      m_montantSjc = newValue;
    }
  }
  
  protected static final void jdoSetm_nbJoursIccp(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJoursIccp = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 58, m_nbJoursIccp, newValue);
    } else {
      m_nbJoursIccp = newValue;
    }
  }
  
  protected static final void jdoSetm_uniteDureeIccp(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_uniteDureeIccp = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 59, m_uniteDureeIccp, newValue);
    } else {
      m_uniteDureeIccp = newValue;
    }
  }
  
  protected static final void jdoSetm_dateDebutIccp(AttributionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebutIccp = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 60, m_dateDebutIccp, newValue);
    } else {
      m_dateDebutIccp = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinIccp(AttributionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinIccp = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 61, m_dateFinIccp, newValue);
    } else {
      m_dateFinIccp = newValue;
    }
  }
  
  protected static final void jdoSetm_nbJoursIslr(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJoursIslr = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 62, m_nbJoursIslr, newValue);
    } else {
      m_nbJoursIslr = newValue;
    }
  }
  
  protected static final void jdoSetm_uniteDureeIslr(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_uniteDureeIslr = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 63, m_uniteDureeIslr, newValue);
    } else {
      m_uniteDureeIslr = newValue;
    }
  }
  
  protected static final void jdoSetm_dateDebutIslr(AttributionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebutIslr = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 64, m_dateDebutIslr, newValue);
    } else {
      m_dateDebutIslr = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinIslr(AttributionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinIslr = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 65, m_dateFinIslr, newValue);
    } else {
      m_dateFinIslr = newValue;
    }
  }
  
  protected static final void jdoSetm_montantIslr(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantIslr = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 66, m_montantIslr, newValue);
    } else {
      m_montantIslr = newValue;
    }
  }
  
  protected static final void jdoSetm_nbJoursDiffere(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJoursDiffere = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 67, m_nbJoursDiffere, newValue);
    } else {
      m_nbJoursDiffere = newValue;
    }
  }
  
  protected static final void jdoSetm_uniteDureeDiffere(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_uniteDureeDiffere = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 68, m_uniteDureeDiffere, newValue);
    } else {
      m_uniteDureeDiffere = newValue;
    }
  }
  
  protected static final void jdoSetm_dateDebutDiffere(AttributionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebutDiffere = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 69, m_dateDebutDiffere, newValue);
    } else {
      m_dateDebutDiffere = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinDiffere(AttributionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinDiffere = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 70, m_dateFinDiffere, newValue);
    } else {
      m_dateFinDiffere = newValue;
    }
  }
  
  protected static final void jdoSetm_montantInitialCapitalMax(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantInitialCapitalMax = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 71, m_montantInitialCapitalMax, newValue);
    } else {
      m_montantInitialCapitalMax = newValue;
    }
  }
  
  protected static final void jdoSetm_flagReadmission(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_flagReadmission = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 72, m_flagReadmission, newValue);
    } else {
      m_flagReadmission = newValue;
    }
  }
  
  protected static final void jdoSetm_regimeParticulier(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_regimeParticulier = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 73, m_regimeParticulier, newValue);
    } else {
      m_regimeParticulier = newValue;
    }
  }
  
  protected static final void jdoSetm_nbJoursActiviteCourrierASS(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJoursActiviteCourrierASS = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 74, m_nbJoursActiviteCourrierASS, newValue);
    } else {
      m_nbJoursActiviteCourrierASS = newValue;
    }
  }
  
  protected static final void jdoSetm_montantCarenceIccp(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantCarenceIccp = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 75, m_montantCarenceIccp, newValue);
    } else {
      m_montantCarenceIccp = newValue;
    }
  }
  
  protected static final void jdoSetm_codeSousProduitCourant(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeSousProduitCourant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 76, m_codeSousProduitCourant, newValue);
    } else {
      m_codeSousProduitCourant = newValue;
    }
  }
  
  protected static final void jdoSetm_codeSousProduitRetenu(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeSousProduitRetenu = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 77, m_codeSousProduitRetenu, newValue);
    } else {
      m_codeSousProduitRetenu = newValue;
    }
  }
  
  protected static final void jdoSetm_nombreHeureTravailleEtendu(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nombreHeureTravailleEtendu = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 78, m_nombreHeureTravailleEtendu, newValue);
    } else {
      m_nombreHeureTravailleEtendu = newValue;
    }
  }
  
  protected static final void jdoSetm_rangAllongementPRA(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_rangAllongementPRA = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 79, m_rangAllongementPRA, newValue);
    } else {
      m_rangAllongementPRA = newValue;
    }
  }
  
  protected static final void jdoSetm_situationParticuliereDroitCourant(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_situationParticuliereDroitCourant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 80, m_situationParticuliereDroitCourant, newValue);
    } else {
      m_situationParticuliereDroitCourant = newValue;
    }
  }
  
  protected static final void jdoSetm_situationParticuliereDroitRetenu(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_situationParticuliereDroitRetenu = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 81, m_situationParticuliereDroitRetenu, newValue);
    } else {
      m_situationParticuliereDroitRetenu = newValue;
    }
  }
  
  protected static final void jdoSetm_codeActiviteHorsFrance(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeActiviteHorsFrance = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 82, m_codeActiviteHorsFrance, newValue);
    } else {
      m_codeActiviteHorsFrance = newValue;
    }
  }
  
  protected static final void jdoSetm_codePaysActivite(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codePaysActivite = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 83, m_codePaysActivite, newValue);
    } else {
      m_codePaysActivite = newValue;
    }
  }
  
  protected static final void jdoSetm_montantSalaireReferenceA10FNA(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantSalaireReferenceA10FNA = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 84, m_montantSalaireReferenceA10FNA, newValue);
    } else {
      m_montantSalaireReferenceA10FNA = newValue;
    }
  }
  
  protected static final void jdoSetm_rangAttributionAFDFiliereFNA(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_rangAttributionAFDFiliereFNA = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 85, m_rangAttributionAFDFiliereFNA, newValue);
    } else {
      m_rangAttributionAFDFiliereFNA = newValue;
    }
  }
  
  protected static final void jdoSetm_typeFinancement(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeFinancement = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 86, m_typeFinancement, newValue);
    } else {
      m_typeFinancement = newValue;
    }
  }
  
  protected static final void jdoSetm_nbMoisRemboursesCoordEuropeenne(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbMoisRemboursesCoordEuropeenne = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 87, m_nbMoisRemboursesCoordEuropeenne, newValue);
    } else {
      m_nbMoisRemboursesCoordEuropeenne = newValue;
    }
  }
  
  private static final void jdoSetm_numeroConvention(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_numeroConvention = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 88, m_numeroConvention, newValue);
    } else {
      m_numeroConvention = newValue;
    }
  }
  
  private static final void jdoSetm_codeAffectationConvention(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeAffectationConvention = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 89, m_codeAffectationConvention, newValue);
    } else {
      m_codeAffectationConvention = newValue;
    }
  }
  
  private static final void jdoSetm_idExterneEmployeurSp(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_idExterneEmployeurSp = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 90, m_idExterneEmployeurSp, newValue);
    } else {
      m_idExterneEmployeurSp = newValue;
    }
  }
  
  private static final void jdoSetm_fctEmployeurCompetent(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_fctEmployeurCompetent = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 91, m_fctEmployeurCompetent, newValue);
    } else {
      m_fctEmployeurCompetent = newValue;
    }
  }
  
  protected static final void jdoSetm_dateLimiteIndemnisation(AttributionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateLimiteIndemnisation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 92, m_dateLimiteIndemnisation, newValue);
    } else {
      m_dateLimiteIndemnisation = newValue;
    }
  }
  
  private static final void jdoSetm_auMoinsUneActiviteConservee(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_auMoinsUneActiviteConservee = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 93, m_auMoinsUneActiviteConservee, newValue);
    } else {
      m_auMoinsUneActiviteConservee = newValue;
    }
  }
  
  private static final void jdoSetm_estDroitOption(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_estDroitOption = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 94, m_estDroitOption, newValue);
    } else {
      m_estDroitOption = newValue;
    }
  }
  
  private static final void jdoSetm_estDroitApprenti(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_estDroitApprenti = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 95, m_estDroitApprenti, newValue);
    } else {
      m_estDroitApprenti = newValue;
    }
  }
  
  private static final void jdoSetm_nbJourEcretementPlafDuree(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJourEcretementPlafDuree = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 96, m_nbJourEcretementPlafDuree, newValue);
    } else {
      m_nbJourEcretementPlafDuree = newValue;
    }
  }
  
  private static final void jdoSetm_deltaDiffereSpectacle(AttributionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_deltaDiffereSpectacle = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 97, m_deltaDiffereSpectacle, newValue);
    } else {
      m_deltaDiffereSpectacle = newValue;
    }
  }
  
  protected static final void jdoSetm_montantAllocationJournaliereBrut(AttributionPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantAllocationJournaliereBrut = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 98, m_montantAllocationJournaliereBrut, newValue);
    } else {
      m_montantAllocationJournaliereBrut = newValue;
    }
  }
  
  private static final void jdoSetm_estDroitInterimaire(AttributionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_estDroitInterimaire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 99, m_estDroitInterimaire, newValue);
    } else {
      m_estDroitInterimaire = newValue;
    }
  }
  
  protected static final void jdoSetm_collectionPeriodeAffiliation(AttributionPC pc, Collection newValue)
  {
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 100, m_collectionPeriodeAffiliation, newValue);
    } else {
      m_collectionPeriodeAffiliation = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedIntField(this, fieldNumber, m_identifiantOuvertureDroit);
      break;
    case 1: 
      jdoStateManager.providedIntField(this, fieldNumber, m_identifiantReprise);
      break;
    case 2: 
      jdoStateManager.providedStringField(this, fieldNumber, m_identifiantDemandeCali);
      break;
    case 3: 
      jdoStateManager.providedIntField(this, fieldNumber, m_identifiantOuvertureDroitAttributionPrecedente);
      break;
    case 4: 
      jdoStateManager.providedStringField(this, fieldNumber, m_referenceExterneDemande);
      break;
    case 5: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateEffetAttribution);
      break;
    case 6: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_pji);
      break;
    case 7: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeProduit);
      break;
    case 8: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeProduitDroitCourant);
      break;
    case 9: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeValidation);
      break;
    case 10: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeValidationComplementaire);
      break;
    case 11: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbJoursNonConsoDelaiDechance);
      break;
    case 12: 
      jdoStateManager.providedIntField(this, fieldNumber, m_typeAerDroitRetenu);
      break;
    case 13: 
      jdoStateManager.providedIntField(this, fieldNumber, m_typeAerDroitCourant);
      break;
    case 14: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_djtp);
      break;
    case 15: 
      jdoStateManager.providedStringField(this, fieldNumber, m_referenceReglementaireAffiliationDroitCourant);
      break;
    case 16: 
      jdoStateManager.providedIntField(this, fieldNumber, m_dureeTheoriqueDroitCourant);
      break;
    case 17: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinDelaiDecheance);
      break;
    case 18: 
      jdoStateManager.providedStringField(this, fieldNumber, m_origineDecision);
      break;
    case 19: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_capitalOdPrecedente);
      break;
    case 20: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_capitalOdCourante);
      break;
    case 21: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeChomageSaisonnier);
      break;
    case 22: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_capitalDroitPrecedentSp);
      break;
    case 23: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateTheoriqueFinDroit);
      break;
    case 24: 
      jdoStateManager.providedStringField(this, fieldNumber, m_plus100trimestres);
      break;
    case 25: 
      jdoStateManager.providedIntField(this, fieldNumber, m_dureeTheoriqueDroitRetenu);
      break;
    case 26: 
      jdoStateManager.providedStringField(this, fieldNumber, m_referenceReglementaireAffiliationDroitRetenu);
      break;
    case 27: 
      jdoStateManager.providedStringField(this, fieldNumber, m_reglementApplicableCourant);
      break;
    case 28: 
      jdoStateManager.providedStringField(this, fieldNumber, m_reglementApplicableRetenu);
      break;
    case 29: 
      jdoStateManager.providedStringField(this, fieldNumber, m_idGaecPeriodeFg);
      break;
    case 30: 
      jdoStateManager.providedStringField(this, fieldNumber, m_idGaecPeriodeRa);
      break;
    case 31: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_fctRetenueOD);
      break;
    case 32: 
      jdoStateManager.providedStringField(this, fieldNumber, m_motifFctRetenueOD);
      break;
    case 33: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDerniereFctDansDelaiForclusion);
      break;
    case 34: 
      jdoStateManager.providedStringField(this, fieldNumber, m_motifDerniereFctDansDelaiForclusion);
      break;
    case 35: 
      jdoStateManager.providedStringField(this, fieldNumber, m_complementSs);
      break;
    case 36: 
      jdoStateManager.providedIntField(this, fieldNumber, m_regimeSs);
      break;
    case 37: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeQualification);
      break;
    case 38: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeQualificationDroitCourant);
      break;
    case 39: 
      jdoStateManager.providedIntField(this, fieldNumber, m_codeMetier);
      break;
    case 40: 
      jdoStateManager.providedIntField(this, fieldNumber, m_codeMetierDroitCourant);
      break;
    case 41: 
      jdoStateManager.providedIntField(this, fieldNumber, m_codeStatutIndividu);
      break;
    case 42: 
      jdoStateManager.providedStringField(this, fieldNumber, m_prcSjrForces);
      break;
    case 43: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebutPrcDroitCourant);
      break;
    case 44: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinPrcDroitCourant);
      break;
    case 45: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantSjrCourantNonPlafonne);
      break;
    case 46: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantSjrCourantCalculePlafonne);
      break;
    case 47: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantSjrCourantPlafonne);
      break;
    case 48: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantSalaireReferenceSjrCourant);
      break;
    case 49: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_nbJoursDiviseurSjrCourant);
      break;
    case 50: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbHeuresTravailleesA8A10SjrCourant);
      break;
    case 51: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_coeffTempsPartielSjrCourant);
      break;
    case 52: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_coeffSaisonnierCalcSjrCourant);
      break;
    case 53: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_coeffSaisonnierForceSjrCourant);
      break;
    case 54: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_finPrcSjrRetenu);
      break;
    case 55: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantSjrRetenuPlafonne);
      break;
    case 56: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateEffetSjc);
      break;
    case 57: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantSjc);
      break;
    case 58: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbJoursIccp);
      break;
    case 59: 
      jdoStateManager.providedStringField(this, fieldNumber, m_uniteDureeIccp);
      break;
    case 60: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebutIccp);
      break;
    case 61: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinIccp);
      break;
    case 62: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbJoursIslr);
      break;
    case 63: 
      jdoStateManager.providedStringField(this, fieldNumber, m_uniteDureeIslr);
      break;
    case 64: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebutIslr);
      break;
    case 65: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinIslr);
      break;
    case 66: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantIslr);
      break;
    case 67: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbJoursDiffere);
      break;
    case 68: 
      jdoStateManager.providedStringField(this, fieldNumber, m_uniteDureeDiffere);
      break;
    case 69: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebutDiffere);
      break;
    case 70: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinDiffere);
      break;
    case 71: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantInitialCapitalMax);
      break;
    case 72: 
      jdoStateManager.providedIntField(this, fieldNumber, m_flagReadmission);
      break;
    case 73: 
      jdoStateManager.providedStringField(this, fieldNumber, m_regimeParticulier);
      break;
    case 74: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbJoursActiviteCourrierASS);
      break;
    case 75: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantCarenceIccp);
      break;
    case 76: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeSousProduitCourant);
      break;
    case 77: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeSousProduitRetenu);
      break;
    case 78: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nombreHeureTravailleEtendu);
      break;
    case 79: 
      jdoStateManager.providedIntField(this, fieldNumber, m_rangAllongementPRA);
      break;
    case 80: 
      jdoStateManager.providedStringField(this, fieldNumber, m_situationParticuliereDroitCourant);
      break;
    case 81: 
      jdoStateManager.providedStringField(this, fieldNumber, m_situationParticuliereDroitRetenu);
      break;
    case 82: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeActiviteHorsFrance);
      break;
    case 83: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codePaysActivite);
      break;
    case 84: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantSalaireReferenceA10FNA);
      break;
    case 85: 
      jdoStateManager.providedIntField(this, fieldNumber, m_rangAttributionAFDFiliereFNA);
      break;
    case 86: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeFinancement);
      break;
    case 87: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_nbMoisRemboursesCoordEuropeenne);
      break;
    case 88: 
      jdoStateManager.providedStringField(this, fieldNumber, m_numeroConvention);
      break;
    case 89: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeAffectationConvention);
      break;
    case 90: 
      jdoStateManager.providedStringField(this, fieldNumber, m_idExterneEmployeurSp);
      break;
    case 91: 
      jdoStateManager.providedStringField(this, fieldNumber, m_fctEmployeurCompetent);
      break;
    case 92: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateLimiteIndemnisation);
      break;
    case 93: 
      jdoStateManager.providedStringField(this, fieldNumber, m_auMoinsUneActiviteConservee);
      break;
    case 94: 
      jdoStateManager.providedStringField(this, fieldNumber, m_estDroitOption);
      break;
    case 95: 
      jdoStateManager.providedStringField(this, fieldNumber, m_estDroitApprenti);
      break;
    case 96: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_nbJourEcretementPlafDuree);
      break;
    case 97: 
      jdoStateManager.providedIntField(this, fieldNumber, m_deltaDiffereSpectacle);
      break;
    case 98: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantAllocationJournaliereBrut);
      break;
    case 99: 
      jdoStateManager.providedStringField(this, fieldNumber, m_estDroitInterimaire);
      break;
    case 100: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_collectionPeriodeAffiliation);
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
      m_identifiantOuvertureDroit = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 1: 
      m_identifiantReprise = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 2: 
      m_identifiantDemandeCali = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 3: 
      m_identifiantOuvertureDroitAttributionPrecedente = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 4: 
      m_referenceExterneDemande = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 5: 
      m_dateEffetAttribution = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 6: 
      m_pji = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 7: 
      m_codeProduit = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 8: 
      m_codeProduitDroitCourant = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 9: 
      m_codeValidation = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 10: 
      m_codeValidationComplementaire = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 11: 
      m_nbJoursNonConsoDelaiDechance = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 12: 
      m_typeAerDroitRetenu = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 13: 
      m_typeAerDroitCourant = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 14: 
      m_djtp = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 15: 
      m_referenceReglementaireAffiliationDroitCourant = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 16: 
      m_dureeTheoriqueDroitCourant = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 17: 
      m_dateFinDelaiDecheance = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 18: 
      m_origineDecision = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 19: 
      m_capitalOdPrecedente = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 20: 
      m_capitalOdCourante = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 21: 
      m_typeChomageSaisonnier = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 22: 
      m_capitalDroitPrecedentSp = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 23: 
      m_dateTheoriqueFinDroit = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 24: 
      m_plus100trimestres = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 25: 
      m_dureeTheoriqueDroitRetenu = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 26: 
      m_referenceReglementaireAffiliationDroitRetenu = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 27: 
      m_reglementApplicableCourant = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 28: 
      m_reglementApplicableRetenu = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 29: 
      m_idGaecPeriodeFg = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 30: 
      m_idGaecPeriodeRa = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 31: 
      m_fctRetenueOD = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 32: 
      m_motifFctRetenueOD = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 33: 
      m_dateDerniereFctDansDelaiForclusion = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 34: 
      m_motifDerniereFctDansDelaiForclusion = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 35: 
      m_complementSs = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 36: 
      m_regimeSs = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 37: 
      m_codeQualification = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 38: 
      m_codeQualificationDroitCourant = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 39: 
      m_codeMetier = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 40: 
      m_codeMetierDroitCourant = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 41: 
      m_codeStatutIndividu = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 42: 
      m_prcSjrForces = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 43: 
      m_dateDebutPrcDroitCourant = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 44: 
      m_dateFinPrcDroitCourant = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 45: 
      m_montantSjrCourantNonPlafonne = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 46: 
      m_montantSjrCourantCalculePlafonne = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 47: 
      m_montantSjrCourantPlafonne = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 48: 
      m_montantSalaireReferenceSjrCourant = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 49: 
      m_nbJoursDiviseurSjrCourant = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 50: 
      m_nbHeuresTravailleesA8A10SjrCourant = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 51: 
      m_coeffTempsPartielSjrCourant = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 52: 
      m_coeffSaisonnierCalcSjrCourant = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 53: 
      m_coeffSaisonnierForceSjrCourant = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 54: 
      m_finPrcSjrRetenu = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 55: 
      m_montantSjrRetenuPlafonne = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 56: 
      m_dateEffetSjc = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 57: 
      m_montantSjc = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 58: 
      m_nbJoursIccp = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 59: 
      m_uniteDureeIccp = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 60: 
      m_dateDebutIccp = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 61: 
      m_dateFinIccp = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 62: 
      m_nbJoursIslr = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 63: 
      m_uniteDureeIslr = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 64: 
      m_dateDebutIslr = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 65: 
      m_dateFinIslr = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 66: 
      m_montantIslr = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 67: 
      m_nbJoursDiffere = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 68: 
      m_uniteDureeDiffere = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 69: 
      m_dateDebutDiffere = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 70: 
      m_dateFinDiffere = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 71: 
      m_montantInitialCapitalMax = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 72: 
      m_flagReadmission = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 73: 
      m_regimeParticulier = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 74: 
      m_nbJoursActiviteCourrierASS = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 75: 
      m_montantCarenceIccp = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 76: 
      m_codeSousProduitCourant = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 77: 
      m_codeSousProduitRetenu = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 78: 
      m_nombreHeureTravailleEtendu = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 79: 
      m_rangAllongementPRA = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 80: 
      m_situationParticuliereDroitCourant = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 81: 
      m_situationParticuliereDroitRetenu = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 82: 
      m_codeActiviteHorsFrance = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 83: 
      m_codePaysActivite = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 84: 
      m_montantSalaireReferenceA10FNA = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 85: 
      m_rangAttributionAFDFiliereFNA = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 86: 
      m_typeFinancement = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 87: 
      m_nbMoisRemboursesCoordEuropeenne = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 88: 
      m_numeroConvention = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 89: 
      m_codeAffectationConvention = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 90: 
      m_idExterneEmployeurSp = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 91: 
      m_fctEmployeurCompetent = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 92: 
      m_dateLimiteIndemnisation = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 93: 
      m_auMoinsUneActiviteConservee = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 94: 
      m_estDroitOption = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 95: 
      m_estDroitApprenti = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 96: 
      m_nbJourEcretementPlafDuree = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 97: 
      m_deltaDiffereSpectacle = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 98: 
      m_montantAllocationJournaliereBrut = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 99: 
      m_estDroitInterimaire = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 100: 
      m_collectionPeriodeAffiliation = ((Collection)jdoStateManager.replacingObjectField(this, fieldNumber));
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
    AttributionPC pc = new AttributionPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    AttributionPC pc = new AttributionPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 101;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof AttributionPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    AttributionPC other = (AttributionPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_identifiantOuvertureDroit = m_identifiantOuvertureDroit;
        break;
      case 1: 
        m_identifiantReprise = m_identifiantReprise;
        break;
      case 2: 
        m_identifiantDemandeCali = m_identifiantDemandeCali;
        break;
      case 3: 
        m_identifiantOuvertureDroitAttributionPrecedente = m_identifiantOuvertureDroitAttributionPrecedente;
        break;
      case 4: 
        m_referenceExterneDemande = m_referenceExterneDemande;
        break;
      case 5: 
        m_dateEffetAttribution = m_dateEffetAttribution;
        break;
      case 6: 
        m_pji = m_pji;
        break;
      case 7: 
        m_codeProduit = m_codeProduit;
        break;
      case 8: 
        m_codeProduitDroitCourant = m_codeProduitDroitCourant;
        break;
      case 9: 
        m_codeValidation = m_codeValidation;
        break;
      case 10: 
        m_codeValidationComplementaire = m_codeValidationComplementaire;
        break;
      case 11: 
        m_nbJoursNonConsoDelaiDechance = m_nbJoursNonConsoDelaiDechance;
        break;
      case 12: 
        m_typeAerDroitRetenu = m_typeAerDroitRetenu;
        break;
      case 13: 
        m_typeAerDroitCourant = m_typeAerDroitCourant;
        break;
      case 14: 
        m_djtp = m_djtp;
        break;
      case 15: 
        m_referenceReglementaireAffiliationDroitCourant = m_referenceReglementaireAffiliationDroitCourant;
        break;
      case 16: 
        m_dureeTheoriqueDroitCourant = m_dureeTheoriqueDroitCourant;
        break;
      case 17: 
        m_dateFinDelaiDecheance = m_dateFinDelaiDecheance;
        break;
      case 18: 
        m_origineDecision = m_origineDecision;
        break;
      case 19: 
        m_capitalOdPrecedente = m_capitalOdPrecedente;
        break;
      case 20: 
        m_capitalOdCourante = m_capitalOdCourante;
        break;
      case 21: 
        m_typeChomageSaisonnier = m_typeChomageSaisonnier;
        break;
      case 22: 
        m_capitalDroitPrecedentSp = m_capitalDroitPrecedentSp;
        break;
      case 23: 
        m_dateTheoriqueFinDroit = m_dateTheoriqueFinDroit;
        break;
      case 24: 
        m_plus100trimestres = m_plus100trimestres;
        break;
      case 25: 
        m_dureeTheoriqueDroitRetenu = m_dureeTheoriqueDroitRetenu;
        break;
      case 26: 
        m_referenceReglementaireAffiliationDroitRetenu = m_referenceReglementaireAffiliationDroitRetenu;
        break;
      case 27: 
        m_reglementApplicableCourant = m_reglementApplicableCourant;
        break;
      case 28: 
        m_reglementApplicableRetenu = m_reglementApplicableRetenu;
        break;
      case 29: 
        m_idGaecPeriodeFg = m_idGaecPeriodeFg;
        break;
      case 30: 
        m_idGaecPeriodeRa = m_idGaecPeriodeRa;
        break;
      case 31: 
        m_fctRetenueOD = m_fctRetenueOD;
        break;
      case 32: 
        m_motifFctRetenueOD = m_motifFctRetenueOD;
        break;
      case 33: 
        m_dateDerniereFctDansDelaiForclusion = m_dateDerniereFctDansDelaiForclusion;
        break;
      case 34: 
        m_motifDerniereFctDansDelaiForclusion = m_motifDerniereFctDansDelaiForclusion;
        break;
      case 35: 
        m_complementSs = m_complementSs;
        break;
      case 36: 
        m_regimeSs = m_regimeSs;
        break;
      case 37: 
        m_codeQualification = m_codeQualification;
        break;
      case 38: 
        m_codeQualificationDroitCourant = m_codeQualificationDroitCourant;
        break;
      case 39: 
        m_codeMetier = m_codeMetier;
        break;
      case 40: 
        m_codeMetierDroitCourant = m_codeMetierDroitCourant;
        break;
      case 41: 
        m_codeStatutIndividu = m_codeStatutIndividu;
        break;
      case 42: 
        m_prcSjrForces = m_prcSjrForces;
        break;
      case 43: 
        m_dateDebutPrcDroitCourant = m_dateDebutPrcDroitCourant;
        break;
      case 44: 
        m_dateFinPrcDroitCourant = m_dateFinPrcDroitCourant;
        break;
      case 45: 
        m_montantSjrCourantNonPlafonne = m_montantSjrCourantNonPlafonne;
        break;
      case 46: 
        m_montantSjrCourantCalculePlafonne = m_montantSjrCourantCalculePlafonne;
        break;
      case 47: 
        m_montantSjrCourantPlafonne = m_montantSjrCourantPlafonne;
        break;
      case 48: 
        m_montantSalaireReferenceSjrCourant = m_montantSalaireReferenceSjrCourant;
        break;
      case 49: 
        m_nbJoursDiviseurSjrCourant = m_nbJoursDiviseurSjrCourant;
        break;
      case 50: 
        m_nbHeuresTravailleesA8A10SjrCourant = m_nbHeuresTravailleesA8A10SjrCourant;
        break;
      case 51: 
        m_coeffTempsPartielSjrCourant = m_coeffTempsPartielSjrCourant;
        break;
      case 52: 
        m_coeffSaisonnierCalcSjrCourant = m_coeffSaisonnierCalcSjrCourant;
        break;
      case 53: 
        m_coeffSaisonnierForceSjrCourant = m_coeffSaisonnierForceSjrCourant;
        break;
      case 54: 
        m_finPrcSjrRetenu = m_finPrcSjrRetenu;
        break;
      case 55: 
        m_montantSjrRetenuPlafonne = m_montantSjrRetenuPlafonne;
        break;
      case 56: 
        m_dateEffetSjc = m_dateEffetSjc;
        break;
      case 57: 
        m_montantSjc = m_montantSjc;
        break;
      case 58: 
        m_nbJoursIccp = m_nbJoursIccp;
        break;
      case 59: 
        m_uniteDureeIccp = m_uniteDureeIccp;
        break;
      case 60: 
        m_dateDebutIccp = m_dateDebutIccp;
        break;
      case 61: 
        m_dateFinIccp = m_dateFinIccp;
        break;
      case 62: 
        m_nbJoursIslr = m_nbJoursIslr;
        break;
      case 63: 
        m_uniteDureeIslr = m_uniteDureeIslr;
        break;
      case 64: 
        m_dateDebutIslr = m_dateDebutIslr;
        break;
      case 65: 
        m_dateFinIslr = m_dateFinIslr;
        break;
      case 66: 
        m_montantIslr = m_montantIslr;
        break;
      case 67: 
        m_nbJoursDiffere = m_nbJoursDiffere;
        break;
      case 68: 
        m_uniteDureeDiffere = m_uniteDureeDiffere;
        break;
      case 69: 
        m_dateDebutDiffere = m_dateDebutDiffere;
        break;
      case 70: 
        m_dateFinDiffere = m_dateFinDiffere;
        break;
      case 71: 
        m_montantInitialCapitalMax = m_montantInitialCapitalMax;
        break;
      case 72: 
        m_flagReadmission = m_flagReadmission;
        break;
      case 73: 
        m_regimeParticulier = m_regimeParticulier;
        break;
      case 74: 
        m_nbJoursActiviteCourrierASS = m_nbJoursActiviteCourrierASS;
        break;
      case 75: 
        m_montantCarenceIccp = m_montantCarenceIccp;
        break;
      case 76: 
        m_codeSousProduitCourant = m_codeSousProduitCourant;
        break;
      case 77: 
        m_codeSousProduitRetenu = m_codeSousProduitRetenu;
        break;
      case 78: 
        m_nombreHeureTravailleEtendu = m_nombreHeureTravailleEtendu;
        break;
      case 79: 
        m_rangAllongementPRA = m_rangAllongementPRA;
        break;
      case 80: 
        m_situationParticuliereDroitCourant = m_situationParticuliereDroitCourant;
        break;
      case 81: 
        m_situationParticuliereDroitRetenu = m_situationParticuliereDroitRetenu;
        break;
      case 82: 
        m_codeActiviteHorsFrance = m_codeActiviteHorsFrance;
        break;
      case 83: 
        m_codePaysActivite = m_codePaysActivite;
        break;
      case 84: 
        m_montantSalaireReferenceA10FNA = m_montantSalaireReferenceA10FNA;
        break;
      case 85: 
        m_rangAttributionAFDFiliereFNA = m_rangAttributionAFDFiliereFNA;
        break;
      case 86: 
        m_typeFinancement = m_typeFinancement;
        break;
      case 87: 
        m_nbMoisRemboursesCoordEuropeenne = m_nbMoisRemboursesCoordEuropeenne;
        break;
      case 88: 
        m_numeroConvention = m_numeroConvention;
        break;
      case 89: 
        m_codeAffectationConvention = m_codeAffectationConvention;
        break;
      case 90: 
        m_idExterneEmployeurSp = m_idExterneEmployeurSp;
        break;
      case 91: 
        m_fctEmployeurCompetent = m_fctEmployeurCompetent;
        break;
      case 92: 
        m_dateLimiteIndemnisation = m_dateLimiteIndemnisation;
        break;
      case 93: 
        m_auMoinsUneActiviteConservee = m_auMoinsUneActiviteConservee;
        break;
      case 94: 
        m_estDroitOption = m_estDroitOption;
        break;
      case 95: 
        m_estDroitApprenti = m_estDroitApprenti;
        break;
      case 96: 
        m_nbJourEcretementPlafDuree = m_nbJourEcretementPlafDuree;
        break;
      case 97: 
        m_deltaDiffereSpectacle = m_deltaDiffereSpectacle;
        break;
      case 98: 
        m_montantAllocationJournaliereBrut = m_montantAllocationJournaliereBrut;
        break;
      case 99: 
        m_estDroitInterimaire = m_estDroitInterimaire;
        break;
      case 100: 
        m_collectionPeriodeAffiliation = m_collectionPeriodeAffiliation;
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
 * Qualified Name:     AttributionPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */