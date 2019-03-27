package fr.pe.d12dal.dictionnaire;

public final class EtudeMandataireInstructionEnumeration
{
  public static final EtudeMandataireInstructionEnumeration E_0 = new EtudeMandataireInstructionEnumeration("IndÃ©terminÃ©", "IndÃ©terminÃ©", "0");
  public static final EtudeMandataireInstructionEnumeration E_1 = new EtudeMandataireInstructionEnumeration("A Ã©tudier", "A Ã©tudier", "1");
  public static final EtudeMandataireInstructionEnumeration E_2 = new EtudeMandataireInstructionEnumeration("En cours", "En cours", "2");
  public static final EtudeMandataireInstructionEnumeration E_3 = new EtudeMandataireInstructionEnumeration("Admis", "Admis", "3");
  public static final EtudeMandataireInstructionEnumeration E_4 = new EtudeMandataireInstructionEnumeration("Rejet", "Rejet", "4");
  public static final EtudeMandataireInstructionEnumeration E_5 = new EtudeMandataireInstructionEnumeration("Non rÃ©ponse", "Non rÃ©ponse", "5");
  static final EtudeMandataireInstructionEnumeration[] LISTE_ENUM = { E_0, E_1, E_2, E_3, E_4, E_5 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private EtudeMandataireInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private EtudeMandataireInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static EtudeMandataireInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    EtudeMandataireInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtudeMandataireInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    EtudeMandataireInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtudeMandataireInstructionEnumeration getPourValeur(String pValeur)
  {
    EtudeMandataireInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtudeMandataireInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     EtudeMandataireInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */