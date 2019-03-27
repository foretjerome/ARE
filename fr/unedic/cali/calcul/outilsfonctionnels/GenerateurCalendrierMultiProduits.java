package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.calcul.dom.CalendrierExecutionAvant;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPonctuel;
import fr.unedic.cali.calcul.dom.EvenementPaiementProduitPonctuel;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.UniteTraitementAvant;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.UniteTraitementMultiProduits;
import fr.unedic.cali.parcours.ResultatDetailleProduit;
import fr.unedic.cali.parcours.ResultatPilotage;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieStandard;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.ObjetChronoPeriodeConcrete;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenerateurCalendrierMultiProduits
{
  public static Chronologie transformeResultatVersChronologieUniteTraitementMultiProduits(ResultatPilotage p_resultat)
  {
    ChronologieStandard chronoUTsMultiProduits = new ChronologieStandard();
    
    List resultatsDetaillesProduit = getResultatsDetaillesSatisfaits(p_resultat);
    
    Damj dateFinCalcul = getDernierePeriode(resultatsDetaillesProduit).getDateFin();
    
    Damj dateDebutUT = getPremierePeriode(resultatsDetaillesProduit).getDateDebut();
    Damj dateFinUT = dateDebutUT.getFinMois();
    do
    {
      UniteTraitementMultiProduits utMultiProduits = construitUTMultiProduits(resultatsDetaillesProduit, new Periode(dateDebutUT, dateFinUT));
      chronoUTsMultiProduits.ajouter(utMultiProduits);
      
      dateDebutUT = dateFinUT.getDebutMoisSuivant();
      dateFinUT = dateDebutUT.getFinMois();
    } while (dateFinUT.estAvantOuCoincideAvec(dateFinCalcul));
    return chronoUTsMultiProduits;
  }
  
  private static UniteTraitementMultiProduits construitUTMultiProduits(List p_resultatsDetaillesProduit, Periode p_periode)
  {
    UniteTraitementMultiProduits utMultiProduits = new UniteTraitementMultiProduits(p_periode);
    
    Iterator it = p_resultatsDetaillesProduit.iterator();
    while (it.hasNext())
    {
      UniteTraitement ut = null;
      UniteTraitementAvant utAvant = null;
      ResultatDetailleProduit resultat = (ResultatDetailleProduit)it.next();
      if ((resultat.getCalendrierExecutionCalcul() instanceof CalendrierExecutionCalculPeriodique))
      {
        Chronologie chronoUTs = ((CalendrierExecutionCalculPeriodique)resultat.getCalendrierExecutionCalcul()).getChronologieUnitesTraitements();
        
        ut = (UniteTraitement)filtreChronologieSurPeriode(chronoUTs, p_periode);
        if (ut != null) {
          utMultiProduits.addUTProduitPeriodique(ut, resultat.getAttribution());
        }
      }
      else if ((resultat.getCalendrierExecutionCalcul() instanceof CalendrierExecutionCalculPonctuel))
      {
        EvenementPaiementProduitPonctuel evt = ((CalendrierExecutionCalculPonctuel)resultat.getCalendrierExecutionCalcul()).getEvenementPaiementProduitPonctuel();
        if (p_periode.contient(evt.getDateDePaiement())) {
          utMultiProduits.addEvtProduitPonctuel(evt, resultat.getAttribution());
        }
      }
      if ((resultat.getCalendrierExecutionAvantCalcul() instanceof CalendrierExecutionAvant))
      {
        Chronologie chronoUTs = ((CalendrierExecutionAvant)resultat.getCalendrierExecutionAvantCalcul()).getChronologieUnitesTraitements();
        
        utAvant = (UniteTraitementAvant)filtreChronologieSurPeriode(chronoUTs, p_periode);
        if (utAvant != null) {
          utMultiProduits.addUTAvantProduit(utAvant, resultat.getAttribution());
        }
      }
    }
    return utMultiProduits;
  }
  
  private static ObjetChronoPeriode filtreChronologieSurPeriode(Chronologie p_chrono, Periode p_periode)
  {
    p_chrono.iterer();
    while (p_chrono.encoreSuivant())
    {
      ObjetChronoPeriode objetChronoPeriode = (ObjetChronoPeriode)p_chrono.elementSuivant();
      Periode p = new Periode(objetChronoPeriode.getDateDebut(), objetChronoPeriode.getDateFin());
      if (p.coincideAvec(p_periode)) {
        return objetChronoPeriode;
      }
    }
    return null;
  }
  
  private static ObjetChronoPeriode getDernierePeriode(List p_resultatsDetaillesProduit)
  {
    ObjetChronoPeriode dernierePeriode = null;
    
    Iterator it = p_resultatsDetaillesProduit.iterator();
    while (it.hasNext())
    {
      ResultatDetailleProduit resultat = (ResultatDetailleProduit)it.next();
      
      ObjetChronoPeriode dernierePeriodeDecision = null;
      if ((resultat.getCalendrierExecutionAvantCalcul() != null) && (((CalendrierExecutionAvant)resultat.getCalendrierExecutionAvantCalcul()).getChronologieUnitesTraitements() != null) && (!((CalendrierExecutionAvant)resultat.getCalendrierExecutionAvantCalcul()).getChronologieUnitesTraitements().estVide())) {
        dernierePeriodeDecision = (ObjetChronoPeriode)((CalendrierExecutionAvant)resultat.getCalendrierExecutionAvantCalcul()).getChronologieUnitesTraitements().dernierElement();
      }
      if ((resultat.getCalendrierExecutionCalcul() instanceof CalendrierExecutionCalculPeriodique))
      {
        dernierePeriodeDecision = (ObjetChronoPeriode)((CalendrierExecutionCalculPeriodique)resultat.getCalendrierExecutionCalcul()).getChronologieUnitesTraitements().dernierElement();
      }
      else if ((resultat.getCalendrierExecutionCalcul() instanceof CalendrierExecutionCalculPonctuel))
      {
        Damj dateProduit = ((CalendrierExecutionCalculPonctuel)resultat.getCalendrierExecutionCalcul()).getEvenementPaiementProduitPonctuel().getDateDePaiement();
        
        dernierePeriodeDecision = new ObjetChronoPeriodeConcrete(dateProduit.getDebutMois(), dateProduit.getFinMois());
      }
      if ((dernierePeriode == null) || ((dernierePeriodeDecision != null) && (dernierePeriodeDecision.getDateFin().estApres(dernierePeriode.getDateFin())))) {
        dernierePeriode = dernierePeriodeDecision;
      }
    }
    return dernierePeriode;
  }
  
  private static ObjetChronoPeriode getPremierePeriode(List p_resultatsDetaillesProduit)
  {
    ObjetChronoPeriode premierePeriode = null;
    
    Iterator it = p_resultatsDetaillesProduit.iterator();
    while (it.hasNext())
    {
      ResultatDetailleProduit resultat = (ResultatDetailleProduit)it.next();
      ObjetChronoPeriode premierePeriodeDecision = null;
      if ((resultat.getCalendrierExecutionCalcul() instanceof CalendrierExecutionCalculPeriodique))
      {
        premierePeriodeDecision = (ObjetChronoPeriode)((CalendrierExecutionCalculPeriodique)resultat.getCalendrierExecutionCalcul()).getChronologieUnitesTraitements().premierElement();
      }
      else if ((resultat.getCalendrierExecutionCalcul() instanceof CalendrierExecutionCalculPonctuel))
      {
        Damj dateProduit = ((CalendrierExecutionCalculPonctuel)resultat.getCalendrierExecutionCalcul()).getEvenementPaiementProduitPonctuel().getDateDePaiement();
        
        premierePeriodeDecision = new ObjetChronoPeriodeConcrete(dateProduit.getDebutMois(), dateProduit.getFinMois());
      }
      if ((resultat.getCalendrierExecutionAvantCalcul() != null) && ((resultat.getCalendrierExecutionAvantCalcul() instanceof CalendrierExecutionAvant)) && (((CalendrierExecutionAvant)resultat.getCalendrierExecutionAvantCalcul()).getChronologieUnitesTraitements() != null) && (!((CalendrierExecutionAvant)resultat.getCalendrierExecutionAvantCalcul()).getChronologieUnitesTraitements().estVide())) {
        premierePeriodeDecision = (ObjetChronoPeriode)((CalendrierExecutionAvant)resultat.getCalendrierExecutionAvantCalcul()).getChronologieUnitesTraitements().premierElement();
      }
      if ((premierePeriode == null) || ((premierePeriodeDecision != null) && (premierePeriodeDecision.getDateDebut().estAvant(premierePeriode.getDateDebut())))) {
        premierePeriode = premierePeriodeDecision;
      }
    }
    return premierePeriode;
  }
  
  private static List getResultatsDetaillesSatisfaits(ResultatPilotage p_resultat)
  {
    List resultatDetaillesValides = new ArrayList();
    
    Iterator it = p_resultat.getResultatsDetailles().iterator();
    while (it.hasNext())
    {
      ResultatDetailleProduit resultat = (ResultatDetailleProduit)it.next();
      if (resultat.getEtat() == 0) {
        resultatDetaillesValides.add(resultat);
      }
    }
    return resultatDetaillesValides;
  }
}

/* Location:
 * Qualified Name:     GenerateurCalendrierMultiProduits
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */