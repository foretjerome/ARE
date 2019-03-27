package fr.pe.d12dal.dictionnaire;

public final class TypeJustificatifInstructionEnumeration
{
  public static final TypeJustificatifInstructionEnumeration E_1 = new TypeJustificatifInstructionEnumeration("PÃ©riode GAEC", "PÃ©riode GAEC", "1");
  public static final TypeJustificatifInstructionEnumeration E_2 = new TypeJustificatifInstructionEnumeration("Formation Sigma", "Formation Sigma", "2");
  public static final TypeJustificatifInstructionEnumeration E_3 = new TypeJustificatifInstructionEnumeration("Ressources", "Ressources", "3");
  static final TypeJustificatifInstructionEnumeration[] LISTE_ENUM = { E_1, E_2, E_3 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypeJustificatifInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypeJustificatifInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypeJustificatifInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypeJustificatifInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeJustificatifInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypeJustificatifInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeJustificatifInstructionEnumeration getPourValeur(String pValeur)
  {
    TypeJustificatifInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeJustificatifInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypeJustificatifInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */