package fr.pe.d12dal.dictionnaire;

public final class SousMotifInscriptionInstructionEnumeration
{
  public static final SousMotifInscriptionInstructionEnumeration E_11 = new SousMotifInscriptionInstructionEnumeration("Licenciement Ã©conomique", "Licenciement Ã©conomique", "11");
  public static final SousMotifInscriptionInstructionEnumeration E_12 = new SousMotifInscriptionInstructionEnumeration("Autre licenciement", "Autre licenciement", "12");
  public static final SousMotifInscriptionInstructionEnumeration E_13 = new SousMotifInscriptionInstructionEnumeration("DÃ©mission", "DÃ©mission", "13");
  public static final SousMotifInscriptionInstructionEnumeration E_14 = new SousMotifInscriptionInstructionEnumeration("Fin de contrat Ã  durÃ©e dÃ©terminÃ©e", "Fin de contrat Ã  durÃ©e dÃ©terminÃ©e", "14");
  public static final SousMotifInscriptionInstructionEnumeration E_15 = new SousMotifInscriptionInstructionEnumeration("Fin de mission", "Fin de mission", "15");
  public static final SousMotifInscriptionInstructionEnumeration E_18 = new SousMotifInscriptionInstructionEnumeration("Fin de contrat emploi jeune", "Fin de contrat emploi jeune", "18");
  public static final SousMotifInscriptionInstructionEnumeration E_26 = new SousMotifInscriptionInstructionEnumeration("Rupture CNE initiative employeur", "Rupture CNE initiative employeur", "26");
  public static final SousMotifInscriptionInstructionEnumeration E_27 = new SousMotifInscriptionInstructionEnumeration("Rupture CNE initiative salariÃ©", "Rupture CNE initiative salariÃ©", "27");
  public static final SousMotifInscriptionInstructionEnumeration E_32 = new SousMotifInscriptionInstructionEnumeration("Rupture conventionnelle du CDI", "Rupture conventionnelle du CDI", "32");
  public static final SousMotifInscriptionInstructionEnumeration E_00 = new SousMotifInscriptionInstructionEnumeration("", "", "00");
  static final SousMotifInscriptionInstructionEnumeration[] LISTE_ENUM = { E_11, E_12, E_13, E_14, E_15, E_18, E_26, E_27, E_32, E_00 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private SousMotifInscriptionInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private SousMotifInscriptionInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static SousMotifInscriptionInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    SousMotifInscriptionInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static SousMotifInscriptionInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    SousMotifInscriptionInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static SousMotifInscriptionInstructionEnumeration getPourValeur(String pValeur)
  {
    SousMotifInscriptionInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static SousMotifInscriptionInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     SousMotifInscriptionInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */