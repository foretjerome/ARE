package fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.spec.StructureOutBlocageActuSpec;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;

public class StructureOutBlocageActu
  implements StructureOutBlocageActuSpec
{
  private Collection m_listeBlocagesActu;
  private Collection m_periodesAbsencePointage;
  private Collection m_periodesAbsenceRetourUL961;
  private Collection m_periodesPresenceRetourUL961;
  private Collection m_periodesAbsenceRetourAMS;
  private Collection m_moisMandates;
  private Damj m_dateEvtBloquant = null;
  private String m_libelleMotifEvtBloquant = null;
  public static final String PI = "blocage pour signal. pension d'inval. sur le DSM";
  public static final String PR = "blocage pour signal. pension de retraite sur le DSM";
  public static final String RE = "blocage pour arret recherche d'empl. sign. sur le DSM";
  public static final String GR = "blocage pour signal maternité sans date sur le DSM";
  public static final String DR = "DSM en multi-déclaration recyclée";
  public static final String DI = "blocage pour motif divers";
  public static final String AD = "blocage ADE si actu sans déclaration TO";
  public static final String CR = "blocage pour changement de situation et D.E. en CRP";
  public static final String FO = "blocage pour signal formation";
  public static final String NR = "blocage paiement pour DE migre NCP en renouvellement";
  public static final String TO = "blocage pour D.E. en CTP ayant déclaré du TO";
  public static final String CT = "blocage pour changement de situation et D.E. en CTP";
  public static final String DC = "Blocage suite info CNAV décès certifié";
  public static final String DP = "Blocage suite info CNAV décès présumé";
  public static final String ST = "Blocage indemnisation pour DE en fin de formation";
  
  public Collection getListeBlocagesActu()
  {
    if (m_listeBlocagesActu == null)
    {
      m_listeBlocagesActu = new ArrayList();
      
      m_listeBlocagesActu.addAll(getPeriodesNonPayables());
      
      m_listeBlocagesActu.addAll(getPeriodesAbsenceRetourUL961());
      
      m_listeBlocagesActu.addAll(getPeriodesPresenceRetourUL961());
    }
    return m_listeBlocagesActu;
  }
  
  public void setListeBlocagesActu(Collection p_listePeriodesNonPayables)
  {
    m_listeBlocagesActu = p_listePeriodesNonPayables;
  }
  
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
  
  public Damj getDateEvtBloquant()
  {
    return m_dateEvtBloquant;
  }
  
  public void setDateEvtBloquant(Damj p_dateEvtBloquant)
  {
    m_dateEvtBloquant = p_dateEvtBloquant;
  }
  
  public String getLibelleMotifEvtBloquant()
  {
    return m_libelleMotifEvtBloquant;
  }
  
  public void setMotifEvtBloquant(String p_motifEvtBloquant)
  {
    if (p_motifEvtBloquant != null)
    {
      if (p_motifEvtBloquant.compareTo("PI") == 0) {
        m_libelleMotifEvtBloquant = "blocage pour signal. pension d'inval. sur le DSM";
      }
      if (p_motifEvtBloquant.compareTo("PR") == 0) {
        m_libelleMotifEvtBloquant = "blocage pour signal. pension de retraite sur le DSM";
      }
      if (p_motifEvtBloquant.compareTo("FO") == 0) {
        m_libelleMotifEvtBloquant = "blocage pour signal formation";
      }
      if (p_motifEvtBloquant.compareTo("RE") == 0) {
        m_libelleMotifEvtBloquant = "blocage pour arret recherche d'empl. sign. sur le DSM";
      }
      if (p_motifEvtBloquant.compareTo("GR") == 0) {
        m_libelleMotifEvtBloquant = "blocage pour signal maternité sans date sur le DSM";
      }
      if (p_motifEvtBloquant.compareTo("DR") == 0) {
        m_libelleMotifEvtBloquant = "DSM en multi-déclaration recyclée";
      }
      if (p_motifEvtBloquant.compareTo("DI") == 0) {
        m_libelleMotifEvtBloquant = "blocage pour motif divers";
      }
      if (p_motifEvtBloquant.compareTo("AD") == 0) {
        m_libelleMotifEvtBloquant = "blocage ADE si actu sans déclaration TO";
      }
      if (p_motifEvtBloquant.compareTo("CR") == 0) {
        m_libelleMotifEvtBloquant = "blocage pour changement de situation et D.E. en CRP";
      }
      if (p_motifEvtBloquant.compareTo("NR") == 0) {
        m_libelleMotifEvtBloquant = "blocage paiement pour DE migre NCP en renouvellement";
      }
      if (p_motifEvtBloquant.compareTo("TO") == 0) {
        m_libelleMotifEvtBloquant = "blocage pour D.E. en CTP ayant déclaré du TO";
      }
      if (p_motifEvtBloquant.compareTo("CT") == 0) {
        m_libelleMotifEvtBloquant = "blocage pour changement de situation et D.E. en CTP";
      }
      if (p_motifEvtBloquant.compareTo("DC") == 0) {
        m_libelleMotifEvtBloquant = "Blocage suite info CNAV décès certifié";
      }
      if (p_motifEvtBloquant.compareTo("DP") == 0) {
        m_libelleMotifEvtBloquant = "Blocage suite info CNAV décès présumé";
      }
      if (p_motifEvtBloquant.compareTo("ST") == 0) {
        m_libelleMotifEvtBloquant = "Blocage indemnisation pour DE en fin de formation";
      }
    }
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
 * Qualified Name:     StructureOutBlocageActu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */