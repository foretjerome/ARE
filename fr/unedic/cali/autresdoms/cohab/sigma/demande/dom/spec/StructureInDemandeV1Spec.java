package fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Spec.StructureInSpec;

public abstract interface StructureInDemandeV1Spec
  extends StructureInSpec
{
  public abstract String getIdentifiantDemande();
  
  public abstract String getTypeDemande();
  
  public abstract String getIdentifiantRecherche();
  
  public abstract void setIdentifiantDemande(String paramString);
  
  public abstract void setTypeDemande(String paramString);
  
  public abstract void setIdentifiantRecherche(String paramString);
}

/* Location:
 * Qualified Name:     StructureInDemandeV1Spec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */