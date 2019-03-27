package fr.pe.d12dal.dictionnaire;

public final class CodeAttenteInstructionEnumeration
{
  public static final CodeAttenteInstructionEnumeration E_01 = new CodeAttenteInstructionEnumeration("Faux-Primo", "Faux-Primo", "01");
  public static final CodeAttenteInstructionEnumeration E_02 = new CodeAttenteInstructionEnumeration("Dal Web KO", "Dal Web KO", "02");
  public static final CodeAttenteInstructionEnumeration E_03 = new CodeAttenteInstructionEnumeration("Dal Mode Secours A Traiter", "Dal Mode Secours A Traiter", "03");
  public static final CodeAttenteInstructionEnumeration E_04 = new CodeAttenteInstructionEnumeration("Dal Mode Secours KO", "Dal Mode Secours KO", "04");
  static final CodeAttenteInstructionEnumeration[] LISTE_ENUM = { E_01, E_02, E_03, E_04 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private CodeAttenteInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private CodeAttenteInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static CodeAttenteInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    CodeAttenteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CodeAttenteInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    CodeAttenteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CodeAttenteInstructionEnumeration getPourValeur(String pValeur)
  {
    CodeAttenteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CodeAttenteInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     CodeAttenteInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */