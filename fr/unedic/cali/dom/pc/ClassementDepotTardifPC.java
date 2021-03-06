package fr.unedic.cali.dom.pc;

import fr.unedic.cali.dom.ClassementDepotTardif;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import javax.jdo.JDOFatalInternalException;
import javax.jdo.spi.JDOImplHelper;
import javax.jdo.spi.PersistenceCapable;
import javax.jdo.spi.StateManager;

public class ClassementDepotTardifPC
  extends ClassementAdministratifPC
  implements DomPCSpec, PersistenceCapable
{
  private transient ClassementDepotTardif m_classementDepotTardifOM;
  private static int jdoInheritedFieldCount = ;
  private static String[] jdoFieldNames = new String[0];
  private static Class[] jdoFieldTypes = new Class[0];
  private static byte[] jdoFieldFlags = new byte[0];
  private static Class jdoPersistenceCapableSuperclass = class$("fr.unedic.cali.dom.pc.ClassementAdministratifPC");
  
  public Object createOM()
  {
    if (m_classementDepotTardifOM == null) {
      m_classementDepotTardifOM = new ClassementDepotTardif(this);
    }
    return m_classementDepotTardifOM;
  }
  
  static
  {
    JDOImplHelper.registerClass(ClassementDepotTardifPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new ClassementDepotTardifPC());
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    if (relativeField < 0) {
      super.jdoProvideField(fieldNumber);
    } else {
      throw new JDOFatalInternalException("index of field is out of bound");
    }
  }
  
  public void jdoReplaceField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    if (relativeField < 0) {
      super.jdoReplaceField(fieldNumber);
    } else {
      throw new JDOFatalInternalException("index of field is out of bound");
    }
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm)
  {
    ClassementDepotTardifPC pc = new ClassementDepotTardifPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    ClassementDepotTardifPC pc = new ClassementDepotTardifPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 0;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    ;
    ;
    ;
    if (!(pc instanceof ClassementDepotTardifPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
  }
}

/* Location:
 * Qualified Name:     ClassementDepotTardifPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */