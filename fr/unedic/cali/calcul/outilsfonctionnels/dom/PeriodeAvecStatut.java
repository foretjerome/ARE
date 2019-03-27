package fr.unedic.cali.calcul.outilsfonctionnels.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;

public class PeriodeAvecStatut
  extends ObjetChronoPeriode
{
  private int m_statut;
  
  public PeriodeAvecStatut(Damj p_dateEffet, int p_statut)
  {
    super(p_dateEffet.getDebutMois(), p_dateEffet.getFinMois());
    
    m_statut = p_statut;
  }
  
  public PeriodeAvecStatut(Damj p_dateDebut, Damj p_dateFin, int p_statut)
  {
    super(p_dateDebut, p_dateFin);
    
    m_statut = p_statut;
  }
  
  public int getStatut()
  {
    return m_statut;
  }
  
  public void setStatut(int p_statut)
  {
    m_statut = p_statut;
  }
  
  public ObjetMetierSpec copie()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     PeriodeAvecStatut
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */