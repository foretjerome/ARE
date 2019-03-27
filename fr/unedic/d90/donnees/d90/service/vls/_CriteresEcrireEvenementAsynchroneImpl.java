package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _CriteresEcrireEvenementAsynchroneImpl
  extends CriteresEcrireEvenementAsynchrone
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _CriteresEcrireEvenementAsynchrone m_criteresEcrireEvenementAsynchroneInfra;
  
  public _CriteresEcrireEvenementAsynchroneImpl()
  {
    m_criteresEcrireEvenementAsynchroneInfra = new _CriteresEcrireEvenementAsynchrone();
  }
  
  public _CriteresEcrireEvenementAsynchroneImpl(_CriteresEcrireEvenementAsynchrone pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("CriteresEcrireEvenementAsynchroneInfra", pValeur);
    
    m_criteresEcrireEvenementAsynchroneInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_criteresEcrireEvenementAsynchroneInfra;
  }
  
  public String getIdentifiant()
  {
    return m_criteresEcrireEvenementAsynchroneInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_criteresEcrireEvenementAsynchroneInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_criteresEcrireEvenementAsynchroneInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_criteresEcrireEvenementAsynchroneInfra.set_C_ETAT(pCode);
  }
  
  public ContexteService getContexteService()
  {
    _ContexteService infraItem = m_criteresEcrireEvenementAsynchroneInfra.getContexteService();
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
      m_criteresEcrireEvenementAsynchroneInfra.setContexteService(null);
    }
    else
    {
      _ContexteServiceImpl subImpl = (_ContexteServiceImpl)pValeur;
      m_criteresEcrireEvenementAsynchroneInfra.setContexteService(subImpl.getContexteServiceInfra());
    }
  }
  
  public ContexteService setNewContexteService()
  {
    _ContexteServiceImpl item = new _ContexteServiceImpl();
    m_criteresEcrireEvenementAsynchroneInfra.setContexteService(item.getContexteServiceInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ContexteService setNewContexteService_contexteService()
  {
    return setNewContexteService();
  }
  
  public ListeParametres getListeParametres()
  {
    _ListeParametres infraItem = m_criteresEcrireEvenementAsynchroneInfra.getListeParametres();
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
      m_criteresEcrireEvenementAsynchroneInfra.setListeParametres(null);
    }
    else
    {
      _ListeParametresImpl subImpl = (_ListeParametresImpl)pValeur;
      m_criteresEcrireEvenementAsynchroneInfra.setListeParametres(subImpl.getListeParametresInfra());
    }
  }
  
  public ListeParametres setNewListeParametres()
  {
    _ListeParametresImpl item = new _ListeParametresImpl();
    m_criteresEcrireEvenementAsynchroneInfra.setListeParametres(item.getListeParametresInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ListeParametres setNewListeParametres_listeParametres()
  {
    return setNewListeParametres();
  }
  
  public Flux getFlux()
  {
    _Flux infraItem = m_criteresEcrireEvenementAsynchroneInfra.getFlux();
    _FluxImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFlux(Flux pValeur)
  {
    if (pValeur == null)
    {
      m_criteresEcrireEvenementAsynchroneInfra.setFlux(null);
    }
    else
    {
      _FluxImpl subImpl = (_FluxImpl)pValeur;
      m_criteresEcrireEvenementAsynchroneInfra.setFlux(subImpl.getFluxInfra());
    }
  }
  
  public Flux setNewFlux()
  {
    _FluxImpl item = new _FluxImpl();
    m_criteresEcrireEvenementAsynchroneInfra.setFlux(item.getFluxInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public Flux setNewFlux_flux()
  {
    return setNewFlux();
  }
  
  public _CriteresEcrireEvenementAsynchrone getCriteresEcrireEvenementAsynchroneInfra()
  {
    return m_criteresEcrireEvenementAsynchroneInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    Object objCriteresEcrireEvenementAsynchrone_contexteService = getContexteService();
    if ((objCriteresEcrireEvenementAsynchrone_contexteService != null) && 
      (getContexteService().isEnErreur())) {
      return true;
    }
    Object objListeParametres = getListeParametres();
    if ((objListeParametres != null) && 
      (getListeParametres().isEnErreur())) {
      return true;
    }
    Object objCriteresEcrireEvenementAsynchrone_flux = getFlux();
    if ((objCriteresEcrireEvenementAsynchrone_flux != null) && 
      (getFlux().isEnErreur())) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _CriteresEcrireEvenementAsynchroneImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */