package fr.unedic.d90.donnees.d90.service.vls;

public abstract class CriteresEcrireEvenementAsynchrone
{
  public static CriteresEcrireEvenementAsynchrone getInstance()
  {
    return new _CriteresEcrireEvenementAsynchroneImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract ContexteService getContexteService();
  
  public abstract void setContexteService(ContexteService paramContexteService);
  
  public abstract ContexteService setNewContexteService();
  
  public abstract ListeParametres getListeParametres();
  
  public abstract void setListeParametres(ListeParametres paramListeParametres);
  
  public abstract ListeParametres setNewListeParametres();
  
  public abstract Flux getFlux();
  
  public abstract void setFlux(Flux paramFlux);
  
  public abstract Flux setNewFlux();
}

/* Location:
 * Qualified Name:     CriteresEcrireEvenementAsynchrone
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */