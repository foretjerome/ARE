package fr.unedic.cali.dom.pc;

import fr.unedic.cali.dom.ActionFormationLiee;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;
import java.io.IOException;
import java.io.ObjectOutputStream;
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

public class ActionFormationLieePC
  implements DomPCSpec, PersistenceCapable
{
  private transient ActionFormationLiee m_actionFormationLieeOM;
  protected Damj m_dateDebut;
  protected Damj m_dateFin;
  protected Damj m_dateDebutPeriodeFormation;
  protected Damj m_datePrescription;
  protected String m_numeroConvention;
  protected int m_typeConvention;
  protected String m_statutFormation;
  protected int m_typePopulationRsa;
  protected String m_identifiantConvention;
  protected String m_affDerogatoire;
  protected String m_typePlanFormation;
  protected Quantite m_quantiteHebdomadaire;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_dateDebut", "m_dateFin", "m_dateDebutPeriodeFormation", "m_datePrescription", "m_numeroConvention", "m_typeConvention", "m_statutFormation", "m_typePopulationRsa", "m_identifiantConvention", "m_affDerogatoire", "m_typePlanFormation", "m_quantiteHebdomadaire" };
  private static Class[] jdoFieldTypes = { Damj.class, Damj.class, Damj.class, Damj.class, String.class, Integer.TYPE, String.class, Integer.TYPE, String.class, String.class, String.class, Quantite.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_actionFormationLieeOM == null) {
      m_actionFormationLieeOM = new ActionFormationLiee(this);
    }
    return m_actionFormationLieeOM;
  }
  
  public Damj getDateDebut()
  {
    return jdoGetm_dateDebut(this);
  }
  
  public final void setDateDebut(Damj p_dateDebut)
  {
    jdoSetm_dateDebut(this, p_dateDebut);
  }
  
  public Damj getDateFin()
  {
    return jdoGetm_dateFin(this);
  }
  
  public final void setDateFin(Damj p_dateFin)
  {
    jdoSetm_dateFin(this, p_dateFin);
  }
  
  public Damj getDateDebutPeriodeFormation()
  {
    return jdoGetm_dateDebutPeriodeFormation(this);
  }
  
  public final void setDateDebutPeriodeFormation(Damj p_dateDebutPeriodeFormation)
  {
    jdoSetm_dateDebutPeriodeFormation(this, p_dateDebutPeriodeFormation);
  }
  
  public Damj getDatePrescription()
  {
    return jdoGetm_datePrescription(this);
  }
  
  public final void setDatePrescription(Damj p_datePrescription)
  {
    jdoSetm_datePrescription(this, p_datePrescription);
  }
  
  public String getNumeroConvention()
  {
    return jdoGetm_numeroConvention(this);
  }
  
  public final void setNumeroConvention(String p_numeroConvention)
  {
    jdoSetm_numeroConvention(this, p_numeroConvention);
  }
  
  public int getTypeConvention()
  {
    return jdoGetm_typeConvention(this);
  }
  
  public final void setTypeConvention(int p_typeConvention)
  {
    jdoSetm_typeConvention(this, p_typeConvention);
  }
  
  public String getStatutFormation()
  {
    return jdoGetm_statutFormation(this);
  }
  
  public final void setStatutFormation(String p_statutFormation)
  {
    jdoSetm_statutFormation(this, p_statutFormation);
  }
  
  public int getTypePopulationRsa()
  {
    return jdoGetm_typePopulationRsa(this);
  }
  
  public final void setTypePopulationRsa(int p_typePopulationRsa)
  {
    jdoSetm_typePopulationRsa(this, p_typePopulationRsa);
  }
  
  public String getIdentifiantConvention()
  {
    return jdoGetm_identifiantConvention(this);
  }
  
  public final void setIdentifiantConvention(String p_identifiantConvention)
  {
    jdoSetm_identifiantConvention(this, p_identifiantConvention);
  }
  
  public String getAffDerogatoire()
  {
    return jdoGetm_affDerogatoire(this);
  }
  
  public final void setAffDerogatoire(String p_affDerogatoire)
  {
    jdoSetm_affDerogatoire(this, p_affDerogatoire);
  }
  
  public String getTypePlanFormation()
  {
    return jdoGetm_typePlanFormation(this);
  }
  
  public final void setTypePlanFormation(String p_typePlanFormation)
  {
    jdoSetm_typePlanFormation(this, p_typePlanFormation);
  }
  
  public Quantite getQuantiteHebdomadaire()
  {
    return jdoGetm_quantiteHebdomadaire(this);
  }
  
  public final void setQuantiteHebdomadaire(Quantite p_quantiteHebdomadaire)
  {
    jdoSetm_quantiteHebdomadaire(this, p_quantiteHebdomadaire);
  }
  
  static
  {
    JDOImplHelper.registerClass(ActionFormationLieePC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new ActionFormationLieePC());
  }
  
  protected static final Damj jdoGetm_dateDebut(ActionFormationLieePC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebut;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_dateDebut;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 0, m_dateDebut);
    }
    return m_dateDebut;
  }
  
  protected static final Damj jdoGetm_dateFin(ActionFormationLieePC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFin;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_dateFin;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_dateFin);
    }
    return m_dateFin;
  }
  
  protected static final Damj jdoGetm_dateDebutPeriodeFormation(ActionFormationLieePC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebutPeriodeFormation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_dateDebutPeriodeFormation;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_dateDebutPeriodeFormation);
    }
    return m_dateDebutPeriodeFormation;
  }
  
  protected static final Damj jdoGetm_datePrescription(ActionFormationLieePC pc)
  {
    if (jdoFlags <= 0) {
      return m_datePrescription;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_datePrescription;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 3, m_datePrescription);
    }
    return m_datePrescription;
  }
  
  protected static final String jdoGetm_numeroConvention(ActionFormationLieePC pc)
  {
    if (jdoFlags <= 0) {
      return m_numeroConvention;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_numeroConvention;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 4, m_numeroConvention);
    }
    return m_numeroConvention;
  }
  
  protected static final int jdoGetm_typeConvention(ActionFormationLieePC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeConvention;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_typeConvention;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 5, m_typeConvention);
    }
    return m_typeConvention;
  }
  
  protected static final String jdoGetm_statutFormation(ActionFormationLieePC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutFormation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_statutFormation;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 6, m_statutFormation);
    }
    return m_statutFormation;
  }
  
  protected static final int jdoGetm_typePopulationRsa(ActionFormationLieePC pc)
  {
    if (jdoFlags <= 0) {
      return m_typePopulationRsa;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_typePopulationRsa;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 7, m_typePopulationRsa);
    }
    return m_typePopulationRsa;
  }
  
  protected static final String jdoGetm_identifiantConvention(ActionFormationLieePC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantConvention;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_identifiantConvention;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 8, m_identifiantConvention);
    }
    return m_identifiantConvention;
  }
  
  protected static final String jdoGetm_affDerogatoire(ActionFormationLieePC pc)
  {
    if (jdoFlags <= 0) {
      return m_affDerogatoire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 9)) {
        return m_affDerogatoire;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 9, m_affDerogatoire);
    }
    return m_affDerogatoire;
  }
  
  protected static final String jdoGetm_typePlanFormation(ActionFormationLieePC pc)
  {
    if (jdoFlags <= 0) {
      return m_typePlanFormation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 10)) {
        return m_typePlanFormation;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 10, m_typePlanFormation);
    }
    return m_typePlanFormation;
  }
  
  protected static final Quantite jdoGetm_quantiteHebdomadaire(ActionFormationLieePC pc)
  {
    if (jdoFlags <= 0) {
      return m_quantiteHebdomadaire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 11)) {
        return m_quantiteHebdomadaire;
      }
      return (Quantite)sm.getObjectField(pc, jdoInheritedFieldCount + 11, m_quantiteHebdomadaire);
    }
    return m_quantiteHebdomadaire;
  }
  
  protected static final void jdoSetm_dateDebut(ActionFormationLieePC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebut = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 0, m_dateDebut, newValue);
    } else {
      m_dateDebut = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFin(ActionFormationLieePC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFin = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_dateFin, newValue);
    } else {
      m_dateFin = newValue;
    }
  }
  
  protected static final void jdoSetm_dateDebutPeriodeFormation(ActionFormationLieePC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebutPeriodeFormation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_dateDebutPeriodeFormation, newValue);
    } else {
      m_dateDebutPeriodeFormation = newValue;
    }
  }
  
  protected static final void jdoSetm_datePrescription(ActionFormationLieePC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_datePrescription = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 3, m_datePrescription, newValue);
    } else {
      m_datePrescription = newValue;
    }
  }
  
  protected static final void jdoSetm_numeroConvention(ActionFormationLieePC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_numeroConvention = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 4, m_numeroConvention, newValue);
    } else {
      m_numeroConvention = newValue;
    }
  }
  
  protected static final void jdoSetm_typeConvention(ActionFormationLieePC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeConvention = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 5, m_typeConvention, newValue);
    } else {
      m_typeConvention = newValue;
    }
  }
  
  protected static final void jdoSetm_statutFormation(ActionFormationLieePC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutFormation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 6, m_statutFormation, newValue);
    } else {
      m_statutFormation = newValue;
    }
  }
  
  protected static final void jdoSetm_typePopulationRsa(ActionFormationLieePC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_typePopulationRsa = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 7, m_typePopulationRsa, newValue);
    } else {
      m_typePopulationRsa = newValue;
    }
  }
  
  protected static final void jdoSetm_identifiantConvention(ActionFormationLieePC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantConvention = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 8, m_identifiantConvention, newValue);
    } else {
      m_identifiantConvention = newValue;
    }
  }
  
  protected static final void jdoSetm_affDerogatoire(ActionFormationLieePC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_affDerogatoire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 9, m_affDerogatoire, newValue);
    } else {
      m_affDerogatoire = newValue;
    }
  }
  
  protected static final void jdoSetm_typePlanFormation(ActionFormationLieePC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typePlanFormation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 10, m_typePlanFormation, newValue);
    } else {
      m_typePlanFormation = newValue;
    }
  }
  
  protected static final void jdoSetm_quantiteHebdomadaire(ActionFormationLieePC pc, Quantite newValue)
  {
    if (jdoFlags == 0)
    {
      m_quantiteHebdomadaire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 11, m_quantiteHebdomadaire, newValue);
    } else {
      m_quantiteHebdomadaire = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebut);
      break;
    case 1: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFin);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebutPeriodeFormation);
      break;
    case 3: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_datePrescription);
      break;
    case 4: 
      jdoStateManager.providedStringField(this, fieldNumber, m_numeroConvention);
      break;
    case 5: 
      jdoStateManager.providedIntField(this, fieldNumber, m_typeConvention);
      break;
    case 6: 
      jdoStateManager.providedStringField(this, fieldNumber, m_statutFormation);
      break;
    case 7: 
      jdoStateManager.providedIntField(this, fieldNumber, m_typePopulationRsa);
      break;
    case 8: 
      jdoStateManager.providedStringField(this, fieldNumber, m_identifiantConvention);
      break;
    case 9: 
      jdoStateManager.providedStringField(this, fieldNumber, m_affDerogatoire);
      break;
    case 10: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typePlanFormation);
      break;
    case 11: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_quantiteHebdomadaire);
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
      m_dateDebut = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 1: 
      m_dateFin = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_dateDebutPeriodeFormation = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 3: 
      m_datePrescription = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 4: 
      m_numeroConvention = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 5: 
      m_typeConvention = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 6: 
      m_statutFormation = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 7: 
      m_typePopulationRsa = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 8: 
      m_identifiantConvention = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 9: 
      m_affDerogatoire = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 10: 
      m_typePlanFormation = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 11: 
      m_quantiteHebdomadaire = ((Quantite)jdoStateManager.replacingObjectField(this, fieldNumber));
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
    ActionFormationLieePC pc = new ActionFormationLieePC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    ActionFormationLieePC pc = new ActionFormationLieePC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 12;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof ActionFormationLieePC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    ActionFormationLieePC other = (ActionFormationLieePC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_dateDebut = m_dateDebut;
        break;
      case 1: 
        m_dateFin = m_dateFin;
        break;
      case 2: 
        m_dateDebutPeriodeFormation = m_dateDebutPeriodeFormation;
        break;
      case 3: 
        m_datePrescription = m_datePrescription;
        break;
      case 4: 
        m_numeroConvention = m_numeroConvention;
        break;
      case 5: 
        m_typeConvention = m_typeConvention;
        break;
      case 6: 
        m_statutFormation = m_statutFormation;
        break;
      case 7: 
        m_typePopulationRsa = m_typePopulationRsa;
        break;
      case 8: 
        m_identifiantConvention = m_identifiantConvention;
        break;
      case 9: 
        m_affDerogatoire = m_affDerogatoire;
        break;
      case 10: 
        m_typePlanFormation = m_typePlanFormation;
        break;
      case 11: 
        m_quantiteHebdomadaire = m_quantiteHebdomadaire;
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
 * Qualified Name:     ActionFormationLieePC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */