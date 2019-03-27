package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;
import java.util.Collection;

public class DomAlimenterSyntheseDE
  extends DomCaliOptimise
  implements DomCali
{
  private Collection m_colReferenceExterneFormuliare;
  private ResultatAlimenterSyntheseDE m_resultatSyntheseDE;
  private ContexteService m_contexteService;
  private IndividuSpec m_individu;
  
  public Collection getColReferenceExterneFormuliare()
  {
    return m_colReferenceExterneFormuliare;
  }
  
  public void setColReferenceExterneFormuliare(Collection p_colReferenceExterneFormuliare)
  {
    m_colReferenceExterneFormuliare = p_colReferenceExterneFormuliare;
  }
  
  public ResultatAlimenterSyntheseDE getResultatSyntheseDE()
  {
    return m_resultatSyntheseDE;
  }
  
  public void setResultatSyntheseDE(ResultatAlimenterSyntheseDE p_resultatSyntheseDE)
  {
    m_resultatSyntheseDE = p_resultatSyntheseDE;
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
}

/* Location:
 * Qualified Name:     DomAlimenterSyntheseDE
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */