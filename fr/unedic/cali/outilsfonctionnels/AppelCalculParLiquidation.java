package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.FacadeCalculProduitPourLiquidationAbstraite;
import fr.unedic.cali.calcul.FacadeCalculProduitPourLiquidationFactory;
import fr.unedic.cali.calcul.FacadeCalculProduitPourLiquidationSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.parcours.ResultatExecutionCalcul;
import fr.unedic.cali.parcours.ResultatExecutionCalculSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class AppelCalculParLiquidation
{
  public static ResultatExecutionCalculSpec executerCalculDeterminationEtatDroit(AttributionSpec attributionAEtudier, Damj dateEtude, boolean priseEnCompteGaec, boolean determinationApres)
    throws ApplicativeException
  {
    return executerCalculDeterminationEtatDroit(attributionAEtudier, null, null, dateEtude, priseEnCompteGaec, determinationApres);
  }
  
  public static ResultatExecutionCalculSpec executerCalculDeterminationEtatDroit(AttributionSpec attributionAEtudier, AttributionSpec attributionPivot, Damj dateEtude, boolean priseEnCompteGaec, boolean determinationApres)
    throws ApplicativeException
  {
    return executerCalculDeterminationEtatDroit(attributionAEtudier, attributionPivot, null, dateEtude, priseEnCompteGaec, determinationApres);
  }
  
  public static ResultatExecutionCalculSpec executerCalculDeterminationEtatDroit(AttributionSpec attributionAEtudier, DemandeSpec demandePivot, Damj dateEtude, boolean priseEnCompteGaec, boolean determinationApres)
    throws ApplicativeException
  {
    return executerCalculDeterminationEtatDroit(attributionAEtudier, null, demandePivot, dateEtude, priseEnCompteGaec, determinationApres);
  }
  
  public static ResultatExecutionCalculSpec executerCalculDeterminationMontantAidePaye(AttributionSpec attributionAEtudier, Damj dateEtude, DemandeSpec demandePivot, AttributionSpec attributionPivot)
    throws ApplicativeException
  {
    ResultatExecutionCalcul resultatCalcul = null;
    FacadeCalculProduitPourLiquidationSpec facadeCalculPourLiquidation = recuperationFacadesCalculPourLiquidation(attributionAEtudier.getProduit());
    if (facadeCalculPourLiquidation != null) {
      resultatCalcul = facadeCalculPourLiquidation.executerCalculDeterminationMontantAidePaye(attributionAEtudier, dateEtude, demandePivot, attributionPivot);
    }
    return resultatCalcul;
  }
  
  public static ResultatExecutionCalculSpec executerCalculDeterminationEtatDroit(AttributionSpec attributionAEtudier, AttributionSpec attributionPivot, DemandeSpec demandePivot, Damj dateEtude, boolean priseEnCompteGaec, boolean determinationApres)
    throws ApplicativeException
  {
    ResultatExecutionCalcul resultatCalcul = null;
    FacadeCalculProduitPourLiquidationSpec facadeCalculPourLiquidation = recuperationFacadesCalculPourLiquidation(attributionAEtudier.getProduit());
    if (facadeCalculPourLiquidation != null)
    {
      if ((attributionPivot == null) && (demandePivot == null)) {
        resultatCalcul = facadeCalculPourLiquidation.executerCalculDeterminationEtatDroit(attributionAEtudier, dateEtude, priseEnCompteGaec, determinationApres);
      } else if (demandePivot == null) {
        resultatCalcul = facadeCalculPourLiquidation.executerCalculDeterminationEtatDroit(attributionAEtudier, attributionPivot, dateEtude, priseEnCompteGaec, determinationApres);
      } else if (attributionPivot == null) {
        resultatCalcul = facadeCalculPourLiquidation.executerCalculDeterminationEtatDroit(attributionAEtudier, demandePivot, dateEtude, priseEnCompteGaec, determinationApres);
      }
    }
    else
    {
      resultatCalcul = new ResultatExecutionCalcul();
      resultatCalcul.setResultatPendant(AppelCalcul.executerCalculDeterminationEtatDroit(attributionAEtudier, dateEtude));
    }
    return resultatCalcul;
  }
  
  public static ResultatExecutionCalculSpec executerCalculDeterminationEtatDroit(AttributionSpec attributionAEtudier, Damj dateEtude, boolean priseEnCompteGaec)
    throws ApplicativeException
  {
    return executerCalculDeterminationEtatDroit(attributionAEtudier, dateEtude, priseEnCompteGaec, false);
  }
  
  public static Periode determinerPeriodeAvantSansCalendrier(AttributionSpec attribution)
    throws ApplicativeException
  {
    Periode periodeAvant = null;
    FacadeCalculProduitPourLiquidationSpec facadeCalculProduitPourLiquidation = recuperationFacadesCalculPourLiquidation(attribution.getProduit());
    if (facadeCalculProduitPourLiquidation != null) {
      periodeAvant = facadeCalculProduitPourLiquidation.determinerPeriodeAvantSansCalendrier(attribution);
    }
    return periodeAvant;
  }
  
  protected static FacadeCalculProduitPourLiquidationSpec recuperationFacadesCalculPourLiquidation(ProduitSpec produit)
  {
    FacadeCalculProduitPourLiquidationSpec facadeCalculProduitPourLiquidation = null;
    try
    {
      facadeCalculProduitPourLiquidation = FacadeCalculProduitPourLiquidationFactory.getInstance().getInstanceGestionnaireCalculProduit(produit);
    }
    catch (CoucheLogiqueException e)
    {
      facadeCalculProduitPourLiquidation = null;
    }
    return facadeCalculProduitPourLiquidation;
  }
  
  public static Damj recupererDateFinDroitTheorique(AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    Damj periodeAvant = null;
    FacadeCalculProduitPourLiquidationSpec facadeCalculProduitPourLiquidation = recuperationFacadesCalculPourLiquidation(attribution.getProduit());
    if (facadeCalculProduitPourLiquidation != null) {
      periodeAvant = facadeCalculProduitPourLiquidation.recupererDateFinDroitTheorique(attribution);
    }
    return periodeAvant;
  }
  
  public static MontantBaseSpec determinerMontant(AttributionSpec attribution, Damj dateCalcul)
    throws ApplicativeException
  {
    FacadeCalculProduitPourLiquidationSpec facadeCalculProduitPourLiquidation = recuperationFacadesCalculPourLiquidation(attribution.getProduit());
    
    return facadeCalculProduitPourLiquidation.determinerMontant(attribution, dateCalcul);
  }
  
  public static Damj recupererDateRepriseDeVersement(AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    Damj dateDrv = null;
    FacadeCalculProduitPourLiquidationSpec facadeCalculProduitPourLiquidation = recuperationFacadesCalculPourLiquidation(attribution.getProduit());
    if (facadeCalculProduitPourLiquidation != null) {
      dateDrv = facadeCalculProduitPourLiquidation.recupererDateDrv(attribution);
    }
    return dateDrv;
  }
  
  public static Damj recupererDateEpuisementDuree(AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    Damj dateDrv = null;
    FacadeCalculProduitPourLiquidationSpec facadeCalculProduitPourLiquidation = recuperationFacadesCalculPourLiquidation(attribution.getProduit());
    if (facadeCalculProduitPourLiquidation != null) {
      dateDrv = facadeCalculProduitPourLiquidation.recupererDateEpuisementDuree(attribution);
    }
    return dateDrv;
  }
  
  public static Boolean recupererReliquatValide(AttributionSpec attribution, Damj dateRecherche)
    throws CoucheLogiqueException
  {
    Boolean etatReliquat = null;
    FacadeCalculProduitPourLiquidationSpec facadeCalculProduitPourLiquidation = recuperationFacadesCalculPourLiquidation(attribution.getProduit());
    if (facadeCalculProduitPourLiquidation != null) {
      etatReliquat = ((FacadeCalculProduitPourLiquidationAbstraite)facadeCalculProduitPourLiquidation).determinerReliquatValide(attribution, dateRecherche);
    }
    return etatReliquat;
  }
}

/* Location:
 * Qualified Name:     AppelCalculParLiquidation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */