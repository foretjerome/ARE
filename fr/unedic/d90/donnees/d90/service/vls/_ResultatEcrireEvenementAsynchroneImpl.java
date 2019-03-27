package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ResultatEcrireEvenementAsynchroneImpl
  extends ResultatEcrireEvenementAsynchrone
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ResultatEcrireEvenementAsynchrone m_resultatEcrireEvenementAsynchroneInfra;
  
  public _ResultatEcrireEvenementAsynchroneImpl()
  {
    m_resultatEcrireEvenementAsynchroneInfra = new _ResultatEcrireEvenementAsynchrone();
  }
  
  public _ResultatEcrireEvenementAsynchroneImpl(_ResultatEcrireEvenementAsynchrone pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("ResultatEcrireEvenementAsynchroneInfra", pValeur);
    
    m_resultatEcrireEvenementAsynchroneInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_resultatEcrireEvenementAsynchroneInfra;
  }
  
  public String getIdentifiant()
  {
    return m_resultatEcrireEvenementAsynchroneInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_resultatEcrireEvenementAsynchroneInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_resultatEcrireEvenementAsynchroneInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_resultatEcrireEvenementAsynchroneInfra.set_C_ETAT(pCode);
  }
  
  public ResultatService getResultatService()
  {
    _ResultatService infraItem = m_resultatEcrireEvenementAsynchroneInfra.getResultatService();
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
      m_resultatEcrireEvenementAsynchroneInfra.setResultatService(null);
    }
    else
    {
      _ResultatServiceImpl subImpl = (_ResultatServiceImpl)pValeur;
      m_resultatEcrireEvenementAsynchroneInfra.setResultatService(subImpl.getResultatServiceInfra());
    }
  }
  
  public ResultatService setNewResultatService()
  {
    _ResultatServiceImpl item = new _ResultatServiceImpl();
    m_resultatEcrireEvenementAsynchroneInfra.setResultatService(item.getResultatServiceInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ResultatService setNewResultatService_resultatService()
  {
    return setNewResultatService();
  }
  
  public _ResultatEcrireEvenementAsynchrone getResultatEcrireEvenementAsynchroneInfra()
  {
    return m_resultatEcrireEvenementAsynchroneInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    Object objResultatEcrireEvenementAsynchrone_resultatService = getResultatService();
    if ((objResultatEcrireEvenementAsynchrone_resultatService != null) && 
      (getResultatService().isEnErreur())) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ResultatEcrireEvenementAsynchroneImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */