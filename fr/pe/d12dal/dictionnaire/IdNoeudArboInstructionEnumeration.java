package fr.pe.d12dal.dictionnaire;

public final class IdNoeudArboInstructionEnumeration
{
  public static final IdNoeudArboInstructionEnumeration E_REFEXTERNE = new IdNoeudArboInstructionEnumeration("rÃ©fÃ©rence externe", "rÃ©fÃ©rence externe", "refExterne");
  public static final IdNoeudArboInstructionEnumeration E_IDDEM = new IdNoeudArboInstructionEnumeration("l'id de la demande V2", "l'id de la demande V2", "idDem");
  public static final IdNoeudArboInstructionEnumeration E_TYPEDEM = new IdNoeudArboInstructionEnumeration("le type de la demande", "le type de la demande", "typeDem");
  public static final IdNoeudArboInstructionEnumeration E_TYPEEXA = new IdNoeudArboInstructionEnumeration("le type de l'examen", "le type de l'examen", "typeExa");
  public static final IdNoeudArboInstructionEnumeration E_ESTLIQ = new IdNoeudArboInstructionEnumeration("indique si la demande est liquidÃ©e", "indique si la demande est liquidÃ©e", "estLiq");
  public static final IdNoeudArboInstructionEnumeration E_CAESTCLAD = new IdNoeudArboInstructionEnumeration("est classÃ©e administrativement", "est classÃ©e administrativement", "CAEstClAd");
  public static final IdNoeudArboInstructionEnumeration E_CAESTPRES = new IdNoeudArboInstructionEnumeration("est prescrite", "est prescrite", "CAEstPres");
  public static final IdNoeudArboInstructionEnumeration E_CAESTSAOB = new IdNoeudArboInstructionEnumeration("est sans objet", "est sans objet", "CAEstSaOb");
  public static final IdNoeudArboInstructionEnumeration E_CAESTCSP = new IdNoeudArboInstructionEnumeration("est competence secteur public", "est competence secteur public", "CAEstCSP");
  public static final IdNoeudArboInstructionEnumeration E_CAESTDETA = new IdNoeudArboInstructionEnumeration("est depot tardif", "est depot tardif", "CAEstDeTa");
  public static final IdNoeudArboInstructionEnumeration E_CAESTSASU = new IdNoeudArboInstructionEnumeration("est sans suite", "est sans suite", "CAEstSaSu");
  public static final IdNoeudArboInstructionEnumeration E_ESTNEULIQ = new IdNoeudArboInstructionEnumeration("neutralisÃ©e liquidation", "neutralisÃ©e liquidation", "estNeuLiq");
  public static final IdNoeudArboInstructionEnumeration E_ESTMAN = new IdNoeudArboInstructionEnumeration("est mandatÃ©e", "est mandatÃ©e", "estMan");
  public static final IdNoeudArboInstructionEnumeration E_NUMDOSSUI = new IdNoeudArboInstructionEnumeration("numÃ©ro de dossier de suivi", "numÃ©ro de dossier de suivi", "numDosSui");
  static final IdNoeudArboInstructionEnumeration[] LISTE_ENUM = { E_REFEXTERNE, E_IDDEM, E_TYPEDEM, E_TYPEEXA, E_ESTLIQ, E_CAESTCLAD, E_CAESTPRES, E_CAESTSAOB, E_CAESTCSP, E_CAESTDETA, E_CAESTSASU, E_ESTNEULIQ, E_ESTMAN, E_NUMDOSSUI };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private IdNoeudArboInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private IdNoeudArboInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static IdNoeudArboInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    IdNoeudArboInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static IdNoeudArboInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    IdNoeudArboInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static IdNoeudArboInstructionEnumeration getPourValeur(String pValeur)
  {
    IdNoeudArboInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static IdNoeudArboInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     IdNoeudArboInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */