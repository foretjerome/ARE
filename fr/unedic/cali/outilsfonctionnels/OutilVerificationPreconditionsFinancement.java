package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologieDebuts;

public class OutilVerificationPreconditionsFinancement
  extends OutilVerificationPreconditions
{
  public static OutilVerificationPreconditions getInstance()
  {
    return new OutilVerificationPreconditionsFinancement();
  }
  
  public void verifierPreconditions(DemandeSpec p_demandePrestationsCourante)
    throws CoucheLogiqueException
  {
    IndividuSpec demandeur = p_demandePrestationsCourante.getDemandeur();
    
    ChronologieDebuts chronoDemandesDuDemandeur = demandeur.getChronoDemandes();
    
    verifierBlocageManuelMF03(p_demandePrestationsCourante, demandeur);
    
    verifierBlocageIndemnisationConflitGaec(p_demandePrestationsCourante, demandeur);
    
    verifierBlocageActualisation(p_demandePrestationsCourante, demandeur);
    
    verifierConditionExamen(p_demandePrestationsCourante, chronoDemandesDuDemandeur);
    
    verifierTypePriseEnCharge(p_demandePrestationsCourante);
  }
}

/* Location:
 * Qualified Name:     OutilVerificationPreconditionsFinancement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */