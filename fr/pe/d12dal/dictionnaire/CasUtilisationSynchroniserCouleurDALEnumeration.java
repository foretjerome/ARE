package fr.pe.d12dal.dictionnaire;

public final class CasUtilisationSynchroniserCouleurDALEnumeration
{
  public static final CasUtilisationSynchroniserCouleurDALEnumeration E_SYNCHRONE = new CasUtilisationSynchroniserCouleurDALEnumeration("Synchrone", "Synchrone", "Synchrone");
  static final CasUtilisationSynchroniserCouleurDALEnumeration[] LISTE_ENUM = { E_SYNCHRONE };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private CasUtilisationSynchroniserCouleurDALEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private CasUtilisationSynchroniserCouleurDALEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static CasUtilisationSynchroniserCouleurDALEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    CasUtilisationSynchroniserCouleurDALEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationSynchroniserCouleurDALEnumeration getPourLibelleLong(String pLibelleLong)
  {
    CasUtilisationSynchroniserCouleurDALEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationSynchroniserCouleurDALEnumeration getPourValeur(String pValeur)
  {
    CasUtilisationSynchroniserCouleurDALEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationSynchroniserCouleurDALEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     CasUtilisationSynchroniserCouleurDALEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */