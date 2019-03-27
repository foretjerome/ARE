package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import java.util.ArrayList;

public class ResultatEnquetesNcpListerParIndividu
  extends Resultat
{
  private static final long serialVersionUID = 271544412937269923L;
  private ArrayList m_listeEnquetesNcp;
  
  public ArrayList getListeEnquetesNcp()
  {
    return m_listeEnquetesNcp;
  }
  
  public void setListeEnquetesNcp(ArrayList p_listeEnquetesNcp)
  {
    m_listeEnquetesNcp = p_listeEnquetesNcp;
  }
}

/* Location:
 * Qualified Name:     ResultatEnquetesNcpListerParIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */