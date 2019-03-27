package fr.unedic.cali.parcours;

import fr.unedic.cali.autresdoms.ga.dom.ActionFormation;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Chronologie;
import java.math.BigDecimal;
import java.util.Collection;

public class DomCreationFormulaires
  extends DomCaliOptimise
  implements DomCali
{
  private Collection m_collectionDemandesCojac;
  private String m_numeroAllocataire;
  private IndividuSpec m_allocataire;
  private ContexteService m_contexteService;
  private ActionFormation m_actionFormation;
  private String m_idActionFormation;
  private BigDecimal m_montantGlobal;
  private BigDecimal m_montantACharge;
  private String m_numAllocataire;
  private Chronologie m_chronoPeriodesLieux;
  
  public String getNumAllocataire()
  {
    return m_numAllocataire;
  }
  
  public void setNumAllocataire(String p_numAllocataire)
  {
    m_numAllocataire = p_numAllocataire;
  }
  
  public Chronologie getChronoPeriodesLieux()
  {
    return m_chronoPeriodesLieux;
  }
  
  public void setChronoPeriodesLieux(Chronologie p_chronoPeriodesLieux)
  {
    m_chronoPeriodesLieux = p_chronoPeriodesLieux;
  }
  
  public void setIdActionFormation(String p_idActionFormation)
  {
    m_idActionFormation = p_idActionFormation;
  }
  
  public Collection getCollectionDemandesCojac()
  {
    return m_collectionDemandesCojac;
  }
  
  public String getNumeroAllocataire()
  {
    return m_numeroAllocataire;
  }
  
  public void setCollectionDemandesCojac(Collection p_collection)
  {
    m_collectionDemandesCojac = p_collection;
  }
  
  public void setNumeroAllocataire(String p_string)
  {
    m_numeroAllocataire = p_string;
  }
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public static ContexteService getContexteService(Contexte p_contexte)
  {
    return ((DomCreationFormulaires)p_contexte.getDonnees()).getContexteService();
  }
  
  public String getIdActionFormation()
  {
    return m_idActionFormation;
  }
  
  public IndividuSpec getIndividu()
  {
    return m_allocataire;
  }
  
  public void setIndividu(IndividuSpec p_allocataire)
  {
    m_allocataire = p_allocataire;
  }
  
  public BigDecimal getMontantACharge()
  {
    return m_montantACharge;
  }
  
  public void setMontantACharge(BigDecimal p_montantACharge)
  {
    m_montantACharge = p_montantACharge;
  }
  
  public BigDecimal getMontantGlobal()
  {
    return m_montantGlobal;
  }
  
  public void setMontantGlobal(BigDecimal p_montantGlobal)
  {
    m_montantGlobal = p_montantGlobal;
  }
  
  public ActionFormation getActionFormation()
  {
    return m_actionFormation;
  }
  
  public void setActionFormation(ActionFormation p_actionFormation)
  {
    m_actionFormation = p_actionFormation;
  }
}

/* Location:
 * Qualified Name:     DomCreationFormulaires
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */