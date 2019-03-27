package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import java.util.ArrayList;

public class ResultatPrimesNcpListerParIndividu
  extends Resultat
{
  private static final long serialVersionUID = 271544412937269923L;
  private ArrayList m_listePrimesNcp;
  
  public ArrayList getListePrimesNcp()
  {
    return m_listePrimesNcp;
  }
  
  public void setListePrimesNcp(ArrayList p_listePrimesNcp)
  {
    m_listePrimesNcp = p_listePrimesNcp;
  }
}

/* Location:
 * Qualified Name:     ResultatPrimesNcpListerParIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */