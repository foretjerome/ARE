package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.util.List;

public class DomNotificationEvenement
  extends DomCaliOptimise
{
  private String m_identifiantAbonnement;
  private IndividuSpec m_individu;
  private List m_listePeriodesGaec;
  private ContexteService m_contexteService;
  private Damj m_dateEvenement;
  
  public List getListePeriodesGaec()
  {
    return m_listePeriodesGaec;
  }
  
  public void setListePeriodesGaec(List p_periodes)
  {
    m_listePeriodesGaec = p_periodes;
  }
  
  public String getIdentifiantAbonnement()
  {
    return m_identifiantAbonnement;
  }
  
  public void setIdentifiantAbonnement(String p_identifiantAbonnement)
  {
    m_identifiantAbonnement = p_identifiantAbonnement;
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
  
  public static ContexteService getContexteService(Contexte p_contexte)
  {
    return ((DomCali)p_contexte.getDonnees()).getContexteService();
  }
  
  public Damj getDateEvenement()
  {
    return m_dateEvenement;
  }
  
  public void setDateEvenement(Damj p_dateEvenement)
  {
    m_dateEvenement = p_dateEvenement;
  }
}

/* Location:
 * Qualified Name:     DomNotificationEvenement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */