package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.DemandeSpec;
import java.io.Serializable;
import java.util.Comparator;

public class ComparateurSurDateDeclenchementEtPrioriteDemande
  implements Comparator<DemandeSpec>, Serializable
{
  private static final long serialVersionUID = -5555534390386067921L;
  
  public int compare(DemandeSpec arg0, DemandeSpec arg1)
  {
    DemandeSpec demande1 = arg0;
    DemandeSpec demande2 = arg1;
    
    return demande1.compareTo(demande2);
  }
}

/* Location:
 * Qualified Name:     ComparateurSurDateDeclenchementEtPrioriteDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */