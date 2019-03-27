package fr.unedic.cali.utilitaire.comparateurs;

import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.dom.pivot.Decision;
import fr.unedic.cali.outilsfonctionnels.ConstructionCSOIA;
import fr.unedic.util.temps.Damj;
import java.util.Comparator;

public class ComparateurDecisionPivotAssuranceDecroissante
  implements Comparator<Decision>
{
  public int compare(Decision o1, Decision o2)
  {
    Damj dateEffet1 = o1.getDateEffetDecision();
    Damj dateEffet2 = o2.getDateEffetDecision();
    
    int comparaison = dateEffet2.compareTo(dateEffet1);
    if (comparaison == 0)
    {
      String typeExamen1 = recupererTypeExamen(o1.getTypeExamen());
      String typeExamen2 = recupererTypeExamen(o2.getTypeExamen());
      Integer prioriteEre1 = recuperePrioriteEre(typeExamen1);
      Integer prioriteEre2 = recuperePrioriteEre(typeExamen2);
      comparaison = prioriteEre1.compareTo(prioriteEre2);
    }
    return comparaison;
  }
  
  private String recupererTypeExamen(String typeExamenV2)
  {
    String typeExamenV1 = ConstructionCSOIA.recupererTypeExamenDepuisCsoiaPourGamme(typeExamenV2, "ASU");
    if ("".equals(typeExamenV1)) {
      typeExamenV1 = ConstructionCSOIA.recupererTypeExamenDepuisCsoiaPourGamme(typeExamenV2, "ARI");
    }
    return typeExamenV1;
  }
  
  private Integer recuperePrioriteEre(String typeExamenV1)
  {
    Integer prioriteEre;
    Integer prioriteEre;
    if ("ARI_01".equals(typeExamenV1)) {
      prioriteEre = Integer.valueOf(17);
    } else {
      prioriteEre = Integer.valueOf(GammeAsu.getInstance().recupererEvenementReferenceExamen(typeExamenV1).getPriorite());
    }
    return prioriteEre;
  }
}

/* Location:
 * Qualified Name:     ComparateurDecisionPivotAssuranceDecroissante
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */