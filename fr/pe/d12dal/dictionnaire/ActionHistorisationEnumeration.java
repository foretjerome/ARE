package fr.pe.d12dal.dictionnaire;

public final class ActionHistorisationEnumeration
{
  public static final ActionHistorisationEnumeration E_INSTALLATION_DAL = new ActionHistorisationEnumeration("Installation DAL", "Installation DAL", "Installation DAL");
  public static final ActionHistorisationEnumeration E_ACTIVATION_DAL = new ActionHistorisationEnumeration("Activation DAL", "Activation DAL", "Activation DAL");
  public static final ActionHistorisationEnumeration E_COMPLETUDE = new ActionHistorisationEnumeration("Completude", "Completude", "Completude");
  public static final ActionHistorisationEnumeration E_ENREGISTREMENT_DAL_MANUEL = new ActionHistorisationEnumeration("Enregistrement DAL manuel", "Enregistrement DAL manuel", "Enregistrement DAL manuel");
  public static final ActionHistorisationEnumeration E_DETECTION_FAUX_PRIMO = new ActionHistorisationEnumeration("Detection faux primo", "Detection faux primo", "Detection faux primo");
  public static final ActionHistorisationEnumeration E_RECEPTION_FLUX_GED = new ActionHistorisationEnumeration("Reception flux GED", "Reception flux GED", "Reception flux GED");
  public static final ActionHistorisationEnumeration E_NOTIFICATION_GAEC = new ActionHistorisationEnumeration("Notification GAEC", "Notification GAEC", "Notification GAEC");
  public static final ActionHistorisationEnumeration E_AJOUT_PIECE_MANUEL_CALI = new ActionHistorisationEnumeration("Ajout piece manuel CALI", "Ajout piece manuel CALI", "Ajout piece manuel CALI");
  public static final ActionHistorisationEnumeration E_INITIALISATION_DAL_EXPRESSE_WEB_BROUILLON = new ActionHistorisationEnumeration("Initialisation DAL Expresse Web Brouillon", "Initialisation DAL Expresse Web Brouillon", "Initialisation DAL Expresse Web Brouillon");
  public static final ActionHistorisationEnumeration E_LECTURE_DAL_CALI = new ActionHistorisationEnumeration("Lecture DAL CALI", "Lecture DAL CALI", "Lecture DAL CALI");
  public static final ActionHistorisationEnumeration E_CREATION_ATTENTE_FAUX_PRIMO = new ActionHistorisationEnumeration("Creation attente faux primo", "Creation attente faux primo", "Creation attente faux primo");
  public static final ActionHistorisationEnumeration E_CREATION_ATTENTE_MODE_SECOURS = new ActionHistorisationEnumeration("Creation attente mode secours", "Creation attente mode secours", "Creation attente mode secours");
  public static final ActionHistorisationEnumeration E_LIQUIDATION = new ActionHistorisationEnumeration("Liquidation", "Liquidation", "Liquidation");
  public static final ActionHistorisationEnumeration E_SYNCHRONISATION_COULEUR = new ActionHistorisationEnumeration("Synchronisation Couleur", "Synchronisation Couleur", "Synchronisation Couleur");
  public static final ActionHistorisationEnumeration E_ENVOI_CREM = new ActionHistorisationEnumeration("Envoi CREM", "Envoi CREM", "Envoi CREM");
  static final ActionHistorisationEnumeration[] LISTE_ENUM = { E_INSTALLATION_DAL, E_ACTIVATION_DAL, E_COMPLETUDE, E_ENREGISTREMENT_DAL_MANUEL, E_DETECTION_FAUX_PRIMO, E_RECEPTION_FLUX_GED, E_NOTIFICATION_GAEC, E_AJOUT_PIECE_MANUEL_CALI, E_INITIALISATION_DAL_EXPRESSE_WEB_BROUILLON, E_LECTURE_DAL_CALI, E_CREATION_ATTENTE_FAUX_PRIMO, E_CREATION_ATTENTE_MODE_SECOURS, E_LIQUIDATION, E_SYNCHRONISATION_COULEUR, E_ENVOI_CREM };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private ActionHistorisationEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private ActionHistorisationEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static ActionHistorisationEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    ActionHistorisationEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static ActionHistorisationEnumeration getPourLibelleLong(String pLibelleLong)
  {
    ActionHistorisationEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static ActionHistorisationEnumeration getPourValeur(String pValeur)
  {
    ActionHistorisationEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static ActionHistorisationEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     ActionHistorisationEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */