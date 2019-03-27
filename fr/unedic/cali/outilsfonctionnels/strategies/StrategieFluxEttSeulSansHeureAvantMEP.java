package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;
import java.math.BigDecimal;

public class StrategieFluxEttSeulSansHeureAvantMEP
  implements StrategieFluxEttSeulSansHeureSpec
{
  private static final int COEFFICIENT_MULTIPLICATEUR_HEURES_POUR_ETT = 5;
  
  public void determinerNombreHeureEttSeul(PeriodeActiviteEmploiCalcul p_periodeActiviteEmploiCalcul)
  {
    p_periodeActiviteEmploiCalcul.setNombreHeures(new BigDecimal(p_periodeActiviteEmploiCalcul.getDuree()).multiply(new BigDecimal(5)));
  }
}

/* Location:
 * Qualified Name:     StrategieFluxEttSeulSansHeureAvantMEP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */