package fr.unedic.cali.calcul.dom.pc;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.transverse.dom.spec.DomPCSpec;
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

public abstract class UniteTraitementPC
  extends ObjetChronoPeriodePC
  implements DomPCSpec, PersistenceCapable
{
  protected int m_nbJoursFormationEnFinDUT;
  protected ConstituantsCalculActiviteReduitePC m_constituantsCalculActiviteReduiteEnFinUT;
  protected ConstituantsIndemnisationPC m_constituantsIndemnisationEnFinUT;
  protected DecalagePC m_decalageEnFinUT;
  protected boolean m_estFigee;
  private int m_cumulJoursIndemnise;
  private boolean m_estCumulJoursIndemnise;
  protected int m_nbMoisIndemniseAsu;
  private boolean m_estNbMoisIndemniseAsu;
  private String m_typeConstituantsCalculActiviteReduiteFinUT;
  private int m_cumulNbJourAct;
  protected Collection m_collectionFinQuantiteDroit;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_periode", "m_nbJoursFormationEnFinDUT", "m_constituantsCalculActiviteReduiteEnFinUT", "m_constituantsIndemnisationEnFinUT", "m_decalageEnFinUT", "m_estFigee", "m_cumulJoursIndemnise", "m_estCumulJoursIndemnise", "m_nbMoisIndemniseAsu", "m_estNbMoisIndemniseAsu", "m_typeConstituantsCalculActiviteReduiteFinUT", "m_cumulNbJourAct", "m_collectionFinQuantiteDroit" };
  private static Class[] jdoFieldTypes = { Periode.class, Integer.TYPE, ConstituantsCalculActiviteReduitePC.class, ConstituantsIndemnisationPC.class, DecalagePC.class, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, String.class, Integer.TYPE, Collection.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.MEDIATE_READ + PersistenceCapable.MEDIATE_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  static final long serialVersionUID = -356723099982712750L;
  
  public UniteTraitementPC()
  {
    jdoSetm_estFigee(this, false);
    jdoSetm_cumulJoursIndemnise(this, 0);
    jdoSetm_estCumulJoursIndemnise(this, false);
    
    jdoSetm_estNbMoisIndemniseAsu(this, false);
    
    jdoSetm_cumulNbJourAct(this, 0);
  }
  
  public abstract Object createOM();
  
  public int getNbJoursFormationEnFinDUT()
  {
    return jdoGetm_nbJoursFormationEnFinDUT(this);
  }
  
  public final void setNbJoursFormationEnFinDUT(int p_nbJoursFormationEnFinDUT)
  {
    jdoSetm_nbJoursFormationEnFinDUT(this, p_nbJoursFormationEnFinDUT);
  }
  
  public DomPCSpec getConstituantsCalculActiviteReduiteEnFinUT()
  {
    return jdoGetm_constituantsCalculActiviteReduiteEnFinUT(this);
  }
  
  public final void setConstituantsCalculActiviteReduiteEnFinUT(DomPCSpec p_constituantsCalculActiviteReduiteEnFinUT)
  {
    jdoSetm_constituantsCalculActiviteReduiteEnFinUT(this, (ConstituantsCalculActiviteReduitePC)p_constituantsCalculActiviteReduiteEnFinUT);
  }
  
  public DomPCSpec getConstituantsIndemnisationEnFinUT()
  {
    return jdoGetm_constituantsIndemnisationEnFinUT(this);
  }
  
  public final void setConstituantsIndemnisationEnFinUT(DomPCSpec p_constituantsIndemnisationEnFinUT)
  {
    jdoSetm_constituantsIndemnisationEnFinUT(this, (ConstituantsIndemnisationPC)p_constituantsIndemnisationEnFinUT);
  }
  
  public DomPCSpec getDecalageEnFinUT()
  {
    return jdoGetm_decalageEnFinUT(this);
  }
  
  public final void setDecalageEnFinUT(DomPCSpec p_decalageEnFinUT)
  {
    jdoSetm_decalageEnFinUT(this, (DecalagePC)p_decalageEnFinUT);
  }
  
  public boolean isEstFigee()
  {
    return jdoGetm_estFigee(this);
  }
  
  public final void setEstFigee(boolean p_estFigee)
  {
    jdoSetm_estFigee(this, p_estFigee);
  }
  
  public int getCumulJoursIndemnise()
  {
    return jdoGetm_cumulJoursIndemnise(this);
  }
  
  public final void setCumulJoursIndemnise(int p_cumulJoursIndemnise)
  {
    jdoSetm_cumulJoursIndemnise(this, p_cumulJoursIndemnise);
  }
  
  public boolean isEstCumulJoursIndemnise()
  {
    return jdoGetm_estCumulJoursIndemnise(this);
  }
  
  public final void setEstCumulJoursIndemnise(boolean p_estCumulJoursIndemnise)
  {
    jdoSetm_estCumulJoursIndemnise(this, p_estCumulJoursIndemnise);
  }
  
  public int getNbMoisIndemniseAsu()
  {
    return jdoGetm_nbMoisIndemniseAsu(this);
  }
  
  public final void setNbMoisIndemniseAsu(int p_nbMoisIndemniseAsu)
  {
    jdoSetm_nbMoisIndemniseAsu(this, p_nbMoisIndemniseAsu);
  }
  
  public boolean isEstNbMoisIndemniseAsu()
  {
    return jdoGetm_estNbMoisIndemniseAsu(this);
  }
  
  public final void setEstNbMoisIndemniseAsu(boolean p_estNbMoisIndemniseAsu)
  {
    jdoSetm_estNbMoisIndemniseAsu(this, p_estNbMoisIndemniseAsu);
  }
  
  public String getTypeConstituantsCalculActiviteReduiteFinUT()
  {
    return jdoGetm_typeConstituantsCalculActiviteReduiteFinUT(this);
  }
  
  public final void setTypeConstituantsCalculActiviteReduiteFinUT(String p_typeConstituantsCalculActiviteReduiteFinUT)
  {
    jdoSetm_typeConstituantsCalculActiviteReduiteFinUT(this, p_typeConstituantsCalculActiviteReduiteFinUT);
  }
  
  public int getCumulNbJourAct()
  {
    return jdoGetm_cumulNbJourAct(this);
  }
  
  public final void setCumulNbJourAct(int p_cumulNbJourAct)
  {
    jdoSetm_cumulNbJourAct(this, p_cumulNbJourAct);
  }
  
  public final Collection getCollectionEvenementFinQuantiteDroit()
  {
    if (jdoGetm_collectionFinQuantiteDroit(this) == null) {
      jdoSetm_collectionFinQuantiteDroit(this, new ArrayList());
    }
    return jdoGetm_collectionFinQuantiteDroit(this);
  }
  
  public final void ajouterEvenementFinQuantiteDroit(DomPCSpec p_finQuantiteDroit)
    throws NullPointerException
  {
    if (p_finQuantiteDroit == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_finQuantiteDroit ne devrait pas être nul.", p_finQuantiteDroit);
    }
    getCollectionEvenementFinQuantiteDroit().add(p_finQuantiteDroit);
  }
  
  public final void supprimerEvenementFinQuantiteDroit(DomPCSpec p_finQuantiteDroit)
    throws NullPointerException
  {
    if (p_finQuantiteDroit == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_finQuantiteDroit ne devrait pas être nul.", p_finQuantiteDroit);
    }
    getCollectionEvenementFinQuantiteDroit().remove(p_finQuantiteDroit);
  }
  
  static
  {
    JDOImplHelper.registerClass(UniteTraitementPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, null);
  }
  
  protected static final Periode jdoGetm_periode(UniteTraitementPC pc)
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
  
  protected static final int jdoGetm_nbJoursFormationEnFinDUT(UniteTraitementPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJoursFormationEnFinDUT;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_nbJoursFormationEnFinDUT;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 1, m_nbJoursFormationEnFinDUT);
    }
    return m_nbJoursFormationEnFinDUT;
  }
  
  protected static final ConstituantsCalculActiviteReduitePC jdoGetm_constituantsCalculActiviteReduiteEnFinUT(UniteTraitementPC pc)
  {
    if (jdoFlags <= 0) {
      return m_constituantsCalculActiviteReduiteEnFinUT;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_constituantsCalculActiviteReduiteEnFinUT;
      }
      return (ConstituantsCalculActiviteReduitePC)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_constituantsCalculActiviteReduiteEnFinUT);
    }
    return m_constituantsCalculActiviteReduiteEnFinUT;
  }
  
  protected static final ConstituantsIndemnisationPC jdoGetm_constituantsIndemnisationEnFinUT(UniteTraitementPC pc)
  {
    if (jdoFlags <= 0) {
      return m_constituantsIndemnisationEnFinUT;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_constituantsIndemnisationEnFinUT;
      }
      return (ConstituantsIndemnisationPC)sm.getObjectField(pc, jdoInheritedFieldCount + 3, m_constituantsIndemnisationEnFinUT);
    }
    return m_constituantsIndemnisationEnFinUT;
  }
  
  protected static final DecalagePC jdoGetm_decalageEnFinUT(UniteTraitementPC pc)
  {
    if (jdoFlags <= 0) {
      return m_decalageEnFinUT;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_decalageEnFinUT;
      }
      return (DecalagePC)sm.getObjectField(pc, jdoInheritedFieldCount + 4, m_decalageEnFinUT);
    }
    return m_decalageEnFinUT;
  }
  
  protected static final boolean jdoGetm_estFigee(UniteTraitementPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estFigee;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_estFigee;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 5, m_estFigee);
    }
    return m_estFigee;
  }
  
  private static final int jdoGetm_cumulJoursIndemnise(UniteTraitementPC pc)
  {
    if (jdoFlags <= 0) {
      return m_cumulJoursIndemnise;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_cumulJoursIndemnise;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 6, m_cumulJoursIndemnise);
    }
    return m_cumulJoursIndemnise;
  }
  
  private static final boolean jdoGetm_estCumulJoursIndemnise(UniteTraitementPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estCumulJoursIndemnise;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_estCumulJoursIndemnise;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 7, m_estCumulJoursIndemnise);
    }
    return m_estCumulJoursIndemnise;
  }
  
  protected static final int jdoGetm_nbMoisIndemniseAsu(UniteTraitementPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbMoisIndemniseAsu;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_nbMoisIndemniseAsu;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 8, m_nbMoisIndemniseAsu);
    }
    return m_nbMoisIndemniseAsu;
  }
  
  private static final boolean jdoGetm_estNbMoisIndemniseAsu(UniteTraitementPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estNbMoisIndemniseAsu;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 9)) {
        return m_estNbMoisIndemniseAsu;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 9, m_estNbMoisIndemniseAsu);
    }
    return m_estNbMoisIndemniseAsu;
  }
  
  private static final String jdoGetm_typeConstituantsCalculActiviteReduiteFinUT(UniteTraitementPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeConstituantsCalculActiviteReduiteFinUT;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 10)) {
        return m_typeConstituantsCalculActiviteReduiteFinUT;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 10, m_typeConstituantsCalculActiviteReduiteFinUT);
    }
    return m_typeConstituantsCalculActiviteReduiteFinUT;
  }
  
  private static final int jdoGetm_cumulNbJourAct(UniteTraitementPC pc)
  {
    if (jdoFlags <= 0) {
      return m_cumulNbJourAct;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 11)) {
        return m_cumulNbJourAct;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 11, m_cumulNbJourAct);
    }
    return m_cumulNbJourAct;
  }
  
  protected static final Collection jdoGetm_collectionFinQuantiteDroit(UniteTraitementPC pc)
  {
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 12)) {
        return m_collectionFinQuantiteDroit;
      }
      return (Collection)sm.getObjectField(pc, jdoInheritedFieldCount + 12, m_collectionFinQuantiteDroit);
    }
    return m_collectionFinQuantiteDroit;
  }
  
  protected static final void jdoSetm_periode(UniteTraitementPC pc, Periode newValue)
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
  
  protected static final void jdoSetm_nbJoursFormationEnFinDUT(UniteTraitementPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJoursFormationEnFinDUT = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 1, m_nbJoursFormationEnFinDUT, newValue);
    } else {
      m_nbJoursFormationEnFinDUT = newValue;
    }
  }
  
  protected static final void jdoSetm_constituantsCalculActiviteReduiteEnFinUT(UniteTraitementPC pc, ConstituantsCalculActiviteReduitePC newValue)
  {
    if (jdoFlags == 0)
    {
      m_constituantsCalculActiviteReduiteEnFinUT = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_constituantsCalculActiviteReduiteEnFinUT, newValue);
    } else {
      m_constituantsCalculActiviteReduiteEnFinUT = newValue;
    }
  }
  
  protected static final void jdoSetm_constituantsIndemnisationEnFinUT(UniteTraitementPC pc, ConstituantsIndemnisationPC newValue)
  {
    if (jdoFlags == 0)
    {
      m_constituantsIndemnisationEnFinUT = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 3, m_constituantsIndemnisationEnFinUT, newValue);
    } else {
      m_constituantsIndemnisationEnFinUT = newValue;
    }
  }
  
  protected static final void jdoSetm_decalageEnFinUT(UniteTraitementPC pc, DecalagePC newValue)
  {
    if (jdoFlags == 0)
    {
      m_decalageEnFinUT = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 4, m_decalageEnFinUT, newValue);
    } else {
      m_decalageEnFinUT = newValue;
    }
  }
  
  protected static final void jdoSetm_estFigee(UniteTraitementPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_estFigee = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 5, m_estFigee, newValue);
    } else {
      m_estFigee = newValue;
    }
  }
  
  private static final void jdoSetm_cumulJoursIndemnise(UniteTraitementPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_cumulJoursIndemnise = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 6, m_cumulJoursIndemnise, newValue);
    } else {
      m_cumulJoursIndemnise = newValue;
    }
  }
  
  private static final void jdoSetm_estCumulJoursIndemnise(UniteTraitementPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_estCumulJoursIndemnise = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 7, m_estCumulJoursIndemnise, newValue);
    } else {
      m_estCumulJoursIndemnise = newValue;
    }
  }
  
  protected static final void jdoSetm_nbMoisIndemniseAsu(UniteTraitementPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbMoisIndemniseAsu = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 8, m_nbMoisIndemniseAsu, newValue);
    } else {
      m_nbMoisIndemniseAsu = newValue;
    }
  }
  
  private static final void jdoSetm_estNbMoisIndemniseAsu(UniteTraitementPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_estNbMoisIndemniseAsu = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 9, m_estNbMoisIndemniseAsu, newValue);
    } else {
      m_estNbMoisIndemniseAsu = newValue;
    }
  }
  
  private static final void jdoSetm_typeConstituantsCalculActiviteReduiteFinUT(UniteTraitementPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeConstituantsCalculActiviteReduiteFinUT = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 10, m_typeConstituantsCalculActiviteReduiteFinUT, newValue);
    } else {
      m_typeConstituantsCalculActiviteReduiteFinUT = newValue;
    }
  }
  
  private static final void jdoSetm_cumulNbJourAct(UniteTraitementPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_cumulNbJourAct = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 11, m_cumulNbJourAct, newValue);
    } else {
      m_cumulNbJourAct = newValue;
    }
  }
  
  protected static final void jdoSetm_collectionFinQuantiteDroit(UniteTraitementPC pc, Collection newValue)
  {
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 12, m_collectionFinQuantiteDroit, newValue);
    } else {
      m_collectionFinQuantiteDroit = newValue;
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
      jdoStateManager.providedIntField(this, fieldNumber, m_nbJoursFormationEnFinDUT);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_constituantsCalculActiviteReduiteEnFinUT);
      break;
    case 3: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_constituantsIndemnisationEnFinUT);
      break;
    case 4: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_decalageEnFinUT);
      break;
    case 5: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_estFigee);
      break;
    case 6: 
      jdoStateManager.providedIntField(this, fieldNumber, m_cumulJoursIndemnise);
      break;
    case 7: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_estCumulJoursIndemnise);
      break;
    case 8: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbMoisIndemniseAsu);
      break;
    case 9: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_estNbMoisIndemniseAsu);
      break;
    case 10: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeConstituantsCalculActiviteReduiteFinUT);
      break;
    case 11: 
      jdoStateManager.providedIntField(this, fieldNumber, m_cumulNbJourAct);
      break;
    case 12: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_collectionFinQuantiteDroit);
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
      m_nbJoursFormationEnFinDUT = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 2: 
      m_constituantsCalculActiviteReduiteEnFinUT = ((ConstituantsCalculActiviteReduitePC)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 3: 
      m_constituantsIndemnisationEnFinUT = ((ConstituantsIndemnisationPC)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 4: 
      m_decalageEnFinUT = ((DecalagePC)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 5: 
      m_estFigee = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 6: 
      m_cumulJoursIndemnise = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 7: 
      m_estCumulJoursIndemnise = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 8: 
      m_nbMoisIndemniseAsu = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 9: 
      m_estNbMoisIndemniseAsu = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 10: 
      m_typeConstituantsCalculActiviteReduiteFinUT = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 11: 
      m_cumulNbJourAct = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 12: 
      m_collectionFinQuantiteDroit = ((Collection)jdoStateManager.replacingObjectField(this, fieldNumber));
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
    //   0: new 145	javax/jdo/JDOFatalInternalException
    //   3: dup
    //   4: ldc_w 534
    //   7: invokespecial 439	javax/jdo/JDOFatalInternalException:<init>	(Ljava/lang/String;)V
    //   10: athrow
    //   11: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	12	0	this	UniteTraitementPC
    //   0	12	1	sm	StateManager
  }
  
  /* Error */
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    // Byte code:
    //   0: new 145	javax/jdo/JDOFatalInternalException
    //   3: dup
    //   4: ldc_w 534
    //   7: invokespecial 439	javax/jdo/JDOFatalInternalException:<init>	(Ljava/lang/String;)V
    //   10: athrow
    //   11: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	12	0	this	UniteTraitementPC
    //   0	12	1	sm	StateManager
    //   0	12	2	oid	Object
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 13;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof UniteTraitementPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    UniteTraitementPC other = (UniteTraitementPC)pc;
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
        m_nbJoursFormationEnFinDUT = m_nbJoursFormationEnFinDUT;
        break;
      case 2: 
        m_constituantsCalculActiviteReduiteEnFinUT = m_constituantsCalculActiviteReduiteEnFinUT;
        break;
      case 3: 
        m_constituantsIndemnisationEnFinUT = m_constituantsIndemnisationEnFinUT;
        break;
      case 4: 
        m_decalageEnFinUT = m_decalageEnFinUT;
        break;
      case 5: 
        m_estFigee = m_estFigee;
        break;
      case 6: 
        m_cumulJoursIndemnise = m_cumulJoursIndemnise;
        break;
      case 7: 
        m_estCumulJoursIndemnise = m_estCumulJoursIndemnise;
        break;
      case 8: 
        m_nbMoisIndemniseAsu = m_nbMoisIndemniseAsu;
        break;
      case 9: 
        m_estNbMoisIndemniseAsu = m_estNbMoisIndemniseAsu;
        break;
      case 10: 
        m_typeConstituantsCalculActiviteReduiteFinUT = m_typeConstituantsCalculActiviteReduiteFinUT;
        break;
      case 11: 
        m_cumulNbJourAct = m_cumulNbJourAct;
        break;
      case 12: 
        m_collectionFinQuantiteDroit = m_collectionFinQuantiteDroit;
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
 * Qualified Name:     UniteTraitementPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */