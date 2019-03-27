package fr.unedic.cali.autresdoms.cohab.sigma.individubni.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.individubni.dom.spec.AllocataireBniSigmaR0Spec;

public class AllocataireBniSigmaR0
  implements AllocataireBniSigmaR0Spec
{
  private String m_NumeroAllocataire;
  private String m_IdentifiantSigma;
  private String m_CodeAssedic;
  private String m_codeEtatMigrationNCP;
  private String m_origineCertification;
  
  public String getCodeAssedic()
  {
    return m_CodeAssedic;
  }
  
  public String getIdentifiantSigma()
  {
    return m_IdentifiantSigma;
  }
  
  public String getNumeroAllocataire()
  {
    return m_NumeroAllocataire;
  }
  
  public void setCodeAssedic(String p_cxass)
  {
    m_CodeAssedic = p_cxass;
  }
  
  public void setIdentifiantSigma(String p_rsin)
  {
    m_IdentifiantSigma = p_rsin;
  }
  
  public void setNumeroAllocataire(String p_cxala)
  {
    m_NumeroAllocataire = p_cxala;
  }
  
  public String getCodeEtatMigrationNCP()
  {
    return m_codeEtatMigrationNCP;
  }
  
  public void setCodeEtatMigrationNCP(String p_cincp)
  {
    m_codeEtatMigrationNCP = p_cincp;
  }
  
  public String getOrigineCertification()
  {
    return m_origineCertification;
  }
  
  public void setOrigineCertification(String p_lzocn)
  {
    m_origineCertification = p_lzocn;
  }
}

/* Location:
 * Qualified Name:     AllocataireBniSigmaR0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */