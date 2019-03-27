package fr.unedic.cali.dom;

import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Periode;

public class PeriodeQuantite
{
  private Periode m_periode;
  private Quantite m_quantite;
  
  public PeriodeQuantite() {}
  
  public PeriodeQuantite(Periode p_periode, Quantite p_quantite)
  {
    m_periode = p_periode;
    m_quantite = p_quantite;
  }
  
  public Periode getPeriode()
  {
    return m_periode;
  }
  
  public void setPeriode(Periode p_periode)
  {
    m_periode = p_periode;
  }
  
  public Quantite getQuantite()
  {
    return m_quantite;
  }
  
  public void setQuantite(Quantite p_quantite)
  {
    m_quantite = p_quantite;
  }
}

/* Location:
 * Qualified Name:     PeriodeQuantite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */