package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.occasionnel.DomLirePopulationsListe;
import fr.unedic.util.temps.Damj;
import java.util.Comparator;

public class ComparateurSurDatePassageDecroissante
  implements Comparator
{
  public int compare(Object p_objet1, Object p_objet2)
  {
    DomLirePopulationsListe temporel1 = (DomLirePopulationsListe)p_objet1;
    DomLirePopulationsListe temporel2 = (DomLirePopulationsListe)p_objet2;
    Damj dateFin1 = temporel1.getDatePassage();
    Damj dateFin2 = temporel2.getDatePassage();
    if (dateFin1.estApres(dateFin2)) {
      return -1;
    }
    if (dateFin1.estAvant(dateFin2)) {
      return 1;
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     ComparateurSurDatePassageDecroissante
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */