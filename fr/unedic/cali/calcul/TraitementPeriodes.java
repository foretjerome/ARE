package fr.unedic.cali.calcul;

import fr.unedic.cali.calcul.dom.ArretProduitAvecRaison;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.ConstituantsCalculActiviteReduiteSpec;
import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.QualificationPeriodes;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoRemplissage;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.ContexteUT;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAnalyse;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAnalyseSpec;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodesPriseEnCompte;
import fr.unedic.cali.calcul.outilsfonctionnels.proratisation.PeriodeProratisationFactory;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.FiltreDebutDansBornes;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class TraitementPeriodes
{
  static ArretProduitAvecRaison traitementPeriodesInterruptivesDefinitives(PeriodesPriseEnCompte periodesPriseEnCompte, UniteTraitement ut, AttributionSpec attribution, FacadeCalculProduitPeriodiqueSpec facade, CalendrierExecutionCalculPeriodique calendrier)
    throws CoucheLogiqueException
  {
    ObjetChronoPeriode objetChronoPeriode = null;
    ListIterator iterator = null;
    ArretProduitAvecRaison retour = new ArretProduitAvecRaison();
    Damj dateDebutPremierePeriodeTraitee = null;
    ChronologiePeriodes periodesInterruptivesDefinitives = ut.getQualificationPeriodes().getPeriodesInterruptivesDefinitives();
    
    iterator = periodesInterruptivesDefinitives.iterer();
    while (iterator.hasNext())
    {
      objetChronoPeriode = (ObjetChronoPeriode)iterator.next();
      if ((dateDebutPremierePeriodeTraitee == null) || (objetChronoPeriode.getDateDebut().equals(dateDebutPremierePeriodeTraitee)))
      {
        dateDebutPremierePeriodeTraitee = objetChronoPeriode.getDateDebut();
        
        retour.ajoutePeriodeInterruptiveDefinitive(objetChronoPeriode);
        
        periodesPriseEnCompte.tronquePeriodesPriseEnCompteEnFin(objetChronoPeriode.getDateDebut().veille());
        
        facade.traiterPeriodeInterruptiveDefinitive(attribution, ut, objetChronoPeriode, retour, calendrier);
      }
    }
    return retour;
  }
  
  static void traitementPeriodesInterruptives(PeriodesPriseEnCompte periodesPriseEnCompte, ChronologiePeriodes periodesInterruptives)
    throws CoucheLogiqueException
  {
    ObjetChronoPeriode objetChronoPeriode = null;
    ListIterator iterator = null;
    Damj dateDebutPremierePeriodeTraitee = null;
    
    iterator = periodesInterruptives.iterer();
    while (iterator.hasNext())
    {
      objetChronoPeriode = (ObjetChronoPeriode)iterator.next();
      if ((dateDebutPremierePeriodeTraitee == null) || (objetChronoPeriode.getDateDebut().equals(dateDebutPremierePeriodeTraitee)))
      {
        dateDebutPremierePeriodeTraitee = objetChronoPeriode.getDateDebut();
        
        Periode periodeReference = new Periode();
        
        periodeReference.setDebut(objetChronoPeriode.getDateDebut());
        periodeReference.setFin(objetChronoPeriode.getDateFin());
        periodesPriseEnCompte.tronquePeriodesPriseEnCompteEnExcluantPeriode(periodeReference);
      }
    }
  }
  
  static ChronologiePeriodes traitementPeriodesSegmentantes(Periode periode, UniteTraitement ut, ChronologiePeriodes periodesSegmentantes)
    throws CoucheLogiqueException
  {
    PeriodeAnalyseSpec periodeAnalysePrecedente = null;
    PeriodeAnalyseSpec periodeAnalyseNouvelle = null;
    ObjetChronoPeriode periodeSegmentante = null;
    ChronologiePeriodes chronoPeriodesAnalyse = new ChronologiePeriodes();
    ListIterator iterateur = null;
    ChronologiePeriodes chronoPeriodesSegmentantesSurUt = null;
    
    periodeAnalysePrecedente = new PeriodeAnalyse(ut.getUniteParDefautQuantites(), new Periode(periode.getDebut(), periode.getFin()));
    
    chronoPeriodesAnalyse.ajouter(periodeAnalysePrecedente);
    
    chronoPeriodesSegmentantesSurUt = (ChronologiePeriodes)periodesSegmentantes.copier(new FiltreDebutDansBornes(periode));
    
    iterateur = chronoPeriodesSegmentantesSurUt.iterer();
    while (iterateur.hasNext())
    {
      periodeSegmentante = (ObjetChronoPeriode)iterateur.next();
      if (!periodeSegmentante.getDateDebut().coincideAvec(periodeAnalysePrecedente.getDateDebut()))
      {
        if (periodeSegmentante.getDateDebut().estApres(periodeAnalysePrecedente.getDateFin())) {
          throw new CoucheLogiqueException("HG_PR_CALI_L_ERREUR_TRAITEMENT_PERIODE_SEGMENTANTE", "Erreur de date de début lors du traitement des périodes segmentantes dans le Calcul.", null);
        }
        periodeAnalysePrecedente.setDateFin(periodeSegmentante.getDateDebut().veille());
        
        periodeAnalyseNouvelle = new PeriodeAnalyse(ut.getUniteParDefautQuantites(), new Periode(periodeSegmentante.getDateDebut(), periode.getFin()));
        
        chronoPeriodesAnalyse.ajouter(periodeAnalyseNouvelle);
        
        periodeAnalysePrecedente = periodeAnalyseNouvelle;
      }
    }
    return chronoPeriodesAnalyse;
  }
  
  static void traitementPeriodesGelantes(FacadeCalculProduitPeriodiqueSpec gestionnaireCalculProduit, AttributionSpec attribution, ChronologiePeriodes periodesGelantes, ConstituantsCalculActiviteReduiteSpec constituantsCalculActiviteReduite, UniteTraitement ut)
    throws CoucheLogiqueException
  {
    gestionnaireCalculProduit.traitementPeriodesGelantes(attribution, periodesGelantes, constituantsCalculActiviteReduite, ut);
  }
  
  static void traitementPeriodesDecalantes(FacadeCalculProduitPeriodiqueSpec gestionnaireCalculProduit, AttributionSpec attribution, ChronologiePeriodes periodesDecalantes, ConstituantsCalculActiviteReduiteSpec constituantsCalculActiviteReduite, UniteTraitement ut, ConstituantsIndemnisation constituantsIndemnisation, ContexteUT contexteUT)
    throws CoucheLogiqueException
  {
    gestionnaireCalculProduit.traitementPeriodesDecalantes(attribution, periodesDecalantes, constituantsCalculActiviteReduite, ut, constituantsIndemnisation, contexteUT);
  }
  
  static void traitementPeriodesSuspensives(FacadeCalculProduitPeriodiqueSpec gestionnaireCalculProduit, AttributionSpec attribution, PeriodeAnalyseSpec pa, QualificationPeriodes qualificationPeriodes, int quantiteDaImputeDebutMois)
    throws CoucheLogiqueException
  {
    Periode periodePa = pa.getPeriode();
    if (quantiteDaImputeDebutMois != 0) {
      periodePa = new Periode(pa.getPeriode().getDebut().deplacerVersAvant(new DureeCalendaire(0, 0, quantiteDaImputeDebutMois)), pa.getPeriode().getFin());
    }
    ChronologiePeriodes chronologiePeriodesSuspensivesSurPeriode = PeriodeProratisationFactory.decoupeEtProratiseParDefaut(qualificationPeriodes.getPeriodesSuspensives(), periodePa);
    
    qualificationPeriodes.ajouterChronologieSuspensivesDecoupesParSegmentants(chronologiePeriodesSuspensivesSurPeriode);
    
    gestionnaireCalculProduit.traitementPeriodesSuspensives(attribution, chronologiePeriodesSuspensivesSurPeriode, pa);
  }
  
  public static Quantite getQuantiteSuspensive(Periode periode, Quantite quantiteIndemnisable, ChronologiePeriodes periodesSuspensives)
    throws CoucheLogiqueException
  {
    ObjetChronoPeriode objetChronoPeriode = null;
    int dureePeriodesNonSuspensives = 0;
    ChronologiePeriodes chronologiePeriodesRemplie = null;
    
    chronologiePeriodesRemplie = OutillageCalculADate.boucheLesTrous(periodesSuspensives, ObjetChronoRemplissage.class, periode.getDebut(), periode.getFin());
    
    chronologiePeriodesRemplie.iterer();
    while (chronologiePeriodesRemplie.encoreSuivant())
    {
      objetChronoPeriode = (ObjetChronoPeriode)chronologiePeriodesRemplie.elementSuivant();
      if ((objetChronoPeriode instanceof ObjetChronoRemplissage)) {
        dureePeriodesNonSuspensives += objetChronoPeriode.getDuree();
      }
    }
    BigDecimal dureeSuspensive = new BigDecimal(periode.getDuree() - dureePeriodesNonSuspensives);
    
    return new Quantite(dureeSuspensive.multiply(quantiteIndemnisable.getValeur()).divide(new BigDecimal(periode.getDuree()), 1), quantiteIndemnisable.getUnite());
  }
  
  public static ChronologiePeriodes recupererPeriodesProduits(List listeAttributions, Map mapFacadesCalculProduit)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes periodesProduits = null;
    Iterator iterateur = null;
    AttributionSpec attribution = null;
    Map mapPeriodesProduitsTraites = null;
    
    periodesProduits = new ChronologiePeriodes();
    mapPeriodesProduitsTraites = new HashMap();
    
    iterateur = listeAttributions.iterator();
    while (iterateur.hasNext())
    {
      attribution = (AttributionSpec)iterateur.next();
      
      ChronologiePeriodes periodesProduit = ((FacadeCalculProduitSpec)mapFacadesCalculProduit.get(attribution)).recupererPeriodesProduit(attribution);
      String periodesProduitKey = attribution.getProduit().getNom() + "\n" + periodesProduit.toString() + "\n" + attribution.getRsod();
      if (mapPeriodesProduitsTraites.get(periodesProduitKey) == null)
      {
        periodesProduits.ajouter(periodesProduit);
        mapPeriodesProduitsTraites.put(periodesProduitKey, Boolean.TRUE);
      }
    }
    return periodesProduits;
  }
}

/* Location:
 * Qualified Name:     TraitementPeriodes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */