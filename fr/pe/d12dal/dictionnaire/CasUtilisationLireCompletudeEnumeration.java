package fr.pe.d12dal.dictionnaire;

import java.math.BigDecimal;

public final class CasUtilisationLireCompletudeEnumeration
{
  public static final CasUtilisationLireCompletudeEnumeration E_1 = new CasUtilisationLireCompletudeEnumeration("Lire le dernier rÃ©sultat de complÃ©tude", "Lire le dernier rÃ©sultat de complÃ©tude", new BigDecimal("1"));
  static final CasUtilisationLireCompletudeEnumeration[] LISTE_ENUM = { E_1 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final BigDecimal m_valeur;
  
  private CasUtilisationLireCompletudeEnumeration(String pLibelleCourt, String pLibelleLong, BigDecimal pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private CasUtilisationLireCompletudeEnumeration(String pLibelleCourt, BigDecimal pValeur)
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
  
  public BigDecimal getValeur()
  {
    return m_valeur;
  }
  
  public static CasUtilisationLireCompletudeEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    CasUtilisationLireCompletudeEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationLireCompletudeEnumeration getPourLibelleLong(String pLibelleLong)
  {
    CasUtilisationLireCompletudeEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationLireCompletudeEnumeration getPourValeur(BigDecimal pValeur)
  {
    CasUtilisationLireCompletudeEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationLireCompletudeEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     CasUtilisationLireCompletudeEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */