package fr.unedic.cali.autresdoms.cohab.sigma.individu.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.spec.TrimestreRetraiteSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenementDebut;

public class TrimestreRetraite
  extends ObjetChronoEvenementDebut
  implements TrimestreRetraiteSpec
{
  private int m_nombreTrimestre = 0;
  private Damj m_dateCentTrimestres = null;
  
  public TrimestreRetraite() {}
  
  public TrimestreRetraite(Damj p_dateEvenement)
  {
    super(p_dateEvenement);
  }
  
  public Damj getDateValeurTrimestre()
  {
    return getDateEvenement();
  }
  
  public int getNombreTrimestre()
  {
    return m_nombreTrimestre;
  }
  
  public void setDateValeurTrimestre(Damj p_dateValeurTrimestre)
  {
    setDateEvenement(p_dateValeurTrimestre);
  }
  
  public void setNombreTrimestre(int p_nombreTrimestre)
  {
    m_nombreTrimestre = p_nombreTrimestre;
  }
  
  public String toString()
  {
    return getNombreTrimestre() + "(" + getDateValeurTrimestre() + ")";
  }
  
  public void setDateCentTrimestres(Damj p_dateCentTrimestres)
  {
    m_dateCentTrimestres = p_dateCentTrimestres;
  }
  
  public Damj getDateCentTrimestres()
  {
    return m_dateCentTrimestres;
  }
}

/* Location:
 * Qualified Name:     TrimestreRetraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */