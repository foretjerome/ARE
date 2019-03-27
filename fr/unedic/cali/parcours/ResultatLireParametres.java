package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.DomLireParametres;
import fr.unedic.util.services.Resultat;

public class ResultatLireParametres
  extends Resultat
{
  private DomLireParametres m_dom = null;
  
  public DomLireParametres getDomLireParametres()
  {
    return m_dom;
  }
  
  public void setDomLireParametres(DomLireParametres p_dom)
  {
    m_dom = p_dom;
  }
}

/* Location:
 * Qualified Name:     ResultatLireParametres
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */