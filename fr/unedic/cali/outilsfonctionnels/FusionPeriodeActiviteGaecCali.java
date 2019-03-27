package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.OutilFonctionnel;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Temporel;
import java.util.Collection;
import java.util.Iterator;

public class FusionPeriodeActiviteGaecCali
  implements OutilFonctionnel
{
  public static void miseAJourQualificationPeriode(ChronologiePeriodes p_chronoPeriodesGaec, Collection p_listePeriodesQualifiees, IndividuSpec p_individu)
  {
    if (p_chronoPeriodesGaec != null)
    {
      p_chronoPeriodesGaec.iterer();
      while (p_chronoPeriodesGaec.encoreSuivant())
      {
        Temporel periode = p_chronoPeriodesGaec.elementSuivant();
        if (periode.estType(ActiviteSalarie.class))
        {
          ActiviteSalarie periodeActiviteSalarieeAQualifier = (ActiviteSalarie)periode;
          
          Iterator iter = p_listePeriodesQualifiees.iterator();
          boolean periodeTrouvee = false;
          while ((!periodeTrouvee) && (iter.hasNext()))
          {
            ActiviteSalarie periodeQualifieeCourante = (ActiviteSalarie)iter.next();
            if (periodeActiviteSalarieeAQualifier.getIdentifiant().equals(periodeQualifieeCourante.getIdentifiant()))
            {
              periodeActiviteSalarieeAQualifier.setPeriodeActiviteSalarieCali(periodeQualifieeCourante.getPeriodeActiviteSalarieCali());
              
              periodeTrouvee = true;
            }
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     FusionPeriodeActiviteGaecCali
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */