package fr.unedic.cali.outilsfonctionnels;

import java.util.HashMap;
import java.util.Map;

public abstract class ConstantesEnumeration
{
  private Map enumeration;
  private boolean estInitialise = false;
  
  protected abstract void initialiserEnumeration();
  
  private synchronized void initialiserSiBesoin()
  {
    if (!estInitialise)
    {
      estInitialise = true;
      initialiserEnumeration();
    }
  }
  
  protected Map getEnumeration()
  {
    if (enumeration == null) {
      enumeration = new HashMap();
    }
    return enumeration;
  }
  
  protected void ajouterElement(int numero, String libelle)
  {
    getEnumeration().put(Integer.valueOf(numero), libelle);
  }
  
  public String trouverLibelle(int numero)
  {
    initialiserSiBesoin();
    return (String)enumeration.get(Integer.valueOf(numero));
  }
}

/* Location:
 * Qualified Name:     ConstantesEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */