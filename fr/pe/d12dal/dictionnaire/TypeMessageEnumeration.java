package fr.pe.d12dal.dictionnaire;

public final class TypeMessageEnumeration
{
  public static final TypeMessageEnumeration E_1 = new TypeMessageEnumeration("message d'information", "message d'information", "1");
  public static final TypeMessageEnumeration E_2 = new TypeMessageEnumeration("message d'avertissement", "message d'avertissement", "2");
  public static final TypeMessageEnumeration E_3 = new TypeMessageEnumeration("message d'erreur", "message d'erreur", "3");
  static final TypeMessageEnumeration[] LISTE_ENUM = { E_1, E_2, E_3 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypeMessageEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypeMessageEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypeMessageEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypeMessageEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeMessageEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypeMessageEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeMessageEnumeration getPourValeur(String pValeur)
  {
    TypeMessageEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeMessageEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypeMessageEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */