package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class PeriodeClca
  extends PeriodeEvenementPersonnel
{
  private static final long serialVersionUID = 1L;
  private Periode m_periodeInitiale;
  private BigDecimal m_intensite;
  public static final BigDecimal INTENSITE_TEMPS_PLEIN = new BigDecimal(1);
  
  protected PeriodeClca() {}
  
  public PeriodeClca(Damj p_debut, Damj p_fin)
  {
    super(p_debut, p_fin);
  }
  
  public Periode getPeriodeInitiale()
  {
    return m_periodeInitiale;
  }
  
  public void setPeriodeInitiale(Periode p_periodeInitiale)
  {
    m_periodeInitiale = p_periodeInitiale;
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
    PeriodeClca copie = new PeriodeClca();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeClca copie = (PeriodeClca)p_copie;
    super.copieElements(copie);
    m_periodeInitiale = getPeriodeInitiale();
  }
}

/* Location:
 * Qualified Name:     PeriodeClca
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */