package fr.unedic.cali.dom.conteneurs;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class DonneesCalculMontantRfp
{
  private Damj m_dateEntreeEnStage = null;
  private BigDecimal m_sjrInitialForce = null;
  
  public DonneesCalculMontantRfp copie()
  {
    DonneesCalculMontantRfp copie = new DonneesCalculMontantRfp();
    copie.setDateEntreeEnStage(getDateEntreeEnStage());
    copie.setSjrInitialForce(getSjrInitialForce());
    return copie;
  }
  
  public Damj getDateEntreeEnStage()
  {
    return m_dateEntreeEnStage;
  }
  
  public void setDateEntreeEnStage(Damj p_dateEntreeEnStage)
  {
    m_dateEntreeEnStage = p_dateEntreeEnStage;
  }
  
  public BigDecimal getSjrInitialForce()
  {
    return m_sjrInitialForce;
  }
  
  public void setSjrInitialForce(BigDecimal p_sjrInitialForce)
  {
    m_sjrInitialForce = p_sjrInitialForce;
  }
}

/* Location:
 * Qualified Name:     DonneesCalculMontantRfp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */