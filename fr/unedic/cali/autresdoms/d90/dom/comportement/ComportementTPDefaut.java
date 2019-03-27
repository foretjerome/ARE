package fr.unedic.cali.autresdoms.d90.dom.comportement;

import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.utilitaire.decideur.metier.DecideurElementsAExclure;

public class ComportementTPDefaut
  extends ComportementAbstrait
{
  public static final String IDENTIFIANT = "comportementTPDefaut";
  private String identifiant = "comportementTPDefaut";
  private String libelle = "Comportement TP par défaut";
  
  public ComportementTPDefaut()
  {
    identifiantComportement = identifiant;
    applicationSurPremiereDecision = false;
    libelleComportement = libelle;
    reexucutionDecisionMigrees = true;
    rexamenDecisionMigrees = "D";
    typeMandatement = "1";
    ecrireEnBaseVisu = false;
    comparerBasesPivotsEchanges = false;
    
    reexamenAlertesNonBloquantes = true;
    
    DecideurElementsAExclure decideur = new DecideurElementsAExclure();
    setDecideur(decideur);
  }
  
  public ComportementSpec getComportementSansReexamenAuto()
  {
    return new ComportementTPDefautSansReexamenAuto();
  }
}

/* Location:
 * Qualified Name:     ComportementTPDefaut
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */