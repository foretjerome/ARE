package fr.unedic.cali.parcours.occasionnel;

import fr.unedic.cali.dom.occasionnel.DomLireEltReex;
import fr.unedic.util.services.Resultat;

public class ResultatEltReex
  extends Resultat
{
  private static final long serialVersionUID = -7382150926856591909L;
  private DomLireEltReex m_dom;
  
  public DomLireEltReex getDomLireEltReex()
  {
    return m_dom;
  }
  
  public void setDomLireEltReex(DomLireEltReex p_dom)
  {
    m_dom = p_dom;
  }
}

/* Location:
 * Qualified Name:     ResultatEltReex
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */