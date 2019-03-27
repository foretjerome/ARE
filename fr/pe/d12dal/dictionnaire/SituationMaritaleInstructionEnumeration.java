package fr.pe.d12dal.dictionnaire;

public final class SituationMaritaleInstructionEnumeration
{
  public static final SituationMaritaleInstructionEnumeration E_M = new SituationMaritaleInstructionEnumeration("MariÃ©", "MariÃ©", "M");
  public static final SituationMaritaleInstructionEnumeration E_P = new SituationMaritaleInstructionEnumeration("Partenaire PACS", "Partenaire PACS", "P");
  public static final SituationMaritaleInstructionEnumeration E_O = new SituationMaritaleInstructionEnumeration("Concubin(e)", "Concubin(e)", "O");
  public static final SituationMaritaleInstructionEnumeration E_C = new SituationMaritaleInstructionEnumeration("CÃ©libataire", "CÃ©libataire", "C");
  public static final SituationMaritaleInstructionEnumeration E_V = new SituationMaritaleInstructionEnumeration("Veuf(ve)", "Veuf(ve)", "V");
  public static final SituationMaritaleInstructionEnumeration E_D = new SituationMaritaleInstructionEnumeration("SÃ©parÃ©(e)/DivorcÃ©(e)", "SÃ©parÃ©(e)/DivorcÃ©(e)", "D");
  static final SituationMaritaleInstructionEnumeration[] LISTE_ENUM = { E_M, E_P, E_O, E_C, E_V, E_D };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private SituationMaritaleInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private SituationMaritaleInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static SituationMaritaleInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    SituationMaritaleInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static SituationMaritaleInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    SituationMaritaleInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static SituationMaritaleInstructionEnumeration getPourValeur(String pValeur)
  {
    SituationMaritaleInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static SituationMaritaleInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     SituationMaritaleInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */