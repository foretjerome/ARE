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

public abstract class DureeIndemnisationAbstraitePC
  extends QuantiteDroitPC
  implements DomPCSpec, PersistenceCapable
{
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_etat", "m_quantiteCourante", "m_quantiteInitial" };
  private static Class[] jdoFieldTypes = { Integer.TYPE, Quantite.class, Quantite.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public abstract Object createOM();
  
  static
  {
    JDOImplHelper.registerClass(DureeIndemnisationAbstraitePC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, null);
  }
  
  protected static final int jdoGetm_etat(DureeIndemnisationAbstraitePC pc)
  {
    if (jdoFlags <= 0) {
      return m_etat;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_etat;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 0, m_etat);
    }
    return m_etat;
  }
  
  protected static final Quantite jdoGetm_quantiteCourante(DureeIndemnisationAbstraitePC pc)
  {
    if (jdoFlags <= 0) {
      return m_quantiteCourante;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_quantiteCourante;
      }
      return (Quantite)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_quantiteCourante);
    }
    return m_quantiteCourante;
  }
  
  protected static final Quantite jdoGetm_quantiteInitial(DureeIndemnisationAbstraitePC pc)
  {
    if (jdoFlags <= 0) {
      return m_quantiteInitial;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_quantiteInitial;
      }
      return (Quantite)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_quantiteInitial);
    }
    return m_quantiteInitial;
  }
  
  protected static final void jdoSetm_etat(DureeIndemnisationAbstraitePC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_etat = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 0, m_etat, newValue);
    } else {
      m_etat = newValue;
    }
  }
  
  protected static final void jdoSetm_quantiteCourante(DureeIndemnisationAbstraitePC pc, Quantite newValue)
  {
    if (jdoFlags == 0)
    {
      m_quantiteCourante = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_quantiteCourante, newValue);
    } else {
      m_quantiteCourante = newValue;
    }
  }
  
  protected static final void jdoSetm_quantiteInitial(DureeIndemnisationAbstraitePC pc, Quantite newValue)
  {
    if (jdoFlags == 0)
    {
      m_quantiteInitial = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_quantiteInitial, newValue);
    } else {
      m_quantiteInitial = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedIntField(this, fieldNumber, m_etat);
      break;
    case 1: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_quantiteCourante);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_quantiteInitial);
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
      m_etat = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 1: 
      m_quantiteCourante = ((Quantite)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_quantiteInitial = ((Quantite)jdoStateManager.replacingObjectField(this, fieldNumber));
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
    //   0: new 23	javax/jdo/JDOFatalInternalException
    //   3: dup
    //   4: ldc_w 261
    //   7: invokespecial 171	javax/jdo/JDOFatalInternalException:<init>	(Ljava/lang/String;)V
    //   10: athrow
    //   11: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	12	0	this	DureeIndemnisationAbstraitePC
    //   0	12	1	sm	StateManager
  }
  
  /* Error */
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    // Byte code:
    //   0: new 23	javax/jdo/JDOFatalInternalException
    //   3: dup
    //   4: ldc_w 261
    //   7: invokespecial 171	javax/jdo/JDOFatalInternalException:<init>	(Ljava/lang/String;)V
    //   10: athrow
    //   11: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	12	0	this	DureeIndemnisationAbstraitePC
    //   0	12	1	sm	StateManager
    //   0	12	2	oid	Object
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 3;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof DureeIndemnisationAbstraitePC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    DureeIndemnisationAbstraitePC other = (DureeIndemnisationAbstraitePC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_etat = m_etat;
        break;
      case 1: 
        m_quantiteCourante = m_quantiteCourante;
        break;
      case 2: 
        m_quantiteInitial = m_quantiteInitial;
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
 * Qualified Name:     DureeIndemnisationAbstraitePC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */