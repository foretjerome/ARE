package fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom.spec;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Spec.CriteresSpec;
import fr.unedic.util.temps.Damj;

public abstract interface CriteresPecSpec
  extends CriteresSpec
{
  public abstract String getNumeroAllocataire();
  
  public abstract void setNumeroAllocataire(String paramString);
  
  public abstract int getIdentifiantPriseEnCharge();
  
  public abstract void setIdentifiantPriseEnCharge(int paramInt);
  
  public abstract Damj getDateRecherche();
  
  public abstract void setDateRecherche(Damj paramDamj);
}

/* Location:
 * Qualified Name:     CriteresPecSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */