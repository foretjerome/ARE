package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.Damj;

public abstract interface ProduitAvecEpuisementSpec
{
  public abstract Damj recupererDJIParEpuisement(DemandeSpec paramDemandeSpec, AttributionSpec paramAttributionSpec, boolean paramBoolean)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     ProduitAvecEpuisementSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */