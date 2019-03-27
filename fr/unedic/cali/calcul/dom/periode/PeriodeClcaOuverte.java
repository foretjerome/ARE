package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class PeriodeClcaOuverte
  extends PeriodeEvenementPersonnel
{
  private BigDecimal m_intensite;
  public static final BigDecimal INTENSITE_TEMPS_PLEIN = new BigDecimal(1);
  
  protected PeriodeClcaOuverte() {}
  
  public PeriodeClcaOuverte(Damj p_debut)
  {
    super(p_debut, Damj.FIN_DES_TEMPS);
  }
  
  public BigDecimal getIntensite()
  {
    return m_intensite;
  }
  
  public void setIntensite(BigDecimal p_intensite)
  {
    m_intensite = p_intensite;
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeClcaOuverte copie = new PeriodeClcaOuverte();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodeClcaOuverte
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */