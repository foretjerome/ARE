package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class PeriodeServiceCivique
  extends PeriodeEvenementPersonnel
{
  private static final long serialVersionUID = 3866484511134812847L;
  private Periode m_periodeInitiale;
  
  protected PeriodeServiceCivique() {}
  
  public PeriodeServiceCivique(Damj p_debut, Damj p_fin)
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
    PeriodeServiceCivique copie = new PeriodeServiceCivique();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeServiceCivique copie = (PeriodeServiceCivique)p_copie;
    super.copieElements(copie);
    m_periodeInitiale = getPeriodeInitiale();
  }
}

/* Location:
 * Qualified Name:     PeriodeServiceCivique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */