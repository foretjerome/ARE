package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ListeDSMTravailImpl
  extends ListeDSMTravail
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ListeDSMTravail m_listeDSMTravail;
  
  public _ListeDSMTravailImpl()
  {
    m_listeDSMTravail = new _ListeDSMTravail();
  }
  
  public _ListeDSMTravailImpl(_ListeDSMTravail pIn)
  {
    ExceptionUtil.assertMethodParamNotNull("_ListeDSMTravail", pIn);
    
    m_listeDSMTravail = pIn;
  }
  
  public Object getObjet()
  {
    return m_listeDSMTravail;
  }
  
  public String getIdentifiant()
  {
    return m_listeDSMTravail.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_listeDSMTravail.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_listeDSMTravail.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_listeDSMTravail.set_C_ETAT(pCode);
  }
  
  public _ListeDSMTravail getListeDSMTravailInfra()
  {
    return m_listeDSMTravail;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    boolean resultat = false;
    for (int i = 0; getNbListeDSMTravail() > i; i++) {
      if (getListeDSMTravail(i).isEnErreur())
      {
        resultat = true;
        break;
      }
    }
    return resultat;
  }
  
  public int getNbListeDSMTravail()
  {
    if (m_listeDSMTravail != null)
    {
      DataList liste = m_listeDSMTravail.getInternalListeDSMTravail();
      if (liste != null) {
        return liste.getNbElement();
      }
      return 0;
    }
    return 0;
  }
  
  public int getNbListDsmTravail()
  {
    return getNbListeDSMTravail();
  }
  
  public List getListDsmTravail()
  {
    List retour = new ArrayList();
    if (m_listeDSMTravail != null)
    {
      _DsmTravail[] table = m_listeDSMTravail.getListeDSMTravail();
      for (int i = 0; i < table.length; i++) {
        if (table[i] == null) {
          retour.add(null);
        } else {
          retour.add(new _DsmTravailImpl(table[i]));
        }
      }
    }
    return retour;
  }
  
  public List getListeDSMTravail()
  {
    return (List)m_listeDSMTravail.getInternalListeDSMTravail();
  }
  
  public DsmTravail getListeDSMTravail(int pIndex)
  {
    DsmTravail retour = null;
    if ((m_listeDSMTravail != null) && (m_listeDSMTravail.getInternalListeDSMTravail() != null) && 
      (m_listeDSMTravail.getNbListeDSMTravail() > pIndex) && 
      (m_listeDSMTravail.getListeDSMTravail()[pIndex] != null)) {
      retour = new _DsmTravailImpl(m_listeDSMTravail.getListeDSMTravail()[pIndex]);
    }
    return retour;
  }
  
  public DsmTravail getListeDSMTravail(String pId)
  {
    for (int i = 0; m_listeDSMTravail.getListeDSMTravail().length > i; i++) {
      if (m_listeDSMTravail.getListeDSMTravail()[i].get_IDENT().equals(pId))
      {
        if (m_listeDSMTravail.getListeDSMTravail()[i] == null) {
          return null;
        }
        return new _DsmTravailImpl(m_listeDSMTravail.getListeDSMTravail()[i]);
      }
    }
    return null;
  }
  
  public DsmTravail addDsmTravail()
  {
    _DsmTravailImpl item = new _DsmTravailImpl();
    m_listeDSMTravail.getInternalListeDSMTravail().addElement(item.getDsmTravailInfra());
    return item;
  }
  
  public void addDsmTravail(DsmTravail pDsmTravail)
  {
    m_listeDSMTravail.getInternalListeDSMTravail().addElement(((_DsmTravailImpl)pDsmTravail).getDsmTravailInfra());
  }
  
  public DsmTravail addListeDSMTravail()
  {
    return addDsmTravail();
  }
  
  public void addListeDSMTravail(DsmTravail pDsmTravail)
  {
    addDsmTravail(pDsmTravail);
  }
  
  public void removeDsmTravail(String pIndex)
  {
    int posTab = 0;
    DataList liste = m_listeDSMTravail.getInternalListeDSMTravail();
    int longueur = liste.getNbElement();
    for (int i = 0; longueur > i; i++) {
      if (((_DsmTravail)liste.getElement(i)).get_IDENT().equals(pIndex))
      {
        liste.removeElement(i);
        break;
      }
    }
  }
  
  public void removeDsmTravail(DsmTravail pDsmTravail)
  {
    m_listeDSMTravail.getInternalListeDSMTravail().removeElement(((_DsmTravailImpl)pDsmTravail).getDsmTravailInfra());
  }
}

/* Location:
 * Qualified Name:     _ListeDSMTravailImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */