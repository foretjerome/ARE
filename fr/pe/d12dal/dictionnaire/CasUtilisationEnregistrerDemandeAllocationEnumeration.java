package fr.pe.d12dal.dictionnaire;

import java.math.BigDecimal;

public final class CasUtilisationEnregistrerDemandeAllocationEnumeration
{
  public static final CasUtilisationEnregistrerDemandeAllocationEnumeration E_1 = new CasUtilisationEnregistrerDemandeAllocationEnumeration("Enregistrement en mode confirmation", "Enregistrement en mode confirmation", new BigDecimal("1"));
  public static final CasUtilisationEnregistrerDemandeAllocationEnumeration E_2 = new CasUtilisationEnregistrerDemandeAllocationEnumeration("Enregistrement sans confirmation", "Enregistrement sans confirmation", new BigDecimal("2"));
  static final CasUtilisationEnregistrerDemandeAllocationEnumeration[] LISTE_ENUM = { E_1, E_2 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final BigDecimal m_valeur;
  
  private CasUtilisationEnregistrerDemandeAllocationEnumeration(String pLibelleCourt, String pLibelleLong, BigDecimal pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private CasUtilisationEnregistrerDemandeAllocationEnumeration(String pLibelleCourt, BigDecimal pValeur)
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
  
  public static CasUtilisationEnregistrerDemandeAllocationEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    CasUtilisationEnregistrerDemandeAllocationEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationEnregistrerDemandeAllocationEnumeration getPourLibelleLong(String pLibelleLong)
  {
    CasUtilisationEnregistrerDemandeAllocationEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationEnregistrerDemandeAllocationEnumeration getPourValeur(BigDecimal pValeur)
  {
    CasUtilisationEnregistrerDemandeAllocationEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationEnregistrerDemandeAllocationEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     CasUtilisationEnregistrerDemandeAllocationEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */