package fr.unedic.cali.outilsfonctionnels.reexecution;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementTPDefaut;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilComportement;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionSuivi;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.ComportementExamenFilEauSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.ElementComparaisonReexamen;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.ResultatAppelCalcul;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.migration.outilsfonctionnels.OutilsMigration;
import fr.unedic.cali.outilsfonctionnels.AppelCalcul;
import fr.unedic.cali.outilsfonctionnels.ComparateurSurDateDeclenchementEtPrioriteDemande;
import fr.unedic.cali.outilsfonctionnels.EvenementReexamen;
import fr.unedic.cali.outilsfonctionnels.ExamenAuFilEauManager;
import fr.unedic.cali.outilsfonctionnels.GestionAnomalies;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.MiseEnReexamenDemande;
import fr.unedic.cali.outilsfonctionnels.OutilComportementExamenFilEau;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GestionnaireReexecution
  implements GestionnaireReexecutionSpec
{
  private static final int NB_LIQUIDATION_POUR_DETECTION_BOUCLE_INFINIE = 5;
  private static final boolean RETOUR_ARRIERE_DATE_EXECUTION = true;
  
  public ResultatGestionnaireReexecutionSpec executer(DemandeSpec demande, EvenementReexamen evenement)
    throws ApplicativeException
  {
    return executer(demande.getDemandeur(), evenement);
  }
  
  public ResultatGestionnaireReexecutionSpec executer(IndividuSpec individu, EvenementReexamen evenement)
    throws ApplicativeException
  {
    return executer(individu, evenement, getComportementParDefaut());
  }
  
  public ResultatGestionnaireReexecutionSpec executer(IndividuSpec individu, EvenementReexamen evenement, ComportementSpec comportement)
    throws ApplicativeException
  {
    OutilGestionnaireReexecution outilGestionnaireReexecution = OutilGestionnaireReexecution.getInstance();
    
    DomGestionnaireReexecution domGestionnaireReexecution = new DomGestionnaireReexecution();
    domGestionnaireReexecution.setEvenementReexamen(evenement);
    domGestionnaireReexecution.setIndividu(individu);
    domGestionnaireReexecution.setComportement(comportement);
    if (individu.getContexteService() != null) {
      domGestionnaireReexecution.setContexteEmission(individu.getContexteService().getContexteEmission());
    }
    domGestionnaireReexecution.setDateReexecutionInitiale(determinerDateReexecutionInitiale(domGestionnaireReexecution));
    
    domGestionnaireReexecution.setListeDemandesAReliquiderInitiale(outilGestionnaireReexecution.recupererDemandesAReliquider(domGestionnaireReexecution.getIndividu(), domGestionnaireReexecution.getDateReexecutionInitiale(), getPrioriteParDefaut(), getPrioriteParDefaut(), null, false, true, false));
    
    domGestionnaireReexecution.setListeAttributionsAReexecuter(outilGestionnaireReexecution.recupererAttributionsAReexecuter(domGestionnaireReexecution.getIndividu(), domGestionnaireReexecution.getDateReexecutionInitiale(), getPrioriteParDefaut(), comportement, getPrioriteParDefaut(), null));
    
    domGestionnaireReexecution.setListeAttributionsANettoyer(outilGestionnaireReexecution.recupererDemandesANettoyer(domGestionnaireReexecution.getIndividu(), domGestionnaireReexecution.getDateReexecutionInitiale(), getPrioriteParDefaut()));
    
    outilGestionnaireReexecution.completerListeDemandesAReliquiderInitialeParDemandesNpde(domGestionnaireReexecution.getListeDemandesAReliquiderInitiale(), domGestionnaireReexecution, individu.getChronoDemandesNonTriees(), domGestionnaireReexecution.getDateReexecutionInitiale());
    
    domGestionnaireReexecution.setListeAttributionsAReexecuter(OutilGestionnaireReexecution.getInstance().miseAJourAttributionsAReexecuter(domGestionnaireReexecution.getListeAttributionsAReexecuter(), domGestionnaireReexecution.getListeDemandesAReliquiderInitiale()));
    
    return lancerReexecution(domGestionnaireReexecution);
  }
  
  public ResultatGestionnaireReexecutionSpec executerSurInstallationDemande(DemandeSpec demande, EvenementReexamen evenement)
    throws ApplicativeException
  {
    evenement.setExecutionSuiteInstallationDemande(true);
    return executer(demande, evenement);
  }
  
  public ResultatGestionnaireReexecutionSpec executerSurReexamenManuel(DemandeSpec demandeAReexaminer)
    throws ApplicativeException
  {
    DomGestionnaireReexecution domGestionnaireReexecution = new DomGestionnaireReexecution();
    domGestionnaireReexecution.setIndividu(demandeAReexaminer.getDemandeur());
    domGestionnaireReexecution.setComportement(getComportementParDefaut());
    
    domGestionnaireReexecution.setDateReexecutionInitiale(getDateEvenement(demandeAReexaminer));
    domGestionnaireReexecution.setEvenementReexamen(new EvenementReexamen(domGestionnaireReexecution.getDateReexecutionInitiale(), "4"));
    
    domGestionnaireReexecution.setListeDemandesAReliquiderInitiale(OutilGestionnaireReexecution.getInstance().recupererDemandesAReliquider(domGestionnaireReexecution.getIndividu(), domGestionnaireReexecution.getDateReexecutionInitiale(), demandeAReexaminer.getGamme().getPriorite(), demandeAReexaminer.getEvenementReferenceExamen().getPriorite(), demandeAReexaminer.getFormulaire().getReferenceExterne(), false, true, false));
    
    domGestionnaireReexecution.setListeAttributionsAReexecuter(OutilGestionnaireReexecution.getInstance().recupererAttributionsAReexecuter(domGestionnaireReexecution.getIndividu(), domGestionnaireReexecution.getDateReexecutionInitiale(), demandeAReexaminer.getGamme().getPriorite(), getComportementParDefaut(), demandeAReexaminer.getEvenementReferenceExamen().getPriorite(), demandeAReexaminer.getFormulaire().getReferenceExterne()));
    
    domGestionnaireReexecution.setListeAttributionsANettoyer(OutilGestionnaireReexecution.getInstance().recupererDemandesANettoyer(domGestionnaireReexecution.getIndividu(), domGestionnaireReexecution.getDateReexecutionInitiale(), demandeAReexaminer.getGamme().getPriorite()));
    if (!domGestionnaireReexecution.getListeAttributionsANettoyer().contains(demandeAReexaminer)) {
      domGestionnaireReexecution.getListeAttributionsANettoyer().add(demandeAReexaminer);
    }
    domGestionnaireReexecution.setListeAttributionsAReexecuter(OutilGestionnaireReexecution.getInstance().miseAJourAttributionsAReexecuter(domGestionnaireReexecution.getListeAttributionsAReexecuter(), domGestionnaireReexecution.getListeDemandesAReliquiderInitiale()));
    
    return lancerReexecution(domGestionnaireReexecution);
  }
  
  public ResultatGestionnaireReexecutionSpec executerSurValidation(DemandeSpec demandeAValider)
    throws ApplicativeException
  {
    DomGestionnaireReexecution domGestionnaireReexecution = new DomGestionnaireReexecution();
    domGestionnaireReexecution.setIndividu(demandeAValider.getDemandeur());
    domGestionnaireReexecution.setDemandeAValider((DemandeSpec)demandeAValider.copie());
    domGestionnaireReexecution.setEvenementReexamen(new EvenementReexamen(getDateEvenement(demandeAValider), "27"));
    
    domGestionnaireReexecution.setComportement(getComportementParDefaut());
    
    domGestionnaireReexecution.setDateReexecutionInitiale(determinerDateDepartExecutionSurValidation(domGestionnaireReexecution, demandeAValider));
    
    boolean estNonReexecutionDemandesSuivantesActivee = demandeAValider.getDemandeur().isEstArretReexecution();
    int prioriteGamme;
    if (domGestionnaireReexecution.getDateReexecutionInitiale().equals(domGestionnaireReexecution.getEvenementReexamen().getDateReexamen()))
    {
      int prioriteGamme = demandeAValider.getGamme().getPriorite();
      int prioriteEre = demandeAValider.getEvenementReferenceExamen().getPriorite();
      domGestionnaireReexecution.setListeDemandesAReliquiderInitiale(OutilGestionnaireReexecution.getInstance().recupererDemandesAReliquider(domGestionnaireReexecution.getIndividu(), domGestionnaireReexecution.getDateReexecutionInitiale(), prioriteGamme, prioriteEre, demandeAValider.getFormulaire().getReferenceExterne(), !estNonReexecutionDemandesSuivantesActivee, true, true));
      
      domGestionnaireReexecution.getListeDemandesAReliquiderInitiale().remove(demandeAValider);
      
      domGestionnaireReexecution.setListeAttributionsAReexecuter(OutilGestionnaireReexecution.getInstance().recupererAttributionsAReexecuter(domGestionnaireReexecution.getIndividu(), domGestionnaireReexecution.getDateReexecutionInitiale(), prioriteGamme, domGestionnaireReexecution.getComportement(), prioriteEre, demandeAValider.getFormulaire().getReferenceExterne()));
    }
    else
    {
      prioriteGamme = getPrioriteParDefaut();
      int prioriteEre = getPrioriteParDefaut();
      domGestionnaireReexecution.setListeDemandesAReliquiderInitiale(OutilGestionnaireReexecution.getInstance().recupererDemandesAReliquider(domGestionnaireReexecution.getIndividu(), domGestionnaireReexecution.getDateReexecutionInitiale(), prioriteGamme, prioriteEre, null, !estNonReexecutionDemandesSuivantesActivee, true, true));
      
      domGestionnaireReexecution.setListeAttributionsAReexecuter(OutilGestionnaireReexecution.getInstance().recupererAttributionsAReexecuter(domGestionnaireReexecution.getIndividu(), domGestionnaireReexecution.getDateReexecutionInitiale(), prioriteGamme, domGestionnaireReexecution.getComportement(), prioriteEre, null));
    }
    domGestionnaireReexecution.setListeAttributionsANettoyer(OutilGestionnaireReexecution.getInstance().recupererDemandesANettoyer(domGestionnaireReexecution.getIndividu(), domGestionnaireReexecution.getDateReexecutionInitiale(), prioriteGamme));
    if (!domGestionnaireReexecution.getListeDemandesAReliquiderInitiale().contains(demandeAValider)) {
      OutilGestionnaireReexecution.getInstance().ajouterAttributionAReexecuter(domGestionnaireReexecution.getListeAttributionsAReexecuter(), demandeAValider);
    }
    if (domGestionnaireReexecution.getListeAttributionsANettoyer().contains(demandeAValider)) {
      domGestionnaireReexecution.getListeAttributionsANettoyer().remove(demandeAValider);
    }
    OutilGestionnaireReexecution.getInstance().ajouterDemandeFinDroit(demandeAValider, domGestionnaireReexecution.getListeDemandesAReliquiderInitiale());
    
    domGestionnaireReexecution.setListeAttributionsAReexecuter(OutilGestionnaireReexecution.getInstance().miseAJourAttributionsAReexecuter(domGestionnaireReexecution.getListeAttributionsAReexecuter(), domGestionnaireReexecution.getListeDemandesAReliquiderInitiale()));
    
    return lancerReexecution(domGestionnaireReexecution);
  }
  
  private Damj determinerDateReexecutionInitiale(DomGestionnaireReexecution donnees)
    throws CoucheLogiqueException
  {
    return OutilGestionnaireReexecution.getInstance().determinerDateReexecutionInitiale(donnees);
  }
  
  private Damj getDateEvenement(DemandeSpec demande)
  {
    Damj dateEvenement = demande.getDateRecherche();
    Damj dateAttribution = null;
    Damj pji = null;
    
    List<DossierExamenSpec> listeDossierExamen = demande.getListeDossiersExamen();
    if ((listeDossierExamen != null) && (!listeDossierExamen.isEmpty()) && (((DossierExamenSpec)listeDossierExamen.get(0)).getDateAttribution() != null))
    {
      dateAttribution = ((DossierExamenSpec)listeDossierExamen.get(0)).getDateAttribution();
      if ((listeDossierExamen.get(0) instanceof AttributionSpec)) {
        pji = ((AttributionSpec)listeDossierExamen.get(0)).getPji();
      }
    }
    if (dateAttribution != null) {
      dateEvenement = Damj.min(dateEvenement, dateAttribution);
    }
    if (pji != null) {
      dateEvenement = Damj.min(dateEvenement, pji);
    }
    return dateEvenement;
  }
  
  private Damj determinerDateDepartExecutionSurValidation(DomGestionnaireReexecution donnees, DemandeSpec demandeAValider)
    throws CoucheLogiqueException
  {
    Damj dateReexecutionInitiale = getDateEvenement(demandeAValider);
    
    return dateReexecutionInitiale;
  }
  
  private ResultatGestionnaireReexecution lancerReexecution(DomGestionnaireReexecution donnees)
    throws ApplicativeException
  {
    ResultatGestionnaireReexecution resultat = new ResultatGestionnaireReexecution();
    
    boolean estExecutionTerminee = false;
    
    donnees.setDateReexecutionCourante(donnees.getDateReexecutionInitiale());
    donnees.getListeDemandesAReliquider().addAll(donnees.getListeDemandesAReliquiderInitiale());
    ComportementSpec comportementCourant = donnees.getComportement();
    
    OutilsMigration.controlerCoherenceNeutralisationDemandes(donnees.getIndividu());
    
    MiseEnReexamenDemande.miseEnReexamen(donnees.getListeDemandesAReliquider());
    
    initialiserCalcul(donnees.getIndividu(), donnees.getListeAttributionsANettoyer(), donnees.getListeAttributionsAReexecuter(), donnees.getDateReexecutionInitiale());
    while (!estExecutionTerminee)
    {
      GestionSuivi.nettoyerIndividuPbjcNcp(donnees.getIndividu(), donnees.getDateReexecutionInitiale());
      
      appelCalcul(donnees.getIndividu(), donnees.getListeAttributionsAReexecuter(), donnees.getDateReexecutionCourante(), null, donnees.getComportement());
      
      ordonnerDemandes(donnees.getListeDemandesAReliquider());
      DemandeSpec prochaineDemandeAReliquider = OutilGestionnaireReexecution.getInstance().recupererProchaineDemande(donnees.getListeDemandesAReliquider());
      if (prochaineDemandeAReliquider != null)
      {
        detecterBoucleInfinie(donnees, prochaineDemandeAReliquider);
        
        comportementCourant = getProchainComportementAAppliquer(comportementCourant);
        ComportementSpec comportementSpecifique = getComportementSpecifique(donnees, comportementCourant, prochaineDemandeAReliquider);
        
        ResultatLiquidation resultatLiquidation = OutilLiquidation.getInstance().liquider(prochaineDemandeAReliquider, comportementSpecifique);
        
        resultat.getResultatLiquidationSurDemande().put(prochaineDemandeAReliquider, resultatLiquidation.getListeElementComparaison());
        
        traiterEtatLiquidation(donnees, resultat, prochaineDemandeAReliquider, resultatLiquidation);
        
        donnees.setDateReexecutionCourante(OutilGestionnaireReexecution.getInstance().getDateExecution(prochaineDemandeAReliquider));
        
        donnees.getListeDemandesAReliquider().remove(prochaineDemandeAReliquider);
      }
      else
      {
        estExecutionTerminee = true;
      }
    }
    resultat.setDateReexecution(donnees.getDateReexecutionInitiale());
    ordonnerDemandes(donnees.getListeDemandesAReliquiderInitiale());
    resultat.getDemandesReliquidees().addAll(donnees.getListeDemandesAReliquiderInitiale());
    resultat.getAttributionsReexecutees().addAll(donnees.getListeAttributionsAReexecuter());
    if (OutilFluxSigma.estCalculEffectue(donnees.getIndividu())) {
      donnees.getIndividu().enregistrerLA2K(donnees.getIndividu(), donnees.getEvenementReexamen().getDateReexamen() != null ? donnees.getEvenementReexamen().getDateReexamen().getDebutMois() : null, donnees.getIndividu().getContexteService(), 0);
    }
    if ((donnees.getIndividu() == null) || (!donnees.getIndividu().isEstDesactEFE())) {
      executerExamenAuFilEau(donnees);
    }
    traiterMiseEnReexamen(donnees.getListeDemandesAReliquiderInitiale(), resultat.getResultatLiquidationSurDemande());
    
    alimenterDateAtteinteCumulMoisNiSurIndividu(donnees);
    
    return resultat;
  }
  
  private void traiterEtatLiquidation(DomGestionnaireReexecution donnees, ResultatGestionnaireReexecution resultat, DemandeSpec prochaineDemandeAReliquider, ResultatLiquidation resultatLiquidation)
    throws CoucheLogiqueException
  {
    switch (resultatLiquidation.getEtatLiquidation())
    {
    case 3: 
      traiterEtatRecondution(donnees, prochaineDemandeAReliquider);
      break;
    case 0: 
    case 1: 
      traiterEtatNonReconduit(donnees, prochaineDemandeAReliquider, resultat);
      break;
    }
  }
  
  private void traiterEtatRecondution(DomGestionnaireReexecution donnees, DemandeSpec prochaineDemandeAReliquider)
  {
    OutilGestionnaireReexecution.getInstance().ajouterAttributionAReexecuter(donnees.getListeAttributionsAReexecuter(), prochaineDemandeAReliquider);
    
    miseAJourListeDemandesALiquider(donnees, prochaineDemandeAReliquider, donnees.getDemandeAValider() != null);
  }
  
  private void traiterEtatNonReconduit(DomGestionnaireReexecution donnees, DemandeSpec prochaineDemandeAReliquider, ResultatGestionnaireReexecution resultat)
    throws CoucheLogiqueException
  {
    if ((donnees.getDemandeAValider() != null) && (donnees.getDemandeAValider().getFormulaire().getReferenceExterne().equals(prochaineDemandeAReliquider.getFormulaire().getReferenceExterne()))) {
      GestionnaireErreur.getInstance().genererException("HG_PR_CALI_L_GESTIONNAIRE_REEXECUTION_REEXAMEN", new Object[] { donnees.getDateReexecutionInitiale() }, 1);
    }
    resultat.setDemandeEnReexamen(true);
    MiseEnReexamenDemande.miseEnReexamen(prochaineDemandeAReliquider, donnees.getEvenementReexamen());
  }
  
  private void initialiserCalcul(IndividuSpec individu, List<DemandeSpec> demandesANettoyer, List<AttributionSpec> attributionInvalides, Damj dateNettoyage)
    throws ApplicativeException
  {
    AppelCalcul.nettoyerCalcul(individu, demandesANettoyer, attributionInvalides, dateNettoyage, 0);
    
    GestionAnomalies.nettoyerAnomalieSansDate(individu);
    GestionSuivi.nettoyerIndividuPbjcNcp(individu, dateNettoyage);
  }
  
  private ResultatAppelCalcul appelCalcul(IndividuSpec individu, List<AttributionSpec> attributions, Damj dateDebut, Damj dateProchaineDemande, ComportementSpec comportement)
    throws ApplicativeException
  {
    return AppelCalcul.effectuerCalcul(individu, attributions, dateDebut, dateProchaineDemande, comportement);
  }
  
  private List<DemandeSpec> ordonnerDemandes(List<DemandeSpec> demandes)
  {
    Iterator<DemandeSpec> iterDemandes = demandes.iterator();
    while (iterDemandes.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)iterDemandes.next();
      demande.getEvenementReferenceExamen().setDateDeclenchementExamen(null);
    }
    Collections.sort(demandes, new ComparateurSurDateDeclenchementEtPrioriteDemande());
    return demandes;
  }
  
  private ComportementSpec getProchainComportementAAppliquer(ComportementSpec comportement)
  {
    return OutilComportement.definirProchainComportementAAppliquer(comportement);
  }
  
  private ComportementSpec getComportementSpecifique(DomGestionnaireReexecution donnees, ComportementSpec comportement, DemandeSpec demandeALiquider)
  {
    ComportementSpec comportementARetourner = comportement;
    if (((donnees.getDemandeAValider() != null) && (getDateEvenement(demandeALiquider).estAvantOuCoincideAvec(donnees.getEvenementReexamen().getDateReexamen()))) || (getDateEvenement(demandeALiquider).estAvant(donnees.getEvenementReexamen().getDateReexamen()))) {
      comportementARetourner = comportement.getComportementSansReexamenAuto();
    }
    return comportementARetourner;
  }
  
  private void detecterBoucleInfinie(DomGestionnaireReexecution donnees, DemandeSpec demandeALiquider)
    throws CoucheLogiqueException
  {
    Integer compteur = (Integer)donnees.getCompteurLiquidationDemande().get(demandeALiquider);
    if (compteur == null)
    {
      compteur = Integer.valueOf(0);
    }
    else if (compteur.intValue() >= 5)
    {
      OutilTrace.ecrireTrace(Niveau.ERROR, new Object[] { "Erreur lors de la réexécution du dossier : veuillez vérifier l'ordonnancement des demandes (date depôt)" });
      
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_GESTIONNAIRE_REEXECUTION_BOUCLE");
    }
    compteur = Integer.valueOf(compteur.intValue() + 1);
    donnees.getCompteurLiquidationDemande().put(demandeALiquider, compteur);
  }
  
  private void miseAJourListeDemandesALiquider(DomGestionnaireReexecution donnees, DemandeSpec demandeLiquidee, boolean estValidationDecision)
  {
    List<DemandeSpec> nouvellesDemandesAReliquiderValidees = OutilGestionnaireReexecution.getInstance().recupererDemandesAReliquider(donnees.getIndividu(), OutilGestionnaireReexecution.getInstance().getDateExecution(demandeLiquidee), demandeLiquidee.getGamme().getPriorite(), demandeLiquidee.getEvenementReferenceExamen().getPriorite(), demandeLiquidee.getFormulaire().getReferenceExterne(), false, false, estValidationDecision);
    
    nouvellesDemandesAReliquiderValidees.remove(demandeLiquidee);
    
    OutilGestionnaireReexecution.getInstance().ajouterDemandeFinDroit(demandeLiquidee, nouvellesDemandesAReliquiderValidees);
    
    donnees.setListeAttributionsAReexecuter(OutilGestionnaireReexecution.getInstance().miseAJourAttributionsAReexecuter(donnees.getListeAttributionsAReexecuter(), nouvellesDemandesAReliquiderValidees));
    
    List<DemandeSpec> nouvellesDemandesAReliquiderParmisInitiales = OutilGestionnaireReexecution.getInstance().recupererDemandesAReliquider(donnees.getListeDemandesAReliquiderInitiale(), OutilGestionnaireReexecution.getInstance().getDateExecution(demandeLiquidee), demandeLiquidee.getGamme().getPriorite(), demandeLiquidee.getEvenementReferenceExamen().getPriorite(), demandeLiquidee.getFormulaire().getReferenceExterne(), true, false, estValidationDecision);
    
    nouvellesDemandesAReliquiderParmisInitiales.remove(demandeLiquidee);
    
    OutilGestionnaireReexecution.getInstance().ajouterDemandesALiquiderSansDoublon(nouvellesDemandesAReliquiderValidees, nouvellesDemandesAReliquiderParmisInitiales);
    
    MiseEnReexamenDemande.miseEnReexamen(nouvellesDemandesAReliquiderValidees);
    OutilGestionnaireReexecution.getInstance().ajouterDemandesALiquiderSansDoublon(donnees.getListeDemandesAReliquider(), nouvellesDemandesAReliquiderValidees);
    
    OutilGestionnaireReexecution.getInstance().ajouterDemandesALiquiderSansDoublon(donnees.getListeDemandesAReliquiderInitiale(), nouvellesDemandesAReliquiderValidees);
  }
  
  private void executerExamenAuFilEau(DomGestionnaireReexecution donnees)
    throws ApplicativeException
  {
    if (("1".equals(donnees.getEvenementReexamen().getTypeReexamen())) || ("27".equals(donnees.getEvenementReexamen().getTypeReexamen())) || ("4".equals(donnees.getEvenementReexamen().getTypeReexamen())) || ("5".equals(donnees.getEvenementReexamen().getTypeReexamen())))
    {
      ComportementExamenFilEauSpec comportementEfe = OutilComportementExamenFilEau.getComportementAutomatique();
      
      comportementEfe.setDateEvenementDeclencheur(donnees.getEvenementReexamen().getDateReexamen());
      if (donnees.getEvenementReexamen().getTypeReexamen() != null) {
        comportementEfe.setNatureEvenementDeclencheur(Integer.parseInt(donnees.getEvenementReexamen().getTypeReexamen()));
      }
      ExamenAuFilEauManager.executerExamenFilEau(donnees.getIndividu(), comportementEfe);
    }
  }
  
  private int getPrioriteParDefaut()
  {
    return 100;
  }
  
  private ComportementSpec getComportementParDefaut()
  {
    return new ComportementTPDefaut();
  }
  
  private void traiterMiseEnReexamen(List<DemandeSpec> listeDemandesAReliquiderInitiale, HashMap<DemandeSpec, List<ElementComparaisonReexamen>> resultatLiquidationSurDemande)
  {
    Iterator<DemandeSpec> it = listeDemandesAReliquiderInitiale.iterator();
    while (it.hasNext())
    {
      DemandeSpec demandeCourante = (DemandeSpec)it.next();
      if (demandeCourante.estEnReExamen())
      {
        List<ElementComparaisonReexamen> listeElementsComparaison = (List)resultatLiquidationSurDemande.get(demandeCourante);
        demandeCourante.getGamme().traiterMiseEnReexamen(demandeCourante, listeElementsComparaison);
      }
    }
  }
  
  private void alimenterDateAtteinteCumulMoisNiSurIndividu(DomGestionnaireReexecution donnees)
  {
    if ((donnees.getIndividu().getIndividuPbjcNcp() != null) && (donnees.getIndividu().getIndividuPbjcNcp().getDateAtteinteMoisNonPaye() != null) && (!OutilRecherche.rechercherDecisionsSuivantes(donnees.getIndividu().getChronoDemandeAssurance(), donnees.getIndividu().getIndividuPbjcNcp().getDateAtteinteMoisNonPaye(), null).estVide())) {
      donnees.getIndividu().getIndividuPbjcNcp().setDateAtteinteMoisNonPaye(null);
    }
  }
}

/* Location:
 * Qualified Name:     GestionnaireReexecution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */