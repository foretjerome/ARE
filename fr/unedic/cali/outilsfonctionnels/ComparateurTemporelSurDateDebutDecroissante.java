package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;
import java.util.Comparator;

public class ComparateurTemporelSurDateDebutDecroissante
  implements Comparator
{
  public int compare(Object p_objet1, Object p_objet2)
  {
    Temporel temporel1 = (Temporel)p_objet1;
    Temporel temporel2 = (Temporel)p_objet2;
    Damj dateDebut1 = temporel1.getDateDebut();
    Damj dateDebut2 = temporel2.getDateDebut();
    if (dateDebut1.estApres(dateDebut2)) {
      return -1;
    }
    if (dateDebut1.estAvant(dateDebut2)) {
      return 1;
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     ComparateurTemporelSurDateDebutDecroissante
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */