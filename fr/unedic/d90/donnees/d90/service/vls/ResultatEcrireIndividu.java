package fr.unedic.d90.donnees.d90.service.vls;

public abstract class ResultatEcrireIndividu
{
  public static ResultatEcrireIndividu getInstance()
  {
    return new _ResultatEcrireIndividuImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
}

/* Location:
 * Qualified Name:     ResultatEcrireIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */