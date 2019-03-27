package fr.pe.cali.reglementaire.regles.assurance.affiliation.dom;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.Comparator;

class ComparateurElementSemaineCivile
  implements Comparator<ElementSemaineCivile>
{
  public int compare(ElementSemaineCivile o1, ElementSemaineCivile o2)
  {
    return o2.getPeriodeContrat().getFin().compareTo(o1.getPeriodeContrat().getFin());
  }
}

/* Location:
 * Qualified Name:     ComparateurElementSemaineCivile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */