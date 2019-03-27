package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ListeRSODImpl
  extends ListeRSOD
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ListeRSOD m_listeRSOD;
  
  public _ListeRSODImpl()
  {
    m_listeRSOD = new _ListeRSOD();
  }
  
  public _ListeRSODImpl(_ListeRSOD pIn)
  {
    ExceptionUtil.assertMethodParamNotNull("_ListeRSOD", pIn);
    
    m_listeRSOD = pIn;
  }
  
  public Object getObjet()
  {
    return m_listeRSOD;
  }
  
  public String getIdentifiant()
  {
    return m_listeRSOD.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_listeRSOD.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_listeRSOD.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_listeRSOD.set_C_ETAT(pCode);
  }
  
  public _ListeRSOD getListeRSODInfra()
  {
    return m_listeRSOD;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    boolean resultat = false;
    for (int i = 0; getNbListeRSOD() > i; i++) {
      if (getListeRSOD(i).isEnErreur())
      {
        resultat = true;
        break;
      }
    }
    return resultat;
  }
  
  public int getNbListeRSOD()
  {
    if (m_listeRSOD != null)
    {
      DataList liste = m_listeRSOD.getInternalListeRSOD();
      if (liste != null) {
        return liste.getNbElement();
      }
      return 0;
    }
    return 0;
  }
  
  public int getNbListRSOD()
  {
    return getNbListeRSOD();
  }
  
  public List getListRSOD()
  {
    List retour = new ArrayList();
    if (m_listeRSOD != null)
    {
      _RSOD[] table = m_listeRSOD.getListeRSOD();
      for (int i = 0; i < table.length; i++) {
        if (table[i] == null) {
          retour.add(null);
        } else {
          retour.add(new _RSODImpl(table[i]));
        }
      }
    }
    return retour;
  }
  
  public List getListeRSOD()
  {
    return (List)m_listeRSOD.getInternalListeRSOD();
  }
  
  public RSOD getListeRSOD(int pIndex)
  {
    RSOD retour = null;
    if ((m_listeRSOD != null) && (m_listeRSOD.getInternalListeRSOD() != null) && 
      (m_listeRSOD.getNbListeRSOD() > pIndex) && 
      (m_listeRSOD.getListeRSOD()[pIndex] != null)) {
      retour = new _RSODImpl(m_listeRSOD.getListeRSOD()[pIndex]);
    }
    return retour;
  }
  
  public RSOD getListeRSOD(String pId)
  {
    for (int i = 0; m_listeRSOD.getListeRSOD().length > i; i++) {
      if (m_listeRSOD.getListeRSOD()[i].get_IDENT().equals(pId))
      {
        if (m_listeRSOD.getListeRSOD()[i] == null) {
          return null;
        }
        return new _RSODImpl(m_listeRSOD.getListeRSOD()[i]);
      }
    }
    return null;
  }
  
  public RSOD addRSOD()
  {
    _RSODImpl item = new _RSODImpl();
    m_listeRSOD.getInternalListeRSOD().addElement(item.getRSODInfra());
    return item;
  }
  
  public void addRSOD(RSOD pRSOD)
  {
    m_listeRSOD.getInternalListeRSOD().addElement(((_RSODImpl)pRSOD).getRSODInfra());
  }
  
  public RSOD addListeRSOD()
  {
    return addRSOD();
  }
  
  public void addListeRSOD(RSOD pRSOD)
  {
    addRSOD(pRSOD);
  }
  
  public void removeRSOD(String pIndex)
  {
    int posTab = 0;
    DataList liste = m_listeRSOD.getInternalListeRSOD();
    int longueur = liste.getNbElement();
    for (int i = 0; longueur > i; i++) {
      if (((_RSOD)liste.getElement(i)).get_IDENT().equals(pIndex))
      {
        liste.removeElement(i);
        break;
      }
    }
  }
  
  public void removeRSOD(RSOD pRSOD)
  {
    m_listeRSOD.getInternalListeRSOD().removeElement(((_RSODImpl)pRSOD).getRSODInfra());
  }
}

/* Location:
 * Qualified Name:     _ListeRSODImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */