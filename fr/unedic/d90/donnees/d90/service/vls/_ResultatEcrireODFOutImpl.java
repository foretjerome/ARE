package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ResultatEcrireODFOutImpl
  extends ResultatEcrireODFOut
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ResultatEcrireODFOut m_resultatEcrireODFOutInfra;
  
  public _ResultatEcrireODFOutImpl()
  {
    m_resultatEcrireODFOutInfra = new _ResultatEcrireODFOut();
  }
  
  public _ResultatEcrireODFOutImpl(_ResultatEcrireODFOut pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("ResultatEcrireODFOutInfra", pValeur);
    
    m_resultatEcrireODFOutInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_resultatEcrireODFOutInfra;
  }
  
  public String getIdentifiant()
  {
    return m_resultatEcrireODFOutInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_resultatEcrireODFOutInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_resultatEcrireODFOutInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_resultatEcrireODFOutInfra.set_C_ETAT(pCode);
  }
  
  public ResultatService getResultatService()
  {
    _ResultatService infraItem = m_resultatEcrireODFOutInfra.getResultatService();
    _ResultatServiceImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ResultatServiceImpl(infraItem);
    }
    return resultat;
  }
  
  public void setResultatService(ResultatService pValeur)
  {
    if (pValeur == null)
    {
      m_resultatEcrireODFOutInfra.setResultatService(null);
    }
    else
    {
      _ResultatServiceImpl subImpl = (_ResultatServiceImpl)pValeur;
      m_resultatEcrireODFOutInfra.setResultatService(subImpl.getResultatServiceInfra());
    }
  }
  
  public ResultatService setNewResultatService()
  {
    _ResultatServiceImpl item = new _ResultatServiceImpl();
    m_resultatEcrireODFOutInfra.setResultatService(item.getResultatServiceInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ResultatService setNewResultatService_resultatService()
  {
    return setNewResultatService();
  }
  
  public _ResultatEcrireODFOut getResultatEcrireODFOutInfra()
  {
    return m_resultatEcrireODFOutInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    Object objResultatEcrireODFOut_resultatService = getResultatService();
    if ((objResultatEcrireODFOut_resultatService != null) && 
      (getResultatService().isEnErreur())) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ResultatEcrireODFOutImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */