package fr.unedic.cali.autresdoms.cohab.sigma.pension.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.StructureIn;
import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.spec.AvantageVieillesseSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.spec.PensionInvaliditeSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.spec.StructureOutPensionV1Spec;
import java.util.ArrayList;
import java.util.Collection;

public class StructureOutPension
  extends StructureIn
  implements StructureOutPensionV1Spec
{
  private Collection m_listeAvantageVieillesse = new ArrayList();
  private Collection m_listePensionInvalidite = new ArrayList();
  
  public void ajouterAvantageVieillesse(AvantageVieillesseSpec p_avantageVieillesse) {}
  
  public Collection getListeAvantageVieillesse()
  {
    return m_listeAvantageVieillesse;
  }
  
  public String toString()
  {
    return getListeAvantageVieillesse().toString();
  }
  
  public void ajouterPensionInvalidite(PensionInvaliditeSpec p_pensionInvalidite)
  {
    m_listePensionInvalidite.add(p_pensionInvalidite);
  }
  
  public Collection getListePensionInvalidite()
  {
    return getListePensionInvalidite();
  }
}

/* Location:
 * Qualified Name:     StructureOutPension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */