package fr.pe.d12dal.dictionnaire;

public final class StatutPieceGEDInstructionEnumeration
{
  public static final StatutPieceGEDInstructionEnumeration E_00 = new StatutPieceGEDInstructionEnumeration("En attente de traitement", "En attente de traitement", "00");
  public static final StatutPieceGEDInstructionEnumeration E_01 = new StatutPieceGEDInstructionEnumeration("RejetÃ©", "RejetÃ©", "01");
  public static final StatutPieceGEDInstructionEnumeration E_02 = new StatutPieceGEDInstructionEnumeration("En attente de traitement", "En attente de traitement", "02");
  public static final StatutPieceGEDInstructionEnumeration E_03 = new StatutPieceGEDInstructionEnumeration("TraitÃ©", "TraitÃ©", "03");
  public static final StatutPieceGEDInstructionEnumeration E_05 = new StatutPieceGEDInstructionEnumeration("Plus attendu", "Plus attendu", "05");
  public static final StatutPieceGEDInstructionEnumeration E_04 = new StatutPieceGEDInstructionEnumeration("Recevable", "Recevable", "04");
  static final StatutPieceGEDInstructionEnumeration[] LISTE_ENUM = { E_00, E_01, E_02, E_03, E_05, E_04 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private StatutPieceGEDInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private StatutPieceGEDInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static StatutPieceGEDInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    StatutPieceGEDInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutPieceGEDInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    StatutPieceGEDInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutPieceGEDInstructionEnumeration getPourValeur(String pValeur)
  {
    StatutPieceGEDInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutPieceGEDInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     StatutPieceGEDInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */