package fr.unedic.cali.dom.pc;

import fr.unedic.cali.dom.DureeNonIndemnisable;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.Quantite;
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

public class DureeNonIndemnisablePC
  extends QuantiteDroitPC
  implements DomPCSpec, PersistenceCapable
{
  private transient DureeNonIndemnisable m_dureeNonIndemnisableOM;
  private Quantite m_reliquat;
  private Periode m_periodeDA;
  private Quantite m_reliquatMaxMois;
  private String m_type;
  private Quantite m_quantiteCourante;
  private int m_etat;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_etat", "m_quantiteCourante", "m_quantiteInitial", "m_reliquat", "m_periodeDA", "m_reliquatMaxMois", "m_type" };
  private static Class[] jdoFieldTypes = { Integer.TYPE, Quantite.class, Quantite.class, Quantite.class, Periode.class, Quantite.class, String.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_dureeNonIndemnisableOM == null) {
      m_dureeNonIndemnisableOM = new DureeNonIndemnisable(this);
    }
    return m_dureeNonIndemnisableOM;
  }
  
  public Quantite getReliquat()
  {
    return jdoGetm_reliquat(this);
  }
  
  public final void setReliquat(Quantite p_reliquat)
  {
    jdoSetm_reliquat(this, p_reliquat);
  }
  
  public Periode getPeriodeDA()
  {
    return jdoGetm_periodeDA(this);
  }
  
  public final void setPeriodeDA(Periode p_periodeDA)
  {
    jdoSetm_periodeDA(this, p_periodeDA);
  }
  
  public Quantite getReliquatMaxMois()
  {
    return jdoGetm_reliquatMaxMois(this);
  }
  
  public final void setReliquatMaxMois(Quantite p_reliquatMaxMois)
  {
    jdoSetm_reliquatMaxMois(this, p_reliquatMaxMois);
  }
  
  public String getType()
  {
    return jdoGetm_type(this);
  }
  
  public final void setType(String p_type)
  {
    jdoSetm_type(this, p_type);
  }
  
  public Quantite getQuantiteCourante()
  {
    return jdoGetm_quantiteCourante(this);
  }
  
  public final void setQuantiteCourante(Quantite p_quantiteCourante)
  {
    jdoSetm_quantiteCourante(this, p_quantiteCourante);
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
    JDOImplHelper.registerClass(DureeNonIndemnisablePC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new DureeNonIndemnisablePC());
  }
  
  private static final int jdoGetm_etat(DureeNonIndemnisablePC pc)
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
  
  private static final Quantite jdoGetm_quantiteCourante(DureeNonIndemnisablePC pc)
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
  
  protected static final Quantite jdoGetm_quantiteInitial(DureeNonIndemnisablePC pc)
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
  
  private static final Quantite jdoGetm_reliquat(DureeNonIndemnisablePC pc)
  {
    if (jdoFlags <= 0) {
      return m_reliquat;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_reliquat;
      }
      return (Quantite)sm.getObjectField(pc, jdoInheritedFieldCount + 3, m_reliquat);
    }
    return m_reliquat;
  }
  
  private static final Periode jdoGetm_periodeDA(DureeNonIndemnisablePC pc)
  {
    if (jdoFlags <= 0) {
      return m_periodeDA;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_periodeDA;
      }
      return (Periode)sm.getObjectField(pc, jdoInheritedFieldCount + 4, m_periodeDA);
    }
    return m_periodeDA;
  }
  
  private static final Quantite jdoGetm_reliquatMaxMois(DureeNonIndemnisablePC pc)
  {
    if (jdoFlags <= 0) {
      return m_reliquatMaxMois;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_reliquatMaxMois;
      }
      return (Quantite)sm.getObjectField(pc, jdoInheritedFieldCount + 5, m_reliquatMaxMois);
    }
    return m_reliquatMaxMois;
  }
  
  private static final String jdoGetm_type(DureeNonIndemnisablePC pc)
  {
    if (jdoFlags <= 0) {
      return m_type;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_type;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 6, m_type);
    }
    return m_type;
  }
  
  private static final void jdoSetm_etat(DureeNonIndemnisablePC pc, int newValue)
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
  
  private static final void jdoSetm_quantiteCourante(DureeNonIndemnisablePC pc, Quantite newValue)
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
  
  protected static final void jdoSetm_quantiteInitial(DureeNonIndemnisablePC pc, Quantite newValue)
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
  
  private static final void jdoSetm_reliquat(DureeNonIndemnisablePC pc, Quantite newValue)
  {
    if (jdoFlags == 0)
    {
      m_reliquat = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 3, m_reliquat, newValue);
    } else {
      m_reliquat = newValue;
    }
  }
  
  private static final void jdoSetm_periodeDA(DureeNonIndemnisablePC pc, Periode newValue)
  {
    if (jdoFlags == 0)
    {
      m_periodeDA = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 4, m_periodeDA, newValue);
    } else {
      m_periodeDA = newValue;
    }
  }
  
  private static final void jdoSetm_reliquatMaxMois(DureeNonIndemnisablePC pc, Quantite newValue)
  {
    if (jdoFlags == 0)
    {
      m_reliquatMaxMois = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 5, m_reliquatMaxMois, newValue);
    } else {
      m_reliquatMaxMois = newValue;
    }
  }
  
  private static final void jdoSetm_type(DureeNonIndemnisablePC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_type = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 6, m_type, newValue);
    } else {
      m_type = newValue;
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
    case 3: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_reliquat);
      break;
    case 4: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_periodeDA);
      break;
    case 5: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_reliquatMaxMois);
      break;
    case 6: 
      jdoStateManager.providedStringField(this, fieldNumber, m_type);
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
    case 3: 
      m_reliquat = ((Quantite)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 4: 
      m_periodeDA = ((Periode)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 5: 
      m_reliquatMaxMois = ((Quantite)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 6: 
      m_type = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
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
    DureeNonIndemnisablePC pc = new DureeNonIndemnisablePC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    DureeNonIndemnisablePC pc = new DureeNonIndemnisablePC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 7;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof DureeNonIndemnisablePC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    DureeNonIndemnisablePC other = (DureeNonIndemnisablePC)pc;
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
        break;
      case 3: 
        m_reliquat = m_reliquat;
        break;
      case 4: 
        m_periodeDA = m_periodeDA;
        break;
      case 5: 
        m_reliquatMaxMois = m_reliquatMaxMois;
        break;
      case 6: 
        m_type = m_type;
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
 * Qualified Name:     DureeNonIndemnisablePC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */