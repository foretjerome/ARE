package fr.pe.d12dal.dictionnaire;

public final class TypeActiviteInstructionEnumeration
{
  public static final TypeActiviteInstructionEnumeration E_1 = new TypeActiviteInstructionEnumeration("ActiviteSalarie", "ActiviteSalarie", "1");
  public static final TypeActiviteInstructionEnumeration E_2 = new TypeActiviteInstructionEnumeration("ActivitÃ© Non Salarie", "ActivitÃ© Non Salarie", "2");
  public static final TypeActiviteInstructionEnumeration E_3 = new TypeActiviteInstructionEnumeration("Autre situation", "Autre situation", "3");
  public static final TypeActiviteInstructionEnumeration E_0 = new TypeActiviteInstructionEnumeration("", "", "0");
  public static final TypeActiviteInstructionEnumeration E_4 = new TypeActiviteInstructionEnumeration("Formation", "Formation", "4");
  static final TypeActiviteInstructionEnumeration[] LISTE_ENUM = { E_1, E_2, E_3, E_0, E_4 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypeActiviteInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypeActiviteInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypeActiviteInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypeActiviteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeActiviteInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypeActiviteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeActiviteInstructionEnumeration getPourValeur(String pValeur)
  {
    TypeActiviteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeActiviteInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypeActiviteInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */