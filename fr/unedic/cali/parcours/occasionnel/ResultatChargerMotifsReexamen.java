package fr.unedic.cali.parcours.occasionnel;

import fr.unedic.cali.dom.occasionnel.DomLireMotifsReexamen;
import fr.unedic.util.services.Resultat;

public class ResultatChargerMotifsReexamen
  extends Resultat
{
  private static final long serialVersionUID = 1L;
  private DomLireMotifsReexamen m_dom = null;
  
  public DomLireMotifsReexamen getDomLireMotifsReexamen()
  {
    return m_dom;
  }
  
  public void setDomLireMotifsReexamen(DomLireMotifsReexamen p_dom)
  {
    m_dom = p_dom;
  }
}

/* Location:
 * Qualified Name:     ResultatChargerMotifsReexamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */