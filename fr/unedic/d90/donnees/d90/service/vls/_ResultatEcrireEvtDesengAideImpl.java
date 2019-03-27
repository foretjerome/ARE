package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ResultatEcrireEvtDesengAideImpl
  extends ResultatEcrireEvtDesengAide
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ResultatEcrireEvtDesengAide m_resultatEcrireEvtDesengAideInfra;
  
  public _ResultatEcrireEvtDesengAideImpl()
  {
    m_resultatEcrireEvtDesengAideInfra = new _ResultatEcrireEvtDesengAide();
  }
  
  public _ResultatEcrireEvtDesengAideImpl(_ResultatEcrireEvtDesengAide pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("ResultatEcrireEvtDesengAideInfra", pValeur);
    
    m_resultatEcrireEvtDesengAideInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_resultatEcrireEvtDesengAideInfra;
  }
  
  public String getIdentifiant()
  {
    return m_resultatEcrireEvtDesengAideInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_resultatEcrireEvtDesengAideInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_resultatEcrireEvtDesengAideInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_resultatEcrireEvtDesengAideInfra.set_C_ETAT(pCode);
  }
  
  public ResultatService getResultatService()
  {
    _ResultatService infraItem = m_resultatEcrireEvtDesengAideInfra.getResultatService();
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
      m_resultatEcrireEvtDesengAideInfra.setResultatService(null);
    }
    else
    {
      _ResultatServiceImpl subImpl = (_ResultatServiceImpl)pValeur;
      m_resultatEcrireEvtDesengAideInfra.setResultatService(subImpl.getResultatServiceInfra());
    }
  }
  
  public ResultatService setNewResultatService()
  {
    _ResultatServiceImpl item = new _ResultatServiceImpl();
    m_resultatEcrireEvtDesengAideInfra.setResultatService(item.getResultatServiceInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ResultatService setNewResultatService_resultatService()
  {
    return setNewResultatService();
  }
  
  public _ResultatEcrireEvtDesengAide getResultatEcrireEvtDesengAideInfra()
  {
    return m_resultatEcrireEvtDesengAideInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    Object objResultatEcrireEvtDesengAide_resultatService = getResultatService();
    if ((objResultatEcrireEvtDesengAide_resultatService != null) && 
      (getResultatService().isEnErreur())) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ResultatEcrireEvtDesengAideImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */