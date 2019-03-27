package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;
import java.util.Comparator;

public class ComparateurTemporelSurDateFinCroissante
  implements Comparator
{
  public int compare(Object p_objet1, Object p_objet2)
  {
    Temporel temporel1 = (Temporel)p_objet1;
    Temporel temporel2 = (Temporel)p_objet2;
    Damj dateFin1 = temporel1.getDateFin();
    Damj dateFin2 = temporel2.getDateFin();
    if (dateFin1.estApres(dateFin2)) {
      return 1;
    }
    if (dateFin1.estAvant(dateFin2)) {
      return -1;
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     ComparateurTemporelSurDateFinCroissante
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */