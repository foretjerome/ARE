package fr.unedic.cali.dom;

import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.temps.UniteDuree;
import java.math.BigDecimal;

public class ImputationMois
  extends Imputation
  implements Comparable
{
  public static final Unite UNITE_DEFAUT = UniteDuree.MOIS;
  
  public int compareTo(Object p_object)
  {
    ImputationMois monImputation = (ImputationMois)p_object;
    return getValeurResteAImputer().compareTo(monImputation.getValeurResteAImputer());
  }
  
  public BigDecimal getValeurResteAImputer()
  {
    return getResteAImputer().getValeur();
  }
  
  public void setResteAImputer(BigDecimal p_valeur)
  {
    setResteAImputer(new Quantite(p_valeur, UNITE_DEFAUT));
  }
}

/* Location:
 * Qualified Name:     ImputationMois
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */