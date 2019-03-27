package fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec;

import java.util.Collection;

public abstract interface StructureOutDemandeV1Spec
{
  public abstract void ajouterDemande(DemandeV1Spec paramDemandeV1Spec);
  
  public abstract Collection getListeDemandes();
}

/* Location:
 * Qualified Name:     StructureOutDemandeV1Spec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */