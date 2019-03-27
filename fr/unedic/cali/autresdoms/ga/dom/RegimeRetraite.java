package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.ObjetMetierSpec;

public class RegimeRetraite
  implements ObjetMetierSpec
{
  private boolean m_alsaceMoselle;
  private boolean m_caisseRetraiteAbsente;
  
  public boolean estAlsaceMoselle()
  {
    return m_alsaceMoselle;
  }
  
  public void setAlsaceMoselle(boolean p_alsaceMoselle)
  {
    m_alsaceMoselle = p_alsaceMoselle;
  }
  
  public boolean estCaisseRetraiteAbsente()
  {
    return m_caisseRetraiteAbsente;
  }
  
  public void setCaisseRetraiteAbsente(boolean p_caisseRetraiteAbsente)
  {
    m_caisseRetraiteAbsente = p_caisseRetraiteAbsente;
  }
  
  public ObjetMetierSpec copie()
  {
    return this;
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     RegimeRetraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */