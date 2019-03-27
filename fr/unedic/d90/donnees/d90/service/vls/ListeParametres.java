package fr.unedic.d90.donnees.d90.service.vls;

import java.util.List;

public abstract class ListeParametres
{
  public static ListeParametres getInstance()
  {
    return new _ListeParametresImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract int getNbListeParametres();
  
  public abstract int getNbListParametre();
  
  public abstract List getListParametre();
  
  public abstract List getListeParametres();
  
  public abstract Parametre getListeParametres(String paramString);
  
  public abstract Parametre getListeParametres(int paramInt);
  
  public abstract Parametre addListeParametres();
  
  public abstract void addListeParametres(Parametre paramParametre);
  
  public abstract Parametre addParametre();
  
  public abstract void addParametre(Parametre paramParametre);
  
  public abstract void removeParametre(String paramString);
  
  public abstract void removeParametre(Parametre paramParametre);
}

/* Location:
 * Qualified Name:     ListeParametres
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */