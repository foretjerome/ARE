package fr.pe.d12dal.dictionnaire;

public final class CodeNoeudInstructionEnumeration
{
  public static final CodeNoeudInstructionEnumeration E_ELEMENTDECLARATIF = new CodeNoeudInstructionEnumeration("Ã©lÃ©ment dÃ©claratif", "Ã©lÃ©ment dÃ©claratif", "elementDeclaratif");
  public static final CodeNoeudInstructionEnumeration E_ELEMENTLIQUIDATIONV2 = new CodeNoeudInstructionEnumeration("Ã©lÃ©ment liquidation V2", "Ã©lÃ©ment liquidation V2", "elementLiquidationV2");
  public static final CodeNoeudInstructionEnumeration E_JUSTIFICATIF = new CodeNoeudInstructionEnumeration("justificatif", "justificatif", "justificatif");
  public static final CodeNoeudInstructionEnumeration E_DESCISIONV2 = new CodeNoeudInstructionEnumeration("descision V2", "descision V2", "descisionV2");
  public static final CodeNoeudInstructionEnumeration E_JUSTIFICATIFV2 = new CodeNoeudInstructionEnumeration("justificatif V2", "justificatif V2", "justificatifV2");
  public static final CodeNoeudInstructionEnumeration E_FINANCEMENTV2 = new CodeNoeudInstructionEnumeration("financement V2", "financement V2", "financementV2");
  static final CodeNoeudInstructionEnumeration[] LISTE_ENUM = { E_ELEMENTDECLARATIF, E_ELEMENTLIQUIDATIONV2, E_JUSTIFICATIF, E_DESCISIONV2, E_JUSTIFICATIFV2, E_FINANCEMENTV2 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private CodeNoeudInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private CodeNoeudInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static CodeNoeudInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    CodeNoeudInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CodeNoeudInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    CodeNoeudInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CodeNoeudInstructionEnumeration getPourValeur(String pValeur)
  {
    CodeNoeudInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static CodeNoeudInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     CodeNoeudInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */