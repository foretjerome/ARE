package fr.unedic.cali.dom.pc;

import fr.unedic.cali.dom.ClassementSansSuite;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import javax.jdo.JDOFatalInternalException;
import javax.jdo.JDOUserException;
import javax.jdo.spi.JDOImplHelper;
import javax.jdo.spi.PersistenceCapable;
import javax.jdo.spi.StateManager;

public class ClassementSansSuitePC
  extends ClassementAdministratifPC
  implements DomPCSpec, PersistenceCapable
{
  private transient ClassementSansSuite m_classementSansSuiteOM;
  protected String m_motif;
  private static int jdoInheritedFieldCount = ;
  private static String[] jdoFieldNames = { "m_motif" };
  private static Class[] jdoFieldTypes = { String.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = class$("fr.unedic.cali.dom.pc.ClassementAdministratifPC");
  
  public Object createOM()
  {
    if (m_classementSansSuiteOM == null) {
      m_classementSansSuiteOM = new ClassementSansSuite(this);
    }
    return m_classementSansSuiteOM;
  }
  
  public String getMotif()
  {
    return jdoGetm_motif(this);
  }
  
  public final void setMotif(String p_motif)
  {
    jdoSetm_motif(this, p_motif);
  }
  
  static
  {
    JDOImplHelper.registerClass(ClassementSansSuitePC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new ClassementSansSuitePC());
  }
  
  protected static final String jdoGetm_motif(ClassementSansSuitePC pc)
  {
    if (jdoFlags <= 0) {
      return m_motif;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_motif;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 0, m_motif);
    }
    return m_motif;
  }
  
  protected static final void jdoSetm_motif(ClassementSansSuitePC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_motif = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 0, m_motif, newValue);
    } else {
      m_motif = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedStringField(this, fieldNumber, m_motif);
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
      m_motif = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
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
    ClassementSansSuitePC pc = new ClassementSansSuitePC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    ClassementSansSuitePC pc = new ClassementSansSuitePC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 1;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof ClassementSansSuitePC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    ClassementSansSuitePC other = (ClassementSansSuitePC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_motif = m_motif;
      }
    }
    super.jdoCopyFields(pc, fieldNumbers);
  }
}

/* Location:
 * Qualified Name:     ClassementSansSuitePC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */