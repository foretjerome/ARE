package fr.unedic.d90.donnees.d90.service.vls;

import java.util.List;

public abstract class ListeRSOD
{
  public static ListeRSOD getInstance()
  {
    return new _ListeRSODImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract int getNbListeRSOD();
  
  public abstract int getNbListRSOD();
  
  public abstract List getListRSOD();
  
  public abstract List getListeRSOD();
  
  public abstract RSOD getListeRSOD(String paramString);
  
  public abstract RSOD getListeRSOD(int paramInt);
  
  public abstract RSOD addListeRSOD();
  
  public abstract void addListeRSOD(RSOD paramRSOD);
  
  public abstract RSOD addRSOD();
  
  public abstract void addRSOD(RSOD paramRSOD);
  
  public abstract void removeRSOD(String paramString);
  
  public abstract void removeRSOD(RSOD paramRSOD);
}

/* Location:
 * Qualified Name:     ListeRSOD
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */