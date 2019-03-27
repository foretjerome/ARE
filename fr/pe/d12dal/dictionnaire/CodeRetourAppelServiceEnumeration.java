package fr.pe.d12dal.dictionnaire;

public final class CodeRetourAppelServiceEnumeration
{
  public static final CodeRetourAppelServiceEnumeration E_00 = new CodeRetourAppelServiceEnumeration("Appel Service OK", "Appel Service OK", "00");
  public static final CodeRetourAppelServiceEnumeration E_01 = new CodeRetourAppelServiceEnumeration("Appel Service KO", "Appel Service KO", "01");
  static final CodeRetourAppelServiceEnumeration[] LISTE_ENUM = { E_00, E_01 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private CodeRetourAppelServiceEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private CodeRetourAppelServiceEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static CodeRetourAppelServiceEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    CodeRetourAppelServiceEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CodeRetourAppelServiceEnumeration getPourLibelleLong(String pLibelleLong)
  {
    CodeRetourAppelServiceEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CodeRetourAppelServiceEnumeration getPourValeur(String pValeur)
  {
    CodeRetourAppelServiceEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CodeRetourAppelServiceEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     CodeRetourAppelServiceEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */