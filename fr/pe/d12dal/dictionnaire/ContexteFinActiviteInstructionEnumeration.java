package fr.pe.d12dal.dictionnaire;

public final class ContexteFinActiviteInstructionEnumeration
{
  public static final ContexteFinActiviteInstructionEnumeration E_01 = new ContexteFinActiviteInstructionEnumeration("Fin pÃ©riode essai salariÃ© < 91 j suite licenciement ou fin CDD sans IDE", "Fin pÃ©riode essai salariÃ© < 91 j suite licenciement ou fin CDD sans IDE", "01");
  public static final ContexteFinActiviteInstructionEnumeration E_02 = new ContexteFinActiviteInstructionEnumeration("Pour acte dÃ©lictueux", "Pour acte dÃ©lictueux", "02");
  public static final ContexteFinActiviteInstructionEnumeration E_03 = new ContexteFinActiviteInstructionEnumeration("Pour arrÃªt de pÃ©riodique ou clause de conscience avec versement d'indemnitÃ©s", "Pour arrÃªt de pÃ©riodique ou clause de conscience avec versement d'indemnitÃ©s", "03");
  public static final ContexteFinActiviteInstructionEnumeration E_04 = new ContexteFinActiviteInstructionEnumeration("Pour crÃ©ation d'entreprise", "Pour crÃ©ation d'entreprise", "04");
  public static final ContexteFinActiviteInstructionEnumeration E_05 = new ContexteFinActiviteInstructionEnumeration("Pour non paiement des salaires", "Pour non paiement des salaires", "05");
  public static final ContexteFinActiviteInstructionEnumeration E_06 = new ContexteFinActiviteInstructionEnumeration("Pour prendre un emploi CDI avec fin pÃ©riode d'essai employeur", "Pour prendre un emploi CDI avec fin pÃ©riode d'essai employeur", "06");
  public static final ContexteFinActiviteInstructionEnumeration E_07 = new ContexteFinActiviteInstructionEnumeration("Pour suivre ses parents", "Pour suivre ses parents", "07");
  public static final ContexteFinActiviteInstructionEnumeration E_08 = new ContexteFinActiviteInstructionEnumeration("Pour violence conjugale", "Pour violence conjugale", "08");
  public static final ContexteFinActiviteInstructionEnumeration E_09 = new ContexteFinActiviteInstructionEnumeration("Suite Ã  un contrat couple", "Suite Ã  un contrat couple", "09");
  public static final ContexteFinActiviteInstructionEnumeration E_10 = new ContexteFinActiviteInstructionEnumeration("Pour suivre son conjoint crÃ©ateur d'entreprise", "Pour suivre son conjoint crÃ©ateur d'entreprise", "10");
  public static final ContexteFinActiviteInstructionEnumeration E_11 = new ContexteFinActiviteInstructionEnumeration("Pour suivre son conjoint mutation", "Pour suivre son conjoint mutation", "11");
  public static final ContexteFinActiviteInstructionEnumeration E_12 = new ContexteFinActiviteInstructionEnumeration("Pour mariage", "Pour mariage", "12");
  public static final ContexteFinActiviteInstructionEnumeration E_13 = new ContexteFinActiviteInstructionEnumeration("Pour PACS", "Pour PACS", "13");
  public static final ContexteFinActiviteInstructionEnumeration E_14 = new ContexteFinActiviteInstructionEnumeration("Pour nouvel emploi d'un CES, CAE, CIE, CA ou CI-RMA", "Pour nouvel emploi d'un CES, CAE, CIE, CA ou CI-RMA", "14");
  public static final ContexteFinActiviteInstructionEnumeration E_15 = new ContexteFinActiviteInstructionEnumeration("Pour une formation d'un CES, CAE, CIE, CA ou CI-RMA", "Pour une formation d'un CES, CAE, CIE, CA ou CI-RMA", "15");
  public static final ContexteFinActiviteInstructionEnumeration E_16 = new ContexteFinActiviteInstructionEnumeration("Pour volontariat associatif", "Pour volontariat associatif", "16");
  public static final ContexteFinActiviteInstructionEnumeration E_17 = new ContexteFinActiviteInstructionEnumeration("Pour effectuer des missions de volontariat de solidaritÃ© internationale", "Pour effectuer des missions de volontariat de solidaritÃ© internationale", "17");
  public static final ContexteFinActiviteInstructionEnumeration E_00 = new ContexteFinActiviteInstructionEnumeration("", "", "00");
  public static final ContexteFinActiviteInstructionEnumeration E_22 = new ContexteFinActiviteInstructionEnumeration("Sans motif prÃ©cisÃ©", "Sans motif prÃ©cisÃ©", "22");
  public static final ContexteFinActiviteInstructionEnumeration E_18 = new ContexteFinActiviteInstructionEnumeration("Suppression ou transformation de votre emploi", "Suppression ou transformation de votre emploi", "18");
  public static final ContexteFinActiviteInstructionEnumeration E_19 = new ContexteFinActiviteInstructionEnumeration("Modification de contrat de travail", "Modification de contrat de travail", "19");
  public static final ContexteFinActiviteInstructionEnumeration E_20 = new ContexteFinActiviteInstructionEnumeration("Pour raison Ã©conomique ou technologique", "Pour raison Ã©conomique ou technologique", "20");
  public static final ContexteFinActiviteInstructionEnumeration E_21 = new ContexteFinActiviteInstructionEnumeration("autre raison", "autre raison", "21");
  public static final ContexteFinActiviteInstructionEnumeration E_23 = new ContexteFinActiviteInstructionEnumeration("Pour placement d'un enfant handicapÃ© en structure d'accueil", "Pour placement d'un enfant handicapÃ© en structure d'accueil", "23");
  public static final ContexteFinActiviteInstructionEnumeration E_24 = new ContexteFinActiviteInstructionEnumeration("Pour suivre son mandataire/curateur/tuteur", "Pour suivre son mandataire/curateur/tuteur", "24");
  static final ContexteFinActiviteInstructionEnumeration[] LISTE_ENUM = { E_01, E_02, E_03, E_04, E_05, E_06, E_07, E_08, E_09, E_10, E_11, E_12, E_13, E_14, E_15, E_16, E_17, E_00, E_22, E_18, E_19, E_20, E_21, E_23, E_24 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private ContexteFinActiviteInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private ContexteFinActiviteInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static ContexteFinActiviteInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    ContexteFinActiviteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static ContexteFinActiviteInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    ContexteFinActiviteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static ContexteFinActiviteInstructionEnumeration getPourValeur(String pValeur)
  {
    ContexteFinActiviteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static ContexteFinActiviteInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     ContexteFinActiviteInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */