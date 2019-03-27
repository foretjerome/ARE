package fr.unedic.d90.donnees.d90.service.vls;

public abstract class CriteresEcrireODF
{
  public static CriteresEcrireODF getInstance()
  {
    return new _CriteresEcrireODFImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract ContexteService getContexteService();
  
  public abstract void setContexteService(ContexteService paramContexteService);
  
  public abstract ContexteService setNewContexteService();
  
  public abstract ListeRSOD getListeRSOD();
  
  public abstract void setListeRSOD(ListeRSOD paramListeRSOD);
  
  public abstract ListeRSOD setNewListeRSOD();
}

/* Location:
 * Qualified Name:     CriteresEcrireODF
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */