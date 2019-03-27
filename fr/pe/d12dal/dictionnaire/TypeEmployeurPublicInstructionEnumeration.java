package fr.pe.d12dal.dictionnaire;

public final class TypeEmployeurPublicInstructionEnumeration
{
  public static final TypeEmployeurPublicInstructionEnumeration E_01 = new TypeEmployeurPublicInstructionEnumeration("Etat", "Etat", "01");
  public static final TypeEmployeurPublicInstructionEnumeration E_02 = new TypeEmployeurPublicInstructionEnumeration("CollectivitÃ© territoriale", "CollectivitÃ© territoriale", "02");
  public static final TypeEmployeurPublicInstructionEnumeration E_03 = new TypeEmployeurPublicInstructionEnumeration("Etablissement public administratif", "Etablissement public administratif", "03");
  public static final TypeEmployeurPublicInstructionEnumeration E_00 = new TypeEmployeurPublicInstructionEnumeration("", "", "00");
  static final TypeEmployeurPublicInstructionEnumeration[] LISTE_ENUM = { E_01, E_02, E_03, E_00 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypeEmployeurPublicInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypeEmployeurPublicInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypeEmployeurPublicInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypeEmployeurPublicInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeEmployeurPublicInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypeEmployeurPublicInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeEmployeurPublicInstructionEnumeration getPourValeur(String pValeur)
  {
    TypeEmployeurPublicInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeEmployeurPublicInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypeEmployeurPublicInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */