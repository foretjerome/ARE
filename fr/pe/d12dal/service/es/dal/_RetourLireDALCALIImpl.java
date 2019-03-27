package fr.pe.d12dal.service.es.dal;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _RetourLireDALCALIImpl
  extends RetourLireDALCALI
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _RetourLireDALCALI m_retourLireDALCALIInfra;
  
  public _RetourLireDALCALIImpl()
  {
    m_retourLireDALCALIInfra = new _RetourLireDALCALI();
  }
  
  public _RetourLireDALCALIImpl(_RetourLireDALCALI pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("RetourLireDALCALIInfra", pValeur);
    
    m_retourLireDALCALIInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_retourLireDALCALIInfra;
  }
  
  public String getIdentifiant()
  {
    return m_retourLireDALCALIInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_retourLireDALCALIInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_retourLireDALCALIInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_retourLireDALCALIInfra.set_C_ETAT(pCode);
  }
  
  public RetourLireDALCALI_listeInfosDALCALI getListeInfosDALCALI()
  {
    _RetourLireDALCALI_listeInfosDALCALI infraItem = m_retourLireDALCALIInfra.getListeInfosDALCALI();
    _RetourLireDALCALI_listeInfosDALCALIImpl resultat = null;
    if (infraItem != null) {
      resultat = new _RetourLireDALCALI_listeInfosDALCALIImpl(infraItem);
    }
    return resultat;
  }
  
  public void setListeInfosDALCALI(RetourLireDALCALI_listeInfosDALCALI pValeur)
  {
    if (pValeur == null)
    {
      m_retourLireDALCALIInfra.setListeInfosDALCALI(null);
    }
    else
    {
      _RetourLireDALCALI_listeInfosDALCALIImpl subImpl = (_RetourLireDALCALI_listeInfosDALCALIImpl)pValeur;
      m_retourLireDALCALIInfra.setListeInfosDALCALI(subImpl.getRetourLireDALCALI_listeInfosDALCALIInfra());
    }
  }
  
  public RetourLireDALCALI_listeInfosDALCALI setNewRetourLireDALCALI_listeInfosDALCALI()
  {
    _RetourLireDALCALI_listeInfosDALCALIImpl item = new _RetourLireDALCALI_listeInfosDALCALIImpl();
    m_retourLireDALCALIInfra.setListeInfosDALCALI(item.getRetourLireDALCALI_listeInfosDALCALIInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public RetourLireDALCALI_listeInfosDALCALI setNewRetourLireDALCALI_listeInfosDALCALI_listeInfosDALCALI()
  {
    return setNewRetourLireDALCALI_listeInfosDALCALI();
  }
  
  /**
   * @deprecated
   */
  public RetourLireDALCALI_listeInfosDALCALI setNewListeInfosDALCALI()
  {
    return setNewRetourLireDALCALI_listeInfosDALCALI();
  }
  
  public _RetourLireDALCALI getRetourLireDALCALIInfra()
  {
    return m_retourLireDALCALIInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    Object objRetourLireDALCALI_listeInfosDALCALI = getListeInfosDALCALI();
    if ((objRetourLireDALCALI_listeInfosDALCALI != null) && 
      (getListeInfosDALCALI().isEnErreur())) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _RetourLireDALCALIImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */