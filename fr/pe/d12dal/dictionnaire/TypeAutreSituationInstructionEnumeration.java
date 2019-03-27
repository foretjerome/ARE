package fr.pe.d12dal.dictionnaire;

public final class TypeAutreSituationInstructionEnumeration
{
  public static final TypeAutreSituationInstructionEnumeration E_00 = new TypeAutreSituationInstructionEnumeration("", "", "00");
  public static final TypeAutreSituationInstructionEnumeration E_01 = new TypeAutreSituationInstructionEnumeration("CLCA", "CLCA", "01");
  public static final TypeAutreSituationInstructionEnumeration E_02 = new TypeAutreSituationInstructionEnumeration("Formation", "Formation", "02");
  public static final TypeAutreSituationInstructionEnumeration E_03 = new TypeAutreSituationInstructionEnumeration("Maladie", "Maladie", "03");
  public static final TypeAutreSituationInstructionEnumeration E_04 = new TypeAutreSituationInstructionEnumeration("MaternitÃ©", "MaternitÃ©", "04");
  public static final TypeAutreSituationInstructionEnumeration E_05 = new TypeAutreSituationInstructionEnumeration("Accident du Travail", "Accident du Travail", "05");
  public static final TypeAutreSituationInstructionEnumeration E_06 = new TypeAutreSituationInstructionEnumeration("Service National", "Service National", "06");
  public static final TypeAutreSituationInstructionEnumeration E_07 = new TypeAutreSituationInstructionEnumeration("CongÃ© prÃ©sence parentale", "CongÃ© prÃ©sence parentale", "07");
  public static final TypeAutreSituationInstructionEnumeration E_08 = new TypeAutreSituationInstructionEnumeration("Service civique", "Service civique", "08");
  public static final TypeAutreSituationInstructionEnumeration E_09 = new TypeAutreSituationInstructionEnumeration("CongÃ© individuel de formation", "CongÃ© individuel de formation", "09");
  public static final TypeAutreSituationInstructionEnumeration E_10 = new TypeAutreSituationInstructionEnumeration("IncarcÃ©ration", "IncarcÃ©ration", "10");
  public static final TypeAutreSituationInstructionEnumeration E_11 = new TypeAutreSituationInstructionEnumeration("Contrat de volontariat associatif", "Contrat de volontariat associatif", "11");
  public static final TypeAutreSituationInstructionEnumeration E_12 = new TypeAutreSituationInstructionEnumeration("Contrat de solidaritÃ© internationale", "Contrat de solidaritÃ© internationale", "12");
  public static final TypeAutreSituationInstructionEnumeration E_13 = new TypeAutreSituationInstructionEnumeration("Volontariat civil", "Volontariat civil", "13");
  public static final TypeAutreSituationInstructionEnumeration E_15 = new TypeAutreSituationInstructionEnumeration("MobilitÃ© volontaire sÃ©curisÃ©e", "MobilitÃ© volontaire sÃ©curisÃ©e", "15");
  public static final TypeAutreSituationInstructionEnumeration E_16 = new TypeAutreSituationInstructionEnumeration("CongÃ© parental d'Ã©ducation", "CongÃ© parental d'Ã©ducation", "16");
  public static final TypeAutreSituationInstructionEnumeration E_17 = new TypeAutreSituationInstructionEnumeration("CongÃ© de paternitÃ©", "CongÃ© de paternitÃ©", "17");
  public static final TypeAutreSituationInstructionEnumeration E_18 = new TypeAutreSituationInstructionEnumeration("CongÃ© d'adoption", "CongÃ© d'adoption", "18");
  public static final TypeAutreSituationInstructionEnumeration E_19 = new TypeAutreSituationInstructionEnumeration("PrÃ©parE", "Prestation partagÃ©e Ã©ducation de l'enfant (PrÃ©pare)", "19");
  public static final TypeAutreSituationInstructionEnumeration E_20 = new TypeAutreSituationInstructionEnumeration("ChÃ´mage Ã©tat membre EuropÃ©en ou Suisse", "ChÃ´mage Ã©tat membre EuropÃ©en ou Suisse", "20");
  public static final TypeAutreSituationInstructionEnumeration E_22 = new TypeAutreSituationInstructionEnumeration("DisponibilitÃ© du fonctionnaire", "DisponibilitÃ© du fonctionnaire", "22");
  public static final TypeAutreSituationInstructionEnumeration E_23 = new TypeAutreSituationInstructionEnumeration("CongÃ© sans solde", "CongÃ© sans solde", "23");
  public static final TypeAutreSituationInstructionEnumeration E_24 = new TypeAutreSituationInstructionEnumeration("CongÃ© sabbatique", "CongÃ© sabbatique", "24");
  public static final TypeAutreSituationInstructionEnumeration E_25 = new TypeAutreSituationInstructionEnumeration("CongÃ© non rÃ©munÃ©rÃ©", "CongÃ© non rÃ©munÃ©rÃ©", "25");
  static final TypeAutreSituationInstructionEnumeration[] LISTE_ENUM = { E_00, E_01, E_02, E_03, E_04, E_05, E_06, E_07, E_08, E_09, E_10, E_11, E_12, E_13, E_15, E_16, E_17, E_18, E_19, E_20, E_22, E_23, E_24, E_25 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypeAutreSituationInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypeAutreSituationInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypeAutreSituationInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypeAutreSituationInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeAutreSituationInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypeAutreSituationInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeAutreSituationInstructionEnumeration getPourValeur(String pValeur)
  {
    TypeAutreSituationInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeAutreSituationInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypeAutreSituationInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */