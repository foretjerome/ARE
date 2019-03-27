package fr.pe.d12dal.dictionnaire;

public final class IntensiteHoraireInstructionEnumeration
{
  public static final IntensiteHoraireInstructionEnumeration E_2 = new IntensiteHoraireInstructionEnumeration("Hebdo", "Hebdo", "2");
  public static final IntensiteHoraireInstructionEnumeration E_4 = new IntensiteHoraireInstructionEnumeration("Mensuel", "Mensuel", "4");
  public static final IntensiteHoraireInstructionEnumeration E_5 = new IntensiteHoraireInstructionEnumeration("Annuel", "Annuel", "5");
  public static final IntensiteHoraireInstructionEnumeration E_0 = new IntensiteHoraireInstructionEnumeration("", "", "0");
  static final IntensiteHoraireInstructionEnumeration[] LISTE_ENUM = { E_2, E_4, E_5, E_0 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private IntensiteHoraireInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private IntensiteHoraireInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static IntensiteHoraireInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    IntensiteHoraireInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static IntensiteHoraireInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    IntensiteHoraireInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static IntensiteHoraireInstructionEnumeration getPourValeur(String pValeur)
  {
    IntensiteHoraireInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static IntensiteHoraireInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     IntensiteHoraireInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */