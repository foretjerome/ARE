package fr.unedic.cali.occasionnel;

public class CoupleCodeAntenneRapportId
{
  private String m_codeAntenne;
  private int m_rapportId;
  
  public String getCodeAntenne()
  {
    return m_codeAntenne;
  }
  
  public void setCodeAntenne(String p_codeAntenne)
  {
    m_codeAntenne = p_codeAntenne;
  }
  
  public int getRapportId()
  {
    return m_rapportId;
  }
  
  public void setRapportId(int p_rapportId)
  {
    m_rapportId = p_rapportId;
  }
  
  public int hashCode()
  {
    return (m_rapportId + m_codeAntenne.hashCode()) * 3;
  }
  
  public boolean equals(Object p_obj)
  {
    CoupleCodeAntenneRapportId autre = (CoupleCodeAntenneRapportId)p_obj;
    return (m_codeAntenne.equals(autre.getCodeAntenne())) && (m_rapportId == autre.getRapportId());
  }
}

/* Location:
 * Qualified Name:     CoupleCodeAntenneRapportId
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */