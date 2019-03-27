package fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.spec;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Spec.CriteresSpec;

public abstract interface CriteresPensionSpec
  extends CriteresSpec
{
  public abstract String getNumeroAllocataire();
  
  public abstract void setNumeroAllocataire(String paramString);
}

/* Location:
 * Qualified Name:     CriteresPensionSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */