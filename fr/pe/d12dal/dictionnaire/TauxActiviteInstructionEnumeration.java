package fr.pe.d12dal.dictionnaire;

public final class TauxActiviteInstructionEnumeration
{
  public static final TauxActiviteInstructionEnumeration E_1 = new TauxActiviteInstructionEnumeration("Taux plein", "Taux plein", "1");
  public static final TauxActiviteInstructionEnumeration E_2 = new TauxActiviteInstructionEnumeration("Taux partiel", "Taux partiel", "2");
  public static final TauxActiviteInstructionEnumeration E_0 = new TauxActiviteInstructionEnumeration("", "", "0");
  static final TauxActiviteInstructionEnumeration[] LISTE_ENUM = { E_1, E_2, E_0 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TauxActiviteInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TauxActiviteInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TauxActiviteInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TauxActiviteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TauxActiviteInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TauxActiviteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TauxActiviteInstructionEnumeration getPourValeur(String pValeur)
  {
    TauxActiviteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TauxActiviteInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TauxActiviteInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */