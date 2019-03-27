package fr.unedic.d90.donnees.d90.service.vls;

import java.math.BigDecimal;

public abstract class FluxQuantiteTravailDsn
{
  public static FluxQuantiteTravailDsn getInstance()
  {
    return new _FluxQuantiteTravailDsnImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getUniteTempsTravail();
  
  public abstract void setUniteTempsTravail(String paramString);
  
  public abstract String getCodeErreurUniteTempsTravail();
  
  public abstract void setCodeErreurUniteTempsTravail(String paramString);
  
  public abstract BigDecimal getQuantiteTempsTravail();
  
  public abstract void setQuantiteTempsTravail(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurQuantiteTempsTravail();
  
  public abstract void setCodeErreurQuantiteTempsTravail(String paramString);
  
  public abstract String getSigneQuantiteTempsTravail();
  
  public abstract void setSigneQuantiteTempsTravail(String paramString);
  
  public abstract String getCodeErreurSigneQuantiteTempsTravail();
  
  public abstract void setCodeErreurSigneQuantiteTempsTravail(String paramString);
}

/* Location:
 * Qualified Name:     FluxQuantiteTravailDsn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */