package fr.unedic.cali.dom.pivot.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.dom.pivot.Derogation;
import fr.unedic.cali.dom.pivot.PeriodeLieu;
import fr.unedic.cali.dom.pivot.pc.AidesPC;
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

public abstract class AidesGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_aidesPC;
  private BigDecimal m_montantTotalPaye;
  private String m_etat;
  private Damj m_dateValidationANPE;
  private Damj m_dateValidationAssedic;
  private BigDecimal m_montantTotalEngageFraisP;
  private BigDecimal m_montantFraisRestantStagiaireFraisP;
  private BigDecimal m_montantCoutStageFraisP;
  private String m_beneficiaireAideFraisP;
  private BigDecimal m_montantFraisRestantStagiaireNonPlafonneFraisP;
  private BigDecimal m_montantTotalEngageFraisT;
  private BigDecimal m_montantTotalEngageFraisH;
  private BigDecimal m_montantTotalEngageFraisR;
  private String m_identifiantConvention;
  private String m_etatDemande;
  private String m_typeActionReclassement;
  private BigDecimal m_montantAideDerogatoire;
  private BigDecimal m_montantBonTransport;
  private Damj m_dateLimiteIndemnisation;
  private BigDecimal m_plafondDerogatoireAvantAide;
  private BigDecimal m_plafondAvantAide;
  private String m_situationMobilite;
  private Damj m_dateDebutActionReclassement;
  private String m_typeDerogation;
  private Damj m_dateFinActionReclassement;
  private String m_codeProduit;
  private String m_referenceExterne;
  private String m_libelleDerogatoire;
  private String m_numeroBon;
  private String m_clefControleBon;
  private String m_montantBonEnLettres;
  private String m_typeBon;
  private Integer m_origineDemande;
  private String m_typeDemandeWeb;
  private String m_gareAllerDepart;
  private String m_gareAllerArrivee;
  private Collection m_collectionPeriodeLieu;
  private Collection m_collectionDerogation;
  
  public AidesGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public AidesGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new AidesPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_aidesPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_aidesPC)
  {
    m_aidesPC = p_aidesPC;
  }
  
  protected int rawGetRangAide()
  {
    return ((AidesPC)getPC()).getRangAide();
  }
  
  public int getRangAide()
  {
    return ((AidesPC)getPC()).getRangAide();
  }
  
  public void setRangAide(int p_rangAide)
  {
    ((AidesPC)getPC()).setRangAide(p_rangAide);
  }
  
  protected int rawGetTypeAide()
  {
    return ((AidesPC)getPC()).getTypeAide();
  }
  
  public int getTypeAide()
  {
    return ((AidesPC)getPC()).getTypeAide();
  }
  
  public void setTypeAide(int p_typeAide)
  {
    ((AidesPC)getPC()).setTypeAide(p_typeAide);
  }
  
  protected BigDecimal rawGetMontantTotalPaye()
  {
    return ((AidesPC)getPC()).getMontantTotalPaye();
  }
  
  public BigDecimal getMontantTotalPaye()
  {
    return ((AidesPC)getPC()).getMontantTotalPaye();
  }
  
  public void setMontantTotalPaye(BigDecimal p_montantTotalPaye)
  {
    if ((m_montantTotalPaye == null) || (p_montantTotalPaye == null))
    {
      m_montantTotalPaye = p_montantTotalPaye;
      ((AidesPC)getPC()).setMontantTotalPaye(p_montantTotalPaye);
    }
    else if ((m_montantTotalPaye != null) && (p_montantTotalPaye != null) && (!p_montantTotalPaye.equals(m_montantTotalPaye)))
    {
      m_montantTotalPaye = p_montantTotalPaye;
      ((AidesPC)getPC()).setMontantTotalPaye(p_montantTotalPaye);
    }
  }
  
  protected String rawGetEtat()
  {
    return ((AidesPC)getPC()).getEtat();
  }
  
  public String getEtat()
  {
    return ((AidesPC)getPC()).getEtat();
  }
  
  public void setEtat(String p_etat)
  {
    if ((m_etat == null) || (p_etat == null))
    {
      m_etat = p_etat;
      ((AidesPC)getPC()).setEtat(p_etat);
    }
    else if ((m_etat != null) && (p_etat != null) && (!p_etat.equals(m_etat)))
    {
      m_etat = p_etat;
      ((AidesPC)getPC()).setEtat(p_etat);
    }
  }
  
  protected Damj rawGetDateValidationANPE()
  {
    return ((AidesPC)getPC()).getDateValidationANPE();
  }
  
  public Damj getDateValidationANPE()
  {
    return ((AidesPC)getPC()).getDateValidationANPE();
  }
  
  public void setDateValidationANPE(Damj p_dateValidationANPE)
  {
    if ((m_dateValidationANPE == null) || (p_dateValidationANPE == null))
    {
      m_dateValidationANPE = p_dateValidationANPE;
      ((AidesPC)getPC()).setDateValidationANPE(p_dateValidationANPE);
    }
    else if ((m_dateValidationANPE != null) && (p_dateValidationANPE != null) && (!p_dateValidationANPE.equals(m_dateValidationANPE)))
    {
      m_dateValidationANPE = p_dateValidationANPE;
      ((AidesPC)getPC()).setDateValidationANPE(p_dateValidationANPE);
    }
  }
  
  protected Damj rawGetDateValidationAssedic()
  {
    return ((AidesPC)getPC()).getDateValidationAssedic();
  }
  
  public Damj getDateValidationAssedic()
  {
    return ((AidesPC)getPC()).getDateValidationAssedic();
  }
  
  public void setDateValidationAssedic(Damj p_dateValidationAssedic)
  {
    if ((m_dateValidationAssedic == null) || (p_dateValidationAssedic == null))
    {
      m_dateValidationAssedic = p_dateValidationAssedic;
      ((AidesPC)getPC()).setDateValidationAssedic(p_dateValidationAssedic);
    }
    else if ((m_dateValidationAssedic != null) && (p_dateValidationAssedic != null) && (!p_dateValidationAssedic.equals(m_dateValidationAssedic)))
    {
      m_dateValidationAssedic = p_dateValidationAssedic;
      ((AidesPC)getPC()).setDateValidationAssedic(p_dateValidationAssedic);
    }
  }
  
  protected int rawGetAnneeAffectation()
  {
    return ((AidesPC)getPC()).getAnneeAffectation();
  }
  
  public int getAnneeAffectation()
  {
    return ((AidesPC)getPC()).getAnneeAffectation();
  }
  
  public void setAnneeAffectation(int p_anneeAffectation)
  {
    ((AidesPC)getPC()).setAnneeAffectation(p_anneeAffectation);
  }
  
  protected BigDecimal rawGetMontantTotalEngageFraisP()
  {
    return ((AidesPC)getPC()).getMontantTotalEngageFraisP();
  }
  
  public BigDecimal getMontantTotalEngageFraisP()
  {
    return ((AidesPC)getPC()).getMontantTotalEngageFraisP();
  }
  
  public void setMontantTotalEngageFraisP(BigDecimal p_montantTotalEngageFraisP)
  {
    if ((m_montantTotalEngageFraisP == null) || (p_montantTotalEngageFraisP == null))
    {
      m_montantTotalEngageFraisP = p_montantTotalEngageFraisP;
      ((AidesPC)getPC()).setMontantTotalEngageFraisP(p_montantTotalEngageFraisP);
    }
    else if ((m_montantTotalEngageFraisP != null) && (p_montantTotalEngageFraisP != null) && (!p_montantTotalEngageFraisP.equals(m_montantTotalEngageFraisP)))
    {
      m_montantTotalEngageFraisP = p_montantTotalEngageFraisP;
      ((AidesPC)getPC()).setMontantTotalEngageFraisP(p_montantTotalEngageFraisP);
    }
  }
  
  protected BigDecimal rawGetMontantFraisRestantStagiaireFraisP()
  {
    return ((AidesPC)getPC()).getMontantFraisRestantStagiaireFraisP();
  }
  
  public BigDecimal getMontantFraisRestantStagiaireFraisP()
  {
    return ((AidesPC)getPC()).getMontantFraisRestantStagiaireFraisP();
  }
  
  public void setMontantFraisRestantStagiaireFraisP(BigDecimal p_montantFraisRestantStagiaireFraisP)
  {
    if ((m_montantFraisRestantStagiaireFraisP == null) || (p_montantFraisRestantStagiaireFraisP == null))
    {
      m_montantFraisRestantStagiaireFraisP = p_montantFraisRestantStagiaireFraisP;
      ((AidesPC)getPC()).setMontantFraisRestantStagiaireFraisP(p_montantFraisRestantStagiaireFraisP);
    }
    else if ((m_montantFraisRestantStagiaireFraisP != null) && (p_montantFraisRestantStagiaireFraisP != null) && (!p_montantFraisRestantStagiaireFraisP.equals(m_montantFraisRestantStagiaireFraisP)))
    {
      m_montantFraisRestantStagiaireFraisP = p_montantFraisRestantStagiaireFraisP;
      ((AidesPC)getPC()).setMontantFraisRestantStagiaireFraisP(p_montantFraisRestantStagiaireFraisP);
    }
  }
  
  protected BigDecimal rawGetMontantCoutStageFraisP()
  {
    return ((AidesPC)getPC()).getMontantCoutStageFraisP();
  }
  
  public BigDecimal getMontantCoutStageFraisP()
  {
    return ((AidesPC)getPC()).getMontantCoutStageFraisP();
  }
  
  public void setMontantCoutStageFraisP(BigDecimal p_montantCoutStageFraisP)
  {
    if ((m_montantCoutStageFraisP == null) || (p_montantCoutStageFraisP == null))
    {
      m_montantCoutStageFraisP = p_montantCoutStageFraisP;
      ((AidesPC)getPC()).setMontantCoutStageFraisP(p_montantCoutStageFraisP);
    }
    else if ((m_montantCoutStageFraisP != null) && (p_montantCoutStageFraisP != null) && (!p_montantCoutStageFraisP.equals(m_montantCoutStageFraisP)))
    {
      m_montantCoutStageFraisP = p_montantCoutStageFraisP;
      ((AidesPC)getPC()).setMontantCoutStageFraisP(p_montantCoutStageFraisP);
    }
  }
  
  protected String rawGetBeneficiaireAideFraisP()
  {
    return ((AidesPC)getPC()).getBeneficiaireAideFraisP();
  }
  
  public String getBeneficiaireAideFraisP()
  {
    return ((AidesPC)getPC()).getBeneficiaireAideFraisP();
  }
  
  public void setBeneficiaireAideFraisP(String p_beneficiaireAideFraisP)
  {
    if ((m_beneficiaireAideFraisP == null) || (p_beneficiaireAideFraisP == null))
    {
      m_beneficiaireAideFraisP = p_beneficiaireAideFraisP;
      ((AidesPC)getPC()).setBeneficiaireAideFraisP(p_beneficiaireAideFraisP);
    }
    else if ((m_beneficiaireAideFraisP != null) && (p_beneficiaireAideFraisP != null) && (!p_beneficiaireAideFraisP.equals(m_beneficiaireAideFraisP)))
    {
      m_beneficiaireAideFraisP = p_beneficiaireAideFraisP;
      ((AidesPC)getPC()).setBeneficiaireAideFraisP(p_beneficiaireAideFraisP);
    }
  }
  
  protected BigDecimal rawGetMontantFraisRestantStagiaireNonPlafonneFraisP()
  {
    return ((AidesPC)getPC()).getMontantFraisRestantStagiaireNonPlafonneFraisP();
  }
  
  public BigDecimal getMontantFraisRestantStagiaireNonPlafonneFraisP()
  {
    return ((AidesPC)getPC()).getMontantFraisRestantStagiaireNonPlafonneFraisP();
  }
  
  public void setMontantFraisRestantStagiaireNonPlafonneFraisP(BigDecimal p_montantFraisRestantStagiaireNonPlafonneFraisP)
  {
    if ((m_montantFraisRestantStagiaireNonPlafonneFraisP == null) || (p_montantFraisRestantStagiaireNonPlafonneFraisP == null))
    {
      m_montantFraisRestantStagiaireNonPlafonneFraisP = p_montantFraisRestantStagiaireNonPlafonneFraisP;
      ((AidesPC)getPC()).setMontantFraisRestantStagiaireNonPlafonneFraisP(p_montantFraisRestantStagiaireNonPlafonneFraisP);
    }
    else if ((m_montantFraisRestantStagiaireNonPlafonneFraisP != null) && (p_montantFraisRestantStagiaireNonPlafonneFraisP != null) && (!p_montantFraisRestantStagiaireNonPlafonneFraisP.equals(m_montantFraisRestantStagiaireNonPlafonneFraisP)))
    {
      m_montantFraisRestantStagiaireNonPlafonneFraisP = p_montantFraisRestantStagiaireNonPlafonneFraisP;
      ((AidesPC)getPC()).setMontantFraisRestantStagiaireNonPlafonneFraisP(p_montantFraisRestantStagiaireNonPlafonneFraisP);
    }
  }
  
  protected BigDecimal rawGetMontantTotalEngageFraisT()
  {
    return ((AidesPC)getPC()).getMontantTotalEngageFraisT();
  }
  
  public BigDecimal getMontantTotalEngageFraisT()
  {
    return ((AidesPC)getPC()).getMontantTotalEngageFraisT();
  }
  
  public void setMontantTotalEngageFraisT(BigDecimal p_montantTotalEngageFraisT)
  {
    if ((m_montantTotalEngageFraisT == null) || (p_montantTotalEngageFraisT == null))
    {
      m_montantTotalEngageFraisT = p_montantTotalEngageFraisT;
      ((AidesPC)getPC()).setMontantTotalEngageFraisT(p_montantTotalEngageFraisT);
    }
    else if ((m_montantTotalEngageFraisT != null) && (p_montantTotalEngageFraisT != null) && (!p_montantTotalEngageFraisT.equals(m_montantTotalEngageFraisT)))
    {
      m_montantTotalEngageFraisT = p_montantTotalEngageFraisT;
      ((AidesPC)getPC()).setMontantTotalEngageFraisT(p_montantTotalEngageFraisT);
    }
  }
  
  protected BigDecimal rawGetMontantTotalEngageFraisH()
  {
    return ((AidesPC)getPC()).getMontantTotalEngageFraisH();
  }
  
  public BigDecimal getMontantTotalEngageFraisH()
  {
    return ((AidesPC)getPC()).getMontantTotalEngageFraisH();
  }
  
  public void setMontantTotalEngageFraisH(BigDecimal p_montantTotalEngageFraisH)
  {
    if ((m_montantTotalEngageFraisH == null) || (p_montantTotalEngageFraisH == null))
    {
      m_montantTotalEngageFraisH = p_montantTotalEngageFraisH;
      ((AidesPC)getPC()).setMontantTotalEngageFraisH(p_montantTotalEngageFraisH);
    }
    else if ((m_montantTotalEngageFraisH != null) && (p_montantTotalEngageFraisH != null) && (!p_montantTotalEngageFraisH.equals(m_montantTotalEngageFraisH)))
    {
      m_montantTotalEngageFraisH = p_montantTotalEngageFraisH;
      ((AidesPC)getPC()).setMontantTotalEngageFraisH(p_montantTotalEngageFraisH);
    }
  }
  
  protected BigDecimal rawGetMontantTotalEngageFraisR()
  {
    return ((AidesPC)getPC()).getMontantTotalEngageFraisR();
  }
  
  public BigDecimal getMontantTotalEngageFraisR()
  {
    return ((AidesPC)getPC()).getMontantTotalEngageFraisR();
  }
  
  public void setMontantTotalEngageFraisR(BigDecimal p_montantTotalEngageFraisR)
  {
    if ((m_montantTotalEngageFraisR == null) || (p_montantTotalEngageFraisR == null))
    {
      m_montantTotalEngageFraisR = p_montantTotalEngageFraisR;
      ((AidesPC)getPC()).setMontantTotalEngageFraisR(p_montantTotalEngageFraisR);
    }
    else if ((m_montantTotalEngageFraisR != null) && (p_montantTotalEngageFraisR != null) && (!p_montantTotalEngageFraisR.equals(m_montantTotalEngageFraisR)))
    {
      m_montantTotalEngageFraisR = p_montantTotalEngageFraisR;
      ((AidesPC)getPC()).setMontantTotalEngageFraisR(p_montantTotalEngageFraisR);
    }
  }
  
  protected int rawGetIdentifiantActionFormation()
  {
    return ((AidesPC)getPC()).getIdentifiantActionFormation();
  }
  
  public int getIdentifiantActionFormation()
  {
    return ((AidesPC)getPC()).getIdentifiantActionFormation();
  }
  
  public void setIdentifiantActionFormation(int p_identifiantActionFormation)
  {
    ((AidesPC)getPC()).setIdentifiantActionFormation(p_identifiantActionFormation);
  }
  
  protected String rawGetIdentifiantConvention()
  {
    return ((AidesPC)getPC()).getIdentifiantConvention();
  }
  
  public String getIdentifiantConvention()
  {
    return ((AidesPC)getPC()).getIdentifiantConvention();
  }
  
  public void setIdentifiantConvention(String p_identifiantConvention)
  {
    if ((m_identifiantConvention == null) || (p_identifiantConvention == null))
    {
      m_identifiantConvention = p_identifiantConvention;
      ((AidesPC)getPC()).setIdentifiantConvention(p_identifiantConvention);
    }
    else if ((m_identifiantConvention != null) && (p_identifiantConvention != null) && (!p_identifiantConvention.equals(m_identifiantConvention)))
    {
      m_identifiantConvention = p_identifiantConvention;
      ((AidesPC)getPC()).setIdentifiantConvention(p_identifiantConvention);
    }
  }
  
  protected String rawGetEtatDemande()
  {
    return ((AidesPC)getPC()).getEtatDemande();
  }
  
  public String getEtatDemande()
  {
    return ((AidesPC)getPC()).getEtatDemande();
  }
  
  public void setEtatDemande(String p_etatDemande)
  {
    if ((m_etatDemande == null) || (p_etatDemande == null))
    {
      m_etatDemande = p_etatDemande;
      ((AidesPC)getPC()).setEtatDemande(p_etatDemande);
    }
    else if ((m_etatDemande != null) && (p_etatDemande != null) && (!p_etatDemande.equals(m_etatDemande)))
    {
      m_etatDemande = p_etatDemande;
      ((AidesPC)getPC()).setEtatDemande(p_etatDemande);
    }
  }
  
  protected String rawGetTypeActionReclassement()
  {
    return ((AidesPC)getPC()).getTypeActionReclassement();
  }
  
  public String getTypeActionReclassement()
  {
    return ((AidesPC)getPC()).getTypeActionReclassement();
  }
  
  public void setTypeActionReclassement(String p_typeActionReclassement)
  {
    if ((m_typeActionReclassement == null) || (p_typeActionReclassement == null))
    {
      m_typeActionReclassement = p_typeActionReclassement;
      ((AidesPC)getPC()).setTypeActionReclassement(p_typeActionReclassement);
    }
    else if ((m_typeActionReclassement != null) && (p_typeActionReclassement != null) && (!p_typeActionReclassement.equals(m_typeActionReclassement)))
    {
      m_typeActionReclassement = p_typeActionReclassement;
      ((AidesPC)getPC()).setTypeActionReclassement(p_typeActionReclassement);
    }
  }
  
  protected BigDecimal rawGetMontantAideDerogatoire()
  {
    return ((AidesPC)getPC()).getMontantAideDerogatoire();
  }
  
  public BigDecimal getMontantAideDerogatoire()
  {
    return ((AidesPC)getPC()).getMontantAideDerogatoire();
  }
  
  public void setMontantAideDerogatoire(BigDecimal p_montantAideDerogatoire)
  {
    if ((m_montantAideDerogatoire == null) || (p_montantAideDerogatoire == null))
    {
      m_montantAideDerogatoire = p_montantAideDerogatoire;
      ((AidesPC)getPC()).setMontantAideDerogatoire(p_montantAideDerogatoire);
    }
    else if ((m_montantAideDerogatoire != null) && (p_montantAideDerogatoire != null) && (!p_montantAideDerogatoire.equals(m_montantAideDerogatoire)))
    {
      m_montantAideDerogatoire = p_montantAideDerogatoire;
      ((AidesPC)getPC()).setMontantAideDerogatoire(p_montantAideDerogatoire);
    }
  }
  
  protected BigDecimal rawGetMontantBonTransport()
  {
    return ((AidesPC)getPC()).getMontantBonTransport();
  }
  
  public BigDecimal getMontantBonTransport()
  {
    return ((AidesPC)getPC()).getMontantBonTransport();
  }
  
  public void setMontantBonTransport(BigDecimal p_montantBonTransport)
  {
    if ((m_montantBonTransport == null) || (p_montantBonTransport == null))
    {
      m_montantBonTransport = p_montantBonTransport;
      ((AidesPC)getPC()).setMontantBonTransport(p_montantBonTransport);
    }
    else if ((m_montantBonTransport != null) && (p_montantBonTransport != null) && (!p_montantBonTransport.equals(m_montantBonTransport)))
    {
      m_montantBonTransport = p_montantBonTransport;
      ((AidesPC)getPC()).setMontantBonTransport(p_montantBonTransport);
    }
  }
  
  protected Damj rawGetDateLimiteIndemnisation()
  {
    return ((AidesPC)getPC()).getDateLimiteIndemnisation();
  }
  
  public Damj getDateLimiteIndemnisation()
  {
    return ((AidesPC)getPC()).getDateLimiteIndemnisation();
  }
  
  public void setDateLimiteIndemnisation(Damj p_dateLimiteIndemnisation)
  {
    if ((m_dateLimiteIndemnisation == null) || (p_dateLimiteIndemnisation == null))
    {
      m_dateLimiteIndemnisation = p_dateLimiteIndemnisation;
      ((AidesPC)getPC()).setDateLimiteIndemnisation(p_dateLimiteIndemnisation);
    }
    else if ((m_dateLimiteIndemnisation != null) && (p_dateLimiteIndemnisation != null) && (!p_dateLimiteIndemnisation.equals(m_dateLimiteIndemnisation)))
    {
      m_dateLimiteIndemnisation = p_dateLimiteIndemnisation;
      ((AidesPC)getPC()).setDateLimiteIndemnisation(p_dateLimiteIndemnisation);
    }
  }
  
  protected BigDecimal rawGetPlafondDerogatoireAvantAide()
  {
    return ((AidesPC)getPC()).getPlafondDerogatoireAvantAide();
  }
  
  public BigDecimal getPlafondDerogatoireAvantAide()
  {
    return ((AidesPC)getPC()).getPlafondDerogatoireAvantAide();
  }
  
  public void setPlafondDerogatoireAvantAide(BigDecimal p_plafondDerogatoireAvantAide)
  {
    if ((m_plafondDerogatoireAvantAide == null) || (p_plafondDerogatoireAvantAide == null))
    {
      m_plafondDerogatoireAvantAide = p_plafondDerogatoireAvantAide;
      ((AidesPC)getPC()).setPlafondDerogatoireAvantAide(p_plafondDerogatoireAvantAide);
    }
    else if ((m_plafondDerogatoireAvantAide != null) && (p_plafondDerogatoireAvantAide != null) && (!p_plafondDerogatoireAvantAide.equals(m_plafondDerogatoireAvantAide)))
    {
      m_plafondDerogatoireAvantAide = p_plafondDerogatoireAvantAide;
      ((AidesPC)getPC()).setPlafondDerogatoireAvantAide(p_plafondDerogatoireAvantAide);
    }
  }
  
  protected BigDecimal rawGetPlafondAvantAide()
  {
    return ((AidesPC)getPC()).getPlafondAvantAide();
  }
  
  public BigDecimal getPlafondAvantAide()
  {
    return ((AidesPC)getPC()).getPlafondAvantAide();
  }
  
  public void setPlafondAvantAide(BigDecimal p_plafondAvantAide)
  {
    if ((m_plafondAvantAide == null) || (p_plafondAvantAide == null))
    {
      m_plafondAvantAide = p_plafondAvantAide;
      ((AidesPC)getPC()).setPlafondAvantAide(p_plafondAvantAide);
    }
    else if ((m_plafondAvantAide != null) && (p_plafondAvantAide != null) && (!p_plafondAvantAide.equals(m_plafondAvantAide)))
    {
      m_plafondAvantAide = p_plafondAvantAide;
      ((AidesPC)getPC()).setPlafondAvantAide(p_plafondAvantAide);
    }
  }
  
  protected int rawGetMotifEchec()
  {
    return ((AidesPC)getPC()).getMotifEchec();
  }
  
  public int getMotifEchec()
  {
    return ((AidesPC)getPC()).getMotifEchec();
  }
  
  public void setMotifEchec(int p_motifEchec)
  {
    ((AidesPC)getPC()).setMotifEchec(p_motifEchec);
  }
  
  protected String rawGetSituationMobilite()
  {
    return ((AidesPC)getPC()).getSituationMobilite();
  }
  
  public String getSituationMobilite()
  {
    return ((AidesPC)getPC()).getSituationMobilite();
  }
  
  public void setSituationMobilite(String p_situationMobilite)
  {
    if ((m_situationMobilite == null) || (p_situationMobilite == null))
    {
      m_situationMobilite = p_situationMobilite;
      ((AidesPC)getPC()).setSituationMobilite(p_situationMobilite);
    }
    else if ((m_situationMobilite != null) && (p_situationMobilite != null) && (!p_situationMobilite.equals(m_situationMobilite)))
    {
      m_situationMobilite = p_situationMobilite;
      ((AidesPC)getPC()).setSituationMobilite(p_situationMobilite);
    }
  }
  
  protected Damj rawGetDateDebutActionReclassement()
  {
    return ((AidesPC)getPC()).getDateDebutActionReclassement();
  }
  
  public Damj getDateDebutActionReclassement()
  {
    return ((AidesPC)getPC()).getDateDebutActionReclassement();
  }
  
  public void setDateDebutActionReclassement(Damj p_dateDebutActionReclassement)
  {
    if ((m_dateDebutActionReclassement == null) || (p_dateDebutActionReclassement == null))
    {
      m_dateDebutActionReclassement = p_dateDebutActionReclassement;
      ((AidesPC)getPC()).setDateDebutActionReclassement(p_dateDebutActionReclassement);
    }
    else if ((m_dateDebutActionReclassement != null) && (p_dateDebutActionReclassement != null) && (!p_dateDebutActionReclassement.equals(m_dateDebutActionReclassement)))
    {
      m_dateDebutActionReclassement = p_dateDebutActionReclassement;
      ((AidesPC)getPC()).setDateDebutActionReclassement(p_dateDebutActionReclassement);
    }
  }
  
  protected String rawGetTypeDerogation()
  {
    return ((AidesPC)getPC()).getTypeDerogation();
  }
  
  public String getTypeDerogation()
  {
    return ((AidesPC)getPC()).getTypeDerogation();
  }
  
  public void setTypeDerogation(String p_typeDerogation)
  {
    if ((m_typeDerogation == null) || (p_typeDerogation == null))
    {
      m_typeDerogation = p_typeDerogation;
      ((AidesPC)getPC()).setTypeDerogation(p_typeDerogation);
    }
    else if ((m_typeDerogation != null) && (p_typeDerogation != null) && (!p_typeDerogation.equals(m_typeDerogation)))
    {
      m_typeDerogation = p_typeDerogation;
      ((AidesPC)getPC()).setTypeDerogation(p_typeDerogation);
    }
  }
  
  protected Damj rawGetDateFinActionReclassement()
  {
    return ((AidesPC)getPC()).getDateFinActionReclassement();
  }
  
  public Damj getDateFinActionReclassement()
  {
    return ((AidesPC)getPC()).getDateFinActionReclassement();
  }
  
  public void setDateFinActionReclassement(Damj p_dateFinActionReclassement)
  {
    if ((m_dateFinActionReclassement == null) || (p_dateFinActionReclassement == null))
    {
      m_dateFinActionReclassement = p_dateFinActionReclassement;
      ((AidesPC)getPC()).setDateFinActionReclassement(p_dateFinActionReclassement);
    }
    else if ((m_dateFinActionReclassement != null) && (p_dateFinActionReclassement != null) && (!p_dateFinActionReclassement.equals(m_dateFinActionReclassement)))
    {
      m_dateFinActionReclassement = p_dateFinActionReclassement;
      ((AidesPC)getPC()).setDateFinActionReclassement(p_dateFinActionReclassement);
    }
  }
  
  protected String rawGetCodeProduit()
  {
    return ((AidesPC)getPC()).getCodeProduit();
  }
  
  public String getCodeProduit()
  {
    return ((AidesPC)getPC()).getCodeProduit();
  }
  
  public void setCodeProduit(String p_codeProduit)
  {
    if ((m_codeProduit == null) || (p_codeProduit == null))
    {
      m_codeProduit = p_codeProduit;
      ((AidesPC)getPC()).setCodeProduit(p_codeProduit);
    }
    else if ((m_codeProduit != null) && (p_codeProduit != null) && (!p_codeProduit.equals(m_codeProduit)))
    {
      m_codeProduit = p_codeProduit;
      ((AidesPC)getPC()).setCodeProduit(p_codeProduit);
    }
  }
  
  protected String rawGetReferenceExterne()
  {
    return ((AidesPC)getPC()).getReferenceExterne();
  }
  
  public String getReferenceExterne()
  {
    return ((AidesPC)getPC()).getReferenceExterne();
  }
  
  public void setReferenceExterne(String p_referenceExterne)
  {
    if ((m_referenceExterne == null) || (p_referenceExterne == null))
    {
      m_referenceExterne = p_referenceExterne;
      ((AidesPC)getPC()).setReferenceExterne(p_referenceExterne);
    }
    else if ((m_referenceExterne != null) && (p_referenceExterne != null) && (!p_referenceExterne.equals(m_referenceExterne)))
    {
      m_referenceExterne = p_referenceExterne;
      ((AidesPC)getPC()).setReferenceExterne(p_referenceExterne);
    }
  }
  
  protected String rawGetLibelleDerogatoire()
  {
    return ((AidesPC)getPC()).getLibelleDerogatoire();
  }
  
  public String getLibelleDerogatoire()
  {
    return ((AidesPC)getPC()).getLibelleDerogatoire();
  }
  
  public void setLibelleDerogatoire(String p_libelleDerogatoire)
  {
    if ((m_libelleDerogatoire == null) || (p_libelleDerogatoire == null))
    {
      m_libelleDerogatoire = p_libelleDerogatoire;
      ((AidesPC)getPC()).setLibelleDerogatoire(p_libelleDerogatoire);
    }
    else if ((m_libelleDerogatoire != null) && (p_libelleDerogatoire != null) && (!p_libelleDerogatoire.equals(m_libelleDerogatoire)))
    {
      m_libelleDerogatoire = p_libelleDerogatoire;
      ((AidesPC)getPC()).setLibelleDerogatoire(p_libelleDerogatoire);
    }
  }
  
  protected String rawGetNumeroBon()
  {
    return ((AidesPC)getPC()).getNumeroBon();
  }
  
  public String getNumeroBon()
  {
    return ((AidesPC)getPC()).getNumeroBon();
  }
  
  public void setNumeroBon(String p_numeroBon)
  {
    if ((m_numeroBon == null) || (p_numeroBon == null))
    {
      m_numeroBon = p_numeroBon;
      ((AidesPC)getPC()).setNumeroBon(p_numeroBon);
    }
    else if ((m_numeroBon != null) && (p_numeroBon != null) && (!p_numeroBon.equals(m_numeroBon)))
    {
      m_numeroBon = p_numeroBon;
      ((AidesPC)getPC()).setNumeroBon(p_numeroBon);
    }
  }
  
  protected String rawGetClefControleBon()
  {
    return ((AidesPC)getPC()).getClefControleBon();
  }
  
  public String getClefControleBon()
  {
    return ((AidesPC)getPC()).getClefControleBon();
  }
  
  public void setClefControleBon(String p_clefControleBon)
  {
    if ((m_clefControleBon == null) || (p_clefControleBon == null))
    {
      m_clefControleBon = p_clefControleBon;
      ((AidesPC)getPC()).setClefControleBon(p_clefControleBon);
    }
    else if ((m_clefControleBon != null) && (p_clefControleBon != null) && (!p_clefControleBon.equals(m_clefControleBon)))
    {
      m_clefControleBon = p_clefControleBon;
      ((AidesPC)getPC()).setClefControleBon(p_clefControleBon);
    }
  }
  
  protected String rawGetMontantBonEnLettres()
  {
    return ((AidesPC)getPC()).getMontantBonEnLettres();
  }
  
  public String getMontantBonEnLettres()
  {
    return ((AidesPC)getPC()).getMontantBonEnLettres();
  }
  
  public void setMontantBonEnLettres(String p_montantBonEnLettres)
  {
    if ((m_montantBonEnLettres == null) || (p_montantBonEnLettres == null))
    {
      m_montantBonEnLettres = p_montantBonEnLettres;
      ((AidesPC)getPC()).setMontantBonEnLettres(p_montantBonEnLettres);
    }
    else if ((m_montantBonEnLettres != null) && (p_montantBonEnLettres != null) && (!p_montantBonEnLettres.equals(m_montantBonEnLettres)))
    {
      m_montantBonEnLettres = p_montantBonEnLettres;
      ((AidesPC)getPC()).setMontantBonEnLettres(p_montantBonEnLettres);
    }
  }
  
  protected String rawGetTypeBon()
  {
    return ((AidesPC)getPC()).getTypeBon();
  }
  
  public String getTypeBon()
  {
    return ((AidesPC)getPC()).getTypeBon();
  }
  
  public void setTypeBon(String p_typeBon)
  {
    if ((m_typeBon == null) || (p_typeBon == null))
    {
      m_typeBon = p_typeBon;
      ((AidesPC)getPC()).setTypeBon(p_typeBon);
    }
    else if ((m_typeBon != null) && (p_typeBon != null) && (!p_typeBon.equals(m_typeBon)))
    {
      m_typeBon = p_typeBon;
      ((AidesPC)getPC()).setTypeBon(p_typeBon);
    }
  }
  
  protected Integer rawGetOrigineDemande()
  {
    return ((AidesPC)getPC()).getOrigineDemande();
  }
  
  public Integer getOrigineDemande()
  {
    return ((AidesPC)getPC()).getOrigineDemande();
  }
  
  public void setOrigineDemande(Integer p_origineDemande)
  {
    if ((m_origineDemande == null) || (p_origineDemande == null))
    {
      m_origineDemande = p_origineDemande;
      ((AidesPC)getPC()).setOrigineDemande(p_origineDemande);
    }
    else if ((m_origineDemande != null) && (p_origineDemande != null) && (!p_origineDemande.equals(m_origineDemande)))
    {
      m_origineDemande = p_origineDemande;
      ((AidesPC)getPC()).setOrigineDemande(p_origineDemande);
    }
  }
  
  protected String rawGetTypeDemandeWeb()
  {
    return ((AidesPC)getPC()).getTypeDemandeWeb();
  }
  
  public String getTypeDemandeWeb()
  {
    return ((AidesPC)getPC()).getTypeDemandeWeb();
  }
  
  public void setTypeDemandeWeb(String p_typeDemandeWeb)
  {
    if ((m_typeDemandeWeb == null) || (p_typeDemandeWeb == null))
    {
      m_typeDemandeWeb = p_typeDemandeWeb;
      ((AidesPC)getPC()).setTypeDemandeWeb(p_typeDemandeWeb);
    }
    else if ((m_typeDemandeWeb != null) && (p_typeDemandeWeb != null) && (!p_typeDemandeWeb.equals(m_typeDemandeWeb)))
    {
      m_typeDemandeWeb = p_typeDemandeWeb;
      ((AidesPC)getPC()).setTypeDemandeWeb(p_typeDemandeWeb);
    }
  }
  
  protected String rawGetGareAllerDepart()
  {
    return ((AidesPC)getPC()).getGareAllerDepart();
  }
  
  public String getGareAllerDepart()
  {
    return ((AidesPC)getPC()).getGareAllerDepart();
  }
  
  public void setGareAllerDepart(String p_gareAllerDepart)
  {
    if ((m_gareAllerDepart == null) || (p_gareAllerDepart == null))
    {
      m_gareAllerDepart = p_gareAllerDepart;
      ((AidesPC)getPC()).setGareAllerDepart(p_gareAllerDepart);
    }
    else if ((m_gareAllerDepart != null) && (p_gareAllerDepart != null) && (!p_gareAllerDepart.equals(m_gareAllerDepart)))
    {
      m_gareAllerDepart = p_gareAllerDepart;
      ((AidesPC)getPC()).setGareAllerDepart(p_gareAllerDepart);
    }
  }
  
  protected String rawGetGareAllerArrivee()
  {
    return ((AidesPC)getPC()).getGareAllerArrivee();
  }
  
  public String getGareAllerArrivee()
  {
    return ((AidesPC)getPC()).getGareAllerArrivee();
  }
  
  public void setGareAllerArrivee(String p_gareAllerArrivee)
  {
    if ((m_gareAllerArrivee == null) || (p_gareAllerArrivee == null))
    {
      m_gareAllerArrivee = p_gareAllerArrivee;
      ((AidesPC)getPC()).setGareAllerArrivee(p_gareAllerArrivee);
    }
    else if ((m_gareAllerArrivee != null) && (p_gareAllerArrivee != null) && (!p_gareAllerArrivee.equals(m_gareAllerArrivee)))
    {
      m_gareAllerArrivee = p_gareAllerArrivee;
      ((AidesPC)getPC()).setGareAllerArrivee(p_gareAllerArrivee);
    }
  }
  
  private final Collection getCollectionModifiablePeriodeLieu()
  {
    Iterator itCollectionPC;
    if (m_collectionPeriodeLieu == null)
    {
      m_collectionPeriodeLieu = new ArrayList();
      for (itCollectionPC = ((AidesPC)getPC()).getCollectionPeriodeLieu().iterator(); itCollectionPC.hasNext();)
      {
        DomPCSpec currentPC = (DomPCSpec)itCollectionPC.next();
        Object currentOM = currentPC.createOM();
        m_collectionPeriodeLieu.add(currentOM);
      }
    }
    return m_collectionPeriodeLieu;
  }
  
  public Collection getCollectionPeriodeLieu()
  {
    return Collections.unmodifiableCollection(getCollectionModifiablePeriodeLieu());
  }
  
  public List getListPeriodeLieu()
  {
    return Collections.unmodifiableList((List)getCollectionModifiablePeriodeLieu());
  }
  
  public void remplacerCollectionPeriodeLieu(Collection p_collectionACopier)
  {
    clearCollectionPeriodeLieu();
    for (Iterator i = p_collectionACopier.iterator(); i.hasNext();)
    {
      PeriodeLieu objet = (PeriodeLieu)i.next();
      ajouterPeriodeLieu(objet);
    }
  }
  
  public void supprimerSousCollectionPeriodeLieu(Collection p_collectionASupprimer)
  {
    for (Iterator i = p_collectionASupprimer.iterator(); i.hasNext();)
    {
      PeriodeLieu objet = (PeriodeLieu)i.next();
      supprimerPeriodeLieu(objet);
    }
  }
  
  public void ajouterPeriodeLieu(PeriodeLieu p_periodeLieu)
    throws NullPointerException
  {
    if (p_periodeLieu == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periodeLieu ne devrait pas être nul.", p_periodeLieu);
    }
    getCollectionModifiablePeriodeLieu().add(p_periodeLieu);
    ((AidesPC)getPC()).ajouterPeriodeLieu(p_periodeLieu.getPC());
  }
  
  public void supprimerPeriodeLieu(PeriodeLieu p_periodeLieu)
    throws NullPointerException
  {
    if (p_periodeLieu == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periodeLieu ne devrait pas être nul.", p_periodeLieu);
    }
    getCollectionModifiablePeriodeLieu().remove(p_periodeLieu);
    ((AidesPC)getPC()).supprimerPeriodeLieu(p_periodeLieu.getPC());
  }
  
  public void recopierCollectionPeriodeLieuVers(ObjetMetierSpec p_copie)
  {
    AidesGen copie = (AidesGen)p_copie;
    Collection listeACopier = getCollectionPeriodeLieu();
    for (Iterator i = listeACopier.iterator(); i.hasNext();)
    {
      ObjetMetierSpec objet = ((ObjetMetierSpec)i.next()).copie();
      copie.ajouterPeriodeLieu((PeriodeLieu)objet);
    }
  }
  
  public void clearCollectionPeriodeLieu()
  {
    getCollectionModifiablePeriodeLieu().clear();
    ((AidesPC)getPC()).getCollectionPeriodeLieu().clear();
  }
  
  private final Collection getCollectionModifiableDerogation()
  {
    Iterator itCollectionPC;
    if (m_collectionDerogation == null)
    {
      m_collectionDerogation = new ArrayList();
      for (itCollectionPC = ((AidesPC)getPC()).getCollectionDerogation().iterator(); itCollectionPC.hasNext();)
      {
        DomPCSpec currentPC = (DomPCSpec)itCollectionPC.next();
        Object currentOM = currentPC.createOM();
        m_collectionDerogation.add(currentOM);
      }
    }
    return m_collectionDerogation;
  }
  
  public Collection getCollectionDerogation()
  {
    return Collections.unmodifiableCollection(getCollectionModifiableDerogation());
  }
  
  public List getListDerogation()
  {
    return Collections.unmodifiableList((List)getCollectionModifiableDerogation());
  }
  
  public void remplacerCollectionDerogation(Collection p_collectionACopier)
  {
    clearCollectionDerogation();
    for (Iterator i = p_collectionACopier.iterator(); i.hasNext();)
    {
      Derogation objet = (Derogation)i.next();
      ajouterDerogation(objet);
    }
  }
  
  public void supprimerSousCollectionDerogation(Collection p_collectionASupprimer)
  {
    for (Iterator i = p_collectionASupprimer.iterator(); i.hasNext();)
    {
      Derogation objet = (Derogation)i.next();
      supprimerDerogation(objet);
    }
  }
  
  public void ajouterDerogation(Derogation p_derogation)
    throws NullPointerException
  {
    if (p_derogation == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_derogation ne devrait pas être nul.", p_derogation);
    }
    getCollectionModifiableDerogation().add(p_derogation);
    ((AidesPC)getPC()).ajouterDerogation(p_derogation.getPC());
  }
  
  public void supprimerDerogation(Derogation p_derogation)
    throws NullPointerException
  {
    if (p_derogation == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_derogation ne devrait pas être nul.", p_derogation);
    }
    getCollectionModifiableDerogation().remove(p_derogation);
    ((AidesPC)getPC()).supprimerDerogation(p_derogation.getPC());
  }
  
  public void recopierCollectionDerogationVers(ObjetMetierSpec p_copie)
  {
    AidesGen copie = (AidesGen)p_copie;
    Collection listeACopier = getCollectionDerogation();
    for (Iterator i = listeACopier.iterator(); i.hasNext();)
    {
      ObjetMetierSpec objet = ((ObjetMetierSpec)i.next()).copie();
      copie.ajouterDerogation((Derogation)objet);
    }
  }
  
  public void clearCollectionDerogation()
  {
    getCollectionModifiableDerogation().clear();
    ((AidesPC)getPC()).getCollectionDerogation().clear();
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    for (Iterator iter = getCollectionPeriodeLieu().iterator(); iter.hasNext();)
    {
      DomGenSpec item = (DomGenSpec)iter.next();
      if ((item != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(item))) {
        DomManager.supprimer(item, p_contexteSuppression);
      }
    }
    for (Iterator iter = getCollectionDerogation().iterator(); iter.hasNext();)
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
 * Qualified Name:     AidesGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */