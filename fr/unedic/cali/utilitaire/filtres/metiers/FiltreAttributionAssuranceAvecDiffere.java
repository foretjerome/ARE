package fr.unedic.cali.utilitaire.filtres.metiers;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.affectation.ProduitAsuSpec;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreAttributionSurDecisions;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourNumeroGamme;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.util.temps.Temporel;

public class FiltreAttributionAssuranceAvecDiffere
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepterElement(Temporel p_temporel)
  {
    boolean retour = false;
    DecisionSpec decision = (DecisionSpec)p_temporel;
    FiltreET filtrePrerequis = new FiltreET();
    filtrePrerequis.ajouterFiltre(new FiltreAttributionSurDecisions());
    filtrePrerequis.ajouterFiltre(new FiltreDemandePourNumeroGamme(1));
    if (filtrePrerequis.accepter(p_temporel))
    {
      ProduitAsuSpec produit = (ProduitAsuSpec)decision.getDossierAffecte().getProduit();
      if (produit.estPresenceDiffere((AttributionSpec)decision)) {
        retour = true;
      }
    }
    return retour;
  }
  
  public int getTypeElementManipule()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     FiltreAttributionAssuranceAvecDiffere
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */