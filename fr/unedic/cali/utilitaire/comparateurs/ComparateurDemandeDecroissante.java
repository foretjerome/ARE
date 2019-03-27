package fr.unedic.cali.utilitaire.comparateurs;

import fr.unedic.cali.dom.DemandeSpec;
import java.io.Serializable;
import java.util.Comparator;

public class ComparateurDemandeDecroissante
  implements Comparator<DemandeSpec>, Serializable
{
  private static final long serialVersionUID = 1L;
  
  public int compare(DemandeSpec arg0, DemandeSpec arg1)
  {
    DemandeSpec demande1 = arg0;
    DemandeSpec demande2 = arg1;
    return demande2.compareTo(demande1);
  }
}

/* Location:
 * Qualified Name:     ComparateurDemandeDecroissante
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */