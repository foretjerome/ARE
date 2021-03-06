package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.io.Serializable;

public class FiltreDateDebutPosterieurDate
  implements FiltreTemporel, Serializable
{
  private Damj m_dateComparaison;
  
  public FiltreDateDebutPosterieurDate(Damj p_dateComparaison)
  {
    m_dateComparaison = p_dateComparaison;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return p_temporel.getDateDebut().estApresOuCoincideAvec(m_dateComparaison);
  }
}

/* Location:
 * Qualified Name:     FiltreDateDebutPosterieurDate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */