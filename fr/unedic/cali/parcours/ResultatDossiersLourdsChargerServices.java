package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.dossiersLourds.DomDossiersLourdsChargerServices;
import fr.unedic.util.services.Resultat;

public class ResultatDossiersLourdsChargerServices
  extends Resultat
{
  private static final long serialVersionUID = -7335876078323092598L;
  private DomDossiersLourdsChargerServices m_dom = null;
  
  public DomDossiersLourdsChargerServices getDomDossiersLourdsChargerServices()
  {
    return m_dom;
  }
  
  public void setDomDossiersLourdsChargerServices(DomDossiersLourdsChargerServices p_dom)
  {
    m_dom = p_dom;
  }
}

/* Location:
 * Qualified Name:     ResultatDossiersLourdsChargerServices
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */