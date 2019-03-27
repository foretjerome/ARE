package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.Damj;
import java.util.Collection;

public abstract interface FacadeLiquidationGammeRbfSpec
  extends FacadeLiquidationGammeSpec
{
  public abstract Collection<ProduitSpec> getProduits(DemandeSpec paramDemandeSpec);
  
  public abstract String getIdActionFormationLiee(DemandeSpec paramDemandeSpec);
  
  public abstract String getIdActiviteSalarieeLiee(DemandeSpec paramDemandeSpec);
  
  public abstract Damj getDateMinAttibutions(DemandeSpec paramDemandeSpec);
  
  public abstract Damj recupererDateDepotDemandeDepuisReferenceExt(String paramString);
}

/* Location:
 * Qualified Name:     FacadeLiquidationGammeRbfSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */