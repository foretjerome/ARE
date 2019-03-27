package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.Demande;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilComportement;
import fr.unedic.cali.autresdoms.ga.outilsfonctionnels.OutilPasseProfessionel;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.ElementComparaisonReexamen;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.ResultatAppelLiquidation;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.parcours.DomLiquidationDemande;
import fr.unedic.cali.parcours.ParcoursLiquidation;
import fr.unedic.cali.parcours.ResultatServiceDemande;
import fr.unedic.cali.utilitaire.decideur.spec.DecideurDecisionSpec;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class AppelLiquidation
{
  public static ResultatAppelLiquidation liquider(DemandeSpec demande)
    throws ApplicativeException
  {
    return liquider(demande, OutilComportement.getComportementParDefaut());
  }
  
  public static ResultatAppelLiquidation liquider(DemandeSpec demande, ComportementSpec comportement)
    throws ApplicativeException
  {
    ResultatAppelLiquidation resultat = new ResultatAppelLiquidation();
    
    Demande demandeVisu = new Demande();
    ComportementSpec comportementCourant = comportement;
    initialiserDemandeVisu(demandeVisu, comportementCourant);
    
    DemandeSpec demandeAvant = (DemandeSpec)demande.copie();
    if (comportement == null) {
      comportementCourant = OutilComportement.getComportementParDefaut();
    }
    try
    {
      if (demande.estLiquidableOuReexecutable())
      {
        if (reexaminerDemande(demande, comportementCourant)) {
          traiterReexamen(demande, resultat, demandeAvant, demandeVisu, comportementCourant);
        } else if (remettreEnCauseDemande(demande, comportementCourant)) {
          traiterRemiseEnCause(demande, resultat, demandeVisu);
        } else if (reconduireDemande(demande, comportementCourant)) {
          traiterReconduction(demande, resultat, demandeAvant, demandeVisu);
        }
      }
      else
      {
        demandeVisu.setEtatReexamen("V");
        
        resultat.setEtatLiquidation(3);
        resultat.setDemandeLiquidee(demande);
        demande.setValide(true);
        demande.setListeMotifsReexamen(null);
        demande.validerDecision();
      }
    }
    catch (CoucheLogiqueException ex)
    {
      resultat.setEtatLiquidation(0);
      demande.mettreAJourDemande(demandeAvant);
      demande.setValide(false);
      
      demande.setDemandeLiquidee(false);
      resultat.setDemandeLiquidee(demande);
      ajouterElementComparaisonException(demandeVisu, ex);
    }
    catch (ApplicativeRuntimeException ex)
    {
      if ((ex.getOrigine() instanceof CoucheLogiqueException))
      {
        resultat.setEtatLiquidation(0);
        demande.mettreAJourDemande(demandeAvant);
        demande.setValide(false);
        demande.setDemandeLiquidee(false);
        resultat.setDemandeLiquidee(demande);
        ajouterElementComparaisonException(demandeVisu, (CoucheLogiqueException)ex.getOrigine());
      }
      else
      {
        throw ex;
      }
    }
    alimenterDemandeVisu(demandeVisu, demande, comportementCourant);
    
    resultat.setDemandeVisu(demandeVisu);
    return resultat;
  }
  
  private static void traiterReconduction(DemandeSpec demande, ResultatAppelLiquidation resultat, DemandeSpec demandeAvant, Demande demandeVisu)
    throws ApplicativeException
  {
    demande.setValide(true);
    resultat.setDemandeLiquidee(demande);
    GammeSpec gammeAssocieeALaDemande = demande.getGamme();
    
    gammeAssocieeALaDemande.setTopRenoncementDecision(demande, gammeAssocieeALaDemande.estDecisionRenoncement(demandeAvant));
    
    demande.setListeMotifsReexamen(null);
    
    initialisationPasseProfessionnelLiquidation(demande);
    
    OutilAnnulationReexamen.verifierConditionAnnulationReexamen(demande);
    
    OutilAnnulationReexamen.recalculSurAnnulerReexamen(demande);
    
    demande.validerDecision();
    demandeVisu.setEtatReexamen("V");
    resultat.setEtatLiquidation(3);
  }
  
  private static void traiterRemiseEnCause(DemandeSpec demande, ResultatAppelLiquidation resultat, Demande demandeVisu)
  {
    resultat.setEtatLiquidation(1);
    
    demande.setValide(false);
    resultat.setDemandeLiquidee(demande);
    
    ElementComparaisonReexamen elementComparaison = new ElementComparaisonReexamen("Remise en cause automatique de la décision", null, null);
    
    ajouterElementComparaisonSurDemande(demandeVisu, elementComparaison);
  }
  
  private static void traiterReexamen(DemandeSpec demande, ResultatAppelLiquidation resultat, DemandeSpec demandeAvant, Demande demandeVisu, ComportementSpec comportementCourant)
    throws ApplicativeException
  {
    ResultatServiceDemande resultatParcoursLiquidation = liquiderDemande(demande);
    
    demandeVisu.setElementsComparaisonReexamen(resultatParcoursLiquidation.getListeDifferencesReexamen());
    
    boolean sauvegardeUtilisationComportement = comportementCourant.isUtilise();
    comportementCourant.setUtilise(false);
    
    boolean decisionsEgales = comparerDecisions(comportementCourant, demandeAvant, demande, resultatParcoursLiquidation);
    
    GammeSpec gammeAssocieeALaDemande = demande.getGamme();
    
    boolean contientAlertenonBloquantetAvecRemiseEnCause = false;
    if (comportementCourant.isReexamenAlertesNonBloquantes()) {
      contientAlertenonBloquantetAvecRemiseEnCause = gammeAssocieeALaDemande.contientAlerteNonBloquanteProvoquantRemiseEnCause(demande);
    }
    if ((decisionsEgales) && (!contientAlertenonBloquantetAvecRemiseEnCause))
    {
      demande.setValide(true);
      resultat.setDemandeLiquidee(demande);
      
      gammeAssocieeALaDemande.setTopRenoncementDecision(demande, gammeAssocieeALaDemande.estDecisionRenoncement(demandeAvant));
      demande.validerDecision();
      
      demande.supprimerDossiersAffectations();
      if (comportementCourant.isUtilise()) {
        demandeVisu.setEtatReexamen("E");
      } else {
        demandeVisu.setEtatReexamen("V");
      }
      resultat.setEtatLiquidation(3);
    }
    else
    {
      if (contientAlertenonBloquantetAvecRemiseEnCause)
      {
        ElementComparaisonReexamen elementComparaison = new ElementComparaisonReexamen("Alerte non bloquante avec mise en réexamen", null, null);
        
        ajouterElementComparaisonSurDemande(demandeVisu, elementComparaison);
      }
      resultat.setEtatLiquidation(1);
      demande.mettreAJourDemande(demandeAvant);
      demande.setValide(false);
      resultat.setDemandeLiquidee(demande);
    }
    if (!comportementCourant.isUtilise()) {
      comportementCourant.setUtilise(sauvegardeUtilisationComportement);
    }
  }
  
  private static boolean comparerDecisions(ComportementSpec comportement, DemandeSpec demandeAvant, DemandeSpec demandeApres, ResultatServiceDemande resultatParcoursLiquidation)
    throws CoucheLogiqueException
  {
    DecideurDecisionSpec decideur = comportement.getDecideur();
    if (decideur == null) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_OCCAS_OCCAS_DECIDEUR_INDISPONIBLE");
    }
    return decideur.decisionsIdentiques(demandeAvant, demandeApres, resultatParcoursLiquidation.getListeDifferencesReexamen(), comportement);
  }
  
  private static void initialisationPasseProfessionnelLiquidation(DemandeSpec demande)
  {
    IndividuSpec individu = demande.getDemandeur();
    ChronologiePeriodes chrono = OutilPasseProfessionel.trouverChronoPasseProfessionelAvecFiltrageDNJ(individu);
    
    individu.setChronoPeriodePasseProfessionnelLiquidation(chrono);
  }
  
  private static ResultatServiceDemande liquiderDemande(DemandeSpec demande)
    throws ApplicativeException
  {
    DomLiquidationDemande domContexte = null;
    Contexte contexteParcours = null;
    ParcoursLiquidation parcoursLiquidationDemande = null;
    
    domContexte = demande.getGamme().creerDomLiquidationDemande();
    domContexte.setDemande(demande);
    domContexte.setIdDemande(demande.getIdentifiant());
    domContexte.setIndividu(demande.getDemandeur());
    domContexte.setContexteService(demande.getDemandeur().getContexteService());
    contexteParcours = new Contexte();
    contexteParcours.setDonnees(domContexte);
    
    parcoursLiquidationDemande = demande.getGamme().getParcoursLiquidation(demande);
    return (ResultatServiceDemande)parcoursLiquidationDemande.effectuerParcours(contexteParcours);
  }
  
  private static void ajouterElementComparaisonException(Demande demandeVisu, CoucheLogiqueException exception)
  {
    String valeurApres = null;
    String libelle = null;
    if ((exception.getLibelle() != null) && (exception.getLibelle().length() <= 100)) {
      valeurApres = exception.getLibelle();
    } else {
      valeurApres = exception.getCode();
    }
    if ((exception.getCode() != null) && (exception.getCode().length() <= 50)) {
      libelle = exception.getCode();
    } else if (exception.getCode() != null) {
      libelle = exception.getCode().substring(exception.getCode().length() - 50 + 1);
    } else {
      libelle = "Exception couche logique sur demande";
    }
    ElementComparaisonReexamen elementComparaison = new ElementComparaisonReexamen(libelle, null, valeurApres);
    
    ajouterElementComparaisonSurDemande(demandeVisu, elementComparaison);
  }
  
  private static void ajouterElementComparaisonSurDemande(Demande demandeVisu, ElementComparaisonReexamen elementComparaison)
  {
    List<ElementComparaisonReexamen> elementComparaisonReexamen = demandeVisu.getElementsComparaisonReexamen();
    if (null == elementComparaisonReexamen)
    {
      elementComparaisonReexamen = new ArrayList();
      demandeVisu.setElementsComparaisonReexamen(elementComparaisonReexamen);
    }
    elementComparaisonReexamen.add(elementComparaison);
  }
  
  private static boolean reexaminerDemande(DemandeSpec demande, ComportementSpec comportement)
  {
    return (demande.estReexaminableAutomatiquement()) || ((comportement != null) && (OutilComportement.reexaminerDecisionsMigrees(comportement)));
  }
  
  private static boolean reconduireDemande(DemandeSpec demande, ComportementSpec comportement)
  {
    return (!demande.estMigree()) || ((comportement != null) && (OutilComportement.reconduireDecisionsMigrees(comportement)));
  }
  
  private static boolean remettreEnCauseDemande(DemandeSpec demande, ComportementSpec comportement)
  {
    return (!demande.estMigree()) || ((comportement != null) && (OutilComportement.remettreEnCauseDecisionsMigrees(comportement)));
  }
  
  private static void initialiserDemandeVisu(Demande demandeVisu, ComportementSpec comportement)
  {
    if ((comportement != null) && (comportement.isEcrireEnBaseVisu()))
    {
      demandeVisu.setEstReexecutee(false);
      demandeVisu.setEtatReexamen("R");
    }
  }
  
  public static void alimenterDemandeVisu(Demande demandeVisu, DemandeSpec demande, ComportementSpec comportement)
  {
    if ((comportement != null) && (comportement.isEcrireEnBaseVisu()))
    {
      demandeVisu.setIdDemande(demande.getIdentifiant());
      demandeVisu.setEstdecisionnee(demande.estDecisionnee());
      demandeVisu.setEstImpacte(true);
      demandeVisu.setTypeDemande(demande.getEvenementReferenceExamen().getTypeExamen());
      
      demandeVisu.setEstMigree(demande.estMigree());
      demandeVisu.setEstFigee(demande.estNeutraliseeCalcul());
      demandeVisu.setEstNeutralisee(demande.estNeutraliseeLiquidation());
      if (demande.estDecisionnee()) {
        alimenterDemandeVisuDecision(demandeVisu, demande);
      } else {
        demandeVisu.setDateAttribution(demande.getDateRecherche());
      }
    }
  }
  
  private static void alimenterDemandeVisuDecision(Demande demandeVisu, DemandeSpec demande)
  {
    String gamme = definirLibelleGamme(demande);
    boolean estDeTypeRbf = StringUtils.equals(gamme, "RBF");
    
    boolean estDeTypeMaintien = StringUtils.equals(demande.getEvenementReferenceExamen().getTypeExamen(), "ASU_06");
    
    DossierExamenSpec dossierExamen = null;
    if (estDeTypeRbf)
    {
      dossierExamen = recupereDossierExamen(demande);
      if (dossierExamen != null) {
        demandeVisu.setTypeDecision(((DecisionSpec)dossierExamen).getNatureDecision());
      }
    }
    else if (estDeTypeMaintien)
    {
      dossierExamen = recupereDossierExamen(demande);
      demandeVisu.setCodeProduit(15);
      if (dossierExamen != null) {
        demandeVisu.setTypeDecision(((DecisionSpec)dossierExamen).getNatureDecision());
      }
    }
    else
    {
      demandeVisu.setCodeProduit(demande.getDossierAffectation().getProduit().getCode());
      demandeVisu.setTypeDecision(((DecisionSpec)demande.getDossierAffectation().getDossierExamen()).getNatureDecision());
    }
    if (!estDecisionRejetee(demandeVisu.getTypeDecision()))
    {
      if ((!estDeTypeRbf) && (!estDeTypeMaintien)) {
        demandeVisu.setDateAttribution(demande.getDossierAffectation().getDossierExamen().getDateAttribution());
      } else if ((dossierExamen != null) && (dossierExamen.getDateAttribution() != null)) {
        demandeVisu.setDateAttribution(dossierExamen.getDateAttribution());
      } else {
        demandeVisu.setDateAttribution(demande.getDateRecherche());
      }
    }
    else {
      demandeVisu.setDateAttribution(demande.getDateRecherche());
    }
  }
  
  private static DossierExamenSpec recupereDossierExamen(DemandeSpec demande)
  {
    DossierExamenSpec dossierExamen = null;
    
    List listeDossierExamen = demande.getListeDossiersExamen();
    if ((listeDossierExamen != null) && (!listeDossierExamen.isEmpty())) {
      dossierExamen = (DossierExamenSpec)listeDossierExamen.iterator().next();
    }
    return dossierExamen;
  }
  
  private static String definirLibelleGamme(DemandeSpec demande)
  {
    String libelleGamme = null;
    if ((demande != null) && (demande.getGamme() != null)) {
      libelleGamme = demande.getGamme().getNomUnique();
    }
    return libelleGamme;
  }
  
  private static boolean estDecisionRejetee(int natureDecision)
  {
    return (16 == natureDecision) || (28 == natureDecision) || (19 == natureDecision) || (18 == natureDecision) || (17 == natureDecision) || (20 == natureDecision) || (25 == natureDecision);
  }
}

/* Location:
 * Qualified Name:     AppelLiquidation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */