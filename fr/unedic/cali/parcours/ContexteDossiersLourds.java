package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.Individu;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Parcours;

public class ContexteDossiersLourds
  extends Contexte
{
  private Parcours m_parcours = null;
  private Individu m_individu = null;
  private String m_nomService = null;
  
  public Parcours getParcours()
  {
    return m_parcours;
  }
  
  public void setParcours(Parcours p_parcours)
  {
    m_parcours = p_parcours;
  }
  
  public Individu getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(Individu p_individu)
  {
    m_individu = p_individu;
  }
  
  public String getNomService()
  {
    return m_nomService;
  }
  
  public void setNomService(String p_nomService)
  {
    m_nomService = p_nomService;
  }
}

/* Location:
 * Qualified Name:     ContexteDossiersLourds
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */