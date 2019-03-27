package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _CriteresEcrireEvtDesengAideImpl
  extends CriteresEcrireEvtDesengAide
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _CriteresEcrireEvtDesengAide m_criteresEcrireEvtDesengAideInfra;
  
  public _CriteresEcrireEvtDesengAideImpl()
  {
    m_criteresEcrireEvtDesengAideInfra = new _CriteresEcrireEvtDesengAide();
  }
  
  public _CriteresEcrireEvtDesengAideImpl(_CriteresEcrireEvtDesengAide pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("CriteresEcrireEvtDesengAideInfra", pValeur);
    
    m_criteresEcrireEvtDesengAideInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_criteresEcrireEvtDesengAideInfra;
  }
  
  public String getIdentifiant()
  {
    return m_criteresEcrireEvtDesengAideInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_criteresEcrireEvtDesengAideInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_criteresEcrireEvtDesengAideInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_criteresEcrireEvtDesengAideInfra.set_C_ETAT(pCode);
  }
  
  public ContexteService getContexteService()
  {
    _ContexteService infraItem = m_criteresEcrireEvtDesengAideInfra.getContexteService();
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
      m_criteresEcrireEvtDesengAideInfra.setContexteService(null);
    }
    else
    {
      _ContexteServiceImpl subImpl = (_ContexteServiceImpl)pValeur;
      m_criteresEcrireEvtDesengAideInfra.setContexteService(subImpl.getContexteServiceInfra());
    }
  }
  
  public ContexteService setNewContexteService()
  {
    _ContexteServiceImpl item = new _ContexteServiceImpl();
    m_criteresEcrireEvtDesengAideInfra.setContexteService(item.getContexteServiceInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ContexteService setNewContexteService_contexteService()
  {
    return setNewContexteService();
  }
  
  public Flux getFlux()
  {
    _Flux infraItem = m_criteresEcrireEvtDesengAideInfra.getFlux();
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
      m_criteresEcrireEvtDesengAideInfra.setFlux(null);
    }
    else
    {
      _FluxImpl subImpl = (_FluxImpl)pValeur;
      m_criteresEcrireEvtDesengAideInfra.setFlux(subImpl.getFluxInfra());
    }
  }
  
  public Flux setNewFlux()
  {
    _FluxImpl item = new _FluxImpl();
    m_criteresEcrireEvtDesengAideInfra.setFlux(item.getFluxInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public Flux setNewFlux_flux()
  {
    return setNewFlux();
  }
  
  public CriteresEcrireEvtDesengAide_listeParametres getListeParametres()
  {
    _CriteresEcrireEvtDesengAide_listeParametres infraItem = m_criteresEcrireEvtDesengAideInfra.getListeParametres();
    _CriteresEcrireEvtDesengAide_listeParametresImpl resultat = null;
    if (infraItem != null) {
      resultat = new _CriteresEcrireEvtDesengAide_listeParametresImpl(infraItem);
    }
    return resultat;
  }
  
  public void setListeParametres(CriteresEcrireEvtDesengAide_listeParametres pValeur)
  {
    if (pValeur == null)
    {
      m_criteresEcrireEvtDesengAideInfra.setListeParametres(null);
    }
    else
    {
      _CriteresEcrireEvtDesengAide_listeParametresImpl subImpl = (_CriteresEcrireEvtDesengAide_listeParametresImpl)pValeur;
      m_criteresEcrireEvtDesengAideInfra.setListeParametres(subImpl.getCriteresEcrireEvtDesengAide_listeParametresInfra());
    }
  }
  
  public CriteresEcrireEvtDesengAide_listeParametres setNewCriteresEcrireEvtDesengAide_listeParametres()
  {
    _CriteresEcrireEvtDesengAide_listeParametresImpl item = new _CriteresEcrireEvtDesengAide_listeParametresImpl();
    m_criteresEcrireEvtDesengAideInfra.setListeParametres(item.getCriteresEcrireEvtDesengAide_listeParametresInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public CriteresEcrireEvtDesengAide_listeParametres setNewCriteresEcrireEvtDesengAide_listeParametres_listeParametres()
  {
    return setNewCriteresEcrireEvtDesengAide_listeParametres();
  }
  
  /**
   * @deprecated
   */
  public CriteresEcrireEvtDesengAide_listeParametres setNewListeParametres()
  {
    return setNewCriteresEcrireEvtDesengAide_listeParametres();
  }
  
  public _CriteresEcrireEvtDesengAide getCriteresEcrireEvtDesengAideInfra()
  {
    return m_criteresEcrireEvtDesengAideInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    Object objCriteresEcrireEvtDesengAide_contexteService = getContexteService();
    if ((objCriteresEcrireEvtDesengAide_contexteService != null) && 
      (getContexteService().isEnErreur())) {
      return true;
    }
    Object objCriteresEcrireEvtDesengAide_flux = getFlux();
    if ((objCriteresEcrireEvtDesengAide_flux != null) && 
      (getFlux().isEnErreur())) {
      return true;
    }
    Object objCriteresEcrireEvtDesengAide_listeParametres = getListeParametres();
    if ((objCriteresEcrireEvtDesengAide_listeParametres != null) && 
      (getListeParametres().isEnErreur())) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _CriteresEcrireEvtDesengAideImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */