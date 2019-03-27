package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ResultatServiceImpl
  extends ResultatService
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ResultatService m_resultatServiceInfra;
  
  public _ResultatServiceImpl()
  {
    m_resultatServiceInfra = new _ResultatService();
  }
  
  public _ResultatServiceImpl(_ResultatService pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("ResultatServiceInfra", pValeur);
    
    m_resultatServiceInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_resultatServiceInfra;
  }
  
  public String getIdentifiant()
  {
    return m_resultatServiceInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_resultatServiceInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_resultatServiceInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_resultatServiceInfra.set_C_ETAT(pCode);
  }
  
  public ListeErreurs getListeErreurs()
  {
    _ListeErreurs infraItem = m_resultatServiceInfra.getListeErreurs();
    _ListeErreursImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ListeErreursImpl(infraItem);
    }
    return resultat;
  }
  
  public void setListeErreurs(ListeErreurs pValeur)
  {
    if (pValeur == null)
    {
      m_resultatServiceInfra.setListeErreurs(null);
    }
    else
    {
      _ListeErreursImpl subImpl = (_ListeErreursImpl)pValeur;
      m_resultatServiceInfra.setListeErreurs(subImpl.getListeErreursInfra());
    }
  }
  
  public ListeErreurs setNewListeErreurs()
  {
    _ListeErreursImpl item = new _ListeErreursImpl();
    m_resultatServiceInfra.setListeErreurs(item.getListeErreursInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ListeErreurs setNewListeErreurs_listeErreurs()
  {
    return setNewListeErreurs();
  }
  
  public ListeIndicateurs getListeIndicateurs()
  {
    _ListeIndicateurs infraItem = m_resultatServiceInfra.getListeIndicateurs();
    _ListeIndicateursImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ListeIndicateursImpl(infraItem);
    }
    return resultat;
  }
  
  public void setListeIndicateurs(ListeIndicateurs pValeur)
  {
    if (pValeur == null)
    {
      m_resultatServiceInfra.setListeIndicateurs(null);
    }
    else
    {
      _ListeIndicateursImpl subImpl = (_ListeIndicateursImpl)pValeur;
      m_resultatServiceInfra.setListeIndicateurs(subImpl.getListeIndicateursInfra());
    }
  }
  
  public ListeIndicateurs setNewListeIndicateurs()
  {
    _ListeIndicateursImpl item = new _ListeIndicateursImpl();
    m_resultatServiceInfra.setListeIndicateurs(item.getListeIndicateursInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ListeIndicateurs setNewListeIndicateurs_listeIndicateurs()
  {
    return setNewListeIndicateurs();
  }
  
  public BigDecimal getEtat()
  {
    return m_resultatServiceInfra.getEtat();
  }
  
  public String getCodeErreurEtat()
  {
    return m_resultatServiceInfra.getEtat_C_ERR();
  }
  
  public void setEtat(BigDecimal pValeur)
  {
    m_resultatServiceInfra.setEtat(pValeur);
  }
  
  public void setCodeErreurEtat(String pCodeErreur)
  {
    m_resultatServiceInfra.setEtat_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getIndividuNCP()
  {
    return m_resultatServiceInfra.getIndividuNCP();
  }
  
  public String getCodeErreurIndividuNCP()
  {
    return m_resultatServiceInfra.getIndividuNCP_C_ERR();
  }
  
  public void setIndividuNCP(BigDecimal pValeur)
  {
    m_resultatServiceInfra.setIndividuNCP(pValeur);
  }
  
  public void setCodeErreurIndividuNCP(String pCodeErreur)
  {
    m_resultatServiceInfra.setIndividuNCP_C_ERR(pCodeErreur);
  }
  
  public _ResultatService getResultatServiceInfra()
  {
    return m_resultatServiceInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    Object objListeErreurs = getListeErreurs();
    if ((objListeErreurs != null) && 
      (getListeErreurs().isEnErreur())) {
      return true;
    }
    Object objListeIndicateurs = getListeIndicateurs();
    if ((objListeIndicateurs != null) && 
      (getListeIndicateurs().isEnErreur())) {
      return true;
    }
    if ((getCodeErreurEtat() != null) && 
      ("".equals(getCodeErreurEtat()))) {
      return true;
    }
    if ((getCodeErreurIndividuNCP() != null) && 
      ("".equals(getCodeErreurIndividuNCP()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ResultatServiceImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */