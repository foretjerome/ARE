package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ListeFluxQuantiteTravailDsnImpl
  extends ListeFluxQuantiteTravailDsn
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ListeFluxQuantiteTravailDsn m_listeFluxQuantiteTravailDsn;
  
  public _ListeFluxQuantiteTravailDsnImpl()
  {
    m_listeFluxQuantiteTravailDsn = new _ListeFluxQuantiteTravailDsn();
  }
  
  public _ListeFluxQuantiteTravailDsnImpl(_ListeFluxQuantiteTravailDsn pIn)
  {
    ExceptionUtil.assertMethodParamNotNull("_ListeFluxQuantiteTravailDsn", pIn);
    
    m_listeFluxQuantiteTravailDsn = pIn;
  }
  
  public Object getObjet()
  {
    return m_listeFluxQuantiteTravailDsn;
  }
  
  public String getIdentifiant()
  {
    return m_listeFluxQuantiteTravailDsn.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_listeFluxQuantiteTravailDsn.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_listeFluxQuantiteTravailDsn.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_listeFluxQuantiteTravailDsn.set_C_ETAT(pCode);
  }
  
  public _ListeFluxQuantiteTravailDsn getListeFluxQuantiteTravailDsnInfra()
  {
    return m_listeFluxQuantiteTravailDsn;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    boolean resultat = false;
    for (int i = 0; getNbListeFluxQuantiteTravailDsn() > i; i++) {
      if (getListeFluxQuantiteTravailDsn(i).isEnErreur())
      {
        resultat = true;
        break;
      }
    }
    return resultat;
  }
  
  public int getNbListeFluxQuantiteTravailDsn()
  {
    if (m_listeFluxQuantiteTravailDsn != null)
    {
      DataList liste = m_listeFluxQuantiteTravailDsn.getInternalListeFluxQuantiteTravailDsn();
      if (liste != null) {
        return liste.getNbElement();
      }
      return 0;
    }
    return 0;
  }
  
  public int getNbListFluxQuantiteTravailDsn()
  {
    return getNbListeFluxQuantiteTravailDsn();
  }
  
  public List getListFluxQuantiteTravailDsn()
  {
    List retour = new ArrayList();
    if (m_listeFluxQuantiteTravailDsn != null)
    {
      _FluxQuantiteTravailDsn[] table = m_listeFluxQuantiteTravailDsn.getListeFluxQuantiteTravailDsn();
      for (int i = 0; i < table.length; i++) {
        if (table[i] == null) {
          retour.add(null);
        } else {
          retour.add(new _FluxQuantiteTravailDsnImpl(table[i]));
        }
      }
    }
    return retour;
  }
  
  public List getListeFluxQuantiteTravailDsn()
  {
    return (List)m_listeFluxQuantiteTravailDsn.getInternalListeFluxQuantiteTravailDsn();
  }
  
  public FluxQuantiteTravailDsn getListeFluxQuantiteTravailDsn(int pIndex)
  {
    FluxQuantiteTravailDsn retour = null;
    if ((m_listeFluxQuantiteTravailDsn != null) && (m_listeFluxQuantiteTravailDsn.getInternalListeFluxQuantiteTravailDsn() != null) && 
      (m_listeFluxQuantiteTravailDsn.getNbListeFluxQuantiteTravailDsn() > pIndex) && 
      (m_listeFluxQuantiteTravailDsn.getListeFluxQuantiteTravailDsn()[pIndex] != null)) {
      retour = new _FluxQuantiteTravailDsnImpl(m_listeFluxQuantiteTravailDsn.getListeFluxQuantiteTravailDsn()[pIndex]);
    }
    return retour;
  }
  
  public FluxQuantiteTravailDsn getListeFluxQuantiteTravailDsn(String pId)
  {
    for (int i = 0; m_listeFluxQuantiteTravailDsn.getListeFluxQuantiteTravailDsn().length > i; i++) {
      if (m_listeFluxQuantiteTravailDsn.getListeFluxQuantiteTravailDsn()[i].get_IDENT().equals(pId))
      {
        if (m_listeFluxQuantiteTravailDsn.getListeFluxQuantiteTravailDsn()[i] == null) {
          return null;
        }
        return new _FluxQuantiteTravailDsnImpl(m_listeFluxQuantiteTravailDsn.getListeFluxQuantiteTravailDsn()[i]);
      }
    }
    return null;
  }
  
  public FluxQuantiteTravailDsn addFluxQuantiteTravailDsn()
  {
    _FluxQuantiteTravailDsnImpl item = new _FluxQuantiteTravailDsnImpl();
    m_listeFluxQuantiteTravailDsn.getInternalListeFluxQuantiteTravailDsn().addElement(item.getFluxQuantiteTravailDsnInfra());
    return item;
  }
  
  public void addFluxQuantiteTravailDsn(FluxQuantiteTravailDsn pFluxQuantiteTravailDsn)
  {
    m_listeFluxQuantiteTravailDsn.getInternalListeFluxQuantiteTravailDsn().addElement(((_FluxQuantiteTravailDsnImpl)pFluxQuantiteTravailDsn).getFluxQuantiteTravailDsnInfra());
  }
  
  public FluxQuantiteTravailDsn addListeFluxQuantiteTravailDsn()
  {
    return addFluxQuantiteTravailDsn();
  }
  
  public void addListeFluxQuantiteTravailDsn(FluxQuantiteTravailDsn pFluxQuantiteTravailDsn)
  {
    addFluxQuantiteTravailDsn(pFluxQuantiteTravailDsn);
  }
  
  public void removeFluxQuantiteTravailDsn(String pIndex)
  {
    int posTab = 0;
    DataList liste = m_listeFluxQuantiteTravailDsn.getInternalListeFluxQuantiteTravailDsn();
    int longueur = liste.getNbElement();
    for (int i = 0; longueur > i; i++) {
      if (((_FluxQuantiteTravailDsn)liste.getElement(i)).get_IDENT().equals(pIndex))
      {
        liste.removeElement(i);
        break;
      }
    }
  }
  
  public void removeFluxQuantiteTravailDsn(FluxQuantiteTravailDsn pFluxQuantiteTravailDsn)
  {
    m_listeFluxQuantiteTravailDsn.getInternalListeFluxQuantiteTravailDsn().removeElement(((_FluxQuantiteTravailDsnImpl)pFluxQuantiteTravailDsn).getFluxQuantiteTravailDsnInfra());
  }
}

/* Location:
 * Qualified Name:     _ListeFluxQuantiteTravailDsnImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */