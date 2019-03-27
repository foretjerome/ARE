package fr.unedic.cali.autresdoms.d90.dom.comportement;

import fr.unedic.cali.autresdoms.d90.dom.ElementDroitAExclure;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.utilitaire.decideur.metier.DecideurElementsAExclure;

public class ComportementTPDefautSansReexamenAuto
  extends ComportementTPDefaut
{
  private String identifiant = "comportementTPDefautSansReexamenAuto";
  private String libelle = "Comportement TP par défaut sans réexamen auto";
  
  public ComportementTPDefautSansReexamenAuto()
  {
    identifiantComportement = identifiant;
    libelleComportement = libelle;
    rexamenDecisionMigrees = "D";
    reexamenAlertesNonBloquantes = false;
    
    DecideurElementsAExclure decideur = new DecideurElementsAExclure();
    setDecideur(decideur);
    creerElementDroitAExclure(decideur);
  }
  
  public ComportementSpec getComportementSansReexamenAuto()
  {
    return this;
  }
  
  protected void creerElementDroitAExclure(DecideurElementsAExclure decideur)
  {
    ElementDroitAExclure elementDroitSystematiqueAExclure = new ElementDroitAExclure();
    elementDroitSystematiqueAExclure.setLibelleElementAExclure("Date // Heure de liquidation");
    decideur.ajouterElementDroitAExclure(elementDroitSystematiqueAExclure);
    
    ElementDroitAExclure elementDroitDateAttributionAExclure = new ElementDroitAExclure();
    elementDroitDateAttributionAExclure.setLibelleElementAExclure("Date Attribution");
    decideur.ajouterElementDroitAExclure(elementDroitDateAttributionAExclure);
  }
}

/* Location:
 * Qualified Name:     ComportementTPDefautSansReexamenAuto
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */