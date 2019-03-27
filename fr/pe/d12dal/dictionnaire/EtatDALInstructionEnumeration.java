package fr.pe.d12dal.dictionnaire;

public final class EtatDALInstructionEnumeration
{
  public static final EtatDALInstructionEnumeration E_01 = new EtatDALInstructionEnumeration("Ok", "Ok", "01");
  public static final EtatDALInstructionEnumeration E_02 = new EtatDALInstructionEnumeration("Brouillon", "Brouillon", "02");
  public static final EtatDALInstructionEnumeration E_00 = new EtatDALInstructionEnumeration("", "", "00");
  public static final EtatDALInstructionEnumeration E_03 = new EtatDALInstructionEnumeration("Brouillon ACDA", "Brouillon ACDA", "03");
  public static final EtatDALInstructionEnumeration E_04 = new EtatDALInstructionEnumeration("Brouillon ACDB", "Brouillon ACDB", "04");
  static final EtatDALInstructionEnumeration[] LISTE_ENUM = { E_01, E_02, E_00, E_03, E_04 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private EtatDALInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private EtatDALInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static EtatDALInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    EtatDALInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtatDALInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    EtatDALInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtatDALInstructionEnumeration getPourValeur(String pValeur)
  {
    EtatDALInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtatDALInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     EtatDALInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */