package fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.StructureIn;
import fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.spec.StructureInBlocageActuSpec;
import fr.unedic.util.temps.Damj;

public class StructureInBlocageActu
  extends StructureIn
  implements StructureInBlocageActuSpec
{
  private Damj m_dateDebut;
  private Damj m_dateFin;
  
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
 * Qualified Name:     StructureInBlocageActu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */