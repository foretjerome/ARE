package fr.unedic.cali.autresdoms.cohab.dom;

import fr.unedic.cali.autresdoms.cohab.dom.spec.TrimestreRetraiteSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenementDebut;

public class TrimestreRetraite
  extends ObjetChronoEvenementDebut
  implements TrimestreRetraiteSpec
{
  private Integer m_nombreTrimestre;
  
  public TrimestreRetraite() {}
  
  public TrimestreRetraite(Damj p_dateEvenement)
  {
    super(p_dateEvenement);
  }
  
  public TrimestreRetraite(Damj p_dateEvenement, Integer p_nombreTrimestre)
  {
    super(p_dateEvenement);
    m_nombreTrimestre = p_nombreTrimestre;
  }
  
  public Integer getNombreTrimestre()
  {
    return m_nombreTrimestre;
  }
  
  public void setNombreTrimestre(Integer p_nombreTrimestre)
  {
    m_nombreTrimestre = p_nombreTrimestre;
  }
  
  public String toString()
  {
    StringBuffer chaineRetour = new StringBuffer();
    
    chaineRetour.append("          date effet :" + getDateEffet() + "\n");
    chaineRetour.append("          nombre de trimestre : " + getNombreTrimestre() + "\n");
    
    return chaineRetour.toString();
  }
}

/* Location:
 * Qualified Name:     TrimestreRetraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */