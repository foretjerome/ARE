package fr.pe.d12dal.dictionnaire;

public final class EmployeurInterimInstructionEnumeration
{
  public static final EmployeurInterimInstructionEnumeration E_01 = new EmployeurInterimInstructionEnumeration("Manpower", "Manpower", "01");
  public static final EmployeurInterimInstructionEnumeration E_02 = new EmployeurInterimInstructionEnumeration("Randstad", "Randstad", "02");
  public static final EmployeurInterimInstructionEnumeration E_03 = new EmployeurInterimInstructionEnumeration("Adecco", "Adecco", "03");
  public static final EmployeurInterimInstructionEnumeration E_04 = new EmployeurInterimInstructionEnumeration("Synergie", "Synergie", "04");
  public static final EmployeurInterimInstructionEnumeration E_05 = new EmployeurInterimInstructionEnumeration("Adia", "Adia", "05");
  public static final EmployeurInterimInstructionEnumeration E_06 = new EmployeurInterimInstructionEnumeration("Select TT", "Select TT", "06");
  public static final EmployeurInterimInstructionEnumeration E_07 = new EmployeurInterimInstructionEnumeration("IdÃ©es interim", "IdÃ©es interim", "07");
  static final EmployeurInterimInstructionEnumeration[] LISTE_ENUM = { E_01, E_02, E_03, E_04, E_05, E_06, E_07 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private EmployeurInterimInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private EmployeurInterimInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static EmployeurInterimInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    EmployeurInterimInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EmployeurInterimInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    EmployeurInterimInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EmployeurInterimInstructionEnumeration getPourValeur(String pValeur)
  {
    EmployeurInterimInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EmployeurInterimInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     EmployeurInterimInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */