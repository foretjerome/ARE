package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ListeFluxPasDnaQuantiteTravailImpl
  extends ListeFluxPasDnaQuantiteTravail
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ListeFluxPasDnaQuantiteTravail m_listeFluxPasDnaQuantiteTravail;
  
  public _ListeFluxPasDnaQuantiteTravailImpl()
  {
    m_listeFluxPasDnaQuantiteTravail = new _ListeFluxPasDnaQuantiteTravail();
  }
  
  public _ListeFluxPasDnaQuantiteTravailImpl(_ListeFluxPasDnaQuantiteTravail pIn)
  {
    ExceptionUtil.assertMethodParamNotNull("_ListeFluxPasDnaQuantiteTravail", pIn);
    
    m_listeFluxPasDnaQuantiteTravail = pIn;
  }
  
  public Object getObjet()
  {
    return m_listeFluxPasDnaQuantiteTravail;
  }
  
  public String getIdentifiant()
  {
    return m_listeFluxPasDnaQuantiteTravail.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_listeFluxPasDnaQuantiteTravail.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_listeFluxPasDnaQuantiteTravail.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_listeFluxPasDnaQuantiteTravail.set_C_ETAT(pCode);
  }
  
  public _ListeFluxPasDnaQuantiteTravail getListeFluxPasDnaQuantiteTravailInfra()
  {
    return m_listeFluxPasDnaQuantiteTravail;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    boolean resultat = false;
    for (int i = 0; getNbListeFluxPasDnaQuantiteTravail() > i; i++) {
      if (getListeFluxPasDnaQuantiteTravail(i).isEnErreur())
      {
        resultat = true;
        break;
      }
    }
    return resultat;
  }
  
  public int getNbListeFluxPasDnaQuantiteTravail()
  {
    if (m_listeFluxPasDnaQuantiteTravail != null)
    {
      DataList liste = m_listeFluxPasDnaQuantiteTravail.getInternalListeFluxPasDnaQuantiteTravail();
      if (liste != null) {
        return liste.getNbElement();
      }
      return 0;
    }
    return 0;
  }
  
  public int getNbListFluxPasDnaQuantiteTravail()
  {
    return getNbListeFluxPasDnaQuantiteTravail();
  }
  
  public List getListFluxPasDnaQuantiteTravail()
  {
    List retour = new ArrayList();
    if (m_listeFluxPasDnaQuantiteTravail != null)
    {
      _FluxPasDnaQuantiteTravail[] table = m_listeFluxPasDnaQuantiteTravail.getListeFluxPasDnaQuantiteTravail();
      for (int i = 0; i < table.length; i++) {
        if (table[i] == null) {
          retour.add(null);
        } else {
          retour.add(new _FluxPasDnaQuantiteTravailImpl(table[i]));
        }
      }
    }
    return retour;
  }
  
  public List getListeFluxPasDnaQuantiteTravail()
  {
    return (List)m_listeFluxPasDnaQuantiteTravail.getInternalListeFluxPasDnaQuantiteTravail();
  }
  
  public FluxPasDnaQuantiteTravail getListeFluxPasDnaQuantiteTravail(int pIndex)
  {
    FluxPasDnaQuantiteTravail retour = null;
    if ((m_listeFluxPasDnaQuantiteTravail != null) && (m_listeFluxPasDnaQuantiteTravail.getInternalListeFluxPasDnaQuantiteTravail() != null) && 
      (m_listeFluxPasDnaQuantiteTravail.getNbListeFluxPasDnaQuantiteTravail() > pIndex) && 
      (m_listeFluxPasDnaQuantiteTravail.getListeFluxPasDnaQuantiteTravail()[pIndex] != null)) {
      retour = new _FluxPasDnaQuantiteTravailImpl(m_listeFluxPasDnaQuantiteTravail.getListeFluxPasDnaQuantiteTravail()[pIndex]);
    }
    return retour;
  }
  
  public FluxPasDnaQuantiteTravail getListeFluxPasDnaQuantiteTravail(String pId)
  {
    for (int i = 0; m_listeFluxPasDnaQuantiteTravail.getListeFluxPasDnaQuantiteTravail().length > i; i++) {
      if (m_listeFluxPasDnaQuantiteTravail.getListeFluxPasDnaQuantiteTravail()[i].get_IDENT().equals(pId))
      {
        if (m_listeFluxPasDnaQuantiteTravail.getListeFluxPasDnaQuantiteTravail()[i] == null) {
          return null;
        }
        return new _FluxPasDnaQuantiteTravailImpl(m_listeFluxPasDnaQuantiteTravail.getListeFluxPasDnaQuantiteTravail()[i]);
      }
    }
    return null;
  }
  
  public FluxPasDnaQuantiteTravail addFluxPasDnaQuantiteTravail()
  {
    _FluxPasDnaQuantiteTravailImpl item = new _FluxPasDnaQuantiteTravailImpl();
    m_listeFluxPasDnaQuantiteTravail.getInternalListeFluxPasDnaQuantiteTravail().addElement(item.getFluxPasDnaQuantiteTravailInfra());
    return item;
  }
  
  public void addFluxPasDnaQuantiteTravail(FluxPasDnaQuantiteTravail pFluxPasDnaQuantiteTravail)
  {
    m_listeFluxPasDnaQuantiteTravail.getInternalListeFluxPasDnaQuantiteTravail().addElement(((_FluxPasDnaQuantiteTravailImpl)pFluxPasDnaQuantiteTravail).getFluxPasDnaQuantiteTravailInfra());
  }
  
  public FluxPasDnaQuantiteTravail addListeFluxPasDnaQuantiteTravail()
  {
    return addFluxPasDnaQuantiteTravail();
  }
  
  public void addListeFluxPasDnaQuantiteTravail(FluxPasDnaQuantiteTravail pFluxPasDnaQuantiteTravail)
  {
    addFluxPasDnaQuantiteTravail(pFluxPasDnaQuantiteTravail);
  }
  
  public void removeFluxPasDnaQuantiteTravail(String pIndex)
  {
    int posTab = 0;
    DataList liste = m_listeFluxPasDnaQuantiteTravail.getInternalListeFluxPasDnaQuantiteTravail();
    int longueur = liste.getNbElement();
    for (int i = 0; longueur > i; i++) {
      if (((_FluxPasDnaQuantiteTravail)liste.getElement(i)).get_IDENT().equals(pIndex))
      {
        liste.removeElement(i);
        break;
      }
    }
  }
  
  public void removeFluxPasDnaQuantiteTravail(FluxPasDnaQuantiteTravail pFluxPasDnaQuantiteTravail)
  {
    m_listeFluxPasDnaQuantiteTravail.getInternalListeFluxPasDnaQuantiteTravail().removeElement(((_FluxPasDnaQuantiteTravailImpl)pFluxPasDnaQuantiteTravail).getFluxPasDnaQuantiteTravailInfra());
  }
}

/* Location:
 * Qualified Name:     _ListeFluxPasDnaQuantiteTravailImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */