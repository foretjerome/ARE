package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.util.Comparator;

public class ComparateurSurDateFinAbonnementEtPrioriteDemande
  implements Comparator, Serializable
{
  public int compare(Object p_arg0, Object p_arg1)
  {
    DemandeSpec demande1 = (DemandeSpec)p_arg0;
    DemandeSpec demande2 = (DemandeSpec)p_arg1;
    
    Damj dateFinAbonnement1 = demande1.getDateFinAbonnement();
    Damj dateFinAbonnement2 = demande2.getDateFinAbonnement();
    if ((dateFinAbonnement1 == null) || (dateFinAbonnement2 == null)) {
      return 0;
    }
    int comparaison = dateFinAbonnement1.compareTo(dateFinAbonnement2);
    if (comparaison == 0)
    {
      Integer prioriteGamme1 = Integer.valueOf(demande1.getGamme().getPriorite());
      Integer prioriteGamme2 = Integer.valueOf(demande2.getGamme().getPriorite());
      
      comparaison = -prioriteGamme1.compareTo(prioriteGamme2);
    }
    if (comparaison == 0)
    {
      Integer prioriteERE1 = Integer.valueOf(demande1.getEvenementReferenceExamen().getPriorite());
      Integer prioriteERE2 = Integer.valueOf(demande2.getEvenementReferenceExamen().getPriorite());
      
      comparaison = -prioriteERE1.compareTo(prioriteERE2);
    }
    if (comparaison == 0)
    {
      Damj dateDepot1 = demande1.getDateDepot();
      Damj dateDepot2 = demande2.getDateDepot();
      if ((dateDepot1 != null) && (dateDepot2 != null)) {
        comparaison = dateDepot1.compareTo(dateDepot2);
      }
    }
    if (comparaison == 0)
    {
      Damj dateCreationDal1 = demande1.getFormulaire().getDateCreationDal();
      Damj dateCreationDal2 = demande2.getFormulaire().getDateCreationDal();
      if ((dateCreationDal1 != null) && (dateCreationDal2 != null)) {
        comparaison = dateCreationDal1.compareTo(dateCreationDal2);
      }
    }
    return comparaison;
  }
}

/* Location:
 * Qualified Name:     ComparateurSurDateFinAbonnementEtPrioriteDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */