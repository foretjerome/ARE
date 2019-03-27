package fr.unedic.cali.utilitaire.comparateurs;

import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.Damj;
import java.util.Comparator;

public class ComparateurDecisionCroissante
  implements Comparator<DecisionSpec>
{
  public int compare(DecisionSpec dec1, DecisionSpec dec2)
  {
    int comparaison = 0;
    DecisionSpec decision1 = dec1;
    DecisionSpec decision2 = dec2;
    Damj dateEffetDecision = decision1.getDateEffetDecision();
    Damj dateEffetDecisionParametre = decision2.getDateEffetDecision();
    
    comparaison = dateEffetDecision.compareTo(dateEffetDecisionParametre);
    if (comparaison == 0)
    {
      DemandeSpec demande1 = decision1.getDemande();
      DemandeSpec demande2 = decision2.getDemande();
      comparaison = demande1.compareTo(demande2);
    }
    return comparaison;
  }
}

/* Location:
 * Qualified Name:     ComparateurDecisionCroissante
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */