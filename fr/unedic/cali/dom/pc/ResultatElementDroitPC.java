package fr.unedic.cali.dom.pc;

import fr.unedic.cali.dom.ResultatElementDroit;
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

public class ResultatElementDroitPC
  implements DomPCSpec, PersistenceCapable
{
  private transient ResultatElementDroit m_resultatElementDroitOM;
  protected int m_codeMotifEchec;
  protected int m_etat;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_codeMotifEchec", "m_etat" };
  private static Class[] jdoFieldTypes = { Integer.TYPE, Integer.TYPE };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_resultatElementDroitOM == null) {
      m_resultatElementDroitOM = new ResultatElementDroit(this);
    }
    return m_resultatElementDroitOM;
  }
  
  public int getCodeMotifEchec()
  {
    return jdoGetm_codeMotifEchec(this);
  }
  
  public final void setCodeMotifEchec(int p_codeMotifEchec)
  {
    jdoSetm_codeMotifEchec(this, p_codeMotifEchec);
  }
  
  public int getEtat()
  {
    return jdoGetm_etat(this);
  }
  
  public final void setEtat(int p_etat)
  {
    jdoSetm_etat(this, p_etat);
  }
  
  static
  {
    JDOImplHelper.registerClass(ResultatElementDroitPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new ResultatElementDroitPC());
  }
  
  protected static final int jdoGetm_codeMotifEchec(ResultatElementDroitPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeMotifEchec;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_codeMotifEchec;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 0, m_codeMotifEchec);
    }
    return m_codeMotifEchec;
  }
  
  protected static final int jdoGetm_etat(ResultatElementDroitPC pc)
  {
    if (jdoFlags <= 0) {
      return m_etat;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_etat;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 1, m_etat);
    }
    return m_etat;
  }
  
  protected static final void jdoSetm_codeMotifEchec(ResultatElementDroitPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeMotifEchec = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 0, m_codeMotifEchec, newValue);
    } else {
      m_codeMotifEchec = newValue;
    }
  }
  
  protected static final void jdoSetm_etat(ResultatElementDroitPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_etat = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 1, m_etat, newValue);
    } else {
      m_etat = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedIntField(this, fieldNumber, m_codeMotifEchec);
      break;
    case 1: 
      jdoStateManager.providedIntField(this, fieldNumber, m_etat);
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
      m_codeMotifEchec = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 1: 
      m_etat = jdoStateManager.replacingIntField(this, fieldNumber);
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
    ResultatElementDroitPC pc = new ResultatElementDroitPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    ResultatElementDroitPC pc = new ResultatElementDroitPC();
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
    if (!(pc instanceof ResultatElementDroitPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    ResultatElementDroitPC other = (ResultatElementDroitPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_codeMotifEchec = m_codeMotifEchec;
        break;
      case 1: 
        m_etat = m_etat;
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
 * Qualified Name:     ResultatElementDroitPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */