package fr.unedic.cali.parcours.occasionnel;

import fr.unedic.cali.dom.occasionnel.DomLireRapport;
import fr.unedic.util.services.Resultat;

public class ResultatLireRapports
  extends Resultat
{
  private static final long serialVersionUID = -2058863711633771128L;
  private DomLireRapport m_dom = null;
  
  public DomLireRapport getDomLireRapport()
  {
    return m_dom;
  }
  
  public void setDomLireRapport(DomLireRapport p_dom)
  {
    m_dom = p_dom;
  }
}

/* Location:
 * Qualified Name:     ResultatLireRapports
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */