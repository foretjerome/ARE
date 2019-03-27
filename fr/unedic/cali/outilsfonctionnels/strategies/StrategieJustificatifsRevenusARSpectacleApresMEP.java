package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;
import fr.unedic.util.Quantite;
import java.math.BigDecimal;

public class StrategieJustificatifsRevenusARSpectacleApresMEP
  implements StrategieJustificatifsRevenusARSpec
{
  public boolean verifierConditionsRevenus(PeriodeActiviteEmploiCalcul p_paec)
  {
    boolean conditionsRemplies = false;
    if ((p_paec.getInformationOrigine() == 2) && ((p_paec.getNombreHeures() == null) || (p_paec.getNombreHeures().compareTo(new BigDecimal(0)) == 0)) && ((p_paec.getQuantiteAbsences() == null) || (p_paec.getQuantiteAbsences().getValeur() == null) || (p_paec.getQuantiteAbsences().getValeur().compareTo(new BigDecimal(0)) == 0))) {
      conditionsRemplies = true;
    }
    return conditionsRemplies;
  }
}

/* Location:
 * Qualified Name:     StrategieJustificatifsRevenusARSpectacleApresMEP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */