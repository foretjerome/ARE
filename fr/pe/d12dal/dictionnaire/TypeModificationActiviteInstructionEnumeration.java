package fr.pe.d12dal.dictionnaire;

public final class TypeModificationActiviteInstructionEnumeration
{
  public static final TypeModificationActiviteInstructionEnumeration E_00 = new TypeModificationActiviteInstructionEnumeration("", "", "00");
  public static final TypeModificationActiviteInstructionEnumeration E_01 = new TypeModificationActiviteInstructionEnumeration("Modification activitÃ© salariÃ©e nÃ©cessitant une demande d'AE", "Modification activitÃ© salariÃ©e nÃ©cessitant une demande d'AE", "01");
  static final TypeModificationActiviteInstructionEnumeration[] LISTE_ENUM = { E_00, E_01 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypeModificationActiviteInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypeModificationActiviteInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypeModificationActiviteInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypeModificationActiviteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeModificationActiviteInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypeModificationActiviteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeModificationActiviteInstructionEnumeration getPourValeur(String pValeur)
  {
    TypeModificationActiviteInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeModificationActiviteInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypeModificationActiviteInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */