package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.util.Comparator;

public class ComparateurFormulaireSurDateDepotDecroissante
  implements Comparator, Serializable
{
  public int compare(Object p_objet1, Object p_objet2)
    throws ClassCastException
  {
    FormulaireSpec formulaire1 = (FormulaireSpec)p_objet1;
    FormulaireSpec formulaire2 = (FormulaireSpec)p_objet2;
    if ((formulaire1.getDateDepot() != null) && (formulaire2.getDateDepot() != null)) {
      return formulaire2.getDateDepot().compareTo(formulaire1.getDateDepot());
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     ComparateurFormulaireSurDateDepotDecroissante
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */