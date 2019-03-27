package fr.unedic.cali.dom.pivot.pc;

import fr.unedic.cali.dom.pivot.PeriodeAffiliation;
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

public class PeriodeAffiliationPC
  implements DomPCSpec, PersistenceCapable
{
  private transient PeriodeAffiliation m_periodeAffiliationOM;
  private String m_identifiantPeriode;
  private Damj m_dateDebut;
  private Damj m_dateFin;
  private String m_qualification;
  private String m_type;
  private String m_competenceFinanciere;
  private String m_competenceAdministrative;
  private Integer m_identifiantOD;
  private String m_referenceExterneDemande;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_identifiantPeriode", "m_dateDebut", "m_dateFin", "m_qualification", "m_type", "m_competenceFinanciere", "m_competenceAdministrative", "m_identifiantOD", "m_referenceExterneDemande" };
  private static Class[] jdoFieldTypes = { String.class, Damj.class, Damj.class, String.class, String.class, String.class, String.class, Integer.class, String.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_periodeAffiliationOM == null) {
      m_periodeAffiliationOM = new PeriodeAffiliation(this);
    }
    return m_periodeAffiliationOM;
  }
  
  public String getIdentifiantPeriode()
  {
    return jdoGetm_identifiantPeriode(this);
  }
  
  public final void setIdentifiantPeriode(String p_identifiantPeriode)
  {
    jdoSetm_identifiantPeriode(this, p_identifiantPeriode);
  }
  
  public Damj getDateDebut()
  {
    return jdoGetm_dateDebut(this);
  }
  
  public final void setDateDebut(Damj p_dateDebut)
  {
    jdoSetm_dateDebut(this, p_dateDebut);
  }
  
  public Damj getDateFin()
  {
    return jdoGetm_dateFin(this);
  }
  
  public final void setDateFin(Damj p_dateFin)
  {
    jdoSetm_dateFin(this, p_dateFin);
  }
  
  public String getQualification()
  {
    return jdoGetm_qualification(this);
  }
  
  public final void setQualification(String p_qualification)
  {
    jdoSetm_qualification(this, p_qualification);
  }
  
  public String getType()
  {
    return jdoGetm_type(this);
  }
  
  public final void setType(String p_type)
  {
    jdoSetm_type(this, p_type);
  }
  
  public String getCompetenceFinanciere()
  {
    return jdoGetm_competenceFinanciere(this);
  }
  
  public final void setCompetenceFinanciere(String p_competenceFinanciere)
  {
    jdoSetm_competenceFinanciere(this, p_competenceFinanciere);
  }
  
  public String getCompetenceAdministrative()
  {
    return jdoGetm_competenceAdministrative(this);
  }
  
  public final void setCompetenceAdministrative(String p_competenceAdministrative)
  {
    jdoSetm_competenceAdministrative(this, p_competenceAdministrative);
  }
  
  public Integer getIdentifiantOD()
  {
    return jdoGetm_identifiantOD(this);
  }
  
  public final void setIdentifiantOD(Integer p_identifiantOD)
  {
    jdoSetm_identifiantOD(this, p_identifiantOD);
  }
  
  public String getReferenceExterneDemande()
  {
    return jdoGetm_referenceExterneDemande(this);
  }
  
  public final void setReferenceExterneDemande(String p_referenceExterneDemande)
  {
    jdoSetm_referenceExterneDemande(this, p_referenceExterneDemande);
  }
  
  static
  {
    JDOImplHelper.registerClass(PeriodeAffiliationPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new PeriodeAffiliationPC());
  }
  
  private static final String jdoGetm_identifiantPeriode(PeriodeAffiliationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantPeriode;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_identifiantPeriode;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 0, m_identifiantPeriode);
    }
    return m_identifiantPeriode;
  }
  
  private static final Damj jdoGetm_dateDebut(PeriodeAffiliationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebut;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_dateDebut;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_dateDebut);
    }
    return m_dateDebut;
  }
  
  private static final Damj jdoGetm_dateFin(PeriodeAffiliationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFin;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_dateFin;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_dateFin);
    }
    return m_dateFin;
  }
  
  private static final String jdoGetm_qualification(PeriodeAffiliationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_qualification;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_qualification;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 3, m_qualification);
    }
    return m_qualification;
  }
  
  private static final String jdoGetm_type(PeriodeAffiliationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_type;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_type;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 4, m_type);
    }
    return m_type;
  }
  
  private static final String jdoGetm_competenceFinanciere(PeriodeAffiliationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_competenceFinanciere;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_competenceFinanciere;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 5, m_competenceFinanciere);
    }
    return m_competenceFinanciere;
  }
  
  private static final String jdoGetm_competenceAdministrative(PeriodeAffiliationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_competenceAdministrative;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_competenceAdministrative;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 6, m_competenceAdministrative);
    }
    return m_competenceAdministrative;
  }
  
  private static final Integer jdoGetm_identifiantOD(PeriodeAffiliationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantOD;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_identifiantOD;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 7, m_identifiantOD);
    }
    return m_identifiantOD;
  }
  
  private static final String jdoGetm_referenceExterneDemande(PeriodeAffiliationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_referenceExterneDemande;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_referenceExterneDemande;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 8, m_referenceExterneDemande);
    }
    return m_referenceExterneDemande;
  }
  
  private static final void jdoSetm_identifiantPeriode(PeriodeAffiliationPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantPeriode = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 0, m_identifiantPeriode, newValue);
    } else {
      m_identifiantPeriode = newValue;
    }
  }
  
  private static final void jdoSetm_dateDebut(PeriodeAffiliationPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebut = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_dateDebut, newValue);
    } else {
      m_dateDebut = newValue;
    }
  }
  
  private static final void jdoSetm_dateFin(PeriodeAffiliationPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFin = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_dateFin, newValue);
    } else {
      m_dateFin = newValue;
    }
  }
  
  private static final void jdoSetm_qualification(PeriodeAffiliationPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_qualification = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 3, m_qualification, newValue);
    } else {
      m_qualification = newValue;
    }
  }
  
  private static final void jdoSetm_type(PeriodeAffiliationPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_type = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 4, m_type, newValue);
    } else {
      m_type = newValue;
    }
  }
  
  private static final void jdoSetm_competenceFinanciere(PeriodeAffiliationPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_competenceFinanciere = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 5, m_competenceFinanciere, newValue);
    } else {
      m_competenceFinanciere = newValue;
    }
  }
  
  private static final void jdoSetm_competenceAdministrative(PeriodeAffiliationPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_competenceAdministrative = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 6, m_competenceAdministrative, newValue);
    } else {
      m_competenceAdministrative = newValue;
    }
  }
  
  private static final void jdoSetm_identifiantOD(PeriodeAffiliationPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantOD = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 7, m_identifiantOD, newValue);
    } else {
      m_identifiantOD = newValue;
    }
  }
  
  private static final void jdoSetm_referenceExterneDemande(PeriodeAffiliationPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_referenceExterneDemande = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 8, m_referenceExterneDemande, newValue);
    } else {
      m_referenceExterneDemande = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedStringField(this, fieldNumber, m_identifiantPeriode);
      break;
    case 1: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebut);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFin);
      break;
    case 3: 
      jdoStateManager.providedStringField(this, fieldNumber, m_qualification);
      break;
    case 4: 
      jdoStateManager.providedStringField(this, fieldNumber, m_type);
      break;
    case 5: 
      jdoStateManager.providedStringField(this, fieldNumber, m_competenceFinanciere);
      break;
    case 6: 
      jdoStateManager.providedStringField(this, fieldNumber, m_competenceAdministrative);
      break;
    case 7: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_identifiantOD);
      break;
    case 8: 
      jdoStateManager.providedStringField(this, fieldNumber, m_referenceExterneDemande);
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
      m_identifiantPeriode = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 1: 
      m_dateDebut = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_dateFin = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 3: 
      m_qualification = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 4: 
      m_type = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 5: 
      m_competenceFinanciere = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 6: 
      m_competenceAdministrative = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 7: 
      m_identifiantOD = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 8: 
      m_referenceExterneDemande = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
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
    PeriodeAffiliationPC pc = new PeriodeAffiliationPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    PeriodeAffiliationPC pc = new PeriodeAffiliationPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 9;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof PeriodeAffiliationPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    PeriodeAffiliationPC other = (PeriodeAffiliationPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_identifiantPeriode = m_identifiantPeriode;
        break;
      case 1: 
        m_dateDebut = m_dateDebut;
        break;
      case 2: 
        m_dateFin = m_dateFin;
        break;
      case 3: 
        m_qualification = m_qualification;
        break;
      case 4: 
        m_type = m_type;
        break;
      case 5: 
        m_competenceFinanciere = m_competenceFinanciere;
        break;
      case 6: 
        m_competenceAdministrative = m_competenceAdministrative;
        break;
      case 7: 
        m_identifiantOD = m_identifiantOD;
        break;
      case 8: 
        m_referenceExterneDemande = m_referenceExterneDemande;
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
 * Qualified Name:     PeriodeAffiliationPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */