package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.QuantiteMonnaie;

public class Indemnite
{
  private int m_typeIndemnite;
  private QuantiteMonnaie m_montant;
  
  public QuantiteMonnaie getMontant()
  {
    return m_montant;
  }
  
  public void setMontant(QuantiteMonnaie p_montant)
  {
    m_montant = p_montant;
  }
  
  public int getTypeIndemnite()
  {
    return m_typeIndemnite;
  }
  
  public void setTypeIndemnite(int p_typeIndemnite)
  {
    m_typeIndemnite = p_typeIndemnite;
  }
}

/* Location:
 * Qualified Name:     Indemnite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */