package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;
import fr.unedic.cali.outilsfonctionnels.ConvertisseurUniteAffiliation;
import fr.unedic.util.Quantite;
import fr.unedic.util.UniteAffiliation;

public class StrategieQuantiteAffiliationHeureAvecCachetAvantMEP09SI3
  implements StrategieQuantiteAffiliationHeureAvecCachetSpec
{
  public void determinerQuantiteAffiliationHeureAvecCachet(PeriodeActiviteEmploiCalcul p_periodeActiviteEmploiCalcul, Quantite p_quantiteAffiliationCachets)
  {
    p_periodeActiviteEmploiCalcul.setNombreHeures(p_quantiteAffiliationCachets.convertir(UniteAffiliation.HEURE_TRAVAIL, ConvertisseurUniteAffiliation.getInstance()).getValeur());
  }
}

/* Location:
 * Qualified Name:     StrategieQuantiteAffiliationHeureAvecCachetAvantMEP09SI3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */