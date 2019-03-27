package fr.unedic.cali.parametres;

import fr.unedic.util.temps.Damj;

public class DateAcces
  implements CleAcces
{
  private Damj m_dateEffet;
  
  public DateAcces(Damj p_date)
  {
    m_dateEffet = p_date;
  }
  
  public boolean equals(Object p_object)
  {
    return ((DateAcces)p_object).getDateEffet().equals(m_dateEffet);
  }
  
  public Damj getDateEffet()
  {
    return m_dateEffet;
  }
  
  public void setDateEffet(Damj p_dateEffet)
  {
    m_dateEffet = p_dateEffet;
  }
}

/* Location:
 * Qualified Name:     DateAcces
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */