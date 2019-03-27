package fr.pe.d12dal.service.es.dal;

public abstract class CritereLireDALCALI
{
  public static CritereLireDALCALI getInstance()
  {
    return new _CritereLireDALCALIImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
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
}

/* Location:
 * Qualified Name:     CritereLireDALCALI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */