package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeAllongementCSP
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel temporel)
  {
    return (temporel.estType(PeriodeActiviteEmploiCalcul.class)) && (((PeriodeActiviteEmploiCalcul)temporel).getInformationOrigine() == 1) && (((PeriodeActiviteEmploiCalcul)temporel).getPeriodeOrigine().getDuree() >= 3);
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeAllongementCSP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */