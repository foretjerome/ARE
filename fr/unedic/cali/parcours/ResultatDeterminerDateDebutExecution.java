package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;

public class ResultatDeterminerDateDebutExecution
  extends Resultat
{
  private static final long serialVersionUID = 1L;
  private Damj m_dateDebutExecution = null;
  
  public Damj getDateDebutExecution()
  {
    return m_dateDebutExecution;
  }
  
  public void setDateDebutExecution(Damj p_dateDebutExecution)
  {
    m_dateDebutExecution = p_dateDebutExecution;
  }
}

/* Location:
 * Qualified Name:     ResultatDeterminerDateDebutExecution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */