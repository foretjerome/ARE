package fr.unedic.d90.donnees.d90.service.vls;

import java.math.BigDecimal;

public abstract class Erreur
{
  public static Erreur getInstance()
  {
    return new _ErreurImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getCode();
  
  public abstract void setCode(String paramString);
  
  public abstract String getCodeErreurCode();
  
  public abstract void setCodeErreurCode(String paramString);
  
  public abstract String getLibelle();
  
  public abstract void setLibelle(String paramString);
  
  public abstract String getCodeErreurLibelle();
  
  public abstract void setCodeErreurLibelle(String paramString);
  
  public abstract String getItem();
  
  public abstract void setItem(String paramString);
  
  public abstract String getCodeErreurItem();
  
  public abstract void setCodeErreurItem(String paramString);
  
  public abstract String getParametres();
  
  public abstract void setParametres(String paramString);
  
  public abstract String getCodeErreurParametres();
  
  public abstract void setCodeErreurParametres(String paramString);
  
  public abstract BigDecimal getNiveau();
  
  public abstract void setNiveau(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNiveau();
  
  public abstract void setCodeErreurNiveau(String paramString);
}

/* Location:
 * Qualified Name:     Erreur
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */