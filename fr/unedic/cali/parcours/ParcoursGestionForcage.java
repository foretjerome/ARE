package fr.unedic.cali.parcours;

import fr.pe.cali.crem.outils.OutilAjoutCremDalLiquidation;
import fr.unedic.archi.logique.cre.CRModificationDonnee;
import fr.unedic.archi.logique.cre.CompteRenduEvtHandler;
import fr.unedic.archi.logique.cre.TypeModification;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.dom.UniteTraitementForcee;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionForcage;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuIdSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.EvenementReexamen;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.outilsfonctionnels.OutilsGestionForcage;
import fr.unedic.cali.outilsfonctionnels.reexecution.FabriqueGestionnaireReexecution;
import fr.unedic.cali.outilsfonctionnels.reexecution.GestionnaireReexecutionSpec;
import fr.unedic.cali.outilsfonctionnels.reexecution.ResultatGestionnaireReexecutionSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteJour;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class ParcoursGestionForcage
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    ResultatGestionForcage resultatGestionForcage = new ResultatGestionForcage();
    
    resultatGestionForcage.setEtat(1);
    resultatGestionForcage.setFailure(true);
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Début Parcours gestion individu ********\n");
    }
    ContexteService contexteService = ((DomCali)contexte.getDonnees()).getContexteService();
    boolean isModeTp = true;
    if ((contexteService != null) && (contexteService.getContexteEmission() != null)) {
      isModeTp = contexteService.getContexteEmission().equalsIgnoreCase("TP");
    }
    IndividuSpec individu = getIndividu(contexte);
    String idDemande = ((DomGestionForcage)contexte.getDonnees()).getIdDemande();
    Damj dateEffet = ((DomGestionForcage)contexte.getDonnees()).getDateEffetUT();
    int statutForce = ((DomGestionForcage)contexte.getDonnees()).getStatutForce();
    String cumulARForce = ((DomGestionForcage)contexte.getDonnees()).getCumulARForce();
    QuantiteJour creditDecalageForce = ((DomGestionForcage)contexte.getDonnees()).getCreditDecalageForce();
    QuantiteJour creditDecalagePNDSForce = ((DomGestionForcage)contexte.getDonnees()).getCreditDecalagePNDSForce();
    String repriseMemeEmployeur = ((DomGestionForcage)contexte.getDonnees()).getRepriseMemeEmployeur();
    String estNeutralisee = ((DomGestionForcage)contexte.getDonnees()).getEstNeutralisee();
    String typeNeutralisation = ((DomGestionForcage)contexte.getDonnees()).getTypeNeutralisation();
    
    String deblocageSeuil = ((DomGestionForcage)contexte.getDonnees()).getDeblocageSeuil();
    String deblocageVariationRemuneration = ((DomGestionForcage)contexte.getDonnees()).getDeblocageVariationRemuneration();
    BigDecimal montantNetRevenusActiviteReprise = ((DomGestionForcage)contexte.getDonnees()).getMontantNetRevenusActiviteReprise();
    String ignorerAEDV = ((DomGestionForcage)contexte.getDonnees()).getIgnorerAEDV();
    String leverBlocageMandatement = ((DomGestionForcage)contexte.getDonnees()).getLeverBlocageMandatement();
    String motifDV = ((DomGestionForcage)contexte.getDonnees()).getMotifDV();
    
    Chronologie chronologieDemande = individu.getChronoDemandes();
    if ((chronologieDemande != null) && (!chronologieDemande.estVide()))
    {
      Iterator iteratorDemande = chronologieDemande.iterer();
      while (iteratorDemande.hasNext())
      {
        DemandeSpec demande = (DemandeSpec)iteratorDemande.next();
        if (estTraitementForcageAFaire(demande, idDemande))
        {
          Damj dateDebut = dateEffet.getDebutMois();
          Damj dateFin = dateEffet.getFinMois();
          UniteTraitementForcee utForcee = GestionForcage.getUniteTraitementForcee(demande, dateDebut, dateFin, false);
          UniteTraitementForcee utForceeAvant = null;
          if (utForcee != null) {
            utForceeAvant = (UniteTraitementForcee)utForcee.copie();
          }
          boolean estDecalageForce = OutilsGestionForcage.gestionForcageCreditDecalage(demande, dateDebut, dateFin, creditDecalageForce);
          boolean estDecalagePNDSForce = OutilsGestionForcage.gestionForcageCreditDecalagePNDS(demande, dateDebut, dateFin, creditDecalagePNDSForce);
          boolean estStatutForce = OutilsGestionForcage.gestionForcageStatutUT(demande, dateDebut, dateFin, statutForce);
          boolean estCumulARForce = OutilsGestionForcage.gestionForcageCumulAR(demande, dateDebut, dateFin, cumulARForce);
          boolean estNeutraliseForce = OutilsGestionForcage.gestionForcageEstNeutralise(demande, dateDebut, dateFin, estNeutralisee, typeNeutralisation);
          boolean estTypeNeutralisationForce = OutilsGestionForcage.gestionForcageTypeNeutralisation(demande, dateDebut, dateFin, typeNeutralisation);
          boolean estRepriseMemeEmployeurForcee = OutilsGestionForcage.gestionForcageRepriseMemeEmployeur(demande, dateDebut, dateFin, repriseMemeEmployeur);
          boolean estDeblocageSeuil = OutilsGestionForcage.gestionForcageDeblocageSeuil(demande, dateDebut, dateFin, deblocageSeuil);
          boolean estDeblocageVariationRemuneration = OutilsGestionForcage.gestionForcageDeblocageVariationRemuneration(demande, dateDebut, dateFin, deblocageVariationRemuneration);
          boolean estMontantNetRevenusActiviteReprise = OutilsGestionForcage.gestionForcageMontantNetRevenusActiviteReprise(demande, dateDebut, dateFin, montantNetRevenusActiviteReprise);
          boolean estIgnorerAEDVMayotte = OutilsGestionForcage.gestionForcageIgnorerAEDV(demande, dateDebut, dateFin, ignorerAEDV);
          boolean estDeblocageMandatementAEDV = OutilsGestionForcage.gestionForcageLeverBlocageMandatement(demande, dateDebut, dateFin, leverBlocageMandatement);
          boolean estPresenceMotifDV = OutilsGestionForcage.gestionForcageMotifDV(demande, dateDebut, dateFin, motifDV);
          
          boolean aucuneDonneesForcee = (!estDeblocageSeuil) && (!estDeblocageVariationRemuneration) && (!estStatutForce) && (!estCumulARForce) && (!estRepriseMemeEmployeurForcee) && (!estDecalageForce) && (!estDecalagePNDSForce) && (!estNeutraliseForce) && (!estTypeNeutralisationForce) && (!estMontantNetRevenusActiviteReprise) && (!estIgnorerAEDVMayotte) && (!estDeblocageMandatementAEDV) && (!estPresenceMotifDV);
          if (isModeTp) {
            detecterCREMForcage(getIdentifiant(individu), demande.getIdentifiant(), dateDebut.toString(), utForceeAvant, GestionForcage.getUniteTraitementForcee(demande, dateDebut, dateFin, false));
          }
          if (utForcee != null) {
            GestionForcage.checkForcage(demande, utForcee, aucuneDonneesForcee);
          }
        }
      }
      resultatGestionForcage.setEtat(0);
      resultatGestionForcage.setFailure(false);
    }
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Fin Parcours GestionForcage ********\n");
    }
    if (resultatGestionForcage.getEtat() == 0) {
      reexecute(individu, dateEffet);
    }
    return resultatGestionForcage;
  }
  
  protected void reexecute(IndividuSpec individu, Damj dateEffet)
    throws ApplicativeException
  {
    EvenementReexamen evtReexamen = new EvenementReexamen(dateEffet.getDebutMois(), "27");
    
    ResultatGestionnaireReexecutionSpec resultatReexecution = gestionnaireReexecution(individu, evtReexamen);
    
    OutilAjoutCremDalLiquidation outilAjoutCrem = initialisationOutilAjouCREM();
    outilAjoutCrem.ajouterCREMDemandesReexecutes(resultatReexecution.getDemandesReliquidees(), individu);
    
    notifierSigma(individu, resultatReexecution);
  }
  
  protected ResultatGestionnaireReexecutionSpec gestionnaireReexecution(IndividuSpec individu, EvenementReexamen evtReexamen)
    throws ApplicativeException
  {
    return FabriqueGestionnaireReexecution.getGestionnaire().executer(individu, evtReexamen);
  }
  
  protected void notifierSigma(IndividuSpec individu, ResultatGestionnaireReexecutionSpec resultatReexecution)
    throws ApplicativeException
  {
    OutilFluxSigma.notifierSigma(individu, resultatReexecution.getDemandesReliquidees(), false);
  }
  
  protected OutilAjoutCremDalLiquidation initialisationOutilAjouCREM()
  {
    return OutilAjoutCremDalLiquidation.getInstance();
  }
  
  public void controlerContexte(Contexte contexte)
    throws ContexteException
  {
    if (contexte != null)
    {
      IndividuSpec demandeur = getIndividu(contexte);
      if ((demandeur.getIndividuId() == null) || (demandeur.getIndividuId().getId() == null) || (demandeur.getIndividuId().getId().equals(""))) {
        throw new ContexteException("HG_PR_CALI_L_CONTEXTE_ABSENCE_ID_INDIVIDU", "La demande ne peut être rattachée à aucun individu.", null);
      }
    }
    else
    {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE_ABSENT", "Le contexte ne doit pas être null", null);
    }
  }
  
  private String getIdentifiant(IndividuSpec individu)
  {
    String idEntite = "";
    String cxala = "";
    if ((individu != null) && 
      (individu.getContexteService() != null))
    {
      if (individu.getContexteService().getIdEntite() != null) {
        idEntite = individu.getContexteService().getIdEntite();
      }
      if (individu.getContexteService().getCxala() != null) {
        cxala = individu.getContexteService().getCxala().toString();
      }
    }
    return idEntite + cxala;
  }
  
  private void detecterCREMForcage(String identifiantIndividu, String identifiantDemande, String dateDebutUTForcee, UniteTraitementForcee utForceeAvant, UniteTraitementForcee utForcee)
    throws fr.unedic.util.services.TechniqueException
  {
    try
    {
      CRModificationDonnee crm1 = CompteRenduEvtHandler.creerCRModificationDonnee("Demandeur d Emploi", TypeModification.MODIFICATION, identifiantIndividu);
      CRModificationDonnee crm2 = crm1.creerSousElement("UT Forcage", TypeModification.MODIFICATION, identifiantDemande);
      CRModificationDonnee crm3 = crm2.creerSousElement("UT Forcee", TypeModification.MODIFICATION, dateDebutUTForcee);
      if ((utForcee != null) && (utForcee.getStatut() == 0))
      {
        if ((utForceeAvant != null) && (utForceeAvant.isStatutForce())) {
          crm3.notifierModificationDonnee("Statut UT", TypeModification.SUPPRESSION, String.valueOf(utForceeAvant.getStatut()));
        }
      }
      else if ((utForcee != null) && ((utForceeAvant == null) || (!utForceeAvant.isStatutForce()))) {
        crm3.notifierModificationDonnee("Statut UT", TypeModification.CREATION, String.valueOf(utForcee.getStatut()));
      } else if ((utForceeAvant != null) && (utForceeAvant.isStatutForce()) && (utForcee.getStatut() != utForceeAvant.getStatut())) {
        crm3.notifierModificationDonnee("Statut UT", TypeModification.MODIFICATION, String.valueOf(utForceeAvant.getStatut()), String.valueOf(utForcee.getStatut()));
      }
      if ((utForcee != null) && (utForcee.getCumulARsurUtForce() == 0))
      {
        if ((utForceeAvant != null) && (utForceeAvant.isCumulAR())) {
          crm3.notifierModificationDonnee("Cumul AR", TypeModification.SUPPRESSION, String.valueOf(utForceeAvant.getCumulARsurUtForce()));
        }
      }
      else if ((utForcee != null) && ((utForceeAvant == null) || (!utForceeAvant.isCumulAR()))) {
        crm3.notifierModificationDonnee("Cumul AR", TypeModification.CREATION, String.valueOf(utForcee.getCumulARsurUtForce()));
      } else if ((utForceeAvant != null) && (utForceeAvant.isCumulAR()) && (utForcee.getCumulARsurUtForce() != utForceeAvant.getCumulARsurUtForce())) {
        crm3.notifierModificationDonnee("Cumul AR", TypeModification.MODIFICATION, String.valueOf(utForceeAvant.getCumulARsurUtForce()), String.valueOf(utForcee.getCumulARsurUtForce()));
      }
      if ((utForcee != null) && (utForcee.getCreditDecalage() != null))
      {
        if ((utForceeAvant != null) && (utForceeAvant.isCreditDecalageForce()) && (utForceeAvant.getCreditDecalage().compareTo(utForcee.getCreditDecalage()) != 0)) {
          crm3.notifierModificationDonnee("Credit Decalage", TypeModification.MODIFICATION, String.valueOf(utForceeAvant.getCreditDecalage()), String.valueOf(utForcee.getCreditDecalage()));
        } else if ((utForceeAvant == null) || (!utForceeAvant.isCreditDecalageForce())) {
          crm3.notifierModificationDonnee("Credit Decalage", TypeModification.CREATION, String.valueOf(utForcee.getCreditDecalage()));
        }
      }
      else if ((utForceeAvant != null) && (utForceeAvant.isCreditDecalageForce())) {
        crm3.notifierModificationDonnee("Credit Decalage", TypeModification.SUPPRESSION, String.valueOf(utForceeAvant.getCreditDecalage()));
      }
      if ((utForcee != null) && (utForcee.getCreditDecalagePNDS() != null))
      {
        if ((utForceeAvant != null) && (utForceeAvant.isCreditDecalagePNDSForce()) && (utForceeAvant.getCreditDecalagePNDS().compareTo(utForcee.getCreditDecalagePNDS()) != 0)) {
          crm3.notifierModificationDonnee("Credit Decalage PNDS", TypeModification.MODIFICATION, String.valueOf(utForceeAvant.getCreditDecalagePNDS()), String.valueOf(utForcee.getCreditDecalagePNDS()));
        } else if ((utForceeAvant == null) || (!utForceeAvant.isCreditDecalagePNDSForce())) {
          crm3.notifierModificationDonnee("Credit Decalage PNDS", TypeModification.CREATION, String.valueOf(utForcee.getCreditDecalagePNDS()));
        }
      }
      else if ((utForceeAvant != null) && (utForceeAvant.isCreditDecalagePNDSForce())) {
        crm3.notifierModificationDonnee("Credit Decalage PNDS", TypeModification.SUPPRESSION, String.valueOf(utForceeAvant.getCreditDecalagePNDS()));
      }
      if ((utForcee != null) && (utForcee.getEstNeutralisee() == 0))
      {
        if ((utForceeAvant != null) && (utForceeAvant.isEstNeutraliseForcee())) {
          crm3.notifierModificationDonnee("Neutralisation", TypeModification.SUPPRESSION, getValeur(utForceeAvant.getEstNeutralisee()));
        }
      }
      else if ((utForcee != null) && ((utForceeAvant == null) || (!utForceeAvant.isEstNeutraliseForcee()))) {
        crm3.notifierModificationDonnee("Neutralisation", TypeModification.CREATION, getValeur(utForcee.getEstNeutralisee()));
      } else if ((utForceeAvant != null) && (utForceeAvant.isEstNeutraliseForcee()) && (utForcee.getEstNeutralisee() != utForceeAvant.getEstNeutralisee())) {
        crm3.notifierModificationDonnee("Neutralisation", TypeModification.MODIFICATION, getValeur(utForceeAvant.getEstNeutralisee()), getValeur(utForcee.getEstNeutralisee()));
      }
      if ((utForcee != null) && (utForcee.getTypeNeutralisation() == 0))
      {
        if ((utForceeAvant != null) && (utForceeAvant.isTypeNeutralisationForce())) {
          crm3.notifierModificationDonnee("Type Neutralisation", TypeModification.SUPPRESSION, String.valueOf(utForceeAvant.getTypeNeutralisation()));
        }
      }
      else if ((utForcee != null) && ((utForceeAvant == null) || (!utForceeAvant.isTypeNeutralisationForce()))) {
        crm3.notifierModificationDonnee("Type Neutralisation", TypeModification.CREATION, String.valueOf(utForcee.getTypeNeutralisation()));
      } else if ((utForceeAvant != null) && (utForceeAvant.isTypeNeutralisationForce()) && (utForcee.getTypeNeutralisation() != utForceeAvant.getTypeNeutralisation())) {
        crm3.notifierModificationDonnee("Type Neutralisation", TypeModification.MODIFICATION, String.valueOf(utForceeAvant.getTypeNeutralisation()), String.valueOf(utForcee.getTypeNeutralisation()));
      }
      if ((utForcee != null) && (utForcee.getRepriseMemeEmployeur() == 0))
      {
        if ((utForceeAvant != null) && (utForceeAvant.isRepriseMemeEmployeurForcee())) {
          crm3.notifierModificationDonnee("Reprise Meme Employeur", TypeModification.SUPPRESSION, getValeur(utForceeAvant.getRepriseMemeEmployeur()));
        }
      }
      else if ((utForcee != null) && ((utForceeAvant == null) || (!utForceeAvant.isRepriseMemeEmployeurForcee()))) {
        crm3.notifierModificationDonnee("Reprise Meme Employeur", TypeModification.CREATION, getValeur(utForcee.getRepriseMemeEmployeur()));
      } else if ((utForceeAvant != null) && (utForceeAvant.isRepriseMemeEmployeurForcee()) && (utForcee.getRepriseMemeEmployeur() != utForceeAvant.getRepriseMemeEmployeur())) {
        crm3.notifierModificationDonnee("Reprise Meme Employeur", TypeModification.MODIFICATION, getValeur(utForceeAvant.getRepriseMemeEmployeur()), getValeur(utForcee.getRepriseMemeEmployeur()));
      }
      if ((utForcee != null) && (utForcee.isDeblocageSeuil()))
      {
        if ((utForceeAvant == null) || (!utForceeAvant.isDeblocageSeuil())) {
          crm3.notifierModificationDonnee("Deblocage Atteinte Seuil", TypeModification.CREATION, getValeur(utForcee.isDeblocageSeuil()));
        } else if ((utForceeAvant.isDeblocageSeuil()) && (utForceeAvant.isDeblocageSeuil() != utForcee.isDeblocageSeuil())) {
          crm3.notifierModificationDonnee("Deblocage Atteinte Seuil", TypeModification.MODIFICATION, getValeur(utForceeAvant.isDeblocageSeuil()), getValeur(utForcee.isDeblocageSeuil()));
        }
      }
      else if ((utForceeAvant != null) && (utForceeAvant.isDeblocageSeuil())) {
        crm3.notifierModificationDonnee("Deblocage Atteinte Seuil", TypeModification.SUPPRESSION, getValeur(utForceeAvant.isDeblocageSeuil()));
      }
      if ((utForcee != null) && (utForcee.isDeblocageVariationRemuneration()))
      {
        if ((utForceeAvant == null) || (!utForceeAvant.isDeblocageVariationRemuneration())) {
          crm3.notifierModificationDonnee("Deblocage Var. Remuneration", TypeModification.CREATION, getValeur(utForcee.isDeblocageVariationRemuneration()));
        } else if ((utForceeAvant.isDeblocageVariationRemuneration()) && (utForceeAvant.isDeblocageVariationRemuneration() != utForcee.isDeblocageVariationRemuneration())) {
          crm3.notifierModificationDonnee("Deblocage Var. Remuneration", TypeModification.MODIFICATION, getValeur(utForceeAvant.isDeblocageVariationRemuneration()), getValeur(utForcee.isDeblocageVariationRemuneration()));
        }
      }
      else if ((utForceeAvant != null) && (utForceeAvant.isDeblocageVariationRemuneration())) {
        crm3.notifierModificationDonnee("Deblocage Var. Remuneration", TypeModification.SUPPRESSION, getValeur(utForceeAvant.isDeblocageVariationRemuneration()));
      }
      if ((utForcee != null) && (utForcee.getMontantNetRevenusActiviteReprise() != null))
      {
        if ((utForceeAvant != null) && (utForceeAvant.isMontantNetActiviteReprise()) && (utForceeAvant.getMontantNetRevenusActiviteReprise().compareTo(utForcee.getMontantNetRevenusActiviteReprise()) != 0)) {
          crm3.notifierModificationDonnee("Montant Net Revenus Act. Rep", TypeModification.MODIFICATION, String.valueOf(utForceeAvant.getMontantNetRevenusActiviteReprise()), String.valueOf(utForcee.getMontantNetRevenusActiviteReprise()));
        } else if ((utForceeAvant == null) || (!utForceeAvant.isMontantNetActiviteReprise())) {
          crm3.notifierModificationDonnee("Montant Net Revenus Act. Rep", TypeModification.CREATION, String.valueOf(utForcee.getMontantNetRevenusActiviteReprise()));
        }
      }
      else if ((utForceeAvant != null) && (utForceeAvant.isMontantNetActiviteReprise())) {
        crm3.notifierModificationDonnee("Montant Net Revenus Act. Rep", TypeModification.SUPPRESSION, String.valueOf(utForceeAvant.getMontantNetRevenusActiviteReprise()));
      }
      if ((utForcee != null) && (utForcee.isEstIgnorerAEDV()))
      {
        if ((utForceeAvant == null) || (!utForceeAvant.isEstIgnorerAEDV())) {
          crm3.notifierModificationDonnee("Poursuite indemnisation AREM", TypeModification.CREATION, getValeur(utForcee.isEstIgnorerAEDV()));
        } else if ((utForceeAvant.isEstIgnorerAEDV()) && (utForceeAvant.isEstIgnorerAEDV() != utForcee.isEstIgnorerAEDV())) {
          crm3.notifierModificationDonnee("Poursuite indemnisation AREM", TypeModification.MODIFICATION, getValeur(utForceeAvant.isEstIgnorerAEDV()), getValeur(utForcee.isEstIgnorerAEDV()));
        }
      }
      else if ((utForceeAvant != null) && (utForceeAvant.isEstIgnorerAEDV())) {
        crm3.notifierModificationDonnee("Poursuite indemnisation AREM", TypeModification.SUPPRESSION, getValeur(utForceeAvant.isEstIgnorerAEDV()));
      }
      if ((utForcee != null) && (utForcee.isEstLeverBlocageDV()))
      {
        if ((utForceeAvant == null) || (!utForceeAvant.isEstLeverBlocageDV())) {
          crm3.notifierModificationDonnee("Deblocage mandatement AREM", TypeModification.CREATION, getValeur(utForcee.isEstLeverBlocageDV()));
        } else if ((utForceeAvant.isEstLeverBlocageDV()) && (utForceeAvant.isEstLeverBlocageDV() != utForcee.isEstLeverBlocageDV())) {
          crm3.notifierModificationDonnee("Deblocage mandatement AREM", TypeModification.MODIFICATION, getValeur(utForceeAvant.isEstLeverBlocageDV()), getValeur(utForcee.isEstLeverBlocageDV()));
        }
      }
      else if ((utForceeAvant != null) && (utForceeAvant.isEstLeverBlocageDV())) {
        crm3.notifierModificationDonnee("Deblocage mandatement AREM", TypeModification.SUPPRESSION, getValeur(utForceeAvant.isEstLeverBlocageDV()));
      }
    }
    catch (fr.unedic.archi.commun.exception.TechniqueException ex)
    {
      throw new fr.unedic.util.services.TechniqueException("HG_PR_CALI_L_INIT_COMPTE_RENDU", "Impossible d'initialiser le compte-rendu de suivi des modifications de l'individu", ex);
    }
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    if (individu != null) {
      individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(2);
    }
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(individu.getDonneesChargementGaec().getAppelGaecReduit(), 2);
  }
  
  private boolean estTraitementForcageAFaire(DemandeSpec demande, String idDemande)
    throws CoucheLogiqueException
  {
    if (demande.getIdentifiant().equals(idDemande))
    {
      ProduitSpec produit = demande.getDossierAffectation().getProduit();
      if (!produit.getListeElementsForcables().isEmpty()) {
        return true;
      }
    }
    return false;
  }
  
  private String getValeur(int entree)
  {
    String retour = "N";
    if (entree == 1) {
      retour = "O";
    }
    return retour;
  }
  
  private String getValeur(boolean entree)
  {
    String retour = "N";
    if (entree) {
      retour = "O";
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     ParcoursGestionForcage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */