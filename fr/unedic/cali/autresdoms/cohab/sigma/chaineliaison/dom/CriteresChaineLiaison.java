package fr.unedic.cali.autresdoms.cohab.sigma.chaineliaison.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.chaineliaison.dom.spec.CriteresChaineLiaisonSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.dom.Criteres;
import java.util.Date;

public class CriteresChaineLiaison
  extends Criteres
  implements CriteresChaineLiaisonSpec
{
  private Date m_date;
  private String m_identifiantIndividu;
  private String m_codeAssedic;
  
  public Date getDateEvenement()
  {
    return m_date;
  }
  
  public void setDateEvenement(Date p_date)
  {
    m_date = p_date;
  }
  
  public String getCodeAssedic()
  {
    return m_codeAssedic;
  }
  
  public String getIdentifiantIndividu()
  {
    return m_identifiantIndividu;
  }
  
  public void setCodeAssedic(String p_codeAssedic)
  {
    m_codeAssedic = p_codeAssedic;
  }
  
  public void setIdentifiantIndividu(String p_identifiantIndividu)
  {
    m_identifiantIndividu = p_identifiantIndividu;
  }
}

/* Location:
 * Qualified Name:     CriteresChaineLiaison
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */