package fr.unedic.cali.dom.pc;

import fr.unedic.cali.dom.Entretien;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.Quantite;
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

public class EntretienPC
  implements DomPCSpec, PersistenceCapable
{
  private transient Entretien m_entretienOM;
  protected Damj m_dateCessationInscription;
  protected Damj m_dateFinContrat;
  protected Damj m_dateDebutPra;
  protected Damj m_dateFinPra;
  protected boolean m_aExerceActiviteSalarie;
  protected boolean m_aSuiviFormation;
  protected Quantite m_quantiteAffiliation;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_dateCessationInscription", "m_dateFinContrat", "m_dateDebutPra", "m_dateFinPra", "m_aExerceActiviteSalarie", "m_aSuiviFormation", "m_quantiteAffiliation" };
  private static Class[] jdoFieldTypes = { Damj.class, Damj.class, Damj.class, Damj.class, Boolean.TYPE, Boolean.TYPE, Quantite.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_entretienOM == null) {
      m_entretienOM = new Entretien(this);
    }
    return m_entretienOM;
  }
  
  public Damj getDateCessationInscription()
  {
    return jdoGetm_dateCessationInscription(this);
  }
  
  public final void setDateCessationInscription(Damj p_dateCessationInscription)
  {
    jdoSetm_dateCessationInscription(this, p_dateCessationInscription);
  }
  
  public Damj getDateFinContrat()
  {
    return jdoGetm_dateFinContrat(this);
  }
  
  public final void setDateFinContrat(Damj p_dateFinContrat)
  {
    jdoSetm_dateFinContrat(this, p_dateFinContrat);
  }
  
  public Damj getDateDebutPra()
  {
    return jdoGetm_dateDebutPra(this);
  }
  
  public final void setDateDebutPra(Damj p_dateDebutPra)
  {
    jdoSetm_dateDebutPra(this, p_dateDebutPra);
  }
  
  public Damj getDateFinPra()
  {
    return jdoGetm_dateFinPra(this);
  }
  
  public final void setDateFinPra(Damj p_dateFinPra)
  {
    jdoSetm_dateFinPra(this, p_dateFinPra);
  }
  
  public boolean isAExerceActiviteSalarie()
  {
    return jdoGetm_aExerceActiviteSalarie(this);
  }
  
  public final void setAExerceActiviteSalarie(boolean p_aExerceActiviteSalarie)
  {
    jdoSetm_aExerceActiviteSalarie(this, p_aExerceActiviteSalarie);
  }
  
  public boolean isASuiviFormation()
  {
    return jdoGetm_aSuiviFormation(this);
  }
  
  public final void setASuiviFormation(boolean p_aSuiviFormation)
  {
    jdoSetm_aSuiviFormation(this, p_aSuiviFormation);
  }
  
  public Quantite getQuantiteAffiliation()
  {
    return jdoGetm_quantiteAffiliation(this);
  }
  
  public final void setQuantiteAffiliation(Quantite p_quantiteAffiliation)
  {
    jdoSetm_quantiteAffiliation(this, p_quantiteAffiliation);
  }
  
  static
  {
    JDOImplHelper.registerClass(EntretienPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new EntretienPC());
  }
  
  protected static final Damj jdoGetm_dateCessationInscription(EntretienPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateCessationInscription;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_dateCessationInscription;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 0, m_dateCessationInscription);
    }
    return m_dateCessationInscription;
  }
  
  protected static final Damj jdoGetm_dateFinContrat(EntretienPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinContrat;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_dateFinContrat;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_dateFinContrat);
    }
    return m_dateFinContrat;
  }
  
  protected static final Damj jdoGetm_dateDebutPra(EntretienPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebutPra;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_dateDebutPra;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_dateDebutPra);
    }
    return m_dateDebutPra;
  }
  
  protected static final Damj jdoGetm_dateFinPra(EntretienPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinPra;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_dateFinPra;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 3, m_dateFinPra);
    }
    return m_dateFinPra;
  }
  
  protected static final boolean jdoGetm_aExerceActiviteSalarie(EntretienPC pc)
  {
    if (jdoFlags <= 0) {
      return m_aExerceActiviteSalarie;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_aExerceActiviteSalarie;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 4, m_aExerceActiviteSalarie);
    }
    return m_aExerceActiviteSalarie;
  }
  
  protected static final boolean jdoGetm_aSuiviFormation(EntretienPC pc)
  {
    if (jdoFlags <= 0) {
      return m_aSuiviFormation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_aSuiviFormation;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 5, m_aSuiviFormation);
    }
    return m_aSuiviFormation;
  }
  
  protected static final Quantite jdoGetm_quantiteAffiliation(EntretienPC pc)
  {
    if (jdoFlags <= 0) {
      return m_quantiteAffiliation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_quantiteAffiliation;
      }
      return (Quantite)sm.getObjectField(pc, jdoInheritedFieldCount + 6, m_quantiteAffiliation);
    }
    return m_quantiteAffiliation;
  }
  
  protected static final void jdoSetm_dateCessationInscription(EntretienPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateCessationInscription = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 0, m_dateCessationInscription, newValue);
    } else {
      m_dateCessationInscription = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinContrat(EntretienPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinContrat = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_dateFinContrat, newValue);
    } else {
      m_dateFinContrat = newValue;
    }
  }
  
  protected static final void jdoSetm_dateDebutPra(EntretienPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebutPra = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_dateDebutPra, newValue);
    } else {
      m_dateDebutPra = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinPra(EntretienPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinPra = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 3, m_dateFinPra, newValue);
    } else {
      m_dateFinPra = newValue;
    }
  }
  
  protected static final void jdoSetm_aExerceActiviteSalarie(EntretienPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_aExerceActiviteSalarie = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 4, m_aExerceActiviteSalarie, newValue);
    } else {
      m_aExerceActiviteSalarie = newValue;
    }
  }
  
  protected static final void jdoSetm_aSuiviFormation(EntretienPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_aSuiviFormation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 5, m_aSuiviFormation, newValue);
    } else {
      m_aSuiviFormation = newValue;
    }
  }
  
  protected static final void jdoSetm_quantiteAffiliation(EntretienPC pc, Quantite newValue)
  {
    if (jdoFlags == 0)
    {
      m_quantiteAffiliation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 6, m_quantiteAffiliation, newValue);
    } else {
      m_quantiteAffiliation = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateCessationInscription);
      break;
    case 1: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinContrat);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebutPra);
      break;
    case 3: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinPra);
      break;
    case 4: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_aExerceActiviteSalarie);
      break;
    case 5: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_aSuiviFormation);
      break;
    case 6: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_quantiteAffiliation);
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
      m_dateCessationInscription = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 1: 
      m_dateFinContrat = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_dateDebutPra = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 3: 
      m_dateFinPra = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 4: 
      m_aExerceActiviteSalarie = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 5: 
      m_aSuiviFormation = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 6: 
      m_quantiteAffiliation = ((Quantite)jdoStateManager.replacingObjectField(this, fieldNumber));
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
    EntretienPC pc = new EntretienPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    EntretienPC pc = new EntretienPC();
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
    if (!(pc instanceof EntretienPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    EntretienPC other = (EntretienPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_dateCessationInscription = m_dateCessationInscription;
        break;
      case 1: 
        m_dateFinContrat = m_dateFinContrat;
        break;
      case 2: 
        m_dateDebutPra = m_dateDebutPra;
        break;
      case 3: 
        m_dateFinPra = m_dateFinPra;
        break;
      case 4: 
        m_aExerceActiviteSalarie = m_aExerceActiviteSalarie;
        break;
      case 5: 
        m_aSuiviFormation = m_aSuiviFormation;
        break;
      case 6: 
        m_quantiteAffiliation = m_quantiteAffiliation;
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
 * Qualified Name:     EntretienPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */