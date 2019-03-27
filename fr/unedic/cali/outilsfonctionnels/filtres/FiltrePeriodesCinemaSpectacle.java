package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.PeriodeActiviteSalarieCaliSpec;
import fr.unedic.cali.dom.affectation.ProduitAsuSpe02P01;
import fr.unedic.cali.dom.affectation.ProduitAsuSpe02P03;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodesCinemaSpectacle
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    Reglement reglement = null;
    if (p_temporel.estType(PeriodeActiviteSalarieCaliSpec.class))
    {
      reglement = ((PeriodeActiviteSalarieCaliSpec)p_temporel).getReglement();
      if (reglement != null)
      {
        if ((reglement.equals(ProduitAsuSpe02P01.getInstance().getReglement("A8"))) || (reglement.equals(ProduitAsuSpe02P01.getInstance().getReglement("A10"))) || (reglement.equals(ProduitAsuSpe02P03.getInstance().getReglement("A8"))) || (reglement.equals(ProduitAsuSpe02P03.getInstance().getReglement("A10")))) {
          return true;
        }
      }
      else {
        return false;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodesCinemaSpectacle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */