package fr.unedic.cali.parcours;

import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;

public class ParcoursAvantPilotageDeterminationEtatDroit
  extends ParcoursAvantPilotage
{
  public void controlerContexte(Contexte contexte)
    throws ContexteException
  {
    super.controlerContexte(contexte);
    
    DomAvantPilotage domCalculPilotage = (DomAvantPilotage)contexte.getDonnees();
    if (domCalculPilotage.isExecutionPersistante()) {
      throw new ContexteException("HG_PR_CALI_L_CALCUL_CONTEXTE_EXECUTION_PERSISTANTE", "Contrôle du contexte du calcul : l'exécution ne doit pas être persistante", null);
    }
  }
}

/* Location:
 * Qualified Name:     ParcoursAvantPilotageDeterminationEtatDroit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */