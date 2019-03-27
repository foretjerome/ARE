package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.Salaire;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.math.BigDecimal;

public class FiltrePeriodeSalaireAvecAbsence
  implements FiltreTemporel
{
  private static final long serialVersionUID = 7258045154739226003L;
  
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(Salaire.class)) && ((((Salaire)p_temporel).estExclus()) || ((((Salaire)p_temporel).getQuantiteAbsence() != null) && (((Salaire)p_temporel).getQuantiteAbsence().getValeur().compareTo(new BigDecimal("0")) > 0)));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeSalaireAvecAbsence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */