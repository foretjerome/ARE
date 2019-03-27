package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.Prime;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePrimesExclues
  implements FiltreTemporel
{
  private boolean m_etatGarde = false;
  
  public FiltrePrimesExclues(boolean p_etat)
  {
    m_etatGarde = p_etat;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    if ((p_temporel instanceof Prime)) {
      return ((Prime)p_temporel).estPrimeExclue() == m_etatGarde;
    }
    return false;
  }
  
  public boolean getTypePrimesAGarder()
  {
    return m_etatGarde;
  }
  
  public void setTypePrimesAGarder(boolean p_etatGarde)
  {
    m_etatGarde = p_etatGarde;
  }
}

/* Location:
 * Qualified Name:     FiltrePrimesExclues
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */