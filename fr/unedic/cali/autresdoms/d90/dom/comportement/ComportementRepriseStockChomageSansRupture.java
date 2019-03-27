package fr.unedic.cali.autresdoms.d90.dom.comportement;

import fr.unedic.cali.autresdoms.d90.dom.ElementDroitAExclure;
import fr.unedic.cali.utilitaire.decideur.metier.DecideurElementsAExclure;

public class ComportementRepriseStockChomageSansRupture
  extends ComportementBatchDefaut
{
  private String identifiant = "comportementRepriseStockCsr";
  private String libelle = "Comportement pour la reprise de stock csr";
  
  public ComportementRepriseStockChomageSansRupture()
  {
    identifiantComportement = identifiant;
    libelleComportement = libelle;
  }
  
  protected void creerElementDroitAExclureOccasionnelLiquidation(DecideurElementsAExclure decideur)
  {
    super.creerElementDroitAExclureOccasionnelLiquidation(decideur);
    
    ElementDroitAExclure elementDroitAExclureCsr04P02 = new ElementDroitAExclure();
    elementDroitAExclureCsr04P02.setLibelleGamme("ASU");
    elementDroitAExclureCsr04P02.setCodeProduit(33);
    elementDroitAExclureCsr04P02.setLibelleElementAExclure("Produit Proposé");
    decideur.ajouterElementDroitAExclure(elementDroitAExclureCsr04P02);
  }
}

/* Location:
 * Qualified Name:     ComportementRepriseStockChomageSansRupture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */