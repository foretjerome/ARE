package fr.unedic.cali.autresdoms.d90.dom.comportement;

import fr.unedic.cali.autresdoms.d90.dom.ElementDroitAExclure;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.utilitaire.decideur.metier.DecideurElementsAExclure;

public class ComportementVnrBatchCinqCles
  extends ComportementAbstrait
{
  private String identifiant = "comportementVnrBatch";
  private String libelle = "Comportement pour la VNR Batch";
  
  public ComportementVnrBatchCinqCles()
  {
    identifiantComportement = identifiant;
    libelleComportement = libelle;
    applicationSurPremiereDecision = false;
    reexucutionDecisionMigrees = true;
    rexamenDecisionMigrees = "D";
    typeMandatement = "2";
    ecrireEnBaseVisu = false;
    
    reexamenAlertesNonBloquantes = false;
    comparerBasesPivotsEchanges = true;
    
    DecideurElementsAExclure decideur = new DecideurElementsAExclure();
    setDecideur(decideur);
    
    ElementDroitAExclure elementDroitAExclure = new ElementDroitAExclure();
    elementDroitAExclure.setLibelleElementAExclure("Date // Heure de liquidation");
    decideur.ajouterElementDroitAExclure(elementDroitAExclure);
  }
  
  public ComportementSpec getComportementSansReexamenAuto()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     ComportementVnrBatchCinqCles
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */