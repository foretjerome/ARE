package fr.pe.d12dal.dictionnaire;

public final class RegimeSpecialRetraiteInstructionEnumeration
{
  public static final RegimeSpecialRetraiteInstructionEnumeration E_01 = new RegimeSpecialRetraiteInstructionEnumeration("Agricole", "Agricole", "01");
  public static final RegimeSpecialRetraiteInstructionEnumeration E_02 = new RegimeSpecialRetraiteInstructionEnumeration("Clercs de notaire", "Clercs de notaire", "02");
  public static final RegimeSpecialRetraiteInstructionEnumeration E_03 = new RegimeSpecialRetraiteInstructionEnumeration("Compagnie des eaux", "Compagnie des eaux", "03");
  public static final RegimeSpecialRetraiteInstructionEnumeration E_04 = new RegimeSpecialRetraiteInstructionEnumeration("FranÃ§ais Ã  l'Ã©tranger", "FranÃ§ais Ã  l'Ã©tranger", "04");
  public static final RegimeSpecialRetraiteInstructionEnumeration E_05 = new RegimeSpecialRetraiteInstructionEnumeration("Des mines", "Des mines", "05");
  public static final RegimeSpecialRetraiteInstructionEnumeration E_06 = new RegimeSpecialRetraiteInstructionEnumeration("Marine marchande", "Marine marchande", "06");
  public static final RegimeSpecialRetraiteInstructionEnumeration E_07 = new RegimeSpecialRetraiteInstructionEnumeration("Port autonome de Bordeaux", "Port autonome de Bordeaux", "07");
  public static final RegimeSpecialRetraiteInstructionEnumeration E_00 = new RegimeSpecialRetraiteInstructionEnumeration("-", "-", "00");
  static final RegimeSpecialRetraiteInstructionEnumeration[] LISTE_ENUM = { E_01, E_02, E_03, E_04, E_05, E_06, E_07, E_00 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private RegimeSpecialRetraiteInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private RegimeSpecialRetraiteInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static RegimeSpecialRetraiteInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    RegimeSpecialRetraiteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static RegimeSpecialRetraiteInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    RegimeSpecialRetraiteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static RegimeSpecialRetraiteInstructionEnumeration getPourValeur(String pValeur)
  {
    RegimeSpecialRetraiteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static RegimeSpecialRetraiteInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     RegimeSpecialRetraiteInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */