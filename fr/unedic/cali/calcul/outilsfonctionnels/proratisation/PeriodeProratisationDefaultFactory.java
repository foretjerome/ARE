package fr.unedic.cali.calcul.outilsfonctionnels.proratisation;

import fr.unedic.cali.calcul.OutillagePeriodes;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import java.util.Collection;
import java.util.Iterator;

public class PeriodeProratisationDefaultFactory
{
  public static ChronologiePeriodes decoupeEtProratise(Collection p_periodesActivite, Damj p_debut, Damj p_fin)
    throws CoucheLogiqueException
  {
    if (p_periodesActivite == null) {
      return null;
    }
    ChronologiePeriodes periodesARetourner = new ChronologiePeriodes();
    
    Iterator iterateurActivites = p_periodesActivite.iterator();
    if ((p_debut != null) || (p_fin != null)) {}
    while (iterateurActivites.hasNext())
    {
      ObjetChronoPeriode periodeTronquee = OutillagePeriodes.decoupe((ObjetChronoPeriode)iterateurActivites.next(), p_debut, p_fin);
      if (periodeTronquee != null) {
        periodesARetourner.ajouter(periodeTronquee);
      }
      continue;
      while (iterateurActivites.hasNext())
      {
        ObjetChronoPeriode periode = (ObjetChronoPeriode)iterateurActivites.next();
        periodesARetourner.ajouter((ObjetChronoPeriode)periode.copie());
      }
    }
    return periodesARetourner;
  }
}

/* Location:
 * Qualified Name:     PeriodeProratisationDefaultFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */