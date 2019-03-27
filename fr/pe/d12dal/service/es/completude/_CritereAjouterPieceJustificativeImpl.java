package fr.pe.d12dal.service.es.completude;

import fr.pe.d12dal.dictionnaire.CasUtilisationAjouterPieceJustificativeEnumeration;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _CritereAjouterPieceJustificativeImpl
  extends CritereAjouterPieceJustificative
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _CritereAjouterPieceJustificative m_critereAjouterPieceJustificativeInfra;
  
  public _CritereAjouterPieceJustificativeImpl()
  {
    m_critereAjouterPieceJustificativeInfra = new _CritereAjouterPieceJustificative();
  }
  
  public _CritereAjouterPieceJustificativeImpl(_CritereAjouterPieceJustificative pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("CritereAjouterPieceJustificativeInfra", pValeur);
    
    m_critereAjouterPieceJustificativeInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_critereAjouterPieceJustificativeInfra;
  }
  
  public String getIdentifiant()
  {
    return m_critereAjouterPieceJustificativeInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_critereAjouterPieceJustificativeInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_critereAjouterPieceJustificativeInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_critereAjouterPieceJustificativeInfra.set_C_ETAT(pCode);
  }
  
  public ContexteServiceES getContexteService()
  {
    _ContexteServiceES infraItem = m_critereAjouterPieceJustificativeInfra.getContexteService();
    _ContexteServiceESImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ContexteServiceESImpl(infraItem);
    }
    return resultat;
  }
  
  public void setContexteService(ContexteServiceES pValeur)
  {
    if (pValeur == null)
    {
      m_critereAjouterPieceJustificativeInfra.setContexteService(null);
    }
    else
    {
      _ContexteServiceESImpl subImpl = (_ContexteServiceESImpl)pValeur;
      m_critereAjouterPieceJustificativeInfra.setContexteService(subImpl.getContexteServiceESInfra());
    }
  }
  
  public ContexteServiceES setNewContexteServiceES()
  {
    _ContexteServiceESImpl item = new _ContexteServiceESImpl();
    m_critereAjouterPieceJustificativeInfra.setContexteService(item.getContexteServiceESInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ContexteServiceES setNewContexteServiceES_contexteService()
  {
    return setNewContexteServiceES();
  }
  
  /**
   * @deprecated
   */
  public ContexteServiceES setNewContexteService()
  {
    return setNewContexteServiceES();
  }
  
  public String getCxalaf()
  {
    return m_critereAjouterPieceJustificativeInfra.getCxalaf();
  }
  
  public String getCodeErreurCxalaf()
  {
    return m_critereAjouterPieceJustificativeInfra.getCxalaf_C_ERR();
  }
  
  public void setCxalaf(String pValeur)
  {
    m_critereAjouterPieceJustificativeInfra.setCxalaf(pValeur);
  }
  
  public void setCodeErreurCxalaf(String pCodeErreur)
  {
    m_critereAjouterPieceJustificativeInfra.setCxalaf_C_ERR(pCodeErreur);
  }
  
  public String getCodePE()
  {
    return m_critereAjouterPieceJustificativeInfra.getCodePE();
  }
  
  public String getCodeErreurCodePE()
  {
    return m_critereAjouterPieceJustificativeInfra.getCodePE_C_ERR();
  }
  
  public void setCodePE(String pValeur)
  {
    m_critereAjouterPieceJustificativeInfra.setCodePE(pValeur);
  }
  
  public void setCodeErreurCodePE(String pCodeErreur)
  {
    m_critereAjouterPieceJustificativeInfra.setCodePE_C_ERR(pCodeErreur);
  }
  
  public String getRefExterne()
  {
    return m_critereAjouterPieceJustificativeInfra.getRefExterne();
  }
  
  public String getCodeErreurRefExterne()
  {
    return m_critereAjouterPieceJustificativeInfra.getRefExterne_C_ERR();
  }
  
  public void setRefExterne(String pValeur)
  {
    m_critereAjouterPieceJustificativeInfra.setRefExterne(pValeur);
  }
  
  public void setCodeErreurRefExterne(String pCodeErreur)
  {
    m_critereAjouterPieceJustificativeInfra.setRefExterne_C_ERR(pCodeErreur);
  }
  
  public String getCasUtilisation()
  {
    return m_critereAjouterPieceJustificativeInfra.getCasUtilisation();
  }
  
  public CasUtilisationAjouterPieceJustificativeEnumeration getEnumerationCasUtilisation()
  {
    return CasUtilisationAjouterPieceJustificativeEnumeration.getPourValeur(m_critereAjouterPieceJustificativeInfra.getCasUtilisation());
  }
  
  public void setEnumerationCasUtilisation(CasUtilisationAjouterPieceJustificativeEnumeration pEnumeration)
  {
    m_critereAjouterPieceJustificativeInfra.setCasUtilisation(pEnumeration.getValeur());
  }
  
  public void setCasUtilisation(String pValeur)
  {
    m_critereAjouterPieceJustificativeInfra.setCasUtilisation(pValeur);
  }
  
  public String getCodeErreurCasUtilisation()
  {
    return m_critereAjouterPieceJustificativeInfra.getCasUtilisation_C_ERR();
  }
  
  public void setCodeErreurCasUtilisation(String pCodeErreur)
  {
    m_critereAjouterPieceJustificativeInfra.setCasUtilisation_C_ERR(pCodeErreur);
  }
  
  public String getIdPeriodeGAEC()
  {
    return m_critereAjouterPieceJustificativeInfra.getIdPeriodeGAEC();
  }
  
  public String getCodeErreurIdPeriodeGAEC()
  {
    return m_critereAjouterPieceJustificativeInfra.getIdPeriodeGAEC_C_ERR();
  }
  
  public void setIdPeriodeGAEC(String pValeur)
  {
    m_critereAjouterPieceJustificativeInfra.setIdPeriodeGAEC(pValeur);
  }
  
  public void setCodeErreurIdPeriodeGAEC(String pCodeErreur)
  {
    m_critereAjouterPieceJustificativeInfra.setIdPeriodeGAEC_C_ERR(pCodeErreur);
  }
  
  public String getRsin()
  {
    return m_critereAjouterPieceJustificativeInfra.getRsin();
  }
  
  public String getCodeErreurRsin()
  {
    return m_critereAjouterPieceJustificativeInfra.getRsin_C_ERR();
  }
  
  public void setRsin(String pValeur)
  {
    m_critereAjouterPieceJustificativeInfra.setRsin(pValeur);
  }
  
  public void setCodeErreurRsin(String pCodeErreur)
  {
    m_critereAjouterPieceJustificativeInfra.setRsin_C_ERR(pCodeErreur);
  }
  
  public _CritereAjouterPieceJustificative getCritereAjouterPieceJustificativeInfra()
  {
    return m_critereAjouterPieceJustificativeInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    Object objCritereAjouterPieceJustificative_contexteService = getContexteService();
    if ((objCritereAjouterPieceJustificative_contexteService != null) && 
      (getContexteService().isEnErreur())) {
      return true;
    }
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
    if ((getCodeErreurCasUtilisation() != null) && 
      ("".equals(getCodeErreurCasUtilisation()))) {
      return true;
    }
    if ((getCodeErreurIdPeriodeGAEC() != null) && 
      ("".equals(getCodeErreurIdPeriodeGAEC()))) {
      return true;
    }
    if ((getCodeErreurRsin() != null) && 
      ("".equals(getCodeErreurRsin()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _CritereAjouterPieceJustificativeImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */