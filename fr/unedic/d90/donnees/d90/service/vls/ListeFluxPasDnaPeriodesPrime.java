package fr.unedic.d90.donnees.d90.service.vls;

import java.util.List;

public abstract class ListeFluxPasDnaPeriodesPrime
{
  public static ListeFluxPasDnaPeriodesPrime getInstance()
  {
    return new _ListeFluxPasDnaPeriodesPrimeImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract int getNbListeFluxPasDnaPeriodesPrime();
  
  public abstract int getNbListFluxPasDnaPeriodePrime();
  
  public abstract List getListFluxPasDnaPeriodePrime();
  
  public abstract List getListeFluxPasDnaPeriodesPrime();
  
  public abstract FluxPasDnaPeriodePrime getListeFluxPasDnaPeriodesPrime(String paramString);
  
  public abstract FluxPasDnaPeriodePrime getListeFluxPasDnaPeriodesPrime(int paramInt);
  
  public abstract FluxPasDnaPeriodePrime addListeFluxPasDnaPeriodesPrime();
  
  public abstract void addListeFluxPasDnaPeriodesPrime(FluxPasDnaPeriodePrime paramFluxPasDnaPeriodePrime);
  
  public abstract FluxPasDnaPeriodePrime addFluxPasDnaPeriodePrime();
  
  public abstract void addFluxPasDnaPeriodePrime(FluxPasDnaPeriodePrime paramFluxPasDnaPeriodePrime);
  
  public abstract void removeFluxPasDnaPeriodePrime(String paramString);
  
  public abstract void removeFluxPasDnaPeriodePrime(FluxPasDnaPeriodePrime paramFluxPasDnaPeriodePrime);
}

/* Location:
 * Qualified Name:     ListeFluxPasDnaPeriodesPrime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */