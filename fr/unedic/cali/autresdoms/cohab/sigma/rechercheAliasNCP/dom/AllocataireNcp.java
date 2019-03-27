package fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.spec.AllocataireNcpSpec;

public class AllocataireNcp
  implements AllocataireNcpSpec
{
  private String m_numeroAllocataire = null;
  private String m_aliasNcp = null;
  private String m_identifiantSigma = null;
  private String m_codeAssedic = null;
  private String m_topReferent = null;
  private String m_codeAntenne = null;
  private String m_identifiantDNA = null;
  
  public String getNumeroAllocataire()
  {
    return m_numeroAllocataire;
  }
  
  public void setNumeroAllocataire(String p_cxala)
  {
    m_numeroAllocataire = p_cxala;
  }
  
  public String getAliasNcp()
  {
    return m_aliasNcp;
  }
  
  public void setAliasNcp(String p_cincp)
  {
    m_aliasNcp = p_cincp;
  }
  
  public String getIdentifiantSigma()
  {
    return m_identifiantSigma;
  }
  
  public String getCodeAssedic()
  {
    return m_codeAssedic;
  }
  
  public void setIdentifiantSigma(String p_rsin)
  {
    m_identifiantSigma = p_rsin;
  }
  
  public void setCodeAssedic(String p_cxass)
  {
    m_codeAssedic = p_cxass;
  }
  
  public String getCodeAntenne()
  {
    return m_codeAntenne;
  }
  
  public void setCodeAntenne(String p_codeAntenne)
  {
    m_codeAntenne = p_codeAntenne;
  }
  
  public String getIdentifiantDNA()
  {
    return m_identifiantDNA;
  }
  
  public void setIdentifiantDNA(String p_identifiantDNA)
  {
    m_identifiantDNA = p_identifiantDNA;
  }
  
  public String getTopReferent()
  {
    return m_topReferent;
  }
  
  public void setTopReferent(String p_topReferent)
  {
    m_topReferent = p_topReferent;
  }
}

/* Location:
 * Qualified Name:     AllocataireNcp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */