package fr.unedic.d90.donnees.d90.service.vls;

import java.util.List;

public abstract class ListeFluxFctDnaIndemnitesVersees
{
  public static ListeFluxFctDnaIndemnitesVersees getInstance()
  {
    return new _ListeFluxFctDnaIndemnitesVerseesImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract int getNbListeFluxFctDnaIndemnitesVersees();
  
  public abstract int getNbListFluxFctDnaIndemniteVersee();
  
  public abstract List getListFluxFctDnaIndemniteVersee();
  
  public abstract List getListeFluxFctDnaIndemnitesVersees();
  
  public abstract FluxFctDnaIndemniteVersee getListeFluxFctDnaIndemnitesVersees(String paramString);
  
  public abstract FluxFctDnaIndemniteVersee getListeFluxFctDnaIndemnitesVersees(int paramInt);
  
  public abstract FluxFctDnaIndemniteVersee addListeFluxFctDnaIndemnitesVersees();
  
  public abstract void addListeFluxFctDnaIndemnitesVersees(FluxFctDnaIndemniteVersee paramFluxFctDnaIndemniteVersee);
  
  public abstract FluxFctDnaIndemniteVersee addFluxFctDnaIndemniteVersee();
  
  public abstract void addFluxFctDnaIndemniteVersee(FluxFctDnaIndemniteVersee paramFluxFctDnaIndemniteVersee);
  
  public abstract void removeFluxFctDnaIndemniteVersee(String paramString);
  
  public abstract void removeFluxFctDnaIndemniteVersee(FluxFctDnaIndemniteVersee paramFluxFctDnaIndemniteVersee);
}

/* Location:
 * Qualified Name:     ListeFluxFctDnaIndemnitesVersees
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */