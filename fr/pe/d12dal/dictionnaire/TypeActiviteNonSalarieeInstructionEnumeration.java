package fr.pe.d12dal.dictionnaire;

public final class TypeActiviteNonSalarieeInstructionEnumeration
{
  public static final TypeActiviteNonSalarieeInstructionEnumeration E_01 = new TypeActiviteNonSalarieeInstructionEnumeration("Ponctuelle", "Ponctuelle", "01");
  public static final TypeActiviteNonSalarieeInstructionEnumeration E_02 = new TypeActiviteNonSalarieeInstructionEnumeration("PÃ©riodique", "PÃ©riodique", "02");
  public static final TypeActiviteNonSalarieeInstructionEnumeration E_00 = new TypeActiviteNonSalarieeInstructionEnumeration("", "", "00");
  static final TypeActiviteNonSalarieeInstructionEnumeration[] LISTE_ENUM = { E_01, E_02, E_00 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypeActiviteNonSalarieeInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypeActiviteNonSalarieeInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypeActiviteNonSalarieeInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypeActiviteNonSalarieeInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeActiviteNonSalarieeInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypeActiviteNonSalarieeInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeActiviteNonSalarieeInstructionEnumeration getPourValeur(String pValeur)
  {
    TypeActiviteNonSalarieeInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeActiviteNonSalarieeInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypeActiviteNonSalarieeInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */