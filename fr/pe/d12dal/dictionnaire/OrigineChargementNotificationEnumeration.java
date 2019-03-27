package fr.pe.d12dal.dictionnaire;

public final class OrigineChargementNotificationEnumeration
{
  public static final OrigineChargementNotificationEnumeration E_FLUX_MSG = new OrigineChargementNotificationEnumeration("FLUX_MSG", "FLUX_MSG", "FLUX_MSG");
  public static final OrigineChargementNotificationEnumeration E_FLUX_FICHIER = new OrigineChargementNotificationEnumeration("FLUX_FICHIER", "FLUX_FICHIER", "FLUX_FICHIER");
  public static final OrigineChargementNotificationEnumeration E_STOCK = new OrigineChargementNotificationEnumeration("STOCK", "STOCK", "STOCK");
  static final OrigineChargementNotificationEnumeration[] LISTE_ENUM = { E_FLUX_MSG, E_FLUX_FICHIER, E_STOCK };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private OrigineChargementNotificationEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private OrigineChargementNotificationEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static OrigineChargementNotificationEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    OrigineChargementNotificationEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static OrigineChargementNotificationEnumeration getPourLibelleLong(String pLibelleLong)
  {
    OrigineChargementNotificationEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static OrigineChargementNotificationEnumeration getPourValeur(String pValeur)
  {
    OrigineChargementNotificationEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static OrigineChargementNotificationEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     OrigineChargementNotificationEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */