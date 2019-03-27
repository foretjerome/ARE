package fr.pe.d12dal.dictionnaire;

public final class CategorieEmploiParticulierInstructionEnumeration
{
  public static final CategorieEmploiParticulierInstructionEnumeration E_5 = new CategorieEmploiParticulierInstructionEnumeration("Assistante maternelle", "Assistante maternelle", "5");
  public static final CategorieEmploiParticulierInstructionEnumeration E_1 = new CategorieEmploiParticulierInstructionEnumeration("IntÃ©rimaire", "IntÃ©rimaire", "1");
  public static final CategorieEmploiParticulierInstructionEnumeration E_2 = new CategorieEmploiParticulierInstructionEnumeration("Intermittent du spectacle", "Intermittent du spectacle", "2");
  public static final CategorieEmploiParticulierInstructionEnumeration E_7 = new CategorieEmploiParticulierInstructionEnumeration("PÃ©riode de mobilitÃ© volontaire sÃ©curisÃ©e", "PÃ©riode de mobilitÃ© volontaire sÃ©curisÃ©e", "7");
  public static final CategorieEmploiParticulierInstructionEnumeration E_3 = new CategorieEmploiParticulierInstructionEnumeration("ExpatriÃ©", "ExpatriÃ©", "3");
  public static final CategorieEmploiParticulierInstructionEnumeration E_4 = new CategorieEmploiParticulierInstructionEnumeration("ActivitÃ© Etat Membre EuropÃ©en", "ActivitÃ© Etat Membre EuropÃ©en", "4");
  public static final CategorieEmploiParticulierInstructionEnumeration E_6 = new CategorieEmploiParticulierInstructionEnumeration("Autre activitÃ© salariÃ©e", "Autre activitÃ© salariÃ©e", "6");
  public static final CategorieEmploiParticulierInstructionEnumeration E_0 = new CategorieEmploiParticulierInstructionEnumeration("IndÃ©terminÃ©", "IndÃ©terminÃ©", "0");
  static final CategorieEmploiParticulierInstructionEnumeration[] LISTE_ENUM = { E_5, E_1, E_2, E_7, E_3, E_4, E_6, E_0 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private CategorieEmploiParticulierInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private CategorieEmploiParticulierInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static CategorieEmploiParticulierInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    CategorieEmploiParticulierInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CategorieEmploiParticulierInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    CategorieEmploiParticulierInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CategorieEmploiParticulierInstructionEnumeration getPourValeur(String pValeur)
  {
    CategorieEmploiParticulierInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CategorieEmploiParticulierInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     CategorieEmploiParticulierInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */