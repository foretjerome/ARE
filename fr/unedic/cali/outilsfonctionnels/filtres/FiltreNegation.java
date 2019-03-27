package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreNegation
  implements FiltreTemporel
{
  FiltreTemporel m_filtre;
  
  public FiltreNegation(FiltreTemporel p_filtre)
  {
    m_filtre = p_filtre;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    if (m_filtre != null) {
      return !m_filtre.accepter(p_temporel);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreNegation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */