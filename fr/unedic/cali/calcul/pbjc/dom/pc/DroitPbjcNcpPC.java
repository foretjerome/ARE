package fr.unedic.cali.calcul.pbjc.dom.pc;

import fr.unedic.cali.calcul.pbjc.dom.DroitPbjcNcp;
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

public class DroitPbjcNcpPC
  implements DomPCSpec, PersistenceCapable
{
  private transient DroitPbjcNcp m_droitPbjcNcpOM;
  protected int m_identOuvertureDroit;
  protected Damj m_dateEffetMaintien;
  protected Damj m_dateEffetExclusionDef;
  protected Damj m_dateFinDeDroit;
  protected Damj m_dateEffetPjiMaintienEESSI;
  protected Damj m_dateEffetIdeMaintienEESSI;
  protected Damj m_dateEffetDjiMaintienEESSI;
  protected boolean m_indicateurMaintienEESSI;
  private BigDecimal m_anneeAffectation;
  protected Damj m_dateFinCSP;
  private Damj m_dateDebutDroit;
  private Integer m_reliquatFranchiseSalaire;
  private BigDecimal m_montantPrecompteOd;
  private Integer m_reliquatFranchiseCP;
  private Integer m_sommeReliquatPlafonee;
  private Integer m_franchiseSalaireInit;
  private Integer m_franchiseCPinit;
  private BigDecimal m_montantBrutOd;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_identOuvertureDroit", "m_dateEffetMaintien", "m_dateEffetExclusionDef", "m_dateFinDeDroit", "m_dateEffetPjiMaintienEESSI", "m_dateEffetIdeMaintienEESSI", "m_dateEffetDjiMaintienEESSI", "m_indicateurMaintienEESSI", "m_anneeAffectation", "m_dateFinCSP", "m_dateDebutDroit", "m_reliquatFranchiseSalaire", "m_montantPrecompteOd", "m_reliquatFranchiseCP", "m_sommeReliquatPlafonee", "m_franchiseSalaireInit", "m_franchiseCPinit", "m_montantBrutOd" };
  private static Class[] jdoFieldTypes = { Integer.TYPE, Damj.class, Damj.class, Damj.class, Damj.class, Damj.class, Damj.class, Boolean.TYPE, BigDecimal.class, Damj.class, Damj.class, Integer.class, BigDecimal.class, Integer.class, Integer.class, Integer.class, Integer.class, BigDecimal.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_droitPbjcNcpOM == null) {
      m_droitPbjcNcpOM = new DroitPbjcNcp(this);
    }
    return m_droitPbjcNcpOM;
  }
  
  public int getIdentOuvertureDroit()
  {
    return jdoGetm_identOuvertureDroit(this);
  }
  
  public final void setIdentOuvertureDroit(int p_identOuvertureDroit)
  {
    jdoSetm_identOuvertureDroit(this, p_identOuvertureDroit);
  }
  
  public Damj getDateEffetMaintien()
  {
    return jdoGetm_dateEffetMaintien(this);
  }
  
  public final void setDateEffetMaintien(Damj p_dateEffetMaintien)
  {
    jdoSetm_dateEffetMaintien(this, p_dateEffetMaintien);
  }
  
  public Damj getDateEffetExclusionDef()
  {
    return jdoGetm_dateEffetExclusionDef(this);
  }
  
  public final void setDateEffetExclusionDef(Damj p_dateEffetExclusionDef)
  {
    jdoSetm_dateEffetExclusionDef(this, p_dateEffetExclusionDef);
  }
  
  public Damj getDateFinDeDroit()
  {
    return jdoGetm_dateFinDeDroit(this);
  }
  
  public final void setDateFinDeDroit(Damj p_dateFinDeDroit)
  {
    jdoSetm_dateFinDeDroit(this, p_dateFinDeDroit);
  }
  
  public Damj getDateEffetPjiMaintienEESSI()
  {
    return jdoGetm_dateEffetPjiMaintienEESSI(this);
  }
  
  public final void setDateEffetPjiMaintienEESSI(Damj p_dateEffetPjiMaintienEESSI)
  {
    jdoSetm_dateEffetPjiMaintienEESSI(this, p_dateEffetPjiMaintienEESSI);
  }
  
  public Damj getDateEffetIdeMaintienEESSI()
  {
    return jdoGetm_dateEffetIdeMaintienEESSI(this);
  }
  
  public final void setDateEffetIdeMaintienEESSI(Damj p_dateEffetIdeMaintienEESSI)
  {
    jdoSetm_dateEffetIdeMaintienEESSI(this, p_dateEffetIdeMaintienEESSI);
  }
  
  public Damj getDateEffetDjiMaintienEESSI()
  {
    return jdoGetm_dateEffetDjiMaintienEESSI(this);
  }
  
  public final void setDateEffetDjiMaintienEESSI(Damj p_dateEffetDjiMaintienEESSI)
  {
    jdoSetm_dateEffetDjiMaintienEESSI(this, p_dateEffetDjiMaintienEESSI);
  }
  
  public boolean isIndicateurMaintienEESSI()
  {
    return jdoGetm_indicateurMaintienEESSI(this);
  }
  
  public final void setIndicateurMaintienEESSI(boolean p_indicateurMaintienEESSI)
  {
    jdoSetm_indicateurMaintienEESSI(this, p_indicateurMaintienEESSI);
  }
  
  public BigDecimal getAnneeAffectation()
  {
    return jdoGetm_anneeAffectation(this);
  }
  
  public final void setAnneeAffectation(BigDecimal p_anneeAffectation)
  {
    jdoSetm_anneeAffectation(this, p_anneeAffectation);
  }
  
  public Damj getDateFinCSP()
  {
    return jdoGetm_dateFinCSP(this);
  }
  
  public final void setDateFinCSP(Damj p_dateFinCSP)
  {
    jdoSetm_dateFinCSP(this, p_dateFinCSP);
  }
  
  public Damj getDateDebutDroit()
  {
    return jdoGetm_dateDebutDroit(this);
  }
  
  public final void setDateDebutDroit(Damj p_dateDebutDroit)
  {
    jdoSetm_dateDebutDroit(this, p_dateDebutDroit);
  }
  
  public Integer getReliquatFranchiseSalaire()
  {
    return jdoGetm_reliquatFranchiseSalaire(this);
  }
  
  public final void setReliquatFranchiseSalaire(Integer p_reliquatFranchiseSalaire)
  {
    jdoSetm_reliquatFranchiseSalaire(this, p_reliquatFranchiseSalaire);
  }
  
  public BigDecimal getMontantPrecompteOd()
  {
    return jdoGetm_montantPrecompteOd(this);
  }
  
  public final void setMontantPrecompteOd(BigDecimal p_montantPrecompteOd)
  {
    jdoSetm_montantPrecompteOd(this, p_montantPrecompteOd);
  }
  
  public Integer getReliquatFranchiseCP()
  {
    return jdoGetm_reliquatFranchiseCP(this);
  }
  
  public final void setReliquatFranchiseCP(Integer p_reliquatFranchiseCP)
  {
    jdoSetm_reliquatFranchiseCP(this, p_reliquatFranchiseCP);
  }
  
  public Integer getSommeReliquatPlafonee()
  {
    return jdoGetm_sommeReliquatPlafonee(this);
  }
  
  public final void setSommeReliquatPlafonee(Integer p_sommeReliquatPlafonee)
  {
    jdoSetm_sommeReliquatPlafonee(this, p_sommeReliquatPlafonee);
  }
  
  public Integer getFranchiseSalaireInit()
  {
    return jdoGetm_franchiseSalaireInit(this);
  }
  
  public final void setFranchiseSalaireInit(Integer p_franchiseSalaireInit)
  {
    jdoSetm_franchiseSalaireInit(this, p_franchiseSalaireInit);
  }
  
  public Integer getFranchiseCPinit()
  {
    return jdoGetm_franchiseCPinit(this);
  }
  
  public final void setFranchiseCPinit(Integer p_franchiseCPinit)
  {
    jdoSetm_franchiseCPinit(this, p_franchiseCPinit);
  }
  
  public BigDecimal getMontantBrutOd()
  {
    return jdoGetm_montantBrutOd(this);
  }
  
  public final void setMontantBrutOd(BigDecimal p_montantBrutOd)
  {
    jdoSetm_montantBrutOd(this, p_montantBrutOd);
  }
  
  static
  {
    JDOImplHelper.registerClass(DroitPbjcNcpPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new DroitPbjcNcpPC());
  }
  
  protected static final int jdoGetm_identOuvertureDroit(DroitPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identOuvertureDroit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_identOuvertureDroit;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 0, m_identOuvertureDroit);
    }
    return m_identOuvertureDroit;
  }
  
  protected static final Damj jdoGetm_dateEffetMaintien(DroitPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateEffetMaintien;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_dateEffetMaintien;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_dateEffetMaintien);
    }
    return m_dateEffetMaintien;
  }
  
  protected static final Damj jdoGetm_dateEffetExclusionDef(DroitPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateEffetExclusionDef;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_dateEffetExclusionDef;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_dateEffetExclusionDef);
    }
    return m_dateEffetExclusionDef;
  }
  
  protected static final Damj jdoGetm_dateFinDeDroit(DroitPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinDeDroit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_dateFinDeDroit;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 3, m_dateFinDeDroit);
    }
    return m_dateFinDeDroit;
  }
  
  protected static final Damj jdoGetm_dateEffetPjiMaintienEESSI(DroitPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateEffetPjiMaintienEESSI;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_dateEffetPjiMaintienEESSI;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 4, m_dateEffetPjiMaintienEESSI);
    }
    return m_dateEffetPjiMaintienEESSI;
  }
  
  protected static final Damj jdoGetm_dateEffetIdeMaintienEESSI(DroitPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateEffetIdeMaintienEESSI;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_dateEffetIdeMaintienEESSI;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 5, m_dateEffetIdeMaintienEESSI);
    }
    return m_dateEffetIdeMaintienEESSI;
  }
  
  protected static final Damj jdoGetm_dateEffetDjiMaintienEESSI(DroitPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateEffetDjiMaintienEESSI;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_dateEffetDjiMaintienEESSI;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 6, m_dateEffetDjiMaintienEESSI);
    }
    return m_dateEffetDjiMaintienEESSI;
  }
  
  protected static final boolean jdoGetm_indicateurMaintienEESSI(DroitPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_indicateurMaintienEESSI;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_indicateurMaintienEESSI;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 7, m_indicateurMaintienEESSI);
    }
    return m_indicateurMaintienEESSI;
  }
  
  private static final BigDecimal jdoGetm_anneeAffectation(DroitPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_anneeAffectation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_anneeAffectation;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 8, m_anneeAffectation);
    }
    return m_anneeAffectation;
  }
  
  protected static final Damj jdoGetm_dateFinCSP(DroitPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinCSP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 9)) {
        return m_dateFinCSP;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 9, m_dateFinCSP);
    }
    return m_dateFinCSP;
  }
  
  private static final Damj jdoGetm_dateDebutDroit(DroitPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebutDroit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 10)) {
        return m_dateDebutDroit;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 10, m_dateDebutDroit);
    }
    return m_dateDebutDroit;
  }
  
  private static final Integer jdoGetm_reliquatFranchiseSalaire(DroitPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reliquatFranchiseSalaire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 11)) {
        return m_reliquatFranchiseSalaire;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 11, m_reliquatFranchiseSalaire);
    }
    return m_reliquatFranchiseSalaire;
  }
  
  private static final BigDecimal jdoGetm_montantPrecompteOd(DroitPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantPrecompteOd;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 12)) {
        return m_montantPrecompteOd;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 12, m_montantPrecompteOd);
    }
    return m_montantPrecompteOd;
  }
  
  private static final Integer jdoGetm_reliquatFranchiseCP(DroitPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reliquatFranchiseCP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 13)) {
        return m_reliquatFranchiseCP;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 13, m_reliquatFranchiseCP);
    }
    return m_reliquatFranchiseCP;
  }
  
  private static final Integer jdoGetm_sommeReliquatPlafonee(DroitPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_sommeReliquatPlafonee;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 14)) {
        return m_sommeReliquatPlafonee;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 14, m_sommeReliquatPlafonee);
    }
    return m_sommeReliquatPlafonee;
  }
  
  private static final Integer jdoGetm_franchiseSalaireInit(DroitPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_franchiseSalaireInit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 15)) {
        return m_franchiseSalaireInit;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 15, m_franchiseSalaireInit);
    }
    return m_franchiseSalaireInit;
  }
  
  private static final Integer jdoGetm_franchiseCPinit(DroitPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_franchiseCPinit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 16)) {
        return m_franchiseCPinit;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 16, m_franchiseCPinit);
    }
    return m_franchiseCPinit;
  }
  
  private static final BigDecimal jdoGetm_montantBrutOd(DroitPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantBrutOd;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 17)) {
        return m_montantBrutOd;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 17, m_montantBrutOd);
    }
    return m_montantBrutOd;
  }
  
  protected static final void jdoSetm_identOuvertureDroit(DroitPbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_identOuvertureDroit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 0, m_identOuvertureDroit, newValue);
    } else {
      m_identOuvertureDroit = newValue;
    }
  }
  
  protected static final void jdoSetm_dateEffetMaintien(DroitPbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateEffetMaintien = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_dateEffetMaintien, newValue);
    } else {
      m_dateEffetMaintien = newValue;
    }
  }
  
  protected static final void jdoSetm_dateEffetExclusionDef(DroitPbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateEffetExclusionDef = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_dateEffetExclusionDef, newValue);
    } else {
      m_dateEffetExclusionDef = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinDeDroit(DroitPbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinDeDroit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 3, m_dateFinDeDroit, newValue);
    } else {
      m_dateFinDeDroit = newValue;
    }
  }
  
  protected static final void jdoSetm_dateEffetPjiMaintienEESSI(DroitPbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateEffetPjiMaintienEESSI = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 4, m_dateEffetPjiMaintienEESSI, newValue);
    } else {
      m_dateEffetPjiMaintienEESSI = newValue;
    }
  }
  
  protected static final void jdoSetm_dateEffetIdeMaintienEESSI(DroitPbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateEffetIdeMaintienEESSI = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 5, m_dateEffetIdeMaintienEESSI, newValue);
    } else {
      m_dateEffetIdeMaintienEESSI = newValue;
    }
  }
  
  protected static final void jdoSetm_dateEffetDjiMaintienEESSI(DroitPbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateEffetDjiMaintienEESSI = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 6, m_dateEffetDjiMaintienEESSI, newValue);
    } else {
      m_dateEffetDjiMaintienEESSI = newValue;
    }
  }
  
  protected static final void jdoSetm_indicateurMaintienEESSI(DroitPbjcNcpPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_indicateurMaintienEESSI = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 7, m_indicateurMaintienEESSI, newValue);
    } else {
      m_indicateurMaintienEESSI = newValue;
    }
  }
  
  private static final void jdoSetm_anneeAffectation(DroitPbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_anneeAffectation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 8, m_anneeAffectation, newValue);
    } else {
      m_anneeAffectation = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinCSP(DroitPbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinCSP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 9, m_dateFinCSP, newValue);
    } else {
      m_dateFinCSP = newValue;
    }
  }
  
  private static final void jdoSetm_dateDebutDroit(DroitPbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebutDroit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 10, m_dateDebutDroit, newValue);
    } else {
      m_dateDebutDroit = newValue;
    }
  }
  
  private static final void jdoSetm_reliquatFranchiseSalaire(DroitPbjcNcpPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_reliquatFranchiseSalaire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 11, m_reliquatFranchiseSalaire, newValue);
    } else {
      m_reliquatFranchiseSalaire = newValue;
    }
  }
  
  private static final void jdoSetm_montantPrecompteOd(DroitPbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantPrecompteOd = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 12, m_montantPrecompteOd, newValue);
    } else {
      m_montantPrecompteOd = newValue;
    }
  }
  
  private static final void jdoSetm_reliquatFranchiseCP(DroitPbjcNcpPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_reliquatFranchiseCP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 13, m_reliquatFranchiseCP, newValue);
    } else {
      m_reliquatFranchiseCP = newValue;
    }
  }
  
  private static final void jdoSetm_sommeReliquatPlafonee(DroitPbjcNcpPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_sommeReliquatPlafonee = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 14, m_sommeReliquatPlafonee, newValue);
    } else {
      m_sommeReliquatPlafonee = newValue;
    }
  }
  
  private static final void jdoSetm_franchiseSalaireInit(DroitPbjcNcpPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_franchiseSalaireInit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 15, m_franchiseSalaireInit, newValue);
    } else {
      m_franchiseSalaireInit = newValue;
    }
  }
  
  private static final void jdoSetm_franchiseCPinit(DroitPbjcNcpPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_franchiseCPinit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 16, m_franchiseCPinit, newValue);
    } else {
      m_franchiseCPinit = newValue;
    }
  }
  
  private static final void jdoSetm_montantBrutOd(DroitPbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantBrutOd = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 17, m_montantBrutOd, newValue);
    } else {
      m_montantBrutOd = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedIntField(this, fieldNumber, m_identOuvertureDroit);
      break;
    case 1: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateEffetMaintien);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateEffetExclusionDef);
      break;
    case 3: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinDeDroit);
      break;
    case 4: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateEffetPjiMaintienEESSI);
      break;
    case 5: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateEffetIdeMaintienEESSI);
      break;
    case 6: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateEffetDjiMaintienEESSI);
      break;
    case 7: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_indicateurMaintienEESSI);
      break;
    case 8: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_anneeAffectation);
      break;
    case 9: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinCSP);
      break;
    case 10: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebutDroit);
      break;
    case 11: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_reliquatFranchiseSalaire);
      break;
    case 12: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantPrecompteOd);
      break;
    case 13: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_reliquatFranchiseCP);
      break;
    case 14: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_sommeReliquatPlafonee);
      break;
    case 15: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_franchiseSalaireInit);
      break;
    case 16: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_franchiseCPinit);
      break;
    case 17: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantBrutOd);
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
      m_identOuvertureDroit = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 1: 
      m_dateEffetMaintien = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_dateEffetExclusionDef = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 3: 
      m_dateFinDeDroit = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 4: 
      m_dateEffetPjiMaintienEESSI = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 5: 
      m_dateEffetIdeMaintienEESSI = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 6: 
      m_dateEffetDjiMaintienEESSI = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 7: 
      m_indicateurMaintienEESSI = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 8: 
      m_anneeAffectation = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 9: 
      m_dateFinCSP = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 10: 
      m_dateDebutDroit = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 11: 
      m_reliquatFranchiseSalaire = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 12: 
      m_montantPrecompteOd = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 13: 
      m_reliquatFranchiseCP = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 14: 
      m_sommeReliquatPlafonee = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 15: 
      m_franchiseSalaireInit = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 16: 
      m_franchiseCPinit = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 17: 
      m_montantBrutOd = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
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
    DroitPbjcNcpPC pc = new DroitPbjcNcpPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    DroitPbjcNcpPC pc = new DroitPbjcNcpPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 18;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof DroitPbjcNcpPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    DroitPbjcNcpPC other = (DroitPbjcNcpPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_identOuvertureDroit = m_identOuvertureDroit;
        break;
      case 1: 
        m_dateEffetMaintien = m_dateEffetMaintien;
        break;
      case 2: 
        m_dateEffetExclusionDef = m_dateEffetExclusionDef;
        break;
      case 3: 
        m_dateFinDeDroit = m_dateFinDeDroit;
        break;
      case 4: 
        m_dateEffetPjiMaintienEESSI = m_dateEffetPjiMaintienEESSI;
        break;
      case 5: 
        m_dateEffetIdeMaintienEESSI = m_dateEffetIdeMaintienEESSI;
        break;
      case 6: 
        m_dateEffetDjiMaintienEESSI = m_dateEffetDjiMaintienEESSI;
        break;
      case 7: 
        m_indicateurMaintienEESSI = m_indicateurMaintienEESSI;
        break;
      case 8: 
        m_anneeAffectation = m_anneeAffectation;
        break;
      case 9: 
        m_dateFinCSP = m_dateFinCSP;
        break;
      case 10: 
        m_dateDebutDroit = m_dateDebutDroit;
        break;
      case 11: 
        m_reliquatFranchiseSalaire = m_reliquatFranchiseSalaire;
        break;
      case 12: 
        m_montantPrecompteOd = m_montantPrecompteOd;
        break;
      case 13: 
        m_reliquatFranchiseCP = m_reliquatFranchiseCP;
        break;
      case 14: 
        m_sommeReliquatPlafonee = m_sommeReliquatPlafonee;
        break;
      case 15: 
        m_franchiseSalaireInit = m_franchiseSalaireInit;
        break;
      case 16: 
        m_franchiseCPinit = m_franchiseCPinit;
        break;
      case 17: 
        m_montantBrutOd = m_montantBrutOd;
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
 * Qualified Name:     DroitPbjcNcpPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */