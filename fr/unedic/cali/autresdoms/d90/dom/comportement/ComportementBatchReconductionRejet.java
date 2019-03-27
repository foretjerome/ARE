package fr.unedic.cali.autresdoms.d90.dom.comportement;

import fr.unedic.cali.utilitaire.decideur.logiques.DecideurDecisionVeto;
import fr.unedic.cali.utilitaire.decideur.metier.DecideurDecisionMotifRejet;
import fr.unedic.cali.utilitaire.decideur.metier.DecideurElementsAExclure;
import fr.unedic.cali.utilitaire.decideur.spec.DecideurDecisionSpec;

public class ComportementBatchReconductionRejet
  extends ComportementBatchDefaut
{
  private String identifiant = "comportementBatchReconductionRejet";
  private String libelle = "Reconduction par défaut et Reconduction des rejets";
  
  public ComportementBatchReconductionRejet()
  {
    initialiserVariableClasse();
    
    identifiantComportement = identifiant;
    libelleComportement = libelle;
    
    DecideurDecisionSpec decideurReconductionRejet = new DecideurDecisionMotifRejet(-1, -1);
    
    DecideurDecisionVeto decideur = new DecideurDecisionVeto();
    
    DecideurElementsAExclure decideurElementsAExclure = new DecideurElementsAExclure();
    creerElementDroitAExclureOccasionnelLiquidation(decideurElementsAExclure);
    
    decideur.ajouterDecideur(decideurElementsAExclure);
    decideur.ajouterDecideur(decideurReconductionRejet);
    
    setDecideur(decideur);
  }
}

/* Location:
 * Qualified Name:     ComportementBatchReconductionRejet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */