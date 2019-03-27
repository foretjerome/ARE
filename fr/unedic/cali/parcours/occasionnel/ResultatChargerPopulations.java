package fr.unedic.cali.parcours.occasionnel;

import fr.unedic.cali.dom.occasionnel.DomLirePopulations;
import fr.unedic.util.services.Resultat;

public class ResultatChargerPopulations
  extends Resultat
{
  private static final long serialVersionUID = -2058863711676871128L;
  private DomLirePopulations m_dom = null;
  
  public DomLirePopulations getDomLirePopulations()
  {
    return m_dom;
  }
  
  public void setDomLirePopulations(DomLirePopulations p_dom)
  {
    m_dom = p_dom;
  }
}

/* Location:
 * Qualified Name:     ResultatChargerPopulations
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */