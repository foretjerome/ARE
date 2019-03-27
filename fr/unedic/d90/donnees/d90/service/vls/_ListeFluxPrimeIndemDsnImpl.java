package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ListeFluxPrimeIndemDsnImpl
  extends ListeFluxPrimeIndemDsn
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ListeFluxPrimeIndemDsn m_listeFluxPrimeIndemDsn;
  
  public _ListeFluxPrimeIndemDsnImpl()
  {
    m_listeFluxPrimeIndemDsn = new _ListeFluxPrimeIndemDsn();
  }
  
  public _ListeFluxPrimeIndemDsnImpl(_ListeFluxPrimeIndemDsn pIn)
  {
    ExceptionUtil.assertMethodParamNotNull("_ListeFluxPrimeIndemDsn", pIn);
    
    m_listeFluxPrimeIndemDsn = pIn;
  }
  
  public Object getObjet()
  {
    return m_listeFluxPrimeIndemDsn;
  }
  
  public String getIdentifiant()
  {
    return m_listeFluxPrimeIndemDsn.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_listeFluxPrimeIndemDsn.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_listeFluxPrimeIndemDsn.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_listeFluxPrimeIndemDsn.set_C_ETAT(pCode);
  }
  
  public _ListeFluxPrimeIndemDsn getListeFluxPrimeIndemDsnInfra()
  {
    return m_listeFluxPrimeIndemDsn;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    boolean resultat = false;
    for (int i = 0; getNbListeFluxPrimeIndemDsn() > i; i++) {
      if (getListeFluxPrimeIndemDsn(i).isEnErreur())
      {
        resultat = true;
        break;
      }
    }
    return resultat;
  }
  
  public int getNbListeFluxPrimeIndemDsn()
  {
    if (m_listeFluxPrimeIndemDsn != null)
    {
      DataList liste = m_listeFluxPrimeIndemDsn.getInternalListeFluxPrimeIndemDsn();
      if (liste != null) {
        return liste.getNbElement();
      }
      return 0;
    }
    return 0;
  }
  
  public int getNbListFluxPrimeIndemDsn()
  {
    return getNbListeFluxPrimeIndemDsn();
  }
  
  public List getListFluxPrimeIndemDsn()
  {
    List retour = new ArrayList();
    if (m_listeFluxPrimeIndemDsn != null)
    {
      _FluxPrimeIndemDsn[] table = m_listeFluxPrimeIndemDsn.getListeFluxPrimeIndemDsn();
      for (int i = 0; i < table.length; i++) {
        if (table[i] == null) {
          retour.add(null);
        } else {
          retour.add(new _FluxPrimeIndemDsnImpl(table[i]));
        }
      }
    }
    return retour;
  }
  
  public List getListeFluxPrimeIndemDsn()
  {
    return (List)m_listeFluxPrimeIndemDsn.getInternalListeFluxPrimeIndemDsn();
  }
  
  public FluxPrimeIndemDsn getListeFluxPrimeIndemDsn(int pIndex)
  {
    FluxPrimeIndemDsn retour = null;
    if ((m_listeFluxPrimeIndemDsn != null) && (m_listeFluxPrimeIndemDsn.getInternalListeFluxPrimeIndemDsn() != null) && 
      (m_listeFluxPrimeIndemDsn.getNbListeFluxPrimeIndemDsn() > pIndex) && 
      (m_listeFluxPrimeIndemDsn.getListeFluxPrimeIndemDsn()[pIndex] != null)) {
      retour = new _FluxPrimeIndemDsnImpl(m_listeFluxPrimeIndemDsn.getListeFluxPrimeIndemDsn()[pIndex]);
    }
    return retour;
  }
  
  public FluxPrimeIndemDsn getListeFluxPrimeIndemDsn(String pId)
  {
    for (int i = 0; m_listeFluxPrimeIndemDsn.getListeFluxPrimeIndemDsn().length > i; i++) {
      if (m_listeFluxPrimeIndemDsn.getListeFluxPrimeIndemDsn()[i].get_IDENT().equals(pId))
      {
        if (m_listeFluxPrimeIndemDsn.getListeFluxPrimeIndemDsn()[i] == null) {
          return null;
        }
        return new _FluxPrimeIndemDsnImpl(m_listeFluxPrimeIndemDsn.getListeFluxPrimeIndemDsn()[i]);
      }
    }
    return null;
  }
  
  public FluxPrimeIndemDsn addFluxPrimeIndemDsn()
  {
    _FluxPrimeIndemDsnImpl item = new _FluxPrimeIndemDsnImpl();
    m_listeFluxPrimeIndemDsn.getInternalListeFluxPrimeIndemDsn().addElement(item.getFluxPrimeIndemDsnInfra());
    return item;
  }
  
  public void addFluxPrimeIndemDsn(FluxPrimeIndemDsn pFluxPrimeIndemDsn)
  {
    m_listeFluxPrimeIndemDsn.getInternalListeFluxPrimeIndemDsn().addElement(((_FluxPrimeIndemDsnImpl)pFluxPrimeIndemDsn).getFluxPrimeIndemDsnInfra());
  }
  
  public FluxPrimeIndemDsn addListeFluxPrimeIndemDsn()
  {
    return addFluxPrimeIndemDsn();
  }
  
  public void addListeFluxPrimeIndemDsn(FluxPrimeIndemDsn pFluxPrimeIndemDsn)
  {
    addFluxPrimeIndemDsn(pFluxPrimeIndemDsn);
  }
  
  public void removeFluxPrimeIndemDsn(String pIndex)
  {
    int posTab = 0;
    DataList liste = m_listeFluxPrimeIndemDsn.getInternalListeFluxPrimeIndemDsn();
    int longueur = liste.getNbElement();
    for (int i = 0; longueur > i; i++) {
      if (((_FluxPrimeIndemDsn)liste.getElement(i)).get_IDENT().equals(pIndex))
      {
        liste.removeElement(i);
        break;
      }
    }
  }
  
  public void removeFluxPrimeIndemDsn(FluxPrimeIndemDsn pFluxPrimeIndemDsn)
  {
    m_listeFluxPrimeIndemDsn.getInternalListeFluxPrimeIndemDsn().removeElement(((_FluxPrimeIndemDsnImpl)pFluxPrimeIndemDsn).getFluxPrimeIndemDsnInfra());
  }
}

/* Location:
 * Qualified Name:     _ListeFluxPrimeIndemDsnImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */