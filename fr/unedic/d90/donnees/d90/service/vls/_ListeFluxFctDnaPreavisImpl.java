package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ListeFluxFctDnaPreavisImpl
  extends ListeFluxFctDnaPreavis
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ListeFluxFctDnaPreavis m_listeFluxFctDnaPreavis;
  
  public _ListeFluxFctDnaPreavisImpl()
  {
    m_listeFluxFctDnaPreavis = new _ListeFluxFctDnaPreavis();
  }
  
  public _ListeFluxFctDnaPreavisImpl(_ListeFluxFctDnaPreavis pIn)
  {
    ExceptionUtil.assertMethodParamNotNull("_ListeFluxFctDnaPreavis", pIn);
    
    m_listeFluxFctDnaPreavis = pIn;
  }
  
  public Object getObjet()
  {
    return m_listeFluxFctDnaPreavis;
  }
  
  public String getIdentifiant()
  {
    return m_listeFluxFctDnaPreavis.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_listeFluxFctDnaPreavis.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_listeFluxFctDnaPreavis.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_listeFluxFctDnaPreavis.set_C_ETAT(pCode);
  }
  
  public _ListeFluxFctDnaPreavis getListeFluxFctDnaPreavisInfra()
  {
    return m_listeFluxFctDnaPreavis;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    boolean resultat = false;
    for (int i = 0; getNbListeFluxFctDnaPreavis() > i; i++) {
      if (getListeFluxFctDnaPreavis(i).isEnErreur())
      {
        resultat = true;
        break;
      }
    }
    return resultat;
  }
  
  public int getNbListeFluxFctDnaPreavis()
  {
    if (m_listeFluxFctDnaPreavis != null)
    {
      DataList liste = m_listeFluxFctDnaPreavis.getInternalListeFluxFctDnaPreavis();
      if (liste != null) {
        return liste.getNbElement();
      }
      return 0;
    }
    return 0;
  }
  
  public int getNbListFluxFctDnaPreavis()
  {
    return getNbListeFluxFctDnaPreavis();
  }
  
  public List getListFluxFctDnaPreavis()
  {
    List retour = new ArrayList();
    if (m_listeFluxFctDnaPreavis != null)
    {
      _FluxFctDnaPreavis[] table = m_listeFluxFctDnaPreavis.getListeFluxFctDnaPreavis();
      for (int i = 0; i < table.length; i++) {
        if (table[i] == null) {
          retour.add(null);
        } else {
          retour.add(new _FluxFctDnaPreavisImpl(table[i]));
        }
      }
    }
    return retour;
  }
  
  public List getListeFluxFctDnaPreavis()
  {
    return (List)m_listeFluxFctDnaPreavis.getInternalListeFluxFctDnaPreavis();
  }
  
  public FluxFctDnaPreavis getListeFluxFctDnaPreavis(int pIndex)
  {
    FluxFctDnaPreavis retour = null;
    if ((m_listeFluxFctDnaPreavis != null) && (m_listeFluxFctDnaPreavis.getInternalListeFluxFctDnaPreavis() != null) && 
      (m_listeFluxFctDnaPreavis.getNbListeFluxFctDnaPreavis() > pIndex) && 
      (m_listeFluxFctDnaPreavis.getListeFluxFctDnaPreavis()[pIndex] != null)) {
      retour = new _FluxFctDnaPreavisImpl(m_listeFluxFctDnaPreavis.getListeFluxFctDnaPreavis()[pIndex]);
    }
    return retour;
  }
  
  public FluxFctDnaPreavis getListeFluxFctDnaPreavis(String pId)
  {
    for (int i = 0; m_listeFluxFctDnaPreavis.getListeFluxFctDnaPreavis().length > i; i++) {
      if (m_listeFluxFctDnaPreavis.getListeFluxFctDnaPreavis()[i].get_IDENT().equals(pId))
      {
        if (m_listeFluxFctDnaPreavis.getListeFluxFctDnaPreavis()[i] == null) {
          return null;
        }
        return new _FluxFctDnaPreavisImpl(m_listeFluxFctDnaPreavis.getListeFluxFctDnaPreavis()[i]);
      }
    }
    return null;
  }
  
  public FluxFctDnaPreavis addFluxFctDnaPreavis()
  {
    _FluxFctDnaPreavisImpl item = new _FluxFctDnaPreavisImpl();
    m_listeFluxFctDnaPreavis.getInternalListeFluxFctDnaPreavis().addElement(item.getFluxFctDnaPreavisInfra());
    return item;
  }
  
  public void addFluxFctDnaPreavis(FluxFctDnaPreavis pFluxFctDnaPreavis)
  {
    m_listeFluxFctDnaPreavis.getInternalListeFluxFctDnaPreavis().addElement(((_FluxFctDnaPreavisImpl)pFluxFctDnaPreavis).getFluxFctDnaPreavisInfra());
  }
  
  public FluxFctDnaPreavis addListeFluxFctDnaPreavis()
  {
    return addFluxFctDnaPreavis();
  }
  
  public void addListeFluxFctDnaPreavis(FluxFctDnaPreavis pFluxFctDnaPreavis)
  {
    addFluxFctDnaPreavis(pFluxFctDnaPreavis);
  }
  
  public void removeFluxFctDnaPreavis(String pIndex)
  {
    int posTab = 0;
    DataList liste = m_listeFluxFctDnaPreavis.getInternalListeFluxFctDnaPreavis();
    int longueur = liste.getNbElement();
    for (int i = 0; longueur > i; i++) {
      if (((_FluxFctDnaPreavis)liste.getElement(i)).get_IDENT().equals(pIndex))
      {
        liste.removeElement(i);
        break;
      }
    }
  }
  
  public void removeFluxFctDnaPreavis(FluxFctDnaPreavis pFluxFctDnaPreavis)
  {
    m_listeFluxFctDnaPreavis.getInternalListeFluxFctDnaPreavis().removeElement(((_FluxFctDnaPreavisImpl)pFluxFctDnaPreavis).getFluxFctDnaPreavisInfra());
  }
}

/* Location:
 * Qualified Name:     _ListeFluxFctDnaPreavisImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */