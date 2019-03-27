package fr.unedic.cali.calcul.pbjc.dom.pc;

import fr.unedic.cali.calcul.pbjc.dom.AideNcp;
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

public class AideNcpPC
  implements DomPCSpec, PersistenceCapable
{
  private transient AideNcp m_aideNcpOM;
  private String m_codeProduit;
  private Damj m_dateVersementAide;
  private Damj m_dateDebutAide;
  private Damj m_dateFinAide;
  private String m_codeNatureAide;
  private int m_siecleAnneeAffectationDecision;
  private String m_codeSousProduit1;
  private String m_codeNatureDerogatoireSousProduit1;
  private int m_nbAidesIndemniseesPeriode1;
  private BigDecimal m_montantUnitaireAide1;
  private BigDecimal m_montantTotalAide1;
  private String m_codeSousProduit2;
  private String m_codeNatureDerogatoireSousProduit2;
  private int m_nbAidesIndemniseesPeriode2;
  private BigDecimal m_montantUnitaireAide2;
  private BigDecimal m_montantTotalAide2;
  private String m_codeSousProduit3;
  private String m_codeSousProduit4;
  private String m_codeNatureDerogatoireSousProduit3;
  private String m_codeNatureDerogatoireSousProduit4;
  private int m_nbAidesIndemniseesPeriode3;
  private int m_nbAidesIndemniseesPeriode4;
  private BigDecimal m_montantUnitaireAide3;
  private BigDecimal m_montantUnitaireAide4;
  private BigDecimal m_montantTotalAide3;
  private BigDecimal m_montantTotalAide4;
  private String m_referenceExterne;
  private String m_typePopulation1;
  private String m_typePopulation2;
  private String m_typePopulation3;
  private String m_typePopulation4;
  private String m_typePopulation5;
  private String m_sousTypePopulation1;
  private String m_sousTypePopulation2;
  private String m_sousTypePopulation3;
  private String m_sousTypePopulation4;
  private String m_sousTypePopulation5;
  private String m_statutPrestation1;
  private String m_statutPrestation2;
  private String m_statutPrestation3;
  private String m_statutPrestation4;
  private String m_statutPrestation5;
  private int m_idPlanFormation;
  private int m_idStageFormation;
  private int m_complementTypeMontant1;
  private int m_complementTypeMontant2;
  private int m_complementTypeMontant3;
  private int m_complementTypeMontant4;
  private String m_codeSousProduit;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_codeProduit", "m_dateVersementAide", "m_dateDebutAide", "m_dateFinAide", "m_codeNatureAide", "m_siecleAnneeAffectationDecision", "m_codeSousProduit1", "m_codeNatureDerogatoireSousProduit1", "m_nbAidesIndemniseesPeriode1", "m_montantUnitaireAide1", "m_montantTotalAide1", "m_codeSousProduit2", "m_codeNatureDerogatoireSousProduit2", "m_nbAidesIndemniseesPeriode2", "m_montantUnitaireAide2", "m_montantTotalAide2", "m_codeSousProduit3", "m_codeSousProduit4", "m_codeNatureDerogatoireSousProduit3", "m_codeNatureDerogatoireSousProduit4", "m_nbAidesIndemniseesPeriode3", "m_nbAidesIndemniseesPeriode4", "m_montantUnitaireAide3", "m_montantUnitaireAide4", "m_montantTotalAide3", "m_montantTotalAide4", "m_referenceExterne", "m_typePopulation1", "m_typePopulation2", "m_typePopulation3", "m_typePopulation4", "m_typePopulation5", "m_sousTypePopulation1", "m_sousTypePopulation2", "m_sousTypePopulation3", "m_sousTypePopulation4", "m_sousTypePopulation5", "m_statutPrestation1", "m_statutPrestation2", "m_statutPrestation3", "m_statutPrestation4", "m_statutPrestation5", "m_idPlanFormation", "m_idStageFormation", "m_complementTypeMontant1", "m_complementTypeMontant2", "m_complementTypeMontant3", "m_complementTypeMontant4", "m_codeSousProduit" };
  private static Class[] jdoFieldTypes = { String.class, Damj.class, Damj.class, Damj.class, String.class, Integer.TYPE, String.class, String.class, Integer.TYPE, BigDecimal.class, BigDecimal.class, String.class, String.class, Integer.TYPE, BigDecimal.class, BigDecimal.class, String.class, String.class, String.class, String.class, Integer.TYPE, Integer.TYPE, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_aideNcpOM == null) {
      m_aideNcpOM = new AideNcp(this);
    }
    return m_aideNcpOM;
  }
  
  public String getCodeProduit()
  {
    return jdoGetm_codeProduit(this);
  }
  
  public final void setCodeProduit(String p_codeProduit)
  {
    jdoSetm_codeProduit(this, p_codeProduit);
  }
  
  public Damj getDateVersementAide()
  {
    return jdoGetm_dateVersementAide(this);
  }
  
  public final void setDateVersementAide(Damj p_dateVersementAide)
  {
    jdoSetm_dateVersementAide(this, p_dateVersementAide);
  }
  
  public Damj getDateDebutAide()
  {
    return jdoGetm_dateDebutAide(this);
  }
  
  public final void setDateDebutAide(Damj p_dateDebutAide)
  {
    jdoSetm_dateDebutAide(this, p_dateDebutAide);
  }
  
  public Damj getDateFinAide()
  {
    return jdoGetm_dateFinAide(this);
  }
  
  public final void setDateFinAide(Damj p_dateFinAide)
  {
    jdoSetm_dateFinAide(this, p_dateFinAide);
  }
  
  public String getCodeNatureAide()
  {
    return jdoGetm_codeNatureAide(this);
  }
  
  public final void setCodeNatureAide(String p_codeNatureAide)
  {
    jdoSetm_codeNatureAide(this, p_codeNatureAide);
  }
  
  public int getSiecleAnneeAffectationDecision()
  {
    return jdoGetm_siecleAnneeAffectationDecision(this);
  }
  
  public final void setSiecleAnneeAffectationDecision(int p_siecleAnneeAffectationDecision)
  {
    jdoSetm_siecleAnneeAffectationDecision(this, p_siecleAnneeAffectationDecision);
  }
  
  public String getCodeSousProduit1()
  {
    return jdoGetm_codeSousProduit1(this);
  }
  
  public final void setCodeSousProduit1(String p_codeSousProduit1)
  {
    jdoSetm_codeSousProduit1(this, p_codeSousProduit1);
  }
  
  public String getCodeNatureDerogatoireSousProduit1()
  {
    return jdoGetm_codeNatureDerogatoireSousProduit1(this);
  }
  
  public final void setCodeNatureDerogatoireSousProduit1(String p_codeNatureDerogatoireSousProduit1)
  {
    jdoSetm_codeNatureDerogatoireSousProduit1(this, p_codeNatureDerogatoireSousProduit1);
  }
  
  public int getNbAidesIndemniseesPeriode1()
  {
    return jdoGetm_nbAidesIndemniseesPeriode1(this);
  }
  
  public final void setNbAidesIndemniseesPeriode1(int p_nbAidesIndemniseesPeriode1)
  {
    jdoSetm_nbAidesIndemniseesPeriode1(this, p_nbAidesIndemniseesPeriode1);
  }
  
  public BigDecimal getMontantUnitaireAide1()
  {
    return jdoGetm_montantUnitaireAide1(this);
  }
  
  public final void setMontantUnitaireAide1(BigDecimal p_montantUnitaireAide1)
  {
    jdoSetm_montantUnitaireAide1(this, p_montantUnitaireAide1);
  }
  
  public BigDecimal getMontantTotalAide1()
  {
    return jdoGetm_montantTotalAide1(this);
  }
  
  public final void setMontantTotalAide1(BigDecimal p_montantTotalAide1)
  {
    jdoSetm_montantTotalAide1(this, p_montantTotalAide1);
  }
  
  public String getCodeSousProduit2()
  {
    return jdoGetm_codeSousProduit2(this);
  }
  
  public final void setCodeSousProduit2(String p_codeSousProduit2)
  {
    jdoSetm_codeSousProduit2(this, p_codeSousProduit2);
  }
  
  public String getCodeNatureDerogatoireSousProduit2()
  {
    return jdoGetm_codeNatureDerogatoireSousProduit2(this);
  }
  
  public final void setCodeNatureDerogatoireSousProduit2(String p_codeNatureDerogatoireSousProduit2)
  {
    jdoSetm_codeNatureDerogatoireSousProduit2(this, p_codeNatureDerogatoireSousProduit2);
  }
  
  public int getNbAidesIndemniseesPeriode2()
  {
    return jdoGetm_nbAidesIndemniseesPeriode2(this);
  }
  
  public final void setNbAidesIndemniseesPeriode2(int p_nbAidesIndemniseesPeriode2)
  {
    jdoSetm_nbAidesIndemniseesPeriode2(this, p_nbAidesIndemniseesPeriode2);
  }
  
  public BigDecimal getMontantUnitaireAide2()
  {
    return jdoGetm_montantUnitaireAide2(this);
  }
  
  public final void setMontantUnitaireAide2(BigDecimal p_montantUnitaireAide2)
  {
    jdoSetm_montantUnitaireAide2(this, p_montantUnitaireAide2);
  }
  
  public BigDecimal getMontantTotalAide2()
  {
    return jdoGetm_montantTotalAide2(this);
  }
  
  public final void setMontantTotalAide2(BigDecimal p_montantTotalAide2)
  {
    jdoSetm_montantTotalAide2(this, p_montantTotalAide2);
  }
  
  public String getCodeSousProduit3()
  {
    return jdoGetm_codeSousProduit3(this);
  }
  
  public final void setCodeSousProduit3(String p_codeSousProduit3)
  {
    jdoSetm_codeSousProduit3(this, p_codeSousProduit3);
  }
  
  public String getCodeSousProduit4()
  {
    return jdoGetm_codeSousProduit4(this);
  }
  
  public final void setCodeSousProduit4(String p_codeSousProduit4)
  {
    jdoSetm_codeSousProduit4(this, p_codeSousProduit4);
  }
  
  public String getCodeNatureDerogatoireSousProduit3()
  {
    return jdoGetm_codeNatureDerogatoireSousProduit3(this);
  }
  
  public final void setCodeNatureDerogatoireSousProduit3(String p_codeNatureDerogatoireSousProduit3)
  {
    jdoSetm_codeNatureDerogatoireSousProduit3(this, p_codeNatureDerogatoireSousProduit3);
  }
  
  public String getCodeNatureDerogatoireSousProduit4()
  {
    return jdoGetm_codeNatureDerogatoireSousProduit4(this);
  }
  
  public final void setCodeNatureDerogatoireSousProduit4(String p_codeNatureDerogatoireSousProduit4)
  {
    jdoSetm_codeNatureDerogatoireSousProduit4(this, p_codeNatureDerogatoireSousProduit4);
  }
  
  public int getNbAidesIndemniseesPeriode3()
  {
    return jdoGetm_nbAidesIndemniseesPeriode3(this);
  }
  
  public final void setNbAidesIndemniseesPeriode3(int p_nbAidesIndemniseesPeriode3)
  {
    jdoSetm_nbAidesIndemniseesPeriode3(this, p_nbAidesIndemniseesPeriode3);
  }
  
  public int getNbAidesIndemniseesPeriode4()
  {
    return jdoGetm_nbAidesIndemniseesPeriode4(this);
  }
  
  public final void setNbAidesIndemniseesPeriode4(int p_nbAidesIndemniseesPeriode4)
  {
    jdoSetm_nbAidesIndemniseesPeriode4(this, p_nbAidesIndemniseesPeriode4);
  }
  
  public BigDecimal getMontantUnitaireAide3()
  {
    return jdoGetm_montantUnitaireAide3(this);
  }
  
  public final void setMontantUnitaireAide3(BigDecimal p_montantUnitaireAide3)
  {
    jdoSetm_montantUnitaireAide3(this, p_montantUnitaireAide3);
  }
  
  public BigDecimal getMontantUnitaireAide4()
  {
    return jdoGetm_montantUnitaireAide4(this);
  }
  
  public final void setMontantUnitaireAide4(BigDecimal p_montantUnitaireAide4)
  {
    jdoSetm_montantUnitaireAide4(this, p_montantUnitaireAide4);
  }
  
  public BigDecimal getMontantTotalAide3()
  {
    return jdoGetm_montantTotalAide3(this);
  }
  
  public final void setMontantTotalAide3(BigDecimal p_montantTotalAide3)
  {
    jdoSetm_montantTotalAide3(this, p_montantTotalAide3);
  }
  
  public BigDecimal getMontantTotalAide4()
  {
    return jdoGetm_montantTotalAide4(this);
  }
  
  public final void setMontantTotalAide4(BigDecimal p_montantTotalAide4)
  {
    jdoSetm_montantTotalAide4(this, p_montantTotalAide4);
  }
  
  public String getReferenceExterne()
  {
    return jdoGetm_referenceExterne(this);
  }
  
  public final void setReferenceExterne(String p_referenceExterne)
  {
    jdoSetm_referenceExterne(this, p_referenceExterne);
  }
  
  public String getTypePopulation1()
  {
    return jdoGetm_typePopulation1(this);
  }
  
  public final void setTypePopulation1(String p_typePopulation1)
  {
    jdoSetm_typePopulation1(this, p_typePopulation1);
  }
  
  public String getTypePopulation2()
  {
    return jdoGetm_typePopulation2(this);
  }
  
  public final void setTypePopulation2(String p_typePopulation2)
  {
    jdoSetm_typePopulation2(this, p_typePopulation2);
  }
  
  public String getTypePopulation3()
  {
    return jdoGetm_typePopulation3(this);
  }
  
  public final void setTypePopulation3(String p_typePopulation3)
  {
    jdoSetm_typePopulation3(this, p_typePopulation3);
  }
  
  public String getTypePopulation4()
  {
    return jdoGetm_typePopulation4(this);
  }
  
  public final void setTypePopulation4(String p_typePopulation4)
  {
    jdoSetm_typePopulation4(this, p_typePopulation4);
  }
  
  public String getTypePopulation5()
  {
    return jdoGetm_typePopulation5(this);
  }
  
  public final void setTypePopulation5(String p_typePopulation5)
  {
    jdoSetm_typePopulation5(this, p_typePopulation5);
  }
  
  public String getSousTypePopulation1()
  {
    return jdoGetm_sousTypePopulation1(this);
  }
  
  public final void setSousTypePopulation1(String p_sousTypePopulation1)
  {
    jdoSetm_sousTypePopulation1(this, p_sousTypePopulation1);
  }
  
  public String getSousTypePopulation2()
  {
    return jdoGetm_sousTypePopulation2(this);
  }
  
  public final void setSousTypePopulation2(String p_sousTypePopulation2)
  {
    jdoSetm_sousTypePopulation2(this, p_sousTypePopulation2);
  }
  
  public String getSousTypePopulation3()
  {
    return jdoGetm_sousTypePopulation3(this);
  }
  
  public final void setSousTypePopulation3(String p_sousTypePopulation3)
  {
    jdoSetm_sousTypePopulation3(this, p_sousTypePopulation3);
  }
  
  public String getSousTypePopulation4()
  {
    return jdoGetm_sousTypePopulation4(this);
  }
  
  public final void setSousTypePopulation4(String p_sousTypePopulation4)
  {
    jdoSetm_sousTypePopulation4(this, p_sousTypePopulation4);
  }
  
  public String getSousTypePopulation5()
  {
    return jdoGetm_sousTypePopulation5(this);
  }
  
  public final void setSousTypePopulation5(String p_sousTypePopulation5)
  {
    jdoSetm_sousTypePopulation5(this, p_sousTypePopulation5);
  }
  
  public String getStatutPrestation1()
  {
    return jdoGetm_statutPrestation1(this);
  }
  
  public final void setStatutPrestation1(String p_statutPrestation1)
  {
    jdoSetm_statutPrestation1(this, p_statutPrestation1);
  }
  
  public String getStatutPrestation2()
  {
    return jdoGetm_statutPrestation2(this);
  }
  
  public final void setStatutPrestation2(String p_statutPrestation2)
  {
    jdoSetm_statutPrestation2(this, p_statutPrestation2);
  }
  
  public String getStatutPrestation3()
  {
    return jdoGetm_statutPrestation3(this);
  }
  
  public final void setStatutPrestation3(String p_statutPrestation3)
  {
    jdoSetm_statutPrestation3(this, p_statutPrestation3);
  }
  
  public String getStatutPrestation4()
  {
    return jdoGetm_statutPrestation4(this);
  }
  
  public final void setStatutPrestation4(String p_statutPrestation4)
  {
    jdoSetm_statutPrestation4(this, p_statutPrestation4);
  }
  
  public String getStatutPrestation5()
  {
    return jdoGetm_statutPrestation5(this);
  }
  
  public final void setStatutPrestation5(String p_statutPrestation5)
  {
    jdoSetm_statutPrestation5(this, p_statutPrestation5);
  }
  
  public int getIdPlanFormation()
  {
    return jdoGetm_idPlanFormation(this);
  }
  
  public final void setIdPlanFormation(int p_idPlanFormation)
  {
    jdoSetm_idPlanFormation(this, p_idPlanFormation);
  }
  
  public int getIdStageFormation()
  {
    return jdoGetm_idStageFormation(this);
  }
  
  public final void setIdStageFormation(int p_idStageFormation)
  {
    jdoSetm_idStageFormation(this, p_idStageFormation);
  }
  
  public int getComplementTypeMontant1()
  {
    return jdoGetm_complementTypeMontant1(this);
  }
  
  public final void setComplementTypeMontant1(int p_complementTypeMontant1)
  {
    jdoSetm_complementTypeMontant1(this, p_complementTypeMontant1);
  }
  
  public int getComplementTypeMontant2()
  {
    return jdoGetm_complementTypeMontant2(this);
  }
  
  public final void setComplementTypeMontant2(int p_complementTypeMontant2)
  {
    jdoSetm_complementTypeMontant2(this, p_complementTypeMontant2);
  }
  
  public int getComplementTypeMontant3()
  {
    return jdoGetm_complementTypeMontant3(this);
  }
  
  public final void setComplementTypeMontant3(int p_complementTypeMontant3)
  {
    jdoSetm_complementTypeMontant3(this, p_complementTypeMontant3);
  }
  
  public int getComplementTypeMontant4()
  {
    return jdoGetm_complementTypeMontant4(this);
  }
  
  public final void setComplementTypeMontant4(int p_complementTypeMontant4)
  {
    jdoSetm_complementTypeMontant4(this, p_complementTypeMontant4);
  }
  
  public String getCodeSousProduit()
  {
    return jdoGetm_codeSousProduit(this);
  }
  
  public final void setCodeSousProduit(String p_codeSousProduit)
  {
    jdoSetm_codeSousProduit(this, p_codeSousProduit);
  }
  
  static
  {
    JDOImplHelper.registerClass(AideNcpPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new AideNcpPC());
  }
  
  private static final String jdoGetm_codeProduit(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeProduit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_codeProduit;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 0, m_codeProduit);
    }
    return m_codeProduit;
  }
  
  private static final Damj jdoGetm_dateVersementAide(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateVersementAide;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_dateVersementAide;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_dateVersementAide);
    }
    return m_dateVersementAide;
  }
  
  private static final Damj jdoGetm_dateDebutAide(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebutAide;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_dateDebutAide;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_dateDebutAide);
    }
    return m_dateDebutAide;
  }
  
  private static final Damj jdoGetm_dateFinAide(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinAide;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_dateFinAide;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 3, m_dateFinAide);
    }
    return m_dateFinAide;
  }
  
  private static final String jdoGetm_codeNatureAide(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeNatureAide;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_codeNatureAide;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 4, m_codeNatureAide);
    }
    return m_codeNatureAide;
  }
  
  private static final int jdoGetm_siecleAnneeAffectationDecision(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_siecleAnneeAffectationDecision;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_siecleAnneeAffectationDecision;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 5, m_siecleAnneeAffectationDecision);
    }
    return m_siecleAnneeAffectationDecision;
  }
  
  private static final String jdoGetm_codeSousProduit1(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeSousProduit1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_codeSousProduit1;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 6, m_codeSousProduit1);
    }
    return m_codeSousProduit1;
  }
  
  private static final String jdoGetm_codeNatureDerogatoireSousProduit1(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeNatureDerogatoireSousProduit1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_codeNatureDerogatoireSousProduit1;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 7, m_codeNatureDerogatoireSousProduit1);
    }
    return m_codeNatureDerogatoireSousProduit1;
  }
  
  private static final int jdoGetm_nbAidesIndemniseesPeriode1(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbAidesIndemniseesPeriode1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_nbAidesIndemniseesPeriode1;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 8, m_nbAidesIndemniseesPeriode1);
    }
    return m_nbAidesIndemniseesPeriode1;
  }
  
  private static final BigDecimal jdoGetm_montantUnitaireAide1(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantUnitaireAide1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 9)) {
        return m_montantUnitaireAide1;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 9, m_montantUnitaireAide1);
    }
    return m_montantUnitaireAide1;
  }
  
  private static final BigDecimal jdoGetm_montantTotalAide1(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantTotalAide1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 10)) {
        return m_montantTotalAide1;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 10, m_montantTotalAide1);
    }
    return m_montantTotalAide1;
  }
  
  private static final String jdoGetm_codeSousProduit2(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeSousProduit2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 11)) {
        return m_codeSousProduit2;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 11, m_codeSousProduit2);
    }
    return m_codeSousProduit2;
  }
  
  private static final String jdoGetm_codeNatureDerogatoireSousProduit2(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeNatureDerogatoireSousProduit2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 12)) {
        return m_codeNatureDerogatoireSousProduit2;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 12, m_codeNatureDerogatoireSousProduit2);
    }
    return m_codeNatureDerogatoireSousProduit2;
  }
  
  private static final int jdoGetm_nbAidesIndemniseesPeriode2(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbAidesIndemniseesPeriode2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 13)) {
        return m_nbAidesIndemniseesPeriode2;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 13, m_nbAidesIndemniseesPeriode2);
    }
    return m_nbAidesIndemniseesPeriode2;
  }
  
  private static final BigDecimal jdoGetm_montantUnitaireAide2(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantUnitaireAide2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 14)) {
        return m_montantUnitaireAide2;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 14, m_montantUnitaireAide2);
    }
    return m_montantUnitaireAide2;
  }
  
  private static final BigDecimal jdoGetm_montantTotalAide2(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantTotalAide2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 15)) {
        return m_montantTotalAide2;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 15, m_montantTotalAide2);
    }
    return m_montantTotalAide2;
  }
  
  private static final String jdoGetm_codeSousProduit3(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeSousProduit3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 16)) {
        return m_codeSousProduit3;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 16, m_codeSousProduit3);
    }
    return m_codeSousProduit3;
  }
  
  private static final String jdoGetm_codeSousProduit4(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeSousProduit4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 17)) {
        return m_codeSousProduit4;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 17, m_codeSousProduit4);
    }
    return m_codeSousProduit4;
  }
  
  private static final String jdoGetm_codeNatureDerogatoireSousProduit3(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeNatureDerogatoireSousProduit3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 18)) {
        return m_codeNatureDerogatoireSousProduit3;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 18, m_codeNatureDerogatoireSousProduit3);
    }
    return m_codeNatureDerogatoireSousProduit3;
  }
  
  private static final String jdoGetm_codeNatureDerogatoireSousProduit4(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeNatureDerogatoireSousProduit4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 19)) {
        return m_codeNatureDerogatoireSousProduit4;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 19, m_codeNatureDerogatoireSousProduit4);
    }
    return m_codeNatureDerogatoireSousProduit4;
  }
  
  private static final int jdoGetm_nbAidesIndemniseesPeriode3(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbAidesIndemniseesPeriode3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 20)) {
        return m_nbAidesIndemniseesPeriode3;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 20, m_nbAidesIndemniseesPeriode3);
    }
    return m_nbAidesIndemniseesPeriode3;
  }
  
  private static final int jdoGetm_nbAidesIndemniseesPeriode4(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbAidesIndemniseesPeriode4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 21)) {
        return m_nbAidesIndemniseesPeriode4;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 21, m_nbAidesIndemniseesPeriode4);
    }
    return m_nbAidesIndemniseesPeriode4;
  }
  
  private static final BigDecimal jdoGetm_montantUnitaireAide3(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantUnitaireAide3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 22)) {
        return m_montantUnitaireAide3;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 22, m_montantUnitaireAide3);
    }
    return m_montantUnitaireAide3;
  }
  
  private static final BigDecimal jdoGetm_montantUnitaireAide4(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantUnitaireAide4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 23)) {
        return m_montantUnitaireAide4;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 23, m_montantUnitaireAide4);
    }
    return m_montantUnitaireAide4;
  }
  
  private static final BigDecimal jdoGetm_montantTotalAide3(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantTotalAide3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 24)) {
        return m_montantTotalAide3;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 24, m_montantTotalAide3);
    }
    return m_montantTotalAide3;
  }
  
  private static final BigDecimal jdoGetm_montantTotalAide4(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantTotalAide4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 25)) {
        return m_montantTotalAide4;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 25, m_montantTotalAide4);
    }
    return m_montantTotalAide4;
  }
  
  private static final String jdoGetm_referenceExterne(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_referenceExterne;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 26)) {
        return m_referenceExterne;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 26, m_referenceExterne);
    }
    return m_referenceExterne;
  }
  
  private static final String jdoGetm_typePopulation1(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typePopulation1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 27)) {
        return m_typePopulation1;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 27, m_typePopulation1);
    }
    return m_typePopulation1;
  }
  
  private static final String jdoGetm_typePopulation2(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typePopulation2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 28)) {
        return m_typePopulation2;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 28, m_typePopulation2);
    }
    return m_typePopulation2;
  }
  
  private static final String jdoGetm_typePopulation3(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typePopulation3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 29)) {
        return m_typePopulation3;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 29, m_typePopulation3);
    }
    return m_typePopulation3;
  }
  
  private static final String jdoGetm_typePopulation4(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typePopulation4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 30)) {
        return m_typePopulation4;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 30, m_typePopulation4);
    }
    return m_typePopulation4;
  }
  
  private static final String jdoGetm_typePopulation5(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typePopulation5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 31)) {
        return m_typePopulation5;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 31, m_typePopulation5);
    }
    return m_typePopulation5;
  }
  
  private static final String jdoGetm_sousTypePopulation1(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_sousTypePopulation1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 32)) {
        return m_sousTypePopulation1;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 32, m_sousTypePopulation1);
    }
    return m_sousTypePopulation1;
  }
  
  private static final String jdoGetm_sousTypePopulation2(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_sousTypePopulation2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 33)) {
        return m_sousTypePopulation2;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 33, m_sousTypePopulation2);
    }
    return m_sousTypePopulation2;
  }
  
  private static final String jdoGetm_sousTypePopulation3(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_sousTypePopulation3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 34)) {
        return m_sousTypePopulation3;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 34, m_sousTypePopulation3);
    }
    return m_sousTypePopulation3;
  }
  
  private static final String jdoGetm_sousTypePopulation4(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_sousTypePopulation4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 35)) {
        return m_sousTypePopulation4;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 35, m_sousTypePopulation4);
    }
    return m_sousTypePopulation4;
  }
  
  private static final String jdoGetm_sousTypePopulation5(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_sousTypePopulation5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 36)) {
        return m_sousTypePopulation5;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 36, m_sousTypePopulation5);
    }
    return m_sousTypePopulation5;
  }
  
  private static final String jdoGetm_statutPrestation1(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutPrestation1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 37)) {
        return m_statutPrestation1;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 37, m_statutPrestation1);
    }
    return m_statutPrestation1;
  }
  
  private static final String jdoGetm_statutPrestation2(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutPrestation2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 38)) {
        return m_statutPrestation2;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 38, m_statutPrestation2);
    }
    return m_statutPrestation2;
  }
  
  private static final String jdoGetm_statutPrestation3(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutPrestation3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 39)) {
        return m_statutPrestation3;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 39, m_statutPrestation3);
    }
    return m_statutPrestation3;
  }
  
  private static final String jdoGetm_statutPrestation4(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutPrestation4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 40)) {
        return m_statutPrestation4;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 40, m_statutPrestation4);
    }
    return m_statutPrestation4;
  }
  
  private static final String jdoGetm_statutPrestation5(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutPrestation5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 41)) {
        return m_statutPrestation5;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 41, m_statutPrestation5);
    }
    return m_statutPrestation5;
  }
  
  private static final int jdoGetm_idPlanFormation(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_idPlanFormation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 42)) {
        return m_idPlanFormation;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 42, m_idPlanFormation);
    }
    return m_idPlanFormation;
  }
  
  private static final int jdoGetm_idStageFormation(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_idStageFormation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 43)) {
        return m_idStageFormation;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 43, m_idStageFormation);
    }
    return m_idStageFormation;
  }
  
  private static final int jdoGetm_complementTypeMontant1(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementTypeMontant1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 44)) {
        return m_complementTypeMontant1;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 44, m_complementTypeMontant1);
    }
    return m_complementTypeMontant1;
  }
  
  private static final int jdoGetm_complementTypeMontant2(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementTypeMontant2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 45)) {
        return m_complementTypeMontant2;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 45, m_complementTypeMontant2);
    }
    return m_complementTypeMontant2;
  }
  
  private static final int jdoGetm_complementTypeMontant3(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementTypeMontant3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 46)) {
        return m_complementTypeMontant3;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 46, m_complementTypeMontant3);
    }
    return m_complementTypeMontant3;
  }
  
  private static final int jdoGetm_complementTypeMontant4(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementTypeMontant4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 47)) {
        return m_complementTypeMontant4;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 47, m_complementTypeMontant4);
    }
    return m_complementTypeMontant4;
  }
  
  private static final String jdoGetm_codeSousProduit(AideNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeSousProduit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 48)) {
        return m_codeSousProduit;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 48, m_codeSousProduit);
    }
    return m_codeSousProduit;
  }
  
  private static final void jdoSetm_codeProduit(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeProduit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 0, m_codeProduit, newValue);
    } else {
      m_codeProduit = newValue;
    }
  }
  
  private static final void jdoSetm_dateVersementAide(AideNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateVersementAide = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_dateVersementAide, newValue);
    } else {
      m_dateVersementAide = newValue;
    }
  }
  
  private static final void jdoSetm_dateDebutAide(AideNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebutAide = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_dateDebutAide, newValue);
    } else {
      m_dateDebutAide = newValue;
    }
  }
  
  private static final void jdoSetm_dateFinAide(AideNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinAide = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 3, m_dateFinAide, newValue);
    } else {
      m_dateFinAide = newValue;
    }
  }
  
  private static final void jdoSetm_codeNatureAide(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeNatureAide = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 4, m_codeNatureAide, newValue);
    } else {
      m_codeNatureAide = newValue;
    }
  }
  
  private static final void jdoSetm_siecleAnneeAffectationDecision(AideNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_siecleAnneeAffectationDecision = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 5, m_siecleAnneeAffectationDecision, newValue);
    } else {
      m_siecleAnneeAffectationDecision = newValue;
    }
  }
  
  private static final void jdoSetm_codeSousProduit1(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeSousProduit1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 6, m_codeSousProduit1, newValue);
    } else {
      m_codeSousProduit1 = newValue;
    }
  }
  
  private static final void jdoSetm_codeNatureDerogatoireSousProduit1(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeNatureDerogatoireSousProduit1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 7, m_codeNatureDerogatoireSousProduit1, newValue);
    } else {
      m_codeNatureDerogatoireSousProduit1 = newValue;
    }
  }
  
  private static final void jdoSetm_nbAidesIndemniseesPeriode1(AideNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbAidesIndemniseesPeriode1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 8, m_nbAidesIndemniseesPeriode1, newValue);
    } else {
      m_nbAidesIndemniseesPeriode1 = newValue;
    }
  }
  
  private static final void jdoSetm_montantUnitaireAide1(AideNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantUnitaireAide1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 9, m_montantUnitaireAide1, newValue);
    } else {
      m_montantUnitaireAide1 = newValue;
    }
  }
  
  private static final void jdoSetm_montantTotalAide1(AideNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantTotalAide1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 10, m_montantTotalAide1, newValue);
    } else {
      m_montantTotalAide1 = newValue;
    }
  }
  
  private static final void jdoSetm_codeSousProduit2(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeSousProduit2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 11, m_codeSousProduit2, newValue);
    } else {
      m_codeSousProduit2 = newValue;
    }
  }
  
  private static final void jdoSetm_codeNatureDerogatoireSousProduit2(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeNatureDerogatoireSousProduit2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 12, m_codeNatureDerogatoireSousProduit2, newValue);
    } else {
      m_codeNatureDerogatoireSousProduit2 = newValue;
    }
  }
  
  private static final void jdoSetm_nbAidesIndemniseesPeriode2(AideNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbAidesIndemniseesPeriode2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 13, m_nbAidesIndemniseesPeriode2, newValue);
    } else {
      m_nbAidesIndemniseesPeriode2 = newValue;
    }
  }
  
  private static final void jdoSetm_montantUnitaireAide2(AideNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantUnitaireAide2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 14, m_montantUnitaireAide2, newValue);
    } else {
      m_montantUnitaireAide2 = newValue;
    }
  }
  
  private static final void jdoSetm_montantTotalAide2(AideNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantTotalAide2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 15, m_montantTotalAide2, newValue);
    } else {
      m_montantTotalAide2 = newValue;
    }
  }
  
  private static final void jdoSetm_codeSousProduit3(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeSousProduit3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 16, m_codeSousProduit3, newValue);
    } else {
      m_codeSousProduit3 = newValue;
    }
  }
  
  private static final void jdoSetm_codeSousProduit4(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeSousProduit4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 17, m_codeSousProduit4, newValue);
    } else {
      m_codeSousProduit4 = newValue;
    }
  }
  
  private static final void jdoSetm_codeNatureDerogatoireSousProduit3(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeNatureDerogatoireSousProduit3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 18, m_codeNatureDerogatoireSousProduit3, newValue);
    } else {
      m_codeNatureDerogatoireSousProduit3 = newValue;
    }
  }
  
  private static final void jdoSetm_codeNatureDerogatoireSousProduit4(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeNatureDerogatoireSousProduit4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 19, m_codeNatureDerogatoireSousProduit4, newValue);
    } else {
      m_codeNatureDerogatoireSousProduit4 = newValue;
    }
  }
  
  private static final void jdoSetm_nbAidesIndemniseesPeriode3(AideNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbAidesIndemniseesPeriode3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 20, m_nbAidesIndemniseesPeriode3, newValue);
    } else {
      m_nbAidesIndemniseesPeriode3 = newValue;
    }
  }
  
  private static final void jdoSetm_nbAidesIndemniseesPeriode4(AideNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbAidesIndemniseesPeriode4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 21, m_nbAidesIndemniseesPeriode4, newValue);
    } else {
      m_nbAidesIndemniseesPeriode4 = newValue;
    }
  }
  
  private static final void jdoSetm_montantUnitaireAide3(AideNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantUnitaireAide3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 22, m_montantUnitaireAide3, newValue);
    } else {
      m_montantUnitaireAide3 = newValue;
    }
  }
  
  private static final void jdoSetm_montantUnitaireAide4(AideNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantUnitaireAide4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 23, m_montantUnitaireAide4, newValue);
    } else {
      m_montantUnitaireAide4 = newValue;
    }
  }
  
  private static final void jdoSetm_montantTotalAide3(AideNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantTotalAide3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 24, m_montantTotalAide3, newValue);
    } else {
      m_montantTotalAide3 = newValue;
    }
  }
  
  private static final void jdoSetm_montantTotalAide4(AideNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantTotalAide4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 25, m_montantTotalAide4, newValue);
    } else {
      m_montantTotalAide4 = newValue;
    }
  }
  
  private static final void jdoSetm_referenceExterne(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_referenceExterne = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 26, m_referenceExterne, newValue);
    } else {
      m_referenceExterne = newValue;
    }
  }
  
  private static final void jdoSetm_typePopulation1(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typePopulation1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 27, m_typePopulation1, newValue);
    } else {
      m_typePopulation1 = newValue;
    }
  }
  
  private static final void jdoSetm_typePopulation2(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typePopulation2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 28, m_typePopulation2, newValue);
    } else {
      m_typePopulation2 = newValue;
    }
  }
  
  private static final void jdoSetm_typePopulation3(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typePopulation3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 29, m_typePopulation3, newValue);
    } else {
      m_typePopulation3 = newValue;
    }
  }
  
  private static final void jdoSetm_typePopulation4(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typePopulation4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 30, m_typePopulation4, newValue);
    } else {
      m_typePopulation4 = newValue;
    }
  }
  
  private static final void jdoSetm_typePopulation5(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typePopulation5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 31, m_typePopulation5, newValue);
    } else {
      m_typePopulation5 = newValue;
    }
  }
  
  private static final void jdoSetm_sousTypePopulation1(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_sousTypePopulation1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 32, m_sousTypePopulation1, newValue);
    } else {
      m_sousTypePopulation1 = newValue;
    }
  }
  
  private static final void jdoSetm_sousTypePopulation2(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_sousTypePopulation2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 33, m_sousTypePopulation2, newValue);
    } else {
      m_sousTypePopulation2 = newValue;
    }
  }
  
  private static final void jdoSetm_sousTypePopulation3(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_sousTypePopulation3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 34, m_sousTypePopulation3, newValue);
    } else {
      m_sousTypePopulation3 = newValue;
    }
  }
  
  private static final void jdoSetm_sousTypePopulation4(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_sousTypePopulation4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 35, m_sousTypePopulation4, newValue);
    } else {
      m_sousTypePopulation4 = newValue;
    }
  }
  
  private static final void jdoSetm_sousTypePopulation5(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_sousTypePopulation5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 36, m_sousTypePopulation5, newValue);
    } else {
      m_sousTypePopulation5 = newValue;
    }
  }
  
  private static final void jdoSetm_statutPrestation1(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutPrestation1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 37, m_statutPrestation1, newValue);
    } else {
      m_statutPrestation1 = newValue;
    }
  }
  
  private static final void jdoSetm_statutPrestation2(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutPrestation2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 38, m_statutPrestation2, newValue);
    } else {
      m_statutPrestation2 = newValue;
    }
  }
  
  private static final void jdoSetm_statutPrestation3(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutPrestation3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 39, m_statutPrestation3, newValue);
    } else {
      m_statutPrestation3 = newValue;
    }
  }
  
  private static final void jdoSetm_statutPrestation4(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutPrestation4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 40, m_statutPrestation4, newValue);
    } else {
      m_statutPrestation4 = newValue;
    }
  }
  
  private static final void jdoSetm_statutPrestation5(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutPrestation5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 41, m_statutPrestation5, newValue);
    } else {
      m_statutPrestation5 = newValue;
    }
  }
  
  private static final void jdoSetm_idPlanFormation(AideNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_idPlanFormation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 42, m_idPlanFormation, newValue);
    } else {
      m_idPlanFormation = newValue;
    }
  }
  
  private static final void jdoSetm_idStageFormation(AideNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_idStageFormation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 43, m_idStageFormation, newValue);
    } else {
      m_idStageFormation = newValue;
    }
  }
  
  private static final void jdoSetm_complementTypeMontant1(AideNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementTypeMontant1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 44, m_complementTypeMontant1, newValue);
    } else {
      m_complementTypeMontant1 = newValue;
    }
  }
  
  private static final void jdoSetm_complementTypeMontant2(AideNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementTypeMontant2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 45, m_complementTypeMontant2, newValue);
    } else {
      m_complementTypeMontant2 = newValue;
    }
  }
  
  private static final void jdoSetm_complementTypeMontant3(AideNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementTypeMontant3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 46, m_complementTypeMontant3, newValue);
    } else {
      m_complementTypeMontant3 = newValue;
    }
  }
  
  private static final void jdoSetm_complementTypeMontant4(AideNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementTypeMontant4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 47, m_complementTypeMontant4, newValue);
    } else {
      m_complementTypeMontant4 = newValue;
    }
  }
  
  private static final void jdoSetm_codeSousProduit(AideNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeSousProduit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 48, m_codeSousProduit, newValue);
    } else {
      m_codeSousProduit = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeProduit);
      break;
    case 1: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateVersementAide);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebutAide);
      break;
    case 3: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinAide);
      break;
    case 4: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeNatureAide);
      break;
    case 5: 
      jdoStateManager.providedIntField(this, fieldNumber, m_siecleAnneeAffectationDecision);
      break;
    case 6: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeSousProduit1);
      break;
    case 7: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeNatureDerogatoireSousProduit1);
      break;
    case 8: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbAidesIndemniseesPeriode1);
      break;
    case 9: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantUnitaireAide1);
      break;
    case 10: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantTotalAide1);
      break;
    case 11: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeSousProduit2);
      break;
    case 12: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeNatureDerogatoireSousProduit2);
      break;
    case 13: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbAidesIndemniseesPeriode2);
      break;
    case 14: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantUnitaireAide2);
      break;
    case 15: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantTotalAide2);
      break;
    case 16: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeSousProduit3);
      break;
    case 17: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeSousProduit4);
      break;
    case 18: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeNatureDerogatoireSousProduit3);
      break;
    case 19: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeNatureDerogatoireSousProduit4);
      break;
    case 20: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbAidesIndemniseesPeriode3);
      break;
    case 21: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbAidesIndemniseesPeriode4);
      break;
    case 22: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantUnitaireAide3);
      break;
    case 23: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantUnitaireAide4);
      break;
    case 24: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantTotalAide3);
      break;
    case 25: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantTotalAide4);
      break;
    case 26: 
      jdoStateManager.providedStringField(this, fieldNumber, m_referenceExterne);
      break;
    case 27: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typePopulation1);
      break;
    case 28: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typePopulation2);
      break;
    case 29: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typePopulation3);
      break;
    case 30: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typePopulation4);
      break;
    case 31: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typePopulation5);
      break;
    case 32: 
      jdoStateManager.providedStringField(this, fieldNumber, m_sousTypePopulation1);
      break;
    case 33: 
      jdoStateManager.providedStringField(this, fieldNumber, m_sousTypePopulation2);
      break;
    case 34: 
      jdoStateManager.providedStringField(this, fieldNumber, m_sousTypePopulation3);
      break;
    case 35: 
      jdoStateManager.providedStringField(this, fieldNumber, m_sousTypePopulation4);
      break;
    case 36: 
      jdoStateManager.providedStringField(this, fieldNumber, m_sousTypePopulation5);
      break;
    case 37: 
      jdoStateManager.providedStringField(this, fieldNumber, m_statutPrestation1);
      break;
    case 38: 
      jdoStateManager.providedStringField(this, fieldNumber, m_statutPrestation2);
      break;
    case 39: 
      jdoStateManager.providedStringField(this, fieldNumber, m_statutPrestation3);
      break;
    case 40: 
      jdoStateManager.providedStringField(this, fieldNumber, m_statutPrestation4);
      break;
    case 41: 
      jdoStateManager.providedStringField(this, fieldNumber, m_statutPrestation5);
      break;
    case 42: 
      jdoStateManager.providedIntField(this, fieldNumber, m_idPlanFormation);
      break;
    case 43: 
      jdoStateManager.providedIntField(this, fieldNumber, m_idStageFormation);
      break;
    case 44: 
      jdoStateManager.providedIntField(this, fieldNumber, m_complementTypeMontant1);
      break;
    case 45: 
      jdoStateManager.providedIntField(this, fieldNumber, m_complementTypeMontant2);
      break;
    case 46: 
      jdoStateManager.providedIntField(this, fieldNumber, m_complementTypeMontant3);
      break;
    case 47: 
      jdoStateManager.providedIntField(this, fieldNumber, m_complementTypeMontant4);
      break;
    case 48: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeSousProduit);
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
      m_codeProduit = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 1: 
      m_dateVersementAide = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_dateDebutAide = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 3: 
      m_dateFinAide = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 4: 
      m_codeNatureAide = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 5: 
      m_siecleAnneeAffectationDecision = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 6: 
      m_codeSousProduit1 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 7: 
      m_codeNatureDerogatoireSousProduit1 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 8: 
      m_nbAidesIndemniseesPeriode1 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 9: 
      m_montantUnitaireAide1 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 10: 
      m_montantTotalAide1 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 11: 
      m_codeSousProduit2 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 12: 
      m_codeNatureDerogatoireSousProduit2 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 13: 
      m_nbAidesIndemniseesPeriode2 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 14: 
      m_montantUnitaireAide2 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 15: 
      m_montantTotalAide2 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 16: 
      m_codeSousProduit3 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 17: 
      m_codeSousProduit4 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 18: 
      m_codeNatureDerogatoireSousProduit3 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 19: 
      m_codeNatureDerogatoireSousProduit4 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 20: 
      m_nbAidesIndemniseesPeriode3 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 21: 
      m_nbAidesIndemniseesPeriode4 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 22: 
      m_montantUnitaireAide3 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 23: 
      m_montantUnitaireAide4 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 24: 
      m_montantTotalAide3 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 25: 
      m_montantTotalAide4 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 26: 
      m_referenceExterne = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 27: 
      m_typePopulation1 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 28: 
      m_typePopulation2 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 29: 
      m_typePopulation3 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 30: 
      m_typePopulation4 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 31: 
      m_typePopulation5 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 32: 
      m_sousTypePopulation1 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 33: 
      m_sousTypePopulation2 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 34: 
      m_sousTypePopulation3 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 35: 
      m_sousTypePopulation4 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 36: 
      m_sousTypePopulation5 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 37: 
      m_statutPrestation1 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 38: 
      m_statutPrestation2 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 39: 
      m_statutPrestation3 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 40: 
      m_statutPrestation4 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 41: 
      m_statutPrestation5 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 42: 
      m_idPlanFormation = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 43: 
      m_idStageFormation = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 44: 
      m_complementTypeMontant1 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 45: 
      m_complementTypeMontant2 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 46: 
      m_complementTypeMontant3 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 47: 
      m_complementTypeMontant4 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 48: 
      m_codeSousProduit = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
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
    AideNcpPC pc = new AideNcpPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    AideNcpPC pc = new AideNcpPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 49;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof AideNcpPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    AideNcpPC other = (AideNcpPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_codeProduit = m_codeProduit;
        break;
      case 1: 
        m_dateVersementAide = m_dateVersementAide;
        break;
      case 2: 
        m_dateDebutAide = m_dateDebutAide;
        break;
      case 3: 
        m_dateFinAide = m_dateFinAide;
        break;
      case 4: 
        m_codeNatureAide = m_codeNatureAide;
        break;
      case 5: 
        m_siecleAnneeAffectationDecision = m_siecleAnneeAffectationDecision;
        break;
      case 6: 
        m_codeSousProduit1 = m_codeSousProduit1;
        break;
      case 7: 
        m_codeNatureDerogatoireSousProduit1 = m_codeNatureDerogatoireSousProduit1;
        break;
      case 8: 
        m_nbAidesIndemniseesPeriode1 = m_nbAidesIndemniseesPeriode1;
        break;
      case 9: 
        m_montantUnitaireAide1 = m_montantUnitaireAide1;
        break;
      case 10: 
        m_montantTotalAide1 = m_montantTotalAide1;
        break;
      case 11: 
        m_codeSousProduit2 = m_codeSousProduit2;
        break;
      case 12: 
        m_codeNatureDerogatoireSousProduit2 = m_codeNatureDerogatoireSousProduit2;
        break;
      case 13: 
        m_nbAidesIndemniseesPeriode2 = m_nbAidesIndemniseesPeriode2;
        break;
      case 14: 
        m_montantUnitaireAide2 = m_montantUnitaireAide2;
        break;
      case 15: 
        m_montantTotalAide2 = m_montantTotalAide2;
        break;
      case 16: 
        m_codeSousProduit3 = m_codeSousProduit3;
        break;
      case 17: 
        m_codeSousProduit4 = m_codeSousProduit4;
        break;
      case 18: 
        m_codeNatureDerogatoireSousProduit3 = m_codeNatureDerogatoireSousProduit3;
        break;
      case 19: 
        m_codeNatureDerogatoireSousProduit4 = m_codeNatureDerogatoireSousProduit4;
        break;
      case 20: 
        m_nbAidesIndemniseesPeriode3 = m_nbAidesIndemniseesPeriode3;
        break;
      case 21: 
        m_nbAidesIndemniseesPeriode4 = m_nbAidesIndemniseesPeriode4;
        break;
      case 22: 
        m_montantUnitaireAide3 = m_montantUnitaireAide3;
        break;
      case 23: 
        m_montantUnitaireAide4 = m_montantUnitaireAide4;
        break;
      case 24: 
        m_montantTotalAide3 = m_montantTotalAide3;
        break;
      case 25: 
        m_montantTotalAide4 = m_montantTotalAide4;
        break;
      case 26: 
        m_referenceExterne = m_referenceExterne;
        break;
      case 27: 
        m_typePopulation1 = m_typePopulation1;
        break;
      case 28: 
        m_typePopulation2 = m_typePopulation2;
        break;
      case 29: 
        m_typePopulation3 = m_typePopulation3;
        break;
      case 30: 
        m_typePopulation4 = m_typePopulation4;
        break;
      case 31: 
        m_typePopulation5 = m_typePopulation5;
        break;
      case 32: 
        m_sousTypePopulation1 = m_sousTypePopulation1;
        break;
      case 33: 
        m_sousTypePopulation2 = m_sousTypePopulation2;
        break;
      case 34: 
        m_sousTypePopulation3 = m_sousTypePopulation3;
        break;
      case 35: 
        m_sousTypePopulation4 = m_sousTypePopulation4;
        break;
      case 36: 
        m_sousTypePopulation5 = m_sousTypePopulation5;
        break;
      case 37: 
        m_statutPrestation1 = m_statutPrestation1;
        break;
      case 38: 
        m_statutPrestation2 = m_statutPrestation2;
        break;
      case 39: 
        m_statutPrestation3 = m_statutPrestation3;
        break;
      case 40: 
        m_statutPrestation4 = m_statutPrestation4;
        break;
      case 41: 
        m_statutPrestation5 = m_statutPrestation5;
        break;
      case 42: 
        m_idPlanFormation = m_idPlanFormation;
        break;
      case 43: 
        m_idStageFormation = m_idStageFormation;
        break;
      case 44: 
        m_complementTypeMontant1 = m_complementTypeMontant1;
        break;
      case 45: 
        m_complementTypeMontant2 = m_complementTypeMontant2;
        break;
      case 46: 
        m_complementTypeMontant3 = m_complementTypeMontant3;
        break;
      case 47: 
        m_complementTypeMontant4 = m_complementTypeMontant4;
        break;
      case 48: 
        m_codeSousProduit = m_codeSousProduit;
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
 * Qualified Name:     AideNcpPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */