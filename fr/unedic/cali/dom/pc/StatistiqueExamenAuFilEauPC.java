package fr.unedic.cali.dom.pc;

import fr.unedic.cali.dom.StatistiqueExamenAuFilEau;
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

public class StatistiqueExamenAuFilEauPC
  implements DomPCSpec, PersistenceCapable
{
  private transient StatistiqueExamenAuFilEau m_statistiqueExamenAuFilEauOM;
  private Damj m_dateEvenement;
  private Damj m_dateEvenementDeclencheur;
  private int m_natureDeclencheur;
  private Damj m_datePremiereFctEtudiee;
  private Damj m_datePremiereFctEtudieeSansAffiSimplifiee;
  private Damj m_dateDerniereFctEtudiee;
  private int m_nombreTotalFctEtudiees;
  private int m_resultatExamen;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_dateEvenement", "m_dateEvenementDeclencheur", "m_natureDeclencheur", "m_datePremiereFctEtudiee", "m_datePremiereFctEtudieeSansAffiSimplifiee", "m_dateDerniereFctEtudiee", "m_nombreTotalFctEtudiees", "m_resultatExamen" };
  private static Class[] jdoFieldTypes = { Damj.class, Damj.class, Integer.TYPE, Damj.class, Damj.class, Damj.class, Integer.TYPE, Integer.TYPE };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_statistiqueExamenAuFilEauOM == null) {
      m_statistiqueExamenAuFilEauOM = new StatistiqueExamenAuFilEau(this);
    }
    return m_statistiqueExamenAuFilEauOM;
  }
  
  public Damj getDateEvenement()
  {
    return jdoGetm_dateEvenement(this);
  }
  
  public final void setDateEvenement(Damj p_dateEvenement)
  {
    jdoSetm_dateEvenement(this, p_dateEvenement);
  }
  
  public Damj getDateEvenementDeclencheur()
  {
    return jdoGetm_dateEvenementDeclencheur(this);
  }
  
  public final void setDateEvenementDeclencheur(Damj p_dateEvenementDeclencheur)
  {
    jdoSetm_dateEvenementDeclencheur(this, p_dateEvenementDeclencheur);
  }
  
  public int getNatureDeclencheur()
  {
    return jdoGetm_natureDeclencheur(this);
  }
  
  public final void setNatureDeclencheur(int p_natureDeclencheur)
  {
    jdoSetm_natureDeclencheur(this, p_natureDeclencheur);
  }
  
  public Damj getDatePremiereFctEtudiee()
  {
    return jdoGetm_datePremiereFctEtudiee(this);
  }
  
  public final void setDatePremiereFctEtudiee(Damj p_datePremiereFctEtudiee)
  {
    jdoSetm_datePremiereFctEtudiee(this, p_datePremiereFctEtudiee);
  }
  
  public Damj getDatePremiereFctEtudieeSansAffiSimplifiee()
  {
    return jdoGetm_datePremiereFctEtudieeSansAffiSimplifiee(this);
  }
  
  public final void setDatePremiereFctEtudieeSansAffiSimplifiee(Damj p_datePremiereFctEtudieeSansAffiSimplifiee)
  {
    jdoSetm_datePremiereFctEtudieeSansAffiSimplifiee(this, p_datePremiereFctEtudieeSansAffiSimplifiee);
  }
  
  public Damj getDateDerniereFctEtudiee()
  {
    return jdoGetm_dateDerniereFctEtudiee(this);
  }
  
  public final void setDateDerniereFctEtudiee(Damj p_dateDerniereFctEtudiee)
  {
    jdoSetm_dateDerniereFctEtudiee(this, p_dateDerniereFctEtudiee);
  }
  
  public int getNombreTotalFctEtudiees()
  {
    return jdoGetm_nombreTotalFctEtudiees(this);
  }
  
  public final void setNombreTotalFctEtudiees(int p_nombreTotalFctEtudiees)
  {
    jdoSetm_nombreTotalFctEtudiees(this, p_nombreTotalFctEtudiees);
  }
  
  public int getResultatExamen()
  {
    return jdoGetm_resultatExamen(this);
  }
  
  public final void setResultatExamen(int p_resultatExamen)
  {
    jdoSetm_resultatExamen(this, p_resultatExamen);
  }
  
  static
  {
    JDOImplHelper.registerClass(StatistiqueExamenAuFilEauPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new StatistiqueExamenAuFilEauPC());
  }
  
  private static final Damj jdoGetm_dateEvenement(StatistiqueExamenAuFilEauPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateEvenement;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_dateEvenement;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 0, m_dateEvenement);
    }
    return m_dateEvenement;
  }
  
  private static final Damj jdoGetm_dateEvenementDeclencheur(StatistiqueExamenAuFilEauPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateEvenementDeclencheur;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_dateEvenementDeclencheur;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_dateEvenementDeclencheur);
    }
    return m_dateEvenementDeclencheur;
  }
  
  private static final int jdoGetm_natureDeclencheur(StatistiqueExamenAuFilEauPC pc)
  {
    if (jdoFlags <= 0) {
      return m_natureDeclencheur;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_natureDeclencheur;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 2, m_natureDeclencheur);
    }
    return m_natureDeclencheur;
  }
  
  private static final Damj jdoGetm_datePremiereFctEtudiee(StatistiqueExamenAuFilEauPC pc)
  {
    if (jdoFlags <= 0) {
      return m_datePremiereFctEtudiee;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_datePremiereFctEtudiee;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 3, m_datePremiereFctEtudiee);
    }
    return m_datePremiereFctEtudiee;
  }
  
  private static final Damj jdoGetm_datePremiereFctEtudieeSansAffiSimplifiee(StatistiqueExamenAuFilEauPC pc)
  {
    if (jdoFlags <= 0) {
      return m_datePremiereFctEtudieeSansAffiSimplifiee;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_datePremiereFctEtudieeSansAffiSimplifiee;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 4, m_datePremiereFctEtudieeSansAffiSimplifiee);
    }
    return m_datePremiereFctEtudieeSansAffiSimplifiee;
  }
  
  private static final Damj jdoGetm_dateDerniereFctEtudiee(StatistiqueExamenAuFilEauPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDerniereFctEtudiee;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_dateDerniereFctEtudiee;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 5, m_dateDerniereFctEtudiee);
    }
    return m_dateDerniereFctEtudiee;
  }
  
  private static final int jdoGetm_nombreTotalFctEtudiees(StatistiqueExamenAuFilEauPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nombreTotalFctEtudiees;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_nombreTotalFctEtudiees;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 6, m_nombreTotalFctEtudiees);
    }
    return m_nombreTotalFctEtudiees;
  }
  
  private static final int jdoGetm_resultatExamen(StatistiqueExamenAuFilEauPC pc)
  {
    if (jdoFlags <= 0) {
      return m_resultatExamen;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_resultatExamen;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 7, m_resultatExamen);
    }
    return m_resultatExamen;
  }
  
  private static final void jdoSetm_dateEvenement(StatistiqueExamenAuFilEauPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateEvenement = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 0, m_dateEvenement, newValue);
    } else {
      m_dateEvenement = newValue;
    }
  }
  
  private static final void jdoSetm_dateEvenementDeclencheur(StatistiqueExamenAuFilEauPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateEvenementDeclencheur = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_dateEvenementDeclencheur, newValue);
    } else {
      m_dateEvenementDeclencheur = newValue;
    }
  }
  
  private static final void jdoSetm_natureDeclencheur(StatistiqueExamenAuFilEauPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_natureDeclencheur = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 2, m_natureDeclencheur, newValue);
    } else {
      m_natureDeclencheur = newValue;
    }
  }
  
  private static final void jdoSetm_datePremiereFctEtudiee(StatistiqueExamenAuFilEauPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_datePremiereFctEtudiee = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 3, m_datePremiereFctEtudiee, newValue);
    } else {
      m_datePremiereFctEtudiee = newValue;
    }
  }
  
  private static final void jdoSetm_datePremiereFctEtudieeSansAffiSimplifiee(StatistiqueExamenAuFilEauPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_datePremiereFctEtudieeSansAffiSimplifiee = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 4, m_datePremiereFctEtudieeSansAffiSimplifiee, newValue);
    } else {
      m_datePremiereFctEtudieeSansAffiSimplifiee = newValue;
    }
  }
  
  private static final void jdoSetm_dateDerniereFctEtudiee(StatistiqueExamenAuFilEauPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDerniereFctEtudiee = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 5, m_dateDerniereFctEtudiee, newValue);
    } else {
      m_dateDerniereFctEtudiee = newValue;
    }
  }
  
  private static final void jdoSetm_nombreTotalFctEtudiees(StatistiqueExamenAuFilEauPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nombreTotalFctEtudiees = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 6, m_nombreTotalFctEtudiees, newValue);
    } else {
      m_nombreTotalFctEtudiees = newValue;
    }
  }
  
  private static final void jdoSetm_resultatExamen(StatistiqueExamenAuFilEauPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_resultatExamen = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 7, m_resultatExamen, newValue);
    } else {
      m_resultatExamen = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateEvenement);
      break;
    case 1: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateEvenementDeclencheur);
      break;
    case 2: 
      jdoStateManager.providedIntField(this, fieldNumber, m_natureDeclencheur);
      break;
    case 3: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_datePremiereFctEtudiee);
      break;
    case 4: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_datePremiereFctEtudieeSansAffiSimplifiee);
      break;
    case 5: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDerniereFctEtudiee);
      break;
    case 6: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nombreTotalFctEtudiees);
      break;
    case 7: 
      jdoStateManager.providedIntField(this, fieldNumber, m_resultatExamen);
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
      m_dateEvenement = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 1: 
      m_dateEvenementDeclencheur = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_natureDeclencheur = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 3: 
      m_datePremiereFctEtudiee = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 4: 
      m_datePremiereFctEtudieeSansAffiSimplifiee = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 5: 
      m_dateDerniereFctEtudiee = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 6: 
      m_nombreTotalFctEtudiees = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 7: 
      m_resultatExamen = jdoStateManager.replacingIntField(this, fieldNumber);
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
    StatistiqueExamenAuFilEauPC pc = new StatistiqueExamenAuFilEauPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    StatistiqueExamenAuFilEauPC pc = new StatistiqueExamenAuFilEauPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 8;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof StatistiqueExamenAuFilEauPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    StatistiqueExamenAuFilEauPC other = (StatistiqueExamenAuFilEauPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_dateEvenement = m_dateEvenement;
        break;
      case 1: 
        m_dateEvenementDeclencheur = m_dateEvenementDeclencheur;
        break;
      case 2: 
        m_natureDeclencheur = m_natureDeclencheur;
        break;
      case 3: 
        m_datePremiereFctEtudiee = m_datePremiereFctEtudiee;
        break;
      case 4: 
        m_datePremiereFctEtudieeSansAffiSimplifiee = m_datePremiereFctEtudieeSansAffiSimplifiee;
        break;
      case 5: 
        m_dateDerniereFctEtudiee = m_dateDerniereFctEtudiee;
        break;
      case 6: 
        m_nombreTotalFctEtudiees = m_nombreTotalFctEtudiees;
        break;
      case 7: 
        m_resultatExamen = m_resultatExamen;
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
 * Qualified Name:     StatistiqueExamenAuFilEauPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */