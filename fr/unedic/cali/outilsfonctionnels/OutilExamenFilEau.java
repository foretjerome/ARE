package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreActiviteSalarieEtantFCT;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodeActiviteSalarieeE301NonFrontalier;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreFinApresOuCoincideAvecDate;
import fr.unedic.util.temps.FiltresTemporel;
import fr.unedic.util.temps.Temporel;

public class OutilExamenFilEau
{
  public static Damj getDateFctApresOuCoincideAvec(IndividuSpec p_individu, Damj p_dateEvenement)
  {
    Damj dateFct = null;
    
    FiltresTemporel filtre = new FiltresTemporel();
    
    filtre.ajouterFiltre(new FiltreActiviteSalarieEtantFCT());
    filtre.ajouterFiltre(new FiltreFinApresOuCoincideAvecDate(p_dateEvenement));
    
    filtre.ajouterFiltre(new FiltrePeriodeActiviteSalarieeE301NonFrontalier(false));
    
    Chronologie chronoPassePro = p_individu.getChronoPeriodePasseProfessionnelLiquidation().copier(filtre);
    
    chronoPassePro.setComparateur(new ComparateurTemporelSurDateFinCroissante());
    if (!chronoPassePro.estVide()) {
      dateFct = chronoPassePro.premierElement().getDateFin();
    }
    return dateFct;
  }
}

/* Location:
 * Qualified Name:     OutilExamenFilEau
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */