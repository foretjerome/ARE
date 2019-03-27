package fr.unedic.d90.donnees.d90.service.vls;

import java.util.List;

public abstract class ListeFluxQuantiteTravailDsn
{
  public static ListeFluxQuantiteTravailDsn getInstance()
  {
    return new _ListeFluxQuantiteTravailDsnImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract int getNbListeFluxQuantiteTravailDsn();
  
  public abstract int getNbListFluxQuantiteTravailDsn();
  
  public abstract List getListFluxQuantiteTravailDsn();
  
  public abstract List getListeFluxQuantiteTravailDsn();
  
  public abstract FluxQuantiteTravailDsn getListeFluxQuantiteTravailDsn(String paramString);
  
  public abstract FluxQuantiteTravailDsn getListeFluxQuantiteTravailDsn(int paramInt);
  
  public abstract FluxQuantiteTravailDsn addListeFluxQuantiteTravailDsn();
  
  public abstract void addListeFluxQuantiteTravailDsn(FluxQuantiteTravailDsn paramFluxQuantiteTravailDsn);
  
  public abstract FluxQuantiteTravailDsn addFluxQuantiteTravailDsn();
  
  public abstract void addFluxQuantiteTravailDsn(FluxQuantiteTravailDsn paramFluxQuantiteTravailDsn);
  
  public abstract void removeFluxQuantiteTravailDsn(String paramString);
  
  public abstract void removeFluxQuantiteTravailDsn(FluxQuantiteTravailDsn paramFluxQuantiteTravailDsn);
}

/* Location:
 * Qualified Name:     ListeFluxQuantiteTravailDsn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */