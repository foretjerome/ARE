package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionAssuranceSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.fabriques.FabriqueConvention2014;
import fr.unedic.cali.outilsfonctionnels.AppelCalculParLiquidation;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieRechargementARE14Spec;
import fr.unedic.cali.parcours.ResultatExecutionCalculSpec;
import fr.unedic.cali.utilitaire.filtres.composites.FiltreAttributionAssurance;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionPourTypeProduit;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionsSuivantesSurDecisions;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourERE;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class StrategieRechargementApresARE14
  implements StrategieRechargementARE14Spec
{
  public void controlePresenceDemandeRechargement(DemandeSpec demandePrestationsCourante)
    throws CoucheLogiqueException
  {
    if (!"ASU_29".equals(demandePrestationsCourante.getEvenementReferenceExamen().getTypeExamen()))
    {
      FiltreET filtreAttributionPourTypeProduitRechargement = new FiltreET();
      filtreAttributionPourTypeProduitRechargement.ajouterFiltre(new FiltreAttributionAssurance(true, true, false, false, null));
      filtreAttributionPourTypeProduitRechargement.ajouterFiltre(new FiltreDecisionPourTypeProduit(8));
      
      AttributionSpec attributionPrecedente = (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(demandePrestationsCourante.getChronologieDemandesAssuranceSansCourante(), demandePrestationsCourante, filtreAttributionPourTypeProduitRechargement);
      if ((attributionPrecedente != null) && (!((AttributionAssuranceSpec)attributionPrecedente).estMaintenue()))
      {
        Damj djiParEpuisement = null;
        try
        {
          djiParEpuisement = AppelCalculParLiquidation.executerCalculDeterminationEtatDroit(attributionPrecedente, demandePrestationsCourante.getDateRecherche().veille(), true).recupererDJIParEpuisement(attributionPrecedente);
        }
        catch (ApplicativeException ex)
        {
          djiParEpuisement = null;
        }
        if ((djiParEpuisement != null) && (djiParEpuisement.estApresOuCoincideAvec(FabriqueConvention2014.DATE_APPLICATION)) && (djiParEpuisement.estAvant(demandePrestationsCourante.getDateExamen())))
        {
          FiltreET filtreDecisionRechargement = new FiltreET();
          filtreDecisionRechargement.ajouterFiltre(new FiltreDemandePourERE("ASU_29"));
          filtreDecisionRechargement.ajouterFiltre(new FiltreDecisionPourTypeProduit(5));
          filtreDecisionRechargement.ajouterFiltre(new FiltreDecisionsSuivantesSurDecisions(attributionPrecedente));
          
          DecisionSpec decisionRechargement = OutilRecherche.rechercherDecisionPrecedente(demandePrestationsCourante.getChronologieDemandesAssuranceSansCourante(), demandePrestationsCourante.getDateRecherche().lendemain(), filtreDecisionRechargement);
          if (decisionRechargement == null) {
            GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_ERR_DEMANDE_RECHARG_MANQ", new Object[] { attributionPrecedente.getDateAttribution() });
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     StrategieRechargementApresARE14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */