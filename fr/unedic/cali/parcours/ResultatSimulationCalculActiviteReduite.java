package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.DomSimulationCalculActiviteReduite;
import fr.unedic.util.services.Resultat;

public class ResultatSimulationCalculActiviteReduite
  extends Resultat
{
  private static final long serialVersionUID = -3807085796950778307L;
  private DomSimulationCalculActiviteReduite m_dom = null;
  
  public DomSimulationCalculActiviteReduite getDomSimulationCalculActiviteReduite()
  {
    return m_dom;
  }
  
  public void setDomSimulationCalculActiviteReduite(DomSimulationCalculActiviteReduite p_dom)
  {
    m_dom = p_dom;
  }
}

/* Location:
 * Qualified Name:     ResultatSimulationCalculActiviteReduite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */