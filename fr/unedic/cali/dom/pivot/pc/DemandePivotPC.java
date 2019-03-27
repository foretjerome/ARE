package fr.unedic.cali.dom.pivot.pc;

import fr.unedic.cali.dom.pivot.DemandePivot;
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

public class DemandePivotPC
  implements DomPCSpec, PersistenceCapable
{
  private transient DemandePivot m_demandePivotOM;
  protected AttributionPC m_attribution;
  protected DecisionPC m_decision;
  protected AidesPC m_aides;
  protected AidesNcpPC m_aidesNcp;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_attribution", "m_decision", "m_aides", "m_aidesNcp" };
  private static Class[] jdoFieldTypes = { AttributionPC.class, DecisionPC.class, AidesPC.class, AidesNcpPC.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_demandePivotOM == null) {
      m_demandePivotOM = new DemandePivot(this);
    }
    return m_demandePivotOM;
  }
  
  public DomPCSpec getAttribution()
  {
    return jdoGetm_attribution(this);
  }
  
  public final void setAttribution(DomPCSpec p_attribution)
  {
    jdoSetm_attribution(this, (AttributionPC)p_attribution);
  }
  
  public DomPCSpec getDecision()
  {
    return jdoGetm_decision(this);
  }
  
  public final void setDecision(DomPCSpec p_decision)
  {
    jdoSetm_decision(this, (DecisionPC)p_decision);
  }
  
  public DomPCSpec getAides()
  {
    return jdoGetm_aides(this);
  }
  
  public final void setAides(DomPCSpec p_aides)
  {
    jdoSetm_aides(this, (AidesPC)p_aides);
  }
  
  public DomPCSpec getAidesNcp()
  {
    return jdoGetm_aidesNcp(this);
  }
  
  public final void setAidesNcp(DomPCSpec p_aidesNcp)
  {
    jdoSetm_aidesNcp(this, (AidesNcpPC)p_aidesNcp);
  }
  
  static
  {
    JDOImplHelper.registerClass(DemandePivotPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new DemandePivotPC());
  }
  
  protected static final AttributionPC jdoGetm_attribution(DemandePivotPC pc)
  {
    if (jdoFlags <= 0) {
      return m_attribution;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_attribution;
      }
      return (AttributionPC)sm.getObjectField(pc, jdoInheritedFieldCount + 0, m_attribution);
    }
    return m_attribution;
  }
  
  protected static final DecisionPC jdoGetm_decision(DemandePivotPC pc)
  {
    if (jdoFlags <= 0) {
      return m_decision;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_decision;
      }
      return (DecisionPC)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_decision);
    }
    return m_decision;
  }
  
  protected static final AidesPC jdoGetm_aides(DemandePivotPC pc)
  {
    if (jdoFlags <= 0) {
      return m_aides;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_aides;
      }
      return (AidesPC)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_aides);
    }
    return m_aides;
  }
  
  protected static final AidesNcpPC jdoGetm_aidesNcp(DemandePivotPC pc)
  {
    if (jdoFlags <= 0) {
      return m_aidesNcp;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_aidesNcp;
      }
      return (AidesNcpPC)sm.getObjectField(pc, jdoInheritedFieldCount + 3, m_aidesNcp);
    }
    return m_aidesNcp;
  }
  
  protected static final void jdoSetm_attribution(DemandePivotPC pc, AttributionPC newValue)
  {
    if (jdoFlags == 0)
    {
      m_attribution = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 0, m_attribution, newValue);
    } else {
      m_attribution = newValue;
    }
  }
  
  protected static final void jdoSetm_decision(DemandePivotPC pc, DecisionPC newValue)
  {
    if (jdoFlags == 0)
    {
      m_decision = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_decision, newValue);
    } else {
      m_decision = newValue;
    }
  }
  
  protected static final void jdoSetm_aides(DemandePivotPC pc, AidesPC newValue)
  {
    if (jdoFlags == 0)
    {
      m_aides = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_aides, newValue);
    } else {
      m_aides = newValue;
    }
  }
  
  protected static final void jdoSetm_aidesNcp(DemandePivotPC pc, AidesNcpPC newValue)
  {
    if (jdoFlags == 0)
    {
      m_aidesNcp = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 3, m_aidesNcp, newValue);
    } else {
      m_aidesNcp = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_attribution);
      break;
    case 1: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_decision);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_aides);
      break;
    case 3: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_aidesNcp);
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
      m_attribution = ((AttributionPC)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 1: 
      m_decision = ((DecisionPC)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_aides = ((AidesPC)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 3: 
      m_aidesNcp = ((AidesNcpPC)jdoStateManager.replacingObjectField(this, fieldNumber));
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
    DemandePivotPC pc = new DemandePivotPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    DemandePivotPC pc = new DemandePivotPC();
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
    if (!(pc instanceof DemandePivotPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    DemandePivotPC other = (DemandePivotPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_attribution = m_attribution;
        break;
      case 1: 
        m_decision = m_decision;
        break;
      case 2: 
        m_aides = m_aides;
        break;
      case 3: 
        m_aidesNcp = m_aidesNcp;
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
 * Qualified Name:     DemandePivotPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */