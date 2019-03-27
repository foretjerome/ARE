package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import java.util.ArrayList;

public class ResultatDroitsNcpListerParIndividu
  extends Resultat
{
  private static final long serialVersionUID = 271544412937269923L;
  private ArrayList m_listeDroitsNcp;
  
  public ArrayList getListeDroitsNcp()
  {
    return m_listeDroitsNcp;
  }
  
  public void setListeDroitsNcp(ArrayList p_listeDroitsNcp)
  {
    m_listeDroitsNcp = p_listeDroitsNcp;
  }
}

/* Location:
 * Qualified Name:     ResultatDroitsNcpListerParIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */