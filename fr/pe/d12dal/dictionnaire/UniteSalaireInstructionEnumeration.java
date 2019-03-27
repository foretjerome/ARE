package fr.pe.d12dal.dictionnaire;

public final class UniteSalaireInstructionEnumeration
{
  public static final UniteSalaireInstructionEnumeration E_01 = new UniteSalaireInstructionEnumeration("Horaire", "Horaire", "01");
  public static final UniteSalaireInstructionEnumeration E_02 = new UniteSalaireInstructionEnumeration("Mensuel", "Mensuel", "02");
  public static final UniteSalaireInstructionEnumeration E_04 = new UniteSalaireInstructionEnumeration("Annuel", "Annuel", "04");
  public static final UniteSalaireInstructionEnumeration E_00 = new UniteSalaireInstructionEnumeration("", "", "00");
  static final UniteSalaireInstructionEnumeration[] LISTE_ENUM = { E_01, E_02, E_04, E_00 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private UniteSalaireInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private UniteSalaireInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static UniteSalaireInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    UniteSalaireInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static UniteSalaireInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    UniteSalaireInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static UniteSalaireInstructionEnumeration getPourValeur(String pValeur)
  {
    UniteSalaireInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static UniteSalaireInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     UniteSalaireInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */