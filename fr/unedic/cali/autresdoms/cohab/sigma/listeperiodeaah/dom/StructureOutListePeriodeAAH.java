package fr.unedic.cali.autresdoms.cohab.sigma.listeperiodeaah.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.listeperiodeaah.dom.spec.StructureOutListePeriodeAAHSpec;
import fr.unedic.cali.dom.PeriodeDroitAAH;
import java.util.ArrayList;
import java.util.Collection;

public class StructureOutListePeriodeAAH
  implements StructureOutListePeriodeAAHSpec
{
  private Collection<PeriodeDroitAAH> listePeriodeAAH = new ArrayList();
  
  public Collection<PeriodeDroitAAH> getListePeriodeAAH()
  {
    return listePeriodeAAH;
  }
  
  public void ajouterPeriodeAAH(PeriodeDroitAAH periodeDroitAAH)
  {
    if (listePeriodeAAH == null) {
      listePeriodeAAH = new ArrayList();
    }
    listePeriodeAAH.add(periodeDroitAAH);
  }
}

/* Location:
 * Qualified Name:     StructureOutListePeriodeAAH
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */