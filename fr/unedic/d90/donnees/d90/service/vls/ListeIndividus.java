package fr.unedic.d90.donnees.d90.service.vls;

import java.util.List;

public abstract class ListeIndividus
{
  public static ListeIndividus getInstance()
  {
    return new _ListeIndividusImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract int getNbListeIndividus();
  
  public abstract int getNbListIndividu();
  
  public abstract List getListIndividu();
  
  public abstract List getListeIndividus();
  
  public abstract Individu getListeIndividus(String paramString);
  
  public abstract Individu getListeIndividus(int paramInt);
  
  public abstract Individu addListeIndividus();
  
  public abstract void addListeIndividus(Individu paramIndividu);
  
  public abstract Individu addIndividu();
  
  public abstract void addIndividu(Individu paramIndividu);
  
  public abstract void removeIndividu(String paramString);
  
  public abstract void removeIndividu(Individu paramIndividu);
}

/* Location:
 * Qualified Name:     ListeIndividus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */