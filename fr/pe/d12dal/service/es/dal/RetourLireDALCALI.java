package fr.pe.d12dal.service.es.dal;

public abstract class RetourLireDALCALI
{
  public static RetourLireDALCALI getInstance()
  {
    return new _RetourLireDALCALIImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract RetourLireDALCALI_listeInfosDALCALI getListeInfosDALCALI();
  
  public abstract void setListeInfosDALCALI(RetourLireDALCALI_listeInfosDALCALI paramRetourLireDALCALI_listeInfosDALCALI);
  
  public abstract RetourLireDALCALI_listeInfosDALCALI setNewRetourLireDALCALI_listeInfosDALCALI();
  
  /**
   * @deprecated
   */
  public abstract RetourLireDALCALI_listeInfosDALCALI setNewListeInfosDALCALI();
}

/* Location:
 * Qualified Name:     RetourLireDALCALI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */