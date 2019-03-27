package fr.pe.d12dal.dictionnaire;

public final class TypeDemandeInstructionEnumeration
{
  public static final TypeDemandeInstructionEnumeration E_01 = new TypeDemandeInstructionEnumeration("Demande d'assurance", "Demande d'assurance", "01");
  public static final TypeDemandeInstructionEnumeration E_02 = new TypeDemandeInstructionEnumeration("Demande ATA", "Demande ATA", "02");
  public static final TypeDemandeInstructionEnumeration E_03 = new TypeDemandeInstructionEnumeration("Demande Ass", "Demande Ass", "03");
  static final TypeDemandeInstructionEnumeration[] LISTE_ENUM = { E_01, E_02, E_03 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypeDemandeInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypeDemandeInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypeDemandeInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypeDemandeInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeDemandeInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypeDemandeInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeDemandeInstructionEnumeration getPourValeur(String pValeur)
  {
    TypeDemandeInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeDemandeInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypeDemandeInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */