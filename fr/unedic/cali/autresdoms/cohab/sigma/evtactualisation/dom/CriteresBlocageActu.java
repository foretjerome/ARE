package fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Criteres;
import fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.spec.CriteresBlocageActuSpec;
import fr.unedic.util.temps.Damj;

public class CriteresBlocageActu
  extends Criteres
  implements CriteresBlocageActuSpec
{
  private String m_numeroAllocataire;
  private Damj m_dateDebut;
  private Damj m_dateFin;
  
  public String getNumeroAllocataire()
  {
    return m_numeroAllocataire;
  }
  
  public void setNumeroAllocataire(String p_numeroAllocataire)
  {
    m_numeroAllocataire = p_numeroAllocataire;
  }
  
  public Damj getDateDebut()
  {
    return m_dateDebut;
  }
  
  public void setDateDebut(Damj p_dateDebut)
  {
    m_dateDebut = p_dateDebut;
  }
  
  public Damj getDateFin()
  {
    return m_dateFin;
  }
  
  public void setDateFin(Damj p_dateFin)
  {
    m_dateFin = p_dateFin;
  }
}

/* Location:
 * Qualified Name:     CriteresBlocageActu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */