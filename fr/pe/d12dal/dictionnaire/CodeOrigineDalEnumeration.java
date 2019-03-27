package fr.pe.d12dal.dictionnaire;

public final class CodeOrigineDalEnumeration
{
  public static final CodeOrigineDalEnumeration E_08 = new CodeOrigineDalEnumeration("Expresse", "Expresse", "08");
  public static final CodeOrigineDalEnumeration E_00 = new CodeOrigineDalEnumeration("IDE", "IDE", "00");
  static final CodeOrigineDalEnumeration[] LISTE_ENUM = { E_08, E_00 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private CodeOrigineDalEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private CodeOrigineDalEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static CodeOrigineDalEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    CodeOrigineDalEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CodeOrigineDalEnumeration getPourLibelleLong(String pLibelleLong)
  {
    CodeOrigineDalEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CodeOrigineDalEnumeration getPourValeur(String pValeur)
  {
    CodeOrigineDalEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CodeOrigineDalEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     CodeOrigineDalEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */