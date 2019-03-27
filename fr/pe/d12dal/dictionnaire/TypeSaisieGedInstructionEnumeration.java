package fr.pe.d12dal.dictionnaire;

public final class TypeSaisieGedInstructionEnumeration
{
  public static final TypeSaisieGedInstructionEnumeration E_1 = new TypeSaisieGedInstructionEnumeration("Saisie FaÃ§onnier", "Saisie FaÃ§onnier", "1");
  public static final TypeSaisieGedInstructionEnumeration E_2 = new TypeSaisieGedInstructionEnumeration("Saisie Conseiller", "Saisie Conseiller", "2");
  public static final TypeSaisieGedInstructionEnumeration E_3 = new TypeSaisieGedInstructionEnumeration("Saisie Conseiller", "Saisie Conseiller", "3");
  static final TypeSaisieGedInstructionEnumeration[] LISTE_ENUM = { E_1, E_2, E_3 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypeSaisieGedInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypeSaisieGedInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypeSaisieGedInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypeSaisieGedInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeSaisieGedInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypeSaisieGedInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeSaisieGedInstructionEnumeration getPourValeur(String pValeur)
  {
    TypeSaisieGedInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeSaisieGedInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypeSaisieGedInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */