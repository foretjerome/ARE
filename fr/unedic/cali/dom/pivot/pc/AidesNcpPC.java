package fr.unedic.cali.dom.pivot.pc;

import fr.unedic.cali.dom.pivot.AidesNcp;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.temps.Damj;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
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

public class AidesNcpPC
  implements DomPCSpec, PersistenceCapable
{
  private transient AidesNcp m_aidesNcpOM;
  protected String m_identifiantBanalise1;
  protected String m_identifiantBanalise2;
  protected String m_identifiantBanalise3;
  protected Damj m_dateBanalisee1;
  protected Damj m_dateBanalisee2;
  protected Damj m_dateBanalisee3;
  protected Damj m_dateBanalisee4;
  protected Damj m_dateBanalisee5;
  protected String m_libelleBanalise1;
  protected String m_libelleBanalise2;
  protected String m_libelleBanalise3;
  protected String m_libelleBanalise4;
  protected String m_libelleBanalise5;
  protected BigDecimal m_nbJoursBanalise1;
  protected BigDecimal m_nbJoursBanalise2;
  protected BigDecimal m_nbJoursBanalise3;
  protected BigDecimal m_capitalBanalise1;
  protected BigDecimal m_capitalBanalise2;
  protected BigDecimal m_capitalBanalise3;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_identifiantBanalise1", "m_identifiantBanalise2", "m_identifiantBanalise3", "m_dateBanalisee1", "m_dateBanalisee2", "m_dateBanalisee3", "m_dateBanalisee4", "m_dateBanalisee5", "m_libelleBanalise1", "m_libelleBanalise2", "m_libelleBanalise3", "m_libelleBanalise4", "m_libelleBanalise5", "m_nbJoursBanalise1", "m_nbJoursBanalise2", "m_nbJoursBanalise3", "m_capitalBanalise1", "m_capitalBanalise2", "m_capitalBanalise3" };
  private static Class[] jdoFieldTypes = { String.class, String.class, String.class, Damj.class, Damj.class, Damj.class, Damj.class, Damj.class, String.class, String.class, String.class, String.class, String.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_aidesNcpOM == null) {
      m_aidesNcpOM = new AidesNcp(this);
    }
    return m_aidesNcpOM;
  }
  
  public String getIdentifiantBanalise1()
  {
    return jdoGetm_identifiantBanalise1(this);
  }
  
  public final void setIdentifiantBanalise1(String p_identifiantBanalise1)
  {
    jdoSetm_identifiantBanalise1(this, p_identifiantBanalise1);
  }
  
  public String getIdentifiantBanalise2()
  {
    return jdoGetm_identifiantBanalise2(this);
  }
  
  public final void setIdentifiantBanalise2(String p_identifiantBanalise2)
  {
    jdoSetm_identifiantBanalise2(this, p_identifiantBanalise2);
  }
  
  public String getIdentifiantBanalise3()
  {
    return jdoGetm_identifiantBanalise3(this);
  }
  
  public final void setIdentifiantBanalise3(String p_identifiantBanalise3)
  {
    jdoSetm_identifiantBanalise3(this, p_identifiantBanalise3);
  }
  
  public Damj getDateBanalisee1()
  {
    return jdoGetm_dateBanalisee1(this);
  }
  
  public final void setDateBanalisee1(Damj p_dateBanalisee1)
  {
    jdoSetm_dateBanalisee1(this, p_dateBanalisee1);
  }
  
  public Damj getDateBanalisee2()
  {
    return jdoGetm_dateBanalisee2(this);
  }
  
  public final void setDateBanalisee2(Damj p_dateBanalisee2)
  {
    jdoSetm_dateBanalisee2(this, p_dateBanalisee2);
  }
  
  public Damj getDateBanalisee3()
  {
    return jdoGetm_dateBanalisee3(this);
  }
  
  public final void setDateBanalisee3(Damj p_dateBanalisee3)
  {
    jdoSetm_dateBanalisee3(this, p_dateBanalisee3);
  }
  
  public Damj getDateBanalisee4()
  {
    return jdoGetm_dateBanalisee4(this);
  }
  
  public final void setDateBanalisee4(Damj p_dateBanalisee4)
  {
    jdoSetm_dateBanalisee4(this, p_dateBanalisee4);
  }
  
  public Damj getDateBanalisee5()
  {
    return jdoGetm_dateBanalisee5(this);
  }
  
  public final void setDateBanalisee5(Damj p_dateBanalisee5)
  {
    jdoSetm_dateBanalisee5(this, p_dateBanalisee5);
  }
  
  public String getLibelleBanalise1()
  {
    return jdoGetm_libelleBanalise1(this);
  }
  
  public final void setLibelleBanalise1(String p_libelleBanalise1)
  {
    jdoSetm_libelleBanalise1(this, p_libelleBanalise1);
  }
  
  public String getLibelleBanalise2()
  {
    return jdoGetm_libelleBanalise2(this);
  }
  
  public final void setLibelleBanalise2(String p_libelleBanalise2)
  {
    jdoSetm_libelleBanalise2(this, p_libelleBanalise2);
  }
  
  public String getLibelleBanalise3()
  {
    return jdoGetm_libelleBanalise3(this);
  }
  
  public final void setLibelleBanalise3(String p_libelleBanalise3)
  {
    jdoSetm_libelleBanalise3(this, p_libelleBanalise3);
  }
  
  public String getLibelleBanalise4()
  {
    return jdoGetm_libelleBanalise4(this);
  }
  
  public final void setLibelleBanalise4(String p_libelleBanalise4)
  {
    jdoSetm_libelleBanalise4(this, p_libelleBanalise4);
  }
  
  public String getLibelleBanalise5()
  {
    return jdoGetm_libelleBanalise5(this);
  }
  
  public final void setLibelleBanalise5(String p_libelleBanalise5)
  {
    jdoSetm_libelleBanalise5(this, p_libelleBanalise5);
  }
  
  public BigDecimal getNbJoursBanalise1()
  {
    return jdoGetm_nbJoursBanalise1(this);
  }
  
  public final void setNbJoursBanalise1(BigDecimal p_nbJoursBanalise1)
  {
    jdoSetm_nbJoursBanalise1(this, p_nbJoursBanalise1);
  }
  
  public BigDecimal getNbJoursBanalise2()
  {
    return jdoGetm_nbJoursBanalise2(this);
  }
  
  public final void setNbJoursBanalise2(BigDecimal p_nbJoursBanalise2)
  {
    jdoSetm_nbJoursBanalise2(this, p_nbJoursBanalise2);
  }
  
  public BigDecimal getNbJoursBanalise3()
  {
    return jdoGetm_nbJoursBanalise3(this);
  }
  
  public final void setNbJoursBanalise3(BigDecimal p_nbJoursBanalise3)
  {
    jdoSetm_nbJoursBanalise3(this, p_nbJoursBanalise3);
  }
  
  public BigDecimal getCapitalBanalise1()
  {
    return jdoGetm_capitalBanalise1(this);
  }
  
  public final void setCapitalBanalise1(BigDecimal p_capitalBanalise1)
  {
    jdoSetm_capitalBanalise1(this, p_capitalBanalise1);
  }
  
  public BigDecimal getCapitalBanalise2()
  {
    return jdoGetm_capitalBanalise2(this);
  }
  
  public final void setCapitalBanalise2(BigDecimal p_capitalBanalise2)
  {
    jdoSetm_capitalBanalise2(this, p_capitalBanalise2);
  }
  
  public BigDecimal getCapitalBanalise3()
  {
    return jdoGetm_capitalBanalise3(this);
  }
  
  public final void setCapitalBanalise3(BigDecimal p_capitalBanalise3)
  {
    jdoSetm_capitalBanalise3(this, p_capitalBanalise3);
  }
  
  static
  {
    JDOImplHelper.registerClass(AidesNcpPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new AidesNcpPC());
  }
  
  protected static final String jdoGetm_identifiantBanalise1(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantBanalise1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_identifiantBanalise1;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 0, m_identifiantBanalise1);
    }
    return m_identifiantBanalise1;
  }
  
  protected static final String jdoGetm_identifiantBanalise2(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantBanalise2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_identifiantBanalise2;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 1, m_identifiantBanalise2);
    }
    return m_identifiantBanalise2;
  }
  
  protected static final String jdoGetm_identifiantBanalise3(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantBanalise3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_identifiantBanalise3;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 2, m_identifiantBanalise3);
    }
    return m_identifiantBanalise3;
  }
  
  protected static final Damj jdoGetm_dateBanalisee1(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateBanalisee1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_dateBanalisee1;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 3, m_dateBanalisee1);
    }
    return m_dateBanalisee1;
  }
  
  protected static final Damj jdoGetm_dateBanalisee2(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateBanalisee2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_dateBanalisee2;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 4, m_dateBanalisee2);
    }
    return m_dateBanalisee2;
  }
  
  protected static final Damj jdoGetm_dateBanalisee3(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateBanalisee3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_dateBanalisee3;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 5, m_dateBanalisee3);
    }
    return m_dateBanalisee3;
  }
  
  protected static final Damj jdoGetm_dateBanalisee4(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateBanalisee4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_dateBanalisee4;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 6, m_dateBanalisee4);
    }
    return m_dateBanalisee4;
  }
  
  protected static final Damj jdoGetm_dateBanalisee5(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateBanalisee5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_dateBanalisee5;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 7, m_dateBanalisee5);
    }
    return m_dateBanalisee5;
  }
  
  protected static final String jdoGetm_libelleBanalise1(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_libelleBanalise1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_libelleBanalise1;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 8, m_libelleBanalise1);
    }
    return m_libelleBanalise1;
  }
  
  protected static final String jdoGetm_libelleBanalise2(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_libelleBanalise2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 9)) {
        return m_libelleBanalise2;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 9, m_libelleBanalise2);
    }
    return m_libelleBanalise2;
  }
  
  protected static final String jdoGetm_libelleBanalise3(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_libelleBanalise3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 10)) {
        return m_libelleBanalise3;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 10, m_libelleBanalise3);
    }
    return m_libelleBanalise3;
  }
  
  protected static final String jdoGetm_libelleBanalise4(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_libelleBanalise4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 11)) {
        return m_libelleBanalise4;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 11, m_libelleBanalise4);
    }
    return m_libelleBanalise4;
  }
  
  protected static final String jdoGetm_libelleBanalise5(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_libelleBanalise5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 12)) {
        return m_libelleBanalise5;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 12, m_libelleBanalise5);
    }
    return m_libelleBanalise5;
  }
  
  protected static final BigDecimal jdoGetm_nbJoursBanalise1(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJoursBanalise1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 13)) {
        return m_nbJoursBanalise1;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 13, m_nbJoursBanalise1);
    }
    return m_nbJoursBanalise1;
  }
  
  protected static final BigDecimal jdoGetm_nbJoursBanalise2(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJoursBanalise2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 14)) {
        return m_nbJoursBanalise2;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 14, m_nbJoursBanalise2);
    }
    return m_nbJoursBanalise2;
  }
  
  protected static final BigDecimal jdoGetm_nbJoursBanalise3(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJoursBanalise3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 15)) {
        return m_nbJoursBanalise3;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 15, m_nbJoursBanalise3);
    }
    return m_nbJoursBanalise3;
  }
  
  protected static final BigDecimal jdoGetm_capitalBanalise1(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_capitalBanalise1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 16)) {
        return m_capitalBanalise1;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 16, m_capitalBanalise1);
    }
    return m_capitalBanalise1;
  }
  
  protected static final BigDecimal jdoGetm_capitalBanalise2(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_capitalBanalise2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 17)) {
        return m_capitalBanalise2;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 17, m_capitalBanalise2);
    }
    return m_capitalBanalise2;
  }
  
  protected static final BigDecimal jdoGetm_capitalBanalise3(AidesNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_capitalBanalise3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 18)) {
        return m_capitalBanalise3;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 18, m_capitalBanalise3);
    }
    return m_capitalBanalise3;
  }
  
  protected static final void jdoSetm_identifiantBanalise1(AidesNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantBanalise1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 0, m_identifiantBanalise1, newValue);
    } else {
      m_identifiantBanalise1 = newValue;
    }
  }
  
  protected static final void jdoSetm_identifiantBanalise2(AidesNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantBanalise2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 1, m_identifiantBanalise2, newValue);
    } else {
      m_identifiantBanalise2 = newValue;
    }
  }
  
  protected static final void jdoSetm_identifiantBanalise3(AidesNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantBanalise3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 2, m_identifiantBanalise3, newValue);
    } else {
      m_identifiantBanalise3 = newValue;
    }
  }
  
  protected static final void jdoSetm_dateBanalisee1(AidesNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateBanalisee1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 3, m_dateBanalisee1, newValue);
    } else {
      m_dateBanalisee1 = newValue;
    }
  }
  
  protected static final void jdoSetm_dateBanalisee2(AidesNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateBanalisee2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 4, m_dateBanalisee2, newValue);
    } else {
      m_dateBanalisee2 = newValue;
    }
  }
  
  protected static final void jdoSetm_dateBanalisee3(AidesNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateBanalisee3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 5, m_dateBanalisee3, newValue);
    } else {
      m_dateBanalisee3 = newValue;
    }
  }
  
  protected static final void jdoSetm_dateBanalisee4(AidesNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateBanalisee4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 6, m_dateBanalisee4, newValue);
    } else {
      m_dateBanalisee4 = newValue;
    }
  }
  
  protected static final void jdoSetm_dateBanalisee5(AidesNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateBanalisee5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 7, m_dateBanalisee5, newValue);
    } else {
      m_dateBanalisee5 = newValue;
    }
  }
  
  protected static final void jdoSetm_libelleBanalise1(AidesNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_libelleBanalise1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 8, m_libelleBanalise1, newValue);
    } else {
      m_libelleBanalise1 = newValue;
    }
  }
  
  protected static final void jdoSetm_libelleBanalise2(AidesNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_libelleBanalise2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 9, m_libelleBanalise2, newValue);
    } else {
      m_libelleBanalise2 = newValue;
    }
  }
  
  protected static final void jdoSetm_libelleBanalise3(AidesNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_libelleBanalise3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 10, m_libelleBanalise3, newValue);
    } else {
      m_libelleBanalise3 = newValue;
    }
  }
  
  protected static final void jdoSetm_libelleBanalise4(AidesNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_libelleBanalise4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 11, m_libelleBanalise4, newValue);
    } else {
      m_libelleBanalise4 = newValue;
    }
  }
  
  protected static final void jdoSetm_libelleBanalise5(AidesNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_libelleBanalise5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 12, m_libelleBanalise5, newValue);
    } else {
      m_libelleBanalise5 = newValue;
    }
  }
  
  protected static final void jdoSetm_nbJoursBanalise1(AidesNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJoursBanalise1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 13, m_nbJoursBanalise1, newValue);
    } else {
      m_nbJoursBanalise1 = newValue;
    }
  }
  
  protected static final void jdoSetm_nbJoursBanalise2(AidesNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJoursBanalise2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 14, m_nbJoursBanalise2, newValue);
    } else {
      m_nbJoursBanalise2 = newValue;
    }
  }
  
  protected static final void jdoSetm_nbJoursBanalise3(AidesNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJoursBanalise3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 15, m_nbJoursBanalise3, newValue);
    } else {
      m_nbJoursBanalise3 = newValue;
    }
  }
  
  protected static final void jdoSetm_capitalBanalise1(AidesNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_capitalBanalise1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 16, m_capitalBanalise1, newValue);
    } else {
      m_capitalBanalise1 = newValue;
    }
  }
  
  protected static final void jdoSetm_capitalBanalise2(AidesNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_capitalBanalise2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 17, m_capitalBanalise2, newValue);
    } else {
      m_capitalBanalise2 = newValue;
    }
  }
  
  protected static final void jdoSetm_capitalBanalise3(AidesNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_capitalBanalise3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 18, m_capitalBanalise3, newValue);
    } else {
      m_capitalBanalise3 = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedStringField(this, fieldNumber, m_identifiantBanalise1);
      break;
    case 1: 
      jdoStateManager.providedStringField(this, fieldNumber, m_identifiantBanalise2);
      break;
    case 2: 
      jdoStateManager.providedStringField(this, fieldNumber, m_identifiantBanalise3);
      break;
    case 3: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateBanalisee1);
      break;
    case 4: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateBanalisee2);
      break;
    case 5: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateBanalisee3);
      break;
    case 6: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateBanalisee4);
      break;
    case 7: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateBanalisee5);
      break;
    case 8: 
      jdoStateManager.providedStringField(this, fieldNumber, m_libelleBanalise1);
      break;
    case 9: 
      jdoStateManager.providedStringField(this, fieldNumber, m_libelleBanalise2);
      break;
    case 10: 
      jdoStateManager.providedStringField(this, fieldNumber, m_libelleBanalise3);
      break;
    case 11: 
      jdoStateManager.providedStringField(this, fieldNumber, m_libelleBanalise4);
      break;
    case 12: 
      jdoStateManager.providedStringField(this, fieldNumber, m_libelleBanalise5);
      break;
    case 13: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_nbJoursBanalise1);
      break;
    case 14: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_nbJoursBanalise2);
      break;
    case 15: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_nbJoursBanalise3);
      break;
    case 16: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_capitalBanalise1);
      break;
    case 17: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_capitalBanalise2);
      break;
    case 18: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_capitalBanalise3);
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
      m_identifiantBanalise1 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 1: 
      m_identifiantBanalise2 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 2: 
      m_identifiantBanalise3 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 3: 
      m_dateBanalisee1 = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 4: 
      m_dateBanalisee2 = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 5: 
      m_dateBanalisee3 = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 6: 
      m_dateBanalisee4 = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 7: 
      m_dateBanalisee5 = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 8: 
      m_libelleBanalise1 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 9: 
      m_libelleBanalise2 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 10: 
      m_libelleBanalise3 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 11: 
      m_libelleBanalise4 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 12: 
      m_libelleBanalise5 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 13: 
      m_nbJoursBanalise1 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 14: 
      m_nbJoursBanalise2 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 15: 
      m_nbJoursBanalise3 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 16: 
      m_capitalBanalise1 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 17: 
      m_capitalBanalise2 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 18: 
      m_capitalBanalise3 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
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
    AidesNcpPC pc = new AidesNcpPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    AidesNcpPC pc = new AidesNcpPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 19;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof AidesNcpPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    AidesNcpPC other = (AidesNcpPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_identifiantBanalise1 = m_identifiantBanalise1;
        break;
      case 1: 
        m_identifiantBanalise2 = m_identifiantBanalise2;
        break;
      case 2: 
        m_identifiantBanalise3 = m_identifiantBanalise3;
        break;
      case 3: 
        m_dateBanalisee1 = m_dateBanalisee1;
        break;
      case 4: 
        m_dateBanalisee2 = m_dateBanalisee2;
        break;
      case 5: 
        m_dateBanalisee3 = m_dateBanalisee3;
        break;
      case 6: 
        m_dateBanalisee4 = m_dateBanalisee4;
        break;
      case 7: 
        m_dateBanalisee5 = m_dateBanalisee5;
        break;
      case 8: 
        m_libelleBanalise1 = m_libelleBanalise1;
        break;
      case 9: 
        m_libelleBanalise2 = m_libelleBanalise2;
        break;
      case 10: 
        m_libelleBanalise3 = m_libelleBanalise3;
        break;
      case 11: 
        m_libelleBanalise4 = m_libelleBanalise4;
        break;
      case 12: 
        m_libelleBanalise5 = m_libelleBanalise5;
        break;
      case 13: 
        m_nbJoursBanalise1 = m_nbJoursBanalise1;
        break;
      case 14: 
        m_nbJoursBanalise2 = m_nbJoursBanalise2;
        break;
      case 15: 
        m_nbJoursBanalise3 = m_nbJoursBanalise3;
        break;
      case 16: 
        m_capitalBanalise1 = m_capitalBanalise1;
        break;
      case 17: 
        m_capitalBanalise2 = m_capitalBanalise2;
        break;
      case 18: 
        m_capitalBanalise3 = m_capitalBanalise3;
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
 * Qualified Name:     AidesNcpPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */