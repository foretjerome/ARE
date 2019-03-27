package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.Salaire;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeSalaireExclu
  implements FiltreTemporel
{
  private static final long serialVersionUID = 4864299040672021816L;
  
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(Salaire.class)) && (((Salaire)p_temporel).estExclus());
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeSalaireExclu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */