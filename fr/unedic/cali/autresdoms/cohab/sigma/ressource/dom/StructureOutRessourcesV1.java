package fr.unedic.cali.autresdoms.cohab.sigma.ressource.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.ressource.dom.spec.StructureOutRessourcesV1Spec;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Damj;

public class StructureOutRessourcesV1
  implements StructureOutRessourcesV1Spec
{
  private String m_identifiantDemande;
  private String m_codeCertification;
  private String m_origine;
  private String m_codeSituationFamiliale;
  private Damj m_dateEffet;
  private QuantiteEuro m_montant;
  private int m_rang;
  private QuantiteEuro m_ressourcesAllocataire;
  private QuantiteEuro m_ressourcesConjoint;
  private Damj m_dateReference;
  
  public String getIdentifiantDemande()
  {
    return m_identifiantDemande;
  }
  
  public void setIdentifiantDemande(String p_identifiantDemande)
  {
    m_identifiantDemande = p_identifiantDemande;
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
}

/* Location:
 * Qualified Name:     StructureOutRessourcesV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */