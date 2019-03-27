package fr.unedic.cali.dom;

import java.io.Serializable;

public abstract class EtatQuantiteDroit
  implements Serializable
{
  public static final int INACTIVE = 0;
  public static final int ACTIVE = 1;
  public static final int EPUISEE = 2;
  
  public abstract Object accepteVisiteur(VisiteurQuantiteDroit paramVisiteurQuantiteDroit);
  
  public abstract int getEtat();
  
  public String toString()
  {
    StringBuffer bufferRetour = new StringBuffer();
    
    String nomClasse = getClass().getName().substring(getClass().getName().lastIndexOf(".") + 1);
    bufferRetour.append(nomClasse);
    return bufferRetour.toString();
  }
}

/* Location:
 * Qualified Name:     EtatQuantiteDroit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */