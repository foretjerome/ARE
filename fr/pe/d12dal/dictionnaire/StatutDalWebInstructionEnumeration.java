package fr.pe.d12dal.dictionnaire;

public final class StatutDalWebInstructionEnumeration
{
  public static final StatutDalWebInstructionEnumeration E_1 = new StatutDalWebInstructionEnumeration("Brouillon", "Brouillon", "1");
  public static final StatutDalWebInstructionEnumeration E_2 = new StatutDalWebInstructionEnumeration("RÃ©cÃ©pissÃ©", "RÃ©cÃ©pissÃ©", "2");
  static final StatutDalWebInstructionEnumeration[] LISTE_ENUM = { E_1, E_2 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private StatutDalWebInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private StatutDalWebInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static StatutDalWebInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    StatutDalWebInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutDalWebInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    StatutDalWebInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutDalWebInstructionEnumeration getPourValeur(String pValeur)
  {
    StatutDalWebInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutDalWebInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     StatutDalWebInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */