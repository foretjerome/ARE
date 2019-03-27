package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.NovationSpec;
import fr.unedic.cali.dom.OdSpec;
import fr.unedic.cali.dom.RepriseSpec;
import fr.unedic.cali.dom.RevisionSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitForAff03P01;
import fr.unedic.cali.dom.affectation.ProduitForAff03P03;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreAttributionSecteurPublicHorsAntecedentSecteurPublic;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandeDateAttributionContenueDansPeriode;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandesPortantAttributionPourSigma;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreNovationSpec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreOD;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreOu;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreReprise;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreRevisionAre14;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliSpec;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreAttributionPourRsod;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionPourNatureDecision;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionPourProduit;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourEreAMettreEnBasePivot;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourNumeroGamme;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreOuvertureDroitSurDecision;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreOU;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltresTemporel;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class AlgorithmesIdentifiantSigma
{
  private static final int PAS_DE_VINGT = 20;
  
  public static int getIdentifiantReprise(AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    DemandeSpec demande = attribution.getDemande();
    IndividuSpec individu = demande.getDemandeur();
    int idReprise = 0;
    if ((attribution instanceof RepriseSpec))
    {
      int numeroGamme = demande.getNumeroGamme();
      switch (numeroGamme)
      {
      case 1: 
      case 2: 
      case 6: 
        idReprise = calculeIdentifiantReprise(demande);
        break;
      case 4: 
        idReprise = getIdentifiantReprisePourGammeFor(demande, individu);
        break;
      }
    }
    return idReprise;
  }
  
  private static int getIdentifiantReprisePourGammeFor(DemandeSpec demande, IndividuSpec individu)
    throws CoucheLogiqueException
  {
    int idReprise;
    int idReprise;
    if (((demande.getDossierAffectation().getProduit() instanceof ProduitForAff03P01)) || ((demande.getDossierAffectation().getProduit() instanceof ProduitForAff03P03)))
    {
      FiltreET filtre = new FiltreET();
      filtre.ajouterFiltre(new FiltreDemandePourNumeroGamme(1));
      filtre.ajouterFiltre(new FiltreOuvertureDroitSurDecision(true));
      
      AttributionSpec odOrigine = (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(individu.getChronoDemandes(), demande, filtre);
      
      idReprise = getIdentifiantReprise(odOrigine);
    }
    else
    {
      idReprise = calculeIdentifiantReprise(demande);
    }
    return idReprise;
  }
  
  private static int calculeIdentifiantReprise(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    Chronologie chronoDemandesParticipantes = filtrePourCalculRSRP(demande.getChronologieDemandesSansCourante(), demande);
    
    Chronologie chronoReprisesPosterieures = recupererReprisesPosterieures(chronoDemandesParticipantes, demande);
    
    Chronologie chronoDemandesAnterieures = OutilRecherche.rechercherDecisionsPrecedentes(chronoDemandesParticipantes, demande.getListeDossiersExamen().get(0), null);
    chronoDemandesAnterieures.setComparateur(new ComparateurSurDateAttributionEtPrioriteDemande());
    
    AttributionSpec attribution = (AttributionSpec)chronoDemandesAnterieures.dernierElement();
    int rsrpAttributionPrecedente = Integer.parseInt(attribution.getRsrp());
    int idReprise;
    int idReprise;
    if (chronoReprisesPosterieures.getTaille() > 0)
    {
      DemandeSpec demandeSuivante = (DemandeSpec)chronoReprisesPosterieures.premierElement();
      int rsrpAttributionSuivante = Integer.parseInt(((RepriseSpec)demandeSuivante.getListeDossiersExamen().get(0)).getReferenceExterne());
      
      idReprise = (rsrpAttributionPrecedente + rsrpAttributionSuivante) / 2;
    }
    else
    {
      idReprise = rsrpAttributionPrecedente + 20;
    }
    Chronologie chronoDemandesParticipantesPourControle = chronoReprisesPosterieures;
    chronoDemandesParticipantesPourControle.ajouter(chronoDemandesAnterieures);
    controleRsrpCalcule(idReprise, chronoDemandesParticipantesPourControle);
    
    return idReprise;
  }
  
  private static Chronologie filtrePourCalculRSRP(Chronologie chronologie, DemandeSpec demandeCourante)
  {
    FiltreCaliSpec filtreGamme = instancieFiltreGamme(demandeCourante);
    FiltreCaliSpec filtreProduit = filtreGamme;
    if ((demandeCourante.getDossierAffectation() != null) && (demandeCourante.getDossierAffectation().getProduit() != null)) {
      filtreProduit = new FiltreDecisionPourProduit(demandeCourante.getDossierAffectation().getProduit().getCode());
    }
    String rsod = ((AttributionSpec)demandeCourante.getDossierAffectation().getDossierExamen()).getRsod();
    
    FiltreET filtrePourCalculRSRP = new FiltreET();
    filtrePourCalculRSRP.ajouterFiltre(filtreProduit);
    filtrePourCalculRSRP.ajouterFiltre(new FiltreAttributionPourRsod(rsod));
    
    filtrePourCalculRSRP.ajouterFiltre(new FiltreDemandePourEreAMettreEnBasePivot());
    filtrePourCalculRSRP.ajouterFiltre(new fr.unedic.cali.utilitaire.filtres.logiques.FiltreNegation(new FiltreDecisionPourNatureDecision(8)));
    
    Chronologie chronoDemandeParticipantes = chronologie.copier(filtrePourCalculRSRP);
    
    Chronologie chronoARetourner = new ChronologieDebuts();
    Iterator<DemandeSpec> it = chronoDemandeParticipantes.iterer();
    FiltreCaliSpec filtreExclusionRevision = new FiltreRevisionAre14(false);
    while (it.hasNext())
    {
      DemandeSpec courante = (DemandeSpec)it.next();
      if (OutilDemande.estUneDemandeDeRevisionAdmission(courante))
      {
        if (filtreExclusionRevision.accepter(courante)) {
          chronoARetourner.ajouter(courante);
        }
      }
      else {
        chronoARetourner.ajouter(courante);
      }
    }
    return chronoARetourner;
  }
  
  private static void controleRsrpCalcule(int rsrpCalcule, Chronologie chronoDemandesParticipantes)
    throws CoucheLogiqueException
  {
    chronoDemandesParticipantes.iterer();
    while (chronoDemandesParticipantes.encoreSuivant())
    {
      Temporel objetTemp = chronoDemandesParticipantes.elementSuivant();
      AttributionSpec attribution;
      AttributionSpec attribution;
      if ((objetTemp instanceof DemandeSpec))
      {
        DemandeSpec demande = (DemandeSpec)objetTemp;
        attribution = (AttributionSpec)demande.getListeDossiersExamen().get(0);
      }
      else
      {
        attribution = (AttributionSpec)objetTemp;
      }
      String rsrp = attribution.getRsrp();
      if (Integer.toString(rsrpCalcule).equalsIgnoreCase(rsrp)) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_ERR_CALCUL_RSOD", new Object[] { rsrp, attribution.getDateAttribution() });
      }
    }
  }
  
  public static int getIdentifiantOD(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    int rsod = 0;
    IndividuSpec individu = demande.getDemandeur();
    
    DossierExamenSpec dossierExamen = null;
    if (!demande.getListeDossiersExamen().isEmpty()) {
      dossierExamen = (DossierExamenSpec)demande.getListeDossiersExamen().get(0);
    }
    int numeroGamme = demande.getNumeroGamme();
    
    FiltreCaliSpec filtreGamme = instancieFiltreGamme(demande);
    switch (numeroGamme)
    {
    case 1: 
    case 2: 
    case 4: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
      rsod = determinerIdentifiantODPourGamme(demande, individu, dossierExamen, filtreGamme);
      
      break;
    }
    return rsod;
  }
  
  private static int determinerIdentifiantODPourGamme(DemandeSpec demande, IndividuSpec individu, DossierExamenSpec dossierExamen, FiltreCaliSpec filtreGamme)
    throws CoucheLogiqueException
  {
    int rsod;
    if (((dossierExamen instanceof RepriseSpec)) || (((dossierExamen instanceof RevisionSpec)) && (((RevisionSpec)dossierExamen).getType() == 1)))
    {
      FiltreET filtre = new FiltreET();
      filtre.ajouterFiltre(filtreGamme);
      FiltreOU filtreOdOuRevisionAdmissionHorsRejetDv = new FiltreOU();
      filtreOdOuRevisionAdmissionHorsRejetDv.ajouterFiltre(new FiltreOuvertureDroitSurDecision(true));
      filtreOdOuRevisionAdmissionHorsRejetDv.ajouterFiltre(new FiltreRevisionAre14(false));
      
      filtre.ajouterFiltre(filtreOdOuRevisionAdmissionHorsRejetDv);
      
      AttributionSpec odOrigine = (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(individu.getChronoDemandes(), demande, filtreOdOuRevisionAdmissionHorsRejetDv);
      
      rsod = getIdentifiantOD(odOrigine.getDemande());
    }
    else
    {
      int rsod;
      if (((dossierExamen instanceof OdSpec)) || (((dossierExamen instanceof RevisionSpec)) && (((RevisionSpec)dossierExamen).getType() == 2)) || ((dossierExamen instanceof NovationSpec)))
      {
        rsod = calculeIdentifiantOD(demande);
      }
      else
      {
        String msg = "Erreur : décision sur la demande paramètre : ni une OdSpec ni une RepriseSpec";
        if (Log.isTraceActive(AlgorithmesIdentifiantSigma.class, Niveau.DEBUG)) {
          Log.ecritTrace(Niveau.DEBUG, AlgorithmesIdentifiantSigma.class, "getIdentifiantOD", msg);
        }
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_GENERIQUE", msg);
      }
    }
    int rsod;
    return rsod;
  }
  
  private static int calculeIdentifiantOD(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    int rsodDerniereOdSigmaNonMigree = 0;
    
    Chronologie chronoDemandesParticipantes = demande.getDemandeur().getChronoDemandes();
    
    chronoDemandesParticipantes = filtrePourCalculRSOD(chronoDemandesParticipantes);
    
    Chronologie chronoDemandesPosterieures = recupererDemandesPosterieures(chronoDemandesParticipantes, demande);
    
    Chronologie chronoDemandesAnterieures = recupererDemandesAnterieures(chronoDemandesParticipantes, chronoDemandesPosterieures, demande);
    if ((demande.getDemandeur().getRsodDerniereOdSigmaNonMigree() != null) && (!"".equalsIgnoreCase(demande.getDemandeur().getRsodDerniereOdSigmaNonMigree()))) {
      rsodDerniereOdSigmaNonMigree = Integer.parseInt(demande.getDemandeur().getRsodDerniereOdSigmaNonMigree());
    }
    int rsodOdPrecedente = 0;
    if ((chronoDemandesAnterieures != null) && (chronoDemandesAnterieures.getTaille() > 0))
    {
      ListIterator<?> it = chronoDemandesAnterieures.iterer();
      while (it.hasNext())
      {
        DemandeSpec demandeCourante = (DemandeSpec)it.next();
        int rsodCourant = Integer.parseInt(((AttributionSpec)demandeCourante.getListeDossiersExamen().get(0)).getReferenceExterne());
        if (rsodCourant > rsodOdPrecedente) {
          rsodOdPrecedente = rsodCourant;
        }
      }
    }
    else
    {
      rsodOdPrecedente = rsodDerniereOdSigmaNonMigree;
    }
    int rsod;
    int rsod;
    if ((chronoDemandesPosterieures != null) && (chronoDemandesPosterieures.getTaille() > 0))
    {
      DemandeSpec demandeSuivante = (DemandeSpec)chronoDemandesPosterieures.premierElement();
      int rsodOdSuivante = Integer.parseInt(((AttributionSpec)demandeSuivante.getListeDossiersExamen().get(0)).getReferenceExterne());
      
      rsod = (rsodOdPrecedente + rsodOdSuivante) / 2;
    }
    else
    {
      rsod = rsodOdPrecedente + 20;
    }
    controleRsodCalcule(rsod, chronoDemandesParticipantes, demande);
    
    return rsod;
  }
  
  private static void controleRsodCalcule(int rsodCalcule, Chronologie chronoDemandesParticipantes, DemandeSpec demande)
    throws CoucheLogiqueException
  {
    Chronologie chronoDemandesParticipantesAControler = supprimerDemandeCourante(chronoDemandesParticipantes, demande);
    chronoDemandesParticipantesAControler.iterer();
    while (chronoDemandesParticipantesAControler.encoreSuivant())
    {
      DemandeSpec demandeCourante = (DemandeSpec)chronoDemandesParticipantesAControler.elementSuivant();
      AttributionSpec attribution = (AttributionSpec)demandeCourante.getListeDossiersExamen().get(0);
      String rsod = attribution.getRsod();
      if (Integer.toString(rsodCalcule).equalsIgnoreCase(rsod)) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_ERR_CALCUL_RSOD", new Object[] { rsod, attribution.getDateAttribution() });
      }
    }
  }
  
  private static Chronologie recupererDemandesPosterieures(Chronologie chronoDemandesParticipantes, DemandeSpec demande)
  {
    Damj dateAttributionDemandeCourante = demande.getDossierAffectation().getDossierExamen().getDateAttribution();
    
    Chronologie chronoDemandesPosterieuresOuDuJourPortantOd = chronoDemandesParticipantes.copier(new FiltreDemandeDateAttributionContenueDansPeriode(new Periode(dateAttributionDemandeCourante, Damj.FIN_DES_TEMPS)));
    
    Chronologie chronoDemandesPosterieures = supprimerDemandesDuJourPrioritePlusForte(chronoDemandesPosterieuresOuDuJourPortantOd, demande);
    
    chronoDemandesPosterieures = supprimerDemandeCourante(chronoDemandesPosterieures, demande);
    
    return chronoDemandesPosterieures;
  }
  
  private static Chronologie recupererReprisesPosterieures(Chronologie chronoDemandesParticipantes, DemandeSpec demande)
  {
    Damj dateAttributionDemandeCourante = demande.getDossierAffectation().getDossierExamen().getDateAttribution();
    
    FiltresTemporel listeFiltres = new FiltresTemporel();
    listeFiltres.ajouterFiltre(new FiltreDemandeDateAttributionContenueDansPeriode(new Periode(dateAttributionDemandeCourante, Damj.FIN_DES_TEMPS)));
    
    listeFiltres.ajouterFiltre(new FiltreReprise());
    
    Chronologie chronoDemandesPosterieuresOuDuJourPortantReprise = chronoDemandesParticipantes.copier(listeFiltres);
    
    Chronologie chronoDemandesPosterieures = supprimerDemandesDuJourPrioritePlusForte(chronoDemandesPosterieuresOuDuJourPortantReprise, demande);
    
    chronoDemandesPosterieures = supprimerDemandeCourante(chronoDemandesPosterieures, demande);
    chronoDemandesPosterieures.setComparateur(new ComparateurSurDateAttributionEtPrioriteDemande());
    return chronoDemandesPosterieures;
  }
  
  private static Chronologie recupererDemandesAnterieures(Chronologie chronoDemandesParticipantes, Chronologie chronoDemandesPosterieures, DemandeSpec demande)
  {
    Damj dateAttributionDemandeCourante = demande.getDossierAffectation().getDossierExamen().getDateAttribution();
    
    Chronologie chronoDemandesAnterieures = chronoDemandesParticipantes.copier(new FiltreDemandeDateAttributionContenueDansPeriode(new Periode(Damj.NUIT_DES_TEMPS, dateAttributionDemandeCourante)));
    
    chronoDemandesAnterieures = supprimerDemandesPosterieures(chronoDemandesAnterieures, chronoDemandesPosterieures);
    
    chronoDemandesAnterieures = supprimerDemandeCourante(chronoDemandesAnterieures, demande);
    
    return chronoDemandesAnterieures;
  }
  
  private static Chronologie supprimerDemandeCourante(Chronologie chrono, DemandeSpec demandeCourante)
  {
    String refExterneDemandeCourante = demandeCourante.getFormulaire().getReferenceExterne();
    chrono.iterer();
    while (chrono.encoreSuivant())
    {
      DemandeSpec demande = (DemandeSpec)chrono.elementSuivant();
      if (demande.getFormulaire().getReferenceExterne().equals(refExterneDemandeCourante))
      {
        chrono.supprimer(demande);
        break;
      }
    }
    return chrono;
  }
  
  private static Chronologie supprimerDemandesDuJourPrioritePlusFaible(Chronologie chrono, DemandeSpec demande)
  {
    return OutilRecherche.rechercherDemandesPrecedentes(chrono, demande, null);
  }
  
  private static Chronologie supprimerDemandesDuJourPrioritePlusForte(Chronologie chrono, DemandeSpec demande)
  {
    Iterator<?> iter = chrono.iterer();
    while (iter.hasNext())
    {
      DemandeSpec demandeTemp = (DemandeSpec)iter.next();
      if ((estDemandeDuJourPrioritePlusForte(demande, demandeTemp)) || (estCasParticulierSortieClauseRattrapage(demande, demandeTemp))) {
        iter.remove();
      }
    }
    return chrono;
  }
  
  private static boolean estDemandeDuJourPrioritePlusForte(DemandeSpec demandePivot, DemandeSpec demandeCourante)
  {
    return (demandeCourante.getDossierAffectation().getDossierExamen().getDateAttribution().equals(demandePivot.getDossierAffectation().getDossierExamen().getDateAttribution())) && ((demandePivot.getGamme().getPriorite() < demandeCourante.getGamme().getPriorite()) || ((demandePivot.getGamme().getNomUnique().equals(demandeCourante.getGamme().getNomUnique())) && (demandePivot.getEvenementReferenceExamen().getPriorite() < demandeCourante.getEvenementReferenceExamen().getPriorite())));
  }
  
  private static boolean estCasParticulierSortieClauseRattrapage(DemandeSpec demandePivot, DemandeSpec demandeCourante)
  {
    return (demandePivot.getDateAttribution().equals(demandeCourante.getDateAttribution())) && (demandePivot.estEnContexteDemande("SORTIECRA")) && (demandeCourante.estEnContexteDemande("ENTREECRA"));
  }
  
  public static int determineRsodAttributionPrecedente(DemandeSpec demande)
  {
    int rsodAttributionPrecedente = 0;
    
    Damj dateAttribution = demande.getDossierAffectation().getDossierExamen().getDateAttribution();
    
    Chronologie chronoAttributions = demande.getDemandeur().getChronoDemandes();
    
    chronoAttributions = filtrePourCalculRSOD(chronoAttributions);
    chronoAttributions = chronoAttributions.copier(new FiltreDemandeDateAttributionContenueDansPeriode(new Periode(Damj.NUIT_DES_TEMPS, dateAttribution)));
    
    chronoAttributions.supprimer(demande);
    
    chronoAttributions = supprimerDemandesDuJourPrioritePlusFaible(chronoAttributions, demande);
    
    chronoAttributions.setComparateur(new ComparateurSurDateDeclenchementDemandeDecroissante());
    
    chronoAttributions.iterer();
    if (!chronoAttributions.estVide())
    {
      AttributionSpec attributionPrecedente = (AttributionSpec)((DemandeSpec)chronoAttributions.elementSuivant()).getListeDossiersExamen().get(0);
      
      rsodAttributionPrecedente = Integer.parseInt(attributionPrecedente.getReferenceExterne());
    }
    return rsodAttributionPrecedente;
  }
  
  private static FiltreCaliSpec instancieFiltreGamme(DemandeSpec demande)
  {
    FiltreDemandePourNumeroGamme filtreGamme = new FiltreDemandePourNumeroGamme(demande.getNumeroGamme());
    switch (demande.getNumeroGamme())
    {
    case 1: 
    case 2: 
    case 4: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
      break;
    case 3: 
    case 5: 
    case 7: 
    default: 
      String msg = "Détermination du RSOD pour cette gamme non prévue";
      if (Log.isTraceActive(AlgorithmesIdentifiantSigma.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, AlgorithmesIdentifiantSigma.class, "instancieFiltre", msg);
      }
      throw new UnsupportedOperationException(msg);
    }
    return filtreGamme;
  }
  
  private static Chronologie supprimerDemandesPosterieures(Chronologie chronoDemandesAnterieures, Chronologie chronoDemandesPosterieures)
  {
    Iterator<?> iter = chronoDemandesPosterieures.iterer();
    while (iter.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)iter.next();
      chronoDemandesAnterieures.supprimer(demande);
    }
    return chronoDemandesAnterieures;
  }
  
  private static Chronologie filtrePourCalculRSOD(Chronologie chronologie)
  {
    FiltreOu filtreDecision = new FiltreOu();
    filtreDecision.ajouterFiltre(new FiltreOD());
    filtreDecision.ajouterFiltre(new FiltreRevisionAre14(false));
    filtreDecision.ajouterFiltre(new FiltreNovationSpec());
    
    Chronologie chronoAttributions = chronologie.copier(filtreDecision);
    chronoAttributions = chronoAttributions.copier(new FiltreDemandesPortantAttributionPourSigma());
    chronoAttributions = chronoAttributions.copier(new fr.unedic.cali.outilsfonctionnels.filtres.FiltreNegation(new FiltreAttributionSecteurPublicHorsAntecedentSecteurPublic()));
    
    return chronoAttributions;
  }
}

/* Location:
 * Qualified Name:     AlgorithmesIdentifiantSigma
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */