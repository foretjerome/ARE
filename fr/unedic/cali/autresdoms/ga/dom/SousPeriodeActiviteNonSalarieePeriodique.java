package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;

public class SousPeriodeActiviteNonSalarieePeriodique
  extends ObjetChronoPeriode
{
  private boolean m_etatProfessionnel;
  private PeriodeActiviteNonSalariePeriodique m_periodeActiviteNonSalarieePeriodique;
  
  public SousPeriodeActiviteNonSalarieePeriodique(Damj p_dateDebut, Damj p_dateFin)
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
  
  public PeriodeActiviteNonSalariePeriodique getPeriodeActiviteNonSalarieePeriodique()
  {
    return m_periodeActiviteNonSalarieePeriodique;
  }
  
  public void setPeriodeActiviteNonSalarieePeriodique(PeriodeActiviteNonSalariePeriodique p_periodeActiviteNonSalarieePeriodique)
  {
    m_periodeActiviteNonSalarieePeriodique = p_periodeActiviteNonSalarieePeriodique;
  }
}

/* Location:
 * Qualified Name:     SousPeriodeActiviteNonSalarieePeriodique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */