package fr.unedic.cali.autresdoms.cohab.sigma.ressource.dom.spec;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Spec.CriteresSpec;

public abstract interface CriteresRessourcesSpec
  extends CriteresSpec
{
  public abstract String getNumeroAllocataire();
  
  public abstract void setNumeroAllocataire(String paramString);
  
  public abstract String getIdentifiantDemande();
  
  public abstract void setIdentifiantDemande(String paramString);
  
  public abstract void setTypeSegment(String paramString);
  
  public abstract String getTypeSegmentV1();
}

/* Location:
 * Qualified Name:     CriteresRessourcesSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */