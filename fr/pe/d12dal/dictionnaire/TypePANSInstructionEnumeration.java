package fr.pe.d12dal.dictionnaire;

public final class TypePANSInstructionEnumeration
{
  public static final TypePANSInstructionEnumeration E_01 = new TypePANSInstructionEnumeration("PÃ©riodique", "PÃ©riodique", "01");
  public static final TypePANSInstructionEnumeration E_02 = new TypePANSInstructionEnumeration("Ponctuel", "Ponctuel", "02");
  public static final TypePANSInstructionEnumeration E_00 = new TypePANSInstructionEnumeration("", "", "00");
  static final TypePANSInstructionEnumeration[] LISTE_ENUM = { E_01, E_02, E_00 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypePANSInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypePANSInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypePANSInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypePANSInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypePANSInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypePANSInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypePANSInstructionEnumeration getPourValeur(String pValeur)
  {
    TypePANSInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypePANSInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypePANSInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */