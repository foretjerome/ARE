package fr.unedic.cali.dom.pc;

import fr.unedic.cali.dom.ClassementCompetenceSecteurPublic;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import javax.jdo.JDOFatalInternalException;
import javax.jdo.JDOUserException;
import javax.jdo.spi.JDOImplHelper;
import javax.jdo.spi.PersistenceCapable;
import javax.jdo.spi.StateManager;

public class ClassementCompetenceSecteurPublicPC
  extends ClassementAdministratifPC
  implements DomPCSpec, PersistenceCapable
{
  private transient ClassementCompetenceSecteurPublic m_classementCompetenceSecteurPublicOM;
  protected int m_motifNotification;
  protected String m_employeurCompetent;
  private static int jdoInheritedFieldCount = ;
  private static String[] jdoFieldNames = { "m_motifNotification", "m_employeurCompetent" };
  private static Class[] jdoFieldTypes = { Integer.TYPE, String.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = class$("fr.unedic.cali.dom.pc.ClassementAdministratifPC");
  
  public Object createOM()
  {
    if (m_classementCompetenceSecteurPublicOM == null) {
      m_classementCompetenceSecteurPublicOM = new ClassementCompetenceSecteurPublic(this);
    }
    return m_classementCompetenceSecteurPublicOM;
  }
  
  public int getMotifNotification()
  {
    return jdoGetm_motifNotification(this);
  }
  
  public final void setMotifNotification(int p_motifNotification)
  {
    jdoSetm_motifNotification(this, p_motifNotification);
  }
  
  public String getEmployeurCompetent()
  {
    return jdoGetm_employeurCompetent(this);
  }
  
  public final void setEmployeurCompetent(String p_employeurCompetent)
  {
    jdoSetm_employeurCompetent(this, p_employeurCompetent);
  }
  
  static
  {
    JDOImplHelper.registerClass(ClassementCompetenceSecteurPublicPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new ClassementCompetenceSecteurPublicPC());
  }
  
  protected static final int jdoGetm_motifNotification(ClassementCompetenceSecteurPublicPC pc)
  {
    if (jdoFlags <= 0) {
      return m_motifNotification;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_motifNotification;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 0, m_motifNotification);
    }
    return m_motifNotification;
  }
  
  protected static final String jdoGetm_employeurCompetent(ClassementCompetenceSecteurPublicPC pc)
  {
    if (jdoFlags <= 0) {
      return m_employeurCompetent;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_employeurCompetent;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 1, m_employeurCompetent);
    }
    return m_employeurCompetent;
  }
  
  protected static final void jdoSetm_motifNotification(ClassementCompetenceSecteurPublicPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_motifNotification = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 0, m_motifNotification, newValue);
    } else {
      m_motifNotification = newValue;
    }
  }
  
  protected static final void jdoSetm_employeurCompetent(ClassementCompetenceSecteurPublicPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_employeurCompetent = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 1, m_employeurCompetent, newValue);
    } else {
      m_employeurCompetent = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedIntField(this, fieldNumber, m_motifNotification);
      break;
    case 1: 
      jdoStateManager.providedStringField(this, fieldNumber, m_employeurCompetent);
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
      m_motifNotification = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 1: 
      m_employeurCompetent = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
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
    ClassementCompetenceSecteurPublicPC pc = new ClassementCompetenceSecteurPublicPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    ClassementCompetenceSecteurPublicPC pc = new ClassementCompetenceSecteurPublicPC();
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
    if (!(pc instanceof ClassementCompetenceSecteurPublicPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    ClassementCompetenceSecteurPublicPC other = (ClassementCompetenceSecteurPublicPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_motifNotification = m_motifNotification;
        break;
      case 1: 
        m_employeurCompetent = m_employeurCompetent;
      }
    }
    super.jdoCopyFields(pc, fieldNumbers);
  }
}

/* Location:
 * Qualified Name:     ClassementCompetenceSecteurPublicPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */