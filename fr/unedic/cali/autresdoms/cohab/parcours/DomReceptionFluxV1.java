package fr.unedic.cali.autresdoms.cohab.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.parcours.DomCali;
import fr.unedic.cali.parcours.DomCaliOptimise;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import java.math.BigDecimal;

public abstract class DomReceptionFluxV1
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu;
  private String m_csas;
  private String m_rsin;
  private BigDecimal m_identifiantBni;
  private ContexteService m_contexteService;
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
  
  public String getCsas()
  {
    return m_csas;
  }
  
  public void setCsas(String p_csas)
  {
    m_csas = p_csas;
  }
  
  public String getRsin()
  {
    return m_rsin;
  }
  
  public void setRsin(String p_rsin)
  {
    m_rsin = p_rsin;
  }
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public static ContexteService getContexteService(Contexte p_contexte)
  {
    return ((DomReceptionFluxV1)p_contexte.getDonnees()).getContexteService();
  }
  
  public BigDecimal getIdentifiantBni()
  {
    return m_identifiantBni;
  }
  
  public void setIdentifiantBni(BigDecimal p_identifiantBni)
  {
    m_identifiantBni = p_identifiantBni;
  }
}

/* Location:
 * Qualified Name:     DomReceptionFluxV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */