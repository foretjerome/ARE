package fr.unedic.d90.donnees.d90.service.vls;

import java.math.BigDecimal;

public abstract class Indicateur
{
  public static Indicateur getInstance()
  {
    return new _IndicateurImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getNom();
  
  public abstract void setNom(String paramString);
  
  public abstract String getCodeErreurNom();
  
  public abstract void setCodeErreurNom(String paramString);
  
  public abstract BigDecimal getValeur();
  
  public abstract void setValeur(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurValeur();
  
  public abstract void setCodeErreurValeur(String paramString);
}

/* Location:
 * Qualified Name:     Indicateur
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */