package fr.unedic.cali.dom.pivot.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.dom.pivot.PeriodeAffiliation;
import fr.unedic.cali.dom.pivot.pc.AttributionPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class AttributionGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_attributionPC;
  private String m_identifiantDemandeCali;
  private String m_referenceExterneDemande;
  private Damj m_dateEffetAttribution;
  private Damj m_pji;
  private String m_codeProduit;
  private String m_codeProduitDroitCourant;
  private String m_codeValidation;
  private String m_codeValidationComplementaire;
  private Damj m_djtp;
  private String m_referenceReglementaireAffiliationDroitCourant;
  private Damj m_dateFinDelaiDecheance;
  private String m_origineDecision;
  private BigDecimal m_capitalOdPrecedente;
  private BigDecimal m_capitalOdCourante;
  private String m_typeChomageSaisonnier;
  private BigDecimal m_capitalDroitPrecedentSp;
  private Damj m_dateTheoriqueFinDroit;
  private String m_plus100trimestres;
  private String m_referenceReglementaireAffiliationDroitRetenu;
  private String m_reglementApplicableCourant;
  private String m_reglementApplicableRetenu;
  private String m_idGaecPeriodeFg;
  private String m_idGaecPeriodeRa;
  private Damj m_fctRetenueOD;
  private String m_motifFctRetenueOD;
  private Damj m_dateDerniereFctDansDelaiForclusion;
  private String m_motifDerniereFctDansDelaiForclusion;
  private String m_complementSs;
  private String m_codeQualification;
  private String m_codeQualificationDroitCourant;
  private String m_prcSjrForces;
  private Damj m_dateDebutPrcDroitCourant;
  private Damj m_dateFinPrcDroitCourant;
  private BigDecimal m_montantSjrCourantNonPlafonne;
  private BigDecimal m_montantSjrCourantCalculePlafonne;
  private BigDecimal m_montantSjrCourantPlafonne;
  private BigDecimal m_montantSalaireReferenceSjrCourant;
  private BigDecimal m_nbJoursDiviseurSjrCourant;
  private BigDecimal m_coeffTempsPartielSjrCourant;
  private BigDecimal m_coeffSaisonnierCalcSjrCourant;
  private BigDecimal m_coeffSaisonnierForceSjrCourant;
  private Damj m_finPrcSjrRetenu;
  private BigDecimal m_montantSjrRetenuPlafonne;
  private Damj m_dateEffetSjc;
  private BigDecimal m_montantSjc;
  private String m_uniteDureeIccp;
  private Damj m_dateDebutIccp;
  private Damj m_dateFinIccp;
  private String m_uniteDureeIslr;
  private Damj m_dateDebutIslr;
  private Damj m_dateFinIslr;
  private BigDecimal m_montantIslr;
  private String m_uniteDureeDiffere;
  private Damj m_dateDebutDiffere;
  private Damj m_dateFinDiffere;
  private BigDecimal m_montantInitialCapitalMax;
  private String m_regimeParticulier;
  private BigDecimal m_montantCarenceIccp = null;
  private String m_codeSousProduitCourant;
  private String m_codeSousProduitRetenu;
  private String m_situationParticuliereDroitCourant;
  private String m_situationParticuliereDroitRetenu;
  private String m_codeActiviteHorsFrance;
  private String m_codePaysActivite;
  private BigDecimal m_montantSalaireReferenceA10FNA;
  private String m_typeFinancement;
  private BigDecimal m_nbMoisRemboursesCoordEuropeenne;
  private String m_numeroConvention;
  private String m_codeAffectationConvention;
  private String m_idExterneEmployeurSp;
  private String m_fctEmployeurCompetent;
  private Damj m_dateLimiteIndemnisation;
  private String m_auMoinsUneActiviteConservee;
  private String m_estDroitOption;
  private String m_estDroitApprenti;
  private BigDecimal m_nbJourEcretementPlafDuree;
  private BigDecimal m_montantAllocationJournaliereBrut;
  private String m_estDroitInterimaire;
  private Collection m_collectionPeriodeAffiliation;
  
  public AttributionGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public AttributionGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new AttributionPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_attributionPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_attributionPC)
  {
    m_attributionPC = p_attributionPC;
  }
  
  protected int rawGetIdentifiantOuvertureDroit()
  {
    return ((AttributionPC)getPC()).getIdentifiantOuvertureDroit();
  }
  
  public int getIdentifiantOuvertureDroit()
  {
    return ((AttributionPC)getPC()).getIdentifiantOuvertureDroit();
  }
  
  public void setIdentifiantOuvertureDroit(int p_identifiantOuvertureDroit)
  {
    ((AttributionPC)getPC()).setIdentifiantOuvertureDroit(p_identifiantOuvertureDroit);
  }
  
  protected int rawGetIdentifiantReprise()
  {
    return ((AttributionPC)getPC()).getIdentifiantReprise();
  }
  
  public int getIdentifiantReprise()
  {
    return ((AttributionPC)getPC()).getIdentifiantReprise();
  }
  
  public void setIdentifiantReprise(int p_identifiantReprise)
  {
    ((AttributionPC)getPC()).setIdentifiantReprise(p_identifiantReprise);
  }
  
  protected String rawGetIdentifiantDemandeCali()
  {
    return ((AttributionPC)getPC()).getIdentifiantDemandeCali();
  }
  
  public String getIdentifiantDemandeCali()
  {
    return ((AttributionPC)getPC()).getIdentifiantDemandeCali();
  }
  
  public void setIdentifiantDemandeCali(String p_identifiantDemandeCali)
  {
    if ((m_identifiantDemandeCali == null) || (p_identifiantDemandeCali == null))
    {
      m_identifiantDemandeCali = p_identifiantDemandeCali;
      ((AttributionPC)getPC()).setIdentifiantDemandeCali(p_identifiantDemandeCali);
    }
    else if ((m_identifiantDemandeCali != null) && (p_identifiantDemandeCali != null) && (!p_identifiantDemandeCali.equals(m_identifiantDemandeCali)))
    {
      m_identifiantDemandeCali = p_identifiantDemandeCali;
      ((AttributionPC)getPC()).setIdentifiantDemandeCali(p_identifiantDemandeCali);
    }
  }
  
  protected int rawGetIdentifiantOuvertureDroitAttributionPrecedente()
  {
    return ((AttributionPC)getPC()).getIdentifiantOuvertureDroitAttributionPrecedente();
  }
  
  public int getIdentifiantOuvertureDroitAttributionPrecedente()
  {
    return ((AttributionPC)getPC()).getIdentifiantOuvertureDroitAttributionPrecedente();
  }
  
  public void setIdentifiantOuvertureDroitAttributionPrecedente(int p_identifiantOuvertureDroitAttributionPrecedente)
  {
    ((AttributionPC)getPC()).setIdentifiantOuvertureDroitAttributionPrecedente(p_identifiantOuvertureDroitAttributionPrecedente);
  }
  
  protected String rawGetReferenceExterneDemande()
  {
    return ((AttributionPC)getPC()).getReferenceExterneDemande();
  }
  
  public String getReferenceExterneDemande()
  {
    return ((AttributionPC)getPC()).getReferenceExterneDemande();
  }
  
  public void setReferenceExterneDemande(String p_referenceExterneDemande)
  {
    if ((m_referenceExterneDemande == null) || (p_referenceExterneDemande == null))
    {
      m_referenceExterneDemande = p_referenceExterneDemande;
      ((AttributionPC)getPC()).setReferenceExterneDemande(p_referenceExterneDemande);
    }
    else if ((m_referenceExterneDemande != null) && (p_referenceExterneDemande != null) && (!p_referenceExterneDemande.equals(m_referenceExterneDemande)))
    {
      m_referenceExterneDemande = p_referenceExterneDemande;
      ((AttributionPC)getPC()).setReferenceExterneDemande(p_referenceExterneDemande);
    }
  }
  
  protected Damj rawGetDateEffetAttribution()
  {
    return ((AttributionPC)getPC()).getDateEffetAttribution();
  }
  
  public Damj getDateEffetAttribution()
  {
    return ((AttributionPC)getPC()).getDateEffetAttribution();
  }
  
  public void setDateEffetAttribution(Damj p_dateEffetAttribution)
  {
    if ((m_dateEffetAttribution == null) || (p_dateEffetAttribution == null))
    {
      m_dateEffetAttribution = p_dateEffetAttribution;
      ((AttributionPC)getPC()).setDateEffetAttribution(p_dateEffetAttribution);
    }
    else if ((m_dateEffetAttribution != null) && (p_dateEffetAttribution != null) && (!p_dateEffetAttribution.equals(m_dateEffetAttribution)))
    {
      m_dateEffetAttribution = p_dateEffetAttribution;
      ((AttributionPC)getPC()).setDateEffetAttribution(p_dateEffetAttribution);
    }
  }
  
  protected Damj rawGetPji()
  {
    return ((AttributionPC)getPC()).getPji();
  }
  
  public Damj getPji()
  {
    return ((AttributionPC)getPC()).getPji();
  }
  
  public void setPji(Damj p_pji)
  {
    if ((m_pji == null) || (p_pji == null))
    {
      m_pji = p_pji;
      ((AttributionPC)getPC()).setPji(p_pji);
    }
    else if ((m_pji != null) && (p_pji != null) && (!p_pji.equals(m_pji)))
    {
      m_pji = p_pji;
      ((AttributionPC)getPC()).setPji(p_pji);
    }
  }
  
  protected String rawGetCodeProduit()
  {
    return ((AttributionPC)getPC()).getCodeProduit();
  }
  
  public String getCodeProduit()
  {
    return ((AttributionPC)getPC()).getCodeProduit();
  }
  
  public void setCodeProduit(String p_codeProduit)
  {
    if ((m_codeProduit == null) || (p_codeProduit == null))
    {
      m_codeProduit = p_codeProduit;
      ((AttributionPC)getPC()).setCodeProduit(p_codeProduit);
    }
    else if ((m_codeProduit != null) && (p_codeProduit != null) && (!p_codeProduit.equals(m_codeProduit)))
    {
      m_codeProduit = p_codeProduit;
      ((AttributionPC)getPC()).setCodeProduit(p_codeProduit);
    }
  }
  
  protected String rawGetCodeProduitDroitCourant()
  {
    return ((AttributionPC)getPC()).getCodeProduitDroitCourant();
  }
  
  public String getCodeProduitDroitCourant()
  {
    return ((AttributionPC)getPC()).getCodeProduitDroitCourant();
  }
  
  public void setCodeProduitDroitCourant(String p_codeProduitDroitCourant)
  {
    if ((m_codeProduitDroitCourant == null) || (p_codeProduitDroitCourant == null))
    {
      m_codeProduitDroitCourant = p_codeProduitDroitCourant;
      ((AttributionPC)getPC()).setCodeProduitDroitCourant(p_codeProduitDroitCourant);
    }
    else if ((m_codeProduitDroitCourant != null) && (p_codeProduitDroitCourant != null) && (!p_codeProduitDroitCourant.equals(m_codeProduitDroitCourant)))
    {
      m_codeProduitDroitCourant = p_codeProduitDroitCourant;
      ((AttributionPC)getPC()).setCodeProduitDroitCourant(p_codeProduitDroitCourant);
    }
  }
  
  protected String rawGetCodeValidation()
  {
    return ((AttributionPC)getPC()).getCodeValidation();
  }
  
  public String getCodeValidation()
  {
    return ((AttributionPC)getPC()).getCodeValidation();
  }
  
  public void setCodeValidation(String p_codeValidation)
  {
    if ((m_codeValidation == null) || (p_codeValidation == null))
    {
      m_codeValidation = p_codeValidation;
      ((AttributionPC)getPC()).setCodeValidation(p_codeValidation);
    }
    else if ((m_codeValidation != null) && (p_codeValidation != null) && (!p_codeValidation.equals(m_codeValidation)))
    {
      m_codeValidation = p_codeValidation;
      ((AttributionPC)getPC()).setCodeValidation(p_codeValidation);
    }
  }
  
  protected String rawGetCodeValidationComplementaire()
  {
    return ((AttributionPC)getPC()).getCodeValidationComplementaire();
  }
  
  public String getCodeValidationComplementaire()
  {
    return ((AttributionPC)getPC()).getCodeValidationComplementaire();
  }
  
  public void setCodeValidationComplementaire(String p_codeValidationComplementaire)
  {
    if ((m_codeValidationComplementaire == null) || (p_codeValidationComplementaire == null))
    {
      m_codeValidationComplementaire = p_codeValidationComplementaire;
      ((AttributionPC)getPC()).setCodeValidationComplementaire(p_codeValidationComplementaire);
    }
    else if ((m_codeValidationComplementaire != null) && (p_codeValidationComplementaire != null) && (!p_codeValidationComplementaire.equals(m_codeValidationComplementaire)))
    {
      m_codeValidationComplementaire = p_codeValidationComplementaire;
      ((AttributionPC)getPC()).setCodeValidationComplementaire(p_codeValidationComplementaire);
    }
  }
  
  protected int rawGetNbJoursNonConsoDelaiDechance()
  {
    return ((AttributionPC)getPC()).getNbJoursNonConsoDelaiDechance();
  }
  
  public int getNbJoursNonConsoDelaiDechance()
  {
    return ((AttributionPC)getPC()).getNbJoursNonConsoDelaiDechance();
  }
  
  public void setNbJoursNonConsoDelaiDechance(int p_nbJoursNonConsoDelaiDechance)
  {
    ((AttributionPC)getPC()).setNbJoursNonConsoDelaiDechance(p_nbJoursNonConsoDelaiDechance);
  }
  
  protected int rawGetTypeAerDroitRetenu()
  {
    return ((AttributionPC)getPC()).getTypeAerDroitRetenu();
  }
  
  public int getTypeAerDroitRetenu()
  {
    return ((AttributionPC)getPC()).getTypeAerDroitRetenu();
  }
  
  public void setTypeAerDroitRetenu(int p_typeAerDroitRetenu)
  {
    ((AttributionPC)getPC()).setTypeAerDroitRetenu(p_typeAerDroitRetenu);
  }
  
  protected int rawGetTypeAerDroitCourant()
  {
    return ((AttributionPC)getPC()).getTypeAerDroitCourant();
  }
  
  public int getTypeAerDroitCourant()
  {
    return ((AttributionPC)getPC()).getTypeAerDroitCourant();
  }
  
  public void setTypeAerDroitCourant(int p_typeAerDroitCourant)
  {
    ((AttributionPC)getPC()).setTypeAerDroitCourant(p_typeAerDroitCourant);
  }
  
  protected Damj rawGetDjtp()
  {
    return ((AttributionPC)getPC()).getDjtp();
  }
  
  public Damj getDjtp()
  {
    return ((AttributionPC)getPC()).getDjtp();
  }
  
  public void setDjtp(Damj p_djtp)
  {
    if ((m_djtp == null) || (p_djtp == null))
    {
      m_djtp = p_djtp;
      ((AttributionPC)getPC()).setDjtp(p_djtp);
    }
    else if ((m_djtp != null) && (p_djtp != null) && (!p_djtp.equals(m_djtp)))
    {
      m_djtp = p_djtp;
      ((AttributionPC)getPC()).setDjtp(p_djtp);
    }
  }
  
  protected String rawGetReferenceReglementaireAffiliationDroitCourant()
  {
    return ((AttributionPC)getPC()).getReferenceReglementaireAffiliationDroitCourant();
  }
  
  public String getReferenceReglementaireAffiliationDroitCourant()
  {
    return ((AttributionPC)getPC()).getReferenceReglementaireAffiliationDroitCourant();
  }
  
  public void setReferenceReglementaireAffiliationDroitCourant(String p_referenceReglementaireAffiliationDroitCourant)
  {
    if ((m_referenceReglementaireAffiliationDroitCourant == null) || (p_referenceReglementaireAffiliationDroitCourant == null))
    {
      m_referenceReglementaireAffiliationDroitCourant = p_referenceReglementaireAffiliationDroitCourant;
      ((AttributionPC)getPC()).setReferenceReglementaireAffiliationDroitCourant(p_referenceReglementaireAffiliationDroitCourant);
    }
    else if ((m_referenceReglementaireAffiliationDroitCourant != null) && (p_referenceReglementaireAffiliationDroitCourant != null) && (!p_referenceReglementaireAffiliationDroitCourant.equals(m_referenceReglementaireAffiliationDroitCourant)))
    {
      m_referenceReglementaireAffiliationDroitCourant = p_referenceReglementaireAffiliationDroitCourant;
      ((AttributionPC)getPC()).setReferenceReglementaireAffiliationDroitCourant(p_referenceReglementaireAffiliationDroitCourant);
    }
  }
  
  protected int rawGetDureeTheoriqueDroitCourant()
  {
    return ((AttributionPC)getPC()).getDureeTheoriqueDroitCourant();
  }
  
  public int getDureeTheoriqueDroitCourant()
  {
    return ((AttributionPC)getPC()).getDureeTheoriqueDroitCourant();
  }
  
  public void setDureeTheoriqueDroitCourant(int p_dureeTheoriqueDroitCourant)
  {
    ((AttributionPC)getPC()).setDureeTheoriqueDroitCourant(p_dureeTheoriqueDroitCourant);
  }
  
  protected Damj rawGetDateFinDelaiDecheance()
  {
    return ((AttributionPC)getPC()).getDateFinDelaiDecheance();
  }
  
  public Damj getDateFinDelaiDecheance()
  {
    return ((AttributionPC)getPC()).getDateFinDelaiDecheance();
  }
  
  public void setDateFinDelaiDecheance(Damj p_dateFinDelaiDecheance)
  {
    if ((m_dateFinDelaiDecheance == null) || (p_dateFinDelaiDecheance == null))
    {
      m_dateFinDelaiDecheance = p_dateFinDelaiDecheance;
      ((AttributionPC)getPC()).setDateFinDelaiDecheance(p_dateFinDelaiDecheance);
    }
    else if ((m_dateFinDelaiDecheance != null) && (p_dateFinDelaiDecheance != null) && (!p_dateFinDelaiDecheance.equals(m_dateFinDelaiDecheance)))
    {
      m_dateFinDelaiDecheance = p_dateFinDelaiDecheance;
      ((AttributionPC)getPC()).setDateFinDelaiDecheance(p_dateFinDelaiDecheance);
    }
  }
  
  protected String rawGetOrigineDecision()
  {
    return ((AttributionPC)getPC()).getOrigineDecision();
  }
  
  public String getOrigineDecision()
  {
    return ((AttributionPC)getPC()).getOrigineDecision();
  }
  
  public void setOrigineDecision(String p_origineDecision)
  {
    if ((m_origineDecision == null) || (p_origineDecision == null))
    {
      m_origineDecision = p_origineDecision;
      ((AttributionPC)getPC()).setOrigineDecision(p_origineDecision);
    }
    else if ((m_origineDecision != null) && (p_origineDecision != null) && (!p_origineDecision.equals(m_origineDecision)))
    {
      m_origineDecision = p_origineDecision;
      ((AttributionPC)getPC()).setOrigineDecision(p_origineDecision);
    }
  }
  
  protected BigDecimal rawGetCapitalOdPrecedente()
  {
    return ((AttributionPC)getPC()).getCapitalOdPrecedente();
  }
  
  public BigDecimal getCapitalOdPrecedente()
  {
    return ((AttributionPC)getPC()).getCapitalOdPrecedente();
  }
  
  public void setCapitalOdPrecedente(BigDecimal p_capitalOdPrecedente)
  {
    if ((m_capitalOdPrecedente == null) || (p_capitalOdPrecedente == null))
    {
      m_capitalOdPrecedente = p_capitalOdPrecedente;
      ((AttributionPC)getPC()).setCapitalOdPrecedente(p_capitalOdPrecedente);
    }
    else if ((m_capitalOdPrecedente != null) && (p_capitalOdPrecedente != null) && (!p_capitalOdPrecedente.equals(m_capitalOdPrecedente)))
    {
      m_capitalOdPrecedente = p_capitalOdPrecedente;
      ((AttributionPC)getPC()).setCapitalOdPrecedente(p_capitalOdPrecedente);
    }
  }
  
  protected BigDecimal rawGetCapitalOdCourante()
  {
    return ((AttributionPC)getPC()).getCapitalOdCourante();
  }
  
  public BigDecimal getCapitalOdCourante()
  {
    return ((AttributionPC)getPC()).getCapitalOdCourante();
  }
  
  public void setCapitalOdCourante(BigDecimal p_capitalOdCourante)
  {
    if ((m_capitalOdCourante == null) || (p_capitalOdCourante == null))
    {
      m_capitalOdCourante = p_capitalOdCourante;
      ((AttributionPC)getPC()).setCapitalOdCourante(p_capitalOdCourante);
    }
    else if ((m_capitalOdCourante != null) && (p_capitalOdCourante != null) && (!p_capitalOdCourante.equals(m_capitalOdCourante)))
    {
      m_capitalOdCourante = p_capitalOdCourante;
      ((AttributionPC)getPC()).setCapitalOdCourante(p_capitalOdCourante);
    }
  }
  
  protected String rawGetTypeChomageSaisonnier()
  {
    return ((AttributionPC)getPC()).getTypeChomageSaisonnier();
  }
  
  public String getTypeChomageSaisonnier()
  {
    return ((AttributionPC)getPC()).getTypeChomageSaisonnier();
  }
  
  public void setTypeChomageSaisonnier(String p_typeChomageSaisonnier)
  {
    if ((m_typeChomageSaisonnier == null) || (p_typeChomageSaisonnier == null))
    {
      m_typeChomageSaisonnier = p_typeChomageSaisonnier;
      ((AttributionPC)getPC()).setTypeChomageSaisonnier(p_typeChomageSaisonnier);
    }
    else if ((m_typeChomageSaisonnier != null) && (p_typeChomageSaisonnier != null) && (!p_typeChomageSaisonnier.equals(m_typeChomageSaisonnier)))
    {
      m_typeChomageSaisonnier = p_typeChomageSaisonnier;
      ((AttributionPC)getPC()).setTypeChomageSaisonnier(p_typeChomageSaisonnier);
    }
  }
  
  protected BigDecimal rawGetCapitalDroitPrecedentSp()
  {
    return ((AttributionPC)getPC()).getCapitalDroitPrecedentSp();
  }
  
  public BigDecimal getCapitalDroitPrecedentSp()
  {
    return ((AttributionPC)getPC()).getCapitalDroitPrecedentSp();
  }
  
  public void setCapitalDroitPrecedentSp(BigDecimal p_capitalDroitPrecedentSp)
  {
    if ((m_capitalDroitPrecedentSp == null) || (p_capitalDroitPrecedentSp == null))
    {
      m_capitalDroitPrecedentSp = p_capitalDroitPrecedentSp;
      ((AttributionPC)getPC()).setCapitalDroitPrecedentSp(p_capitalDroitPrecedentSp);
    }
    else if ((m_capitalDroitPrecedentSp != null) && (p_capitalDroitPrecedentSp != null) && (!p_capitalDroitPrecedentSp.equals(m_capitalDroitPrecedentSp)))
    {
      m_capitalDroitPrecedentSp = p_capitalDroitPrecedentSp;
      ((AttributionPC)getPC()).setCapitalDroitPrecedentSp(p_capitalDroitPrecedentSp);
    }
  }
  
  protected Damj rawGetDateTheoriqueFinDroit()
  {
    return ((AttributionPC)getPC()).getDateTheoriqueFinDroit();
  }
  
  public Damj getDateTheoriqueFinDroit()
  {
    return ((AttributionPC)getPC()).getDateTheoriqueFinDroit();
  }
  
  public void setDateTheoriqueFinDroit(Damj p_dateTheoriqueFinDroit)
  {
    if ((m_dateTheoriqueFinDroit == null) || (p_dateTheoriqueFinDroit == null))
    {
      m_dateTheoriqueFinDroit = p_dateTheoriqueFinDroit;
      ((AttributionPC)getPC()).setDateTheoriqueFinDroit(p_dateTheoriqueFinDroit);
    }
    else if ((m_dateTheoriqueFinDroit != null) && (p_dateTheoriqueFinDroit != null) && (!p_dateTheoriqueFinDroit.equals(m_dateTheoriqueFinDroit)))
    {
      m_dateTheoriqueFinDroit = p_dateTheoriqueFinDroit;
      ((AttributionPC)getPC()).setDateTheoriqueFinDroit(p_dateTheoriqueFinDroit);
    }
  }
  
  protected String rawGetPlus100trimestres()
  {
    return ((AttributionPC)getPC()).getPlus100trimestres();
  }
  
  public String getPlus100trimestres()
  {
    return ((AttributionPC)getPC()).getPlus100trimestres();
  }
  
  public void setPlus100trimestres(String p_plus100trimestres)
  {
    if ((m_plus100trimestres == null) || (p_plus100trimestres == null))
    {
      m_plus100trimestres = p_plus100trimestres;
      ((AttributionPC)getPC()).setPlus100trimestres(p_plus100trimestres);
    }
    else if ((m_plus100trimestres != null) && (p_plus100trimestres != null) && (!p_plus100trimestres.equals(m_plus100trimestres)))
    {
      m_plus100trimestres = p_plus100trimestres;
      ((AttributionPC)getPC()).setPlus100trimestres(p_plus100trimestres);
    }
  }
  
  protected int rawGetDureeTheoriqueDroitRetenu()
  {
    return ((AttributionPC)getPC()).getDureeTheoriqueDroitRetenu();
  }
  
  public int getDureeTheoriqueDroitRetenu()
  {
    return ((AttributionPC)getPC()).getDureeTheoriqueDroitRetenu();
  }
  
  public void setDureeTheoriqueDroitRetenu(int p_dureeTheoriqueDroitRetenu)
  {
    ((AttributionPC)getPC()).setDureeTheoriqueDroitRetenu(p_dureeTheoriqueDroitRetenu);
  }
  
  protected String rawGetReferenceReglementaireAffiliationDroitRetenu()
  {
    return ((AttributionPC)getPC()).getReferenceReglementaireAffiliationDroitRetenu();
  }
  
  public String getReferenceReglementaireAffiliationDroitRetenu()
  {
    return ((AttributionPC)getPC()).getReferenceReglementaireAffiliationDroitRetenu();
  }
  
  public void setReferenceReglementaireAffiliationDroitRetenu(String p_referenceReglementaireAffiliationDroitRetenu)
  {
    if ((m_referenceReglementaireAffiliationDroitRetenu == null) || (p_referenceReglementaireAffiliationDroitRetenu == null))
    {
      m_referenceReglementaireAffiliationDroitRetenu = p_referenceReglementaireAffiliationDroitRetenu;
      ((AttributionPC)getPC()).setReferenceReglementaireAffiliationDroitRetenu(p_referenceReglementaireAffiliationDroitRetenu);
    }
    else if ((m_referenceReglementaireAffiliationDroitRetenu != null) && (p_referenceReglementaireAffiliationDroitRetenu != null) && (!p_referenceReglementaireAffiliationDroitRetenu.equals(m_referenceReglementaireAffiliationDroitRetenu)))
    {
      m_referenceReglementaireAffiliationDroitRetenu = p_referenceReglementaireAffiliationDroitRetenu;
      ((AttributionPC)getPC()).setReferenceReglementaireAffiliationDroitRetenu(p_referenceReglementaireAffiliationDroitRetenu);
    }
  }
  
  protected String rawGetReglementApplicableCourant()
  {
    return ((AttributionPC)getPC()).getReglementApplicableCourant();
  }
  
  public String getReglementApplicableCourant()
  {
    return ((AttributionPC)getPC()).getReglementApplicableCourant();
  }
  
  public void setReglementApplicableCourant(String p_reglementApplicableCourant)
  {
    if ((m_reglementApplicableCourant == null) || (p_reglementApplicableCourant == null))
    {
      m_reglementApplicableCourant = p_reglementApplicableCourant;
      ((AttributionPC)getPC()).setReglementApplicableCourant(p_reglementApplicableCourant);
    }
    else if ((m_reglementApplicableCourant != null) && (p_reglementApplicableCourant != null) && (!p_reglementApplicableCourant.equals(m_reglementApplicableCourant)))
    {
      m_reglementApplicableCourant = p_reglementApplicableCourant;
      ((AttributionPC)getPC()).setReglementApplicableCourant(p_reglementApplicableCourant);
    }
  }
  
  protected String rawGetReglementApplicableRetenu()
  {
    return ((AttributionPC)getPC()).getReglementApplicableRetenu();
  }
  
  public String getReglementApplicableRetenu()
  {
    return ((AttributionPC)getPC()).getReglementApplicableRetenu();
  }
  
  public void setReglementApplicableRetenu(String p_reglementApplicableRetenu)
  {
    if ((m_reglementApplicableRetenu == null) || (p_reglementApplicableRetenu == null))
    {
      m_reglementApplicableRetenu = p_reglementApplicableRetenu;
      ((AttributionPC)getPC()).setReglementApplicableRetenu(p_reglementApplicableRetenu);
    }
    else if ((m_reglementApplicableRetenu != null) && (p_reglementApplicableRetenu != null) && (!p_reglementApplicableRetenu.equals(m_reglementApplicableRetenu)))
    {
      m_reglementApplicableRetenu = p_reglementApplicableRetenu;
      ((AttributionPC)getPC()).setReglementApplicableRetenu(p_reglementApplicableRetenu);
    }
  }
  
  protected String rawGetIdGaecPeriodeFg()
  {
    return ((AttributionPC)getPC()).getIdGaecPeriodeFg();
  }
  
  public String getIdGaecPeriodeFg()
  {
    return ((AttributionPC)getPC()).getIdGaecPeriodeFg();
  }
  
  public void setIdGaecPeriodeFg(String p_idGaecPeriodeFg)
  {
    if ((m_idGaecPeriodeFg == null) || (p_idGaecPeriodeFg == null))
    {
      m_idGaecPeriodeFg = p_idGaecPeriodeFg;
      ((AttributionPC)getPC()).setIdGaecPeriodeFg(p_idGaecPeriodeFg);
    }
    else if ((m_idGaecPeriodeFg != null) && (p_idGaecPeriodeFg != null) && (!p_idGaecPeriodeFg.equals(m_idGaecPeriodeFg)))
    {
      m_idGaecPeriodeFg = p_idGaecPeriodeFg;
      ((AttributionPC)getPC()).setIdGaecPeriodeFg(p_idGaecPeriodeFg);
    }
  }
  
  protected String rawGetIdGaecPeriodeRa()
  {
    return ((AttributionPC)getPC()).getIdGaecPeriodeRa();
  }
  
  public String getIdGaecPeriodeRa()
  {
    return ((AttributionPC)getPC()).getIdGaecPeriodeRa();
  }
  
  public void setIdGaecPeriodeRa(String p_idGaecPeriodeRa)
  {
    if ((m_idGaecPeriodeRa == null) || (p_idGaecPeriodeRa == null))
    {
      m_idGaecPeriodeRa = p_idGaecPeriodeRa;
      ((AttributionPC)getPC()).setIdGaecPeriodeRa(p_idGaecPeriodeRa);
    }
    else if ((m_idGaecPeriodeRa != null) && (p_idGaecPeriodeRa != null) && (!p_idGaecPeriodeRa.equals(m_idGaecPeriodeRa)))
    {
      m_idGaecPeriodeRa = p_idGaecPeriodeRa;
      ((AttributionPC)getPC()).setIdGaecPeriodeRa(p_idGaecPeriodeRa);
    }
  }
  
  protected Damj rawGetFctRetenueOD()
  {
    return ((AttributionPC)getPC()).getFctRetenueOD();
  }
  
  public Damj getFctRetenueOD()
  {
    return ((AttributionPC)getPC()).getFctRetenueOD();
  }
  
  public void setFctRetenueOD(Damj p_fctRetenueOD)
  {
    if ((m_fctRetenueOD == null) || (p_fctRetenueOD == null))
    {
      m_fctRetenueOD = p_fctRetenueOD;
      ((AttributionPC)getPC()).setFctRetenueOD(p_fctRetenueOD);
    }
    else if ((m_fctRetenueOD != null) && (p_fctRetenueOD != null) && (!p_fctRetenueOD.equals(m_fctRetenueOD)))
    {
      m_fctRetenueOD = p_fctRetenueOD;
      ((AttributionPC)getPC()).setFctRetenueOD(p_fctRetenueOD);
    }
  }
  
  protected String rawGetMotifFctRetenueOD()
  {
    return ((AttributionPC)getPC()).getMotifFctRetenueOD();
  }
  
  public String getMotifFctRetenueOD()
  {
    return ((AttributionPC)getPC()).getMotifFctRetenueOD();
  }
  
  public void setMotifFctRetenueOD(String p_motifFctRetenueOD)
  {
    if ((m_motifFctRetenueOD == null) || (p_motifFctRetenueOD == null))
    {
      m_motifFctRetenueOD = p_motifFctRetenueOD;
      ((AttributionPC)getPC()).setMotifFctRetenueOD(p_motifFctRetenueOD);
    }
    else if ((m_motifFctRetenueOD != null) && (p_motifFctRetenueOD != null) && (!p_motifFctRetenueOD.equals(m_motifFctRetenueOD)))
    {
      m_motifFctRetenueOD = p_motifFctRetenueOD;
      ((AttributionPC)getPC()).setMotifFctRetenueOD(p_motifFctRetenueOD);
    }
  }
  
  protected Damj rawGetDateDerniereFctDansDelaiForclusion()
  {
    return ((AttributionPC)getPC()).getDateDerniereFctDansDelaiForclusion();
  }
  
  public Damj getDateDerniereFctDansDelaiForclusion()
  {
    return ((AttributionPC)getPC()).getDateDerniereFctDansDelaiForclusion();
  }
  
  public void setDateDerniereFctDansDelaiForclusion(Damj p_dateDerniereFctDansDelaiForclusion)
  {
    if ((m_dateDerniereFctDansDelaiForclusion == null) || (p_dateDerniereFctDansDelaiForclusion == null))
    {
      m_dateDerniereFctDansDelaiForclusion = p_dateDerniereFctDansDelaiForclusion;
      ((AttributionPC)getPC()).setDateDerniereFctDansDelaiForclusion(p_dateDerniereFctDansDelaiForclusion);
    }
    else if ((m_dateDerniereFctDansDelaiForclusion != null) && (p_dateDerniereFctDansDelaiForclusion != null) && (!p_dateDerniereFctDansDelaiForclusion.equals(m_dateDerniereFctDansDelaiForclusion)))
    {
      m_dateDerniereFctDansDelaiForclusion = p_dateDerniereFctDansDelaiForclusion;
      ((AttributionPC)getPC()).setDateDerniereFctDansDelaiForclusion(p_dateDerniereFctDansDelaiForclusion);
    }
  }
  
  protected String rawGetMotifDerniereFctDansDelaiForclusion()
  {
    return ((AttributionPC)getPC()).getMotifDerniereFctDansDelaiForclusion();
  }
  
  public String getMotifDerniereFctDansDelaiForclusion()
  {
    return ((AttributionPC)getPC()).getMotifDerniereFctDansDelaiForclusion();
  }
  
  public void setMotifDerniereFctDansDelaiForclusion(String p_motifDerniereFctDansDelaiForclusion)
  {
    if ((m_motifDerniereFctDansDelaiForclusion == null) || (p_motifDerniereFctDansDelaiForclusion == null))
    {
      m_motifDerniereFctDansDelaiForclusion = p_motifDerniereFctDansDelaiForclusion;
      ((AttributionPC)getPC()).setMotifDerniereFctDansDelaiForclusion(p_motifDerniereFctDansDelaiForclusion);
    }
    else if ((m_motifDerniereFctDansDelaiForclusion != null) && (p_motifDerniereFctDansDelaiForclusion != null) && (!p_motifDerniereFctDansDelaiForclusion.equals(m_motifDerniereFctDansDelaiForclusion)))
    {
      m_motifDerniereFctDansDelaiForclusion = p_motifDerniereFctDansDelaiForclusion;
      ((AttributionPC)getPC()).setMotifDerniereFctDansDelaiForclusion(p_motifDerniereFctDansDelaiForclusion);
    }
  }
  
  protected String rawGetComplementSs()
  {
    return ((AttributionPC)getPC()).getComplementSs();
  }
  
  public String getComplementSs()
  {
    return ((AttributionPC)getPC()).getComplementSs();
  }
  
  public void setComplementSs(String p_complementSs)
  {
    if ((m_complementSs == null) || (p_complementSs == null))
    {
      m_complementSs = p_complementSs;
      ((AttributionPC)getPC()).setComplementSs(p_complementSs);
    }
    else if ((m_complementSs != null) && (p_complementSs != null) && (!p_complementSs.equals(m_complementSs)))
    {
      m_complementSs = p_complementSs;
      ((AttributionPC)getPC()).setComplementSs(p_complementSs);
    }
  }
  
  protected int rawGetRegimeSs()
  {
    return ((AttributionPC)getPC()).getRegimeSs();
  }
  
  public int getRegimeSs()
  {
    return ((AttributionPC)getPC()).getRegimeSs();
  }
  
  public void setRegimeSs(int p_regimeSs)
  {
    ((AttributionPC)getPC()).setRegimeSs(p_regimeSs);
  }
  
  protected String rawGetCodeQualification()
  {
    return ((AttributionPC)getPC()).getCodeQualification();
  }
  
  public String getCodeQualification()
  {
    return ((AttributionPC)getPC()).getCodeQualification();
  }
  
  public void setCodeQualification(String p_codeQualification)
  {
    if ((m_codeQualification == null) || (p_codeQualification == null))
    {
      m_codeQualification = p_codeQualification;
      ((AttributionPC)getPC()).setCodeQualification(p_codeQualification);
    }
    else if ((m_codeQualification != null) && (p_codeQualification != null) && (!p_codeQualification.equals(m_codeQualification)))
    {
      m_codeQualification = p_codeQualification;
      ((AttributionPC)getPC()).setCodeQualification(p_codeQualification);
    }
  }
  
  protected String rawGetCodeQualificationDroitCourant()
  {
    return ((AttributionPC)getPC()).getCodeQualificationDroitCourant();
  }
  
  public String getCodeQualificationDroitCourant()
  {
    return ((AttributionPC)getPC()).getCodeQualificationDroitCourant();
  }
  
  public void setCodeQualificationDroitCourant(String p_codeQualificationDroitCourant)
  {
    if ((m_codeQualificationDroitCourant == null) || (p_codeQualificationDroitCourant == null))
    {
      m_codeQualificationDroitCourant = p_codeQualificationDroitCourant;
      ((AttributionPC)getPC()).setCodeQualificationDroitCourant(p_codeQualificationDroitCourant);
    }
    else if ((m_codeQualificationDroitCourant != null) && (p_codeQualificationDroitCourant != null) && (!p_codeQualificationDroitCourant.equals(m_codeQualificationDroitCourant)))
    {
      m_codeQualificationDroitCourant = p_codeQualificationDroitCourant;
      ((AttributionPC)getPC()).setCodeQualificationDroitCourant(p_codeQualificationDroitCourant);
    }
  }
  
  protected int rawGetCodeMetier()
  {
    return ((AttributionPC)getPC()).getCodeMetier();
  }
  
  public int getCodeMetier()
  {
    return ((AttributionPC)getPC()).getCodeMetier();
  }
  
  public void setCodeMetier(int p_codeMetier)
  {
    ((AttributionPC)getPC()).setCodeMetier(p_codeMetier);
  }
  
  protected int rawGetCodeMetierDroitCourant()
  {
    return ((AttributionPC)getPC()).getCodeMetierDroitCourant();
  }
  
  public int getCodeMetierDroitCourant()
  {
    return ((AttributionPC)getPC()).getCodeMetierDroitCourant();
  }
  
  public void setCodeMetierDroitCourant(int p_codeMetierDroitCourant)
  {
    ((AttributionPC)getPC()).setCodeMetierDroitCourant(p_codeMetierDroitCourant);
  }
  
  protected int rawGetCodeStatutIndividu()
  {
    return ((AttributionPC)getPC()).getCodeStatutIndividu();
  }
  
  public int getCodeStatutIndividu()
  {
    return ((AttributionPC)getPC()).getCodeStatutIndividu();
  }
  
  public void setCodeStatutIndividu(int p_codeStatutIndividu)
  {
    ((AttributionPC)getPC()).setCodeStatutIndividu(p_codeStatutIndividu);
  }
  
  protected String rawGetPrcSjrForces()
  {
    return ((AttributionPC)getPC()).getPrcSjrForces();
  }
  
  public String getPrcSjrForces()
  {
    return ((AttributionPC)getPC()).getPrcSjrForces();
  }
  
  public void setPrcSjrForces(String p_prcSjrForces)
  {
    if ((m_prcSjrForces == null) || (p_prcSjrForces == null))
    {
      m_prcSjrForces = p_prcSjrForces;
      ((AttributionPC)getPC()).setPrcSjrForces(p_prcSjrForces);
    }
    else if ((m_prcSjrForces != null) && (p_prcSjrForces != null) && (!p_prcSjrForces.equals(m_prcSjrForces)))
    {
      m_prcSjrForces = p_prcSjrForces;
      ((AttributionPC)getPC()).setPrcSjrForces(p_prcSjrForces);
    }
  }
  
  protected Damj rawGetDateDebutPrcDroitCourant()
  {
    return ((AttributionPC)getPC()).getDateDebutPrcDroitCourant();
  }
  
  public Damj getDateDebutPrcDroitCourant()
  {
    return ((AttributionPC)getPC()).getDateDebutPrcDroitCourant();
  }
  
  public void setDateDebutPrcDroitCourant(Damj p_dateDebutPrcDroitCourant)
  {
    if ((m_dateDebutPrcDroitCourant == null) || (p_dateDebutPrcDroitCourant == null))
    {
      m_dateDebutPrcDroitCourant = p_dateDebutPrcDroitCourant;
      ((AttributionPC)getPC()).setDateDebutPrcDroitCourant(p_dateDebutPrcDroitCourant);
    }
    else if ((m_dateDebutPrcDroitCourant != null) && (p_dateDebutPrcDroitCourant != null) && (!p_dateDebutPrcDroitCourant.equals(m_dateDebutPrcDroitCourant)))
    {
      m_dateDebutPrcDroitCourant = p_dateDebutPrcDroitCourant;
      ((AttributionPC)getPC()).setDateDebutPrcDroitCourant(p_dateDebutPrcDroitCourant);
    }
  }
  
  protected Damj rawGetDateFinPrcDroitCourant()
  {
    return ((AttributionPC)getPC()).getDateFinPrcDroitCourant();
  }
  
  public Damj getDateFinPrcDroitCourant()
  {
    return ((AttributionPC)getPC()).getDateFinPrcDroitCourant();
  }
  
  public void setDateFinPrcDroitCourant(Damj p_dateFinPrcDroitCourant)
  {
    if ((m_dateFinPrcDroitCourant == null) || (p_dateFinPrcDroitCourant == null))
    {
      m_dateFinPrcDroitCourant = p_dateFinPrcDroitCourant;
      ((AttributionPC)getPC()).setDateFinPrcDroitCourant(p_dateFinPrcDroitCourant);
    }
    else if ((m_dateFinPrcDroitCourant != null) && (p_dateFinPrcDroitCourant != null) && (!p_dateFinPrcDroitCourant.equals(m_dateFinPrcDroitCourant)))
    {
      m_dateFinPrcDroitCourant = p_dateFinPrcDroitCourant;
      ((AttributionPC)getPC()).setDateFinPrcDroitCourant(p_dateFinPrcDroitCourant);
    }
  }
  
  protected BigDecimal rawGetMontantSjrCourantNonPlafonne()
  {
    return ((AttributionPC)getPC()).getMontantSjrCourantNonPlafonne();
  }
  
  public BigDecimal getMontantSjrCourantNonPlafonne()
  {
    return ((AttributionPC)getPC()).getMontantSjrCourantNonPlafonne();
  }
  
  public void setMontantSjrCourantNonPlafonne(BigDecimal p_montantSjrCourantNonPlafonne)
  {
    if ((m_montantSjrCourantNonPlafonne == null) || (p_montantSjrCourantNonPlafonne == null))
    {
      m_montantSjrCourantNonPlafonne = p_montantSjrCourantNonPlafonne;
      ((AttributionPC)getPC()).setMontantSjrCourantNonPlafonne(p_montantSjrCourantNonPlafonne);
    }
    else if ((m_montantSjrCourantNonPlafonne != null) && (p_montantSjrCourantNonPlafonne != null) && (!p_montantSjrCourantNonPlafonne.equals(m_montantSjrCourantNonPlafonne)))
    {
      m_montantSjrCourantNonPlafonne = p_montantSjrCourantNonPlafonne;
      ((AttributionPC)getPC()).setMontantSjrCourantNonPlafonne(p_montantSjrCourantNonPlafonne);
    }
  }
  
  protected BigDecimal rawGetMontantSjrCourantCalculePlafonne()
  {
    return ((AttributionPC)getPC()).getMontantSjrCourantCalculePlafonne();
  }
  
  public BigDecimal getMontantSjrCourantCalculePlafonne()
  {
    return ((AttributionPC)getPC()).getMontantSjrCourantCalculePlafonne();
  }
  
  public void setMontantSjrCourantCalculePlafonne(BigDecimal p_montantSjrCourantCalculePlafonne)
  {
    if ((m_montantSjrCourantCalculePlafonne == null) || (p_montantSjrCourantCalculePlafonne == null))
    {
      m_montantSjrCourantCalculePlafonne = p_montantSjrCourantCalculePlafonne;
      ((AttributionPC)getPC()).setMontantSjrCourantCalculePlafonne(p_montantSjrCourantCalculePlafonne);
    }
    else if ((m_montantSjrCourantCalculePlafonne != null) && (p_montantSjrCourantCalculePlafonne != null) && (!p_montantSjrCourantCalculePlafonne.equals(m_montantSjrCourantCalculePlafonne)))
    {
      m_montantSjrCourantCalculePlafonne = p_montantSjrCourantCalculePlafonne;
      ((AttributionPC)getPC()).setMontantSjrCourantCalculePlafonne(p_montantSjrCourantCalculePlafonne);
    }
  }
  
  protected BigDecimal rawGetMontantSjrCourantPlafonne()
  {
    return ((AttributionPC)getPC()).getMontantSjrCourantPlafonne();
  }
  
  public BigDecimal getMontantSjrCourantPlafonne()
  {
    return ((AttributionPC)getPC()).getMontantSjrCourantPlafonne();
  }
  
  public void setMontantSjrCourantPlafonne(BigDecimal p_montantSjrCourantPlafonne)
  {
    if ((m_montantSjrCourantPlafonne == null) || (p_montantSjrCourantPlafonne == null))
    {
      m_montantSjrCourantPlafonne = p_montantSjrCourantPlafonne;
      ((AttributionPC)getPC()).setMontantSjrCourantPlafonne(p_montantSjrCourantPlafonne);
    }
    else if ((m_montantSjrCourantPlafonne != null) && (p_montantSjrCourantPlafonne != null) && (!p_montantSjrCourantPlafonne.equals(m_montantSjrCourantPlafonne)))
    {
      m_montantSjrCourantPlafonne = p_montantSjrCourantPlafonne;
      ((AttributionPC)getPC()).setMontantSjrCourantPlafonne(p_montantSjrCourantPlafonne);
    }
  }
  
  protected BigDecimal rawGetMontantSalaireReferenceSjrCourant()
  {
    return ((AttributionPC)getPC()).getMontantSalaireReferenceSjrCourant();
  }
  
  public BigDecimal getMontantSalaireReferenceSjrCourant()
  {
    return ((AttributionPC)getPC()).getMontantSalaireReferenceSjrCourant();
  }
  
  public void setMontantSalaireReferenceSjrCourant(BigDecimal p_montantSalaireReferenceSjrCourant)
  {
    if ((m_montantSalaireReferenceSjrCourant == null) || (p_montantSalaireReferenceSjrCourant == null))
    {
      m_montantSalaireReferenceSjrCourant = p_montantSalaireReferenceSjrCourant;
      ((AttributionPC)getPC()).setMontantSalaireReferenceSjrCourant(p_montantSalaireReferenceSjrCourant);
    }
    else if ((m_montantSalaireReferenceSjrCourant != null) && (p_montantSalaireReferenceSjrCourant != null) && (!p_montantSalaireReferenceSjrCourant.equals(m_montantSalaireReferenceSjrCourant)))
    {
      m_montantSalaireReferenceSjrCourant = p_montantSalaireReferenceSjrCourant;
      ((AttributionPC)getPC()).setMontantSalaireReferenceSjrCourant(p_montantSalaireReferenceSjrCourant);
    }
  }
  
  protected BigDecimal rawGetNbJoursDiviseurSjrCourant()
  {
    return ((AttributionPC)getPC()).getNbJoursDiviseurSjrCourant();
  }
  
  public BigDecimal getNbJoursDiviseurSjrCourant()
  {
    return ((AttributionPC)getPC()).getNbJoursDiviseurSjrCourant();
  }
  
  public void setNbJoursDiviseurSjrCourant(BigDecimal p_nbJoursDiviseurSjrCourant)
  {
    if ((m_nbJoursDiviseurSjrCourant == null) || (p_nbJoursDiviseurSjrCourant == null))
    {
      m_nbJoursDiviseurSjrCourant = p_nbJoursDiviseurSjrCourant;
      ((AttributionPC)getPC()).setNbJoursDiviseurSjrCourant(p_nbJoursDiviseurSjrCourant);
    }
    else if ((m_nbJoursDiviseurSjrCourant != null) && (p_nbJoursDiviseurSjrCourant != null) && (!p_nbJoursDiviseurSjrCourant.equals(m_nbJoursDiviseurSjrCourant)))
    {
      m_nbJoursDiviseurSjrCourant = p_nbJoursDiviseurSjrCourant;
      ((AttributionPC)getPC()).setNbJoursDiviseurSjrCourant(p_nbJoursDiviseurSjrCourant);
    }
  }
  
  protected int rawGetNbHeuresTravailleesA8A10SjrCourant()
  {
    return ((AttributionPC)getPC()).getNbHeuresTravailleesA8A10SjrCourant();
  }
  
  public int getNbHeuresTravailleesA8A10SjrCourant()
  {
    return ((AttributionPC)getPC()).getNbHeuresTravailleesA8A10SjrCourant();
  }
  
  public void setNbHeuresTravailleesA8A10SjrCourant(int p_nbHeuresTravailleesA8A10SjrCourant)
  {
    ((AttributionPC)getPC()).setNbHeuresTravailleesA8A10SjrCourant(p_nbHeuresTravailleesA8A10SjrCourant);
  }
  
  protected BigDecimal rawGetCoeffTempsPartielSjrCourant()
  {
    return ((AttributionPC)getPC()).getCoeffTempsPartielSjrCourant();
  }
  
  public BigDecimal getCoeffTempsPartielSjrCourant()
  {
    return ((AttributionPC)getPC()).getCoeffTempsPartielSjrCourant();
  }
  
  public void setCoeffTempsPartielSjrCourant(BigDecimal p_coeffTempsPartielSjrCourant)
  {
    if ((m_coeffTempsPartielSjrCourant == null) || (p_coeffTempsPartielSjrCourant == null))
    {
      m_coeffTempsPartielSjrCourant = p_coeffTempsPartielSjrCourant;
      ((AttributionPC)getPC()).setCoeffTempsPartielSjrCourant(p_coeffTempsPartielSjrCourant);
    }
    else if ((m_coeffTempsPartielSjrCourant != null) && (p_coeffTempsPartielSjrCourant != null) && (!p_coeffTempsPartielSjrCourant.equals(m_coeffTempsPartielSjrCourant)))
    {
      m_coeffTempsPartielSjrCourant = p_coeffTempsPartielSjrCourant;
      ((AttributionPC)getPC()).setCoeffTempsPartielSjrCourant(p_coeffTempsPartielSjrCourant);
    }
  }
  
  protected BigDecimal rawGetCoeffSaisonnierCalcSjrCourant()
  {
    return ((AttributionPC)getPC()).getCoeffSaisonnierCalcSjrCourant();
  }
  
  public BigDecimal getCoeffSaisonnierCalcSjrCourant()
  {
    return ((AttributionPC)getPC()).getCoeffSaisonnierCalcSjrCourant();
  }
  
  public void setCoeffSaisonnierCalcSjrCourant(BigDecimal p_coeffSaisonnierCalcSjrCourant)
  {
    if ((m_coeffSaisonnierCalcSjrCourant == null) || (p_coeffSaisonnierCalcSjrCourant == null))
    {
      m_coeffSaisonnierCalcSjrCourant = p_coeffSaisonnierCalcSjrCourant;
      ((AttributionPC)getPC()).setCoeffSaisonnierCalcSjrCourant(p_coeffSaisonnierCalcSjrCourant);
    }
    else if ((m_coeffSaisonnierCalcSjrCourant != null) && (p_coeffSaisonnierCalcSjrCourant != null) && (!p_coeffSaisonnierCalcSjrCourant.equals(m_coeffSaisonnierCalcSjrCourant)))
    {
      m_coeffSaisonnierCalcSjrCourant = p_coeffSaisonnierCalcSjrCourant;
      ((AttributionPC)getPC()).setCoeffSaisonnierCalcSjrCourant(p_coeffSaisonnierCalcSjrCourant);
    }
  }
  
  protected BigDecimal rawGetCoeffSaisonnierForceSjrCourant()
  {
    return ((AttributionPC)getPC()).getCoeffSaisonnierForceSjrCourant();
  }
  
  public BigDecimal getCoeffSaisonnierForceSjrCourant()
  {
    return ((AttributionPC)getPC()).getCoeffSaisonnierForceSjrCourant();
  }
  
  public void setCoeffSaisonnierForceSjrCourant(BigDecimal p_coeffSaisonnierForceSjrCourant)
  {
    if ((m_coeffSaisonnierForceSjrCourant == null) || (p_coeffSaisonnierForceSjrCourant == null))
    {
      m_coeffSaisonnierForceSjrCourant = p_coeffSaisonnierForceSjrCourant;
      ((AttributionPC)getPC()).setCoeffSaisonnierForceSjrCourant(p_coeffSaisonnierForceSjrCourant);
    }
    else if ((m_coeffSaisonnierForceSjrCourant != null) && (p_coeffSaisonnierForceSjrCourant != null) && (!p_coeffSaisonnierForceSjrCourant.equals(m_coeffSaisonnierForceSjrCourant)))
    {
      m_coeffSaisonnierForceSjrCourant = p_coeffSaisonnierForceSjrCourant;
      ((AttributionPC)getPC()).setCoeffSaisonnierForceSjrCourant(p_coeffSaisonnierForceSjrCourant);
    }
  }
  
  protected Damj rawGetFinPrcSjrRetenu()
  {
    return ((AttributionPC)getPC()).getFinPrcSjrRetenu();
  }
  
  public Damj getFinPrcSjrRetenu()
  {
    return ((AttributionPC)getPC()).getFinPrcSjrRetenu();
  }
  
  public void setFinPrcSjrRetenu(Damj p_finPrcSjrRetenu)
  {
    if ((m_finPrcSjrRetenu == null) || (p_finPrcSjrRetenu == null))
    {
      m_finPrcSjrRetenu = p_finPrcSjrRetenu;
      ((AttributionPC)getPC()).setFinPrcSjrRetenu(p_finPrcSjrRetenu);
    }
    else if ((m_finPrcSjrRetenu != null) && (p_finPrcSjrRetenu != null) && (!p_finPrcSjrRetenu.equals(m_finPrcSjrRetenu)))
    {
      m_finPrcSjrRetenu = p_finPrcSjrRetenu;
      ((AttributionPC)getPC()).setFinPrcSjrRetenu(p_finPrcSjrRetenu);
    }
  }
  
  protected BigDecimal rawGetMontantSjrRetenuPlafonne()
  {
    return ((AttributionPC)getPC()).getMontantSjrRetenuPlafonne();
  }
  
  public BigDecimal getMontantSjrRetenuPlafonne()
  {
    return ((AttributionPC)getPC()).getMontantSjrRetenuPlafonne();
  }
  
  public void setMontantSjrRetenuPlafonne(BigDecimal p_montantSjrRetenuPlafonne)
  {
    if ((m_montantSjrRetenuPlafonne == null) || (p_montantSjrRetenuPlafonne == null))
    {
      m_montantSjrRetenuPlafonne = p_montantSjrRetenuPlafonne;
      ((AttributionPC)getPC()).setMontantSjrRetenuPlafonne(p_montantSjrRetenuPlafonne);
    }
    else if ((m_montantSjrRetenuPlafonne != null) && (p_montantSjrRetenuPlafonne != null) && (!p_montantSjrRetenuPlafonne.equals(m_montantSjrRetenuPlafonne)))
    {
      m_montantSjrRetenuPlafonne = p_montantSjrRetenuPlafonne;
      ((AttributionPC)getPC()).setMontantSjrRetenuPlafonne(p_montantSjrRetenuPlafonne);
    }
  }
  
  protected Damj rawGetDateEffetSjc()
  {
    return ((AttributionPC)getPC()).getDateEffetSjc();
  }
  
  public Damj getDateEffetSjc()
  {
    return ((AttributionPC)getPC()).getDateEffetSjc();
  }
  
  public void setDateEffetSjc(Damj p_dateEffetSjc)
  {
    if ((m_dateEffetSjc == null) || (p_dateEffetSjc == null))
    {
      m_dateEffetSjc = p_dateEffetSjc;
      ((AttributionPC)getPC()).setDateEffetSjc(p_dateEffetSjc);
    }
    else if ((m_dateEffetSjc != null) && (p_dateEffetSjc != null) && (!p_dateEffetSjc.equals(m_dateEffetSjc)))
    {
      m_dateEffetSjc = p_dateEffetSjc;
      ((AttributionPC)getPC()).setDateEffetSjc(p_dateEffetSjc);
    }
  }
  
  protected BigDecimal rawGetMontantSjc()
  {
    return ((AttributionPC)getPC()).getMontantSjc();
  }
  
  public BigDecimal getMontantSjc()
  {
    return ((AttributionPC)getPC()).getMontantSjc();
  }
  
  public void setMontantSjc(BigDecimal p_montantSjc)
  {
    if ((m_montantSjc == null) || (p_montantSjc == null))
    {
      m_montantSjc = p_montantSjc;
      ((AttributionPC)getPC()).setMontantSjc(p_montantSjc);
    }
    else if ((m_montantSjc != null) && (p_montantSjc != null) && (!p_montantSjc.equals(m_montantSjc)))
    {
      m_montantSjc = p_montantSjc;
      ((AttributionPC)getPC()).setMontantSjc(p_montantSjc);
    }
  }
  
  protected int rawGetNbJoursIccp()
  {
    return ((AttributionPC)getPC()).getNbJoursIccp();
  }
  
  public int getNbJoursIccp()
  {
    return ((AttributionPC)getPC()).getNbJoursIccp();
  }
  
  public void setNbJoursIccp(int p_nbJoursIccp)
  {
    ((AttributionPC)getPC()).setNbJoursIccp(p_nbJoursIccp);
  }
  
  protected String rawGetUniteDureeIccp()
  {
    return ((AttributionPC)getPC()).getUniteDureeIccp();
  }
  
  public String getUniteDureeIccp()
  {
    return ((AttributionPC)getPC()).getUniteDureeIccp();
  }
  
  public void setUniteDureeIccp(String p_uniteDureeIccp)
  {
    if ((m_uniteDureeIccp == null) || (p_uniteDureeIccp == null))
    {
      m_uniteDureeIccp = p_uniteDureeIccp;
      ((AttributionPC)getPC()).setUniteDureeIccp(p_uniteDureeIccp);
    }
    else if ((m_uniteDureeIccp != null) && (p_uniteDureeIccp != null) && (!p_uniteDureeIccp.equals(m_uniteDureeIccp)))
    {
      m_uniteDureeIccp = p_uniteDureeIccp;
      ((AttributionPC)getPC()).setUniteDureeIccp(p_uniteDureeIccp);
    }
  }
  
  protected Damj rawGetDateDebutIccp()
  {
    return ((AttributionPC)getPC()).getDateDebutIccp();
  }
  
  public Damj getDateDebutIccp()
  {
    return ((AttributionPC)getPC()).getDateDebutIccp();
  }
  
  public void setDateDebutIccp(Damj p_dateDebutIccp)
  {
    if ((m_dateDebutIccp == null) || (p_dateDebutIccp == null))
    {
      m_dateDebutIccp = p_dateDebutIccp;
      ((AttributionPC)getPC()).setDateDebutIccp(p_dateDebutIccp);
    }
    else if ((m_dateDebutIccp != null) && (p_dateDebutIccp != null) && (!p_dateDebutIccp.equals(m_dateDebutIccp)))
    {
      m_dateDebutIccp = p_dateDebutIccp;
      ((AttributionPC)getPC()).setDateDebutIccp(p_dateDebutIccp);
    }
  }
  
  protected Damj rawGetDateFinIccp()
  {
    return ((AttributionPC)getPC()).getDateFinIccp();
  }
  
  public Damj getDateFinIccp()
  {
    return ((AttributionPC)getPC()).getDateFinIccp();
  }
  
  public void setDateFinIccp(Damj p_dateFinIccp)
  {
    if ((m_dateFinIccp == null) || (p_dateFinIccp == null))
    {
      m_dateFinIccp = p_dateFinIccp;
      ((AttributionPC)getPC()).setDateFinIccp(p_dateFinIccp);
    }
    else if ((m_dateFinIccp != null) && (p_dateFinIccp != null) && (!p_dateFinIccp.equals(m_dateFinIccp)))
    {
      m_dateFinIccp = p_dateFinIccp;
      ((AttributionPC)getPC()).setDateFinIccp(p_dateFinIccp);
    }
  }
  
  protected int rawGetNbJoursIslr()
  {
    return ((AttributionPC)getPC()).getNbJoursIslr();
  }
  
  public int getNbJoursIslr()
  {
    return ((AttributionPC)getPC()).getNbJoursIslr();
  }
  
  public void setNbJoursIslr(int p_nbJoursIslr)
  {
    ((AttributionPC)getPC()).setNbJoursIslr(p_nbJoursIslr);
  }
  
  protected String rawGetUniteDureeIslr()
  {
    return ((AttributionPC)getPC()).getUniteDureeIslr();
  }
  
  public String getUniteDureeIslr()
  {
    return ((AttributionPC)getPC()).getUniteDureeIslr();
  }
  
  public void setUniteDureeIslr(String p_uniteDureeIslr)
  {
    if ((m_uniteDureeIslr == null) || (p_uniteDureeIslr == null))
    {
      m_uniteDureeIslr = p_uniteDureeIslr;
      ((AttributionPC)getPC()).setUniteDureeIslr(p_uniteDureeIslr);
    }
    else if ((m_uniteDureeIslr != null) && (p_uniteDureeIslr != null) && (!p_uniteDureeIslr.equals(m_uniteDureeIslr)))
    {
      m_uniteDureeIslr = p_uniteDureeIslr;
      ((AttributionPC)getPC()).setUniteDureeIslr(p_uniteDureeIslr);
    }
  }
  
  protected Damj rawGetDateDebutIslr()
  {
    return ((AttributionPC)getPC()).getDateDebutIslr();
  }
  
  public Damj getDateDebutIslr()
  {
    return ((AttributionPC)getPC()).getDateDebutIslr();
  }
  
  public void setDateDebutIslr(Damj p_dateDebutIslr)
  {
    if ((m_dateDebutIslr == null) || (p_dateDebutIslr == null))
    {
      m_dateDebutIslr = p_dateDebutIslr;
      ((AttributionPC)getPC()).setDateDebutIslr(p_dateDebutIslr);
    }
    else if ((m_dateDebutIslr != null) && (p_dateDebutIslr != null) && (!p_dateDebutIslr.equals(m_dateDebutIslr)))
    {
      m_dateDebutIslr = p_dateDebutIslr;
      ((AttributionPC)getPC()).setDateDebutIslr(p_dateDebutIslr);
    }
  }
  
  protected Damj rawGetDateFinIslr()
  {
    return ((AttributionPC)getPC()).getDateFinIslr();
  }
  
  public Damj getDateFinIslr()
  {
    return ((AttributionPC)getPC()).getDateFinIslr();
  }
  
  public void setDateFinIslr(Damj p_dateFinIslr)
  {
    if ((m_dateFinIslr == null) || (p_dateFinIslr == null))
    {
      m_dateFinIslr = p_dateFinIslr;
      ((AttributionPC)getPC()).setDateFinIslr(p_dateFinIslr);
    }
    else if ((m_dateFinIslr != null) && (p_dateFinIslr != null) && (!p_dateFinIslr.equals(m_dateFinIslr)))
    {
      m_dateFinIslr = p_dateFinIslr;
      ((AttributionPC)getPC()).setDateFinIslr(p_dateFinIslr);
    }
  }
  
  protected BigDecimal rawGetMontantIslr()
  {
    return ((AttributionPC)getPC()).getMontantIslr();
  }
  
  public BigDecimal getMontantIslr()
  {
    return ((AttributionPC)getPC()).getMontantIslr();
  }
  
  public void setMontantIslr(BigDecimal p_montantIslr)
  {
    if ((m_montantIslr == null) || (p_montantIslr == null))
    {
      m_montantIslr = p_montantIslr;
      ((AttributionPC)getPC()).setMontantIslr(p_montantIslr);
    }
    else if ((m_montantIslr != null) && (p_montantIslr != null) && (!p_montantIslr.equals(m_montantIslr)))
    {
      m_montantIslr = p_montantIslr;
      ((AttributionPC)getPC()).setMontantIslr(p_montantIslr);
    }
  }
  
  protected int rawGetNbJoursDiffere()
  {
    return ((AttributionPC)getPC()).getNbJoursDiffere();
  }
  
  public int getNbJoursDiffere()
  {
    return ((AttributionPC)getPC()).getNbJoursDiffere();
  }
  
  public void setNbJoursDiffere(int p_nbJoursDiffere)
  {
    ((AttributionPC)getPC()).setNbJoursDiffere(p_nbJoursDiffere);
  }
  
  protected String rawGetUniteDureeDiffere()
  {
    return ((AttributionPC)getPC()).getUniteDureeDiffere();
  }
  
  public String getUniteDureeDiffere()
  {
    return ((AttributionPC)getPC()).getUniteDureeDiffere();
  }
  
  public void setUniteDureeDiffere(String p_uniteDureeDiffere)
  {
    if ((m_uniteDureeDiffere == null) || (p_uniteDureeDiffere == null))
    {
      m_uniteDureeDiffere = p_uniteDureeDiffere;
      ((AttributionPC)getPC()).setUniteDureeDiffere(p_uniteDureeDiffere);
    }
    else if ((m_uniteDureeDiffere != null) && (p_uniteDureeDiffere != null) && (!p_uniteDureeDiffere.equals(m_uniteDureeDiffere)))
    {
      m_uniteDureeDiffere = p_uniteDureeDiffere;
      ((AttributionPC)getPC()).setUniteDureeDiffere(p_uniteDureeDiffere);
    }
  }
  
  protected Damj rawGetDateDebutDiffere()
  {
    return ((AttributionPC)getPC()).getDateDebutDiffere();
  }
  
  public Damj getDateDebutDiffere()
  {
    return ((AttributionPC)getPC()).getDateDebutDiffere();
  }
  
  public void setDateDebutDiffere(Damj p_dateDebutDiffere)
  {
    if ((m_dateDebutDiffere == null) || (p_dateDebutDiffere == null))
    {
      m_dateDebutDiffere = p_dateDebutDiffere;
      ((AttributionPC)getPC()).setDateDebutDiffere(p_dateDebutDiffere);
    }
    else if ((m_dateDebutDiffere != null) && (p_dateDebutDiffere != null) && (!p_dateDebutDiffere.equals(m_dateDebutDiffere)))
    {
      m_dateDebutDiffere = p_dateDebutDiffere;
      ((AttributionPC)getPC()).setDateDebutDiffere(p_dateDebutDiffere);
    }
  }
  
  protected Damj rawGetDateFinDiffere()
  {
    return ((AttributionPC)getPC()).getDateFinDiffere();
  }
  
  public Damj getDateFinDiffere()
  {
    return ((AttributionPC)getPC()).getDateFinDiffere();
  }
  
  public void setDateFinDiffere(Damj p_dateFinDiffere)
  {
    if ((m_dateFinDiffere == null) || (p_dateFinDiffere == null))
    {
      m_dateFinDiffere = p_dateFinDiffere;
      ((AttributionPC)getPC()).setDateFinDiffere(p_dateFinDiffere);
    }
    else if ((m_dateFinDiffere != null) && (p_dateFinDiffere != null) && (!p_dateFinDiffere.equals(m_dateFinDiffere)))
    {
      m_dateFinDiffere = p_dateFinDiffere;
      ((AttributionPC)getPC()).setDateFinDiffere(p_dateFinDiffere);
    }
  }
  
  protected BigDecimal rawGetMontantInitialCapitalMax()
  {
    return ((AttributionPC)getPC()).getMontantInitialCapitalMax();
  }
  
  public BigDecimal getMontantInitialCapitalMax()
  {
    return ((AttributionPC)getPC()).getMontantInitialCapitalMax();
  }
  
  public void setMontantInitialCapitalMax(BigDecimal p_montantInitialCapitalMax)
  {
    if ((m_montantInitialCapitalMax == null) || (p_montantInitialCapitalMax == null))
    {
      m_montantInitialCapitalMax = p_montantInitialCapitalMax;
      ((AttributionPC)getPC()).setMontantInitialCapitalMax(p_montantInitialCapitalMax);
    }
    else if ((m_montantInitialCapitalMax != null) && (p_montantInitialCapitalMax != null) && (!p_montantInitialCapitalMax.equals(m_montantInitialCapitalMax)))
    {
      m_montantInitialCapitalMax = p_montantInitialCapitalMax;
      ((AttributionPC)getPC()).setMontantInitialCapitalMax(p_montantInitialCapitalMax);
    }
  }
  
  protected int rawGetFlagReadmission()
  {
    return ((AttributionPC)getPC()).getFlagReadmission();
  }
  
  public int getFlagReadmission()
  {
    return ((AttributionPC)getPC()).getFlagReadmission();
  }
  
  public void setFlagReadmission(int p_flagReadmission)
  {
    ((AttributionPC)getPC()).setFlagReadmission(p_flagReadmission);
  }
  
  protected String rawGetRegimeParticulier()
  {
    return ((AttributionPC)getPC()).getRegimeParticulier();
  }
  
  public String getRegimeParticulier()
  {
    return ((AttributionPC)getPC()).getRegimeParticulier();
  }
  
  public void setRegimeParticulier(String p_regimeParticulier)
  {
    if ((m_regimeParticulier == null) || (p_regimeParticulier == null))
    {
      m_regimeParticulier = p_regimeParticulier;
      ((AttributionPC)getPC()).setRegimeParticulier(p_regimeParticulier);
    }
    else if ((m_regimeParticulier != null) && (p_regimeParticulier != null) && (!p_regimeParticulier.equals(m_regimeParticulier)))
    {
      m_regimeParticulier = p_regimeParticulier;
      ((AttributionPC)getPC()).setRegimeParticulier(p_regimeParticulier);
    }
  }
  
  protected int rawGetNbJoursActiviteCourrierASS()
  {
    return ((AttributionPC)getPC()).getNbJoursActiviteCourrierASS();
  }
  
  public int getNbJoursActiviteCourrierASS()
  {
    return ((AttributionPC)getPC()).getNbJoursActiviteCourrierASS();
  }
  
  public void setNbJoursActiviteCourrierASS(int p_nbJoursActiviteCourrierASS)
  {
    ((AttributionPC)getPC()).setNbJoursActiviteCourrierASS(p_nbJoursActiviteCourrierASS);
  }
  
  protected BigDecimal rawGetMontantCarenceIccp()
  {
    return ((AttributionPC)getPC()).getMontantCarenceIccp();
  }
  
  public BigDecimal getMontantCarenceIccp()
  {
    return ((AttributionPC)getPC()).getMontantCarenceIccp();
  }
  
  public void setMontantCarenceIccp(BigDecimal p_montantCarenceIccp)
  {
    if ((m_montantCarenceIccp == null) || (p_montantCarenceIccp == null))
    {
      m_montantCarenceIccp = p_montantCarenceIccp;
      ((AttributionPC)getPC()).setMontantCarenceIccp(p_montantCarenceIccp);
    }
    else if ((m_montantCarenceIccp != null) && (p_montantCarenceIccp != null) && (!p_montantCarenceIccp.equals(m_montantCarenceIccp)))
    {
      m_montantCarenceIccp = p_montantCarenceIccp;
      ((AttributionPC)getPC()).setMontantCarenceIccp(p_montantCarenceIccp);
    }
  }
  
  protected String rawGetCodeSousProduitCourant()
  {
    return ((AttributionPC)getPC()).getCodeSousProduitCourant();
  }
  
  public String getCodeSousProduitCourant()
  {
    return ((AttributionPC)getPC()).getCodeSousProduitCourant();
  }
  
  public void setCodeSousProduitCourant(String p_codeSousProduitCourant)
  {
    if ((m_codeSousProduitCourant == null) || (p_codeSousProduitCourant == null))
    {
      m_codeSousProduitCourant = p_codeSousProduitCourant;
      ((AttributionPC)getPC()).setCodeSousProduitCourant(p_codeSousProduitCourant);
    }
    else if ((m_codeSousProduitCourant != null) && (p_codeSousProduitCourant != null) && (!p_codeSousProduitCourant.equals(m_codeSousProduitCourant)))
    {
      m_codeSousProduitCourant = p_codeSousProduitCourant;
      ((AttributionPC)getPC()).setCodeSousProduitCourant(p_codeSousProduitCourant);
    }
  }
  
  protected String rawGetCodeSousProduitRetenu()
  {
    return ((AttributionPC)getPC()).getCodeSousProduitRetenu();
  }
  
  public String getCodeSousProduitRetenu()
  {
    return ((AttributionPC)getPC()).getCodeSousProduitRetenu();
  }
  
  public void setCodeSousProduitRetenu(String p_codeSousProduitRetenu)
  {
    if ((m_codeSousProduitRetenu == null) || (p_codeSousProduitRetenu == null))
    {
      m_codeSousProduitRetenu = p_codeSousProduitRetenu;
      ((AttributionPC)getPC()).setCodeSousProduitRetenu(p_codeSousProduitRetenu);
    }
    else if ((m_codeSousProduitRetenu != null) && (p_codeSousProduitRetenu != null) && (!p_codeSousProduitRetenu.equals(m_codeSousProduitRetenu)))
    {
      m_codeSousProduitRetenu = p_codeSousProduitRetenu;
      ((AttributionPC)getPC()).setCodeSousProduitRetenu(p_codeSousProduitRetenu);
    }
  }
  
  protected int rawGetNombreHeureTravailleEtendu()
  {
    return ((AttributionPC)getPC()).getNombreHeureTravailleEtendu();
  }
  
  public int getNombreHeureTravailleEtendu()
  {
    return ((AttributionPC)getPC()).getNombreHeureTravailleEtendu();
  }
  
  public void setNombreHeureTravailleEtendu(int p_nombreHeureTravailleEtendu)
  {
    ((AttributionPC)getPC()).setNombreHeureTravailleEtendu(p_nombreHeureTravailleEtendu);
  }
  
  protected int rawGetRangAllongementPRA()
  {
    return ((AttributionPC)getPC()).getRangAllongementPRA();
  }
  
  public int getRangAllongementPRA()
  {
    return ((AttributionPC)getPC()).getRangAllongementPRA();
  }
  
  public void setRangAllongementPRA(int p_rangAllongementPRA)
  {
    ((AttributionPC)getPC()).setRangAllongementPRA(p_rangAllongementPRA);
  }
  
  protected String rawGetSituationParticuliereDroitCourant()
  {
    return ((AttributionPC)getPC()).getSituationParticuliereDroitCourant();
  }
  
  public String getSituationParticuliereDroitCourant()
  {
    return ((AttributionPC)getPC()).getSituationParticuliereDroitCourant();
  }
  
  public void setSituationParticuliereDroitCourant(String p_situationParticuliereDroitCourant)
  {
    if ((m_situationParticuliereDroitCourant == null) || (p_situationParticuliereDroitCourant == null))
    {
      m_situationParticuliereDroitCourant = p_situationParticuliereDroitCourant;
      ((AttributionPC)getPC()).setSituationParticuliereDroitCourant(p_situationParticuliereDroitCourant);
    }
    else if ((m_situationParticuliereDroitCourant != null) && (p_situationParticuliereDroitCourant != null) && (!p_situationParticuliereDroitCourant.equals(m_situationParticuliereDroitCourant)))
    {
      m_situationParticuliereDroitCourant = p_situationParticuliereDroitCourant;
      ((AttributionPC)getPC()).setSituationParticuliereDroitCourant(p_situationParticuliereDroitCourant);
    }
  }
  
  protected String rawGetSituationParticuliereDroitRetenu()
  {
    return ((AttributionPC)getPC()).getSituationParticuliereDroitRetenu();
  }
  
  public String getSituationParticuliereDroitRetenu()
  {
    return ((AttributionPC)getPC()).getSituationParticuliereDroitRetenu();
  }
  
  public void setSituationParticuliereDroitRetenu(String p_situationParticuliereDroitRetenu)
  {
    if ((m_situationParticuliereDroitRetenu == null) || (p_situationParticuliereDroitRetenu == null))
    {
      m_situationParticuliereDroitRetenu = p_situationParticuliereDroitRetenu;
      ((AttributionPC)getPC()).setSituationParticuliereDroitRetenu(p_situationParticuliereDroitRetenu);
    }
    else if ((m_situationParticuliereDroitRetenu != null) && (p_situationParticuliereDroitRetenu != null) && (!p_situationParticuliereDroitRetenu.equals(m_situationParticuliereDroitRetenu)))
    {
      m_situationParticuliereDroitRetenu = p_situationParticuliereDroitRetenu;
      ((AttributionPC)getPC()).setSituationParticuliereDroitRetenu(p_situationParticuliereDroitRetenu);
    }
  }
  
  protected String rawGetCodeActiviteHorsFrance()
  {
    return ((AttributionPC)getPC()).getCodeActiviteHorsFrance();
  }
  
  public String getCodeActiviteHorsFrance()
  {
    return ((AttributionPC)getPC()).getCodeActiviteHorsFrance();
  }
  
  public void setCodeActiviteHorsFrance(String p_codeActiviteHorsFrance)
  {
    if ((m_codeActiviteHorsFrance == null) || (p_codeActiviteHorsFrance == null))
    {
      m_codeActiviteHorsFrance = p_codeActiviteHorsFrance;
      ((AttributionPC)getPC()).setCodeActiviteHorsFrance(p_codeActiviteHorsFrance);
    }
    else if ((m_codeActiviteHorsFrance != null) && (p_codeActiviteHorsFrance != null) && (!p_codeActiviteHorsFrance.equals(m_codeActiviteHorsFrance)))
    {
      m_codeActiviteHorsFrance = p_codeActiviteHorsFrance;
      ((AttributionPC)getPC()).setCodeActiviteHorsFrance(p_codeActiviteHorsFrance);
    }
  }
  
  protected String rawGetCodePaysActivite()
  {
    return ((AttributionPC)getPC()).getCodePaysActivite();
  }
  
  public String getCodePaysActivite()
  {
    return ((AttributionPC)getPC()).getCodePaysActivite();
  }
  
  public void setCodePaysActivite(String p_codePaysActivite)
  {
    if ((m_codePaysActivite == null) || (p_codePaysActivite == null))
    {
      m_codePaysActivite = p_codePaysActivite;
      ((AttributionPC)getPC()).setCodePaysActivite(p_codePaysActivite);
    }
    else if ((m_codePaysActivite != null) && (p_codePaysActivite != null) && (!p_codePaysActivite.equals(m_codePaysActivite)))
    {
      m_codePaysActivite = p_codePaysActivite;
      ((AttributionPC)getPC()).setCodePaysActivite(p_codePaysActivite);
    }
  }
  
  protected BigDecimal rawGetMontantSalaireReferenceA10FNA()
  {
    return ((AttributionPC)getPC()).getMontantSalaireReferenceA10FNA();
  }
  
  public BigDecimal getMontantSalaireReferenceA10FNA()
  {
    return ((AttributionPC)getPC()).getMontantSalaireReferenceA10FNA();
  }
  
  public void setMontantSalaireReferenceA10FNA(BigDecimal p_montantSalaireReferenceA10FNA)
  {
    if ((m_montantSalaireReferenceA10FNA == null) || (p_montantSalaireReferenceA10FNA == null))
    {
      m_montantSalaireReferenceA10FNA = p_montantSalaireReferenceA10FNA;
      ((AttributionPC)getPC()).setMontantSalaireReferenceA10FNA(p_montantSalaireReferenceA10FNA);
    }
    else if ((m_montantSalaireReferenceA10FNA != null) && (p_montantSalaireReferenceA10FNA != null) && (!p_montantSalaireReferenceA10FNA.equals(m_montantSalaireReferenceA10FNA)))
    {
      m_montantSalaireReferenceA10FNA = p_montantSalaireReferenceA10FNA;
      ((AttributionPC)getPC()).setMontantSalaireReferenceA10FNA(p_montantSalaireReferenceA10FNA);
    }
  }
  
  protected int rawGetRangAttributionAFDFiliereFNA()
  {
    return ((AttributionPC)getPC()).getRangAttributionAFDFiliereFNA();
  }
  
  public int getRangAttributionAFDFiliereFNA()
  {
    return ((AttributionPC)getPC()).getRangAttributionAFDFiliereFNA();
  }
  
  public void setRangAttributionAFDFiliereFNA(int p_rangAttributionAFDFiliereFNA)
  {
    ((AttributionPC)getPC()).setRangAttributionAFDFiliereFNA(p_rangAttributionAFDFiliereFNA);
  }
  
  protected String rawGetTypeFinancement()
  {
    return ((AttributionPC)getPC()).getTypeFinancement();
  }
  
  public String getTypeFinancement()
  {
    return ((AttributionPC)getPC()).getTypeFinancement();
  }
  
  public void setTypeFinancement(String p_typeFinancement)
  {
    if ((m_typeFinancement == null) || (p_typeFinancement == null))
    {
      m_typeFinancement = p_typeFinancement;
      ((AttributionPC)getPC()).setTypeFinancement(p_typeFinancement);
    }
    else if ((m_typeFinancement != null) && (p_typeFinancement != null) && (!p_typeFinancement.equals(m_typeFinancement)))
    {
      m_typeFinancement = p_typeFinancement;
      ((AttributionPC)getPC()).setTypeFinancement(p_typeFinancement);
    }
  }
  
  protected BigDecimal rawGetNbMoisRemboursesCoordEuropeenne()
  {
    return ((AttributionPC)getPC()).getNbMoisRemboursesCoordEuropeenne();
  }
  
  public BigDecimal getNbMoisRemboursesCoordEuropeenne()
  {
    return ((AttributionPC)getPC()).getNbMoisRemboursesCoordEuropeenne();
  }
  
  public void setNbMoisRemboursesCoordEuropeenne(BigDecimal p_nbMoisRemboursesCoordEuropeenne)
  {
    if ((m_nbMoisRemboursesCoordEuropeenne == null) || (p_nbMoisRemboursesCoordEuropeenne == null))
    {
      m_nbMoisRemboursesCoordEuropeenne = p_nbMoisRemboursesCoordEuropeenne;
      ((AttributionPC)getPC()).setNbMoisRemboursesCoordEuropeenne(p_nbMoisRemboursesCoordEuropeenne);
    }
    else if ((m_nbMoisRemboursesCoordEuropeenne != null) && (p_nbMoisRemboursesCoordEuropeenne != null) && (!p_nbMoisRemboursesCoordEuropeenne.equals(m_nbMoisRemboursesCoordEuropeenne)))
    {
      m_nbMoisRemboursesCoordEuropeenne = p_nbMoisRemboursesCoordEuropeenne;
      ((AttributionPC)getPC()).setNbMoisRemboursesCoordEuropeenne(p_nbMoisRemboursesCoordEuropeenne);
    }
  }
  
  protected String rawGetNumeroConvention()
  {
    return ((AttributionPC)getPC()).getNumeroConvention();
  }
  
  public String getNumeroConvention()
  {
    return ((AttributionPC)getPC()).getNumeroConvention();
  }
  
  public void setNumeroConvention(String p_numeroConvention)
  {
    if ((m_numeroConvention == null) || (p_numeroConvention == null))
    {
      m_numeroConvention = p_numeroConvention;
      ((AttributionPC)getPC()).setNumeroConvention(p_numeroConvention);
    }
    else if ((m_numeroConvention != null) && (p_numeroConvention != null) && (!p_numeroConvention.equals(m_numeroConvention)))
    {
      m_numeroConvention = p_numeroConvention;
      ((AttributionPC)getPC()).setNumeroConvention(p_numeroConvention);
    }
  }
  
  protected String rawGetCodeAffectationConvention()
  {
    return ((AttributionPC)getPC()).getCodeAffectationConvention();
  }
  
  public String getCodeAffectationConvention()
  {
    return ((AttributionPC)getPC()).getCodeAffectationConvention();
  }
  
  public void setCodeAffectationConvention(String p_codeAffectationConvention)
  {
    if ((m_codeAffectationConvention == null) || (p_codeAffectationConvention == null))
    {
      m_codeAffectationConvention = p_codeAffectationConvention;
      ((AttributionPC)getPC()).setCodeAffectationConvention(p_codeAffectationConvention);
    }
    else if ((m_codeAffectationConvention != null) && (p_codeAffectationConvention != null) && (!p_codeAffectationConvention.equals(m_codeAffectationConvention)))
    {
      m_codeAffectationConvention = p_codeAffectationConvention;
      ((AttributionPC)getPC()).setCodeAffectationConvention(p_codeAffectationConvention);
    }
  }
  
  protected String rawGetIdExterneEmployeurSp()
  {
    return ((AttributionPC)getPC()).getIdExterneEmployeurSp();
  }
  
  public String getIdExterneEmployeurSp()
  {
    return ((AttributionPC)getPC()).getIdExterneEmployeurSp();
  }
  
  public void setIdExterneEmployeurSp(String p_idExterneEmployeurSp)
  {
    if ((m_idExterneEmployeurSp == null) || (p_idExterneEmployeurSp == null))
    {
      m_idExterneEmployeurSp = p_idExterneEmployeurSp;
      ((AttributionPC)getPC()).setIdExterneEmployeurSp(p_idExterneEmployeurSp);
    }
    else if ((m_idExterneEmployeurSp != null) && (p_idExterneEmployeurSp != null) && (!p_idExterneEmployeurSp.equals(m_idExterneEmployeurSp)))
    {
      m_idExterneEmployeurSp = p_idExterneEmployeurSp;
      ((AttributionPC)getPC()).setIdExterneEmployeurSp(p_idExterneEmployeurSp);
    }
  }
  
  protected String rawGetFctEmployeurCompetent()
  {
    return ((AttributionPC)getPC()).getFctEmployeurCompetent();
  }
  
  public String getFctEmployeurCompetent()
  {
    return ((AttributionPC)getPC()).getFctEmployeurCompetent();
  }
  
  public void setFctEmployeurCompetent(String p_fctEmployeurCompetent)
  {
    if ((m_fctEmployeurCompetent == null) || (p_fctEmployeurCompetent == null))
    {
      m_fctEmployeurCompetent = p_fctEmployeurCompetent;
      ((AttributionPC)getPC()).setFctEmployeurCompetent(p_fctEmployeurCompetent);
    }
    else if ((m_fctEmployeurCompetent != null) && (p_fctEmployeurCompetent != null) && (!p_fctEmployeurCompetent.equals(m_fctEmployeurCompetent)))
    {
      m_fctEmployeurCompetent = p_fctEmployeurCompetent;
      ((AttributionPC)getPC()).setFctEmployeurCompetent(p_fctEmployeurCompetent);
    }
  }
  
  protected Damj rawGetDateLimiteIndemnisation()
  {
    return ((AttributionPC)getPC()).getDateLimiteIndemnisation();
  }
  
  public Damj getDateLimiteIndemnisation()
  {
    return ((AttributionPC)getPC()).getDateLimiteIndemnisation();
  }
  
  public void setDateLimiteIndemnisation(Damj p_dateLimiteIndemnisation)
  {
    if ((m_dateLimiteIndemnisation == null) || (p_dateLimiteIndemnisation == null))
    {
      m_dateLimiteIndemnisation = p_dateLimiteIndemnisation;
      ((AttributionPC)getPC()).setDateLimiteIndemnisation(p_dateLimiteIndemnisation);
    }
    else if ((m_dateLimiteIndemnisation != null) && (p_dateLimiteIndemnisation != null) && (!p_dateLimiteIndemnisation.equals(m_dateLimiteIndemnisation)))
    {
      m_dateLimiteIndemnisation = p_dateLimiteIndemnisation;
      ((AttributionPC)getPC()).setDateLimiteIndemnisation(p_dateLimiteIndemnisation);
    }
  }
  
  protected String rawGetAuMoinsUneActiviteConservee()
  {
    return ((AttributionPC)getPC()).getAuMoinsUneActiviteConservee();
  }
  
  public String getAuMoinsUneActiviteConservee()
  {
    return ((AttributionPC)getPC()).getAuMoinsUneActiviteConservee();
  }
  
  public void setAuMoinsUneActiviteConservee(String p_auMoinsUneActiviteConservee)
  {
    if ((m_auMoinsUneActiviteConservee == null) || (p_auMoinsUneActiviteConservee == null))
    {
      m_auMoinsUneActiviteConservee = p_auMoinsUneActiviteConservee;
      ((AttributionPC)getPC()).setAuMoinsUneActiviteConservee(p_auMoinsUneActiviteConservee);
    }
    else if ((m_auMoinsUneActiviteConservee != null) && (p_auMoinsUneActiviteConservee != null) && (!p_auMoinsUneActiviteConservee.equals(m_auMoinsUneActiviteConservee)))
    {
      m_auMoinsUneActiviteConservee = p_auMoinsUneActiviteConservee;
      ((AttributionPC)getPC()).setAuMoinsUneActiviteConservee(p_auMoinsUneActiviteConservee);
    }
  }
  
  protected String rawGetEstDroitOption()
  {
    return ((AttributionPC)getPC()).getEstDroitOption();
  }
  
  public String getEstDroitOption()
  {
    return ((AttributionPC)getPC()).getEstDroitOption();
  }
  
  public void setEstDroitOption(String p_estDroitOption)
  {
    if ((m_estDroitOption == null) || (p_estDroitOption == null))
    {
      m_estDroitOption = p_estDroitOption;
      ((AttributionPC)getPC()).setEstDroitOption(p_estDroitOption);
    }
    else if ((m_estDroitOption != null) && (p_estDroitOption != null) && (!p_estDroitOption.equals(m_estDroitOption)))
    {
      m_estDroitOption = p_estDroitOption;
      ((AttributionPC)getPC()).setEstDroitOption(p_estDroitOption);
    }
  }
  
  protected String rawGetEstDroitApprenti()
  {
    return ((AttributionPC)getPC()).getEstDroitApprenti();
  }
  
  public String getEstDroitApprenti()
  {
    return ((AttributionPC)getPC()).getEstDroitApprenti();
  }
  
  public void setEstDroitApprenti(String p_estDroitApprenti)
  {
    if ((m_estDroitApprenti == null) || (p_estDroitApprenti == null))
    {
      m_estDroitApprenti = p_estDroitApprenti;
      ((AttributionPC)getPC()).setEstDroitApprenti(p_estDroitApprenti);
    }
    else if ((m_estDroitApprenti != null) && (p_estDroitApprenti != null) && (!p_estDroitApprenti.equals(m_estDroitApprenti)))
    {
      m_estDroitApprenti = p_estDroitApprenti;
      ((AttributionPC)getPC()).setEstDroitApprenti(p_estDroitApprenti);
    }
  }
  
  protected BigDecimal rawGetNbJourEcretementPlafDuree()
  {
    return ((AttributionPC)getPC()).getNbJourEcretementPlafDuree();
  }
  
  public BigDecimal getNbJourEcretementPlafDuree()
  {
    return ((AttributionPC)getPC()).getNbJourEcretementPlafDuree();
  }
  
  public void setNbJourEcretementPlafDuree(BigDecimal p_nbJourEcretementPlafDuree)
  {
    if ((m_nbJourEcretementPlafDuree == null) || (p_nbJourEcretementPlafDuree == null))
    {
      m_nbJourEcretementPlafDuree = p_nbJourEcretementPlafDuree;
      ((AttributionPC)getPC()).setNbJourEcretementPlafDuree(p_nbJourEcretementPlafDuree);
    }
    else if ((m_nbJourEcretementPlafDuree != null) && (p_nbJourEcretementPlafDuree != null) && (!p_nbJourEcretementPlafDuree.equals(m_nbJourEcretementPlafDuree)))
    {
      m_nbJourEcretementPlafDuree = p_nbJourEcretementPlafDuree;
      ((AttributionPC)getPC()).setNbJourEcretementPlafDuree(p_nbJourEcretementPlafDuree);
    }
  }
  
  protected int rawGetDeltaDiffereSpectacle()
  {
    return ((AttributionPC)getPC()).getDeltaDiffereSpectacle();
  }
  
  public int getDeltaDiffereSpectacle()
  {
    return ((AttributionPC)getPC()).getDeltaDiffereSpectacle();
  }
  
  public void setDeltaDiffereSpectacle(int p_deltaDiffereSpectacle)
  {
    ((AttributionPC)getPC()).setDeltaDiffereSpectacle(p_deltaDiffereSpectacle);
  }
  
  protected BigDecimal rawGetMontantAllocationJournaliereBrut()
  {
    return ((AttributionPC)getPC()).getMontantAllocationJournaliereBrut();
  }
  
  public BigDecimal getMontantAllocationJournaliereBrut()
  {
    return ((AttributionPC)getPC()).getMontantAllocationJournaliereBrut();
  }
  
  public void setMontantAllocationJournaliereBrut(BigDecimal p_montantAllocationJournaliereBrut)
  {
    if ((m_montantAllocationJournaliereBrut == null) || (p_montantAllocationJournaliereBrut == null))
    {
      m_montantAllocationJournaliereBrut = p_montantAllocationJournaliereBrut;
      ((AttributionPC)getPC()).setMontantAllocationJournaliereBrut(p_montantAllocationJournaliereBrut);
    }
    else if ((m_montantAllocationJournaliereBrut != null) && (p_montantAllocationJournaliereBrut != null) && (!p_montantAllocationJournaliereBrut.equals(m_montantAllocationJournaliereBrut)))
    {
      m_montantAllocationJournaliereBrut = p_montantAllocationJournaliereBrut;
      ((AttributionPC)getPC()).setMontantAllocationJournaliereBrut(p_montantAllocationJournaliereBrut);
    }
  }
  
  protected String rawGetEstDroitInterimaire()
  {
    return ((AttributionPC)getPC()).getEstDroitInterimaire();
  }
  
  public String getEstDroitInterimaire()
  {
    return ((AttributionPC)getPC()).getEstDroitInterimaire();
  }
  
  public void setEstDroitInterimaire(String p_estDroitInterimaire)
  {
    if ((m_estDroitInterimaire == null) || (p_estDroitInterimaire == null))
    {
      m_estDroitInterimaire = p_estDroitInterimaire;
      ((AttributionPC)getPC()).setEstDroitInterimaire(p_estDroitInterimaire);
    }
    else if ((m_estDroitInterimaire != null) && (p_estDroitInterimaire != null) && (!p_estDroitInterimaire.equals(m_estDroitInterimaire)))
    {
      m_estDroitInterimaire = p_estDroitInterimaire;
      ((AttributionPC)getPC()).setEstDroitInterimaire(p_estDroitInterimaire);
    }
  }
  
  private final Collection getCollectionModifiablePeriodeAffiliation()
  {
    Iterator itCollectionPC;
    if (m_collectionPeriodeAffiliation == null)
    {
      m_collectionPeriodeAffiliation = new ArrayList();
      for (itCollectionPC = ((AttributionPC)getPC()).getCollectionPeriodeAffiliation().iterator(); itCollectionPC.hasNext();)
      {
        DomPCSpec currentPC = (DomPCSpec)itCollectionPC.next();
        Object currentOM = currentPC.createOM();
        m_collectionPeriodeAffiliation.add(currentOM);
      }
    }
    return m_collectionPeriodeAffiliation;
  }
  
  public Collection getCollectionPeriodeAffiliation()
  {
    return Collections.unmodifiableCollection(getCollectionModifiablePeriodeAffiliation());
  }
  
  public List getListPeriodeAffiliation()
  {
    return Collections.unmodifiableList((List)getCollectionModifiablePeriodeAffiliation());
  }
  
  public void remplacerCollectionPeriodeAffiliation(Collection p_collectionACopier)
  {
    clearCollectionPeriodeAffiliation();
    for (Iterator i = p_collectionACopier.iterator(); i.hasNext();)
    {
      PeriodeAffiliation objet = (PeriodeAffiliation)i.next();
      ajouterPeriodeAffiliation(objet);
    }
  }
  
  public void supprimerSousCollectionPeriodeAffiliation(Collection p_collectionASupprimer)
  {
    for (Iterator i = p_collectionASupprimer.iterator(); i.hasNext();)
    {
      PeriodeAffiliation objet = (PeriodeAffiliation)i.next();
      supprimerPeriodeAffiliation(objet);
    }
  }
  
  public void ajouterPeriodeAffiliation(PeriodeAffiliation p_periodeAffiliation)
    throws NullPointerException
  {
    if (p_periodeAffiliation == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periodeAffiliation ne devrait pas être nul.", p_periodeAffiliation);
    }
    getCollectionModifiablePeriodeAffiliation().add(p_periodeAffiliation);
    ((AttributionPC)getPC()).ajouterPeriodeAffiliation(p_periodeAffiliation.getPC());
  }
  
  public void supprimerPeriodeAffiliation(PeriodeAffiliation p_periodeAffiliation)
    throws NullPointerException
  {
    if (p_periodeAffiliation == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periodeAffiliation ne devrait pas être nul.", p_periodeAffiliation);
    }
    getCollectionModifiablePeriodeAffiliation().remove(p_periodeAffiliation);
    ((AttributionPC)getPC()).supprimerPeriodeAffiliation(p_periodeAffiliation.getPC());
  }
  
  public void recopierCollectionPeriodeAffiliationVers(ObjetMetierSpec p_copie)
  {
    AttributionGen copie = (AttributionGen)p_copie;
    Collection listeACopier = getCollectionPeriodeAffiliation();
    for (Iterator i = listeACopier.iterator(); i.hasNext();)
    {
      ObjetMetierSpec objet = ((ObjetMetierSpec)i.next()).copie();
      copie.ajouterPeriodeAffiliation((PeriodeAffiliation)objet);
    }
  }
  
  public void clearCollectionPeriodeAffiliation()
  {
    getCollectionModifiablePeriodeAffiliation().clear();
    ((AttributionPC)getPC()).getCollectionPeriodeAffiliation().clear();
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    for (Iterator iter = getCollectionPeriodeAffiliation().iterator(); iter.hasNext();)
    {
      DomGenSpec item = (DomGenSpec)iter.next();
      if ((item != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(item))) {
        DomManager.supprimer(item, p_contexteSuppression);
      }
    }
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     AttributionGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */