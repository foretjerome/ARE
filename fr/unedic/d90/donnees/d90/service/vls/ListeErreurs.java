package fr.unedic.d90.donnees.d90.service.vls;

import java.util.List;

public abstract class ListeErreurs
{
  public static ListeErreurs getInstance()
  {
    return new _ListeErreursImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract int getNbListeErreurs();
  
  public abstract int getNbListErreur();
  
  public abstract List getListErreur();
  
  public abstract List getListeErreurs();
  
  public abstract Erreur getListeErreurs(String paramString);
  
  public abstract Erreur getListeErreurs(int paramInt);
  
  public abstract Erreur addListeErreurs();
  
  public abstract void addListeErreurs(Erreur paramErreur);
  
  public abstract Erreur addErreur();
  
  public abstract void addErreur(Erreur paramErreur);
  
  public abstract void removeErreur(String paramString);
  
  public abstract void removeErreur(Erreur paramErreur);
}

/* Location:
 * Qualified Name:     ListeErreurs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */