package fr.unedic.cali.dom.pc;

import fr.unedic.cali.dom.ContexteDemande;
import fr.unedic.transverse.dom.spec.DomPCSpec;
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

public class ContexteDemandePC
  implements DomPCSpec, PersistenceCapable
{
  private transient ContexteDemande m_contexteDemandeOM;
  private String m_typeContexteDemande;
  private String m_sousTypeContexteDemande;
  private Damj m_dateFinJustifContexte;
  private Damj m_dateDebutJustifContexte;
  private String m_identifiantPeriodeCaliJustifContexte;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_typeContexteDemande", "m_sousTypeContexteDemande", "m_dateFinJustifContexte", "m_dateDebutJustifContexte", "m_identifiantPeriodeCaliJustifContexte" };
  private static Class[] jdoFieldTypes = { String.class, String.class, Damj.class, Damj.class, String.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_contexteDemandeOM == null) {
      m_contexteDemandeOM = new ContexteDemande(this);
    }
    return m_contexteDemandeOM;
  }
  
  public String getTypeContexteDemande()
  {
    return jdoGetm_typeContexteDemande(this);
  }
  
  public final void setTypeContexteDemande(String p_typeContexteDemande)
  {
    jdoSetm_typeContexteDemande(this, p_typeContexteDemande);
  }
  
  public String getSousTypeContexteDemande()
  {
    return jdoGetm_sousTypeContexteDemande(this);
  }
  
  public final void setSousTypeContexteDemande(String p_sousTypeContexteDemande)
  {
    jdoSetm_sousTypeContexteDemande(this, p_sousTypeContexteDemande);
  }
  
  public Damj getDateFinJustifContexte()
  {
    return jdoGetm_dateFinJustifContexte(this);
  }
  
  public final void setDateFinJustifContexte(Damj p_dateFinJustifContexte)
  {
    jdoSetm_dateFinJustifContexte(this, p_dateFinJustifContexte);
  }
  
  public Damj getDateDebutJustifContexte()
  {
    return jdoGetm_dateDebutJustifContexte(this);
  }
  
  public final void setDateDebutJustifContexte(Damj p_dateDebutJustifContexte)
  {
    jdoSetm_dateDebutJustifContexte(this, p_dateDebutJustifContexte);
  }
  
  public String getIdentifiantPeriodeCaliJustifContexte()
  {
    return jdoGetm_identifiantPeriodeCaliJustifContexte(this);
  }
  
  public final void setIdentifiantPeriodeCaliJustifContexte(String p_identifiantPeriodeCaliJustifContexte)
  {
    jdoSetm_identifiantPeriodeCaliJustifContexte(this, p_identifiantPeriodeCaliJustifContexte);
  }
  
  static
  {
    JDOImplHelper.registerClass(ContexteDemandePC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new ContexteDemandePC());
  }
  
  private static final String jdoGetm_typeContexteDemande(ContexteDemandePC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeContexteDemande;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_typeContexteDemande;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 0, m_typeContexteDemande);
    }
    return m_typeContexteDemande;
  }
  
  private static final String jdoGetm_sousTypeContexteDemande(ContexteDemandePC pc)
  {
    if (jdoFlags <= 0) {
      return m_sousTypeContexteDemande;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_sousTypeContexteDemande;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 1, m_sousTypeContexteDemande);
    }
    return m_sousTypeContexteDemande;
  }
  
  private static final Damj jdoGetm_dateFinJustifContexte(ContexteDemandePC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinJustifContexte;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_dateFinJustifContexte;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_dateFinJustifContexte);
    }
    return m_dateFinJustifContexte;
  }
  
  private static final Damj jdoGetm_dateDebutJustifContexte(ContexteDemandePC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebutJustifContexte;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_dateDebutJustifContexte;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 3, m_dateDebutJustifContexte);
    }
    return m_dateDebutJustifContexte;
  }
  
  private static final String jdoGetm_identifiantPeriodeCaliJustifContexte(ContexteDemandePC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantPeriodeCaliJustifContexte;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_identifiantPeriodeCaliJustifContexte;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 4, m_identifiantPeriodeCaliJustifContexte);
    }
    return m_identifiantPeriodeCaliJustifContexte;
  }
  
  private static final void jdoSetm_typeContexteDemande(ContexteDemandePC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeContexteDemande = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 0, m_typeContexteDemande, newValue);
    } else {
      m_typeContexteDemande = newValue;
    }
  }
  
  private static final void jdoSetm_sousTypeContexteDemande(ContexteDemandePC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_sousTypeContexteDemande = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 1, m_sousTypeContexteDemande, newValue);
    } else {
      m_sousTypeContexteDemande = newValue;
    }
  }
  
  private static final void jdoSetm_dateFinJustifContexte(ContexteDemandePC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinJustifContexte = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_dateFinJustifContexte, newValue);
    } else {
      m_dateFinJustifContexte = newValue;
    }
  }
  
  private static final void jdoSetm_dateDebutJustifContexte(ContexteDemandePC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebutJustifContexte = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 3, m_dateDebutJustifContexte, newValue);
    } else {
      m_dateDebutJustifContexte = newValue;
    }
  }
  
  private static final void jdoSetm_identifiantPeriodeCaliJustifContexte(ContexteDemandePC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantPeriodeCaliJustifContexte = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 4, m_identifiantPeriodeCaliJustifContexte, newValue);
    } else {
      m_identifiantPeriodeCaliJustifContexte = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeContexteDemande);
      break;
    case 1: 
      jdoStateManager.providedStringField(this, fieldNumber, m_sousTypeContexteDemande);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinJustifContexte);
      break;
    case 3: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebutJustifContexte);
      break;
    case 4: 
      jdoStateManager.providedStringField(this, fieldNumber, m_identifiantPeriodeCaliJustifContexte);
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
      m_typeContexteDemande = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 1: 
      m_sousTypeContexteDemande = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 2: 
      m_dateFinJustifContexte = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 3: 
      m_dateDebutJustifContexte = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 4: 
      m_identifiantPeriodeCaliJustifContexte = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
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
    ContexteDemandePC pc = new ContexteDemandePC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    ContexteDemandePC pc = new ContexteDemandePC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 5;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof ContexteDemandePC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    ContexteDemandePC other = (ContexteDemandePC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_typeContexteDemande = m_typeContexteDemande;
        break;
      case 1: 
        m_sousTypeContexteDemande = m_sousTypeContexteDemande;
        break;
      case 2: 
        m_dateFinJustifContexte = m_dateFinJustifContexte;
        break;
      case 3: 
        m_dateDebutJustifContexte = m_dateDebutJustifContexte;
        break;
      case 4: 
        m_identifiantPeriodeCaliJustifContexte = m_identifiantPeriodeCaliJustifContexte;
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
 * Qualified Name:     ContexteDemandePC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */