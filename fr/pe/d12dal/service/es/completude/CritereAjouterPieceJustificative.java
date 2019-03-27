package fr.pe.d12dal.service.es.completude;

import fr.pe.d12dal.dictionnaire.CasUtilisationAjouterPieceJustificativeEnumeration;

public abstract class CritereAjouterPieceJustificative
{
  public static CritereAjouterPieceJustificative getInstance()
  {
    return new _CritereAjouterPieceJustificativeImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract ContexteServiceES getContexteService();
  
  public abstract void setContexteService(ContexteServiceES paramContexteServiceES);
  
  public abstract ContexteServiceES setNewContexteServiceES();
  
  public abstract ContexteServiceES setNewContexteService();
  
  public abstract String getCxalaf();
  
  public abstract void setCxalaf(String paramString);
  
  public abstract String getCodeErreurCxalaf();
  
  public abstract void setCodeErreurCxalaf(String paramString);
  
  public abstract String getCodePE();
  
  public abstract void setCodePE(String paramString);
  
  public abstract String getCodeErreurCodePE();
  
  public abstract void setCodeErreurCodePE(String paramString);
  
  public abstract String getRefExterne();
  
  public abstract void setRefExterne(String paramString);
  
  public abstract String getCodeErreurRefExterne();
  
  public abstract void setCodeErreurRefExterne(String paramString);
  
  public abstract CasUtilisationAjouterPieceJustificativeEnumeration getEnumerationCasUtilisation();
  
  public abstract String getCasUtilisation();
  
  public abstract void setEnumerationCasUtilisation(CasUtilisationAjouterPieceJustificativeEnumeration paramCasUtilisationAjouterPieceJustificativeEnumeration);
  
  public abstract String getCodeErreurCasUtilisation();
  
  public abstract void setCodeErreurCasUtilisation(String paramString);
  
  public abstract String getIdPeriodeGAEC();
  
  public abstract void setIdPeriodeGAEC(String paramString);
  
  public abstract String getCodeErreurIdPeriodeGAEC();
  
  public abstract void setCodeErreurIdPeriodeGAEC(String paramString);
  
  public abstract String getRsin();
  
  public abstract void setRsin(String paramString);
  
  public abstract String getCodeErreurRsin();
  
  public abstract void setCodeErreurRsin(String paramString);
}

/* Location:
 * Qualified Name:     CritereAjouterPieceJustificative
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */