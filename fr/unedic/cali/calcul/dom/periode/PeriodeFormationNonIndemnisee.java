package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Periode;

public class PeriodeFormationNonIndemnisee
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -2920296546658738778L;
  private Quantite m_dureeTotale;
  private boolean m_estRemuneree;
  private Periode m_periodeInitiale;
  
  protected PeriodeFormationNonIndemnisee() {}
  
  public PeriodeFormationNonIndemnisee(PeriodeFormation p_periodeFormation)
  {
    super(p_periodeFormation.getDateDebut(), p_periodeFormation.getDateFin());
    setDureeTotale(p_periodeFormation.getDureeTotale());
    setEstRemuneree(p_periodeFormation.getOrigineRemuneration() != 5);
  }
  
  public Quantite getDureeTotale()
  {
    return m_dureeTotale;
  }
  
  private void setDureeTotale(Quantite p_dureeTotale)
  {
    m_dureeTotale = p_dureeTotale;
  }
  
  public boolean estRemuneree()
  {
    return m_estRemuneree;
  }
  
  public void setEstRemuneree(boolean p_estRemuneree)
  {
    m_estRemuneree = p_estRemuneree;
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
    PeriodeFormationNonIndemnisee copie = new PeriodeFormationNonIndemnisee();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeFormationNonIndemnisee copie = (PeriodeFormationNonIndemnisee)p_copie;
    super.copieElements(copie);
    m_dureeTotale = getDureeTotale();
    m_estRemuneree = estRemuneree();
    m_periodeInitiale = getPeriodeInitiale();
  }
}

/* Location:
 * Qualified Name:     PeriodeFormationNonIndemnisee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */