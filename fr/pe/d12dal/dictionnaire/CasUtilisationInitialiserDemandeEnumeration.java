package fr.pe.d12dal.dictionnaire;

public final class CasUtilisationInitialiserDemandeEnumeration
{
  public static final CasUtilisationInitialiserDemandeEnumeration E_1 = new CasUtilisationInitialiserDemandeEnumeration("Mode crÃ©ation demande", "Mode crÃ©ation demande", "1");
  public static final CasUtilisationInitialiserDemandeEnumeration E_2 = new CasUtilisationInitialiserDemandeEnumeration("Mode forÃ§age", "Mode forÃ§age", "2");
  static final CasUtilisationInitialiserDemandeEnumeration[] LISTE_ENUM = { E_1, E_2 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private CasUtilisationInitialiserDemandeEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private CasUtilisationInitialiserDemandeEnumeration(String pLibelleCourt, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = null;
    m_valeur = pValeur;
  }
  
  public String getLibelleCourt()
  {
    return m_libelleCourt;
  }
  
  public String getLibelleLong()
  {
    return m_libelleLong;
  }
  
  public String getValeur()
  {
    return m_valeur;
  }
  
  public static CasUtilisationInitialiserDemandeEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    CasUtilisationInitialiserDemandeEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationInitialiserDemandeEnumeration getPourLibelleLong(String pLibelleLong)
  {
    CasUtilisationInitialiserDemandeEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationInitialiserDemandeEnumeration getPourValeur(String pValeur)
  {
    CasUtilisationInitialiserDemandeEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationInitialiserDemandeEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     CasUtilisationInitialiserDemandeEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */