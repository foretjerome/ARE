package fr.unedic.cali.calcul.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;
import fr.unedic.cali.calcul.dom.periode.PeriodeTravail;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeTravailCalculCIRMA
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel p_temporel)
  {
    return ((p_temporel instanceof PeriodeTravail)) && ((p_temporel instanceof PeriodeActiviteEmploiCalcul)) && (((PeriodeActiviteEmploiCalcul)p_temporel).getTypeContratParticulier() == 22);
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeTravailCalculCIRMA
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */