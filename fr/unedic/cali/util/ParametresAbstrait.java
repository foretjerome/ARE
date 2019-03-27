package fr.unedic.cali.util;

import java.util.Hashtable;

public abstract class ParametresAbstrait
{
  protected Hashtable m_table = new Hashtable();
  
  protected void ajouter(Object p_cle, Object p_valeur)
  {
    m_table.put(p_cle, p_valeur);
  }
  
  protected Object get(Object p_cle)
  {
    return m_table.get(p_cle);
  }
}

/* Location:
 * Qualified Name:     ParametresAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */