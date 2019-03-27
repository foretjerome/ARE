package fr.unedic.cali.parcours;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AppelGaecReduit;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuIdSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.OdSpec;
import fr.unedic.cali.dom.SalaireJournalierSpec;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.dom.affectation.GammeMnt;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitAsuCSR04P01;
import fr.unedic.cali.dom.affectation.ProduitAsuSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.migration.outilsfonctionnels.OutilsMigration;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.cali.outilsfonctionnels.RechercherDernierSinistre;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePASOrigineContratTravail;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodeExpatries;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodesSurFiltresExclusifs;
import fr.unedic.cali.utilitaire.filtres.composites.FiltreOuvertureDroitStandardAssurance;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourReferenceExterne;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.PasAssezInformationException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreDebutDansBornes;
import fr.unedic.util.temps.FiltreFinDansBornes;
import fr.unedic.util.temps.FiltresTemporel;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class LireDemandePrestation
  extends ParcoursServiceAbstrait
{
  public void controlerContexte(Contexte p_context)
    throws ContexteException
  {}
  
  public void controleDonneesEnEntreeDeService(Contexte p_context)
    throws CoucheLogiqueException
  {
    if (p_context != null)
    {
      String idDemande = getIdentifiantDemande(p_context);
      String referenceExterne = getReferenceExterneDemande(p_context);
      IndividuSpec demandeur = getIndividu(p_context);
      if ((demandeur.getIndividuId() == null) || (demandeur.getIndividuId().getId() == null) || (demandeur.getIndividuId().getId().equals(""))) {
        throw new PasAssezInformationException("HG_PR_CALI_L_CONTEXTE_ABSENCE_ID_INDIVIDU", "La demande ne peut être rattachée à aucun individu.");
      }
      if (((idDemande == null) || (idDemande.equals(""))) && ((referenceExterne == null) || (referenceExterne.equals("")))) {
        throw new PasAssezInformationException("HG_PR_CALI_L_CONTEXTE_ABSENCE_ID_DEMANDE", "La demande recherchée en base n'a pas d'identifiant.");
      }
    }
    else
    {
      throw new PasAssezInformationException("HG_PR_CALI_L_ERR_CONTEXTE_ABSENT", "Le contexte ne doit pas être null");
    }
  }
  
  public Resultat demarrerParcours(Contexte p_contexte)
    throws CoucheLogiqueException
  {
    ResultatServicePrestation resultatLireDemande = new ResultatServicePrestation();
    
    resultatLireDemande.setEtat(1);
    String idDemandeCourante = null;
    DemandeSpec demandeLue = null;
    IndividuSpec individu = null;
    
    ChronologiePeriodes chronoPeriodeExpatrie = null;
    if (Log.isTraceActive(LireDemandePrestation.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, LireDemandePrestation.class, "demarrer", "");
    }
    if (Log.isTraceActive(LireDemandePrestation.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, LireDemandePrestation.class, "demarrer", "\t\t******** Début Parcours LireDemandePrestation ********\n");
    }
    controleDonneesEnEntreeDeService(p_contexte);
    
    idDemandeCourante = getIdentifiantDemande(p_contexte);
    individu = getIndividu(p_contexte);
    
    String refExtDemande = getReferenceExterneDemande(p_contexte);
    if (refExtDemande != null) {
      demandeLue = OutilRecherche.rechercherDemandePrecedente(individu.getChronoDemandes(), Damj.FIN_DES_TEMPS, new FiltreDemandePourReferenceExterne(refExtDemande));
    } else {
      demandeLue = individu.rechercherDemande(idDemandeCourante);
    }
    if (confirmerSiDecorAMettreEnPlace(p_contexte, individu))
    {
      positionnerDecorReglementaireSurPeriodes(demandeLue, individu);
      
      Damj dateDebut = Damj.NUIT_DES_TEMPS;
      Damj dateFinDernierSinistre = null;
      
      TravailSpec dernierSinistre = null;
      try
      {
        dernierSinistre = RechercherDernierSinistre.rechercherDateDernierSinistre(demandeLue.getDateRecherche(), individu.getChronoPeriodePasseProfessionnel());
      }
      catch (PasAssezInformationException e)
      {
        OutilTrace.ecrireTrace(Niveau.DEBUG, new Object[] { e });
      }
      if (dernierSinistre != null) {
        dateFinDernierSinistre = dernierSinistre.getDateFin();
      }
      if (dateFinDernierSinistre == null) {
        dateFinDernierSinistre = getDateFinPeriodeConcommittante(p_contexte, demandeLue);
      }
      if (dateFinDernierSinistre != null)
      {
        OdSpec odPrecedente = (OdSpec)OutilRecherche.rechercherDecisionPrecedente(demandeLue.getDemandeur().getChronoDemandeAssurance(), demandeLue.getDateRecherche(), new FiltreOuvertureDroitStandardAssurance(false, true, false, true, demandeLue));
        if (odPrecedente != null) {
          dateDebut = odPrecedente.getDateEffet();
        }
        FiltrePeriodesSurFiltresExclusifs listeFiltresBornes = new FiltrePeriodesSurFiltresExclusifs();
        Periode periodeBorne = new Periode(dateDebut, dateFinDernierSinistre);
        FiltreDebutDansBornes filtredebutDansBornes = new FiltreDebutDansBornes(periodeBorne);
        FiltreFinDansBornes filtreFinDansBornes = new FiltreFinDansBornes(periodeBorne);
        listeFiltresBornes.ajouterFiltre(filtredebutDansBornes);
        listeFiltresBornes.ajouterFiltre(filtreFinDansBornes);
        
        FiltresTemporel filtres = new FiltresTemporel();
        filtres.ajouterFiltre(new FiltrePASOrigineContratTravail());
        filtres.ajouterFiltre(new FiltrePeriodeExpatries());
        filtres.ajouterFiltre(listeFiltresBornes);
        
        chronoPeriodeExpatrie = (ChronologiePeriodes)individu.getChronoPeriodePasseProfessionnelLiquidation().copier(filtres);
        resultatLireDemande.setChronoPeriodeExpatrie(chronoPeriodeExpatrie);
      }
      mettreAJourActivitesConserveesOdPrecedente(demandeLue);
    }
    mettreAJourPensionsInvalidite(resultatLireDemande, demandeLue);
    
    resultatLireDemande.setDemande(demandeLue);
    resultatLireDemande.setEtat(0);
    if (Log.isTraceActive(LireDemandePrestation.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, LireDemandePrestation.class, "demarrer", "");
    }
    if (Log.isTraceActive(LireDemandePrestation.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, LireDemandePrestation.class, "demarrer", "\t\t******** Fin Parcours EnregistrerDemandePrestation ********\n");
    }
    return resultatLireDemande;
  }
  
  protected void mettreAJourPensionsInvalidite(ResultatServicePrestation p_resultatLireDemande, DemandeSpec p_demande)
    throws CoucheLogiqueException
  {}
  
  private boolean confirmerSiDecorAMettreEnPlace(Contexte p_contexte, IndividuSpec p_individu)
  {
    String nomService = p_individu.getDonneesChargementGaec().getAgregatGaec().getNomService();
    
    boolean estAssurance = getCodeGamme(p_contexte).equals("ASU");
    boolean estMaintien = "fr.unedic.cali.service.ServiceLectureDemandeMaintien".equals(nomService);
    boolean estDude = "fr.unedic.cali.service.ServiceLectureDemandeAssuranceDude".equals(nomService);
    
    int codeService = p_individu.getDonneesChargementGaec().getAgregatGaec().getCodeService();
    boolean estLectureDeDecisionAssurance = codeService == 3;
    
    return (estAssurance) && (!estMaintien) && (!estDude) && (!estLectureDeDecisionAssurance);
  }
  
  private void positionnerDecorReglementaireSurPeriodes(DemandeSpec p_demande, IndividuSpec p_individu)
    throws CoucheLogiqueException
  {
    TravailSpec dernierSinistre = null;
    
    Chronologie chronoPeriodesParticipantesRechercherDernierSinistre = RechercherDernierSinistre.determinerChronologieActivitesRechercheDernierSinistre(p_demande);
    if (chronoPeriodesParticipantesRechercherDernierSinistre != null) {
      dernierSinistre = RechercherDernierSinistre.rechercherDateDernierSinistre(p_demande.getDateRecherche(), chronoPeriodesParticipantesRechercherDernierSinistre);
    }
    if (dernierSinistre != null) {
      GammeAsu.getInstance().positionnerCriteresQualifSurPas(p_demande, p_individu, dernierSinistre);
    }
  }
  
  private String getIdentifiantDemande(Contexte p_contexte)
  {
    return ((DomLiquidationDemande)p_contexte.getDonnees()).getIdDemande();
  }
  
  private String getReferenceExterneDemande(Contexte p_contexte)
  {
    return ((DomLiquidationDemande)p_contexte.getDonnees()).getRefExtDemande();
  }
  
  private String getCodeGamme(Contexte p_contexte)
  {
    return ((DomLiquidationDemande)p_contexte.getDonnees()).getCodeGamme();
  }
  
  private Damj getDateFinPeriodeConcommittante(Contexte p_contexte, DemandeSpec p_demande)
    throws CoucheLogiqueException
  {
    TravailSpec periodeConcommittante = RechercherDernierSinistre.rechercherUneDesPeriodesConcommittantes(p_demande.getDateRecherche().veille(), getIndividu(p_contexte).getChronoPeriodePasseProfessionnelLiquidation());
    if (periodeConcommittante != null) {
      return periodeConcommittante.getDateFin();
    }
    return null;
  }
  
  private void mettreAJourActivitesConserveesOdPrecedente(DemandeSpec p_demande)
    throws CoucheLogiqueException
  {
    OdSpec odPrecedente = (OdSpec)OutilRecherche.rechercherDecisionPrecedente(p_demande.getDemandeur().getChronoDemandeAssurance(), p_demande.getDateRecherche(), new FiltreOuvertureDroitStandardAssurance(false, true, false, true, p_demande));
    if ((p_demande.getEvenementReferenceExamen() != null) && ("REV_ASU".equals(p_demande.getEvenementReferenceExamen().getLibelle()))) {
      if (odPrecedente != null)
      {
        DemandeSpec demandePrecedente = odPrecedente.getDemande();
        if ((demandePrecedente.estMigree()) && (OutilsMigration.estFigee(demandePrecedente)))
        {
          ProduitAsuSpec produit = (ProduitAsuSpec)demandePrecedente.getDossierAffectation().getProduit();
          produit.recalculerActivitesConserveesPourDemandeMigree(demandePrecedente);
        }
      }
    }
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    if (p_individu != null)
    {
      AgregatGaec agregat = p_individu.getDonneesChargementGaec().getAgregatGaec();
      if ("fr.unedic.cali.service.ServiceAfficherAppletLiquidation".equals(agregat.getNomService()))
      {
        Collection typePeriodesGaec = new ArrayList();
        ajouterSiNouveau("999", typePeriodesGaec);
        
        int modeChargement = 1;
        DemandeSpec demande = p_individu.rechercherDemande(p_idDemande);
        if ("ASU_31".equals(demande.getEvenementReferenceExamen().getTypeExamen())) {
          modeChargement = 2;
        }
        agregat.setModeAppel(modeChargement);
        agregat.setTypePeriodesGaec(typePeriodesGaec);
      }
      else
      {
        DemandeSpec demande = p_individu.rechercherDemande(p_idDemande);
        GammeSpec gamme = demande.getGamme();
        
        boolean estLectureDeDecision = agregat.getCodeService() == 3;
        boolean estLectureDeDemande = agregat.getCodeService() == 1;
        boolean estLectureDeDemandeClassee = (estLectureDeDemande) && (demande.getClassementAdministratif() != null);
        
        boolean estGammeMaintien = (gamme != null) && ((gamme instanceof GammeMnt));
        if (estLectureDeDecision)
        {
          Collection typePeriodesGaec = new ArrayList();
          int modeAppel = 0;
          
          agregat.initModeAppel();
          
          ProduitSpec produit = null;
          if (!estGammeMaintien)
          {
            List listeDossierExamen = demande.getListeDossiersExamen();
            if ((listeDossierExamen != null) && (!listeDossierExamen.isEmpty())) {
              produit = ((DossierExamenSpec)listeDossierExamen.get(0)).getDossierAffecte().getProduit();
            }
          }
          else
          {
            produit = GammeMnt.getInstance().determinerProduitDemandeMaintenue(demande);
          }
          String nomTypeEre = demande.getEvenementReferenceExamen().getTypeExamen();
          if ("ASU_17".equals(nomTypeEre))
          {
            modeAppel = Math.max(modeAppel, determinerModeAppelEtTypesPeriodes(p_individu, typePeriodesGaec));
          }
          else if ((rechercherPresenceDeProduitCsr2006(agregat)) || (estDemandeAspDcPapDcNouvelleConvention(demande)))
          {
            ajouterSiNouveau("9", typePeriodesGaec);
            modeAppel = Math.max(modeAppel, 1);
          }
          else if (produit != null)
          {
            String idPeriodeGaecAChargerSurLectureDecision = produit.determinerPeriodeGaecAChargerSurLectureDecision(demande);
            if (idPeriodeGaecAChargerSurLectureDecision != null)
            {
              modeAppel = Math.max(modeAppel, 1);
              agregat.setIdPeriode(idPeriodeGaecAChargerSurLectureDecision);
            }
          }
          if (estDemandeMigreeAvecAC(demande, gamme, produit))
          {
            typePeriodesGaec = new ArrayList();
            ajouterSiNouveau("9", typePeriodesGaec);
            agregat.setModeAppel(1);
            agregat.setTypePeriodesGaec(typePeriodesGaec);
          }
          agregat.setModeAppel(modeAppel);
          if (modeAppel == 1) {
            agregat.setTypePeriodesGaec(typePeriodesGaec);
          }
        }
        else if ((estGammeMaintien) && (estLectureDeDemandeClassee))
        {
          Collection typePeriodesGaec = new ArrayList();
          ajouterSiNouveau("9", typePeriodesGaec);
          agregat.setModeAppel(1);
          agregat.setTypePeriodesGaec(typePeriodesGaec);
        }
        else
        {
          alimenterAgregatGaecTypesPeriodes(p_individu);
        }
      }
    }
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    DonneesChargementGaec donneesChargementGaec = p_individu.getDonneesChargementGaec();
    AgregatGaec agregat = donneesChargementGaec.getAgregatGaec();
    
    AppelGaecReduit gaecReduit = donneesChargementGaec.getAppelGaecReduit();
    
    boolean estLectureDeDecision = agregat.getCodeService() == 3;
    if (estLectureDeDecision)
    {
      DemandeSpec demande = p_individu.rechercherDemande(agregat.getIdDemande());
      
      GammeSpec gamme = demande.getGamme();
      boolean estGammeMaintien = (gamme != null) && ((gamme instanceof GammeMnt));
      
      ProduitSpec produit = null;
      if (!estGammeMaintien)
      {
        List listeDossierExamen = demande.getListeDossiersExamen();
        if ((listeDossierExamen != null) && (!listeDossierExamen.isEmpty())) {
          produit = ((DossierExamenSpec)listeDossierExamen.get(0)).getDossierAffecte().getProduit();
        }
      }
      else
      {
        produit = GammeMnt.getInstance().determinerProduitDemandeMaintenue(demande);
      }
      String nomTypeEre = demande.getEvenementReferenceExamen().getTypeExamen();
      Collection typesPeriodesGaecAttendues = new ArrayList();
      int modeAppel = 0;
      if ((rechercherPresenceDeProduitCsr2006(agregat)) || (estDemandeAspDcPapDcNouvelleConvention(demande)))
      {
        modeAppel = Math.max(modeAppel, 1);
        ajouterSiNouveau("9", typesPeriodesGaecAttendues);
        controlerModeAppel(gaecReduit, modeAppel);
        if (modeAppel == 1) {
          controlerTypesPeriodes(modeAppel, agregat.getTypePeriodesGaec(), typesPeriodesGaecAttendues);
        }
      }
      else if ("ASU_17".equals(nomTypeEre))
      {
        modeAppel = Math.max(modeAppel, determinerModeAppelEtTypesPeriodes(p_individu, typesPeriodesGaecAttendues));
        controlerModeAppel(gaecReduit, modeAppel);
        if (modeAppel == 1) {
          controlerTypesPeriodes(modeAppel, agregat.getTypePeriodesGaec(), typesPeriodesGaecAttendues);
        }
      }
      else if (produit != null)
      {
        String idPeriodeGaecAChargerSurLectureDecision = produit.determinerPeriodeGaecAChargerSurLectureDecision(demande);
        if (idPeriodeGaecAChargerSurLectureDecision != null)
        {
          controlerModeAppel(donneesChargementGaec.getAppelGaecReduit(), 1);
        }
        else if (estDemandeMigreeAvecAC(demande, gamme, produit))
        {
          modeAppel = Math.max(modeAppel, 1);
          ajouterSiNouveau("9", typesPeriodesGaecAttendues);
          controlerModeAppel(gaecReduit, modeAppel);
        }
        else
        {
          controlerModeAppel(donneesChargementGaec.getAppelGaecReduit(), 0);
        }
      }
      else
      {
        controlerPostTraitementTypesPeriodes(p_individu);
      }
    }
  }
  
  private boolean rechercherPresenceDeProduitCsr2006(AgregatGaec p_agregat)
  {
    boolean produitCsr2006Present = false;
    if (p_agregat != null)
    {
      Collection produits = p_agregat.getProduits();
      Iterator itProduits = produits.iterator();
      while (itProduits.hasNext())
      {
        ProduitSpec produit = (ProduitSpec)itProduits.next();
        if ((produit != null) && ((produit instanceof ProduitAsuCSR04P01))) {
          produitCsr2006Present = true;
        }
      }
    }
    return produitCsr2006Present;
  }
  
  private boolean estDemandeAspDcPapDcNouvelleConvention(DemandeSpec demande)
  {
    return (demande.estEnContexteDemande("ASPDC")) || (demande.estEnContexteDemande("PAPDC"));
  }
  
  private boolean estDemandeMigreeAvecAC(DemandeSpec p_demande, GammeSpec p_gamme, ProduitSpec p_produit)
  {
    if ((p_demande.estMigree()) && ((p_gamme instanceof GammeAsu)) && ((p_demande.getDossierAffectation().getDossierExamen() instanceof AttributionSpec)))
    {
      ProduitAsuSpec produitAsu = (ProduitAsuSpec)p_produit;
      SalaireJournalierSpec sjc = produitAsu.getSJC((AttributionSpec)p_demande.getDossierAffectation().getDossierExamen());
      
      return sjc != null;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     LireDemandePrestation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */