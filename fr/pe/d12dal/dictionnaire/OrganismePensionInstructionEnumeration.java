package fr.pe.d12dal.dictionnaire;

public final class OrganismePensionInstructionEnumeration
{
  public static final OrganismePensionInstructionEnumeration E_00 = new OrganismePensionInstructionEnumeration("", "", "00");
  public static final OrganismePensionInstructionEnumeration E_01 = new OrganismePensionInstructionEnumeration("Fond de sÃ©curitÃ© sociale de l'assemblÃ©e nationale", "Fond de sÃ©curitÃ© sociale de l'assemblÃ©e nationale", "01");
  public static final OrganismePensionInstructionEnumeration E_02 = new OrganismePensionInstructionEnumeration("Autre rÃ©gime spÃ©cial", "Autre rÃ©gime spÃ©cial", "02");
  public static final OrganismePensionInstructionEnumeration E_03 = new OrganismePensionInstructionEnumeration("Banque de France", "Banque de France", "03");
  public static final OrganismePensionInstructionEnumeration E_04 = new OrganismePensionInstructionEnumeration("RÃ©gime minier", "RÃ©gime minier", "04");
  public static final OrganismePensionInstructionEnumeration E_05 = new OrganismePensionInstructionEnumeration("Caisse autonome de sÃ©curitÃ© sociale des sÃ©nateurs et du personnel du sÃ©nat", "Caisse autonome de sÃ©curitÃ© sociale des sÃ©nateurs et du personnel du sÃ©nat", "05");
  public static final OrganismePensionInstructionEnumeration E_06 = new OrganismePensionInstructionEnumeration("Protection sociale des cultes", "Protection sociale des cultes", "06");
  public static final OrganismePensionInstructionEnumeration E_07 = new OrganismePensionInstructionEnumeration("Caisse de coordination au assurances sociales de la RATP", "Caisse de coordination au assurances sociales de la RATP", "07");
  public static final OrganismePensionInstructionEnumeration E_08 = new OrganismePensionInstructionEnumeration("RÃ©gime spÃ©cial d'assurance maladie de la chambre de commerce et d'industrie de Paris", "RÃ©gime spÃ©cial d'assurance maladie de la chambre de commerce et d'industrie de Paris", "08");
  public static final OrganismePensionInstructionEnumeration E_09 = new OrganismePensionInstructionEnumeration("Caisse nationale militaire de sÃ©curitÃ© sociale", "Caisse nationale militaire de sÃ©curitÃ© sociale", "09");
  public static final OrganismePensionInstructionEnumeration E_10 = new OrganismePensionInstructionEnumeration("RÃ©gime des agents des collectivitÃ©s locales", "RÃ©gime des agents des collectivitÃ©s locales", "10");
  public static final OrganismePensionInstructionEnumeration E_11 = new OrganismePensionInstructionEnumeration("ComÃ©die francaise", "ComÃ©die francaise", "11");
  public static final OrganismePensionInstructionEnumeration E_12 = new OrganismePensionInstructionEnumeration("Caisse primaire assurance maladie", "Caisse primaire assurance maladie", "12");
  public static final OrganismePensionInstructionEnumeration E_13 = new OrganismePensionInstructionEnumeration("Caisse de prÃ©voyance et de retraite du personnel de la SNCF", "Caisse de prÃ©voyance et de retraite du personnel de la SNCF", "13");
  public static final OrganismePensionInstructionEnumeration E_14 = new OrganismePensionInstructionEnumeration("Caisse de retraite et de prÃ©voyance des clercs et employÃ©s de notaire", "Caisse de retraite et de prÃ©voyance des clercs et employÃ©s de notaire", "14");
  public static final OrganismePensionInstructionEnumeration E_15 = new OrganismePensionInstructionEnumeration("EDF et GDF", "EDF et GDF", "15");
  public static final OrganismePensionInstructionEnumeration E_16 = new OrganismePensionInstructionEnumeration("Etablissement national des invalides de la marine", "Etablissement national des invalides de la marine", "16");
  public static final OrganismePensionInstructionEnumeration E_17 = new OrganismePensionInstructionEnumeration("RÃ©gime des ouvriers des Ã©tablissements industriels de l'Ã©tat", "RÃ©gime des ouvriers des Ã©tablissements industriels de l'Ã©tat", "17");
  public static final OrganismePensionInstructionEnumeration E_18 = new OrganismePensionInstructionEnumeration("Mutuelle sociale agricole", "Mutuelle sociale agricole", "18");
  public static final OrganismePensionInstructionEnumeration E_19 = new OrganismePensionInstructionEnumeration("OpÃ©ra de Paris", "OpÃ©ra de Paris", "19");
  public static final OrganismePensionInstructionEnumeration E_20 = new OrganismePensionInstructionEnumeration("Police nationale", "Police nationale", "20");
  public static final OrganismePensionInstructionEnumeration E_21 = new OrganismePensionInstructionEnumeration("Caisse de prÃ©voyance du personnel du port autonome Bordeaux", "Caisse de prÃ©voyance du personnel du port autonome Bordeaux", "21");
  public static final OrganismePensionInstructionEnumeration E_22 = new OrganismePensionInstructionEnumeration("Port autonome de Strasbourg", "Port autonome de Strasbourg", "22");
  static final OrganismePensionInstructionEnumeration[] LISTE_ENUM = { E_00, E_01, E_02, E_03, E_04, E_05, E_06, E_07, E_08, E_09, E_10, E_11, E_12, E_13, E_14, E_15, E_16, E_17, E_18, E_19, E_20, E_21, E_22 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private OrganismePensionInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private OrganismePensionInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static OrganismePensionInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    OrganismePensionInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static OrganismePensionInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    OrganismePensionInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static OrganismePensionInstructionEnumeration getPourValeur(String pValeur)
  {
    OrganismePensionInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static OrganismePensionInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     OrganismePensionInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */