package fr.unedic.cali.calcul.dom.pc;

import fr.unedic.cali.calcul.dom.UniteTraitementAvant;
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

public class UniteTraitementAvantPC
  extends ObjetChronoPeriodePC
  implements DomPCSpec, PersistenceCapable
{
  private transient UniteTraitementAvant m_uniteTraitementAvantOM;
  private Integer m_dureePmc;
  private Integer m_dureeIccp;
  private Integer m_dureeIslr;
  private Integer m_dureeDelaiAttente;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_periode", "m_dureePmc", "m_dureeIccp", "m_dureeIslr", "m_dureeDelaiAttente" };
  private static Class[] jdoFieldTypes = { Periode.class, Integer.class, Integer.class, Integer.class, Integer.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  static final long serialVersionUID = -8375426923634768144L;
  
  public Object createOM()
  {
    if (m_uniteTraitementAvantOM == null) {
      m_uniteTraitementAvantOM = new UniteTraitementAvant(this);
    }
    return m_uniteTraitementAvantOM;
  }
  
  public Integer getDureePmc()
  {
    return jdoGetm_dureePmc(this);
  }
  
  public final void setDureePmc(Integer p_dureePmc)
  {
    jdoSetm_dureePmc(this, p_dureePmc);
  }
  
  public Integer getDureeIccp()
  {
    return jdoGetm_dureeIccp(this);
  }
  
  public final void setDureeIccp(Integer p_dureeIccp)
  {
    jdoSetm_dureeIccp(this, p_dureeIccp);
  }
  
  public Integer getDureeIslr()
  {
    return jdoGetm_dureeIslr(this);
  }
  
  public final void setDureeIslr(Integer p_dureeIslr)
  {
    jdoSetm_dureeIslr(this, p_dureeIslr);
  }
  
  public Integer getDureeDelaiAttente()
  {
    return jdoGetm_dureeDelaiAttente(this);
  }
  
  public final void setDureeDelaiAttente(Integer p_dureeDelaiAttente)
  {
    jdoSetm_dureeDelaiAttente(this, p_dureeDelaiAttente);
  }
  
  static
  {
    JDOImplHelper.registerClass(UniteTraitementAvantPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new UniteTraitementAvantPC());
  }
  
  protected static final Periode jdoGetm_periode(UniteTraitementAvantPC pc)
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
  
  private static final Integer jdoGetm_dureePmc(UniteTraitementAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureePmc;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_dureePmc;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_dureePmc);
    }
    return m_dureePmc;
  }
  
  private static final Integer jdoGetm_dureeIccp(UniteTraitementAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeIccp;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_dureeIccp;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_dureeIccp);
    }
    return m_dureeIccp;
  }
  
  private static final Integer jdoGetm_dureeIslr(UniteTraitementAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeIslr;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_dureeIslr;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 3, m_dureeIslr);
    }
    return m_dureeIslr;
  }
  
  private static final Integer jdoGetm_dureeDelaiAttente(UniteTraitementAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeDelaiAttente;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_dureeDelaiAttente;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 4, m_dureeDelaiAttente);
    }
    return m_dureeDelaiAttente;
  }
  
  protected static final void jdoSetm_periode(UniteTraitementAvantPC pc, Periode newValue)
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
  
  private static final void jdoSetm_dureePmc(UniteTraitementAvantPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureePmc = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_dureePmc, newValue);
    } else {
      m_dureePmc = newValue;
    }
  }
  
  private static final void jdoSetm_dureeIccp(UniteTraitementAvantPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeIccp = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_dureeIccp, newValue);
    } else {
      m_dureeIccp = newValue;
    }
  }
  
  private static final void jdoSetm_dureeIslr(UniteTraitementAvantPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeIslr = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 3, m_dureeIslr, newValue);
    } else {
      m_dureeIslr = newValue;
    }
  }
  
  private static final void jdoSetm_dureeDelaiAttente(UniteTraitementAvantPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeDelaiAttente = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 4, m_dureeDelaiAttente, newValue);
    } else {
      m_dureeDelaiAttente = newValue;
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
      jdoStateManager.providedObjectField(this, fieldNumber, m_dureePmc);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dureeIccp);
      break;
    case 3: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dureeIslr);
      break;
    case 4: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dureeDelaiAttente);
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
      m_dureePmc = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_dureeIccp = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 3: 
      m_dureeIslr = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 4: 
      m_dureeDelaiAttente = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
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
    UniteTraitementAvantPC pc = new UniteTraitementAvantPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    UniteTraitementAvantPC pc = new UniteTraitementAvantPC();
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
    if (!(pc instanceof UniteTraitementAvantPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    UniteTraitementAvantPC other = (UniteTraitementAvantPC)pc;
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
        m_dureePmc = m_dureePmc;
        break;
      case 2: 
        m_dureeIccp = m_dureeIccp;
        break;
      case 3: 
        m_dureeIslr = m_dureeIslr;
        break;
      case 4: 
        m_dureeDelaiAttente = m_dureeDelaiAttente;
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
 * Qualified Name:     UniteTraitementAvantPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */