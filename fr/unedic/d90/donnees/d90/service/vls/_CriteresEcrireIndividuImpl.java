package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _CriteresEcrireIndividuImpl
  extends CriteresEcrireIndividu
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _CriteresEcrireIndividu m_criteresEcrireIndividuInfra;
  
  public _CriteresEcrireIndividuImpl()
  {
    m_criteresEcrireIndividuInfra = new _CriteresEcrireIndividu();
  }
  
  public _CriteresEcrireIndividuImpl(_CriteresEcrireIndividu pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("CriteresEcrireIndividuInfra", pValeur);
    
    m_criteresEcrireIndividuInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_criteresEcrireIndividuInfra;
  }
  
  public String getIdentifiant()
  {
    return m_criteresEcrireIndividuInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_criteresEcrireIndividuInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_criteresEcrireIndividuInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_criteresEcrireIndividuInfra.set_C_ETAT(pCode);
  }
  
  public ContexteService getContexteService()
  {
    _ContexteService infraItem = m_criteresEcrireIndividuInfra.getContexteService();
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
      m_criteresEcrireIndividuInfra.setContexteService(null);
    }
    else
    {
      _ContexteServiceImpl subImpl = (_ContexteServiceImpl)pValeur;
      m_criteresEcrireIndividuInfra.setContexteService(subImpl.getContexteServiceInfra());
    }
  }
  
  public ContexteService setNewContexteService()
  {
    _ContexteServiceImpl item = new _ContexteServiceImpl();
    m_criteresEcrireIndividuInfra.setContexteService(item.getContexteServiceInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ContexteService setNewContexteService_contexteService()
  {
    return setNewContexteService();
  }
  
  public ListeIndividus getListeIndividus()
  {
    _ListeIndividus infraItem = m_criteresEcrireIndividuInfra.getListeIndividus();
    _ListeIndividusImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ListeIndividusImpl(infraItem);
    }
    return resultat;
  }
  
  public void setListeIndividus(ListeIndividus pValeur)
  {
    if (pValeur == null)
    {
      m_criteresEcrireIndividuInfra.setListeIndividus(null);
    }
    else
    {
      _ListeIndividusImpl subImpl = (_ListeIndividusImpl)pValeur;
      m_criteresEcrireIndividuInfra.setListeIndividus(subImpl.getListeIndividusInfra());
    }
  }
  
  public ListeIndividus setNewListeIndividus()
  {
    _ListeIndividusImpl item = new _ListeIndividusImpl();
    m_criteresEcrireIndividuInfra.setListeIndividus(item.getListeIndividusInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ListeIndividus setNewListeIndividus_listeIndividus()
  {
    return setNewListeIndividus();
  }
  
  public ListeParametres getListeParametres()
  {
    _ListeParametres infraItem = m_criteresEcrireIndividuInfra.getListeParametres();
    _ListeParametresImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ListeParametresImpl(infraItem);
    }
    return resultat;
  }
  
  public void setListeParametres(ListeParametres pValeur)
  {
    if (pValeur == null)
    {
      m_criteresEcrireIndividuInfra.setListeParametres(null);
    }
    else
    {
      _ListeParametresImpl subImpl = (_ListeParametresImpl)pValeur;
      m_criteresEcrireIndividuInfra.setListeParametres(subImpl.getListeParametresInfra());
    }
  }
  
  public ListeParametres setNewListeParametres()
  {
    _ListeParametresImpl item = new _ListeParametresImpl();
    m_criteresEcrireIndividuInfra.setListeParametres(item.getListeParametresInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ListeParametres setNewListeParametres_listeParametres()
  {
    return setNewListeParametres();
  }
  
  public _CriteresEcrireIndividu getCriteresEcrireIndividuInfra()
  {
    return m_criteresEcrireIndividuInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    Object objCriteresEcrireIndividu_contexteService = getContexteService();
    if ((objCriteresEcrireIndividu_contexteService != null) && 
      (getContexteService().isEnErreur())) {
      return true;
    }
    Object objListeIndividus = getListeIndividus();
    if ((objListeIndividus != null) && 
      (getListeIndividus().isEnErreur())) {
      return true;
    }
    Object objListeParametres = getListeParametres();
    if ((objListeParametres != null) && 
      (getListeParametres().isEnErreur())) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _CriteresEcrireIndividuImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */