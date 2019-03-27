package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.cali.dom.SalaireJournalierSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class ObjetChronoPeriodeRevisionADR
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 4079476960298698062L;
  private SalaireJournalierSpec m_sjr = null;
  private BigDecimal m_coefficientHoraire = null;
  private BigDecimal m_salaireMensuelContratADR = null;
  private BigDecimal m_plafondCap04 = null;
  
  public ObjetChronoPeriodeRevisionADR() {}
  
  public ObjetChronoPeriodeRevisionADR(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public ObjetChronoPeriodeRevisionADR(Damj p_date, SalaireJournalierSpec p_sjr, BigDecimal p_coefficientHoraire, BigDecimal p_salaireADR, BigDecimal p_plafondCap04)
  {
    super(p_date, p_date);
    setSjr(p_sjr);
    setCoefficientHoraire(p_coefficientHoraire);
    setSalaireMensuelContratADR(p_salaireADR);
    setPlafondCap04(p_plafondCap04);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeRevisionADR copie = new ObjetChronoPeriodeRevisionADR();
    copieElements(copie);
    return copie;
  }
  
  public BigDecimal getCoefficientHoraire()
  {
    return m_coefficientHoraire;
  }
  
  public void setCoefficientHoraire(BigDecimal p_coefficientHoraire)
  {
    m_coefficientHoraire = p_coefficientHoraire;
  }
  
  public BigDecimal getPlafondCap04()
  {
    return m_plafondCap04;
  }
  
  public void setPlafondCap04(BigDecimal p_plafondCap04)
  {
    m_plafondCap04 = p_plafondCap04;
  }
  
  public BigDecimal getSalaireMensuelContratADR()
  {
    return m_salaireMensuelContratADR;
  }
  
  public void setSalaireMensuelContratADR(BigDecimal p_salaireMensuelContratADR)
  {
    m_salaireMensuelContratADR = p_salaireMensuelContratADR;
  }
  
  public SalaireJournalierSpec getSjr()
  {
    return m_sjr;
  }
  
  public void setSjr(SalaireJournalierSpec p_sjr)
  {
    m_sjr = p_sjr;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeRevisionADR
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */