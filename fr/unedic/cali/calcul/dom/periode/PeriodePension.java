package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Damj;

public abstract class PeriodePension
  extends ObjetChronoPeriodeCalculTransient
{
  private String m_codeNature = null;
  private QuantiteEuro m_quantiteEuro = null;
  
  protected PeriodePension() {}
  
  public PeriodePension(Damj p_debut, Damj p_fin)
  {
    super(p_debut, p_fin);
  }
  
  public String getCodeNature()
  {
    return m_codeNature;
  }
  
  public void setCodeNature(String p_codeNature)
  {
    m_codeNature = p_codeNature;
  }
  
  public QuantiteEuro getQuantiteEuro()
  {
    return m_quantiteEuro;
  }
  
  public void setQuantiteEuro(QuantiteEuro p_quantiteEuro)
  {
    m_quantiteEuro = p_quantiteEuro;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodePension copie = (PeriodePension)p_copie;
    
    super.copieElements(copie);
    
    m_codeNature = getCodeNature();
    m_quantiteEuro = getQuantiteEuro();
  }
}

/* Location:
 * Qualified Name:     PeriodePension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */