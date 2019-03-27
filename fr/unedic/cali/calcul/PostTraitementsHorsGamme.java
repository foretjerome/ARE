package fr.unedic.cali.calcul;

import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnCharge;
import fr.unedic.cali.calcul.dom.ArretProduitAvecRaison;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.EtatAuDji;
import fr.unedic.cali.calcul.dom.Somme;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.periode.PeriodeExclusionDefinitiveDDTE;
import fr.unedic.cali.calcul.dom.periode.PeriodeNonMaintienASSetATA;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DureeFinancementAbstraite;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.cali.dom.QuantiteDroitSpec;
import fr.unedic.cali.dom.QuantiteIndemnisationSpec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreContientDate;
import fr.unedic.cali.parcours.ResultatCalcul;
import fr.unedic.cali.parcours.ResultatDetailleProduit;
import fr.unedic.cali.parcours.ResultatDeterminationEtatDroitProduit;
import fr.unedic.cali.parcours.ResultatMigrationCalculProduit;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.QuantiteJour;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PostTraitementsHorsGamme
{
  protected static void remplirResultatPostTraitement(Resultat p_resultat)
  {
    p_resultat.setEtat(0);
  }
  
  protected static void remplirResultatPostTraitement(CalendrierExecutionCalculSpec p_calendrierExecutionCalcul, ResultatCalcul p_resultat)
  {
    p_resultat.setCalendrierExecutionCalcul(p_calendrierExecutionCalcul);
    
    remplirResultatPostTraitement(p_resultat);
  }
  
  protected static void remplirResultatPostTraitement(AttributionSpec p_attribution, CalendrierExecutionCalculSpec p_calendrierExecutionCalcul, ResultatDetailleProduit p_resultat)
    throws CoucheLogiqueException
  {
    remplirResultatPostTraitement(p_calendrierExecutionCalcul, p_resultat);
    
    p_resultat.setAttribution(p_attribution);
  }
  
  protected static void remplirResultatPostTraitement(AttributionSpec p_attribution, CalendrierExecutionCalculSpec p_calendrierExecutionCalcul, Damj p_dateEtatDroit, ResultatDeterminationEtatDroitProduit p_resultat)
    throws CoucheLogiqueException
  {
    remplirResultatPostTraitement(p_attribution, p_calendrierExecutionCalcul, p_resultat);
    
    EtatAuDji etatAuDji = p_calendrierExecutionCalcul.getEtatAuDJI();
    if ((etatAuDji != null) && (p_dateEtatDroit == p_calendrierExecutionCalcul.getDernierJourIndemnisable()))
    {
      p_resultat.setMontant(etatAuDji.getMontant());
      p_resultat.setCumulJourIndemnise(etatAuDji.getCumulJoursIndemnise());
    }
    else
    {
      p_resultat.setMontant(recupererMontant(p_calendrierExecutionCalcul));
      p_resultat.setCumulJourIndemnise(recupererCumulJoursServi(p_calendrierExecutionCalcul));
    }
    if (etatAuDji != null) {
      if (etatAuDji.getPeriodePECEvenementReducteur() != null) {
        p_resultat.setPeriodePriseEnCompteEvtsReducteurs(etatAuDji.getPeriodePECEvenementReducteur());
      } else {
        p_resultat.setPeriodePriseEnCompteEvtsReducteurs(recupererPeriodePriseEnCompteEvtsReducteurs(p_attribution, p_calendrierExecutionCalcul, p_resultat.getEtatAttribution()));
      }
    }
  }
  
  protected static void remplirResultatPostTraitement(AttributionSpec p_attribution, CalendrierExecutionCalculSpec p_calendrierExecutionCalcul, ResultatMigrationCalculProduit p_resultat)
    throws CoucheLogiqueException
  {
    remplirResultatPostTraitement(p_attribution, p_calendrierExecutionCalcul, p_resultat);
    
    p_resultat.setQuantiteIndemnisee(calculerQuantiteIndemnisee(p_calendrierExecutionCalcul));
    
    p_resultat.setCapitalindemnise(calculerCapitalIndemnise(p_calendrierExecutionCalcul));
    
    p_resultat.setMontantJourBrutDJI(calculerMontantJourBrutDJI(p_calendrierExecutionCalcul));
  }
  
  public static int recupererEtatAttribution(CalendrierExecutionCalculSpec p_calendrierExecutionCalcul)
    throws CoucheLogiqueException
  {
    int etatDecision = 0;
    UniteTraitement ut = null;
    if ((p_calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique))
    {
      Chronologie chronoUT = ((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements().copier(new FiltreContientDate(p_calendrierExecutionCalcul.getDernierJourIndemnisable()));
      if (!chronoUT.estVide()) {
        ut = (UniteTraitement)chronoUT.premierElement();
      } else {
        ut = (UniteTraitement)((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements().dernierElement();
      }
      QuantiteIndemnisationSpec reliquatQuantiteIndemnisation = OutillageQuantites.recupererPremiereQuantiteIndemnisationActive(ut.getConstituantsIndemnisationEnFinUT().getCollectionQuantiteDroit());
      
      ut = (UniteTraitement)((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements().dernierElement();
      if ((reliquatQuantiteIndemnisation != null) && (reliquatQuantiteIndemnisation.getQuantiteCourante().getValeur().compareTo(new BigDecimal("0")) > 0)) {
        etatDecision = 3;
      } else {
        etatDecision = 2;
      }
      if (ut.getArretProduitAvecRaison().isProduitAEteindre())
      {
        etatDecision = 1;
      }
      else
      {
        Collection collectionPeriodesInterruptives = ut.getArretProduitAvecRaison().getPeriodesInterruptivesDefinitives();
        if (collectionPeriodesInterruptives != null)
        {
          Iterator iterator = collectionPeriodesInterruptives.iterator();
          while (iterator.hasNext())
          {
            ObjetChronoPeriode periode = (ObjetChronoPeriode)iterator.next();
            if (((periode instanceof PeriodeExclusionDefinitiveDDTE)) || ((periode instanceof PeriodeNonMaintienASSetATA))) {
              etatDecision = 1;
            }
          }
        }
      }
    }
    return etatDecision;
  }
  
  public static String recupererCodeFormuleMontant(CalendrierExecutionCalculSpec p_calendrierExecutionCalcul)
    throws CoucheLogiqueException
  {
    String codeFormuleMontant = null;
    UniteTraitement ut = null;
    if ((p_calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique))
    {
      Chronologie chronoUT = ((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements().copier(new FiltreContientDate(p_calendrierExecutionCalcul.getDernierJourIndemnisable()));
      if (!chronoUT.estVide()) {
        ut = (UniteTraitement)chronoUT.premierElement();
      } else {
        ut = (UniteTraitement)((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements().dernierElement();
      }
      QuantiteIndemnisationSpec quantiteIndemnisation = OutillageQuantites.recupererPremiereQuantiteIndemnisationActive(ut.getConstituantsIndemnisationEnFinUT().getCollectionQuantiteDroit());
      if (quantiteIndemnisation != null)
      {
        Quantite quantiteRestantAIndemniser = quantiteIndemnisation.getQuantiteCourante();
        if (quantiteRestantAIndemniser.getValeur().compareTo(new BigDecimal("0")) > 0) {
          codeFormuleMontant = quantiteIndemnisation.getCodeFormuleMontant();
        }
      }
      else
      {
        Iterator iterator = null;
        QuantiteDroitSpec quantite = null;
        
        iterator = ut.getConstituantsIndemnisationEnFinUT().getCollectionQuantiteDroit().iterator();
        while (iterator.hasNext())
        {
          quantite = (QuantiteDroitSpec)iterator.next();
          if (((quantite instanceof QuantiteIndemnisationSpec)) && (quantite.getEtat() == 2))
          {
            codeFormuleMontant = ((QuantiteIndemnisationSpec)quantite).getCodeFormuleMontant();
            if (codeFormuleMontant == null) {
              throw new CoucheLogiqueException("HG_PR_CALI_L_FORMULE_MONTANT_ABSENTE", "Calcul : Formule montant introuvable malgré fin de quantite d'indemnisation", null);
            }
          }
        }
        if (codeFormuleMontant == null) {
          codeFormuleMontant = ut.getConstituantsIndemnisationEnFinUT().getCodeFormuleMontant();
        }
      }
    }
    return codeFormuleMontant;
  }
  
  public static MontantBaseSpec recupererMontant(CalendrierExecutionCalculSpec p_calendrierExecutionCalcul)
    throws CoucheLogiqueException
  {
    MontantBaseSpec montant = null;
    UniteTraitement ut = null;
    if ((p_calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique))
    {
      Chronologie chronoUT = ((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements().copier(new FiltreContientDate(p_calendrierExecutionCalcul.getDernierJourIndemnisable()));
      if (!chronoUT.estVide()) {
        ut = (UniteTraitement)chronoUT.premierElement();
      } else {
        ut = (UniteTraitement)((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements().dernierElement();
      }
      Collection collectionSommes = ut.getCollectionSommes();
      
      Iterator iterator = collectionSommes.iterator();
      while (iterator.hasNext())
      {
        Somme somme = (Somme)iterator.next();
        if (somme.getDateFin().coincideAvec(p_calendrierExecutionCalcul.getDernierJourIndemnisable()))
        {
          montant = somme.getMontant();
          break;
        }
      }
    }
    return montant;
  }
  
  public static QuantiteEuro calculerCapitalIndemnise(CalendrierExecutionCalculSpec p_calendrierExecutionCalcul)
    throws CoucheLogiqueException
  {
    BigDecimal capital = new BigDecimal("0");
    if ((p_calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique))
    {
      Chronologie chronoUT = ((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements();
      
      chronoUT.iterer();
      while (chronoUT.encoreSuivant())
      {
        UniteTraitement ut = (UniteTraitement)chronoUT.elementSuivant();
        
        Collection collectionSommes = ut.getCollectionSommes();
        
        Iterator iterator = collectionSommes.iterator();
        while (iterator.hasNext())
        {
          Somme somme = (Somme)iterator.next();
          capital = capital.add(somme.getNbBase().getValeur().multiply(somme.getMontant().getMontantBrut().getValeur()));
        }
      }
    }
    return new QuantiteEuro(capital.setScale(2));
  }
  
  public static BigDecimal calculerQuantiteIndemnisee(CalendrierExecutionCalculSpec p_calendrierExecutionCalcul)
    throws CoucheLogiqueException
  {
    BigDecimal quantite = new BigDecimal("0");
    if ((p_calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique))
    {
      Chronologie chronoUT = ((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements();
      
      chronoUT.iterer();
      while (chronoUT.encoreSuivant())
      {
        UniteTraitement ut = (UniteTraitement)chronoUT.elementSuivant();
        
        Collection collectionSommes = ut.getCollectionSommes();
        
        Iterator iterator = collectionSommes.iterator();
        while (iterator.hasNext())
        {
          Somme somme = (Somme)iterator.next();
          quantite = quantite.add(somme.getNbBase().getValeur());
        }
      }
    }
    return quantite.setScale(2);
  }
  
  public static Quantite recupererReliquatDureeIndemnisation(CalendrierExecutionCalculSpec p_calendrierExecutionCalcul)
    throws CoucheLogiqueException
  {
    Quantite reliquatDureeIndemnisation = null;
    UniteTraitement ut = null;
    if ((p_calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique))
    {
      Chronologie chronoUT = ((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements().copier(new FiltreContientDate(p_calendrierExecutionCalcul.getDernierJourIndemnisable()));
      if (!chronoUT.estVide()) {
        ut = (UniteTraitement)chronoUT.premierElement();
      } else {
        ut = (UniteTraitement)((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements().dernierElement();
      }
      Collection collectionQuantiteDroit = ut.getConstituantsIndemnisationEnFinUT().getCollectionQuantiteDroit();
      QuantiteIndemnisationSpec quantiteIndemnisation = null;
      if (collectionQuantiteDroit != null)
      {
        Iterator iterator = collectionQuantiteDroit.iterator();
        while (iterator.hasNext())
        {
          QuantiteDroitSpec quantiteDroit = (QuantiteDroitSpec)iterator.next();
          if ((quantiteDroit instanceof QuantiteIndemnisationSpec))
          {
            quantiteIndemnisation = (QuantiteIndemnisationSpec)quantiteDroit;
            if (quantiteDroit.getEtat() == 1) {
              break;
            }
          }
        }
      }
      if (quantiteIndemnisation != null) {
        if (quantiteIndemnisation.getEtat() == 1) {
          reliquatDureeIndemnisation = quantiteIndemnisation.getQuantiteCourante();
        } else if (quantiteIndemnisation.getEtat() == 2) {
          reliquatDureeIndemnisation = new QuantiteJour(new BigDecimal("0"));
        }
      }
    }
    return reliquatDureeIndemnisation;
  }
  
  public static Quantite calculerMontantJourBrutDJI(CalendrierExecutionCalculSpec p_calendrierExecutionCalcul)
  {
    Somme somme = null;
    
    Quantite montantJourBrut = new QuantiteEuro("0");
    if ((p_calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique))
    {
      Chronologie chronoUT = ((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements();
      if (chronoUT != null)
      {
        chronoUT.iterer();
        while (chronoUT.encoreSuivant()) {
          chronoUT.elementSuivant();
        }
        while (chronoUT.encorePrecedent())
        {
          UniteTraitement utNCP = (UniteTraitement)chronoUT.elementPrecedent();
          
          List listeSomme = (List)utNCP.getCollectionSommes();
          if (listeSomme != null) {
            for (int i = listeSomme.size() - 1; i >= 0; i--)
            {
              somme = (Somme)listeSomme.get(i);
              if ((somme != null) && (somme.getMontant() != null) && 
                (somme.getNbBase().getValeurEntiere() != 0)) {
                return somme.getMontant().getMontantBrut();
              }
            }
          }
        }
      }
    }
    return montantJourBrut;
  }
  
  public static UniteTraitement rechercheUtContenantDate(CalendrierExecutionCalculSpec p_calendrierExecutionCalcul, Damj p_dateDansUT)
  {
    UniteTraitement ut = null;
    Chronologie chronologieFiltree = null;
    if (p_calendrierExecutionCalcul != null)
    {
      chronologieFiltree = ((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements().copier(new FiltreContientDate(p_dateDansUT));
      if (chronologieFiltree.getTaille() != 0) {
        ut = (UniteTraitement)chronologieFiltree.premierElement();
      }
    }
    return ut;
  }
  
  public static Periode recupererPeriodePriseEnCompteEvtsReducteurs(AttributionSpec p_attribution, CalendrierExecutionCalculSpec p_calendrierExecutionCalcul, int p_etatAttribution)
    throws CoucheLogiqueException
  {
    Periode periode = new Periode(p_attribution.getDateAttribution(), p_calendrierExecutionCalcul.getDernierJourIndemnisable());
    
    ObjetChronoPeriodePriseEnCharge periodePEC = OutillagePeriodes.recupererPeriodePECContenant(p_attribution.getDemandeur(), p_calendrierExecutionCalcul.getDernierJourIndemnisable());
    if ((periodePEC != null) && (periodePEC.getDateFin().estAvantOuCoincideAvec(p_calendrierExecutionCalcul.getDernierJourIndemnisable().getFinMois()))) {
      periode.setFin(periodePEC.getDateFin());
    } else if (p_etatAttribution == 2) {
      periode.setFin(p_calendrierExecutionCalcul.getDernierJourIndemnisable().getFinMois());
    }
    return periode;
  }
  
  public static int recupererCumulJoursServi(CalendrierExecutionCalculSpec p_calendrierExecutionCalcul)
    throws CoucheLogiqueException
  {
    UniteTraitement ut = null;
    if ((p_calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique))
    {
      Chronologie chronoUT = ((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements().copier(new FiltreContientDate(p_calendrierExecutionCalcul.getDernierJourIndemnisable()));
      if (!chronoUT.estVide()) {
        ut = (UniteTraitement)chronoUT.premierElement();
      } else {
        ut = (UniteTraitement)((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements().dernierElement();
      }
      return ut.getCumulJoursIndemnise();
    }
    return 0;
  }
  
  public static Quantite recupererReliquatDureeFinancement(CalendrierExecutionCalculSpec p_calendrierExecutionCalcul)
    throws CoucheLogiqueException
  {
    Quantite reliquatDureeFinancement = null;
    UniteTraitement ut = null;
    if ((p_calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique))
    {
      Chronologie chronoUT = ((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements().copier(new FiltreContientDate(p_calendrierExecutionCalcul.getDernierJourIndemnisable()));
      if (!chronoUT.estVide()) {
        ut = (UniteTraitement)chronoUT.premierElement();
      } else {
        ut = (UniteTraitement)((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements().dernierElement();
      }
      Collection collectionQuantiteDroit = ut.getConstituantsIndemnisationEnFinUT().getCollectionQuantiteDroit();
      DureeFinancementAbstraite dureeFinancement = null;
      if (collectionQuantiteDroit != null)
      {
        Iterator iterator = collectionQuantiteDroit.iterator();
        while (iterator.hasNext())
        {
          QuantiteDroitSpec quantiteDroit = (QuantiteDroitSpec)iterator.next();
          if ((quantiteDroit instanceof DureeFinancementAbstraite))
          {
            dureeFinancement = (DureeFinancementAbstraite)quantiteDroit;
            if (quantiteDroit.getEtat() == 1) {
              break;
            }
          }
        }
      }
      if (dureeFinancement != null) {
        if (dureeFinancement.getEtat() == 1) {
          reliquatDureeFinancement = dureeFinancement.getQuantiteCourante();
        } else if (dureeFinancement.getEtat() == 2) {
          reliquatDureeFinancement = new QuantiteJour(new BigDecimal("0"));
        }
      }
    }
    return reliquatDureeFinancement;
  }
}

/* Location:
 * Qualified Name:     PostTraitementsHorsGamme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */