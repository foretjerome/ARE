package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ListeFluxPrimIndemDsnImpl
  extends ListeFluxPrimIndemDsn
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ListeFluxPrimIndemDsn m_listeFluxPrimIndemDsn;
  
  public _ListeFluxPrimIndemDsnImpl()
  {
    m_listeFluxPrimIndemDsn = new _ListeFluxPrimIndemDsn();
  }
  
  public _ListeFluxPrimIndemDsnImpl(_ListeFluxPrimIndemDsn pIn)
  {
    ExceptionUtil.assertMethodParamNotNull("_ListeFluxPrimIndemDsn", pIn);
    
    m_listeFluxPrimIndemDsn = pIn;
  }
  
  public Object getObjet()
  {
    return m_listeFluxPrimIndemDsn;
  }
  
  public String getIdentifiant()
  {
    return m_listeFluxPrimIndemDsn.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_listeFluxPrimIndemDsn.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_listeFluxPrimIndemDsn.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_listeFluxPrimIndemDsn.set_C_ETAT(pCode);
  }
  
  public _ListeFluxPrimIndemDsn getListeFluxPrimIndemDsnInfra()
  {
    return m_listeFluxPrimIndemDsn;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    boolean resultat = false;
    for (int i = 0; getNbListeFluxPrimIndemDsn() > i; i++) {
      if (getListeFluxPrimIndemDsn(i).isEnErreur())
      {
        resultat = true;
        break;
      }
    }
    return resultat;
  }
  
  public int getNbListeFluxPrimIndemDsn()
  {
    if (m_listeFluxPrimIndemDsn != null)
    {
      DataList liste = m_listeFluxPrimIndemDsn.getInternalListeFluxPrimIndemDsn();
      if (liste != null) {
        return liste.getNbElement();
      }
      return 0;
    }
    return 0;
  }
  
  public int getNbListFluxPrimeIndemDsn()
  {
    return getNbListeFluxPrimIndemDsn();
  }
  
  public List getListFluxPrimeIndemDsn()
  {
    List retour = new ArrayList();
    if (m_listeFluxPrimIndemDsn != null)
    {
      _FluxPrimeIndemDsn[] table = m_listeFluxPrimIndemDsn.getListeFluxPrimIndemDsn();
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
    return (List)m_listeFluxPrimIndemDsn.getInternalListeFluxPrimIndemDsn();
  }
  
  public FluxPrimeIndemDsn getListeFluxPrimIndemDsn(int pIndex)
  {
    FluxPrimeIndemDsn retour = null;
    if ((m_listeFluxPrimIndemDsn != null) && (m_listeFluxPrimIndemDsn.getInternalListeFluxPrimIndemDsn() != null) && 
      (m_listeFluxPrimIndemDsn.getNbListeFluxPrimIndemDsn() > pIndex) && 
      (m_listeFluxPrimIndemDsn.getListeFluxPrimIndemDsn()[pIndex] != null)) {
      retour = new _FluxPrimeIndemDsnImpl(m_listeFluxPrimIndemDsn.getListeFluxPrimIndemDsn()[pIndex]);
    }
    return retour;
  }
  
  public FluxPrimeIndemDsn getListeFluxPrimIndemDsn(String pId)
  {
    for (int i = 0; m_listeFluxPrimIndemDsn.getListeFluxPrimIndemDsn().length > i; i++) {
      if (m_listeFluxPrimIndemDsn.getListeFluxPrimIndemDsn()[i].get_IDENT().equals(pId))
      {
        if (m_listeFluxPrimIndemDsn.getListeFluxPrimIndemDsn()[i] == null) {
          return null;
        }
        return new _FluxPrimeIndemDsnImpl(m_listeFluxPrimIndemDsn.getListeFluxPrimIndemDsn()[i]);
      }
    }
    return null;
  }
  
  public FluxPrimeIndemDsn addFluxPrimeIndemDsn()
  {
    _FluxPrimeIndemDsnImpl item = new _FluxPrimeIndemDsnImpl();
    m_listeFluxPrimIndemDsn.getInternalListeFluxPrimIndemDsn().addElement(item.getFluxPrimeIndemDsnInfra());
    return item;
  }
  
  public void addFluxPrimeIndemDsn(FluxPrimeIndemDsn pFluxPrimeIndemDsn)
  {
    m_listeFluxPrimIndemDsn.getInternalListeFluxPrimIndemDsn().addElement(((_FluxPrimeIndemDsnImpl)pFluxPrimeIndemDsn).getFluxPrimeIndemDsnInfra());
  }
  
  public FluxPrimeIndemDsn addListeFluxPrimIndemDsn()
  {
    return addFluxPrimeIndemDsn();
  }
  
  public void addListeFluxPrimIndemDsn(FluxPrimeIndemDsn pFluxPrimeIndemDsn)
  {
    addFluxPrimeIndemDsn(pFluxPrimeIndemDsn);
  }
  
  public void removeFluxPrimeIndemDsn(String pIndex)
  {
    int posTab = 0;
    DataList liste = m_listeFluxPrimIndemDsn.getInternalListeFluxPrimIndemDsn();
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
    m_listeFluxPrimIndemDsn.getInternalListeFluxPrimIndemDsn().removeElement(((_FluxPrimeIndemDsnImpl)pFluxPrimeIndemDsn).getFluxPrimeIndemDsnInfra());
  }
}

/* Location:
 * Qualified Name:     _ListeFluxPrimIndemDsnImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */