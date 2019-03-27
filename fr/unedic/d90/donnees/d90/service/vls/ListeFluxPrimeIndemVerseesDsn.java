package fr.unedic.d90.donnees.d90.service.vls;

import java.util.List;

public abstract class ListeFluxPrimeIndemVerseesDsn
{
  public static ListeFluxPrimeIndemVerseesDsn getInstance()
  {
    return new _ListeFluxPrimeIndemVerseesDsnImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract int getNbListeFluxPrimeIndemVerseesDsn();
  
  public abstract int getNbListFluxPrimesIndemVerseesDsn();
  
  public abstract List getListFluxPrimesIndemVerseesDsn();
  
  public abstract List getListeFluxPrimIndemVerseesDsn();
  
  public abstract FluxPrimesIndemVerseesDsn getListeFluxPrimeIndemVerseesDsn(String paramString);
  
  public abstract FluxPrimesIndemVerseesDsn getListeFluxPrimeIndemVerseesDsn(int paramInt);
  
  public abstract FluxPrimesIndemVerseesDsn addListeFluxPrimeIndemVerseesDsn();
  
  public abstract void addListeFluxPrimeIndemVerseesDsn(FluxPrimesIndemVerseesDsn paramFluxPrimesIndemVerseesDsn);
  
  public abstract FluxPrimesIndemVerseesDsn addFluxPrimesIndemVerseesDsn();
  
  public abstract void addFluxPrimesIndemVerseesDsn(FluxPrimesIndemVerseesDsn paramFluxPrimesIndemVerseesDsn);
  
  public abstract void removeFluxPrimesIndemVerseesDsn(String paramString);
  
  public abstract void removeFluxPrimesIndemVerseesDsn(FluxPrimesIndemVerseesDsn paramFluxPrimesIndemVerseesDsn);
}

/* Location:
 * Qualified Name:     ListeFluxPrimeIndemVerseesDsn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */