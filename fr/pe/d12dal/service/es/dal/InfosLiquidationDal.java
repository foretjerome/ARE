package fr.pe.d12dal.service.es.dal;

public abstract class InfosLiquidationDal
{
  public static InfosLiquidationDal getInstance()
  {
    return new _InfosLiquidationDalImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract Boolean getTopPresenceFormation();
  
  public abstract void setTopPresenceFormation(Boolean paramBoolean);
  
  public abstract String getCodeErreurTopPresenceFormation();
  
  public abstract void setCodeErreurTopPresenceFormation(String paramString);
  
  public abstract Boolean getTopDemandeLiquidable();
  
  public abstract void setTopDemandeLiquidable(Boolean paramBoolean);
  
  public abstract String getCodeErreurTopDemandeLiquidable();
  
  public abstract void setCodeErreurTopDemandeLiquidable(String paramString);
  
  public abstract Boolean getTopDemandeComplete();
  
  public abstract void setTopDemandeComplete(Boolean paramBoolean);
  
  public abstract String getCodeErreurTopDemandeComplete();
  
  public abstract void setCodeErreurTopDemandeComplete(String paramString);
  
  public abstract Boolean getTopLiquidationAuto();
  
  public abstract void setTopLiquidationAuto(Boolean paramBoolean);
  
  public abstract String getCodeErreurTopLiquidationAuto();
  
  public abstract void setCodeErreurTopLiquidationAuto(String paramString);
  
  public abstract Boolean getTopDemandeWebKO();
  
  public abstract void setTopDemandeWebKO(Boolean paramBoolean);
  
  public abstract String getCodeErreurTopDemandeWebKO();
  
  public abstract void setCodeErreurTopDemandeWebKO(String paramString);
  
  public abstract Boolean getTopLiquidationStandardAuto();
  
  public abstract void setTopLiquidationStandardAuto(Boolean paramBoolean);
  
  public abstract String getCodeErreurTopLiquidationStandardAuto();
  
  public abstract void setCodeErreurTopLiquidationStandardAuto(String paramString);
}

/* Location:
 * Qualified Name:     InfosLiquidationDal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */