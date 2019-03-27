package fr.unedic.cali.autresdoms.d90.dom.comportement;

import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.utilitaire.decideur.logiques.DecideurDecisionVeto;
import fr.unedic.cali.utilitaire.decideur.metier.DecideurElementsAExclure;
import fr.unedic.cali.utilitaire.decideur.spec.DecideurDecisionSpec;

public class ComportementBatchDefautDecideurRejetB47B4X
  extends ComportementBatchDefaut
{
  private String identifiant = "comportementBatchDefautRejetB47B4x";
  private String libelle = "Comportement par défaut d'un occasionnel / Reconduction des rejets B47-B4X";
  
  public ComportementBatchDefautDecideurRejetB47B4X()
  {
    identifiantComportement = identifiant;
    libelleComportement = libelle;
    applicationSurPremiereDecision = false;
    reexucutionDecisionMigrees = true;
    rexamenDecisionMigrees = "D";
    typeMandatement = "2";
    ecrireEnBaseVisu = true;
    
    reexamenAlertesNonBloquantes = false;
    comparerBasesPivotsEchanges = false;
    
    DecideurDecisionSpec decideurRejetB47B4X = GammeAsu.getInstance().determinerDecideursPourComportement(getIdentifiantComportement());
    
    DecideurDecisionVeto decideur = new DecideurDecisionVeto();
    setDecideur(decideur);
    
    DecideurElementsAExclure decideurElementsAExclure = new DecideurElementsAExclure();
    creerElementDroitAExclureOccasionnelLiquidation(decideurElementsAExclure);
    
    decideur.ajouterDecideur(decideurElementsAExclure);
    decideur.ajouterDecideur(decideurRejetB47B4X);
    
    setDecideur(decideur);
  }
}

/* Location:
 * Qualified Name:     ComportementBatchDefautDecideurRejetB47B4X
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */