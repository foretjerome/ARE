package fr.unedic.d90.donnees.d90.service.vls;

public abstract class Parametre
{
  public static Parametre getInstance()
  {
    return new _ParametreImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getId();
  
  public abstract void setId(String paramString);
  
  public abstract String getCodeErreurId();
  
  public abstract void setCodeErreurId(String paramString);
  
  public abstract String getValeur();
  
  public abstract void setValeur(String paramString);
  
  public abstract String getCodeErreurValeur();
  
  public abstract void setCodeErreurValeur(String paramString);
}

/* Location:
 * Qualified Name:     Parametre
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */