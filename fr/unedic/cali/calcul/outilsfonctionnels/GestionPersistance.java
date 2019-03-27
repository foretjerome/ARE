package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.calcul.FacadeCalculProduitFactory;
import fr.unedic.cali.calcul.FacadeCalculProduitSpec;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPonctuel;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.PoursuiteSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GestionPersistance
{
  public static Map creerCalendriers(List p_listeAttributions, Map p_mapFacadesCalculProduit, boolean p_executionDepuisPersistance, boolean p_executionVersPersistance, Damj p_dateDebutUT)
    throws CoucheLogiqueException
  {
    Map mapCalendriers = null;
    Iterator iterateur = null;
    AttributionSpec attribution = null;
    CalendrierExecutionCalculSpec calendrier = null;
    
    mapCalendriers = new HashMap();
    
    iterateur = p_listeAttributions.iterator();
    while (iterateur.hasNext())
    {
      attribution = (AttributionSpec)iterateur.next();
      Damj pjeNcp = OutilGestionPoursuite.getInstance().recupererPremierJourExecutableNcp(attribution);
      
      CalendrierExecutionCalculSpec calendrierPersistant = attribution.getCalendrierExecutionCalcul();
      if ((p_executionDepuisPersistance) && (p_executionVersPersistance) && (calendrierPersistant != null))
      {
        calendrier = calendrierPersistant;
        if (!"INR_PFM01_01".equals(attribution.getProduit().getNomUnique()))
        {
          calendrier.setPremierJourIndemnisable(pjeNcp);
        }
        else if (calendrier.getEtatAttribution() == 1)
        {
          ((FacadeCalculProduitSpec)p_mapFacadesCalculProduit.get(attribution)).controlerPjiAttribution(attribution, p_dateDebutUT);
          calendrier.setPremierJourIndemnisable(pjeNcp);
        }
      }
      else if ((p_executionDepuisPersistance) && (calendrierPersistant != null))
      {
        calendrier = ((FacadeCalculProduitSpec)p_mapFacadesCalculProduit.get(attribution)).creerCalendrierExecutionCalcul(attribution);
        
        calendrier.setEtatAttribution(calendrierPersistant.getEtatAttribution());
        if (!"INR_PFM01_01".equals(attribution.getProduit().getNomUnique()))
        {
          calendrier.setPremierJourIndemnisable(pjeNcp);
        }
        else if (calendrier.getEtatAttribution() == 1)
        {
          ((FacadeCalculProduitSpec)p_mapFacadesCalculProduit.get(attribution)).controlerPjiAttribution(attribution, p_dateDebutUT);
          calendrier.setPremierJourIndemnisable(pjeNcp);
        }
        calendrier.setDernierJourIndemnisable(calendrierPersistant.getDernierJourIndemnisable());
        
        alimenterCalendrierDUneAttributionMigreeEnSimplifiee(attribution, calendrier);
      }
      else
      {
        calendrier = ((FacadeCalculProduitSpec)p_mapFacadesCalculProduit.get(attribution)).creerCalendrierExecutionCalcul(attribution);
        if (attribution.estPjiEffectif()) {
          calendrier.setEtatAttribution(1);
        } else {
          calendrier.setEtatAttribution(4);
        }
        ((FacadeCalculProduitSpec)p_mapFacadesCalculProduit.get(attribution)).controlerPjiAttribution(attribution, p_dateDebutUT);
        calendrier.setPremierJourIndemnisable(pjeNcp);
        
        alimenterCalendrierDUneAttributionMigreeEnSimplifiee(attribution, calendrier);
        if (p_executionDepuisPersistance) {
          attribution.setCalendrierExecutionCalcul(calendrier);
        }
      }
      if (p_executionVersPersistance) {
        attribution.setCalendrierExecutionCalcul(calendrier);
      }
      mapCalendriers.put(attribution, calendrier);
    }
    if (p_executionDepuisPersistance) {
      if (p_executionVersPersistance) {
        reinitialiserCalendriersPersistant(p_listeAttributions, mapCalendriers, p_dateDebutUT);
      } else {
        reinitialiserCalendriers(p_listeAttributions, mapCalendriers, p_dateDebutUT);
      }
    }
    return mapCalendriers;
  }
  
  private static void reinitialiserCalendriersPersistant(List p_listeAttributions, Map p_mapCalendriers, Damj p_dateDebutExecution)
    throws CoucheLogiqueException
  {
    Iterator iterateur = null;
    AttributionSpec attribution = null;
    CalendrierExecutionCalculSpec calendrier = null;
    FacadeCalculProduitSpec facadeCalculProduit = null;
    
    iterateur = p_listeAttributions.iterator();
    while (iterateur.hasNext())
    {
      attribution = (AttributionSpec)iterateur.next();
      calendrier = (CalendrierExecutionCalculSpec)p_mapCalendriers.get(attribution);
      if (calendrier.getEtatAttribution() != 1)
      {
        if ((p_dateDebutExecution.estAvant(calendrier.getPremierJourIndemnisable().getDebutMoisSuivant())) || (("INR_PFM01_01".equals(attribution.getProduit().getNomUnique())) && (calendrier.getEtatAttribution() == 4)))
        {
          calendrier.setEtatAttribution(1);
          calendrier.reinitialiserCalendrier(p_dateDebutExecution);
          if ((calendrier.getDernierJourIndemnisablePourSuivi() != null) && (calendrier.getDernierJourIndemnisablePourSuivi().estApresOuCoincideAvec(p_dateDebutExecution))) {
            calendrier.setDernierJourIndemnisablePourSuivi(null);
          }
          facadeCalculProduit = FacadeCalculProduitFactory.getInstance().getInstanceGestionnaireCalculProduit(attribution.getProduit());
          
          facadeCalculProduit.controlerPjiAttribution(attribution, p_dateDebutExecution);
        }
        else if ((calendrier.getDernierJourIndemnisable() == null) || (p_dateDebutExecution.estAvantOuCoincideAvec(calendrier.getDernierJourIndemnisable())) || (((calendrier instanceof CalendrierExecutionCalculPeriodique)) && (((CalendrierExecutionCalculPeriodique)calendrier).getChronologieUnitesTraitements() != null) && (!((CalendrierExecutionCalculPeriodique)calendrier).getChronologieUnitesTraitements().estVide()) && (p_dateDebutExecution.estAvantOuCoincideAvec(((CalendrierExecutionCalculPeriodique)calendrier).getChronologieUnitesTraitements().dernierElement().getDateFin()))))
        {
          if (attribution.estPjiEffectif()) {
            calendrier.setEtatAttribution(2);
          } else {
            calendrier.setEtatAttribution(4);
          }
          calendrier.reinitialiserCalendrier(p_dateDebutExecution);
          if ((calendrier.getDernierJourIndemnisablePourSuivi() != null) && (calendrier.getDernierJourIndemnisablePourSuivi().estApresOuCoincideAvec(p_dateDebutExecution))) {
            calendrier.setDernierJourIndemnisablePourSuivi(null);
          }
        }
      }
      else
      {
        facadeCalculProduit = FacadeCalculProduitFactory.getInstance().getInstanceGestionnaireCalculProduit(attribution.getProduitExecution());
        
        facadeCalculProduit.controlerPjiAttribution(attribution, p_dateDebutExecution);
        if ((calendrier != null) && ((calendrier instanceof CalendrierExecutionCalculPeriodique)) && (((CalendrierExecutionCalculPeriodique)calendrier).getChronologieUnitesTraitements() != null) && (!((CalendrierExecutionCalculPeriodique)calendrier).getChronologieUnitesTraitements().estVide())) {
          ((CalendrierExecutionCalculPeriodique)calendrier).reinitialiserCalendrier(calendrier.getPremierJourIndemnisable());
        }
      }
    }
  }
  
  private static void reinitialiserCalendriers(List p_listeAttributions, Map p_mapCalendriers, Damj p_dateDebutExecution)
    throws CoucheLogiqueException
  {
    Iterator iterateur = null;
    AttributionSpec attribution = null;
    CalendrierExecutionCalculSpec calendrier = null;
    FacadeCalculProduitSpec facadeCalculProduit = null;
    
    iterateur = p_listeAttributions.iterator();
    while (iterateur.hasNext())
    {
      attribution = (AttributionSpec)iterateur.next();
      calendrier = (CalendrierExecutionCalculSpec)p_mapCalendriers.get(attribution);
      if (calendrier.getEtatAttribution() != 1) {
        if ((calendrier instanceof CalendrierExecutionCalculPeriodique))
        {
          if ((p_dateDebutExecution.estAvant(calendrier.getPremierJourIndemnisable().getDebutMoisSuivant())) || (("INR_PFM01_01".equals(attribution.getProduit().getNomUnique())) && (calendrier.getEtatAttribution() == 4)))
          {
            calendrier.setEtatAttribution(1);
            
            facadeCalculProduit = FacadeCalculProduitFactory.getInstance().getInstanceGestionnaireCalculProduit(attribution.getProduitExecution());
            
            facadeCalculProduit.controlerPjiAttribution(attribution, p_dateDebutExecution);
          }
          else
          {
            if ((calendrier.getDernierJourIndemnisable() == null) || (p_dateDebutExecution.estAvantOuCoincideAvec(calendrier.getDernierJourIndemnisable())) || (((calendrier instanceof CalendrierExecutionCalculPeriodique)) && (((CalendrierExecutionCalculPeriodique)calendrier).getChronologieUnitesTraitements() != null) && (!((CalendrierExecutionCalculPeriodique)calendrier).getChronologieUnitesTraitements().estVide()) && (p_dateDebutExecution.estAvantOuCoincideAvec(((CalendrierExecutionCalculPeriodique)calendrier).getChronologieUnitesTraitements().dernierElement().getDateFin())))) {
              if (attribution.estPjiEffectif()) {
                calendrier.setEtatAttribution(2);
              } else {
                calendrier.setEtatAttribution(4);
              }
            }
            CalendrierExecutionCalculPeriodique calendrierEtatDroit = (CalendrierExecutionCalculPeriodique)attribution.getCalendrierExecutionCalcul();
            
            UniteTraitement derniereUT = null;
            Iterator iterateurUT = calendrierEtatDroit.getChronologieUnitesTraitements().iterer();
            while (iterateurUT.hasNext())
            {
              derniereUT = (UniteTraitement)iterateurUT.next();
              if (derniereUT.getDateFin().coincideAvec(p_dateDebutExecution.getFinMoisPrecedent())) {
                break;
              }
            }
            if (derniereUT != null) {
              ((CalendrierExecutionCalculPeriodique)calendrier).ajouterUT(derniereUT);
            }
          }
        }
        else if (((calendrier instanceof CalendrierExecutionCalculPonctuel)) && 
          (p_dateDebutExecution.estAvant(calendrier.getPremierJourIndemnisable().getDebutMoisSuivant()))) {
          calendrier.setEtatAttribution(1);
        }
      }
    }
  }
  
  public static void purgerCalendriers(Map p_mapCalendriers, Damj p_dateDebutExecution, Collection p_attibutionsAbandonnees)
    throws CoucheLogiqueException
  {
    Collection collectionPeriodesUTsAConserver = new ArrayList();
    
    Collection collectionPeriodesUTsAConserverSurPJItheorique = new ArrayList();
    Iterator iterateurAttibutionsAbandonnees = p_attibutionsAbandonnees.iterator();
    while (iterateurAttibutionsAbandonnees.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)iterateurAttibutionsAbandonnees.next();
      if (attribution.getPji() != null) {
        collectionPeriodesUTsAConserverSurPJItheorique.add(new Periode(attribution.getPji().getFinMoisPrecedent().getDebutMois(), attribution.getPji().getFinMoisPrecedent()));
      }
    }
    collectionPeriodesUTsAConserver.addAll(collectionPeriodesUTsAConserverSurPJItheorique);
    
    Collection collectionPeriodesUTsAConserverSurPJI = new ArrayList();
    Iterator iterateurCalendrier = p_mapCalendriers.keySet().iterator();
    while (iterateurCalendrier.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)iterateurCalendrier.next();
      CalendrierExecutionCalculSpec calendrier = attribution.getCalendrierExecutionCalcul();
      if (calendrier.getEtatAttribution() != 1) {
        collectionPeriodesUTsAConserverSurPJI.add(new Periode(calendrier.getPremierJourIndemnisable().getFinMoisPrecedent().getDebutMois(), calendrier.getPremierJourIndemnisable().getFinMoisPrecedent()));
      }
    }
    collectionPeriodesUTsAConserver.addAll(collectionPeriodesUTsAConserverSurPJI);
    
    collectionPeriodesUTsAConserver.add(new Periode(p_dateDebutExecution.getFinMoisPrecedent(), p_dateDebutExecution.getFinMoisPrecedent().getDebutMois()));
    
    Collection collectionPeriodesUTsAConserverSurDJI = new ArrayList();
    iterateurCalendrier = p_mapCalendriers.keySet().iterator();
    while (iterateurCalendrier.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)iterateurCalendrier.next();
      CalendrierExecutionCalculSpec calendrier = attribution.getCalendrierExecutionCalcul();
      if (calendrier.getEtatAttribution() != 1)
      {
        Iterator iterateurPeriodesUTs = collectionPeriodesUTsAConserver.iterator();
        while (iterateurPeriodesUTs.hasNext()) {
          if (calendrier.getDernierJourIndemnisable().estAvant(((Periode)iterateurPeriodesUTs.next()).getFin())) {
            collectionPeriodesUTsAConserverSurDJI.add(new Periode(calendrier.getDernierJourIndemnisable().getFinMoisPrecedent().getDebutMois(), calendrier.getDernierJourIndemnisable().getFinMoisPrecedent()));
          }
        }
      }
    }
    collectionPeriodesUTsAConserver.addAll(collectionPeriodesUTsAConserverSurDJI);
    
    Iterator iterateurPeriodesUTs = collectionPeriodesUTsAConserver.iterator();
    while (iterateurPeriodesUTs.hasNext())
    {
      Periode periodeUTAconserver = (Periode)iterateurPeriodesUTs.next();
      if (periodeUTAconserver.getDebut().estApresOuCoincideAvec(p_dateDebutExecution)) {
        iterateurPeriodesUTs.remove();
      }
    }
    iterateurCalendrier = p_mapCalendriers.keySet().iterator();
    while (iterateurCalendrier.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)iterateurCalendrier.next();
      if ((!attribution.getProduit().getNom().equals("ASU_SPE02_03")) && (!attribution.getProduit().getNom().equals("ASU_SPE02_04")) && (!attribution.getProduit().getNom().equals("ASU_SPE02_06")) && (!attribution.getProduit().getNom().equals("ASU_SPE02_05")))
      {
        CalendrierExecutionCalculSpec calendrier = attribution.getCalendrierExecutionCalcul();
        if ((calendrier instanceof CalendrierExecutionCalculPeriodique))
        {
          Collection collectionUTsASupprimer = new ArrayList();
          
          Chronologie chronoUTs = ((CalendrierExecutionCalculPeriodique)calendrier).getChronologieUnitesTraitements();
          if (chronoUTs != null)
          {
            chronoUTs.iterer();
            boolean estApresUtPP = false;
            while (chronoUTs.encoreSuivant())
            {
              UniteTraitement uniteTraitement = (UniteTraitement)chronoUTs.elementSuivant();
              boolean bUTsASupprimer = false;
              if ((uniteTraitement.getStatut() == 7) || (uniteTraitement.getStatut() == 5) || (estApresUtPP))
              {
                bUTsASupprimer = true;
                estApresUtPP = true;
              }
              if (bUTsASupprimer) {
                collectionUTsASupprimer.add(uniteTraitement);
              }
            }
          }
          Iterator iterateurUTs = collectionUTsASupprimer.iterator();
          while (iterateurUTs.hasNext())
          {
            UniteTraitement ut = (UniteTraitement)iterateurUTs.next();
            if (!ut.isEstFigee()) {
              ((CalendrierExecutionCalculPeriodique)calendrier).supprimerUT(ut);
            }
          }
        }
      }
    }
    iterateurCalendrier = p_mapCalendriers.keySet().iterator();
    while (iterateurCalendrier.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)iterateurCalendrier.next();
      CalendrierExecutionCalculSpec calendrier = attribution.getCalendrierExecutionCalcul();
      if ((calendrier instanceof CalendrierExecutionCalculPeriodique))
      {
        Collection collectionUTsASupprimer = new ArrayList();
        
        Chronologie chronoUTs = ((CalendrierExecutionCalculPeriodique)calendrier).getChronologieUnitesTraitements();
        if (chronoUTs != null)
        {
          chronoUTs.iterer();
          while (chronoUTs.encoreSuivant())
          {
            UniteTraitement uniteTraitement = (UniteTraitement)chronoUTs.elementSuivant();
            
            boolean bUTsASupprimer = true;
            
            iterateurPeriodesUTs = collectionPeriodesUTsAConserver.iterator();
            while (iterateurPeriodesUTs.hasNext())
            {
              Periode periodeUTAconserver = (Periode)iterateurPeriodesUTs.next();
              if ((calendrier.getDernierJourIndemnisable().estApres(periodeUTAconserver.getFin())) && (uniteTraitement.chevauche(periodeUTAconserver))) {
                bUTsASupprimer = false;
              }
            }
            if (bUTsASupprimer) {
              collectionUTsASupprimer.add(uniteTraitement);
            }
          }
        }
        Iterator iterateurUTs = collectionUTsASupprimer.iterator();
        while (iterateurUTs.hasNext())
        {
          UniteTraitement ut = (UniteTraitement)iterateurUTs.next();
          if (!ut.isEstFigee()) {
            ((CalendrierExecutionCalculPeriodique)calendrier).supprimerUT(ut);
          }
        }
      }
    }
  }
  
  public static void nettoyerExecutions(Collection p_listeDemandes)
    throws CoucheLogiqueException
  {
    Iterator iterateurDemande = p_listeDemandes.iterator();
    while (iterateurDemande.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)iterateurDemande.next();
      if (demande.getListeDossiersExamen() != null)
      {
        Iterator iterateurDossierExamen = demande.getListeDossiersExamen().iterator();
        while (iterateurDossierExamen.hasNext())
        {
          DossierExamenSpec dossierExamen = (DossierExamenSpec)iterateurDossierExamen.next();
          if ((dossierExamen != null) && ((dossierExamen instanceof AttributionSpec)))
          {
            AttributionSpec attribution = (AttributionSpec)dossierExamen;
            if (!attribution.estMigreeEnSimplifiee())
            {
              attribution.setCalendrierExecutionCalcul(null);
              attribution.setCalendrierExecutionAvant(null);
            }
            if ((attribution instanceof PoursuiteSpec))
            {
              ((PoursuiteSpec)attribution).setUniteTraitement(null);
              ((PoursuiteSpec)attribution).setUniteTraitementAvant(null);
            }
          }
        }
      }
    }
  }
  
  private static void alimenterCalendrierDUneAttributionMigreeEnSimplifiee(AttributionSpec p_attribution, CalendrierExecutionCalculSpec p_calendrier)
    throws CoucheLogiqueException
  {
    if (p_attribution.estMigreeEnSimplifiee()) {
      if ((p_attribution.getCalendrierExecutionCalcul() != null) && ((p_attribution.getCalendrierExecutionCalcul() instanceof CalendrierExecutionCalculPeriodique)))
      {
        CalendrierExecutionCalculPeriodique calendrierPersistant = (CalendrierExecutionCalculPeriodique)p_attribution.getCalendrierExecutionCalcul();
        
        UniteTraitement utFigee = calendrierPersistant.getUTFigee();
        
        CalendrierExecutionCalculPeriodique nouveauCalendrier = (CalendrierExecutionCalculPeriodique)p_calendrier;
        if (utFigee != null)
        {
          nouveauCalendrier.ajouterUTFigee(utFigee);
          nouveauCalendrier.setEtatAttribution(2);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     GestionPersistance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */