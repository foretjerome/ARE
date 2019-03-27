package fr.pe.d12dal.dictionnaire;

import java.math.BigDecimal;

public final class CasUtilisationRechercherDemandeParMultiCriteresEnumeration
{
  public static final CasUtilisationRechercherDemandeParMultiCriteresEnumeration E_1 = new CasUtilisationRechercherDemandeParMultiCriteresEnumeration("recherche demande par multicriteres", "recherche demande par multicriteres", new BigDecimal("1"));
  static final CasUtilisationRechercherDemandeParMultiCriteresEnumeration[] LISTE_ENUM = { E_1 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final BigDecimal m_valeur;
  
  private CasUtilisationRechercherDemandeParMultiCriteresEnumeration(String pLibelleCourt, String pLibelleLong, BigDecimal pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private CasUtilisationRechercherDemandeParMultiCriteresEnumeration(String pLibelleCourt, BigDecimal pValeur)
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
  
  public static CasUtilisationRechercherDemandeParMultiCriteresEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    CasUtilisationRechercherDemandeParMultiCriteresEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationRechercherDemandeParMultiCriteresEnumeration getPourLibelleLong(String pLibelleLong)
  {
    CasUtilisationRechercherDemandeParMultiCriteresEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationRechercherDemandeParMultiCriteresEnumeration getPourValeur(BigDecimal pValeur)
  {
    CasUtilisationRechercherDemandeParMultiCriteresEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationRechercherDemandeParMultiCriteresEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     CasUtilisationRechercherDemandeParMultiCriteresEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */