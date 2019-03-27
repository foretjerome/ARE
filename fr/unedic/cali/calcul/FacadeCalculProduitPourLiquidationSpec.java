package fr.unedic.cali.calcul;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.cali.parcours.ResultatExecutionCalcul;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public abstract interface FacadeCalculProduitPourLiquidationSpec
{
  public abstract Periode determinerPeriodeAvantSansCalendrier(AttributionSpec paramAttributionSpec)
    throws ApplicativeException;
  
  public abstract ResultatExecutionCalcul executerCalculDeterminationEtatDroit(AttributionSpec paramAttributionSpec, Damj paramDamj, boolean paramBoolean1, boolean paramBoolean2)
    throws ApplicativeException;
  
  public abstract ResultatExecutionCalcul executerCalculDeterminationEtatDroit(AttributionSpec paramAttributionSpec1, AttributionSpec paramAttributionSpec2, Damj paramDamj, boolean paramBoolean1, boolean paramBoolean2)
    throws ApplicativeException;
  
  public abstract ResultatExecutionCalcul executerCalculDeterminationEtatDroit(AttributionSpec paramAttributionSpec, DemandeSpec paramDemandeSpec, Damj paramDamj, boolean paramBoolean1, boolean paramBoolean2)
    throws ApplicativeException;
  
  public abstract Damj recupererDateFinDroitTheorique(AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract MontantBaseSpec determinerMontant(AttributionSpec paramAttributionSpec, Damj paramDamj)
    throws ApplicativeException;
  
  public abstract Damj recupererDateDrv(AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract Damj recupererDateEpuisementDuree(AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract ResultatExecutionCalcul executerCalculDeterminationMontantAidePaye(AttributionSpec paramAttributionSpec1, Damj paramDamj, DemandeSpec paramDemandeSpec, AttributionSpec paramAttributionSpec2)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     FacadeCalculProduitPourLiquidationSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */