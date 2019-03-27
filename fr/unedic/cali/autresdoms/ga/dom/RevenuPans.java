package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import java.math.BigDecimal;

public class RevenuPans
  extends ObjetChronoPeriode
{
  private BigDecimal m_montant;
  
  public RevenuPans(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public RevenuPans(Damj p_dateDebut, Damj p_dateFin, BigDecimal p_montant)
  {
    super(p_dateDebut, p_dateFin);
    setMontant(p_montant);
  }
  
  public BigDecimal getMontant()
  {
    return m_montant;
  }
  
  public void setMontant(BigDecimal p_montant)
  {
    m_montant = p_montant;
  }
  
  public ObjetMetierSpec copie()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     RevenuPans
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */