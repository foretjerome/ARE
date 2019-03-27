package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDateFinPeriode;
import fr.unedic.util.services.OutilFonctionnel;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import java.util.Iterator;

public class OutilChronologie
  implements OutilFonctionnel
{
  public static void supprimerPeriodeParIdentifiant(Chronologie p_chronologiePeriodes, PeriodeGaecSpec p_periode)
  {
    Iterator iter = p_chronologiePeriodes.iterer();
    while (iter.hasNext())
    {
      PeriodeGaecSpec periode = (PeriodeGaecSpec)iter.next();
      if ((periode.getClass().getName().equals(p_periode.getClass().getName())) && (periode.getIdentifiant().equals(p_periode.getIdentifiant())))
      {
        iter.remove();
        
        break;
      }
    }
  }
  
  public static boolean recherchePeriodeParIdentifiant(Chronologie p_chronologiePeriodes, PeriodeGaecSpec p_periode)
  {
    Iterator iter = p_chronologiePeriodes.iterer();
    boolean trouve = false;
    while (iter.hasNext())
    {
      PeriodeGaecSpec periode = (PeriodeGaecSpec)iter.next();
      if ((periode.getClass().getName().equals(p_periode.getClass().getName())) && (periode.getIdentifiant().equals(p_periode.getIdentifiant())))
      {
        trouve = true;
        
        break;
      }
    }
    return trouve;
  }
  
  public static boolean verifierDateFinPeriodeDansChronologie(Chronologie p_chrono, Damj p_dateFin)
  {
    return !p_chrono.copier(new FiltreDateFinPeriode(p_dateFin)).estVide();
  }
}

/* Location:
 * Qualified Name:     OutilChronologie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */