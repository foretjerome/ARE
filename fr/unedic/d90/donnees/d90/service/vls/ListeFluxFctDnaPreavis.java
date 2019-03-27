package fr.unedic.d90.donnees.d90.service.vls;

import java.util.List;

public abstract class ListeFluxFctDnaPreavis
{
  public static ListeFluxFctDnaPreavis getInstance()
  {
    return new _ListeFluxFctDnaPreavisImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract int getNbListeFluxFctDnaPreavis();
  
  public abstract int getNbListFluxFctDnaPreavis();
  
  public abstract List getListFluxFctDnaPreavis();
  
  public abstract List getListeFluxFctDnaPreavis();
  
  public abstract FluxFctDnaPreavis getListeFluxFctDnaPreavis(String paramString);
  
  public abstract FluxFctDnaPreavis getListeFluxFctDnaPreavis(int paramInt);
  
  public abstract FluxFctDnaPreavis addListeFluxFctDnaPreavis();
  
  public abstract void addListeFluxFctDnaPreavis(FluxFctDnaPreavis paramFluxFctDnaPreavis);
  
  public abstract FluxFctDnaPreavis addFluxFctDnaPreavis();
  
  public abstract void addFluxFctDnaPreavis(FluxFctDnaPreavis paramFluxFctDnaPreavis);
  
  public abstract void removeFluxFctDnaPreavis(String paramString);
  
  public abstract void removeFluxFctDnaPreavis(FluxFctDnaPreavis paramFluxFctDnaPreavis);
}

/* Location:
 * Qualified Name:     ListeFluxFctDnaPreavis
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */