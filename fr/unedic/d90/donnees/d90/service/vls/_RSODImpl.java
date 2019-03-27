package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _RSODImpl
  extends RSOD
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _RSOD m_RSODInfra;
  
  public _RSODImpl()
  {
    m_RSODInfra = new _RSOD();
  }
  
  public _RSODImpl(_RSOD pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("RSODInfra", pValeur);
    
    m_RSODInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_RSODInfra;
  }
  
  public String getIdentifiant()
  {
    return m_RSODInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_RSODInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_RSODInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_RSODInfra.set_C_ETAT(pCode);
  }
  
  public String getRSOD()
  {
    return m_RSODInfra.getRSOD();
  }
  
  public String getCodeErreurRSOD()
  {
    return m_RSODInfra.getRSOD_C_ERR();
  }
  
  public void setRSOD(String pValeur)
  {
    m_RSODInfra.setRSOD(pValeur);
  }
  
  public void setCodeErreurRSOD(String pCodeErreur)
  {
    m_RSODInfra.setRSOD_C_ERR(pCodeErreur);
  }
  
  public _RSOD getRSODInfra()
  {
    return m_RSODInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurRSOD() != null) && 
      ("".equals(getCodeErreurRSOD()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _RSODImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */