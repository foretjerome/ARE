package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.echange.Decision;
import fr.unedic.cali.dom.pivot.DemandePivot;
import fr.unedic.cali.migration.GrapheLiquidationSpec;
import fr.unedic.cali.occasionnel.outilsfonctionnels.CriteresExecutionPopulation;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import java.util.ArrayList;
import java.util.Hashtable;

public abstract interface FacadeLiquidationProduitSpec
{
  public abstract boolean comparerDecisions(DecisionSpec paramDecisionSpec1, DecisionSpec paramDecisionSpec2);
  
  public abstract void alimenterBasePivotProduit(DossierExamenSpec paramDossierExamenSpec, DemandePivot paramDemandePivot)
    throws ApplicativeException;
  
  public abstract void alimenterBasePivotAidesProduit(DossierExamenSpec paramDossierExamenSpec, DemandePivot paramDemandePivot)
    throws ApplicativeException;
  
  public abstract void alimenterBaseEchangesProduit(DossierExamenSpec paramDossierExamenSpec, Decision paramDecision)
    throws ApplicativeException;
  
  public abstract Hashtable recupererElementsConstituant(DossierExamenSpec paramDossierExamenSpec)
    throws CoucheLogiqueException;
  
  public abstract GrapheLiquidationSpec creerGraphe(int paramInt, boolean paramBoolean);
  
  public abstract ArrayList alimenterDecisionsReexamen(Contexte paramContexte)
    throws CoucheLogiqueException;
  
  public abstract ArrayList getParametres();
  
  public abstract boolean estReexecutable(CriteresExecutionPopulation paramCriteresExecutionPopulation);
  
  public abstract String determinerPeriodeGaecAChargerSurLectureDecision(DemandeSpec paramDemandeSpec);
}

/* Location:
 * Qualified Name:     FacadeLiquidationProduitSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */