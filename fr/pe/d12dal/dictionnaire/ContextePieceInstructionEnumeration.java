package fr.pe.d12dal.dictionnaire;

public final class ContextePieceInstructionEnumeration
{
  public static final ContextePieceInstructionEnumeration E_001 = new ContextePieceInstructionEnumeration("ActivitÃ© salariÃ©e", "ActivitÃ© salariÃ©e", "001");
  public static final ContextePieceInstructionEnumeration E_002 = new ContextePieceInstructionEnumeration("ActivitÃ© non salariÃ©e", "ActivitÃ© non salariÃ©e", "002");
  public static final ContextePieceInstructionEnumeration E_003 = new ContextePieceInstructionEnumeration("Autres activitÃ©s", "Autres activitÃ©s", "003");
  public static final ContextePieceInstructionEnumeration E_004 = new ContextePieceInstructionEnumeration("Salaire", "Salaire", "004");
  public static final ContextePieceInstructionEnumeration E_005 = new ContextePieceInstructionEnumeration("Rupture", "Rupture", "005");
  public static final ContextePieceInstructionEnumeration E_006 = new ContextePieceInstructionEnumeration("Mandataire", "Mandataire", "006");
  public static final ContextePieceInstructionEnumeration E_007 = new ContextePieceInstructionEnumeration("Rentes et pensions", "Rentes et pensions", "007");
  public static final ContextePieceInstructionEnumeration E_008 = new ContextePieceInstructionEnumeration("DonnÃ©es personnelles", "DonnÃ©es personnelles", "008");
  static final ContextePieceInstructionEnumeration[] LISTE_ENUM = { E_001, E_002, E_003, E_004, E_005, E_006, E_007, E_008 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private ContextePieceInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private ContextePieceInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static ContextePieceInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    ContextePieceInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static ContextePieceInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    ContextePieceInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static ContextePieceInstructionEnumeration getPourValeur(String pValeur)
  {
    ContextePieceInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static ContextePieceInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     ContextePieceInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */