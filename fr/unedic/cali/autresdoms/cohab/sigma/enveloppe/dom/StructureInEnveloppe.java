package fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.StructureIn;
import fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.spec.StructureInEnveloppeSpec;
import java.math.BigDecimal;

public class StructureInEnveloppe
  extends StructureIn
  implements StructureInEnveloppeSpec
{
  private static final int NEUF = 9;
  private BigDecimal m_montantEngagerAvant;
  private BigDecimal m_montantEngagerApres;
  private int m_exerciceAvant = -1;
  private int m_exerciceApres = -1;
  private String m_typeConventionFormation;
  private String m_classementAdministratif;
  private int m_identifiantActionFormation = -1;
  private int m_natureDecision = -1;
  private int m_statutAvant = 9;
  private int m_statutApres = 9;
  private String m_origineFonctionnelle;
  
  public BigDecimal getMontantEngagerAvant()
  {
    return m_montantEngagerAvant;
  }
  
  public void setMontantEngagerAvant(BigDecimal p_montantEngagerAvant)
  {
    m_montantEngagerAvant = p_montantEngagerAvant;
  }
  
  public BigDecimal getMontantEngagerApres()
  {
    return m_montantEngagerApres;
  }
  
  public void setMontantEngagerApres(BigDecimal p_montantEngagerApres)
  {
    m_montantEngagerApres = p_montantEngagerApres;
  }
  
  public int getExerciceAvant()
  {
    return m_exerciceAvant;
  }
  
  public void setExerciceAvant(int p_exercice)
  {
    m_exerciceAvant = p_exercice;
  }
  
  public int getExerciceApres()
  {
    return m_exerciceApres;
  }
  
  public void setExerciceApres(int p_exercice)
  {
    m_exerciceApres = p_exercice;
  }
  
  public String getTypeConventionFormation()
  {
    return m_typeConventionFormation;
  }
  
  public void setTypeConventionFormation(String p_conventionFormation)
  {
    m_typeConventionFormation = p_conventionFormation;
  }
  
  public String getClassementAdministratif()
  {
    return m_classementAdministratif;
  }
  
  public void setClassementAdministratif(String p_classementAdministratif)
  {
    m_classementAdministratif = p_classementAdministratif;
  }
  
  public int getIdentifiantActionFormation()
  {
    return m_identifiantActionFormation;
  }
  
  public void setIdentifiantActionFormation(int p_identifiantActionFormation)
  {
    m_identifiantActionFormation = p_identifiantActionFormation;
  }
  
  public int getNatureDecision()
  {
    return m_natureDecision;
  }
  
  public void setNatureDecision(int p_natureDecision)
  {
    m_natureDecision = p_natureDecision;
  }
  
  public int getStatutAvant()
  {
    return m_statutAvant;
  }
  
  public void setStatutAvant(int p_statut)
  {
    m_statutAvant = p_statut;
  }
  
  public int getStatutApres()
  {
    return m_statutApres;
  }
  
  public void setStatutApres(int p_statut)
  {
    m_statutApres = p_statut;
  }
  
  public String getOrigineFonctionnelle()
  {
    return m_origineFonctionnelle;
  }
  
  public void setOrigineFonctionnelle(String p_fonctionnelle)
  {
    m_origineFonctionnelle = p_fonctionnelle;
  }
}

/* Location:
 * Qualified Name:     StructureInEnveloppe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */