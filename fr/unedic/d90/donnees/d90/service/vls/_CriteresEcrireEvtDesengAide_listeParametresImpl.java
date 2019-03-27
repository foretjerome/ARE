package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _CriteresEcrireEvtDesengAide_listeParametresImpl
  extends CriteresEcrireEvtDesengAide_listeParametres
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _CriteresEcrireEvtDesengAide_listeParametres m_criteresEcrireEvtDesengAide_listeParametres;
  
  public _CriteresEcrireEvtDesengAide_listeParametresImpl()
  {
    m_criteresEcrireEvtDesengAide_listeParametres = new _CriteresEcrireEvtDesengAide_listeParametres();
  }
  
  public _CriteresEcrireEvtDesengAide_listeParametresImpl(_CriteresEcrireEvtDesengAide_listeParametres pIn)
  {
    ExceptionUtil.assertMethodParamNotNull("_CriteresEcrireEvtDesengAide_listeParametres", pIn);
    
    m_criteresEcrireEvtDesengAide_listeParametres = pIn;
  }
  
  public Object getObjet()
  {
    return m_criteresEcrireEvtDesengAide_listeParametres;
  }
  
  public String getIdentifiant()
  {
    return m_criteresEcrireEvtDesengAide_listeParametres.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_criteresEcrireEvtDesengAide_listeParametres.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_criteresEcrireEvtDesengAide_listeParametres.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_criteresEcrireEvtDesengAide_listeParametres.set_C_ETAT(pCode);
  }
  
  public _CriteresEcrireEvtDesengAide_listeParametres getCriteresEcrireEvtDesengAide_listeParametresInfra()
  {
    return m_criteresEcrireEvtDesengAide_listeParametres;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    boolean resultat = false;
    for (int i = 0; getNbCriteresEcrireEvtDesengAide_listeParametres() > i; i++) {
      if (getListeParametres(i).isEnErreur())
      {
        resultat = true;
        break;
      }
    }
    return resultat;
  }
  
  public int getNbCriteresEcrireEvtDesengAide_listeParametres()
  {
    if (m_criteresEcrireEvtDesengAide_listeParametres != null)
    {
      DataList liste = m_criteresEcrireEvtDesengAide_listeParametres.getInternalCriteresEcrireEvtDesengAide_listeParametres();
      if (liste != null) {
        return liste.getNbElement();
      }
      return 0;
    }
    return 0;
  }
  
  public int getNbListParametre()
  {
    return getNbCriteresEcrireEvtDesengAide_listeParametres();
  }
  
  public List getListParametre()
  {
    List retour = new ArrayList();
    if (m_criteresEcrireEvtDesengAide_listeParametres != null)
    {
      _Parametre[] table = m_criteresEcrireEvtDesengAide_listeParametres.getListeParametres();
      for (int i = 0; i < table.length; i++) {
        if (table[i] == null) {
          retour.add(null);
        } else {
          retour.add(new _ParametreImpl(table[i]));
        }
      }
    }
    return retour;
  }
  
  public List getListeParametres()
  {
    return (List)m_criteresEcrireEvtDesengAide_listeParametres.getInternalCriteresEcrireEvtDesengAide_listeParametres();
  }
  
  public Parametre getListeParametres(int pIndex)
  {
    Parametre retour = null;
    if ((m_criteresEcrireEvtDesengAide_listeParametres != null) && (m_criteresEcrireEvtDesengAide_listeParametres.getInternalCriteresEcrireEvtDesengAide_listeParametres() != null) && 
      (m_criteresEcrireEvtDesengAide_listeParametres.getNbCriteresEcrireEvtDesengAide_listeParametres() > pIndex) && 
      (m_criteresEcrireEvtDesengAide_listeParametres.getListeParametres()[pIndex] != null)) {
      retour = new _ParametreImpl(m_criteresEcrireEvtDesengAide_listeParametres.getListeParametres()[pIndex]);
    }
    return retour;
  }
  
  public Parametre getListeParametres(String pId)
  {
    for (int i = 0; m_criteresEcrireEvtDesengAide_listeParametres.getListeParametres().length > i; i++) {
      if (m_criteresEcrireEvtDesengAide_listeParametres.getListeParametres()[i].get_IDENT().equals(pId))
      {
        if (m_criteresEcrireEvtDesengAide_listeParametres.getListeParametres()[i] == null) {
          return null;
        }
        return new _ParametreImpl(m_criteresEcrireEvtDesengAide_listeParametres.getListeParametres()[i]);
      }
    }
    return null;
  }
  
  public Parametre addParametre()
  {
    _ParametreImpl item = new _ParametreImpl();
    m_criteresEcrireEvtDesengAide_listeParametres.getInternalCriteresEcrireEvtDesengAide_listeParametres().addElement(item.getParametreInfra());
    return item;
  }
  
  public void addParametre(Parametre pParametre)
  {
    m_criteresEcrireEvtDesengAide_listeParametres.getInternalCriteresEcrireEvtDesengAide_listeParametres().addElement(((_ParametreImpl)pParametre).getParametreInfra());
  }
  
  public Parametre addListeParametres()
  {
    return addParametre();
  }
  
  public void addListeParametres(Parametre pParametre)
  {
    addParametre(pParametre);
  }
  
  public void removeParametre(String pIndex)
  {
    int posTab = 0;
    DataList liste = m_criteresEcrireEvtDesengAide_listeParametres.getInternalCriteresEcrireEvtDesengAide_listeParametres();
    int longueur = liste.getNbElement();
    for (int i = 0; longueur > i; i++) {
      if (((_Parametre)liste.getElement(i)).get_IDENT().equals(pIndex))
      {
        liste.removeElement(i);
        break;
      }
    }
  }
  
  public void removeParametre(Parametre pParametre)
  {
    m_criteresEcrireEvtDesengAide_listeParametres.getInternalCriteresEcrireEvtDesengAide_listeParametres().removeElement(((_ParametreImpl)pParametre).getParametreInfra());
  }
}

/* Location:
 * Qualified Name:     _CriteresEcrireEvtDesengAide_listeParametresImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */