package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;
import fr.unedic.cali.outilsfonctionnels.ConvertisseurUniteAffiliation;
import fr.unedic.util.Quantite;
import fr.unedic.util.UniteAffiliation;
import java.math.BigDecimal;

public class StrategieQuantiteAffiliationHeureAvecCachetApresMEP09SI3
  implements StrategieQuantiteAffiliationHeureAvecCachetSpec
{
  private static final BigDecimal ZERO = new BigDecimal(0);
  
  public void determinerQuantiteAffiliationHeureAvecCachet(PeriodeActiviteEmploiCalcul periodeActiviteEmploiCalcul, Quantite quantiteAffiliationCachets)
  {
    BigDecimal nbHeures = periodeActiviteEmploiCalcul.getNombreHeures();
    if (nbHeures == null) {
      nbHeures = ZERO;
    }
    periodeActiviteEmploiCalcul.setNombreHeures(nbHeures.add(quantiteAffiliationCachets.convertir(UniteAffiliation.HEURE_TRAVAIL, ConvertisseurUniteAffiliation.getInstance()).getValeur()));
  }
}

/* Location:
 * Qualified Name:     StrategieQuantiteAffiliationHeureAvecCachetApresMEP09SI3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */