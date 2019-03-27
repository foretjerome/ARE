package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public abstract class Formation
  extends PeriodeGaec
{
  private String m_nomOrganismeFormation;
  private Quantite m_dureeTotale;
  
  public Formation() {}
  
  public Formation(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public Formation(Periode p_periode)
  {
    super(p_periode);
  }
  
  public Quantite getDureeTotale()
  {
    return m_dureeTotale;
  }
  
  public void setDureeTotale(Quantite p_dureeTotale)
  {
    m_dureeTotale = p_dureeTotale;
  }
  
  public String getNomOrganismeFormation()
  {
    return m_nomOrganismeFormation;
  }
  
  public void setNomOrganismeFormation(String p_nomOrganismeFormation)
  {
    m_nomOrganismeFormation = p_nomOrganismeFormation;
  }
}

/* Location:
 * Qualified Name:     Formation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */