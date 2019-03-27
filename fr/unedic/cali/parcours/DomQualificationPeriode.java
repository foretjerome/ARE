package fr.unedic.cali.parcours;

import fr.unedic.util.temps.Damj;
import java.util.Hashtable;

public class DomQualificationPeriode
  extends DomLiquidationDemande
{
  private Hashtable m_idPeriodeBooleen = null;
  private Damj m_dateFinDernierSinistre = null;
  
  public Hashtable getIdPeriodeBooleen()
  {
    return m_idPeriodeBooleen;
  }
  
  public void setIdPeriodeBooleen(Hashtable p_idPeriodeBooleen)
  {
    m_idPeriodeBooleen = p_idPeriodeBooleen;
  }
  
  public Damj getDateFinDernierSinistre()
  {
    return m_dateFinDernierSinistre;
  }
  
  public void setDateFinDernierSinistre(Damj p_dateFinDernierSinistre)
  {
    m_dateFinDernierSinistre = p_dateFinDernierSinistre;
  }
}

/* Location:
 * Qualified Name:     DomQualificationPeriode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */