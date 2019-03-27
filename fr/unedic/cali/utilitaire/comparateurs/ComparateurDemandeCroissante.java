package fr.unedic.cali.utilitaire.comparateurs;

import fr.unedic.cali.dom.DemandeSpec;
import java.util.Comparator;

public class ComparateurDemandeCroissante
  implements Comparator<DemandeSpec>
{
  public int compare(DemandeSpec dd1, DemandeSpec dd2)
  {
    DemandeSpec demande1 = dd1;
    DemandeSpec demande2 = dd2;
    return demande1.compareTo(demande2);
  }
}

/* Location:
 * Qualified Name:     ComparateurDemandeCroissante
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */