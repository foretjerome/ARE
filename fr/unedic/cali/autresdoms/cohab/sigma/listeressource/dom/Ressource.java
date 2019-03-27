package fr.unedic.cali.autresdoms.cohab.sigma.listeressource.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.listeressource.dom.spec.RessourceSpec;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Damj;

public class Ressource
  implements RessourceSpec
{
  private String m_referenceExterne;
  private String m_codeCertification;
  private String m_origine;
  private String m_codeSituationFamiliale;
  private Damj m_dateEffet;
  private QuantiteEuro m_montant;
  private int m_rang;
  private QuantiteEuro m_ressourcesAllocataire;
  private QuantiteEuro m_ressourcesConjoint;
  private Damj m_dateReference;
  private int m_nombreEnfant;
  
  public String getReferenceExterne()
  {
    return m_referenceExterne;
  }
  
  public void setReferenceExterne(String p_referenceExterne)
  {
    m_referenceExterne = p_referenceExterne;
  }
  
  public String getCodeCertification()
  {
    return m_codeCertification;
  }
  
  public String getOrigine()
  {
    return m_origine;
  }
  
  public String getCodeSituationFamiliale()
  {
    return m_codeSituationFamiliale;
  }
  
  public Damj getDateEffet()
  {
    return m_dateEffet;
  }
  
  public QuantiteEuro getMontant()
  {
    return m_montant;
  }
  
  public int getRang()
  {
    return m_rang;
  }
  
  public QuantiteEuro getRessourcesAllocataire()
  {
    return m_ressourcesAllocataire;
  }
  
  public QuantiteEuro getRessourcesConjoint()
  {
    return m_ressourcesConjoint;
  }
  
  public void setCodeCertification(String p_code)
  {
    m_codeCertification = p_code;
  }
  
  public void setOrigine(String p_origine)
  {
    m_origine = p_origine;
  }
  
  public void setCodeSituationFamiliale(String p_code)
  {
    m_codeSituationFamiliale = p_code;
  }
  
  public void setDateEffet(Damj p_dateEffet)
  {
    m_dateEffet = p_dateEffet;
  }
  
  public void setMontant(QuantiteEuro p_montant)
  {
    m_montant = p_montant;
  }
  
  public void setRang(int p_rang)
  {
    m_rang = p_rang;
  }
  
  public void setRessourcesAllocataire(QuantiteEuro p_ressourcesAllocataire)
  {
    m_ressourcesAllocataire = p_ressourcesAllocataire;
  }
  
  public void setRessourcesConjoint(QuantiteEuro p_ressourcesConjoint)
  {
    m_ressourcesConjoint = p_ressourcesConjoint;
  }
  
  public Damj getDateReference()
  {
    return m_dateReference;
  }
  
  public void setDateReference(Damj p_reference)
  {
    m_dateReference = p_reference.getFinMois();
  }
  
  public int getNombreEnfant()
  {
    return m_nombreEnfant;
  }
  
  public void setNombreEnfant(int p_nombreEnfant)
  {
    m_nombreEnfant = p_nombreEnfant;
  }
}

/* Location:
 * Qualified Name:     Ressource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */