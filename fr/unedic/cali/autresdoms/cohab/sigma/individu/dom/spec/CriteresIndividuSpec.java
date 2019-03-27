package fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.spec;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Spec.CriteresSpec;

public abstract interface CriteresIndividuSpec
  extends CriteresSpec
{
  public abstract String getNumeroAllocataire();
  
  public abstract void setNumeroAllocataire(String paramString);
}

/* Location:
 * Qualified Name:     CriteresIndividuSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */