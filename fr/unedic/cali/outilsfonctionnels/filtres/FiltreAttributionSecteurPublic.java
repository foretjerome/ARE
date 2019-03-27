package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitAsuSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.List;

public class FiltreAttributionSecteurPublic
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1779905505457893288L;
  
  public boolean accepter(Temporel p_temporel)
  {
    try
    {
      DemandeSpec demande = (DemandeSpec)p_temporel;
      if ((!demande.getListeDossiersExamen().isEmpty()) && (demande.getListeDossiersExamen().get(0) != null) && ((demande.getListeDossiersExamen().get(0) instanceof AttributionSpec)) && (GammeAsu.getInstance().getNomUnique().equals(demande.getGamme().getNomUnique())))
      {
        AttributionSpec attribution = (AttributionSpec)demande.getListeDossiersExamen().get(0);
        ProduitAsuSpec produitAsu = (ProduitAsuSpec)demande.getDossierAffectation().getProduit();
        if (produitAsu != null) {
          return !produitAsu.estCompetenceAdministrativeRac(attribution);
        }
      }
    }
    catch (ClassCastException e)
    {
      return false;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreAttributionSecteurPublic
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */