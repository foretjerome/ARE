package fr.unedic.cali.autresdoms.cohab.dom;

import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Damj;

public class Ressources
{
  private QuantiteEuro m_ressourcesAllocataire = null;
  private QuantiteEuro m_ressourcesConjoint = null;
  private QuantiteEuro m_montantRessourcesMensuelles = null;
  private int m_situationFamiliale;
  private Damj m_dateFinPeriodeReference;
  private String m_origine = null;
  private Damj m_dateEffet = null;
  private String m_referenceExterne = null;
  private int m_rang;
  private int m_nombreEnfants;
  
  public QuantiteEuro getRessourcesAllocataire()
  {
    return m_ressourcesAllocataire;
  }
  
  public QuantiteEuro getRessourcesConjoint()
  {
    return m_ressourcesConjoint;
  }
  
  public int getSituationFamiliale()
  {
    return m_situationFamiliale;
  }
  
  public void setRessourcesAllocataire(QuantiteEuro p_ressourcesAllocataire)
  {
    m_ressourcesAllocataire = p_ressourcesAllocataire;
  }
  
  public void setRessourcesConjoint(QuantiteEuro p_ressourcesConjoint)
  {
    m_ressourcesConjoint = p_ressourcesConjoint;
  }
  
  public void setSituationFamiliale(int p_situationFamiliale)
  {
    m_situationFamiliale = p_situationFamiliale;
  }
  
  public Damj getDateFinPeriodeReference()
  {
    return m_dateFinPeriodeReference;
  }
  
  public void setDateFinPeriodeReference(Damj p_damj)
  {
    m_dateFinPeriodeReference = p_damj;
  }
  
  public QuantiteEuro getMontantRessourcesMensuelles()
  {
    return m_montantRessourcesMensuelles;
  }
  
  public void setMontantRessourcesMensuelles(QuantiteEuro p_montantRessourcesMensuelles)
  {
    m_montantRessourcesMensuelles = p_montantRessourcesMensuelles;
  }
  
  public Damj getDateEffet()
  {
    return m_dateEffet;
  }
  
  public void setDateEffet(Damj p_dateEffet)
  {
    m_dateEffet = p_dateEffet;
  }
  
  public String getOrigine()
  {
    return m_origine;
  }
  
  public void setOrigine(String p_origine)
  {
    m_origine = p_origine;
  }
  
  public String getReferenceExterne()
  {
    return m_referenceExterne;
  }
  
  public void setReferenceExterne(String p_referenceExterne)
  {
    m_referenceExterne = p_referenceExterne;
  }
  
  public int getRang()
  {
    return m_rang;
  }
  
  public void setRang(int p_rang)
  {
    m_rang = p_rang;
  }
  
  public int getNombreEnfants()
  {
    return m_nombreEnfants;
  }
  
  public void setNombreEnfants(int p_nombreEnfants)
  {
    m_nombreEnfants = p_nombreEnfants;
  }
}

/* Location:
 * Qualified Name:     Ressources
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */