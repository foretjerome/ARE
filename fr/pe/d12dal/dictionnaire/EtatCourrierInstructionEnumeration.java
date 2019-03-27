package fr.pe.d12dal.dictionnaire;

public final class EtatCourrierInstructionEnumeration
{
  public static final EtatCourrierInstructionEnumeration E_1 = new EtatCourrierInstructionEnumeration("Brouillon", "Brouillon", "1");
  public static final EtatCourrierInstructionEnumeration E_2 = new EtatCourrierInstructionEnumeration("EnvoyÃ©", "EnvoyÃ©", "2");
  public static final EtatCourrierInstructionEnumeration E_3 = new EtatCourrierInstructionEnumeration("ReÃ§u", "ReÃ§u", "3");
  static final EtatCourrierInstructionEnumeration[] LISTE_ENUM = { E_1, E_2, E_3 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private EtatCourrierInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private EtatCourrierInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static EtatCourrierInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    EtatCourrierInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtatCourrierInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    EtatCourrierInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtatCourrierInstructionEnumeration getPourValeur(String pValeur)
  {
    EtatCourrierInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtatCourrierInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     EtatCourrierInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */