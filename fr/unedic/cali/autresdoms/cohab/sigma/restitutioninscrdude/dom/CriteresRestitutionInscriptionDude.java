package fr.unedic.cali.autresdoms.cohab.sigma.restitutioninscrdude.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.restitutioninscrdude.dom.spec.CriteresRestitutionInscriptionDudeSpec;

public class CriteresRestitutionInscriptionDude
  implements CriteresRestitutionInscriptionDudeSpec
{
  private String m_codeAssedic;
  private String m_numeroAllocataire;
  private String m_identifiantSigma;
  
  public String getCodeAssedic()
  {
    return m_codeAssedic;
  }
  
  public String getIdentifiantSigma()
  {
    return m_identifiantSigma;
  }
  
  public String getNumeroAllocataire()
  {
    return m_numeroAllocataire;
  }
  
  public void setCodeAssedic(String p_codeAssedic)
  {
    m_codeAssedic = p_codeAssedic;
  }
  
  public void setIdentifiantSigma(String p_identifiantSigma)
  {
    m_identifiantSigma = p_identifiantSigma;
  }
  
  public void setNumeroAllocataire(String p_numeroAllocataire)
  {
    m_numeroAllocataire = p_numeroAllocataire;
  }
}

/* Location:
 * Qualified Name:     CriteresRestitutionInscriptionDude
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */