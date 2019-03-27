package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.affectation.ProduitSolSpec;
import fr.unedic.cali.parcours.ResultatExecutionCalculSpec;
import fr.unedic.util.services.OutilFonctionnel;
import fr.unedic.util.temps.Damj;

public class RechercherReliquat
  implements OutilFonctionnel
{
  public static boolean rechercherValiditeReliquatPourAss(AttributionSpec p_attribution, Damj p_dateEtatDroit)
    throws ApplicativeException
  {
    if (p_attribution != null) {
      try
      {
        ResultatExecutionCalculSpec etatDroitProduit = ((ProduitSolSpec)p_attribution.getProduit()).retrouverDeterminationEtatDroit(p_attribution, p_dateEtatDroit);
        
        return etatDroitProduit.getEtatAttribution() == 3;
      }
      catch (UnsupportedOperationException ex)
      {
        return false;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     RechercherReliquat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */