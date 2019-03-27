package fr.unedic.cali.calcul.outilsfonctionnels.dom;

public class ElementBaseIndemnisationFacade
{
  private String m_coefficientSaisonnier = null;
  private String m_coefficientTempsPartiel = null;
  private String m_coefficientAvantageVieillesse = null;
  private String m_montantAvantageVieillesse = null;
  private String m_tauxAvantageVieillesse = null;
  private String m_montantPensionInvaliditeADeduire = null;
  private String m_sjr = null;
  private String m_sjc = null;
  private String m_ressource = null;
  private String m_coefficientPPA = null;
  private String m_contexte = null;
  private String m_salaireMensuelContratADR = null;
  private String m_montantIH = null;
  private String m_montantIT = null;
  private String m_cumulActivite = null;
  
  public String getCumulActivite()
  {
    return m_cumulActivite;
  }
  
  public void setCumulActivite(String p_cumulActivite)
  {
    m_cumulActivite = p_cumulActivite;
  }
  
  public String getCoefficientPPA()
  {
    return m_coefficientPPA;
  }
  
  public void setCoefficientPPA(String p_coefficientPPA)
  {
    m_coefficientPPA = p_coefficientPPA;
  }
  
  public String getCoefficientAvantageVieillesse()
  {
    return m_coefficientAvantageVieillesse;
  }
  
  public String getCoefficientSaisonnier()
  {
    return m_coefficientSaisonnier;
  }
  
  public String getCoefficientTempsPartiel()
  {
    return m_coefficientTempsPartiel;
  }
  
  public String getMontantPensionInvaliditeADeduire()
  {
    return m_montantPensionInvaliditeADeduire;
  }
  
  public String getSjc()
  {
    return m_sjc;
  }
  
  public String getSjr()
  {
    return m_sjr;
  }
  
  public void setCoefficientAvantageVieillesse(String p_coefficientAvantageVieillesse)
  {
    m_coefficientAvantageVieillesse = p_coefficientAvantageVieillesse;
  }
  
  public void setCoefficientSaisonnier(String p_coefficientSaisonnier)
  {
    m_coefficientSaisonnier = p_coefficientSaisonnier;
  }
  
  public void setCoefficientTempsPartiel(String p_coefficientTempsPartiel)
  {
    m_coefficientTempsPartiel = p_coefficientTempsPartiel;
  }
  
  public void setMontantPensionInvaliditeADeduire(String p_montantPensionInvaliditeADeduire)
  {
    m_montantPensionInvaliditeADeduire = p_montantPensionInvaliditeADeduire;
  }
  
  public void setSjc(String p_sjc)
  {
    m_sjc = p_sjc;
  }
  
  public void setSjr(String p_sjr)
  {
    m_sjr = p_sjr;
  }
  
  public void setRessource(String p_ressource)
  {
    m_ressource = p_ressource;
  }
  
  public String getRessource()
  {
    return m_ressource;
  }
  
  public String getTauxAvantageVieillesseCourant()
  {
    return null;
  }
  
  public String getTauxAvantageVieillesse()
  {
    return m_tauxAvantageVieillesse;
  }
  
  public void setTauxAvantageVieillesse(String p_taux)
  {
    m_tauxAvantageVieillesse = p_taux;
  }
  
  public String getMontantAvantageVieillesse()
  {
    return m_montantAvantageVieillesse;
  }
  
  public void setMontantAvantageVieillesse(String p_montantAvantageVieillesse)
  {
    m_montantAvantageVieillesse = p_montantAvantageVieillesse;
  }
  
  public String getContexte()
  {
    return m_contexte;
  }
  
  public void setContexte(String p_contexte)
  {
    m_contexte = p_contexte;
  }
  
  public String getSalaireMensuelContratADR()
  {
    return m_salaireMensuelContratADR;
  }
  
  public void setSalaireMensuelContratADR(String p_salaireMensuelContratADR)
  {
    m_salaireMensuelContratADR = p_salaireMensuelContratADR;
  }
  
  public String getMontantIH()
  {
    return m_montantIH;
  }
  
  public void setMontantIH(String p_montantIH)
  {
    m_montantIH = p_montantIH;
  }
  
  public String getMontantIT()
  {
    return m_montantIT;
  }
  
  public void setMontantIT(String p_montantIT)
  {
    m_montantIT = p_montantIT;
  }
}

/* Location:
 * Qualified Name:     ElementBaseIndemnisationFacade
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */