package fr.unedic.cali.calcul.dom.pc;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import java.util.ArrayList;
import java.util.Collection;
import javax.jdo.JDOFatalInternalException;
import javax.jdo.JDOUserException;
import javax.jdo.spi.JDOImplHelper;
import javax.jdo.spi.PersistenceCapable;
import javax.jdo.spi.StateManager;

public abstract class CalendrierExecutionCalculPeriodiquePC
  extends CalendrierExecutionCalculPC
  implements DomPCSpec, PersistenceCapable
{
  protected Collection m_listChronologieUnitesTraitements;
  private static int jdoInheritedFieldCount = ;
  private static String[] jdoFieldNames = { "m_listChronologieUnitesTraitements" };
  private static Class[] jdoFieldTypes = { Collection.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.MEDIATE_READ + PersistenceCapable.MEDIATE_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = class$("fr.unedic.cali.calcul.dom.pc.CalendrierExecutionCalculPC");
  static final long serialVersionUID = -5918450298979839901L;
  
  public abstract Object createOM();
  
  public final Collection getCollectionUniteTraitement()
  {
    if (jdoGetm_listChronologieUnitesTraitements(this) == null) {
      jdoSetm_listChronologieUnitesTraitements(this, new ArrayList());
    }
    return jdoGetm_listChronologieUnitesTraitements(this);
  }
  
  public final void ajouterUniteTraitement(DomPCSpec p_ut)
    throws NullPointerException
  {
    if (p_ut == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_ut ne devrait pas être nul.", p_ut);
    }
    getCollectionUniteTraitement().add(p_ut);
  }
  
  public final void supprimerUniteTraitement(DomPCSpec p_ut)
    throws NullPointerException
  {
    if (p_ut == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_ut ne devrait pas être nul.", p_ut);
    }
    getCollectionUniteTraitement().remove(p_ut);
  }
  
  static
  {
    JDOImplHelper.registerClass(CalendrierExecutionCalculPeriodiquePC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, null);
  }
  
  protected static final Collection jdoGetm_listChronologieUnitesTraitements(CalendrierExecutionCalculPeriodiquePC pc)
  {
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_listChronologieUnitesTraitements;
      }
      return (Collection)sm.getObjectField(pc, jdoInheritedFieldCount + 0, m_listChronologieUnitesTraitements);
    }
    return m_listChronologieUnitesTraitements;
  }
  
  protected static final void jdoSetm_listChronologieUnitesTraitements(CalendrierExecutionCalculPeriodiquePC pc, Collection newValue)
  {
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 0, m_listChronologieUnitesTraitements, newValue);
    } else {
      m_listChronologieUnitesTraitements = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_listChronologieUnitesTraitements);
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
      m_listChronologieUnitesTraitements = ((Collection)jdoStateManager.replacingObjectField(this, fieldNumber));
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
  
  /* Error */
  public PersistenceCapable jdoNewInstance(StateManager sm)
  {
    // Byte code:
    //   0: new 60	javax/jdo/JDOFatalInternalException
    //   3: dup
    //   4: ldc -56
    //   6: invokespecial 189	javax/jdo/JDOFatalInternalException:<init>	(Ljava/lang/String;)V
    //   9: athrow
    //   10: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	11	0	this	CalendrierExecutionCalculPeriodiquePC
    //   0	11	1	sm	StateManager
  }
  
  /* Error */
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    // Byte code:
    //   0: new 60	javax/jdo/JDOFatalInternalException
    //   3: dup
    //   4: ldc -56
    //   6: invokespecial 189	javax/jdo/JDOFatalInternalException:<init>	(Ljava/lang/String;)V
    //   9: athrow
    //   10: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	11	0	this	CalendrierExecutionCalculPeriodiquePC
    //   0	11	1	sm	StateManager
    //   0	11	2	oid	Object
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 1;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof CalendrierExecutionCalculPeriodiquePC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    CalendrierExecutionCalculPeriodiquePC other = (CalendrierExecutionCalculPeriodiquePC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_listChronologieUnitesTraitements = m_listChronologieUnitesTraitements;
      }
    }
    super.jdoCopyFields(pc, fieldNumbers);
  }
}

/* Location:
 * Qualified Name:     CalendrierExecutionCalculPeriodiquePC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */