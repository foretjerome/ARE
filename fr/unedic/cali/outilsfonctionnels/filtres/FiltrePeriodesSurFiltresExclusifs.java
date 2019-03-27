package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;

public class FiltrePeriodesSurFiltresExclusifs
  implements FiltreTemporel
{
  private ArrayList m_listeFiltres = new ArrayList();
  
  public boolean accepter(Temporel p_temporel)
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
  
  public void ajouterFiltre(FiltreTemporel p_filtre)
  {
    m_listeFiltres.add(p_filtre);
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodesSurFiltresExclusifs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */