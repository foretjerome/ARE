package fr.pe.d12dal.dictionnaire;

public final class FormeJuridiqueInstructionEnumeration
{
  public static final FormeJuridiqueInstructionEnumeration E_01 = new FormeJuridiqueInstructionEnumeration("SARL", "SARL", "01");
  public static final FormeJuridiqueInstructionEnumeration E_02 = new FormeJuridiqueInstructionEnumeration("SA Ã  Conseil d'Administration", "SA Ã  Conseil d'Administration", "02");
  public static final FormeJuridiqueInstructionEnumeration E_03 = new FormeJuridiqueInstructionEnumeration("EURL", "EURL", "03");
  public static final FormeJuridiqueInstructionEnumeration E_04 = new FormeJuridiqueInstructionEnumeration("SCOP SA", "SCOP SA", "04");
  public static final FormeJuridiqueInstructionEnumeration E_05 = new FormeJuridiqueInstructionEnumeration("SAS", "SAS", "05");
  public static final FormeJuridiqueInstructionEnumeration E_06 = new FormeJuridiqueInstructionEnumeration("SNC", "SNC", "06");
  public static final FormeJuridiqueInstructionEnumeration E_07 = new FormeJuridiqueInstructionEnumeration("Association Loi de 1901", "Association Loi de 1901", "07");
  public static final FormeJuridiqueInstructionEnumeration E_08 = new FormeJuridiqueInstructionEnumeration("GIE", "GIE", "08");
  public static final FormeJuridiqueInstructionEnumeration E_09 = new FormeJuridiqueInstructionEnumeration("SociÃ©tÃ© en Commandite Simple", "SociÃ©tÃ© en Commandite Simple", "09");
  public static final FormeJuridiqueInstructionEnumeration E_10 = new FormeJuridiqueInstructionEnumeration("SociÃ©tÃ© en Commandite par Actions", "SociÃ©tÃ© en Commandite par Actions", "10");
  public static final FormeJuridiqueInstructionEnumeration E_11 = new FormeJuridiqueInstructionEnumeration("Conjoint dans les Professions LibÃ©rales", "Conjoint dans les Professions LibÃ©rales", "11");
  public static final FormeJuridiqueInstructionEnumeration E_12 = new FormeJuridiqueInstructionEnumeration("Conjoint du chef d'Entreprise", "Conjoint du chef d'Entreprise", "12");
  public static final FormeJuridiqueInstructionEnumeration E_13 = new FormeJuridiqueInstructionEnumeration("SA Ã  Directoire", "SA Ã  Directoire", "13");
  public static final FormeJuridiqueInstructionEnumeration E_14 = new FormeJuridiqueInstructionEnumeration("SCOP SARL", "SCOP SARL", "14");
  public static final FormeJuridiqueInstructionEnumeration E_00 = new FormeJuridiqueInstructionEnumeration("", "", "00");
  static final FormeJuridiqueInstructionEnumeration[] LISTE_ENUM = { E_01, E_02, E_03, E_04, E_05, E_06, E_07, E_08, E_09, E_10, E_11, E_12, E_13, E_14, E_00 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private FormeJuridiqueInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private FormeJuridiqueInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static FormeJuridiqueInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    FormeJuridiqueInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static FormeJuridiqueInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    FormeJuridiqueInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static FormeJuridiqueInstructionEnumeration getPourValeur(String pValeur)
  {
    FormeJuridiqueInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static FormeJuridiqueInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     FormeJuridiqueInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */