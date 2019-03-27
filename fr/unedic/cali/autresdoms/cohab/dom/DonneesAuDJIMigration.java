package fr.unedic.cali.autresdoms.cohab.dom;

import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class DonneesAuDJIMigration
{
  private Damj m_dji;
  private BigDecimal m_qteIndemnisee;
  private Quantite m_reliquatAuDJI;
  private Integer m_cumulHeureAuDJI;
  private Integer m_cumulMoisAuDJI;
  private BigDecimal m_nbJourDecalage;
  private Quantite m_montantJourBrutDJI;
  private Damj m_moisEcart;
  private Integer m_nbMoisInactivite;
  
  public Integer getCumulHeureAuDJI()
  {
    return m_cumulHeureAuDJI;
  }
  
  public void setCumulHeureAuDJI(Integer p_cumulHeureAuDJI)
  {
    m_cumulHeureAuDJI = p_cumulHeureAuDJI;
  }
  
  public Integer getCumulMoisAuDJI()
  {
    return m_cumulMoisAuDJI;
  }
  
  public void setCumulMoisAuDJI(Integer p_cumulMoisAuDJI)
  {
    m_cumulMoisAuDJI = p_cumulMoisAuDJI;
  }
  
  public Damj getDji()
  {
    return m_dji;
  }
  
  public void setDji(Damj p_dji)
  {
    m_dji = p_dji;
  }
  
  public Quantite getMontantJourBrutDJI()
  {
    return m_montantJourBrutDJI;
  }
  
  public void setMontantJourBrutDJI(Quantite p_montantJourBrutDJI)
  {
    m_montantJourBrutDJI = p_montantJourBrutDJI;
  }
  
  public BigDecimal getNbJourDecalage()
  {
    return m_nbJourDecalage;
  }
  
  public void setNbJourDecalage(BigDecimal p_nbJourDecalage)
  {
    m_nbJourDecalage = p_nbJourDecalage;
  }
  
  public BigDecimal getQteIndemnisee()
  {
    return m_qteIndemnisee;
  }
  
  public void setQteIndemnisee(BigDecimal p_qteIndemnisee)
  {
    m_qteIndemnisee = p_qteIndemnisee;
  }
  
  public Quantite getReliquatAuDJI()
  {
    return m_reliquatAuDJI;
  }
  
  public void setReliquatAuDJI(Quantite p_reliquatAuDJI)
  {
    m_reliquatAuDJI = p_reliquatAuDJI;
  }
  
  public Damj getMoisEcart()
  {
    return m_moisEcart;
  }
  
  public void setMoisEcart(Damj p_moisEcart)
  {
    m_moisEcart = p_moisEcart;
  }
  
  public Integer getNbMoisInactivite()
  {
    return m_nbMoisInactivite;
  }
  
  public void setNbMoisInactivite(Integer p_nbMoisInactivite)
  {
    m_nbMoisInactivite = p_nbMoisInactivite;
  }
}

/* Location:
 * Qualified Name:     DonneesAuDJIMigration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */