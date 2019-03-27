package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class FluxPasDnaPeriodePrime
{
  public static FluxPasDnaPeriodePrime getInstance()
  {
    return new _FluxPasDnaPeriodePrimeImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getNature();
  
  public abstract void setNature(String paramString);
  
  public abstract String getCodeErreurNature();
  
  public abstract void setCodeErreurNature(String paramString);
  
  public abstract String getType();
  
  public abstract void setType(String paramString);
  
  public abstract String getCodeErreurType();
  
  public abstract void setCodeErreurType(String paramString);
  
  public abstract String getIndicMontant();
  
  public abstract void setIndicMontant(String paramString);
  
  public abstract String getCodeErreurIndicMontant();
  
  public abstract void setCodeErreurIndicMontant(String paramString);
  
  public abstract Damj getDateDebutPrime();
  
  public abstract void setDateDebutPrime(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebutPrime();
  
  public abstract void setCodeErreurDateDebutPrime(String paramString);
  
  public abstract Damj getDateFinPrime();
  
  public abstract void setDateFinPrime(Damj paramDamj);
  
  public abstract String getCodeErreurDateFinPrime();
  
  public abstract void setCodeErreurDateFinPrime(String paramString);
  
  public abstract BigDecimal getMontantPrime();
  
  public abstract void setMontantPrime(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurMontantPrime();
  
  public abstract void setCodeErreurMontantPrime(String paramString);
}

/* Location:
 * Qualified Name:     FluxPasDnaPeriodePrime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */