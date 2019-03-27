package fr.pe.d12dal.dictionnaire;

public final class TypeModificationWEBInstructionEnumeration
{
  public static final TypeModificationWEBInstructionEnumeration E_1 = new TypeModificationWEBInstructionEnumeration("Initiale", "Initiale", "1");
  public static final TypeModificationWEBInstructionEnumeration E_2 = new TypeModificationWEBInstructionEnumeration("Suppression", "Suppression", "2");
  public static final TypeModificationWEBInstructionEnumeration E_3 = new TypeModificationWEBInstructionEnumeration("Modification", "Modification", "3");
  public static final TypeModificationWEBInstructionEnumeration E_0 = new TypeModificationWEBInstructionEnumeration("", "", "0");
  static final TypeModificationWEBInstructionEnumeration[] LISTE_ENUM = { E_1, E_2, E_3, E_0 };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypeModificationWEBInstructionEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypeModificationWEBInstructionEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypeModificationWEBInstructionEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypeModificationWEBInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeModificationWEBInstructionEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypeModificationWEBInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeModificationWEBInstructionEnumeration getPourValeur(String pValeur)
  {
    TypeModificationWEBInstructionEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeModificationWEBInstructionEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypeModificationWEBInstructionEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */