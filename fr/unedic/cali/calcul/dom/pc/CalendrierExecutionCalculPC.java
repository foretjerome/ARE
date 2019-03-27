package fr.unedic.cali.calcul.dom.pc;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriodePC;
import fr.unedic.util.temps.Periode;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
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

public abstract class CalendrierExecutionCalculPC
  extends ObjetChronoPeriodePC
  implements DomPCSpec, PersistenceCapable
{
  protected int m_etatAttribution;
  protected Damj m_dernierJourIndemnisablePourSuivi;
  protected EtatAuDjiPC m_etatAuDji;
  protected Damj m_dateFinDispositifCSP;
  protected Collection m_listePNDS;
  protected Collection m_listeDNJ;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_periode", "m_etatAttribution", "m_dernierJourIndemnisablePourSuivi", "m_etatAuDji", "m_dateFinDispositifCSP", "m_listePNDS", "m_listeDNJ" };
  private static Class[] jdoFieldTypes = { Periode.class, Integer.TYPE, Damj.class, EtatAuDjiPC.class, Damj.class, Collection.class, Collection.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.MEDIATE_READ + PersistenceCapable.MEDIATE_WRITE), (byte)(PersistenceCapable.MEDIATE_READ + PersistenceCapable.MEDIATE_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  static final long serialVersionUID = 4012414250063723170L;
  
  public abstract Object createOM();
  
  public int getEtatAttribution()
  {
    return jdoGetm_etatAttribution(this);
  }
  
  public final void setEtatAttribution(int p_etatAttribution)
  {
    jdoSetm_etatAttribution(this, p_etatAttribution);
  }
  
  public Damj getDernierJourIndemnisablePourSuivi()
  {
    return jdoGetm_dernierJourIndemnisablePourSuivi(this);
  }
  
  public final void setDernierJourIndemnisablePourSuivi(Damj p_dernierJourIndemnisablePourSuivi)
  {
    jdoSetm_dernierJourIndemnisablePourSuivi(this, p_dernierJourIndemnisablePourSuivi);
  }
  
  public DomPCSpec getEtatAuDji()
  {
    return jdoGetm_etatAuDji(this);
  }
  
  public final void setEtatAuDji(DomPCSpec p_etatAuDji)
  {
    jdoSetm_etatAuDji(this, (EtatAuDjiPC)p_etatAuDji);
  }
  
  public Damj getDateFinDispositifCSP()
  {
    return jdoGetm_dateFinDispositifCSP(this);
  }
  
  public final void setDateFinDispositifCSP(Damj p_dateFinDispositifCSP)
  {
    jdoSetm_dateFinDispositifCSP(this, p_dateFinDispositifCSP);
  }
  
  public final Collection getCollectionPNDS()
  {
    if (jdoGetm_listePNDS(this) == null) {
      jdoSetm_listePNDS(this, new ArrayList());
    }
    return jdoGetm_listePNDS(this);
  }
  
  public final void ajouterPNDS(DomPCSpec p_periode)
    throws NullPointerException
  {
    if (p_periode == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periode ne devrait pas être nul.", p_periode);
    }
    getCollectionPNDS().add(p_periode);
  }
  
  public final void supprimerPNDS(DomPCSpec p_periode)
    throws NullPointerException
  {
    if (p_periode == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periode ne devrait pas être nul.", p_periode);
    }
    getCollectionPNDS().remove(p_periode);
  }
  
  public final Collection getCollectionDNJ()
  {
    if (jdoGetm_listeDNJ(this) == null) {
      jdoSetm_listeDNJ(this, new ArrayList());
    }
    return jdoGetm_listeDNJ(this);
  }
  
  public final void ajouterDNJ(DomPCSpec p_periode)
    throws NullPointerException
  {
    if (p_periode == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periode ne devrait pas être nul.", p_periode);
    }
    getCollectionDNJ().add(p_periode);
  }
  
  public final void supprimerDNJ(DomPCSpec p_periode)
    throws NullPointerException
  {
    if (p_periode == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periode ne devrait pas être nul.", p_periode);
    }
    getCollectionDNJ().remove(p_periode);
  }
  
  static
  {
    JDOImplHelper.registerClass(CalendrierExecutionCalculPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, null);
  }
  
  protected static final Periode jdoGetm_periode(CalendrierExecutionCalculPC pc)
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
  
  protected static final int jdoGetm_etatAttribution(CalendrierExecutionCalculPC pc)
  {
    if (jdoFlags <= 0) {
      return m_etatAttribution;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_etatAttribution;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 1, m_etatAttribution);
    }
    return m_etatAttribution;
  }
  
  protected static final Damj jdoGetm_dernierJourIndemnisablePourSuivi(CalendrierExecutionCalculPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dernierJourIndemnisablePourSuivi;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_dernierJourIndemnisablePourSuivi;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_dernierJourIndemnisablePourSuivi);
    }
    return m_dernierJourIndemnisablePourSuivi;
  }
  
  protected static final EtatAuDjiPC jdoGetm_etatAuDji(CalendrierExecutionCalculPC pc)
  {
    if (jdoFlags <= 0) {
      return m_etatAuDji;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_etatAuDji;
      }
      return (EtatAuDjiPC)sm.getObjectField(pc, jdoInheritedFieldCount + 3, m_etatAuDji);
    }
    return m_etatAuDji;
  }
  
  protected static final Damj jdoGetm_dateFinDispositifCSP(CalendrierExecutionCalculPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinDispositifCSP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_dateFinDispositifCSP;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 4, m_dateFinDispositifCSP);
    }
    return m_dateFinDispositifCSP;
  }
  
  protected static final Collection jdoGetm_listePNDS(CalendrierExecutionCalculPC pc)
  {
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_listePNDS;
      }
      return (Collection)sm.getObjectField(pc, jdoInheritedFieldCount + 5, m_listePNDS);
    }
    return m_listePNDS;
  }
  
  protected static final Collection jdoGetm_listeDNJ(CalendrierExecutionCalculPC pc)
  {
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_listeDNJ;
      }
      return (Collection)sm.getObjectField(pc, jdoInheritedFieldCount + 6, m_listeDNJ);
    }
    return m_listeDNJ;
  }
  
  protected static final void jdoSetm_periode(CalendrierExecutionCalculPC pc, Periode newValue)
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
  
  protected static final void jdoSetm_etatAttribution(CalendrierExecutionCalculPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_etatAttribution = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 1, m_etatAttribution, newValue);
    } else {
      m_etatAttribution = newValue;
    }
  }
  
  protected static final void jdoSetm_dernierJourIndemnisablePourSuivi(CalendrierExecutionCalculPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dernierJourIndemnisablePourSuivi = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_dernierJourIndemnisablePourSuivi, newValue);
    } else {
      m_dernierJourIndemnisablePourSuivi = newValue;
    }
  }
  
  protected static final void jdoSetm_etatAuDji(CalendrierExecutionCalculPC pc, EtatAuDjiPC newValue)
  {
    if (jdoFlags == 0)
    {
      m_etatAuDji = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 3, m_etatAuDji, newValue);
    } else {
      m_etatAuDji = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinDispositifCSP(CalendrierExecutionCalculPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinDispositifCSP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 4, m_dateFinDispositifCSP, newValue);
    } else {
      m_dateFinDispositifCSP = newValue;
    }
  }
  
  protected static final void jdoSetm_listePNDS(CalendrierExecutionCalculPC pc, Collection newValue)
  {
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 5, m_listePNDS, newValue);
    } else {
      m_listePNDS = newValue;
    }
  }
  
  protected static final void jdoSetm_listeDNJ(CalendrierExecutionCalculPC pc, Collection newValue)
  {
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 6, m_listeDNJ, newValue);
    } else {
      m_listeDNJ = newValue;
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
      jdoStateManager.providedIntField(this, fieldNumber, m_etatAttribution);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dernierJourIndemnisablePourSuivi);
      break;
    case 3: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_etatAuDji);
      break;
    case 4: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinDispositifCSP);
      break;
    case 5: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_listePNDS);
      break;
    case 6: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_listeDNJ);
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
      m_etatAttribution = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 2: 
      m_dernierJourIndemnisablePourSuivi = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 3: 
      m_etatAuDji = ((EtatAuDjiPC)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 4: 
      m_dateFinDispositifCSP = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 5: 
      m_listePNDS = ((Collection)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 6: 
      m_listeDNJ = ((Collection)jdoStateManager.replacingObjectField(this, fieldNumber));
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
  
  /* Error */
  public PersistenceCapable jdoNewInstance(StateManager sm)
  {
    // Byte code:
    //   0: new 102	javax/jdo/JDOFatalInternalException
    //   3: dup
    //   4: ldc_w 403
    //   7: invokespecial 314	javax/jdo/JDOFatalInternalException:<init>	(Ljava/lang/String;)V
    //   10: athrow
    //   11: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	12	0	this	CalendrierExecutionCalculPC
    //   0	12	1	sm	StateManager
  }
  
  /* Error */
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    // Byte code:
    //   0: new 102	javax/jdo/JDOFatalInternalException
    //   3: dup
    //   4: ldc_w 403
    //   7: invokespecial 314	javax/jdo/JDOFatalInternalException:<init>	(Ljava/lang/String;)V
    //   10: athrow
    //   11: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	12	0	this	CalendrierExecutionCalculPC
    //   0	12	1	sm	StateManager
    //   0	12	2	oid	Object
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 7;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof CalendrierExecutionCalculPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    CalendrierExecutionCalculPC other = (CalendrierExecutionCalculPC)pc;
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
        m_etatAttribution = m_etatAttribution;
        break;
      case 2: 
        m_dernierJourIndemnisablePourSuivi = m_dernierJourIndemnisablePourSuivi;
        break;
      case 3: 
        m_etatAuDji = m_etatAuDji;
        break;
      case 4: 
        m_dateFinDispositifCSP = m_dateFinDispositifCSP;
        break;
      case 5: 
        m_listePNDS = m_listePNDS;
        break;
      case 6: 
        m_listeDNJ = m_listeDNJ;
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
 * Qualified Name:     CalendrierExecutionCalculPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */