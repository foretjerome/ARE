package fr.pe.d12dal.service.es.dal;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _CritereLireDALCALIImpl
  extends CritereLireDALCALI
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _CritereLireDALCALI m_critereLireDALCALIInfra;
  
  public _CritereLireDALCALIImpl()
  {
    m_critereLireDALCALIInfra = new _CritereLireDALCALI();
  }
  
  public _CritereLireDALCALIImpl(_CritereLireDALCALI pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("CritereLireDALCALIInfra", pValeur);
    
    m_critereLireDALCALIInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_critereLireDALCALIInfra;
  }
  
  public String getIdentifiant()
  {
    return m_critereLireDALCALIInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_critereLireDALCALIInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_critereLireDALCALIInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_critereLireDALCALIInfra.set_C_ETAT(pCode);
  }
  
  public String getCxalaf()
  {
    return m_critereLireDALCALIInfra.getCxalaf();
  }
  
  public String getCodeErreurCxalaf()
  {
    return m_critereLireDALCALIInfra.getCxalaf_C_ERR();
  }
  
  public void setCxalaf(String pValeur)
  {
    m_critereLireDALCALIInfra.setCxalaf(pValeur);
  }
  
  public void setCodeErreurCxalaf(String pCodeErreur)
  {
    m_critereLireDALCALIInfra.setCxalaf_C_ERR(pCodeErreur);
  }
  
  public String getCodePE()
  {
    return m_critereLireDALCALIInfra.getCodePE();
  }
  
  public String getCodeErreurCodePE()
  {
    return m_critereLireDALCALIInfra.getCodePE_C_ERR();
  }
  
  public void setCodePE(String pValeur)
  {
    m_critereLireDALCALIInfra.setCodePE(pValeur);
  }
  
  public void setCodeErreurCodePE(String pCodeErreur)
  {
    m_critereLireDALCALIInfra.setCodePE_C_ERR(pCodeErreur);
  }
  
  public String getRefExterne()
  {
    return m_critereLireDALCALIInfra.getRefExterne();
  }
  
  public String getCodeErreurRefExterne()
  {
    return m_critereLireDALCALIInfra.getRefExterne_C_ERR();
  }
  
  public void setRefExterne(String pValeur)
  {
    m_critereLireDALCALIInfra.setRefExterne(pValeur);
  }
  
  public void setCodeErreurRefExterne(String pCodeErreur)
  {
    m_critereLireDALCALIInfra.setRefExterne_C_ERR(pCodeErreur);
  }
  
  public _CritereLireDALCALI getCritereLireDALCALIInfra()
  {
    return m_critereLireDALCALIInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurCxalaf() != null) && 
      ("".equals(getCodeErreurCxalaf()))) {
      return true;
    }
    if ((getCodeErreurCodePE() != null) && 
      ("".equals(getCodeErreurCodePE()))) {
      return true;
    }
    if ((getCodeErreurRefExterne() != null) && 
      ("".equals(getCodeErreurRefExterne()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _CritereLireDALCALIImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */