package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ListeFluxFctDnaIndemnitesVerseesImpl
  extends ListeFluxFctDnaIndemnitesVersees
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ListeFluxFctDnaIndemnitesVersees m_listeFluxFctDnaIndemnitesVersees;
  
  public _ListeFluxFctDnaIndemnitesVerseesImpl()
  {
    m_listeFluxFctDnaIndemnitesVersees = new _ListeFluxFctDnaIndemnitesVersees();
  }
  
  public _ListeFluxFctDnaIndemnitesVerseesImpl(_ListeFluxFctDnaIndemnitesVersees pIn)
  {
    ExceptionUtil.assertMethodParamNotNull("_ListeFluxFctDnaIndemnitesVersees", pIn);
    
    m_listeFluxFctDnaIndemnitesVersees = pIn;
  }
  
  public Object getObjet()
  {
    return m_listeFluxFctDnaIndemnitesVersees;
  }
  
  public String getIdentifiant()
  {
    return m_listeFluxFctDnaIndemnitesVersees.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_listeFluxFctDnaIndemnitesVersees.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_listeFluxFctDnaIndemnitesVersees.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_listeFluxFctDnaIndemnitesVersees.set_C_ETAT(pCode);
  }
  
  public _ListeFluxFctDnaIndemnitesVersees getListeFluxFctDnaIndemnitesVerseesInfra()
  {
    return m_listeFluxFctDnaIndemnitesVersees;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    boolean resultat = false;
    for (int i = 0; getNbListeFluxFctDnaIndemnitesVersees() > i; i++) {
      if (getListeFluxFctDnaIndemnitesVersees(i).isEnErreur())
      {
        resultat = true;
        break;
      }
    }
    return resultat;
  }
  
  public int getNbListeFluxFctDnaIndemnitesVersees()
  {
    if (m_listeFluxFctDnaIndemnitesVersees != null)
    {
      DataList liste = m_listeFluxFctDnaIndemnitesVersees.getInternalListeFluxFctDnaIndemnitesVersees();
      if (liste != null) {
        return liste.getNbElement();
      }
      return 0;
    }
    return 0;
  }
  
  public int getNbListFluxFctDnaIndemniteVersee()
  {
    return getNbListeFluxFctDnaIndemnitesVersees();
  }
  
  public List getListFluxFctDnaIndemniteVersee()
  {
    List retour = new ArrayList();
    if (m_listeFluxFctDnaIndemnitesVersees != null)
    {
      _FluxFctDnaIndemniteVersee[] table = m_listeFluxFctDnaIndemnitesVersees.getListeFluxFctDnaIndemnitesVersees();
      for (int i = 0; i < table.length; i++) {
        if (table[i] == null) {
          retour.add(null);
        } else {
          retour.add(new _FluxFctDnaIndemniteVerseeImpl(table[i]));
        }
      }
    }
    return retour;
  }
  
  public List getListeFluxFctDnaIndemnitesVersees()
  {
    return (List)m_listeFluxFctDnaIndemnitesVersees.getInternalListeFluxFctDnaIndemnitesVersees();
  }
  
  public FluxFctDnaIndemniteVersee getListeFluxFctDnaIndemnitesVersees(int pIndex)
  {
    FluxFctDnaIndemniteVersee retour = null;
    if ((m_listeFluxFctDnaIndemnitesVersees != null) && (m_listeFluxFctDnaIndemnitesVersees.getInternalListeFluxFctDnaIndemnitesVersees() != null) && 
      (m_listeFluxFctDnaIndemnitesVersees.getNbListeFluxFctDnaIndemnitesVersees() > pIndex) && 
      (m_listeFluxFctDnaIndemnitesVersees.getListeFluxFctDnaIndemnitesVersees()[pIndex] != null)) {
      retour = new _FluxFctDnaIndemniteVerseeImpl(m_listeFluxFctDnaIndemnitesVersees.getListeFluxFctDnaIndemnitesVersees()[pIndex]);
    }
    return retour;
  }
  
  public FluxFctDnaIndemniteVersee getListeFluxFctDnaIndemnitesVersees(String pId)
  {
    for (int i = 0; m_listeFluxFctDnaIndemnitesVersees.getListeFluxFctDnaIndemnitesVersees().length > i; i++) {
      if (m_listeFluxFctDnaIndemnitesVersees.getListeFluxFctDnaIndemnitesVersees()[i].get_IDENT().equals(pId))
      {
        if (m_listeFluxFctDnaIndemnitesVersees.getListeFluxFctDnaIndemnitesVersees()[i] == null) {
          return null;
        }
        return new _FluxFctDnaIndemniteVerseeImpl(m_listeFluxFctDnaIndemnitesVersees.getListeFluxFctDnaIndemnitesVersees()[i]);
      }
    }
    return null;
  }
  
  public FluxFctDnaIndemniteVersee addFluxFctDnaIndemniteVersee()
  {
    _FluxFctDnaIndemniteVerseeImpl item = new _FluxFctDnaIndemniteVerseeImpl();
    m_listeFluxFctDnaIndemnitesVersees.getInternalListeFluxFctDnaIndemnitesVersees().addElement(item.getFluxFctDnaIndemniteVerseeInfra());
    return item;
  }
  
  public void addFluxFctDnaIndemniteVersee(FluxFctDnaIndemniteVersee pFluxFctDnaIndemniteVersee)
  {
    m_listeFluxFctDnaIndemnitesVersees.getInternalListeFluxFctDnaIndemnitesVersees().addElement(((_FluxFctDnaIndemniteVerseeImpl)pFluxFctDnaIndemniteVersee).getFluxFctDnaIndemniteVerseeInfra());
  }
  
  public FluxFctDnaIndemniteVersee addListeFluxFctDnaIndemnitesVersees()
  {
    return addFluxFctDnaIndemniteVersee();
  }
  
  public void addListeFluxFctDnaIndemnitesVersees(FluxFctDnaIndemniteVersee pFluxFctDnaIndemniteVersee)
  {
    addFluxFctDnaIndemniteVersee(pFluxFctDnaIndemniteVersee);
  }
  
  public void removeFluxFctDnaIndemniteVersee(String pIndex)
  {
    int posTab = 0;
    DataList liste = m_listeFluxFctDnaIndemnitesVersees.getInternalListeFluxFctDnaIndemnitesVersees();
    int longueur = liste.getNbElement();
    for (int i = 0; longueur > i; i++) {
      if (((_FluxFctDnaIndemniteVersee)liste.getElement(i)).get_IDENT().equals(pIndex))
      {
        liste.removeElement(i);
        break;
      }
    }
  }
  
  public void removeFluxFctDnaIndemniteVersee(FluxFctDnaIndemniteVersee pFluxFctDnaIndemniteVersee)
  {
    m_listeFluxFctDnaIndemnitesVersees.getInternalListeFluxFctDnaIndemnitesVersees().removeElement(((_FluxFctDnaIndemniteVerseeImpl)pFluxFctDnaIndemniteVersee).getFluxFctDnaIndemniteVerseeInfra());
  }
}

/* Location:
 * Qualified Name:     _ListeFluxFctDnaIndemnitesVerseesImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */