package fr.pe.d12dal.dictionnaire;

public final class MediaDepotInstructionEnumeration
{
  public static final MediaDepotInstructionEnumeration E_2 = new MediaDepotInstructionEnumeration("Web", "Web", "2");
  public static final MediaDepotInstructionEnumeration E_4 = new MediaDepotInstructionEnumeration("Aude", "Aude", "4");
  public static final MediaDepotInstructionEnumeration E_0 = new MediaDepotInstructionEnumeration("", "", "0");
  public static final MediaDepotInstructionEnumeration E_5 = new MediaDepotInstructionEnumeration("Saisie", "Saisie", "5");
  static final MediaDepotInstructionEnumeration[] LISTE_ENUM = { E_2, E_4, E_0, E_5 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private MediaDepotInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private MediaDepotInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static MediaDepotInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    MediaDepotInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static MediaDepotInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    MediaDepotInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static MediaDepotInstructionEnumeration getPourValeur(String pValeur)
  {
    MediaDepotInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static MediaDepotInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     MediaDepotInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */