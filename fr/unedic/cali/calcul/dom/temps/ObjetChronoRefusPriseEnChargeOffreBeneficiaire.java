package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoRefusPriseEnChargeOffreBeneficiaire
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 8812192414366603046L;
  private Damj m_dateEffet;
  private String m_rsod;
  
  private ObjetChronoRefusPriseEnChargeOffreBeneficiaire() {}
  
  public ObjetChronoRefusPriseEnChargeOffreBeneficiaire(Damj p_date, String p_rsod)
  {
    super(p_date, p_date);
    setRsod(p_rsod);
  }
  
  public Damj getDateEffet()
  {
    return m_dateEffet;
  }
  
  public void setDateEffet(Damj p_dateEffet)
  {
    m_dateEffet = p_dateEffet;
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoRefusPriseEnChargeOffreBeneficiaire copie = new ObjetChronoRefusPriseEnChargeOffreBeneficiaire();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    ObjetChronoRefusPriseEnChargeOffreBeneficiaire copie = (ObjetChronoRefusPriseEnChargeOffreBeneficiaire)p_copie;
    super.copieElements(copie);
    copie.setDateEffet(getDateEffet());
    copie.setRsod(getRsod());
  }
  
  public String getRsod()
  {
    return m_rsod;
  }
  
  public void setRsod(String p_rsod)
  {
    m_rsod = p_rsod;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoRefusPriseEnChargeOffreBeneficiaire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */