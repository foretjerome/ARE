package fr.unedic.d90.donnees.d90.service.vls;

import java.math.BigDecimal;

public abstract class FluxPasDnaQuantiteTravail
{
  public static FluxPasDnaQuantiteTravail getInstance()
  {
    return new _FluxPasDnaQuantiteTravailImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getUniteTravail();
  
  public abstract void setUniteTravail(String paramString);
  
  public abstract String getCodeErreurUniteTravail();
  
  public abstract void setCodeErreurUniteTravail(String paramString);
  
  public abstract BigDecimal getQuantiteTravail();
  
  public abstract void setQuantiteTravail(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurQuantiteTravail();
  
  public abstract void setCodeErreurQuantiteTravail(String paramString);
}

/* Location:
 * Qualified Name:     FluxPasDnaQuantiteTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */