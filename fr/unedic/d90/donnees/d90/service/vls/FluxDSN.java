package fr.unedic.d90.donnees.d90.service.vls;

public abstract class FluxDSN
{
  public static FluxDSN getInstance()
  {
    return new _FluxDSNImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract FluxCtPasDsn getFluxCtPasDsn();
  
  public abstract void setFluxCtPasDsn(FluxCtPasDsn paramFluxCtPasDsn);
  
  public abstract FluxCtPasDsn setNewFluxCtPasDsn();
  
  public abstract ListeFluxPrimIndemDsn getListeFluxPrimIndemDsn();
  
  /**
   * @deprecated
   */
  public abstract ListeFluxPrimIndemDsn getListeFluxPrimeIndemDsn();
  
  public abstract void setListeFluxPrimIndemDsn(ListeFluxPrimIndemDsn paramListeFluxPrimIndemDsn);
  
  public abstract void setListeFluxPrimeIndemDsn(ListeFluxPrimIndemDsn paramListeFluxPrimIndemDsn);
  
  public abstract ListeFluxPrimIndemDsn setNewListeFluxPrimIndemDsn();
  
  /**
   * @deprecated
   */
  public abstract ListeFluxPrimIndemDsn setNewListeFluxPrimeIndemDsn();
}

/* Location:
 * Qualified Name:     FluxDSN
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */