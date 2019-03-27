package fr.unedic.cali.parcours.occasionnel;

import fr.unedic.cali.dom.occasionnel.DomLireStatistiques;
import fr.unedic.util.services.Resultat;

public class ResultatChargerStatistiques
  extends Resultat
{
  private static final long serialVersionUID = 1L;
  private DomLireStatistiques m_dom = null;
  
  public DomLireStatistiques getDomLireStatistiques()
  {
    return m_dom;
  }
  
  public void setDomLireStatistiques(DomLireStatistiques p_dom)
  {
    m_dom = p_dom;
  }
}

/* Location:
 * Qualified Name:     ResultatChargerStatistiques
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */