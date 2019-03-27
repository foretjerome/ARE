package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Periode;

public class PeriodeFormation
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 913275126426425329L;
  private ActionFormation m_actionFormation;
  private int m_identifiantPeriodeFormation;
  private Periode m_periodeEffectiveInitiale;
  private Periode m_periodePrevisionnelleInitiale;
  private String m_typeMesureEmploi;
  
  public int getIdentifiantPeriodeFormation()
  {
    return m_identifiantPeriodeFormation;
  }
  
  public void setIdentifiantPeriodeFormation(int p_identifiantPeriodeFormation)
  {
    m_identifiantPeriodeFormation = p_identifiantPeriodeFormation;
  }
  
  public Periode getPeriodeEffectiveInitiale()
  {
    return m_periodeEffectiveInitiale;
  }
  
  public void setPeriodeEffectiveInitiale(Periode p_periodeEffectiveInitiale)
  {
    m_periodeEffectiveInitiale = p_periodeEffectiveInitiale;
  }
  
  public boolean estEffective()
  {
    return getPeriodeEffectiveInitiale() != null;
  }
  
  public Periode getPeriodePrevisionnelleInitiale()
  {
    return m_periodePrevisionnelleInitiale;
  }
  
  public void setPeriodePrevisionnelleInitiale(Periode p_periodePrevisionnelleInitiale)
  {
    m_periodePrevisionnelleInitiale = p_periodePrevisionnelleInitiale;
  }
  
  public ActionFormation getActionFormation()
  {
    return m_actionFormation;
  }
  
  public void setActionFormation(ActionFormation p_actionFormation)
  {
    m_actionFormation = p_actionFormation;
  }
  
  public String getTypeMesureEmploi()
  {
    return m_typeMesureEmploi;
  }
  
  public void setTypeMesureEmploi(String p_typeMesureEmploi)
  {
    m_typeMesureEmploi = p_typeMesureEmploi;
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeFormation copie = new PeriodeFormation();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeFormation copie = (PeriodeFormation)p_copie;
    super.copieElements(copie);
    m_actionFormation = getActionFormation();
    m_identifiantPeriodeFormation = getIdentifiantPeriodeFormation();
    m_periodeEffectiveInitiale = getPeriodeEffectiveInitiale();
    m_periodePrevisionnelleInitiale = getPeriodePrevisionnelleInitiale();
    m_typeMesureEmploi = getTypeMesureEmploi();
  }
}

/* Location:
 * Qualified Name:     PeriodeFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */