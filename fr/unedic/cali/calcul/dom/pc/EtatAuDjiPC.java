package fr.unedic.cali.calcul.dom.pc;

import fr.unedic.cali.calcul.dom.EtatAuDji;
import fr.unedic.cali.dom.pc.MontantBaseAbstraitPC;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
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

public class EtatAuDjiPC
  implements DomPCSpec, PersistenceCapable
{
  private transient EtatAuDji m_etatAuDjiOM;
  protected MontantBaseAbstraitPC m_montant;
  protected boolean m_estFigee;
  private Periode m_periodePECEvenementReducteur;
  private int m_cumulJoursIndemnise;
  private int m_cumulMoisnonIndemnise;
  private int m_cumulNbJourAct;
  protected Damj m_dateEpuisementDuree;
  private BigDecimal m_montantAidePaye;
  private BigDecimal m_montantAidePayeDerog;
  private Integer m_reliquatFS;
  private Integer m_reliquatFCP;
  private Integer m_reportRlqFS;
  private Integer m_reportRlqFCP;
  private Periode m_periodeDA;
  private Integer m_reliquatMaxFS;
  private Integer m_reliquatDA;
  private Integer m_reliquatMaxFCP;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_montant", "m_estFigee", "m_periodePECEvenementReducteur", "m_cumulJoursIndemnise", "m_cumulMoisnonIndemnise", "m_cumulNbJourAct", "m_dateEpuisementDuree", "m_montantAidePaye", "m_montantAidePayeDerog", "m_reliquatFS", "m_reliquatFCP", "m_reportRlqFS", "m_reportRlqFCP", "m_periodeDA", "m_reliquatMaxFS", "m_reliquatDA", "m_reliquatMaxFCP" };
  private static Class[] jdoFieldTypes = { MontantBaseAbstraitPC.class, Boolean.TYPE, Periode.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Damj.class, BigDecimal.class, BigDecimal.class, Integer.class, Integer.class, Integer.class, Integer.class, Periode.class, Integer.class, Integer.class, Integer.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public EtatAuDjiPC()
  {
    jdoSetm_estFigee(this, false);
    
    jdoSetm_cumulJoursIndemnise(this, 0);
    jdoSetm_cumulMoisnonIndemnise(this, 0);
    jdoSetm_cumulNbJourAct(this, 0);
  }
  
  public Object createOM()
  {
    if (m_etatAuDjiOM == null) {
      m_etatAuDjiOM = new EtatAuDji(this);
    }
    return m_etatAuDjiOM;
  }
  
  public DomPCSpec getMontant()
  {
    return jdoGetm_montant(this);
  }
  
  public final void setMontant(DomPCSpec p_montant)
  {
    jdoSetm_montant(this, (MontantBaseAbstraitPC)p_montant);
  }
  
  public boolean isEstFigee()
  {
    return jdoGetm_estFigee(this);
  }
  
  public final void setEstFigee(boolean p_estFigee)
  {
    jdoSetm_estFigee(this, p_estFigee);
  }
  
  public Periode getPeriodePECEvenementReducteur()
  {
    return jdoGetm_periodePECEvenementReducteur(this);
  }
  
  public final void setPeriodePECEvenementReducteur(Periode p_periodePECEvenementReducteur)
  {
    jdoSetm_periodePECEvenementReducteur(this, p_periodePECEvenementReducteur);
  }
  
  public int getCumulJoursIndemnise()
  {
    return jdoGetm_cumulJoursIndemnise(this);
  }
  
  public final void setCumulJoursIndemnise(int p_cumulJoursIndemnise)
  {
    jdoSetm_cumulJoursIndemnise(this, p_cumulJoursIndemnise);
  }
  
  public int getCumulMoisnonIndemnise()
  {
    return jdoGetm_cumulMoisnonIndemnise(this);
  }
  
  public final void setCumulMoisnonIndemnise(int p_cumulMoisnonIndemnise)
  {
    jdoSetm_cumulMoisnonIndemnise(this, p_cumulMoisnonIndemnise);
  }
  
  public int getCumulNbJourAct()
  {
    return jdoGetm_cumulNbJourAct(this);
  }
  
  public final void setCumulNbJourAct(int p_cumulNbJourAct)
  {
    jdoSetm_cumulNbJourAct(this, p_cumulNbJourAct);
  }
  
  public Damj getDateEpuisementDuree()
  {
    return jdoGetm_dateEpuisementDuree(this);
  }
  
  public final void setDateEpuisementDuree(Damj p_dateEpuisementDuree)
  {
    jdoSetm_dateEpuisementDuree(this, p_dateEpuisementDuree);
  }
  
  public BigDecimal getMontantAidePaye()
  {
    return jdoGetm_montantAidePaye(this);
  }
  
  public final void setMontantAidePaye(BigDecimal p_montantAidePaye)
  {
    jdoSetm_montantAidePaye(this, p_montantAidePaye);
  }
  
  public BigDecimal getMontantAidePayeDerog()
  {
    return jdoGetm_montantAidePayeDerog(this);
  }
  
  public final void setMontantAidePayeDerog(BigDecimal p_montantAidePayeDerog)
  {
    jdoSetm_montantAidePayeDerog(this, p_montantAidePayeDerog);
  }
  
  public Integer getReliquatFS()
  {
    return jdoGetm_reliquatFS(this);
  }
  
  public final void setReliquatFS(Integer p_reliquatFS)
  {
    jdoSetm_reliquatFS(this, p_reliquatFS);
  }
  
  public Integer getReliquatFCP()
  {
    return jdoGetm_reliquatFCP(this);
  }
  
  public final void setReliquatFCP(Integer p_reliquatFCP)
  {
    jdoSetm_reliquatFCP(this, p_reliquatFCP);
  }
  
  public Integer getReportRlqFS()
  {
    return jdoGetm_reportRlqFS(this);
  }
  
  public final void setReportRlqFS(Integer p_reportRlqFS)
  {
    jdoSetm_reportRlqFS(this, p_reportRlqFS);
  }
  
  public Integer getReportRlqFCP()
  {
    return jdoGetm_reportRlqFCP(this);
  }
  
  public final void setReportRlqFCP(Integer p_reportRlqFCP)
  {
    jdoSetm_reportRlqFCP(this, p_reportRlqFCP);
  }
  
  public Periode getPeriodeDA()
  {
    return jdoGetm_periodeDA(this);
  }
  
  public final void setPeriodeDA(Periode p_periodeDA)
  {
    jdoSetm_periodeDA(this, p_periodeDA);
  }
  
  public Integer getReliquatMaxFS()
  {
    return jdoGetm_reliquatMaxFS(this);
  }
  
  public final void setReliquatMaxFS(Integer p_reliquatMaxFS)
  {
    jdoSetm_reliquatMaxFS(this, p_reliquatMaxFS);
  }
  
  public Integer getReliquatDA()
  {
    return jdoGetm_reliquatDA(this);
  }
  
  public final void setReliquatDA(Integer p_reliquatDA)
  {
    jdoSetm_reliquatDA(this, p_reliquatDA);
  }
  
  public Integer getReliquatMaxFCP()
  {
    return jdoGetm_reliquatMaxFCP(this);
  }
  
  public final void setReliquatMaxFCP(Integer p_reliquatMaxFCP)
  {
    jdoSetm_reliquatMaxFCP(this, p_reliquatMaxFCP);
  }
  
  static
  {
    JDOImplHelper.registerClass(EtatAuDjiPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new EtatAuDjiPC());
  }
  
  protected static final MontantBaseAbstraitPC jdoGetm_montant(EtatAuDjiPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_montant;
      }
      return (MontantBaseAbstraitPC)sm.getObjectField(pc, jdoInheritedFieldCount + 0, m_montant);
    }
    return m_montant;
  }
  
  protected static final boolean jdoGetm_estFigee(EtatAuDjiPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estFigee;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_estFigee;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 1, m_estFigee);
    }
    return m_estFigee;
  }
  
  private static final Periode jdoGetm_periodePECEvenementReducteur(EtatAuDjiPC pc)
  {
    if (jdoFlags <= 0) {
      return m_periodePECEvenementReducteur;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_periodePECEvenementReducteur;
      }
      return (Periode)sm.getObjectField(pc, jdoInheritedFieldCount + 2, m_periodePECEvenementReducteur);
    }
    return m_periodePECEvenementReducteur;
  }
  
  private static final int jdoGetm_cumulJoursIndemnise(EtatAuDjiPC pc)
  {
    if (jdoFlags <= 0) {
      return m_cumulJoursIndemnise;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_cumulJoursIndemnise;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 3, m_cumulJoursIndemnise);
    }
    return m_cumulJoursIndemnise;
  }
  
  private static final int jdoGetm_cumulMoisnonIndemnise(EtatAuDjiPC pc)
  {
    if (jdoFlags <= 0) {
      return m_cumulMoisnonIndemnise;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_cumulMoisnonIndemnise;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 4, m_cumulMoisnonIndemnise);
    }
    return m_cumulMoisnonIndemnise;
  }
  
  private static final int jdoGetm_cumulNbJourAct(EtatAuDjiPC pc)
  {
    if (jdoFlags <= 0) {
      return m_cumulNbJourAct;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_cumulNbJourAct;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 5, m_cumulNbJourAct);
    }
    return m_cumulNbJourAct;
  }
  
  protected static final Damj jdoGetm_dateEpuisementDuree(EtatAuDjiPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateEpuisementDuree;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_dateEpuisementDuree;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 6, m_dateEpuisementDuree);
    }
    return m_dateEpuisementDuree;
  }
  
  private static final BigDecimal jdoGetm_montantAidePaye(EtatAuDjiPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantAidePaye;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_montantAidePaye;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 7, m_montantAidePaye);
    }
    return m_montantAidePaye;
  }
  
  private static final BigDecimal jdoGetm_montantAidePayeDerog(EtatAuDjiPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantAidePayeDerog;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_montantAidePayeDerog;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 8, m_montantAidePayeDerog);
    }
    return m_montantAidePayeDerog;
  }
  
  private static final Integer jdoGetm_reliquatFS(EtatAuDjiPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reliquatFS;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 9)) {
        return m_reliquatFS;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 9, m_reliquatFS);
    }
    return m_reliquatFS;
  }
  
  private static final Integer jdoGetm_reliquatFCP(EtatAuDjiPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reliquatFCP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 10)) {
        return m_reliquatFCP;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 10, m_reliquatFCP);
    }
    return m_reliquatFCP;
  }
  
  private static final Integer jdoGetm_reportRlqFS(EtatAuDjiPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reportRlqFS;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 11)) {
        return m_reportRlqFS;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 11, m_reportRlqFS);
    }
    return m_reportRlqFS;
  }
  
  private static final Integer jdoGetm_reportRlqFCP(EtatAuDjiPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reportRlqFCP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 12)) {
        return m_reportRlqFCP;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 12, m_reportRlqFCP);
    }
    return m_reportRlqFCP;
  }
  
  private static final Periode jdoGetm_periodeDA(EtatAuDjiPC pc)
  {
    if (jdoFlags <= 0) {
      return m_periodeDA;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 13)) {
        return m_periodeDA;
      }
      return (Periode)sm.getObjectField(pc, jdoInheritedFieldCount + 13, m_periodeDA);
    }
    return m_periodeDA;
  }
  
  private static final Integer jdoGetm_reliquatMaxFS(EtatAuDjiPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reliquatMaxFS;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 14)) {
        return m_reliquatMaxFS;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 14, m_reliquatMaxFS);
    }
    return m_reliquatMaxFS;
  }
  
  private static final Integer jdoGetm_reliquatDA(EtatAuDjiPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reliquatDA;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 15)) {
        return m_reliquatDA;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 15, m_reliquatDA);
    }
    return m_reliquatDA;
  }
  
  private static final Integer jdoGetm_reliquatMaxFCP(EtatAuDjiPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reliquatMaxFCP;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 16)) {
        return m_reliquatMaxFCP;
      }
      return (Integer)sm.getObjectField(pc, jdoInheritedFieldCount + 16, m_reliquatMaxFCP);
    }
    return m_reliquatMaxFCP;
  }
  
  protected static final void jdoSetm_montant(EtatAuDjiPC pc, MontantBaseAbstraitPC newValue)
  {
    if (jdoFlags == 0)
    {
      m_montant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 0, m_montant, newValue);
    } else {
      m_montant = newValue;
    }
  }
  
  protected static final void jdoSetm_estFigee(EtatAuDjiPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_estFigee = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 1, m_estFigee, newValue);
    } else {
      m_estFigee = newValue;
    }
  }
  
  private static final void jdoSetm_periodePECEvenementReducteur(EtatAuDjiPC pc, Periode newValue)
  {
    if (jdoFlags == 0)
    {
      m_periodePECEvenementReducteur = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 2, m_periodePECEvenementReducteur, newValue);
    } else {
      m_periodePECEvenementReducteur = newValue;
    }
  }
  
  private static final void jdoSetm_cumulJoursIndemnise(EtatAuDjiPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_cumulJoursIndemnise = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 3, m_cumulJoursIndemnise, newValue);
    } else {
      m_cumulJoursIndemnise = newValue;
    }
  }
  
  private static final void jdoSetm_cumulMoisnonIndemnise(EtatAuDjiPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_cumulMoisnonIndemnise = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 4, m_cumulMoisnonIndemnise, newValue);
    } else {
      m_cumulMoisnonIndemnise = newValue;
    }
  }
  
  private static final void jdoSetm_cumulNbJourAct(EtatAuDjiPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_cumulNbJourAct = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 5, m_cumulNbJourAct, newValue);
    } else {
      m_cumulNbJourAct = newValue;
    }
  }
  
  protected static final void jdoSetm_dateEpuisementDuree(EtatAuDjiPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateEpuisementDuree = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 6, m_dateEpuisementDuree, newValue);
    } else {
      m_dateEpuisementDuree = newValue;
    }
  }
  
  private static final void jdoSetm_montantAidePaye(EtatAuDjiPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantAidePaye = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 7, m_montantAidePaye, newValue);
    } else {
      m_montantAidePaye = newValue;
    }
  }
  
  private static final void jdoSetm_montantAidePayeDerog(EtatAuDjiPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantAidePayeDerog = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 8, m_montantAidePayeDerog, newValue);
    } else {
      m_montantAidePayeDerog = newValue;
    }
  }
  
  private static final void jdoSetm_reliquatFS(EtatAuDjiPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_reliquatFS = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 9, m_reliquatFS, newValue);
    } else {
      m_reliquatFS = newValue;
    }
  }
  
  private static final void jdoSetm_reliquatFCP(EtatAuDjiPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_reliquatFCP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 10, m_reliquatFCP, newValue);
    } else {
      m_reliquatFCP = newValue;
    }
  }
  
  private static final void jdoSetm_reportRlqFS(EtatAuDjiPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_reportRlqFS = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 11, m_reportRlqFS, newValue);
    } else {
      m_reportRlqFS = newValue;
    }
  }
  
  private static final void jdoSetm_reportRlqFCP(EtatAuDjiPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_reportRlqFCP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 12, m_reportRlqFCP, newValue);
    } else {
      m_reportRlqFCP = newValue;
    }
  }
  
  private static final void jdoSetm_periodeDA(EtatAuDjiPC pc, Periode newValue)
  {
    if (jdoFlags == 0)
    {
      m_periodeDA = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 13, m_periodeDA, newValue);
    } else {
      m_periodeDA = newValue;
    }
  }
  
  private static final void jdoSetm_reliquatMaxFS(EtatAuDjiPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_reliquatMaxFS = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 14, m_reliquatMaxFS, newValue);
    } else {
      m_reliquatMaxFS = newValue;
    }
  }
  
  private static final void jdoSetm_reliquatDA(EtatAuDjiPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_reliquatDA = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 15, m_reliquatDA, newValue);
    } else {
      m_reliquatDA = newValue;
    }
  }
  
  private static final void jdoSetm_reliquatMaxFCP(EtatAuDjiPC pc, Integer newValue)
  {
    if (jdoFlags == 0)
    {
      m_reliquatMaxFCP = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 16, m_reliquatMaxFCP, newValue);
    } else {
      m_reliquatMaxFCP = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montant);
      break;
    case 1: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_estFigee);
      break;
    case 2: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_periodePECEvenementReducteur);
      break;
    case 3: 
      jdoStateManager.providedIntField(this, fieldNumber, m_cumulJoursIndemnise);
      break;
    case 4: 
      jdoStateManager.providedIntField(this, fieldNumber, m_cumulMoisnonIndemnise);
      break;
    case 5: 
      jdoStateManager.providedIntField(this, fieldNumber, m_cumulNbJourAct);
      break;
    case 6: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateEpuisementDuree);
      break;
    case 7: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantAidePaye);
      break;
    case 8: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantAidePayeDerog);
      break;
    case 9: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_reliquatFS);
      break;
    case 10: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_reliquatFCP);
      break;
    case 11: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_reportRlqFS);
      break;
    case 12: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_reportRlqFCP);
      break;
    case 13: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_periodeDA);
      break;
    case 14: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_reliquatMaxFS);
      break;
    case 15: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_reliquatDA);
      break;
    case 16: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_reliquatMaxFCP);
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
      m_montant = ((MontantBaseAbstraitPC)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 1: 
      m_estFigee = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 2: 
      m_periodePECEvenementReducteur = ((Periode)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 3: 
      m_cumulJoursIndemnise = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 4: 
      m_cumulMoisnonIndemnise = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 5: 
      m_cumulNbJourAct = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 6: 
      m_dateEpuisementDuree = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 7: 
      m_montantAidePaye = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 8: 
      m_montantAidePayeDerog = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 9: 
      m_reliquatFS = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 10: 
      m_reliquatFCP = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 11: 
      m_reportRlqFS = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 12: 
      m_reportRlqFCP = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 13: 
      m_periodeDA = ((Periode)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 14: 
      m_reliquatMaxFS = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 15: 
      m_reliquatDA = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 16: 
      m_reliquatMaxFCP = ((Integer)jdoStateManager.replacingObjectField(this, fieldNumber));
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
    EtatAuDjiPC pc = new EtatAuDjiPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    EtatAuDjiPC pc = new EtatAuDjiPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 17;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof EtatAuDjiPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    EtatAuDjiPC other = (EtatAuDjiPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_montant = m_montant;
        break;
      case 1: 
        m_estFigee = m_estFigee;
        break;
      case 2: 
        m_periodePECEvenementReducteur = m_periodePECEvenementReducteur;
        break;
      case 3: 
        m_cumulJoursIndemnise = m_cumulJoursIndemnise;
        break;
      case 4: 
        m_cumulMoisnonIndemnise = m_cumulMoisnonIndemnise;
        break;
      case 5: 
        m_cumulNbJourAct = m_cumulNbJourAct;
        break;
      case 6: 
        m_dateEpuisementDuree = m_dateEpuisementDuree;
        break;
      case 7: 
        m_montantAidePaye = m_montantAidePaye;
        break;
      case 8: 
        m_montantAidePayeDerog = m_montantAidePayeDerog;
        break;
      case 9: 
        m_reliquatFS = m_reliquatFS;
        break;
      case 10: 
        m_reliquatFCP = m_reliquatFCP;
        break;
      case 11: 
        m_reportRlqFS = m_reportRlqFS;
        break;
      case 12: 
        m_reportRlqFCP = m_reportRlqFCP;
        break;
      case 13: 
        m_periodeDA = m_periodeDA;
        break;
      case 14: 
        m_reliquatMaxFS = m_reliquatMaxFS;
        break;
      case 15: 
        m_reliquatDA = m_reliquatDA;
        break;
      case 16: 
        m_reliquatMaxFCP = m_reliquatMaxFCP;
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
 * Qualified Name:     EtatAuDjiPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */