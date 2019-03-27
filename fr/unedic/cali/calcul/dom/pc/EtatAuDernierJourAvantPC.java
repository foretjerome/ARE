package fr.unedic.cali.calcul.dom.pc;

import fr.unedic.cali.calcul.dom.EtatAuDernierJourAvant;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.temps.Periode;
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

public class EtatAuDernierJourAvantPC
  implements DomPCSpec, PersistenceCapable
{
  private transient EtatAuDernierJourAvant m_etatAuDernierJourAvantOM;
  private Integer m_reliquatPMC;
  private Integer m_reliquatICCP;
  private Integer m_reliquatISLR;
  private Integer m_reliquatDelaiAttente;
  private boolean m_delaiAttenteEntame;
  private int m_etat;
  private Periode m_periodeApplicationPMC;
  private Periode m_periodeApplicationICCP;
  private Periode m_periodeApplicationISLR;
  private Periode m_periodeApplicationDelaiAttente;
  private Integer m_dureeInitialePMC;
  private Integer m_dureeInitialeICCP;
  private Integer m_dureeInitialeISLR;
  private Integer m_dureeInitialeDelaiAttente;
  private Periode m_periodePECEvenementReducteur;
  private Integer m_reliquatCP;
  private Integer m_reliquatSalaire;
  private Integer m_dureeInitialeCP;
  private Integer m_dureeInitialeSalaire;
  private Periode m_periodeApplicationCP;
  private Periode m_periodeApplicationSalaire;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_reliquatPMC", "m_reliquatICCP", "m_reliquatISLR", "m_reliquatDelaiAttente", "m_delaiAttenteEntame", "m_etat", "m_periodeApplicationPMC", "m_periodeApplicationICCP", "m_periodeApplicationISLR", "m_periodeApplicationDelaiAttente", "m_dureeInitialePMC", "m_dureeInitialeICCP", "m_dureeInitialeISLR", "m_dureeInitialeDelaiAttente", "m_periodePECEvenementReducteur", "m_reliquatCP", "m_reliquatSalaire", "m_dureeInitialeCP", "m_dureeInitialeSalaire", "m_periodeApplicationCP", "m_periodeApplicationSalaire" };
  private static Class[] jdoFieldTypes = { Integer.class, Integer.class, Integer.class, Integer.class, Boolean.TYPE, Integer.TYPE, Periode.class, Periode.class, Periode.class, Periode.class, Integer.class, Integer.class, Integer.class, Integer.class, Periode.class, Integer.class, Integer.class, Integer.class, Integer.class, Periode.class, Periode.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public EtatAuDernierJourAvantPC()
  {
    jdoSetm_delaiAttenteEntame(this, false);
  }
  
  public Object createOM()
  {
    if (m_etatAuDernierJourAvantOM == null) {
      m_etatAuDernierJourAvantOM = new EtatAuDernierJourAvant(this);
    }
    return m_etatAuDernierJourAvantOM;
  }
  
  public Integer getReliquatPMC()
  {
    return jdoGetm_reliquatPMC(this);
  }
  
  public final void setReliquatPMC(Integer p_reliquatPMC)
  {
    jdoSetm_reliquatPMC(this, p_reliquatPMC);
  }
  
  public Integer getReliquatICCP()
  {
    return jdoGetm_reliquatICCP(this);
  }
  
  public final void setReliquatICCP(Integer p_reliquatICCP)
  {
    jdoSetm_reliquatICCP(this, p_reliquatICCP);
  }
  
  public Integer getReliquatISLR()
  {
    return jdoGetm_reliquatISLR(this);
  }
  
  public final void setReliquatISLR(Integer p_reliquatISLR)
  {
    jdoSetm_reliquatISLR(this, p_reliquatISLR);
  }
  
  public Integer getReliquatDelaiAttente()
  {
    return jdoGetm_reliquatDelaiAttente(this);
  }
  
  public final void setReliquatDelaiAttente(Integer p_reliquatDelaiAttente)
  {
    jdoSetm_reliquatDelaiAttente(this, p_reliquatDelaiAttente);
  }
  
  public boolean isDelaiAttenteEntame()
  {
    return jdoGetm_delaiAttenteEntame(this);
  }
  
  public final void setDelaiAttenteEntame(boolean p_delaiAttenteEntame)
  {
    jdoSetm_delaiAttenteEntame(this, p_delaiAttenteEntame);
  }
  
  public int getEtat()
  {
    return jdoGetm_etat(this);
  }
  
  public final void setEtat(int p_etat)
  {
    jdoSetm_etat(this, p_etat);
  }
  
  public Periode getPeriodeApplicationPMC()
  {
    return jdoGetm_periodeApplicationPMC(this);
  }
  
  public final void setPeriodeApplicationPMC(Periode p_periodeApplicationPMC)
  {
    jdoSetm_periodeApplicationPMC(this, p_periodeApplicationPMC);
  }
  
  public Periode getPeriodeApplicationICCP()
  {
    return jdoGetm_periodeApplicationICCP(this);
  }
  
  public final void setPeriodeApplicationICCP(Periode p_periodeApplicationICCP)
  {
    jdoSetm_periodeApplicationICCP(this, p_periodeApplicationICCP);
  }
  
  public Periode getPeriodeApplicationISLR()
  {
    return jdoGetm_periodeApplicationISLR(this);
  }
  
  public final void setPeriodeApplicationISLR(Periode p_periodeApplicationISLR)
  {
    jdoSetm_periodeApplicationISLR(this, p_periodeApplicationISLR);
  }
  
  public Periode getPeriodeApplicationDelaiAttente()
  {
    return jdoGetm_periodeApplicationDelaiAttente(this);
  }
  
  public final void setPeriodeApplicationDelaiAttente(Periode p_periodeApplicationDelaiAttente)
  {
    jdoSetm_periodeApplicationDelaiAttente(this, p_periodeApplicationDelaiAttente);
  }
  
  public Integer getDureeInitialePMC()
  {
    return jdoGetm_dureeInitialePMC(this);
  }
  
  public final void setDureeInitialePMC(Integer p_dureeInitialePMC)
  {
    jdoSetm_dureeInitialePMC(this, p_dureeInitialePMC);
  }
  
  public Integer getDureeInitialeICCP()
  {
    return jdoGetm_dureeInitialeICCP(this);
  }
  
  public final void setDureeInitialeICCP(Integer p_dureeInitialeICCP)
  {
    jdoSetm_dureeInitialeICCP(this, p_dureeInitialeICCP);
  }
  
  public Integer getDureeInitialeISLR()
  {
    return jdoGetm_dureeInitialeISLR(this);
  }
  
  public final void setDureeInitialeISLR(Integer p_dureeInitialeISLR)
  {
    jdoSetm_dureeInitialeISLR(this, p_dureeInitialeISLR);
  }
  
  public Integer getDureeInitialeDelaiAttente()
  {
    return jdoGetm_dureeInitialeDelaiAttente(this);
  }
  
  public final void setDureeInitialeDelaiAttente(Integer p_dureeInitialeDelaiAttente)
  {
    jdoSetm_dureeInitialeDelaiAttente(this, p_dureeInitialeDelaiAttente);
  }
  
  public Periode getPeriodePECEvenementReducteur()
  {
    return jdoGetm_periodePECEvenementReducteur(this);
  }
  
  public final void setPeriodePECEvenementReducteur(Periode p_periodePECEvenementReducteur)
  {
    jdoSetm_periodePECEvenementReducteur(this, p_periodePECEvenementReducteur);
  }
  
  public Integer getReliquatCP()
  {
    return jdoGetm_reliquatCP(this);
  }
  
  public final void setReliquatCP(Integer p_reliquatCP)
  {
    jdoSetm_reliquatCP(this, p_reliquatCP);
  }
  
  public Integer getReliquatSalaire()
  {
    return jdoGetm_reliquatSalaire(this);
  }
  
  public final void setReliquatSalaire(Integer p_reliquatSalaire)
  {
    jdoSetm_reliquatSalaire(this, p_reliquatSalaire);
  }
  
  public Integer getDureeInitialeCP()
  {
    return jdoGetm_dureeInitialeCP(this);
  }
  
  public final void setDureeInitialeCP(Integer p_dureeInitialeCP)
  {
    jdoSetm_dureeInitialeCP(this, p_dureeInitialeCP);
  }
  
  public Integer getDureeInitialeSalaire()
  {
    return jdoGetm_dureeInitialeSalaire(this);
  }
  
  public final void setDureeInitialeSalaire(Integer p_dureeInitialeSalaire)
  {
    jdoSetm_dureeInitialeSalaire(this, p_dureeInitialeSalaire);
  }
  
  public Periode getPeriodeApplicationCP()
  {
    return jdoGetm_periodeApplicationCP(this);
  }
  
  public final void setPeriodeApplicationCP(Periode p_periodeApplicationCP)
  {
    jdoSetm_periodeApplicationCP(this, p_periodeApplicationCP);
  }
  
  public Periode getPeriodeApplicationSalaire()
  {
    return jdoGetm_periodeApplicationSalaire(this);
  }
  
  public final void setPeriodeApplicationSalaire(Periode p_periodeApplicationSalaire)
  {
    jdoSetm_periodeApplicationSalaire(this, p_periodeApplicationSalaire);
  }
  
  static
  {
    JDOImplHelper.registerClass(EtatAuDernierJourAvantPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new EtatAuDernierJourAvantPC());
  }
  
  private static final Integer jdoGetm_reliquatPMC(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reliquatPMC;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_reliquatPMC;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 0, m_reliquatPMC);
    }
    return m_reliquatPMC;
  }
  
  private static final Integer jdoGetm_reliquatICCP(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reliquatICCP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_reliquatICCP;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_reliquatICCP);
    }
    return m_reliquatICCP;
  }
  
  private static final Integer jdoGetm_reliquatISLR(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reliquatISLR;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_reliquatISLR;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_reliquatISLR);
    }
    return m_reliquatISLR;
  }
  
  private static final Integer jdoGetm_reliquatDelaiAttente(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reliquatDelaiAttente;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_reliquatDelaiAttente;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 3, m_reliquatDelaiAttente);
    }
    return m_reliquatDelaiAttente;
  }
  
  private static final boolean jdoGetm_delaiAttenteEntame(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_delaiAttenteEntame;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_delaiAttenteEntame;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 4, m_delaiAttenteEntame);
    }
    return m_delaiAttenteEntame;
  }
  
  private static final int jdoGetm_etat(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_etat;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_etat;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 5, m_etat);
    }
    return m_etat;
  }
  
  private static final Periode jdoGetm_periodeApplicationPMC(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_periodeApplicationPMC;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_periodeApplicationPMC;
      }
      return (Periode)sm.getObjectField(pc, jdoInheritedFieldCount + 6, m_periodeApplicationPMC);
    }
    return m_periodeApplicationPMC;
  }
  
  private static final Periode jdoGetm_periodeApplicationICCP(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_periodeApplicationICCP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_periodeApplicationICCP;
      }
      return (Periode)sm.getObjectField(pc, jdoInheritedFieldCount + 7, m_periodeApplicationICCP);
    }
    return m_periodeApplicationICCP;
  }
  
  private static final Periode jdoGetm_periodeApplicationISLR(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_periodeApplicationISLR;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_periodeApplicationISLR;
      }
      return (Periode)sm.getObjectField(pc, jdoInheritedFieldCount + 8, m_periodeApplicationISLR);
    }
    return m_periodeApplicationISLR;
  }
  
  private static final Periode jdoGetm_periodeApplicationDelaiAttente(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_periodeApplicationDelaiAttente;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 9)) {
        return m_periodeApplicationDelaiAttente;
      }
      return (Periode)sm.getObjectField(pc, jdoInheritedFieldCount + 9, m_periodeApplicationDelaiAttente);
    }
    return m_periodeApplicationDelaiAttente;
  }
  
  private static final Integer jdoGetm_dureeInitialePMC(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeInitialePMC;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 10)) {
        return m_dureeInitialePMC;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 10, m_dureeInitialePMC);
    }
    return m_dureeInitialePMC;
  }
  
  private static final Integer jdoGetm_dureeInitialeICCP(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeInitialeICCP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 11)) {
        return m_dureeInitialeICCP;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 11, m_dureeInitialeICCP);
    }
    return m_dureeInitialeICCP;
  }
  
  private static final Integer jdoGetm_dureeInitialeISLR(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeInitialeISLR;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 12)) {
        return m_dureeInitialeISLR;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 12, m_dureeInitialeISLR);
    }
    return m_dureeInitialeISLR;
  }
  
  private static final Integer jdoGetm_dureeInitialeDelaiAttente(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeInitialeDelaiAttente;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 13)) {
        return m_dureeInitialeDelaiAttente;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 13, m_dureeInitialeDelaiAttente);
    }
    return m_dureeInitialeDelaiAttente;
  }
  
  private static final Periode jdoGetm_periodePECEvenementReducteur(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_periodePECEvenementReducteur;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 14)) {
        return m_periodePECEvenementReducteur;
      }
      return (Periode)sm.getObjectField(pc, jdoInheritedFieldCount + 14, m_periodePECEvenementReducteur);
    }
    return m_periodePECEvenementReducteur;
  }
  
  private static final Integer jdoGetm_reliquatCP(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reliquatCP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 15)) {
        return m_reliquatCP;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 15, m_reliquatCP);
    }
    return m_reliquatCP;
  }
  
  private static final Integer jdoGetm_reliquatSalaire(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reliquatSalaire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 16)) {
        return m_reliquatSalaire;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 16, m_reliquatSalaire);
    }
    return m_reliquatSalaire;
  }
  
  private static final Integer jdoGetm_dureeInitialeCP(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeInitialeCP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 17)) {
        return m_dureeInitialeCP;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 17, m_dureeInitialeCP);
    }
    return m_dureeInitialeCP;
  }
  
  private static final Integer jdoGetm_dureeInitialeSalaire(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dureeInitialeSalaire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 18)) {
        return m_dureeInitialeSalaire;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 18, m_dureeInitialeSalaire);
    }
    return m_dureeInitialeSalaire;
  }
  
  private static final Periode jdoGetm_periodeApplicationCP(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_periodeApplicationCP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 19)) {
        return m_periodeApplicationCP;
      }
      return (Periode)sm.getObjectField(pc, jdoInheritedFieldCount + 19, m_periodeApplicationCP);
    }
    return m_periodeApplicationCP;
  }
  
  private static final Periode jdoGetm_periodeApplicationSalaire(EtatAuDernierJourAvantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_periodeApplicationSalaire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 20)) {
        return m_periodeApplicationSalaire;
      }
      return (Periode)sm.getObjectField(pc, jdoInheritedFieldCount + 20, m_periodeApplicationSalaire);
    }
    return m_periodeApplicationSalaire;
  }
  
  private static final void jdoSetm_reliquatPMC(EtatAuDernierJourAvantPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_reliquatPMC = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 0, m_reliquatPMC, newValue);
    } else {
      m_reliquatPMC = newValue;
    }
  }
  
  private static final void jdoSetm_reliquatICCP(EtatAuDernierJourAvantPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_reliquatICCP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_reliquatICCP, newValue);
    } else {
      m_reliquatICCP = newValue;
    }
  }
  
  private static final void jdoSetm_reliquatISLR(EtatAuDernierJourAvantPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_reliquatISLR = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_reliquatISLR, newValue);
    } else {
      m_reliquatISLR = newValue;
    }
  }
  
  private static final void jdoSetm_reliquatDelaiAttente(EtatAuDernierJourAvantPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_reliquatDelaiAttente = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 3, m_reliquatDelaiAttente, newValue);
    } else {
      m_reliquatDelaiAttente = newValue;
    }
  }
  
  private static final void jdoSetm_delaiAttenteEntame(EtatAuDernierJourAvantPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_delaiAttenteEntame = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 4, m_delaiAttenteEntame, newValue);
    } else {
      m_delaiAttenteEntame = newValue;
    }
  }
  
  private static final void jdoSetm_etat(EtatAuDernierJourAvantPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_etat = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 5, m_etat, newValue);
    } else {
      m_etat = newValue;
    }
  }
  
  private static final void jdoSetm_periodeApplicationPMC(EtatAuDernierJourAvantPC pc, Periode newValue)
  {
    if (jdoFlags == 0)
    {
      m_periodeApplicationPMC = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 6, m_periodeApplicationPMC, newValue);
    } else {
      m_periodeApplicationPMC = newValue;
    }
  }
  
  private static final void jdoSetm_periodeApplicationICCP(EtatAuDernierJourAvantPC pc, Periode newValue)
  {
    if (jdoFlags == 0)
    {
      m_periodeApplicationICCP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 7, m_periodeApplicationICCP, newValue);
    } else {
      m_periodeApplicationICCP = newValue;
    }
  }
  
  private static final void jdoSetm_periodeApplicationISLR(EtatAuDernierJourAvantPC pc, Periode newValue)
  {
    if (jdoFlags == 0)
    {
      m_periodeApplicationISLR = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 8, m_periodeApplicationISLR, newValue);
    } else {
      m_periodeApplicationISLR = newValue;
    }
  }
  
  private static final void jdoSetm_periodeApplicationDelaiAttente(EtatAuDernierJourAvantPC pc, Periode newValue)
  {
    if (jdoFlags == 0)
    {
      m_periodeApplicationDelaiAttente = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 9, m_periodeApplicationDelaiAttente, newValue);
    } else {
      m_periodeApplicationDelaiAttente = newValue;
    }
  }
  
  private static final void jdoSetm_dureeInitialePMC(EtatAuDernierJourAvantPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeInitialePMC = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 10, m_dureeInitialePMC, newValue);
    } else {
      m_dureeInitialePMC = newValue;
    }
  }
  
  private static final void jdoSetm_dureeInitialeICCP(EtatAuDernierJourAvantPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeInitialeICCP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 11, m_dureeInitialeICCP, newValue);
    } else {
      m_dureeInitialeICCP = newValue;
    }
  }
  
  private static final void jdoSetm_dureeInitialeISLR(EtatAuDernierJourAvantPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeInitialeISLR = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 12, m_dureeInitialeISLR, newValue);
    } else {
      m_dureeInitialeISLR = newValue;
    }
  }
  
  private static final void jdoSetm_dureeInitialeDelaiAttente(EtatAuDernierJourAvantPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeInitialeDelaiAttente = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 13, m_dureeInitialeDelaiAttente, newValue);
    } else {
      m_dureeInitialeDelaiAttente = newValue;
    }
  }
  
  private static final void jdoSetm_periodePECEvenementReducteur(EtatAuDernierJourAvantPC pc, Periode newValue)
  {
    if (jdoFlags == 0)
    {
      m_periodePECEvenementReducteur = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 14, m_periodePECEvenementReducteur, newValue);
    } else {
      m_periodePECEvenementReducteur = newValue;
    }
  }
  
  private static final void jdoSetm_reliquatCP(EtatAuDernierJourAvantPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_reliquatCP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 15, m_reliquatCP, newValue);
    } else {
      m_reliquatCP = newValue;
    }
  }
  
  private static final void jdoSetm_reliquatSalaire(EtatAuDernierJourAvantPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_reliquatSalaire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 16, m_reliquatSalaire, newValue);
    } else {
      m_reliquatSalaire = newValue;
    }
  }
  
  private static final void jdoSetm_dureeInitialeCP(EtatAuDernierJourAvantPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeInitialeCP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 17, m_dureeInitialeCP, newValue);
    } else {
      m_dureeInitialeCP = newValue;
    }
  }
  
  private static final void jdoSetm_dureeInitialeSalaire(EtatAuDernierJourAvantPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_dureeInitialeSalaire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 18, m_dureeInitialeSalaire, newValue);
    } else {
      m_dureeInitialeSalaire = newValue;
    }
  }
  
  private static final void jdoSetm_periodeApplicationCP(EtatAuDernierJourAvantPC pc, Periode newValue)
  {
    if (jdoFlags == 0)
    {
      m_periodeApplicationCP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 19, m_periodeApplicationCP, newValue);
    } else {
      m_periodeApplicationCP = newValue;
    }
  }
  
  private static final void jdoSetm_periodeApplicationSalaire(EtatAuDernierJourAvantPC pc, Periode newValue)
  {
    if (jdoFlags == 0)
    {
      m_periodeApplicationSalaire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 20, m_periodeApplicationSalaire, newValue);
    } else {
      m_periodeApplicationSalaire = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_reliquatPMC);
      break;
    case 1: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_reliquatICCP);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_reliquatISLR);
      break;
    case 3: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_reliquatDelaiAttente);
      break;
    case 4: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_delaiAttenteEntame);
      break;
    case 5: 
      jdoStateManager.providedIntField(this, fieldNumber, m_etat);
      break;
    case 6: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_periodeApplicationPMC);
      break;
    case 7: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_periodeApplicationICCP);
      break;
    case 8: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_periodeApplicationISLR);
      break;
    case 9: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_periodeApplicationDelaiAttente);
      break;
    case 10: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dureeInitialePMC);
      break;
    case 11: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dureeInitialeICCP);
      break;
    case 12: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dureeInitialeISLR);
      break;
    case 13: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dureeInitialeDelaiAttente);
      break;
    case 14: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_periodePECEvenementReducteur);
      break;
    case 15: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_reliquatCP);
      break;
    case 16: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_reliquatSalaire);
      break;
    case 17: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dureeInitialeCP);
      break;
    case 18: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dureeInitialeSalaire);
      break;
    case 19: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_periodeApplicationCP);
      break;
    case 20: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_periodeApplicationSalaire);
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
      m_reliquatPMC = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 1: 
      m_reliquatICCP = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_reliquatISLR = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 3: 
      m_reliquatDelaiAttente = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 4: 
      m_delaiAttenteEntame = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 5: 
      m_etat = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 6: 
      m_periodeApplicationPMC = ((Periode)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 7: 
      m_periodeApplicationICCP = ((Periode)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 8: 
      m_periodeApplicationISLR = ((Periode)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 9: 
      m_periodeApplicationDelaiAttente = ((Periode)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 10: 
      m_dureeInitialePMC = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 11: 
      m_dureeInitialeICCP = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 12: 
      m_dureeInitialeISLR = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 13: 
      m_dureeInitialeDelaiAttente = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 14: 
      m_periodePECEvenementReducteur = ((Periode)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 15: 
      m_reliquatCP = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 16: 
      m_reliquatSalaire = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 17: 
      m_dureeInitialeCP = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 18: 
      m_dureeInitialeSalaire = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 19: 
      m_periodeApplicationCP = ((Periode)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 20: 
      m_periodeApplicationSalaire = ((Periode)jdoStateManager.replacingObjectField(this, fieldNumber));
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
    EtatAuDernierJourAvantPC pc = new EtatAuDernierJourAvantPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    EtatAuDernierJourAvantPC pc = new EtatAuDernierJourAvantPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 21;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof EtatAuDernierJourAvantPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    EtatAuDernierJourAvantPC other = (EtatAuDernierJourAvantPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_reliquatPMC = m_reliquatPMC;
        break;
      case 1: 
        m_reliquatICCP = m_reliquatICCP;
        break;
      case 2: 
        m_reliquatISLR = m_reliquatISLR;
        break;
      case 3: 
        m_reliquatDelaiAttente = m_reliquatDelaiAttente;
        break;
      case 4: 
        m_delaiAttenteEntame = m_delaiAttenteEntame;
        break;
      case 5: 
        m_etat = m_etat;
        break;
      case 6: 
        m_periodeApplicationPMC = m_periodeApplicationPMC;
        break;
      case 7: 
        m_periodeApplicationICCP = m_periodeApplicationICCP;
        break;
      case 8: 
        m_periodeApplicationISLR = m_periodeApplicationISLR;
        break;
      case 9: 
        m_periodeApplicationDelaiAttente = m_periodeApplicationDelaiAttente;
        break;
      case 10: 
        m_dureeInitialePMC = m_dureeInitialePMC;
        break;
      case 11: 
        m_dureeInitialeICCP = m_dureeInitialeICCP;
        break;
      case 12: 
        m_dureeInitialeISLR = m_dureeInitialeISLR;
        break;
      case 13: 
        m_dureeInitialeDelaiAttente = m_dureeInitialeDelaiAttente;
        break;
      case 14: 
        m_periodePECEvenementReducteur = m_periodePECEvenementReducteur;
        break;
      case 15: 
        m_reliquatCP = m_reliquatCP;
        break;
      case 16: 
        m_reliquatSalaire = m_reliquatSalaire;
        break;
      case 17: 
        m_dureeInitialeCP = m_dureeInitialeCP;
        break;
      case 18: 
        m_dureeInitialeSalaire = m_dureeInitialeSalaire;
        break;
      case 19: 
        m_periodeApplicationCP = m_periodeApplicationCP;
        break;
      case 20: 
        m_periodeApplicationSalaire = m_periodeApplicationSalaire;
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
 * Qualified Name:     EtatAuDernierJourAvantPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */