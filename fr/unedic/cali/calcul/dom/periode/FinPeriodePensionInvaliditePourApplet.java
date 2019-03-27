package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.autresdoms.cohab.dom.spec.PeriodeSousPensionInvaliditeChaineeSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class FinPeriodePensionInvaliditePourApplet
  extends FinPeriodePension
{
  private static final long serialVersionUID = -4909672583791944837L;
  private PeriodeSousPensionInvaliditeChaineeSpec m_pensionGeneratrice;
  
  protected FinPeriodePensionInvaliditePourApplet() {}
  
  public FinPeriodePensionInvaliditePourApplet(Damj p_date)
  {
    super(p_date);
  }
  
  public PeriodeSousPensionInvaliditeChaineeSpec getPeriodePensionGeneratrice()
  {
    return m_pensionGeneratrice;
  }
  
  public void setPeriodePensionGeneratrice(PeriodeSousPensionInvaliditeChaineeSpec p_pensionGeneratrice)
  {
    m_pensionGeneratrice = p_pensionGeneratrice;
  }
  
  public ObjetMetierSpec copie()
  {
    FinPeriodePensionInvalidite copie = new FinPeriodePensionInvalidite();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    FinPeriodePensionInvaliditePourApplet copie = (FinPeriodePensionInvaliditePourApplet)p_copie;
    
    super.copieElements(copie);
    
    m_pensionGeneratrice = getPeriodePensionGeneratrice();
  }
}

/* Location:
 * Qualified Name:     FinPeriodePensionInvaliditePourApplet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */