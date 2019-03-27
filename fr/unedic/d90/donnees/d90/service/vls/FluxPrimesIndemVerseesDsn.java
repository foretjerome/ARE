package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class FluxPrimesIndemVerseesDsn
{
  public static FluxPrimesIndemVerseesDsn getInstance()
  {
    return new _FluxPrimesIndemVerseesDsnImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getTypePrimeIndem();
  
  public abstract void setTypePrimeIndem(String paramString);
  
  public abstract String getCodeErreurTypePrimeIndem();
  
  public abstract void setCodeErreurTypePrimeIndem(String paramString);
  
  public abstract String getSigneMtantPrimeIndem();
  
  public abstract void setSigneMtantPrimeIndem(String paramString);
  
  public abstract String getCodeErreurSigneMtantPrimeIndem();
  
  public abstract void setCodeErreurSigneMtantPrimeIndem(String paramString);
  
  public abstract BigDecimal getMontantPrimeIndem();
  
  public abstract void setMontantPrimeIndem(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurMontantPrimeIndem();
  
  public abstract void setCodeErreurMontantPrimeIndem(String paramString);
  
  public abstract Damj getDateDebutPrime();
  
  public abstract void setDateDebutPrime(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebutPrime();
  
  public abstract void setCodeErreurDateDebutPrime(String paramString);
  
  public abstract Damj getDateFinPrime();
  
  public abstract void setDateFinPrime(Damj paramDamj);
  
  public abstract String getCodeErreurDateFinPrime();
  
  public abstract void setCodeErreurDateFinPrime(String paramString);
  
  public abstract Damj getDatePaiement();
  
  public abstract void setDatePaiement(Damj paramDamj);
  
  public abstract String getCodeErreurDatePaiement();
  
  public abstract void setCodeErreurDatePaiement(String paramString);
}

/* Location:
 * Qualified Name:     FluxPrimesIndemVerseesDsn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */