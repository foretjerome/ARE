package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.calcul.dom.periode.PeriodePrime;
import fr.unedic.cali.calcul.outilsfonctionnels.filtres.FiltrePeriodePrimeCalcul;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public abstract class DefinitionStatutUtTraitementActiviteReduiteAbstraite
{
  public static BigDecimal calculGainPrimes(Periode periodeUt, ChronologiePeriodes periodesDecalantes)
    throws CoucheLogiqueException
  {
    BigDecimal cumulGainPrimes = BigDecimal.ZERO;
    if (periodeUt.getDebut().estApres(GestionnaireDateApplication.getInstance().recupererDateApplication("Determination du statut UT en RG")))
    {
      Chronologie periodesPrime = periodesDecalantes.copier(new FiltrePeriodePrimeCalcul());
      periodesPrime.iterer();
      while (periodesPrime.encoreSuivant())
      {
        PeriodePrime prime = (PeriodePrime)periodesPrime.elementSuivant();
        cumulGainPrimes = cumulGainPrimes.add(prime.getMontant().getValeur());
      }
    }
    return cumulGainPrimes;
  }
}

/* Location:
 * Qualified Name:     DefinitionStatutUtTraitementActiviteReduiteAbstraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */