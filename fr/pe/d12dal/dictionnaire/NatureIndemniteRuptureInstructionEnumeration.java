package fr.pe.d12dal.dictionnaire;

public final class NatureIndemniteRuptureInstructionEnumeration
{
  public static final NatureIndemniteRuptureInstructionEnumeration E_01 = new NatureIndemniteRuptureInstructionEnumeration("IndemnitÃ© de Licenciement", "IndemnitÃ© de Licenciement", "01");
  public static final NatureIndemniteRuptureInstructionEnumeration E_02 = new NatureIndemniteRuptureInstructionEnumeration("IndemnitÃ© transactionnel", "IndemnitÃ© transactionnel", "02");
  public static final NatureIndemniteRuptureInstructionEnumeration E_03 = new NatureIndemniteRuptureInstructionEnumeration("IndemnitÃ© de rupture conventionnelle", "IndemnitÃ© de rupture conventionnelle", "03");
  public static final NatureIndemniteRuptureInstructionEnumeration E_04 = new NatureIndemniteRuptureInstructionEnumeration("Prime de dÃ©part", "Prime de dÃ©part", "04");
  public static final NatureIndemniteRuptureInstructionEnumeration E_05 = new NatureIndemniteRuptureInstructionEnumeration("RTT ou compte Ã©pargne temps", "RTT ou compte Ã©pargne temps", "05");
  public static final NatureIndemniteRuptureInstructionEnumeration E_00 = new NatureIndemniteRuptureInstructionEnumeration("", "", "00");
  static final NatureIndemniteRuptureInstructionEnumeration[] LISTE_ENUM = { E_01, E_02, E_03, E_04, E_05, E_00 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private NatureIndemniteRuptureInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private NatureIndemniteRuptureInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static NatureIndemniteRuptureInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    NatureIndemniteRuptureInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static NatureIndemniteRuptureInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    NatureIndemniteRuptureInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static NatureIndemniteRuptureInstructionEnumeration getPourValeur(String pValeur)
  {
    NatureIndemniteRuptureInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static NatureIndemniteRuptureInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     NatureIndemniteRuptureInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */