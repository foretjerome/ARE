package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Resultat;

public class ResultatLirePEC
  extends Resultat
{
  private IndividuSpec m_individu;
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
}

/* Location:
 * Qualified Name:     ResultatLirePEC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */