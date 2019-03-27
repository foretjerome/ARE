package fr.pe.d12dal.dictionnaire;

public final class TypeContratAideInstructionEnumeration
{
  public static final TypeContratAideInstructionEnumeration E_00 = new TypeContratAideInstructionEnumeration("", "", "00");
  public static final TypeContratAideInstructionEnumeration E_01 = new TypeContratAideInstructionEnumeration("CUI-CIE", "CUI-CIE", "01");
  public static final TypeContratAideInstructionEnumeration E_02 = new TypeContratAideInstructionEnumeration("CUI-CAE", "CUI-CAE", "02");
  public static final TypeContratAideInstructionEnumeration E_03 = new TypeContratAideInstructionEnumeration("Autre contrat aidÃ©", "Autre contrat aidÃ©", "03");
  public static final TypeContratAideInstructionEnumeration E_04 = new TypeContratAideInstructionEnumeration("CIF/CDD", "CIF/CDD", "04");
  static final TypeContratAideInstructionEnumeration[] LISTE_ENUM = { E_00, E_01, E_02, E_03, E_04 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypeContratAideInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypeContratAideInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypeContratAideInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypeContratAideInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeContratAideInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypeContratAideInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeContratAideInstructionEnumeration getPourValeur(String pValeur)
  {
    TypeContratAideInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeContratAideInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypeContratAideInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */