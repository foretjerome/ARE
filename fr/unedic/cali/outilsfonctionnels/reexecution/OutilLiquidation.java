package fr.unedic.cali.outilsfonctionnels.reexecution;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilComportement;
import fr.unedic.cali.autresdoms.ga.outilsfonctionnels.OutilPasseProfessionel;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesSortieNPDESpec;
import fr.unedic.cali.dom.ElementComparaisonReexamen;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.IOutilFonctionnelTraitementsErreurs;
import fr.unedic.cali.outilsfonctionnels.OutilAnnulationReexamen;
import fr.unedic.cali.outilsfonctionnels.OutilDemande;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.cali.parcours.DomLiquidationDemande;
import fr.unedic.cali.parcours.ParcoursLiquidation;
import fr.unedic.cali.parcours.ResultatServiceDemande;
import fr.unedic.cali.utilitaire.decideur.spec.DecideurDecisionSpec;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.List;

public class OutilLiquidation
{
  private static OutilLiquidation outilLiquidation;
  
  public static synchronized OutilLiquidation getInstance()
  {
    if (outilLiquidation == null) {
      outilLiquidation = new OutilLiquidation();
    }
    return outilLiquidation;
  }
  
  public ResultatLiquidation liquider(DemandeSpec demande, ComportementSpec comportement)
    throws ApplicativeException
  {
    ResultatLiquidation resultat = new ResultatLiquidation();
    
    ComportementSpec comportementTemp = comportement;
    if (comportementTemp == null) {
      comportementTemp = OutilComportement.getComportementParDefaut();
    }
    List<ElementComparaisonReexamen> listeElementsComparaison = new ArrayList();
    
    DemandeSpec demandeAvant = (DemandeSpec)demande.copie();
    boolean estDemandeAvantNpdeEnAttenteDecision = estDemandeNpdeEnAttenteDecision(demandeAvant);
    try
    {
      if (demande.estLiquidableOuReexecutable())
      {
        if (reexaminerDemande(demande, comportementTemp))
        {
          if (estDemandeAvantNpdeEnAttenteDecision) {
            demande.getDonneesSortieNPDE().setModeTraitementDemande("AG");
          }
          ResultatServiceDemande resultatParcoursLiquidation = liquiderDemande(demande, estDemandeAvantNpdeEnAttenteDecision);
          
          listeElementsComparaison = resultatParcoursLiquidation.getListeDifferencesReexamen();
          
          boolean sauvegardeUtilisationComportement = comportementTemp.isUtilise();
          comportementTemp.setUtilise(false);
          boolean decisionsEgales = comparerDecisions(comportementTemp, demandeAvant, demande, resultatParcoursLiquidation);
          GammeSpec gammeAssocieeALaDemande = demande.getGamme();
          boolean contientAlertenonBloquantetAvecRemiseEnCause = false;
          if (comportementTemp.isReexamenAlertesNonBloquantes()) {
            contientAlertenonBloquantetAvecRemiseEnCause = gammeAssocieeALaDemande.contientAlerteNonBloquanteProvoquantRemiseEnCause(demande);
          }
          if ((decisionsEgales) && (!contientAlertenonBloquantetAvecRemiseEnCause))
          {
            demande.setValide(true);
            
            gammeAssocieeALaDemande.setTopRenoncementDecision(demande, gammeAssocieeALaDemande.estDecisionRenoncement(demandeAvant));
            demande.validerDecision();
            demande.supprimerDossiersAffectations();
            resultat.setEtatLiquidation(3);
            if (estDemandeAvantNpdeEnAttenteDecision)
            {
              Damj dateTraitement = recupererDateTraitement(demande);
              demande.definirDateValidation(dateTraitement);
              demande.setDateDerniereNotification(dateTraitement);
              notifierCourrierDemande(demande);
            }
          }
          else
          {
            if (contientAlertenonBloquantetAvecRemiseEnCause)
            {
              ElementComparaisonReexamen elementComparaison = new ElementComparaisonReexamen("Alerte non bloquante avec mise en réexamen", null, null);
              
              ajouterElementComparaisonSurDemande(listeElementsComparaison, elementComparaison);
            }
            resultat.setEtatLiquidation(1);
            demande.mettreAJourDemande(demandeAvant);
            demande.setValide(false);
          }
          if (!comportementTemp.isUtilise()) {
            comportementTemp.setUtilise(sauvegardeUtilisationComportement);
          }
        }
        else if (remettreEnCauseDemande(demande, comportementTemp))
        {
          resultat.setEtatLiquidation(1);
          demande.setValide(false);
          
          ElementComparaisonReexamen elementComparaison = new ElementComparaisonReexamen("Remise en cause automatique de la décision", null, null);
          
          ajouterElementComparaisonSurDemande(listeElementsComparaison, elementComparaison);
        }
        else if (reconduireDemande(demande, comportementTemp))
        {
          demande.setValide(true);
          GammeSpec gammeAssocieeALaDemande = demande.getGamme();
          
          gammeAssocieeALaDemande.setTopRenoncementDecision(demande, gammeAssocieeALaDemande.estDecisionRenoncement(demandeAvant));
          demande.setListeMotifsReexamen(null);
          initialisationPasseProfessionnelLiquidation(demande);
          OutilAnnulationReexamen.verifierConditionAnnulationReexamen(demande);
          OutilAnnulationReexamen.recalculSurAnnulerReexamen(demande);
          demande.validerDecision();
          resultat.setEtatLiquidation(3);
        }
      }
      else
      {
        resultat.setEtatLiquidation(3);
        demande.setValide(true);
        demande.setListeMotifsReexamen(null);
        demande.validerDecision();
      }
    }
    catch (CoucheLogiqueException ex)
    {
      gererExceptionFonctionnelle(resultat, demande, demandeAvant, listeElementsComparaison, ex);
    }
    catch (ApplicativeRuntimeException ex)
    {
      if ((ex.getOrigine() != null) && ((ex.getOrigine() instanceof CoucheLogiqueException)))
      {
        gererExceptionFonctionnelle(resultat, demande, demandeAvant, listeElementsComparaison, (CoucheLogiqueException)ex.getOrigine());
      }
      else
      {
        if (estDemandeAvantNpdeEnAttenteDecision) {
          demande.getGamme().getOutilFonctionnelTraitementErreurLiquidationAutomatique().traitementBlocagesTechniquesLiquidationAuto(demandeAvant, ex);
        }
        throw ex;
      }
    }
    resultat.setListeElementComparaison(listeElementsComparaison);
    return resultat;
  }
  
  private Damj recupererDateTraitement(DemandeSpec demande)
  {
    Damj dateTraitement = new Damj();
    if ((demande.getDemandeur() != null) && (demande.getDemandeur().getContexteService() != null)) {
      dateTraitement = demande.getDemandeur().getContexteService().getDateTraitement();
    }
    return dateTraitement;
  }
  
  private void gererExceptionFonctionnelle(ResultatLiquidation resultat, DemandeSpec demande, DemandeSpec demandeAvant, List<ElementComparaisonReexamen> listeElementsComparaison, CoucheLogiqueException ex)
    throws CoucheLogiqueException
  {
    if (estDemandeNpdeEnAttenteDecision(demandeAvant))
    {
      demande.getGamme().getOutilFonctionnelTraitementErreurLiquidationAutomatique().traitementBlocagesFonctionnelsLiquidationAutoNPDE(demande, ex);
    }
    else
    {
      demande.mettreAJourDemande(demandeAvant);
      ajouterElementComparaisonException(listeElementsComparaison, ex);
      tracerApplicativeException(ex);
    }
    resultat.setEtatLiquidation(0);
    demande.setValide(false);
    demande.setDemandeLiquidee(false);
  }
  
  protected boolean estDemandeNpdeEnAttenteDecision(DemandeSpec demande)
  {
    return (1 == demande.getNumeroGamme()) && (demande.isDemandeNPDE()) && (OutilDemande.estDemandeAttenteDecision(demande));
  }
  
  protected void notifierCourrierDemande(DemandeSpec demande)
  {
    demande.setNotifieeCourrier(true);
  }
  
  private boolean comparerDecisions(ComportementSpec comportement, DemandeSpec demandeAvant, DemandeSpec demandeApres, ResultatServiceDemande resultatParcoursLiquidation)
    throws CoucheLogiqueException
  {
    DecideurDecisionSpec decideur = comportement.getDecideur();
    if (decideur == null) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_OCCAS_OCCAS_DECIDEUR_INDISPONIBLE");
    }
    return decideur.decisionsIdentiques(demandeAvant, demandeApres, resultatParcoursLiquidation.getListeDifferencesReexamen(), comportement);
  }
  
  private void initialisationPasseProfessionnelLiquidation(DemandeSpec demande)
  {
    IndividuSpec individu = demande.getDemandeur();
    ChronologiePeriodes chrono = OutilPasseProfessionel.trouverChronoPasseProfessionelAvecFiltrageDNJ(individu);
    individu.setChronoPeriodePasseProfessionnelLiquidation(chrono);
  }
  
  private ResultatServiceDemande liquiderDemande(DemandeSpec demande, boolean effectuerControlesEligibilite)
    throws ApplicativeException
  {
    DomLiquidationDemande domContexte = demande.getGamme().creerDomLiquidationDemande();
    domContexte.setDemande(demande);
    domContexte.setIdDemande(demande.getIdentifiant());
    domContexte.setIndividu(demande.getDemandeur());
    domContexte.setContexteService(demande.getDemandeur().getContexteService());
    domContexte.setEffectuerControlesEligiliteSurDecisionAuto(effectuerControlesEligibilite);
    Contexte contexteParcours = new Contexte();
    contexteParcours.setDonnees(domContexte);
    
    ParcoursLiquidation parcoursLiquidationDemande = demande.getGamme().getParcoursLiquidation(demande);
    return (ResultatServiceDemande)parcoursLiquidationDemande.effectuerParcours(contexteParcours);
  }
  
  private boolean reexaminerDemande(DemandeSpec demande, ComportementSpec comportement)
  {
    return (demande.estReexaminableAutomatiquement()) || ((comportement != null) && (OutilComportement.reexaminerDecisionsMigrees(comportement)));
  }
  
  private boolean reconduireDemande(DemandeSpec demande, ComportementSpec comportement)
  {
    return (!demande.estMigree()) || ((comportement != null) && (OutilComportement.reconduireDecisionsMigrees(comportement)));
  }
  
  private boolean remettreEnCauseDemande(DemandeSpec demande, ComportementSpec comportement)
  {
    return (!demande.estMigree()) || ((comportement != null) && (OutilComportement.remettreEnCauseDecisionsMigrees(comportement)));
  }
  
  private void ajouterElementComparaisonException(List<ElementComparaisonReexamen> listeElementsComparaison, CoucheLogiqueException exception)
  {
    String valeurApres;
    String valeurApres;
    if ((exception.getLibelle() != null) && (exception.getLibelle().length() <= 100)) {
      valeurApres = exception.getLibelle();
    } else {
      valeurApres = exception.getCode();
    }
    String libelle;
    String libelle;
    if ((exception.getCode() != null) && (exception.getCode().length() <= 50))
    {
      libelle = exception.getCode();
    }
    else
    {
      String libelle;
      if (exception.getCode() != null) {
        libelle = exception.getCode().substring(exception.getCode().length() - 50 + 1);
      } else {
        libelle = "Exception couche logique sur demande";
      }
    }
    ElementComparaisonReexamen elementComparaison = new ElementComparaisonReexamen(libelle, null, valeurApres);
    ajouterElementComparaisonSurDemande(listeElementsComparaison, elementComparaison);
  }
  
  private void ajouterElementComparaisonSurDemande(List<ElementComparaisonReexamen> listeElementsComparaison, ElementComparaisonReexamen elementComparaison)
  {
    listeElementsComparaison.add(elementComparaison);
  }
  
  private void tracerApplicativeException(ApplicativeException pException)
  {
    OutilTrace.ecrireTrace(Niveau.ERROR, new Object[] { "CALI - EXCEPTION LORS REEXECUTION : CODE : ", pException.getCode(), " MESSAGE : ", pException.getLibelle() });
  }
}

/* Location:
 * Qualified Name:     OutilLiquidation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */