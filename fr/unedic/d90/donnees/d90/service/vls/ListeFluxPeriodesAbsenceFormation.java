package fr.unedic.d90.donnees.d90.service.vls;

import java.util.List;

public abstract class ListeFluxPeriodesAbsenceFormation
{
  public static ListeFluxPeriodesAbsenceFormation getInstance()
  {
    return new _ListeFluxPeriodesAbsenceFormationImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract int getNbListeFluxPeriodesAbsenceFormation();
  
  public abstract int getNbListFluxPeriodeAbsenceFormation();
  
  public abstract List getListFluxPeriodeAbsenceFormation();
  
  public abstract List getListeFluxPeriodesAbsenceFormation();
  
  public abstract FluxPeriodeAbsenceFormation getListeFluxPeriodesAbsenceFormation(String paramString);
  
  public abstract FluxPeriodeAbsenceFormation getListeFluxPeriodesAbsenceFormation(int paramInt);
  
  public abstract FluxPeriodeAbsenceFormation addListeFluxPeriodesAbsenceFormation();
  
  public abstract void addListeFluxPeriodesAbsenceFormation(FluxPeriodeAbsenceFormation paramFluxPeriodeAbsenceFormation);
  
  public abstract FluxPeriodeAbsenceFormation addFluxPeriodeAbsenceFormation();
  
  public abstract void addFluxPeriodeAbsenceFormation(FluxPeriodeAbsenceFormation paramFluxPeriodeAbsenceFormation);
  
  public abstract void removeFluxPeriodeAbsenceFormation(String paramString);
  
  public abstract void removeFluxPeriodeAbsenceFormation(FluxPeriodeAbsenceFormation paramFluxPeriodeAbsenceFormation);
}

/* Location:
 * Qualified Name:     ListeFluxPeriodesAbsenceFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */