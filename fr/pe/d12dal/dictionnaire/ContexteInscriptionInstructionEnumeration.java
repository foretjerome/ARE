package fr.pe.d12dal.dictionnaire;

public final class ContexteInscriptionInstructionEnumeration
{
  public static final ContexteInscriptionInstructionEnumeration E_0 = new ContexteInscriptionInstructionEnumeration("Inscription", "Inscription", "0");
  public static final ContexteInscriptionInstructionEnumeration E_2 = new ContexteInscriptionInstructionEnumeration("RIDE moins de 6 mois", "RIDE moins de 6 mois", "2");
  public static final ContexteInscriptionInstructionEnumeration E_1 = new ContexteInscriptionInstructionEnumeration("RIDE plus de 6 mois", "RIDE plus de 6 mois", "1");
  static final ContexteInscriptionInstructionEnumeration[] LISTE_ENUM = { E_0, E_2, E_1 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private ContexteInscriptionInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private ContexteInscriptionInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static ContexteInscriptionInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    ContexteInscriptionInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static ContexteInscriptionInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    ContexteInscriptionInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static ContexteInscriptionInstructionEnumeration getPourValeur(String pValeur)
  {
    ContexteInscriptionInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static ContexteInscriptionInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     ContexteInscriptionInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */