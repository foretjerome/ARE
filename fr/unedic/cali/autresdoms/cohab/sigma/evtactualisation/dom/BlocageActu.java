package fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.spec.BlocageActuSpec;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;

public class BlocageActu
  implements BlocageActuSpec
{
  private Collection m_periodesAbsencePointage;
  private Collection m_periodesAbsenceRetourUL961;
  private Collection m_periodesPresenceRetourUL961;
  private Collection m_periodesAbsenceRetourAMS;
  private Collection m_moisMandates;
  private String m_libelleEvtBloquant = null;
  private Damj m_dateEvtBloquant = null;
  
  public Collection getPeriodesNonPayables()
  {
    if (m_periodesAbsencePointage == null) {
      m_periodesAbsencePointage = new ArrayList();
    }
    return m_periodesAbsencePointage;
  }
  
  public void setPeriodesNonPayables(Collection p_periodesAbsencePointage)
  {
    m_periodesAbsencePointage = p_periodesAbsencePointage;
  }
  
  public Collection getPeriodesAbsenceRetourUL961()
  {
    if (m_periodesAbsenceRetourUL961 == null) {
      m_periodesAbsenceRetourUL961 = new ArrayList();
    }
    return m_periodesAbsenceRetourUL961;
  }
  
  public void setPeriodesAbsenceRetourUL961(Collection p_periodesAbsenceRetourUL961)
  {
    m_periodesAbsenceRetourUL961 = p_periodesAbsenceRetourUL961;
  }
  
  public Collection getPeriodesPresenceRetourUL961()
  {
    if (m_periodesPresenceRetourUL961 == null) {
      m_periodesPresenceRetourUL961 = new ArrayList();
    }
    return m_periodesPresenceRetourUL961;
  }
  
  public void setPeriodesPresenceRetourUL961(Collection p_periodesPresenceRetourUL961)
  {
    m_periodesPresenceRetourUL961 = p_periodesPresenceRetourUL961;
  }
  
  public Collection getDonneesMoisMandates()
  {
    if (m_moisMandates == null) {
      m_moisMandates = new ArrayList();
    }
    return m_moisMandates;
  }
  
  public void setDonneesMoisMandates(Collection p_moisMandates)
  {
    m_moisMandates = p_moisMandates;
  }
  
  public boolean isEvtBloquant()
  {
    return m_dateEvtBloquant != null;
  }
  
  public String getLibelleEvtBloquant()
  {
    return m_libelleEvtBloquant;
  }
  
  public void setLibelleEvtBloquant(String p_evtBloquant)
  {
    m_libelleEvtBloquant = p_evtBloquant;
  }
  
  public Damj getDateEvtBloquant()
  {
    return m_dateEvtBloquant;
  }
  
  public void setDateEvtBloquant(Damj p_dateEvtBloquant)
  {
    m_dateEvtBloquant = p_dateEvtBloquant;
  }
  
  public Collection getPeriodesAbsenceRetourAMS()
  {
    if (m_periodesAbsenceRetourAMS == null) {
      m_periodesAbsenceRetourAMS = new ArrayList();
    }
    return m_periodesAbsenceRetourAMS;
  }
  
  public void setPeriodesAbsenceRetourAMS(Collection p_periodesAbsenceRetourAMS)
  {
    m_periodesAbsenceRetourAMS = p_periodesAbsenceRetourAMS;
  }
}

/* Location:
 * Qualified Name:     BlocageActu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */