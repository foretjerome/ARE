package fr.pe.d12dal.dictionnaire;

public final class StatutRapprochementAutoEnumeration
{
  public static final StatutRapprochementAutoEnumeration E_1 = new StatutRapprochementAutoEnumeration("RapprochÃ©e", "RapprochÃ©e", "1");
  public static final StatutRapprochementAutoEnumeration E_2 = new StatutRapprochementAutoEnumeration("SupprimÃ©e", "SupprimÃ©e", "2");
  public static final StatutRapprochementAutoEnumeration E_0 = new StatutRapprochementAutoEnumeration("A rapprocher / Nouvelle", "A rapprocher / Nouvelle", "0");
  static final StatutRapprochementAutoEnumeration[] LISTE_ENUM = { E_1, E_2, E_0 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private StatutRapprochementAutoEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private StatutRapprochementAutoEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static StatutRapprochementAutoEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    StatutRapprochementAutoEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutRapprochementAutoEnumeration getPourLibelleLong(String pLibelleLong)
  {
    StatutRapprochementAutoEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutRapprochementAutoEnumeration getPourValeur(String pValeur)
  {
    StatutRapprochementAutoEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutRapprochementAutoEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     StatutRapprochementAutoEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */