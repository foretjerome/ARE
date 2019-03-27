package fr.pe.d12dal.service.es.completude;

import fr.pe.d12dal.dictionnaire.CasUtilisationSynchroniserCouleurDALEnumeration;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _CritereSynchroniserCouleurDALImpl
  extends CritereSynchroniserCouleurDAL
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _CritereSynchroniserCouleurDAL m_critereSynchroniserCouleurDALInfra;
  
  public _CritereSynchroniserCouleurDALImpl()
  {
    m_critereSynchroniserCouleurDALInfra = new _CritereSynchroniserCouleurDAL();
  }
  
  public _CritereSynchroniserCouleurDALImpl(_CritereSynchroniserCouleurDAL pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("CritereSynchroniserCouleurDALInfra", pValeur);
    
    m_critereSynchroniserCouleurDALInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_critereSynchroniserCouleurDALInfra;
  }
  
  public String getIdentifiant()
  {
    return m_critereSynchroniserCouleurDALInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_critereSynchroniserCouleurDALInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_critereSynchroniserCouleurDALInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_critereSynchroniserCouleurDALInfra.set_C_ETAT(pCode);
  }
  
  public ContexteServiceES getContexteService()
  {
    _ContexteServiceES infraItem = m_critereSynchroniserCouleurDALInfra.getContexteService();
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
      m_critereSynchroniserCouleurDALInfra.setContexteService(null);
    }
    else
    {
      _ContexteServiceESImpl subImpl = (_ContexteServiceESImpl)pValeur;
      m_critereSynchroniserCouleurDALInfra.setContexteService(subImpl.getContexteServiceESInfra());
    }
  }
  
  public ContexteServiceES setNewContexteServiceES()
  {
    _ContexteServiceESImpl item = new _ContexteServiceESImpl();
    m_critereSynchroniserCouleurDALInfra.setContexteService(item.getContexteServiceESInfra());
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
    return m_critereSynchroniserCouleurDALInfra.getCxalaf();
  }
  
  public String getCodeErreurCxalaf()
  {
    return m_critereSynchroniserCouleurDALInfra.getCxalaf_C_ERR();
  }
  
  public void setCxalaf(String pValeur)
  {
    m_critereSynchroniserCouleurDALInfra.setCxalaf(pValeur);
  }
  
  public void setCodeErreurCxalaf(String pCodeErreur)
  {
    m_critereSynchroniserCouleurDALInfra.setCxalaf_C_ERR(pCodeErreur);
  }
  
  public String getCodePE()
  {
    return m_critereSynchroniserCouleurDALInfra.getCodePE();
  }
  
  public String getCodeErreurCodePE()
  {
    return m_critereSynchroniserCouleurDALInfra.getCodePE_C_ERR();
  }
  
  public void setCodePE(String pValeur)
  {
    m_critereSynchroniserCouleurDALInfra.setCodePE(pValeur);
  }
  
  public void setCodeErreurCodePE(String pCodeErreur)
  {
    m_critereSynchroniserCouleurDALInfra.setCodePE_C_ERR(pCodeErreur);
  }
  
  public String getCasUtilisation()
  {
    return m_critereSynchroniserCouleurDALInfra.getCasUtilisation();
  }
  
  public CasUtilisationSynchroniserCouleurDALEnumeration getEnumerationCasUtilisation()
  {
    return CasUtilisationSynchroniserCouleurDALEnumeration.getPourValeur(m_critereSynchroniserCouleurDALInfra.getCasUtilisation());
  }
  
  public void setEnumerationCasUtilisation(CasUtilisationSynchroniserCouleurDALEnumeration pEnumeration)
  {
    m_critereSynchroniserCouleurDALInfra.setCasUtilisation(pEnumeration.getValeur());
  }
  
  public void setCasUtilisation(String pValeur)
  {
    m_critereSynchroniserCouleurDALInfra.setCasUtilisation(pValeur);
  }
  
  public String getCodeErreurCasUtilisation()
  {
    return m_critereSynchroniserCouleurDALInfra.getCasUtilisation_C_ERR();
  }
  
  public void setCodeErreurCasUtilisation(String pCodeErreur)
  {
    m_critereSynchroniserCouleurDALInfra.setCasUtilisation_C_ERR(pCodeErreur);
  }
  
  public String getRefExterne()
  {
    return m_critereSynchroniserCouleurDALInfra.getRefExterne();
  }
  
  public String getCodeErreurRefExterne()
  {
    return m_critereSynchroniserCouleurDALInfra.getRefExterne_C_ERR();
  }
  
  public void setRefExterne(String pValeur)
  {
    m_critereSynchroniserCouleurDALInfra.setRefExterne(pValeur);
  }
  
  public void setCodeErreurRefExterne(String pCodeErreur)
  {
    m_critereSynchroniserCouleurDALInfra.setRefExterne_C_ERR(pCodeErreur);
  }
  
  public String getTypeAttente()
  {
    return m_critereSynchroniserCouleurDALInfra.getTypeAttente();
  }
  
  public String getCodeErreurTypeAttente()
  {
    return m_critereSynchroniserCouleurDALInfra.getTypeAttente_C_ERR();
  }
  
  public void setTypeAttente(String pValeur)
  {
    m_critereSynchroniserCouleurDALInfra.setTypeAttente(pValeur);
  }
  
  public void setCodeErreurTypeAttente(String pCodeErreur)
  {
    m_critereSynchroniserCouleurDALInfra.setTypeAttente_C_ERR(pCodeErreur);
  }
  
  public _CritereSynchroniserCouleurDAL getCritereSynchroniserCouleurDALInfra()
  {
    return m_critereSynchroniserCouleurDALInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    Object objCritereSynchroniserCouleurDAL_contexteService = getContexteService();
    if ((objCritereSynchroniserCouleurDAL_contexteService != null) && 
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
    if ((getCodeErreurCasUtilisation() != null) && 
      ("".equals(getCodeErreurCasUtilisation()))) {
      return true;
    }
    if ((getCodeErreurRefExterne() != null) && 
      ("".equals(getCodeErreurRefExterne()))) {
      return true;
    }
    if ((getCodeErreurTypeAttente() != null) && 
      ("".equals(getCodeErreurTypeAttente()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _CritereSynchroniserCouleurDALImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */