package fr.pe.d12dal.dictionnaire;

public final class TypeActionEnumeration
{
  public static final TypeActionEnumeration E_ACTION_EPC = new TypeActionEnumeration("ACTION_EPC", "ACTION_EPC", "ACTION_EPC");
  public static final TypeActionEnumeration E_ACTION_HORS_EPC = new TypeActionEnumeration("ACTION_HORS_EPC", "ACTION_HORS_EPC", "ACTION_HORS_EPC");
  public static final TypeActionEnumeration E_NULL = new TypeActionEnumeration("NULL", "NULL", "NULL");
  static final TypeActionEnumeration[] LISTE_ENUM = { E_ACTION_EPC, E_ACTION_HORS_EPC, E_NULL };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypeActionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypeActionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypeActionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypeActionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeActionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypeActionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeActionEnumeration getPourValeur(String pValeur)
  {
    TypeActionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeActionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypeActionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */