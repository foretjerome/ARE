package fr.unedic.cali.calcul;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.dom.ArretProduitAvecRaison;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPonctuel;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.ConstituantsCalculActiviteReduiteSpec;
import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.EtatAuDji;
import fr.unedic.cali.calcul.dom.EvenementBlocageIndemnisation;
import fr.unedic.cali.calcul.dom.EvenementPaiementProduitPonctuel;
import fr.unedic.cali.calcul.dom.EvenementPeriodeConflitGaec;
import fr.unedic.cali.calcul.dom.EvenementVeilleAtteinteRetraite;
import fr.unedic.cali.calcul.dom.Somme;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.periode.DsmTravail;
import fr.unedic.cali.calcul.dom.periode.FinPeriodeFormationNonIndemnisee;
import fr.unedic.cali.calcul.dom.periode.PeriodeBlocageIndemnisation;
import fr.unedic.cali.calcul.dom.periode.PeriodeConflitGAEC;
import fr.unedic.cali.calcul.dom.periode.PeriodeSuspensionDDTEAvecImputation;
import fr.unedic.cali.calcul.dom.temps.ObjetChrono60AnsBlocageRetraite;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeArretCalcul;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeFinPec;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeRadiation;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeRetraite;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoRetraiteAuPlusTard;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionSuivi;
import fr.unedic.cali.calcul.outilsfonctionnels.OutilGestionPoursuite;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.ContexteUT;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodesPriseEnCompte;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.MontantBaseAbstrait;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.fabriques.FabriqueStrategieDetectionDNJ;
import fr.unedic.cali.outilsfonctionnels.Anomalie;
import fr.unedic.cali.outilsfonctionnels.GestionAnomalies;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreContientDate;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDetectionDNJSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.FiltreChevauchePeriode;
import fr.unedic.util.temps.FiltresTemporel;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.ObjetChronoPeriodeConcrete;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TraitementUT
{
  private static final int CENT_DIX = 110;
  
  public static void executerUT(Periode p_periodeUT, Map p_mapFacadesCalculProduit, Map p_mapCalendriers, ChronologiePeriodes p_chronologiePeriodesGAEC, ChronologiePeriodes p_chronologiePeriodesPEC, ChronologiePeriodes p_chronologiePeriodesPECSansFiltre, ChronologiePeriodes p_chronologiePeriodesProduits, ChronologiePeriodes p_chronologiePeriodesEvtActualisation, ChronologiePeriodes p_chronologiePeriodesSanctions, ChronologiePeriodes p_chronologiePensionsInvaliditeEtAvantagesVieillesse, ContexteUT p_contexteUT)
    throws ApplicativeException
  {
    List listeCandidats = null;
    List listeOrdonneeCandidats = null;
    Iterator iterateur = null;
    AttributionSpec attribution = null;
    
    CalendrierExecutionCalculSpec calendrier = null;
    FacadeCalculProduitSpec facadeCalculProduit = null;
    
    listeCandidats = FonctionnelMultiProduits.getAttributionsCandidates(p_periodeUT, p_mapCalendriers);
    
    listeOrdonneeCandidats = FonctionnelMultiProduits.getAttributionsOrdonnees(listeCandidats);
    
    p_contexteUT.setPeriodeUT(p_periodeUT);
    p_contexteUT.setListeOrdonneeCandidats(listeOrdonneeCandidats);
    
    AttributionSpec attributionVivante = null;
    IndividuSpec individu = null;
    iterateur = p_mapCalendriers.keySet().iterator();
    while ((iterateur.hasNext()) && (attributionVivante == null))
    {
      AttributionSpec a = (AttributionSpec)iterateur.next();
      CalendrierExecutionCalculSpec calendrierExecutionCalcul = (CalendrierExecutionCalculSpec)p_mapCalendriers.get(a);
      if ((calendrierExecutionCalcul.getEtatAttribution() != 3) && (calendrierExecutionCalcul.getEtatAttribution() != 4) && (calendrierExecutionCalcul.getEtatAttribution() != 5) && (calendrierExecutionCalcul.getEtatAttribution() != 6))
      {
        attributionVivante = a;
        individu = a.getDemandeur();
      }
    }
    if ((individu != null) && (individu.getDateNaissance() != null) && (p_periodeUT.getDebut().estApres(individu.getDateNaissance().deplacerVersAvant(new DureeCalendaire(110))))) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_EXECUTION_ATTRIBUTION_DEMARRE_JAMAIS", new Object[] { attributionVivante.getDateAttribution() });
    } else if (p_periodeUT.getDebut().estApres(new Damj("2200, 01, 01"))) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_EXECUTION_ATTRIBUTION_DEMARRE_JAMAIS", new Object[] { attributionVivante.getDateAttribution() });
    } else if (p_periodeUT.getDebut().estApres(Damj.FIN_DES_TEMPS)) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_EXECUTION_ATTRIBUTION_DEMARRE_JAMAIS", new Object[] { attributionVivante.getDateAttribution() });
    }
    iterateur = listeOrdonneeCandidats.iterator();
    while (iterateur.hasNext())
    {
      attribution = (AttributionSpec)iterateur.next();
      
      facadeCalculProduit = (FacadeCalculProduitSpec)p_mapFacadesCalculProduit.get(attribution);
      
      calendrier = (CalendrierExecutionCalculSpec)p_mapCalendriers.get(attribution);
      
      attribution.setReexecutee(true);
      if (attribution.getProduit().getTypePaiement() == 0) {
        traiterAttributionPeriodique(attribution, (FacadeCalculProduitPeriodiqueSpec)facadeCalculProduit, (CalendrierExecutionCalculPeriodique)calendrier, p_periodeUT, p_contexteUT, p_chronologiePeriodesGAEC, p_chronologiePeriodesPEC, p_chronologiePeriodesPECSansFiltre, p_chronologiePeriodesProduits, p_chronologiePeriodesEvtActualisation, p_chronologiePeriodesSanctions, p_chronologiePensionsInvaliditeEtAvantagesVieillesse);
      } else if (attribution.getProduit().getTypePaiement() == 1) {
        traiterAttributionPonctuelle(attribution, (FacadeCalculProduitPonctuelSpec)facadeCalculProduit, (CalendrierExecutionCalculPonctuel)calendrier);
      }
    }
  }
  
  private static void traiterAttributionPeriodique(AttributionSpec p_attribution, FacadeCalculProduitPeriodiqueSpec p_facadeCalculProduit, CalendrierExecutionCalculPeriodique p_calendrier, Periode p_periodeUT, ContexteUT p_contexteUT, ChronologiePeriodes p_chronologiePeriodesGAEC, ChronologiePeriodes p_chronologiePeriodesPEC, ChronologiePeriodes p_chronologiePeriodesPECSansFiltre, ChronologiePeriodes p_chronologiePeriodesProduits, ChronologiePeriodes p_chronologiePeriodesEvtActualisation, ChronologiePeriodes p_chronologiePeriodesSanctions, ChronologiePeriodes p_chronologiePensionsInvaliditeEtAvantagesVieillesse)
    throws ApplicativeException
  {
    ConstituantsIndemnisation constituantsIndemnisation = null;
    ConstituantsCalculActiviteReduiteSpec constituantsCalculActiviteReduite = null;
    Quantite qteDecalageDureeEnCours = null;
    UniteTraitement ut = null;
    ChronologiePeriodes chronologiePeriodesPourAttribution = null;
    PeriodesPriseEnCompte periodesPriseEnCompte = null;
    Damj dateBlocageIndemnisation = null;
    EtatAuDji etatAuDji = null;
    ObjetChronoPeriodeRetraite objetChronoPeriodeRetraite = null;
    
    Collection listeDNJ = null;
    if (Log.isTraceActive(TraitementUT.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, TraitementUT.class, "traiterAttribution", "Calcul:   Attribution: [Produit:" + p_attribution.getProduit().getNom() + "] [DateEffet:" + p_attribution.getDateEffet() + "] [PJI:" + p_attribution.getPji() + "]");
    }
    dateBlocageIndemnisation = p_attribution.getDemandeur().getDateBlocageIndemnisation();
    if ((p_calendrier.getEtatAttribution() == 2) || (p_facadeCalculProduit.verifierConditionExecutionEtEventuelAbandon(p_attribution, p_contexteUT, p_periodeUT, p_calendrier)))
    {
      if (p_calendrier.getEtatAttribution() != 4)
      {
        if (Log.isTraceActive(TraitementUT.class, Niveau.DEBUG)) {
          Log.ecritTrace(Niveau.DEBUG, TraitementUT.class, "traiterAttribution", "Calcul:     exécution attribution");
        }
        if ((p_calendrier.getEtatAttribution() != 1) && (!p_periodeUT.getDebut().getFinMoisPrecedent().coincideAvec(((UniteTraitement)p_calendrier.getChronologieUnitesTraitements().dernierElement()).getDateDebut().getFinMois()))) {
          GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CALCUL_UT_PERSISTANTE_INCOHERENTE");
        }
        int cumulNombreJoursServi = recupererCumulNombreJoursServi(p_calendrier, p_attribution, p_facadeCalculProduit);
        int nbJourFormation = recupererNbJourFormation(p_attribution, p_calendrier, p_facadeCalculProduit);
        constituantsIndemnisation = recupererConstituantsIndemnisation(p_attribution, p_calendrier, p_facadeCalculProduit, p_periodeUT);
        constituantsCalculActiviteReduite = recupererConstituantsCalculActiviteReduite(p_attribution, p_calendrier, p_facadeCalculProduit, p_contexteUT, constituantsIndemnisation);
        
        periodesPriseEnCompte = new PeriodesPriseEnCompte(p_periodeUT);
        
        chronologiePeriodesPourAttribution = initialiserChronologiePeriode(p_attribution, p_periodeUT, p_chronologiePeriodesGAEC, p_chronologiePeriodesPEC, p_chronologiePeriodesPECSansFiltre, p_chronologiePeriodesProduits, p_chronologiePeriodesEvtActualisation, p_chronologiePeriodesSanctions, p_chronologiePensionsInvaliditeEtAvantagesVieillesse, p_contexteUT, p_facadeCalculProduit, dateBlocageIndemnisation);
        
        qteDecalageDureeEnCours = recupererDureeDecalageEnCours(p_calendrier);
        if (p_calendrier.getEtatAttribution() == 1)
        {
          if (Log.isTraceActive(TraitementUT.class, Niveau.DEBUG)) {
            Log.ecritTrace(Niveau.DEBUG, TraitementUT.class, "traiterAttribution", "Calcul:     première UT d'exécution");
          }
          preparerPremiereExecution(p_attribution, constituantsIndemnisation, p_facadeCalculProduit, periodesPriseEnCompte, p_chronologiePeriodesSanctions, p_periodeUT);
        }
        else if (p_calendrier.getEtatAttribution() == 2)
        {
          preparerAutreExecution(p_attribution, p_periodeUT, constituantsIndemnisation, p_facadeCalculProduit, p_chronologiePeriodesSanctions);
        }
        ut = TraitementAttributionPeriodique.executerAttribution(p_attribution, p_facadeCalculProduit, constituantsIndemnisation, constituantsCalculActiviteReduite, qteDecalageDureeEnCours, p_periodeUT, p_contexteUT, chronologiePeriodesPourAttribution, periodesPriseEnCompte, p_chronologiePeriodesEvtActualisation, p_calendrier);
        
        ut = alimenterUtAvecCompteurs(ut, p_facadeCalculProduit, nbJourFormation, cumulNombreJoursServi, p_attribution, p_calendrier, p_contexteUT, constituantsIndemnisation);
        
        effectuerTraitementBlocageIndemnisation(ut, dateBlocageIndemnisation, p_attribution.getPji());
        
        p_calendrier.ajouterUT(ut);
        if (estGestionDnj(p_attribution))
        {
          listeDNJ = determinerListeDNJ(p_chronologiePeriodesGAEC, ut);
          Collection listeDNJProduit = convertirEnListeDsmProduit(listeDNJ, p_attribution);
          p_calendrier.ajouterListeDNJ(listeDNJProduit);
        }
        p_facadeCalculProduit.miseAJourUtAvecDnjGaec(p_attribution, ut);
        if (p_calendrier.getEtatAttribution() == 1) {
          terminerPremiereExecution(p_calendrier);
        }
        if (ut.isProduitATerminerApresUT())
        {
          if ((ut.getArretProduitAvecRaison().isProduitAEteindre()) && (ut.getArretProduitAvecRaison().getPeriodesInterruptivesDefinitives().size() != 0)) {
            p_calendrier.setEtatAttribution(6);
          } else {
            p_calendrier.setEtatAttribution(3);
          }
          FacadeCalculProduitSpec facadeCalculProduit = FacadeCalculProduitFactory.getInstance().getInstanceGestionnaireCalculProduit(p_attribution.getProduitExecution());
          if (ut.getArretProduitAvecRaison().isRaisonsContientRaison(4))
          {
            Iterator iterator = ut.getArretProduitAvecRaison().getPeriodesInterruptivesDefinitives().iterator();
            
            boolean aDejaUnePeriodeRetraite = false;
            while (iterator.hasNext())
            {
              Object object = iterator.next();
              if ((object instanceof ObjetChronoPeriodeArretCalcul))
              {
                p_calendrier.setEtatAttribution(5);
                break;
              }
              if ((object instanceof ObjetChronoPeriodeRadiation))
              {
                if ((((ObjetChronoPeriodeRadiation)object).getMotifAnnulationPEC() != null) && (((ObjetChronoPeriodeRadiation)object).getMotifAnnulationPEC().equals("48"))) {
                  GestionSuivi.enregistrerEnquetePbjcNcp(p_attribution, ((ObjetChronoPeriodeRadiation)object).getDateDebut().veille(), 3, 0, true, p_facadeCalculProduit.recupererCategorieAttribution(p_attribution, ut), facadeCalculProduit, ut.getConstituantsIndemnisationEnFinUT());
                }
              }
              else if ((object instanceof ObjetChronoPeriodeFinPec))
              {
                if ((((ObjetChronoPeriodeFinPec)object).getMotifAnnulationPEC() != null) && (((ObjetChronoPeriodeFinPec)object).getMotifAnnulationPEC().equals("48"))) {
                  GestionSuivi.enregistrerEnquetePbjcNcp(p_attribution, ((ObjetChronoPeriodeFinPec)object).getDateDebut().veille(), 3, 0, true, p_facadeCalculProduit.recupererCategorieAttribution(p_attribution, ut), facadeCalculProduit, ut.getConstituantsIndemnisationEnFinUT());
                }
              }
              else if ((object instanceof PeriodeConflitGAEC))
              {
                PeriodeConflitGAEC periodeConflitGAEC = (PeriodeConflitGAEC)object;
                
                GestionAnomalies.ajouteAnomalie(new Anomalie("M02", periodeConflitGAEC.getDateDebut(), ""), p_attribution.getDemandeur());
                Chronologie chronologieUT = p_calendrier.getChronologieUnitesTraitements().copier(new FiltreContientDate(periodeConflitGAEC.getDateDebut().getFinMoisPrecedent()));
                if (chronologieUT.getTaille() != 0)
                {
                  UniteTraitement utPrecedente = (UniteTraitement)chronologieUT.premierElement();
                  utPrecedente.ajouterEvenement(new EvenementPeriodeConflitGaec(utPrecedente.getDateFin()));
                }
              }
              else if ((object instanceof ObjetChrono60AnsBlocageRetraite))
              {
                ObjetChrono60AnsBlocageRetraite objetChrono60AnsBlocageRetraite = (ObjetChrono60AnsBlocageRetraite)object;
                GestionAnomalies.ajouteAnomalie(new Anomalie("M11", Damj.max(objetChrono60AnsBlocageRetraite.getDateDebut(), p_attribution.getDateAttribution()), ""), p_attribution.getDemandeur());
              }
              else if ((object instanceof ObjetChronoPeriodeRetraite))
              {
                objetChronoPeriodeRetraite = (ObjetChronoPeriodeRetraite)object;
                int typeSuivi;
                int typeSuivi;
                if (objetChronoPeriodeRetraite.estNbTrimestreInconnu()) {
                  typeSuivi = 1;
                } else {
                  typeSuivi = 2;
                }
                GestionSuivi.enregistrerEnquetePbjcNcp(p_attribution, objetChronoPeriodeRetraite.getDateDebut().veille(), typeSuivi, 0, true, p_facadeCalculProduit.recupererCategorieAttribution(p_attribution, ut), facadeCalculProduit, ut.getConstituantsIndemnisationEnFinUT());
                if (!aDejaUnePeriodeRetraite)
                {
                  aDejaUnePeriodeRetraite = true;
                  ut.ajouterEvenement(new EvenementVeilleAtteinteRetraite(((ObjetChronoPeriodeRetraite)object).getDateEffet().veille()));
                }
              }
              else if ((object instanceof ObjetChronoRetraiteAuPlusTard))
              {
                if (!aDejaUnePeriodeRetraite)
                {
                  aDejaUnePeriodeRetraite = true;
                  ut.ajouterEvenement(new EvenementVeilleAtteinteRetraite(((ObjetChronoRetraiteAuPlusTard)object).getDateEffet().veille()));
                }
              }
              else
              {
                p_facadeCalculProduit.realiserDetectionFinDeProduitPourSuivi(p_attribution, ut, p_contexteUT);
              }
            }
          }
          p_calendrier.setDernierJourIndemnisable(ut.getArretProduitAvecRaison().recupereLendemainDateArret().veille());
          
          etatAuDji = new EtatAuDji();
          
          etatAuDji.setMontant(recupererMontant(ut, p_calendrier));
          etatAuDji = p_facadeCalculProduit.renseignerEtatAuDji(ut, p_calendrier, p_attribution, etatAuDji);
          etatAuDji.setCumulJoursIndemnise(ut.getCumulJoursIndemnise());
          etatAuDji.setPeriodePECEvenementReducteur(recupererPeriodeEvenementReducteur(p_calendrier, periodesPriseEnCompte, p_attribution));
          
          p_calendrier.setEtatAuDJI(etatAuDji);
          if (Log.isTraceActive(TraitementUT.class, Niveau.DEBUG))
          {
            Log.ecritTrace(Niveau.DEBUG, TraitementUT.class, "traiterAttribution", "Calcul:     fin attribution: DJI: " + p_calendrier.getDernierJourIndemnisable());
            
            Iterator iterateurTemporelRaisonAuLendemainArret = ut.getArretProduitAvecRaison().recupereTemporelRaisonAuLendemainArret().iterator();
            while (iterateurTemporelRaisonAuLendemainArret.hasNext())
            {
              String classeTemporel = iterateurTemporelRaisonAuLendemainArret.next().getClass().getName();
              Log.ecritTrace(Niveau.DEBUG, TraitementUT.class, "traiterAttribution", "Calcul:     fin attribution: Evt: " + classeTemporel);
            }
          }
          p_facadeCalculProduit.realiserDetectionFinDeProduitPourSuivi(p_attribution, ut, p_contexteUT);
        }
      }
      else if (Log.isTraceActive(TraitementUT.class, Niveau.DEBUG))
      {
        Log.ecritTrace(Niveau.DEBUG, TraitementUT.class, "traiterAttribution", "Calcul:     abandon attribution");
      }
    }
    else if (Log.isTraceActive(TraitementUT.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, TraitementUT.class, "traiterAttribution", "Calcul:     exécution reportée (Condition d'exécution non vérifiée)");
    }
  }
  
  private static void traiterAttributionPonctuelle(AttributionSpec p_attribution, FacadeCalculProduitPonctuelSpec p_facadeCalculProduit, CalendrierExecutionCalculPonctuel p_calendrier)
    throws CoucheLogiqueException
  {
    ConstituantsIndemnisation constituantsIndemnisation = null;
    
    EvenementPaiementProduitPonctuel evenementPaiementProduitPonctuel = null;
    if (Log.isTraceActive(TraitementUT.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, TraitementUT.class, "traiterAttributionPonctuelle", "Calcul:   Attribution: [Produit:" + p_attribution.getProduit().getNom() + "] [DateEffet:" + p_attribution.getDateEffet() + "] [PJI:" + p_attribution.getPji() + "]");
    }
    if (p_calendrier.getEtatAttribution() != 4)
    {
      if (Log.isTraceActive(TraitementUT.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, TraitementUT.class, "traiterAttributionPonctuelle", "Calcul:     exécution attribution");
      }
      constituantsIndemnisation = recupererConstituantsIndemnisation(p_attribution, p_calendrier, p_facadeCalculProduit);
      
      evenementPaiementProduitPonctuel = TraitementAttributionPonctuelle.executerAttribution(p_attribution, p_facadeCalculProduit, constituantsIndemnisation);
      
      p_calendrier.setEvenementPaiementProduitPonctuel(evenementPaiementProduitPonctuel);
      
      p_calendrier.setEtatAttribution(3);
      
      p_calendrier.setDernierJourIndemnisable(p_calendrier.getDateDebut());
      if (Log.isTraceActive(TraitementUT.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, TraitementUT.class, "traiterAttribution", "Calcul:     fin attribution: DJI: " + p_calendrier.getDernierJourIndemnisable());
      }
    }
    else if (Log.isTraceActive(TraitementUT.class, Niveau.DEBUG))
    {
      Log.ecritTrace(Niveau.DEBUG, TraitementUT.class, "traiterAttribution", "Calcul:     abandon attribution");
    }
  }
  
  private static void preparerPremiereExecution(AttributionSpec p_attribution, ConstituantsIndemnisation p_constituantsIndemnisation, FacadeCalculProduitPeriodiqueSpec p_facadeCalculProduit, PeriodesPriseEnCompte p_periodesPriseEnCompte, ChronologiePeriodes p_chronologieSanctions, Periode p_periodeUT)
    throws ApplicativeException
  {
    p_facadeCalculProduit.controlerAttribution(p_attribution);
    
    p_facadeCalculProduit.initialisationQuantitesIndemnisation(p_constituantsIndemnisation, p_attribution, p_periodeUT);
    
    ChronologiePeriodes chronologiePeriodesGAEC = OutillagePeriodes.recupererPeriodesGAEC(p_attribution.getDemandeur(), p_attribution.getDateAttribution(), null);
    
    chronologiePeriodesGAEC.iterer();
    while (chronologiePeriodesGAEC.encoreSuivant())
    {
      ObjetChronoPeriode periode = (ObjetChronoPeriode)chronologiePeriodesGAEC.elementSuivant();
      if (((periode instanceof FinPeriodeFormationNonIndemnisee)) && (periode.getDateFin().estApres(p_attribution.getDateAttribution())) && (periode.getDateFin().estAvant(p_attribution.getPji()))) {
        p_facadeCalculProduit.imputerAvant(periode, p_constituantsIndemnisation, p_attribution);
      }
    }
    p_chronologieSanctions.iterer();
    while (p_chronologieSanctions.encoreSuivant())
    {
      ObjetChronoPeriode periode = (ObjetChronoPeriode)p_chronologieSanctions.elementSuivant();
      if (((periode instanceof PeriodeSuspensionDDTEAvecImputation)) && (periode.getDateDebut().estApresOuCoincideAvec(p_attribution.getDateAttribution())) && (periode.getDateDebut().estAvant(p_attribution.getPji()))) {
        if (periode.getDateFin().estApres(p_attribution.getPji()))
        {
          PeriodeSuspensionDDTEAvecImputation tperiode = new PeriodeSuspensionDDTEAvecImputation(periode.getDateDebut(), p_attribution.getPji(), ((PeriodeSuspensionDDTEAvecImputation)periode).getCodeSanction());
          
          tperiode.setDureeImputation(p_attribution.getPji().veille().joursEntre(periode.getDateDebut()) + 1);
          
          p_facadeCalculProduit.imputerAvant(tperiode, p_constituantsIndemnisation, p_attribution);
          
          periode.setDateDebut(p_attribution.getPji());
          ((PeriodeSuspensionDDTEAvecImputation)periode).setDureeImputation(((PeriodeSuspensionDDTEAvecImputation)periode).getDureeImputation() - tperiode.getDureeImputation() - 1);
        }
        else
        {
          p_facadeCalculProduit.imputerAvant(periode, p_constituantsIndemnisation, p_attribution);
        }
      }
    }
    if (p_attribution.getDateAttribution() != null)
    {
      Damj dateAttribOuPjp = OutilGestionPoursuite.getInstance().recupererDateAttributionOuPjpSiPoursuite(p_attribution);
      p_periodesPriseEnCompte.tronquePeriodesPriseEnCompteEnDebut(dateAttribOuPjp);
    }
    Damj pjeNcp = OutilGestionPoursuite.getInstance().recupererPremierJourExecutableNcp(p_attribution);
    p_periodesPriseEnCompte.tronquePeriodesPriseEnCompteEnDebutHorsDecalantesEtGelantes(pjeNcp);
  }
  
  private static void preparerAutreExecution(AttributionSpec p_attribution, Periode p_periodeUT, ConstituantsIndemnisation p_constituantsIndemnisation, FacadeCalculProduitPeriodiqueSpec p_facadeCalculProduit, ChronologiePeriodes p_chronologiePeriodesSanctions)
    throws ApplicativeException
  {
    p_facadeCalculProduit.miseAJourConstituantsIndemnisationADate(p_attribution, p_constituantsIndemnisation, p_periodeUT.getDebut(), p_chronologiePeriodesSanctions);
  }
  
  private static void terminerPremiereExecution(CalendrierExecutionCalculSpec p_calendrier)
    throws CoucheLogiqueException
  {
    p_calendrier.setDernierJourIndemnisable(Damj.FIN_DES_TEMPS);
    p_calendrier.setEtatAttribution(2);
  }
  
  private static Quantite recupererDureeDecalageEnCours(CalendrierExecutionCalculPeriodique p_calendrierExecutionCalcul)
    throws CoucheLogiqueException
  {
    Quantite qteDecalageDureeEnCours = null;
    if (p_calendrierExecutionCalcul.getEtatAttribution() == 2) {
      qteDecalageDureeEnCours = ((UniteTraitement)p_calendrierExecutionCalcul.getChronologieUnitesTraitements().dernierElement()).getCreditDecalageDureeEnFinUT();
    }
    return qteDecalageDureeEnCours;
  }
  
  private static ConstituantsCalculActiviteReduiteSpec recupererConstituantsCalculActiviteReduite(AttributionSpec p_attribution, CalendrierExecutionCalculPeriodique p_calendrierExecutionCalcul, FacadeCalculProduitPeriodiqueSpec p_facadeCalculProduit, ContexteUT p_contexteUT, ConstituantsIndemnisation p_constituantsIndemnisation)
    throws CoucheLogiqueException
  {
    ConstituantsCalculActiviteReduiteSpec constituantsCalculActiviteReduite = null;
    if (p_calendrierExecutionCalcul.getEtatAttribution() == 1) {
      constituantsCalculActiviteReduite = p_facadeCalculProduit.creationConstituantsCalculActiviteReduite(p_attribution, p_contexteUT, p_constituantsIndemnisation);
    } else {
      constituantsCalculActiviteReduite = ((UniteTraitement)p_calendrierExecutionCalcul.getChronologieUnitesTraitements().dernierElement()).getConstituantsCalculActiviteReduiteEnFinUT();
    }
    return constituantsCalculActiviteReduite;
  }
  
  private static int recupererNbJourFormation(AttributionSpec p_attribution, CalendrierExecutionCalculPeriodique p_calendrierExecutionCalcul, FacadeCalculProduitPeriodiqueSpec p_facadeCalculProduit)
    throws CoucheLogiqueException
  {
    int nbJourFormation = 0;
    if (p_calendrierExecutionCalcul.getEtatAttribution() == 1) {
      nbJourFormation = p_facadeCalculProduit.initialiserCompteurFormation(p_attribution);
    } else {
      nbJourFormation = ((UniteTraitement)p_calendrierExecutionCalcul.getChronologieUnitesTraitements().dernierElement()).getNbJoursFormationEnFinDUT();
    }
    return nbJourFormation;
  }
  
  private static ConstituantsIndemnisation recupererConstituantsIndemnisation(AttributionSpec p_attribution, CalendrierExecutionCalculPeriodique p_calendrierExecutionCalcul, FacadeCalculProduitPeriodiqueSpec p_facadeCalculProduit, Periode periodeUT)
    throws CoucheLogiqueException
  {
    ConstituantsIndemnisation constituantsIndemnisation = null;
    constituantsIndemnisation = null;
    if (p_calendrierExecutionCalcul.getEtatAttribution() == 1)
    {
      constituantsIndemnisation = p_facadeCalculProduit.creationConstituantsIndemnisation(p_attribution);
    }
    else
    {
      UniteTraitement ut = (UniteTraitement)p_calendrierExecutionCalcul.getChronologieUnitesTraitements().dernierElement();
      constituantsIndemnisation = (ConstituantsIndemnisation)ut.getConstituantsIndemnisationEnFinUT().copie();
      
      p_facadeCalculProduit.ajouterConstituantsIndemnisationFuturs(constituantsIndemnisation, p_attribution, ut);
      
      p_facadeCalculProduit.controlerDureeDetectionMaintien(constituantsIndemnisation, p_attribution);
      
      p_facadeCalculProduit.initialiseElementBaseIndemnisationCourante(constituantsIndemnisation, p_attribution, periodeUT);
    }
    return constituantsIndemnisation;
  }
  
  private static ConstituantsIndemnisation recupererConstituantsIndemnisation(AttributionSpec p_attribution, CalendrierExecutionCalculPonctuel p_calendrierExecutionCalcul, FacadeCalculProduitPonctuelSpec p_facadeCalculProduit)
    throws CoucheLogiqueException
  {
    ConstituantsIndemnisation constituantsIndemnisation = null;
    if (p_calendrierExecutionCalcul.getEtatAttribution() == 1) {
      constituantsIndemnisation = p_facadeCalculProduit.creationConstituantsIndemnisation(p_attribution);
    }
    return constituantsIndemnisation;
  }
  
  private static ChronologiePeriodes initialiserChronologiePeriode(AttributionSpec p_attribution, Periode p_periodeUT, ChronologiePeriodes p_chronologiePeriodesGAEC, ChronologiePeriodes p_chronologiePeriodesPEC, ChronologiePeriodes p_chronologiePeriodesPECSansFiltre, ChronologiePeriodes p_chronologiePeriodesProduits, ChronologiePeriodes p_chronologiePeriodesEvtActualisation, ChronologiePeriodes p_chronologiePeriodesSanctions, ChronologiePeriodes p_chronologiePensionsInvaliditeEtAvantagesVieillesse, ContexteUT p_contexteUT, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, Damj p_dateBlocageIndemnisation)
    throws CoucheLogiqueException
  {
    Collection collectionPeriodesPourAttribution = new LinkedList();
    
    ChronologiePeriodes chronologiePeriodesPourAttribution = null;
    
    collectionPeriodesPourAttribution.addAll(p_chronologiePeriodesProduits.mapperVersCollection());
    if (p_chronologiePeriodesEvtActualisation != null) {
      collectionPeriodesPourAttribution.addAll(p_chronologiePeriodesEvtActualisation.mapperVersCollection());
    }
    ChronologiePeriodes chronologiePeriodesGAECFiltrees = facadeCalculProduit.filtrerFormationsEffectives(p_chronologiePeriodesGAEC, p_chronologiePeriodesPECSansFiltre);
    
    collectionPeriodesPourAttribution.addAll(chronologiePeriodesGAECFiltrees.mapperVersCollection());
    collectionPeriodesPourAttribution.addAll(p_chronologiePeriodesPEC.mapperVersCollection());
    
    Damj dja = p_attribution.getDemandeur().getDernierJourAtteste();
    ChronologiePeriodes chronologiePeriodesAPartirDesPECs = facadeCalculProduit.recupererPeriodeAPartirDesPECs(p_chronologiePeriodesPECSansFiltre, p_periodeUT, dja);
    if (chronologiePeriodesAPartirDesPECs != null) {
      collectionPeriodesPourAttribution.addAll(chronologiePeriodesAPartirDesPECs.mapperVersCollection());
    }
    ChronologiePeriodes chronologiePeriodesLieesAuContexte = facadeCalculProduit.recupererPeriodesLieesAuContexte(p_contexteUT, p_attribution);
    if (chronologiePeriodesLieesAuContexte != null) {
      collectionPeriodesPourAttribution.addAll(chronologiePeriodesLieesAuContexte.mapperVersCollection());
    }
    if (p_chronologiePeriodesSanctions != null) {
      collectionPeriodesPourAttribution.addAll(p_chronologiePeriodesSanctions.mapperVersCollection());
    }
    if (p_chronologiePensionsInvaliditeEtAvantagesVieillesse != null) {
      collectionPeriodesPourAttribution.addAll(p_chronologiePensionsInvaliditeEtAvantagesVieillesse.mapperVersCollection());
    }
    if (p_dateBlocageIndemnisation != null)
    {
      PeriodeBlocageIndemnisation periodeBlocageIndemnisation = new PeriodeBlocageIndemnisation(p_dateBlocageIndemnisation.lendemain());
      collectionPeriodesPourAttribution.add(periodeBlocageIndemnisation);
    }
    FiltresTemporel filtreCali = new FiltresTemporel();
    filtreCali.ajouterFiltre(new FiltreChevauchePeriode(new Periode(p_periodeUT.getDebut(), p_periodeUT.getFin().lendemain())));
    if (facadeCalculProduit.ajouterFiltrePeriodeSurUT() != null) {
      filtreCali.ajouterFiltre(facadeCalculProduit.ajouterFiltrePeriodeSurUT());
    }
    chronologiePeriodesPourAttribution = new ChronologiePeriodes(filtreCali);
    
    Collection collectionPeriodesPourAttributionFiltrees = facadeCalculProduit.filtrerRadiationSegmentante(collectionPeriodesPourAttribution, p_attribution);
    
    chronologiePeriodesPourAttribution.ajouter(collectionPeriodesPourAttributionFiltrees);
    
    return chronologiePeriodesPourAttribution;
  }
  
  private static void effectuerTraitementBlocageIndemnisation(UniteTraitement p_ut, Damj p_dateBlocageIndmnisation, Damj p_pji)
    throws CoucheLogiqueException
  {
    if (p_dateBlocageIndmnisation != null) {
      if (p_dateBlocageIndmnisation.estContenueDans(p_ut.getPeriode())) {
        p_ut.ajouterEvenement(new EvenementBlocageIndemnisation(p_dateBlocageIndmnisation));
      } else if ((p_pji.estContenueDans(p_ut.getPeriode())) && (p_dateBlocageIndmnisation.estAvant(p_ut.getDateDebut()))) {
        p_ut.ajouterEvenement(new EvenementBlocageIndemnisation(p_pji));
      }
    }
  }
  
  private static Collection determinerListeDNJ(ChronologiePeriodes p_chronologiePeriodesGAEC, UniteTraitement p_ut)
  {
    ChronologiePeriodes chronoPeriodesApresFiltreUT = null;
    DsmTravail periodeDeclare = null;
    Object objet = null;
    Collection listeRetour = new ArrayList();
    
    FiltreChevauchePeriode filtreUT = new FiltreChevauchePeriode(new Periode(p_ut.getDateDebut(), p_ut.getDateFin()));
    
    chronoPeriodesApresFiltreUT = (ChronologiePeriodes)p_chronologiePeriodesGAEC.copier(filtreUT);
    
    chronoPeriodesApresFiltreUT.iterer();
    while (chronoPeriodesApresFiltreUT.encoreSuivant())
    {
      objet = chronoPeriodesApresFiltreUT.elementSuivant();
      if ((objet instanceof DsmTravail))
      {
        periodeDeclare = (DsmTravail)objet;
        
        CritereStrategie critereStrategie = new CritereStrategie();
        critereStrategie.setDatePivot(periodeDeclare.getDateDebut());
        
        StrategieDetectionDNJSpec strategie = (StrategieDetectionDNJSpec)FabriqueStrategieDetectionDNJ.getInstance().getStrategie(critereStrategie);
        
        strategie.enrichirListeDNJ(periodeDeclare, p_ut, listeRetour);
      }
    }
    return listeRetour;
  }
  
  private static MontantBaseAbstrait recupererMontant(UniteTraitement p_derniereUT, CalendrierExecutionCalculPeriodique p_calendrierExecutionCalcul)
    throws CoucheLogiqueException
  {
    MontantBaseAbstrait montant = null;
    
    Collection collectionSommes = p_derniereUT.getCollectionSommes();
    
    Iterator iterator = collectionSommes.iterator();
    while (iterator.hasNext())
    {
      Somme somme = (Somme)iterator.next();
      if (somme.getDateFin().coincideAvec(p_calendrierExecutionCalcul.getDernierJourIndemnisable()))
      {
        montant = (MontantBaseAbstrait)somme.getMontant();
        break;
      }
    }
    return montant;
  }
  
  private static UniteTraitement alimenterUtAvecCompteurs(UniteTraitement p_ut, FacadeCalculProduitPeriodiqueSpec p_facadeCalculProduit, int p_nbJourFormation, int p_cumulNombreJoursServi, AttributionSpec p_attribution, CalendrierExecutionCalculPeriodique p_calendrier, ContexteUT p_contexteUT, ConstituantsIndemnisation constituantsIndemnisation)
    throws CoucheLogiqueException
  {
    p_ut.setNbJoursFormationEnDebutDUT(p_nbJourFormation);
    int nbJoursEnFinUT = p_facadeCalculProduit.calculerCompteurFormationSurUT(p_ut);
    p_ut.setNbJoursFormationEnFinDUT(nbJoursEnFinUT);
    
    p_ut.setCumulJoursIndemniseEnDebutDUT(p_cumulNombreJoursServi);
    int cumulNbJoursServiSurUT = p_facadeCalculProduit.calculerCompteurNombreJoursIndemnisesSurUT(p_ut, p_cumulNombreJoursServi);
    p_ut.setCumulJoursIndemnise(cumulNbJoursServiSurUT);
    int nombreMoisIndemnise = recupererNbMoisIndemnise(p_attribution, p_calendrier, p_facadeCalculProduit, p_ut, p_contexteUT);
    p_ut.setNbMoisIndemniseAsu(nombreMoisIndemnise);
    
    p_facadeCalculProduit.miseAjourCumulAllongementAREF(p_ut, constituantsIndemnisation, p_attribution);
    
    p_facadeCalculProduit.miseAJourCompteurs(p_attribution, p_ut);
    if (p_ut.getDateEpuisementDuree() != null) {
      p_calendrier.setDateEpuisementDuree(p_ut.getDateEpuisementDuree());
    }
    return p_ut;
  }
  
  private static boolean estGestionDnj(AttributionSpec p_attribution)
  {
    return (p_attribution.getGamme().getNomUnique().equals("ASU")) || (p_attribution.getGamme().getNomUnique().equals("SOL"));
  }
  
  private static Collection convertirEnListeDsmProduit(Collection p_listeDsm, AttributionSpec p_attribution)
    throws ApplicativeException
  {
    Collection listeDsmProduit = new ArrayList();
    FacadeCalculProduitSpec facadeCalcul = FacadeCalculProduitFactory.getInstance().getInstanceGestionnaireCalculProduit(p_attribution.getProduitExecution());
    
    Iterator iterateurDsm = p_listeDsm.iterator();
    while (iterateurDsm.hasNext())
    {
      DsmTravail dsmTravail = (DsmTravail)iterateurDsm.next();
      
      DsmTravail dsmTravailProduit = facadeCalcul.convertirDsmTravailVersDsmTravailProduit(dsmTravail);
      listeDsmProduit.add(dsmTravailProduit);
    }
    return listeDsmProduit;
  }
  
  private static Periode recupererPeriodeEvenementReducteur(CalendrierExecutionCalculPeriodique p_calendrier, PeriodesPriseEnCompte p_periodesPriseEnCompte, AttributionSpec p_attribution)
  {
    ChronologiePeriodes periodesDecalantes = p_periodesPriseEnCompte.getPeriodesParTypologie(5);
    
    Damj dateFinPeriodePriseEnCompte = p_calendrier.getDernierJourIndemnisable();
    boolean estTrouve = false;
    Iterator iter = periodesDecalantes.iterer();
    while ((iter.hasNext()) && (!estTrouve))
    {
      ObjetChronoPeriodeConcrete periodePriseEnCompteDecalant = (ObjetChronoPeriodeConcrete)iter.next();
      dateFinPeriodePriseEnCompte = periodePriseEnCompteDecalant.getDateFin();
      estTrouve = true;
    }
    Periode periodeEvenementReducteur = new Periode(p_attribution.getDateAttribution(), dateFinPeriodePriseEnCompte);
    return periodeEvenementReducteur;
  }
  
  private static int recupererCumulNombreJoursServi(CalendrierExecutionCalculPeriodique p_calendrierExecutionCalcul, AttributionSpec p_attribution, FacadeCalculProduitPeriodiqueSpec p_facadeCalculProduit)
    throws CoucheLogiqueException
  {
    int cumulNombreJoursServi = 0;
    if (p_calendrierExecutionCalcul.getEtatAttribution() == 1) {
      cumulNombreJoursServi = p_facadeCalculProduit.initialiserCumulNombreJoursServi(p_attribution);
    } else {
      cumulNombreJoursServi = ((UniteTraitement)p_calendrierExecutionCalcul.getChronologieUnitesTraitements().dernierElement()).getCumulJoursIndemnise();
    }
    return cumulNombreJoursServi;
  }
  
  private static int recupererNbMoisIndemnise(AttributionSpec p_attribution, CalendrierExecutionCalculPeriodique p_calendrierExecutionCalcul, FacadeCalculProduitPeriodiqueSpec p_facadeCalculProduit, UniteTraitement p_ut, ContexteUT p_contexteUT)
    throws CoucheLogiqueException
  {
    int nbMoisIndemnise = 0;
    boolean estAlimente = false;
    if (p_calendrierExecutionCalcul.getEtatAttribution() == 1)
    {
      estAlimente = p_facadeCalculProduit.recuperationAlimentationNombreMoisIndemnise(p_attribution);
      if (estAlimente) {
        nbMoisIndemnise = p_facadeCalculProduit.initialiserNombreMoisIndemnise(p_attribution, p_ut, p_contexteUT);
      }
    }
    else
    {
      UniteTraitement derniereUTPersistante = (UniteTraitement)p_calendrierExecutionCalcul.getChronologieUnitesTraitements().dernierElement();
      if (derniereUTPersistante.isEstNbMoisIndemniseAsu())
      {
        nbMoisIndemnise = derniereUTPersistante.getNbMoisIndemniseAsu();
        estAlimente = true;
      }
    }
    p_ut.setNbMoisIndemniseEnDebutDUT(nbMoisIndemnise);
    if (estAlimente)
    {
      nbMoisIndemnise = p_facadeCalculProduit.calculerCompteurNombreMoisIndemnisesSurUT(p_ut, nbMoisIndemnise);
      p_ut.setEstNbMoisIndemniseAsu(true);
    }
    return nbMoisIndemnise;
  }
}

/* Location:
 * Qualified Name:     TraitementUT
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */