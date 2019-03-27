package fr.pe.d12dal.dictionnaire;

public final class TypeOperationEnumeration
{
  public static final TypeOperationEnumeration E_C = new TypeOperationEnumeration("C", "C", "C");
  public static final TypeOperationEnumeration E_M = new TypeOperationEnumeration("M", "M", "M");
  public static final TypeOperationEnumeration E_S = new TypeOperationEnumeration("S", "S", "S");
  static final TypeOperationEnumeration[] LISTE_ENUM = { E_C, E_M, E_S };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypeOperationEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypeOperationEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypeOperationEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypeOperationEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeOperationEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypeOperationEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeOperationEnumeration getPourValeur(String pValeur)
  {
    TypeOperationEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeOperationEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypeOperationEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */