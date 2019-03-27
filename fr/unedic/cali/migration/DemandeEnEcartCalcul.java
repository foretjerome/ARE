package fr.unedic.cali.migration;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;

public class DemandeEnEcartCalcul
{
  DemandeSpec m_demande = null;
  boolean m_ecartForce = false;
  boolean m_ecartMontant = false;
  boolean m_ecartDji = false;
  boolean m_ecartReliquat = false;
  boolean m_ecartCumulHeures = false;
  boolean m_ecartCumulMois = false;
  
  public DemandeEnEcartCalcul(DemandeSpec p_demande)
  {
    m_demande = p_demande;
  }
  
  private DemandeEnEcartCalcul() {}
  
  public DemandeSpec getDemande()
  {
    return m_demande;
  }
  
  public AttributionSpec getAttribution()
  {
    return (AttributionSpec)getDemande().getDossierAffectation().getDossierExamen();
  }
  
  public boolean isEcartCumulHeures()
  {
    return m_ecartCumulHeures;
  }
  
  public void setEcartCumulHeures(boolean p_ecartCumulHeures)
  {
    m_ecartCumulHeures = p_ecartCumulHeures;
  }
  
  public boolean isEcartCumulMois()
  {
    return m_ecartCumulMois;
  }
  
  public void setEcartCumulMois(boolean p_ecartCumulMois)
  {
    m_ecartCumulMois = p_ecartCumulMois;
  }
  
  public boolean isEcartDji()
  {
    return m_ecartDji;
  }
  
  public void setEcartDji(boolean p_ecartDji)
  {
    m_ecartDji = p_ecartDji;
  }
  
  public boolean isEcartMontant()
  {
    return m_ecartMontant;
  }
  
  public void setEcartMontant(boolean p_ecartMontant)
  {
    m_ecartMontant = p_ecartMontant;
  }
  
  public boolean isEcartReliquat()
  {
    return m_ecartReliquat;
  }
  
  public void setEcartReliquat(boolean p_ecartReliquat)
  {
    m_ecartReliquat = p_ecartReliquat;
  }
  
  public boolean isEcartForce()
  {
    return m_ecartForce;
  }
  
  public void setEcartForce(boolean p_ecartForce)
  {
    m_ecartForce = p_ecartForce;
  }
  
  public boolean estEnEcart()
  {
    return (isEcartForce()) || (isEcartCumulHeures()) || (isEcartCumulMois()) || (isEcartDji()) || (isEcartMontant()) || (isEcartReliquat());
  }
}

/* Location:
 * Qualified Name:     DemandeEnEcartCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */