package fr.unedic.cali.migration.outilsfonctionnels;

import fr.unedic.cali.autresdoms.cohab.parcours.DomMigration;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.migration.DemandeEnEcartCalcul;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreAttributionSurDecisions;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.temps.Damj;
import java.util.Collection;
import java.util.Iterator;

public class OutilsMigrationCalculEcarts
{
  private static final double ECART_TOLERANCE_MONTANT_JOUR_BRUT = 0.01D;
  
  public static boolean presenceEcartsCalcul(Collection listeDemandeEnEcartCalcul)
  {
    if (listeDemandeEnEcartCalcul != null)
    {
      Iterator it = listeDemandeEnEcartCalcul.iterator();
      while (it.hasNext())
      {
        DemandeEnEcartCalcul demandeEnEcartCalcul = (DemandeEnEcartCalcul)it.next();
        if (demandeEnEcartCalcul.estEnEcart()) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean presenceEcartsCalculMontantSurDernierDroit(Collection listeDemandeEnEcartCalcul, IndividuSpec individuMigre)
  {
    if (listeDemandeEnEcartCalcul != null)
    {
      Iterator it = listeDemandeEnEcartCalcul.iterator();
      
      AttributionSpec derniereAttribution = (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(individuMigre.getChronoDemandes(), Damj.FIN_DES_TEMPS, new FiltreAttributionSurDecisions(true));
      while (it.hasNext())
      {
        DemandeEnEcartCalcul demandeEnEcartCalcul = (DemandeEnEcartCalcul)it.next();
        if ((demandeEnEcartCalcul.isEcartMontant()) && 
          (derniereAttribution != null) && (derniereAttribution.equals(demandeEnEcartCalcul.getAttribution()))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean presenceEcartsDroitsPasses(Collection listeDemandesEnEcartCalcul, DomMigration migration)
  {
    boolean presenceEcartsDroitsPasses = false;
    
    AttributionSpec attributionEnCours = OutilsMigration.getAttributionEnCoursDIndemnisation(migration, migration.getIndividu());
    if (attributionEnCours != null)
    {
      Iterator it = listeDemandesEnEcartCalcul.iterator();
      DemandeEnEcartCalcul demandeEnEcartCalcul = null;
      while (it.hasNext())
      {
        demandeEnEcartCalcul = (DemandeEnEcartCalcul)it.next();
        if (demandeEnEcartCalcul.getAttribution() != attributionEnCours) {
          presenceEcartsDroitsPasses = true;
        }
      }
    }
    else
    {
      presenceEcartsDroitsPasses = !listeDemandesEnEcartCalcul.isEmpty();
    }
    return presenceEcartsDroitsPasses;
  }
  
  public static boolean presenceEcartsDroitEnCours(Collection listeDemandesEnEcartCalcul, DomMigration migration)
  {
    boolean presenceEcartsDroitEnCours = false;
    
    AttributionSpec attributionEnCours = OutilsMigration.getAttributionEnCoursDIndemnisation(migration, migration.getIndividu());
    if (attributionEnCours != null)
    {
      DemandeEnEcartCalcul demandeEnEcartCalcul = getDemandeEnEcartCalcul(listeDemandesEnEcartCalcul, attributionEnCours.getDemande());
      if ((demandeEnEcartCalcul != null) && (demandeEnEcartCalcul.estEnEcart())) {
        presenceEcartsDroitEnCours = true;
      }
    }
    return presenceEcartsDroitEnCours;
  }
  
  public static DemandeEnEcartCalcul getDemandeEnEcartCalcul(Collection listeDemandesEnEcartCalcul, DemandeSpec demande)
  {
    DemandeEnEcartCalcul demandeEnEcartCalculRecherchee = null;
    
    Iterator it = listeDemandesEnEcartCalcul.iterator();
    while (it.hasNext())
    {
      demandeEnEcartCalculRecherchee = (DemandeEnEcartCalcul)it.next();
      if (demandeEnEcartCalculRecherchee.getDemande() == demande) {
        return demandeEnEcartCalculRecherchee;
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     OutilsMigrationCalculEcarts
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */