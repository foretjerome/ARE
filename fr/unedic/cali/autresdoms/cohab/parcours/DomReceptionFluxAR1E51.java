package fr.unedic.cali.autresdoms.cohab.parcours;

public class DomReceptionFluxAR1E51
  extends DomReceptionFluxV1
{
  private String m_referenceExterneDemande;
  private String m_typeDemande;
  private String m_codeGamme;
  private String m_codeLigne;
  
  public String getTypeDemande()
  {
    return m_typeDemande;
  }
  
  public void setTypeDemande(String p_codeSegment)
  {
    m_typeDemande = p_codeSegment;
  }
  
  public String getCodeGamme()
  {
    return m_codeGamme;
  }
  
  public void setCodeGamme(String p_codeGamme)
  {
    m_codeGamme = p_codeGamme;
  }
  
  public String getCodeLigne()
  {
    return m_codeLigne;
  }
  
  public void setCodeLigne(String p_codeLigne)
  {
    m_codeLigne = p_codeLigne;
  }
  
  public String getReferenceExterneDemande()
  {
    return m_referenceExterneDemande;
  }
  
  public void setReferenceExterneDemande(String p_referenceExterneDemande)
  {
    m_referenceExterneDemande = p_referenceExterneDemande;
  }
}

/* Location:
 * Qualified Name:     DomReceptionFluxAR1E51
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */