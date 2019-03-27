package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.affectation.ProduitAbstrait;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreNegation;
import fr.unedic.util.temps.Temporel;

public class FiltreAttributionPourTypeProduitExecution
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private boolean filtrerDecisionValidee;
  private int typeProduit;
  
  public FiltreAttributionPourTypeProduitExecution(boolean estDecisionSansReexamen, int typeProduit)
  {
    filtrerDecisionValidee = estDecisionSansReexamen;
    this.typeProduit = typeProduit;
  }
  
  public boolean accepterElement(Temporel temporel)
  {
    boolean resultat = false;
    if ((temporel instanceof AttributionSpec))
    {
      AttributionSpec attribution = (AttributionSpec)temporel;
      ProduitSpec produitCourant = attribution.getProduitExecution();
      if (produitCourant != null) {
        resultat = ProduitAbstrait.estDuType(typeProduit, produitCourant.getCode());
      }
    }
    if (filtrerDecisionValidee)
    {
      FiltreET filtreReexamen = new FiltreET();
      filtreReexamen.ajouterFiltre(new FiltreNegation(new FiltreReexamenSurDemande()));
      filtreReexamen.ajouterFiltre(new FiltreValideeSurDecision());
      if (!filtreReexamen.accepter(temporel)) {
        resultat = false;
      }
    }
    return resultat;
  }
  
  public int getTypeElementManipule()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     FiltreAttributionPourTypeProduitExecution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */