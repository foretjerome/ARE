package fr.unedic.cali.dom.pivot.pc;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.cali.dom.pivot.Aides;
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

public class AidesPC
  implements DomPCSpec, PersistenceCapable
{
  private transient Aides m_aidesOM;
  protected int m_rangAide;
  protected int m_typeAide;
  protected BigDecimal m_montantTotalPaye;
  protected String m_etat;
  protected Damj m_dateValidationANPE;
  protected Damj m_dateValidationAssedic;
  protected int m_anneeAffectation;
  protected BigDecimal m_montantTotalEngageFraisP;
  protected BigDecimal m_montantFraisRestantStagiaireFraisP;
  protected BigDecimal m_montantCoutStageFraisP;
  protected String m_beneficiaireAideFraisP;
  protected BigDecimal m_montantFraisRestantStagiaireNonPlafonneFraisP;
  protected BigDecimal m_montantTotalEngageFraisT;
  protected BigDecimal m_montantTotalEngageFraisH;
  protected BigDecimal m_montantTotalEngageFraisR;
  protected int m_identifiantActionFormation;
  protected String m_identifiantConvention;
  protected String m_etatDemande;
  protected String m_typeActionReclassement;
  protected BigDecimal m_montantAideDerogatoire;
  protected BigDecimal m_montantBonTransport;
  protected Damj m_dateLimiteIndemnisation;
  protected BigDecimal m_plafondDerogatoireAvantAide;
  protected BigDecimal m_plafondAvantAide;
  protected int m_motifEchec;
  protected String m_situationMobilite;
  protected Damj m_dateDebutActionReclassement;
  protected String m_typeDerogation;
  protected Damj m_dateFinActionReclassement;
  protected String m_codeProduit;
  protected String m_referenceExterne;
  private String m_libelleDerogatoire;
  private String m_numeroBon;
  private String m_clefControleBon;
  private String m_montantBonEnLettres;
  private String m_typeBon;
  private Integer m_origineDemande;
  private String m_typeDemandeWeb;
  private String m_gareAllerDepart;
  private String m_gareAllerArrivee;
  protected Collection m_collectionPeriodeLieu;
  protected Collection m_collectionDerogation;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_rangAide", "m_typeAide", "m_montantTotalPaye", "m_etat", "m_dateValidationANPE", "m_dateValidationAssedic", "m_anneeAffectation", "m_montantTotalEngageFraisP", "m_montantFraisRestantStagiaireFraisP", "m_montantCoutStageFraisP", "m_beneficiaireAideFraisP", "m_montantFraisRestantStagiaireNonPlafonneFraisP", "m_montantTotalEngageFraisT", "m_montantTotalEngageFraisH", "m_montantTotalEngageFraisR", "m_identifiantActionFormation", "m_identifiantConvention", "m_etatDemande", "m_typeActionReclassement", "m_montantAideDerogatoire", "m_montantBonTransport", "m_dateLimiteIndemnisation", "m_plafondDerogatoireAvantAide", "m_plafondAvantAide", "m_motifEchec", "m_situationMobilite", "m_dateDebutActionReclassement", "m_typeDerogation", "m_dateFinActionReclassement", "m_codeProduit", "m_referenceExterne", "m_libelleDerogatoire", "m_numeroBon", "m_clefControleBon", "m_montantBonEnLettres", "m_typeBon", "m_origineDemande", "m_typeDemandeWeb", "m_gareAllerDepart", "m_gareAllerArrivee", "m_collectionPeriodeLieu", "m_collectionDerogation" };
  private static Class[] jdoFieldTypes = { Integer.TYPE, Integer.TYPE, BigDecimal.class, String.class, Damj.class, Damj.class, Integer.TYPE, BigDecimal.class, BigDecimal.class, BigDecimal.class, String.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, Integer.TYPE, String.class, String.class, String.class, BigDecimal.class, BigDecimal.class, Damj.class, BigDecimal.class, BigDecimal.class, Integer.TYPE, String.class, Damj.class, String.class, Damj.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, Collection.class, Collection.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.MEDIATE_READ + PersistenceCapable.MEDIATE_WRITE), (byte)(PersistenceCapable.MEDIATE_READ + PersistenceCapable.MEDIATE_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_aidesOM == null) {
      m_aidesOM = new Aides(this);
    }
    return m_aidesOM;
  }
  
  public int getRangAide()
  {
    return jdoGetm_rangAide(this);
  }
  
  public final void setRangAide(int p_rangAide)
  {
    jdoSetm_rangAide(this, p_rangAide);
  }
  
  public int getTypeAide()
  {
    return jdoGetm_typeAide(this);
  }
  
  public final void setTypeAide(int p_typeAide)
  {
    jdoSetm_typeAide(this, p_typeAide);
  }
  
  public BigDecimal getMontantTotalPaye()
  {
    return jdoGetm_montantTotalPaye(this);
  }
  
  public final void setMontantTotalPaye(BigDecimal p_montantTotalPaye)
  {
    jdoSetm_montantTotalPaye(this, p_montantTotalPaye);
  }
  
  public String getEtat()
  {
    return jdoGetm_etat(this);
  }
  
  public final void setEtat(String p_etat)
  {
    jdoSetm_etat(this, p_etat);
  }
  
  public Damj getDateValidationANPE()
  {
    return jdoGetm_dateValidationANPE(this);
  }
  
  public final void setDateValidationANPE(Damj p_dateValidationANPE)
  {
    jdoSetm_dateValidationANPE(this, p_dateValidationANPE);
  }
  
  public Damj getDateValidationAssedic()
  {
    return jdoGetm_dateValidationAssedic(this);
  }
  
  public final void setDateValidationAssedic(Damj p_dateValidationAssedic)
  {
    jdoSetm_dateValidationAssedic(this, p_dateValidationAssedic);
  }
  
  public int getAnneeAffectation()
  {
    return jdoGetm_anneeAffectation(this);
  }
  
  public final void setAnneeAffectation(int p_anneeAffectation)
  {
    jdoSetm_anneeAffectation(this, p_anneeAffectation);
  }
  
  public BigDecimal getMontantTotalEngageFraisP()
  {
    return jdoGetm_montantTotalEngageFraisP(this);
  }
  
  public final void setMontantTotalEngageFraisP(BigDecimal p_montantTotalEngageFraisP)
  {
    jdoSetm_montantTotalEngageFraisP(this, p_montantTotalEngageFraisP);
  }
  
  public BigDecimal getMontantFraisRestantStagiaireFraisP()
  {
    return jdoGetm_montantFraisRestantStagiaireFraisP(this);
  }
  
  public final void setMontantFraisRestantStagiaireFraisP(BigDecimal p_montantFraisRestantStagiaireFraisP)
  {
    jdoSetm_montantFraisRestantStagiaireFraisP(this, p_montantFraisRestantStagiaireFraisP);
  }
  
  public BigDecimal getMontantCoutStageFraisP()
  {
    return jdoGetm_montantCoutStageFraisP(this);
  }
  
  public final void setMontantCoutStageFraisP(BigDecimal p_montantCoutStageFraisP)
  {
    jdoSetm_montantCoutStageFraisP(this, p_montantCoutStageFraisP);
  }
  
  public String getBeneficiaireAideFraisP()
  {
    return jdoGetm_beneficiaireAideFraisP(this);
  }
  
  public final void setBeneficiaireAideFraisP(String p_beneficiaireAideFraisP)
  {
    jdoSetm_beneficiaireAideFraisP(this, p_beneficiaireAideFraisP);
  }
  
  public BigDecimal getMontantFraisRestantStagiaireNonPlafonneFraisP()
  {
    return jdoGetm_montantFraisRestantStagiaireNonPlafonneFraisP(this);
  }
  
  public final void setMontantFraisRestantStagiaireNonPlafonneFraisP(BigDecimal p_montantFraisRestantStagiaireNonPlafonneFraisP)
  {
    jdoSetm_montantFraisRestantStagiaireNonPlafonneFraisP(this, p_montantFraisRestantStagiaireNonPlafonneFraisP);
  }
  
  public BigDecimal getMontantTotalEngageFraisT()
  {
    return jdoGetm_montantTotalEngageFraisT(this);
  }
  
  public final void setMontantTotalEngageFraisT(BigDecimal p_montantTotalEngageFraisT)
  {
    jdoSetm_montantTotalEngageFraisT(this, p_montantTotalEngageFraisT);
  }
  
  public BigDecimal getMontantTotalEngageFraisH()
  {
    return jdoGetm_montantTotalEngageFraisH(this);
  }
  
  public final void setMontantTotalEngageFraisH(BigDecimal p_montantTotalEngageFraisH)
  {
    jdoSetm_montantTotalEngageFraisH(this, p_montantTotalEngageFraisH);
  }
  
  public BigDecimal getMontantTotalEngageFraisR()
  {
    return jdoGetm_montantTotalEngageFraisR(this);
  }
  
  public final void setMontantTotalEngageFraisR(BigDecimal p_montantTotalEngageFraisR)
  {
    jdoSetm_montantTotalEngageFraisR(this, p_montantTotalEngageFraisR);
  }
  
  public int getIdentifiantActionFormation()
  {
    return jdoGetm_identifiantActionFormation(this);
  }
  
  public final void setIdentifiantActionFormation(int p_identifiantActionFormation)
  {
    jdoSetm_identifiantActionFormation(this, p_identifiantActionFormation);
  }
  
  public String getIdentifiantConvention()
  {
    return jdoGetm_identifiantConvention(this);
  }
  
  public final void setIdentifiantConvention(String p_identifiantConvention)
  {
    jdoSetm_identifiantConvention(this, p_identifiantConvention);
  }
  
  public String getEtatDemande()
  {
    return jdoGetm_etatDemande(this);
  }
  
  public final void setEtatDemande(String p_etatDemande)
  {
    jdoSetm_etatDemande(this, p_etatDemande);
  }
  
  public String getTypeActionReclassement()
  {
    return jdoGetm_typeActionReclassement(this);
  }
  
  public final void setTypeActionReclassement(String p_typeActionReclassement)
  {
    jdoSetm_typeActionReclassement(this, p_typeActionReclassement);
  }
  
  public BigDecimal getMontantAideDerogatoire()
  {
    return jdoGetm_montantAideDerogatoire(this);
  }
  
  public final void setMontantAideDerogatoire(BigDecimal p_montantAideDerogatoire)
  {
    jdoSetm_montantAideDerogatoire(this, p_montantAideDerogatoire);
  }
  
  public BigDecimal getMontantBonTransport()
  {
    return jdoGetm_montantBonTransport(this);
  }
  
  public final void setMontantBonTransport(BigDecimal p_montantBonTransport)
  {
    jdoSetm_montantBonTransport(this, p_montantBonTransport);
  }
  
  public Damj getDateLimiteIndemnisation()
  {
    return jdoGetm_dateLimiteIndemnisation(this);
  }
  
  public final void setDateLimiteIndemnisation(Damj p_dateLimiteIndemnisation)
  {
    jdoSetm_dateLimiteIndemnisation(this, p_dateLimiteIndemnisation);
  }
  
  public BigDecimal getPlafondDerogatoireAvantAide()
  {
    return jdoGetm_plafondDerogatoireAvantAide(this);
  }
  
  public final void setPlafondDerogatoireAvantAide(BigDecimal p_plafondDerogatoireAvantAide)
  {
    jdoSetm_plafondDerogatoireAvantAide(this, p_plafondDerogatoireAvantAide);
  }
  
  public BigDecimal getPlafondAvantAide()
  {
    return jdoGetm_plafondAvantAide(this);
  }
  
  public final void setPlafondAvantAide(BigDecimal p_plafondAvantAide)
  {
    jdoSetm_plafondAvantAide(this, p_plafondAvantAide);
  }
  
  public int getMotifEchec()
  {
    return jdoGetm_motifEchec(this);
  }
  
  public final void setMotifEchec(int p_motifEchec)
  {
    jdoSetm_motifEchec(this, p_motifEchec);
  }
  
  public String getSituationMobilite()
  {
    return jdoGetm_situationMobilite(this);
  }
  
  public final void setSituationMobilite(String p_situationMobilite)
  {
    jdoSetm_situationMobilite(this, p_situationMobilite);
  }
  
  public Damj getDateDebutActionReclassement()
  {
    return jdoGetm_dateDebutActionReclassement(this);
  }
  
  public final void setDateDebutActionReclassement(Damj p_dateDebutActionReclassement)
  {
    jdoSetm_dateDebutActionReclassement(this, p_dateDebutActionReclassement);
  }
  
  public String getTypeDerogation()
  {
    return jdoGetm_typeDerogation(this);
  }
  
  public final void setTypeDerogation(String p_typeDerogation)
  {
    jdoSetm_typeDerogation(this, p_typeDerogation);
  }
  
  public Damj getDateFinActionReclassement()
  {
    return jdoGetm_dateFinActionReclassement(this);
  }
  
  public final void setDateFinActionReclassement(Damj p_dateFinActionReclassement)
  {
    jdoSetm_dateFinActionReclassement(this, p_dateFinActionReclassement);
  }
  
  public String getCodeProduit()
  {
    return jdoGetm_codeProduit(this);
  }
  
  public final void setCodeProduit(String p_codeProduit)
  {
    jdoSetm_codeProduit(this, p_codeProduit);
  }
  
  public String getReferenceExterne()
  {
    return jdoGetm_referenceExterne(this);
  }
  
  public final void setReferenceExterne(String p_referenceExterne)
  {
    jdoSetm_referenceExterne(this, p_referenceExterne);
  }
  
  public String getLibelleDerogatoire()
  {
    return jdoGetm_libelleDerogatoire(this);
  }
  
  public final void setLibelleDerogatoire(String p_libelleDerogatoire)
  {
    jdoSetm_libelleDerogatoire(this, p_libelleDerogatoire);
  }
  
  public String getNumeroBon()
  {
    return jdoGetm_numeroBon(this);
  }
  
  public final void setNumeroBon(String p_numeroBon)
  {
    jdoSetm_numeroBon(this, p_numeroBon);
  }
  
  public String getClefControleBon()
  {
    return jdoGetm_clefControleBon(this);
  }
  
  public final void setClefControleBon(String p_clefControleBon)
  {
    jdoSetm_clefControleBon(this, p_clefControleBon);
  }
  
  public String getMontantBonEnLettres()
  {
    return jdoGetm_montantBonEnLettres(this);
  }
  
  public final void setMontantBonEnLettres(String p_montantBonEnLettres)
  {
    jdoSetm_montantBonEnLettres(this, p_montantBonEnLettres);
  }
  
  public String getTypeBon()
  {
    return jdoGetm_typeBon(this);
  }
  
  public final void setTypeBon(String p_typeBon)
  {
    jdoSetm_typeBon(this, p_typeBon);
  }
  
  public Integer getOrigineDemande()
  {
    return jdoGetm_origineDemande(this);
  }
  
  public final void setOrigineDemande(Integer p_origineDemande)
  {
    jdoSetm_origineDemande(this, p_origineDemande);
  }
  
  public String getTypeDemandeWeb()
  {
    return jdoGetm_typeDemandeWeb(this);
  }
  
  public final void setTypeDemandeWeb(String p_typeDemandeWeb)
  {
    jdoSetm_typeDemandeWeb(this, p_typeDemandeWeb);
  }
  
  public String getGareAllerDepart()
  {
    return jdoGetm_gareAllerDepart(this);
  }
  
  public final void setGareAllerDepart(String p_gareAllerDepart)
  {
    jdoSetm_gareAllerDepart(this, p_gareAllerDepart);
  }
  
  public String getGareAllerArrivee()
  {
    return jdoGetm_gareAllerArrivee(this);
  }
  
  public final void setGareAllerArrivee(String p_gareAllerArrivee)
  {
    jdoSetm_gareAllerArrivee(this, p_gareAllerArrivee);
  }
  
  public final Collection getCollectionPeriodeLieu()
  {
    if (jdoGetm_collectionPeriodeLieu(this) == null) {
      jdoSetm_collectionPeriodeLieu(this, new ArrayList());
    }
    return jdoGetm_collectionPeriodeLieu(this);
  }
  
  public final void ajouterPeriodeLieu(DomPCSpec p_periodeLieu)
    throws NullPointerException
  {
    if (p_periodeLieu == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periodeLieu ne devrait pas être nul.", p_periodeLieu);
    }
    getCollectionPeriodeLieu().add(p_periodeLieu);
  }
  
  public final void supprimerPeriodeLieu(DomPCSpec p_periodeLieu)
    throws NullPointerException
  {
    if (p_periodeLieu == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periodeLieu ne devrait pas être nul.", p_periodeLieu);
    }
    getCollectionPeriodeLieu().remove(p_periodeLieu);
  }
  
  public final Collection getCollectionDerogation()
  {
    if (jdoGetm_collectionDerogation(this) == null) {
      jdoSetm_collectionDerogation(this, new ArrayList());
    }
    return jdoGetm_collectionDerogation(this);
  }
  
  public final void ajouterDerogation(DomPCSpec p_derogation)
    throws NullPointerException
  {
    if (p_derogation == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_derogation ne devrait pas être nul.", p_derogation);
    }
    getCollectionDerogation().add(p_derogation);
  }
  
  public final void supprimerDerogation(DomPCSpec p_derogation)
    throws NullPointerException
  {
    if (p_derogation == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_derogation ne devrait pas être nul.", p_derogation);
    }
    getCollectionDerogation().remove(p_derogation);
  }
  
  static
  {
    JDOImplHelper.registerClass(AidesPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new AidesPC());
  }
  
  protected static final int jdoGetm_rangAide(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_rangAide;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_rangAide;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 0, m_rangAide);
    }
    return m_rangAide;
  }
  
  protected static final int jdoGetm_typeAide(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeAide;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_typeAide;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 1, m_typeAide);
    }
    return m_typeAide;
  }
  
  protected static final BigDecimal jdoGetm_montantTotalPaye(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantTotalPaye;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_montantTotalPaye;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_montantTotalPaye);
    }
    return m_montantTotalPaye;
  }
  
  protected static final String jdoGetm_etat(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_etat;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_etat;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 3, m_etat);
    }
    return m_etat;
  }
  
  protected static final Damj jdoGetm_dateValidationANPE(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateValidationANPE;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_dateValidationANPE;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 4, m_dateValidationANPE);
    }
    return m_dateValidationANPE;
  }
  
  protected static final Damj jdoGetm_dateValidationAssedic(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateValidationAssedic;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_dateValidationAssedic;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 5, m_dateValidationAssedic);
    }
    return m_dateValidationAssedic;
  }
  
  protected static final int jdoGetm_anneeAffectation(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_anneeAffectation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_anneeAffectation;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 6, m_anneeAffectation);
    }
    return m_anneeAffectation;
  }
  
  protected static final BigDecimal jdoGetm_montantTotalEngageFraisP(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantTotalEngageFraisP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_montantTotalEngageFraisP;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 7, m_montantTotalEngageFraisP);
    }
    return m_montantTotalEngageFraisP;
  }
  
  protected static final BigDecimal jdoGetm_montantFraisRestantStagiaireFraisP(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantFraisRestantStagiaireFraisP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_montantFraisRestantStagiaireFraisP;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 8, m_montantFraisRestantStagiaireFraisP);
    }
    return m_montantFraisRestantStagiaireFraisP;
  }
  
  protected static final BigDecimal jdoGetm_montantCoutStageFraisP(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantCoutStageFraisP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 9)) {
        return m_montantCoutStageFraisP;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 9, m_montantCoutStageFraisP);
    }
    return m_montantCoutStageFraisP;
  }
  
  protected static final String jdoGetm_beneficiaireAideFraisP(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_beneficiaireAideFraisP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 10)) {
        return m_beneficiaireAideFraisP;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 10, m_beneficiaireAideFraisP);
    }
    return m_beneficiaireAideFraisP;
  }
  
  protected static final BigDecimal jdoGetm_montantFraisRestantStagiaireNonPlafonneFraisP(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantFraisRestantStagiaireNonPlafonneFraisP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 11)) {
        return m_montantFraisRestantStagiaireNonPlafonneFraisP;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 11, m_montantFraisRestantStagiaireNonPlafonneFraisP);
    }
    return m_montantFraisRestantStagiaireNonPlafonneFraisP;
  }
  
  protected static final BigDecimal jdoGetm_montantTotalEngageFraisT(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantTotalEngageFraisT;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 12)) {
        return m_montantTotalEngageFraisT;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 12, m_montantTotalEngageFraisT);
    }
    return m_montantTotalEngageFraisT;
  }
  
  protected static final BigDecimal jdoGetm_montantTotalEngageFraisH(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantTotalEngageFraisH;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 13)) {
        return m_montantTotalEngageFraisH;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 13, m_montantTotalEngageFraisH);
    }
    return m_montantTotalEngageFraisH;
  }
  
  protected static final BigDecimal jdoGetm_montantTotalEngageFraisR(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantTotalEngageFraisR;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 14)) {
        return m_montantTotalEngageFraisR;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 14, m_montantTotalEngageFraisR);
    }
    return m_montantTotalEngageFraisR;
  }
  
  protected static final int jdoGetm_identifiantActionFormation(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantActionFormation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 15)) {
        return m_identifiantActionFormation;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 15, m_identifiantActionFormation);
    }
    return m_identifiantActionFormation;
  }
  
  protected static final String jdoGetm_identifiantConvention(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantConvention;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 16)) {
        return m_identifiantConvention;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 16, m_identifiantConvention);
    }
    return m_identifiantConvention;
  }
  
  protected static final String jdoGetm_etatDemande(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_etatDemande;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 17)) {
        return m_etatDemande;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 17, m_etatDemande);
    }
    return m_etatDemande;
  }
  
  protected static final String jdoGetm_typeActionReclassement(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeActionReclassement;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 18)) {
        return m_typeActionReclassement;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 18, m_typeActionReclassement);
    }
    return m_typeActionReclassement;
  }
  
  protected static final BigDecimal jdoGetm_montantAideDerogatoire(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantAideDerogatoire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 19)) {
        return m_montantAideDerogatoire;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 19, m_montantAideDerogatoire);
    }
    return m_montantAideDerogatoire;
  }
  
  protected static final BigDecimal jdoGetm_montantBonTransport(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantBonTransport;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 20)) {
        return m_montantBonTransport;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 20, m_montantBonTransport);
    }
    return m_montantBonTransport;
  }
  
  protected static final Damj jdoGetm_dateLimiteIndemnisation(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateLimiteIndemnisation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 21)) {
        return m_dateLimiteIndemnisation;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 21, m_dateLimiteIndemnisation);
    }
    return m_dateLimiteIndemnisation;
  }
  
  protected static final BigDecimal jdoGetm_plafondDerogatoireAvantAide(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_plafondDerogatoireAvantAide;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 22)) {
        return m_plafondDerogatoireAvantAide;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 22, m_plafondDerogatoireAvantAide);
    }
    return m_plafondDerogatoireAvantAide;
  }
  
  protected static final BigDecimal jdoGetm_plafondAvantAide(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_plafondAvantAide;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 23)) {
        return m_plafondAvantAide;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 23, m_plafondAvantAide);
    }
    return m_plafondAvantAide;
  }
  
  protected static final int jdoGetm_motifEchec(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_motifEchec;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 24)) {
        return m_motifEchec;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 24, m_motifEchec);
    }
    return m_motifEchec;
  }
  
  protected static final String jdoGetm_situationMobilite(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_situationMobilite;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 25)) {
        return m_situationMobilite;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 25, m_situationMobilite);
    }
    return m_situationMobilite;
  }
  
  protected static final Damj jdoGetm_dateDebutActionReclassement(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebutActionReclassement;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 26)) {
        return m_dateDebutActionReclassement;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 26, m_dateDebutActionReclassement);
    }
    return m_dateDebutActionReclassement;
  }
  
  protected static final String jdoGetm_typeDerogation(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeDerogation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 27)) {
        return m_typeDerogation;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 27, m_typeDerogation);
    }
    return m_typeDerogation;
  }
  
  protected static final Damj jdoGetm_dateFinActionReclassement(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinActionReclassement;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 28)) {
        return m_dateFinActionReclassement;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 28, m_dateFinActionReclassement);
    }
    return m_dateFinActionReclassement;
  }
  
  protected static final String jdoGetm_codeProduit(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeProduit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 29)) {
        return m_codeProduit;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 29, m_codeProduit);
    }
    return m_codeProduit;
  }
  
  protected static final String jdoGetm_referenceExterne(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_referenceExterne;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 30)) {
        return m_referenceExterne;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 30, m_referenceExterne);
    }
    return m_referenceExterne;
  }
  
  private static final String jdoGetm_libelleDerogatoire(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_libelleDerogatoire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 31)) {
        return m_libelleDerogatoire;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 31, m_libelleDerogatoire);
    }
    return m_libelleDerogatoire;
  }
  
  private static final String jdoGetm_numeroBon(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_numeroBon;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 32)) {
        return m_numeroBon;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 32, m_numeroBon);
    }
    return m_numeroBon;
  }
  
  private static final String jdoGetm_clefControleBon(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_clefControleBon;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 33)) {
        return m_clefControleBon;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 33, m_clefControleBon);
    }
    return m_clefControleBon;
  }
  
  private static final String jdoGetm_montantBonEnLettres(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantBonEnLettres;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 34)) {
        return m_montantBonEnLettres;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 34, m_montantBonEnLettres);
    }
    return m_montantBonEnLettres;
  }
  
  private static final String jdoGetm_typeBon(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeBon;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 35)) {
        return m_typeBon;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 35, m_typeBon);
    }
    return m_typeBon;
  }
  
  private static final Integer jdoGetm_origineDemande(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_origineDemande;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 36)) {
        return m_origineDemande;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 36, m_origineDemande);
    }
    return m_origineDemande;
  }
  
  private static final String jdoGetm_typeDemandeWeb(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeDemandeWeb;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 37)) {
        return m_typeDemandeWeb;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 37, m_typeDemandeWeb);
    }
    return m_typeDemandeWeb;
  }
  
  private static final String jdoGetm_gareAllerDepart(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_gareAllerDepart;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 38)) {
        return m_gareAllerDepart;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 38, m_gareAllerDepart);
    }
    return m_gareAllerDepart;
  }
  
  private static final String jdoGetm_gareAllerArrivee(AidesPC pc)
  {
    if (jdoFlags <= 0) {
      return m_gareAllerArrivee;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 39)) {
        return m_gareAllerArrivee;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 39, m_gareAllerArrivee);
    }
    return m_gareAllerArrivee;
  }
  
  protected static final Collection jdoGetm_collectionPeriodeLieu(AidesPC pc)
  {
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 40)) {
        return m_collectionPeriodeLieu;
      }
      return (Collection)sm.getObjectField(pc, jdoInheritedFieldCount + 40, m_collectionPeriodeLieu);
    }
    return m_collectionPeriodeLieu;
  }
  
  protected static final Collection jdoGetm_collectionDerogation(AidesPC pc)
  {
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 41)) {
        return m_collectionDerogation;
      }
      return (Collection)sm.getObjectField(pc, jdoInheritedFieldCount + 41, m_collectionDerogation);
    }
    return m_collectionDerogation;
  }
  
  protected static final void jdoSetm_rangAide(AidesPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_rangAide = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 0, m_rangAide, newValue);
    } else {
      m_rangAide = newValue;
    }
  }
  
  protected static final void jdoSetm_typeAide(AidesPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeAide = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 1, m_typeAide, newValue);
    } else {
      m_typeAide = newValue;
    }
  }
  
  protected static final void jdoSetm_montantTotalPaye(AidesPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantTotalPaye = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_montantTotalPaye, newValue);
    } else {
      m_montantTotalPaye = newValue;
    }
  }
  
  protected static final void jdoSetm_etat(AidesPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_etat = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 3, m_etat, newValue);
    } else {
      m_etat = newValue;
    }
  }
  
  protected static final void jdoSetm_dateValidationANPE(AidesPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateValidationANPE = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 4, m_dateValidationANPE, newValue);
    } else {
      m_dateValidationANPE = newValue;
    }
  }
  
  protected static final void jdoSetm_dateValidationAssedic(AidesPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateValidationAssedic = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 5, m_dateValidationAssedic, newValue);
    } else {
      m_dateValidationAssedic = newValue;
    }
  }
  
  protected static final void jdoSetm_anneeAffectation(AidesPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_anneeAffectation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 6, m_anneeAffectation, newValue);
    } else {
      m_anneeAffectation = newValue;
    }
  }
  
  protected static final void jdoSetm_montantTotalEngageFraisP(AidesPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantTotalEngageFraisP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 7, m_montantTotalEngageFraisP, newValue);
    } else {
      m_montantTotalEngageFraisP = newValue;
    }
  }
  
  protected static final void jdoSetm_montantFraisRestantStagiaireFraisP(AidesPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantFraisRestantStagiaireFraisP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 8, m_montantFraisRestantStagiaireFraisP, newValue);
    } else {
      m_montantFraisRestantStagiaireFraisP = newValue;
    }
  }
  
  protected static final void jdoSetm_montantCoutStageFraisP(AidesPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantCoutStageFraisP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 9, m_montantCoutStageFraisP, newValue);
    } else {
      m_montantCoutStageFraisP = newValue;
    }
  }
  
  protected static final void jdoSetm_beneficiaireAideFraisP(AidesPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_beneficiaireAideFraisP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 10, m_beneficiaireAideFraisP, newValue);
    } else {
      m_beneficiaireAideFraisP = newValue;
    }
  }
  
  protected static final void jdoSetm_montantFraisRestantStagiaireNonPlafonneFraisP(AidesPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantFraisRestantStagiaireNonPlafonneFraisP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 11, m_montantFraisRestantStagiaireNonPlafonneFraisP, newValue);
    } else {
      m_montantFraisRestantStagiaireNonPlafonneFraisP = newValue;
    }
  }
  
  protected static final void jdoSetm_montantTotalEngageFraisT(AidesPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantTotalEngageFraisT = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 12, m_montantTotalEngageFraisT, newValue);
    } else {
      m_montantTotalEngageFraisT = newValue;
    }
  }
  
  protected static final void jdoSetm_montantTotalEngageFraisH(AidesPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantTotalEngageFraisH = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 13, m_montantTotalEngageFraisH, newValue);
    } else {
      m_montantTotalEngageFraisH = newValue;
    }
  }
  
  protected static final void jdoSetm_montantTotalEngageFraisR(AidesPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantTotalEngageFraisR = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 14, m_montantTotalEngageFraisR, newValue);
    } else {
      m_montantTotalEngageFraisR = newValue;
    }
  }
  
  protected static final void jdoSetm_identifiantActionFormation(AidesPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantActionFormation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 15, m_identifiantActionFormation, newValue);
    } else {
      m_identifiantActionFormation = newValue;
    }
  }
  
  protected static final void jdoSetm_identifiantConvention(AidesPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantConvention = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 16, m_identifiantConvention, newValue);
    } else {
      m_identifiantConvention = newValue;
    }
  }
  
  protected static final void jdoSetm_etatDemande(AidesPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_etatDemande = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 17, m_etatDemande, newValue);
    } else {
      m_etatDemande = newValue;
    }
  }
  
  protected static final void jdoSetm_typeActionReclassement(AidesPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeActionReclassement = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 18, m_typeActionReclassement, newValue);
    } else {
      m_typeActionReclassement = newValue;
    }
  }
  
  protected static final void jdoSetm_montantAideDerogatoire(AidesPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantAideDerogatoire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 19, m_montantAideDerogatoire, newValue);
    } else {
      m_montantAideDerogatoire = newValue;
    }
  }
  
  protected static final void jdoSetm_montantBonTransport(AidesPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantBonTransport = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 20, m_montantBonTransport, newValue);
    } else {
      m_montantBonTransport = newValue;
    }
  }
  
  protected static final void jdoSetm_dateLimiteIndemnisation(AidesPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateLimiteIndemnisation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 21, m_dateLimiteIndemnisation, newValue);
    } else {
      m_dateLimiteIndemnisation = newValue;
    }
  }
  
  protected static final void jdoSetm_plafondDerogatoireAvantAide(AidesPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_plafondDerogatoireAvantAide = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 22, m_plafondDerogatoireAvantAide, newValue);
    } else {
      m_plafondDerogatoireAvantAide = newValue;
    }
  }
  
  protected static final void jdoSetm_plafondAvantAide(AidesPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_plafondAvantAide = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 23, m_plafondAvantAide, newValue);
    } else {
      m_plafondAvantAide = newValue;
    }
  }
  
  protected static final void jdoSetm_motifEchec(AidesPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_motifEchec = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 24, m_motifEchec, newValue);
    } else {
      m_motifEchec = newValue;
    }
  }
  
  protected static final void jdoSetm_situationMobilite(AidesPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_situationMobilite = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 25, m_situationMobilite, newValue);
    } else {
      m_situationMobilite = newValue;
    }
  }
  
  protected static final void jdoSetm_dateDebutActionReclassement(AidesPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebutActionReclassement = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 26, m_dateDebutActionReclassement, newValue);
    } else {
      m_dateDebutActionReclassement = newValue;
    }
  }
  
  protected static final void jdoSetm_typeDerogation(AidesPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeDerogation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 27, m_typeDerogation, newValue);
    } else {
      m_typeDerogation = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinActionReclassement(AidesPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinActionReclassement = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 28, m_dateFinActionReclassement, newValue);
    } else {
      m_dateFinActionReclassement = newValue;
    }
  }
  
  protected static final void jdoSetm_codeProduit(AidesPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeProduit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 29, m_codeProduit, newValue);
    } else {
      m_codeProduit = newValue;
    }
  }
  
  protected static final void jdoSetm_referenceExterne(AidesPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_referenceExterne = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 30, m_referenceExterne, newValue);
    } else {
      m_referenceExterne = newValue;
    }
  }
  
  private static final void jdoSetm_libelleDerogatoire(AidesPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_libelleDerogatoire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 31, m_libelleDerogatoire, newValue);
    } else {
      m_libelleDerogatoire = newValue;
    }
  }
  
  private static final void jdoSetm_numeroBon(AidesPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_numeroBon = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 32, m_numeroBon, newValue);
    } else {
      m_numeroBon = newValue;
    }
  }
  
  private static final void jdoSetm_clefControleBon(AidesPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_clefControleBon = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 33, m_clefControleBon, newValue);
    } else {
      m_clefControleBon = newValue;
    }
  }
  
  private static final void jdoSetm_montantBonEnLettres(AidesPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantBonEnLettres = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 34, m_montantBonEnLettres, newValue);
    } else {
      m_montantBonEnLettres = newValue;
    }
  }
  
  private static final void jdoSetm_typeBon(AidesPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeBon = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 35, m_typeBon, newValue);
    } else {
      m_typeBon = newValue;
    }
  }
  
  private static final void jdoSetm_origineDemande(AidesPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_origineDemande = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 36, m_origineDemande, newValue);
    } else {
      m_origineDemande = newValue;
    }
  }
  
  private static final void jdoSetm_typeDemandeWeb(AidesPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeDemandeWeb = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 37, m_typeDemandeWeb, newValue);
    } else {
      m_typeDemandeWeb = newValue;
    }
  }
  
  private static final void jdoSetm_gareAllerDepart(AidesPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_gareAllerDepart = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 38, m_gareAllerDepart, newValue);
    } else {
      m_gareAllerDepart = newValue;
    }
  }
  
  private static final void jdoSetm_gareAllerArrivee(AidesPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_gareAllerArrivee = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 39, m_gareAllerArrivee, newValue);
    } else {
      m_gareAllerArrivee = newValue;
    }
  }
  
  protected static final void jdoSetm_collectionPeriodeLieu(AidesPC pc, Collection newValue)
  {
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 40, m_collectionPeriodeLieu, newValue);
    } else {
      m_collectionPeriodeLieu = newValue;
    }
  }
  
  protected static final void jdoSetm_collectionDerogation(AidesPC pc, Collection newValue)
  {
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 41, m_collectionDerogation, newValue);
    } else {
      m_collectionDerogation = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedIntField(this, fieldNumber, m_rangAide);
      break;
    case 1: 
      jdoStateManager.providedIntField(this, fieldNumber, m_typeAide);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantTotalPaye);
      break;
    case 3: 
      jdoStateManager.providedStringField(this, fieldNumber, m_etat);
      break;
    case 4: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateValidationANPE);
      break;
    case 5: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateValidationAssedic);
      break;
    case 6: 
      jdoStateManager.providedIntField(this, fieldNumber, m_anneeAffectation);
      break;
    case 7: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantTotalEngageFraisP);
      break;
    case 8: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantFraisRestantStagiaireFraisP);
      break;
    case 9: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantCoutStageFraisP);
      break;
    case 10: 
      jdoStateManager.providedStringField(this, fieldNumber, m_beneficiaireAideFraisP);
      break;
    case 11: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantFraisRestantStagiaireNonPlafonneFraisP);
      break;
    case 12: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantTotalEngageFraisT);
      break;
    case 13: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantTotalEngageFraisH);
      break;
    case 14: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantTotalEngageFraisR);
      break;
    case 15: 
      jdoStateManager.providedIntField(this, fieldNumber, m_identifiantActionFormation);
      break;
    case 16: 
      jdoStateManager.providedStringField(this, fieldNumber, m_identifiantConvention);
      break;
    case 17: 
      jdoStateManager.providedStringField(this, fieldNumber, m_etatDemande);
      break;
    case 18: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeActionReclassement);
      break;
    case 19: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantAideDerogatoire);
      break;
    case 20: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantBonTransport);
      break;
    case 21: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateLimiteIndemnisation);
      break;
    case 22: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_plafondDerogatoireAvantAide);
      break;
    case 23: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_plafondAvantAide);
      break;
    case 24: 
      jdoStateManager.providedIntField(this, fieldNumber, m_motifEchec);
      break;
    case 25: 
      jdoStateManager.providedStringField(this, fieldNumber, m_situationMobilite);
      break;
    case 26: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebutActionReclassement);
      break;
    case 27: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeDerogation);
      break;
    case 28: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinActionReclassement);
      break;
    case 29: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeProduit);
      break;
    case 30: 
      jdoStateManager.providedStringField(this, fieldNumber, m_referenceExterne);
      break;
    case 31: 
      jdoStateManager.providedStringField(this, fieldNumber, m_libelleDerogatoire);
      break;
    case 32: 
      jdoStateManager.providedStringField(this, fieldNumber, m_numeroBon);
      break;
    case 33: 
      jdoStateManager.providedStringField(this, fieldNumber, m_clefControleBon);
      break;
    case 34: 
      jdoStateManager.providedStringField(this, fieldNumber, m_montantBonEnLettres);
      break;
    case 35: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeBon);
      break;
    case 36: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_origineDemande);
      break;
    case 37: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeDemandeWeb);
      break;
    case 38: 
      jdoStateManager.providedStringField(this, fieldNumber, m_gareAllerDepart);
      break;
    case 39: 
      jdoStateManager.providedStringField(this, fieldNumber, m_gareAllerArrivee);
      break;
    case 40: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_collectionPeriodeLieu);
      break;
    case 41: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_collectionDerogation);
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
      m_rangAide = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 1: 
      m_typeAide = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 2: 
      m_montantTotalPaye = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 3: 
      m_etat = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 4: 
      m_dateValidationANPE = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 5: 
      m_dateValidationAssedic = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 6: 
      m_anneeAffectation = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 7: 
      m_montantTotalEngageFraisP = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 8: 
      m_montantFraisRestantStagiaireFraisP = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 9: 
      m_montantCoutStageFraisP = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 10: 
      m_beneficiaireAideFraisP = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 11: 
      m_montantFraisRestantStagiaireNonPlafonneFraisP = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 12: 
      m_montantTotalEngageFraisT = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 13: 
      m_montantTotalEngageFraisH = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 14: 
      m_montantTotalEngageFraisR = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 15: 
      m_identifiantActionFormation = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 16: 
      m_identifiantConvention = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 17: 
      m_etatDemande = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 18: 
      m_typeActionReclassement = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 19: 
      m_montantAideDerogatoire = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 20: 
      m_montantBonTransport = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 21: 
      m_dateLimiteIndemnisation = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 22: 
      m_plafondDerogatoireAvantAide = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 23: 
      m_plafondAvantAide = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 24: 
      m_motifEchec = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 25: 
      m_situationMobilite = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 26: 
      m_dateDebutActionReclassement = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 27: 
      m_typeDerogation = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 28: 
      m_dateFinActionReclassement = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 29: 
      m_codeProduit = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 30: 
      m_referenceExterne = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 31: 
      m_libelleDerogatoire = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 32: 
      m_numeroBon = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 33: 
      m_clefControleBon = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 34: 
      m_montantBonEnLettres = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 35: 
      m_typeBon = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 36: 
      m_origineDemande = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 37: 
      m_typeDemandeWeb = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 38: 
      m_gareAllerDepart = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 39: 
      m_gareAllerArrivee = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 40: 
      m_collectionPeriodeLieu = ((Collection)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 41: 
      m_collectionDerogation = ((Collection)jdoStateManager.replacingObjectField(this, fieldNumber));
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
    AidesPC pc = new AidesPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    AidesPC pc = new AidesPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 42;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof AidesPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    AidesPC other = (AidesPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_rangAide = m_rangAide;
        break;
      case 1: 
        m_typeAide = m_typeAide;
        break;
      case 2: 
        m_montantTotalPaye = m_montantTotalPaye;
        break;
      case 3: 
        m_etat = m_etat;
        break;
      case 4: 
        m_dateValidationANPE = m_dateValidationANPE;
        break;
      case 5: 
        m_dateValidationAssedic = m_dateValidationAssedic;
        break;
      case 6: 
        m_anneeAffectation = m_anneeAffectation;
        break;
      case 7: 
        m_montantTotalEngageFraisP = m_montantTotalEngageFraisP;
        break;
      case 8: 
        m_montantFraisRestantStagiaireFraisP = m_montantFraisRestantStagiaireFraisP;
        break;
      case 9: 
        m_montantCoutStageFraisP = m_montantCoutStageFraisP;
        break;
      case 10: 
        m_beneficiaireAideFraisP = m_beneficiaireAideFraisP;
        break;
      case 11: 
        m_montantFraisRestantStagiaireNonPlafonneFraisP = m_montantFraisRestantStagiaireNonPlafonneFraisP;
        break;
      case 12: 
        m_montantTotalEngageFraisT = m_montantTotalEngageFraisT;
        break;
      case 13: 
        m_montantTotalEngageFraisH = m_montantTotalEngageFraisH;
        break;
      case 14: 
        m_montantTotalEngageFraisR = m_montantTotalEngageFraisR;
        break;
      case 15: 
        m_identifiantActionFormation = m_identifiantActionFormation;
        break;
      case 16: 
        m_identifiantConvention = m_identifiantConvention;
        break;
      case 17: 
        m_etatDemande = m_etatDemande;
        break;
      case 18: 
        m_typeActionReclassement = m_typeActionReclassement;
        break;
      case 19: 
        m_montantAideDerogatoire = m_montantAideDerogatoire;
        break;
      case 20: 
        m_montantBonTransport = m_montantBonTransport;
        break;
      case 21: 
        m_dateLimiteIndemnisation = m_dateLimiteIndemnisation;
        break;
      case 22: 
        m_plafondDerogatoireAvantAide = m_plafondDerogatoireAvantAide;
        break;
      case 23: 
        m_plafondAvantAide = m_plafondAvantAide;
        break;
      case 24: 
        m_motifEchec = m_motifEchec;
        break;
      case 25: 
        m_situationMobilite = m_situationMobilite;
        break;
      case 26: 
        m_dateDebutActionReclassement = m_dateDebutActionReclassement;
        break;
      case 27: 
        m_typeDerogation = m_typeDerogation;
        break;
      case 28: 
        m_dateFinActionReclassement = m_dateFinActionReclassement;
        break;
      case 29: 
        m_codeProduit = m_codeProduit;
        break;
      case 30: 
        m_referenceExterne = m_referenceExterne;
        break;
      case 31: 
        m_libelleDerogatoire = m_libelleDerogatoire;
        break;
      case 32: 
        m_numeroBon = m_numeroBon;
        break;
      case 33: 
        m_clefControleBon = m_clefControleBon;
        break;
      case 34: 
        m_montantBonEnLettres = m_montantBonEnLettres;
        break;
      case 35: 
        m_typeBon = m_typeBon;
        break;
      case 36: 
        m_origineDemande = m_origineDemande;
        break;
      case 37: 
        m_typeDemandeWeb = m_typeDemandeWeb;
        break;
      case 38: 
        m_gareAllerDepart = m_gareAllerDepart;
        break;
      case 39: 
        m_gareAllerArrivee = m_gareAllerArrivee;
        break;
      case 40: 
        m_collectionPeriodeLieu = m_collectionPeriodeLieu;
        break;
      case 41: 
        m_collectionDerogation = m_collectionDerogation;
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
 * Qualified Name:     AidesPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */