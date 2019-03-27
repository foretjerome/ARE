package fr.unedic.cali.utilitaire.filtres.metiers;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.affectation.ProduitInrSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreAttributionSurDecisions;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourNumeroGamme;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;

public class FiltreAttributionInrPourDateAttributionAreLiee
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  Damj m_dateAttribution;
  
  public FiltreAttributionInrPourDateAttributionAreLiee(Damj p_dateAttribution)
  {
    if (p_dateAttribution == null) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_UTILITAIRE_VALEUR_ATTENDUE", new Object[] { "date attribution" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
    m_dateAttribution = p_dateAttribution;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    boolean retour = false;
    FiltreET filtre = new FiltreET();
    filtre.ajouterFiltre(new FiltreDemandePourNumeroGamme(6));
    filtre.ajouterFiltre(new FiltreAttributionSurDecisions());
    if (filtre.accepter(p_temporel))
    {
      AttributionSpec attribution = (AttributionSpec)p_temporel;
      ProduitInrSpec produitInr = (ProduitInrSpec)((DecisionSpec)p_temporel).getDossierAffecte().getProduit();
      Damj dateAttributionAreLiee = produitInr.getDateAttributionAreLiee(attribution);
      if ((dateAttributionAreLiee != null) && (dateAttributionAreLiee.coincideAvec(m_dateAttribution))) {
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
 * Qualified Name:     FiltreAttributionInrPourDateAttributionAreLiee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */