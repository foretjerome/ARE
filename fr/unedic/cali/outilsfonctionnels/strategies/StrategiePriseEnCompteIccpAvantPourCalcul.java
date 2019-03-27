package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.autresdoms.ga.dom.Salaire;
import fr.unedic.cali.autresdoms.ga.dom.TravailSalarie;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteEuro;
import java.math.BigDecimal;

public class StrategiePriseEnCompteIccpAvantPourCalcul
  implements StrategiePriseEnCompteIccpSpec
{
  public boolean paecACreerSurFctSiAbsenceSalaire()
  {
    return false;
  }
  
  private static final BigDecimal ZERO = new BigDecimal("0");
  
  public BigDecimal determinerMontantIccpALaFct(TravailSalarie p_periodeActivite, Salaire p_periodeSalaire)
  {
    BigDecimal montantIccp = null;
    if ((p_periodeSalaire.getMontantIccp() != null) && (!p_periodeSalaire.getMontantIccp().getValeur().equals(ZERO)))
    {
      montantIccp = p_periodeSalaire.getMontantIccp().getValeur();
    }
    else
    {
      BigDecimal tauxIccp = p_periodeSalaire.getTauxIccp();
      BigDecimal gain = p_periodeSalaire.getMontantSoumisAContribution().getValeur();
      if ((tauxIccp != null) && (!tauxIccp.equals(ZERO))) {
        montantIccp = Mathematiques.tronque(gain.multiply(tauxIccp), 2);
      }
    }
    return montantIccp;
  }
}

/* Location:
 * Qualified Name:     StrategiePriseEnCompteIccpAvantPourCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */