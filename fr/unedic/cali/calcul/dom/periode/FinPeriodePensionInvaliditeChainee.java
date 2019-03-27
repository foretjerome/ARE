package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.autresdoms.cohab.dom.spec.PeriodeSousPensionInvaliditeChaineeSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class FinPeriodePensionInvaliditeChainee
  extends FinPeriodePension
{
  private static final long serialVersionUID = -4909672583791944837L;
  private PeriodeSousPensionInvaliditeChaineeSpec m_pensionGeneratrice;
  
  protected FinPeriodePensionInvaliditeChainee() {}
  
  public FinPeriodePensionInvaliditeChainee(Damj date)
  {
    super(date);
  }
  
  public PeriodeSousPensionInvaliditeChaineeSpec getPeriodePensionGeneratrice()
  {
    return m_pensionGeneratrice;
  }
  
  public void setPeriodePensionGeneratrice(PeriodeSousPensionInvaliditeChaineeSpec pensionGeneratrice)
  {
    m_pensionGeneratrice = pensionGeneratrice;
  }
  
  public ObjetMetierSpec copie()
  {
    FinPeriodePensionInvaliditeChainee copie = new FinPeriodePensionInvaliditeChainee();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec objectMetier)
  {
    FinPeriodePensionInvaliditeChainee copie = (FinPeriodePensionInvaliditeChainee)objectMetier;
    super.copieElements(copie);
    m_pensionGeneratrice = getPeriodePensionGeneratrice();
  }
}

/* Location:
 * Qualified Name:     FinPeriodePensionInvaliditeChainee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */