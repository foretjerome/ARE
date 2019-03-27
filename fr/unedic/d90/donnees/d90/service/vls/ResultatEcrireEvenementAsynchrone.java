package fr.unedic.d90.donnees.d90.service.vls;

public abstract class ResultatEcrireEvenementAsynchrone
{
  public static ResultatEcrireEvenementAsynchrone getInstance()
  {
    return new _ResultatEcrireEvenementAsynchroneImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract ResultatService getResultatService();
  
  public abstract void setResultatService(ResultatService paramResultatService);
  
  public abstract ResultatService setNewResultatService();
}

/* Location:
 * Qualified Name:     ResultatEcrireEvenementAsynchrone
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */