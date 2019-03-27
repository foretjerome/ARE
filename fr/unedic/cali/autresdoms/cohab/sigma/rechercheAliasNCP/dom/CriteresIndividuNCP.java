package fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.spec.CriteresIndividuNCPSpec;

public class CriteresIndividuNCP
  implements CriteresIndividuNCPSpec
{
  private String m_numeroAllocataire = null;
  private String m_aliasNcp = null;
  private String m_identifiantSigma = null;
  private String m_codeAssedic = null;
  
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
}

/* Location:
 * Qualified Name:     CriteresIndividuNCP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */