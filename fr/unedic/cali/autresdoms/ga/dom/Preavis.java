package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class Preavis
{
  private Periode m_periodeEffectuee;
  private Periode m_periodeNonEffectueePayee;
  private Periode m_periodeNonEffectueeNonPayee;
  private boolean m_actionPrudhommale;
  private boolean m_engagementRemboursement;
  private Damj m_dateActionPrudhommale;
  private Damj m_dateAccordPreavis;
  private Damj m_dateRefusPreavis;
  
  public Periode getPeriodeEffectuee()
  {
    return m_periodeEffectuee;
  }
  
  public Periode getPeriodeNonEffectueeNonPayee()
  {
    return m_periodeNonEffectueeNonPayee;
  }
  
  public Periode getPeriodeNonEffectueePayee()
  {
    return m_periodeNonEffectueePayee;
  }
  
  public void setPeriodeEffectuee(Periode p_periode)
  {
    m_periodeEffectuee = p_periode;
  }
  
  public void setPeriodeNonEffectueeNonPayee(Periode p_periode)
  {
    m_periodeNonEffectueeNonPayee = p_periode;
  }
  
  public void setPeriodeNonEffectueePayee(Periode p_periode)
  {
    m_periodeNonEffectueePayee = p_periode;
  }
  
  public boolean estEffectue()
  {
    return (m_periodeEffectuee != null) && (m_periodeNonEffectueeNonPayee == null) && (m_periodeNonEffectueePayee == null);
  }
  
  public Damj getDebut()
  {
    Damj dateDebut = null;
    if (m_periodeEffectuee != null) {
      dateDebut = min(dateDebut, m_periodeEffectuee.getDebut());
    }
    if (m_periodeNonEffectueeNonPayee != null) {
      dateDebut = min(dateDebut, m_periodeNonEffectueeNonPayee.getDebut());
    }
    if (m_periodeNonEffectueePayee != null) {
      dateDebut = min(dateDebut, m_periodeNonEffectueePayee.getDebut());
    }
    return dateDebut;
  }
  
  public Damj getFin()
  {
    Damj dateFin = null;
    if (m_periodeEffectuee != null) {
      dateFin = max(dateFin, m_periodeEffectuee.getFin());
    }
    if (m_periodeNonEffectueeNonPayee != null) {
      dateFin = max(dateFin, m_periodeNonEffectueeNonPayee.getFin());
    }
    if (m_periodeNonEffectueePayee != null) {
      dateFin = max(dateFin, m_periodeNonEffectueePayee.getFin());
    }
    return dateFin;
  }
  
  private Damj min(Damj p_date1, Damj p_date2)
  {
    if (p_date1 == null) {
      return p_date2;
    }
    if (p_date2 == null) {
      return p_date1;
    }
    return Damj.min(p_date1, p_date2);
  }
  
  private Damj max(Damj p_date1, Damj p_date2)
  {
    if (p_date1 == null) {
      return p_date2;
    }
    if (p_date2 == null) {
      return p_date1;
    }
    return Damj.max(p_date1, p_date2);
  }
  
  public Damj getDateAccordPreavis()
  {
    return m_dateAccordPreavis;
  }
  
  public void setDateAccordPreavis(Damj p_dateAccordPreavis)
  {
    m_dateAccordPreavis = p_dateAccordPreavis;
  }
  
  public Damj getDateActionPrudhommale()
  {
    return m_dateActionPrudhommale;
  }
  
  public void setDateActionPrudhommale(Damj p_dateActionPrudhommale)
  {
    m_dateActionPrudhommale = p_dateActionPrudhommale;
  }
  
  public Damj getDateRefusPreavis()
  {
    return m_dateRefusPreavis;
  }
  
  public void setDateRefusPreavis(Damj p_dateRefusPreavis)
  {
    m_dateRefusPreavis = p_dateRefusPreavis;
  }
  
  public boolean isActionPrudhommale()
  {
    return m_actionPrudhommale;
  }
  
  public void setActionPrudhommale(boolean p_actionPrudhommale)
  {
    m_actionPrudhommale = p_actionPrudhommale;
  }
  
  public boolean isEngagementRemboursement()
  {
    return m_engagementRemboursement;
  }
  
  public void setEngagementRemboursement(boolean p_engagementRemboursement)
  {
    m_engagementRemboursement = p_engagementRemboursement;
  }
}

/* Location:
 * Qualified Name:     Preavis
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */