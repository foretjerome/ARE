package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import java.util.ArrayList;

public class ResultatLireDecisionsSuivi
  extends Resultat
{
  private static final long serialVersionUID = 271544412937269923L;
  private ArrayList m_listeDecisionSuivi;
  
  public ArrayList getListeDecisionSuivi()
  {
    return m_listeDecisionSuivi;
  }
  
  public void setListeDecisionSuivi(ArrayList p_listeDecisionSuivi)
  {
    m_listeDecisionSuivi = p_listeDecisionSuivi;
  }
}

/* Location:
 * Qualified Name:     ResultatLireDecisionsSuivi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */