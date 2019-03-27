package fr.unedic.d90.donnees.d90.service.vls;

import java.util.List;

public abstract class ListeIndicateurs
{
  public static ListeIndicateurs getInstance()
  {
    return new _ListeIndicateursImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract int getNbListeIndicateurs();
  
  public abstract int getNbListIndicateur();
  
  public abstract List getListIndicateur();
  
  public abstract List getListeIndicateurs();
  
  public abstract Indicateur getListeIndicateurs(String paramString);
  
  public abstract Indicateur getListeIndicateurs(int paramInt);
  
  public abstract Indicateur addListeIndicateurs();
  
  public abstract void addListeIndicateurs(Indicateur paramIndicateur);
  
  public abstract Indicateur addIndicateur();
  
  public abstract void addIndicateur(Indicateur paramIndicateur);
  
  public abstract void removeIndicateur(String paramString);
  
  public abstract void removeIndicateur(Indicateur paramIndicateur);
}

/* Location:
 * Qualified Name:     ListeIndicateurs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */