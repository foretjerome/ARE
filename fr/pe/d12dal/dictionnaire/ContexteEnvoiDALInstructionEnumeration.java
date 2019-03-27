package fr.pe.d12dal.dictionnaire;

public final class ContexteEnvoiDALInstructionEnumeration
{
  public static final ContexteEnvoiDALInstructionEnumeration E_01 = new ContexteEnvoiDALInstructionEnumeration("Inscription", "Inscription", "01");
  public static final ContexteEnvoiDALInstructionEnumeration E_02 = new ContexteEnvoiDALInstructionEnumeration("Demande Expresse", "Demande Expresse", "02");
  public static final ContexteEnvoiDALInstructionEnumeration E_00 = new ContexteEnvoiDALInstructionEnumeration("", "", "00");
  static final ContexteEnvoiDALInstructionEnumeration[] LISTE_ENUM = { E_01, E_02, E_00 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private ContexteEnvoiDALInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private ContexteEnvoiDALInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static ContexteEnvoiDALInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    ContexteEnvoiDALInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static ContexteEnvoiDALInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    ContexteEnvoiDALInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static ContexteEnvoiDALInstructionEnumeration getPourValeur(String pValeur)
  {
    ContexteEnvoiDALInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static ContexteEnvoiDALInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     ContexteEnvoiDALInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */