package fr.unedic.cali.autresdoms.cohab.dom;

import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.util.services.ContexteService;
import java.math.BigDecimal;

public class CriteresCaliServiceEnveloppe
{
  ContexteService m_contexteService;
  String m_numeroAllocataire;
  int m_natureDecision;
  ClassementAdministratif m_classementAdministratif;
  BigDecimal m_montantAvantEngagement;
  BigDecimal m_montantApresEngagement;
  int m_idActionFormation;
  int m_exerciceAvant;
  int m_exerciceApres;
  int m_statutAvant;
  int m_statutApres;
  String m_numeroConvention;
  String m_origineFonctionnelle;
  
  public ClassementAdministratif getClassementAdministratif()
  {
    return m_classementAdministratif;
  }
  
  public void setClassementAdministratif(ClassementAdministratif p_classementAdministratif)
  {
    m_classementAdministratif = p_classementAdministratif;
  }
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public int getExerciceApres()
  {
    return m_exerciceApres;
  }
  
  public void setExerciceApres(int p_exerciceApres)
  {
    m_exerciceApres = p_exerciceApres;
  }
  
  public int getExerciceAvant()
  {
    return m_exerciceAvant;
  }
  
  public void setExerciceAvant(int p_exerciceAvant)
  {
    m_exerciceAvant = p_exerciceAvant;
  }
  
  public int getIdActionFormation()
  {
    return m_idActionFormation;
  }
  
  public void setIdActionFormation(int p_idActionFormation)
  {
    m_idActionFormation = p_idActionFormation;
  }
  
  public BigDecimal getMontantApresEngagement()
  {
    return m_montantApresEngagement;
  }
  
  public void setMontantApresEngagement(BigDecimal p_montantApresEngagement)
  {
    m_montantApresEngagement = p_montantApresEngagement;
  }
  
  public BigDecimal getMontantAvantEngagement()
  {
    return m_montantAvantEngagement;
  }
  
  public void setMontantAvantEngagement(BigDecimal p_montantAvantEngagement)
  {
    m_montantAvantEngagement = p_montantAvantEngagement;
  }
  
  public int getNatureDecision()
  {
    return m_natureDecision;
  }
  
  public void setNatureDecision(int p_natureDecision)
  {
    m_natureDecision = p_natureDecision;
  }
  
  public String getNumeroAllocataire()
  {
    return m_numeroAllocataire;
  }
  
  public void setNumeroAllocataire(String p_numeroAllocataire)
  {
    m_numeroAllocataire = p_numeroAllocataire;
  }
  
  public int estStatutApres()
  {
    return m_statutApres;
  }
  
  public void setStatutApres(int p_statutApres)
  {
    m_statutApres = p_statutApres;
  }
  
  public int estStatutAvant()
  {
    return m_statutAvant;
  }
  
  public void setStatutAvant(int p_statutAvant)
  {
    m_statutAvant = p_statutAvant;
  }
  
  public String getNumeroConvention()
  {
    return m_numeroConvention;
  }
  
  public void setNumeroConvention(String p_numeroConvention)
  {
    m_numeroConvention = p_numeroConvention;
  }
  
  public String getOrigineFonctionnelle()
  {
    return m_origineFonctionnelle;
  }
  
  public void setOrigineFonctionnelle(String p_origineFonctionnelle)
  {
    m_origineFonctionnelle = p_origineFonctionnelle;
  }
}

/* Location:
 * Qualified Name:     CriteresCaliServiceEnveloppe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */