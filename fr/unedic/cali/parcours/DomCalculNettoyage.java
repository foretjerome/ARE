package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.util.Collection;

public class DomCalculNettoyage
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu = null;
  private Damj m_dateDebutNettoyage = null;
  private Collection m_listeDemandes = null;
  private Collection m_listesAttributionsInvalides;
  private ContexteService m_contexteService;
  private int m_contexteExecution = 0;
  
  public Damj getDateDebutNettoyage()
  {
    return m_dateDebutNettoyage;
  }
  
  public void setDateDebutNettoyage(Damj p_date)
  {
    m_dateDebutNettoyage = p_date;
  }
  
  public Collection getListeDemandes()
  {
    return m_listeDemandes;
  }
  
  public void setListeDemandes(Collection p_listeDemandes)
  {
    m_listeDemandes = p_listeDemandes;
  }
  
  public Collection getListeAttributionsInvalides()
  {
    return m_listesAttributionsInvalides;
  }
  
  public void setListeAttributionsInvalides(Collection p_listeAttributions)
  {
    m_listesAttributionsInvalides = p_listeAttributions;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public int getContexteExecution()
  {
    return m_contexteExecution;
  }
  
  public void setContexteExecution(int p_contexteExecution)
  {
    m_contexteExecution = p_contexteExecution;
  }
}

/* Location:
 * Qualified Name:     DomCalculNettoyage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */