package fr.unedic.cali.utilitaire.filtres.logiques;

import fr.unedic.cali.utilitaire.filtres.FiltreCaliSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;

public class FiltreOU
  extends FiltreLogiqueAbstrait
{
  private static final long serialVersionUID = 1L;
  
  public void ajouterFiltre(FiltreCaliSpec p_filtre)
  {
    m_listeFiltres.add(p_filtre);
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    for (int i = 0; i < m_listeFiltres.size(); i++)
    {
      FiltreTemporel filtreCourant = (FiltreTemporel)m_listeFiltres.get(i);
      if (filtreCourant.accepter(p_temporel)) {
        return true;
      }
    }
    return false;
  }
  
  public int getTypeElementManipule()
  {
    return -1;
  }
}

/* Location:
 * Qualified Name:     FiltreOU
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */