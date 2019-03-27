package fr.unedic.cali.outilsfonctionnels.reexecution;

import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilComportement;
import fr.unedic.cali.calcul.dom.CalendrierExecutionAvantSpec;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.outilsfonctionnels.OutilGestionPoursuite;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ProduitRbfSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.parcours.ParcoursCalculPilotage;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class OutilDeterminationDateDebutExecution
{
  private static OutilDeterminationDateDebutExecution outilDeterminationDateDebutExecution;
  private static List<String> produitsPatche = new ArrayList();
  private static List<String> produitsExecutionPatche = new ArrayList();
  
  static
  {
    produitsPatche.add("SOL_AER05_01");
    produitsPatche.add("SOL_AER05_02");
    produitsPatche.add("SOL_AER05_03");
    produitsPatche.add("INR_PFM01_01");
    produitsPatche.add("INR_CES06_01");
    produitsPatche.add("INR_RCE04_01");
    produitsPatche.add("INR_PAR09_01");
  }
  
  public static synchronized OutilDeterminationDateDebutExecution getInstance()
  {
    if (outilDeterminationDateDebutExecution == null) {
      outilDeterminationDateDebutExecution = new OutilDeterminationDateDebutExecution();
    }
    return outilDeterminationDateDebutExecution;
  }
  
  public Damj rechercherDateDebutExecution(Damj dateDebutExecution, Damj dateRechercheAttributionAnterieure, boolean estExecutionDepuisPersistance, IndividuSpec individu)
    throws CoucheLogiqueException
  {
    List<AttributionSpec> attributions = recupererLesAttributions(individu, dateRechercheAttributionAnterieure);
    return parcours(attributions, dateDebutExecution, estExecutionDepuisPersistance, individu);
  }
  
  public Damj rechercherDateDebutExecution(List<?> attributions, Damj dateDebutExecution, boolean estExecutionDepuisPersistance, IndividuSpec individu)
    throws CoucheLogiqueException
  {
    return parcours(attributions, dateDebutExecution, estExecutionDepuisPersistance, individu);
  }
  
  private static Damj parcours(List<?> attributions, Damj dateDebutExecution, boolean estExecutionDepuisPersistance, IndividuSpec individu)
    throws CoucheLogiqueException
  {
    List<Damj> dates = constitutionDatesDepartEnvisageablePourLeCalcul(attributions, dateDebutExecution, estExecutionDepuisPersistance);
    
    Damj dateRetenue = determinationDateDepartValidePourTouteAttribution(dates, attributions, dateDebutExecution);
    
    dateRetenue = ajustementDateDossierMigre(individu, dateRetenue);
    
    return dateRetenue;
  }
  
  private static List<AttributionSpec> recupererLesAttributions(IndividuSpec individu, Damj dateRechercheAttributionAnterieure)
  {
    return OutilGestionnaireReexecution.getInstance().recupererAttributionsAReexecuter(individu, dateRechercheAttributionAnterieure != null ? dateRechercheAttributionAnterieure : Damj.FIN_DES_TEMPS, 100, OutilComportement.getComportementParDefaut(), 100, null);
  }
  
  private static List<Damj> constitutionDatesDepartEnvisageablePourLeCalcul(List<?> attributions, Damj dateDebutExecution, boolean estExecutionDepuisPersistance)
    throws CoucheLogiqueException
  {
    List<Damj> dates = new ArrayList();
    
    Iterator<?> iterateur = attributions.iterator();
    while (iterateur.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)iterateur.next();
      CalendrierExecutionCalculSpec calendrierExecutionCalcul = attribution.getCalendrierExecutionCalcul();
      Chronologie unitesTraitementsAvant = recupererChronoUnitesTraitementsAvant(calendrierExecutionCalcul, dateDebutExecution);
      if ((estExecutionDepuisPersistance) && (verifEtatCalendrier(calendrierExecutionCalcul)) && (!unitesTraitementsAvant.estVide()))
      {
        Iterator<?> iterator = unitesTraitementsAvant.iterer();
        while (iterator.hasNext())
        {
          UniteTraitement ut = (UniteTraitement)iterator.next();
          if (ut.getDateFin().estAvant(calendrierExecutionCalcul.getDernierJourIndemnisable())) {
            stockeDateSansDoublon(dates, ut.getDateDebut().getDebutMoisSuivant());
          }
        }
      }
      Damj pje = OutilGestionPoursuite.getInstance().recupererPremierJourExecutableNcp(attribution);
      if (pje != null) {
        stockeDateSansDoublon(dates, pje.getDebutMois());
      }
      stockeDateSansDoublon(dates, attribution.getDateAttribution().getDebutMois());
    }
    return dates;
  }
  
  private static Damj determinationDateDepartValidePourTouteAttribution(List<Damj> dates, List<?> attributions, Damj dateDebutExecution)
  {
    Damj dateRetenue = Damj.FIN_DES_TEMPS;
    
    Collections.sort(dates, Collections.reverseOrder());
    for (int i = 0; i < dates.size(); i++)
    {
      Damj date = (Damj)dates.get(i);
      if (estUneDateValide(dateDebutExecution, date, attributions))
      {
        dateRetenue = date;
        break;
      }
    }
    if (dateRetenue.equals(Damj.FIN_DES_TEMPS)) {
      if (dates.isEmpty())
      {
        dateRetenue = dateDebutExecution.getDebutMois();
      }
      else
      {
        Collections.sort(dates);
        dateRetenue = (Damj)dates.get(0);
      }
    }
    return dateRetenue;
  }
  
  private static Damj ajustementDateDossierMigre(IndividuSpec individu, Damj dateDebutExecution)
    throws CoucheLogiqueException
  {
    Damj dateBorne = bornerParDroitsNeutralises(individu, dateDebutExecution);
    
    return bornerDateDebutExecutionALaDateDeCalculAuPlusTot(individu, dateBorne);
  }
  
  private static Damj bornerParDroitsNeutralises(IndividuSpec individu, Damj dateDebutExecution)
    throws CoucheLogiqueException
  {
    return Damj.max(ParcoursCalculPilotage.determinerLendemainDjiMaxDroitNeutralise(individu, dateDebutExecution), dateDebutExecution);
  }
  
  private static boolean estUneDateValide(Damj dateDebutExecution, Damj date, List<?> attributions)
  {
    return (dateDebutExecution != null) && (date.estAvantOuCoincideAvec(dateDebutExecution)) && (attributionsPeuventEtreCalculees(attributions, date));
  }
  
  private static boolean attributionsPeuventEtreCalculees(List<?> attributions, Damj date)
  {
    Iterator<?> iterateur = attributions.iterator();
    while (iterateur.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)iterateur.next();
      CalendrierExecutionCalculSpec calendrier = attribution.getCalendrierExecutionCalcul();
      CalendrierExecutionAvantSpec calendrierAvant = attribution.getCalendrierExecutionAvant();
      if ((verificationProduitPatche(attribution)) && (verificationDateEntrePjiDji(date, calendrier))) {
        return false;
      }
      if (verificationSiCalAttributionNonCalculable(date, attribution, calendrier, calendrierAvant)) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean verificationSiCalAttributionNonCalculable(Damj date, AttributionSpec attribution, CalendrierExecutionCalculSpec calendrier, CalendrierExecutionAvantSpec calendrierAvant)
  {
    boolean res = false;
    if ("RBF_MOB07_01".equals(attribution.getProduit().getNom()))
    {
      List<AttributionSpec> attributionsAideMob = new ArrayList();
      ProduitRbfSpec produit = (ProduitRbfSpec)attribution.getProduit();
      attributionsAideMob.addAll(produit.recupererListeAttributionsExecutables(attribution));
      for (AttributionSpec attributionSpec : attributionsAideMob) {
        if (verificationSiAttributionNonCalculable(date, attributionSpec, attributionSpec.getCalendrierExecutionCalcul(), attributionSpec.getCalendrierExecutionAvant())) {
          res = true;
        }
      }
    }
    else if (verificationSiAttributionNonCalculable(date, attribution, calendrier, calendrierAvant))
    {
      res = true;
    }
    return res;
  }
  
  private static boolean verificationSiAttributionNonCalculable(Damj date, AttributionSpec attribution, CalendrierExecutionCalculSpec calendrier, CalendrierExecutionAvantSpec calendrierAvant)
  {
    return (!verificationPji(date, attribution)) && (!verificationDjiDja(date, calendrier, calendrierAvant)) && (!estAttributionValide(date, calendrier)) && (!estPfmNonDeclenchee(attribution, calendrier));
  }
  
  private static boolean verifEtatCalendrier(CalendrierExecutionCalculSpec calendrierExecutionCalcul)
  {
    return (calendrierExecutionCalcul != null) && (calendrierExecutionCalcul.getDernierJourIndemnisable() != null) && ((calendrierExecutionCalcul.getEtatAttribution() == 6) || (calendrierExecutionCalcul.getEtatAttribution() == 3));
  }
  
  private static Damj bornerDateDebutExecutionALaDateDeCalculAuPlusTot(IndividuSpec individu, Damj dateDebutExecution)
  {
    Iterator<?> listeAttributions = individu.getListeAttributionsExecutables().iterator();
    while (listeAttributions.hasNext())
    {
      AttributionSpec a = (AttributionSpec)listeAttributions.next();
      if (a.estMigreeEnSimplifiee())
      {
        CalendrierExecutionCalculPeriodique cal = (CalendrierExecutionCalculPeriodique)a.getCalendrierExecutionCalcul();
        if ((cal != null) && (cal.getUTFigee() != null) && (dateDebutExecution.estAvant(cal.getUTFigee().getDateFin().lendemain()))) {
          return cal.getUTFigee().getDateFin().lendemain();
        }
      }
    }
    return dateDebutExecution;
  }
  
  private static boolean estAttributionRedemarrableADate(CalendrierExecutionCalculSpec calendrier, Damj date)
  {
    boolean retour = false;
    if (((CalendrierExecutionCalculPeriodique)calendrier).getChronologieUnitesTraitements() != null)
    {
      Chronologie uniteTraitementCalendrier = ((CalendrierExecutionCalculPeriodique)calendrier).getChronologieUnitesTraitements();
      uniteTraitementCalendrier.iterer();
      if (calendrier.getPremierJourIndemnisable().getDebutMois().estApresOuCoincideAvec(date)) {
        retour = true;
      }
      while ((uniteTraitementCalendrier.encoreSuivant()) && (!retour))
      {
        UniteTraitement ut = (UniteTraitement)uniteTraitementCalendrier.elementSuivant();
        if (date.veille().estContenueDans(ut.getPeriode())) {
          retour = true;
        }
      }
    }
    return retour;
  }
  
  private static Chronologie recupererChronoUnitesTraitementsAvant(CalendrierExecutionCalculSpec calendrierExecutionCalcul, Damj dateLimite)
  {
    Chronologie unitesTraitementsAvant = new ChronologiePeriodes();
    if ((calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique))
    {
      Chronologie chronoUnitesTraitements = ((CalendrierExecutionCalculPeriodique)calendrierExecutionCalcul).getChronologieUnitesTraitements();
      
      Iterator iterUnitesTraitements = chronoUnitesTraitements.iterer();
      while (iterUnitesTraitements.hasNext())
      {
        UniteTraitement uniteTraitement = (UniteTraitement)iterUnitesTraitements.next();
        if ((dateLimite == null) || (uniteTraitement.getDateFin().estAvant(dateLimite))) {
          unitesTraitementsAvant.ajouter(uniteTraitement);
        }
      }
    }
    return unitesTraitementsAvant;
  }
  
  private static void stockeDateSansDoublon(List<Damj> dates, Damj date)
  {
    if (!dates.contains(date)) {
      dates.add(date);
    }
  }
  
  private static boolean verificationPji(Damj date, AttributionSpec attribution)
  {
    return attribution.getPji().estApresOuCoincideAvec(date);
  }
  
  private static boolean verificationDjiDja(Damj date, CalendrierExecutionCalculSpec calendrier, CalendrierExecutionAvantSpec calendrierAvant)
  {
    return (estDjiAvantDate(date, calendrier)) || (estDjaAvantDate(date, calendrier, calendrierAvant));
  }
  
  private static boolean estDjiAvantDate(Damj date, CalendrierExecutionCalculSpec calendrier)
  {
    return (calendrier != null) && (calendrier.getDernierJourIndemnisable().estAvant(date));
  }
  
  private static boolean estDjaAvantDate(Damj date, CalendrierExecutionCalculSpec calendrier, CalendrierExecutionAvantSpec calendrierAvant)
  {
    return (calendrier == null) && (calendrierAvant != null) && (calendrierAvant.getDernierJourAvant().estAvant(date));
  }
  
  private static boolean estAttributionValide(Damj date, CalendrierExecutionCalculSpec calendrier)
  {
    return (calendrier != null) && ((calendrier instanceof CalendrierExecutionCalculPeriodique)) && (estAttributionRedemarrableADate(calendrier, date));
  }
  
  private static boolean estPfmNonDeclenchee(AttributionSpec attribution, CalendrierExecutionCalculSpec calendrier)
  {
    return ("INR_PFM01_01".equals(attribution.getProduit().getNomUnique())) && (calendrier == null);
  }
  
  private static boolean verificationDateEntrePjiDji(Damj date, CalendrierExecutionCalculSpec calendrier)
  {
    return (calendrier != null) && (date.estApres(calendrier.getPremierJourIndemnisable())) && (date.estAvantOuCoincideAvec(calendrier.getDernierJourIndemnisable()));
  }
  
  private static boolean verificationProduitPatche(AttributionSpec attribution)
  {
    return (produitsPatche.contains(attribution.getProduit().getNomUnique())) || (produitsExecutionPatche.contains(attribution.getProduitExecution().getNomUnique()));
  }
}

/* Location:
 * Qualified Name:     OutilDeterminationDateDebutExecution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */