package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ListeFluxPasDnaImpl
  extends ListeFluxPasDna
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ListeFluxPasDna m_listeFluxPasDna;
  
  public _ListeFluxPasDnaImpl()
  {
    m_listeFluxPasDna = new _ListeFluxPasDna();
  }
  
  public _ListeFluxPasDnaImpl(_ListeFluxPasDna pIn)
  {
    ExceptionUtil.assertMethodParamNotNull("_ListeFluxPasDna", pIn);
    
    m_listeFluxPasDna = pIn;
  }
  
  public Object getObjet()
  {
    return m_listeFluxPasDna;
  }
  
  public String getIdentifiant()
  {
    return m_listeFluxPasDna.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_listeFluxPasDna.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_listeFluxPasDna.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_listeFluxPasDna.set_C_ETAT(pCode);
  }
  
  public _ListeFluxPasDna getListeFluxPasDnaInfra()
  {
    return m_listeFluxPasDna;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    boolean resultat = false;
    for (int i = 0; getNbListeFluxPasDna() > i; i++) {
      if (getListeFluxPasDna(i).isEnErreur())
      {
        resultat = true;
        break;
      }
    }
    return resultat;
  }
  
  public int getNbListeFluxPasDna()
  {
    if (m_listeFluxPasDna != null)
    {
      DataList liste = m_listeFluxPasDna.getInternalListeFluxPasDna();
      if (liste != null) {
        return liste.getNbElement();
      }
      return 0;
    }
    return 0;
  }
  
  public int getNbListFluxPasDna()
  {
    return getNbListeFluxPasDna();
  }
  
  public List getListFluxPasDna()
  {
    List retour = new ArrayList();
    if (m_listeFluxPasDna != null)
    {
      _FluxPasDna[] table = m_listeFluxPasDna.getListeFluxPasDna();
      for (int i = 0; i < table.length; i++) {
        if (table[i] == null) {
          retour.add(null);
        } else {
          retour.add(new _FluxPasDnaImpl(table[i]));
        }
      }
    }
    return retour;
  }
  
  public List getListeFluxPasDna()
  {
    return (List)m_listeFluxPasDna.getInternalListeFluxPasDna();
  }
  
  public FluxPasDna getListeFluxPasDna(int pIndex)
  {
    FluxPasDna retour = null;
    if ((m_listeFluxPasDna != null) && (m_listeFluxPasDna.getInternalListeFluxPasDna() != null) && 
      (m_listeFluxPasDna.getNbListeFluxPasDna() > pIndex) && 
      (m_listeFluxPasDna.getListeFluxPasDna()[pIndex] != null)) {
      retour = new _FluxPasDnaImpl(m_listeFluxPasDna.getListeFluxPasDna()[pIndex]);
    }
    return retour;
  }
  
  public FluxPasDna getListeFluxPasDna(String pId)
  {
    for (int i = 0; m_listeFluxPasDna.getListeFluxPasDna().length > i; i++) {
      if (m_listeFluxPasDna.getListeFluxPasDna()[i].get_IDENT().equals(pId))
      {
        if (m_listeFluxPasDna.getListeFluxPasDna()[i] == null) {
          return null;
        }
        return new _FluxPasDnaImpl(m_listeFluxPasDna.getListeFluxPasDna()[i]);
      }
    }
    return null;
  }
  
  public FluxPasDna addFluxPasDna()
  {
    _FluxPasDnaImpl item = new _FluxPasDnaImpl();
    m_listeFluxPasDna.getInternalListeFluxPasDna().addElement(item.getFluxPasDnaInfra());
    return item;
  }
  
  public void addFluxPasDna(FluxPasDna pFluxPasDna)
  {
    m_listeFluxPasDna.getInternalListeFluxPasDna().addElement(((_FluxPasDnaImpl)pFluxPasDna).getFluxPasDnaInfra());
  }
  
  public FluxPasDna addListeFluxPasDna()
  {
    return addFluxPasDna();
  }
  
  public void addListeFluxPasDna(FluxPasDna pFluxPasDna)
  {
    addFluxPasDna(pFluxPasDna);
  }
  
  public void removeFluxPasDna(String pIndex)
  {
    int posTab = 0;
    DataList liste = m_listeFluxPasDna.getInternalListeFluxPasDna();
    int longueur = liste.getNbElement();
    for (int i = 0; longueur > i; i++) {
      if (((_FluxPasDna)liste.getElement(i)).get_IDENT().equals(pIndex))
      {
        liste.removeElement(i);
        break;
      }
    }
  }
  
  public void removeFluxPasDna(FluxPasDna pFluxPasDna)
  {
    m_listeFluxPasDna.getInternalListeFluxPasDna().removeElement(((_FluxPasDnaImpl)pFluxPasDna).getFluxPasDnaInfra());
  }
}

/* Location:
 * Qualified Name:     _ListeFluxPasDnaImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */