package fr.unedic.cali.dom.pc;

import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.Quantite;
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

public abstract class MontantBaseAbstraitPC
  implements DomPCSpec, PersistenceCapable
{
  protected Quantite m_montantBrut;
  protected Quantite m_crc;
  protected boolean m_estAvecPrecompte;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_montantBrut", "m_crc", "m_estAvecPrecompte" };
  private static Class[] jdoFieldTypes = { Quantite.class, Quantite.class, Boolean.TYPE };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public abstract Object createOM();
  
  public Quantite getMontantBrut()
  {
    return jdoGetm_montantBrut(this);
  }
  
  public final void setMontantBrut(Quantite p_montantBrut)
  {
    jdoSetm_montantBrut(this, p_montantBrut);
  }
  
  public Quantite getCrc()
  {
    return jdoGetm_crc(this);
  }
  
  public final void setCrc(Quantite p_crc)
  {
    jdoSetm_crc(this, p_crc);
  }
  
  public boolean isEstAvecPrecompte()
  {
    return jdoGetm_estAvecPrecompte(this);
  }
  
  public final void setEstAvecPrecompte(boolean p_estAvecPrecompte)
  {
    jdoSetm_estAvecPrecompte(this, p_estAvecPrecompte);
  }
  
  static
  {
    JDOImplHelper.registerClass(MontantBaseAbstraitPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, null);
  }
  
  protected static final Quantite jdoGetm_montantBrut(MontantBaseAbstraitPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantBrut;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_montantBrut;
      }
      return (Quantite)sm.getObjectField(pc, jdoInheritedFieldCount + 0, m_montantBrut);
    }
    return m_montantBrut;
  }
  
  protected static final Quantite jdoGetm_crc(MontantBaseAbstraitPC pc)
  {
    if (jdoFlags <= 0) {
      return m_crc;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_crc;
      }
      return (Quantite)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_crc);
    }
    return m_crc;
  }
  
  protected static final boolean jdoGetm_estAvecPrecompte(MontantBaseAbstraitPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estAvecPrecompte;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_estAvecPrecompte;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 2, m_estAvecPrecompte);
    }
    return m_estAvecPrecompte;
  }
  
  protected static final void jdoSetm_montantBrut(MontantBaseAbstraitPC pc, Quantite newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantBrut = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 0, m_montantBrut, newValue);
    } else {
      m_montantBrut = newValue;
    }
  }
  
  protected static final void jdoSetm_crc(MontantBaseAbstraitPC pc, Quantite newValue)
  {
    if (jdoFlags == 0)
    {
      m_crc = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_crc, newValue);
    } else {
      m_crc = newValue;
    }
  }
  
  protected static final void jdoSetm_estAvecPrecompte(MontantBaseAbstraitPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_estAvecPrecompte = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 2, m_estAvecPrecompte, newValue);
    } else {
      m_estAvecPrecompte = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantBrut);
      break;
    case 1: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_crc);
      break;
    case 2: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_estAvecPrecompte);
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
      m_montantBrut = ((Quantite)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 1: 
      m_crc = ((Quantite)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_estAvecPrecompte = jdoStateManager.replacingBooleanField(this, fieldNumber);
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
  
  /* Error */
  public PersistenceCapable jdoNewInstance(StateManager sm)
  {
    // Byte code:
    //   0: new 47	javax/jdo/JDOFatalInternalException
    //   3: dup
    //   4: ldc_w 285
    //   7: invokespecial 197	javax/jdo/JDOFatalInternalException:<init>	(Ljava/lang/String;)V
    //   10: athrow
    //   11: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	12	0	this	MontantBaseAbstraitPC
    //   0	12	1	sm	StateManager
  }
  
  /* Error */
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    // Byte code:
    //   0: new 47	javax/jdo/JDOFatalInternalException
    //   3: dup
    //   4: ldc_w 285
    //   7: invokespecial 197	javax/jdo/JDOFatalInternalException:<init>	(Ljava/lang/String;)V
    //   10: athrow
    //   11: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	12	0	this	MontantBaseAbstraitPC
    //   0	12	1	sm	StateManager
    //   0	12	2	oid	Object
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 3;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof MontantBaseAbstraitPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    MontantBaseAbstraitPC other = (MontantBaseAbstraitPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_montantBrut = m_montantBrut;
        break;
      case 1: 
        m_crc = m_crc;
        break;
      case 2: 
        m_estAvecPrecompte = m_estAvecPrecompte;
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
 * Qualified Name:     MontantBaseAbstraitPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */