package fr.unedic.cali.autresdoms.cohab.sigma.restitutioninscrdude.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.restitutioninscrdude.dom.spec.RestitutionInscriptionDudeSpec;
import fr.unedic.util.temps.Damj;

public class RestitutionInscriptionDude
  implements RestitutionInscriptionDudeSpec
{
  private Damj m_datePreInscription;
  private String m_typePEC;
  private String m_sousTypePEC;
  
  public Damj getDatePreInscription()
  {
    return m_datePreInscription;
  }
  
  public String getSousTypePEC()
  {
    return m_sousTypePEC;
  }
  
  public String getTypePEC()
  {
    return m_typePEC;
  }
  
  public void setDatePreInscription(Damj p_datePreInscription)
  {
    m_datePreInscription = p_datePreInscription;
  }
  
  public void setSousTypePEC(String p_sousTypePEC)
  {
    m_sousTypePEC = p_sousTypePEC;
  }
  
  public void setTypePEC(String p_typePEC)
  {
    m_typePEC = p_typePEC;
  }
}

/* Location:
 * Qualified Name:     RestitutionInscriptionDude
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */