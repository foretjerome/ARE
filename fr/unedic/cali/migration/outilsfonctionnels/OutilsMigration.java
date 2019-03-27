package fr.unedic.cali.migration.outilsfonctionnels;

import fr.unedic.cali.autresdoms.cohab.parcours.DomMigration;
import fr.unedic.cali.autresdoms.cohab.parcours.ResultatMigration;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ProduitAsuCge01P02;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.ComparateurSurDateDeclenchementDemandeDecroissante;
import fr.unedic.cali.outilsfonctionnels.ComparateurSurDateDeclenchementEtPrioriteDemande;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreAttributionSurDecisions;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.Damj;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class OutilsMigration
{
  public static void controlerCoherenceDemandesFigees(IndividuSpec p_individu)
    throws CoucheLogiqueException
  {
    controlerCoherenceDemandesFigees(p_individu, null);
  }
  
  public static void controlerCoherenceDemandesFigees(IndividuSpec p_individu, DemandeSpec p_demandePointDeDepart)
    throws CoucheLogiqueException
  {
    if (!p_individu.getChronoDemandes().estVide())
    {
      Chronologie chronoDemandesCandidates = null;
      if (p_demandePointDeDepart != null)
      {
        chronoDemandesCandidates = OutilRecherche.rechercherDemandesSuivantes(p_individu.getChronoDemandes(), p_demandePointDeDepart, null);
        
        chronoDemandesCandidates = chronoDemandesCandidates.copier(null);
        
        chronoDemandesCandidates.ajouter(p_demandePointDeDepart);
      }
      else
      {
        chronoDemandesCandidates = p_individu.getChronoDemandes();
      }
      Chronologie chronoDemandesDecroissante = chronoDemandesCandidates;
      chronoDemandesDecroissante.setComparateur(new ComparateurSurDateDeclenchementDemandeDecroissante());
      Iterator it = chronoDemandesDecroissante.iterer();
      
      DemandeSpec demande = null;
      DemandeSpec demandePrec = null;
      
      boolean presenceDemandeFigee = false;
      while (it.hasNext())
      {
        demande = (DemandeSpec)it.next();
        if (estFigee(demande)) {
          presenceDemandeFigee = true;
        }
        if ((presenceDemandeFigee) && (!estFigee(demande))) {
          if (demande.getClassementAdministratif() != null) {
            demande.setEstDeneutralisable(false);
          } else {
            throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_CONTEXTE", "Il existe une demande non figée avant la demande du " + getDateDemande(demandePrec));
          }
        }
        demandePrec = demande;
      }
    }
  }
  
  public static void deneutraliserEnCascade(DemandeSpec p_demande)
    throws CoucheLogiqueException
  {
    controlerCoherenceDemandesFigees(p_demande.getDemandeur(), p_demande);
    if (estFigee(p_demande)) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_DENEUTRALISER_DEMANDE_FIGEE");
    }
    p_demande.setEstDeneutralisable(false);
    p_demande.setEstNeutraliseeLiquidation(false);
    p_demande.setEstNeutraliseeCalcul(false);
    
    Chronologie listeDemandesMigrees = OutilRecherche.rechercherDemandesSuivantes(p_demande.getDemandeur().getChronoDemandes(), p_demande, null);
    
    DemandeSpec demande = null;
    
    listeDemandesMigrees.iterer();
    while (listeDemandesMigrees.encoreSuivant())
    {
      demande = (DemandeSpec)listeDemandesMigrees.elementSuivant();
      if (estFigee(demande)) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_DENEUTRALISER_DEMANDE_FIGEE");
      }
      demande.setEstDeneutralisable(false);
      demande.setEstNeutraliseeLiquidation(false);
      demande.setEstNeutraliseeCalcul(false);
    }
  }
  
  private static String getDateDemande(DemandeSpec p_demande)
  {
    String dateDemande = "";
    if (p_demande.getDateDeclenchementExamen() != null) {
      dateDemande = p_demande.getDateDeclenchementExamen().toString();
    }
    return dateDemande;
  }
  
  public static boolean estFigee(DemandeSpec p_demande)
  {
    if ((p_demande.estNeutraliseeLiquidation()) && (!p_demande.estDeneutralisable())) {
      return true;
    }
    return false;
  }
  
  public static void controlerCoherenceNeutralisationDemandes(IndividuSpec p_individu)
    throws CoucheLogiqueException
  {
    Iterator it = p_individu.getChronoDemandes().iterer();
    while (it.hasNext())
    {
      DemandeSpec demandeCourante = (DemandeSpec)it.next();
      if (((!demandeCourante.estDeneutralisable()) && (!demandeCourante.estNeutraliseeLiquidation()) && (demandeCourante.estNeutraliseeCalcul() == true)) || ((demandeCourante.estDeneutralisable() == true) && (!demandeCourante.estNeutraliseeLiquidation()) && (!demandeCourante.estNeutraliseeCalcul())) || ((demandeCourante.estDeneutralisable() == true) && (!demandeCourante.estNeutraliseeLiquidation()) && (demandeCourante.estNeutraliseeCalcul() == true)) || ((demandeCourante.estDeneutralisable() == true) && (demandeCourante.estNeutraliseeLiquidation() == true) && (!demandeCourante.estNeutraliseeCalcul()))) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_TOPS_DEMANDE_INCOHERENTS", new Object[] { getDateDemande(demandeCourante) });
      }
    }
  }
  
  public static boolean estUnDEEnCoursDIndemnisation(DomMigration p_migration)
  {
    boolean resultat = false;
    if ((p_migration.getContexteMigration() != null) && (p_migration.getContexteMigration().equals("E"))) {
      resultat = true;
    }
    return resultat;
  }
  
  public static AttributionSpec getAttributionEnCoursDIndemnisation(DomMigration p_migration, IndividuSpec p_individuMigre)
  {
    if (estUnDEEnCoursDIndemnisation(p_migration)) {
      return (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(p_individuMigre.getChronoDemandes(), Damj.FIN_DES_TEMPS, new FiltreAttributionSurDecisions(true));
    }
    return null;
  }
  
  public static boolean estUneMigrationSimplifieeForcee(DomMigration p_migration)
  {
    if (p_migration.getAutorisationTypeMigration().equals("F")) {
      return true;
    }
    return false;
  }
  
  public static boolean migrationSimplifieeAutorisee(DomMigration p_migration, Collection p_listeDemandesEnEcartCalcul, IndividuSpec p_individuMigre)
  {
    boolean migrationSimplifieeAutorisee = false;
    if (!OutilsMigrationCalculEcarts.presenceEcartsCalculMontantSurDernierDroit(p_listeDemandesEnEcartCalcul, p_individuMigre))
    {
      String autorisationMigrationSimplifiee = p_migration.getAutorisationTypeMigration();
      if (autorisationMigrationSimplifiee.equalsIgnoreCase(""))
      {
        migrationSimplifieeAutorisee = false;
      }
      else if (autorisationMigrationSimplifiee.equalsIgnoreCase("I"))
      {
        boolean presenceEcartsDroitEnCours = false;
        
        presenceEcartsDroitEnCours = OutilsMigrationCalculEcarts.presenceEcartsDroitEnCours(p_listeDemandesEnEcartCalcul, p_migration);
        if (presenceEcartsDroitEnCours) {
          migrationSimplifieeAutorisee = false;
        } else {
          migrationSimplifieeAutorisee = true;
        }
      }
      else if (autorisationMigrationSimplifiee.equalsIgnoreCase("E"))
      {
        migrationSimplifieeAutorisee = true;
      }
    }
    else
    {
      migrationSimplifieeAutorisee = false;
    }
    return migrationSimplifieeAutorisee;
  }
  
  public static void enrichirResultatMigration(Collection p_listeDemandesEnEcartCalcul, ResultatMigration p_resultatMigration, boolean p_basculeMigrationSimplifiee, DomMigration p_migration)
    throws CoucheLogiqueException
  {
    if (p_basculeMigrationSimplifiee)
    {
      p_resultatMigration.setDdorkb(determinerDdorkbEnMigrationSimplifiee(p_migration.getIndividu()));
      
      p_resultatMigration.setMigreEnSimplifie(true);
    }
    else
    {
      p_resultatMigration.setDdorkb(determinerDdorkbEnMigrationStandard(p_migration.getIndividu()));
      
      p_resultatMigration.setPresenceEcartDroitEnCours(OutilsMigrationCalculEcarts.presenceEcartsDroitEnCours(p_listeDemandesEnEcartCalcul, p_migration));
      
      p_resultatMigration.setPresenceEcartDroitsPasses(OutilsMigrationCalculEcarts.presenceEcartsDroitsPasses(p_listeDemandesEnEcartCalcul, p_migration));
    }
    p_resultatMigration.setRsodnc(Integer.valueOf(determinerRsodnc(p_migration.getIndividu(), p_migration)).intValue());
  }
  
  public static Damj determinerDdorkbEnMigrationSimplifiee(IndividuSpec p_individu)
    throws CoucheLogiqueException
  {
    Damj ddorkbV2 = null;
    Damj ddorkbV1 = p_individu.getDdorkb();
    
    AttributionSpec premiereAttributionNonFigee = getPremiereAttributionNonFigee(p_individu);
    if (premiereAttributionNonFigee != null)
    {
      ddorkbV2 = premiereAttributionNonFigee.getDateAttribution();
    }
    else
    {
      AttributionSpec derniereAttributionFigee = getDerniereAttributionFigee(p_individu);
      if ((derniereAttributionFigee != null) && (derniereAttributionFigee.getCalendrierExecutionCalcul() != null)) {
        ddorkbV2 = derniereAttributionFigee.getCalendrierExecutionCalcul().getDernierJourIndemnisable().lendemain();
      }
    }
    if (ddorkbV2 != null)
    {
      if (ddorkbV2.estAvant(ddorkbV1)) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_DDORKB_NCP_AVANT_DDORKB_V1", new Object[] { " DDORKB V1:" + ddorkbV1 + " DDORKB V2:" + ddorkbV2 });
      }
    }
    else {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_DDORKB_NCP_NULLE");
    }
    return ddorkbV2;
  }
  
  public static Damj determinerDdorkbEnMigrationStandard(IndividuSpec p_individu)
    throws CoucheLogiqueException
  {
    Damj ddorkbV2 = null;
    Damj ddorkbV1 = p_individu.getDdorkb();
    
    AttributionSpec premiereAttributionNonFigee = getPremiereAttributionNonFigee(p_individu);
    if (premiereAttributionNonFigee != null)
    {
      ddorkbV2 = premiereAttributionNonFigee.getDateAttribution();
      if (ddorkbV2.estAvant(ddorkbV1)) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_DDORKB_NCP_AVANT_DDORKB_V1", new Object[] { " DDORKB V1:" + ddorkbV1 + " DDORKB V2:" + ddorkbV2 });
      }
      AttributionSpec derniereAttributionFigee = getDerniereAttributionFigee(p_individu);
      Damj djiDerniereAttributionFigee = null;
      if ((derniereAttributionFigee != null) && (derniereAttributionFigee.getCalendrierExecutionCalcul() != null))
      {
        djiDerniereAttributionFigee = derniereAttributionFigee.getCalendrierExecutionCalcul().getDernierJourIndemnisable().lendemain();
        if (djiDerniereAttributionFigee.estApres(ddorkbV2)) {
          GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_DJI_DROIT_FIGE_APRES_DDORKB_V2", new Object[] { " Dernier DJI Figee:" + djiDerniereAttributionFigee + " DDORKB V2:" + ddorkbV2 });
        }
      }
    }
    else
    {
      AttributionSpec derniereAttributionFigee = getDerniereAttributionFigee(p_individu);
      if ((derniereAttributionFigee != null) && (derniereAttributionFigee.getCalendrierExecutionCalcul() != null))
      {
        ddorkbV2 = derniereAttributionFigee.getCalendrierExecutionCalcul().getDernierJourIndemnisable().lendemain();
        if (ddorkbV2.estApres(ddorkbV1)) {
          GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_DDORKB_NCP_APRES_DDORKB_V1", new Object[] { " DDORKB V1:" + ddorkbV1 + " DDORKB V2:" + ddorkbV2 });
        }
      }
    }
    return ddorkbV1;
  }
  
  public static AttributionSpec getDerniereAttributionFigee(IndividuSpec p_individu)
  {
    AttributionSpec derniereAttributionFigee = null;
    boolean estTrouve = false;
    
    ChronologieDebuts chronoDemandes = p_individu.getChronoDemandes();
    
    chronoDemandes.setComparateur(new ComparateurSurDateDeclenchementDemandeDecroissante());
    Iterator it = chronoDemandes.iterer();
    
    DemandeSpec demande = null;
    while ((it.hasNext()) && (!estTrouve))
    {
      demande = (DemandeSpec)it.next();
      
      List listedossierExamen = demande.getListeDossiersExamen();
      Iterator iter = listedossierExamen.iterator();
      while (iter.hasNext())
      {
        Object objet = iter.next();
        if ((objet instanceof AttributionSpec))
        {
          AttributionSpec attribution = (AttributionSpec)objet;
          if (estFigee(demande))
          {
            derniereAttributionFigee = attribution;
            estTrouve = true;
          }
        }
      }
    }
    return derniereAttributionFigee;
  }
  
  public static String determinerRsodnc(IndividuSpec p_individu, DomMigration p_domMigration)
  {
    String rsodnc = "0";
    
    AttributionSpec attributionEnCours = getAttributionEnCoursDIndemnisation(p_domMigration, p_individu);
    if ((attributionEnCours != null) && 
      (attributionEnCours.getDemande().estMigreeEnSimplifiee())) {
      rsodnc = attributionEnCours.getRsod();
    }
    AttributionSpec premiereAttributionNonFigee = getPremiereAttributionNonFigee(p_individu);
    if (premiereAttributionNonFigee != null) {
      rsodnc = premiereAttributionNonFigee.getRsod();
    }
    return rsodnc;
  }
  
  public static AttributionSpec getPremiereAttributionNonFigee(IndividuSpec p_individu)
  {
    ChronologieDebuts chronoDemandes = p_individu.getChronoDemandes();
    
    chronoDemandes.setComparateur(new ComparateurSurDateDeclenchementEtPrioriteDemande());
    Iterator it = chronoDemandes.iterer();
    
    DemandeSpec demande = null;
    AttributionSpec premiereAttributionNonFigee = null;
    while (it.hasNext())
    {
      demande = (DemandeSpec)it.next();
      if ((demande.getDossierAffectation().getDossierExamen() != null) && ((demande.getDossierAffectation().getDossierExamen() instanceof AttributionSpec)) && 
      
        (!estFigee(demande))) {
        premiereAttributionNonFigee = (AttributionSpec)demande.getDossierAffectation().getDossierExamen();
      }
    }
    return premiereAttributionNonFigee;
  }
  
  public static boolean blocageLiquidationDroitMigree(DemandeSpec p_demande)
  {
    return (p_demande.estMigree()) && (!p_demande.estLiquidable());
  }
  
  public static boolean blocageLiquidationAre2001Migree(DemandeSpec p_demande)
  {
    return estDroitAre2001(p_demande);
  }
  
  public static boolean estDroitAre2001(DemandeSpec p_demande)
  {
    boolean estDroitAre2001 = false;
    try
    {
      if ((p_demande.getDossierAffectation() != null) && (p_demande.getDossierAffectation().getDossierExamen() != null) && ((p_demande.getDossierAffectation().getDossierExamen() instanceof AttributionSpec)))
      {
        AttributionSpec attribution = (AttributionSpec)p_demande.getDossierAffectation().getDossierExamen();
        if ((attribution.getProduit().equals(ProduitAsuCge01P02.getInstance())) && 
          (attribution.getSituationParticuliere().equalsIgnoreCase("1"))) {
          estDroitAre2001 = true;
        }
      }
    }
    catch (UnsupportedOperationException ex)
    {
      estDroitAre2001 = false;
    }
    return estDroitAre2001;
  }
  
  public static boolean estDroitSpectacle(DemandeSpec p_demande)
  {
    boolean estDroitSpectacle = false;
    try
    {
      if ((p_demande.getDossierAffectation() != null) && (p_demande.getDossierAffectation().getDossierExamen() != null) && ((p_demande.getDossierAffectation().getDossierExamen() instanceof AttributionSpec)))
      {
        AttributionSpec attribution = (AttributionSpec)p_demande.getDossierAffectation().getDossierExamen();
        switch (attribution.getProduit().getCode())
        {
        case 3: 
        case 20: 
          estDroitSpectacle = true;
        }
      }
    }
    catch (UnsupportedOperationException ex)
    {
      estDroitSpectacle = false;
    }
    return estDroitSpectacle;
  }
}

/* Location:
 * Qualified Name:     OutilsMigration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */