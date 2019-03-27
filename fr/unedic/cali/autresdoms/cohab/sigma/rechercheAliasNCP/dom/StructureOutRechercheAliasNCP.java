package fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.spec.StructureOutRechercheAliasNCPSpec;

public class StructureOutRechercheAliasNCP
  implements StructureOutRechercheAliasNCPSpec
{
  private String m_NumeroAllocataire = null;
  private String m_IdentifiantSigma = null;
  private String m_CodeAssedic = null;
  private String m_codeAliasNCP = null;
  
  public String getNumeroAllocataire()
  {
    return m_NumeroAllocataire;
  }
  
  public void setNumeroAllocataire(String p_cxala)
  {
    m_NumeroAllocataire = p_cxala;
  }
  
  public String getIdentifiantSigma()
  {
    return m_IdentifiantSigma;
  }
  
  public void setIdentifiantSigma(String p_rsin)
  {
    m_IdentifiantSigma = p_rsin;
  }
  
  public String getCodeAssedic()
  {
    return m_CodeAssedic;
  }
  
  public void setCodeAssedic(String p_cxass)
  {
    m_CodeAssedic = p_cxass;
  }
  
  public String getCodeAliasNCP()
  {
    return m_codeAliasNCP;
  }
  
  public void setCodeAliasNCP(String p_cincp)
  {
    m_codeAliasNCP = p_cincp;
  }
}

/* Location:
 * Qualified Name:     StructureOutRechercheAliasNCP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */