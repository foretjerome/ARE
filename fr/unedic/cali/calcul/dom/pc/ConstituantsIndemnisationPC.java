package fr.unedic.cali.calcul.dom.pc;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.dom.pc.CapitalIndemnisationAbstraitPC;
import fr.unedic.cali.dom.pc.DureeDetectionMaintienAbstraitePC;
import fr.unedic.cali.dom.pc.DureeFinancementAbstraitePC;
import fr.unedic.cali.dom.pc.DureeIndemnisationAbstraitePC;
import fr.unedic.cali.dom.pc.DureeProlongationAbstraitePC;
import fr.unedic.cali.dom.pc.DureeRenouvellementAbstraitePC;
import fr.unedic.cali.dom.pc.RemboursementFraisIndemnisationAbstraitPC;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;
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

public class ConstituantsIndemnisationPC
  implements DomPCSpec, PersistenceCapable
{
  private transient ConstituantsIndemnisation m_constituantsIndemnisationOM;
  protected String m_codeFormuleMontant;
  protected DureeIndemnisationAbstraitePC m_dureeIndemnisation;
  protected DureeRenouvellementAbstraitePC m_dureeRenouvellement;
  protected DureeDetectionMaintienAbstraitePC m_dureeDetectionMaintien;
  protected RemboursementFraisIndemnisationAbstraitPC m_fraisRemboursementIndemnisation;
  protected DureeProlongationAbstraitePC m_dureeProlongation;
  private Quantite m_montantServi;
  public CapitalIndemnisationAbstraitPC m_capitalIndemnisation;
  public DureeFinancementAbstraitePC m_dureeFinancement;
  private Quantite m_montantIndemNonDerog;
  private Quantite m_montantIndemDerog;
  private Integer m_rangTranche;
  protected Damj m_dateFinDispositifCSP;
  protected int m_cumulTotalAllongementAREF;
  public Collection m_listeDureeNonIndemnisables;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_codeFormuleMontant", "m_dureeIndemnisation", "m_dureeRenouvellement", "m_dureeDetectionMaintien", "m_fraisRemboursementIndemnisation", "m_dureeProlongation", "m_montantServi", "m_capitalIndemnisation", "m_dureeFinancement", "m_montantIndemNonDerog", "m_montantIndemDerog", "m_rangTranche", "m_dateFinDispositifCSP", "m_cumulTotalAllongementAREF", "m_listeDureeNonIndemnisables" };
  private static Class[] jdoFieldTypes = { String.class, DureeIndemnisationAbstraitePC.class, DureeRenouvellementAbstraitePC.class, DureeDetectionMaintienAbstraitePC.class, RemboursementFraisIndemnisationAbstraitPC.class, DureeProlongationAbstraitePC.class, Quantite.class, CapitalIndemnisationAbstraitPC.class, DureeFinancementAbstraitePC.class, Quantite.class, Quantite.class, Integer.class, Damj.class, Integer.TYPE, Collection.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.MEDIATE_READ + PersistenceCapable.MEDIATE_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public ConstituantsIndemnisationPC()
  {
    jdoSetm_codeFormuleMontant(this, null);
    jdoSetm_dureeIndemnisation(this, null);
    jdoSetm_dureeRenouvellement(this, null);
    jdoSetm_dureeDetectionMaintien(this, null);
    jdoSetm_fraisRemboursementIndemnisation(this, null);
    jdoSetm_dureeProlongation(this, null);
  }
  
  public Object createOM()
  {
    if (m_constituantsIndemnisationOM == null) {
      m_constituantsIndemnisationOM = new ConstituantsIndemnisation(this);
    }
    return m_constituantsIndemnisationOM;
  }
  
  public String getCodeFormuleMontant()
  {
    return jdoGetm_codeFormuleMontant(this);
  }
  
  public final void setCodeFormuleMontant(String p_codeFormuleMontant)
  {
    jdoSetm_codeFormuleMontant(this, p_codeFormuleMontant);
  }
  
  public DomPCSpec getDureeIndemnisation()
  {
    return jdoGetm_dureeIndemnisation(this);
  }
  
  public final void setDureeIndemnisation(DomPCSpec p_dureeIndemnisation)
  {
    jdoSetm_dureeIndemnisation(this, (DureeIndemnisationAbstraitePC)p_dureeIndemnisation);
  }
  
  public DomPCSpec getDureeRenouvellement()
  {
    return jdoGetm_dureeRenouvellement(this);
  }
  
  public final void setDureeRenouvellement(DomPCSpec p_dureeRenouvellement)
  {
    jdoSetm_dureeRenouvellement(this, (DureeRenouvellementAbstraitePC)p_dureeRenouvellement);
  }
  
  public DomPCSpec getDureeDetectionMaintien()
  {
    return jdoGetm_dureeDetectionMaintien(this);
  }
  
  public final void setDureeDetectionMaintien(DomPCSpec p_dureeDetectionMaintien)
  {
    jdoSetm_dureeDetectionMaintien(this, (DureeDetectionMaintienAbstraitePC)p_dureeDetectionMaintien);
  }
  
  public DomPCSpec getFraisRemboursementIndemnisation()
  {
    return jdoGetm_fraisRemboursementIndemnisation(this);
  }
  
  public final void setFraisRemboursementIndemnisation(DomPCSpec p_fraisRemboursementIndemnisation)
  {
    jdoSetm_fraisRemboursementIndemnisation(this, (RemboursementFraisIndemnisationAbstraitPC)p_fraisRemboursementIndemnisation);
  }
  
  public DomPCSpec getDureeProlongation()
  {
    return jdoGetm_dureeProlongation(this);
  }
  
  public final void setDureeProlongation(DomPCSpec p_dureeProlongation)
  {
    jdoSetm_dureeProlongation(this, (DureeProlongationAbstraitePC)p_dureeProlongation);
  }
  
  public Quantite getMontantServi()
  {
    return jdoGetm_montantServi(this);
  }
  
  public final void setMontantServi(Quantite p_montantServi)
  {
    jdoSetm_montantServi(this, p_montantServi);
  }
  
  public DomPCSpec getCapitalIndemnisation()
  {
    return jdoGetm_capitalIndemnisation(this);
  }
  
  public final void setCapitalIndemnisation(DomPCSpec p_capitalIndemnisation)
  {
    jdoSetm_capitalIndemnisation(this, (CapitalIndemnisationAbstraitPC)p_capitalIndemnisation);
  }
  
  public DomPCSpec getDureeFinancement()
  {
    return jdoGetm_dureeFinancement(this);
  }
  
  public final void setDureeFinancement(DomPCSpec p_dureeFinancement)
  {
    jdoSetm_dureeFinancement(this, (DureeFinancementAbstraitePC)p_dureeFinancement);
  }
  
  public Quantite getMontantIndemNonDerog()
  {
    return jdoGetm_montantIndemNonDerog(this);
  }
  
  public final void setMontantIndemNonDerog(Quantite p_montantIndemNonDerog)
  {
    jdoSetm_montantIndemNonDerog(this, p_montantIndemNonDerog);
  }
  
  public Quantite getMontantIndemDerog()
  {
    return jdoGetm_montantIndemDerog(this);
  }
  
  public final void setMontantIndemDerog(Quantite p_montantIndemDerog)
  {
    jdoSetm_montantIndemDerog(this, p_montantIndemDerog);
  }
  
  public Integer getRangTranche()
  {
    return jdoGetm_rangTranche(this);
  }
  
  public final void setRangTranche(Integer p_rangTranche)
  {
    jdoSetm_rangTranche(this, p_rangTranche);
  }
  
  public Damj getDateFinDispositifCSP()
  {
    return jdoGetm_dateFinDispositifCSP(this);
  }
  
  public final void setDateFinDispositifCSP(Damj p_dateFinDispositifCSP)
  {
    jdoSetm_dateFinDispositifCSP(this, p_dateFinDispositifCSP);
  }
  
  public int getCumulTotalAllongementAREF()
  {
    return jdoGetm_cumulTotalAllongementAREF(this);
  }
  
  public final void setCumulTotalAllongementAREF(int p_cumulTotalAllongementAREF)
  {
    jdoSetm_cumulTotalAllongementAREF(this, p_cumulTotalAllongementAREF);
  }
  
  public final Collection getCollectionListeDureeNonIndemnisables()
  {
    if (jdoGetm_listeDureeNonIndemnisables(this) == null) {
      jdoSetm_listeDureeNonIndemnisables(this, new ArrayList());
    }
    return jdoGetm_listeDureeNonIndemnisables(this);
  }
  
  public final void ajouterListeDureeNonIndemnisables(DomPCSpec p_dureeNonIndemnisables)
    throws NullPointerException
  {
    if (p_dureeNonIndemnisables == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_dureeNonIndemnisables ne devrait pas être nul.", p_dureeNonIndemnisables);
    }
    getCollectionListeDureeNonIndemnisables().add(p_dureeNonIndemnisables);
  }
  
  public final void supprimerListeDureeNonIndemnisables(DomPCSpec p_dureeNonIndemnisables)
    throws NullPointerException
  {
    if (p_dureeNonIndemnisables == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_dureeNonIndemnisables ne devrait pas être nul.", p_dureeNonIndemnisables);
    }
    getCollectionListeDureeNonIndemnisables().remove(p_dureeNonIndemnisables);
  }
  
  static
  {
    JDOImplHelper.registerClass(ConstituantsIndemnisationPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new ConstituantsIndemnisationPC());
  }
  
  protected static final String jdoGetm_codeFormuleMontant(ConstituantsIndemnisationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeFormuleMontant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_codeFormuleMontant;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 0, m_codeFormuleMontant);
    }
    return m_codeFormuleMontant;
  }
  
  protected static final DureeIndemnisationAbstraitePC jdoGetm_dureeIndemnisation(ConstituantsIndemnisationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeIndemnisation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_dureeIndemnisation;
      }
      return (DureeIndemnisationAbstraitePC)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_dureeIndemnisation);
    }
    return m_dureeIndemnisation;
  }
  
  protected static final DureeRenouvellementAbstraitePC jdoGetm_dureeRenouvellement(ConstituantsIndemnisationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeRenouvellement;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_dureeRenouvellement;
      }
      return (DureeRenouvellementAbstraitePC)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_dureeRenouvellement);
    }
    return m_dureeRenouvellement;
  }
  
  protected static final DureeDetectionMaintienAbstraitePC jdoGetm_dureeDetectionMaintien(ConstituantsIndemnisationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeDetectionMaintien;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_dureeDetectionMaintien;
      }
      return (DureeDetectionMaintienAbstraitePC)sm.getObjectField(pc, jdoInheritedFieldCount + 3, m_dureeDetectionMaintien);
    }
    return m_dureeDetectionMaintien;
  }
  
  protected static final RemboursementFraisIndemnisationAbstraitPC jdoGetm_fraisRemboursementIndemnisation(ConstituantsIndemnisationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_fraisRemboursementIndemnisation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_fraisRemboursementIndemnisation;
      }
      return (RemboursementFraisIndemnisationAbstraitPC)sm.getObjectField(pc, jdoInheritedFieldCount + 4, m_fraisRemboursementIndemnisation);
    }
    return m_fraisRemboursementIndemnisation;
  }
  
  protected static final DureeProlongationAbstraitePC jdoGetm_dureeProlongation(ConstituantsIndemnisationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeProlongation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_dureeProlongation;
      }
      return (DureeProlongationAbstraitePC)sm.getObjectField(pc, jdoInheritedFieldCount + 5, m_dureeProlongation);
    }
    return m_dureeProlongation;
  }
  
  private static final Quantite jdoGetm_montantServi(ConstituantsIndemnisationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantServi;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_montantServi;
      }
      return (Quantite)sm.getObjectField(pc, jdoInheritedFieldCount + 6, m_montantServi);
    }
    return m_montantServi;
  }
  
  public static final CapitalIndemnisationAbstraitPC jdoGetm_capitalIndemnisation(ConstituantsIndemnisationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_capitalIndemnisation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_capitalIndemnisation;
      }
      return (CapitalIndemnisationAbstraitPC)sm.getObjectField(pc, jdoInheritedFieldCount + 7, m_capitalIndemnisation);
    }
    return m_capitalIndemnisation;
  }
  
  public static final DureeFinancementAbstraitePC jdoGetm_dureeFinancement(ConstituantsIndemnisationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeFinancement;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_dureeFinancement;
      }
      return (DureeFinancementAbstraitePC)sm.getObjectField(pc, jdoInheritedFieldCount + 8, m_dureeFinancement);
    }
    return m_dureeFinancement;
  }
  
  private static final Quantite jdoGetm_montantIndemNonDerog(ConstituantsIndemnisationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantIndemNonDerog;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 9)) {
        return m_montantIndemNonDerog;
      }
      return (Quantite)sm.getObjectField(pc, jdoInheritedFieldCount + 9, m_montantIndemNonDerog);
    }
    return m_montantIndemNonDerog;
  }
  
  private static final Quantite jdoGetm_montantIndemDerog(ConstituantsIndemnisationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantIndemDerog;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 10)) {
        return m_montantIndemDerog;
      }
      return (Quantite)sm.getObjectField(pc, jdoInheritedFieldCount + 10, m_montantIndemDerog);
    }
    return m_montantIndemDerog;
  }
  
  private static final Integer jdoGetm_rangTranche(ConstituantsIndemnisationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_rangTranche;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 11)) {
        return m_rangTranche;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 11, m_rangTranche);
    }
    return m_rangTranche;
  }
  
  protected static final Damj jdoGetm_dateFinDispositifCSP(ConstituantsIndemnisationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinDispositifCSP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 12)) {
        return m_dateFinDispositifCSP;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 12, m_dateFinDispositifCSP);
    }
    return m_dateFinDispositifCSP;
  }
  
  protected static final int jdoGetm_cumulTotalAllongementAREF(ConstituantsIndemnisationPC pc)
  {
    if (jdoFlags <= 0) {
      return m_cumulTotalAllongementAREF;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 13)) {
        return m_cumulTotalAllongementAREF;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 13, m_cumulTotalAllongementAREF);
    }
    return m_cumulTotalAllongementAREF;
  }
  
  public static final Collection jdoGetm_listeDureeNonIndemnisables(ConstituantsIndemnisationPC pc)
  {
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 14)) {
        return m_listeDureeNonIndemnisables;
      }
      return (Collection)sm.getObjectField(pc, jdoInheritedFieldCount + 14, m_listeDureeNonIndemnisables);
    }
    return m_listeDureeNonIndemnisables;
  }
  
  protected static final void jdoSetm_codeFormuleMontant(ConstituantsIndemnisationPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeFormuleMontant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 0, m_codeFormuleMontant, newValue);
    } else {
      m_codeFormuleMontant = newValue;
    }
  }
  
  protected static final void jdoSetm_dureeIndemnisation(ConstituantsIndemnisationPC pc, DureeIndemnisationAbstraitePC newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeIndemnisation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_dureeIndemnisation, newValue);
    } else {
      m_dureeIndemnisation = newValue;
    }
  }
  
  protected static final void jdoSetm_dureeRenouvellement(ConstituantsIndemnisationPC pc, DureeRenouvellementAbstraitePC newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeRenouvellement = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_dureeRenouvellement, newValue);
    } else {
      m_dureeRenouvellement = newValue;
    }
  }
  
  protected static final void jdoSetm_dureeDetectionMaintien(ConstituantsIndemnisationPC pc, DureeDetectionMaintienAbstraitePC newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeDetectionMaintien = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 3, m_dureeDetectionMaintien, newValue);
    } else {
      m_dureeDetectionMaintien = newValue;
    }
  }
  
  protected static final void jdoSetm_fraisRemboursementIndemnisation(ConstituantsIndemnisationPC pc, RemboursementFraisIndemnisationAbstraitPC newValue)
  {
    if (jdoFlags == 0)
    {
      m_fraisRemboursementIndemnisation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 4, m_fraisRemboursementIndemnisation, newValue);
    } else {
      m_fraisRemboursementIndemnisation = newValue;
    }
  }
  
  protected static final void jdoSetm_dureeProlongation(ConstituantsIndemnisationPC pc, DureeProlongationAbstraitePC newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeProlongation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 5, m_dureeProlongation, newValue);
    } else {
      m_dureeProlongation = newValue;
    }
  }
  
  private static final void jdoSetm_montantServi(ConstituantsIndemnisationPC pc, Quantite newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantServi = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 6, m_montantServi, newValue);
    } else {
      m_montantServi = newValue;
    }
  }
  
  public static final void jdoSetm_capitalIndemnisation(ConstituantsIndemnisationPC pc, CapitalIndemnisationAbstraitPC newValue)
  {
    if (jdoFlags == 0)
    {
      m_capitalIndemnisation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 7, m_capitalIndemnisation, newValue);
    } else {
      m_capitalIndemnisation = newValue;
    }
  }
  
  public static final void jdoSetm_dureeFinancement(ConstituantsIndemnisationPC pc, DureeFinancementAbstraitePC newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeFinancement = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 8, m_dureeFinancement, newValue);
    } else {
      m_dureeFinancement = newValue;
    }
  }
  
  private static final void jdoSetm_montantIndemNonDerog(ConstituantsIndemnisationPC pc, Quantite newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantIndemNonDerog = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 9, m_montantIndemNonDerog, newValue);
    } else {
      m_montantIndemNonDerog = newValue;
    }
  }
  
  private static final void jdoSetm_montantIndemDerog(ConstituantsIndemnisationPC pc, Quantite newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantIndemDerog = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 10, m_montantIndemDerog, newValue);
    } else {
      m_montantIndemDerog = newValue;
    }
  }
  
  private static final void jdoSetm_rangTranche(ConstituantsIndemnisationPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_rangTranche = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 11, m_rangTranche, newValue);
    } else {
      m_rangTranche = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinDispositifCSP(ConstituantsIndemnisationPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinDispositifCSP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 12, m_dateFinDispositifCSP, newValue);
    } else {
      m_dateFinDispositifCSP = newValue;
    }
  }
  
  protected static final void jdoSetm_cumulTotalAllongementAREF(ConstituantsIndemnisationPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_cumulTotalAllongementAREF = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 13, m_cumulTotalAllongementAREF, newValue);
    } else {
      m_cumulTotalAllongementAREF = newValue;
    }
  }
  
  public static final void jdoSetm_listeDureeNonIndemnisables(ConstituantsIndemnisationPC pc, Collection newValue)
  {
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 14, m_listeDureeNonIndemnisables, newValue);
    } else {
      m_listeDureeNonIndemnisables = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeFormuleMontant);
      break;
    case 1: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dureeIndemnisation);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dureeRenouvellement);
      break;
    case 3: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dureeDetectionMaintien);
      break;
    case 4: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_fraisRemboursementIndemnisation);
      break;
    case 5: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dureeProlongation);
      break;
    case 6: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantServi);
      break;
    case 7: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_capitalIndemnisation);
      break;
    case 8: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dureeFinancement);
      break;
    case 9: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantIndemNonDerog);
      break;
    case 10: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantIndemDerog);
      break;
    case 11: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_rangTranche);
      break;
    case 12: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinDispositifCSP);
      break;
    case 13: 
      jdoStateManager.providedIntField(this, fieldNumber, m_cumulTotalAllongementAREF);
      break;
    case 14: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_listeDureeNonIndemnisables);
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
      m_codeFormuleMontant = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 1: 
      m_dureeIndemnisation = ((DureeIndemnisationAbstraitePC)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_dureeRenouvellement = ((DureeRenouvellementAbstraitePC)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 3: 
      m_dureeDetectionMaintien = ((DureeDetectionMaintienAbstraitePC)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 4: 
      m_fraisRemboursementIndemnisation = ((RemboursementFraisIndemnisationAbstraitPC)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 5: 
      m_dureeProlongation = ((DureeProlongationAbstraitePC)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 6: 
      m_montantServi = ((Quantite)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 7: 
      m_capitalIndemnisation = ((CapitalIndemnisationAbstraitPC)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 8: 
      m_dureeFinancement = ((DureeFinancementAbstraitePC)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 9: 
      m_montantIndemNonDerog = ((Quantite)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 10: 
      m_montantIndemDerog = ((Quantite)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 11: 
      m_rangTranche = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 12: 
      m_dateFinDispositifCSP = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 13: 
      m_cumulTotalAllongementAREF = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 14: 
      m_listeDureeNonIndemnisables = ((Collection)jdoStateManager.replacingObjectField(this, fieldNumber));
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
    ConstituantsIndemnisationPC pc = new ConstituantsIndemnisationPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    ConstituantsIndemnisationPC pc = new ConstituantsIndemnisationPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 15;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof ConstituantsIndemnisationPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    ConstituantsIndemnisationPC other = (ConstituantsIndemnisationPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_codeFormuleMontant = m_codeFormuleMontant;
        break;
      case 1: 
        m_dureeIndemnisation = m_dureeIndemnisation;
        break;
      case 2: 
        m_dureeRenouvellement = m_dureeRenouvellement;
        break;
      case 3: 
        m_dureeDetectionMaintien = m_dureeDetectionMaintien;
        break;
      case 4: 
        m_fraisRemboursementIndemnisation = m_fraisRemboursementIndemnisation;
        break;
      case 5: 
        m_dureeProlongation = m_dureeProlongation;
        break;
      case 6: 
        m_montantServi = m_montantServi;
        break;
      case 7: 
        m_capitalIndemnisation = m_capitalIndemnisation;
        break;
      case 8: 
        m_dureeFinancement = m_dureeFinancement;
        break;
      case 9: 
        m_montantIndemNonDerog = m_montantIndemNonDerog;
        break;
      case 10: 
        m_montantIndemDerog = m_montantIndemDerog;
        break;
      case 11: 
        m_rangTranche = m_rangTranche;
        break;
      case 12: 
        m_dateFinDispositifCSP = m_dateFinDispositifCSP;
        break;
      case 13: 
        m_cumulTotalAllongementAREF = m_cumulTotalAllongementAREF;
        break;
      case 14: 
        m_listeDureeNonIndemnisables = m_listeDureeNonIndemnisables;
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
 * Qualified Name:     ConstituantsIndemnisationPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */