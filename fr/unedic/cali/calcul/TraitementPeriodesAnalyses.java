package fr.unedic.cali.calcul;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.dom.ArretProduitAvecRaison;
import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.QualificationPeriodes;
import fr.unedic.cali.calcul.dom.QuantiteNonIndemnises;
import fr.unedic.cali.calcul.dom.Somme;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoNonIndemnise;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoRemplissage;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionForcage;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.ContexteUT;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAnalyseSpec;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodesPriseEnCompte;
import fr.unedic.cali.calcul.outilsfonctionnels.proratisation.PeriodeProratisationFactory;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DureeNonIndemnisable;
import fr.unedic.cali.dom.ElementBaseIndemnisationSpec;
import fr.unedic.cali.dom.FormuleMontantSpec;
import fr.unedic.cali.dom.QuantiteIndemnisationSpec;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteJour;
import fr.unedic.util.Unite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.FiltreDebutDansBornes;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TraitementPeriodesAnalyses
{
  static ConstituantsIndemnisation traitementDesPeriodesAnalyses(AttributionSpec attribution, UniteTraitement ut, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, ConstituantsIndemnisation constituantsIndemnisation, ChronologiePeriodes periodesAnalyse, QualificationPeriodes qualificationPeriodes, ArretProduitAvecRaison arretProduitAvecRaison, ContexteUT contexteUT, PeriodesPriseEnCompte periodesPriseEnCompte)
    throws ApplicativeException
  {
    Quantite creditDecalage = null;
    Quantite creditDecalageDuree = null;
    Quantite creditDecalageImputeSurLaPa = null;
    Quantite creditDecalageDureeImputeSurLaPa = null;
    Quantite quantiteAImputerSurLaPA = null;
    
    PeriodeAnalyseSpec pa = null;
    ConstituantsIndemnisation constituantsIndemnisationTmp = null;
    ChronologiePeriodes chronoPeriodesSegmentantes = null;
    ChronologiePeriodes chronoPeriodesSegmentantesSurPA = null;
    ObjetChronoPeriode periodeSegmentante = null;
    boolean imputerDureeAR = true;
    boolean aTraiteActiviteReduiteSurPa = false;
    Damj dateFinPaTraiteActiviteReduiteSurUt = null;
    
    creditDecalage = ut.getCreditDecalage();
    creditDecalageDuree = ut.getCreditDecalageDuree();
    
    boolean clauseRattrapage = false;
    if (constituantsIndemnisation.getElementBaseIndemnisationCourant() != null) {
      clauseRattrapage = constituantsIndemnisation.getElementBaseIndemnisationCourant().isClauseRattrapage();
    }
    constituantsIndemnisationTmp = constituantsIndemnisation;
    
    QuantiteNonIndemnises quantiteNI = new QuantiteNonIndemnises();
    List<DureeNonIndemnisable> listeDureeNi = new ArrayList();
    if (constituantsIndemnisationTmp.getListListeDureeNonIndemnisables() != null) {
      listeDureeNi = constituantsIndemnisationTmp.getListListeDureeNonIndemnisables();
    }
    TraitementDureeNonIndemnisable.miseAJourReliquatMaxSurMoisEnDebutDeMois(listeDureeNi);
    
    periodesAnalyse.iterer();
    while (periodesAnalyse.encoreSuivant())
    {
      pa = (PeriodeAnalyseSpec)periodesAnalyse.elementSuivant();
      creditDecalageImputeSurLaPa = new Quantite(BigDecimal.ZERO, ut.getUniteParDefautQuantites());
      creditDecalageDureeImputeSurLaPa = new Quantite(BigDecimal.ZERO, ut.getUniteParDefautQuantites());
      if ((arretProduitAvecRaison.isRaisonsContientRaison(1)) || (arretProduitAvecRaison.isRaisonsContientRaison(2)))
      {
        mettreAJourQuantitesApresArretProduit(ut, pa, periodesPriseEnCompte, aTraiteActiviteReduiteSurPa, dateFinPaTraiteActiviteReduiteSurUt);
      }
      else
      {
        constituantsIndemnisationTmp = facadeCalculProduit.miseAJourConstituantsIndemnisation(ut, attribution, constituantsIndemnisationTmp, pa.getDateDebut(), pa.getPeriode());
        
        chronoPeriodesSegmentantes = qualificationPeriodes.getPeriodesSegmentantes();
        
        chronoPeriodesSegmentantesSurPA = (ChronologiePeriodes)chronoPeriodesSegmentantes.copier(new FiltreDebutDansBornes(pa.getPeriode()));
        
        chronoPeriodesSegmentantesSurPA.iterer();
        while (chronoPeriodesSegmentantesSurPA.encoreSuivant())
        {
          periodeSegmentante = (ObjetChronoPeriode)chronoPeriodesSegmentantesSurPA.elementSuivant();
          facadeCalculProduit.traitementPeriodeSegmentante(attribution, periodeSegmentante, constituantsIndemnisation, ut, pa, arretProduitAvecRaison, periodesAnalyse);
        }
        if ((arretProduitAvecRaison.isRaisonsContientRaison(1)) || (arretProduitAvecRaison.isRaisonsContientRaison(2)))
        {
          mettreAJourQuantitesApresArretProduit(ut, pa, periodesPriseEnCompte, aTraiteActiviteReduiteSurPa, dateFinPaTraiteActiviteReduiteSurUt);
        }
        else
        {
          preTraitementPa(attribution, pa, constituantsIndemnisationTmp, facadeCalculProduit, contexteUT);
          if (!pa.isNbJoursIndemnisesForce())
          {
            int quantiteDAImputeeSurPA = TraitementDureeNonIndemnisable.traitementDelaiAttenteEnDebutDeMois(quantiteNI, listeDureeNi, pa);
            
            TraitementPeriodes.traitementPeriodesSuspensives(facadeCalculProduit, attribution, pa, qualificationPeriodes, quantiteDAImputeeSurPA);
            if ((creditDecalage != null) && (creditDecalage.getValeurEntiere() != 0))
            {
              creditDecalageImputeSurLaPa = TraitementDecalage.imputationDecalageSurUnePa(creditDecalage, pa);
              creditDecalage = creditDecalage.soustraire(creditDecalageImputeSurLaPa);
            }
            else if ((facadeCalculProduit.verifierApplicationForcageSurUT(ut, attribution)) && (!GestionForcage.appliquerForcageCreditDecalage(attribution.getDemande(), ut)))
            {
              creditDecalageImputeSurLaPa = TraitementDecalage.traitementActiviteReduiteSurPa(pa, facadeCalculProduit, ut, attribution, constituantsIndemnisation);
              
              aTraiteActiviteReduiteSurPa = true;
              dateFinPaTraiteActiviteReduiteSurUt = pa.getDateFin();
            }
            if ((creditDecalageDuree != null) && (creditDecalageDuree.getValeurEntiere() != 0))
            {
              creditDecalageDureeImputeSurLaPa = TraitementDecalage.imputationDecalageSurUnePa(creditDecalageDuree, pa);
              creditDecalageDuree = creditDecalageDuree.soustraire(creditDecalageDureeImputeSurLaPa);
            }
            Quantite quantiteImputableSurLaPA = pa.getQuantiteIndemnisable().soustraire(pa.getQuantiteNonIndemnisee());
            if ((facadeCalculProduit.verifierApplicationForcageSurUT(ut, attribution)) && (!GestionForcage.appliquerForcageCreditDecalage(attribution.getDemande(), ut))) {
              TraitementPlafonnement.determinerPlafondSurPa(pa, ut, attribution, quantiteImputableSurLaPA, facadeCalculProduit, contexteUT, constituantsIndemnisation);
            }
          }
          quantiteAImputerSurLaPA = pa.getQuantiteIndemnisable().soustraire(pa.getQuantiteNonIndemnisee());
          
          Damj debutDA = pa.getDateDebut();
          DureeNonIndemnisable delaiAttente = TraitementDureeNonIndemnisable.recupererDureeNonIndemnisable(listeDureeNi, "DA");
          if ((delaiAttente != null) && (delaiAttente.getQuantiteCourante().compareTo(new QuantiteJour(new BigDecimal("7"))) == 0)) {
            debutDA = determinerDebutDA(creditDecalageImputeSurLaPa, qualificationPeriodes, ut, pa);
          }
          TraitementDureeNonIndemnisable.traitementDesDureesNonIndemnisees(qualificationPeriodes, listeDureeNi, pa, quantiteAImputerSurLaPA, quantiteNI, debutDA, clauseRattrapage);
          
          quantiteAImputerSurLaPA = pa.getQuantiteIndemnisable().soustraire(pa.getQuantiteNonIndemnisee());
          imputerDureeAR = facadeCalculProduit.verifierImputationDuree(ut, constituantsIndemnisationTmp);
          if (!imputerDureeAR)
          {
            quantiteAImputerSurLaPA = new Quantite(0, ut.getUniteParDefautQuantites());
            pa.setQuantiteIndemnisee(pa.getQuantiteIndemnisable().soustraire(pa.getQuantiteNonIndemnisee()));
          }
          if ("1".equals(quantiteAImputerSurLaPA.getUnite().getCode()))
          {
            if (BigDecimal.ZERO.compareTo(quantiteAImputerSurLaPA.getValeur()) == 0) {
              creerSommesNullesSurPA(facadeCalculProduit, attribution, pa, constituantsIndemnisationTmp, imputerDureeAR);
            }
          }
          else if (quantiteAImputerSurLaPA.getValeurEntiere() == 0) {
            creerSommesNullesSurPA(facadeCalculProduit, attribution, pa, constituantsIndemnisationTmp, imputerDureeAR);
          }
          TraitementQuantites.simulerImputationEtImputerLesQuantites(attribution, quantiteAImputerSurLaPA, creditDecalageImputeSurLaPa.ajouter(creditDecalageDureeImputeSurLaPa), pa, constituantsIndemnisationTmp, qualificationPeriodes, facadeCalculProduit, arretProduitAvecRaison, ut, contexteUT);
          
          facadeCalculProduit.forcerImputationQuantiteIndemnisation(pa, constituantsIndemnisationTmp, arretProduitAvecRaison);
          
          postTraitementPa(ut, pa, constituantsIndemnisationTmp, imputerDureeAR, facadeCalculProduit);
        }
      }
    }
    facadeCalculProduit.majCumulServiQuantitePlafonne(constituantsIndemnisation, ut);
    
    gestionPeriodesAlertantes(attribution, ut, facadeCalculProduit, constituantsIndemnisation, qualificationPeriodes, arretProduitAvecRaison, pa);
    
    majCreditDecalage(ut, creditDecalage, creditDecalageDuree);
    
    facadeCalculProduit.miseAJourMontantSurSommes(attribution, ut, constituantsIndemnisation, ut.getDateDebut());
    
    facadeCalculProduit.traitementPeriodesNonIndemnises(ut, qualificationPeriodes, quantiteNI, constituantsIndemnisation);
    
    TraitementDureeNonIndemnisable.miseAJourReliquatMaxEnFinDeMois(listeDureeNi, clauseRattrapage);
    
    return constituantsIndemnisation;
  }
  
  private static Damj determinerDebutDA(Quantite quantiteDecalageSurPa, QualificationPeriodes qualificationPeriodes, UniteTraitement ut, PeriodeAnalyseSpec pa)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronoPeriodesNonIndemniseEtSuspensive = PeriodeProratisationFactory.decoupeEtProratiseParDefaut(qualificationPeriodes.getPeriodesSuspensives(), ut.getPeriode());
    
    ChronologiePeriodes chronologiePeriodesRemplie = OutillageCalculADate.boucheLesTrous(chronoPeriodesNonIndemniseEtSuspensive, ObjetChronoRemplissage.class, pa.getDateDebut(), pa.getDateFin());
    
    ObjetChronoPeriode objetChronoPeriode = null;
    
    Quantite qteNonIndemniseActiviteProf = pa.getQuantitePlafonnee().ajouter(quantiteDecalageSurPa);
    
    chronologiePeriodesRemplie.iterer();
    while ((chronologiePeriodesRemplie.encoreSuivant()) && (qteNonIndemniseActiviteProf.getValeurEntiere() > 0))
    {
      objetChronoPeriode = (ObjetChronoPeriode)chronologiePeriodesRemplie.elementSuivant();
      if ((objetChronoPeriode instanceof ObjetChronoRemplissage))
      {
        int quantiteTmp = Math.min(objetChronoPeriode.getDuree(), qteNonIndemniseActiviteProf.getValeurEntiere());
        if (quantiteTmp > 0)
        {
          ObjetChronoNonIndemnise o = new ObjetChronoNonIndemnise();
          if (quantiteTmp == 1) {
            o = new ObjetChronoNonIndemnise(objetChronoPeriode.getDateDebut(), objetChronoPeriode.getDateDebut(), null);
          } else {
            o = new ObjetChronoNonIndemnise(objetChronoPeriode.getDateDebut(), objetChronoPeriode.getDateDebut().deplacerVersAvant(new DureeCalendaire(0, 0, quantiteTmp - 1)), null);
          }
          chronoPeriodesNonIndemniseEtSuspensive.ajouter(o);
          qteNonIndemniseActiviteProf = new Quantite(qteNonIndemniseActiviteProf.getValeurEntiere() - quantiteTmp, qteNonIndemniseActiviteProf.getUnite());
        }
      }
    }
    ChronologiePeriodes chronoTemporaire = OutillageCalculADate.boucheLesTrous(chronoPeriodesNonIndemniseEtSuspensive, ObjetChronoRemplissage.class, pa.getDateDebut(), pa.getDateFin());
    
    chronoTemporaire.iterer();
    while (chronoTemporaire.encoreSuivant())
    {
      objetChronoPeriode = (ObjetChronoPeriode)chronoTemporaire.elementSuivant();
      if ((objetChronoPeriode instanceof ObjetChronoRemplissage)) {
        return objetChronoPeriode.getDateDebut();
      }
    }
    return null;
  }
  
  private static void majCreditDecalage(UniteTraitement ut, Quantite creditDecalage, Quantite creditDecalageDuree)
  {
    if ((creditDecalage != null) && (creditDecalage.getValeurEntiere() > 0)) {
      ut.setCreditDecalageEnFinUT(creditDecalage);
    }
    if ((creditDecalageDuree != null) && (creditDecalageDuree.getValeurEntiere() > 0)) {
      ut.setCreditDecalageDureeEnFinUT(creditDecalageDuree);
    }
  }
  
  private static void gestionPeriodesAlertantes(AttributionSpec attribution, UniteTraitement ut, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, ConstituantsIndemnisation constituantsIndemnisation, QualificationPeriodes qualificationPeriodes, ArretProduitAvecRaison arretProduitAvecRaison, PeriodeAnalyseSpec pa)
    throws ApplicativeException
  {
    ChronologiePeriodes chronoPeriodesAlertantes = qualificationPeriodes.getPeriodesAlertantes();
    
    ChronologiePeriodes chronoPeriodesAlertantesSurUT = (ChronologiePeriodes)chronoPeriodesAlertantes.copier(new FiltreDebutDansBornes(ut.getPeriode()));
    
    chronoPeriodesAlertantesSurUT.iterer();
    while (chronoPeriodesAlertantesSurUT.encoreSuivant())
    {
      ObjetChronoPeriode periodeAlertante = (ObjetChronoPeriode)chronoPeriodesAlertantesSurUT.elementSuivant();
      facadeCalculProduit.traitementPeriodesAlertantes(attribution, periodeAlertante, constituantsIndemnisation, ut, pa, arretProduitAvecRaison);
    }
  }
  
  private static void creerSommesNullesSurPA(FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, AttributionSpec attribution, PeriodeAnalyseSpec pa, ConstituantsIndemnisation constituantsIndemnisation, boolean imputerDureeAR)
    throws CoucheLogiqueException
  {
    QuantiteIndemnisationSpec quantiteIndemnisation = null;
    FormuleMontantSpec formuleMontant = null;
    Quantite nbJourIndemnise = null;
    
    List<Somme> listeSommes = pa.getListeSommes();
    if (listeSommes != null) {
      pa.setListeSommes(listeSommes);
    }
    quantiteIndemnisation = OutillageQuantites.recupererPremiereQuantiteIndemnisationActive(constituantsIndemnisation.getCollectionQuantiteDroit());
    
    String codeFormuleMontant = null;
    if (quantiteIndemnisation != null) {
      codeFormuleMontant = quantiteIndemnisation.getCodeFormuleMontant();
    } else if (constituantsIndemnisation.getCodeFormuleMontant() != null) {
      codeFormuleMontant = constituantsIndemnisation.getCodeFormuleMontant();
    }
    formuleMontant = attribution.getFormuleMontant(codeFormuleMontant);
    if (imputerDureeAR) {
      nbJourIndemnise = new Quantite(BigDecimal.ZERO, pa.getUniteParDefautQuantites());
    } else {
      nbJourIndemnise = pa.getQuantiteIndemnisee();
    }
    if (formuleMontant != null) {
      listeSommes.add(new Somme(pa.getDateDebut(), pa.getDateFin(), nbJourIndemnise, facadeCalculProduit.calculMontant(formuleMontant, constituantsIndemnisation, pa.getDateDebut()), null));
    }
  }
  
  private static void preTraitementPa(AttributionSpec attribution, PeriodeAnalyseSpec pa, ConstituantsIndemnisation constituantsIndemnisation, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, ContexteUT contexteUT)
    throws CoucheLogiqueException
  {
    pa.setQuantiteIndemnisable(facadeCalculProduit.getQuantiteIndemnisableTheorique(pa.getPeriode(), attribution, constituantsIndemnisation, contexteUT));
    
    pa.setConstituantsIndemnisationEnDebutPA((ConstituantsIndemnisation)constituantsIndemnisation.copie());
    
    List<Temporel> evtsChgtsParam = new ArrayList();
    Iterator<?> it = facadeCalculProduit.getEvtsChangementParametre(constituantsIndemnisation, pa.getDateDebut()).iterator();
    while (it.hasNext())
    {
      Temporel evt = (Temporel)it.next();
      if (pa.getPeriode().contient(evt.getDateEffet())) {
        evtsChgtsParam.add(evt);
      }
    }
    pa.addEvenements(evtsChgtsParam);
    
    pa.setCollectionFinQuantiteDroit(new ArrayList());
  }
  
  private static void postTraitementPa(UniteTraitement ut, PeriodeAnalyseSpec pa, ConstituantsIndemnisation constituantsIndemnisation, boolean imputerDureeAR, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit)
    throws CoucheLogiqueException
  {
    ut.ajouterSommes(pa.getListeSommes());
    
    ut.ajouterEvenementsFinQuantiteDroit(pa.getCollectionFinQuantiteDroit());
    
    pa.setConstituantsIndemnisationEnFinPA((ConstituantsIndemnisation)constituantsIndemnisation.copie());
    if (pa.isProduitATerminerApresPA()) {
      ut.setProduitATerminerApresUT(pa.isProduitATerminerApresPA());
    }
    if (imputerDureeAR) {
      calculerQuantiteIndemniseParLesSommes(pa, constituantsIndemnisation, facadeCalculProduit);
    }
    ut.ajouterEvenements(pa.getEvenements());
    
    ut.setQuantiteIndemnisable(ut.getQuantiteIndemnisable().ajouter(pa.getQuantiteIndemnisable()));
    ut.setQuantiteNonIndemnisee(ut.getQuantiteNonIndemnisee().ajouter(pa.getQuantiteNonIndemnisee()));
    ut.setQuantiteIndemnisee(ut.getQuantiteIndemnisee().ajouter(pa.getQuantiteIndemnisee()));
    ut.setQuantiteImputeeNonIndemnisee(ut.getQuantiteImputeeNonIndemnisee().ajouter(pa.getQuantiteImputeeNonIndemnisee()));
    ut.setQuantitePlafonnee(ut.getQuantitePlafonnee().ajouter(pa.getQuantitePlafonnee()));
    ut.setPlafonnee(ut.getQuantitePlafonnee().getValeurEntiere() > 0);
    ut.ajouterPeriodesAnalyse(pa);
  }
  
  private static void calculerQuantiteIndemniseParLesSommes(PeriodeAnalyseSpec pa, ConstituantsIndemnisation constituantsIndemnisation, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit)
    throws CoucheLogiqueException
  {
    Quantite quantiteIndemnise = new Quantite(BigDecimal.ZERO, pa.getUniteParDefautQuantites());
    Somme somme = null;
    Iterator iterator = null;
    if (pa.getListeSommes() != null)
    {
      iterator = pa.getListeSommes().iterator();
      while (iterator.hasNext())
      {
        somme = (Somme)iterator.next();
        quantiteIndemnise = quantiteIndemnise.ajouter(facadeCalculProduit.convertir(somme.getNbBase(), quantiteIndemnise.getUnite(), constituantsIndemnisation, pa.getDateDebut()));
      }
      pa.setQuantiteIndemnisee(quantiteIndemnise);
    }
  }
  
  private static void mettreAJourQuantitesApresArretProduit(UniteTraitement ut, PeriodeAnalyseSpec pa, PeriodesPriseEnCompte periodesPriseEnCompte, boolean aTraiteActiviteReduiteSurPa, Damj dateFinPaTraiteActiviteReduiteSurUt)
    throws CoucheLogiqueException
  {
    pa.setQuantiteIndemnisable(new Quantite(new BigDecimal(pa.getDuree()), ut.getUniteParDefautQuantites()));
    pa.setQuantiteNonIndemnisee(new Quantite(new BigDecimal(pa.getDuree()), ut.getUniteParDefautQuantites()));
    pa.setQuantiteIndemnisee(new Quantite(BigDecimal.ZERO, ut.getUniteParDefautQuantites()));
    
    ut.setQuantiteIndemnisable(new Quantite(new BigDecimal(ut.getQuantiteIndemnisable().getValeurEntiere() + pa.getQuantiteIndemnisable().getValeurEntiere()), ut.getUniteParDefautQuantites()));
    
    ut.setQuantiteNonIndemnisee(new Quantite(new BigDecimal(ut.getQuantiteNonIndemnisee().getValeurEntiere() + pa.getQuantiteNonIndemnisee().getValeurEntiere()), ut.getUniteParDefautQuantites()));
    if ((aTraiteActiviteReduiteSurPa) && (ut.getDateDebut().estApresOuCoincideAvec(GestionnaireDateApplication.getInstance().recupererDateApplication("Application des segmentant à tort")))) {
      periodesPriseEnCompte.tronquePeriodeParTypologieEnFin(dateFinPaTraiteActiviteReduiteSurUt, 5);
    }
  }
}

/* Location:
 * Qualified Name:     TraitementPeriodesAnalyses
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */