package fr.pe.d12dal.dictionnaire;

public final class TypeAppelBPMEnumeration
{
  public static final TypeAppelBPMEnumeration E_INSTALLATIONDAL = new TypeAppelBPMEnumeration("installationDAL", "installationDAL", "installationDAL");
  public static final TypeAppelBPMEnumeration E_COMPLETUDEDAL = new TypeAppelBPMEnumeration("completudeDAL", "completudeDAL", "completudeDAL");
  public static final TypeAppelBPMEnumeration E_ENREGISTREMENTDAL = new TypeAppelBPMEnumeration("enregistrementDAL", "enregistrementDAL", "enregistrementDAL");
  public static final TypeAppelBPMEnumeration E_PIECEDALGENERIQUE = new TypeAppelBPMEnumeration("pieceDalGenerique", "pieceDalGenerique", "pieceDalGenerique");
  static final TypeAppelBPMEnumeration[] LISTE_ENUM = { E_INSTALLATIONDAL, E_COMPLETUDEDAL, E_ENREGISTREMENTDAL, E_PIECEDALGENERIQUE };
  final String m_libelleCourt;
  final String m_libelleLong;
  final String m_valeur;
  
  private TypeAppelBPMEnumeration(String pLibelleCourt, String pLibelleLong, String pValeur)
  {
    m_libelleCourt = pLibelleCourt;
    m_libelleLong = pLibelleLong;
    m_valeur = pValeur;
  }
  
  private TypeAppelBPMEnumeration(String pLibelleCourt, String pValeur)
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
  
  public static TypeAppelBPMEnumeration getPourLibelleCourt(String pLibelleCourt)
  {
    TypeAppelBPMEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleCourt().equals(pLibelleCourt)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeAppelBPMEnumeration getPourLibelleLong(String pLibelleLong)
  {
    TypeAppelBPMEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getLibelleLong().equals(pLibelleLong)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeAppelBPMEnumeration getPourValeur(String pValeur)
  {
    TypeAppelBPMEnumeration retour = null;
    for (int i = 0; (retour == null) && (i < LISTE_ENUM.length); i++) {
      if (LISTE_ENUM[i].getValeur().equals(pValeur)) {
        retour = LISTE_ENUM[i];
      }
    }
    return retour;
  }
  
  public static TypeAppelBPMEnumeration[] getAll()
  {
    return LISTE_ENUM;
  }
}

/* Location:
 * Qualified Name:     TypeAppelBPMEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */