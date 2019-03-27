package fr.unedic.cali.calcul.pbjc.dom.pc;

import fr.unedic.cali.calcul.pbjc.dom.PrimePbjcNcp;
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

public class PrimePbjcNcpPC
  implements DomPCSpec, PersistenceCapable
{
  private transient PrimePbjcNcp m_primePbjcNcpOM;
  protected String m_codeProduit;
  protected Damj m_dateEffet;
  protected BigDecimal m_montant;
  protected BigDecimal m_complementMontant1;
  protected BigDecimal m_complementMontant2;
  protected int m_nbJoursReliquatARE;
  protected int m_odOrigine;
  protected int m_numeroOrdre;
  protected String m_codePays;
  protected String m_typePopulation1;
  protected String m_sousTypePopulation1;
  protected String m_statutPrestation1;
  protected String m_typePopulation2;
  protected String m_sousTypePopulation2;
  protected String m_statutPrestation2;
  protected String m_typePopulation3;
  protected String m_sousTypePopulation3;
  protected String m_statutPrestation3;
  protected String m_typePopulation4;
  protected String m_sousTypePopulation4;
  protected String m_statutPrestation4;
  protected String m_typePopulation5;
  protected String m_sousTypePopulation5;
  protected String m_statutPrestation5;
  private String m_codeSousProduit;
  private String m_tiers;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_codeProduit", "m_dateEffet", "m_montant", "m_complementMontant1", "m_complementMontant2", "m_nbJoursReliquatARE", "m_odOrigine", "m_numeroOrdre", "m_codePays", "m_typePopulation1", "m_sousTypePopulation1", "m_statutPrestation1", "m_typePopulation2", "m_sousTypePopulation2", "m_statutPrestation2", "m_typePopulation3", "m_sousTypePopulation3", "m_statutPrestation3", "m_typePopulation4", "m_sousTypePopulation4", "m_statutPrestation4", "m_typePopulation5", "m_sousTypePopulation5", "m_statutPrestation5", "m_codeSousProduit", "m_tiers" };
  private static Class[] jdoFieldTypes = { String.class, Damj.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_primePbjcNcpOM == null) {
      m_primePbjcNcpOM = new PrimePbjcNcp(this);
    }
    return m_primePbjcNcpOM;
  }
  
  public String getCodeProduit()
  {
    return jdoGetm_codeProduit(this);
  }
  
  public final void setCodeProduit(String p_codeProduit)
  {
    jdoSetm_codeProduit(this, p_codeProduit);
  }
  
  public Damj getDateEffet()
  {
    return jdoGetm_dateEffet(this);
  }
  
  public final void setDateEffet(Damj p_dateEffet)
  {
    jdoSetm_dateEffet(this, p_dateEffet);
  }
  
  public BigDecimal getMontant()
  {
    return jdoGetm_montant(this);
  }
  
  public final void setMontant(BigDecimal p_montant)
  {
    jdoSetm_montant(this, p_montant);
  }
  
  public BigDecimal getComplementMontant1()
  {
    return jdoGetm_complementMontant1(this);
  }
  
  public final void setComplementMontant1(BigDecimal p_complementMontant1)
  {
    jdoSetm_complementMontant1(this, p_complementMontant1);
  }
  
  public BigDecimal getComplementMontant2()
  {
    return jdoGetm_complementMontant2(this);
  }
  
  public final void setComplementMontant2(BigDecimal p_complementMontant2)
  {
    jdoSetm_complementMontant2(this, p_complementMontant2);
  }
  
  public int getNbJoursReliquatARE()
  {
    return jdoGetm_nbJoursReliquatARE(this);
  }
  
  public final void setNbJoursReliquatARE(int p_nbJoursReliquatARE)
  {
    jdoSetm_nbJoursReliquatARE(this, p_nbJoursReliquatARE);
  }
  
  public int getOdOrigine()
  {
    return jdoGetm_odOrigine(this);
  }
  
  public final void setOdOrigine(int p_odOrigine)
  {
    jdoSetm_odOrigine(this, p_odOrigine);
  }
  
  public int getNumeroOrdre()
  {
    return jdoGetm_numeroOrdre(this);
  }
  
  public final void setNumeroOrdre(int p_numeroOrdre)
  {
    jdoSetm_numeroOrdre(this, p_numeroOrdre);
  }
  
  public String getCodePays()
  {
    return jdoGetm_codePays(this);
  }
  
  public final void setCodePays(String p_codePays)
  {
    jdoSetm_codePays(this, p_codePays);
  }
  
  public String getTypePopulation1()
  {
    return jdoGetm_typePopulation1(this);
  }
  
  public final void setTypePopulation1(String p_typePopulation1)
  {
    jdoSetm_typePopulation1(this, p_typePopulation1);
  }
  
  public String getSousTypePopulation1()
  {
    return jdoGetm_sousTypePopulation1(this);
  }
  
  public final void setSousTypePopulation1(String p_sousTypePopulation1)
  {
    jdoSetm_sousTypePopulation1(this, p_sousTypePopulation1);
  }
  
  public String getStatutPrestation1()
  {
    return jdoGetm_statutPrestation1(this);
  }
  
  public final void setStatutPrestation1(String p_statutPrestation1)
  {
    jdoSetm_statutPrestation1(this, p_statutPrestation1);
  }
  
  public String getTypePopulation2()
  {
    return jdoGetm_typePopulation2(this);
  }
  
  public final void setTypePopulation2(String p_typePopulation2)
  {
    jdoSetm_typePopulation2(this, p_typePopulation2);
  }
  
  public String getSousTypePopulation2()
  {
    return jdoGetm_sousTypePopulation2(this);
  }
  
  public final void setSousTypePopulation2(String p_sousTypePopulation2)
  {
    jdoSetm_sousTypePopulation2(this, p_sousTypePopulation2);
  }
  
  public String getStatutPrestation2()
  {
    return jdoGetm_statutPrestation2(this);
  }
  
  public final void setStatutPrestation2(String p_statutPrestation2)
  {
    jdoSetm_statutPrestation2(this, p_statutPrestation2);
  }
  
  public String getTypePopulation3()
  {
    return jdoGetm_typePopulation3(this);
  }
  
  public final void setTypePopulation3(String p_typePopulation3)
  {
    jdoSetm_typePopulation3(this, p_typePopulation3);
  }
  
  public String getSousTypePopulation3()
  {
    return jdoGetm_sousTypePopulation3(this);
  }
  
  public final void setSousTypePopulation3(String p_sousTypePopulation3)
  {
    jdoSetm_sousTypePopulation3(this, p_sousTypePopulation3);
  }
  
  public String getStatutPrestation3()
  {
    return jdoGetm_statutPrestation3(this);
  }
  
  public final void setStatutPrestation3(String p_statutPrestation3)
  {
    jdoSetm_statutPrestation3(this, p_statutPrestation3);
  }
  
  public String getTypePopulation4()
  {
    return jdoGetm_typePopulation4(this);
  }
  
  public final void setTypePopulation4(String p_typePopulation4)
  {
    jdoSetm_typePopulation4(this, p_typePopulation4);
  }
  
  public String getSousTypePopulation4()
  {
    return jdoGetm_sousTypePopulation4(this);
  }
  
  public final void setSousTypePopulation4(String p_sousTypePopulation4)
  {
    jdoSetm_sousTypePopulation4(this, p_sousTypePopulation4);
  }
  
  public String getStatutPrestation4()
  {
    return jdoGetm_statutPrestation4(this);
  }
  
  public final void setStatutPrestation4(String p_statutPrestation4)
  {
    jdoSetm_statutPrestation4(this, p_statutPrestation4);
  }
  
  public String getTypePopulation5()
  {
    return jdoGetm_typePopulation5(this);
  }
  
  public final void setTypePopulation5(String p_typePopulation5)
  {
    jdoSetm_typePopulation5(this, p_typePopulation5);
  }
  
  public String getSousTypePopulation5()
  {
    return jdoGetm_sousTypePopulation5(this);
  }
  
  public final void setSousTypePopulation5(String p_sousTypePopulation5)
  {
    jdoSetm_sousTypePopulation5(this, p_sousTypePopulation5);
  }
  
  public String getStatutPrestation5()
  {
    return jdoGetm_statutPrestation5(this);
  }
  
  public final void setStatutPrestation5(String p_statutPrestation5)
  {
    jdoSetm_statutPrestation5(this, p_statutPrestation5);
  }
  
  public String getCodeSousProduit()
  {
    return jdoGetm_codeSousProduit(this);
  }
  
  public final void setCodeSousProduit(String p_codeSousProduit)
  {
    jdoSetm_codeSousProduit(this, p_codeSousProduit);
  }
  
  public String getTiers()
  {
    return jdoGetm_tiers(this);
  }
  
  public final void setTiers(String p_tiers)
  {
    jdoSetm_tiers(this, p_tiers);
  }
  
  static
  {
    JDOImplHelper.registerClass(PrimePbjcNcpPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new PrimePbjcNcpPC());
  }
  
  protected static final String jdoGetm_codeProduit(PrimePbjcNcpPC pc)
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
  
  protected static final Damj jdoGetm_dateEffet(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateEffet;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_dateEffet;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_dateEffet);
    }
    return m_dateEffet;
  }
  
  protected static final BigDecimal jdoGetm_montant(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_montant;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_montant);
    }
    return m_montant;
  }
  
  protected static final BigDecimal jdoGetm_complementMontant1(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementMontant1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_complementMontant1;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 3, m_complementMontant1);
    }
    return m_complementMontant1;
  }
  
  protected static final BigDecimal jdoGetm_complementMontant2(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementMontant2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_complementMontant2;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 4, m_complementMontant2);
    }
    return m_complementMontant2;
  }
  
  protected static final int jdoGetm_nbJoursReliquatARE(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJoursReliquatARE;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_nbJoursReliquatARE;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 5, m_nbJoursReliquatARE);
    }
    return m_nbJoursReliquatARE;
  }
  
  protected static final int jdoGetm_odOrigine(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_odOrigine;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_odOrigine;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 6, m_odOrigine);
    }
    return m_odOrigine;
  }
  
  protected static final int jdoGetm_numeroOrdre(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_numeroOrdre;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_numeroOrdre;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 7, m_numeroOrdre);
    }
    return m_numeroOrdre;
  }
  
  protected static final String jdoGetm_codePays(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codePays;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_codePays;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 8, m_codePays);
    }
    return m_codePays;
  }
  
  protected static final String jdoGetm_typePopulation1(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typePopulation1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 9)) {
        return m_typePopulation1;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 9, m_typePopulation1);
    }
    return m_typePopulation1;
  }
  
  protected static final String jdoGetm_sousTypePopulation1(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_sousTypePopulation1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 10)) {
        return m_sousTypePopulation1;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 10, m_sousTypePopulation1);
    }
    return m_sousTypePopulation1;
  }
  
  protected static final String jdoGetm_statutPrestation1(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutPrestation1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 11)) {
        return m_statutPrestation1;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 11, m_statutPrestation1);
    }
    return m_statutPrestation1;
  }
  
  protected static final String jdoGetm_typePopulation2(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typePopulation2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 12)) {
        return m_typePopulation2;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 12, m_typePopulation2);
    }
    return m_typePopulation2;
  }
  
  protected static final String jdoGetm_sousTypePopulation2(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_sousTypePopulation2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 13)) {
        return m_sousTypePopulation2;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 13, m_sousTypePopulation2);
    }
    return m_sousTypePopulation2;
  }
  
  protected static final String jdoGetm_statutPrestation2(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutPrestation2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 14)) {
        return m_statutPrestation2;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 14, m_statutPrestation2);
    }
    return m_statutPrestation2;
  }
  
  protected static final String jdoGetm_typePopulation3(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typePopulation3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 15)) {
        return m_typePopulation3;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 15, m_typePopulation3);
    }
    return m_typePopulation3;
  }
  
  protected static final String jdoGetm_sousTypePopulation3(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_sousTypePopulation3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 16)) {
        return m_sousTypePopulation3;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 16, m_sousTypePopulation3);
    }
    return m_sousTypePopulation3;
  }
  
  protected static final String jdoGetm_statutPrestation3(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutPrestation3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 17)) {
        return m_statutPrestation3;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 17, m_statutPrestation3);
    }
    return m_statutPrestation3;
  }
  
  protected static final String jdoGetm_typePopulation4(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typePopulation4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 18)) {
        return m_typePopulation4;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 18, m_typePopulation4);
    }
    return m_typePopulation4;
  }
  
  protected static final String jdoGetm_sousTypePopulation4(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_sousTypePopulation4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 19)) {
        return m_sousTypePopulation4;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 19, m_sousTypePopulation4);
    }
    return m_sousTypePopulation4;
  }
  
  protected static final String jdoGetm_statutPrestation4(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutPrestation4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 20)) {
        return m_statutPrestation4;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 20, m_statutPrestation4);
    }
    return m_statutPrestation4;
  }
  
  protected static final String jdoGetm_typePopulation5(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typePopulation5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 21)) {
        return m_typePopulation5;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 21, m_typePopulation5);
    }
    return m_typePopulation5;
  }
  
  protected static final String jdoGetm_sousTypePopulation5(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_sousTypePopulation5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 22)) {
        return m_sousTypePopulation5;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 22, m_sousTypePopulation5);
    }
    return m_sousTypePopulation5;
  }
  
  protected static final String jdoGetm_statutPrestation5(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutPrestation5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 23)) {
        return m_statutPrestation5;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 23, m_statutPrestation5);
    }
    return m_statutPrestation5;
  }
  
  private static final String jdoGetm_codeSousProduit(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeSousProduit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 24)) {
        return m_codeSousProduit;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 24, m_codeSousProduit);
    }
    return m_codeSousProduit;
  }
  
  private static final String jdoGetm_tiers(PrimePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_tiers;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 25)) {
        return m_tiers;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 25, m_tiers);
    }
    return m_tiers;
  }
  
  protected static final void jdoSetm_codeProduit(PrimePbjcNcpPC pc, String newValue)
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
  
  protected static final void jdoSetm_dateEffet(PrimePbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateEffet = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_dateEffet, newValue);
    } else {
      m_dateEffet = newValue;
    }
  }
  
  protected static final void jdoSetm_montant(PrimePbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_montant, newValue);
    } else {
      m_montant = newValue;
    }
  }
  
  protected static final void jdoSetm_complementMontant1(PrimePbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementMontant1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 3, m_complementMontant1, newValue);
    } else {
      m_complementMontant1 = newValue;
    }
  }
  
  protected static final void jdoSetm_complementMontant2(PrimePbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementMontant2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 4, m_complementMontant2, newValue);
    } else {
      m_complementMontant2 = newValue;
    }
  }
  
  protected static final void jdoSetm_nbJoursReliquatARE(PrimePbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJoursReliquatARE = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 5, m_nbJoursReliquatARE, newValue);
    } else {
      m_nbJoursReliquatARE = newValue;
    }
  }
  
  protected static final void jdoSetm_odOrigine(PrimePbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_odOrigine = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 6, m_odOrigine, newValue);
    } else {
      m_odOrigine = newValue;
    }
  }
  
  protected static final void jdoSetm_numeroOrdre(PrimePbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_numeroOrdre = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 7, m_numeroOrdre, newValue);
    } else {
      m_numeroOrdre = newValue;
    }
  }
  
  protected static final void jdoSetm_codePays(PrimePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codePays = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 8, m_codePays, newValue);
    } else {
      m_codePays = newValue;
    }
  }
  
  protected static final void jdoSetm_typePopulation1(PrimePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typePopulation1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 9, m_typePopulation1, newValue);
    } else {
      m_typePopulation1 = newValue;
    }
  }
  
  protected static final void jdoSetm_sousTypePopulation1(PrimePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_sousTypePopulation1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 10, m_sousTypePopulation1, newValue);
    } else {
      m_sousTypePopulation1 = newValue;
    }
  }
  
  protected static final void jdoSetm_statutPrestation1(PrimePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutPrestation1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 11, m_statutPrestation1, newValue);
    } else {
      m_statutPrestation1 = newValue;
    }
  }
  
  protected static final void jdoSetm_typePopulation2(PrimePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typePopulation2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 12, m_typePopulation2, newValue);
    } else {
      m_typePopulation2 = newValue;
    }
  }
  
  protected static final void jdoSetm_sousTypePopulation2(PrimePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_sousTypePopulation2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 13, m_sousTypePopulation2, newValue);
    } else {
      m_sousTypePopulation2 = newValue;
    }
  }
  
  protected static final void jdoSetm_statutPrestation2(PrimePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutPrestation2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 14, m_statutPrestation2, newValue);
    } else {
      m_statutPrestation2 = newValue;
    }
  }
  
  protected static final void jdoSetm_typePopulation3(PrimePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typePopulation3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 15, m_typePopulation3, newValue);
    } else {
      m_typePopulation3 = newValue;
    }
  }
  
  protected static final void jdoSetm_sousTypePopulation3(PrimePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_sousTypePopulation3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 16, m_sousTypePopulation3, newValue);
    } else {
      m_sousTypePopulation3 = newValue;
    }
  }
  
  protected static final void jdoSetm_statutPrestation3(PrimePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutPrestation3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 17, m_statutPrestation3, newValue);
    } else {
      m_statutPrestation3 = newValue;
    }
  }
  
  protected static final void jdoSetm_typePopulation4(PrimePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typePopulation4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 18, m_typePopulation4, newValue);
    } else {
      m_typePopulation4 = newValue;
    }
  }
  
  protected static final void jdoSetm_sousTypePopulation4(PrimePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_sousTypePopulation4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 19, m_sousTypePopulation4, newValue);
    } else {
      m_sousTypePopulation4 = newValue;
    }
  }
  
  protected static final void jdoSetm_statutPrestation4(PrimePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutPrestation4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 20, m_statutPrestation4, newValue);
    } else {
      m_statutPrestation4 = newValue;
    }
  }
  
  protected static final void jdoSetm_typePopulation5(PrimePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typePopulation5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 21, m_typePopulation5, newValue);
    } else {
      m_typePopulation5 = newValue;
    }
  }
  
  protected static final void jdoSetm_sousTypePopulation5(PrimePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_sousTypePopulation5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 22, m_sousTypePopulation5, newValue);
    } else {
      m_sousTypePopulation5 = newValue;
    }
  }
  
  protected static final void jdoSetm_statutPrestation5(PrimePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutPrestation5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 23, m_statutPrestation5, newValue);
    } else {
      m_statutPrestation5 = newValue;
    }
  }
  
  private static final void jdoSetm_codeSousProduit(PrimePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeSousProduit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 24, m_codeSousProduit, newValue);
    } else {
      m_codeSousProduit = newValue;
    }
  }
  
  private static final void jdoSetm_tiers(PrimePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_tiers = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 25, m_tiers, newValue);
    } else {
      m_tiers = newValue;
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
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateEffet);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montant);
      break;
    case 3: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_complementMontant1);
      break;
    case 4: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_complementMontant2);
      break;
    case 5: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbJoursReliquatARE);
      break;
    case 6: 
      jdoStateManager.providedIntField(this, fieldNumber, m_odOrigine);
      break;
    case 7: 
      jdoStateManager.providedIntField(this, fieldNumber, m_numeroOrdre);
      break;
    case 8: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codePays);
      break;
    case 9: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typePopulation1);
      break;
    case 10: 
      jdoStateManager.providedStringField(this, fieldNumber, m_sousTypePopulation1);
      break;
    case 11: 
      jdoStateManager.providedStringField(this, fieldNumber, m_statutPrestation1);
      break;
    case 12: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typePopulation2);
      break;
    case 13: 
      jdoStateManager.providedStringField(this, fieldNumber, m_sousTypePopulation2);
      break;
    case 14: 
      jdoStateManager.providedStringField(this, fieldNumber, m_statutPrestation2);
      break;
    case 15: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typePopulation3);
      break;
    case 16: 
      jdoStateManager.providedStringField(this, fieldNumber, m_sousTypePopulation3);
      break;
    case 17: 
      jdoStateManager.providedStringField(this, fieldNumber, m_statutPrestation3);
      break;
    case 18: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typePopulation4);
      break;
    case 19: 
      jdoStateManager.providedStringField(this, fieldNumber, m_sousTypePopulation4);
      break;
    case 20: 
      jdoStateManager.providedStringField(this, fieldNumber, m_statutPrestation4);
      break;
    case 21: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typePopulation5);
      break;
    case 22: 
      jdoStateManager.providedStringField(this, fieldNumber, m_sousTypePopulation5);
      break;
    case 23: 
      jdoStateManager.providedStringField(this, fieldNumber, m_statutPrestation5);
      break;
    case 24: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeSousProduit);
      break;
    case 25: 
      jdoStateManager.providedStringField(this, fieldNumber, m_tiers);
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
      m_dateEffet = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_montant = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 3: 
      m_complementMontant1 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 4: 
      m_complementMontant2 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 5: 
      m_nbJoursReliquatARE = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 6: 
      m_odOrigine = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 7: 
      m_numeroOrdre = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 8: 
      m_codePays = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 9: 
      m_typePopulation1 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 10: 
      m_sousTypePopulation1 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 11: 
      m_statutPrestation1 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 12: 
      m_typePopulation2 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 13: 
      m_sousTypePopulation2 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 14: 
      m_statutPrestation2 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 15: 
      m_typePopulation3 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 16: 
      m_sousTypePopulation3 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 17: 
      m_statutPrestation3 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 18: 
      m_typePopulation4 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 19: 
      m_sousTypePopulation4 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 20: 
      m_statutPrestation4 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 21: 
      m_typePopulation5 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 22: 
      m_sousTypePopulation5 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 23: 
      m_statutPrestation5 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 24: 
      m_codeSousProduit = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 25: 
      m_tiers = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
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
    PrimePbjcNcpPC pc = new PrimePbjcNcpPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    PrimePbjcNcpPC pc = new PrimePbjcNcpPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 26;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof PrimePbjcNcpPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    PrimePbjcNcpPC other = (PrimePbjcNcpPC)pc;
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
        m_dateEffet = m_dateEffet;
        break;
      case 2: 
        m_montant = m_montant;
        break;
      case 3: 
        m_complementMontant1 = m_complementMontant1;
        break;
      case 4: 
        m_complementMontant2 = m_complementMontant2;
        break;
      case 5: 
        m_nbJoursReliquatARE = m_nbJoursReliquatARE;
        break;
      case 6: 
        m_odOrigine = m_odOrigine;
        break;
      case 7: 
        m_numeroOrdre = m_numeroOrdre;
        break;
      case 8: 
        m_codePays = m_codePays;
        break;
      case 9: 
        m_typePopulation1 = m_typePopulation1;
        break;
      case 10: 
        m_sousTypePopulation1 = m_sousTypePopulation1;
        break;
      case 11: 
        m_statutPrestation1 = m_statutPrestation1;
        break;
      case 12: 
        m_typePopulation2 = m_typePopulation2;
        break;
      case 13: 
        m_sousTypePopulation2 = m_sousTypePopulation2;
        break;
      case 14: 
        m_statutPrestation2 = m_statutPrestation2;
        break;
      case 15: 
        m_typePopulation3 = m_typePopulation3;
        break;
      case 16: 
        m_sousTypePopulation3 = m_sousTypePopulation3;
        break;
      case 17: 
        m_statutPrestation3 = m_statutPrestation3;
        break;
      case 18: 
        m_typePopulation4 = m_typePopulation4;
        break;
      case 19: 
        m_sousTypePopulation4 = m_sousTypePopulation4;
        break;
      case 20: 
        m_statutPrestation4 = m_statutPrestation4;
        break;
      case 21: 
        m_typePopulation5 = m_typePopulation5;
        break;
      case 22: 
        m_sousTypePopulation5 = m_sousTypePopulation5;
        break;
      case 23: 
        m_statutPrestation5 = m_statutPrestation5;
        break;
      case 24: 
        m_codeSousProduit = m_codeSousProduit;
        break;
      case 25: 
        m_tiers = m_tiers;
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
 * Qualified Name:     PrimePbjcNcpPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */