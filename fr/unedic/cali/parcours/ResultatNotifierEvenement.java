package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndicateursGeneriques;
import fr.unedic.util.services.Resultat;

public class ResultatNotifierEvenement
  extends Resultat
{
  private IndicateursGeneriques m_indicateursGeneriques;
  
  public IndicateursGeneriques getIndicateursGeneriques()
  {
    return m_indicateursGeneriques;
  }
  
  public void setIndicateursGeneriques(IndicateursGeneriques p_indicateursGeneriques)
  {
    m_indicateursGeneriques = p_indicateursGeneriques;
  }
}

/* Location:
 * Qualified Name:     ResultatNotifierEvenement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */