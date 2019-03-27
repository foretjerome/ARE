package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ListeIndicateursImpl
  extends ListeIndicateurs
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ListeIndicateurs m_listeIndicateurs;
  
  public _ListeIndicateursImpl()
  {
    m_listeIndicateurs = new _ListeIndicateurs();
  }
  
  public _ListeIndicateursImpl(_ListeIndicateurs pIn)
  {
    ExceptionUtil.assertMethodParamNotNull("_ListeIndicateurs", pIn);
    
    m_listeIndicateurs = pIn;
  }
  
  public Object getObjet()
  {
    return m_listeIndicateurs;
  }
  
  public String getIdentifiant()
  {
    return m_listeIndicateurs.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_listeIndicateurs.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_listeIndicateurs.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_listeIndicateurs.set_C_ETAT(pCode);
  }
  
  public _ListeIndicateurs getListeIndicateursInfra()
  {
    return m_listeIndicateurs;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    boolean resultat = false;
    for (int i = 0; getNbListeIndicateurs() > i; i++) {
      if (getListeIndicateurs(i).isEnErreur())
      {
        resultat = true;
        break;
      }
    }
    return resultat;
  }
  
  public int getNbListeIndicateurs()
  {
    if (m_listeIndicateurs != null)
    {
      DataList liste = m_listeIndicateurs.getInternalListeIndicateurs();
      if (liste != null) {
        return liste.getNbElement();
      }
      return 0;
    }
    return 0;
  }
  
  public int getNbListIndicateur()
  {
    return getNbListeIndicateurs();
  }
  
  public List getListIndicateur()
  {
    List retour = new ArrayList();
    if (m_listeIndicateurs != null)
    {
      _Indicateur[] table = m_listeIndicateurs.getListeIndicateurs();
      for (int i = 0; i < table.length; i++) {
        if (table[i] == null) {
          retour.add(null);
        } else {
          retour.add(new _IndicateurImpl(table[i]));
        }
      }
    }
    return retour;
  }
  
  public List getListeIndicateurs()
  {
    return (List)m_listeIndicateurs.getInternalListeIndicateurs();
  }
  
  public Indicateur getListeIndicateurs(int pIndex)
  {
    Indicateur retour = null;
    if ((m_listeIndicateurs != null) && (m_listeIndicateurs.getInternalListeIndicateurs() != null) && 
      (m_listeIndicateurs.getNbListeIndicateurs() > pIndex) && 
      (m_listeIndicateurs.getListeIndicateurs()[pIndex] != null)) {
      retour = new _IndicateurImpl(m_listeIndicateurs.getListeIndicateurs()[pIndex]);
    }
    return retour;
  }
  
  public Indicateur getListeIndicateurs(String pId)
  {
    for (int i = 0; m_listeIndicateurs.getListeIndicateurs().length > i; i++) {
      if (m_listeIndicateurs.getListeIndicateurs()[i].get_IDENT().equals(pId))
      {
        if (m_listeIndicateurs.getListeIndicateurs()[i] == null) {
          return null;
        }
        return new _IndicateurImpl(m_listeIndicateurs.getListeIndicateurs()[i]);
      }
    }
    return null;
  }
  
  public Indicateur addIndicateur()
  {
    _IndicateurImpl item = new _IndicateurImpl();
    m_listeIndicateurs.getInternalListeIndicateurs().addElement(item.getIndicateurInfra());
    return item;
  }
  
  public void addIndicateur(Indicateur pIndicateur)
  {
    m_listeIndicateurs.getInternalListeIndicateurs().addElement(((_IndicateurImpl)pIndicateur).getIndicateurInfra());
  }
  
  public Indicateur addListeIndicateurs()
  {
    return addIndicateur();
  }
  
  public void addListeIndicateurs(Indicateur pIndicateur)
  {
    addIndicateur(pIndicateur);
  }
  
  public void removeIndicateur(String pIndex)
  {
    int posTab = 0;
    DataList liste = m_listeIndicateurs.getInternalListeIndicateurs();
    int longueur = liste.getNbElement();
    for (int i = 0; longueur > i; i++) {
      if (((_Indicateur)liste.getElement(i)).get_IDENT().equals(pIndex))
      {
        liste.removeElement(i);
        break;
      }
    }
  }
  
  public void removeIndicateur(Indicateur pIndicateur)
  {
    m_listeIndicateurs.getInternalListeIndicateurs().removeElement(((_IndicateurImpl)pIndicateur).getIndicateurInfra());
  }
}

/* Location:
 * Qualified Name:     _ListeIndicateursImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */