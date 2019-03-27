package fr.unedic.cali.dom;

import fr.unedic.util.temps.Damj;

public abstract interface DecisionSpec
  extends DossierExamenSpec
{
  public static final int ORIGINE_DECISION_ASSEDIC = 1;
  public static final int ORIGINE_DECISION_DDTE = 2;
  
  public abstract boolean estValidee();
  
  public abstract void setValidee(boolean paramBoolean);
  
  public abstract void setNatureDecision(int paramInt);
  
  public abstract int getNatureDecision();
  
  public abstract Damj getDateEffetDecision();
  
  public abstract String determinerCodeSousProduitPourSigma();
}

/* Location:
 * Qualified Name:     DecisionSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */