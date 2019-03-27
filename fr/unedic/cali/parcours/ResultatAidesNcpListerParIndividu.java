package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import java.util.ArrayList;

public class ResultatAidesNcpListerParIndividu
  extends Resultat
{
  private static final long serialVersionUID = 271544412937269923L;
  private ArrayList m_listeAidesNcp;
  
  public ArrayList getListeAidesNcp()
  {
    return m_listeAidesNcp;
  }
  
  public void setListeAidesNcp(ArrayList p_listeAidesNcp)
  {
    m_listeAidesNcp = p_listeAidesNcp;
  }
}

/* Location:
 * Qualified Name:     ResultatAidesNcpListerParIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */