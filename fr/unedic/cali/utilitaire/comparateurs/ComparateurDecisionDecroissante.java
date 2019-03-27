package fr.unedic.cali.utilitaire.comparateurs;

import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.util.Comparator;

public class ComparateurDecisionDecroissante
  implements Comparator<DecisionSpec>, Serializable
{
  private static final long serialVersionUID = -5537883702302563755L;
  
  public int compare(DecisionSpec o1, DecisionSpec o2)
  {
    int comparaison = 0;
    DecisionSpec decision1 = o1;
    DecisionSpec decision2 = o2;
    Damj dateEffetDecision = decision1.getDateEffetDecision();
    Damj dateEffetDecisionParametre = decision2.getDateEffetDecision();
    
    comparaison = dateEffetDecisionParametre.compareTo(dateEffetDecision);
    if (comparaison == 0)
    {
      DemandeSpec demande1 = decision1.getDemande();
      DemandeSpec demande2 = decision2.getDemande();
      comparaison = demande2.compareTo(demande1);
    }
    return comparaison;
  }
}

/* Location:
 * Qualified Name:     ComparateurDecisionDecroissante
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */