package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.periode.gen.PeriodeNonDeclareeSanctionGen;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class PeriodeNonDeclareeSanction
  extends PeriodeNonDeclareeSanctionGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = 3606847565412859540L;
  private transient BigDecimal m_iccp;
  
  protected PeriodeNonDeclareeSanction()
  {
    setIccp(new BigDecimal("0"));
  }
  
  public PeriodeNonDeclareeSanction(DomPCSpec p_pc)
  {
    super(p_pc);
    setIccp(new BigDecimal("0"));
  }
  
  public PeriodeNonDeclareeSanction(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
    setIccp(new BigDecimal("0"));
  }
  
  public BigDecimal getGainHorsIccp()
  {
    BigDecimal gain;
    BigDecimal gain;
    if ((getGain() != null) && (getIccp() != null)) {
      gain = getGain().subtract(getIccp());
    } else {
      gain = getGain();
    }
    return gain;
  }
  
  public BigDecimal getIccp()
  {
    return m_iccp;
  }
  
  public void setIccp(BigDecimal p_iccp)
  {
    m_iccp = p_iccp;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeNonDeclareeSanction copie = (PeriodeNonDeclareeSanction)p_copie;
    
    super.copieElements(copie);
    
    m_iccp = getIccp();
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void marquerGraphePersistant() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void jdoPostLoad() {}
  
  public void jdoPreStore() {}
}

/* Location:
 * Qualified Name:     PeriodeNonDeclareeSanction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */