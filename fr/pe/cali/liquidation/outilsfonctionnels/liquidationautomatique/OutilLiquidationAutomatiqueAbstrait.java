package fr.pe.cali.liquidation.outilsfonctionnels.liquidationautomatique;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.parcours.DomCali;
import fr.unedic.cali.parcours.DomLiquidationDemande;
import fr.unedic.cali.parcours.ParcoursLiquidation;
import fr.unedic.cali.parcours.ResultatServiceDemande;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;

public abstract class OutilLiquidationAutomatiqueAbstrait
  implements IOutilLiquidationAutomatique
{
  protected ResultatServiceDemande liquiderDemande(DemandeSpec demande, boolean effectuerControleEligibilite)
    throws ApplicativeException
  {
    DomLiquidationDemande domContexte = demande.getGamme().creerDomLiquidationDemande();
    domContexte.setDemande(demande);
    domContexte.setIdDemande(demande.getIdentifiant());
    domContexte.setIndividu(demande.getDemandeur());
    domContexte.setContexteService(demande.getDemandeur().getContexteService());
    domContexte.setEffectuerControlesEligiliteSurDecisionAuto(effectuerControleEligibilite);
    Contexte contexteParcours = new Contexte();
    contexteParcours.setDonnees(domContexte);
    
    ParcoursLiquidation parcoursLiquidationDemande = demande.getGamme().getParcoursLiquidation(demande);
    
    return (ResultatServiceDemande)parcoursLiquidationDemande.effectuerParcours(contexteParcours);
  }
  
  protected void sauvegarderEtatDemandes(IndividuSpec individu)
  {
    OutilFluxSigma.sauvegarderEtatDemandes(individu);
  }
  
  protected void validerDecision(DemandeSpec demande, Contexte contexte)
    throws ApplicativeException
  {
    demande.validerDecision();
    
    demande.definirDateValidation(getDateTraitement(contexte));
  }
  
  protected Damj getDateTraitement(Contexte contexte)
  {
    return getContexteService(contexte).getDateTraitement();
  }
  
  public ContexteService getContexteService(Contexte contexte)
  {
    DomCali domCali = (DomCali)contexte.getDonnees();
    return domCali.getContexteService();
  }
}

/* Location:
 * Qualified Name:     OutilLiquidationAutomatiqueAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */