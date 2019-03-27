package fr.unedic.cali.utilitaire.filtres.logiques;

import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;

public class FiltreNegation
  extends FiltreLogiqueAbstrait
{
  private static final long serialVersionUID = 1L;
  
  public FiltreNegation(FiltreTemporel p_filtre)
  {
    m_listeFiltres.add(p_filtre);
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    return !((FiltreTemporel)m_listeFiltres.get(0)).accepter(p_temporel);
  }
  
  public int getTypeElementManipule()
  {
    return -1;
  }
}

/* Location:
 * Qualified Name:     FiltreNegation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */