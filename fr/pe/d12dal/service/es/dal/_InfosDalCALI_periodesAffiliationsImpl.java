package fr.pe.d12dal.service.es.dal;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _InfosDalCALI_periodesAffiliationsImpl
  extends InfosDalCALI_periodesAffiliations
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _InfosDalCALI_periodesAffiliations m_infosDalCALI_periodesAffiliations;
  
  public _InfosDalCALI_periodesAffiliationsImpl()
  {
    m_infosDalCALI_periodesAffiliations = new _InfosDalCALI_periodesAffiliations();
  }
  
  public _InfosDalCALI_periodesAffiliationsImpl(_InfosDalCALI_periodesAffiliations pIn)
  {
    ExceptionUtil.assertMethodParamNotNull("_InfosDalCALI_periodesAffiliations", pIn);
    
    m_infosDalCALI_periodesAffiliations = pIn;
  }
  
  public Object getObjet()
  {
    return m_infosDalCALI_periodesAffiliations;
  }
  
  public String getIdentifiant()
  {
    return m_infosDalCALI_periodesAffiliations.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_infosDalCALI_periodesAffiliations.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_infosDalCALI_periodesAffiliations.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_infosDalCALI_periodesAffiliations.set_C_ETAT(pCode);
  }
  
  public _InfosDalCALI_periodesAffiliations getInfosDalCALI_periodesAffiliationsInfra()
  {
    return m_infosDalCALI_periodesAffiliations;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    boolean resultat = false;
    for (int i = 0; getNbInfosDalCALI_periodesAffiliations() > i; i++) {
      if (getPeriodesAffiliations(i).isEnErreur())
      {
        resultat = true;
        break;
      }
    }
    return resultat;
  }
  
  public int getNbInfosDalCALI_periodesAffiliations()
  {
    if (m_infosDalCALI_periodesAffiliations != null)
    {
      DataList liste = m_infosDalCALI_periodesAffiliations.getInternalInfosDalCALI_periodesAffiliations();
      if (liste != null) {
        return liste.getNbElement();
      }
      return 0;
    }
    return 0;
  }
  
  public int getNbListPeriodeAffiliation()
  {
    return getNbInfosDalCALI_periodesAffiliations();
  }
  
  public List getListPeriodeAffiliation()
  {
    List retour = new ArrayList();
    if (m_infosDalCALI_periodesAffiliations != null)
    {
      _PeriodeAffiliation[] table = m_infosDalCALI_periodesAffiliations.getPeriodesAffiliations();
      for (int i = 0; i < table.length; i++) {
        if (table[i] == null) {
          retour.add(null);
        } else {
          retour.add(new _PeriodeAffiliationImpl(table[i]));
        }
      }
    }
    return retour;
  }
  
  public List getPeriodesAffiliations()
  {
    return (List)m_infosDalCALI_periodesAffiliations.getInternalInfosDalCALI_periodesAffiliations();
  }
  
  public PeriodeAffiliation getPeriodesAffiliations(int pIndex)
  {
    PeriodeAffiliation retour = null;
    if ((m_infosDalCALI_periodesAffiliations != null) && (m_infosDalCALI_periodesAffiliations.getInternalInfosDalCALI_periodesAffiliations() != null) && 
      (m_infosDalCALI_periodesAffiliations.getNbInfosDalCALI_periodesAffiliations() > pIndex) && 
      (m_infosDalCALI_periodesAffiliations.getPeriodesAffiliations()[pIndex] != null)) {
      retour = new _PeriodeAffiliationImpl(m_infosDalCALI_periodesAffiliations.getPeriodesAffiliations()[pIndex]);
    }
    return retour;
  }
  
  public PeriodeAffiliation getPeriodesAffiliations(String pId)
  {
    for (int i = 0; m_infosDalCALI_periodesAffiliations.getPeriodesAffiliations().length > i; i++) {
      if (m_infosDalCALI_periodesAffiliations.getPeriodesAffiliations()[i].get_IDENT().equals(pId))
      {
        if (m_infosDalCALI_periodesAffiliations.getPeriodesAffiliations()[i] == null) {
          return null;
        }
        return new _PeriodeAffiliationImpl(m_infosDalCALI_periodesAffiliations.getPeriodesAffiliations()[i]);
      }
    }
    return null;
  }
  
  public PeriodeAffiliation addPeriodeAffiliation()
  {
    _PeriodeAffiliationImpl item = new _PeriodeAffiliationImpl();
    m_infosDalCALI_periodesAffiliations.getInternalInfosDalCALI_periodesAffiliations().addElement(item.getPeriodeAffiliationInfra());
    return item;
  }
  
  public void addPeriodeAffiliation(PeriodeAffiliation pPeriodeAffiliation)
  {
    m_infosDalCALI_periodesAffiliations.getInternalInfosDalCALI_periodesAffiliations().addElement(((_PeriodeAffiliationImpl)pPeriodeAffiliation).getPeriodeAffiliationInfra());
  }
  
  public PeriodeAffiliation addPeriodesAffiliations()
  {
    return addPeriodeAffiliation();
  }
  
  public void addPeriodesAffiliations(PeriodeAffiliation pPeriodeAffiliation)
  {
    addPeriodeAffiliation(pPeriodeAffiliation);
  }
  
  public void removePeriodeAffiliation(String pIndex)
  {
    int posTab = 0;
    DataList liste = m_infosDalCALI_periodesAffiliations.getInternalInfosDalCALI_periodesAffiliations();
    int longueur = liste.getNbElement();
    for (int i = 0; longueur > i; i++) {
      if (((_PeriodeAffiliation)liste.getElement(i)).get_IDENT().equals(pIndex))
      {
        liste.removeElement(i);
        break;
      }
    }
  }
  
  public void removePeriodeAffiliation(PeriodeAffiliation pPeriodeAffiliation)
  {
    m_infosDalCALI_periodesAffiliations.getInternalInfosDalCALI_periodesAffiliations().removeElement(((_PeriodeAffiliationImpl)pPeriodeAffiliation).getPeriodeAffiliationInfra());
  }
}

/* Location:
 * Qualified Name:     _InfosDalCALI_periodesAffiliationsImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */