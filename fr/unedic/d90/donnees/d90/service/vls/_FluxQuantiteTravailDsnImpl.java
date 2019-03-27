package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxQuantiteTravailDsnImpl
  extends FluxQuantiteTravailDsn
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxQuantiteTravailDsn m_fluxQuantiteTravailDsnInfra;
  
  public _FluxQuantiteTravailDsnImpl()
  {
    m_fluxQuantiteTravailDsnInfra = new _FluxQuantiteTravailDsn();
  }
  
  public _FluxQuantiteTravailDsnImpl(_FluxQuantiteTravailDsn pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxQuantiteTravailDsnInfra", pValeur);
    
    m_fluxQuantiteTravailDsnInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxQuantiteTravailDsnInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxQuantiteTravailDsnInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxQuantiteTravailDsnInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxQuantiteTravailDsnInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxQuantiteTravailDsnInfra.set_C_ETAT(pCode);
  }
  
  public String getUniteTempsTravail()
  {
    return m_fluxQuantiteTravailDsnInfra.getUniteTempsTravail();
  }
  
  public String getCodeErreurUniteTempsTravail()
  {
    return m_fluxQuantiteTravailDsnInfra.getUniteTempsTravail_C_ERR();
  }
  
  public void setUniteTempsTravail(String pValeur)
  {
    m_fluxQuantiteTravailDsnInfra.setUniteTempsTravail(pValeur);
  }
  
  public void setCodeErreurUniteTempsTravail(String pCodeErreur)
  {
    m_fluxQuantiteTravailDsnInfra.setUniteTempsTravail_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getQuantiteTempsTravail()
  {
    return m_fluxQuantiteTravailDsnInfra.getQuantiteTempsTravail();
  }
  
  public String getCodeErreurQuantiteTempsTravail()
  {
    return m_fluxQuantiteTravailDsnInfra.getQuantiteTempsTravail_C_ERR();
  }
  
  public void setQuantiteTempsTravail(BigDecimal pValeur)
  {
    m_fluxQuantiteTravailDsnInfra.setQuantiteTempsTravail(pValeur);
  }
  
  public void setCodeErreurQuantiteTempsTravail(String pCodeErreur)
  {
    m_fluxQuantiteTravailDsnInfra.setQuantiteTempsTravail_C_ERR(pCodeErreur);
  }
  
  public String getSigneQuantiteTempsTravail()
  {
    return m_fluxQuantiteTravailDsnInfra.getSigneQuantiteTempsTravail();
  }
  
  public String getCodeErreurSigneQuantiteTempsTravail()
  {
    return m_fluxQuantiteTravailDsnInfra.getSigneQuantiteTempsTravail_C_ERR();
  }
  
  public void setSigneQuantiteTempsTravail(String pValeur)
  {
    m_fluxQuantiteTravailDsnInfra.setSigneQuantiteTempsTravail(pValeur);
  }
  
  public void setCodeErreurSigneQuantiteTempsTravail(String pCodeErreur)
  {
    m_fluxQuantiteTravailDsnInfra.setSigneQuantiteTempsTravail_C_ERR(pCodeErreur);
  }
  
  public _FluxQuantiteTravailDsn getFluxQuantiteTravailDsnInfra()
  {
    return m_fluxQuantiteTravailDsnInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurUniteTempsTravail() != null) && 
      ("".equals(getCodeErreurUniteTempsTravail()))) {
      return true;
    }
    if ((getCodeErreurQuantiteTempsTravail() != null) && 
      ("".equals(getCodeErreurQuantiteTempsTravail()))) {
      return true;
    }
    if ((getCodeErreurSigneQuantiteTempsTravail() != null) && 
      ("".equals(getCodeErreurSigneQuantiteTempsTravail()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxQuantiteTravailDsnImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */