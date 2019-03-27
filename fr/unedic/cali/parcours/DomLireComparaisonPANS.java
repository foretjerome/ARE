package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import java.util.List;

public class DomLireComparaisonPANS
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu;
  private ContexteService m_contexteService;
  private boolean m_comparerCali;
  private List m_listeAvantCalcul;
  private List m_listeApresCalcul;
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public static ContexteService getContexteService(Contexte p_contexte)
  {
    return ((DomReexecutionCali)p_contexte.getDonnees()).getContexteService();
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public boolean isComparerCali()
  {
    return m_comparerCali;
  }
  
  public void setComparerCali(boolean p_comparerCali)
  {
    m_comparerCali = p_comparerCali;
  }
  
  public List getListeApresCalcul()
  {
    return m_listeApresCalcul;
  }
  
  public void setListeApresCalcul(List p_listeApresCalcul)
  {
    m_listeApresCalcul = p_listeApresCalcul;
  }
  
  public List getListeAvantCalcul()
  {
    return m_listeAvantCalcul;
  }
  
  public void setListeAvantCalcul(List p_listeAvantCalcul)
  {
    m_listeAvantCalcul = p_listeAvantCalcul;
  }
}

/* Location:
 * Qualified Name:     DomLireComparaisonPANS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */