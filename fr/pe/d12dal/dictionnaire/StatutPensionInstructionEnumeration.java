package fr.pe.d12dal.dictionnaire;

public final class StatutPensionInstructionEnumeration
{
  public static final StatutPensionInstructionEnumeration E_1 = new StatutPensionInstructionEnumeration("En cours", "En cours", "1");
  public static final StatutPensionInstructionEnumeration E_2 = new StatutPensionInstructionEnumeration("En attente", "En attente", "2");
  static final StatutPensionInstructionEnumeration[] LISTE_ENUM = { E_1, E_2 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private StatutPensionInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private StatutPensionInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static StatutPensionInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    StatutPensionInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutPensionInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    StatutPensionInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutPensionInstructionEnumeration getPourValeur(String pValeur)
  {
    StatutPensionInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutPensionInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     StatutPensionInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */