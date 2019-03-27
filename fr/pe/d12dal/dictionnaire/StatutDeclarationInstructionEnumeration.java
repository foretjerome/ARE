package fr.pe.d12dal.dictionnaire;

public final class StatutDeclarationInstructionEnumeration
{
  public static final StatutDeclarationInstructionEnumeration E_1 = new StatutDeclarationInstructionEnumeration("CertifiÃ©e", "CertifiÃ©e", "1");
  public static final StatutDeclarationInstructionEnumeration E_2 = new StatutDeclarationInstructionEnumeration("DÃ©clarÃ©e", "DÃ©clarÃ©e", "2");
  public static final StatutDeclarationInstructionEnumeration E_3 = new StatutDeclarationInstructionEnumeration("Non confirmÃ©", "Non confirmÃ©", "3");
  public static final StatutDeclarationInstructionEnumeration E_0 = new StatutDeclarationInstructionEnumeration("", "", "0");
  public static final StatutDeclarationInstructionEnumeration E_4 = new StatutDeclarationInstructionEnumeration("A certifier", "A certifier", "4");
  static final StatutDeclarationInstructionEnumeration[] LISTE_ENUM = { E_1, E_2, E_3, E_0, E_4 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private StatutDeclarationInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private StatutDeclarationInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static StatutDeclarationInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    StatutDeclarationInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutDeclarationInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    StatutDeclarationInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutDeclarationInstructionEnumeration getPourValeur(String pValeur)
  {
    StatutDeclarationInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static StatutDeclarationInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     StatutDeclarationInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */