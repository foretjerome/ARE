package fr.unedic.cali.calcul.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.cali.calcul.dom.EtatAuDji;
import fr.unedic.cali.calcul.dom.pc.CalendrierExecutionCalculPC;
import fr.unedic.cali.calcul.dom.periode.DsmTravail;
import fr.unedic.cali.calcul.dom.periode.PeriodeNonDeclareeSanction;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriodeCREM;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class CalendrierExecutionCalculGen
  extends ObjetChronoPeriodeCREM
  implements DomGenSpec
{
  private Damj m_dernierJourIndemnisablePourSuivi;
  private EtatAuDji m_etatAuDji;
  private Damj m_dateFinDispositifCSP;
  private Collection m_listePNDS;
  private Collection m_listeDNJ;
  
  public CalendrierExecutionCalculGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public CalendrierExecutionCalculGen() {}
  
  protected abstract DomPCSpec createPC();
  
  protected int rawGetEtatAttribution()
  {
    return ((CalendrierExecutionCalculPC)getPC()).getEtatAttribution();
  }
  
  public int getEtatAttribution()
  {
    return ((CalendrierExecutionCalculPC)getPC()).getEtatAttribution();
  }
  
  public void setEtatAttribution(int p_etatAttribution)
  {
    ((CalendrierExecutionCalculPC)getPC()).setEtatAttribution(p_etatAttribution);
  }
  
  protected Damj rawGetDernierJourIndemnisablePourSuivi()
  {
    return ((CalendrierExecutionCalculPC)getPC()).getDernierJourIndemnisablePourSuivi();
  }
  
  public Damj getDernierJourIndemnisablePourSuivi()
  {
    return ((CalendrierExecutionCalculPC)getPC()).getDernierJourIndemnisablePourSuivi();
  }
  
  public void setDernierJourIndemnisablePourSuivi(Damj p_dernierJourIndemnisablePourSuivi)
  {
    if ((m_dernierJourIndemnisablePourSuivi == null) || (p_dernierJourIndemnisablePourSuivi == null))
    {
      m_dernierJourIndemnisablePourSuivi = p_dernierJourIndemnisablePourSuivi;
      ((CalendrierExecutionCalculPC)getPC()).setDernierJourIndemnisablePourSuivi(p_dernierJourIndemnisablePourSuivi);
    }
    else if ((m_dernierJourIndemnisablePourSuivi != null) && (p_dernierJourIndemnisablePourSuivi != null) && (!p_dernierJourIndemnisablePourSuivi.equals(m_dernierJourIndemnisablePourSuivi)))
    {
      m_dernierJourIndemnisablePourSuivi = p_dernierJourIndemnisablePourSuivi;
      ((CalendrierExecutionCalculPC)getPC()).setDernierJourIndemnisablePourSuivi(p_dernierJourIndemnisablePourSuivi);
    }
  }
  
  public EtatAuDji getEtatAuDji()
  {
    if (m_etatAuDji == null)
    {
      DomPCSpec etatAuDjiPC = ((CalendrierExecutionCalculPC)getPC()).getEtatAuDji();
      if (etatAuDjiPC != null) {
        m_etatAuDji = ((EtatAuDji)etatAuDjiPC.createOM());
      }
    }
    return m_etatAuDji;
  }
  
  public void setEtatAuDji(EtatAuDji p_etatAuDji)
  {
    if (p_etatAuDji == null)
    {
      ((CalendrierExecutionCalculPC)getPC()).setEtatAuDji(null);
      m_etatAuDji = p_etatAuDji;
    }
    else if (!p_etatAuDji.equals(m_etatAuDji))
    {
      ((CalendrierExecutionCalculPC)getPC()).setEtatAuDji(p_etatAuDji.getPC());
      m_etatAuDji = p_etatAuDji;
    }
  }
  
  protected Damj rawGetDateFinDispositifCSP()
  {
    return ((CalendrierExecutionCalculPC)getPC()).getDateFinDispositifCSP();
  }
  
  public Damj getDateFinDispositifCSP()
  {
    return ((CalendrierExecutionCalculPC)getPC()).getDateFinDispositifCSP();
  }
  
  public void setDateFinDispositifCSP(Damj p_dateFinDispositifCSP)
  {
    if ((m_dateFinDispositifCSP == null) || (p_dateFinDispositifCSP == null))
    {
      m_dateFinDispositifCSP = p_dateFinDispositifCSP;
      ((CalendrierExecutionCalculPC)getPC()).setDateFinDispositifCSP(p_dateFinDispositifCSP);
    }
    else if ((m_dateFinDispositifCSP != null) && (p_dateFinDispositifCSP != null) && (!p_dateFinDispositifCSP.equals(m_dateFinDispositifCSP)))
    {
      m_dateFinDispositifCSP = p_dateFinDispositifCSP;
      ((CalendrierExecutionCalculPC)getPC()).setDateFinDispositifCSP(p_dateFinDispositifCSP);
    }
  }
  
  private final Collection getCollectionModifiablePNDS()
  {
    Iterator itCollectionPC;
    if (m_listePNDS == null)
    {
      m_listePNDS = new ArrayList();
      for (itCollectionPC = ((CalendrierExecutionCalculPC)getPC()).getCollectionPNDS().iterator(); itCollectionPC.hasNext();)
      {
        DomPCSpec currentPC = (DomPCSpec)itCollectionPC.next();
        Object currentOM = currentPC.createOM();
        m_listePNDS.add(currentOM);
      }
    }
    return m_listePNDS;
  }
  
  public Collection getCollectionPNDS()
  {
    return Collections.unmodifiableCollection(getCollectionModifiablePNDS());
  }
  
  public List getListPNDS()
  {
    return Collections.unmodifiableList((List)getCollectionModifiablePNDS());
  }
  
  public void remplacerCollectionPNDS(Collection p_collectionACopier)
  {
    clearCollectionPNDS();
    for (Iterator i = p_collectionACopier.iterator(); i.hasNext();)
    {
      PeriodeNonDeclareeSanction objet = (PeriodeNonDeclareeSanction)i.next();
      ajouterPNDS(objet);
    }
  }
  
  public void supprimerSousCollectionPNDS(Collection p_collectionASupprimer)
  {
    for (Iterator i = p_collectionASupprimer.iterator(); i.hasNext();)
    {
      PeriodeNonDeclareeSanction objet = (PeriodeNonDeclareeSanction)i.next();
      supprimerPNDS(objet);
    }
  }
  
  public void ajouterPNDS(PeriodeNonDeclareeSanction p_periode)
    throws NullPointerException
  {
    if (p_periode == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periode ne devrait pas être nul.", p_periode);
    }
    getCollectionModifiablePNDS().add(p_periode);
    ((CalendrierExecutionCalculPC)getPC()).ajouterPNDS(p_periode.getPC());
  }
  
  public void supprimerPNDS(PeriodeNonDeclareeSanction p_periode)
    throws NullPointerException
  {
    if (p_periode == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periode ne devrait pas être nul.", p_periode);
    }
    getCollectionModifiablePNDS().remove(p_periode);
    ((CalendrierExecutionCalculPC)getPC()).supprimerPNDS(p_periode.getPC());
  }
  
  public void recopierCollectionPNDSVers(ObjetMetierSpec p_copie)
  {
    CalendrierExecutionCalculGen copie = (CalendrierExecutionCalculGen)p_copie;
    Collection listeACopier = getCollectionPNDS();
    for (Iterator i = listeACopier.iterator(); i.hasNext();)
    {
      ObjetMetierSpec objet = ((ObjetMetierSpec)i.next()).copie();
      copie.ajouterPNDS((PeriodeNonDeclareeSanction)objet);
    }
  }
  
  public void clearCollectionPNDS()
  {
    getCollectionModifiablePNDS().clear();
    ((CalendrierExecutionCalculPC)getPC()).getCollectionPNDS().clear();
  }
  
  private final Collection getCollectionModifiableDNJ()
  {
    Iterator itCollectionPC;
    if (m_listeDNJ == null)
    {
      m_listeDNJ = new ArrayList();
      for (itCollectionPC = ((CalendrierExecutionCalculPC)getPC()).getCollectionDNJ().iterator(); itCollectionPC.hasNext();)
      {
        DomPCSpec currentPC = (DomPCSpec)itCollectionPC.next();
        Object currentOM = currentPC.createOM();
        m_listeDNJ.add(currentOM);
      }
    }
    return m_listeDNJ;
  }
  
  public Collection getCollectionDNJ()
  {
    return Collections.unmodifiableCollection(getCollectionModifiableDNJ());
  }
  
  public List getListDNJ()
  {
    return Collections.unmodifiableList((List)getCollectionModifiableDNJ());
  }
  
  public void remplacerCollectionDNJ(Collection p_collectionACopier)
  {
    clearCollectionDNJ();
    for (Iterator i = p_collectionACopier.iterator(); i.hasNext();)
    {
      DsmTravail objet = (DsmTravail)i.next();
      ajouterDNJ(objet);
    }
  }
  
  public void supprimerSousCollectionDNJ(Collection p_collectionASupprimer)
  {
    for (Iterator i = p_collectionASupprimer.iterator(); i.hasNext();)
    {
      DsmTravail objet = (DsmTravail)i.next();
      supprimerDNJ(objet);
    }
  }
  
  public void ajouterDNJ(DsmTravail p_periode)
    throws NullPointerException
  {
    if (p_periode == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periode ne devrait pas être nul.", p_periode);
    }
    getCollectionModifiableDNJ().add(p_periode);
    ((CalendrierExecutionCalculPC)getPC()).ajouterDNJ(p_periode.getPC());
  }
  
  public void supprimerDNJ(DsmTravail p_periode)
    throws NullPointerException
  {
    if (p_periode == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_periode ne devrait pas être nul.", p_periode);
    }
    getCollectionModifiableDNJ().remove(p_periode);
    ((CalendrierExecutionCalculPC)getPC()).supprimerDNJ(p_periode.getPC());
  }
  
  public void recopierCollectionDNJVers(ObjetMetierSpec p_copie)
  {
    CalendrierExecutionCalculGen copie = (CalendrierExecutionCalculGen)p_copie;
    Collection listeACopier = getCollectionDNJ();
    for (Iterator i = listeACopier.iterator(); i.hasNext();)
    {
      ObjetMetierSpec objet = ((ObjetMetierSpec)i.next()).copie();
      copie.ajouterDNJ((DsmTravail)objet);
    }
  }
  
  public void clearCollectionDNJ()
  {
    getCollectionModifiableDNJ().clear();
    ((CalendrierExecutionCalculPC)getPC()).getCollectionDNJ().clear();
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    
    super.supprimerEnProfondeur(p_contexteSuppression);
    
    Object etatAuDji = getEtatAuDji();
    if ((etatAuDji != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(etatAuDji))) {
      DomManager.supprimer(getEtatAuDji(), p_contexteSuppression);
    }
    for (Iterator iter = getCollectionPNDS().iterator(); iter.hasNext();)
    {
      DomGenSpec item = (DomGenSpec)iter.next();
      if ((item != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(item))) {
        DomManager.supprimer(item, p_contexteSuppression);
      }
    }
    for (Iterator iter = getCollectionDNJ().iterator(); iter.hasNext();)
    {
      DomGenSpec item = (DomGenSpec)iter.next();
      if ((item != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(item))) {
        DomManager.supprimer(item, p_contexteSuppression);
      }
    }
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    super.copieElements(p_copie);
  }
}

/* Location:
 * Qualified Name:     CalendrierExecutionCalculGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */