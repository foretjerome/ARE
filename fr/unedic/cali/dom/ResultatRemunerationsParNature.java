package fr.unedic.cali.dom;

import fr.unedic.archi.commun.util.HashMap;
import fr.unedic.util.Quantite;
import java.util.Map;

public class ResultatRemunerationsParNature
{
  public static final int NATURE_SALAIRE = 1;
  public static final int NATURE_PRIME_NORMALE = 2;
  public static final int NATURE_PRIME_EXCEPTIONNEL = 3;
  private Map resultatsRemuneration;
  
  public ResultatRemunerationsParNature()
  {
    resultatsRemuneration = new HashMap();
  }
  
  public void ajouterRemuneration(int nature, Quantite quantite)
  {
    resultatsRemuneration.put(Integer.valueOf(nature), quantite);
  }
  
  public Quantite recupererRemuneration(int nature)
  {
    return (Quantite)resultatsRemuneration.get(Integer.valueOf(nature));
  }
}

/* Location:
 * Qualified Name:     ResultatRemunerationsParNature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */