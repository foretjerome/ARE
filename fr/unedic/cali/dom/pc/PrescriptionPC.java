package fr.unedic.cali.dom.pc;

import fr.unedic.cali.dom.Prescription;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import javax.jdo.JDOFatalInternalException;
import javax.jdo.JDOUserException;
import javax.jdo.spi.JDOImplHelper;
import javax.jdo.spi.PersistenceCapable;
import javax.jdo.spi.StateManager;

public class PrescriptionPC
  extends ClassementAdministratifPC
  implements DomPCSpec, PersistenceCapable
{
  private transient Prescription m_prescriptionOM;
  protected boolean m_validite;
  protected String m_motifRejetPrescription;
  private static int jdoInheritedFieldCount = ;
  private static String[] jdoFieldNames = { "m_validite", "m_motifRejetPrescription" };
  private static Class[] jdoFieldTypes = { Boolean.TYPE, String.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = class$("fr.unedic.cali.dom.pc.ClassementAdministratifPC");
  
  public PrescriptionPC()
  {
    jdoSetm_validite(this, true);
    jdoSetm_motifRejetPrescription(this, "");
  }
  
  public Object createOM()
  {
    if (m_prescriptionOM == null) {
      m_prescriptionOM = new Prescription(this);
    }
    return m_prescriptionOM;
  }
  
  public boolean isValidite()
  {
    return jdoGetm_validite(this);
  }
  
  public final void setValidite(boolean p_validite)
  {
    jdoSetm_validite(this, p_validite);
  }
  
  public String getMotifRejetPrescription()
  {
    return jdoGetm_motifRejetPrescription(this);
  }
  
  public final void setMotifRejetPrescription(String p_motifRejetPrescription)
  {
    jdoSetm_motifRejetPrescription(this, p_motifRejetPrescription);
  }
  
  static
  {
    JDOImplHelper.registerClass(PrescriptionPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new PrescriptionPC());
  }
  
  protected static final boolean jdoGetm_validite(PrescriptionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_validite;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_validite;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 0, m_validite);
    }
    return m_validite;
  }
  
  protected static final String jdoGetm_motifRejetPrescription(PrescriptionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_motifRejetPrescription;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_motifRejetPrescription;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 1, m_motifRejetPrescription);
    }
    return m_motifRejetPrescription;
  }
  
  protected static final void jdoSetm_validite(PrescriptionPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_validite = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 0, m_validite, newValue);
    } else {
      m_validite = newValue;
    }
  }
  
  protected static final void jdoSetm_motifRejetPrescription(PrescriptionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_motifRejetPrescription = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 1, m_motifRejetPrescription, newValue);
    } else {
      m_motifRejetPrescription = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_validite);
      break;
    case 1: 
      jdoStateManager.providedStringField(this, fieldNumber, m_motifRejetPrescription);
      break;
    default: 
      if (relativeField < 0) {
        super.jdoProvideField(fieldNumber);
      } else {
        throw new JDOFatalInternalException("index of field is out of bound");
      }
      break;
    }
  }
  
  public void jdoReplaceField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      m_validite = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 1: 
      m_motifRejetPrescription = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    default: 
      if (relativeField < 0) {
        super.jdoReplaceField(fieldNumber);
      } else {
        throw new JDOFatalInternalException("index of field is out of bound");
      }
      break;
    }
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm)
  {
    PrescriptionPC pc = new PrescriptionPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    PrescriptionPC pc = new PrescriptionPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 2;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof PrescriptionPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    PrescriptionPC other = (PrescriptionPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_validite = m_validite;
        break;
      case 1: 
        m_motifRejetPrescription = m_motifRejetPrescription;
      }
    }
    super.jdoCopyFields(pc, fieldNumbers);
  }
}

/* Location:
 * Qualified Name:     PrescriptionPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */