package fr.pe.d12dal.dictionnaire;

public final class LibelleIdentifiantListeInstructionEnumeration
{
  public static final LibelleIdentifiantListeInstructionEnumeration E_1 = new LibelleIdentifiantListeInstructionEnumeration("_IDENT", "_IDENT", "1");
  public static final LibelleIdentifiantListeInstructionEnumeration E_2 = new LibelleIdentifiantListeInstructionEnumeration("_IDENT", "_IDENT", "2");
  public static final LibelleIdentifiantListeInstructionEnumeration E_3 = new LibelleIdentifiantListeInstructionEnumeration("_IDENT", "_IDENT", "3");
  public static final LibelleIdentifiantListeInstructionEnumeration E_4 = new LibelleIdentifiantListeInstructionEnumeration("_IDENT", "_IDENT", "4");
  public static final LibelleIdentifiantListeInstructionEnumeration E_5 = new LibelleIdentifiantListeInstructionEnumeration("_IDENT", "_IDENT", "5");
  public static final LibelleIdentifiantListeInstructionEnumeration E_6 = new LibelleIdentifiantListeInstructionEnumeration("_IDENT", "_IDENT", "6");
  public static final LibelleIdentifiantListeInstructionEnumeration E_7 = new LibelleIdentifiantListeInstructionEnumeration("_IDENT", "_IDENT", "7");
  public static final LibelleIdentifiantListeInstructionEnumeration E_8 = new LibelleIdentifiantListeInstructionEnumeration("_IDENT", "_IDENT", "8");
  static final LibelleIdentifiantListeInstructionEnumeration[] LISTE_ENUM = { E_1, E_2, E_3, E_4, E_5, E_6, E_7, E_8 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private LibelleIdentifiantListeInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private LibelleIdentifiantListeInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static LibelleIdentifiantListeInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    LibelleIdentifiantListeInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static LibelleIdentifiantListeInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    LibelleIdentifiantListeInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static LibelleIdentifiantListeInstructionEnumeration getPourValeur(String pValeur)
  {
    LibelleIdentifiantListeInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static LibelleIdentifiantListeInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     LibelleIdentifiantListeInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */