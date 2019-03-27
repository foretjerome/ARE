package fr.unedic.cali.dom;

import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.UniteMonaitaire;

public class ImputationEuro
  extends Imputation
  implements Comparable
{
  public static final Unite UNITE_DEFAUT = UniteMonaitaire.EUROS;
  
  public int compareTo(Object p_object)
  {
    ImputationEuro monImputation = (ImputationEuro)p_object;
    return getValeurResteAImputer() - monImputation.getValeurResteAImputer();
  }
  
  public int getValeurResteAImputer()
  {
    return getResteAImputer().getValeurEntiere();
  }
  
  public void setResteAImputer(int p_valeur)
  {
    setResteAImputer(new Quantite(Integer.toString(p_valeur), UNITE_DEFAUT));
  }
}

/* Location:
 * Qualified Name:     ImputationEuro
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */