package fr.pe.d12dal.dictionnaire;

public final class MotifRejetGedInstructionEnumeration
{
  public static final MotifRejetGedInstructionEnumeration E_00 = new MotifRejetGedInstructionEnumeration("Illisible", "Document illisible", "00");
  public static final MotifRejetGedInstructionEnumeration E_01 = new MotifRejetGedInstructionEnumeration("Document non exploitable", "Document non exploitable", "01");
  public static final MotifRejetGedInstructionEnumeration E_02 = new MotifRejetGedInstructionEnumeration("Documents hors pÃ©rimÃ¨tre", "Documents hors pÃ©rimÃ¨tre", "02");
  public static final MotifRejetGedInstructionEnumeration E_03 = new MotifRejetGedInstructionEnumeration("Justificatifs Multiples", "Justificatifs Multiples", "03");
  public static final MotifRejetGedInstructionEnumeration E_04 = new MotifRejetGedInstructionEnumeration("Hors delai", "Hors delai", "04");
  public static final MotifRejetGedInstructionEnumeration E_06 = new MotifRejetGedInstructionEnumeration("Absence non excusÃ©e", "Absence non excusÃ©e", "06");
  public static final MotifRejetGedInstructionEnumeration E_05 = new MotifRejetGedInstructionEnumeration("Maintien de la dÃ©cision", "Maintien de la dÃ©cision", "05");
  static final MotifRejetGedInstructionEnumeration[] LISTE_ENUM = { E_00, E_01, E_02, E_03, E_04, E_06, E_05 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private MotifRejetGedInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private MotifRejetGedInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static MotifRejetGedInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    MotifRejetGedInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static MotifRejetGedInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    MotifRejetGedInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static MotifRejetGedInstructionEnumeration getPourValeur(String pValeur)
  {
    MotifRejetGedInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static MotifRejetGedInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     MotifRejetGedInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */