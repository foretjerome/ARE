package fr.unedic.cali.autresdoms.cohab.dom;

import fr.unedic.cali.autresdoms.cohab.dom.spec.PeriodePensionInvaliditeChaineeSpec;
import fr.unedic.cali.autresdoms.cohab.dom.spec.PeriodeSousPensionInvaliditeChaineeSpec;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Damj;

public class PeriodeSousPensionInvaliditeChainee
  extends ObjetChronoPeriodeCalculTransient
  implements PeriodeSousPensionInvaliditeChaineeSpec
{
  private static final long serialVersionUID = 2900444447956566663L;
  private String m_codeNature;
  private QuantiteEuro m_quantiteEuro;
  private String m_etat;
  private PeriodePensionInvaliditeChaineeSpec m_pensionParente;
  
  protected PeriodeSousPensionInvaliditeChainee() {}
  
  public PeriodeSousPensionInvaliditeChainee(Damj p_debut, Damj p_fin)
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
  
  public QuantiteEuro getMontant()
  {
    return m_quantiteEuro;
  }
  
  public void setMontant(QuantiteEuro p_quantiteEuro)
  {
    m_quantiteEuro = p_quantiteEuro;
  }
  
  public String getEtat()
  {
    return m_etat;
  }
  
  public void setEtat(String p_etat)
  {
    m_etat = p_etat;
  }
  
  public PeriodePensionInvaliditeChaineeSpec getPensionParente()
  {
    return m_pensionParente;
  }
  
  public void setPensionParente(PeriodePensionInvaliditeChaineeSpec p_pensionParente)
  {
    m_pensionParente = p_pensionParente;
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetMetierSpec copie = new PeriodeSousPensionInvaliditeChainee();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeSousPensionInvaliditeChainee copie = (PeriodeSousPensionInvaliditeChainee)p_copie;
    super.copieElements(copie);
    
    m_codeNature = getCodeNature();
    m_quantiteEuro = getMontant();
    m_etat = getEtat();
  }
}

/* Location:
 * Qualified Name:     PeriodeSousPensionInvaliditeChainee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */