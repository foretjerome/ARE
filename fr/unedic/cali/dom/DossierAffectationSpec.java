package fr.unedic.cali.dom;

import fr.unedic.cali.dom.affectation.ProduitSpec;

public abstract interface DossierAffectationSpec
  extends ObjetPersistantSpec
{
  public abstract DossierExamenSpec getDossierExamen();
  
  public abstract void setDossierExamen(DossierExamenSpec paramDossierExamenSpec);
  
  public abstract DemandeSpec getDemande();
  
  public abstract void setDemande(DemandeSpec paramDemandeSpec);
  
  public abstract ProduitSpec getProduit();
}

/* Location:
 * Qualified Name:     DossierAffectationSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */