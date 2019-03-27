package fr.unedic.cali.autresdoms.cohab.dom;

public class QuadrupletteIndividu
  extends SeptupletteIndividu
  implements IndividuPopulationImpl
{
  private String m_numeroAllocataireRsin;
  private String m_numeroAllocataireBniCxala;
  private String m_codeAssedic;
  private String m_aliasNCP;
  
  public String getCodeAssedic()
  {
    return m_codeAssedic;
  }
  
  public void setCodeAssedic(String p_codeAssedic)
  {
    m_codeAssedic = p_codeAssedic;
  }
  
  public String getNumeroAllocataireBniCxala()
  {
    return m_numeroAllocataireBniCxala;
  }
  
  public void setNumeroAllocataireBniCxala(String p_numeroAllocataireBniCxala)
  {
    m_numeroAllocataireBniCxala = p_numeroAllocataireBniCxala;
  }
  
  public String getNumeroAllocataireRsin()
  {
    return m_numeroAllocataireRsin;
  }
  
  public void setNumeroAllocataireRsin(String p_numeroAllocataireRsin)
  {
    m_numeroAllocataireRsin = p_numeroAllocataireRsin;
  }
  
  public String getAliasNCP()
  {
    return m_aliasNCP;
  }
  
  public void setAliasNCP(String p_aliasNCP)
  {
    m_aliasNCP = p_aliasNCP;
  }
}

/* Location:
 * Qualified Name:     QuadrupletteIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */