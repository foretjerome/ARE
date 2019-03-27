package fr.pe.d12dal.dictionnaire;

public final class TypeOrganismeInstructionEnumeration
{
  public static final TypeOrganismeInstructionEnumeration E_01 = new TypeOrganismeInstructionEnumeration("Employeur public", "Employeur public", "01");
  public static final TypeOrganismeInstructionEnumeration E_02 = new TypeOrganismeInstructionEnumeration("Etat membre europÃ©en", "Etat membre europÃ©en", "02");
  public static final TypeOrganismeInstructionEnumeration E_00 = new TypeOrganismeInstructionEnumeration("", "", "00");
  static final TypeOrganismeInstructionEnumeration[] LISTE_ENUM = { E_01, E_02, E_00 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypeOrganismeInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypeOrganismeInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypeOrganismeInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypeOrganismeInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeOrganismeInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypeOrganismeInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeOrganismeInstructionEnumeration getPourValeur(String pValeur)
  {
    TypeOrganismeInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeOrganismeInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypeOrganismeInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */