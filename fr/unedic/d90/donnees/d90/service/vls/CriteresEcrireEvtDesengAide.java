package fr.unedic.d90.donnees.d90.service.vls;

public abstract class CriteresEcrireEvtDesengAide
{
  public static CriteresEcrireEvtDesengAide getInstance()
  {
    return new _CriteresEcrireEvtDesengAideImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract ContexteService getContexteService();
  
  public abstract void setContexteService(ContexteService paramContexteService);
  
  public abstract ContexteService setNewContexteService();
  
  public abstract Flux getFlux();
  
  public abstract void setFlux(Flux paramFlux);
  
  public abstract Flux setNewFlux();
  
  /**
   * @deprecated
   */
  public abstract CriteresEcrireEvtDesengAide_listeParametres getListeParametres();
  
  public abstract void setListeParametres(CriteresEcrireEvtDesengAide_listeParametres paramCriteresEcrireEvtDesengAide_listeParametres);
  
  /**
   * @deprecated
   */
  public abstract CriteresEcrireEvtDesengAide_listeParametres setNewListeParametres();
  
  public abstract CriteresEcrireEvtDesengAide_listeParametres setNewCriteresEcrireEvtDesengAide_listeParametres();
}

/* Location:
 * Qualified Name:     CriteresEcrireEvtDesengAide
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */