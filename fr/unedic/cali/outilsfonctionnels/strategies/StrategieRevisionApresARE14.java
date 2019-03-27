package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.dom.AttributionAssuranceSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieRevisionARE14Spec;
import fr.unedic.cali.utilitaire.filtres.composites.FiltreAttributionStandardAssurance;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionPourProduit;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreNegation;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreOU;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.CoucheLogiqueException;

public class StrategieRevisionApresARE14
  implements StrategieRevisionARE14Spec
{
  public void controlePresenceDemandeRevision(DemandeSpec demandePrestationsCourante)
    throws CoucheLogiqueException
  {
    AttributionAssuranceSpec attributionAssurancePrecedente = trouverAttributionPrecedente(demandePrestationsCourante);
    if (attributionAssurancePrecedente != null) {
      attributionAssurancePrecedente.getDemande().getGamme().controlerPresenceDemandeRevision(demandePrestationsCourante, attributionAssurancePrecedente);
    }
  }
  
  public void controlePresenceDemandeRevisionPostLiquidation(DemandeSpec demandePrestationsCourante)
    throws CoucheLogiqueException
  {
    AttributionAssuranceSpec attributionAssurancePrecedente = trouverAttributionPrecedente(demandePrestationsCourante);
    if (attributionAssurancePrecedente != null) {
      attributionAssurancePrecedente.getDemande().getGamme().controlerPresenceDemandeRevisionPostLiquidation(demandePrestationsCourante, attributionAssurancePrecedente);
    }
  }
  
  private AttributionAssuranceSpec trouverAttributionPrecedente(DemandeSpec demandePrestationsCourante)
  {
    FiltreET filtreEt = new FiltreET();
    FiltreAttributionStandardAssurance filtreAsu = new FiltreAttributionStandardAssurance(false, true, false, false, null);
    
    FiltreOU filtreOu = new FiltreOU();
    
    FiltreDecisionPourProduit filtreARE03 = new FiltreDecisionPourProduit(1);
    FiltreDecisionPourProduit filtreARE06 = new FiltreDecisionPourProduit(13);
    FiltreDecisionPourProduit filtreASPDC2011 = new FiltreDecisionPourProduit(51);
    
    FiltreDecisionPourProduit filtreASRARE = new FiltreDecisionPourProduit("ASU_CAA14_01");
    FiltreDecisionPourProduit filtreASRDC = new FiltreDecisionPourProduit(36);
    
    filtreOu.ajouterFiltre(filtreARE03);
    filtreOu.ajouterFiltre(filtreARE06);
    filtreOu.ajouterFiltre(filtreASPDC2011);
    filtreOu.ajouterFiltre(filtreASRARE);
    filtreOu.ajouterFiltre(filtreASRDC);
    FiltreNegation filtreNon = new FiltreNegation(filtreOu);
    filtreEt.ajouterFiltre(filtreAsu);
    filtreEt.ajouterFiltre(filtreNon);
    
    AttributionAssuranceSpec attributionAssurancePrecedente = (AttributionAssuranceSpec)OutilRecherche.rechercherDecisionPrecedente(demandePrestationsCourante.getChronologieDemandesAssuranceSansCourante(), demandePrestationsCourante, filtreEt);
    
    return attributionAssurancePrecedente;
  }
}

/* Location:
 * Qualified Name:     StrategieRevisionApresARE14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */