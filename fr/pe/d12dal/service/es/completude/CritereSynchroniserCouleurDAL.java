package fr.pe.d12dal.service.es.completude;

import fr.pe.d12dal.dictionnaire.CasUtilisationSynchroniserCouleurDALEnumeration;

public abstract class CritereSynchroniserCouleurDAL
{
  public static CritereSynchroniserCouleurDAL getInstance()
  {
    return new _CritereSynchroniserCouleurDALImpl();
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
  
  public abstract CasUtilisationSynchroniserCouleurDALEnumeration getEnumerationCasUtilisation();
  
  public abstract String getCasUtilisation();
  
  public abstract void setEnumerationCasUtilisation(CasUtilisationSynchroniserCouleurDALEnumeration paramCasUtilisationSynchroniserCouleurDALEnumeration);
  
  public abstract String getCodeErreurCasUtilisation();
  
  public abstract void setCodeErreurCasUtilisation(String paramString);
  
  public abstract String getRefExterne();
  
  public abstract void setRefExterne(String paramString);
  
  public abstract String getCodeErreurRefExterne();
  
  public abstract void setCodeErreurRefExterne(String paramString);
  
  public abstract String getTypeAttente();
  
  public abstract void setTypeAttente(String paramString);
  
  public abstract String getCodeErreurTypeAttente();
  
  public abstract void setCodeErreurTypeAttente(String paramString);
}

/* Location:
 * Qualified Name:     CritereSynchroniserCouleurDAL
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */