package fr.pe.d12dal.dictionnaire;

public final class EtatCompletudeInstructionEnumeration
{
  public static final EtatCompletudeInstructionEnumeration E_1 = new EtatCompletudeInstructionEnumeration("En cours d'instruction", "En cours d'instruction", "1");
  public static final EtatCompletudeInstructionEnumeration E_2 = new EtatCompletudeInstructionEnumeration("Complet", "Complet", "2");
  public static final EtatCompletudeInstructionEnumeration E_3 = new EtatCompletudeInstructionEnumeration("Incomplet", "Incomplet", "3");
  public static final EtatCompletudeInstructionEnumeration E_0 = new EtatCompletudeInstructionEnumeration("Dal non trouvÃ©e", "Dal non trouvÃ©e", "0");
  public static final EtatCompletudeInstructionEnumeration E_4 = new EtatCompletudeInstructionEnumeration("Erreur de rÃ©cupÃ©ration Web", "Erreur de rÃ©cupÃ©ration Web", "4");
  static final EtatCompletudeInstructionEnumeration[] LISTE_ENUM = { E_1, E_2, E_3, E_0, E_4 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private EtatCompletudeInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private EtatCompletudeInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static EtatCompletudeInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    EtatCompletudeInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtatCompletudeInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    EtatCompletudeInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtatCompletudeInstructionEnumeration getPourValeur(String pValeur)
  {
    EtatCompletudeInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtatCompletudeInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     EtatCompletudeInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */