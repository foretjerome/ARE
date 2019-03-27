package fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.spec;

import java.io.Serializable;

public abstract interface EnveloppeAidesSpec
  extends Serializable
{
  public static final int ENVELOPPE_AIDE_STATUT_PREVISIONNEL = 0;
  public static final int ENVELOPPE_AIDE_STATUT_EFFECTIF = 1;
  public static final int ENVELOPPE_AIDE_STATUT_NON_RENSEIGNE = 9;
  
  public abstract boolean isEngagementPossible();
  
  public abstract void setEngagementPossible(boolean paramBoolean);
  
  public abstract boolean isMontantDisponibleInsuffisant();
  
  public abstract void setMontantDisponibleInsuffisant(boolean paramBoolean);
  
  public abstract String getMotifImpossibiliteEngagement();
  
  public abstract void setMotifImpossibiliteEngagement(String paramString);
}

/* Location:
 * Qualified Name:     EnveloppeAidesSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */