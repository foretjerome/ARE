package fr.unedic.cali.parcours;

import fr.unedic.cali.autresdoms.d90.dom.Individu;
import fr.unedic.cali.autresdoms.d90.dom.spec.RedressementSpec;
import java.util.ArrayList;
import java.util.List;

public class ResultatVisualisationSelection
{
  private RedressementSpec m_redressementSpec;
  private List m_listeIndividusSelectionnes;
  
  public ResultatVisualisationSelection()
  {
    m_listeIndividusSelectionnes = new ArrayList();
  }
  
  public List getListeIndividusSelectionnes()
  {
    return m_listeIndividusSelectionnes;
  }
  
  public void setListeIndividusSelectionnes(List p_listeIndividusSelectionnes)
  {
    m_listeIndividusSelectionnes = p_listeIndividusSelectionnes;
  }
  
  public RedressementSpec getRedressementSpec()
  {
    return m_redressementSpec;
  }
  
  public void setRedressementSpec(RedressementSpec p_redressementSpec)
  {
    m_redressementSpec = p_redressementSpec;
  }
  
  public void ajouterIndividu(Individu p_individu)
  {
    getListeIndividusSelectionnes().add(p_individu);
  }
}

/* Location:
 * Qualified Name:     ResultatVisualisationSelection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */