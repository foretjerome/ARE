package fr.pe.d12dal.service.es.dal;

import java.util.List;

public abstract class RetourLireDALCALI_listeInfosDALCALI
{
  public static RetourLireDALCALI_listeInfosDALCALI getInstance()
  {
    return new _RetourLireDALCALI_listeInfosDALCALIImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract int getNbRetourLireDALCALI_listeInfosDALCALI();
  
  public abstract int getNbListInfosDalCALI();
  
  public abstract List getListInfosDalCALI();
  
  public abstract List getListeInfosDALCALI();
  
  public abstract InfosDalCALI getListeInfosDALCALI(String paramString);
  
  public abstract InfosDalCALI getListeInfosDALCALI(int paramInt);
  
  public abstract InfosDalCALI addListeInfosDALCALI();
  
  public abstract void addListeInfosDALCALI(InfosDalCALI paramInfosDalCALI);
  
  public abstract InfosDalCALI addInfosDalCALI();
  
  public abstract void addInfosDalCALI(InfosDalCALI paramInfosDalCALI);
  
  public abstract void removeInfosDalCALI(String paramString);
  
  public abstract void removeInfosDalCALI(InfosDalCALI paramInfosDalCALI);
}

/* Location:
 * Qualified Name:     RetourLireDALCALI_listeInfosDALCALI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */