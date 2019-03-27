package fr.unedic.cali.autresdoms.cohab.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;

public class ObjetChronoPeriodePriseEnCharge
  extends ObjetChronoPeriode
{
  private static final long serialVersionUID = -5246831261707024111L;
  private boolean m_estCes;
  private String m_motifAnnulation;
  private String m_categorie;
  private int m_identifiantPec;
  private String m_aleIndividu;
  private Damj m_dateDispenseRechercheEmploi;
  private boolean m_estDispenseRechercheEmploi;
  private String m_typePec;
  private String m_sousType;
  private transient boolean m_demandeurEmploi;
  private transient boolean m_actualise;
  private String m_codeAuTitre;
  private String m_situationEmploi;
  public String m_codePays;
  public String m_contexteEESSI;
  public static final String CONTEXTE_EESSI_NON_RENSEIGNE = "0";
  public static final String CONTEXTE_EESSI_MAINTIEN_INDEMNISATION_FRANCE = "1";
  public static final String CONTEXTE_EESSI_MAINTIEN_INDEMNISATION_EUROPE = "2";
  public static final String CONTEXTE_EESSI_DOUBLE_INSCRIPTION_FRANCE = "3";
  public String m_contextePECNonIndemnisable;
  public String m_numeroAffiliation;
  public String m_numeroSiren;
  public String m_identifiantBne;
  public static final String CONTEXTE_PEC_NON_INDEMNISABLE_MAYOTTE = "M";
  public static final String CATEGORIE_1_DISPONIBLE_SANS_EMPLOI_DUREE_INDETERMINEE_TEMPS_PLEIN = "1";
  public static final String CATEGORIE_2_DISPONIBLE_SANS_EMPLOI_DUREE_INDETERMINEE_TEMPS_PARTIEL = "2";
  public static final String CATEGORIE_3_DISPONIBLE_SANS_EMPLOI_DUREE_INDETERMINEE = "3";
  public static final String CATEGORIE_4_NON_DISPONIBLE_SANS_EMPLOI = "4";
  public static final String CATEGORIE_5_NON_DISPONIBLE_AVEC_EMPLOI = "5";
  
  public ObjetChronoPeriodePriseEnCharge() {}
  
  public ObjetChronoPeriodePriseEnCharge(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public ObjetChronoPeriodePriseEnCharge(Periode p_periode)
  {
    super(p_periode);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodePriseEnCharge copie = new ObjetChronoPeriodePriseEnCharge();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    ObjetChronoPeriodePriseEnCharge copie = (ObjetChronoPeriodePriseEnCharge)p_copie;
    
    super.copieElements(p_copie);
    
    copie.setCodeAuTitre(getCodeAuTitre());
    copie.setAleIndividu(getAleIndividu());
    copie.setCategorie(getCategorie());
    copie.setDateDispenseRechercheEmploi(getDateDispenseRechercheEmploi());
    copie.setEstCes(estCes());
    copie.setEstDispenseRechercheEmploi(estDispenseRechercheEmploi());
    copie.setIdentifiantPec(getIdentifiantPec());
    copie.setMotifAnnulation(getMotifAnnulation());
    
    copie.setTypePec(getTypePec());
    copie.setSousType(getSousType());
    copie.setDemandeurEmploi(getDemandeurEmploi());
    copie.setActualise(getActualise());
    copie.setCodePays(getCodePays());
    copie.setContexteEESSI(getContexteEESSI());
    copie.setContextePECNonIndemnisable(getContextePECNonIndemnisable());
    copie.setSituationEmploi(getSituationEmploi());
  }
  
  public boolean estCes()
  {
    return m_estCes;
  }
  
  public void setEstCes(boolean p_estCes)
  {
    m_estCes = p_estCes;
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
  
  public void setIdentifiantPec(int p_i)
  {
    m_identifiantPec = p_i;
  }
  
  public void setDateDispenseRechercheEmploi(Damj p_dateDispense)
  {
    m_dateDispenseRechercheEmploi = p_dateDispense;
  }
  
  public Damj getDateDispenseRechercheEmploi()
  {
    return m_dateDispenseRechercheEmploi;
  }
  
  public String getAleIndividu()
  {
    return m_aleIndividu;
  }
  
  public void setAleIndividu(String p_aleIndividu)
  {
    m_aleIndividu = p_aleIndividu;
  }
  
  public boolean estDispenseRechercheEmploi()
  {
    return m_estDispenseRechercheEmploi;
  }
  
  public void setEstDispenseRechercheEmploi(boolean p_estDispenseRechercheEmploi)
  {
    m_estDispenseRechercheEmploi = p_estDispenseRechercheEmploi;
  }
  
  public String getSousType()
  {
    return m_sousType;
  }
  
  public void setSousType(String p_sousType)
  {
    m_sousType = p_sousType;
  }
  
  public String getTypePec()
  {
    return m_typePec;
  }
  
  public void setTypePec(String p_typePec)
  {
    m_typePec = p_typePec;
  }
  
  public boolean isAnnulee()
  {
    return (getDuree() <= 1) && (!"72".equals(getMotifAnnulation())) && (!"31".equals(getMotifAnnulation())) && (!"34".equals(getMotifAnnulation())) && (!"18".equals(getMotifAnnulation())) && (!"19".equals(getMotifAnnulation())) && (!"29".equals(getMotifAnnulation())) && (!"30".equals(getMotifAnnulation())) && (!"16".equals(getMotifAnnulation()));
  }
  
  public boolean getActualise()
  {
    return m_actualise;
  }
  
  public void setActualise(boolean p_actualise)
  {
    m_actualise = p_actualise;
  }
  
  public boolean getDemandeurEmploi()
  {
    return m_demandeurEmploi;
  }
  
  public void setDemandeurEmploi(boolean p_demandeurEmploi)
  {
    m_demandeurEmploi = p_demandeurEmploi;
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
  
  public String getContextePECNonIndemnisable()
  {
    return m_contextePECNonIndemnisable;
  }
  
  public void setContextePECNonIndemnisable(String p_contextePECNonIndemnisable)
  {
    m_contextePECNonIndemnisable = p_contextePECNonIndemnisable;
  }
  
  public boolean estUnePecCTP()
  {
    return (("1".equals(getTypePec())) && ("8".equals(getSousType()))) || (("2".equals(getTypePec())) && ("8".equals(getSousType())));
  }
  
  public boolean estDeTypeAdr()
  {
    return (getTypePec().equals("1")) && (getSousType().equals("9"));
  }
  
  public boolean estDeTypeArce()
  {
    return (getTypePec().equals("1")) && (getSousType().equals("7")) && (getCodeAuTitre().equals("3"));
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
  
  public String getSituationEmploi()
  {
    return m_situationEmploi;
  }
  
  public void setSituationEmploi(String p_situationEmploi)
  {
    m_situationEmploi = p_situationEmploi;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodePriseEnCharge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */