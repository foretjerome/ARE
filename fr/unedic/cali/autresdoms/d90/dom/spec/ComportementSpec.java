package fr.unedic.cali.autresdoms.d90.dom.spec;

import fr.unedic.cali.utilitaire.decideur.spec.DecideurDecisionSpec;

public abstract interface ComportementSpec
{
  public static final String REEXAMINER_DECISION_MIGREES = "R";
  public static final String REMISE_EN_CAUSE_DECISION_MIGREES = "C";
  public static final String RECONDUCTION_DECISION_MIGREES = "D";
  
  public abstract String getIdentifiantComportement();
  
  public abstract String getLibelleComportement();
  
  public abstract boolean isApplicationSurPremiereDecision();
  
  public abstract boolean isReexucutionDecisionMigrees();
  
  public abstract String getRexamenDecisionMigrees();
  
  public abstract String getTypeMandatement();
  
  public abstract boolean isEcrireEnBaseVisu();
  
  public abstract boolean isUtilise();
  
  public abstract void setUtilise(boolean paramBoolean);
  
  public abstract boolean isReexamenAlertesNonBloquantes();
  
  public abstract boolean isComparerBasesPivotsEchanges();
  
  public abstract DecideurDecisionSpec getDecideur();
  
  public abstract ComportementSpec getComportementSansReexamenAuto();
}

/* Location:
 * Qualified Name:     ComportementSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */