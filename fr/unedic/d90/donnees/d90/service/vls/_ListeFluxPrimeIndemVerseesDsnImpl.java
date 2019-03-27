package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ListeFluxPrimeIndemVerseesDsnImpl
  extends ListeFluxPrimeIndemVerseesDsn
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ListeFluxPrimeIndemVerseesDsn m_listeFluxPrimeIndemVerseesDsn;
  
  public _ListeFluxPrimeIndemVerseesDsnImpl()
  {
    m_listeFluxPrimeIndemVerseesDsn = new _ListeFluxPrimeIndemVerseesDsn();
  }
  
  public _ListeFluxPrimeIndemVerseesDsnImpl(_ListeFluxPrimeIndemVerseesDsn pIn)
  {
    ExceptionUtil.assertMethodParamNotNull("_ListeFluxPrimeIndemVerseesDsn", pIn);
    
    m_listeFluxPrimeIndemVerseesDsn = pIn;
  }
  
  public Object getObjet()
  {
    return m_listeFluxPrimeIndemVerseesDsn;
  }
  
  public String getIdentifiant()
  {
    return m_listeFluxPrimeIndemVerseesDsn.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_listeFluxPrimeIndemVerseesDsn.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_listeFluxPrimeIndemVerseesDsn.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_listeFluxPrimeIndemVerseesDsn.set_C_ETAT(pCode);
  }
  
  public _ListeFluxPrimeIndemVerseesDsn getListeFluxPrimeIndemVerseesDsnInfra()
  {
    return m_listeFluxPrimeIndemVerseesDsn;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    boolean resultat = false;
    for (int i = 0; getNbListeFluxPrimeIndemVerseesDsn() > i; i++) {
      if (getListeFluxPrimeIndemVerseesDsn(i).isEnErreur())
      {
        resultat = true;
        break;
      }
    }
    return resultat;
  }
  
  public int getNbListeFluxPrimeIndemVerseesDsn()
  {
    if (m_listeFluxPrimeIndemVerseesDsn != null)
    {
      DataList liste = m_listeFluxPrimeIndemVerseesDsn.getInternalListeFluxPrimeIndemVerseesDsn();
      if (liste != null) {
        return liste.getNbElement();
      }
      return 0;
    }
    return 0;
  }
  
  public int getNbListFluxPrimesIndemVerseesDsn()
  {
    return getNbListeFluxPrimeIndemVerseesDsn();
  }
  
  public List getListFluxPrimesIndemVerseesDsn()
  {
    List retour = new ArrayList();
    if (m_listeFluxPrimeIndemVerseesDsn != null)
    {
      _FluxPrimesIndemVerseesDsn[] table = m_listeFluxPrimeIndemVerseesDsn.getListeFluxPrimeIndemVerseesDsn();
      for (int i = 0; i < table.length; i++) {
        if (table[i] == null) {
          retour.add(null);
        } else {
          retour.add(new _FluxPrimesIndemVerseesDsnImpl(table[i]));
        }
      }
    }
    return retour;
  }
  
  public List getListeFluxPrimIndemVerseesDsn()
  {
    return (List)m_listeFluxPrimeIndemVerseesDsn.getInternalListeFluxPrimeIndemVerseesDsn();
  }
  
  public FluxPrimesIndemVerseesDsn getListeFluxPrimeIndemVerseesDsn(int pIndex)
  {
    FluxPrimesIndemVerseesDsn retour = null;
    if ((m_listeFluxPrimeIndemVerseesDsn != null) && (m_listeFluxPrimeIndemVerseesDsn.getInternalListeFluxPrimeIndemVerseesDsn() != null) && 
      (m_listeFluxPrimeIndemVerseesDsn.getNbListeFluxPrimeIndemVerseesDsn() > pIndex) && 
      (m_listeFluxPrimeIndemVerseesDsn.getListeFluxPrimeIndemVerseesDsn()[pIndex] != null)) {
      retour = new _FluxPrimesIndemVerseesDsnImpl(m_listeFluxPrimeIndemVerseesDsn.getListeFluxPrimeIndemVerseesDsn()[pIndex]);
    }
    return retour;
  }
  
  public FluxPrimesIndemVerseesDsn getListeFluxPrimeIndemVerseesDsn(String pId)
  {
    for (int i = 0; m_listeFluxPrimeIndemVerseesDsn.getListeFluxPrimeIndemVerseesDsn().length > i; i++) {
      if (m_listeFluxPrimeIndemVerseesDsn.getListeFluxPrimeIndemVerseesDsn()[i].get_IDENT().equals(pId))
      {
        if (m_listeFluxPrimeIndemVerseesDsn.getListeFluxPrimeIndemVerseesDsn()[i] == null) {
          return null;
        }
        return new _FluxPrimesIndemVerseesDsnImpl(m_listeFluxPrimeIndemVerseesDsn.getListeFluxPrimeIndemVerseesDsn()[i]);
      }
    }
    return null;
  }
  
  public FluxPrimesIndemVerseesDsn addFluxPrimesIndemVerseesDsn()
  {
    _FluxPrimesIndemVerseesDsnImpl item = new _FluxPrimesIndemVerseesDsnImpl();
    m_listeFluxPrimeIndemVerseesDsn.getInternalListeFluxPrimeIndemVerseesDsn().addElement(item.getFluxPrimesIndemVerseesDsnInfra());
    return item;
  }
  
  public void addFluxPrimesIndemVerseesDsn(FluxPrimesIndemVerseesDsn pFluxPrimesIndemVerseesDsn)
  {
    m_listeFluxPrimeIndemVerseesDsn.getInternalListeFluxPrimeIndemVerseesDsn().addElement(((_FluxPrimesIndemVerseesDsnImpl)pFluxPrimesIndemVerseesDsn).getFluxPrimesIndemVerseesDsnInfra());
  }
  
  public FluxPrimesIndemVerseesDsn addListeFluxPrimeIndemVerseesDsn()
  {
    return addFluxPrimesIndemVerseesDsn();
  }
  
  public void addListeFluxPrimeIndemVerseesDsn(FluxPrimesIndemVerseesDsn pFluxPrimesIndemVerseesDsn)
  {
    addFluxPrimesIndemVerseesDsn(pFluxPrimesIndemVerseesDsn);
  }
  
  public void removeFluxPrimesIndemVerseesDsn(String pIndex)
  {
    int posTab = 0;
    DataList liste = m_listeFluxPrimeIndemVerseesDsn.getInternalListeFluxPrimeIndemVerseesDsn();
    int longueur = liste.getNbElement();
    for (int i = 0; longueur > i; i++) {
      if (((_FluxPrimesIndemVerseesDsn)liste.getElement(i)).get_IDENT().equals(pIndex))
      {
        liste.removeElement(i);
        break;
      }
    }
  }
  
  public void removeFluxPrimesIndemVerseesDsn(FluxPrimesIndemVerseesDsn pFluxPrimesIndemVerseesDsn)
  {
    m_listeFluxPrimeIndemVerseesDsn.getInternalListeFluxPrimeIndemVerseesDsn().removeElement(((_FluxPrimesIndemVerseesDsnImpl)pFluxPrimesIndemVerseesDsn).getFluxPrimesIndemVerseesDsnInfra());
  }
}

/* Location:
 * Qualified Name:     _ListeFluxPrimeIndemVerseesDsnImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */