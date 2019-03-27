package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.affectation.ProduitAsuSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.List;

public class FiltreAttribution
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    List listDossierExamen = ((DemandeSpec)p_temporel).getListeDossiersExamen();
    try
    {
      if ((listDossierExamen != null) && (!listDossierExamen.isEmpty()) && ((listDossierExamen.get(0) instanceof AttributionSpec)))
      {
        AttributionSpec attributionCourante = (AttributionSpec)listDossierExamen.get(0);
        ProduitSpec produitAttributionCourante = attributionCourante.getDossierAffecte().getProduit();
        if ((!(produitAttributionCourante instanceof ProduitAsuSpec)) || (((ProduitAsuSpec)produitAttributionCourante).estCompetenceAdministrativeRac(attributionCourante))) {
          return true;
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
 * Qualified Name:     FiltreAttribution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */