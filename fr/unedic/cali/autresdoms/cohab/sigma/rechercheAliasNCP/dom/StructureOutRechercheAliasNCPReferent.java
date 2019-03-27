package fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.spec.StructureOutRechercheAliasNCPReferentSpec;

public class StructureOutRechercheAliasNCPReferent
  implements StructureOutRechercheAliasNCPReferentSpec
{
  private String m_numeroAllocataire = null;
  private String m_identifiantSigma = null;
  private String m_codeAssedic = null;
  private String m_codeAliasNCP = null;
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
  
  public String getIdentifiantSigma()
  {
    return m_identifiantSigma;
  }
  
  public void setIdentifiantSigma(String p_rsin)
  {
    m_identifiantSigma = p_rsin;
  }
  
  public String getCodeAssedic()
  {
    return m_codeAssedic;
  }
  
  public void setCodeAssedic(String p_cxass)
  {
    m_codeAssedic = p_cxass;
  }
  
  public String getCodeAliasNCP()
  {
    return m_codeAliasNCP;
  }
  
  public void setCodeAliasNCP(String p_cincp)
  {
    m_codeAliasNCP = p_cincp;
  }
  
  public String getCodeAntenne()
  {
    return m_codeAntenne;
  }
  
  public void setCodeAntenne(String antenne)
  {
    m_codeAntenne = antenne;
  }
  
  public String getIdentifiantDNA()
  {
    return m_identifiantDNA;
  }
  
  public void setIdentifiantDNA(String m_identifiantdna)
  {
    m_identifiantDNA = m_identifiantdna;
  }
  
  public String getTopReferent()
  {
    return m_topReferent;
  }
  
  public void setTopReferent(String referent)
  {
    m_topReferent = referent;
  }
}

/* Location:
 * Qualified Name:     StructureOutRechercheAliasNCPReferent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */