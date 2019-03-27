package fr.pe.d12dal.dictionnaire;

public final class CasUtilisationAjouterPieceJustificativeEnumeration
{
  public static final CasUtilisationAjouterPieceJustificativeEnumeration E_01 = new CasUtilisationAjouterPieceJustificativeEnumeration("AE Batiment", "AE Batiment", "01");
  static final CasUtilisationAjouterPieceJustificativeEnumeration[] LISTE_ENUM = { E_01 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private CasUtilisationAjouterPieceJustificativeEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private CasUtilisationAjouterPieceJustificativeEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static CasUtilisationAjouterPieceJustificativeEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    CasUtilisationAjouterPieceJustificativeEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationAjouterPieceJustificativeEnumeration getPourLibelleLong(String pLibelleLong)
  {
    CasUtilisationAjouterPieceJustificativeEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationAjouterPieceJustificativeEnumeration getPourValeur(String pValeur)
  {
    CasUtilisationAjouterPieceJustificativeEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationAjouterPieceJustificativeEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     CasUtilisationAjouterPieceJustificativeEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */