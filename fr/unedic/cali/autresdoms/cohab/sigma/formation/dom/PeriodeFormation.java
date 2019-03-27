package fr.unedic.cali.autresdoms.cohab.sigma.formation.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.formation.dom.spec.PeriodeFormationSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;

public class PeriodeFormation
  extends ObjetChronoPeriode
  implements PeriodeFormationSpec
{
  private int m_numeroPeriodeFormation;
  private Periode m_periodeEffective;
  private String m_typeMesureEmploi;
  
  public PeriodeFormation()
  {
    m_periodeEffective = new Periode();
  }
  
  public int getNumeroPeriodeFormation()
  {
    return m_numeroPeriodeFormation;
  }
  
  public Periode getPeriodeEffective()
  {
    return m_periodeEffective;
  }
  
  public void setPeriodeEffective(Periode p_periodeEffective)
  {
    m_periodeEffective = p_periodeEffective;
  }
  
  public void setNumeroPeriodeFormation(int p_numeroPeriodeFormation)
  {
    m_numeroPeriodeFormation = p_numeroPeriodeFormation;
  }
  
  public Damj getDateDebut()
  {
    Damj dateDebut = null;
    if (getPeriode() != null) {
      dateDebut = getPeriode().getDebut();
    }
    return dateDebut;
  }
  
  public Damj getDateFin()
  {
    Damj datefin = null;
    if (getPeriode() != null) {
      datefin = getPeriode().getFin();
    }
    return datefin;
  }
  
  public Periode getPeriode()
  {
    return m_periode;
  }
  
  public void setPeriode(Periode p_periode)
  {
    m_periode = p_periode;
  }
  
  public String getTypeMesureEmploi()
  {
    return m_typeMesureEmploi;
  }
  
  public void setTypeMesureEmploi(String p_mesureEmploi)
  {
    m_typeMesureEmploi = p_mesureEmploi;
  }
  
  public String toString()
  {
    return "\tPeriode de Formation n." + getNumeroPeriodeFormation() + " :\n\t\t" + "Date de Debut Prévue    : " + (getDateDebut() == null ? null : getDateDebut().formater()) + "\n\t\t" + "Date de Fin   Prévue    : " + (getDateFin() == null ? null : getDateFin().formater()) + "\n\t\t" + "Date de Debut Effective : " + ((getPeriodeEffective() == null) || (getPeriodeEffective().getDebut() == null) ? null : getPeriodeEffective().getDebut().formater()) + "\n\t\t" + "Date de Fin   Effective : " + ((getPeriodeEffective() == null) || (getPeriodeEffective().getFin() == null) ? null : getPeriodeEffective().getFin().formater());
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    throw new UnsupportedOperationException("La méthode copieElements(ObjetMetierSpec) n'est pas implémentée.");
  }
  
  public ObjetMetierSpec copie()
  {
    throw new UnsupportedOperationException("La méthode copie() n'est pas implémentée.");
  }
}

/* Location:
 * Qualified Name:     PeriodeFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */