package fr.unedic.cali.calcul;

import fr.unedic.cali.avant.FacadeAvantProduitSpec;
import fr.unedic.cali.calcul.dom.ArretProduitAvecRaison;
import fr.unedic.cali.calcul.dom.ConsommationPeriodes;
import fr.unedic.cali.calcul.dom.DureeConsommableAvant;
import fr.unedic.cali.calcul.dom.EvenementLendemainFinQuantiteDroit;
import fr.unedic.cali.calcul.dom.UniteTraitementAvant;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAnalyseSpec;
import fr.unedic.cali.dom.ImputationSpec;
import fr.unedic.cali.dom.QuantiteDroitSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class TraitementDureeConsommableAvant
{
  public static Quantite simulerImputationEtImputerLaQuantite(Quantite pquantiteAImputer, PeriodeAnalyseSpec pa, DureeConsommableAvant dureeConcommableAvant, UniteTraitementAvant utAvant, Damj dateDebutConsommation, ArretProduitAvecRaison arretProduitAvecRaison)
    throws CoucheLogiqueException
  {
    QuantiteDroitSpec quantiteDroitAImputer = null;
    Quantite quantiteAImputer = null;
    Quantite quantiteRestantAImputer = null;
    
    quantiteRestantAImputer = pquantiteAImputer;
    
    quantiteAImputer = pquantiteAImputer;
    quantiteDroitAImputer = determinerQuantiteDroitAImputer(dureeConcommableAvant, pquantiteAImputer);
    if (quantiteDroitAImputer != null) {
      quantiteAImputer = quantiteDroitAImputer.getQuantiteCourante();
    }
    dureeConcommableAvant.imputer(quantiteAImputer);
    if (dureeConcommableAvant.getQuantiteCourante().getValeur().compareTo(new BigDecimal(0)) == 0)
    {
      dureeConcommableAvant.epuiser();
      
      DureeCalendaire d = new DureeCalendaire(0, 0, quantiteAImputer.getValeurEntiere());
      Damj dateFinQuantiteDroit = dateDebutConsommation.deplacerVersAvant(d).veille();
      Periode p = utAvant.getConsommationPeriodes().getPeriodesParTypologie(dureeConcommableAvant.getTypeDureeConsommable());
      if (p != null) {
        p.setFin(dateFinQuantiteDroit);
      }
    }
    quantiteRestantAImputer = quantiteRestantAImputer.soustraire(quantiteAImputer);
    
    return quantiteRestantAImputer;
  }
  
  public static Quantite simulerImputationEtImputerLaQuantiteEtTerminerProduit(Quantite pquantiteAImputer, PeriodeAnalyseSpec pa, DureeConsommableAvant dureeConcommableAvant, UniteTraitementAvant utAvant, Damj dateDebutConsommation, ArretProduitAvecRaison arretProduitAvecRaison, Damj dateAttribution, FacadeAvantProduitSpec facadeAvant)
    throws CoucheLogiqueException
  {
    QuantiteDroitSpec quantiteDroitAImputer = null;
    Quantite quantiteAImputer = null;
    Quantite quantiteRestantAImputer = null;
    boolean finDeProduit = false;
    boolean finDeQuantiteDroitDansPeriodeAnalyse = false;
    Damj dateDebutQuantiteDroit = null;
    Damj dateFinQuantiteDroit = null;
    
    quantiteRestantAImputer = pquantiteAImputer;
    
    dateDebutQuantiteDroit = dateDebutConsommation;
    
    finDeQuantiteDroitDansPeriodeAnalyse = detecterFinQuantiteDansPeriodeAnalyse(dureeConcommableAvant, quantiteRestantAImputer);
    while ((quantiteRestantAImputer.getValeur().compareTo(new BigDecimal(0)) > 0) && (!finDeProduit))
    {
      quantiteDroitAImputer = determinerQuantiteDroitAImputer(dureeConcommableAvant, quantiteRestantAImputer);
      
      quantiteAImputer = quantiteRestantAImputer;
      if (quantiteDroitAImputer != null) {
        quantiteAImputer = quantiteDroitAImputer.getQuantiteCourante();
      }
      if (finDeQuantiteDroitDansPeriodeAnalyse)
      {
        if (dateFinQuantiteDroit != null)
        {
          dateDebutQuantiteDroit = dateFinQuantiteDroit.lendemain();
          dateFinQuantiteDroit = pa.getDateFin();
        }
        if (quantiteDroitAImputer != null)
        {
          DureeCalendaire d = new DureeCalendaire(0, 0, quantiteDroitAImputer.getQuantiteCourante().getValeurEntiere());
          dateFinQuantiteDroit = dateDebutQuantiteDroit.deplacerVersAvant(d).veille();
          
          pa.addEvenement(facadeAvant.creerEvtFinQteDroit(dateFinQuantiteDroit, quantiteDroitAImputer));
        }
      }
      finDeProduit = imputerLaQuantite(pa, dureeConcommableAvant, quantiteAImputer, dateFinQuantiteDroit, arretProduitAvecRaison);
      
      quantiteRestantAImputer = quantiteRestantAImputer.soustraire(quantiteAImputer);
      if (finDeProduit)
      {
        pa.setProduitATerminerApresUT(true);
        
        DureeCalendaire d = new DureeCalendaire(0, 0, quantiteAImputer.getValeurEntiere());
        dateFinQuantiteDroit = dateDebutConsommation.deplacerVersAvant(d).veille();
        Periode p = utAvant.getConsommationPeriodes().getPeriodesParTypologie(dureeConcommableAvant.getTypeDureeConsommable());
        if (p != null) {
          p.setFin(dateFinQuantiteDroit);
        }
        pa.setQuantiteNonIndemnisee(pa.getQuantiteNonIndemnisee().ajouter(quantiteRestantAImputer));
        
        EvenementLendemainFinQuantiteDroit evtLendemainFinQuantiteDroit = new EvenementLendemainFinQuantiteDroit(Damj.max(dateFinQuantiteDroit.lendemain(), dateAttribution), dureeConcommableAvant);
        
        evtLendemainFinQuantiteDroit.setEstCauseFinProduit(finDeProduit);
        
        arretProduitAvecRaison.ajouteLendemainFinQuantiteDroitArretCalcul(evtLendemainFinQuantiteDroit);
      }
    }
    return quantiteRestantAImputer;
  }
  
  private static boolean detecterFinQuantiteDansPeriodeAnalyse(DureeConsommableAvant quantiteActive, Quantite quantiteAImputer)
  {
    ImputationSpec quantiteImputee = null;
    boolean finDeQuantiteDroitDansPeriodeAnalyse = false;
    
    quantiteImputee = quantiteActive.simulerImputer(quantiteAImputer);
    if ((quantiteImputee.estImpute()) && 
      (quantiteImputee.getResteAImputer().getValeur().compareTo(new BigDecimal(0)) <= 0)) {
      finDeQuantiteDroitDansPeriodeAnalyse = true;
    }
    return finDeQuantiteDroitDansPeriodeAnalyse;
  }
  
  private static QuantiteDroitSpec determinerQuantiteDroitAImputer(DureeConsommableAvant dureeIndemnisation, Quantite quantiteAImputer)
  {
    ImputationSpec imputationImputee = null;
    QuantiteDroitSpec quantiteDroitAImputer = null;
    
    imputationImputee = dureeIndemnisation.simulerImputer(quantiteAImputer);
    if ((imputationImputee.estImpute()) && (imputationImputee.getResteAImputer().getValeur().compareTo(new BigDecimal(0)) <= 0)) {
      quantiteDroitAImputer = imputationImputee.getQuantiteDroit();
    }
    return quantiteDroitAImputer;
  }
  
  private static boolean imputerLaQuantite(PeriodeAnalyseSpec pa, DureeConsommableAvant dureeIndemnisationActive, Quantite quantiteAImputer, Damj dateFinQuantiteDroit, ArretProduitAvecRaison arretProduitAvecRaison)
    throws CoucheLogiqueException
  {
    boolean finDeProduit = false;
    
    dureeIndemnisationActive.imputer(quantiteAImputer);
    if (dureeIndemnisationActive.getQuantiteCourante().getValeur().compareTo(new BigDecimal(0)) == 0)
    {
      dureeIndemnisationActive.epuiser();
      finDeProduit = true;
    }
    return finDeProduit;
  }
}

/* Location:
 * Qualified Name:     TraitementDureeConsommableAvant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */