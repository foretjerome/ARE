package fr.unedic.cali.parcours;

import fr.pe.cali.crem.outils.OutilAjoutCremDalLiquidation;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.migration.outilsfonctionnels.OutilsMigration;
import fr.unedic.cali.outilsfonctionnels.EvenementReexamen;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.outilsfonctionnels.reexecution.FabriqueGestionnaireReexecution;
import fr.unedic.cali.outilsfonctionnels.reexecution.GestionnaireReexecutionSpec;
import fr.unedic.cali.outilsfonctionnels.reexecution.ResultatGestionnaireReexecutionSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Parcours;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.util.Collection;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public abstract class EnregistrerDemande
  extends ParcoursServiceAbstrait
{
  public abstract DemandeSpec mettreAJourOuCreerDemandeGamme(IndividuSpec paramIndividuSpec, String paramString, DemandeSpec paramDemandeSpec, Damj paramDamj)
    throws ApplicativeException;
  
  public void controlerContexte(Contexte contexte)
    throws ContexteException
  {
    if (contexte != null)
    {
      String idDemande = getIdDemande(contexte);
      IndividuSpec demandeur = getIndividu(contexte);
      if ((idDemande == null) || (idDemande.equals(""))) {
        throw new ContexteException("HG_PR_CALI_L_CONTEXTE_ABSENCE_ID_DEMANDE", "La demande recherchée en base n'a pas d'identifiant.");
      }
      DemandeSpec demande = demandeur.rechercherDemande(idDemande);
      if (OutilsMigration.estFigee(demande)) {
        try
        {
          GestionnaireErreur.getInstance().genererException("HG_PR_CALI_L_ERR_DEMANDE_FIGEE", 1);
        }
        catch (CoucheLogiqueException ex)
        {
          throw new ContexteException(ex.getCode(), ex.getLibelle(), ex);
        }
      }
      if ((getDemande(contexte).getClassementAdministratif() != null) && (StringUtils.equalsIgnoreCase(getDemande(contexte).getClassementAdministratif().getTypeClassement(), "SO"))) {
        if ((demande.estDecisionnee()) && (!demande.estEnReExamen())) {
          throw new ContexteException("HG_PR_CALI_L_ERR_CLASSEMENT_SO_SUR_DEMANDE", "Le classement de la demande en sans objet est impossible, veuillez mettre en réexamen la décision");
        }
      }
      if ((getDemande(contexte).getClassementAdministratif() != null) && (StringUtils.equalsIgnoreCase(getDemande(contexte).getClassementAdministratif().getTypeClassement(), "SP"))) {
        if ((demande.estDecisionnee()) && (!demande.estEnReExamen())) {
          throw new ContexteException("HG_PR_CALI_L_ERR_CLASSEMENT_SP_SUR_DEMANDE", "Impossible de classer la demande en secteur public, demande déja décisionnée.");
        }
      }
    }
    else
    {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE_ABSENT");
    }
  }
  
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    ResultatServiceDemande resultatEnregistrerDemande = new ResultatServiceDemande(0);
    
    String identifiantDemande = recupererIdentifiantDemande(contexte);
    DemandeSpec demandeTemporaire = recupererDemandeTemporaire(contexte);
    ContexteService contexteService = recupererContexteService(contexte);
    IndividuSpec individuCali = recupererIndividu(contexte);
    Damj dateTraitement = recupererDateTraitement(contexte);
    
    sauvegarderDemandeAvantMiseAJour(contexte, identifiantDemande);
    DemandeSpec demandeAJour = miseAJourDesDonnees(individuCali, demandeTemporaire, contexte, identifiantDemande, dateTraitement);
    
    ResultatGestionnaireReexecutionSpec resultatReexecution = reexecution(demandeAJour, contexte, contexteService);
    
    OutilAjoutCremDalLiquidation outilAjoutCrem = initialisationOutilAjouCREM();
    outilAjoutCrem.ajouterCREMDemandesReexecutes(resultatReexecution.getDemandesReliquidees(), individuCali);
    
    notifierSigma(resultatReexecution, demandeAJour, contexte, individuCali, resultatEnregistrerDemande);
    
    determinerCREMModificationEnregistrer(contexte, resultatEnregistrerDemande);
    
    resultatEnregistrerDemande.setDemande(demandeAJour);
    
    return resultatEnregistrerDemande;
  }
  
  protected String recupererIdentifiantDemande(Contexte contexte)
  {
    return getIdDemande(contexte);
  }
  
  protected DemandeSpec recupererDemandeTemporaire(Contexte contexte)
  {
    DemandeSpec demandeTemporaire = getDemande(contexte);
    
    String idDecor = ((DomLiquidationDemande)contexte.getDonnees()).getIdDecor();
    demandeTemporaire.getGamme().stockerIdDecorSurDemande(demandeTemporaire, idDecor);
    return demandeTemporaire;
  }
  
  protected ContexteService recupererContexteService(Contexte contexte)
  {
    return ((DomLiquidationDemande)contexte.getDonnees()).getContexteService();
  }
  
  protected IndividuSpec recupererIndividu(Contexte contexte)
  {
    IndividuSpec individuCali = getIndividu(contexte);
    
    OutilFluxSigma.sauvegarderEtatDemandes(individuCali);
    return individuCali;
  }
  
  protected Damj recupererDateTraitement(Contexte contexte)
  {
    return getContexteService(contexte).getDateTraitement();
  }
  
  protected OutilAjoutCremDalLiquidation initialisationOutilAjouCREM()
  {
    return OutilAjoutCremDalLiquidation.getInstance();
  }
  
  protected DemandeSpec miseAJourDesDonnees(IndividuSpec individuCali, DemandeSpec demandeTemporaire, Contexte contexte, String identifiantDemande, Damj dateTraitement)
    throws ApplicativeException
  {
    mettreAJourDonneesIndividu(individuCali, demandeTemporaire, (DomLiquidationDemande)contexte.getDonnees());
    DemandeSpec demandeAJour = mettreAJourOuCreerDemandeGamme(individuCali, identifiantDemande, demandeTemporaire, dateTraitement);
    
    mettreAJourDeblocageLiquidation(demandeAJour, demandeTemporaire);
    
    mettreAJourContexteMigration(demandeAJour);
    
    ((DomLiquidationDemande)contexte.getDonnees()).setDemande(demandeAJour);
    return demandeAJour;
  }
  
  protected Damj recupererDateEvenement(DemandeSpec demandeAJour, Contexte contexte)
  {
    Damj dateEvenement = demandeAJour.getDateRecherche();
    if (((DomLiquidationDemande)contexte.getDonnees()).getDemandeAvantReexamen() != null)
    {
      Damj dateExamenAvantReexamen = ((DomLiquidationDemande)contexte.getDonnees()).getDemandeAvantReexamen().getDateExamen();
      if (dateExamenAvantReexamen != null) {
        dateEvenement = Damj.min(dateExamenAvantReexamen, dateEvenement);
      }
    }
    Damj dateAttribution = null;
    Damj pji = null;
    
    List<DossierExamenSpec> listeDossierExamen = demandeAJour.getListeDossiersExamen();
    if ((listeDossierExamen != null) && (!listeDossierExamen.isEmpty()) && (((DossierExamenSpec)listeDossierExamen.get(0)).getDateAttribution() != null))
    {
      dateAttribution = ((DossierExamenSpec)listeDossierExamen.get(0)).getDateAttribution();
      if ((listeDossierExamen.get(0) instanceof AttributionSpec)) {
        pji = ((AttributionSpec)listeDossierExamen.get(0)).getPji();
      }
    }
    if (dateAttribution != null) {
      dateEvenement = Damj.min(dateAttribution, dateEvenement);
    }
    if (pji != null) {
      dateEvenement = Damj.min(dateEvenement, pji);
    }
    return dateEvenement;
  }
  
  protected ResultatGestionnaireReexecutionSpec reexecution(DemandeSpec demandeAJour, Contexte contexte, ContexteService contexteService)
    throws ApplicativeException
  {
    ResultatGestionnaireReexecutionSpec resultatReexecution = null;
    EvenementReexamen evtReexamen = null;
    Damj dateEvenement = recupererDateEvenement(demandeAJour, contexte);
    if ((demandeAJour.getClassementAdministratif() != null) && (demandeAJour.getClassementAdministratif().estClassementValide()))
    {
      demandeAJour.setListeMotifsReexamen(null);
      demandeAJour.definirDateValidation(contexteService.getDateTraitement());
      
      demandeAJour.annulerDecisions();
    }
    else if (demandeAJour.estDecisionnee())
    {
      evtReexamen = new EvenementReexamen(dateEvenement, "25");
    }
    else
    {
      evtReexamen = new EvenementReexamen(dateEvenement, "2");
    }
    if (demandeAJour.estNotifieeCourrier()) {
      demandeAJour.setDateDerniereNotification(contexteService.getDateTraitement());
    }
    if (evtReexamen != null) {
      resultatReexecution = FabriqueGestionnaireReexecution.getGestionnaire().executer(demandeAJour, evtReexamen);
    } else {
      resultatReexecution = FabriqueGestionnaireReexecution.getGestionnaire().executerSurValidation(demandeAJour);
    }
    return resultatReexecution;
  }
  
  protected void notifierSigma(ResultatGestionnaireReexecutionSpec resultatReexecution, DemandeSpec demandeAJour, Contexte contexte, IndividuSpec individuCali, ResultatServiceDemande resultatEnregistrerDemande)
    throws ApplicativeException
  {
    if (!resultatReexecution.getDemandesReliquidees().contains(demandeAJour)) {
      resultatReexecution.getDemandesReliquidees().add(demandeAJour);
    }
    OutilFluxSigma.notifierSigma(individuCali, resultatReexecution.getDemandesReliquidees(), false);
  }
  
  protected boolean isModeTp(Contexte contexte)
  {
    ContexteService contexteService = ((DomCali)contexte.getDonnees()).getContexteService();
    
    return contexteService.getContexteEmission().equalsIgnoreCase("TP");
  }
  
  protected void determinerCREMModificationEnregistrer(Contexte contexte, ResultatServiceDemande resultatServiceDemande)
    throws ApplicativeException
  {
    if (isModeTp(contexte))
    {
      Parcours parcoursCREMEnregistrer = new ParcoursCREMEnregistrer();
      ResultatCREMEnregistrer resultat = (ResultatCREMEnregistrer)parcoursCREMEnregistrer.effectuerParcours(contexte);
      
      resultatServiceDemande.setListeComparaisonCREMDonneesImposees(resultat.getListeComparaisonCREMDonneesImposees());
      resultatServiceDemande.setCREM(resultat.getCREM());
    }
  }
  
  protected void sauvegarderDemandeAvantMiseAJour(Contexte contexte, String idDemandeAMettreAJour)
    throws CoucheLogiqueException
  {
    DemandeSpec demandeExistante = null;
    
    DomLiquidationDemande dom = (DomLiquidationDemande)contexte.getDonnees();
    if ((idDemandeAMettreAJour != null) && (!idDemandeAMettreAJour.equals(""))) {
      demandeExistante = getIndividu(contexte).rechercherDemande(idDemandeAMettreAJour);
    }
    if (demandeExistante != null) {
      dom.setDemandeAvantReexamen((DemandeSpec)demandeExistante.copie());
    }
  }
  
  protected void mettreAJourContexteMigration(DemandeSpec demande)
    throws ContexteException
  {}
  
  protected boolean mettreAJourDonneesDemandeMigree(DemandeSpec demandeAMettreAJour, DemandeSpec demandeTemporaire)
    throws CoucheLogiqueException
  {
    boolean demandeDeneutralisee = false;
    if (demandeAMettreAJour.estMigree()) {
      if ((demandeAMettreAJour.estDeneutralisable()) && (!demandeTemporaire.estDeneutralisable()))
      {
        OutilsMigration.deneutraliserEnCascade(demandeAMettreAJour);
        
        demandeDeneutralisee = true;
      }
      else if ((demandeTemporaire.getClassementAdministratif() == null) && (demandeAMettreAJour.getClassementAdministratif() != null))
      {
        demandeAMettreAJour.setMigree(0);
      }
      else if ((demandeTemporaire.getClassementAdministratif() != null) && (demandeAMettreAJour.getClassementAdministratif() == null) && 
        (OutilsMigration.blocageLiquidationDroitMigree(demandeAMettreAJour)))
      {
        GestionnaireErreur.getInstance().genererException("HG_PR_CALI_L_CTX_CLASSEMENT_IMPOS_DEMANDE_MIGREE", 1);
      }
    }
    return demandeDeneutralisee;
  }
  
  protected String getIdDemande(Contexte contexte)
  {
    return ((DomLiquidationDemande)contexte.getDonnees()).getIdDemande();
  }
  
  protected String getIdDecor(Contexte contexte)
  {
    return ((DomLiquidationDemande)contexte.getDonnees()).getIdDecor();
  }
  
  protected DemandeSpec getDemande(Contexte contexte)
  {
    return ((DomLiquidationDemande)contexte.getDonnees()).getDemandeSpec();
  }
  
  protected void mettreAJourDonneesIndividu(IndividuSpec individu, DemandeSpec demandeTemporaire, DomLiquidationDemande donnees) {}
  
  protected void mettreAJourDeblocageLiquidation(DemandeSpec demandeAMettreAJour, DemandeSpec demandeTemporaire)
    throws CoucheLogiqueException
  {
    if (demandeTemporaire.estLiquidable())
    {
      if (!demandeAMettreAJour.estLiquidable())
      {
        demandeAMettreAJour.setEstNeutraliseeLiquidation(false);
        OutilsMigration.deneutraliserEnCascade(demandeAMettreAJour);
      }
      demandeAMettreAJour.setEstLiquidable(true);
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
}

/* Location:
 * Qualified Name:     EnregistrerDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */