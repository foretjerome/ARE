package fr.unedic.cali.autresdoms.d90.dom.comportement;

import fr.unedic.cali.autresdoms.d90.dom.ElementDroitAExclure;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.dom.ComparateurDecisionSpec;
import fr.unedic.cali.utilitaire.decideur.logiques.DecideurDecisionVeto;
import fr.unedic.cali.utilitaire.decideur.metier.DecideurDecisionMotifRejet;
import fr.unedic.cali.utilitaire.decideur.metier.DecideurElementsAExclure;
import fr.unedic.cali.utilitaire.decideur.spec.DecideurDecisionSpec;
import fr.unedic.util.services.ApplicativeRuntimeException;
import java.lang.reflect.Field;

public class ComportementBatchDefaut
  extends ComportementAbstrait
{
  private String identifiant = "comportementBatchDefaut";
  private String libelle = "Comportement par défaut d'un occasionnel";
  
  public ComportementBatchDefaut()
  {
    initialiserVariableClasse();
    
    DecideurDecisionVeto decideur = new DecideurDecisionVeto();
    
    DecideurDecisionSpec decideurReconductionRejet = new DecideurDecisionMotifRejet(-1, -1);
    
    DecideurElementsAExclure decideurElementsAExclure = new DecideurElementsAExclure();
    creerElementDroitAExclureOccasionnelLiquidation(decideurElementsAExclure);
    
    decideur.ajouterDecideur(decideurElementsAExclure);
    decideur.ajouterDecideur(decideurReconductionRejet);
    
    setDecideur(decideur);
  }
  
  public void initialiserVariableClasse()
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
  }
  
  protected void creerElementDroitAExclureOccasionnelLiquidation(DecideurElementsAExclure decideur)
  {
    try
    {
      Field[] listeAttributs = Class.forName(ComparateurDecisionSpec.class.getName()).getDeclaredFields();
      int taille = listeAttributs.length;
      for (int i = 0; i < taille; i++)
      {
        Field attribut = listeAttributs[i];
        if (attribut.getName().startsWith("LIB_"))
        {
          String valeurChamp = attribut.get(ComparateurDecisionSpec.class).toString();
          if ((!"Libellé Décision".equals(valeurChamp)) && (!"Produit Proposé".equals(valeurChamp)) && (!"Compétence administrative".equals(valeurChamp)))
          {
            ElementDroitAExclure elementDroitAExclure = new ElementDroitAExclure();
            elementDroitAExclure.setLibelleElementAExclure(valeurChamp);
            decideur.ajouterElementDroitAExclure(elementDroitAExclure);
          }
        }
      }
    }
    catch (ClassNotFoundException ex)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_OCCASL_INSC_COMPORTEMENT_LIQ", "Erreur produit lors de la récupération des élements de comparaison à exclure pour le comportement occasionnel liquidation", ex);
    }
    catch (IllegalAccessException ex)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_OCCASL_INSC_COMPORTEMENT_LIQ", "Erreur produit lors de la récupération des élements de comparaison à exclure pour le comportement occasionnel liquidation", ex);
    }
  }
  
  public ComportementSpec getComportementSansReexamenAuto()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     ComportementBatchDefaut
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */