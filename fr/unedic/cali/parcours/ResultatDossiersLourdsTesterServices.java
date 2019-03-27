package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.dossiersLourds.DomDossiersLourdsTesterServices;
import fr.unedic.util.services.Resultat;

public class ResultatDossiersLourdsTesterServices
  extends Resultat
{
  private static final long serialVersionUID = -6732727325933303258L;
  private DomDossiersLourdsTesterServices m_domDossiersLourdsTesterServices = null;
  
  public DomDossiersLourdsTesterServices getDomDossiersLourdsTesterServices()
  {
    return m_domDossiersLourdsTesterServices;
  }
  
  public void setDomDossiersLourdsTesterServices(DomDossiersLourdsTesterServices p_domDossiersLourdsTesterServices)
  {
    m_domDossiersLourdsTesterServices = p_domDossiersLourdsTesterServices;
  }
}

/* Location:
 * Qualified Name:     ResultatDossiersLourdsTesterServices
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */