package fr.unedic.cali.migration;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.dom.CodesErreursMigration;
import fr.unedic.cali.autresdoms.cohab.dom.DemandeMigreeEnErreur;
import fr.unedic.cali.autresdoms.cohab.parcours.DomMigration;
import fr.unedic.cali.autresdoms.cohab.parcours.ResultatMigration;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.migration.outilsfonctionnels.OutilsMigration;
import fr.unedic.cali.outilsfonctionnels.AlimentationBasePivot;
import fr.unedic.cali.outilsfonctionnels.ComparateurSurDateDeclenchementEtPrioriteDemande;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreAttributionSurDecisions;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreReexamenSurDemande;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreNegation;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.cohabitation.sigma.migration.dom.DecisionMigreeV1;
import fr.unedic.cohabitation.sigma.migration.dom.DemandeMigreeV1;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class OutilsMigrationLiquidation
{
  public static void migrerLiquidation(IndividuSpec p_individuMigre, ResultatMigration p_resultat, DomMigration p_domContexte)
    throws ApplicativeException
  {
    Collection listeDemandesTemporaires = p_domContexte.getListeDemandesAMigrer();
    
    p_individuMigre.setEstMigree(1);
    
    p_individuMigre.setAttributionsAfdFiliereCourte(p_domContexte.getAttributionAfdFiliereCourte());
    p_individuMigre.setAttributionsAfdFiliereIntermediaire(p_domContexte.getAttributionAfdFiliereIntermediaire());
    p_individuMigre.setAttributionsAfdFiliereLongue(p_domContexte.getAttributionAfdFiliereLongue());
    p_individuMigre.setDernierJourIndemnisableAreSpe(p_domContexte.getDjiDernierDroitAreSpectacle());
    
    Iterator iterDemandesTemp = listeDemandesTemporaires.iterator();
    while (iterDemandesTemp.hasNext())
    {
      DemandeMigreeV1 demandeTemp = (DemandeMigreeV1)iterDemandesTemp.next();
      if (demandeTemp != null)
      {
        if (Parametres.getProduit(demandeTemp.getCodeProduit()) != null)
        {
          DemandeMigreeEnErreur demandeEnErreur = new DemandeMigreeEnErreur();
          
          DemandeSpec demandeMigree = migrerDemande(demandeTemp, demandeEnErreur);
          
          rattacherDemandeAIndividu(p_individuMigre, demandeMigree, demandeEnErreur);
          
          p_resultat.ajouterDemandeMigreeEnErreur(demandeEnErreur);
        }
        else
        {
          p_resultat.ajouterErreur(CodesErreursMigration.getErreur(3, "LIQ_HG_CODE_PRODUIT"));
        }
      }
      else {
        p_resultat.ajouterErreur(CodesErreursMigration.getErreur(3, "LIQ_HG_TYPE_EXAMEN"));
      }
    }
    if (p_resultat.estSatisfait()) {
      postTraitementMigration(p_resultat);
    }
  }
  
  private static DemandeSpec migrerDemande(DemandeMigreeV1 p_demandeTemp, DemandeMigreeEnErreur p_demandeEnErreur)
  {
    DemandeSpec nouvelleDemandeMigree = null;
    
    GrapheLiquidationSpec graphe = recupererGraphe(p_demandeTemp);
    
    nouvelleDemandeMigree = graphe.migrerDemande(p_demandeTemp, p_demandeEnErreur);
    
    p_demandeEnErreur.setDemande(nouvelleDemandeMigree);
    p_demandeEnErreur.setDemandeV1(p_demandeTemp);
    
    return nouvelleDemandeMigree;
  }
  
  private static GrapheLiquidationSpec recupererGraphe(DemandeMigreeV1 p_demandeTemp)
  {
    String produit = p_demandeTemp.getCodeProduit();
    boolean classementAdministratif = p_demandeTemp.getClassementAdministratif() != null;
    int natureDecision = 0;
    if (!classementAdministratif)
    {
      DecisionMigreeV1 decisionTemp = (DecisionMigreeV1)((ArrayList)p_demandeTemp.getListeDecisions()).get(0);
      natureDecision = decisionTemp.getNatureDecision();
    }
    return FabriqueGrapheLiquidation.creerGraphe(produit, classementAdministratif, natureDecision);
  }
  
  private static void rattacherDemandeAIndividu(IndividuSpec p_individuMigre, DemandeSpec p_demandeMigree, DemandeMigreeEnErreur p_demandeEnErreur)
  {
    if (p_demandeEnErreur.getNiveauErreurGlobal() != 3) {
      p_individuMigre.ajouterDemande(p_demandeMigree);
    }
  }
  
  private static void postTraitementMigration(ResultatMigration p_resultat)
    throws ApplicativeException
  {
    Iterator it = p_resultat.getListeDemandesMigreesEnErreur().iterator();
    
    GrapheLiquidationSpec graphe = null;
    DemandeMigreeEnErreur demandeEnErreur = null;
    while (it.hasNext())
    {
      demandeEnErreur = (DemandeMigreeEnErreur)it.next();
      
      graphe = recupererGraphe(demandeEnErreur.getDemandeV1());
      
      graphe.postTraitementMigrerDemande(demandeEnErreur.getDemandeV1(), demandeEnErreur.getDemande(), demandeEnErreur);
    }
  }
  
  public static void alimentationBasePivot(ResultatMigration p_resultat)
    throws ApplicativeException
  {
    Iterator it = p_resultat.getListeDemandesMigreesEnErreur().iterator();
    
    DemandeMigreeEnErreur demandeEnErreur = null;
    while (it.hasNext())
    {
      demandeEnErreur = (DemandeMigreeEnErreur)it.next();
      if (demandeEnErreur.getNiveauErreurGlobal() != 3) {
        AlimentationBasePivot.enregistrerBasePivot(demandeEnErreur.getDemande());
      }
    }
  }
  
  public static void deneutraliserDerniereDemande(IndividuSpec p_individu, DomMigration p_domMigration)
    throws CoucheLogiqueException
  {
    boolean estUnDEEnCoursDIndemnisation = OutilsMigration.estUnDEEnCoursDIndemnisation(p_domMigration);
    
    AttributionSpec derniereAttribution = (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(p_individu.getChronoDemandes(), Damj.FIN_DES_TEMPS, new FiltreAttributionSurDecisions(true));
    
    boolean estUnDroitSpe = false;
    if (derniereAttribution != null) {
      estUnDroitSpe = OutilsMigration.estDroitSpectacle(derniereAttribution.getDemande());
    }
    if ((!estUnDroitSpe) && (estUnDEEnCoursDIndemnisation) && (derniereAttribution != null))
    {
      if (!derniereAttribution.estMigreeEnSimplifiee())
      {
        if (!derniereAttribution.getDemande().estDeneutralisable()) {
          throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_CONTEXTE", "Déneutraliser Dernière Demande : la dernière attribution à déneutraliser est figée");
        }
        OutilsMigration.deneutraliserEnCascade(derniereAttribution.getDemande());
      }
    }
    else if ((estUnDEEnCoursDIndemnisation) && (derniereAttribution == null)) {
      throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_CONTEXTE", "Déneutraliser Dernière Demande : aucune dernière attribution à déneutraliser n'a été trouvée");
    }
  }
  
  public static void miseAJourNeutralisationCalcul(DomMigration p_migration, IndividuSpec p_individuMigre)
  {
    Iterator iter = p_individuMigre.getDemandes().iterator();
    while (iter.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)iter.next();
      demande.setEstNeutraliseeCalcul(true);
    }
    AttributionSpec attributionEnCours = OutilsMigration.getAttributionEnCoursDIndemnisation(p_migration, p_individuMigre);
    if ((attributionEnCours != null) && (attributionEnCours.getDemande().estMigreeEnSimplifiee())) {
      attributionEnCours.getDemande().setEstNeutraliseeCalcul(false);
    }
  }
  
  public static void installerDemandeEnMigrationSimplifiee(Collection p_listeDemandesEnEcartCalcul, IndividuSpec p_individuMigre)
  {
    Iterator it = p_listeDemandesEnEcartCalcul.iterator();
    DemandeEnEcartCalcul demandeEnEcartCalcul = null;
    
    Chronologie chronologieDemandesEnEcartCalcul = new ChronologieDebuts();
    chronologieDemandesEnEcartCalcul.setComparateur(new ComparateurSurDateDeclenchementEtPrioriteDemande());
    while (it.hasNext())
    {
      demandeEnEcartCalcul = (DemandeEnEcartCalcul)it.next();
      
      demandeEnEcartCalcul.getDemande().setMigree(2);
      
      chronologieDemandesEnEcartCalcul.ajouter(demandeEnEcartCalcul.getDemande());
    }
    DemandeSpec derniereDemandeEnEcart = (DemandeSpec)chronologieDemandesEnEcartCalcul.dernierElement();
    
    figerDemandesPrecedentes(derniereDemandeEnEcart, p_individuMigre);
  }
  
  private static void figerDemandesPrecedentes(DemandeSpec p_demandeDepart, IndividuSpec p_individuSpec)
  {
    Chronologie chronoDemandes = p_individuSpec.getChronoDemandes();
    
    Iterator it = chronoDemandes.iterer();
    
    DemandeSpec demandeCourante = null;
    while (it.hasNext())
    {
      demandeCourante = (DemandeSpec)it.next();
      
      demandeCourante.setEstDeneutralisable(false);
      if (demandeCourante == p_demandeDepart) {
        break;
      }
    }
  }
  
  public static boolean estUneAttributionPFM(AttributionSpec p_attribution)
  {
    boolean estAttributionPFM = false;
    if (p_attribution.getProduit().getNomUnique().equals("INR_PFM01_01")) {
      estAttributionPFM = true;
    }
    return estAttributionPFM;
  }
  
  public static boolean estUneAttributionAssCGE(AttributionSpec p_attribution)
  {
    boolean estAttributionASS = false;
    if (p_attribution.getProduit().getNomUnique().equals("SOL_CGE01_01")) {
      estAttributionASS = true;
    }
    return estAttributionASS;
  }
  
  public static void deneutraliserDroitSpectacle(IndividuSpec p_individu)
    throws CoucheLogiqueException
  {
    FiltreET filtre = new FiltreET();
    filtre.ajouterFiltre(new FiltreAttributionSurDecisions());
    filtre.ajouterFiltre(new FiltreNegation(new FiltreReexamenSurDemande()));
    AttributionSpec premiereAttribution = (AttributionSpec)OutilRecherche.rechercherDecisionSuivante(p_individu.getChronoDemandes(), Damj.NUIT_DES_TEMPS, filtre);
    if (premiereAttribution != null)
    {
      boolean estUnDroitSpe = OutilsMigration.estDroitSpectacle(premiereAttribution.getDemande());
      if (estUnDroitSpe)
      {
        if (!premiereAttribution.getDemande().estDeneutralisable()) {
          throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_CONTEXTE", "Déneutraliser Première Demande : un droit spectacle ne doit pas être figé");
        }
        OutilsMigration.deneutraliserEnCascade(premiereAttribution.getDemande());
      }
    }
  }
}

/* Location:
 * Qualified Name:     OutilsMigrationLiquidation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */