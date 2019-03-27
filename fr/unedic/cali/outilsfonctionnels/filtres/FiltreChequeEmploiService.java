package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ChequeEmploiService;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreChequeEmploiService
  implements FiltreTemporel
{
  private static final long serialVersionUID = 5010305203071075546L;
  
  public boolean accepter(Temporel p_temporel)
  {
    return p_temporel.estType(ChequeEmploiService.class);
  }
}

/* Location:
 * Qualified Name:     FiltreChequeEmploiService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */