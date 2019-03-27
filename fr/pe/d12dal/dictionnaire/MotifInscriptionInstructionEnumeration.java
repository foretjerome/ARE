package fr.pe.d12dal.dictionnaire;

public final class MotifInscriptionInstructionEnumeration
{
  public static final MotifInscriptionInstructionEnumeration E_00 = new MotifInscriptionInstructionEnumeration("Sans objet cat.5", "Sans objet cat.5", "00");
  public static final MotifInscriptionInstructionEnumeration E_19 = new MotifInscriptionInstructionEnumeration("Autre cas", "Autre cas", "19");
  public static final MotifInscriptionInstructionEnumeration E_20 = new MotifInscriptionInstructionEnumeration("EntrÃ©e en CRP", "EntrÃ©e en CRP", "20");
  public static final MotifInscriptionInstructionEnumeration E_21 = new MotifInscriptionInstructionEnumeration("PremiÃ¨re entrÃ©e sur le marchÃ©", "PremiÃ¨re entrÃ©e sur le marchÃ©", "21");
  public static final MotifInscriptionInstructionEnumeration E_22 = new MotifInscriptionInstructionEnumeration("Reprise activitÃ© aprÃ¨s + 6 mois", "Reprise activitÃ© aprÃ¨s + 6 mois", "22");
  public static final MotifInscriptionInstructionEnumeration E_23 = new MotifInscriptionInstructionEnumeration("BÃ©nÃ©ficiaire convention 03 fÃ©v. 93", "BÃ©nÃ©ficiaire convention 03 fÃ©v. 93", "23");
  public static final MotifInscriptionInstructionEnumeration E_24 = new MotifInscriptionInstructionEnumeration("Primo arrivant", "Primo arrivant", "24");
  public static final MotifInscriptionInstructionEnumeration E_25 = new MotifInscriptionInstructionEnumeration("Fin CRP CTP CSP", "Fin de CRP-CTP-CSP", "25");
  public static final MotifInscriptionInstructionEnumeration E_28 = new MotifInscriptionInstructionEnumeration("Sortie de stage", "Sortie de stage", "28");
  public static final MotifInscriptionInstructionEnumeration E_29 = new MotifInscriptionInstructionEnumeration("Fin d'activitÃ© non salariÃ©", "Fin d'activitÃ© non salariÃ©", "29");
  public static final MotifInscriptionInstructionEnumeration E_30 = new MotifInscriptionInstructionEnumeration("Fin de maladie, maternitÃ©", "Fin de maladie, maternitÃ©", "30");
  public static final MotifInscriptionInstructionEnumeration E_31 = new MotifInscriptionInstructionEnumeration("EntrÃ©e en CTP", "EntrÃ©e en CTP", "31");
  public static final MotifInscriptionInstructionEnumeration E_33 = new MotifInscriptionInstructionEnumeration("EntrÃ©e CTP suite CRP", "EntrÃ©e CTP suite CRP", "33");
  public static final MotifInscriptionInstructionEnumeration E_34 = new MotifInscriptionInstructionEnumeration("EntrÃ©e CSP", "EntrÃ©e CSP", "34");
  public static final MotifInscriptionInstructionEnumeration E_16 = new MotifInscriptionInstructionEnumeration("Fin de convention de conversion", "Fin de convention de conversion", "16");
  public static final MotifInscriptionInstructionEnumeration E_35 = new MotifInscriptionInstructionEnumeration("Retour en France", "Retour en France", "35");
  public static final MotifInscriptionInstructionEnumeration E_36 = new MotifInscriptionInstructionEnumeration("Fin de dÃ©tention", "Fin de dÃ©tention", "36");
  public static final MotifInscriptionInstructionEnumeration E_01 = new MotifInscriptionInstructionEnumeration("Fin d'activitÃ© salariÃ©e", "Fin d'activitÃ© salariÃ©e", "01");
  static final MotifInscriptionInstructionEnumeration[] LISTE_ENUM = { E_00, E_19, E_20, E_21, E_22, E_23, E_24, E_25, E_28, E_29, E_30, E_31, E_33, E_34, E_16, E_35, E_36, E_01 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private MotifInscriptionInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private MotifInscriptionInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static MotifInscriptionInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    MotifInscriptionInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static MotifInscriptionInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    MotifInscriptionInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static MotifInscriptionInstructionEnumeration getPourValeur(String pValeur)
  {
    MotifInscriptionInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static MotifInscriptionInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     MotifInscriptionInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */