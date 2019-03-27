package fr.pe.d12dal.dictionnaire;

public final class TypeAttributPiecesInstructionEnumeration
{
  public static final TypeAttributPiecesInstructionEnumeration E_1 = new TypeAttributPiecesInstructionEnumeration("Raison Sociale", "Raison Sociale", "1");
  public static final TypeAttributPiecesInstructionEnumeration E_2 = new TypeAttributPiecesInstructionEnumeration("Date DÃ©but", "Date DÃ©but", "2");
  public static final TypeAttributPiecesInstructionEnumeration E_3 = new TypeAttributPiecesInstructionEnumeration("Date Fin", "Date Fin", "3");
  public static final TypeAttributPiecesInstructionEnumeration E_4 = new TypeAttributPiecesInstructionEnumeration("Paragraphe", "Paragraphe", "4");
  public static final TypeAttributPiecesInstructionEnumeration E_5 = new TypeAttributPiecesInstructionEnumeration("Mois", "Mois", "5");
  public static final TypeAttributPiecesInstructionEnumeration E_6 = new TypeAttributPiecesInstructionEnumeration("Pays", "Pays", "6");
  public static final TypeAttributPiecesInstructionEnumeration E_7 = new TypeAttributPiecesInstructionEnumeration("IntitulÃ© du Stage", "IntitulÃ© du Stage", "7");
  public static final TypeAttributPiecesInstructionEnumeration E_8 = new TypeAttributPiecesInstructionEnumeration("AnnÃ©e", "AnnÃ©e", "8");
  public static final TypeAttributPiecesInstructionEnumeration E_9 = new TypeAttributPiecesInstructionEnumeration("Date Ã  compter de", "Date Ã  compter de", "9");
  public static final TypeAttributPiecesInstructionEnumeration E_10 = new TypeAttributPiecesInstructionEnumeration("Service de l'emploi", "Service de l'emploi", "10");
  public static final TypeAttributPiecesInstructionEnumeration E_11 = new TypeAttributPiecesInstructionEnumeration("Informations ComplÃ©mentaires", "Informations ComplÃ©mentaires", "11");
  static final TypeAttributPiecesInstructionEnumeration[] LISTE_ENUM = { E_1, E_2, E_3, E_4, E_5, E_6, E_7, E_8, E_9, E_10, E_11 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypeAttributPiecesInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypeAttributPiecesInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypeAttributPiecesInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypeAttributPiecesInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeAttributPiecesInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypeAttributPiecesInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeAttributPiecesInstructionEnumeration getPourValeur(String pValeur)
  {
    TypeAttributPiecesInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeAttributPiecesInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypeAttributPiecesInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */