package fr.unedic.cali.affectation.parametres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import fr.unedic.cali.dom.affectation.DecorReglementaire;
import fr.unedic.util.temps.Damj;

public class CriteresQualification
{
  private boolean m_coordinationCEE = false;
  private boolean m_estContexteMayotte = false;
  private DecorReglementaire m_decor = null;
  private Damj m_dateFinDernierSinistre;
  
  public CriteresQualification(DecorReglementaire p_decor, TravailSpec p_dernierSinitre, boolean p_coordinationCEE)
  {
    if (p_dernierSinitre != null)
    {
      m_dateFinDernierSinistre = p_dernierSinitre.getDateFin();
      if (((p_dernierSinitre instanceof ActiviteSalarie)) && (((ActiviteSalarie)p_dernierSinitre).isEstPeriodeMayotte())) {
        m_estContexteMayotte = true;
      }
    }
    m_decor = p_decor;
    m_coordinationCEE = p_coordinationCEE;
  }
  
  public CriteresQualification(DecorReglementaire p_decor, Damj p_dateDernierSinistre, boolean p_coordinationCEE, boolean p_estContexteMayotte)
  {
    m_dateFinDernierSinistre = p_dateDernierSinistre;
    m_estContexteMayotte = true;
    m_coordinationCEE = p_coordinationCEE;
    m_decor = p_decor;
    m_estContexteMayotte = p_estContexteMayotte;
  }
  
  public boolean isCoordinationCEE()
  {
    return m_coordinationCEE;
  }
  
  public void setCoordinationCEE(boolean p_coordinationCEE)
  {
    m_coordinationCEE = p_coordinationCEE;
  }
  
  public DecorReglementaire getDecor()
  {
    return m_decor;
  }
  
  public void setDecor(DecorReglementaire p_decor)
  {
    m_decor = p_decor;
  }
  
  public Damj getDateFinDernierSinistre()
  {
    return m_dateFinDernierSinistre;
  }
  
  public void setDateFinDernierSinistre(Damj p_dateFinDernierSinistre)
  {
    m_dateFinDernierSinistre = p_dateFinDernierSinistre;
  }
  
  public boolean equals(Object p_obj)
  {
    boolean isEquals = false;
    if ((p_obj instanceof CriteresQualification))
    {
      CriteresQualification criteresQualificationObj = (CriteresQualification)p_obj;
      
      isEquals = (isCoordinationCEE() == criteresQualificationObj.isCoordinationCEE()) && (getDecor().equals(criteresQualificationObj.getDecor())) && (getDateFinDernierSinistre().equals(criteresQualificationObj.getDateFinDernierSinistre()));
    }
    return isEquals;
  }
  
  public boolean isEstContexteMayotte()
  {
    return m_estContexteMayotte;
  }
  
  public void setEstContexteMayotte(boolean p_estContexteMayotte)
  {
    m_estContexteMayotte = p_estContexteMayotte;
  }
}

/* Location:
 * Qualified Name:     CriteresQualification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */