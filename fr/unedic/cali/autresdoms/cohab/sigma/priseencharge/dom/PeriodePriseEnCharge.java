package fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom.spec.PeriodePriseEnChargeSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;

public class PeriodePriseEnCharge
  extends ObjetChronoPeriode
  implements PeriodePriseEnChargeSpec
{
  private String m_motifAnnulation;
  private String m_categorie;
  private int m_identifiantPec;
  private boolean m_dispense;
  private boolean m_ces;
  private boolean m_actualisable;
  private String m_aleIndividu;
  private Damj m_dateDispense;
  private String m_typePec;
  private String m_sousTypePec;
  private String m_situationEmploi;
  private String m_codeAuTitre;
  private transient boolean m_demandeurEmploi;
  private transient boolean m_actualise;
  public String m_codePays;
  public String m_contexteEESSI;
  public String m_contextePECNonIndemnisable;
  public String m_numeroAffiliation;
  public String m_numeroSiren;
  public String m_identifiantBne;
  
  public String getCodeAuTitre()
  {
    return m_codeAuTitre;
  }
  
  public void setCodeAuTitre(String p_codeAuTitre)
  {
    m_codeAuTitre = p_codeAuTitre;
  }
  
  public String getContextePECNonIndemnisable()
  {
    return m_contextePECNonIndemnisable;
  }
  
  public void setContextePECNonIndemnisable(String p_contextePECNonIndemnisable)
  {
    m_contextePECNonIndemnisable = p_contextePECNonIndemnisable;
  }
  
  public boolean isActualisable()
  {
    return m_actualisable;
  }
  
  public void setActualisable(boolean p_actualisable)
  {
    m_actualisable = p_actualisable;
  }
  
  public String getMotifAnnulation()
  {
    return m_motifAnnulation;
  }
  
  public void setMotifAnnulation(String p_motifAnnulation)
  {
    m_motifAnnulation = p_motifAnnulation;
  }
  
  public String getCategorie()
  {
    return m_categorie;
  }
  
  public void setCategorie(String p_categorie)
  {
    m_categorie = p_categorie;
  }
  
  public int getIdentifiantPec()
  {
    return m_identifiantPec;
  }
  
  public void setIdentifiantPec(int p_identifiantPec)
  {
    m_identifiantPec = p_identifiantPec;
  }
  
  public boolean isCes()
  {
    return m_ces;
  }
  
  public void setCes(boolean p_ces)
  {
    m_ces = p_ces;
  }
  
  public boolean isDispense()
  {
    return m_dispense;
  }
  
  public void setDispense(boolean p_dispense)
  {
    m_dispense = p_dispense;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    throw new UnsupportedOperationException("La méthode copieElements(ObjetMetierSpec) n'est pas implémentée.");
  }
  
  public ObjetMetierSpec copie()
  {
    throw new UnsupportedOperationException("La méthode copie() n'est pas implémentée.");
  }
  
  public String getAleIndividu()
  {
    return m_aleIndividu;
  }
  
  public void setAleIndividu(String p_aleIndividu)
  {
    m_aleIndividu = p_aleIndividu;
  }
  
  public Damj getDateDispense()
  {
    return m_dateDispense;
  }
  
  public void setDateDispense(Damj p_dateDispense)
  {
    m_dateDispense = p_dateDispense;
  }
  
  public String getSituationEmploi()
  {
    return m_situationEmploi;
  }
  
  public void setSituationEmploi(String p_emploi)
  {
    m_situationEmploi = p_emploi;
  }
  
  public String getSousTypePec()
  {
    return m_sousTypePec;
  }
  
  public void setSousTypePec(String p_sousTypePec)
  {
    m_sousTypePec = p_sousTypePec;
  }
  
  public String getTypePec()
  {
    return m_typePec;
  }
  
  public void setTypePec(String p_typePec)
  {
    m_typePec = p_typePec;
  }
  
  public boolean getDemandeurEmploi()
  {
    return m_demandeurEmploi;
  }
  
  public void setDemandeurEmploi(boolean p_demandeurEmploi)
  {
    m_demandeurEmploi = p_demandeurEmploi;
  }
  
  public boolean getActualise()
  {
    return m_actualise;
  }
  
  public void setActualise(boolean p_actualise)
  {
    m_actualise = p_actualise;
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
 * Qualified Name:     PeriodePriseEnCharge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */