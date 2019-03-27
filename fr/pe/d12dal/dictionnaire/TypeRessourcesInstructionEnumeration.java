package fr.pe.d12dal.dictionnaire;

public final class TypeRessourcesInstructionEnumeration
{
  public static final TypeRessourcesInstructionEnumeration E_08 = new TypeRessourcesInstructionEnumeration("Avantage Vieillesse", "Avantage Vieillesse", "08");
  public static final TypeRessourcesInstructionEnumeration E_10 = new TypeRessourcesInstructionEnumeration("Pension de Vieillesse pour inaptitude", "Pension de Vieillesse pour inaptitude", "10");
  public static final TypeRessourcesInstructionEnumeration E_11 = new TypeRessourcesInstructionEnumeration("Pension Militaire", "Pension Militaire", "11");
  public static final TypeRessourcesInstructionEnumeration E_01 = new TypeRessourcesInstructionEnumeration("Revenu SolidaritÃ© Actif", "Revenu SolidaritÃ© Actif", "01");
  public static final TypeRessourcesInstructionEnumeration E_02 = new TypeRessourcesInstructionEnumeration("InvaliditÃ© 1Ã¨re catÃ©gorie", "InvaliditÃ© 1Ã¨re catÃ©gorie", "02");
  public static final TypeRessourcesInstructionEnumeration E_03 = new TypeRessourcesInstructionEnumeration("InvaliditÃ© 2Ã¨me catÃ©gorie", "InvaliditÃ© 2Ã¨me catÃ©gorie", "03");
  public static final TypeRessourcesInstructionEnumeration E_04 = new TypeRessourcesInstructionEnumeration("InvaliditÃ© 3Ã¨me catÃ©gorie", "InvaliditÃ© 3Ã¨me catÃ©gorie", "04");
  public static final TypeRessourcesInstructionEnumeration E_05 = new TypeRessourcesInstructionEnumeration("Accident du Travail", "Accident du Travail", "05");
  public static final TypeRessourcesInstructionEnumeration E_06 = new TypeRessourcesInstructionEnumeration("Allocation Adulte HandicapÃ©", "Allocation Adulte HandicapÃ©", "06");
  public static final TypeRessourcesInstructionEnumeration E_07 = new TypeRessourcesInstructionEnumeration("Maladie Professionnelle", "Maladie Professionnelle", "07");
  public static final TypeRessourcesInstructionEnumeration E_00 = new TypeRessourcesInstructionEnumeration("", "", "00");
  public static final TypeRessourcesInstructionEnumeration E_12 = new TypeRessourcesInstructionEnumeration("ActivitÃ© secteur rÃ©gime retraite spÃ©cial", "ActivitÃ© secteur rÃ©gime retraite spÃ©cial", "12");
  public static final TypeRessourcesInstructionEnumeration E_13 = new TypeRessourcesInstructionEnumeration("Pension ou rente en attente", "Pension ou rente en attente", "13");
  public static final TypeRessourcesInstructionEnumeration E_14 = new TypeRessourcesInstructionEnumeration("Retraite anticipÃ©e", "Retraite anticipÃ©e", "14");
  public static final TypeRessourcesInstructionEnumeration E_15 = new TypeRessourcesInstructionEnumeration("InvaliditÃ© 2Ã¨me catÃ©gorie non indemnisÃ©", "InvaliditÃ© 2Ã¨me catÃ©gorie non indemnisÃ©", "15");
  public static final TypeRessourcesInstructionEnumeration E_16 = new TypeRessourcesInstructionEnumeration("InvaliditÃ© 3Ã¨me catÃ©gorie non indemnisÃ©", "InvaliditÃ© 3Ã¨me catÃ©gorie non indemnisÃ©", "16");
  static final TypeRessourcesInstructionEnumeration[] LISTE_ENUM = { E_08, E_10, E_11, E_01, E_02, E_03, E_04, E_05, E_06, E_07, E_00, E_12, E_13, E_14, E_15, E_16 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypeRessourcesInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypeRessourcesInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypeRessourcesInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypeRessourcesInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeRessourcesInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypeRessourcesInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeRessourcesInstructionEnumeration getPourValeur(String pValeur)
  {
    TypeRessourcesInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeRessourcesInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypeRessourcesInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */