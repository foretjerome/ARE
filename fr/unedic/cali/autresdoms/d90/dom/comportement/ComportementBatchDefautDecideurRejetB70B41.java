package fr.unedic.cali.autresdoms.d90.dom.comportement;

import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.utilitaire.decideur.logiques.DecideurDecisionVeto;
import fr.unedic.cali.utilitaire.decideur.metier.DecideurElementsAExclure;
import fr.unedic.cali.utilitaire.decideur.spec.DecideurDecisionSpec;

public class ComportementBatchDefautDecideurRejetB70B41
  extends ComportementBatchDefaut
{
  private String identifiant = "comportementBatchDefautRejetB70B41";
  private String libelle = "Comportement par défaut d'un occasionnel / Reconduction des rejets B70-B41";
  
  public ComportementBatchDefautDecideurRejetB70B41()
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
    
    DecideurDecisionSpec decideurRejetB70B41 = GammeAsu.getInstance().determinerDecideursPourComportement(getIdentifiantComportement());
    
    DecideurDecisionVeto decideur = new DecideurDecisionVeto();
    setDecideur(decideur);
    
    DecideurElementsAExclure decideurElementsAExclure = new DecideurElementsAExclure();
    creerElementDroitAExclureOccasionnelLiquidation(decideurElementsAExclure);
    
    decideur.ajouterDecideur(decideurElementsAExclure);
    decideur.ajouterDecideur(decideurRejetB70B41);
    
    setDecideur(decideur);
  }
}

/* Location:
 * Qualified Name:     ComportementBatchDefautDecideurRejetB70B41
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */