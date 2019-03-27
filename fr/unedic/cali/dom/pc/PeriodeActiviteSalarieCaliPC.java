package fr.unedic.cali.dom.pc;

import fr.unedic.cali.dom.PeriodeActiviteSalarieCali;
import fr.unedic.transverse.dom.spec.DomPCSpec;
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

public class PeriodeActiviteSalarieCaliPC
  implements DomPCSpec, PersistenceCapable
{
  private transient PeriodeActiviteSalarieCali m_periodeActiviteSalarieCaliOM;
  protected boolean m_estLiquidable;
  protected boolean m_estFctPrincipale;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_estLiquidable", "m_estFctPrincipale" };
  private static Class[] jdoFieldTypes = { Boolean.TYPE, Boolean.TYPE };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public PeriodeActiviteSalarieCaliPC()
  {
    jdoSetm_estLiquidable(this, true);
    jdoSetm_estFctPrincipale(this, false);
  }
  
  public Object createOM()
  {
    if (m_periodeActiviteSalarieCaliOM == null) {
      m_periodeActiviteSalarieCaliOM = new PeriodeActiviteSalarieCali(this);
    }
    return m_periodeActiviteSalarieCaliOM;
  }
  
  public boolean isEstLiquidable()
  {
    return jdoGetm_estLiquidable(this);
  }
  
  public final void setEstLiquidable(boolean p_estLiquidable)
  {
    jdoSetm_estLiquidable(this, p_estLiquidable);
  }
  
  public boolean isEstFctPrincipale()
  {
    return jdoGetm_estFctPrincipale(this);
  }
  
  public final void setEstFctPrincipale(boolean p_estFctPrincipale)
  {
    jdoSetm_estFctPrincipale(this, p_estFctPrincipale);
  }
  
  static
  {
    JDOImplHelper.registerClass(PeriodeActiviteSalarieCaliPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new PeriodeActiviteSalarieCaliPC());
  }
  
  protected static final boolean jdoGetm_estLiquidable(PeriodeActiviteSalarieCaliPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estLiquidable;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_estLiquidable;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 0, m_estLiquidable);
    }
    return m_estLiquidable;
  }
  
  protected static final boolean jdoGetm_estFctPrincipale(PeriodeActiviteSalarieCaliPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estFctPrincipale;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_estFctPrincipale;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 1, m_estFctPrincipale);
    }
    return m_estFctPrincipale;
  }
  
  protected static final void jdoSetm_estLiquidable(PeriodeActiviteSalarieCaliPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_estLiquidable = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 0, m_estLiquidable, newValue);
    } else {
      m_estLiquidable = newValue;
    }
  }
  
  protected static final void jdoSetm_estFctPrincipale(PeriodeActiviteSalarieCaliPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_estFctPrincipale = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 1, m_estFctPrincipale, newValue);
    } else {
      m_estFctPrincipale = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_estLiquidable);
      break;
    case 1: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_estFctPrincipale);
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
      m_estLiquidable = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 1: 
      m_estFctPrincipale = jdoStateManager.replacingBooleanField(this, fieldNumber);
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
    PeriodeActiviteSalarieCaliPC pc = new PeriodeActiviteSalarieCaliPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    PeriodeActiviteSalarieCaliPC pc = new PeriodeActiviteSalarieCaliPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 2;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof PeriodeActiviteSalarieCaliPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    PeriodeActiviteSalarieCaliPC other = (PeriodeActiviteSalarieCaliPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_estLiquidable = m_estLiquidable;
        break;
      case 1: 
        m_estFctPrincipale = m_estFctPrincipale;
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
 * Qualified Name:     PeriodeActiviteSalarieCaliPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */