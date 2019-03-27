package fr.pe.d12dal.dictionnaire;

public final class OrigineIndemnisationInstructionEnumeration
{
  public static final OrigineIndemnisationInstructionEnumeration E_01 = new OrigineIndemnisationInstructionEnumeration("ASP/CNASEA", "ASP/CNASEA", "01");
  public static final OrigineIndemnisationInstructionEnumeration E_02 = new OrigineIndemnisationInstructionEnumeration("Conseil gÃ©nÃ©ral", "Conseil gÃ©nÃ©ral", "02");
  public static final OrigineIndemnisationInstructionEnumeration E_03 = new OrigineIndemnisationInstructionEnumeration("Ecole", "Ecole", "03");
  public static final OrigineIndemnisationInstructionEnumeration E_04 = new OrigineIndemnisationInstructionEnumeration("Entreprise", "Entreprise", "04");
  public static final OrigineIndemnisationInstructionEnumeration E_06 = new OrigineIndemnisationInstructionEnumeration("AFPA", "AFPA", "06");
  public static final OrigineIndemnisationInstructionEnumeration E_05 = new OrigineIndemnisationInstructionEnumeration("Non rÃ©munÃ©rÃ©", "Non rÃ©munÃ©rÃ©", "05");
  public static final OrigineIndemnisationInstructionEnumeration E_09 = new OrigineIndemnisationInstructionEnumeration("IJSS", "IJSS", "09");
  public static final OrigineIndemnisationInstructionEnumeration E_00 = new OrigineIndemnisationInstructionEnumeration("", "", "00");
  public static final OrigineIndemnisationInstructionEnumeration E_10 = new OrigineIndemnisationInstructionEnumeration("PÃ´le Emploi", "PÃ´le Emploi", "10");
  static final OrigineIndemnisationInstructionEnumeration[] LISTE_ENUM = { E_01, E_02, E_03, E_04, E_06, E_05, E_09, E_00, E_10 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private OrigineIndemnisationInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private OrigineIndemnisationInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static OrigineIndemnisationInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    OrigineIndemnisationInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static OrigineIndemnisationInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    OrigineIndemnisationInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static OrigineIndemnisationInstructionEnumeration getPourValeur(String pValeur)
  {
    OrigineIndemnisationInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static OrigineIndemnisationInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     OrigineIndemnisationInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */