package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.occasionnel.outilsfonctionnels.CriteresTraitementPopulation;
import fr.unedic.cali.occasionnel.outilsfonctionnels.ResultatTraitementPopulation;

public abstract interface FacadeLiquidationGammeMntSpec
  extends FacadeLiquidationGammeSpec
{
  public abstract ResultatTraitementPopulation effectuerTraitementOccasionnel(CriteresTraitementPopulation paramCriteresTraitementPopulation)
    throws ApplicativeException;
  
  public abstract ProduitSpec determinerProduitDemandeMaintenue(DemandeSpec paramDemandeSpec);
}

/* Location:
 * Qualified Name:     FacadeLiquidationGammeMntSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */