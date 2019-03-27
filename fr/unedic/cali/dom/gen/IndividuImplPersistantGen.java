package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuCaliAbstrait;
import fr.unedic.cali.dom.IndividuIdSpec;
import fr.unedic.cali.dom.PreInscription;
import fr.unedic.cali.dom.StatistiqueExamenAuFilEau;
import fr.unedic.cali.dom.pc.IndividuImplPersistantPC;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class IndividuImplPersistantGen
  extends IndividuCaliAbstrait
  implements DomGenSpec
{
  protected transient DomPCSpec m_individuImplPersistantPC;
  private Damj m_dateBlocageIndemnisationConflitGAEC;
  private Damj m_dateExecutionDifferee;
  private String m_domaineSrcFlux;
  private String m_codeTransaction;
  public Damj m_dernierJourIndemnisableAreSpe;
  public String m_origineSaisieDernierJourIndemnisableAreSpe;
  private Damj m_dateLimiteReexecution;
  private Collection m_collectionPeriodesActiviteSalariee;
  private Collection m_collectionDemandes;
  private Collection m_collectionStatistiqueExamenAuFilEau;
  private Collection m_listePreInscription;
  
  public IndividuImplPersistantGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public IndividuImplPersistantGen()
  {
    setPC(createPC());
  }
  
  public IndividuImplPersistantGen(IndividuIdSpec p_individuIdSpec)
  {
    super(p_individuIdSpec);
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new IndividuImplPersistantPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_individuImplPersistantPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_individuImplPersistantPC)
  {
    m_individuImplPersistantPC = p_individuImplPersistantPC;
  }
  
  protected int rawGetEstMigree()
  {
    return ((IndividuImplPersistantPC)getPC()).getEstMigree();
  }
  
  public int getEstMigree()
  {
    return ((IndividuImplPersistantPC)getPC()).getEstMigree();
  }
  
  public void setEstMigree(int p_estMigree)
  {
    ((IndividuImplPersistantPC)getPC()).setEstMigree(p_estMigree);
  }
  
  protected Damj rawGetDateBlocageIndemnisationConflitGAEC()
  {
    return ((IndividuImplPersistantPC)getPC()).getDateBlocageIndemnisationConflitGAEC();
  }
  
  public Damj getDateBlocageIndemnisationConflitGAEC()
  {
    return ((IndividuImplPersistantPC)getPC()).getDateBlocageIndemnisationConflitGAEC();
  }
  
  public void setDateBlocageIndemnisationConflitGAEC(Damj p_dateBlocageIndemnisationConflitGAEC)
  {
    if ((m_dateBlocageIndemnisationConflitGAEC == null) || (p_dateBlocageIndemnisationConflitGAEC == null))
    {
      m_dateBlocageIndemnisationConflitGAEC = p_dateBlocageIndemnisationConflitGAEC;
      ((IndividuImplPersistantPC)getPC()).setDateBlocageIndemnisationConflitGAEC(p_dateBlocageIndemnisationConflitGAEC);
    }
    else if ((m_dateBlocageIndemnisationConflitGAEC != null) && (p_dateBlocageIndemnisationConflitGAEC != null) && (!p_dateBlocageIndemnisationConflitGAEC.equals(m_dateBlocageIndemnisationConflitGAEC)))
    {
      m_dateBlocageIndemnisationConflitGAEC = p_dateBlocageIndemnisationConflitGAEC;
      ((IndividuImplPersistantPC)getPC()).setDateBlocageIndemnisationConflitGAEC(p_dateBlocageIndemnisationConflitGAEC);
    }
  }
  
  protected int rawGetCodeTransfert()
  {
    return ((IndividuImplPersistantPC)getPC()).getCodeTransfert();
  }
  
  public int getCodeTransfert()
  {
    return ((IndividuImplPersistantPC)getPC()).getCodeTransfert();
  }
  
  public void setCodeTransfert(int p_codeTransfert)
  {
    ((IndividuImplPersistantPC)getPC()).setCodeTransfert(p_codeTransfert);
  }
  
  protected boolean rawIsInvestigationFraude()
  {
    return ((IndividuImplPersistantPC)getPC()).isInvestigationFraude();
  }
  
  public boolean isInvestigationFraude()
  {
    return ((IndividuImplPersistantPC)getPC()).isInvestigationFraude();
  }
  
  public void setInvestigationFraude(boolean p_investigationFraude)
  {
    ((IndividuImplPersistantPC)getPC()).setInvestigationFraude(p_investigationFraude);
  }
  
  protected Damj rawGetDateExecutionDifferee()
  {
    return ((IndividuImplPersistantPC)getPC()).getDateExecutionDifferee();
  }
  
  public Damj getDateExecutionDifferee()
  {
    return ((IndividuImplPersistantPC)getPC()).getDateExecutionDifferee();
  }
  
  public void setDateExecutionDifferee(Damj p_dateExecutionDifferee)
  {
    if ((m_dateExecutionDifferee == null) || (p_dateExecutionDifferee == null))
    {
      m_dateExecutionDifferee = p_dateExecutionDifferee;
      ((IndividuImplPersistantPC)getPC()).setDateExecutionDifferee(p_dateExecutionDifferee);
    }
    else if ((m_dateExecutionDifferee != null) && (p_dateExecutionDifferee != null) && (!p_dateExecutionDifferee.equals(m_dateExecutionDifferee)))
    {
      m_dateExecutionDifferee = p_dateExecutionDifferee;
      ((IndividuImplPersistantPC)getPC()).setDateExecutionDifferee(p_dateExecutionDifferee);
    }
  }
  
  protected boolean rawIsForcageAppelGaecTotal()
  {
    return ((IndividuImplPersistantPC)getPC()).isForcageAppelGaecTotal();
  }
  
  public boolean isForcageAppelGaecTotal()
  {
    return ((IndividuImplPersistantPC)getPC()).isForcageAppelGaecTotal();
  }
  
  public void setForcageAppelGaecTotal(boolean p_forcageAppelGaecTotal)
  {
    ((IndividuImplPersistantPC)getPC()).setForcageAppelGaecTotal(p_forcageAppelGaecTotal);
  }
  
  protected String rawGetDomaineSrcFlux()
  {
    return ((IndividuImplPersistantPC)getPC()).getDomaineSrcFlux();
  }
  
  public String getDomaineSrcFlux()
  {
    return ((IndividuImplPersistantPC)getPC()).getDomaineSrcFlux();
  }
  
  public void setDomaineSrcFlux(String p_domaineSrcFlux)
  {
    if ((m_domaineSrcFlux == null) || (p_domaineSrcFlux == null))
    {
      m_domaineSrcFlux = p_domaineSrcFlux;
      ((IndividuImplPersistantPC)getPC()).setDomaineSrcFlux(p_domaineSrcFlux);
    }
    else if ((m_domaineSrcFlux != null) && (p_domaineSrcFlux != null) && (!p_domaineSrcFlux.equals(m_domaineSrcFlux)))
    {
      m_domaineSrcFlux = p_domaineSrcFlux;
      ((IndividuImplPersistantPC)getPC()).setDomaineSrcFlux(p_domaineSrcFlux);
    }
  }
  
  protected String rawGetCodeTransaction()
  {
    return ((IndividuImplPersistantPC)getPC()).getCodeTransaction();
  }
  
  public String getCodeTransaction()
  {
    return ((IndividuImplPersistantPC)getPC()).getCodeTransaction();
  }
  
  public void setCodeTransaction(String p_codeTransaction)
  {
    if ((m_codeTransaction == null) || (p_codeTransaction == null))
    {
      m_codeTransaction = p_codeTransaction;
      ((IndividuImplPersistantPC)getPC()).setCodeTransaction(p_codeTransaction);
    }
    else if ((m_codeTransaction != null) && (p_codeTransaction != null) && (!p_codeTransaction.equals(m_codeTransaction)))
    {
      m_codeTransaction = p_codeTransaction;
      ((IndividuImplPersistantPC)getPC()).setCodeTransaction(p_codeTransaction);
    }
  }
  
  protected int rawGetAttributionsAfdFiliereCourte()
  {
    return ((IndividuImplPersistantPC)getPC()).getAttributionsAfdFiliereCourte();
  }
  
  public int getAttributionsAfdFiliereCourte()
  {
    return ((IndividuImplPersistantPC)getPC()).getAttributionsAfdFiliereCourte();
  }
  
  public void setAttributionsAfdFiliereCourte(int p_attributionsAfdFiliereCourte)
  {
    ((IndividuImplPersistantPC)getPC()).setAttributionsAfdFiliereCourte(p_attributionsAfdFiliereCourte);
  }
  
  protected int rawGetAttributionsAfdFiliereIntermediaire()
  {
    return ((IndividuImplPersistantPC)getPC()).getAttributionsAfdFiliereIntermediaire();
  }
  
  public int getAttributionsAfdFiliereIntermediaire()
  {
    return ((IndividuImplPersistantPC)getPC()).getAttributionsAfdFiliereIntermediaire();
  }
  
  public void setAttributionsAfdFiliereIntermediaire(int p_attributionsAfdFiliereIntermediaire)
  {
    ((IndividuImplPersistantPC)getPC()).setAttributionsAfdFiliereIntermediaire(p_attributionsAfdFiliereIntermediaire);
  }
  
  protected int rawGetAttributionsAfdFiliereLongue()
  {
    return ((IndividuImplPersistantPC)getPC()).getAttributionsAfdFiliereLongue();
  }
  
  public int getAttributionsAfdFiliereLongue()
  {
    return ((IndividuImplPersistantPC)getPC()).getAttributionsAfdFiliereLongue();
  }
  
  public void setAttributionsAfdFiliereLongue(int p_attributionsAfdFiliereLongue)
  {
    ((IndividuImplPersistantPC)getPC()).setAttributionsAfdFiliereLongue(p_attributionsAfdFiliereLongue);
  }
  
  protected Damj rawGetDernierJourIndemnisableAreSpe()
  {
    return ((IndividuImplPersistantPC)getPC()).getDernierJourIndemnisableAreSpe();
  }
  
  public Damj getDernierJourIndemnisableAreSpe()
  {
    return ((IndividuImplPersistantPC)getPC()).getDernierJourIndemnisableAreSpe();
  }
  
  public void setDernierJourIndemnisableAreSpe(Damj p_dernierJourIndemnisableAreSpe)
  {
    if ((m_dernierJourIndemnisableAreSpe == null) || (p_dernierJourIndemnisableAreSpe == null))
    {
      m_dernierJourIndemnisableAreSpe = p_dernierJourIndemnisableAreSpe;
      ((IndividuImplPersistantPC)getPC()).setDernierJourIndemnisableAreSpe(p_dernierJourIndemnisableAreSpe);
    }
    else if ((m_dernierJourIndemnisableAreSpe != null) && (p_dernierJourIndemnisableAreSpe != null) && (!p_dernierJourIndemnisableAreSpe.equals(m_dernierJourIndemnisableAreSpe)))
    {
      m_dernierJourIndemnisableAreSpe = p_dernierJourIndemnisableAreSpe;
      ((IndividuImplPersistantPC)getPC()).setDernierJourIndemnisableAreSpe(p_dernierJourIndemnisableAreSpe);
    }
  }
  
  protected String rawGetOrigineSaisieDernierJourIndemnisableAreSpe()
  {
    return ((IndividuImplPersistantPC)getPC()).getOrigineSaisieDernierJourIndemnisableAreSpe();
  }
  
  public String getOrigineSaisieDernierJourIndemnisableAreSpe()
  {
    return ((IndividuImplPersistantPC)getPC()).getOrigineSaisieDernierJourIndemnisableAreSpe();
  }
  
  public void setOrigineSaisieDernierJourIndemnisableAreSpe(String p_origineSaisieDernierJourIndemnisableAreSpe)
  {
    if ((m_origineSaisieDernierJourIndemnisableAreSpe == null) || (p_origineSaisieDernierJourIndemnisableAreSpe == null))
    {
      m_origineSaisieDernierJourIndemnisableAreSpe = p_origineSaisieDernierJourIndemnisableAreSpe;
      ((IndividuImplPersistantPC)getPC()).setOrigineSaisieDernierJourIndemnisableAreSpe(p_origineSaisieDernierJourIndemnisableAreSpe);
    }
    else if ((m_origineSaisieDernierJourIndemnisableAreSpe != null) && (p_origineSaisieDernierJourIndemnisableAreSpe != null) && (!p_origineSaisieDernierJourIndemnisableAreSpe.equals(m_origineSaisieDernierJourIndemnisableAreSpe)))
    {
      m_origineSaisieDernierJourIndemnisableAreSpe = p_origineSaisieDernierJourIndemnisableAreSpe;
      ((IndividuImplPersistantPC)getPC()).setOrigineSaisieDernierJourIndemnisableAreSpe(p_origineSaisieDernierJourIndemnisableAreSpe);
    }
  }
  
  protected boolean rawIsEstAbonneGaec()
  {
    return ((IndividuImplPersistantPC)getPC()).isEstAbonneGaec();
  }
  
  public boolean isEstAbonneGaec()
  {
    return ((IndividuImplPersistantPC)getPC()).isEstAbonneGaec();
  }
  
  public void setEstAbonneGaec(boolean p_estAbonneGaec)
  {
    ((IndividuImplPersistantPC)getPC()).setEstAbonneGaec(p_estAbonneGaec);
  }
  
  protected boolean rawIsEstArretReexecution()
  {
    return ((IndividuImplPersistantPC)getPC()).isEstArretReexecution();
  }
  
  public boolean isEstArretReexecution()
  {
    return ((IndividuImplPersistantPC)getPC()).isEstArretReexecution();
  }
  
  public void setEstArretReexecution(boolean p_estArretReexecution)
  {
    ((IndividuImplPersistantPC)getPC()).setEstArretReexecution(p_estArretReexecution);
  }
  
  protected boolean rawIsEstNonExecutionReceptionFlux()
  {
    return ((IndividuImplPersistantPC)getPC()).isEstNonExecutionReceptionFlux();
  }
  
  public boolean isEstNonExecutionReceptionFlux()
  {
    return ((IndividuImplPersistantPC)getPC()).isEstNonExecutionReceptionFlux();
  }
  
  public void setEstNonExecutionReceptionFlux(boolean p_estNonExecutionReceptionFlux)
  {
    ((IndividuImplPersistantPC)getPC()).setEstNonExecutionReceptionFlux(p_estNonExecutionReceptionFlux);
  }
  
  protected boolean rawIsEstDesactEFE()
  {
    return ((IndividuImplPersistantPC)getPC()).isEstDesactEFE();
  }
  
  public boolean isEstDesactEFE()
  {
    return ((IndividuImplPersistantPC)getPC()).isEstDesactEFE();
  }
  
  public void setEstDesactEFE(boolean p_estDesactEFE)
  {
    ((IndividuImplPersistantPC)getPC()).setEstDesactEFE(p_estDesactEFE);
  }
  
  protected Damj rawGetDateLimiteReexecution()
  {
    return ((IndividuImplPersistantPC)getPC()).getDateLimiteReexecution();
  }
  
  public Damj getDateLimiteReexecution()
  {
    return ((IndividuImplPersistantPC)getPC()).getDateLimiteReexecution();
  }
  
  public void setDateLimiteReexecution(Damj p_dateLimiteReexecution)
  {
    if ((m_dateLimiteReexecution == null) || (p_dateLimiteReexecution == null))
    {
      m_dateLimiteReexecution = p_dateLimiteReexecution;
      ((IndividuImplPersistantPC)getPC()).setDateLimiteReexecution(p_dateLimiteReexecution);
    }
    else if ((m_dateLimiteReexecution != null) && (p_dateLimiteReexecution != null) && (!p_dateLimiteReexecution.equals(m_dateLimiteReexecution)))
    {
      m_dateLimiteReexecution = p_dateLimiteReexecution;
      ((IndividuImplPersistantPC)getPC()).setDateLimiteReexecution(p_dateLimiteReexecution);
    }
  }
  
  private final Collection getCollectionModifiableActiviteSalarie()
  {
    Iterator itCollectionPC;
    if (m_collectionPeriodesActiviteSalariee == null)
    {
      m_collectionPeriodesActiviteSalariee = new ArrayList();
      for (itCollectionPC = ((IndividuImplPersistantPC)getPC()).getCollectionActiviteSalarie().iterator(); itCollectionPC.hasNext();)
      {
        DomPCSpec currentPC = (DomPCSpec)itCollectionPC.next();
        Object currentOM = currentPC.createOM();
        m_collectionPeriodesActiviteSalariee.add(currentOM);
      }
    }
    return m_collectionPeriodesActiviteSalariee;
  }
  
  public Collection getCollectionActiviteSalarie()
  {
    return Collections.unmodifiableCollection(getCollectionModifiableActiviteSalarie());
  }
  
  public List getListActiviteSalarie()
  {
    return Collections.unmodifiableList((List)getCollectionModifiableActiviteSalarie());
  }
  
  public void remplacerCollectionActiviteSalarie(Collection p_collectionACopier)
  {
    clearCollectionActiviteSalarie();
    for (Iterator i = p_collectionACopier.iterator(); i.hasNext();)
    {
      ActiviteSalarie objet = (ActiviteSalarie)i.next();
      ajouterActiviteSalarie(objet);
    }
  }
  
  public void supprimerSousCollectionActiviteSalarie(Collection p_collectionASupprimer)
  {
    for (Iterator i = p_collectionASupprimer.iterator(); i.hasNext();)
    {
      ActiviteSalarie objet = (ActiviteSalarie)i.next();
      supprimerActiviteSalarie(objet);
    }
  }
  
  public void ajouterActiviteSalarie(ActiviteSalarie p_periodesActiviteSalariee)
    throws NullPointerException
  {
    if (p_periodesActiviteSalariee == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periodesActiviteSalariee ne devrait pas être nul.", p_periodesActiviteSalariee);
    }
    getCollectionModifiableActiviteSalarie().add(p_periodesActiviteSalariee);
    ((IndividuImplPersistantPC)getPC()).ajouterActiviteSalarie(p_periodesActiviteSalariee.getPC());
  }
  
  public void supprimerActiviteSalarie(ActiviteSalarie p_periodesActiviteSalariee)
    throws NullPointerException
  {
    if (p_periodesActiviteSalariee == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periodesActiviteSalariee ne devrait pas être nul.", p_periodesActiviteSalariee);
    }
    getCollectionModifiableActiviteSalarie().remove(p_periodesActiviteSalariee);
    ((IndividuImplPersistantPC)getPC()).supprimerActiviteSalarie(p_periodesActiviteSalariee.getPC());
  }
  
  public void recopierCollectionActiviteSalarieVers(ObjetMetierSpec p_copie)
  {
    IndividuImplPersistantGen copie = (IndividuImplPersistantGen)p_copie;
    Collection listeACopier = getCollectionActiviteSalarie();
    for (Iterator i = listeACopier.iterator(); i.hasNext();)
    {
      ObjetMetierSpec objet = ((ObjetMetierSpec)i.next()).copie();
      copie.ajouterActiviteSalarie((ActiviteSalarie)objet);
    }
  }
  
  public void clearCollectionActiviteSalarie()
  {
    getCollectionModifiableActiviteSalarie().clear();
    ((IndividuImplPersistantPC)getPC()).getCollectionActiviteSalarie().clear();
  }
  
  private final Collection getCollectionModifiableDemande()
  {
    Iterator itCollectionPC;
    if (m_collectionDemandes == null)
    {
      m_collectionDemandes = new ArrayList();
      for (itCollectionPC = ((IndividuImplPersistantPC)getPC()).getCollectionDemande().iterator(); itCollectionPC.hasNext();)
      {
        DomPCSpec currentPC = (DomPCSpec)itCollectionPC.next();
        Object currentOM = currentPC.createOM();
        m_collectionDemandes.add(currentOM);
      }
    }
    return m_collectionDemandes;
  }
  
  public Collection getCollectionDemande()
  {
    return Collections.unmodifiableCollection(getCollectionModifiableDemande());
  }
  
  public List getListDemande()
  {
    return Collections.unmodifiableList((List)getCollectionModifiableDemande());
  }
  
  public void remplacerCollectionDemande(Collection p_collectionACopier)
  {
    clearCollectionDemande();
    for (Iterator i = p_collectionACopier.iterator(); i.hasNext();)
    {
      DemandeSpec objet = (DemandeSpec)i.next();
      ajouterDemande(objet);
    }
  }
  
  public void supprimerSousCollectionDemande(Collection p_collectionASupprimer)
  {
    for (Iterator i = p_collectionASupprimer.iterator(); i.hasNext();)
    {
      DemandeSpec objet = (DemandeSpec)i.next();
      supprimerDemande(objet);
    }
  }
  
  public void ajouterDemande(DemandeSpec p_demandes)
    throws NullPointerException
  {
    if (p_demandes == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_demandes ne devrait pas être nul.", p_demandes);
    }
    getCollectionModifiableDemande().add(p_demandes);
    ((IndividuImplPersistantPC)getPC()).ajouterDemande(((DomGenSpec)p_demandes).getPC());
  }
  
  public void supprimerDemande(DemandeSpec p_demandes)
    throws NullPointerException
  {
    if (p_demandes == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_demandes ne devrait pas être nul.", p_demandes);
    }
    getCollectionModifiableDemande().remove(p_demandes);
    ((IndividuImplPersistantPC)getPC()).supprimerDemande(((DomGenSpec)p_demandes).getPC());
  }
  
  public void recopierCollectionDemandeVers(ObjetMetierSpec p_copie)
  {
    IndividuImplPersistantGen copie = (IndividuImplPersistantGen)p_copie;
    Collection listeACopier = getCollectionDemande();
    for (Iterator i = listeACopier.iterator(); i.hasNext();)
    {
      ObjetMetierSpec objet = ((ObjetMetierSpec)i.next()).copie();
      copie.ajouterDemande((DemandeSpec)objet);
    }
  }
  
  public void clearCollectionDemande()
  {
    getCollectionModifiableDemande().clear();
    ((IndividuImplPersistantPC)getPC()).getCollectionDemande().clear();
  }
  
  private final Collection getCollectionModifiableStatistiqueExamenAuFilEau()
  {
    Iterator itCollectionPC;
    if (m_collectionStatistiqueExamenAuFilEau == null)
    {
      m_collectionStatistiqueExamenAuFilEau = new ArrayList();
      for (itCollectionPC = ((IndividuImplPersistantPC)getPC()).getCollectionStatistiqueExamenAuFilEau().iterator(); itCollectionPC.hasNext();)
      {
        DomPCSpec currentPC = (DomPCSpec)itCollectionPC.next();
        Object currentOM = currentPC.createOM();
        m_collectionStatistiqueExamenAuFilEau.add(currentOM);
      }
    }
    return m_collectionStatistiqueExamenAuFilEau;
  }
  
  public Collection getCollectionStatistiqueExamenAuFilEau()
  {
    return Collections.unmodifiableCollection(getCollectionModifiableStatistiqueExamenAuFilEau());
  }
  
  public List getListStatistiqueExamenAuFilEau()
  {
    return Collections.unmodifiableList((List)getCollectionModifiableStatistiqueExamenAuFilEau());
  }
  
  public void remplacerCollectionStatistiqueExamenAuFilEau(Collection p_collectionACopier)
  {
    clearCollectionStatistiqueExamenAuFilEau();
    for (Iterator i = p_collectionACopier.iterator(); i.hasNext();)
    {
      StatistiqueExamenAuFilEau objet = (StatistiqueExamenAuFilEau)i.next();
      ajouterStatistiqueExamenAuFilEau(objet);
    }
  }
  
  public void supprimerSousCollectionStatistiqueExamenAuFilEau(Collection p_collectionASupprimer)
  {
    for (Iterator i = p_collectionASupprimer.iterator(); i.hasNext();)
    {
      StatistiqueExamenAuFilEau objet = (StatistiqueExamenAuFilEau)i.next();
      supprimerStatistiqueExamenAuFilEau(objet);
    }
  }
  
  public void ajouterStatistiqueExamenAuFilEau(StatistiqueExamenAuFilEau p_statistiqueExamenAuFilEau)
    throws NullPointerException
  {
    if (p_statistiqueExamenAuFilEau == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_statistiqueExamenAuFilEau ne devrait pas être nul.", p_statistiqueExamenAuFilEau);
    }
    getCollectionModifiableStatistiqueExamenAuFilEau().add(p_statistiqueExamenAuFilEau);
    ((IndividuImplPersistantPC)getPC()).ajouterStatistiqueExamenAuFilEau(p_statistiqueExamenAuFilEau.getPC());
  }
  
  public void supprimerStatistiqueExamenAuFilEau(StatistiqueExamenAuFilEau p_statistiqueExamenAuFilEau)
    throws NullPointerException
  {
    if (p_statistiqueExamenAuFilEau == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_statistiqueExamenAuFilEau ne devrait pas être nul.", p_statistiqueExamenAuFilEau);
    }
    getCollectionModifiableStatistiqueExamenAuFilEau().remove(p_statistiqueExamenAuFilEau);
    ((IndividuImplPersistantPC)getPC()).supprimerStatistiqueExamenAuFilEau(p_statistiqueExamenAuFilEau.getPC());
  }
  
  public void recopierCollectionStatistiqueExamenAuFilEauVers(ObjetMetierSpec p_copie)
  {
    IndividuImplPersistantGen copie = (IndividuImplPersistantGen)p_copie;
    Collection listeACopier = getCollectionStatistiqueExamenAuFilEau();
    for (Iterator i = listeACopier.iterator(); i.hasNext();)
    {
      ObjetMetierSpec objet = ((ObjetMetierSpec)i.next()).copie();
      copie.ajouterStatistiqueExamenAuFilEau((StatistiqueExamenAuFilEau)objet);
    }
  }
  
  public void clearCollectionStatistiqueExamenAuFilEau()
  {
    getCollectionModifiableStatistiqueExamenAuFilEau().clear();
    ((IndividuImplPersistantPC)getPC()).getCollectionStatistiqueExamenAuFilEau().clear();
  }
  
  private final Collection getCollectionModifiablePreInscription()
  {
    Iterator itCollectionPC;
    if (m_listePreInscription == null)
    {
      m_listePreInscription = new ArrayList();
      for (itCollectionPC = ((IndividuImplPersistantPC)getPC()).getCollectionPreInscription().iterator(); itCollectionPC.hasNext();)
      {
        DomPCSpec currentPC = (DomPCSpec)itCollectionPC.next();
        Object currentOM = currentPC.createOM();
        m_listePreInscription.add(currentOM);
      }
    }
    return m_listePreInscription;
  }
  
  public Collection getCollectionPreInscription()
  {
    return Collections.unmodifiableCollection(getCollectionModifiablePreInscription());
  }
  
  public List getListPreInscription()
  {
    return Collections.unmodifiableList((List)getCollectionModifiablePreInscription());
  }
  
  public void remplacerCollectionPreInscription(Collection p_collectionACopier)
  {
    clearCollectionPreInscription();
    for (Iterator i = p_collectionACopier.iterator(); i.hasNext();)
    {
      PreInscription objet = (PreInscription)i.next();
      ajouterPreInscription(objet);
    }
  }
  
  public void supprimerSousCollectionPreInscription(Collection p_collectionASupprimer)
  {
    for (Iterator i = p_collectionASupprimer.iterator(); i.hasNext();)
    {
      PreInscription objet = (PreInscription)i.next();
      supprimerPreInscription(objet);
    }
  }
  
  public void ajouterPreInscription(PreInscription p_preInscription)
    throws NullPointerException
  {
    if (p_preInscription == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_preInscription ne devrait pas être nul.", p_preInscription);
    }
    getCollectionModifiablePreInscription().add(p_preInscription);
    ((IndividuImplPersistantPC)getPC()).ajouterPreInscription(p_preInscription.getPC());
  }
  
  public void supprimerPreInscription(PreInscription p_preInscription)
    throws NullPointerException
  {
    if (p_preInscription == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_preInscription ne devrait pas être nul.", p_preInscription);
    }
    getCollectionModifiablePreInscription().remove(p_preInscription);
    ((IndividuImplPersistantPC)getPC()).supprimerPreInscription(p_preInscription.getPC());
  }
  
  public void recopierCollectionPreInscriptionVers(ObjetMetierSpec p_copie)
  {
    IndividuImplPersistantGen copie = (IndividuImplPersistantGen)p_copie;
    Collection listeACopier = getCollectionPreInscription();
    for (Iterator i = listeACopier.iterator(); i.hasNext();)
    {
      ObjetMetierSpec objet = ((ObjetMetierSpec)i.next()).copie();
      copie.ajouterPreInscription((PreInscription)objet);
    }
  }
  
  public void clearCollectionPreInscription()
  {
    getCollectionModifiablePreInscription().clear();
    ((IndividuImplPersistantPC)getPC()).getCollectionPreInscription().clear();
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    for (Iterator iter = getCollectionActiviteSalarie().iterator(); iter.hasNext();)
    {
      DomGenSpec item = (DomGenSpec)iter.next();
      if ((item != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(item))) {
        DomManager.supprimer(item, p_contexteSuppression);
      }
    }
    for (Iterator iter = getCollectionDemande().iterator(); iter.hasNext();)
    {
      DomGenSpec item = (DomGenSpec)iter.next();
      if ((item != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(item))) {
        DomManager.supprimer(item, p_contexteSuppression);
      }
    }
    for (Iterator iter = getCollectionStatistiqueExamenAuFilEau().iterator(); iter.hasNext();)
    {
      DomGenSpec item = (DomGenSpec)iter.next();
      if ((item != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(item))) {
        DomManager.supprimer(item, p_contexteSuppression);
      }
    }
    for (Iterator iter = getCollectionPreInscription().iterator(); iter.hasNext();)
    {
      DomGenSpec item = (DomGenSpec)iter.next();
      if ((item != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(item))) {
        DomManager.supprimer(item, p_contexteSuppression);
      }
    }
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     IndividuImplPersistantGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */