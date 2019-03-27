package fr.unedic.cali.dom;

import java.util.Comparator;

public class ComparateurReferenceExterne
  implements Comparator<FormulaireSpec>
{
  public int compare(FormulaireSpec o1, FormulaireSpec o2)
  {
    return o1.getReferenceExterne().compareTo(o2.getReferenceExterne());
  }
}

/* Location:
 * Qualified Name:     ComparateurReferenceExterne
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */