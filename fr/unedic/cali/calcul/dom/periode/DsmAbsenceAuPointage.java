package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class DsmAbsenceAuPointage
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -596968554502638430L;
  private boolean m_isJustifiee;
  private transient boolean m_estMigree;
  
  protected DsmAbsenceAuPointage() {}
  
  public DsmAbsenceAuPointage(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public void setJustifiee(boolean p_isJustifiee)
  {
    m_isJustifiee = p_isJustifiee;
  }
  
  public boolean isJustifiee()
  {
    return m_isJustifiee;
  }
  
  public ObjetMetierSpec copie()
  {
    DsmAbsenceAuPointage copie = new DsmAbsenceAuPointage();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    DsmAbsenceAuPointage copie = (DsmAbsenceAuPointage)p_copie;
    
    super.copieElements(copie);
    
    m_isJustifiee = isJustifiee();
  }
  
  public boolean estMigree()
  {
    return m_estMigree;
  }
  
  public void setEstMigree(boolean p_estMigree)
  {
    m_estMigree = p_estMigree;
  }
}

/* Location:
 * Qualified Name:     DsmAbsenceAuPointage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */