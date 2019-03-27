package fr.unedic.cali.autresdoms.cohab.parcours;

import fr.unedic.util.temps.Chronologie;
import java.math.BigDecimal;

public class DomReceptionFluxAR1E5A
  extends DomReceptionFluxV1
{
  private String m_idActionFormation;
  private BigDecimal m_montantGlobal;
  private BigDecimal m_montantACharge;
  private Chronologie m_chronologiePeriodesLieux;
  
  public String getIdActionFormation()
  {
    return m_idActionFormation;
  }
  
  public void setIdActionFormation(String p_idActionFormation)
  {
    m_idActionFormation = p_idActionFormation;
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
  
  public Chronologie getChronologiePeriodesLieux()
  {
    return m_chronologiePeriodesLieux;
  }
  
  public void setChronologiePeriodesLieux(Chronologie p_chronologiePeriodesLieux)
  {
    m_chronologiePeriodesLieux = p_chronologiePeriodesLieux;
  }
}

/* Location:
 * Qualified Name:     DomReceptionFluxAR1E5A
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */