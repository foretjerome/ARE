package fr.unedic.cali.utilitaire.filtres.logiques;

import fr.unedic.cali.utilitaire.filtres.FiltreCaliSpec;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;

public class FiltreET
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
      FiltreCaliSpec filtreCourant = (FiltreCaliSpec)m_listeFiltres.get(i);
      if (!filtreCourant.accepter(p_temporel)) {
        return false;
      }
    }
    return true;
  }
  
  public int getTypeElementManipule()
  {
    return -1;
  }
}

/* Location:
 * Qualified Name:     FiltreET
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */