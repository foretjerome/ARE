package fr.pe.d12dal.dictionnaire;

import java.math.BigDecimal;

public final class CasUtilisationAlimenterArboPrestationFinancieresEnumeration
{
  public static final CasUtilisationAlimenterArboPrestationFinancieresEnumeration E_1 = new CasUtilisationAlimenterArboPrestationFinancieresEnumeration("Chargement en mode complet (toutes demandes)", "Chargement en mode complet (toutes demandes)", new BigDecimal("1"));
  public static final CasUtilisationAlimenterArboPrestationFinancieresEnumeration E_2 = new CasUtilisationAlimenterArboPrestationFinancieresEnumeration("Chargement en mode restreint (3 demandes)", "Chargement en mode restreint (3 demandes)", new BigDecimal("2"));
  static final CasUtilisationAlimenterArboPrestationFinancieresEnumeration[] LISTE_ENUM = { E_1, E_2 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final BigDecimal m_valeur;
  
  private CasUtilisationAlimenterArboPrestationFinancieresEnumeration(String pLibelleCourt, String pLibelleLong, BigDecimal pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private CasUtilisationAlimenterArboPrestationFinancieresEnumeration(String pLibelleCourt, BigDecimal pValeur)
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
  
  public static CasUtilisationAlimenterArboPrestationFinancieresEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    CasUtilisationAlimenterArboPrestationFinancieresEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationAlimenterArboPrestationFinancieresEnumeration getPourLibelleLong(String pLibelleLong)
  {
    CasUtilisationAlimenterArboPrestationFinancieresEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationAlimenterArboPrestationFinancieresEnumeration getPourValeur(BigDecimal pValeur)
  {
    CasUtilisationAlimenterArboPrestationFinancieresEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationAlimenterArboPrestationFinancieresEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     CasUtilisationAlimenterArboPrestationFinancieresEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */