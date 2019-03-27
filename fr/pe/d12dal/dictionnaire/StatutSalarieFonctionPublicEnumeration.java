package fr.pe.d12dal.dictionnaire;

public final class StatutSalarieFonctionPublicEnumeration
{
  public static final StatutSalarieFonctionPublicEnumeration E_01 = new StatutSalarieFonctionPublicEnumeration("Titulaire", "Titulaire", "01");
  public static final StatutSalarieFonctionPublicEnumeration E_02 = new StatutSalarieFonctionPublicEnumeration("Non titulaire", "Non titulaire", "02");
  public static final StatutSalarieFonctionPublicEnumeration E_00 = new StatutSalarieFonctionPublicEnumeration("", "", "00");
  static final StatutSalarieFonctionPublicEnumeration[] LISTE_ENUM = { E_01, E_02, E_00 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private StatutSalarieFonctionPublicEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private StatutSalarieFonctionPublicEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static StatutSalarieFonctionPublicEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    StatutSalarieFonctionPublicEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutSalarieFonctionPublicEnumeration getPourLibelleLong(String pLibelleLong)
  {
    StatutSalarieFonctionPublicEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutSalarieFonctionPublicEnumeration getPourValeur(String pValeur)
  {
    StatutSalarieFonctionPublicEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutSalarieFonctionPublicEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     StatutSalarieFonctionPublicEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */