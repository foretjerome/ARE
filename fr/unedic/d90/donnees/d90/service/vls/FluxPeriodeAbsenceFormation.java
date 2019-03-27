package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;

public abstract class FluxPeriodeAbsenceFormation
{
  public static FluxPeriodeAbsenceFormation getInstance()
  {
    return new _FluxPeriodeAbsenceFormationImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract Damj getDateDebutAbsence();
  
  public abstract void setDateDebutAbsence(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebutAbsence();
  
  public abstract void setCodeErreurDateDebutAbsence(String paramString);
  
  public abstract Damj getDateFinAbsence();
  
  public abstract void setDateFinAbsence(Damj paramDamj);
  
  public abstract String getCodeErreurDateFinAbsence();
  
  public abstract void setCodeErreurDateFinAbsence(String paramString);
  
  public abstract String getCodeAction();
  
  public abstract void setCodeAction(String paramString);
  
  public abstract String getCodeErreurCodeAction();
  
  public abstract void setCodeErreurCodeAction(String paramString);
  
  public abstract String getMotifAbsence();
  
  public abstract void setMotifAbsence(String paramString);
  
  public abstract String getCodeErreurMotifAbsence();
  
  public abstract void setCodeErreurMotifAbsence(String paramString);
}

/* Location:
 * Qualified Name:     FluxPeriodeAbsenceFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */