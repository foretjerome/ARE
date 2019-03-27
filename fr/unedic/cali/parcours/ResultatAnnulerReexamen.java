package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;

public class ResultatAnnulerReexamen
  extends Resultat
{
  private static final long serialVersionUID = -2224756886789191019L;
  private Damj m_dateAnnulationReexamen = null;
  
  public ResultatAnnulerReexamen(int p_etat)
  {
    super(p_etat);
  }
  
  public Damj getDateAnnulationReexamen()
  {
    return m_dateAnnulationReexamen;
  }
  
  public void setDateAnnulationReexamen(Damj p_dateAnnulationReexamen)
  {
    m_dateAnnulationReexamen = p_dateAnnulationReexamen;
  }
}

/* Location:
 * Qualified Name:     ResultatAnnulerReexamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */