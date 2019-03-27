package fr.pe.d12dal.dictionnaire;

public final class CodeRetourInstructionEnumeration
{
  public static final CodeRetourInstructionEnumeration E_00 = new CodeRetourInstructionEnumeration("OK, DAL trouvÃ©e, MADU exÃ©cutÃ©", "OK, DAL trouvÃ©e, MADU exÃ©cutÃ©", "00");
  public static final CodeRetourInstructionEnumeration E_01 = new CodeRetourInstructionEnumeration("KO, DAL non installÃ©e", "KO, DAL non installÃ©e", "01");
  public static final CodeRetourInstructionEnumeration E_02 = new CodeRetourInstructionEnumeration("OK, DAL trouvÃ©e mais absence de rÃ©sultat complÃ©tude (faux primo)", "OK, DAL trouvÃ©e mais absence de rÃ©sultat complÃ©tude (faux primo)", "02");
  static final CodeRetourInstructionEnumeration[] LISTE_ENUM = { E_00, E_01, E_02 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private CodeRetourInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private CodeRetourInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static CodeRetourInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    CodeRetourInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CodeRetourInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    CodeRetourInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CodeRetourInstructionEnumeration getPourValeur(String pValeur)
  {
    CodeRetourInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CodeRetourInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     CodeRetourInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */