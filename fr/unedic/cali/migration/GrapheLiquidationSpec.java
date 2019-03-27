package fr.unedic.cali.migration;

import fr.unedic.cali.autresdoms.cohab.dom.DemandeMigreeEnErreur;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cohabitation.sigma.migration.dom.DemandeMigreeV1;
import fr.unedic.util.services.CoucheLogiqueException;

public abstract interface GrapheLiquidationSpec
{
  public abstract DemandeSpec migrerDemande(DemandeMigreeV1 paramDemandeMigreeV1, DemandeMigreeEnErreur paramDemandeMigreeEnErreur);
  
  public abstract void enregistrerDemande(DemandeMigreeV1 paramDemandeMigreeV1, DemandeSpec paramDemandeSpec, DemandeMigreeEnErreur paramDemandeMigreeEnErreur);
  
  public abstract DemandeMigreeV1 lireDonnees(DemandeSpec paramDemandeSpec);
  
  public abstract void postTraitementMigrerDemande(DemandeMigreeV1 paramDemandeMigreeV1, DemandeSpec paramDemandeSpec, DemandeMigreeEnErreur paramDemandeMigreeEnErreur)
    throws CoucheLogiqueException;
}

/* Location:
 * Qualified Name:     GrapheLiquidationSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */