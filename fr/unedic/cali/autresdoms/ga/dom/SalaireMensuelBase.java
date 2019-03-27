package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class SalaireMensuelBase
  extends ObjetChronoPeriode
{
  private static final long serialVersionUID = 2696506128102483487L;
  private BigDecimal m_montantSalaireMensuel;
  
  public ObjetMetierSpec copie()
  {
    return this;
  }
  
  public SalaireMensuelBase(Periode p_periode)
  {
    super(p_periode);
  }
  
  public BigDecimal getMontantSalaireMensuel()
  {
    return m_montantSalaireMensuel;
  }
  
  public void setMontantSalaireMensuel(BigDecimal p_montantSalaireMensuel)
  {
    m_montantSalaireMensuel = p_montantSalaireMensuel;
  }
}

/* Location:
 * Qualified Name:     SalaireMensuelBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */