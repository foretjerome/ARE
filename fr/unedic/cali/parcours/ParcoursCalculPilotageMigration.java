package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;

public class ParcoursCalculPilotageMigration
  extends ParcoursMigrationCalculPilotage
{
  public ParcoursCalculPilotageMigration()
  {
    setTypeDePostTraitement(1);
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
 * Qualified Name:     ParcoursCalculPilotageMigration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */