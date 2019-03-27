package fr.unedic.cali.autresdoms.cohab.sigma.pension.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.spec.AvantageVieillesseSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.spec.PensionInvaliditeSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.spec.PensionSpec;
import java.util.ArrayList;
import java.util.Collection;

public class Pension
  implements PensionSpec
{
  private ArrayList m_listePensionInvalidite = new ArrayList();
  private ArrayList m_listeAvantageVieillesse = new ArrayList();
  
  public Collection getListePensionInvalidite()
  {
    return m_listePensionInvalidite;
  }
  
  public void ajouterAvantageVieillesse(AvantageVieillesseSpec p_avantageVieillesse)
  {
    m_listeAvantageVieillesse.add(p_avantageVieillesse);
  }
  
  public Collection getListeAvantageVieillesse()
  {
    return m_listeAvantageVieillesse;
  }
  
  public void ajouterPensionInvalidite(PensionInvaliditeSpec p_pensionInvalidite)
  {
    m_listePensionInvalidite.add(p_pensionInvalidite);
  }
}

/* Location:
 * Qualified Name:     Pension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */