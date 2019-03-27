package fr.unedic.cali.calcul.pbjc.dom.pc;

import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
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

public class IndividuPbjcNcpPC
  implements DomPCSpec, PersistenceCapable
{
  private transient IndividuPbjcNcp m_individuPbjcNcpOM;
  protected Damj m_dateDerniereExecCal;
  protected int m_heureDerniereExecCal;
  protected Damj m_dateDerniereDemCal;
  protected int m_heureDerniereDemCal;
  protected Damj m_dernierJourIndemnisable;
  protected Damj m_dateDepartRetraiteCalculee;
  protected String m_codeJustifRetraite;
  protected int m_etatDerniereExecution;
  protected String m_codeAnomalieCalcul;
  protected String m_donneeAnomalieCalcul;
  protected String m_contexteExecution;
  protected int m_nombreTrimestreRetraite;
  protected Damj m_dateAtteinteMoisNonPaye;
  protected Damj m_dateDebutIneligibiliteAidesMob;
  protected Damj m_dateFinIneligibiliteAidesMob;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_dateDerniereExecCal", "m_heureDerniereExecCal", "m_dateDerniereDemCal", "m_heureDerniereDemCal", "m_dernierJourIndemnisable", "m_dateDepartRetraiteCalculee", "m_codeJustifRetraite", "m_etatDerniereExecution", "m_codeAnomalieCalcul", "m_donneeAnomalieCalcul", "m_contexteExecution", "m_nombreTrimestreRetraite", "m_dateAtteinteMoisNonPaye", "m_dateDebutIneligibiliteAidesMob", "m_dateFinIneligibiliteAidesMob" };
  private static Class[] jdoFieldTypes = { Damj.class, Integer.TYPE, Damj.class, Integer.TYPE, Damj.class, Damj.class, String.class, Integer.TYPE, String.class, String.class, String.class, Integer.TYPE, Damj.class, Damj.class, Damj.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_individuPbjcNcpOM == null) {
      m_individuPbjcNcpOM = new IndividuPbjcNcp(this);
    }
    return m_individuPbjcNcpOM;
  }
  
  public Damj getDateDerniereExecCal()
  {
    return jdoGetm_dateDerniereExecCal(this);
  }
  
  public final void setDateDerniereExecCal(Damj p_dateDerniereExecCal)
  {
    jdoSetm_dateDerniereExecCal(this, p_dateDerniereExecCal);
  }
  
  public int getHeureDerniereExecCal()
  {
    return jdoGetm_heureDerniereExecCal(this);
  }
  
  public final void setHeureDerniereExecCal(int p_heureDerniereExecCal)
  {
    jdoSetm_heureDerniereExecCal(this, p_heureDerniereExecCal);
  }
  
  public Damj getDateDerniereDemCal()
  {
    return jdoGetm_dateDerniereDemCal(this);
  }
  
  public final void setDateDerniereDemCal(Damj p_dateDerniereDemCal)
  {
    jdoSetm_dateDerniereDemCal(this, p_dateDerniereDemCal);
  }
  
  public int getHeureDerniereDemCal()
  {
    return jdoGetm_heureDerniereDemCal(this);
  }
  
  public final void setHeureDerniereDemCal(int p_heureDerniereDemCal)
  {
    jdoSetm_heureDerniereDemCal(this, p_heureDerniereDemCal);
  }
  
  public Damj getDernierJourIndemnisable()
  {
    return jdoGetm_dernierJourIndemnisable(this);
  }
  
  public final void setDernierJourIndemnisable(Damj p_dernierJourIndemnisable)
  {
    jdoSetm_dernierJourIndemnisable(this, p_dernierJourIndemnisable);
  }
  
  public Damj getDateDepartRetraiteCalculee()
  {
    return jdoGetm_dateDepartRetraiteCalculee(this);
  }
  
  public final void setDateDepartRetraiteCalculee(Damj p_dateDepartRetraiteCalculee)
  {
    jdoSetm_dateDepartRetraiteCalculee(this, p_dateDepartRetraiteCalculee);
  }
  
  public String getCodeJustifRetraite()
  {
    return jdoGetm_codeJustifRetraite(this);
  }
  
  public final void setCodeJustifRetraite(String p_codeJustifRetraite)
  {
    jdoSetm_codeJustifRetraite(this, p_codeJustifRetraite);
  }
  
  public int getEtatDerniereExecution()
  {
    return jdoGetm_etatDerniereExecution(this);
  }
  
  public final void setEtatDerniereExecution(int p_etatDerniereExecution)
  {
    jdoSetm_etatDerniereExecution(this, p_etatDerniereExecution);
  }
  
  public String getCodeAnomalieCalcul()
  {
    return jdoGetm_codeAnomalieCalcul(this);
  }
  
  public final void setCodeAnomalieCalcul(String p_codeAnomalieCalcul)
  {
    jdoSetm_codeAnomalieCalcul(this, p_codeAnomalieCalcul);
  }
  
  public String getDonneeAnomalieCalcul()
  {
    return jdoGetm_donneeAnomalieCalcul(this);
  }
  
  public final void setDonneeAnomalieCalcul(String p_donneeAnomalieCalcul)
  {
    jdoSetm_donneeAnomalieCalcul(this, p_donneeAnomalieCalcul);
  }
  
  public String getContexteExecution()
  {
    return jdoGetm_contexteExecution(this);
  }
  
  public final void setContexteExecution(String p_contexteExecution)
  {
    jdoSetm_contexteExecution(this, p_contexteExecution);
  }
  
  public int getNombreTrimestreRetraite()
  {
    return jdoGetm_nombreTrimestreRetraite(this);
  }
  
  public final void setNombreTrimestreRetraite(int p_nombreTrimestreRetraite)
  {
    jdoSetm_nombreTrimestreRetraite(this, p_nombreTrimestreRetraite);
  }
  
  public Damj getDateAtteinteMoisNonPaye()
  {
    return jdoGetm_dateAtteinteMoisNonPaye(this);
  }
  
  public final void setDateAtteinteMoisNonPaye(Damj p_dateAtteinteMoisNonPaye)
  {
    jdoSetm_dateAtteinteMoisNonPaye(this, p_dateAtteinteMoisNonPaye);
  }
  
  public Damj getDateDebutIneligibiliteAidesMob()
  {
    return jdoGetm_dateDebutIneligibiliteAidesMob(this);
  }
  
  public final void setDateDebutIneligibiliteAidesMob(Damj p_dateDebutIneligibiliteAidesMob)
  {
    jdoSetm_dateDebutIneligibiliteAidesMob(this, p_dateDebutIneligibiliteAidesMob);
  }
  
  public Damj getDateFinIneligibiliteAidesMob()
  {
    return jdoGetm_dateFinIneligibiliteAidesMob(this);
  }
  
  public final void setDateFinIneligibiliteAidesMob(Damj p_dateFinIneligibiliteAidesMob)
  {
    jdoSetm_dateFinIneligibiliteAidesMob(this, p_dateFinIneligibiliteAidesMob);
  }
  
  static
  {
    JDOImplHelper.registerClass(IndividuPbjcNcpPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new IndividuPbjcNcpPC());
  }
  
  protected static final Damj jdoGetm_dateDerniereExecCal(IndividuPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDerniereExecCal;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_dateDerniereExecCal;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 0, m_dateDerniereExecCal);
    }
    return m_dateDerniereExecCal;
  }
  
  protected static final int jdoGetm_heureDerniereExecCal(IndividuPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_heureDerniereExecCal;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_heureDerniereExecCal;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 1, m_heureDerniereExecCal);
    }
    return m_heureDerniereExecCal;
  }
  
  protected static final Damj jdoGetm_dateDerniereDemCal(IndividuPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDerniereDemCal;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_dateDerniereDemCal;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_dateDerniereDemCal);
    }
    return m_dateDerniereDemCal;
  }
  
  protected static final int jdoGetm_heureDerniereDemCal(IndividuPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_heureDerniereDemCal;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_heureDerniereDemCal;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 3, m_heureDerniereDemCal);
    }
    return m_heureDerniereDemCal;
  }
  
  protected static final Damj jdoGetm_dernierJourIndemnisable(IndividuPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dernierJourIndemnisable;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_dernierJourIndemnisable;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 4, m_dernierJourIndemnisable);
    }
    return m_dernierJourIndemnisable;
  }
  
  protected static final Damj jdoGetm_dateDepartRetraiteCalculee(IndividuPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDepartRetraiteCalculee;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_dateDepartRetraiteCalculee;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 5, m_dateDepartRetraiteCalculee);
    }
    return m_dateDepartRetraiteCalculee;
  }
  
  protected static final String jdoGetm_codeJustifRetraite(IndividuPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeJustifRetraite;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_codeJustifRetraite;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 6, m_codeJustifRetraite);
    }
    return m_codeJustifRetraite;
  }
  
  protected static final int jdoGetm_etatDerniereExecution(IndividuPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_etatDerniereExecution;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_etatDerniereExecution;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 7, m_etatDerniereExecution);
    }
    return m_etatDerniereExecution;
  }
  
  protected static final String jdoGetm_codeAnomalieCalcul(IndividuPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeAnomalieCalcul;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_codeAnomalieCalcul;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 8, m_codeAnomalieCalcul);
    }
    return m_codeAnomalieCalcul;
  }
  
  protected static final String jdoGetm_donneeAnomalieCalcul(IndividuPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_donneeAnomalieCalcul;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 9)) {
        return m_donneeAnomalieCalcul;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 9, m_donneeAnomalieCalcul);
    }
    return m_donneeAnomalieCalcul;
  }
  
  protected static final String jdoGetm_contexteExecution(IndividuPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_contexteExecution;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 10)) {
        return m_contexteExecution;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 10, m_contexteExecution);
    }
    return m_contexteExecution;
  }
  
  protected static final int jdoGetm_nombreTrimestreRetraite(IndividuPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nombreTrimestreRetraite;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 11)) {
        return m_nombreTrimestreRetraite;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 11, m_nombreTrimestreRetraite);
    }
    return m_nombreTrimestreRetraite;
  }
  
  protected static final Damj jdoGetm_dateAtteinteMoisNonPaye(IndividuPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateAtteinteMoisNonPaye;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 12)) {
        return m_dateAtteinteMoisNonPaye;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 12, m_dateAtteinteMoisNonPaye);
    }
    return m_dateAtteinteMoisNonPaye;
  }
  
  protected static final Damj jdoGetm_dateDebutIneligibiliteAidesMob(IndividuPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebutIneligibiliteAidesMob;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 13)) {
        return m_dateDebutIneligibiliteAidesMob;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 13, m_dateDebutIneligibiliteAidesMob);
    }
    return m_dateDebutIneligibiliteAidesMob;
  }
  
  protected static final Damj jdoGetm_dateFinIneligibiliteAidesMob(IndividuPbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinIneligibiliteAidesMob;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 14)) {
        return m_dateFinIneligibiliteAidesMob;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 14, m_dateFinIneligibiliteAidesMob);
    }
    return m_dateFinIneligibiliteAidesMob;
  }
  
  protected static final void jdoSetm_dateDerniereExecCal(IndividuPbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDerniereExecCal = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 0, m_dateDerniereExecCal, newValue);
    } else {
      m_dateDerniereExecCal = newValue;
    }
  }
  
  protected static final void jdoSetm_heureDerniereExecCal(IndividuPbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_heureDerniereExecCal = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 1, m_heureDerniereExecCal, newValue);
    } else {
      m_heureDerniereExecCal = newValue;
    }
  }
  
  protected static final void jdoSetm_dateDerniereDemCal(IndividuPbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDerniereDemCal = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_dateDerniereDemCal, newValue);
    } else {
      m_dateDerniereDemCal = newValue;
    }
  }
  
  protected static final void jdoSetm_heureDerniereDemCal(IndividuPbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_heureDerniereDemCal = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 3, m_heureDerniereDemCal, newValue);
    } else {
      m_heureDerniereDemCal = newValue;
    }
  }
  
  protected static final void jdoSetm_dernierJourIndemnisable(IndividuPbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dernierJourIndemnisable = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 4, m_dernierJourIndemnisable, newValue);
    } else {
      m_dernierJourIndemnisable = newValue;
    }
  }
  
  protected static final void jdoSetm_dateDepartRetraiteCalculee(IndividuPbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDepartRetraiteCalculee = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 5, m_dateDepartRetraiteCalculee, newValue);
    } else {
      m_dateDepartRetraiteCalculee = newValue;
    }
  }
  
  protected static final void jdoSetm_codeJustifRetraite(IndividuPbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeJustifRetraite = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 6, m_codeJustifRetraite, newValue);
    } else {
      m_codeJustifRetraite = newValue;
    }
  }
  
  protected static final void jdoSetm_etatDerniereExecution(IndividuPbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_etatDerniereExecution = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 7, m_etatDerniereExecution, newValue);
    } else {
      m_etatDerniereExecution = newValue;
    }
  }
  
  protected static final void jdoSetm_codeAnomalieCalcul(IndividuPbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeAnomalieCalcul = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 8, m_codeAnomalieCalcul, newValue);
    } else {
      m_codeAnomalieCalcul = newValue;
    }
  }
  
  protected static final void jdoSetm_donneeAnomalieCalcul(IndividuPbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_donneeAnomalieCalcul = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 9, m_donneeAnomalieCalcul, newValue);
    } else {
      m_donneeAnomalieCalcul = newValue;
    }
  }
  
  protected static final void jdoSetm_contexteExecution(IndividuPbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_contexteExecution = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 10, m_contexteExecution, newValue);
    } else {
      m_contexteExecution = newValue;
    }
  }
  
  protected static final void jdoSetm_nombreTrimestreRetraite(IndividuPbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nombreTrimestreRetraite = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 11, m_nombreTrimestreRetraite, newValue);
    } else {
      m_nombreTrimestreRetraite = newValue;
    }
  }
  
  protected static final void jdoSetm_dateAtteinteMoisNonPaye(IndividuPbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateAtteinteMoisNonPaye = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 12, m_dateAtteinteMoisNonPaye, newValue);
    } else {
      m_dateAtteinteMoisNonPaye = newValue;
    }
  }
  
  protected static final void jdoSetm_dateDebutIneligibiliteAidesMob(IndividuPbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebutIneligibiliteAidesMob = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 13, m_dateDebutIneligibiliteAidesMob, newValue);
    } else {
      m_dateDebutIneligibiliteAidesMob = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinIneligibiliteAidesMob(IndividuPbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinIneligibiliteAidesMob = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 14, m_dateFinIneligibiliteAidesMob, newValue);
    } else {
      m_dateFinIneligibiliteAidesMob = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDerniereExecCal);
      break;
    case 1: 
      jdoStateManager.providedIntField(this, fieldNumber, m_heureDerniereExecCal);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDerniereDemCal);
      break;
    case 3: 
      jdoStateManager.providedIntField(this, fieldNumber, m_heureDerniereDemCal);
      break;
    case 4: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dernierJourIndemnisable);
      break;
    case 5: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDepartRetraiteCalculee);
      break;
    case 6: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeJustifRetraite);
      break;
    case 7: 
      jdoStateManager.providedIntField(this, fieldNumber, m_etatDerniereExecution);
      break;
    case 8: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeAnomalieCalcul);
      break;
    case 9: 
      jdoStateManager.providedStringField(this, fieldNumber, m_donneeAnomalieCalcul);
      break;
    case 10: 
      jdoStateManager.providedStringField(this, fieldNumber, m_contexteExecution);
      break;
    case 11: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nombreTrimestreRetraite);
      break;
    case 12: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateAtteinteMoisNonPaye);
      break;
    case 13: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebutIneligibiliteAidesMob);
      break;
    case 14: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinIneligibiliteAidesMob);
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
      m_dateDerniereExecCal = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 1: 
      m_heureDerniereExecCal = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 2: 
      m_dateDerniereDemCal = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 3: 
      m_heureDerniereDemCal = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 4: 
      m_dernierJourIndemnisable = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 5: 
      m_dateDepartRetraiteCalculee = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 6: 
      m_codeJustifRetraite = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 7: 
      m_etatDerniereExecution = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 8: 
      m_codeAnomalieCalcul = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 9: 
      m_donneeAnomalieCalcul = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 10: 
      m_contexteExecution = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 11: 
      m_nombreTrimestreRetraite = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 12: 
      m_dateAtteinteMoisNonPaye = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 13: 
      m_dateDebutIneligibiliteAidesMob = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 14: 
      m_dateFinIneligibiliteAidesMob = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
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
    IndividuPbjcNcpPC pc = new IndividuPbjcNcpPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    IndividuPbjcNcpPC pc = new IndividuPbjcNcpPC();
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
    if (!(pc instanceof IndividuPbjcNcpPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    IndividuPbjcNcpPC other = (IndividuPbjcNcpPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_dateDerniereExecCal = m_dateDerniereExecCal;
        break;
      case 1: 
        m_heureDerniereExecCal = m_heureDerniereExecCal;
        break;
      case 2: 
        m_dateDerniereDemCal = m_dateDerniereDemCal;
        break;
      case 3: 
        m_heureDerniereDemCal = m_heureDerniereDemCal;
        break;
      case 4: 
        m_dernierJourIndemnisable = m_dernierJourIndemnisable;
        break;
      case 5: 
        m_dateDepartRetraiteCalculee = m_dateDepartRetraiteCalculee;
        break;
      case 6: 
        m_codeJustifRetraite = m_codeJustifRetraite;
        break;
      case 7: 
        m_etatDerniereExecution = m_etatDerniereExecution;
        break;
      case 8: 
        m_codeAnomalieCalcul = m_codeAnomalieCalcul;
        break;
      case 9: 
        m_donneeAnomalieCalcul = m_donneeAnomalieCalcul;
        break;
      case 10: 
        m_contexteExecution = m_contexteExecution;
        break;
      case 11: 
        m_nombreTrimestreRetraite = m_nombreTrimestreRetraite;
        break;
      case 12: 
        m_dateAtteinteMoisNonPaye = m_dateAtteinteMoisNonPaye;
        break;
      case 13: 
        m_dateDebutIneligibiliteAidesMob = m_dateDebutIneligibiliteAidesMob;
        break;
      case 14: 
        m_dateFinIneligibiliteAidesMob = m_dateFinIneligibiliteAidesMob;
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
 * Qualified Name:     IndividuPbjcNcpPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */