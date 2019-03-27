package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ListeFluxPeriodesAbsenceFormationImpl
  extends ListeFluxPeriodesAbsenceFormation
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ListeFluxPeriodesAbsenceFormation m_listeFluxPeriodesAbsenceFormation;
  
  public _ListeFluxPeriodesAbsenceFormationImpl()
  {
    m_listeFluxPeriodesAbsenceFormation = new _ListeFluxPeriodesAbsenceFormation();
  }
  
  public _ListeFluxPeriodesAbsenceFormationImpl(_ListeFluxPeriodesAbsenceFormation pIn)
  {
    ExceptionUtil.assertMethodParamNotNull("_ListeFluxPeriodesAbsenceFormation", pIn);
    
    m_listeFluxPeriodesAbsenceFormation = pIn;
  }
  
  public Object getObjet()
  {
    return m_listeFluxPeriodesAbsenceFormation;
  }
  
  public String getIdentifiant()
  {
    return m_listeFluxPeriodesAbsenceFormation.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_listeFluxPeriodesAbsenceFormation.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_listeFluxPeriodesAbsenceFormation.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_listeFluxPeriodesAbsenceFormation.set_C_ETAT(pCode);
  }
  
  public _ListeFluxPeriodesAbsenceFormation getListeFluxPeriodesAbsenceFormationInfra()
  {
    return m_listeFluxPeriodesAbsenceFormation;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    boolean resultat = false;
    for (int i = 0; getNbListeFluxPeriodesAbsenceFormation() > i; i++) {
      if (getListeFluxPeriodesAbsenceFormation(i).isEnErreur())
      {
        resultat = true;
        break;
      }
    }
    return resultat;
  }
  
  public int getNbListeFluxPeriodesAbsenceFormation()
  {
    if (m_listeFluxPeriodesAbsenceFormation != null)
    {
      DataList liste = m_listeFluxPeriodesAbsenceFormation.getInternalListeFluxPeriodesAbsenceFormation();
      if (liste != null) {
        return liste.getNbElement();
      }
      return 0;
    }
    return 0;
  }
  
  public int getNbListFluxPeriodeAbsenceFormation()
  {
    return getNbListeFluxPeriodesAbsenceFormation();
  }
  
  public List getListFluxPeriodeAbsenceFormation()
  {
    List retour = new ArrayList();
    if (m_listeFluxPeriodesAbsenceFormation != null)
    {
      _FluxPeriodeAbsenceFormation[] table = m_listeFluxPeriodesAbsenceFormation.getListeFluxPeriodesAbsenceFormation();
      for (int i = 0; i < table.length; i++) {
        if (table[i] == null) {
          retour.add(null);
        } else {
          retour.add(new _FluxPeriodeAbsenceFormationImpl(table[i]));
        }
      }
    }
    return retour;
  }
  
  public List getListeFluxPeriodesAbsenceFormation()
  {
    return (List)m_listeFluxPeriodesAbsenceFormation.getInternalListeFluxPeriodesAbsenceFormation();
  }
  
  public FluxPeriodeAbsenceFormation getListeFluxPeriodesAbsenceFormation(int pIndex)
  {
    FluxPeriodeAbsenceFormation retour = null;
    if ((m_listeFluxPeriodesAbsenceFormation != null) && (m_listeFluxPeriodesAbsenceFormation.getInternalListeFluxPeriodesAbsenceFormation() != null) && 
      (m_listeFluxPeriodesAbsenceFormation.getNbListeFluxPeriodesAbsenceFormation() > pIndex) && 
      (m_listeFluxPeriodesAbsenceFormation.getListeFluxPeriodesAbsenceFormation()[pIndex] != null)) {
      retour = new _FluxPeriodeAbsenceFormationImpl(m_listeFluxPeriodesAbsenceFormation.getListeFluxPeriodesAbsenceFormation()[pIndex]);
    }
    return retour;
  }
  
  public FluxPeriodeAbsenceFormation getListeFluxPeriodesAbsenceFormation(String pId)
  {
    for (int i = 0; m_listeFluxPeriodesAbsenceFormation.getListeFluxPeriodesAbsenceFormation().length > i; i++) {
      if (m_listeFluxPeriodesAbsenceFormation.getListeFluxPeriodesAbsenceFormation()[i].get_IDENT().equals(pId))
      {
        if (m_listeFluxPeriodesAbsenceFormation.getListeFluxPeriodesAbsenceFormation()[i] == null) {
          return null;
        }
        return new _FluxPeriodeAbsenceFormationImpl(m_listeFluxPeriodesAbsenceFormation.getListeFluxPeriodesAbsenceFormation()[i]);
      }
    }
    return null;
  }
  
  public FluxPeriodeAbsenceFormation addFluxPeriodeAbsenceFormation()
  {
    _FluxPeriodeAbsenceFormationImpl item = new _FluxPeriodeAbsenceFormationImpl();
    m_listeFluxPeriodesAbsenceFormation.getInternalListeFluxPeriodesAbsenceFormation().addElement(item.getFluxPeriodeAbsenceFormationInfra());
    return item;
  }
  
  public void addFluxPeriodeAbsenceFormation(FluxPeriodeAbsenceFormation pFluxPeriodeAbsenceFormation)
  {
    m_listeFluxPeriodesAbsenceFormation.getInternalListeFluxPeriodesAbsenceFormation().addElement(((_FluxPeriodeAbsenceFormationImpl)pFluxPeriodeAbsenceFormation).getFluxPeriodeAbsenceFormationInfra());
  }
  
  public FluxPeriodeAbsenceFormation addListeFluxPeriodesAbsenceFormation()
  {
    return addFluxPeriodeAbsenceFormation();
  }
  
  public void addListeFluxPeriodesAbsenceFormation(FluxPeriodeAbsenceFormation pFluxPeriodeAbsenceFormation)
  {
    addFluxPeriodeAbsenceFormation(pFluxPeriodeAbsenceFormation);
  }
  
  public void removeFluxPeriodeAbsenceFormation(String pIndex)
  {
    int posTab = 0;
    DataList liste = m_listeFluxPeriodesAbsenceFormation.getInternalListeFluxPeriodesAbsenceFormation();
    int longueur = liste.getNbElement();
    for (int i = 0; longueur > i; i++) {
      if (((_FluxPeriodeAbsenceFormation)liste.getElement(i)).get_IDENT().equals(pIndex))
      {
        liste.removeElement(i);
        break;
      }
    }
  }
  
  public void removeFluxPeriodeAbsenceFormation(FluxPeriodeAbsenceFormation pFluxPeriodeAbsenceFormation)
  {
    m_listeFluxPeriodesAbsenceFormation.getInternalListeFluxPeriodesAbsenceFormation().removeElement(((_FluxPeriodeAbsenceFormationImpl)pFluxPeriodeAbsenceFormation).getFluxPeriodeAbsenceFormationInfra());
  }
}

/* Location:
 * Qualified Name:     _ListeFluxPeriodesAbsenceFormationImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */