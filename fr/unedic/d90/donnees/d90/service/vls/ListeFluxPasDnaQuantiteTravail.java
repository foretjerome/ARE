package fr.unedic.d90.donnees.d90.service.vls;

import java.util.List;

public abstract class ListeFluxPasDnaQuantiteTravail
{
  public static ListeFluxPasDnaQuantiteTravail getInstance()
  {
    return new _ListeFluxPasDnaQuantiteTravailImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract int getNbListeFluxPasDnaQuantiteTravail();
  
  public abstract int getNbListFluxPasDnaQuantiteTravail();
  
  public abstract List getListFluxPasDnaQuantiteTravail();
  
  public abstract List getListeFluxPasDnaQuantiteTravail();
  
  public abstract FluxPasDnaQuantiteTravail getListeFluxPasDnaQuantiteTravail(String paramString);
  
  public abstract FluxPasDnaQuantiteTravail getListeFluxPasDnaQuantiteTravail(int paramInt);
  
  public abstract FluxPasDnaQuantiteTravail addListeFluxPasDnaQuantiteTravail();
  
  public abstract void addListeFluxPasDnaQuantiteTravail(FluxPasDnaQuantiteTravail paramFluxPasDnaQuantiteTravail);
  
  public abstract FluxPasDnaQuantiteTravail addFluxPasDnaQuantiteTravail();
  
  public abstract void addFluxPasDnaQuantiteTravail(FluxPasDnaQuantiteTravail paramFluxPasDnaQuantiteTravail);
  
  public abstract void removeFluxPasDnaQuantiteTravail(String paramString);
  
  public abstract void removeFluxPasDnaQuantiteTravail(FluxPasDnaQuantiteTravail paramFluxPasDnaQuantiteTravail);
}

/* Location:
 * Qualified Name:     ListeFluxPasDnaQuantiteTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */