package fr.unedic.d90.donnees.d90.service.vls;

import java.util.List;

public abstract class ListeFluxPrimIndemDsn
{
  public static ListeFluxPrimIndemDsn getInstance()
  {
    return new _ListeFluxPrimIndemDsnImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract int getNbListeFluxPrimIndemDsn();
  
  public abstract int getNbListFluxPrimeIndemDsn();
  
  public abstract List getListFluxPrimeIndemDsn();
  
  public abstract List getListeFluxPrimeIndemDsn();
  
  public abstract FluxPrimeIndemDsn getListeFluxPrimIndemDsn(String paramString);
  
  public abstract FluxPrimeIndemDsn getListeFluxPrimIndemDsn(int paramInt);
  
  public abstract FluxPrimeIndemDsn addListeFluxPrimIndemDsn();
  
  public abstract void addListeFluxPrimIndemDsn(FluxPrimeIndemDsn paramFluxPrimeIndemDsn);
  
  public abstract FluxPrimeIndemDsn addFluxPrimeIndemDsn();
  
  public abstract void addFluxPrimeIndemDsn(FluxPrimeIndemDsn paramFluxPrimeIndemDsn);
  
  public abstract void removeFluxPrimeIndemDsn(String paramString);
  
  public abstract void removeFluxPrimeIndemDsn(FluxPrimeIndemDsn paramFluxPrimeIndemDsn);
}

/* Location:
 * Qualified Name:     ListeFluxPrimIndemDsn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */