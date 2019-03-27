package fr.pe.d12dal.dictionnaire;

public final class CasUtilisationLireDemandeAllocationEnumeration
{
  public static final CasUtilisationLireDemandeAllocationEnumeration E_1 = new CasUtilisationLireDemandeAllocationEnumeration("Lire la demande allocation", "Lire la demande allocation", "1");
  static final CasUtilisationLireDemandeAllocationEnumeration[] LISTE_ENUM = { E_1 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private CasUtilisationLireDemandeAllocationEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private CasUtilisationLireDemandeAllocationEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static CasUtilisationLireDemandeAllocationEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    CasUtilisationLireDemandeAllocationEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationLireDemandeAllocationEnumeration getPourLibelleLong(String pLibelleLong)
  {
    CasUtilisationLireDemandeAllocationEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationLireDemandeAllocationEnumeration getPourValeur(String pValeur)
  {
    CasUtilisationLireDemandeAllocationEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationLireDemandeAllocationEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     CasUtilisationLireDemandeAllocationEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */