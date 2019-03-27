package fr.pe.d12dal.service.es.dal;

import java.util.Date;

public abstract class PeriodeAffiliation
{
  public static PeriodeAffiliation getInstance()
  {
    return new _PeriodeAffiliationImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract Date getDateDebut();
  
  public abstract void setDateDebut(Date paramDate);
  
  public abstract String getCodeErreurDateDebut();
  
  public abstract void setCodeErreurDateDebut(String paramString);
  
  public abstract Date getDateFin();
  
  public abstract void setDateFin(Date paramDate);
  
  public abstract String getCodeErreurDateFin();
  
  public abstract void setCodeErreurDateFin(String paramString);
  
  public abstract String getTopPropositionCSP();
  
  public abstract void setTopPropositionCSP(String paramString);
  
  public abstract String getCodeErreurTopPropositionCSP();
  
  public abstract void setCodeErreurTopPropositionCSP(String paramString);
  
  public abstract String getStatutDeclaration();
  
  public abstract void setStatutDeclaration(String paramString);
  
  public abstract String getCodeErreurStatutDeclaration();
  
  public abstract void setCodeErreurStatutDeclaration(String paramString);
  
  public abstract String getTopPropositionPAP();
  
  public abstract void setTopPropositionPAP(String paramString);
  
  public abstract String getCodeErreurTopPropositionPAP();
  
  public abstract void setCodeErreurTopPropositionPAP(String paramString);
}

/* Location:
 * Qualified Name:     PeriodeAffiliation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */