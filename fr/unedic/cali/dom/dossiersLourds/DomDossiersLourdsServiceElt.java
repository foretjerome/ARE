package fr.unedic.cali.dom.dossiersLourds;

import fr.unedic.util.services.Dom;

public class DomDossiersLourdsServiceElt
  implements Dom
{
  private String m_service;
  private String m_mappeur;
  private String m_parcours;
  private String m_segment;
  private String m_dom;
  private String m_type;
  
  public String getDom()
  {
    return m_dom;
  }
  
  public void setDom(String p_dom)
  {
    m_dom = p_dom;
  }
  
  public String getSegment()
  {
    return m_segment;
  }
  
  public void setSegment(String p_segment)
  {
    m_segment = p_segment;
  }
  
  public String getMappeur()
  {
    return m_mappeur;
  }
  
  public void setMappeur(String p_mappeur)
  {
    m_mappeur = p_mappeur;
  }
  
  public String getParcours()
  {
    return m_parcours;
  }
  
  public void setParcours(String p_parcours)
  {
    m_parcours = p_parcours;
  }
  
  public String getService()
  {
    return m_service;
  }
  
  public void setService(String p_service)
  {
    m_service = p_service;
  }
  
  public String getType()
  {
    return m_type;
  }
  
  public void setType(String p_type)
  {
    m_type = p_type;
  }
}

/* Location:
 * Qualified Name:     DomDossiersLourdsServiceElt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */