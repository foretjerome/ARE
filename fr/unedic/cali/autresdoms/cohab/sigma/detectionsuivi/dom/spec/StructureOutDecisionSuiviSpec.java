package fr.unedic.cali.autresdoms.cohab.sigma.detectionsuivi.dom.spec;

import java.util.Collection;

public abstract interface StructureOutDecisionSuiviSpec
{
  public abstract Collection getListeDecisionsSuivi();
  
  public abstract void ajouterDecision(DecisionSuiviSpec paramDecisionSuiviSpec);
}

/* Location:
 * Qualified Name:     StructureOutDecisionSuiviSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */