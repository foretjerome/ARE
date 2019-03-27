package fr.pe.d12dal.dictionnaire;

public final class TypeActionHistorisationEnumeration
{
  public static final TypeActionHistorisationEnumeration E_FONC = new TypeActionHistorisationEnumeration("fonctionnelle", "fonctionnelle", "FONC");
  public static final TypeActionHistorisationEnumeration E_TECH = new TypeActionHistorisationEnumeration("technique", "technique", "TECH");
  static final TypeActionHistorisationEnumeration[] LISTE_ENUM = { E_FONC, E_TECH };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypeActionHistorisationEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypeActionHistorisationEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypeActionHistorisationEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypeActionHistorisationEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeActionHistorisationEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypeActionHistorisationEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeActionHistorisationEnumeration getPourValeur(String pValeur)
  {
    TypeActionHistorisationEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeActionHistorisationEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypeActionHistorisationEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */