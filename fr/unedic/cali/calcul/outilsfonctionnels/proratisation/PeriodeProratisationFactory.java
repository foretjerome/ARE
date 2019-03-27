package fr.unedic.cali.calcul.outilsfonctionnels.proratisation;

import fr.unedic.cali.calcul.dom.periode.PeriodePrime;
import fr.unedic.cali.calcul.dom.periode.PeriodeTravail;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Periode;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class PeriodeProratisationFactory
{
  public static ChronologiePeriodes decoupeEtProratiseParDefaut(ChronologiePeriodes p_periodesActivite, Periode p_periode)
    throws CoucheLogiqueException
  {
    return PeriodeProratisationDefaultFactory.decoupeEtProratise(p_periodesActivite.mapperVersCollection(), p_periode.getDebut(), p_periode.getFin());
  }
  
  public static ChronologiePeriodes decoupeEtProratiseParType(ChronologiePeriodes p_periodesActivite, Periode p_periode)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologieARetourner = new ChronologiePeriodes();
    if ((p_periodesActivite != null) && (!p_periodesActivite.estVide()))
    {
      Iterator iterateur = p_periodesActivite.iterer();
      
      Collection collectionPeriodesTravail = new Vector();
      Collection collectionPeriodesPrime = new Vector();
      Collection collectionPeriodesDefault = new Vector();
      while (iterateur.hasNext())
      {
        ObjetChronoPeriodeCalculSpec periode = (ObjetChronoPeriodeCalculSpec)iterateur.next();
        if ((periode instanceof PeriodeTravail)) {
          collectionPeriodesTravail.add(periode);
        } else if ((periode instanceof PeriodePrime)) {
          collectionPeriodesPrime.add(periode);
        } else {
          collectionPeriodesDefault.add(periode);
        }
      }
      ChronologiePeriodes chrono = PeriodeProratisationTravailFactory.decoupeEtProratise(collectionPeriodesTravail, p_periode.getDebut(), p_periode.getFin());
      if (chrono != null) {
        chronologieARetourner.ajouter(chrono);
      }
      chrono = PeriodeProratisationPrimeFactory.decoupeEtProratise(collectionPeriodesPrime, p_periode.getDebut(), p_periode.getFin());
      if (chrono != null) {
        chronologieARetourner.ajouter(chrono);
      }
      chrono = PeriodeProratisationDefaultFactory.decoupeEtProratise(collectionPeriodesDefault, p_periode.getDebut(), p_periode.getFin());
      if (chrono != null) {
        chronologieARetourner.ajouter(chrono);
      }
    }
    return chronologieARetourner;
  }
}

/* Location:
 * Qualified Name:     PeriodeProratisationFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */