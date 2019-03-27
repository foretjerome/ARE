package fr.unedic.cali.parcours;

import fr.pe.cali.crem.outils.OutilAjoutCremDalLiquidation;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.ga.services.AppelServicesGaec;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.outilsfonctionnels.ComparateurSurDateDeclenchementEtPrioriteDemande;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.outilsfonctionnels.reexecution.FabriqueGestionnaireReexecution;
import fr.unedic.cali.outilsfonctionnels.reexecution.GestionnaireReexecutionSpec;
import fr.unedic.cali.outilsfonctionnels.reexecution.ResultatGestionnaireReexecutionSpec;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import java.util.Collection;

public class ParcoursValiderDecision
  extends ParcoursServiceAbstrait
{
  public void controlerContexte(Contexte contexte)
    throws ContexteException
  {
    DomLiquidationDemande domCourant = (DomLiquidationDemande)contexte.getDonnees();
    
    IndividuSpec individuCourant = getIndividu(contexte);
    if (individuCourant == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CTX_ABS_DEMANDEUR", "Individu absent du contexte");
    }
    String idDemande = getIdDemande(contexte);
    if (idDemande == null) {
      throw new ContexteException("HG_PR_CALI_L_CONTEXTE_ABSENCE_DEMANDE_ASSURANCE", "Identifiant demande absente du contexte");
    }
    if (domCourant.getDemandeSpec() == null)
    {
      DemandeSpec demandeCourante = domCourant.getIndividu().rechercherDemande(domCourant.getIdDemande());
      domCourant.setDemande(demandeCourante);
    }
  }
  
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    ResultatServiceDemande resultatParcours = new ResultatServiceDemande(0);
    
    IndividuSpec individu = getIndividu(contexte);
    
    AppelServicesGaec.enregistrerAbonnementGaec(contexte);
    
    OutilFluxSigma.sauvegarderEtatDemandes(getIndividu(contexte));
    
    notificationDemande(contexte);
    
    liquider(contexte);
    
    ResultatGestionnaireReexecutionSpec resultatReexecution = valider(contexte);
    
    positionnerALiquidableDemandesPosterieures(contexte);
    
    getDemande(contexte).getGamme().controlerInvestigationFrauduleuse((DomLiquidationDemande)contexte.getDonnees());
    
    traitementPostValidation(contexte);
    
    OutilFluxSigma.notifierSigma(individu, resultatReexecution.getDemandesReliquidees(), false);
    
    resultatParcours.setDemande(getDemande(contexte));
    resultatParcours.setChronoDemandes(getDemandes(contexte));
    return resultatParcours;
  }
  
  private void traitementPostValidation(Contexte contexte)
    throws ApplicativeException
  {
    DemandeSpec demande = getDemande(contexte);
    demande.getGamme().traitementPostValidation(demande);
  }
  
  private void liquider(Contexte contexte)
    throws ApplicativeException
  {
    ContexteService contexteService = ((DomLiquidationDemande)contexte.getDonnees()).getContexteService();
    DemandeSpec demandeAValider = getDemande(contexte);
    DomLiquidationDemande domLiquidation = demandeAValider.getGamme().creerDomLiquidationDemande();
    domLiquidation.setContexteService(contexteService);
    domLiquidation.setDemande(demandeAValider);
    domLiquidation.setIdDemande(getIdDemande(contexte));
    domLiquidation.setIndividu(getIndividu(contexte));
    domLiquidation.setLiquidationAvecDroitOptionReprise(((DomLiquidationDemande)contexte.getDonnees()).isLiquidationAvecDroitOptionReprise());
    domLiquidation.setLiquidationAvecDroitOptionReadmission(((DomLiquidationDemande)contexte.getDonnees()).isLiquidationAvecDroitOptionReadmission());
    
    domLiquidation.setCodeMotifEchecPourSigma(((DomLiquidationDemande)contexte.getDonnees()).getCodeMotifEchecPourSigma());
    
    domLiquidation.setLiquidationTP(((DomLiquidationDemande)contexte.getDonnees()).isLiquidationTP());
    
    Contexte contexteLiquidation = new Contexte();
    contexteLiquidation.setDonnees(domLiquidation);
    if (ContexteAbsencePNDS.isActif()) {
      getIndividu(contexte).desactiverPNDS();
    }
    ParcoursLiquidation liquider = demandeAValider.getGamme().getParcoursLiquidation(demandeAValider);
    liquider.effectuerParcours(contexteLiquidation);
    if (ContexteAbsencePNDS.isActif()) {
      getIndividu(contexte).activerPNDS();
    }
  }
  
  protected ResultatGestionnaireReexecutionSpec valider(Contexte contexte)
    throws ApplicativeException
  {
    DemandeSpec demandeAValider = recupererDemandeAValider(contexte);
    
    ResultatGestionnaireReexecutionSpec resultatReexecution = reexecution(demandeAValider);
    if (!resultatReexecution.getDemandesReliquidees().contains(demandeAValider)) {
      resultatReexecution.getDemandesReliquidees().add(demandeAValider);
    }
    OutilAjoutCremDalLiquidation outilAjoutCrem = initialisationOutilAjouCREM();
    outilAjoutCrem.ajouterCREMDemandesReexecutes(resultatReexecution.getDemandesReliquidees(), getIndividu(contexte));
    
    return resultatReexecution;
  }
  
  protected DemandeSpec recupererDemandeAValider(Contexte contexte)
  {
    DemandeSpec demandeAValider = getDemande(contexte);
    ContexteService contexteService = ((DomLiquidationDemande)contexte.getDonnees()).getContexteService();
    
    demandeAValider.validerDecision();
    
    demandeAValider.supprimerDossiersAffectations();
    demandeAValider.definirDateValidation(contexteService.getDateTraitement());
    if (((DomLiquidationDemande)contexte.getDonnees()).estNotifierCourrier()) {
      demandeAValider.setDateDerniereNotification(contexteService.getDateTraitement());
    }
    return demandeAValider;
  }
  
  protected ResultatGestionnaireReexecutionSpec reexecution(DemandeSpec demandeAValider)
    throws ApplicativeException
  {
    return FabriqueGestionnaireReexecution.getGestionnaire().executerSurValidation(demandeAValider);
  }
  
  protected OutilAjoutCremDalLiquidation initialisationOutilAjouCREM()
  {
    return OutilAjoutCremDalLiquidation.getInstance();
  }
  
  private void positionnerALiquidableDemandesPosterieures(Contexte contexte)
    throws ApplicativeException
  {
    DemandeSpec demandeAValider = getDemande(contexte);
    if (demandeAValider.estLiquidable())
    {
      Chronologie listeDemandesARendreLiquidable = OutilRecherche.rechercherDemandesSuivantes(demandeAValider.getDemandeur().getChronoDemandes(), demandeAValider, null);
      
      listeDemandesARendreLiquidable.iterer();
      while (listeDemandesARendreLiquidable.encoreSuivant())
      {
        DemandeSpec demande = (DemandeSpec)listeDemandesARendreLiquidable.elementSuivant();
        if (demande.estMigree()) {
          demande.setEstLiquidable(true);
        }
      }
    }
  }
  
  private String getIdDemande(Contexte contexte)
  {
    return ((DomLiquidationDemande)contexte.getDonnees()).getIdDemande();
  }
  
  private DemandeSpec getDemande(Contexte contexte)
  {
    return ((DomLiquidationDemande)contexte.getDonnees()).getDemandeSpec();
  }
  
  private void notificationDemande(Contexte contexte)
    throws CoucheLogiqueException
  {
    DemandeSpec demande = getDemande(contexte);
    
    demande.setNotifieeCourrier(((DomLiquidationDemande)contexte.getDonnees()).estNotifierCourrier());
    
    demande.setTopAppelContribution(((DomLiquidationDemande)contexte.getDonnees()).estTopAppelContribution());
    
    demande.setLiquideeEnEtat(((DomLiquidationDemande)contexte.getDonnees()).estLiquideEnEtat());
    
    demande.setCodeMotifEchecPourSigma(((DomLiquidationDemande)contexte.getDonnees()).getCodeMotifEchecPourSigma());
    
    demande.setRevisionANotifier(((DomLiquidationDemande)contexte.getDonnees()).getRevisionANotifier());
  }
  
  private ChronologieDebuts getDemandes(Contexte contexte)
    throws CoucheLogiqueException
  {
    Individu individuCali = (Individu)getIndividu(contexte);
    
    ChronologieDebuts chronoDemandes = individuCali.getChronoDemandes();
    chronoDemandes.setComparateur(new ComparateurSurDateDeclenchementEtPrioriteDemande());
    
    return chronoDemandes;
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
}

/* Location:
 * Qualified Name:     ParcoursValiderDecision
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */