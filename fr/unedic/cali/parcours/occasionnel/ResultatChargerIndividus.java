package fr.unedic.cali.parcours.occasionnel;

import fr.unedic.cali.dom.occasionnel.DomLireIndividus;
import fr.unedic.util.services.Resultat;

public class ResultatChargerIndividus
  extends Resultat
{
  private static final long serialVersionUID = -2058863711665771128L;
  private DomLireIndividus m_dom = null;
  
  public DomLireIndividus getDomLireIndividus()
  {
    return m_dom;
  }
  
  public void setDomLireIndividus(DomLireIndividus p_dom)
  {
    m_dom = p_dom;
  }
}

/* Location:
 * Qualified Name:     ResultatChargerIndividus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */