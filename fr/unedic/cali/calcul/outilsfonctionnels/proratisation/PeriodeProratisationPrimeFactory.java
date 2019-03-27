package fr.unedic.cali.calcul.outilsfonctionnels.proratisation;

import fr.unedic.cali.calcul.OutillagePeriodes;
import fr.unedic.cali.calcul.dom.periode.PeriodePrime;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;

public class PeriodeProratisationPrimeFactory
{
  public static ChronologiePeriodes decoupeEtProratise(Collection p_periodesPrime, Damj p_debut, Damj p_fin)
    throws CoucheLogiqueException
  {
    if (p_periodesPrime == null) {
      return null;
    }
    ChronologiePeriodes periodesARetourner = new ChronologiePeriodes();
    
    Iterator iterateurPrimes = p_periodesPrime.iterator();
    if ((p_debut != null) || (p_fin != null)) {}
    while (iterateurPrimes.hasNext())
    {
      PeriodePrime periodeProratise = decoupeEtProratise((PeriodePrime)iterateurPrimes.next(), p_debut, p_fin);
      if (periodeProratise != null) {
        periodesARetourner.ajouter(periodeProratise);
      }
      continue;
      while (iterateurPrimes.hasNext())
      {
        PeriodePrime periode = (PeriodePrime)iterateurPrimes.next();
        periodesARetourner.ajouter((Temporel)periode.copie());
      }
    }
    return periodesARetourner;
  }
  
  private static PeriodePrime decoupeEtProratise(PeriodePrime p_periodePrime, Damj p_debut, Damj p_fin)
  {
    PeriodePrime periode = (PeriodePrime)OutillagePeriodes.decoupe(p_periodePrime, p_debut, p_fin);
    if ((periode != null) && (periode.getDuree() > 0))
    {
      periode.setMontant(new QuantiteEuro(Mathematiques.proratiser(p_periodePrime.getMontant().getValeur(), new BigDecimal(Integer.toString(periode.getDuree())), new BigDecimal(Integer.toString(p_periodePrime.getDuree())))));
      
      periode.setMontant(new QuantiteEuro(periode.getMontant().getValeur().setScale(p_periodePrime.getMontant().getValeur().scale(), 6)));
      
      periode.setEstMigree(p_periodePrime.estMigree());
    }
    return periode;
  }
}

/* Location:
 * Qualified Name:     PeriodeProratisationPrimeFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */