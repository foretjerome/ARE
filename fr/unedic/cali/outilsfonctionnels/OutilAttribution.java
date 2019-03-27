package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.AttributionAssuranceSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.LigneSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.utilitaire.filtres.composites.FiltreAttributionAssurance;
import fr.unedic.cali.utilitaire.filtres.composites.FiltreAttributionSolidariteAss;
import fr.unedic.cali.utilitaire.filtres.composites.FiltreAttributionStandardAssurance;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.metiers.FiltreAttributionEnCoursIndemnisationPourDate;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class OutilAttribution
{
  private static OutilAttribution instance;
  
  public static OutilAttribution getInstance()
  {
    if (instance == null) {
      instance = new OutilAttribution();
    }
    return instance;
  }
  
  public boolean estUneAttributionSpectacle(DossierExamenSpec dossierExamenSpec)
  {
    boolean estUneAttributionSpectacle;
    boolean estUneAttributionSpectacle;
    if ((dossierExamenSpec.getDossierAffecte().getProduit().getLigne().getNomUnique().equals("ASU_SPE02")) || (dossierExamenSpec.getDossierAffecte().getProduit().getLigne().getNomUnique().equals("ASU_SSP07")) || (dossierExamenSpec.getDossierAffecte().getProduit().getLigne().getNomUnique().equals("ASU_FDS12"))) {
      estUneAttributionSpectacle = true;
    } else {
      estUneAttributionSpectacle = false;
    }
    return estUneAttributionSpectacle;
  }
  
  public AttributionSpec rechercherAttributionARELiee(IndividuSpec individu, Damj debutActivite)
  {
    FiltreET filtreAttributionAssuranceEncours = new FiltreET();
    filtreAttributionAssuranceEncours.ajouterFiltre(new FiltreAttributionAssurance(false, true, false, false, null));
    filtreAttributionAssuranceEncours.ajouterFiltre(new FiltreAttributionEnCoursIndemnisationPourDate(debutActivite.veille()));
    
    AttributionSpec attributionAreLiee = (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(individu.getChronoDemandeAssurance(), debutActivite, filtreAttributionAssuranceEncours);
    if (attributionAreLiee != null)
    {
      AttributionSpec attributionAssuranceFinDroitEnCours = OutilFinDroit.rechercherFinDroitSuivantAttribution(attributionAreLiee);
      if (attributionAssuranceFinDroitEnCours != null) {
        attributionAreLiee = attributionAssuranceFinDroitEnCours;
      }
    }
    else
    {
      attributionAreLiee = (AttributionSpec)OutilRecherche.rechercherDecisionSuivante(individu.getChronoDemandeAssurance(), debutActivite.veille().veille(), new FiltreAttributionStandardAssurance(false, true, false, false, null));
    }
    return attributionAreLiee;
  }
  
  public void traiterAttributionLiee(List liste, DossierExamenSpec dossierCourant)
  {
    AttributionSpec attributionCourante = (AttributionSpec)dossierCourant;
    Collection<AttributionSpec> listeAttributionsLiees = attributionCourante.getAttributionLiees();
    if ((listeAttributionsLiees != null) && (!listeAttributionsLiees.isEmpty()))
    {
      Iterator<AttributionSpec> iterateurAttributionLiee = listeAttributionsLiees.iterator();
      while (iterateurAttributionLiee.hasNext())
      {
        AttributionSpec dossierTemp = (AttributionSpec)iterateurAttributionLiee.next();
        if (!liste.contains(dossierTemp)) {
          liste.add(dossierTemp);
        }
      }
    }
  }
  
  public boolean estProduitAttributionEgal(AttributionSpec attribution, String nomProduit)
  {
    return attribution.getProduit().getNomUnique().equals(nomProduit);
  }
  
  public AttributionSpec rechercherAttributionASSLiee(IndividuSpec individu, Damj debutActivite)
  {
    FiltreET filtreAttributionASSEnCours = new FiltreET();
    filtreAttributionASSEnCours.ajouterFiltre(new FiltreAttributionSolidariteAss(true));
    return (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(individu.getChronoDemandeSolidarite(), debutActivite.lendemain(), filtreAttributionASSEnCours);
  }
  
  public AttributionAssuranceSpec recupererAttributionAssurancePrecedente(Damj dateDepot, Chronologie chronologieDemandesAssuranceSansCourante, DemandeSpec demandePourFiltre)
  {
    return (AttributionAssuranceSpec)OutilRecherche.rechercherDecisionPrecedente(chronologieDemandesAssuranceSansCourante, dateDepot, new FiltreAttributionAssurance(true, true, false, false, demandePourFiltre));
  }
}

/* Location:
 * Qualified Name:     OutilAttribution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */