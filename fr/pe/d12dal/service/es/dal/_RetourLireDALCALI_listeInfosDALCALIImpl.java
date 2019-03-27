package fr.pe.d12dal.service.es.dal;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _RetourLireDALCALI_listeInfosDALCALIImpl
  extends RetourLireDALCALI_listeInfosDALCALI
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _RetourLireDALCALI_listeInfosDALCALI m_retourLireDALCALI_listeInfosDALCALI;
  
  public _RetourLireDALCALI_listeInfosDALCALIImpl()
  {
    m_retourLireDALCALI_listeInfosDALCALI = new _RetourLireDALCALI_listeInfosDALCALI();
  }
  
  public _RetourLireDALCALI_listeInfosDALCALIImpl(_RetourLireDALCALI_listeInfosDALCALI pIn)
  {
    ExceptionUtil.assertMethodParamNotNull("_RetourLireDALCALI_listeInfosDALCALI", pIn);
    
    m_retourLireDALCALI_listeInfosDALCALI = pIn;
  }
  
  public Object getObjet()
  {
    return m_retourLireDALCALI_listeInfosDALCALI;
  }
  
  public String getIdentifiant()
  {
    return m_retourLireDALCALI_listeInfosDALCALI.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_retourLireDALCALI_listeInfosDALCALI.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_retourLireDALCALI_listeInfosDALCALI.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_retourLireDALCALI_listeInfosDALCALI.set_C_ETAT(pCode);
  }
  
  public _RetourLireDALCALI_listeInfosDALCALI getRetourLireDALCALI_listeInfosDALCALIInfra()
  {
    return m_retourLireDALCALI_listeInfosDALCALI;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    boolean resultat = false;
    for (int i = 0; getNbRetourLireDALCALI_listeInfosDALCALI() > i; i++) {
      if (getListeInfosDALCALI(i).isEnErreur())
      {
        resultat = true;
        break;
      }
    }
    return resultat;
  }
  
  public int getNbRetourLireDALCALI_listeInfosDALCALI()
  {
    if (m_retourLireDALCALI_listeInfosDALCALI != null)
    {
      DataList liste = m_retourLireDALCALI_listeInfosDALCALI.getInternalRetourLireDALCALI_listeInfosDALCALI();
      if (liste != null) {
        return liste.getNbElement();
      }
      return 0;
    }
    return 0;
  }
  
  public int getNbListInfosDalCALI()
  {
    return getNbRetourLireDALCALI_listeInfosDALCALI();
  }
  
  public List getListInfosDalCALI()
  {
    List retour = new ArrayList();
    if (m_retourLireDALCALI_listeInfosDALCALI != null)
    {
      _InfosDalCALI[] table = m_retourLireDALCALI_listeInfosDALCALI.getListeInfosDALCALI();
      for (int i = 0; i < table.length; i++) {
        if (table[i] == null) {
          retour.add(null);
        } else {
          retour.add(new _InfosDalCALIImpl(table[i]));
        }
      }
    }
    return retour;
  }
  
  public List getListeInfosDALCALI()
  {
    return (List)m_retourLireDALCALI_listeInfosDALCALI.getInternalRetourLireDALCALI_listeInfosDALCALI();
  }
  
  public InfosDalCALI getListeInfosDALCALI(int pIndex)
  {
    InfosDalCALI retour = null;
    if ((m_retourLireDALCALI_listeInfosDALCALI != null) && (m_retourLireDALCALI_listeInfosDALCALI.getInternalRetourLireDALCALI_listeInfosDALCALI() != null) && 
      (m_retourLireDALCALI_listeInfosDALCALI.getNbRetourLireDALCALI_listeInfosDALCALI() > pIndex) && 
      (m_retourLireDALCALI_listeInfosDALCALI.getListeInfosDALCALI()[pIndex] != null)) {
      retour = new _InfosDalCALIImpl(m_retourLireDALCALI_listeInfosDALCALI.getListeInfosDALCALI()[pIndex]);
    }
    return retour;
  }
  
  public InfosDalCALI getListeInfosDALCALI(String pId)
  {
    for (int i = 0; m_retourLireDALCALI_listeInfosDALCALI.getListeInfosDALCALI().length > i; i++) {
      if (m_retourLireDALCALI_listeInfosDALCALI.getListeInfosDALCALI()[i].get_IDENT().equals(pId))
      {
        if (m_retourLireDALCALI_listeInfosDALCALI.getListeInfosDALCALI()[i] == null) {
          return null;
        }
        return new _InfosDalCALIImpl(m_retourLireDALCALI_listeInfosDALCALI.getListeInfosDALCALI()[i]);
      }
    }
    return null;
  }
  
  public InfosDalCALI addInfosDalCALI()
  {
    _InfosDalCALIImpl item = new _InfosDalCALIImpl();
    m_retourLireDALCALI_listeInfosDALCALI.getInternalRetourLireDALCALI_listeInfosDALCALI().addElement(item.getInfosDalCALIInfra());
    return item;
  }
  
  public void addInfosDalCALI(InfosDalCALI pInfosDalCALI)
  {
    m_retourLireDALCALI_listeInfosDALCALI.getInternalRetourLireDALCALI_listeInfosDALCALI().addElement(((_InfosDalCALIImpl)pInfosDalCALI).getInfosDalCALIInfra());
  }
  
  public InfosDalCALI addListeInfosDALCALI()
  {
    return addInfosDalCALI();
  }
  
  public void addListeInfosDALCALI(InfosDalCALI pInfosDalCALI)
  {
    addInfosDalCALI(pInfosDalCALI);
  }
  
  public void removeInfosDalCALI(String pIndex)
  {
    int posTab = 0;
    DataList liste = m_retourLireDALCALI_listeInfosDALCALI.getInternalRetourLireDALCALI_listeInfosDALCALI();
    int longueur = liste.getNbElement();
    for (int i = 0; longueur > i; i++) {
      if (((_InfosDalCALI)liste.getElement(i)).get_IDENT().equals(pIndex))
      {
        liste.removeElement(i);
        break;
      }
    }
  }
  
  public void removeInfosDalCALI(InfosDalCALI pInfosDalCALI)
  {
    m_retourLireDALCALI_listeInfosDALCALI.getInternalRetourLireDALCALI_listeInfosDALCALI().removeElement(((_InfosDalCALIImpl)pInfosDalCALI).getInfosDalCALIInfra());
  }
}

/* Location:
 * Qualified Name:     _RetourLireDALCALI_listeInfosDALCALIImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */