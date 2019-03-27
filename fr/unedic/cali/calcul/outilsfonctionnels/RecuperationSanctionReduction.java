package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.calcul.dom.periode.PeriodeSanctionReductionMontant;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalcul;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class RecuperationSanctionReduction
{
  public static BigDecimal recuperationCoefficientSanctionReductionADate(ChronologiePeriodes p_chronologiePeriodesSanctions, Damj p_date)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologieSanction = (ChronologiePeriodes)p_chronologiePeriodesSanctions.copie();
    BigDecimal coefficientSanctionReduction = new BigDecimal("1.00");
    
    chronologieSanction.iterer();
    while (chronologieSanction.encoreSuivant())
    {
      ObjetChronoPeriodeCalcul periodeSanction = (ObjetChronoPeriodeCalcul)chronologieSanction.elementSuivant();
      if (((periodeSanction instanceof PeriodeSanctionReductionMontant)) && (periodeSanction.getDateDebut().estAvant(p_date)) && (periodeSanction.getDateFin().estApresOuCoincideAvec(p_date))) {
        if (((PeriodeSanctionReductionMontant)periodeSanction).getCodeSanction().equals("R1")) {
          coefficientSanctionReduction = new BigDecimal("0.80");
        } else if (((PeriodeSanctionReductionMontant)periodeSanction).getCodeSanction().equals("R2")) {
          coefficientSanctionReduction = new BigDecimal("0.50");
        }
      }
    }
    return coefficientSanctionReduction;
  }
}

/* Location:
 * Qualified Name:     RecuperationSanctionReduction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */