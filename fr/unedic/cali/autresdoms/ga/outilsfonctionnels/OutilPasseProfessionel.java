package fr.unedic.cali.autresdoms.ga.outilsfonctionnels;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.temps.ChronologiePeriodes;

public class OutilPasseProfessionel
{
  public static ChronologiePeriodes trouverChronoPasseProfessionelAvecFiltrageDNJ(IndividuSpec p_individu)
  {
    ChronologiePeriodes chronoPeriodesGa = p_individu.getChronoPeriodePasseProfessionnel();
    chronoPeriodesGa = (ChronologiePeriodes)FiltragePourDeterminationDNJ.filtrer(chronoPeriodesGa, p_individu);
    return chronoPeriodesGa;
  }
}

/* Location:
 * Qualified Name:     OutilPasseProfessionel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */