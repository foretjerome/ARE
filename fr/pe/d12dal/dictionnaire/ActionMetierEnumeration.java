package fr.pe.d12dal.dictionnaire;

public final class ActionMetierEnumeration
{
  public static final ActionMetierEnumeration E_DETAIL = new ActionMetierEnumeration("DETAIL", "DETAIL", "DETAIL");
  static final ActionMetierEnumeration[] LISTE_ENUM = { E_DETAIL };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private ActionMetierEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private ActionMetierEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static ActionMetierEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    ActionMetierEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static ActionMetierEnumeration getPourLibelleLong(String pLibelleLong)
  {
    ActionMetierEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static ActionMetierEnumeration getPourValeur(String pValeur)
  {
    ActionMetierEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static ActionMetierEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     ActionMetierEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */