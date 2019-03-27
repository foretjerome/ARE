package fr.unedic.cali.utilitaire.filtres.logiques;

import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliSpec;
import fr.unedic.util.temps.FiltreTemporel;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class FiltreLogiqueAbstrait
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  protected ArrayList<FiltreTemporel> m_listeFiltres = new ArrayList();
  
  public void initialiserCache()
  {
    super.initialiserCache();
    
    Iterator<FiltreTemporel> it = m_listeFiltres.iterator();
    while (it.hasNext()) {
      ((FiltreCaliSpec)it.next()).initialiserCache();
    }
  }
}

/* Location:
 * Qualified Name:     FiltreLogiqueAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */