package fr.unedic.cali.parcours;

import fr.pe.cali.crem.outils.OutilAjoutCremDalLiquidation;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.ga.outilsfonctionnels.OutilPasseProfessionel;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.ComparateurSurDateDeclenchementEtPrioriteDemande;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.OutilAnnulationReexamen;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDateDeclenchementExamenAvantOuCoincideDateEtInclusParPriorite;
import fr.unedic.cali.outilsfonctionnels.reexecution.FabriqueGestionnaireReexecution;
import fr.unedic.cali.outilsfonctionnels.reexecution.GestionnaireReexecutionSpec;
import fr.unedic.cali.outilsfonctionnels.reexecution.ResultatGestionnaireReexecutionSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.ChronologiePeriodes;
import java.util.Collection;

public class ParcoursAnnulerReexamen
  extends ParcoursServiceAbstrait
{
  public void controlerContexte(Contexte contexte)
    throws ContexteException
  {
    IndividuSpec individuCourant = getIndividu(contexte);
    if (individuCourant == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CTX_ABS_DEMANDEUR", "Individu absent du contexte");
    }
    String idDemande = getIdDemande(contexte);
    if (idDemande == null) {
      throw new ContexteException("HG_PR_CALI_L_CONTEXTE_ABSENCE_DEMANDE_ASSURANCE", "Identifiant demande absente du contexte");
    }
    DemandeSpec demande = individuCourant.rechercherDemande(idDemande);
    if (demande == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Demande inexistante en base");
    }
    getDom(contexte).setDemande(demande);
  }
  
  protected DemandeSpec validerDemande(Contexte contexte)
    throws ApplicativeException
  {
    DemandeSpec demande = getDom(contexte).getDemande();
    
    demande.setListeMotifsReexamen(null);
    if ((!demande.estMigree()) || (!demande.estReexaminable())) {
      throw new CoucheLogiqueException("HG_PR_CALI_L_CONTEXTE_ABSENCE_DEMANDE_ASSURANCE", "La demande ne correspond pas aux critères : seulement les demandes migrées");
    }
    verifierPreconditions(contexte);
    
    initialisationPasseProfessionnelLiquidation(contexte);
    
    OutilAnnulationReexamen.verifierConditionAnnulationReexamen(demande);
    
    OutilAnnulationReexamen.recalculSurAnnulerReexamen(demande);
    
    OutilFluxSigma.sauvegarderEtatDemandes(getIndividu(contexte));
    return demande;
  }
  
  protected void dateAnnulationReexamen(Contexte contexte, ResultatAnnulerReexamen resultat, DemandeSpec demande)
  {
    ContexteService contexteService = getDom(contexte).getContexteService();
    resultat.setDateAnnulationReexamen(contexteService.getDateTraitement());
    demande.setDateAnnulationReexamen(contexteService.getDateTraitement());
  }
  
  protected ResultatGestionnaireReexecutionSpec reexecution(DemandeSpec demande)
    throws ApplicativeException
  {
    return FabriqueGestionnaireReexecution.getGestionnaire().executerSurValidation(demande);
  }
  
  protected void notifierSigma(Contexte contexte, ResultatGestionnaireReexecutionSpec resultatReexecution)
    throws ApplicativeException
  {
    IndividuSpec individu = getIndividu(contexte);
    
    OutilFluxSigma.notifierSigma(individu, resultatReexecution.getDemandesReliquidees(), false);
  }
  
  protected OutilAjoutCremDalLiquidation initialisationOutilAjouCREM()
  {
    return OutilAjoutCremDalLiquidation.getInstance();
  }
  
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    ResultatAnnulerReexamen resultat = new ResultatAnnulerReexamen(0);
    
    DemandeSpec demande = validerDemande(contexte);
    IndividuSpec individu = recupererIndividu(contexte);
    
    ResultatGestionnaireReexecutionSpec resultatReexecution = reexecution(demande);
    
    OutilAjoutCremDalLiquidation outilAjoutCrem = initialisationOutilAjouCREM();
    outilAjoutCrem.ajouterCREMDemandesReexecutes(resultatReexecution.getDemandesReliquidees(), individu);
    if (!resultatReexecution.getDemandesReliquidees().contains(demande)) {
      resultatReexecution.getDemandesReliquidees().add(demande);
    }
    dateAnnulationReexamen(contexte, resultat, demande);
    notifierSigma(contexte, resultatReexecution);
    
    return resultat;
  }
  
  protected IndividuSpec recupererIndividu(Contexte contexte)
  {
    return getIndividu(contexte);
  }
  
  protected void initialisationPasseProfessionnelLiquidation(Contexte contexte)
  {
    IndividuSpec individu = getIndividu(contexte);
    
    ChronologiePeriodes chrono = OutilPasseProfessionel.trouverChronoPasseProfessionelAvecFiltrageDNJ(individu);
    
    individu.setChronoPeriodePasseProfessionnelLiquidation(chrono);
  }
  
  private DomAnnulerReexamen getDom(Contexte contexte)
  {
    return (DomAnnulerReexamen)contexte.getDonnees();
  }
  
  private String getIdDemande(Contexte contexte)
  {
    return getDom(contexte).getIdDemande();
  }
  
  protected void verifierContexte(DemandeSpec demande)
    throws ApplicativeException
  {
    demande.getEvenementReferenceExamen().verifierContexte(demande);
  }
  
  private void verifierPreconditions(Contexte contexte)
    throws CoucheLogiqueException
  {
    DemandeSpec demandePrestationsCourante = getDom(contexte).getDemande();
    IndividuSpec demandeur = demandePrestationsCourante.getDemandeur();
    
    DemandeSpec demandePrestationsPrecedente = null;
    
    ChronologieDebuts chronoDemandesDuDemandeur = demandeur.getChronoDemandes();
    
    ChronologieDebuts chronoDemandesFiltrees = (ChronologieDebuts)chronoDemandesDuDemandeur.copier(new FiltreDateDeclenchementExamenAvantOuCoincideDateEtInclusParPriorite(demandePrestationsCourante.getDateDeclenchementExamen(), demandePrestationsCourante, demandePrestationsCourante.getEvenementReferenceExamen()));
    
    chronoDemandesFiltrees.supprimer(demandePrestationsCourante);
    if (chronoDemandesFiltrees != null)
    {
      chronoDemandesFiltrees.setComparateur(new ComparateurSurDateDeclenchementEtPrioriteDemande());
      chronoDemandesFiltrees.iterer();
      while (chronoDemandesFiltrees.encoreSuivant())
      {
        demandePrestationsPrecedente = (DemandeSpec)chronoDemandesFiltrees.elementSuivant();
        if (!demandePrestationsPrecedente.estClasseeOuDecisionneeValidee()) {
          GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CONTEXTE_INITIAL_NON_VALIDE", new Object[] { demandePrestationsPrecedente.getEvenementReferenceExamen().getLibelleLong(), demandePrestationsPrecedente.getDateDeclenchementExamen() });
        }
        if (demandePrestationsPrecedente.estEnReExamen()) {
          GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CONTEXTE_INITIAL_REEXAMEN", new Object[] { demandePrestationsPrecedente.getEvenementReferenceExamen().getLibelleLong(), demandePrestationsPrecedente.getDateDeclenchementExamen() });
        }
      }
    }
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(2);
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(individu.getDonneesChargementGaec().getAppelGaecReduit(), 2);
  }
}

/* Location:
 * Qualified Name:     ParcoursAnnulerReexamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */