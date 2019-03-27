package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeLimiteIndemRepriseEmploi
  extends ObjetChronoPeriodeCalculTransient
{
  private String m_referenceExterne;
  
  private ObjetChronoPeriodeLimiteIndemRepriseEmploi() {}
  
  public ObjetChronoPeriodeLimiteIndemRepriseEmploi(Damj p_debut, Damj p_fin, String p_referenceExterne)
  {
    super(p_debut, p_fin);
    setReferenceExterne(p_referenceExterne);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeLimiteIndemRepriseEmploi copie = new ObjetChronoPeriodeLimiteIndemRepriseEmploi();
    copieElements(copie);
    m_referenceExterne = getReferenceExterne();
    return copie;
  }
  
  public void setReferenceExterne(String p_referenceExterne)
  {
    m_referenceExterne = p_referenceExterne;
  }
  
  public String getReferenceExterne()
  {
    return m_referenceExterne;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeLimiteIndemRepriseEmploi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */