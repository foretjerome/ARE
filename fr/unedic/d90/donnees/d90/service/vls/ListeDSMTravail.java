package fr.unedic.d90.donnees.d90.service.vls;

import java.util.List;

public abstract class ListeDSMTravail
{
  public static ListeDSMTravail getInstance()
  {
    return new _ListeDSMTravailImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract int getNbListeDSMTravail();
  
  public abstract int getNbListDsmTravail();
  
  public abstract List getListDsmTravail();
  
  public abstract List getListeDSMTravail();
  
  public abstract DsmTravail getListeDSMTravail(String paramString);
  
  public abstract DsmTravail getListeDSMTravail(int paramInt);
  
  public abstract DsmTravail addListeDSMTravail();
  
  public abstract void addListeDSMTravail(DsmTravail paramDsmTravail);
  
  public abstract DsmTravail addDsmTravail();
  
  public abstract void addDsmTravail(DsmTravail paramDsmTravail);
  
  public abstract void removeDsmTravail(String paramString);
  
  public abstract void removeDsmTravail(DsmTravail paramDsmTravail);
}

/* Location:
 * Qualified Name:     ListeDSMTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */