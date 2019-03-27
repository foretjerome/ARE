package fr.unedic.cali.dom;

public class IndividuId
  implements IndividuIdSpec
{
  private Object m_identifiant = null;
  private IndividuSpec m_individu = null;
  
  public IndividuId() {}
  
  public IndividuId(Object p_identifiant)
  {
    m_identifiant = p_identifiant;
  }
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
  
  public String getId()
  {
    return String.valueOf(m_identifiant);
  }
  
  public String toString()
  {
    return String.valueOf(m_identifiant);
  }
}

/* Location:
 * Qualified Name:     IndividuId
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */