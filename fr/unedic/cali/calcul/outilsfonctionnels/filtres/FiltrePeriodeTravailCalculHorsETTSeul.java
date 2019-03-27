package fr.unedic.cali.calcul.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.math.BigDecimal;
import java.util.List;

public class FiltrePeriodeTravailCalculHorsETTSeul
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    if (((p_temporel instanceof PeriodeActiviteEmploiCalcul)) && 
      (((PeriodeActiviteEmploiCalcul)p_temporel).getListeInformationOrigine().size() == 1) && 
      (((PeriodeActiviteEmploiCalcul)p_temporel).getListeInformationOrigine().contains(new BigDecimal(16)))) {
      return false;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeTravailCalculHorsETTSeul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */