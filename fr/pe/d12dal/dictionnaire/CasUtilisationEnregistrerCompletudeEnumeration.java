package fr.pe.d12dal.dictionnaire;

import java.math.BigDecimal;

public final class CasUtilisationEnregistrerCompletudeEnumeration
{
  public static final CasUtilisationEnregistrerCompletudeEnumeration E_1 = new CasUtilisationEnregistrerCompletudeEnumeration("Enregistrer la complÃ©tude de la demande dans le domaine Instruction et notifier Suivi pour la prise en compte", "Enregistrer la complÃ©tude de la demande dans le domaine Instruction et notifier Suivi pour la prise en compte", new BigDecimal("1"));
  public static final CasUtilisationEnregistrerCompletudeEnumeration E_2 = new CasUtilisationEnregistrerCompletudeEnumeration("Afficher un message de confirmation de l'enregistrement en fonction de la dÃ©cision", "Afficher un message de confirmation de l'enregistrement en fonction de la dÃ©cision", new BigDecimal("2"));
  static final CasUtilisationEnregistrerCompletudeEnumeration[] LISTE_ENUM = { E_1, E_2 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final BigDecimal m_valeur;
  
  private CasUtilisationEnregistrerCompletudeEnumeration(String pLibelleCourt, String pLibelleLong, BigDecimal pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private CasUtilisationEnregistrerCompletudeEnumeration(String pLibelleCourt, BigDecimal pValeur)
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
  
  public static CasUtilisationEnregistrerCompletudeEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    CasUtilisationEnregistrerCompletudeEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationEnregistrerCompletudeEnumeration getPourLibelleLong(String pLibelleLong)
  {
    CasUtilisationEnregistrerCompletudeEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationEnregistrerCompletudeEnumeration getPourValeur(BigDecimal pValeur)
  {
    CasUtilisationEnregistrerCompletudeEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CasUtilisationEnregistrerCompletudeEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     CasUtilisationEnregistrerCompletudeEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */