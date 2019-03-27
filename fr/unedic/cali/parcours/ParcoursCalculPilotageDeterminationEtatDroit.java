package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.outilsfonctionnels.reexecution.OutilDeterminationDateDebutExecution;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.util.Arrays;

public class ParcoursCalculPilotageDeterminationEtatDroit
  extends ParcoursCalculPilotage
{
  public ParcoursCalculPilotageDeterminationEtatDroit()
  {
    setTypeDePostTraitement(4);
  }
  
  public void controlerContexte(Contexte p_contexte)
    throws ContexteException
  {
    super.controlerContexte(p_contexte);
    
    DomCalculPilotage domCalculPilotage = (DomCalculPilotage)p_contexte.getDonnees();
    if (domCalculPilotage.getDateArretExecution() == null) {
      throw new ContexteException("HG_PR_CALI_L_CONTEXTE_DATE_ARRET_NON_RENSEIGNEE", "Contrôle du contexte du calcul : la date d'arrêt de l'exécution doit être renseignée", null);
    }
    if (!domCalculPilotage.isExecutionDepuisPersistance()) {
      throw new ContexteException("HG_PR_CALI_L_CONTEXTE_EXECUTION_NON_LUE_EN_BASE", "Contrôle du contexte du calcul : l'exécution doit être lue en base", null);
    }
    if (domCalculPilotage.isExecutionPersistante()) {
      throw new ContexteException("HG_PR_CALI_L_CALCUL_CONTEXTE_EXECUTION_PERSISTANTE", "Contrôle du contexte du calcul : l'exécution ne doit pas être persistante", null);
    }
    AttributionSpec attributionAEtudier = domCalculPilotage.getAttributionAEtudier();
    if (attributionAEtudier == null) {
      throw new ContexteException("HG_PR_CALI_L_CONTEXTE_ABSENCE_DECISION_A_ETUDIER", "Contrôle du contexte du calcul : aucune décision à étudier en entrée", null);
    }
    if ((domCalculPilotage.getDateArretExecution() != null) && (domCalculPilotage.getDateArretExecution().estAvant(attributionAEtudier.getDateEffet()))) {
      throw new ContexteException("HG_PR_CALI_L_CAL_CTX_DATE_ARRET_ANTERIEURE_DECIS", "Contrôle du contexte du calcul : la date d'arrêt de l'exécution est antérieure à la date de la décision", null);
    }
    if ((domCalculPilotage.getDateArretExecution() != null) && (domCalculPilotage.getDateArretExecution().estAvant(attributionAEtudier.getPji()))) {
      throw new ContexteException("HG_PR_CALI_L_CAL_CTX_DATE_ARRET_EXEC_ANTERIEURE", "Contrôle du contexte du calcul : la date d'arrêt de l'exécution est antérieure au PJI de la décision", null);
    }
    Damj dateDebutExecution = null;
    try
    {
      dateDebutExecution = OutilDeterminationDateDebutExecution.getInstance().rechercherDateDebutExecution(Arrays.asList(new Object[] { attributionAEtudier }), domCalculPilotage.getDateDebutExecution(), domCalculPilotage.isExecutionDepuisPersistance(), domCalculPilotage.getIndividu());
    }
    catch (CoucheLogiqueException ex)
    {
      throw new ContexteException("HG_PR_CALI_L_CAL_ECHEC_DETERMINAT_DATE_DEBUT_EXEC", "Echec lors de la détermination de la date de début d'exécution du calcul", null);
    }
    domCalculPilotage.setDateDebutExecution(dateDebutExecution);
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 0;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
}

/* Location:
 * Qualified Name:     ParcoursCalculPilotageDeterminationEtatDroit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */