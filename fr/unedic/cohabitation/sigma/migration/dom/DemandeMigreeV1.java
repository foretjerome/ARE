package fr.unedic.cohabitation.sigma.migration.dom;

import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.lang.builder.EqualsBuilder;

public abstract class DemandeMigreeV1
{
  private Damj m_dateExamen;
  private Damj m_dateDepot;
  private String m_classementAdministratif;
  private String m_idPec;
  private String m_rangDal;
  private String m_codeProduit;
  private String m_typeExamen;
  private String m_typeSegment;
  private boolean m_estNeutraliseeLiquidation;
  private boolean m_estNeutraliseeCalcul;
  private String m_referenceExterne;
  private Collection m_listeDecisions;
  
  protected DemandeMigreeV1()
  {
    initInstance();
  }
  
  private void initInstance()
  {
    m_listeDecisions = new ArrayList();
  }
  
  public String getReferenceExterne()
  {
    return m_referenceExterne;
  }
  
  public void setReferenceExterne(String p_referenceExterne)
  {
    m_referenceExterne = p_referenceExterne;
  }
  
  public String getClassementAdministratif()
  {
    return m_classementAdministratif;
  }
  
  public void setClassementAdministratif(String p_classementAdministratif)
  {
    m_classementAdministratif = p_classementAdministratif;
  }
  
  public String getCodeProduit()
  {
    return m_codeProduit;
  }
  
  public void setCodeProduit(String p_codeProduit)
  {
    m_codeProduit = p_codeProduit;
  }
  
  public Damj getDateDepot()
  {
    return m_dateDepot;
  }
  
  public void setDateDepot(Damj p_dateDepot)
  {
    m_dateDepot = p_dateDepot;
  }
  
  public Damj getDateExamen()
  {
    return m_dateExamen;
  }
  
  public void setDateExamen(Damj p_dateExamen)
  {
    m_dateExamen = p_dateExamen;
  }
  
  public String getIdPec()
  {
    return m_idPec;
  }
  
  public void setIdPec(String p_idPec)
  {
    m_idPec = p_idPec;
  }
  
  public String getRangDal()
  {
    return m_rangDal;
  }
  
  public void setRangDal(String p_rangDal)
  {
    m_rangDal = p_rangDal;
  }
  
  public Collection getListeDecisions()
  {
    return m_listeDecisions;
  }
  
  protected DecisionMigreeV1 getDecisionUnique()
  {
    DecisionMigreeV1 decisionUnique = null;
    if ((getListeDecisions() != null) && (!getListeDecisions().isEmpty()))
    {
      Iterator iterDecisions = m_listeDecisions.iterator();
      decisionUnique = (DecisionMigreeV1)iterDecisions.next();
    }
    return decisionUnique;
  }
  
  public void ajouterDecision(DecisionMigreeV1 p_decision)
  {
    getListeDecisions().add(p_decision);
    p_decision.setDemandeMigree(this);
  }
  
  public String getTypeExamen()
  {
    return m_typeExamen;
  }
  
  public void setTypeExamen(String p_typeExamen)
  {
    m_typeExamen = p_typeExamen;
  }
  
  public String getTypeSegment()
  {
    return m_typeSegment;
  }
  
  public void setTypeSegment(String p_typeSegment)
  {
    m_typeSegment = p_typeSegment;
  }
  
  public boolean isEstNeutraliseeCalcul()
  {
    return m_estNeutraliseeCalcul;
  }
  
  public void setEstNeutraliseeCalcul(boolean p_estNeutraliseeCalcul)
  {
    m_estNeutraliseeCalcul = p_estNeutraliseeCalcul;
  }
  
  public boolean isEstNeutraliseeLiquidation()
  {
    return m_estNeutraliseeLiquidation;
  }
  
  public void setEstNeutraliseeLiquidation(boolean p_estNeutraliseeLiquidation)
  {
    m_estNeutraliseeLiquidation = p_estNeutraliseeLiquidation;
  }
  
  public boolean equals(Object p_arg0)
  {
    boolean isEqual = false;
    if ((p_arg0 instanceof DemandeMigreeV1))
    {
      DemandeMigreeV1 demandeV1 = (DemandeMigreeV1)p_arg0;
      
      EqualsBuilder eqb = new EqualsBuilder();
      
      isEqual = eqb.append(getDateExamen(), demandeV1.getDateExamen()).append(getDateDepot(), demandeV1.getDateDepot()).append(getClassementAdministratif(), demandeV1.getClassementAdministratif()).append(getCodeProduit(), demandeV1.getCodeProduit()).append(getTypeExamen(), demandeV1.getTypeExamen()).append(getTypeSegment(), demandeV1.getTypeSegment()).append(isEstNeutraliseeCalcul(), demandeV1.isEstNeutraliseeCalcul()).append(isEstNeutraliseeLiquidation(), demandeV1.isEstNeutraliseeLiquidation()).append(getReferenceExterne(), demandeV1.getReferenceExterne()).isEquals();
      
      boolean isDecisionEqual = true;
      
      Iterator it = getListeDecisions().iterator();
      Iterator it2 = demandeV1.getListeDecisions().iterator();
      
      DecisionMigreeV1 decisionV1 = null;
      DecisionMigreeV1 decision2V1 = null;
      while ((it.hasNext()) && (it2.hasNext()))
      {
        decisionV1 = (DecisionMigreeV1)it.next();
        decision2V1 = (DecisionMigreeV1)it2.next();
        
        isDecisionEqual = (isDecisionEqual) && (decisionV1.equals(decision2V1));
      }
      isEqual = (isEqual) && (isDecisionEqual);
    }
    return isEqual;
  }
}

/* Location:
 * Qualified Name:     DemandeMigreeV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */