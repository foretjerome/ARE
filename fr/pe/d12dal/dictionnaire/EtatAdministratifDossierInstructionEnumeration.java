package fr.pe.d12dal.dictionnaire;

public final class EtatAdministratifDossierInstructionEnumeration
{
  public static final EtatAdministratifDossierInstructionEnumeration E_16 = new EtatAdministratifDossierInstructionEnumeration("AUTRE ATTENTE", "AUTRE ATTENTE", "16");
  public static final EtatAdministratifDossierInstructionEnumeration E_10 = new EtatAdministratifDossierInstructionEnumeration("PASSAGE EN IPR", "PASSAGE EN IPR", "10");
  public static final EtatAdministratifDossierInstructionEnumeration E_03 = new EtatAdministratifDossierInstructionEnumeration("ATTENTE DE LA DIRECCTE", "ATTENTE DE LA DIRECCTE", "03");
  public static final EtatAdministratifDossierInstructionEnumeration E_01 = new EtatAdministratifDossierInstructionEnumeration("ATTENTE DE DRC", "ATTENTE DE DRC", "01");
  public static final EtatAdministratifDossierInstructionEnumeration E_02 = new EtatAdministratifDossierInstructionEnumeration("ATTENTE Dâ€™ENTRETIEN", "ATTENTE D'ENTRETIEN", "02");
  public static final EtatAdministratifDossierInstructionEnumeration E_13 = new EtatAdministratifDossierInstructionEnumeration("ATTENTE Dâ€™EXAMEN", "ATTENTE D'EXAMEN", "13");
  public static final EtatAdministratifDossierInstructionEnumeration E_11 = new EtatAdministratifDossierInstructionEnumeration("ATTENTE DE PLANIFICATION", "ATTENTE DE PLANIFICATION", "11");
  public static final EtatAdministratifDossierInstructionEnumeration E_15 = new EtatAdministratifDossierInstructionEnumeration("ATTENTE DE PAIEMENT", "ATTENTE DE PAIEMENT", "15");
  public static final EtatAdministratifDossierInstructionEnumeration E_00 = new EtatAdministratifDossierInstructionEnumeration("ATTENTE DE REPONSE", "ATTENTE DE REPONSE", "00");
  public static final EtatAdministratifDossierInstructionEnumeration E_12 = new EtatAdministratifDossierInstructionEnumeration("ATTENTE DE REEXAMEN", "ATTENTE DE REEXAMEN", "12");
  public static final EtatAdministratifDossierInstructionEnumeration E_20 = new EtatAdministratifDossierInstructionEnumeration("DECISIONNE", "DECISIONNE", "20");
  public static final EtatAdministratifDossierInstructionEnumeration E_05 = new EtatAdministratifDossierInstructionEnumeration("ENVOI Dâ€™INFORMATION", "ENVOI D'INFORMATION", "05");
  public static final EtatAdministratifDossierInstructionEnumeration E_99 = new EtatAdministratifDossierInstructionEnumeration("DOSSIER FS CLOTURE", "DOSSIER FS CLOTURE", "99");
  public static final EtatAdministratifDossierInstructionEnumeration E_21 = new EtatAdministratifDossierInstructionEnumeration("TRAITE", "TRAITE", "21");
  static final EtatAdministratifDossierInstructionEnumeration[] LISTE_ENUM = { E_16, E_10, E_03, E_01, E_02, E_13, E_11, E_15, E_00, E_12, E_20, E_05, E_99, E_21 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private EtatAdministratifDossierInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private EtatAdministratifDossierInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static EtatAdministratifDossierInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    EtatAdministratifDossierInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtatAdministratifDossierInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    EtatAdministratifDossierInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtatAdministratifDossierInstructionEnumeration getPourValeur(String pValeur)
  {
    EtatAdministratifDossierInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static EtatAdministratifDossierInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     EtatAdministratifDossierInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */