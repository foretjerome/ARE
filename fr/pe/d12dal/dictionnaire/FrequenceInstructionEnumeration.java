package fr.pe.d12dal.dictionnaire;

public final class FrequenceInstructionEnumeration
{
  public static final FrequenceInstructionEnumeration E_0 = new FrequenceInstructionEnumeration("", "", "0");
  public static final FrequenceInstructionEnumeration E_1 = new FrequenceInstructionEnumeration("Journalier", "Journalier", "1");
  public static final FrequenceInstructionEnumeration E_4 = new FrequenceInstructionEnumeration("Mensuel", "Mensuel", "4");
  static final FrequenceInstructionEnumeration[] LISTE_ENUM = { E_0, E_1, E_4 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private FrequenceInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private FrequenceInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static FrequenceInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    FrequenceInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static FrequenceInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    FrequenceInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static FrequenceInstructionEnumeration getPourValeur(String pValeur)
  {
    FrequenceInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static FrequenceInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     FrequenceInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */