package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.ElementComparaisonReexamen;
import java.util.Date;
import java.util.GregorianCalendar;

public class OutilComparateurDecision
{
  public static final String VALEUR_SANS_OBJET = "Sans objet";
  
  public static ElementComparaisonReexamen creerDifferenceSystematique()
  {
    String valeurAvant = "Sans objet";
    GregorianCalendar dateDuJour = new GregorianCalendar();
    String valeurApres = dateDuJour.getTime().toString();
    
    ElementComparaisonReexamen elementDecision = new ElementComparaisonReexamen("Date // Heure de liquidation", valeurAvant, valeurApres);
    
    return elementDecision;
  }
}

/* Location:
 * Qualified Name:     OutilComparateurDecision
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */