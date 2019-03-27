package fr.unedic.cali.parcours;

import fr.unedic.cali.calcul.dom.CalendrierExecutionAvantSpec;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.util.services.Resultat;

public class ResultatCalcul
  extends Resultat
{
  private transient CalendrierExecutionCalculSpec m_calendrierExecutionCalcul = null;
  private transient CalendrierExecutionAvantSpec m_calendrierExecutionAvantCalcul = null;
  
  public CalendrierExecutionCalculSpec getCalendrierExecutionCalcul()
  {
    return m_calendrierExecutionCalcul;
  }
  
  public void setCalendrierExecutionCalcul(CalendrierExecutionCalculSpec p_calendrierExecutionCalcul)
  {
    m_calendrierExecutionCalcul = p_calendrierExecutionCalcul;
  }
  
  public CalendrierExecutionAvantSpec getCalendrierExecutionAvantCalcul()
  {
    return m_calendrierExecutionAvantCalcul;
  }
  
  public void setCalendrierExecutionAvantCalcul(CalendrierExecutionAvantSpec p_calendrierExecutionAvantCalcul)
  {
    m_calendrierExecutionAvantCalcul = p_calendrierExecutionAvantCalcul;
  }
}

/* Location:
 * Qualified Name:     ResultatCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */