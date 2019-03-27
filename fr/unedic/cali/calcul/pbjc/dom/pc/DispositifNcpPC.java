package fr.unedic.cali.calcul.pbjc.dom.pc;

import fr.unedic.cali.calcul.pbjc.dom.DispositifNcp;
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

public class DispositifNcpPC
  implements DomPCSpec, PersistenceCapable
{
  private transient DispositifNcp m_dispositifNcpOM;
  private Damj m_dateDebutDispositif;
  private Damj m_dateFinDispositifAvant;
  private Damj m_dateFinDispositifApres;
  private String m_idTracker;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_dateDebutDispositif", "m_dateFinDispositifAvant", "m_dateFinDispositifApres", "m_idTracker" };
  private static Class[] jdoFieldTypes = { Damj.class, Damj.class, Damj.class, String.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_dispositifNcpOM == null) {
      m_dispositifNcpOM = new DispositifNcp(this);
    }
    return m_dispositifNcpOM;
  }
  
  public Damj getDateDebutDispositif()
  {
    return jdoGetm_dateDebutDispositif(this);
  }
  
  public final void setDateDebutDispositif(Damj p_dateDebutDispositif)
  {
    jdoSetm_dateDebutDispositif(this, p_dateDebutDispositif);
  }
  
  public Damj getDateFinDispositifAvant()
  {
    return jdoGetm_dateFinDispositifAvant(this);
  }
  
  public final void setDateFinDispositifAvant(Damj p_dateFinDispositifAvant)
  {
    jdoSetm_dateFinDispositifAvant(this, p_dateFinDispositifAvant);
  }
  
  public Damj getDateFinDispositifApres()
  {
    return jdoGetm_dateFinDispositifApres(this);
  }
  
  public final void setDateFinDispositifApres(Damj p_dateFinDispositifApres)
  {
    jdoSetm_dateFinDispositifApres(this, p_dateFinDispositifApres);
  }
  
  public String getIdTracker()
  {
    return jdoGetm_idTracker(this);
  }
  
  public final void setIdTracker(String p_idTracker)
  {
    jdoSetm_idTracker(this, p_idTracker);
  }
  
  static
  {
    JDOImplHelper.registerClass(DispositifNcpPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new DispositifNcpPC());
  }
  
  private static final Damj jdoGetm_dateDebutDispositif(DispositifNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebutDispositif;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_dateDebutDispositif;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 0, m_dateDebutDispositif);
    }
    return m_dateDebutDispositif;
  }
  
  private static final Damj jdoGetm_dateFinDispositifAvant(DispositifNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinDispositifAvant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_dateFinDispositifAvant;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_dateFinDispositifAvant);
    }
    return m_dateFinDispositifAvant;
  }
  
  private static final Damj jdoGetm_dateFinDispositifApres(DispositifNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinDispositifApres;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_dateFinDispositifApres;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_dateFinDispositifApres);
    }
    return m_dateFinDispositifApres;
  }
  
  private static final String jdoGetm_idTracker(DispositifNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_idTracker;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_idTracker;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 3, m_idTracker);
    }
    return m_idTracker;
  }
  
  private static final void jdoSetm_dateDebutDispositif(DispositifNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebutDispositif = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 0, m_dateDebutDispositif, newValue);
    } else {
      m_dateDebutDispositif = newValue;
    }
  }
  
  private static final void jdoSetm_dateFinDispositifAvant(DispositifNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinDispositifAvant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_dateFinDispositifAvant, newValue);
    } else {
      m_dateFinDispositifAvant = newValue;
    }
  }
  
  private static final void jdoSetm_dateFinDispositifApres(DispositifNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinDispositifApres = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_dateFinDispositifApres, newValue);
    } else {
      m_dateFinDispositifApres = newValue;
    }
  }
  
  private static final void jdoSetm_idTracker(DispositifNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_idTracker = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 3, m_idTracker, newValue);
    } else {
      m_idTracker = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebutDispositif);
      break;
    case 1: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinDispositifAvant);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinDispositifApres);
      break;
    case 3: 
      jdoStateManager.providedStringField(this, fieldNumber, m_idTracker);
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
      m_dateDebutDispositif = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 1: 
      m_dateFinDispositifAvant = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_dateFinDispositifApres = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 3: 
      m_idTracker = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
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
    DispositifNcpPC pc = new DispositifNcpPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    DispositifNcpPC pc = new DispositifNcpPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 4;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof DispositifNcpPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    DispositifNcpPC other = (DispositifNcpPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_dateDebutDispositif = m_dateDebutDispositif;
        break;
      case 1: 
        m_dateFinDispositifAvant = m_dateFinDispositifAvant;
        break;
      case 2: 
        m_dateFinDispositifApres = m_dateFinDispositifApres;
        break;
      case 3: 
        m_idTracker = m_idTracker;
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
 * Qualified Name:     DispositifNcpPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */