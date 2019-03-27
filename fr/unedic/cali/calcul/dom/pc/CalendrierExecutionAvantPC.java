package fr.unedic.cali.calcul.dom.pc;

import fr.unedic.cali.calcul.dom.CalendrierExecutionAvant;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.temps.Damj;
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

public class CalendrierExecutionAvantPC
  extends ObjetChronoPeriodePC
  implements DomPCSpec, PersistenceCapable
{
  private transient CalendrierExecutionAvant m_calendrierExecutionAvantOM;
  private EtatAuDernierJourAvantPC m_etatAuDernierJourAvant;
  protected Damj m_dateDrv;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_periode", "m_etatAuDernierJourAvant", "m_dateDrv" };
  private static Class[] jdoFieldTypes = { Periode.class, EtatAuDernierJourAvantPC.class, Damj.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  static final long serialVersionUID = 7986398177367064787L;
  
  public Object createOM()
  {
    if (m_calendrierExecutionAvantOM == null) {
      m_calendrierExecutionAvantOM = new CalendrierExecutionAvant(this);
    }
    return m_calendrierExecutionAvantOM;
  }
  
  public DomPCSpec getEtatAuDernierJourAvant()
  {
    return jdoGetm_etatAuDernierJourAvant(this);
  }
  
  public final void setEtatAuDernierJourAvant(DomPCSpec p_etatAuDernierJourAvant)
  {
    jdoSetm_etatAuDernierJourAvant(this, (EtatAuDernierJourAvantPC)p_etatAuDernierJourAvant);
  }
  
  public Damj getDateDrv()
  {
    return jdoGetm_dateDrv(this);
  }
  
  public final void setDateDrv(Damj p_dateDrv)
  {
    jdoSetm_dateDrv(this, p_dateDrv);
  }
  
  static
  {
    JDOImplHelper.registerClass(CalendrierExecutionAvantPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new CalendrierExecutionAvantPC());
  }
  
  protected static final Periode jdoGetm_periode(CalendrierExecutionAvantPC pc)
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
  
  private static final EtatAuDernierJourAvantPC jdoGetm_etatAuDernierJourAvant(CalendrierExecutionAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_etatAuDernierJourAvant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_etatAuDernierJourAvant;
      }
      return (EtatAuDernierJourAvantPC)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_etatAuDernierJourAvant);
    }
    return m_etatAuDernierJourAvant;
  }
  
  protected static final Damj jdoGetm_dateDrv(CalendrierExecutionAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDrv;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_dateDrv;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_dateDrv);
    }
    return m_dateDrv;
  }
  
  protected static final void jdoSetm_periode(CalendrierExecutionAvantPC pc, Periode newValue)
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
  
  private static final void jdoSetm_etatAuDernierJourAvant(CalendrierExecutionAvantPC pc, EtatAuDernierJourAvantPC newValue)
  {
    if (jdoFlags == 0)
    {
      m_etatAuDernierJourAvant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_etatAuDernierJourAvant, newValue);
    } else {
      m_etatAuDernierJourAvant = newValue;
    }
  }
  
  protected static final void jdoSetm_dateDrv(CalendrierExecutionAvantPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDrv = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_dateDrv, newValue);
    } else {
      m_dateDrv = newValue;
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
      jdoStateManager.providedObjectField(this, fieldNumber, m_etatAuDernierJourAvant);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDrv);
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
      m_etatAuDernierJourAvant = ((EtatAuDernierJourAvantPC)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_dateDrv = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
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
    CalendrierExecutionAvantPC pc = new CalendrierExecutionAvantPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    CalendrierExecutionAvantPC pc = new CalendrierExecutionAvantPC();
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
    if (!(pc instanceof CalendrierExecutionAvantPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    CalendrierExecutionAvantPC other = (CalendrierExecutionAvantPC)pc;
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
        m_etatAuDernierJourAvant = m_etatAuDernierJourAvant;
        break;
      case 2: 
        m_dateDrv = m_dateDrv;
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
 * Qualified Name:     CalendrierExecutionAvantPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */