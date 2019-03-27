package fr.pe.d12dal.dictionnaire;

public final class CodeModificationAttenteInstructionEnumeration
{
  public static final CodeModificationAttenteInstructionEnumeration E_C = new CodeModificationAttenteInstructionEnumeration("CrÃ©ation", "CrÃ©ation", "C");
  public static final CodeModificationAttenteInstructionEnumeration E_S = new CodeModificationAttenteInstructionEnumeration("Suppression", "Suppression", "S");
  public static final CodeModificationAttenteInstructionEnumeration E_T = new CodeModificationAttenteInstructionEnumeration("Transformation", "Transformation", "T");
  static final CodeModificationAttenteInstructionEnumeration[] LISTE_ENUM = { E_C, E_S, E_T };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private CodeModificationAttenteInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private CodeModificationAttenteInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static CodeModificationAttenteInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    CodeModificationAttenteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CodeModificationAttenteInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    CodeModificationAttenteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CodeModificationAttenteInstructionEnumeration getPourValeur(String pValeur)
  {
    CodeModificationAttenteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CodeModificationAttenteInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     CodeModificationAttenteInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */