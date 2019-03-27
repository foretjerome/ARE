package fr.unedic.d90.donnees.d90.service.vls;

import java.util.List;

public abstract class ListeFluxPasDna
{
  public static ListeFluxPasDna getInstance()
  {
    return new _ListeFluxPasDnaImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract int getNbListeFluxPasDna();
  
  public abstract int getNbListFluxPasDna();
  
  public abstract List getListFluxPasDna();
  
  public abstract List getListeFluxPasDna();
  
  public abstract FluxPasDna getListeFluxPasDna(String paramString);
  
  public abstract FluxPasDna getListeFluxPasDna(int paramInt);
  
  public abstract FluxPasDna addListeFluxPasDna();
  
  public abstract void addListeFluxPasDna(FluxPasDna paramFluxPasDna);
  
  public abstract FluxPasDna addFluxPasDna();
  
  public abstract void addFluxPasDna(FluxPasDna paramFluxPasDna);
  
  public abstract void removeFluxPasDna(String paramString);
  
  public abstract void removeFluxPasDna(FluxPasDna paramFluxPasDna);
}

/* Location:
 * Qualified Name:     ListeFluxPasDna
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */