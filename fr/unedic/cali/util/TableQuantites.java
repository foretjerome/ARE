package fr.unedic.cali.util;

import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import java.util.Hashtable;

public class TableQuantites
  extends Hashtable
{
  public Quantite get(Unite p_unite)
  {
    return (Quantite)super.get(p_unite);
  }
  
  public void put(Quantite p_quantite)
  {
    super.put(p_quantite.getUnite(), p_quantite);
  }
}

/* Location:
 * Qualified Name:     TableQuantites
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */