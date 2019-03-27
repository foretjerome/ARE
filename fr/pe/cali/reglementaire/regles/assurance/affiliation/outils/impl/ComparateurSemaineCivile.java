package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.impl;

import fr.pe.cali.reglementaire.regles.assurance.affiliation.dom.SemaineCivile;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.Comparator;

class ComparateurSemaineCivile
  implements Comparator<SemaineCivile>
{
  public int compare(SemaineCivile o1, SemaineCivile o2)
  {
    return o2.getSemaineCivile().getDebut().compareTo(o1.getSemaineCivile().getDebut());
  }
}

/* Location:
 * Qualified Name:     ComparateurSemaineCivile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */