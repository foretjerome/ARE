package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;

public class ResultatPbjcListerParIndividu
  extends Resultat
{
  private static final long serialVersionUID = 271544412937269923L;
  private ArrayList m_listePbjcNcp;
  private Damj m_dateDepartRetraiteCalculee;
  private Damj m_dernierJourIndemnisable;
  private boolean m_isAnomalieBloquant;
  private String m_codeAnomalieCalcul;
  private String m_donneeAnomalieCalcul;
  
  public ArrayList getListePbjcNcp()
  {
    return m_listePbjcNcp;
  }
  
  public void setListePbjcNcp(ArrayList p_listePbjcNcp)
  {
    m_listePbjcNcp = p_listePbjcNcp;
  }
  
  public Damj getDateDepartRetraiteCalculee()
  {
    return m_dateDepartRetraiteCalculee;
  }
  
  public void setDateDepartRetraiteCalculee(Damj p_dateDepartRetraiteCalculee)
  {
    m_dateDepartRetraiteCalculee = p_dateDepartRetraiteCalculee;
  }
  
  public Damj getDernierJourIndemnisable()
  {
    return m_dernierJourIndemnisable;
  }
  
  public void setDernierJourIndemnisable(Damj p_dernierJourIndemnisable)
  {
    m_dernierJourIndemnisable = p_dernierJourIndemnisable;
  }
  
  public boolean isAnomalieBloquant()
  {
    return m_isAnomalieBloquant;
  }
  
  public void setAnomalieBloquant(boolean p_isAnomalieBloquant)
  {
    m_isAnomalieBloquant = p_isAnomalieBloquant;
  }
  
  public String getCodeAnomalieCalcul()
  {
    return m_codeAnomalieCalcul;
  }
  
  public void setCodeAnomalieCalcul(String p_codeAnomalieCalcul)
  {
    m_codeAnomalieCalcul = p_codeAnomalieCalcul;
  }
  
  public String getDonneeAnomalieCalcul()
  {
    return m_donneeAnomalieCalcul;
  }
  
  public void setDonneeAnomalieCalcul(String p_donneeAnomalieCalcul)
  {
    m_donneeAnomalieCalcul = p_donneeAnomalieCalcul;
  }
}

/* Location:
 * Qualified Name:     ResultatPbjcListerParIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */