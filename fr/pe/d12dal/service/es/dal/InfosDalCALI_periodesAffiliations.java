package fr.pe.d12dal.service.es.dal;

import java.util.List;

public abstract class InfosDalCALI_periodesAffiliations
{
  public static InfosDalCALI_periodesAffiliations getInstance()
  {
    return new _InfosDalCALI_periodesAffiliationsImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract int getNbInfosDalCALI_periodesAffiliations();
  
  public abstract int getNbListPeriodeAffiliation();
  
  public abstract List getListPeriodeAffiliation();
  
  public abstract List getPeriodesAffiliations();
  
  public abstract PeriodeAffiliation getPeriodesAffiliations(String paramString);
  
  public abstract PeriodeAffiliation getPeriodesAffiliations(int paramInt);
  
  public abstract PeriodeAffiliation addPeriodesAffiliations();
  
  public abstract void addPeriodesAffiliations(PeriodeAffiliation paramPeriodeAffiliation);
  
  public abstract PeriodeAffiliation addPeriodeAffiliation();
  
  public abstract void addPeriodeAffiliation(PeriodeAffiliation paramPeriodeAffiliation);
  
  public abstract void removePeriodeAffiliation(String paramString);
  
  public abstract void removePeriodeAffiliation(PeriodeAffiliation paramPeriodeAffiliation);
}

/* Location:
 * Qualified Name:     InfosDalCALI_periodesAffiliations
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */