package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandesAff;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreNegation;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.FiltreTemporel;

public final class OutilAnnulationReexamen
{
  public static void verifierConditionAnnulationReexamen(DemandeSpec demande)
    throws ApplicativeException
  {
    verifierContexte(demande);
    
    OutilVerificationPreconditions.getInstance().verifierConditionExamen(demande, demande.getChronologieDemandesSansCourante());
    
    verifierDecisionPrecedente(demande);
    
    verifierPossibiliteAnnulerReexamen(demande);
  }
  
  public static void recalculSurAnnulerReexamen(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    demande.getGamme().recalculerSurAnnulerReexamen(demande);
  }
  
  private static void verifierContexte(DemandeSpec demande)
    throws ApplicativeException
  {
    demande.getEvenementReferenceExamen().verifierContexte(demande);
  }
  
  private static void verifierDecisionPrecedente(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    FiltreTemporel filtre = new FiltreNegation(new FiltreDemandesAff());
    
    DecisionSpec decisionPrecedente = demande.getDemandeur().getDecisionAvant(demande, filtre);
    if (decisionPrecedente != null) {
      if (!decisionPrecedente.getDemande().estMigree()) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_ANNULER_REEXAMEN_DECISION_PREC_NON", new Object[] { decisionPrecedente.getDemande().getDateDeclenchementExamen() });
      }
    }
  }
  
  private static void verifierPossibiliteAnnulerReexamen(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    demande.getGamme().verifierPossibiliteAnnulerReexamen(demande);
  }
}

/* Location:
 * Qualified Name:     OutilAnnulationReexamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */