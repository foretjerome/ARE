package fr.unedic.cali.autresdoms.d90.dom.comportement;

import fr.unedic.cali.autresdoms.d90.dom.ElementDroitAExclure;
import fr.unedic.cali.dom.ComparateurDecisionSpec;
import fr.unedic.cali.utilitaire.decideur.metier.DecideurElementsAExclure;
import fr.unedic.util.services.ApplicativeRuntimeException;
import java.lang.reflect.Field;

public class ComportementBatchReconductionSystematique
  extends ComportementBatchDefaut
{
  private String identifiant = "comportementBatchReconductionSystematique";
  private String libelle = "Comportement batch reconduction systematique";
  
  public ComportementBatchReconductionSystematique()
  {
    identifiantComportement = identifiant;
    libelleComportement = libelle;
    typeMandatement = "1";
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
          ElementDroitAExclure elementDroitAExclure = new ElementDroitAExclure();
          elementDroitAExclure.setLibelleElementAExclure(valeurChamp);
          decideur.ajouterElementDroitAExclure(elementDroitAExclure);
        }
      }
      ElementDroitAExclure elementDroitAExclure = new ElementDroitAExclure();
      elementDroitAExclure.setLibelleElementAExclure("Date // Heure de liquidation");
      decideur.ajouterElementDroitAExclure(elementDroitAExclure);
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
}

/* Location:
 * Qualified Name:     ComportementBatchReconductionSystematique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */