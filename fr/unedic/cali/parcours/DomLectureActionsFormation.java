package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;

public class DomLectureActionsFormation
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu;
  private ContexteService m_contexteService;
  private String m_idActionFormationLiee;
  private boolean m_appelParEcranLiaison;
  private String m_idDemandeRbf;
  
  public boolean isAppelParEcranLiaison()
  {
    return m_appelParEcranLiaison;
  }
  
  public void setAppelParEcranLiaison(boolean p_appelParEcranLiaison)
  {
    m_appelParEcranLiaison = p_appelParEcranLiaison;
  }
  
  public String getIdActionFormationLiee()
  {
    return m_idActionFormationLiee;
  }
  
  public void setIdActionFormationLiee(String p_idActionFormationLiee)
  {
    m_idActionFormationLiee = p_idActionFormationLiee;
  }
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
  
  public String getIdDemandeRbf()
  {
    return m_idDemandeRbf;
  }
  
  public void setIdDemandeRbf(String p_idDemandeRbf)
  {
    m_idDemandeRbf = p_idDemandeRbf;
  }
}

/* Location:
 * Qualified Name:     DomLectureActionsFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */