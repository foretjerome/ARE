package fr.unedic.cali.calcul.dom.pc;

import fr.unedic.transverse.dom.spec.DomPCSpec;
import javax.jdo.JDOFatalInternalException;
import javax.jdo.spi.JDOImplHelper;
import javax.jdo.spi.PersistenceCapable;

public abstract class CalendrierExecutionCalculPonctuelPC
  extends CalendrierExecutionCalculPC
  implements DomPCSpec, PersistenceCapable
{
  private static int jdoInheritedFieldCount = ;
  private static String[] jdoFieldNames = new String[0];
  private static Class[] jdoFieldTypes = new Class[0];
  private static byte[] jdoFieldFlags = new byte[0];
  private static Class jdoPersistenceCapableSuperclass = class$("fr.unedic.cali.calcul.dom.pc.CalendrierExecutionCalculPC");
  static final long serialVersionUID = -4481914990019186919L;
  
  public abstract Object createOM();
  
  static
  {
    JDOImplHelper.registerClass(CalendrierExecutionCalculPonctuelPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, null);
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
  
  /* Error */
  public PersistenceCapable jdoNewInstance(javax.jdo.spi.StateManager sm)
  {
    // Byte code:
    //   0: new 23	javax/jdo/JDOFatalInternalException
    //   3: dup
    //   4: ldc 118
    //   6: invokespecial 111	javax/jdo/JDOFatalInternalException:<init>	(Ljava/lang/String;)V
    //   9: athrow
    //   10: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	11	0	this	CalendrierExecutionCalculPonctuelPC
    //   0	11	1	sm	javax.jdo.spi.StateManager
  }
  
  /* Error */
  public PersistenceCapable jdoNewInstance(javax.jdo.spi.StateManager sm, Object oid)
  {
    // Byte code:
    //   0: new 23	javax/jdo/JDOFatalInternalException
    //   3: dup
    //   4: ldc 118
    //   6: invokespecial 111	javax/jdo/JDOFatalInternalException:<init>	(Ljava/lang/String;)V
    //   9: athrow
    //   10: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	11	0	this	CalendrierExecutionCalculPonctuelPC
    //   0	11	1	sm	javax.jdo.spi.StateManager
    //   0	11	2	oid	Object
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
    if (!(pc instanceof CalendrierExecutionCalculPonctuelPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
  }
}

/* Location:
 * Qualified Name:     CalendrierExecutionCalculPonctuelPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */