package fr.unedic.cali.calcul;

import fr.unedic.cali.avant.FacadeAvantProduitSpec;
import fr.unedic.cali.calcul.dom.ArretProduitAvecRaison;
import fr.unedic.cali.calcul.dom.CalendrierExecutionAvant;
import fr.unedic.cali.calcul.dom.ConsommationPeriodes;
import fr.unedic.cali.calcul.dom.DureeConsommableAvant;
import fr.unedic.cali.calcul.dom.EtatAuDernierJourAvant;
import fr.unedic.cali.calcul.dom.QualificationPeriodes;
import fr.unedic.cali.calcul.dom.UniteTraitementAvant;
import fr.unedic.cali.calcul.dom.periode.PeriodeConflitGAEC;
import fr.unedic.cali.calcul.dom.periode.PeriodeExclusionDefinitiveDDTE;
import fr.unedic.cali.calcul.dom.periode.PeriodeFormationNonIndemniseeAbsenceHeure;
import fr.unedic.cali.calcul.dom.temps.ObjetChrono60AnsBlocageRetraite;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeArretCalcul;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalcul;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodesPriseEnCompte;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.Anomalie;
import fr.unedic.cali.outilsfonctionnels.GestionAnomalies;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreChevauchePeriode;
import fr.unedic.util.temps.FiltreDebutDansBornes;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.util.Iterator;
import java.util.ListIterator;

public class TraitementUTAvant
{
  public static int executerUtAvant(AttributionSpec attribution, CalendrierExecutionAvant calendrierAvant, Periode periodeUtAvant, ChronologiePeriodes chronologiePeriodes, FacadeAvantProduitSpec facadeAvantProduit)
    throws CoucheLogiqueException
  {
    facadeAvantProduit.convertionCachets(chronologiePeriodes);
    
    UniteTraitementAvant utAvant = executerAttributionAvant(attribution, calendrierAvant, periodeUtAvant, chronologiePeriodes, facadeAvantProduit);
    
    return postTraitementUtAvant(attribution, calendrierAvant, utAvant, attribution.getDemandeur());
  }
  
  public static UniteTraitementAvant executerAttributionAvant(AttributionSpec attribution, CalendrierExecutionAvant calendrierAvant, Periode periodeUtAvant, ChronologiePeriodes chronologiePeriodes, FacadeAvantProduitSpec facadeAvantProduit)
    throws CoucheLogiqueException
  {
    Damj dateDepartAttribution = facadeAvantProduit.determinerDateDepartAttribution(attribution);
    
    ChronologiePeriodes chronoPeriodesSurUt = new ChronologiePeriodes(new FiltreChevauchePeriode(new Periode(periodeUtAvant.getDebut(), periodeUtAvant.getFin().lendemain())));
    
    chronoPeriodesSurUt.ajouter(chronologiePeriodes);
    
    QualificationPeriodes periodesQualifie = facadeAvantProduit.qualificationPeriodesPourAvant(chronologiePeriodes, attribution);
    
    forcerQualificationPeriodesCalcul(chronoPeriodesSurUt, periodesQualifie);
    
    ChronologiePeriodes periodesInterruptives = periodesQualifie.getPeriodesInterruptivesDefinitives();
    ChronologiePeriodes periodesNouvellesInterruptives = new ChronologiePeriodes();
    periodesInterruptives.iterer();
    while (periodesInterruptives.encoreSuivant())
    {
      ObjetChronoPeriodeCalcul periode = (ObjetChronoPeriodeCalcul)periodesInterruptives.elementSuivant();
      if (periode.getDateDebut().estApresOuCoincideAvec(dateDepartAttribution)) {
        periodesNouvellesInterruptives.ajouter(periode);
      }
    }
    periodesQualifie.setPeriodesInterruptivesDefinitives(periodesNouvellesInterruptives);
    
    return construireUtAvant(attribution, calendrierAvant, periodeUtAvant, periodesQualifie, facadeAvantProduit);
  }
  
  public static int postTraitementUtAvant(AttributionSpec attribution, CalendrierExecutionAvant calendrierAvant, UniteTraitementAvant utAvant, IndividuSpec individu)
    throws CoucheLogiqueException
  {
    int etat = 0;
    
    DureeConsommableAvant dureeActive = utAvant.getDureeConsommableAvantActiveEnFinUt();
    if (dureeActive != null)
    {
      Periode p = utAvant.getConsommationPeriodes().getPeriodesParTypologie(dureeActive.getTypeDureeConsommable());
      if (p != null) {
        if (utAvant.isProduitATerminerApresUT()) {
          p.setFin(utAvant.getArretProduitAvecRaison().recupereLendemainDateArret().veille());
        } else {
          p.setFin(utAvant.getDateFin());
        }
      }
    }
    calendrierAvant.ajouterUniteTraitementAvant(utAvant);
    if ((calendrierAvant.getDebutPeriodePECEvenementReducteurs() == null) && (utAvant.getDebutPeriodePECEvenementReducteurs() != null)) {
      calendrierAvant.setDebutPeriodePECEvenementReducteurs(utAvant.getDebutPeriodePECEvenementReducteurs());
    }
    if (utAvant.isProduitATerminerApresUT())
    {
      Damj dateDJA = Damj.max(utAvant.getArretProduitAvecRaison().recupereLendemainDateArret().veille(), attribution.getDateAttribution().veille());
      calendrierAvant.setDernierJourAvant(dateDJA);
      if ((etat == 0) && (utAvant.getArretProduitAvecRaison().isRaisonsContientRaison(4))) {
        etat = 1;
      }
      ChronologiePeriodes periodesInterruptivesDefinitives = new ChronologiePeriodes();
      periodesInterruptivesDefinitives.ajouter(utAvant.getArretProduitAvecRaison().getPeriodesInterruptivesDefinitives());
      if (!periodesInterruptivesDefinitives.estVide())
      {
        Damj datePeriodeInterruptives = null;
        
        ObjetChronoPeriode premiereChronoPeriode = null;
        
        periodesInterruptivesDefinitives.iterer();
        while (periodesInterruptivesDefinitives.encoreSuivant())
        {
          ObjetChronoPeriode objetChronoPeriode = (ObjetChronoPeriode)periodesInterruptivesDefinitives.elementSuivant();
          
          datePeriodeInterruptives = objetChronoPeriode.getDateDebut();
          if ((datePeriodeInterruptives.estContenueDans(new Periode(calendrierAvant.getDateDebut(), calendrierAvant.getDateFin().lendemain()))) && ((premiereChronoPeriode == null) || (objetChronoPeriode.getDateDebut().estAvant(premiereChronoPeriode.getDateDebut())))) {
            premiereChronoPeriode = objetChronoPeriode;
          }
        }
        if ((premiereChronoPeriode instanceof PeriodeExclusionDefinitiveDDTE))
        {
          etat = 9;
        }
        else if ((premiereChronoPeriode instanceof PeriodeConflitGAEC))
        {
          GestionAnomalies.ajouteAnomalie(new Anomalie("M02", calendrierAvant.getDateFin().lendemain(), ""), individu);
        }
        else if ((premiereChronoPeriode instanceof PeriodeFormationNonIndemniseeAbsenceHeure))
        {
          GestionAnomalies.ajouteAnomalie(new Anomalie("M06", calendrierAvant.getDateFin().lendemain(), ""), individu);
        }
        else if ((premiereChronoPeriode instanceof ObjetChrono60AnsBlocageRetraite))
        {
          ObjetChrono60AnsBlocageRetraite objetChrono60AnsBlocageRetraite = (ObjetChrono60AnsBlocageRetraite)premiereChronoPeriode;
          GestionAnomalies.ajouteAnomalie(new Anomalie("M11", Damj.max(objetChrono60AnsBlocageRetraite.getDateDebut(), attribution.getDateAttribution()), ""), individu);
        }
      }
      mettreAJourPeriodeApplicationDureeConsommableAvant(calendrierAvant);
      if (calendrierAvant.getDebutPeriodePECEvenementReducteurs() != null) {
        calendrierAvant.setEtatAuDernierJourAvant(new EtatAuDernierJourAvant(utAvant, etat, new Periode(calendrierAvant.getDebutPeriodePECEvenementReducteurs(), calendrierAvant.getDernierJourAvant())));
      } else {
        calendrierAvant.setEtatAuDernierJourAvant(new EtatAuDernierJourAvant(utAvant, etat, null));
      }
    }
    return etat;
  }
  
  protected static void mettreAJourPeriodeApplicationDureeConsommableAvant(CalendrierExecutionAvant calendrierExecutionAvant)
  {
    Chronologie uts = calendrierExecutionAvant.getChronologieUnitesTraitements();
    UniteTraitementAvant derniereUtAvant = (UniteTraitementAvant)uts.dernierElement();
    DureeConsommableAvant duree = null;
    Periode periodeConsoPmc = getPeriode(calendrierExecutionAvant, 0);
    Periode periodeConsoPreavisLegal = getPeriode(calendrierExecutionAvant, 4);
    Periode periodeConsoDiffereStandard = getPeriode(calendrierExecutionAvant, 1);
    Periode periodeConsoDiffereSpecifique = getPeriode(calendrierExecutionAvant, 2);
    Periode periodeConsoDelaiAttente = getPeriode(calendrierExecutionAvant, 3);
    
    duree = derniereUtAvant.getDureePmcEnFinUT();
    if (duree != null) {
      duree.setPeriodeApplicationCarence(periodeConsoPmc);
    }
    duree = derniereUtAvant.getDureePreavisLegalEnFinUT();
    if (duree != null) {
      duree.setPeriodeApplicationCarence(periodeConsoPreavisLegal);
    }
    duree = derniereUtAvant.getDureeDiffereStandardEnFinUT();
    if (duree != null) {
      duree.setPeriodeApplicationCarence(periodeConsoDiffereStandard);
    }
    duree = derniereUtAvant.getDureeDiffereSpecifiqueEnFinUT();
    if (duree != null) {
      duree.setPeriodeApplicationCarence(periodeConsoDiffereSpecifique);
    }
    duree = derniereUtAvant.getDureeDelaiAttenteEnFinUT();
    if (duree != null) {
      duree.setPeriodeApplicationCarence(periodeConsoDelaiAttente);
    }
  }
  
  private static Periode getPeriode(CalendrierExecutionAvant calendrierExecutionAvant, int typeDureeConsommableAvant)
  {
    Chronologie uts = calendrierExecutionAvant.getChronologieUnitesTraitements();
    ConsommationPeriodes periodes = null;
    Periode periodeConsommationTotale = null;
    Periode periodeConsommationMensuelle = null;
    
    uts.iterer();
    while (uts.encoreSuivant())
    {
      UniteTraitementAvant utAvant = (UniteTraitementAvant)uts.elementSuivant();
      periodes = utAvant.getConsommationPeriodes();
      periodeConsommationMensuelle = periodes.getPeriodesParTypologie(typeDureeConsommableAvant);
      if (periodeConsommationMensuelle != null) {
        if (periodeConsommationTotale == null) {
          periodeConsommationTotale = (Periode)periodeConsommationMensuelle.copie();
        } else {
          periodeConsommationTotale.setFin(periodeConsommationMensuelle.getFin());
        }
      }
    }
    return periodeConsommationTotale;
  }
  
  public static UniteTraitementAvant construireUtAvant(AttributionSpec attribution, CalendrierExecutionAvant calendrierAvant, Periode pperiodeUtAvant, QualificationPeriodes periodesQualifie, FacadeAvantProduitSpec facadeAvantProduit)
    throws CoucheLogiqueException
  {
    UniteTraitementAvant utAvant = null;
    ChronologiePeriodes periodesAnalyses = null;
    PeriodesPriseEnCompte periodesPriseEnCompte = null;
    
    Periode periodeUtAvant = (Periode)pperiodeUtAvant.copie();
    
    utAvant = new UniteTraitementAvant(Unite.get("jour"), periodeUtAvant);
    
    utAvant.setQualificationPeriodes(periodesQualifie);
    
    utAvant.setConsommationPeriodes(new ConsommationPeriodes());
    
    periodesPriseEnCompte = new PeriodesPriseEnCompte(pperiodeUtAvant);
    if (calendrierAvant.getEtatExecutionAvant() == 1)
    {
      periodesPriseEnCompte.tronquePeriodesPriseEnCompteEnDebut(calendrierAvant.getPremierJourAvant());
      
      calendrierAvant.setEtatExecutionAvant(2);
    }
    initialiserDureesConsommablesAvant(calendrierAvant, utAvant, attribution, facadeAvantProduit);
    
    ArretProduitAvecRaison arretProduitAvecRaison = effectuerTraitementPeriodes(utAvant, periodesPriseEnCompte, attribution, calendrierAvant, facadeAvantProduit);
    
    DureeConsommableAvant dureeActive = utAvant.getDureeConsommableAvantActiveEnDebutUt();
    if ((dureeActive != null) && (dureeActive.getQuantiteInitial().getValeurEntiere() > 0))
    {
      Periode p = utAvant.getConsommationPeriodes().getPeriodesParTypologie(dureeActive.getTypeDureeConsommable());
      if (p == null)
      {
        p = new Periode(utAvant.getDateDebut());
        utAvant.getConsommationPeriodes().setPeriodesParTypologie(dureeActive.getTypeDureeConsommable(), p);
      }
    }
    periodesAnalyses = creerLesPeriodesAnalyses(utAvant, utAvant.getQualificationPeriodes(), periodesPriseEnCompte, facadeAvantProduit);
    
    TraitementPeriodesAnalyseAvant.traitementDesPeriodesAnalyses(attribution, utAvant, periodesAnalyses, utAvant.getQualificationPeriodes(), arretProduitAvecRaison);
    if (arretProduitAvecRaison.isProduitAArreter())
    {
      utAvant.setProduitATerminerApresUT(true);
      utAvant.setArretProduitAvecRaison(arretProduitAvecRaison);
      calendrierAvant.setEtatExecutionAvant(3);
    }
    return utAvant;
  }
  
  protected static void forcerQualificationPeriodesCalcul(ChronologiePeriodes periodes, QualificationPeriodes qualificationPeriodes)
  {
    ObjetChronoPeriodeCalcul periode = null;
    ListIterator iterator = null;
    iterator = periodes.iterer();
    while (iterator.hasNext())
    {
      periode = (ObjetChronoPeriodeCalcul)iterator.next();
      if ((periode instanceof ObjetChronoPeriodeArretCalcul)) {
        qualificationPeriodes.ajouterPeriodesInterruptivesDefinitives(periode);
      }
    }
  }
  
  public static void initialiserDureesConsommablesAvant(CalendrierExecutionAvant calendrierAvant, UniteTraitementAvant putAvant, AttributionSpec attribution, FacadeAvantProduitSpec facadeAvantProduit)
  {
    if (calendrierAvant.getChronologieUnitesTraitements() != null)
    {
      UniteTraitementAvant utAvant = null;
      Iterator listeUt = calendrierAvant.getChronologieUnitesTraitements().iterer();
      while (listeUt.hasNext()) {
        utAvant = (UniteTraitementAvant)listeUt.next();
      }
      if (utAvant != null)
      {
        if (utAvant.getDureePmcEnFinUT() != null)
        {
          DureeConsommableAvant dureePmc = (DureeConsommableAvant)utAvant.getDureePmcEnFinUT().copie();
          putAvant.setDureePmcEnDebutUT(dureePmc);
        }
        if (utAvant.getDureePreavisLegalEnFinUT() != null)
        {
          DureeConsommableAvant dureePreavisLegal = (DureeConsommableAvant)utAvant.getDureePreavisLegalEnFinUT().copie();
          putAvant.setDureePreavisLegalEnDebutUT(dureePreavisLegal);
        }
        if (utAvant.getDureeDiffereStandardEnFinUT() != null)
        {
          DureeConsommableAvant dureeDiffereStandard = (DureeConsommableAvant)utAvant.getDureeDiffereStandardEnFinUT().copie();
          putAvant.setDureeDiffereStandardEnDebutUT(dureeDiffereStandard);
        }
        if (utAvant.getDureeDiffereSpecifiqueEnFinUT() != null)
        {
          DureeConsommableAvant dureeDiffereSpecifique = (DureeConsommableAvant)utAvant.getDureeDiffereSpecifiqueEnFinUT().copie();
          putAvant.setDureeDiffereSpecifiqueEnDebutUT(dureeDiffereSpecifique);
        }
        if (utAvant.getDureeDelaiAttenteEnFinUT() != null)
        {
          DureeConsommableAvant dureeDelaiAttente = (DureeConsommableAvant)utAvant.getDureeDelaiAttenteEnFinUT().copie();
          putAvant.setDureeDelaiAttenteEnDebutUT(dureeDelaiAttente);
        }
        return;
      }
    }
    facadeAvantProduit.creerDureeIndemnisation(attribution, calendrierAvant, putAvant);
  }
  
  private static ArretProduitAvecRaison effectuerTraitementPeriodes(UniteTraitementAvant utAvant, PeriodesPriseEnCompte periodesPriseEnCompte, AttributionSpec attribution, CalendrierExecutionAvant calendrierAvant, FacadeAvantProduitSpec facadeAvantProduit)
    throws CoucheLogiqueException
  {
    QualificationPeriodes qualificationPeriodes = utAvant.getQualificationPeriodes();
    
    filtrerPeriodesPourUneTypologie(1, qualificationPeriodes, periodesPriseEnCompte);
    
    ArretProduitAvecRaison arretProduitAvecRaison = facadeAvantProduit.traitementPeriodesInterruptivesDefinitives(periodesPriseEnCompte, utAvant, attribution, calendrierAvant);
    
    return arretProduitAvecRaison;
  }
  
  private static void filtrerPeriodesPourUneTypologie(int periodeType, QualificationPeriodes qualificationPeriodes, PeriodesPriseEnCompte periodesPriseEnCompte)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologie = new ChronologiePeriodes();
    
    Iterator it = periodesPriseEnCompte.getPeriodesParTypologie(periodeType).iterer();
    while (it.hasNext())
    {
      ObjetChronoPeriode objetChronoPeriode = (ObjetChronoPeriode)it.next();
      Periode periode = new Periode(objetChronoPeriode.getDateDebut(), objetChronoPeriode.getDateFin());
      ChronologiePeriodes chronoAAjouter = (ChronologiePeriodes)qualificationPeriodes.getPeriodesParTypologie(periodeType).copier(new FiltreChevauchePeriode(periode));
      
      Iterator itChronoAAjouter = chronoAAjouter.iterer();
      while (itChronoAAjouter.hasNext())
      {
        Temporel temporel = (Temporel)itChronoAAjouter.next();
        if (!chronologie.contientElement(temporel)) {
          chronologie.ajouter(temporel);
        }
      }
    }
    qualificationPeriodes.setPeriodesParTypologie(periodeType, chronologie);
  }
  
  private static ChronologiePeriodes creerLesPeriodesAnalyses(UniteTraitementAvant utAvant, QualificationPeriodes qualificationPeriodes, PeriodesPriseEnCompte periodesPriseEnCompte, FacadeAvantProduitSpec facadeAvantProduit)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes periodesAnalyses = null;
    if (periodesAnalyses == null)
    {
      Iterator iterator = null;
      ChronologiePeriodes chronologie = null;
      ObjetChronoPeriode objetChronoPeriode = null;
      Periode periode = null;
      
      iterator = periodesPriseEnCompte.getPeriodesParTypologie(3).iterer();
      chronologie = new ChronologiePeriodes();
      while (iterator.hasNext())
      {
        objetChronoPeriode = (ObjetChronoPeriode)iterator.next();
        periode = new Periode(objetChronoPeriode.getDateDebut(), objetChronoPeriode.getDateFin());
        chronologie.ajouter((ChronologiePeriodes)qualificationPeriodes.getPeriodesSegmentantes().copier(new FiltreDebutDansBornes(periode)));
      }
      iterator = periodesPriseEnCompte.getPeriodesParTypologie(3).iterer();
      ChronologiePeriodes chronologiePeriodesAnalyses = new ChronologiePeriodes();
      while (iterator.hasNext())
      {
        objetChronoPeriode = (ObjetChronoPeriode)iterator.next();
        periode = new Periode(objetChronoPeriode.getDateDebut(), objetChronoPeriode.getDateFin());
        if (periode.getFin().estApresOuCoincideAvec(periode.getDebut())) {
          chronologiePeriodesAnalyses.ajouter(facadeAvantProduit.traitementPeriodesSegmentantes(periode, utAvant, chronologie));
        }
      }
      periodesAnalyses = chronologiePeriodesAnalyses;
    }
    return periodesAnalyses;
  }
}

/* Location:
 * Qualified Name:     TraitementUTAvant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */