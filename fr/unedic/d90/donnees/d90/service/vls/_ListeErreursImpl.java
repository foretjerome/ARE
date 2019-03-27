package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ListeErreursImpl
  extends ListeErreurs
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ListeErreurs m_listeErreurs;
  
  public _ListeErreursImpl()
  {
    m_listeErreurs = new _ListeErreurs();
  }
  
  public _ListeErreursImpl(_ListeErreurs pIn)
  {
    ExceptionUtil.assertMethodParamNotNull("_ListeErreurs", pIn);
    
    m_listeErreurs = pIn;
  }
  
  public Object getObjet()
  {
    return m_listeErreurs;
  }
  
  public String getIdentifiant()
  {
    return m_listeErreurs.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_listeErreurs.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_listeErreurs.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_listeErreurs.set_C_ETAT(pCode);
  }
  
  public _ListeErreurs getListeErreursInfra()
  {
    return m_listeErreurs;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    boolean resultat = false;
    for (int i = 0; getNbListeErreurs() > i; i++) {
      if (getListeErreurs(i).isEnErreur())
      {
        resultat = true;
        break;
      }
    }
    return resultat;
  }
  
  public int getNbListeErreurs()
  {
    if (m_listeErreurs != null)
    {
      DataList liste = m_listeErreurs.getInternalListeErreurs();
      if (liste != null) {
        return liste.getNbElement();
      }
      return 0;
    }
    return 0;
  }
  
  public int getNbListErreur()
  {
    return getNbListeErreurs();
  }
  
  public List getListErreur()
  {
    List retour = new ArrayList();
    if (m_listeErreurs != null)
    {
      _Erreur[] table = m_listeErreurs.getListeErreurs();
      for (int i = 0; i < table.length; i++) {
        if (table[i] == null) {
          retour.add(null);
        } else {
          retour.add(new _ErreurImpl(table[i]));
        }
      }
    }
    return retour;
  }
  
  public List getListeErreurs()
  {
    return (List)m_listeErreurs.getInternalListeErreurs();
  }
  
  public Erreur getListeErreurs(int pIndex)
  {
    Erreur retour = null;
    if ((m_listeErreurs != null) && (m_listeErreurs.getInternalListeErreurs() != null) && 
      (m_listeErreurs.getNbListeErreurs() > pIndex) && 
      (m_listeErreurs.getListeErreurs()[pIndex] != null)) {
      retour = new _ErreurImpl(m_listeErreurs.getListeErreurs()[pIndex]);
    }
    return retour;
  }
  
  public Erreur getListeErreurs(String pId)
  {
    for (int i = 0; m_listeErreurs.getListeErreurs().length > i; i++) {
      if (m_listeErreurs.getListeErreurs()[i].get_IDENT().equals(pId))
      {
        if (m_listeErreurs.getListeErreurs()[i] == null) {
          return null;
        }
        return new _ErreurImpl(m_listeErreurs.getListeErreurs()[i]);
      }
    }
    return null;
  }
  
  public Erreur addErreur()
  {
    _ErreurImpl item = new _ErreurImpl();
    m_listeErreurs.getInternalListeErreurs().addElement(item.getErreurInfra());
    return item;
  }
  
  public void addErreur(Erreur pErreur)
  {
    m_listeErreurs.getInternalListeErreurs().addElement(((_ErreurImpl)pErreur).getErreurInfra());
  }
  
  public Erreur addListeErreurs()
  {
    return addErreur();
  }
  
  public void addListeErreurs(Erreur pErreur)
  {
    addErreur(pErreur);
  }
  
  public void removeErreur(String pIndex)
  {
    int posTab = 0;
    DataList liste = m_listeErreurs.getInternalListeErreurs();
    int longueur = liste.getNbElement();
    for (int i = 0; longueur > i; i++) {
      if (((_Erreur)liste.getElement(i)).get_IDENT().equals(pIndex))
      {
        liste.removeElement(i);
        break;
      }
    }
  }
  
  public void removeErreur(Erreur pErreur)
  {
    m_listeErreurs.getInternalListeErreurs().removeElement(((_ErreurImpl)pErreur).getErreurInfra());
  }
}

/* Location:
 * Qualified Name:     _ListeErreursImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */