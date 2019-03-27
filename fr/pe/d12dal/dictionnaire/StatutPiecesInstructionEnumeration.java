package fr.pe.d12dal.dictionnaire;

public final class StatutPiecesInstructionEnumeration
{
  public static final StatutPiecesInstructionEnumeration E_1 = new StatutPiecesInstructionEnumeration("Irrecevable", "Irrecevable", "1");
  public static final StatutPiecesInstructionEnumeration E_2 = new StatutPiecesInstructionEnumeration("PrÃ©sente", "PrÃ©sente", "2");
  public static final StatutPiecesInstructionEnumeration E_3 = new StatutPiecesInstructionEnumeration("Absente", "Absente", "3");
  public static final StatutPiecesInstructionEnumeration E_4 = new StatutPiecesInstructionEnumeration("Plus attendue", "Plus attendue", "4");
  public static final StatutPiecesInstructionEnumeration E_5 = new StatutPiecesInstructionEnumeration("Saisie", "Saisie", "5");
  public static final StatutPiecesInstructionEnumeration E_6 = new StatutPiecesInstructionEnumeration("Attente employeur", "Attente employeur", "6");
  static final StatutPiecesInstructionEnumeration[] LISTE_ENUM = { E_1, E_2, E_3, E_4, E_5, E_6 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private StatutPiecesInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private StatutPiecesInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static StatutPiecesInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    StatutPiecesInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutPiecesInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    StatutPiecesInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutPiecesInstructionEnumeration getPourValeur(String pValeur)
  {
    StatutPiecesInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutPiecesInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     StatutPiecesInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */