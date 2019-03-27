package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;

public class PeriodeEtatNonProfessionnel
  extends ObjetChronoPeriode
{
  private static final long serialVersionUID = -5650548680490104208L;
  private boolean m_etatProfessionnel;
  
  public PeriodeEtatNonProfessionnel(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public boolean isEtatProfessionnel()
  {
    return m_etatProfessionnel;
  }
  
  public void setEtatProfessionnel(boolean p_etatProfessionnel)
  {
    m_etatProfessionnel = p_etatProfessionnel;
  }
  
  public ObjetMetierSpec copie()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     PeriodeEtatNonProfessionnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */