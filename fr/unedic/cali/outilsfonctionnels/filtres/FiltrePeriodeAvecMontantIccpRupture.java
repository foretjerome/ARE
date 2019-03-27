package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.FiltresTemporel;
import fr.unedic.util.temps.Temporel;
import java.math.BigDecimal;

public class FiltrePeriodeAvecMontantIccpRupture
  extends FiltresTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel p_temporel)
  {
    QuantiteEuro quantiteEuroIccpCourante = ((ActiviteSalarie)p_temporel).getQuantiteEuroIccp();
    if ((quantiteEuroIccpCourante != null) && (quantiteEuroIccpCourante.getValeurMontant() != null) && (quantiteEuroIccpCourante.getValeurMontant().compareTo(new BigDecimal("0")) > 0)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeAvecMontantIccpRupture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */