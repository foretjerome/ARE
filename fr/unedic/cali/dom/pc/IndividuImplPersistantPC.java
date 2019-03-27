package fr.unedic.cali.dom.pc;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.cali.dom.IndividuImplPersistant;
import fr.unedic.transverse.dom.spec.DomPCSpec;
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

public class IndividuImplPersistantPC
  implements DomPCSpec, PersistenceCapable
{
  private transient IndividuImplPersistant m_individuImplPersistantOM;
  protected int m_estMigree;
  protected Damj m_dateBlocageIndemnisationConflitGAEC;
  protected int m_codeTransfert;
  protected boolean m_investigationFraude;
  protected Damj m_dateExecutionDifferee;
  protected boolean m_forcageAppelGaecTotal;
  protected String m_domaineSrcFlux;
  protected String m_codeTransaction;
  protected int m_attributionsAfdFiliereCourte;
  protected int m_attributionsAfdFiliereIntermediaire;
  protected int m_attributionsAfdFiliereLongue;
  public String m_origineSaisieDernierJourIndemnisableAreSpe;
  public Damj m_dernierJourIndemnisableAreSpe;
  private boolean m_estAbonneGaec;
  private boolean m_estArretReexecution;
  private boolean m_estNonExecutionReceptionFlux;
  private boolean m_estDesactEFE;
  private Damj m_dateLimiteReexecution;
  protected Collection m_collectionPeriodesActiviteSalariee;
  protected Collection m_collectionDemandes;
  protected Collection m_collectionStatistiqueExamenAuFilEau;
  protected Collection m_preInscription;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_estMigree", "m_dateBlocageIndemnisationConflitGAEC", "m_codeTransfert", "m_investigationFraude", "m_dateExecutionDifferee", "m_forcageAppelGaecTotal", "m_domaineSrcFlux", "m_codeTransaction", "m_attributionsAfdFiliereCourte", "m_attributionsAfdFiliereIntermediaire", "m_attributionsAfdFiliereLongue", "m_origineSaisieDernierJourIndemnisableAreSpe", "m_dernierJourIndemnisableAreSpe", "m_estAbonneGaec", "m_estArretReexecution", "m_estNonExecutionReceptionFlux", "m_estDesactEFE", "m_dateLimiteReexecution", "m_collectionPeriodesActiviteSalariee", "m_collectionDemandes", "m_collectionStatistiqueExamenAuFilEau", "m_preInscription" };
  private static Class[] jdoFieldTypes = { Integer.TYPE, Damj.class, Integer.TYPE, Boolean.TYPE, Damj.class, Boolean.TYPE, String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class, Damj.class, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Damj.class, Collection.class, Collection.class, Collection.class, Collection.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.MEDIATE_READ + PersistenceCapable.MEDIATE_WRITE), (byte)(PersistenceCapable.MEDIATE_READ + PersistenceCapable.MEDIATE_WRITE), (byte)(PersistenceCapable.MEDIATE_READ + PersistenceCapable.MEDIATE_WRITE), (byte)(PersistenceCapable.MEDIATE_READ + PersistenceCapable.MEDIATE_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_individuImplPersistantOM == null) {
      m_individuImplPersistantOM = new IndividuImplPersistant(this);
    }
    return m_individuImplPersistantOM;
  }
  
  public int getEstMigree()
  {
    return jdoGetm_estMigree(this);
  }
  
  public final void setEstMigree(int p_estMigree)
  {
    jdoSetm_estMigree(this, p_estMigree);
  }
  
  public Damj getDateBlocageIndemnisationConflitGAEC()
  {
    return jdoGetm_dateBlocageIndemnisationConflitGAEC(this);
  }
  
  public final void setDateBlocageIndemnisationConflitGAEC(Damj p_dateBlocageIndemnisationConflitGAEC)
  {
    jdoSetm_dateBlocageIndemnisationConflitGAEC(this, p_dateBlocageIndemnisationConflitGAEC);
  }
  
  public int getCodeTransfert()
  {
    return jdoGetm_codeTransfert(this);
  }
  
  public final void setCodeTransfert(int p_codeTransfert)
  {
    jdoSetm_codeTransfert(this, p_codeTransfert);
  }
  
  public boolean isInvestigationFraude()
  {
    return jdoGetm_investigationFraude(this);
  }
  
  public final void setInvestigationFraude(boolean p_investigationFraude)
  {
    jdoSetm_investigationFraude(this, p_investigationFraude);
  }
  
  public Damj getDateExecutionDifferee()
  {
    return jdoGetm_dateExecutionDifferee(this);
  }
  
  public final void setDateExecutionDifferee(Damj p_dateExecutionDifferee)
  {
    jdoSetm_dateExecutionDifferee(this, p_dateExecutionDifferee);
  }
  
  public boolean isForcageAppelGaecTotal()
  {
    return jdoGetm_forcageAppelGaecTotal(this);
  }
  
  public final void setForcageAppelGaecTotal(boolean p_forcageAppelGaecTotal)
  {
    jdoSetm_forcageAppelGaecTotal(this, p_forcageAppelGaecTotal);
  }
  
  public String getDomaineSrcFlux()
  {
    return jdoGetm_domaineSrcFlux(this);
  }
  
  public final void setDomaineSrcFlux(String p_domaineSrcFlux)
  {
    jdoSetm_domaineSrcFlux(this, p_domaineSrcFlux);
  }
  
  public String getCodeTransaction()
  {
    return jdoGetm_codeTransaction(this);
  }
  
  public final void setCodeTransaction(String p_codeTransaction)
  {
    jdoSetm_codeTransaction(this, p_codeTransaction);
  }
  
  public int getAttributionsAfdFiliereCourte()
  {
    return jdoGetm_attributionsAfdFiliereCourte(this);
  }
  
  public final void setAttributionsAfdFiliereCourte(int p_attributionsAfdFiliereCourte)
  {
    jdoSetm_attributionsAfdFiliereCourte(this, p_attributionsAfdFiliereCourte);
  }
  
  public int getAttributionsAfdFiliereIntermediaire()
  {
    return jdoGetm_attributionsAfdFiliereIntermediaire(this);
  }
  
  public final void setAttributionsAfdFiliereIntermediaire(int p_attributionsAfdFiliereIntermediaire)
  {
    jdoSetm_attributionsAfdFiliereIntermediaire(this, p_attributionsAfdFiliereIntermediaire);
  }
  
  public int getAttributionsAfdFiliereLongue()
  {
    return jdoGetm_attributionsAfdFiliereLongue(this);
  }
  
  public final void setAttributionsAfdFiliereLongue(int p_attributionsAfdFiliereLongue)
  {
    jdoSetm_attributionsAfdFiliereLongue(this, p_attributionsAfdFiliereLongue);
  }
  
  public String getOrigineSaisieDernierJourIndemnisableAreSpe()
  {
    return jdoGetm_origineSaisieDernierJourIndemnisableAreSpe(this);
  }
  
  public final void setOrigineSaisieDernierJourIndemnisableAreSpe(String p_origineSaisieDernierJourIndemnisableAreSpe)
  {
    jdoSetm_origineSaisieDernierJourIndemnisableAreSpe(this, p_origineSaisieDernierJourIndemnisableAreSpe);
  }
  
  public Damj getDernierJourIndemnisableAreSpe()
  {
    return jdoGetm_dernierJourIndemnisableAreSpe(this);
  }
  
  public final void setDernierJourIndemnisableAreSpe(Damj p_dernierJourIndemnisableAreSpe)
  {
    jdoSetm_dernierJourIndemnisableAreSpe(this, p_dernierJourIndemnisableAreSpe);
  }
  
  public boolean isEstAbonneGaec()
  {
    return jdoGetm_estAbonneGaec(this);
  }
  
  public final void setEstAbonneGaec(boolean p_estAbonneGaec)
  {
    jdoSetm_estAbonneGaec(this, p_estAbonneGaec);
  }
  
  public boolean isEstArretReexecution()
  {
    return jdoGetm_estArretReexecution(this);
  }
  
  public final void setEstArretReexecution(boolean p_estArretReexecution)
  {
    jdoSetm_estArretReexecution(this, p_estArretReexecution);
  }
  
  public boolean isEstNonExecutionReceptionFlux()
  {
    return jdoGetm_estNonExecutionReceptionFlux(this);
  }
  
  public final void setEstNonExecutionReceptionFlux(boolean p_estNonExecutionReceptionFlux)
  {
    jdoSetm_estNonExecutionReceptionFlux(this, p_estNonExecutionReceptionFlux);
  }
  
  public boolean isEstDesactEFE()
  {
    return jdoGetm_estDesactEFE(this);
  }
  
  public final void setEstDesactEFE(boolean p_estDesactEFE)
  {
    jdoSetm_estDesactEFE(this, p_estDesactEFE);
  }
  
  public Damj getDateLimiteReexecution()
  {
    return jdoGetm_dateLimiteReexecution(this);
  }
  
  public final void setDateLimiteReexecution(Damj p_dateLimiteReexecution)
  {
    jdoSetm_dateLimiteReexecution(this, p_dateLimiteReexecution);
  }
  
  public final Collection getCollectionActiviteSalarie()
  {
    if (jdoGetm_collectionPeriodesActiviteSalariee(this) == null) {
      jdoSetm_collectionPeriodesActiviteSalariee(this, new ArrayList());
    }
    return jdoGetm_collectionPeriodesActiviteSalariee(this);
  }
  
  public final void ajouterActiviteSalarie(DomPCSpec p_periodesActiviteSalariee)
    throws NullPointerException
  {
    if (p_periodesActiviteSalariee == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periodesActiviteSalariee ne devrait pas être nul.", p_periodesActiviteSalariee);
    }
    getCollectionActiviteSalarie().add(p_periodesActiviteSalariee);
  }
  
  public final void supprimerActiviteSalarie(DomPCSpec p_periodesActiviteSalariee)
    throws NullPointerException
  {
    if (p_periodesActiviteSalariee == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periodesActiviteSalariee ne devrait pas être nul.", p_periodesActiviteSalariee);
    }
    getCollectionActiviteSalarie().remove(p_periodesActiviteSalariee);
  }
  
  public final Collection getCollectionDemande()
  {
    if (jdoGetm_collectionDemandes(this) == null) {
      jdoSetm_collectionDemandes(this, new ArrayList());
    }
    return jdoGetm_collectionDemandes(this);
  }
  
  public final void ajouterDemande(DomPCSpec p_demandes)
    throws NullPointerException
  {
    if (p_demandes == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_demandes ne devrait pas être nul.", p_demandes);
    }
    getCollectionDemande().add(p_demandes);
  }
  
  public final void supprimerDemande(DomPCSpec p_demandes)
    throws NullPointerException
  {
    if (p_demandes == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_demandes ne devrait pas être nul.", p_demandes);
    }
    getCollectionDemande().remove(p_demandes);
  }
  
  public final Collection getCollectionStatistiqueExamenAuFilEau()
  {
    if (jdoGetm_collectionStatistiqueExamenAuFilEau(this) == null) {
      jdoSetm_collectionStatistiqueExamenAuFilEau(this, new ArrayList());
    }
    return jdoGetm_collectionStatistiqueExamenAuFilEau(this);
  }
  
  public final void ajouterStatistiqueExamenAuFilEau(DomPCSpec p_statistiqueExamenAuFilEau)
    throws NullPointerException
  {
    if (p_statistiqueExamenAuFilEau == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_statistiqueExamenAuFilEau ne devrait pas être nul.", p_statistiqueExamenAuFilEau);
    }
    getCollectionStatistiqueExamenAuFilEau().add(p_statistiqueExamenAuFilEau);
  }
  
  public final void supprimerStatistiqueExamenAuFilEau(DomPCSpec p_statistiqueExamenAuFilEau)
    throws NullPointerException
  {
    if (p_statistiqueExamenAuFilEau == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_statistiqueExamenAuFilEau ne devrait pas être nul.", p_statistiqueExamenAuFilEau);
    }
    getCollectionStatistiqueExamenAuFilEau().remove(p_statistiqueExamenAuFilEau);
  }
  
  public final Collection getCollectionPreInscription()
  {
    if (jdoGetm_preInscription(this) == null) {
      jdoSetm_preInscription(this, new ArrayList());
    }
    return jdoGetm_preInscription(this);
  }
  
  public final void ajouterPreInscription(DomPCSpec p_preInscription)
    throws NullPointerException
  {
    if (p_preInscription == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_preInscription ne devrait pas être nul.", p_preInscription);
    }
    getCollectionPreInscription().add(p_preInscription);
  }
  
  public final void supprimerPreInscription(DomPCSpec p_preInscription)
    throws NullPointerException
  {
    if (p_preInscription == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_preInscription ne devrait pas être nul.", p_preInscription);
    }
    getCollectionPreInscription().remove(p_preInscription);
  }
  
  static
  {
    JDOImplHelper.registerClass(IndividuImplPersistantPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new IndividuImplPersistantPC());
  }
  
  protected static final int jdoGetm_estMigree(IndividuImplPersistantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estMigree;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_estMigree;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 0, m_estMigree);
    }
    return m_estMigree;
  }
  
  protected static final Damj jdoGetm_dateBlocageIndemnisationConflitGAEC(IndividuImplPersistantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateBlocageIndemnisationConflitGAEC;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_dateBlocageIndemnisationConflitGAEC;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_dateBlocageIndemnisationConflitGAEC);
    }
    return m_dateBlocageIndemnisationConflitGAEC;
  }
  
  protected static final int jdoGetm_codeTransfert(IndividuImplPersistantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeTransfert;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_codeTransfert;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 2, m_codeTransfert);
    }
    return m_codeTransfert;
  }
  
  protected static final boolean jdoGetm_investigationFraude(IndividuImplPersistantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_investigationFraude;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_investigationFraude;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 3, m_investigationFraude);
    }
    return m_investigationFraude;
  }
  
  protected static final Damj jdoGetm_dateExecutionDifferee(IndividuImplPersistantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateExecutionDifferee;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_dateExecutionDifferee;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 4, m_dateExecutionDifferee);
    }
    return m_dateExecutionDifferee;
  }
  
  protected static final boolean jdoGetm_forcageAppelGaecTotal(IndividuImplPersistantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_forcageAppelGaecTotal;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_forcageAppelGaecTotal;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 5, m_forcageAppelGaecTotal);
    }
    return m_forcageAppelGaecTotal;
  }
  
  protected static final String jdoGetm_domaineSrcFlux(IndividuImplPersistantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_domaineSrcFlux;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_domaineSrcFlux;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 6, m_domaineSrcFlux);
    }
    return m_domaineSrcFlux;
  }
  
  protected static final String jdoGetm_codeTransaction(IndividuImplPersistantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeTransaction;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_codeTransaction;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 7, m_codeTransaction);
    }
    return m_codeTransaction;
  }
  
  protected static final int jdoGetm_attributionsAfdFiliereCourte(IndividuImplPersistantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_attributionsAfdFiliereCourte;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_attributionsAfdFiliereCourte;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 8, m_attributionsAfdFiliereCourte);
    }
    return m_attributionsAfdFiliereCourte;
  }
  
  protected static final int jdoGetm_attributionsAfdFiliereIntermediaire(IndividuImplPersistantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_attributionsAfdFiliereIntermediaire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 9)) {
        return m_attributionsAfdFiliereIntermediaire;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 9, m_attributionsAfdFiliereIntermediaire);
    }
    return m_attributionsAfdFiliereIntermediaire;
  }
  
  protected static final int jdoGetm_attributionsAfdFiliereLongue(IndividuImplPersistantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_attributionsAfdFiliereLongue;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 10)) {
        return m_attributionsAfdFiliereLongue;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 10, m_attributionsAfdFiliereLongue);
    }
    return m_attributionsAfdFiliereLongue;
  }
  
  public static final String jdoGetm_origineSaisieDernierJourIndemnisableAreSpe(IndividuImplPersistantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_origineSaisieDernierJourIndemnisableAreSpe;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 11)) {
        return m_origineSaisieDernierJourIndemnisableAreSpe;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 11, m_origineSaisieDernierJourIndemnisableAreSpe);
    }
    return m_origineSaisieDernierJourIndemnisableAreSpe;
  }
  
  public static final Damj jdoGetm_dernierJourIndemnisableAreSpe(IndividuImplPersistantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dernierJourIndemnisableAreSpe;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 12)) {
        return m_dernierJourIndemnisableAreSpe;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 12, m_dernierJourIndemnisableAreSpe);
    }
    return m_dernierJourIndemnisableAreSpe;
  }
  
  private static final boolean jdoGetm_estAbonneGaec(IndividuImplPersistantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estAbonneGaec;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 13)) {
        return m_estAbonneGaec;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 13, m_estAbonneGaec);
    }
    return m_estAbonneGaec;
  }
  
  private static final boolean jdoGetm_estArretReexecution(IndividuImplPersistantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estArretReexecution;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 14)) {
        return m_estArretReexecution;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 14, m_estArretReexecution);
    }
    return m_estArretReexecution;
  }
  
  private static final boolean jdoGetm_estNonExecutionReceptionFlux(IndividuImplPersistantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estNonExecutionReceptionFlux;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 15)) {
        return m_estNonExecutionReceptionFlux;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 15, m_estNonExecutionReceptionFlux);
    }
    return m_estNonExecutionReceptionFlux;
  }
  
  private static final boolean jdoGetm_estDesactEFE(IndividuImplPersistantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_estDesactEFE;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 16)) {
        return m_estDesactEFE;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 16, m_estDesactEFE);
    }
    return m_estDesactEFE;
  }
  
  private static final Damj jdoGetm_dateLimiteReexecution(IndividuImplPersistantPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateLimiteReexecution;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 17)) {
        return m_dateLimiteReexecution;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 17, m_dateLimiteReexecution);
    }
    return m_dateLimiteReexecution;
  }
  
  protected static final Collection jdoGetm_collectionPeriodesActiviteSalariee(IndividuImplPersistantPC pc)
  {
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 18)) {
        return m_collectionPeriodesActiviteSalariee;
      }
      return (Collection)sm.getObjectField(pc, jdoInheritedFieldCount + 18, m_collectionPeriodesActiviteSalariee);
    }
    return m_collectionPeriodesActiviteSalariee;
  }
  
  protected static final Collection jdoGetm_collectionDemandes(IndividuImplPersistantPC pc)
  {
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 19)) {
        return m_collectionDemandes;
      }
      return (Collection)sm.getObjectField(pc, jdoInheritedFieldCount + 19, m_collectionDemandes);
    }
    return m_collectionDemandes;
  }
  
  protected static final Collection jdoGetm_collectionStatistiqueExamenAuFilEau(IndividuImplPersistantPC pc)
  {
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 20)) {
        return m_collectionStatistiqueExamenAuFilEau;
      }
      return (Collection)sm.getObjectField(pc, jdoInheritedFieldCount + 20, m_collectionStatistiqueExamenAuFilEau);
    }
    return m_collectionStatistiqueExamenAuFilEau;
  }
  
  protected static final Collection jdoGetm_preInscription(IndividuImplPersistantPC pc)
  {
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 21)) {
        return m_preInscription;
      }
      return (Collection)sm.getObjectField(pc, jdoInheritedFieldCount + 21, m_preInscription);
    }
    return m_preInscription;
  }
  
  protected static final void jdoSetm_estMigree(IndividuImplPersistantPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_estMigree = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 0, m_estMigree, newValue);
    } else {
      m_estMigree = newValue;
    }
  }
  
  protected static final void jdoSetm_dateBlocageIndemnisationConflitGAEC(IndividuImplPersistantPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateBlocageIndemnisationConflitGAEC = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_dateBlocageIndemnisationConflitGAEC, newValue);
    } else {
      m_dateBlocageIndemnisationConflitGAEC = newValue;
    }
  }
  
  protected static final void jdoSetm_codeTransfert(IndividuImplPersistantPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeTransfert = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 2, m_codeTransfert, newValue);
    } else {
      m_codeTransfert = newValue;
    }
  }
  
  protected static final void jdoSetm_investigationFraude(IndividuImplPersistantPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_investigationFraude = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 3, m_investigationFraude, newValue);
    } else {
      m_investigationFraude = newValue;
    }
  }
  
  protected static final void jdoSetm_dateExecutionDifferee(IndividuImplPersistantPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateExecutionDifferee = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 4, m_dateExecutionDifferee, newValue);
    } else {
      m_dateExecutionDifferee = newValue;
    }
  }
  
  protected static final void jdoSetm_forcageAppelGaecTotal(IndividuImplPersistantPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_forcageAppelGaecTotal = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 5, m_forcageAppelGaecTotal, newValue);
    } else {
      m_forcageAppelGaecTotal = newValue;
    }
  }
  
  protected static final void jdoSetm_domaineSrcFlux(IndividuImplPersistantPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_domaineSrcFlux = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 6, m_domaineSrcFlux, newValue);
    } else {
      m_domaineSrcFlux = newValue;
    }
  }
  
  protected static final void jdoSetm_codeTransaction(IndividuImplPersistantPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeTransaction = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 7, m_codeTransaction, newValue);
    } else {
      m_codeTransaction = newValue;
    }
  }
  
  protected static final void jdoSetm_attributionsAfdFiliereCourte(IndividuImplPersistantPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_attributionsAfdFiliereCourte = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 8, m_attributionsAfdFiliereCourte, newValue);
    } else {
      m_attributionsAfdFiliereCourte = newValue;
    }
  }
  
  protected static final void jdoSetm_attributionsAfdFiliereIntermediaire(IndividuImplPersistantPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_attributionsAfdFiliereIntermediaire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 9, m_attributionsAfdFiliereIntermediaire, newValue);
    } else {
      m_attributionsAfdFiliereIntermediaire = newValue;
    }
  }
  
  protected static final void jdoSetm_attributionsAfdFiliereLongue(IndividuImplPersistantPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_attributionsAfdFiliereLongue = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 10, m_attributionsAfdFiliereLongue, newValue);
    } else {
      m_attributionsAfdFiliereLongue = newValue;
    }
  }
  
  public static final void jdoSetm_origineSaisieDernierJourIndemnisableAreSpe(IndividuImplPersistantPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_origineSaisieDernierJourIndemnisableAreSpe = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 11, m_origineSaisieDernierJourIndemnisableAreSpe, newValue);
    } else {
      m_origineSaisieDernierJourIndemnisableAreSpe = newValue;
    }
  }
  
  public static final void jdoSetm_dernierJourIndemnisableAreSpe(IndividuImplPersistantPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dernierJourIndemnisableAreSpe = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 12, m_dernierJourIndemnisableAreSpe, newValue);
    } else {
      m_dernierJourIndemnisableAreSpe = newValue;
    }
  }
  
  private static final void jdoSetm_estAbonneGaec(IndividuImplPersistantPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_estAbonneGaec = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 13, m_estAbonneGaec, newValue);
    } else {
      m_estAbonneGaec = newValue;
    }
  }
  
  private static final void jdoSetm_estArretReexecution(IndividuImplPersistantPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_estArretReexecution = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 14, m_estArretReexecution, newValue);
    } else {
      m_estArretReexecution = newValue;
    }
  }
  
  private static final void jdoSetm_estNonExecutionReceptionFlux(IndividuImplPersistantPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_estNonExecutionReceptionFlux = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 15, m_estNonExecutionReceptionFlux, newValue);
    } else {
      m_estNonExecutionReceptionFlux = newValue;
    }
  }
  
  private static final void jdoSetm_estDesactEFE(IndividuImplPersistantPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_estDesactEFE = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 16, m_estDesactEFE, newValue);
    } else {
      m_estDesactEFE = newValue;
    }
  }
  
  private static final void jdoSetm_dateLimiteReexecution(IndividuImplPersistantPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateLimiteReexecution = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 17, m_dateLimiteReexecution, newValue);
    } else {
      m_dateLimiteReexecution = newValue;
    }
  }
  
  protected static final void jdoSetm_collectionPeriodesActiviteSalariee(IndividuImplPersistantPC pc, Collection newValue)
  {
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 18, m_collectionPeriodesActiviteSalariee, newValue);
    } else {
      m_collectionPeriodesActiviteSalariee = newValue;
    }
  }
  
  protected static final void jdoSetm_collectionDemandes(IndividuImplPersistantPC pc, Collection newValue)
  {
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 19, m_collectionDemandes, newValue);
    } else {
      m_collectionDemandes = newValue;
    }
  }
  
  protected static final void jdoSetm_collectionStatistiqueExamenAuFilEau(IndividuImplPersistantPC pc, Collection newValue)
  {
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 20, m_collectionStatistiqueExamenAuFilEau, newValue);
    } else {
      m_collectionStatistiqueExamenAuFilEau = newValue;
    }
  }
  
  protected static final void jdoSetm_preInscription(IndividuImplPersistantPC pc, Collection newValue)
  {
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 21, m_preInscription, newValue);
    } else {
      m_preInscription = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedIntField(this, fieldNumber, m_estMigree);
      break;
    case 1: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateBlocageIndemnisationConflitGAEC);
      break;
    case 2: 
      jdoStateManager.providedIntField(this, fieldNumber, m_codeTransfert);
      break;
    case 3: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_investigationFraude);
      break;
    case 4: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateExecutionDifferee);
      break;
    case 5: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_forcageAppelGaecTotal);
      break;
    case 6: 
      jdoStateManager.providedStringField(this, fieldNumber, m_domaineSrcFlux);
      break;
    case 7: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeTransaction);
      break;
    case 8: 
      jdoStateManager.providedIntField(this, fieldNumber, m_attributionsAfdFiliereCourte);
      break;
    case 9: 
      jdoStateManager.providedIntField(this, fieldNumber, m_attributionsAfdFiliereIntermediaire);
      break;
    case 10: 
      jdoStateManager.providedIntField(this, fieldNumber, m_attributionsAfdFiliereLongue);
      break;
    case 11: 
      jdoStateManager.providedStringField(this, fieldNumber, m_origineSaisieDernierJourIndemnisableAreSpe);
      break;
    case 12: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dernierJourIndemnisableAreSpe);
      break;
    case 13: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_estAbonneGaec);
      break;
    case 14: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_estArretReexecution);
      break;
    case 15: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_estNonExecutionReceptionFlux);
      break;
    case 16: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_estDesactEFE);
      break;
    case 17: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateLimiteReexecution);
      break;
    case 18: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_collectionPeriodesActiviteSalariee);
      break;
    case 19: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_collectionDemandes);
      break;
    case 20: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_collectionStatistiqueExamenAuFilEau);
      break;
    case 21: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_preInscription);
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
      m_estMigree = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 1: 
      m_dateBlocageIndemnisationConflitGAEC = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_codeTransfert = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 3: 
      m_investigationFraude = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 4: 
      m_dateExecutionDifferee = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 5: 
      m_forcageAppelGaecTotal = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 6: 
      m_domaineSrcFlux = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 7: 
      m_codeTransaction = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 8: 
      m_attributionsAfdFiliereCourte = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 9: 
      m_attributionsAfdFiliereIntermediaire = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 10: 
      m_attributionsAfdFiliereLongue = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 11: 
      m_origineSaisieDernierJourIndemnisableAreSpe = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 12: 
      m_dernierJourIndemnisableAreSpe = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 13: 
      m_estAbonneGaec = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 14: 
      m_estArretReexecution = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 15: 
      m_estNonExecutionReceptionFlux = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 16: 
      m_estDesactEFE = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 17: 
      m_dateLimiteReexecution = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 18: 
      m_collectionPeriodesActiviteSalariee = ((Collection)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 19: 
      m_collectionDemandes = ((Collection)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 20: 
      m_collectionStatistiqueExamenAuFilEau = ((Collection)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 21: 
      m_preInscription = ((Collection)jdoStateManager.replacingObjectField(this, fieldNumber));
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
    IndividuImplPersistantPC pc = new IndividuImplPersistantPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    IndividuImplPersistantPC pc = new IndividuImplPersistantPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 22;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof IndividuImplPersistantPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    IndividuImplPersistantPC other = (IndividuImplPersistantPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_estMigree = m_estMigree;
        break;
      case 1: 
        m_dateBlocageIndemnisationConflitGAEC = m_dateBlocageIndemnisationConflitGAEC;
        break;
      case 2: 
        m_codeTransfert = m_codeTransfert;
        break;
      case 3: 
        m_investigationFraude = m_investigationFraude;
        break;
      case 4: 
        m_dateExecutionDifferee = m_dateExecutionDifferee;
        break;
      case 5: 
        m_forcageAppelGaecTotal = m_forcageAppelGaecTotal;
        break;
      case 6: 
        m_domaineSrcFlux = m_domaineSrcFlux;
        break;
      case 7: 
        m_codeTransaction = m_codeTransaction;
        break;
      case 8: 
        m_attributionsAfdFiliereCourte = m_attributionsAfdFiliereCourte;
        break;
      case 9: 
        m_attributionsAfdFiliereIntermediaire = m_attributionsAfdFiliereIntermediaire;
        break;
      case 10: 
        m_attributionsAfdFiliereLongue = m_attributionsAfdFiliereLongue;
        break;
      case 11: 
        m_origineSaisieDernierJourIndemnisableAreSpe = m_origineSaisieDernierJourIndemnisableAreSpe;
        break;
      case 12: 
        m_dernierJourIndemnisableAreSpe = m_dernierJourIndemnisableAreSpe;
        break;
      case 13: 
        m_estAbonneGaec = m_estAbonneGaec;
        break;
      case 14: 
        m_estArretReexecution = m_estArretReexecution;
        break;
      case 15: 
        m_estNonExecutionReceptionFlux = m_estNonExecutionReceptionFlux;
        break;
      case 16: 
        m_estDesactEFE = m_estDesactEFE;
        break;
      case 17: 
        m_dateLimiteReexecution = m_dateLimiteReexecution;
        break;
      case 18: 
        m_collectionPeriodesActiviteSalariee = m_collectionPeriodesActiviteSalariee;
        break;
      case 19: 
        m_collectionDemandes = m_collectionDemandes;
        break;
      case 20: 
        m_collectionStatistiqueExamenAuFilEau = m_collectionStatistiqueExamenAuFilEau;
        break;
      case 21: 
        m_preInscription = m_preInscription;
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
 * Qualified Name:     IndividuImplPersistantPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */