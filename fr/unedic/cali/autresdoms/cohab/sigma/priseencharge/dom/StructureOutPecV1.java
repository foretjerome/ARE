package fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom.spec.StructureOutPecV1Spec;
import java.util.ArrayList;
import java.util.Collection;

public class StructureOutPecV1
  implements StructureOutPecV1Spec
{
  private Collection m_listePeriodesPec = new ArrayList();
  private Collection m_listePeriodesPecFusionnes = new ArrayList();
  
  public void ajouterPec(PeriodePriseEnChargeOut p_pec)
  {
    if (m_listePeriodesPec == null) {
      m_listePeriodesPec = new ArrayList();
    }
    m_listePeriodesPec.add(p_pec);
  }
  
  public Collection getListePeriodesPec()
  {
    return m_listePeriodesPec;
  }
  
  public void ajouterPecFusionnees(PeriodePriseEnChargeOut p_pec)
  {
    if (m_listePeriodesPecFusionnes == null) {
      m_listePeriodesPecFusionnes = new ArrayList();
    }
    m_listePeriodesPecFusionnes.add(p_pec);
  }
  
  public Collection getListePeriodesPecFusionnees()
  {
    return m_listePeriodesPecFusionnes;
  }
}

/* Location:
 * Qualified Name:     StructureOutPecV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */