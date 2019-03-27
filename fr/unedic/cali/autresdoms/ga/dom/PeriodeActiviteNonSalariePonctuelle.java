package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class PeriodeActiviteNonSalariePonctuelle
  extends TravailNonSalarie
{
  private RevenuPans m_revenuPans = null;
  private boolean m_etatProfessionnel;
  
  public PeriodeActiviteNonSalariePonctuelle() {}
  
  public PeriodeActiviteNonSalariePonctuelle(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public PeriodeActiviteNonSalariePonctuelle(Periode p_periode)
  {
    super(p_periode);
  }
  
  public RevenuPans getRevenuPans()
  {
    return m_revenuPans;
  }
  
  public void setRevenuPans(RevenuPans p_revenuPans)
  {
    m_revenuPans = p_revenuPans;
  }
  
  public boolean estQualifiable()
  {
    return false;
  }
  
  public boolean isEtatProfessionnel()
  {
    return m_etatProfessionnel;
  }
  
  public void setEtatProfessionnel(boolean p_etatProfessionnel)
  {
    m_etatProfessionnel = p_etatProfessionnel;
  }
  
  public Entreprise getEntreprise()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     PeriodeActiviteNonSalariePonctuelle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */