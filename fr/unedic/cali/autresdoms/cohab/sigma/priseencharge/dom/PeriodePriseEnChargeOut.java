package fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom.spec.PeriodePriseEnChargeOutSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;

public class PeriodePriseEnChargeOut
  extends ObjetChronoPeriode
  implements PeriodePriseEnChargeOutSpec
{
  private static final long serialVersionUID = 4353260611879931341L;
  private String m_motifAnnulation;
  private String m_categorie;
  private int m_identifiantPec;
  private boolean m_dispense;
  private boolean m_ces;
  private String m_typePec;
  private String m_sousType;
  private boolean m_actualisable;
  private String m_aleIndividu;
  private String m_situationEmploi;
  private Damj m_dateDispense;
  private String m_codeAuTitre;
  public static final String SITUATION_EMPLOI_CEN = "CEN";
  public static final String SITUATION_EMPLOI_CES = "CES";
  public static final String SITUATION_EMPLOI_CRP = "CRP";
  public static final String SITUATION_EMPLOI_CSP = "CSP";
  public String m_codePays;
  public String m_contexteEESSI;
  public String m_contextePECNonIndemnisable;
  public String m_numeroAffiliation;
  public String m_numeroSiren;
  public String m_identifiantBne;
  
  public String getContextePECNonIndemnisable()
  {
    return m_contextePECNonIndemnisable;
  }
  
  public void setContextePECNonIndemnisable(String p_contextePECNonIndemnisable)
  {
    m_contextePECNonIndemnisable = p_contextePECNonIndemnisable;
  }
  
  public String getCategorie()
  {
    return m_categorie;
  }
  
  public int getIdentifiantPec()
  {
    return m_identifiantPec;
  }
  
  public String getMotifAnnulation()
  {
    return m_motifAnnulation;
  }
  
  public String getSousTypePec()
  {
    return m_sousType;
  }
  
  public String getTypePec()
  {
    return m_typePec;
  }
  
  public boolean isCes()
  {
    return m_ces;
  }
  
  public boolean isDispense()
  {
    return m_dispense;
  }
  
  public void setSousTypePec(String p_sousType)
  {
    m_sousType = p_sousType;
  }
  
  public void setTypePec(String p_typePec)
  {
    m_typePec = p_typePec;
  }
  
  public void setCategorie(String p_categorie)
  {
    m_categorie = p_categorie;
  }
  
  public void setCes(boolean p_ces)
  {
    m_ces = p_ces;
  }
  
  public void setDispense(boolean p_dispense)
  {
    m_dispense = p_dispense;
  }
  
  public void setIdentifiantPec(int p_identifiant)
  {
    m_identifiantPec = p_identifiant;
  }
  
  public void setMotifAnnulation(String p_motifAnnulation)
  {
    m_motifAnnulation = p_motifAnnulation;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    throw new UnsupportedOperationException("La méthode copieElements(ObjetMetierSpec) n'est pas implémentée.");
  }
  
  public ObjetMetierSpec copie()
  {
    throw new UnsupportedOperationException("La méthode copie() n'est pas implémentée.");
  }
  
  public boolean isActualisable()
  {
    return m_actualisable;
  }
  
  public void setActualisable(boolean p_actualisable)
  {
    m_actualisable = p_actualisable;
  }
  
  public String getAleIndividu()
  {
    return m_aleIndividu;
  }
  
  public void setAleIndividu(String p_aleIndividu)
  {
    m_aleIndividu = p_aleIndividu;
  }
  
  public String getSituationEmploi()
  {
    return m_situationEmploi;
  }
  
  public void setSituationEmploi(String p_situationEmploi)
  {
    m_situationEmploi = p_situationEmploi;
  }
  
  public Damj getDateDispense()
  {
    return m_dateDispense;
  }
  
  public void setDateDispense(Damj p_dateDispense)
  {
    m_dateDispense = p_dateDispense;
  }
  
  public String getCodeAuTitre()
  {
    return m_codeAuTitre;
  }
  
  public void setCodeAuTitre(String p_codeAuTitre)
  {
    m_codeAuTitre = p_codeAuTitre;
  }
  
  public String getCodePays()
  {
    return m_codePays;
  }
  
  public void setCodePays(String p_codePays)
  {
    m_codePays = p_codePays;
  }
  
  public void setContexteEESSI(String p_contexteEESSI)
  {
    m_contexteEESSI = p_contexteEESSI;
  }
  
  public String getContexteEESSI()
  {
    return m_contexteEESSI;
  }
  
  public String getIdentifiantBne()
  {
    return m_identifiantBne;
  }
  
  public String getNumeroAffiliation()
  {
    return m_numeroAffiliation;
  }
  
  public String getNumeroSiren()
  {
    return m_numeroSiren;
  }
  
  public void setIdentifiantBne(String p_identifiantBne)
  {
    m_identifiantBne = p_identifiantBne;
  }
  
  public void setNumeroAffiliation(String p_numeroAffiliation)
  {
    m_numeroAffiliation = p_numeroAffiliation;
  }
  
  public void setNumeroSiren(String p_numeroSiren)
  {
    m_numeroSiren = p_numeroSiren;
  }
}

/* Location:
 * Qualified Name:     PeriodePriseEnChargeOut
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */