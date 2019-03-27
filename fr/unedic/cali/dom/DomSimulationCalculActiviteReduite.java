package fr.unedic.cali.dom;

import fr.unedic.cali.parcours.DomCali;
import fr.unedic.cali.parcours.DomCaliOptimise;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class DomSimulationCalculActiviteReduite
  extends DomCaliOptimise
  implements DomCali
{
  private Damj m_dateDebutPeriodeActiviteReduite;
  private BigDecimal m_sjr;
  private BigDecimal m_allocationJournaliereInitiale;
  private BigDecimal m_remunerationReprise;
  private BigDecimal m_montant;
  private BigDecimal m_montantCrc;
  private BigDecimal m_montantCsg;
  private BigDecimal m_montantCrds;
  private BigDecimal m_nbJoursDansMois;
  private BigDecimal m_nbJoursAPayer;
  private BigDecimal m_nbJoursDecaler;
  private ContexteService m_contexteService;
  private AttributionSpec m_attribution;
  
  public AttributionSpec getAttribution()
  {
    return m_attribution;
  }
  
  public void setAttribution(AttributionSpec p_attribution)
  {
    m_attribution = p_attribution;
  }
  
  public Damj getDateDebutPeriodeActiviteReduite()
  {
    return m_dateDebutPeriodeActiviteReduite;
  }
  
  public void setDateDebutPeriodeActiviteReduite(Damj p_dateDebutPeriodeActiviteReduite)
  {
    m_dateDebutPeriodeActiviteReduite = p_dateDebutPeriodeActiviteReduite;
  }
  
  public BigDecimal getSjr()
  {
    return m_sjr;
  }
  
  public void setSjr(BigDecimal p_sjr)
  {
    m_sjr = p_sjr;
  }
  
  public IndividuSpec getIndividu()
  {
    return null;
  }
  
  public void setIndividu(IndividuSpec p_individu) {}
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public BigDecimal getMontant()
  {
    return m_montant;
  }
  
  public void setMontant(BigDecimal p_montant)
  {
    m_montant = p_montant;
  }
  
  public BigDecimal getMontantCrc()
  {
    return m_montantCrc;
  }
  
  public void setMontantCrc(BigDecimal p_montantCrc)
  {
    m_montantCrc = p_montantCrc;
  }
  
  public BigDecimal getMontantCrds()
  {
    return m_montantCrds;
  }
  
  public void setMontantCrds(BigDecimal p_montantCrds)
  {
    m_montantCrds = p_montantCrds;
  }
  
  public BigDecimal getMontantCsg()
  {
    return m_montantCsg;
  }
  
  public void setMontantCsg(BigDecimal p_montantCsg)
  {
    m_montantCsg = p_montantCsg;
  }
  
  public BigDecimal getAllocationJournaliereInitiale()
  {
    return m_allocationJournaliereInitiale;
  }
  
  public void setAllocationJournaliereInitiale(BigDecimal p_allocationJournaliereInitiale)
  {
    m_allocationJournaliereInitiale = p_allocationJournaliereInitiale;
  }
  
  public BigDecimal getRemunerationReprise()
  {
    return m_remunerationReprise;
  }
  
  public void setRemunerationReprise(BigDecimal p_remunerationReprise)
  {
    m_remunerationReprise = p_remunerationReprise;
  }
  
  public BigDecimal getNbJoursDansMois()
  {
    return m_nbJoursDansMois;
  }
  
  public void setNbJoursDansMois(BigDecimal p_nbJoursDansMois)
  {
    m_nbJoursDansMois = p_nbJoursDansMois;
  }
  
  public BigDecimal getNbJoursAPayer()
  {
    return m_nbJoursAPayer;
  }
  
  public void setNbJoursAPayer(BigDecimal p_nbJoursAPayer)
  {
    m_nbJoursAPayer = p_nbJoursAPayer;
  }
  
  public BigDecimal getNbJoursDecaler()
  {
    return m_nbJoursDecaler;
  }
  
  public void setNbJoursDecaler(BigDecimal p_nbJoursDecaler)
  {
    m_nbJoursDecaler = p_nbJoursDecaler;
  }
}

/* Location:
 * Qualified Name:     DomSimulationCalculActiviteReduite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */