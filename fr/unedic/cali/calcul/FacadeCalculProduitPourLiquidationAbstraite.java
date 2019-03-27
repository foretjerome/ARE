package fr.unedic.cali.calcul;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.parcours.ResultatExecutionCalcul;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public abstract class FacadeCalculProduitPourLiquidationAbstraite
  implements FacadeCalculProduitPourLiquidationSpec
{
  public ResultatExecutionCalcul executerCalculDeterminationEtatDroit(AttributionSpec attributionAEtudier, AttributionSpec attributionPivot, Damj dateEtude, boolean priseEnCompteGaec, boolean determinationApres)
    throws ApplicativeException
  {
    GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_PRODUIT_METHODE_NON_IMPLEMENTE");
    return null;
  }
  
  public ResultatExecutionCalcul executerCalculDeterminationEtatDroit(AttributionSpec attributionAEtudier, DemandeSpec demandePivot, Damj dateEtude, boolean priseEnCompteGaec, boolean determinationApres)
    throws ApplicativeException
  {
    GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_PRODUIT_METHODE_NON_IMPLEMENTE");
    return null;
  }
  
  public Boolean determinerReliquatValide(AttributionSpec attribution, Damj dateRecherche)
    throws CoucheLogiqueException
  {
    return null;
  }
  
  public ResultatExecutionCalcul executerCalculDeterminationMontantAidePaye(AttributionSpec attributionAEtudier, Damj dateEtude, DemandeSpec demandePivot, AttributionSpec attributionPivot)
    throws ApplicativeException
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     FacadeCalculProduitPourLiquidationAbstraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */