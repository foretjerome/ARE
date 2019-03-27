package fr.pe.d12dal.service.es.dal;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _InfosLiquidationDalImpl
  extends InfosLiquidationDal
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _InfosLiquidationDal m_infosLiquidationDalInfra;
  
  public _InfosLiquidationDalImpl()
  {
    m_infosLiquidationDalInfra = new _InfosLiquidationDal();
  }
  
  public _InfosLiquidationDalImpl(_InfosLiquidationDal pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("InfosLiquidationDalInfra", pValeur);
    
    m_infosLiquidationDalInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_infosLiquidationDalInfra;
  }
  
  public String getIdentifiant()
  {
    return m_infosLiquidationDalInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_infosLiquidationDalInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_infosLiquidationDalInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_infosLiquidationDalInfra.set_C_ETAT(pCode);
  }
  
  public Boolean getTopPresenceFormation()
  {
    return m_infosLiquidationDalInfra.getTopPresenceFormation();
  }
  
  public String getCodeErreurTopPresenceFormation()
  {
    return m_infosLiquidationDalInfra.getTopPresenceFormation_C_ERR();
  }
  
  public void setTopPresenceFormation(Boolean pValeur)
  {
    m_infosLiquidationDalInfra.setTopPresenceFormation(pValeur);
  }
  
  public void setCodeErreurTopPresenceFormation(String pCodeErreur)
  {
    m_infosLiquidationDalInfra.setTopPresenceFormation_C_ERR(pCodeErreur);
  }
  
  public Boolean getTopDemandeLiquidable()
  {
    return m_infosLiquidationDalInfra.getTopDemandeLiquidable();
  }
  
  public String getCodeErreurTopDemandeLiquidable()
  {
    return m_infosLiquidationDalInfra.getTopDemandeLiquidable_C_ERR();
  }
  
  public void setTopDemandeLiquidable(Boolean pValeur)
  {
    m_infosLiquidationDalInfra.setTopDemandeLiquidable(pValeur);
  }
  
  public void setCodeErreurTopDemandeLiquidable(String pCodeErreur)
  {
    m_infosLiquidationDalInfra.setTopDemandeLiquidable_C_ERR(pCodeErreur);
  }
  
  public Boolean getTopDemandeComplete()
  {
    return m_infosLiquidationDalInfra.getTopDemandeComplete();
  }
  
  public String getCodeErreurTopDemandeComplete()
  {
    return m_infosLiquidationDalInfra.getTopDemandeComplete_C_ERR();
  }
  
  public void setTopDemandeComplete(Boolean pValeur)
  {
    m_infosLiquidationDalInfra.setTopDemandeComplete(pValeur);
  }
  
  public void setCodeErreurTopDemandeComplete(String pCodeErreur)
  {
    m_infosLiquidationDalInfra.setTopDemandeComplete_C_ERR(pCodeErreur);
  }
  
  public Boolean getTopLiquidationAuto()
  {
    return m_infosLiquidationDalInfra.getTopLiquidationAuto();
  }
  
  public String getCodeErreurTopLiquidationAuto()
  {
    return m_infosLiquidationDalInfra.getTopLiquidationAuto_C_ERR();
  }
  
  public void setTopLiquidationAuto(Boolean pValeur)
  {
    m_infosLiquidationDalInfra.setTopLiquidationAuto(pValeur);
  }
  
  public void setCodeErreurTopLiquidationAuto(String pCodeErreur)
  {
    m_infosLiquidationDalInfra.setTopLiquidationAuto_C_ERR(pCodeErreur);
  }
  
  public Boolean getTopDemandeWebKO()
  {
    return m_infosLiquidationDalInfra.getTopDemandeWebKO();
  }
  
  public String getCodeErreurTopDemandeWebKO()
  {
    return m_infosLiquidationDalInfra.getTopDemandeWebKO_C_ERR();
  }
  
  public void setTopDemandeWebKO(Boolean pValeur)
  {
    m_infosLiquidationDalInfra.setTopDemandeWebKO(pValeur);
  }
  
  public void setCodeErreurTopDemandeWebKO(String pCodeErreur)
  {
    m_infosLiquidationDalInfra.setTopDemandeWebKO_C_ERR(pCodeErreur);
  }
  
  public Boolean getTopLiquidationStandardAuto()
  {
    return m_infosLiquidationDalInfra.getTopLiquidationStandardAuto();
  }
  
  public String getCodeErreurTopLiquidationStandardAuto()
  {
    return m_infosLiquidationDalInfra.getTopLiquidationStandardAuto_C_ERR();
  }
  
  public void setTopLiquidationStandardAuto(Boolean pValeur)
  {
    m_infosLiquidationDalInfra.setTopLiquidationStandardAuto(pValeur);
  }
  
  public void setCodeErreurTopLiquidationStandardAuto(String pCodeErreur)
  {
    m_infosLiquidationDalInfra.setTopLiquidationStandardAuto_C_ERR(pCodeErreur);
  }
  
  public _InfosLiquidationDal getInfosLiquidationDalInfra()
  {
    return m_infosLiquidationDalInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurTopPresenceFormation() != null) && 
      ("".equals(getCodeErreurTopPresenceFormation()))) {
      return true;
    }
    if ((getCodeErreurTopDemandeLiquidable() != null) && 
      ("".equals(getCodeErreurTopDemandeLiquidable()))) {
      return true;
    }
    if ((getCodeErreurTopDemandeComplete() != null) && 
      ("".equals(getCodeErreurTopDemandeComplete()))) {
      return true;
    }
    if ((getCodeErreurTopLiquidationAuto() != null) && 
      ("".equals(getCodeErreurTopLiquidationAuto()))) {
      return true;
    }
    if ((getCodeErreurTopDemandeWebKO() != null) && 
      ("".equals(getCodeErreurTopDemandeWebKO()))) {
      return true;
    }
    if ((getCodeErreurTopLiquidationStandardAuto() != null) && 
      ("".equals(getCodeErreurTopLiquidationStandardAuto()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _InfosLiquidationDalImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */