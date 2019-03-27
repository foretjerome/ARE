package fr.unedic.cali.calcul;

import fr.unedic.cali.avant.FacadeAvantProduitFactory;
import fr.unedic.cali.avant.FacadeAvantProduitSpec;
import fr.unedic.cali.calcul.dom.ArretProduitAvecRaison;
import fr.unedic.cali.calcul.dom.ConsommationPeriodes;
import fr.unedic.cali.calcul.dom.DureeConsommableAvant;
import fr.unedic.cali.calcul.dom.QualificationPeriodes;
import fr.unedic.cali.calcul.dom.UniteTraitementAvant;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoRemplissage;
import fr.unedic.cali.calcul.outilsfonctionnels.DecoupageProratisation;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAnalyseSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.outilsfonctionnels.OutilDemande;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteJour;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.FiltreChevauchePeriode;
import fr.unedic.util.temps.FiltreDebutDansBornes;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class TraitementPeriodesAnalyseAvant
{
  public static void traitementDesPeriodesAnalyses(AttributionSpec attribution, UniteTraitementAvant utAvant, ChronologiePeriodes periodesAnalyse, QualificationPeriodes qualificationPeriodes, ArretProduitAvecRaison arretProduitAvecRaison)
    throws CoucheLogiqueException
  {
    Quantite quantiteAImputerSurLaPA = null;
    PeriodeAnalyseSpec pa = null;
    Quantite nombreDeJourDecalageAr = null;
    
    FacadeAvantProduitSpec facadeAvant = FacadeAvantProduitFactory.getInstance().getInstanceFacadeAvantProduit(attribution.getProduitExecution());
    DureeConsommableAvant dureePmc = null;
    DureeConsommableAvant dureePreavisLegal = null;
    DureeConsommableAvant dureeDiffereStandard = null;
    DureeConsommableAvant dureeDiffereSpecifique = null;
    DureeConsommableAvant dureeDelaiAttente = null;
    List<DureeConsommableAvant> listeDureeConsoAvantRestante = new ArrayList();
    if (utAvant.getDureePmcEnDebutUT() != null)
    {
      dureePmc = (DureeConsommableAvant)utAvant.getDureePmcEnDebutUT().copie();
      listeDureeConsoAvantRestante.add(dureePmc);
    }
    if (utAvant.getDureePreavisLegalEnDebutUT() != null)
    {
      dureePreavisLegal = (DureeConsommableAvant)utAvant.getDureePreavisLegalEnDebutUT().copie();
      listeDureeConsoAvantRestante.add(dureePreavisLegal);
    }
    if (utAvant.getDureeDiffereStandardEnDebutUT() != null)
    {
      dureeDiffereStandard = (DureeConsommableAvant)utAvant.getDureeDiffereStandardEnDebutUT().copie();
      listeDureeConsoAvantRestante.add(dureeDiffereStandard);
    }
    if (utAvant.getDureeDiffereSpecifiqueEnDebutUT() != null)
    {
      dureeDiffereSpecifique = (DureeConsommableAvant)utAvant.getDureeDiffereSpecifiqueEnDebutUT().copie();
      listeDureeConsoAvantRestante.add(dureeDiffereSpecifique);
    }
    if (utAvant.getDureeDelaiAttenteEnDebutUT() != null)
    {
      dureeDelaiAttente = (DureeConsommableAvant)utAvant.getDureeDelaiAttenteEnDebutUT().copie();
      listeDureeConsoAvantRestante.add(dureeDelaiAttente);
    }
    Iterator ite = periodesAnalyse.iterer();
    while (ite.hasNext())
    {
      Quantite quantiteRestanteSurLaPa = null;
      pa = (PeriodeAnalyseSpec)ite.next();
      pa.setQuantiteIndemnisable(new QuantiteJour(new BigDecimal(pa.getDuree())));
      quantiteAImputerSurLaPA = pa.getQuantiteIndemnisable().soustraire(pa.getQuantiteNonIndemnisee());
      quantiteRestanteSurLaPa = new Quantite(quantiteAImputerSurLaPA.getValeur(), quantiteAImputerSurLaPA.getUnite());
      
      quantiteRestanteSurLaPa = gestionPMC(utAvant, quantiteAImputerSurLaPA, dureePmc, pa, quantiteRestanteSurLaPa, facadeAvant, arretProduitAvecRaison, attribution.getDateAttribution(), verifierQteInitialeCarenceRestante(listeDureeConsoAvantRestante, dureePmc));
      
      quantiteRestanteSurLaPa = gestionPreavisLegal(utAvant, quantiteAImputerSurLaPA, dureePreavisLegal, pa, quantiteRestanteSurLaPa, facadeAvant, arretProduitAvecRaison, attribution.getDateAttribution(), verifierQteInitialeCarenceRestante(listeDureeConsoAvantRestante, dureePreavisLegal));
      
      quantiteRestanteSurLaPa = gestionDiffereStd(utAvant, quantiteAImputerSurLaPA, dureeDiffereStandard, pa, quantiteRestanteSurLaPa, attribution, facadeAvant, qualificationPeriodes, arretProduitAvecRaison, attribution.getDateAttribution(), verifierQteInitialeCarenceRestante(listeDureeConsoAvantRestante, dureeDiffereStandard));
      
      quantiteRestanteSurLaPa = gestionDiffereSpecifique(utAvant, quantiteAImputerSurLaPA, dureeDiffereSpecifique, pa, quantiteRestanteSurLaPa, facadeAvant, arretProduitAvecRaison, attribution.getDateAttribution(), verifierQteInitialeCarenceRestante(listeDureeConsoAvantRestante, dureeDiffereSpecifique));
      
      nombreDeJourDecalageAr = gestionDelaiAttente(utAvant, quantiteAImputerSurLaPA, dureeDelaiAttente, pa, quantiteRestanteSurLaPa, attribution, qualificationPeriodes, arretProduitAvecRaison, facadeAvant, attribution.getDateAttribution(), periodesAnalyse, nombreDeJourDecalageAr);
      
      postTraitementPa(utAvant, pa);
    }
    if (pa != null) {
      traitementPeriodesAlertantes(attribution, utAvant, qualificationPeriodes, arretProduitAvecRaison, pa);
    }
    utAvant.setDureePmcEnFinUT(dureePmc);
    utAvant.setDureePreavisLegalEnFinUT(dureePreavisLegal);
    utAvant.setDureeDiffereStandardEnFinUT(dureeDiffereStandard);
    utAvant.setDureeDiffereSpecifiqueEnFinUT(dureeDiffereSpecifique);
    utAvant.setDureeDelaiAttenteEnFinUT(dureeDelaiAttente);
    
    utAvant.setPmcConsomme(pmcConsomme(utAvant));
    if (utAvant.getDureePreavisLegalEnFinUT() != null) {
      utAvant.setPreavisLegalConsomme(preavisLegalConsomme(utAvant));
    }
    utAvant.setDiffereStandardConsomme(differeStandardConsomme(utAvant));
    utAvant.setDiffereSpecifiqueConsomme(differeSpecifiqueConsomme(utAvant));
    utAvant.setDelaiAttenteConsomme(delaiAttenteConsomme(utAvant));
  }
  
  private static boolean verificationDureeAConsommeNonEpuise(DureeConsommableAvant dureeAvant, Quantite quantiteRestante)
  {
    return (quantiteRestante.getValeur().compareTo(BigDecimal.valueOf(0L)) > 0) && (dureeAvant.getEtat() != 2);
  }
  
  private static boolean doitTraiterDA(UniteTraitementAvant utAvant, QualificationPeriodes qualificationPeriodes, DureeConsommableAvant dureeDelaiAttente, PeriodeAnalyseSpec pa, Damj dateDebutConsommationSurPa, FacadeAvantProduitSpec facadeAvant)
    throws CoucheLogiqueException
  {
    return (!facadeAvant.traitementPeriodesSuspensivesPourDebutConsommationDelaiAttente(pa, qualificationPeriodes, utAvant.getConsommationPeriodes().getPeriodeDelaiAttente() == null ? dateDebutConsommationSurPa : utAvant.getConsommationPeriodes().getPeriodeDelaiAttente().getDebut())) || (verificationQuantiteDA(dureeDelaiAttente));
  }
  
  private static Quantite gestionDiffereSpecifique(UniteTraitementAvant utAvant, Quantite quantiteAImputerSurLaPA, DureeConsommableAvant dureeDiffereSpecifique, PeriodeAnalyseSpec pa, Quantite quantiteRestante, FacadeAvantProduitSpec facadeAvant, ArretProduitAvecRaison arretProduitAvecRaison, Damj dateAttribution, boolean derniereCarenceActive)
    throws CoucheLogiqueException
  {
    Quantite quantiteRestanteTmp = quantiteRestante;
    if ((facadeAvant.estUnCarenceGereeParLeProduit(dureeDiffereSpecifique)) && (verificationDureeAConsommeNonEpuise(dureeDiffereSpecifique, quantiteRestanteTmp)))
    {
      DureeCalendaire d = new DureeCalendaire(0, 0, quantiteAImputerSurLaPA.soustraire(quantiteRestanteTmp).getValeurEntiere());
      Damj dateDebutConsommationSurPa = pa.getDateDebut().deplacerVersAvant(d);
      if (dureeDiffereSpecifique.getEtat() != 1)
      {
        dureeDiffereSpecifique.activer();
        if (dureeDiffereSpecifique.getQuantiteInitial().getValeurEntiere() > 0)
        {
          Periode p = new Periode(dateDebutConsommationSurPa);
          utAvant.getConsommationPeriodes().setPeriodeDiffereSpecifique(p);
        }
      }
      quantiteRestanteTmp = simulerImputerTerminerProduit(utAvant, quantiteAImputerSurLaPA, dureeDiffereSpecifique, pa, quantiteRestanteTmp, arretProduitAvecRaison, facadeAvant, dateDebutConsommationSurPa, dateAttribution, derniereCarenceActive);
    }
    return quantiteRestanteTmp;
  }
  
  private static Quantite gestionPMC(UniteTraitementAvant utAvant, Quantite quantiteAImputerSurLaPA, DureeConsommableAvant dureePMC, PeriodeAnalyseSpec pa, Quantite quantiteRestante, FacadeAvantProduitSpec facadeAvant, ArretProduitAvecRaison arretProduitAvecRaison, Damj dateAttribution, boolean derniereCarenceActive)
    throws CoucheLogiqueException
  {
    Quantite quantiteRestanteTmp = quantiteRestante;
    if ((dureePMC != null) && (verificationDureeAConsommeNonEpuise(dureePMC, quantiteRestanteTmp)) && (facadeAvant.estUnCarenceGereeParLeProduit(dureePMC)))
    {
      DureeCalendaire d = new DureeCalendaire(0, 0, quantiteAImputerSurLaPA.soustraire(quantiteRestanteTmp).getValeurEntiere());
      Damj dateDebutConsommationSurPa = pa.getDateDebut().deplacerVersAvant(d);
      if (dureePMC.getEtat() != 1)
      {
        dureePMC.activer();
        if (dureePMC.getQuantiteInitial().getValeurEntiere() > 0)
        {
          Periode p = new Periode(dateDebutConsommationSurPa);
          utAvant.getConsommationPeriodes().setPeriodePmc(p);
        }
      }
      quantiteRestanteTmp = simulerImputerTerminerProduit(utAvant, quantiteAImputerSurLaPA, dureePMC, pa, quantiteRestanteTmp, arretProduitAvecRaison, facadeAvant, dateDebutConsommationSurPa, dateAttribution, derniereCarenceActive);
    }
    return quantiteRestanteTmp;
  }
  
  private static Quantite gestionPreavisLegal(UniteTraitementAvant utAvant, Quantite quantiteAImputerSurLaPA, DureeConsommableAvant dureePreavisLegal, PeriodeAnalyseSpec pa, Quantite quantiteRestante, FacadeAvantProduitSpec facadeAvant, ArretProduitAvecRaison arretProduitAvecRaison, Damj dateAttribution, boolean derniereCarenceActive)
    throws CoucheLogiqueException
  {
    Quantite quantiteRestanteTmp = quantiteRestante;
    if ((dureePreavisLegal != null) && (verificationDureeAConsommeNonEpuise(dureePreavisLegal, quantiteRestanteTmp)) && (facadeAvant.estUnCarenceGereeParLeProduit(dureePreavisLegal)))
    {
      DureeCalendaire d = new DureeCalendaire(0, 0, quantiteAImputerSurLaPA.soustraire(quantiteRestanteTmp).getValeurEntiere());
      Damj dateDebutConsommationSurPa = pa.getDateDebut().deplacerVersAvant(d);
      if (dureePreavisLegal.getEtat() != 1)
      {
        dureePreavisLegal.activer();
        if (dureePreavisLegal.getQuantiteInitial().getValeurEntiere() > 0)
        {
          Periode p = new Periode(dateDebutConsommationSurPa);
          utAvant.getConsommationPeriodes().setPeriodePreavisLegal(p);
        }
      }
      quantiteRestanteTmp = simulerImputerTerminerProduit(utAvant, quantiteAImputerSurLaPA, dureePreavisLegal, pa, quantiteRestanteTmp, arretProduitAvecRaison, facadeAvant, dateDebutConsommationSurPa, dateAttribution, derniereCarenceActive);
    }
    return quantiteRestanteTmp;
  }
  
  private static Quantite gestionDiffereStd(UniteTraitementAvant utAvant, Quantite quantiteAImputerSurLaPA, DureeConsommableAvant dureeDiffereStd, PeriodeAnalyseSpec pa, Quantite quantiteRestante, AttributionSpec attribution, FacadeAvantProduitSpec facadeAvant, QualificationPeriodes qualificationPeriodes, ArretProduitAvecRaison arretProduitAvecRaison, Damj dateAttribution, boolean derniereCarenceActive)
    throws CoucheLogiqueException
  {
    Quantite quantiteRestanteTmp = quantiteRestante;
    
    DureeCalendaire d = new DureeCalendaire(0, 0, quantiteAImputerSurLaPA.soustraire(quantiteRestanteTmp).getValeurEntiere());
    Damj dateDebutConsommationSurPa = pa.getDateDebut().deplacerVersAvant(d);
    if ((dureeDiffereStd != null) && (facadeAvant.estUnCarenceGereeParLeProduit(dureeDiffereStd)) && (verificationDureeAConsommeNonEpuise(dureeDiffereStd, quantiteRestanteTmp)))
    {
      if ((facadeAvant.estUneCarenceSeConsommantApresDateAttribution(dureeDiffereStd)) && (dateDebutConsommationSurPa.estAvant(attribution.getDateAttribution())) && (dureeDiffereStd.getQuantiteInitial().getValeur().compareTo(BigDecimal.ZERO) > 0)) {
        if (attribution.getDateAttribution().estContenueDans(pa.getPeriode()))
        {
          quantiteRestanteTmp = quantiteRestanteTmp.soustraire(new QuantiteJour(BigDecimal.valueOf(attribution.getDateAttribution().joursEntre(dateDebutConsommationSurPa))));
          dateDebutConsommationSurPa = attribution.getDateAttribution();
        }
        else
        {
          quantiteRestanteTmp = new QuantiteJour(BigDecimal.ZERO);
        }
      }
      if (quantiteRestanteTmp.getValeur().compareTo(BigDecimal.ZERO) > 0)
      {
        d = new DureeCalendaire(0, 0, quantiteAImputerSurLaPA.soustraire(quantiteRestanteTmp).getValeurEntiere());
        dateDebutConsommationSurPa = pa.getDateDebut().deplacerVersAvant(d);
        if (dureeDiffereStd.getEtat() != 1)
        {
          dureeDiffereStd.activer();
          if (dureeDiffereStd.getQuantiteInitial().getValeurEntiere() > 0)
          {
            Periode p = new Periode(dateDebutConsommationSurPa);
            utAvant.getConsommationPeriodes().setPeriodeDiffereStandard(p);
          }
        }
        if ((facadeAvant.estUneCarenceSuspendueParSuspensif(dureeDiffereStd)) && (traitementPeriodesSuspensives(pa, qualificationPeriodes)) && (dureeDiffereStd.getQuantiteCourante().getValeur().compareTo(BigDecimal.ZERO) > 0)) {
          quantiteRestanteTmp = new QuantiteJour(BigDecimal.ZERO);
        } else {
          quantiteRestanteTmp = simulerImputerTerminerProduit(utAvant, quantiteAImputerSurLaPA, dureeDiffereStd, pa, quantiteRestanteTmp, arretProduitAvecRaison, facadeAvant, dateDebutConsommationSurPa, dateAttribution, derniereCarenceActive);
        }
      }
    }
    return quantiteRestanteTmp;
  }
  
  private static Quantite gestionDelaiAttente(UniteTraitementAvant utAvant, Quantite quantiteAImputerSurLaPA, DureeConsommableAvant dureeDelaiAttente, PeriodeAnalyseSpec pa, Quantite quantiteRestante, AttributionSpec attribution, QualificationPeriodes qualificationPeriodes, ArretProduitAvecRaison arretProduitAvecRaison, FacadeAvantProduitSpec facadeAvant, Damj dateAttribution, ChronologiePeriodes periodesAnalyse, Quantite nombreDeJourDecalageAr)
    throws CoucheLogiqueException
  {
    Quantite quantiteRestanteTmp = quantiteRestante;
    
    DureeCalendaire d = new DureeCalendaire(0, 0, quantiteAImputerSurLaPA.soustraire(quantiteRestanteTmp).getValeurEntiere());
    Damj dateDebutConsommationSurPa = pa.getDateDebut().deplacerVersAvant(d);
    if ((dureeDelaiAttente != null) && (facadeAvant.estUnCarenceGereeParLeProduit(dureeDelaiAttente)) && (verificationDureeAConsommeNonEpuise(dureeDelaiAttente, quantiteRestanteTmp)))
    {
      if ((!OutilDemande.estUneDemandeFinancement(attribution.getDemande())) && (dateDebutConsommationSurPa.estAvant(attribution.getDateAttribution())) && (dureeDelaiAttente.getQuantiteInitial().getValeur().compareTo(BigDecimal.ZERO) > 0)) {
        if (attribution.getDateAttribution().estContenueDans(pa.getPeriode()))
        {
          quantiteRestanteTmp = quantiteRestanteTmp.soustraire(new QuantiteJour(BigDecimal.valueOf(attribution.getDateAttribution().joursEntre(dateDebutConsommationSurPa))));
          dateDebutConsommationSurPa = attribution.getDateAttribution();
        }
        else
        {
          quantiteRestanteTmp = new QuantiteJour(BigDecimal.ZERO);
        }
      }
      if (facadeAvant.doitTraiterLAR())
      {
        Periode periodePa = new Periode(dateDebutConsommationSurPa, pa.getDateFin());
        if (!utAvant.isTraitementArEffectue()) {
          nombreDeJourDecalageAr = facadeAvant.traitementActiviteReduiteSurUt(utAvant, periodesAnalyse, dateDebutConsommationSurPa, attribution, qualificationPeriodes, dureeDelaiAttente);
        }
        Quantite quantiteDecale = getDureeDecalageLieASuspention(periodePa, qualificationPeriodes, quantiteRestanteTmp, nombreDeJourDecalageAr);
        pa.setQuantiteDecalee(quantiteDecale);
        nombreDeJourDecalageAr = nombreDeJourDecalageAr.soustraire(quantiteDecale).max(new QuantiteJour(BigDecimal.ZERO));
        if (quantiteRestanteTmp.getValeurEntiere() > nombreDeJourDecalageAr.getValeurEntiere())
        {
          ChronologiePeriodes chronologieRemplissage = OutillageCalculADate.retourneLesTrous((ChronologiePeriodes)qualificationPeriodes.getPeriodesSuspensives().copier(new FiltreChevauchePeriode(periodePa)), ObjetChronoRemplissage.class, periodePa.getDebut(), periodePa.getFin());
          if ((utAvant.getQuantiteDecale() != null) && (utAvant.getQuantiteDecale().getValeur() != null) && (utAvant.getQuantiteDecale().getValeur().compareTo(BigDecimal.ZERO) > 0) && (!chronologieRemplissage.estVide()) && (pa.getQuantiteDecalee() != null) && (pa.getQuantiteDecalee().getValeurEntiere() != 0))
          {
            dateDebutConsommationSurPa = OutillageCalculADate.remplirTrousChronologieParDecalageEtRetourneDate(chronologieRemplissage, pa.getQuantiteDecalee(), periodePa).lendemain();
            if (dateDebutConsommationSurPa.estAvantOuCoincideAvec(periodePa.getFin())) {
              chronologieRemplissage = OutillageCalculADate.retourneLesTrous((ChronologiePeriodes)qualificationPeriodes.getPeriodesSuspensives().copier(new FiltreChevauchePeriode(new Periode(dateDebutConsommationSurPa, periodePa.getFin()))), ObjetChronoRemplissage.class, dateDebutConsommationSurPa, periodePa.getFin());
            } else {
              chronologieRemplissage.vider();
            }
          }
          if (dureeDelaiAttente.getEtat() == 0) {
            dateDebutConsommationSurPa = chronologieRemplissage.estVide() ? periodePa.getFin().lendemain() : chronologieRemplissage.premierElement().getDateDebut();
          } else if (dureeDelaiAttente.getEtat() == 1) {
            dateDebutConsommationSurPa = periodePa.getDebut();
          }
          int nbJourEntreDateEffectiveEtDateTheorique = dateDebutConsommationSurPa.joursEntre(periodePa.getDebut());
          quantiteRestanteTmp = quantiteRestanteTmp.soustraire(new QuantiteJour(new BigDecimal(nbJourEntreDateEffectiveEtDateTheorique)));
          if ((quantiteRestanteTmp.getValeur().compareTo(BigDecimal.ZERO) > 0) && (doitTraiterDA(utAvant, qualificationPeriodes, dureeDelaiAttente, pa, dateDebutConsommationSurPa, facadeAvant)))
          {
            d = new DureeCalendaire(0, 0, quantiteAImputerSurLaPA.soustraire(quantiteRestanteTmp).getValeurEntiere());
            dateDebutConsommationSurPa = pa.getDateDebut().deplacerVersAvant(d);
            if (dureeDelaiAttente.getEtat() != 1)
            {
              dureeDelaiAttente.activer();
              if (dureeDelaiAttente.getQuantiteInitial().getValeurEntiere() > 0)
              {
                Periode p = new Periode(dateDebutConsommationSurPa);
                utAvant.getConsommationPeriodes().setPeriodeDelaiAttente(p);
              }
            }
            simulerImputerTerminerProduit(utAvant, quantiteAImputerSurLaPA, dureeDelaiAttente, pa, quantiteRestanteTmp, arretProduitAvecRaison, facadeAvant, dateDebutConsommationSurPa, dateAttribution, false);
          }
        }
      }
      else if ((quantiteRestanteTmp.getValeur().compareTo(BigDecimal.ZERO) > 0) && (doitTraiterDA(utAvant, qualificationPeriodes, dureeDelaiAttente, pa, dateDebutConsommationSurPa, facadeAvant)))
      {
        d = new DureeCalendaire(0, 0, quantiteAImputerSurLaPA.soustraire(quantiteRestanteTmp).getValeurEntiere());
        dateDebutConsommationSurPa = pa.getDateDebut().deplacerVersAvant(d);
        if (dureeDelaiAttente.getEtat() != 1)
        {
          dureeDelaiAttente.activer();
          if (dureeDelaiAttente.getQuantiteInitial().getValeurEntiere() > 0)
          {
            Periode p = new Periode(dateDebutConsommationSurPa);
            utAvant.getConsommationPeriodes().setPeriodeDelaiAttente(p);
          }
        }
        simulerImputerTerminerProduit(utAvant, quantiteAImputerSurLaPA, dureeDelaiAttente, pa, quantiteRestanteTmp, arretProduitAvecRaison, facadeAvant, dateDebutConsommationSurPa, dateAttribution, false);
      }
    }
    return nombreDeJourDecalageAr;
  }
  
  public static Quantite getDureeDecalageLieASuspention(Periode periodePa, QualificationPeriodes qualificationPeriodes, Quantite quantiteRestante, Quantite nombreDeJourDecalageAr)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronoSusp = DecoupageProratisation.decoupageEtProratisationPeriodesActivites(periodePa, (ChronologiePeriodes)qualificationPeriodes.getPeriodesSuspensives().copier(new FiltreChevauchePeriode(periodePa)));
    
    Quantite quantiteSuspensive = TraitementPeriodes.getQuantiteSuspensive(periodePa, new QuantiteJour(new BigDecimal(periodePa.getDuree())), chronoSusp);
    
    Quantite quantiteRestanteAvecSuspensif = quantiteRestante.soustraire(quantiteSuspensive);
    return quantiteRestanteAvecSuspensif.min(nombreDeJourDecalageAr).max(new QuantiteJour(BigDecimal.ZERO));
  }
  
  private static Quantite simulerImputerTerminerProduit(UniteTraitementAvant utAvant, Quantite quantiteAImputerSurLaPA, DureeConsommableAvant dureeAvant, PeriodeAnalyseSpec pa, Quantite quantiteRestante, ArretProduitAvecRaison arretProduitAvecRaison, FacadeAvantProduitSpec facadeAvant, Damj dateDebutConsommationSurPa, Damj dateAttribution, boolean contientEncoreUneCarenceActive)
    throws CoucheLogiqueException
  {
    Quantite quantiteRestanteTmp = quantiteRestante;
    if ((facadeAvant.estCarenceTerminantProduit(dureeAvant)) || (!contientEncoreUneCarenceActive)) {
      quantiteRestanteTmp = TraitementDureeConsommableAvant.simulerImputationEtImputerLaQuantiteEtTerminerProduit(quantiteRestante, pa, dureeAvant, utAvant, dateDebutConsommationSurPa, arretProduitAvecRaison, dateAttribution, facadeAvant);
    } else {
      quantiteRestanteTmp = TraitementDureeConsommableAvant.simulerImputationEtImputerLaQuantite(quantiteRestanteTmp, null, dureeAvant, utAvant, dateDebutConsommationSurPa, null);
    }
    return quantiteRestanteTmp;
  }
  
  private static boolean verificationQuantiteDA(DureeConsommableAvant dureeDelaiAttente)
  {
    return (dureeDelaiAttente != null) && (dureeDelaiAttente.getQuantiteInitial() != null) && (dureeDelaiAttente.getQuantiteCourante() != null) && (dureeDelaiAttente.getQuantiteInitial().getValeurEntiere() != dureeDelaiAttente.getQuantiteCourante().getValeurEntiere());
  }
  
  private static void postTraitementPa(UniteTraitementAvant utAvant, PeriodeAnalyseSpec pa)
    throws CoucheLogiqueException
  {
    if (pa.isProduitATerminerApresPA()) {
      utAvant.setProduitATerminerApresUT(pa.isProduitATerminerApresPA());
    }
  }
  
  private static Quantite pmcConsomme(UniteTraitementAvant utAvant)
  {
    Quantite pmcConsomme;
    Quantite pmcConsomme;
    if (utAvant.getDureePmcEnFinUT().getEtat() == 0)
    {
      pmcConsomme = new QuantiteJour("0");
    }
    else
    {
      Quantite pmcConsomme;
      if (utAvant.getDureePmcEnDebutUT().getEtat() == 0) {
        pmcConsomme = utAvant.getDureePmcEnDebutUT().getQuantiteInitial().soustraire(utAvant.getDureePmcEnFinUT().getQuantiteCourante());
      } else {
        pmcConsomme = utAvant.getDureePmcEnDebutUT().getQuantiteCourante().soustraire(utAvant.getDureePmcEnFinUT().getQuantiteCourante());
      }
    }
    return pmcConsomme;
  }
  
  private static Quantite differeStandardConsomme(UniteTraitementAvant utAvant)
  {
    Quantite differeStandardConsomme;
    Quantite differeStandardConsomme;
    if (utAvant.getDureeDiffereStandardEnFinUT().getEtat() == 0)
    {
      differeStandardConsomme = new QuantiteJour("0");
    }
    else
    {
      Quantite differeStandardConsomme;
      if (utAvant.getDureeDiffereStandardEnDebutUT().getEtat() == 0) {
        differeStandardConsomme = utAvant.getDureeDiffereStandardEnDebutUT().getQuantiteInitial().soustraire(utAvant.getDureeDiffereStandardEnFinUT().getQuantiteCourante());
      } else {
        differeStandardConsomme = utAvant.getDureeDiffereStandardEnDebutUT().getQuantiteCourante().soustraire(utAvant.getDureeDiffereStandardEnFinUT().getQuantiteCourante());
      }
    }
    return differeStandardConsomme;
  }
  
  private static Quantite preavisLegalConsomme(UniteTraitementAvant utAvant)
  {
    Quantite preavisLegalConsomme;
    Quantite preavisLegalConsomme;
    if (utAvant.getDureePreavisLegalEnFinUT().getEtat() == 0)
    {
      preavisLegalConsomme = new QuantiteJour("0");
    }
    else
    {
      Quantite preavisLegalConsomme;
      if (utAvant.getDureePreavisLegalEnDebutUT().getEtat() == 0) {
        preavisLegalConsomme = utAvant.getDureePreavisLegalEnDebutUT().getQuantiteInitial().soustraire(utAvant.getDureePreavisLegalEnFinUT().getQuantiteCourante());
      } else {
        preavisLegalConsomme = utAvant.getDureePreavisLegalEnDebutUT().getQuantiteCourante().soustraire(utAvant.getDureePreavisLegalEnFinUT().getQuantiteCourante());
      }
    }
    return preavisLegalConsomme;
  }
  
  private static Quantite differeSpecifiqueConsomme(UniteTraitementAvant utAvant)
  {
    Quantite differeSpecifiqueConsomme;
    Quantite differeSpecifiqueConsomme;
    if (utAvant.getDureeDiffereSpecifiqueEnFinUT().getEtat() == 0)
    {
      differeSpecifiqueConsomme = new QuantiteJour("0");
    }
    else
    {
      Quantite differeSpecifiqueConsomme;
      if (utAvant.getDureeDiffereSpecifiqueEnDebutUT().getEtat() == 0) {
        differeSpecifiqueConsomme = utAvant.getDureeDiffereSpecifiqueEnDebutUT().getQuantiteInitial().soustraire(utAvant.getDureeDiffereSpecifiqueEnFinUT().getQuantiteCourante());
      } else {
        differeSpecifiqueConsomme = utAvant.getDureeDiffereSpecifiqueEnDebutUT().getQuantiteCourante().soustraire(utAvant.getDureeDiffereSpecifiqueEnFinUT().getQuantiteCourante());
      }
    }
    return differeSpecifiqueConsomme;
  }
  
  private static Quantite delaiAttenteConsomme(UniteTraitementAvant utAvant)
  {
    Quantite delaiAttenteConsomme;
    Quantite delaiAttenteConsomme;
    if (utAvant.getDureeDelaiAttenteEnFinUT().getEtat() == 0)
    {
      delaiAttenteConsomme = new QuantiteJour("0");
    }
    else
    {
      Quantite delaiAttenteConsomme;
      if (utAvant.getDureeDelaiAttenteEnDebutUT().getEtat() == 0) {
        delaiAttenteConsomme = utAvant.getDureeDelaiAttenteEnDebutUT().getQuantiteInitial().soustraire(utAvant.getDureeDelaiAttenteEnFinUT().getQuantiteCourante());
      } else {
        delaiAttenteConsomme = utAvant.getDureeDelaiAttenteEnDebutUT().getQuantiteCourante().soustraire(utAvant.getDureeDelaiAttenteEnFinUT().getQuantiteCourante());
      }
    }
    return delaiAttenteConsomme;
  }
  
  private static boolean traitementPeriodesSuspensives(PeriodeAnalyseSpec pa, QualificationPeriodes qualificationPeriodes)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologiePeriodesSuspensivesSurPeriode = new ChronologiePeriodes();
    chronologiePeriodesSuspensivesSurPeriode.ajouter((ChronologiePeriodes)qualificationPeriodes.getPeriodesSuspensives().copier(new FiltreChevauchePeriode(pa.getPeriode())));
    if (!chronologiePeriodesSuspensivesSurPeriode.estVide()) {
      return true;
    }
    return false;
  }
  
  private static void traitementPeriodesAlertantes(AttributionSpec attribution, UniteTraitementAvant utAvant, QualificationPeriodes qualificationPeriodes, ArretProduitAvecRaison arretProduitAvecRaison, PeriodeAnalyseSpec pa)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronoPeriodesAlertantes = qualificationPeriodes.getPeriodesAlertantes();
    
    ChronologiePeriodes chronoPeriodesAlertantesSurUT = (ChronologiePeriodes)chronoPeriodesAlertantes.copier(new FiltreDebutDansBornes(utAvant.getPeriode()));
    FacadeAvantProduitSpec facadeAvantProduitSpec = FacadeAvantProduitFactory.getInstance().getInstanceFacadeAvantProduit(attribution.getProduitExecution());
    
    ObjetChronoPeriode periodeAlertante = null;
    chronoPeriodesAlertantesSurUT.iterer();
    while (chronoPeriodesAlertantesSurUT.encoreSuivant())
    {
      periodeAlertante = (ObjetChronoPeriode)chronoPeriodesAlertantesSurUT.elementSuivant();
      facadeAvantProduitSpec.traitementPeriodesAlertantes(attribution, periodeAlertante, pa, arretProduitAvecRaison);
    }
  }
  
  private static boolean verifierQteInitialeCarenceRestante(List<DureeConsommableAvant> listeDureeConsoAvantRestante, DureeConsommableAvant dureeConsoAvant)
  {
    listeDureeConsoAvantRestante.remove(dureeConsoAvant);
    Iterator<DureeConsommableAvant> ite = listeDureeConsoAvantRestante.iterator();
    boolean contientCarenceAConsomme = false;
    while ((ite.hasNext()) && (!contientCarenceAConsomme))
    {
      DureeConsommableAvant duree = (DureeConsommableAvant)ite.next();
      if (duree.getQuantiteInitial().getValeurEntiere() > 0) {
        contientCarenceAConsomme = true;
      }
    }
    return contientCarenceAConsomme;
  }
}

/* Location:
 * Qualified Name:     TraitementPeriodesAnalyseAvant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */