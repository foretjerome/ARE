package fr.pe.d12dal.dictionnaire;

public final class EtatDemandeInstructionEnumeration
{
  public static final EtatDemandeInstructionEnumeration E_1 = new EtatDemandeInstructionEnumeration("En cours d'instruction", "En cours d'instruction", "1");
  public static final EtatDemandeInstructionEnumeration E_2 = new EtatDemandeInstructionEnumeration("ActivÃ©e", "ActivÃ©e", "2");
  public static final EtatDemandeInstructionEnumeration E_3 = new EtatDemandeInstructionEnumeration("Brouillon", "Brouillon", "3");
  public static final EtatDemandeInstructionEnumeration E_0 = new EtatDemandeInstructionEnumeration("", "", "0");
  public static final EtatDemandeInstructionEnumeration E_4 = new EtatDemandeInstructionEnumeration("Erreur de rÃ©cupÃ©ration Web", "Erreur de rÃ©cupÃ©ration Web", "4");
  static final EtatDemandeInstructionEnumeration[] LISTE_ENUM = { E_1, E_2, E_3, E_0, E_4 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private EtatDemandeInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private EtatDemandeInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static EtatDemandeInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    EtatDemandeInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtatDemandeInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    EtatDemandeInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtatDemandeInstructionEnumeration getPourValeur(String pValeur)
  {
    EtatDemandeInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtatDemandeInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     EtatDemandeInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */