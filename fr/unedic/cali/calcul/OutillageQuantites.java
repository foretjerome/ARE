package fr.unedic.cali.calcul;

import fr.unedic.cali.dom.QuantiteDroitSpec;
import fr.unedic.cali.dom.QuantiteIndemnisationSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class OutillageQuantites
{
  public static QuantiteIndemnisationSpec recupererPremiereQuantiteIndemnisationActive(Collection p_collectionQuantiteDroit)
  {
    QuantiteIndemnisationSpec retour = null;
    Iterator iterator = null;
    QuantiteDroitSpec quantite = null;
    if (p_collectionQuantiteDroit != null)
    {
      iterator = p_collectionQuantiteDroit.iterator();
      while (iterator.hasNext())
      {
        quantite = (QuantiteDroitSpec)iterator.next();
        if (((quantite instanceof QuantiteIndemnisationSpec)) && (quantite.getEtat() == 1)) {
          retour = (QuantiteIndemnisationSpec)quantite;
        }
      }
    }
    return retour;
  }
  
  public static QuantiteIndemnisationSpec recupererPremiereQuantiteIndemnisationActiveOuEpuisee(Collection p_collectionQuantiteDroit)
  {
    QuantiteIndemnisationSpec retour = null;
    Iterator iterator = null;
    QuantiteDroitSpec quantite = null;
    if (p_collectionQuantiteDroit != null)
    {
      iterator = p_collectionQuantiteDroit.iterator();
      while (iterator.hasNext())
      {
        quantite = (QuantiteDroitSpec)iterator.next();
        if (((quantite instanceof QuantiteIndemnisationSpec)) && ((quantite.getEtat() == 1) || (quantite.getEtat() == 2))) {
          retour = (QuantiteIndemnisationSpec)quantite;
        }
      }
    }
    return retour;
  }
  
  public static List recupererListeQuantiteDroitActives(Collection p_collectionQuantiteDroit)
  {
    List retour = new ArrayList();
    Iterator iterator = null;
    QuantiteDroitSpec quantite = null;
    if (p_collectionQuantiteDroit != null)
    {
      iterator = p_collectionQuantiteDroit.iterator();
      while (iterator.hasNext())
      {
        quantite = (QuantiteDroitSpec)iterator.next();
        if (quantite.getEtat() == 1) {
          retour.add(quantite);
        }
      }
    }
    return retour;
  }
  
  public static List recupererListeQuantiteIndemnisationActives(Collection p_collectionQuantiteDroit)
  {
    List retour = new ArrayList();
    Iterator iterator = null;
    QuantiteDroitSpec quantite = null;
    if (p_collectionQuantiteDroit != null)
    {
      iterator = p_collectionQuantiteDroit.iterator();
      while (iterator.hasNext())
      {
        quantite = (QuantiteDroitSpec)iterator.next();
        if (((quantite instanceof QuantiteIndemnisationSpec)) && (quantite.getEtat() == 1)) {
          retour.add(quantite);
        }
      }
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     OutillageQuantites
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */