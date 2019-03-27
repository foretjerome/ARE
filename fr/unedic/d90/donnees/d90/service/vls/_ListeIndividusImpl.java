package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ListeIndividusImpl
  extends ListeIndividus
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ListeIndividus m_listeIndividus;
  
  public _ListeIndividusImpl()
  {
    m_listeIndividus = new _ListeIndividus();
  }
  
  public _ListeIndividusImpl(_ListeIndividus pIn)
  {
    ExceptionUtil.assertMethodParamNotNull("_ListeIndividus", pIn);
    
    m_listeIndividus = pIn;
  }
  
  public Object getObjet()
  {
    return m_listeIndividus;
  }
  
  public String getIdentifiant()
  {
    return m_listeIndividus.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_listeIndividus.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_listeIndividus.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_listeIndividus.set_C_ETAT(pCode);
  }
  
  public _ListeIndividus getListeIndividusInfra()
  {
    return m_listeIndividus;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    boolean resultat = false;
    for (int i = 0; getNbListeIndividus() > i; i++) {
      if (getListeIndividus(i).isEnErreur())
      {
        resultat = true;
        break;
      }
    }
    return resultat;
  }
  
  public int getNbListeIndividus()
  {
    if (m_listeIndividus != null)
    {
      DataList liste = m_listeIndividus.getInternalListeIndividus();
      if (liste != null) {
        return liste.getNbElement();
      }
      return 0;
    }
    return 0;
  }
  
  public int getNbListIndividu()
  {
    return getNbListeIndividus();
  }
  
  public List getListIndividu()
  {
    List retour = new ArrayList();
    if (m_listeIndividus != null)
    {
      _Individu[] table = m_listeIndividus.getListeIndividus();
      for (int i = 0; i < table.length; i++) {
        if (table[i] == null) {
          retour.add(null);
        } else {
          retour.add(new _IndividuImpl(table[i]));
        }
      }
    }
    return retour;
  }
  
  public List getListeIndividus()
  {
    return (List)m_listeIndividus.getInternalListeIndividus();
  }
  
  public Individu getListeIndividus(int pIndex)
  {
    Individu retour = null;
    if ((m_listeIndividus != null) && (m_listeIndividus.getInternalListeIndividus() != null) && 
      (m_listeIndividus.getNbListeIndividus() > pIndex) && 
      (m_listeIndividus.getListeIndividus()[pIndex] != null)) {
      retour = new _IndividuImpl(m_listeIndividus.getListeIndividus()[pIndex]);
    }
    return retour;
  }
  
  public Individu getListeIndividus(String pId)
  {
    for (int i = 0; m_listeIndividus.getListeIndividus().length > i; i++) {
      if (m_listeIndividus.getListeIndividus()[i].get_IDENT().equals(pId))
      {
        if (m_listeIndividus.getListeIndividus()[i] == null) {
          return null;
        }
        return new _IndividuImpl(m_listeIndividus.getListeIndividus()[i]);
      }
    }
    return null;
  }
  
  public Individu addIndividu()
  {
    _IndividuImpl item = new _IndividuImpl();
    m_listeIndividus.getInternalListeIndividus().addElement(item.getIndividuInfra());
    return item;
  }
  
  public void addIndividu(Individu pIndividu)
  {
    m_listeIndividus.getInternalListeIndividus().addElement(((_IndividuImpl)pIndividu).getIndividuInfra());
  }
  
  public Individu addListeIndividus()
  {
    return addIndividu();
  }
  
  public void addListeIndividus(Individu pIndividu)
  {
    addIndividu(pIndividu);
  }
  
  public void removeIndividu(String pIndex)
  {
    int posTab = 0;
    DataList liste = m_listeIndividus.getInternalListeIndividus();
    int longueur = liste.getNbElement();
    for (int i = 0; longueur > i; i++) {
      if (((_Individu)liste.getElement(i)).get_IDENT().equals(pIndex))
      {
        liste.removeElement(i);
        break;
      }
    }
  }
  
  public void removeIndividu(Individu pIndividu)
  {
    m_listeIndividus.getInternalListeIndividus().removeElement(((_IndividuImpl)pIndividu).getIndividuInfra());
  }
}

/* Location:
 * Qualified Name:     _ListeIndividusImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */