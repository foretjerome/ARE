package fr.unedic.cali.dom.pivot.pc;

import fr.unedic.cali.dom.pivot.PeriodeLieu;
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

public class PeriodeLieuPC
  implements DomPCSpec, PersistenceCapable
{
  private transient PeriodeLieu m_periodeLieuOM;
  protected int m_identifiantPlanFormation;
  protected int m_idPeriodeFormation;
  protected Damj m_dateDebutPeriode;
  protected String m_typeFrais;
  protected Damj m_dateFinPeriode;
  protected String m_lieuFormation;
  protected int m_nbJoursPresenceStage;
  protected String m_priseEnComptePlafondMajore;
  protected int m_nbAR;
  protected BigDecimal m_montantUnitaireAR;
  protected BigDecimal m_montantUnitaireNuit;
  protected int m_nbNuits;
  protected BigDecimal m_montantUnitaireRepas;
  protected int m_nbRepas;
  protected int m_hebergementChargeStagiaire;
  protected BigDecimal m_montantNuite;
  protected int m_nombreKmAR;
  protected String m_codeProduit;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_identifiantPlanFormation", "m_idPeriodeFormation", "m_dateDebutPeriode", "m_typeFrais", "m_dateFinPeriode", "m_lieuFormation", "m_nbJoursPresenceStage", "m_priseEnComptePlafondMajore", "m_nbAR", "m_montantUnitaireAR", "m_montantUnitaireNuit", "m_nbNuits", "m_montantUnitaireRepas", "m_nbRepas", "m_hebergementChargeStagiaire", "m_montantNuite", "m_nombreKmAR", "m_codeProduit" };
  private static Class[] jdoFieldTypes = { Integer.TYPE, Integer.TYPE, Damj.class, String.class, Damj.class, String.class, Integer.TYPE, String.class, Integer.TYPE, BigDecimal.class, BigDecimal.class, Integer.TYPE, BigDecimal.class, Integer.TYPE, Integer.TYPE, BigDecimal.class, Integer.TYPE, String.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_periodeLieuOM == null) {
      m_periodeLieuOM = new PeriodeLieu(this);
    }
    return m_periodeLieuOM;
  }
  
  public int getIdentifiantPlanFormation()
  {
    return jdoGetm_identifiantPlanFormation(this);
  }
  
  public final void setIdentifiantPlanFormation(int p_identifiantPlanFormation)
  {
    jdoSetm_identifiantPlanFormation(this, p_identifiantPlanFormation);
  }
  
  public int getIdPeriodeFormation()
  {
    return jdoGetm_idPeriodeFormation(this);
  }
  
  public final void setIdPeriodeFormation(int p_idPeriodeFormation)
  {
    jdoSetm_idPeriodeFormation(this, p_idPeriodeFormation);
  }
  
  public Damj getDateDebutPeriode()
  {
    return jdoGetm_dateDebutPeriode(this);
  }
  
  public final void setDateDebutPeriode(Damj p_dateDebutPeriode)
  {
    jdoSetm_dateDebutPeriode(this, p_dateDebutPeriode);
  }
  
  public String getTypeFrais()
  {
    return jdoGetm_typeFrais(this);
  }
  
  public final void setTypeFrais(String p_typeFrais)
  {
    jdoSetm_typeFrais(this, p_typeFrais);
  }
  
  public Damj getDateFinPeriode()
  {
    return jdoGetm_dateFinPeriode(this);
  }
  
  public final void setDateFinPeriode(Damj p_dateFinPeriode)
  {
    jdoSetm_dateFinPeriode(this, p_dateFinPeriode);
  }
  
  public String getLieuFormation()
  {
    return jdoGetm_lieuFormation(this);
  }
  
  public final void setLieuFormation(String p_lieuFormation)
  {
    jdoSetm_lieuFormation(this, p_lieuFormation);
  }
  
  public int getNbJoursPresenceStage()
  {
    return jdoGetm_nbJoursPresenceStage(this);
  }
  
  public final void setNbJoursPresenceStage(int p_nbJoursPresenceStage)
  {
    jdoSetm_nbJoursPresenceStage(this, p_nbJoursPresenceStage);
  }
  
  public String getPriseEnComptePlafondMajore()
  {
    return jdoGetm_priseEnComptePlafondMajore(this);
  }
  
  public final void setPriseEnComptePlafondMajore(String p_priseEnComptePlafondMajore)
  {
    jdoSetm_priseEnComptePlafondMajore(this, p_priseEnComptePlafondMajore);
  }
  
  public int getNbAR()
  {
    return jdoGetm_nbAR(this);
  }
  
  public final void setNbAR(int p_nbAR)
  {
    jdoSetm_nbAR(this, p_nbAR);
  }
  
  public BigDecimal getMontantUnitaireAR()
  {
    return jdoGetm_montantUnitaireAR(this);
  }
  
  public final void setMontantUnitaireAR(BigDecimal p_montantUnitaireAR)
  {
    jdoSetm_montantUnitaireAR(this, p_montantUnitaireAR);
  }
  
  public BigDecimal getMontantUnitaireNuit()
  {
    return jdoGetm_montantUnitaireNuit(this);
  }
  
  public final void setMontantUnitaireNuit(BigDecimal p_montantUnitaireNuit)
  {
    jdoSetm_montantUnitaireNuit(this, p_montantUnitaireNuit);
  }
  
  public int getNbNuits()
  {
    return jdoGetm_nbNuits(this);
  }
  
  public final void setNbNuits(int p_nbNuits)
  {
    jdoSetm_nbNuits(this, p_nbNuits);
  }
  
  public BigDecimal getMontantUnitaireRepas()
  {
    return jdoGetm_montantUnitaireRepas(this);
  }
  
  public final void setMontantUnitaireRepas(BigDecimal p_montantUnitaireRepas)
  {
    jdoSetm_montantUnitaireRepas(this, p_montantUnitaireRepas);
  }
  
  public int getNbRepas()
  {
    return jdoGetm_nbRepas(this);
  }
  
  public final void setNbRepas(int p_nbRepas)
  {
    jdoSetm_nbRepas(this, p_nbRepas);
  }
  
  public int getHebergementChargeStagiaire()
  {
    return jdoGetm_hebergementChargeStagiaire(this);
  }
  
  public final void setHebergementChargeStagiaire(int p_hebergementChargeStagiaire)
  {
    jdoSetm_hebergementChargeStagiaire(this, p_hebergementChargeStagiaire);
  }
  
  public BigDecimal getMontantNuite()
  {
    return jdoGetm_montantNuite(this);
  }
  
  public final void setMontantNuite(BigDecimal p_montantNuite)
  {
    jdoSetm_montantNuite(this, p_montantNuite);
  }
  
  public int getNombreKmAR()
  {
    return jdoGetm_nombreKmAR(this);
  }
  
  public final void setNombreKmAR(int p_nombreKmAR)
  {
    jdoSetm_nombreKmAR(this, p_nombreKmAR);
  }
  
  public String getCodeProduit()
  {
    return jdoGetm_codeProduit(this);
  }
  
  public final void setCodeProduit(String p_codeProduit)
  {
    jdoSetm_codeProduit(this, p_codeProduit);
  }
  
  static
  {
    JDOImplHelper.registerClass(PeriodeLieuPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new PeriodeLieuPC());
  }
  
  protected static final int jdoGetm_identifiantPlanFormation(PeriodeLieuPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantPlanFormation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_identifiantPlanFormation;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 0, m_identifiantPlanFormation);
    }
    return m_identifiantPlanFormation;
  }
  
  protected static final int jdoGetm_idPeriodeFormation(PeriodeLieuPC pc)
  {
    if (jdoFlags <= 0) {
      return m_idPeriodeFormation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_idPeriodeFormation;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 1, m_idPeriodeFormation);
    }
    return m_idPeriodeFormation;
  }
  
  protected static final Damj jdoGetm_dateDebutPeriode(PeriodeLieuPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebutPeriode;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_dateDebutPeriode;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_dateDebutPeriode);
    }
    return m_dateDebutPeriode;
  }
  
  protected static final String jdoGetm_typeFrais(PeriodeLieuPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeFrais;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_typeFrais;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 3, m_typeFrais);
    }
    return m_typeFrais;
  }
  
  protected static final Damj jdoGetm_dateFinPeriode(PeriodeLieuPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinPeriode;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_dateFinPeriode;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 4, m_dateFinPeriode);
    }
    return m_dateFinPeriode;
  }
  
  protected static final String jdoGetm_lieuFormation(PeriodeLieuPC pc)
  {
    if (jdoFlags <= 0) {
      return m_lieuFormation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_lieuFormation;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 5, m_lieuFormation);
    }
    return m_lieuFormation;
  }
  
  protected static final int jdoGetm_nbJoursPresenceStage(PeriodeLieuPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJoursPresenceStage;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_nbJoursPresenceStage;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 6, m_nbJoursPresenceStage);
    }
    return m_nbJoursPresenceStage;
  }
  
  protected static final String jdoGetm_priseEnComptePlafondMajore(PeriodeLieuPC pc)
  {
    if (jdoFlags <= 0) {
      return m_priseEnComptePlafondMajore;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_priseEnComptePlafondMajore;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 7, m_priseEnComptePlafondMajore);
    }
    return m_priseEnComptePlafondMajore;
  }
  
  protected static final int jdoGetm_nbAR(PeriodeLieuPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbAR;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_nbAR;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 8, m_nbAR);
    }
    return m_nbAR;
  }
  
  protected static final BigDecimal jdoGetm_montantUnitaireAR(PeriodeLieuPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantUnitaireAR;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 9)) {
        return m_montantUnitaireAR;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 9, m_montantUnitaireAR);
    }
    return m_montantUnitaireAR;
  }
  
  protected static final BigDecimal jdoGetm_montantUnitaireNuit(PeriodeLieuPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantUnitaireNuit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 10)) {
        return m_montantUnitaireNuit;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 10, m_montantUnitaireNuit);
    }
    return m_montantUnitaireNuit;
  }
  
  protected static final int jdoGetm_nbNuits(PeriodeLieuPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbNuits;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 11)) {
        return m_nbNuits;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 11, m_nbNuits);
    }
    return m_nbNuits;
  }
  
  protected static final BigDecimal jdoGetm_montantUnitaireRepas(PeriodeLieuPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantUnitaireRepas;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 12)) {
        return m_montantUnitaireRepas;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 12, m_montantUnitaireRepas);
    }
    return m_montantUnitaireRepas;
  }
  
  protected static final int jdoGetm_nbRepas(PeriodeLieuPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbRepas;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 13)) {
        return m_nbRepas;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 13, m_nbRepas);
    }
    return m_nbRepas;
  }
  
  protected static final int jdoGetm_hebergementChargeStagiaire(PeriodeLieuPC pc)
  {
    if (jdoFlags <= 0) {
      return m_hebergementChargeStagiaire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 14)) {
        return m_hebergementChargeStagiaire;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 14, m_hebergementChargeStagiaire);
    }
    return m_hebergementChargeStagiaire;
  }
  
  protected static final BigDecimal jdoGetm_montantNuite(PeriodeLieuPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantNuite;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 15)) {
        return m_montantNuite;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 15, m_montantNuite);
    }
    return m_montantNuite;
  }
  
  protected static final int jdoGetm_nombreKmAR(PeriodeLieuPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nombreKmAR;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 16)) {
        return m_nombreKmAR;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 16, m_nombreKmAR);
    }
    return m_nombreKmAR;
  }
  
  protected static final String jdoGetm_codeProduit(PeriodeLieuPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeProduit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 17)) {
        return m_codeProduit;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 17, m_codeProduit);
    }
    return m_codeProduit;
  }
  
  protected static final void jdoSetm_identifiantPlanFormation(PeriodeLieuPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantPlanFormation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 0, m_identifiantPlanFormation, newValue);
    } else {
      m_identifiantPlanFormation = newValue;
    }
  }
  
  protected static final void jdoSetm_idPeriodeFormation(PeriodeLieuPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_idPeriodeFormation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 1, m_idPeriodeFormation, newValue);
    } else {
      m_idPeriodeFormation = newValue;
    }
  }
  
  protected static final void jdoSetm_dateDebutPeriode(PeriodeLieuPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebutPeriode = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_dateDebutPeriode, newValue);
    } else {
      m_dateDebutPeriode = newValue;
    }
  }
  
  protected static final void jdoSetm_typeFrais(PeriodeLieuPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeFrais = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 3, m_typeFrais, newValue);
    } else {
      m_typeFrais = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinPeriode(PeriodeLieuPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinPeriode = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 4, m_dateFinPeriode, newValue);
    } else {
      m_dateFinPeriode = newValue;
    }
  }
  
  protected static final void jdoSetm_lieuFormation(PeriodeLieuPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_lieuFormation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 5, m_lieuFormation, newValue);
    } else {
      m_lieuFormation = newValue;
    }
  }
  
  protected static final void jdoSetm_nbJoursPresenceStage(PeriodeLieuPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJoursPresenceStage = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 6, m_nbJoursPresenceStage, newValue);
    } else {
      m_nbJoursPresenceStage = newValue;
    }
  }
  
  protected static final void jdoSetm_priseEnComptePlafondMajore(PeriodeLieuPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_priseEnComptePlafondMajore = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 7, m_priseEnComptePlafondMajore, newValue);
    } else {
      m_priseEnComptePlafondMajore = newValue;
    }
  }
  
  protected static final void jdoSetm_nbAR(PeriodeLieuPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbAR = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 8, m_nbAR, newValue);
    } else {
      m_nbAR = newValue;
    }
  }
  
  protected static final void jdoSetm_montantUnitaireAR(PeriodeLieuPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantUnitaireAR = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 9, m_montantUnitaireAR, newValue);
    } else {
      m_montantUnitaireAR = newValue;
    }
  }
  
  protected static final void jdoSetm_montantUnitaireNuit(PeriodeLieuPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantUnitaireNuit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 10, m_montantUnitaireNuit, newValue);
    } else {
      m_montantUnitaireNuit = newValue;
    }
  }
  
  protected static final void jdoSetm_nbNuits(PeriodeLieuPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbNuits = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 11, m_nbNuits, newValue);
    } else {
      m_nbNuits = newValue;
    }
  }
  
  protected static final void jdoSetm_montantUnitaireRepas(PeriodeLieuPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantUnitaireRepas = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 12, m_montantUnitaireRepas, newValue);
    } else {
      m_montantUnitaireRepas = newValue;
    }
  }
  
  protected static final void jdoSetm_nbRepas(PeriodeLieuPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbRepas = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 13, m_nbRepas, newValue);
    } else {
      m_nbRepas = newValue;
    }
  }
  
  protected static final void jdoSetm_hebergementChargeStagiaire(PeriodeLieuPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_hebergementChargeStagiaire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 14, m_hebergementChargeStagiaire, newValue);
    } else {
      m_hebergementChargeStagiaire = newValue;
    }
  }
  
  protected static final void jdoSetm_montantNuite(PeriodeLieuPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantNuite = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 15, m_montantNuite, newValue);
    } else {
      m_montantNuite = newValue;
    }
  }
  
  protected static final void jdoSetm_nombreKmAR(PeriodeLieuPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nombreKmAR = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 16, m_nombreKmAR, newValue);
    } else {
      m_nombreKmAR = newValue;
    }
  }
  
  protected static final void jdoSetm_codeProduit(PeriodeLieuPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeProduit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 17, m_codeProduit, newValue);
    } else {
      m_codeProduit = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedIntField(this, fieldNumber, m_identifiantPlanFormation);
      break;
    case 1: 
      jdoStateManager.providedIntField(this, fieldNumber, m_idPeriodeFormation);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebutPeriode);
      break;
    case 3: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeFrais);
      break;
    case 4: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinPeriode);
      break;
    case 5: 
      jdoStateManager.providedStringField(this, fieldNumber, m_lieuFormation);
      break;
    case 6: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbJoursPresenceStage);
      break;
    case 7: 
      jdoStateManager.providedStringField(this, fieldNumber, m_priseEnComptePlafondMajore);
      break;
    case 8: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbAR);
      break;
    case 9: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantUnitaireAR);
      break;
    case 10: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantUnitaireNuit);
      break;
    case 11: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbNuits);
      break;
    case 12: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantUnitaireRepas);
      break;
    case 13: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbRepas);
      break;
    case 14: 
      jdoStateManager.providedIntField(this, fieldNumber, m_hebergementChargeStagiaire);
      break;
    case 15: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantNuite);
      break;
    case 16: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nombreKmAR);
      break;
    case 17: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeProduit);
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
      m_identifiantPlanFormation = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 1: 
      m_idPeriodeFormation = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 2: 
      m_dateDebutPeriode = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 3: 
      m_typeFrais = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 4: 
      m_dateFinPeriode = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 5: 
      m_lieuFormation = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 6: 
      m_nbJoursPresenceStage = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 7: 
      m_priseEnComptePlafondMajore = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 8: 
      m_nbAR = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 9: 
      m_montantUnitaireAR = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 10: 
      m_montantUnitaireNuit = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 11: 
      m_nbNuits = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 12: 
      m_montantUnitaireRepas = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 13: 
      m_nbRepas = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 14: 
      m_hebergementChargeStagiaire = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 15: 
      m_montantNuite = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 16: 
      m_nombreKmAR = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 17: 
      m_codeProduit = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
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
    PeriodeLieuPC pc = new PeriodeLieuPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    PeriodeLieuPC pc = new PeriodeLieuPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 18;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof PeriodeLieuPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    PeriodeLieuPC other = (PeriodeLieuPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_identifiantPlanFormation = m_identifiantPlanFormation;
        break;
      case 1: 
        m_idPeriodeFormation = m_idPeriodeFormation;
        break;
      case 2: 
        m_dateDebutPeriode = m_dateDebutPeriode;
        break;
      case 3: 
        m_typeFrais = m_typeFrais;
        break;
      case 4: 
        m_dateFinPeriode = m_dateFinPeriode;
        break;
      case 5: 
        m_lieuFormation = m_lieuFormation;
        break;
      case 6: 
        m_nbJoursPresenceStage = m_nbJoursPresenceStage;
        break;
      case 7: 
        m_priseEnComptePlafondMajore = m_priseEnComptePlafondMajore;
        break;
      case 8: 
        m_nbAR = m_nbAR;
        break;
      case 9: 
        m_montantUnitaireAR = m_montantUnitaireAR;
        break;
      case 10: 
        m_montantUnitaireNuit = m_montantUnitaireNuit;
        break;
      case 11: 
        m_nbNuits = m_nbNuits;
        break;
      case 12: 
        m_montantUnitaireRepas = m_montantUnitaireRepas;
        break;
      case 13: 
        m_nbRepas = m_nbRepas;
        break;
      case 14: 
        m_hebergementChargeStagiaire = m_hebergementChargeStagiaire;
        break;
      case 15: 
        m_montantNuite = m_montantNuite;
        break;
      case 16: 
        m_nombreKmAR = m_nombreKmAR;
        break;
      case 17: 
        m_codeProduit = m_codeProduit;
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
 * Qualified Name:     PeriodeLieuPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */