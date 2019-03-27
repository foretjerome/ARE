package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxDSNImpl
  extends FluxDSN
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxDSN m_fluxDSNInfra;
  
  public _FluxDSNImpl()
  {
    m_fluxDSNInfra = new _FluxDSN();
  }
  
  public _FluxDSNImpl(_FluxDSN pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxDSNInfra", pValeur);
    
    m_fluxDSNInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxDSNInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxDSNInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxDSNInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxDSNInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxDSNInfra.set_C_ETAT(pCode);
  }
  
  public FluxCtPasDsn getFluxCtPasDsn()
  {
    _FluxCtPasDsn infraItem = m_fluxDSNInfra.getFluxCtPasDsn();
    _FluxCtPasDsnImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxCtPasDsnImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxCtPasDsn(FluxCtPasDsn pValeur)
  {
    if (pValeur == null)
    {
      m_fluxDSNInfra.setFluxCtPasDsn(null);
    }
    else
    {
      _FluxCtPasDsnImpl subImpl = (_FluxCtPasDsnImpl)pValeur;
      m_fluxDSNInfra.setFluxCtPasDsn(subImpl.getFluxCtPasDsnInfra());
    }
  }
  
  public FluxCtPasDsn setNewFluxCtPasDsn()
  {
    _FluxCtPasDsnImpl item = new _FluxCtPasDsnImpl();
    m_fluxDSNInfra.setFluxCtPasDsn(item.getFluxCtPasDsnInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxCtPasDsn setNewFluxCtPasDsn_fluxCtPasDsn()
  {
    return setNewFluxCtPasDsn();
  }
  
  public ListeFluxPrimIndemDsn getListeFluxPrimIndemDsn()
  {
    _ListeFluxPrimIndemDsn infraItem = m_fluxDSNInfra.getListeFluxPrimIndemDsn();
    _ListeFluxPrimIndemDsnImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ListeFluxPrimIndemDsnImpl(infraItem);
    }
    return resultat;
  }
  
  /**
   * @deprecated
   */
  public ListeFluxPrimIndemDsn getListeFluxPrimeIndemDsn()
  {
    return getListeFluxPrimIndemDsn();
  }
  
  public void setListeFluxPrimIndemDsn(ListeFluxPrimIndemDsn pValeur)
  {
    if (pValeur == null)
    {
      m_fluxDSNInfra.setListeFluxPrimIndemDsn(null);
    }
    else
    {
      _ListeFluxPrimIndemDsnImpl subImpl = (_ListeFluxPrimIndemDsnImpl)pValeur;
      m_fluxDSNInfra.setListeFluxPrimIndemDsn(subImpl.getListeFluxPrimIndemDsnInfra());
    }
  }
  
  /**
   * @deprecated
   */
  public void setListeFluxPrimeIndemDsn(ListeFluxPrimIndemDsn pValeur)
  {
    setListeFluxPrimIndemDsn(pValeur);
  }
  
  public ListeFluxPrimIndemDsn setNewListeFluxPrimIndemDsn()
  {
    _ListeFluxPrimIndemDsnImpl item = new _ListeFluxPrimIndemDsnImpl();
    m_fluxDSNInfra.setListeFluxPrimIndemDsn(item.getListeFluxPrimIndemDsnInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ListeFluxPrimIndemDsn setNewListeFluxPrimIndemDsn_listeFluxPrimeIndemDsn()
  {
    return setNewListeFluxPrimIndemDsn();
  }
  
  /**
   * @deprecated
   */
  public ListeFluxPrimIndemDsn setNewListeFluxPrimeIndemDsn()
  {
    return setNewListeFluxPrimIndemDsn();
  }
  
  public _FluxDSN getFluxDSNInfra()
  {
    return m_fluxDSNInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    Object objFluxDSN_fluxCtPasDsn = getFluxCtPasDsn();
    if ((objFluxDSN_fluxCtPasDsn != null) && 
      (getFluxCtPasDsn().isEnErreur())) {
      return true;
    }
    Object objListeFluxPrimIndemDsn = getListeFluxPrimIndemDsn();
    if ((objListeFluxPrimIndemDsn != null) && 
      (getListeFluxPrimIndemDsn().isEnErreur())) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxDSNImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */