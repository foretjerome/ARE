package fr.pe.d12dal.dictionnaire;

public final class EtatDeclarationInstructionEnumeration
{
  public static final EtatDeclarationInstructionEnumeration E_1 = new EtatDeclarationInstructionEnumeration("OK", "OK", "1");
  public static final EtatDeclarationInstructionEnumeration E_2 = new EtatDeclarationInstructionEnumeration("Erreur", "Erreur", "2");
  public static final EtatDeclarationInstructionEnumeration E_0 = new EtatDeclarationInstructionEnumeration("", "", "0");
  static final EtatDeclarationInstructionEnumeration[] LISTE_ENUM = { E_1, E_2, E_0 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private EtatDeclarationInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private EtatDeclarationInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static EtatDeclarationInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    EtatDeclarationInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtatDeclarationInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    EtatDeclarationInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtatDeclarationInstructionEnumeration getPourValeur(String pValeur)
  {
    EtatDeclarationInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtatDeclarationInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     EtatDeclarationInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */