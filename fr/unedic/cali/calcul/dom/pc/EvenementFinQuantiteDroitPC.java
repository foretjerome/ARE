package fr.unedic.cali.calcul.dom.pc;

import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenementDebutPC;
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

public abstract class EvenementFinQuantiteDroitPC
  extends ObjetChronoEvenementDebutPC
  implements DomPCSpec, PersistenceCapable
{
  protected DomPCSpec m_quantiteDroit;
  private String m_typeQuantiteDroit;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_dateEvenement", "m_quantiteDroit", "m_typeQuantiteDroit" };
  private static Class[] jdoFieldTypes = { Damj.class, DomPCSpec.class, String.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  static final long serialVersionUID = 6803874965513222515L;
  
  public abstract Object createOM();
  
  public DomPCSpec getQuantiteDroit()
  {
    return jdoGetm_quantiteDroit(this);
  }
  
  public final void setQuantiteDroit(DomPCSpec p_quantiteDroit)
  {
    jdoSetm_quantiteDroit(this, p_quantiteDroit);
  }
  
  public String getTypeQuantiteDroit()
  {
    return jdoGetm_typeQuantiteDroit(this);
  }
  
  public final void setTypeQuantiteDroit(String p_typeQuantiteDroit)
  {
    jdoSetm_typeQuantiteDroit(this, p_typeQuantiteDroit);
  }
  
  static
  {
    JDOImplHelper.registerClass(EvenementFinQuantiteDroitPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, null);
  }
  
  protected static final Damj jdoGetm_dateEvenement(EvenementFinQuantiteDroitPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateEvenement;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_dateEvenement;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 0, m_dateEvenement);
    }
    return m_dateEvenement;
  }
  
  protected static final DomPCSpec jdoGetm_quantiteDroit(EvenementFinQuantiteDroitPC pc)
  {
    if (jdoFlags <= 0) {
      return m_quantiteDroit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_quantiteDroit;
      }
      return (DomPCSpec)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_quantiteDroit);
    }
    return m_quantiteDroit;
  }
  
  private static final String jdoGetm_typeQuantiteDroit(EvenementFinQuantiteDroitPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeQuantiteDroit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_typeQuantiteDroit;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 2, m_typeQuantiteDroit);
    }
    return m_typeQuantiteDroit;
  }
  
  protected static final void jdoSetm_dateEvenement(EvenementFinQuantiteDroitPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateEvenement = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 0, m_dateEvenement, newValue);
    } else {
      m_dateEvenement = newValue;
    }
  }
  
  protected static final void jdoSetm_quantiteDroit(EvenementFinQuantiteDroitPC pc, DomPCSpec newValue)
  {
    if (jdoFlags == 0)
    {
      m_quantiteDroit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_quantiteDroit, newValue);
    } else {
      m_quantiteDroit = newValue;
    }
  }
  
  private static final void jdoSetm_typeQuantiteDroit(EvenementFinQuantiteDroitPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeQuantiteDroit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 2, m_typeQuantiteDroit, newValue);
    } else {
      m_typeQuantiteDroit = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateEvenement);
      break;
    case 1: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_quantiteDroit);
      break;
    case 2: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeQuantiteDroit);
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
      m_dateEvenement = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 1: 
      m_quantiteDroit = ((DomPCSpec)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_typeQuantiteDroit = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
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
    //   0: new 41	javax/jdo/JDOFatalInternalException
    //   3: dup
    //   4: ldc_w 289
    //   7: invokespecial 199	javax/jdo/JDOFatalInternalException:<init>	(Ljava/lang/String;)V
    //   10: athrow
    //   11: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	12	0	this	EvenementFinQuantiteDroitPC
    //   0	12	1	sm	StateManager
  }
  
  /* Error */
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    // Byte code:
    //   0: new 41	javax/jdo/JDOFatalInternalException
    //   3: dup
    //   4: ldc_w 289
    //   7: invokespecial 199	javax/jdo/JDOFatalInternalException:<init>	(Ljava/lang/String;)V
    //   10: athrow
    //   11: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	12	0	this	EvenementFinQuantiteDroitPC
    //   0	12	1	sm	StateManager
    //   0	12	2	oid	Object
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 3;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof EvenementFinQuantiteDroitPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    EvenementFinQuantiteDroitPC other = (EvenementFinQuantiteDroitPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_dateEvenement = m_dateEvenement;
        break;
      case 1: 
        m_quantiteDroit = m_quantiteDroit;
        break;
      case 2: 
        m_typeQuantiteDroit = m_typeQuantiteDroit;
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
 * Qualified Name:     EvenementFinQuantiteDroitPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */