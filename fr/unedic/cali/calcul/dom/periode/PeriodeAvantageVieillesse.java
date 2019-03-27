package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class PeriodeAvantageVieillesse
  extends PeriodePension
{
  public static final Damj DATE_BASCULE_AV = new Damj(1994, 10, 1);
  private Periode m_periodeInitiale;
  
  protected PeriodeAvantageVieillesse() {}
  
  public PeriodeAvantageVieillesse(Damj p_debut, Damj p_fin)
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
  
  public ObjetMetierSpec copie()
  {
    PeriodeAvantageVieillesse copie = new PeriodeAvantageVieillesse();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeAvantageVieillesse copie = (PeriodeAvantageVieillesse)p_copie;
    super.copieElements(copie);
    m_periodeInitiale = getPeriodeInitiale();
  }
}

/* Location:
 * Qualified Name:     PeriodeAvantageVieillesse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */