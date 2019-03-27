package fr.unedic.cali.autresdoms.ga.dom.pc;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.dom.pc.PeriodeActiviteSalarieCaliPC;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.temps.ObjetChronoPeriodePC;
import fr.unedic.util.temps.Periode;
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

public class ActiviteSalariePC
  extends ObjetChronoPeriodePC
  implements DomPCSpec, PersistenceCapable
{
  private transient ActiviteSalarie m_activiteSalarieOM;
  protected String m_identifiant;
  protected PeriodeActiviteSalarieCaliPC m_periodeActiviteSalarieCali;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_periode", "m_identifiant", "m_periodeActiviteSalarieCali" };
  private static Class[] jdoFieldTypes = { Periode.class, String.class, PeriodeActiviteSalarieCaliPC.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  static final long serialVersionUID = 3601178047915574709L;
  
  public Object createOM()
  {
    if (m_activiteSalarieOM == null) {
      m_activiteSalarieOM = new ActiviteSalarie(this);
    }
    return m_activiteSalarieOM;
  }
  
  public String getIdentifiant()
  {
    return jdoGetm_identifiant(this);
  }
  
  public final void setIdentifiant(String p_identifiant)
  {
    jdoSetm_identifiant(this, p_identifiant);
  }
  
  public DomPCSpec getPeriodeActiviteSalarieCali()
  {
    return jdoGetm_periodeActiviteSalarieCali(this);
  }
  
  public final void setPeriodeActiviteSalarieCali(DomPCSpec p_periodeActiviteSalarieCali)
  {
    jdoSetm_periodeActiviteSalarieCali(this, (PeriodeActiviteSalarieCaliPC)p_periodeActiviteSalarieCali);
  }
  
  static
  {
    JDOImplHelper.registerClass(ActiviteSalariePC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new ActiviteSalariePC());
  }
  
  protected static final Periode jdoGetm_periode(ActiviteSalariePC pc)
  {
    if (jdoFlags <= 0) {
      return m_periode;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_periode;
      }
      return (Periode)sm.getObjectField(pc, jdoInheritedFieldCount + 0, m_periode);
    }
    return m_periode;
  }
  
  protected static final String jdoGetm_identifiant(ActiviteSalariePC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_identifiant;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 1, m_identifiant);
    }
    return m_identifiant;
  }
  
  protected static final PeriodeActiviteSalarieCaliPC jdoGetm_periodeActiviteSalarieCali(ActiviteSalariePC pc)
  {
    if (jdoFlags <= 0) {
      return m_periodeActiviteSalarieCali;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_periodeActiviteSalarieCali;
      }
      return (PeriodeActiviteSalarieCaliPC)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_periodeActiviteSalarieCali);
    }
    return m_periodeActiviteSalarieCali;
  }
  
  protected static final void jdoSetm_periode(ActiviteSalariePC pc, Periode newValue)
  {
    if (jdoFlags == 0)
    {
      m_periode = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 0, m_periode, newValue);
    } else {
      m_periode = newValue;
    }
  }
  
  protected static final void jdoSetm_identifiant(ActiviteSalariePC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 1, m_identifiant, newValue);
    } else {
      m_identifiant = newValue;
    }
  }
  
  protected static final void jdoSetm_periodeActiviteSalarieCali(ActiviteSalariePC pc, PeriodeActiviteSalarieCaliPC newValue)
  {
    if (jdoFlags == 0)
    {
      m_periodeActiviteSalarieCali = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_periodeActiviteSalarieCali, newValue);
    } else {
      m_periodeActiviteSalarieCali = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_periode);
      break;
    case 1: 
      jdoStateManager.providedStringField(this, fieldNumber, m_identifiant);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_periodeActiviteSalarieCali);
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
      m_periode = ((Periode)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 1: 
      m_identifiant = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 2: 
      m_periodeActiviteSalarieCali = ((PeriodeActiviteSalarieCaliPC)jdoStateManager.replacingObjectField(this, fieldNumber));
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
    ActiviteSalariePC pc = new ActiviteSalariePC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    ActiviteSalariePC pc = new ActiviteSalariePC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 3;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof ActiviteSalariePC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    ActiviteSalariePC other = (ActiviteSalariePC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_periode = m_periode;
        break;
      case 1: 
        m_identifiant = m_identifiant;
        break;
      case 2: 
        m_periodeActiviteSalarieCali = m_periodeActiviteSalarieCali;
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
 * Qualified Name:     ActiviteSalariePC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */