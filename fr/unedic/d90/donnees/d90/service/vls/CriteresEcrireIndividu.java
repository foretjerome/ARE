package fr.unedic.d90.donnees.d90.service.vls;

public abstract class CriteresEcrireIndividu
{
  public static CriteresEcrireIndividu getInstance()
  {
    return new _CriteresEcrireIndividuImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract ContexteService getContexteService();
  
  public abstract void setContexteService(ContexteService paramContexteService);
  
  public abstract ContexteService setNewContexteService();
  
  public abstract ListeIndividus getListeIndividus();
  
  public abstract void setListeIndividus(ListeIndividus paramListeIndividus);
  
  public abstract ListeIndividus setNewListeIndividus();
  
  public abstract ListeParametres getListeParametres();
  
  public abstract void setListeParametres(ListeParametres paramListeParametres);
  
  public abstract ListeParametres setNewListeParametres();
}

/* Location:
 * Qualified Name:     CriteresEcrireIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */