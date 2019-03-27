package fr.unedic.cali.calcul;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.dom.ArretProduitAvecRaison;
import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.EvenementFinQuantiteDroit;
import fr.unedic.cali.calcul.dom.EvenementLendemainFinQuantiteDroit;
import fr.unedic.cali.calcul.dom.QualificationPeriodes;
import fr.unedic.cali.calcul.dom.Somme;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.ContexteUT;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAnalyseSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DureeProlongationAbstraite;
import fr.unedic.cali.dom.ImputationSpec;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.cali.dom.QuantiteDroitSpec;
import fr.unedic.cali.dom.QuantiteIndemnisationSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreChevauchePeriode;
import fr.unedic.util.temps.ObjetChronoPeriode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TraitementQuantites
{
  public static void simulerImputationEtImputerLesQuantites(AttributionSpec p_attribution, Quantite p_quantiteAImputer, Quantite p_creditDecalageImputesSurLaPa, PeriodeAnalyseSpec p_pa, ConstituantsIndemnisation p_constituantsIndemnisation, QualificationPeriodes p_qualificationPeriodes, FacadeCalculProduitPeriodiqueSpec p_facadeCalculProduit, ArretProduitAvecRaison p_arretProduitAvecRaison, UniteTraitement p_ut, ContexteUT p_contexteUT)
    throws ApplicativeException
  {
    List listeQuantiteDroitActives = null;
    List listeQuantiteDroitActivesAvantImputation = null;
    QuantiteDroitSpec quantiteDroitAImputer = null;
    Quantite quantiteAImputer = null;
    Quantite quantiteRestantAImputer = null;
    boolean finDeProduit = false;
    boolean finDeQuantiteDroitDansPeriodeAnalyse = false;
    boolean imputeEncore = true;
    Damj dateDebutQuantiteDroit = null;
    Damj dateFinQuantiteDroit = null;
    ChronologiePeriodes chronologieRemplissage = null;
    
    quantiteRestantAImputer = p_quantiteAImputer;
    
    dateDebutQuantiteDroit = p_pa.getDateDebut();
    
    listeQuantiteDroitActives = OutillageQuantites.recupererListeQuantiteDroitActives(p_constituantsIndemnisation.getCollectionQuantiteDroit());
    
    finDeQuantiteDroitDansPeriodeAnalyse = detecterFinQuantiteDansPeriodeAnalyse(listeQuantiteDroitActives, quantiteRestantAImputer, p_facadeCalculProduit, p_constituantsIndemnisation, p_pa.getDateDebut());
    if (finDeQuantiteDroitDansPeriodeAnalyse)
    {
      chronologieRemplissage = OutillageCalculADate.creationChronologieRemplissageAvecSuspensifs((ChronologiePeriodes)p_qualificationPeriodes.getPeriodesSuspensives().copier(new FiltreChevauchePeriode(p_pa.getPeriode())), p_pa.getDateDebut(), p_pa.getDateFin());
      
      OutillageCalculADate.remplirTrousChronologieParDecalage(chronologieRemplissage, p_creditDecalageImputesSurLaPa, p_pa.getPeriode());
    }
    while ((quantiteRestantAImputer.getValeur().compareTo(new BigDecimal(0)) > 0) && (!finDeProduit) && (imputeEncore))
    {
      listeQuantiteDroitActives = OutillageQuantites.recupererListeQuantiteDroitActives(p_constituantsIndemnisation.getCollectionQuantiteDroit());
      
      listeQuantiteDroitActivesAvantImputation = new ArrayList();
      Iterator iterDroit = listeQuantiteDroitActives.iterator();
      while (iterDroit.hasNext())
      {
        QuantiteDroitSpec quantDroitSpec = (QuantiteDroitSpec)iterDroit.next();
        listeQuantiteDroitActivesAvantImputation.add(quantDroitSpec.copie());
      }
      quantiteDroitAImputer = determinerQuantiteDroitAImputer(p_attribution, listeQuantiteDroitActives, quantiteRestantAImputer, p_facadeCalculProduit, p_constituantsIndemnisation, p_pa.getDateDebut());
      
      quantiteAImputer = quantiteRestantAImputer;
      if (quantiteDroitAImputer != null) {
        quantiteAImputer = quantiteDroitAImputer.getQuantiteCourante();
      }
      quantiteAImputer = p_facadeCalculProduit.convertir(quantiteAImputer, quantiteRestantAImputer.getUnite(), p_constituantsIndemnisation, p_pa.getDateDebut());
      if (finDeQuantiteDroitDansPeriodeAnalyse)
      {
        if (dateFinQuantiteDroit != null)
        {
          dateDebutQuantiteDroit = dateFinQuantiteDroit.lendemain();
          dateFinQuantiteDroit = p_pa.getDateFin();
        }
        if (quantiteDroitAImputer != null)
        {
          chronologieRemplissage = tronquerChronologiePeriodesADate(chronologieRemplissage, dateDebutQuantiteDroit);
          
          dateFinQuantiteDroit = p_facadeCalculProduit.getDateFinQuantiteDroit(p_pa.getPeriode(), p_attribution, quantiteDroitAImputer, chronologieRemplissage, quantiteAImputer, dateDebutQuantiteDroit);
          
          FacadeCalculProduitSpec facadeCalcul = FacadeCalculProduitFactory.getInstance().getInstanceGestionnaireCalculProduit(p_attribution.getProduitExecution());
          
          EvenementFinQuantiteDroit evtFinQuantiteDroit = facadeCalcul.creerEvenementFinQuantiteDroit(dateFinQuantiteDroit, quantiteDroitAImputer);
          p_pa.addEvenement(evtFinQuantiteDroit);
        }
      }
      finDeProduit = imputerLesQuantites(p_attribution, p_constituantsIndemnisation, p_pa, p_facadeCalculProduit, listeQuantiteDroitActives, quantiteAImputer, quantiteRestantAImputer, dateDebutQuantiteDroit, dateFinQuantiteDroit, p_arretProduitAvecRaison, p_ut, p_contexteUT);
      
      p_facadeCalculProduit.ajouterEvenementDebutImputation(p_pa, listeQuantiteDroitActivesAvantImputation);
      if (!finDeProduit) {
        imputeEncore = verifierImputeEncore(p_constituantsIndemnisation);
      }
      quantiteRestantAImputer = quantiteRestantAImputer.soustraire(quantiteAImputer);
      if (finDeProduit) {
        p_pa.setProduitATerminerApresUT(true);
      }
      if ((finDeProduit) || (!imputeEncore)) {
        p_pa.setQuantiteNonIndemnisee(p_pa.getQuantiteNonIndemnisee().ajouter(quantiteRestantAImputer));
      }
    }
  }
  
  private static boolean verifierImputeEncore(ConstituantsIndemnisation p_constituantsIndemnisation)
  {
    boolean imputeEncore = false;
    if ((p_constituantsIndemnisation.getCodeFormuleMontant() != null) || (OutillageQuantites.recupererPremiereQuantiteIndemnisationActive(p_constituantsIndemnisation.getCollectionQuantiteDroit()) != null)) {
      imputeEncore = true;
    }
    return imputeEncore;
  }
  
  private static boolean detecterFinQuantiteDansPeriodeAnalyse(List p_listeQuantiteDroitActives, Quantite p_quantiteAImputer, FacadeCalculProduitPeriodiqueSpec p_facadeCalculProduit, ConstituantsIndemnisation p_constituantsIndemnisation, Damj p_dateDebutPa)
    throws CoucheLogiqueException
  {
    boolean finDeQuantiteDroitDansPeriodeAnalyse = false;
    
    List listeImputationsImputees = simulerImputationDesQuantites(p_listeQuantiteDroitActives, p_quantiteAImputer, p_facadeCalculProduit, p_constituantsIndemnisation, p_dateDebutPa);
    
    Iterator iter = listeImputationsImputees.iterator();
    while (iter.hasNext())
    {
      ImputationSpec imputation = (ImputationSpec)iter.next();
      if (imputation.getResteAImputer().getValeur().compareTo(new BigDecimal(0)) <= 0) {
        finDeQuantiteDroitDansPeriodeAnalyse = true;
      }
    }
    return finDeQuantiteDroitDansPeriodeAnalyse;
  }
  
  private static QuantiteDroitSpec determinerQuantiteDroitAImputer(AttributionSpec attribution, List<QuantiteDroitSpec> listeQuantiteDroitActives, Quantite quantiteAImputer, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, ConstituantsIndemnisation constituantsIndemnisation, Damj dateDebutPa)
    throws CoucheLogiqueException
  {
    List listeImputationsImputees = simulerImputationDesQuantites(listeQuantiteDroitActives, quantiteAImputer, facadeCalculProduit, constituantsIndemnisation, dateDebutPa);
    
    QuantiteDroitSpec quantiteDroitAImputer = facadeCalculProduit.determinerDureeProlongationprioritaire(attribution, listeQuantiteDroitActives, quantiteAImputer);
    if (quantiteDroitAImputer != null) {
      return quantiteDroitAImputer.getQuantiteCourante().getValeurEntiere() > quantiteAImputer.getValeurEntiere() ? null : quantiteDroitAImputer;
    }
    ImputationSpec plusPetiteImputation = determinerPlusPetiteImputation(listeImputationsImputees, quantiteAImputer, facadeCalculProduit, constituantsIndemnisation, dateDebutPa);
    if ((plusPetiteImputation != null) && 
      (plusPetiteImputation.getResteAImputer().getValeur().compareTo(new BigDecimal(0)) <= 0)) {
      quantiteDroitAImputer = plusPetiteImputation.getQuantiteDroit();
    }
    return quantiteDroitAImputer;
  }
  
  private static ImputationSpec determinerPlusPetiteImputation(List p_listeImputationsImputees, Quantite p_quantiteAImputer, FacadeCalculProduitPeriodiqueSpec p_facadeCalculProduit, ConstituantsIndemnisation p_constituantsIndemnisation, Damj p_dateDebutPa)
    throws CoucheLogiqueException
  {
    ImputationSpec minimumImputationImputee = null;
    Quantite resteImpute = null;
    
    Iterator iter = p_listeImputationsImputees.iterator();
    while (iter.hasNext())
    {
      ImputationSpec imputation = (ImputationSpec)iter.next();
      
      Quantite resteImputeConverti = p_facadeCalculProduit.convertir(imputation.getResteAImputer(), p_quantiteAImputer.getUnite(), p_constituantsIndemnisation, p_dateDebutPa);
      if (minimumImputationImputee == null)
      {
        minimumImputationImputee = imputation;
        resteImpute = resteImputeConverti;
      }
      else if (resteImputeConverti.getValeur().compareTo(resteImpute.getValeur()) < 0)
      {
        minimumImputationImputee = imputation;
        
        resteImpute = resteImputeConverti;
      }
    }
    return minimumImputationImputee;
  }
  
  private static List simulerImputationDesQuantites(List p_listeQuantiteDroitActives, Quantite p_quantiteAImputer, FacadeCalculProduitPeriodiqueSpec p_facadeCalculProduit, ConstituantsIndemnisation p_constituantsIndemnisation, Damj p_dateDebutPa)
    throws CoucheLogiqueException
  {
    Iterator iterateurQuantiteDroitActives = null;
    QuantiteDroitSpec quantiteDroitActive = null;
    List listeImputationsImputees = null;
    ImputationSpec imputationImputee = null;
    
    listeImputationsImputees = new ArrayList();
    iterateurQuantiteDroitActives = p_listeQuantiteDroitActives.iterator();
    while (iterateurQuantiteDroitActives.hasNext())
    {
      quantiteDroitActive = (QuantiteDroitSpec)iterateurQuantiteDroitActives.next();
      
      Quantite quantiteConverti = p_facadeCalculProduit.convertir(p_quantiteAImputer, quantiteDroitActive.getQuantiteCourante().getUnite(), p_constituantsIndemnisation, p_dateDebutPa);
      
      imputationImputee = quantiteDroitActive.simulerImputer(quantiteConverti);
      if (imputationImputee.estImpute()) {
        listeImputationsImputees.add(imputationImputee);
      }
    }
    return listeImputationsImputees;
  }
  
  private static boolean imputerLesQuantites(AttributionSpec attribution, ConstituantsIndemnisation constituantsIndemnisation, PeriodeAnalyseSpec pa, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, List listeQuantiteDroitActives, Quantite quantiteAImputer, Quantite quantiteRestantAImputer, Damj dateDebutQuantiteDroit, Damj dateFinQuantiteDroit, ArretProduitAvecRaison arretProduitAvecRaison, UniteTraitement ut, ContexteUT contexteUT)
    throws ApplicativeException
  {
    boolean finDeProduitGeneral = false;
    boolean finDeProduit = false;
    Iterator iterateurQuantiteDroitActives = null;
    QuantiteDroitSpec quantiteDroitActive = null;
    QuantiteIndemnisationSpec quantiteIndemnisation = null;
    boolean uneQuantiteIndemnisationTraitee = false;
    String codeFormuleMontant = null;
    quantiteIndemnisation = OutillageQuantites.recupererPremiereQuantiteIndemnisationActive(listeQuantiteDroitActives);
    if (quantiteIndemnisation == null) {
      codeFormuleMontant = constituantsIndemnisation.getCodeFormuleMontant();
    } else {
      codeFormuleMontant = quantiteIndemnisation.getCodeFormuleMontant();
    }
    MontantBaseSpec montant = facadeCalculProduit.calculMontant(attribution.getFormuleMontant(codeFormuleMontant), constituantsIndemnisation, pa.getDateDebut());
    
    iterateurQuantiteDroitActives = listeQuantiteDroitActives.iterator();
    while (iterateurQuantiteDroitActives.hasNext())
    {
      quantiteDroitActive = (QuantiteDroitSpec)iterateurQuantiteDroitActives.next();
      
      quantiteAImputer = facadeCalculProduit.convertir(quantiteAImputer, quantiteDroitActive.getQuantiteCourante().getUnite(), constituantsIndemnisation, pa.getDateDebut());
      
      Quantite quantiteImputable = quantiteAImputer;
      
      quantiteImputable = facadeCalculProduit.determinerQteContexteFormation(attribution, quantiteImputable, codeFormuleMontant, quantiteDroitActive, listeQuantiteDroitActives);
      if ((quantiteDroitActive instanceof QuantiteIndemnisationSpec))
      {
        quantiteIndemnisation = (QuantiteIndemnisationSpec)quantiteDroitActive;
        if (uneQuantiteIndemnisationTraitee) {
          throw new CoucheLogiqueException("HG_PR_CALI_L_DUREE_INDEMNISATION_MULTIPLE", "Impossible d'indemniser le produit: il existe plusieurs durées d'indemnisation actives", null);
        }
        uneQuantiteIndemnisationTraitee = true;
        Damj dateDebut = dateDebutQuantiteDroit;
        Damj dateFin = dateFinQuantiteDroit;
        if (pa.isEstUnePaAvecPlafond())
        {
          facadeCalculProduit.calculSommePlafond(quantiteAImputer, quantiteImputable, ut, dateFin, dateDebut, dateFinQuantiteDroit, quantiteIndemnisation, pa, facadeCalculProduit, montant);
          
          facadeCalculProduit.cumulerMontantGlobalServiAttribution(constituantsIndemnisation, quantiteImputable, montant, attribution);
        }
        if (!quantiteImputable.getValeur().equals(new BigDecimal("0"))) {
          ajouterSomme(pa, dateDebut, dateFin, quantiteImputable, montant, quantiteIndemnisation.getClass(), facadeCalculProduit);
        }
      }
      else if ((estUneDureeProlongationAvecContexteAllongementAREF(quantiteDroitActive)) && (!quantiteImputable.getValeur().equals(new BigDecimal("0"))))
      {
        ajouterSomme(pa, dateDebutQuantiteDroit, dateFinQuantiteDroit, quantiteImputable, montant, quantiteIndemnisation.getClass(), facadeCalculProduit);
      }
      quantiteDroitActive.imputer(quantiteImputable);
      if (estUneDureeProlongationAvecContexteAllongementAREF(quantiteDroitActive))
      {
        Quantite qteAllongementAref = ut.getQteDureeAllongementAref();
        if (qteAllongementAref != null) {
          ut.setQteDureeAllongementAref(qteAllongementAref.ajouter(quantiteImputable));
        } else {
          ut.setQteDureeAllongementAref(quantiteImputable);
        }
        pa.setNbJoursAllongementAREF(quantiteImputable.getValeurEntiere());
      }
      if (quantiteDroitActive.getQuantiteCourante().getValeur().compareTo(new BigDecimal(0)) == 0)
      {
        quantiteDroitActive.epuiser();
        
        finDeProduit = facadeCalculProduit.epuisementQuantiteDroit(dateFinQuantiteDroit, attribution, quantiteDroitActive, constituantsIndemnisation, ut);
        
        FacadeCalculProduitSpec facadeCalcul = FacadeCalculProduitFactory.getInstance().getInstanceGestionnaireCalculProduit(attribution.getProduitExecution());
        
        EvenementFinQuantiteDroit evtFinQuantiteDroit = facadeCalcul.creerEvenementFinQuantiteDroit(dateFinQuantiteDroit, quantiteDroitActive);
        evtFinQuantiteDroit.setEstCauseFinProduit(finDeProduit);
        
        finDeProduitGeneral |= finDeProduit;
        if (finDeProduit)
        {
          dateFinQuantiteDroit = facadeCalculProduit.getDateFinProduit(attribution, quantiteDroitActive, dateFinQuantiteDroit);
          EvenementLendemainFinQuantiteDroit evtLendemainFinQuantiteDroit = new EvenementLendemainFinQuantiteDroit(dateFinQuantiteDroit.lendemain(), quantiteDroitActive);
          
          evtLendemainFinQuantiteDroit.setEstCauseFinProduit(finDeProduit);
          arretProduitAvecRaison.ajouteLendemainFinQuantiteDroitArretCalcul(evtLendemainFinQuantiteDroit);
        }
        pa.getCollectionFinQuantiteDroit().add(evtFinQuantiteDroit);
      }
    }
    if (!uneQuantiteIndemnisationTraitee)
    {
      codeFormuleMontant = constituantsIndemnisation.getCodeFormuleMontant();
      if (codeFormuleMontant == null) {
        throw new CoucheLogiqueException("HG_PR_CALI_L_DUREE_INDEMNISATION_ABSENTE", "Impossible d'indemniser le produit: pas de durée d'indemnisation active ni constituant du montant", null);
      }
      ajouterSomme(pa, dateDebutQuantiteDroit, dateFinQuantiteDroit, quantiteAImputer, montant, null, facadeCalculProduit);
    }
    if ((quantiteIndemnisation != null) && (dateFinQuantiteDroit != null) && (dateFinQuantiteDroit.estAvant(pa.getDateFin())) && (quantiteAImputer.equals(quantiteRestantAImputer))) {
      ajouterSomme(pa, dateFinQuantiteDroit.lendemain(), pa.getDateFin(), new Quantite(new BigDecimal("0"), pa.getUniteParDefautQuantites()), montant, null, facadeCalculProduit);
    }
    return finDeProduitGeneral;
  }
  
  private static boolean estUneDureeProlongationAvecContexteAllongementAREF(QuantiteDroitSpec quantiteDroit)
  {
    return ((quantiteDroit instanceof DureeProlongationAbstraite)) && (((DureeProlongationAbstraite)quantiteDroit).isContexteAllongementAref());
  }
  
  public static void ajouterSomme(PeriodeAnalyseSpec p_pa, Damj p_dateDebutQuantiteDroit, Damj p_dateFinQuantiteDroit, Quantite p_quantiteAImputer, MontantBaseSpec p_montant, Class p_class, FacadeCalculProduitPeriodiqueSpec p_facadeCalculProduit)
    throws CoucheLogiqueException
  {
    if ((p_dateDebutQuantiteDroit != null) && (p_dateFinQuantiteDroit != null)) {
      p_pa.getListeSommes().add(new Somme(p_dateDebutQuantiteDroit, p_dateFinQuantiteDroit, p_facadeCalculProduit.convertir(p_quantiteAImputer, p_pa.getUniteParDefautQuantites(), null, p_pa.getDateDebut()), p_montant, p_class));
    } else {
      p_pa.getListeSommes().add(new Somme(p_pa.getDateDebut(), p_pa.getDateFin(), p_facadeCalculProduit.convertir(p_quantiteAImputer, p_pa.getUniteParDefautQuantites(), null, p_pa.getDateDebut()), p_montant, p_class));
    }
  }
  
  private static ChronologiePeriodes tronquerChronologiePeriodesADate(ChronologiePeriodes p_chonologie, Damj p_date)
  {
    ChronologiePeriodes chronologie = new ChronologiePeriodes();
    
    Iterator iter = p_chonologie.iterer();
    while (iter.hasNext())
    {
      ObjetChronoPeriode periode = (ObjetChronoPeriode)iter.next();
      if (periode.getDateDebut().estApresOuCoincideAvec(p_date)) {
        chronologie.ajouter(periode);
      } else if (periode.getDateFin().estApresOuCoincideAvec(p_date)) {
        chronologie.ajouter(periode);
      }
    }
    return chronologie;
  }
}

/* Location:
 * Qualified Name:     TraitementQuantites
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */