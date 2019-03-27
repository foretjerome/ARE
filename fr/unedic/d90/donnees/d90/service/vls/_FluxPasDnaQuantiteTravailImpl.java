package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxPasDnaQuantiteTravailImpl
  extends FluxPasDnaQuantiteTravail
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxPasDnaQuantiteTravail m_fluxPasDnaQuantiteTravailInfra;
  
  public _FluxPasDnaQuantiteTravailImpl()
  {
    m_fluxPasDnaQuantiteTravailInfra = new _FluxPasDnaQuantiteTravail();
  }
  
  public _FluxPasDnaQuantiteTravailImpl(_FluxPasDnaQuantiteTravail pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxPasDnaQuantiteTravailInfra", pValeur);
    
    m_fluxPasDnaQuantiteTravailInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxPasDnaQuantiteTravailInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxPasDnaQuantiteTravailInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxPasDnaQuantiteTravailInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxPasDnaQuantiteTravailInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxPasDnaQuantiteTravailInfra.set_C_ETAT(pCode);
  }
  
  public String getUniteTravail()
  {
    return m_fluxPasDnaQuantiteTravailInfra.getUniteTravail();
  }
  
  public String getCodeErreurUniteTravail()
  {
    return m_fluxPasDnaQuantiteTravailInfra.getUniteTravail_C_ERR();
  }
  
  public void setUniteTravail(String pValeur)
  {
    m_fluxPasDnaQuantiteTravailInfra.setUniteTravail(pValeur);
  }
  
  public void setCodeErreurUniteTravail(String pCodeErreur)
  {
    m_fluxPasDnaQuantiteTravailInfra.setUniteTravail_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getQuantiteTravail()
  {
    return m_fluxPasDnaQuantiteTravailInfra.getQuantiteTravail();
  }
  
  public String getCodeErreurQuantiteTravail()
  {
    return m_fluxPasDnaQuantiteTravailInfra.getQuantiteTravail_C_ERR();
  }
  
  public void setQuantiteTravail(BigDecimal pValeur)
  {
    m_fluxPasDnaQuantiteTravailInfra.setQuantiteTravail(pValeur);
  }
  
  public void setCodeErreurQuantiteTravail(String pCodeErreur)
  {
    m_fluxPasDnaQuantiteTravailInfra.setQuantiteTravail_C_ERR(pCodeErreur);
  }
  
  public _FluxPasDnaQuantiteTravail getFluxPasDnaQuantiteTravailInfra()
  {
    return m_fluxPasDnaQuantiteTravailInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurUniteTravail() != null) && 
      ("".equals(getCodeErreurUniteTravail()))) {
      return true;
    }
    if ((getCodeErreurQuantiteTravail() != null) && 
      ("".equals(getCodeErreurQuantiteTravail()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxPasDnaQuantiteTravailImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */