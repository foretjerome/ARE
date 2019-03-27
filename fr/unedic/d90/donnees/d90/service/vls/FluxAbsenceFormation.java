package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class FluxAbsenceFormation
{
  public static FluxAbsenceFormation getInstance()
  {
    return new _FluxAbsenceFormationImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract BigDecimal getIdNationalDE();
  
  public abstract void setIdNationalDE(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurIdNationalDE();
  
  public abstract void setCodeErreurIdNationalDE(String paramString);
  
  public abstract String getIdentifiantDESurPE();
  
  public abstract void setIdentifiantDESurPE(String paramString);
  
  public abstract String getCodeErreurIdentifiantDESurPE();
  
  public abstract void setCodeErreurIdentifiantDESurPE(String paramString);
  
  public abstract String getIdentifiantPE();
  
  public abstract void setIdentifiantPE(String paramString);
  
  public abstract String getCodeErreurIdentifiantPE();
  
  public abstract void setCodeErreurIdentifiantPE(String paramString);
  
  public abstract Damj getDateTraitement();
  
  public abstract void setDateTraitement(Damj paramDamj);
  
  public abstract String getCodeErreurDateTraitement();
  
  public abstract void setCodeErreurDateTraitement(String paramString);
  
  public abstract String getMoisActualisation();
  
  public abstract void setMoisActualisation(String paramString);
  
  public abstract String getCodeErreurMoisActualisation();
  
  public abstract void setCodeErreurMoisActualisation(String paramString);
  
  public abstract BigDecimal getIdentifiantPlanFormation();
  
  public abstract void setIdentifiantPlanFormation(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurIdentifiantPlanFormation();
  
  public abstract void setCodeErreurIdentifiantPlanFormation(String paramString);
  
  public abstract BigDecimal getNbOccurrencePeriodesAbsence();
  
  public abstract void setNbOccurrencePeriodesAbsence(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNbOccurrencePeriodesAbsence();
  
  public abstract void setCodeErreurNbOccurrencePeriodesAbsence(String paramString);
  
  public abstract String getIndicateurFinListe();
  
  public abstract void setIndicateurFinListe(String paramString);
  
  public abstract String getCodeErreurIndicateurFinListe();
  
  public abstract void setCodeErreurIndicateurFinListe(String paramString);
  
  public abstract String getIndicateurPresenceRubrique();
  
  public abstract void setIndicateurPresenceRubrique(String paramString);
  
  public abstract String getCodeErreurIndicateurPresenceRubrique();
  
  public abstract void setCodeErreurIndicateurPresenceRubrique(String paramString);
  
  public abstract ListeFluxPeriodesAbsenceFormation getListeFluxPeriodesAbsenceFormation();
  
  public abstract void setListeFluxPeriodesAbsenceFormation(ListeFluxPeriodesAbsenceFormation paramListeFluxPeriodesAbsenceFormation);
  
  public abstract ListeFluxPeriodesAbsenceFormation setNewListeFluxPeriodesAbsenceFormation();
}

/* Location:
 * Qualified Name:     FluxAbsenceFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */