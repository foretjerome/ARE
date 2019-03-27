package fr.unedic.cali.dom;

public class DonneesChargementGaec
{
  public static final int MODE_APPEL_AUCUN = 0;
  public static final int MODE_APPEL_PARTIEL = 1;
  public static final int MODE_APPEL_TOTAL = 2;
  public static final String TYPE_PERIODE_AUCUN = "0";
  public static final String TYPE_PERIODE_TOUS = "999";
  public static final String TYPE_PERIODE_ACTION_FORMATION = "5";
  public static final String TYPE_PERIODE_FORMATION_NON_INDEMNISABLE = "6";
  public static final String TYPE_PERIODE_CONTRAT = "9";
  public static final String TYPE_PERIODE_BULLETIN_SALAIRE = "7";
  public static final String TYPE_PERIODE_CHEQUE_EMPLOI_SERVICE = "16";
  public static final String TYPE_PERIODE_DSM_FORMATION = "12";
  public static final String TYPE_PERIODE_DSM_MALADIE = "13";
  public static final String TYPE_PERIODE_PEP_SECU = "8";
  public static final String TYPE_PERIODE_PEP_AUTRE = "10";
  public static final String TYPE_PERIODE_PANS_PERIODIQUE = "17";
  public static final String TYPE_PERIODE_PANS_PONCTUELLE = "18";
  private AgregatGaec m_agregatGaec = null;
  private AppelGaecReduit m_appelGaecReduit = null;
  private boolean m_modeAppelInitialise = false;
  
  public AgregatGaec getAgregatGaec()
  {
    if (m_agregatGaec == null) {
      m_agregatGaec = new AgregatGaec();
    }
    return m_agregatGaec;
  }
  
  public void setAgregatGaec(AgregatGaec p_agregatGaec)
  {
    m_agregatGaec = p_agregatGaec;
  }
  
  public AppelGaecReduit getAppelGaecReduit()
  {
    return m_appelGaecReduit;
  }
  
  public void setAppelGaecReduit(AppelGaecReduit p_appelGaecReduit)
  {
    m_appelGaecReduit = p_appelGaecReduit;
  }
  
  public boolean isModeAppelInitialise()
  {
    return m_modeAppelInitialise;
  }
  
  public void setModeAppelInitialise(boolean p_modeAppelInitialise)
  {
    m_modeAppelInitialise = p_modeAppelInitialise;
  }
}

/* Location:
 * Qualified Name:     DonneesChargementGaec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */