package fr.unedic.d90.donnees.d90.service.vls;

public abstract class RSOD
{
  public static RSOD getInstance()
  {
    return new _RSODImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getRSOD();
  
  public abstract void setRSOD(String paramString);
  
  public abstract String getCodeErreurRSOD();
  
  public abstract void setCodeErreurRSOD(String paramString);
}

/* Location:
 * Qualified Name:     RSOD
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */