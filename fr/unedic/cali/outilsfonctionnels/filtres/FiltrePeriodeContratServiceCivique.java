package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeContratServiceCivique
  implements FiltreTemporel
{
  private static final long serialVersionUID = -3298100148902315374L;
  
  public boolean accepter(Temporel p_temporel)
  {
    boolean retour = false;
    if (p_temporel.estType(PeriodeEvenementPersonnel.class)) {
      switch (((PeriodeEvenementPersonnel)p_temporel).getNature())
      {
      case 44: 
      case 45: 
      case 46: 
      case 47: 
      case 48: 
        retour = true;
      }
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeContratServiceCivique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */