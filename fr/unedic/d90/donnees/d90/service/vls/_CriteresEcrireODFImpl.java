package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _CriteresEcrireODFImpl
  extends CriteresEcrireODF
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _CriteresEcrireODF m_criteresEcrireODFInfra;
  
  public _CriteresEcrireODFImpl()
  {
    m_criteresEcrireODFInfra = new _CriteresEcrireODF();
  }
  
  public _CriteresEcrireODFImpl(_CriteresEcrireODF pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("CriteresEcrireODFInfra", pValeur);
    
    m_criteresEcrireODFInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_criteresEcrireODFInfra;
  }
  
  public String getIdentifiant()
  {
    return m_criteresEcrireODFInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_criteresEcrireODFInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_criteresEcrireODFInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_criteresEcrireODFInfra.set_C_ETAT(pCode);
  }
  
  public ContexteService getContexteService()
  {
    _ContexteService infraItem = m_criteresEcrireODFInfra.getContexteService();
    _ContexteServiceImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ContexteServiceImpl(infraItem);
    }
    return resultat;
  }
  
  public void setContexteService(ContexteService pValeur)
  {
    if (pValeur == null)
    {
      m_criteresEcrireODFInfra.setContexteService(null);
    }
    else
    {
      _ContexteServiceImpl subImpl = (_ContexteServiceImpl)pValeur;
      m_criteresEcrireODFInfra.setContexteService(subImpl.getContexteServiceInfra());
    }
  }
  
  public ContexteService setNewContexteService()
  {
    _ContexteServiceImpl item = new _ContexteServiceImpl();
    m_criteresEcrireODFInfra.setContexteService(item.getContexteServiceInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ContexteService setNewContexteService_contexteService()
  {
    return setNewContexteService();
  }
  
  public ListeRSOD getListeRSOD()
  {
    _ListeRSOD infraItem = m_criteresEcrireODFInfra.getListeRSOD();
    _ListeRSODImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ListeRSODImpl(infraItem);
    }
    return resultat;
  }
  
  public void setListeRSOD(ListeRSOD pValeur)
  {
    if (pValeur == null)
    {
      m_criteresEcrireODFInfra.setListeRSOD(null);
    }
    else
    {
      _ListeRSODImpl subImpl = (_ListeRSODImpl)pValeur;
      m_criteresEcrireODFInfra.setListeRSOD(subImpl.getListeRSODInfra());
    }
  }
  
  public ListeRSOD setNewListeRSOD()
  {
    _ListeRSODImpl item = new _ListeRSODImpl();
    m_criteresEcrireODFInfra.setListeRSOD(item.getListeRSODInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ListeRSOD setNewListeRSOD_listeRSOD()
  {
    return setNewListeRSOD();
  }
  
  public _CriteresEcrireODF getCriteresEcrireODFInfra()
  {
    return m_criteresEcrireODFInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    Object objCriteresEcrireODF_contexteService = getContexteService();
    if ((objCriteresEcrireODF_contexteService != null) && 
      (getContexteService().isEnErreur())) {
      return true;
    }
    Object objListeRSOD = getListeRSOD();
    if ((objListeRSOD != null) && 
      (getListeRSOD().isEnErreur())) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _CriteresEcrireODFImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */