package fr.unedic.cali.calcul.pbjc.dom.pc;

import fr.unedic.cali.calcul.pbjc.dom.EnquetePbjcNcp;
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

public class EnquetePbjcNcpPC
  implements DomPCSpec, PersistenceCapable
{
  private transient EnquetePbjcNcp m_enquetePbjcNcpOM;
  protected int m_identOuvertureDroit;
  protected Damj m_dateSituationSuivi;
  protected int m_typeSituationSuivi;
  protected String m_codeProduit;
  protected int m_rangSituation;
  protected int m_identReprisePorteuse;
  protected boolean m_situationAEmettre;
  protected String m_situationParticuliere;
  private String m_codeSousProduit;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_identOuvertureDroit", "m_dateSituationSuivi", "m_typeSituationSuivi", "m_codeProduit", "m_rangSituation", "m_identReprisePorteuse", "m_situationAEmettre", "m_situationParticuliere", "m_codeSousProduit" };
  private static Class[] jdoFieldTypes = { Integer.TYPE, Damj.class, Integer.TYPE, String.class, Integer.TYPE, Integer.TYPE, Boolean.TYPE, String.class, String.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_enquetePbjcNcpOM == null) {
      m_enquetePbjcNcpOM = new EnquetePbjcNcp(this);
    }
    return m_enquetePbjcNcpOM;
  }
  
  public int getIdentOuvertureDroit()
  {
    return jdoGetm_identOuvertureDroit(this);
  }
  
  public final void setIdentOuvertureDroit(int p_identOuvertureDroit)
  {
    jdoSetm_identOuvertureDroit(this, p_identOuvertureDroit);
  }
  
  public Damj getDateSituationSuivi()
  {
    return jdoGetm_dateSituationSuivi(this);
  }
  
  public final void setDateSituationSuivi(Damj p_dateSituationSuivi)
  {
    jdoSetm_dateSituationSuivi(this, p_dateSituationSuivi);
  }
  
  public int getTypeSituationSuivi()
  {
    return jdoGetm_typeSituationSuivi(this);
  }
  
  public final void setTypeSituationSuivi(int p_typeSituationSuivi)
  {
    jdoSetm_typeSituationSuivi(this, p_typeSituationSuivi);
  }
  
  public String getCodeProduit()
  {
    return jdoGetm_codeProduit(this);
  }
  
  public final void setCodeProduit(String p_codeProduit)
  {
    jdoSetm_codeProduit(this, p_codeProduit);
  }
  
  public int getRangSituation()
  {
    return jdoGetm_rangSituation(this);
  }
  
  public final void setRangSituation(int p_rangSituation)
  {
    jdoSetm_rangSituation(this, p_rangSituation);
  }
  
  public int getIdentReprisePorteuse()
  {
    return jdoGetm_identReprisePorteuse(this);
  }
  
  public final void setIdentReprisePorteuse(int p_identReprisePorteuse)
  {
    jdoSetm_identReprisePorteuse(this, p_identReprisePorteuse);
  }
  
  public boolean isSituationAEmettre()
  {
    return jdoGetm_situationAEmettre(this);
  }
  
  public final void setSituationAEmettre(boolean p_situationAEmettre)
  {
    jdoSetm_situationAEmettre(this, p_situationAEmettre);
  }
  
  public String getSituationParticuliere()
  {
    return jdoGetm_situationParticuliere(this);
  }
  
  public final void setSituationParticuliere(String p_situationParticuliere)
  {
    jdoSetm_situationParticuliere(this, p_situationParticuliere);
  }
  
  public String getCodeSousProduit()
  {
    return jdoGetm_codeSousProduit(this);
  }
  
  public final void setCodeSousProduit(String p_codeSousProduit)
  {
    jdoSetm_codeSousProduit(this, p_codeSousProduit);
  }
  
  static
  {
    JDOImplHelper.registerClass(EnquetePbjcNcpPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new EnquetePbjcNcpPC());
  }
  
  protected static final int jdoGetm_identOuvertureDroit(EnquetePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identOuvertureDroit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_identOuvertureDroit;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 0, m_identOuvertureDroit);
    }
    return m_identOuvertureDroit;
  }
  
  protected static final Damj jdoGetm_dateSituationSuivi(EnquetePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateSituationSuivi;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_dateSituationSuivi;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_dateSituationSuivi);
    }
    return m_dateSituationSuivi;
  }
  
  protected static final int jdoGetm_typeSituationSuivi(EnquetePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeSituationSuivi;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_typeSituationSuivi;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 2, m_typeSituationSuivi);
    }
    return m_typeSituationSuivi;
  }
  
  protected static final String jdoGetm_codeProduit(EnquetePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeProduit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_codeProduit;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 3, m_codeProduit);
    }
    return m_codeProduit;
  }
  
  protected static final int jdoGetm_rangSituation(EnquetePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_rangSituation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_rangSituation;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 4, m_rangSituation);
    }
    return m_rangSituation;
  }
  
  protected static final int jdoGetm_identReprisePorteuse(EnquetePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identReprisePorteuse;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_identReprisePorteuse;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 5, m_identReprisePorteuse);
    }
    return m_identReprisePorteuse;
  }
  
  protected static final boolean jdoGetm_situationAEmettre(EnquetePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_situationAEmettre;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_situationAEmettre;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 6, m_situationAEmettre);
    }
    return m_situationAEmettre;
  }
  
  protected static final String jdoGetm_situationParticuliere(EnquetePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_situationParticuliere;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_situationParticuliere;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 7, m_situationParticuliere);
    }
    return m_situationParticuliere;
  }
  
  private static final String jdoGetm_codeSousProduit(EnquetePbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeSousProduit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_codeSousProduit;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 8, m_codeSousProduit);
    }
    return m_codeSousProduit;
  }
  
  protected static final void jdoSetm_identOuvertureDroit(EnquetePbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_identOuvertureDroit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 0, m_identOuvertureDroit, newValue);
    } else {
      m_identOuvertureDroit = newValue;
    }
  }
  
  protected static final void jdoSetm_dateSituationSuivi(EnquetePbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateSituationSuivi = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_dateSituationSuivi, newValue);
    } else {
      m_dateSituationSuivi = newValue;
    }
  }
  
  protected static final void jdoSetm_typeSituationSuivi(EnquetePbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeSituationSuivi = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 2, m_typeSituationSuivi, newValue);
    } else {
      m_typeSituationSuivi = newValue;
    }
  }
  
  protected static final void jdoSetm_codeProduit(EnquetePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeProduit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 3, m_codeProduit, newValue);
    } else {
      m_codeProduit = newValue;
    }
  }
  
  protected static final void jdoSetm_rangSituation(EnquetePbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_rangSituation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 4, m_rangSituation, newValue);
    } else {
      m_rangSituation = newValue;
    }
  }
  
  protected static final void jdoSetm_identReprisePorteuse(EnquetePbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_identReprisePorteuse = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 5, m_identReprisePorteuse, newValue);
    } else {
      m_identReprisePorteuse = newValue;
    }
  }
  
  protected static final void jdoSetm_situationAEmettre(EnquetePbjcNcpPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_situationAEmettre = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 6, m_situationAEmettre, newValue);
    } else {
      m_situationAEmettre = newValue;
    }
  }
  
  protected static final void jdoSetm_situationParticuliere(EnquetePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_situationParticuliere = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 7, m_situationParticuliere, newValue);
    } else {
      m_situationParticuliere = newValue;
    }
  }
  
  private static final void jdoSetm_codeSousProduit(EnquetePbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeSousProduit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 8, m_codeSousProduit, newValue);
    } else {
      m_codeSousProduit = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedIntField(this, fieldNumber, m_identOuvertureDroit);
      break;
    case 1: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateSituationSuivi);
      break;
    case 2: 
      jdoStateManager.providedIntField(this, fieldNumber, m_typeSituationSuivi);
      break;
    case 3: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeProduit);
      break;
    case 4: 
      jdoStateManager.providedIntField(this, fieldNumber, m_rangSituation);
      break;
    case 5: 
      jdoStateManager.providedIntField(this, fieldNumber, m_identReprisePorteuse);
      break;
    case 6: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_situationAEmettre);
      break;
    case 7: 
      jdoStateManager.providedStringField(this, fieldNumber, m_situationParticuliere);
      break;
    case 8: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeSousProduit);
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
      m_identOuvertureDroit = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 1: 
      m_dateSituationSuivi = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_typeSituationSuivi = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 3: 
      m_codeProduit = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 4: 
      m_rangSituation = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 5: 
      m_identReprisePorteuse = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 6: 
      m_situationAEmettre = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 7: 
      m_situationParticuliere = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 8: 
      m_codeSousProduit = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
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
    EnquetePbjcNcpPC pc = new EnquetePbjcNcpPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    EnquetePbjcNcpPC pc = new EnquetePbjcNcpPC();
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
    if (!(pc instanceof EnquetePbjcNcpPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    EnquetePbjcNcpPC other = (EnquetePbjcNcpPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_identOuvertureDroit = m_identOuvertureDroit;
        break;
      case 1: 
        m_dateSituationSuivi = m_dateSituationSuivi;
        break;
      case 2: 
        m_typeSituationSuivi = m_typeSituationSuivi;
        break;
      case 3: 
        m_codeProduit = m_codeProduit;
        break;
      case 4: 
        m_rangSituation = m_rangSituation;
        break;
      case 5: 
        m_identReprisePorteuse = m_identReprisePorteuse;
        break;
      case 6: 
        m_situationAEmettre = m_situationAEmettre;
        break;
      case 7: 
        m_situationParticuliere = m_situationParticuliere;
        break;
      case 8: 
        m_codeSousProduit = m_codeSousProduit;
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
 * Qualified Name:     EnquetePbjcNcpPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */