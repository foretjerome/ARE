package fr.pe.d12dal.dictionnaire;

public final class OuiNonInstructionEnumeration
{
  public static final OuiNonInstructionEnumeration E_2 = new OuiNonInstructionEnumeration("Oui", "Oui", "2");
  public static final OuiNonInstructionEnumeration E_1 = new OuiNonInstructionEnumeration("Non", "Non", "1");
  public static final OuiNonInstructionEnumeration E_0 = new OuiNonInstructionEnumeration("IndÃ©terminÃ©", "IndÃ©terminÃ©", "0");
  static final OuiNonInstructionEnumeration[] LISTE_ENUM = { E_2, E_1, E_0 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private OuiNonInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private OuiNonInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static OuiNonInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    OuiNonInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static OuiNonInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    OuiNonInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static OuiNonInstructionEnumeration getPourValeur(String pValeur)
  {
    OuiNonInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static OuiNonInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     OuiNonInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */