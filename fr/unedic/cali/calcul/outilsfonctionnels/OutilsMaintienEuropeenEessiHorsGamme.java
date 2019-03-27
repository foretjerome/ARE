package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnCharge;
import fr.unedic.cali.calcul.FacadeCalculProduitSpec;
import fr.unedic.cali.calcul.OutillagePeriodes;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.EvenementMaintienEuropeenPJI;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.ElementBaseIndemnisationSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.OutillagePEC;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import java.util.HashMap;
import java.util.Map;

public class OutilsMaintienEuropeenEessiHorsGamme
{
  private static final Map LISTE_ENQUETE_NON_PRODUITE = new HashMap();
  
  static
  {
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(5), Integer.valueOf(5));
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(6), Integer.valueOf(6));
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(7), Integer.valueOf(7));
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(8), Integer.valueOf(8));
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(9), Integer.valueOf(9));
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(10), Integer.valueOf(10));
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(14), Integer.valueOf(14));
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(25), Integer.valueOf(25));
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(26), Integer.valueOf(26));
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(27), Integer.valueOf(27));
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(28), Integer.valueOf(28));
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(29), Integer.valueOf(29));
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(17), Integer.valueOf(17));
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(18), Integer.valueOf(18));
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(19), Integer.valueOf(19));
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(20), Integer.valueOf(20));
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(22), Integer.valueOf(22));
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(35), Integer.valueOf(35));
    LISTE_ENQUETE_NON_PRODUITE.put(Integer.valueOf(34), Integer.valueOf(34));
  }
  
  public static Damj getPjiMaintienEuropeenDuDroit(AttributionSpec attribution)
  {
    Damj dateMaintien = null;
    if (attribution.getCalendrierExecutionCalcul() != null)
    {
      Chronologie listeUts = ((CalendrierExecutionCalculPeriodique)attribution.getCalendrierExecutionCalcul()).getChronologieUnitesTraitements();
      listeUts.iterer();
      while ((listeUts.encoreSuivant()) && (dateMaintien == null))
      {
        UniteTraitement ut = (UniteTraitement)listeUts.elementSuivant();
        if ((ut.getConstituantsIndemnisationEnFinUT() != null) && (ut.getConstituantsIndemnisationEnFinUT().getElementBaseIndemnisationCourant() != null)) {
          dateMaintien = ut.getConstituantsIndemnisationEnFinUT().getElementBaseIndemnisationCourant().getDateMaintienEuropeen();
        }
      }
    }
    return dateMaintien;
  }
  
  public static void mapperPecSurPbjc(PbjcNcp pbjc, ObjetChronoPeriodePriseEnCharge pec)
  {
    if (OutillagePEC.estPecAutreEtatMembreCoordination(pec))
    {
      pbjc.setCodePays(pec.getCodePays());
      if (pec.getContexteEESSI() != null)
      {
        String typePopulation = "";
        if (pec.getContexteEESSI().equals("0")) {
          typePopulation = "";
        } else if (pec.getContexteEESSI().equals("2")) {
          typePopulation = "MO";
        } else if (pec.getContexteEESSI().equals("1")) {
          typePopulation = "ME";
        } else if (pec.getContexteEESSI().equals("3")) {
          typePopulation = "DI";
        }
        pbjc.ajouterTypeSousTypePopulation(typePopulation, "");
      }
    }
  }
  
  public static Damj getDateMaintienEuropeen(ConstituantsIndemnisation constituantsIndemnisation)
  {
    Damj dateMaintienEuropeen = constituantsIndemnisation.getElementBaseIndemnisationCourant().getDateMaintienEuropeen();
    return dateMaintienEuropeen;
  }
  
  public static void controlerEtEmettreEnqueteMaintienEuropeen(AttributionSpec attribution, ConstituantsIndemnisation constituantsIndemnisation, Damj dateDebutChronoPeriodeDebutPec, FacadeCalculProduitSpec facadeCalcul, String categorieAttribution, UniteTraitement ut)
  {
    ElementBaseIndemnisationSpec elementBaseIndemnisation = constituantsIndemnisation.getElementBaseIndemnisationCourant();
    if (getDateMaintienEuropeen(constituantsIndemnisation) == null)
    {
      elementBaseIndemnisation.setDateMaintienEuropeen(dateDebutChronoPeriodeDebutPec);
      
      GestionSuivi.enregistrerEnquetePbjcNcp(attribution, dateDebutChronoPeriodeDebutPec, 31, 0, true, categorieAttribution, facadeCalcul, ut.getConstituantsIndemnisationEnFinUT());
      
      ut.ajouterEvenement(new EvenementMaintienEuropeenPJI(dateDebutChronoPeriodeDebutPec));
    }
  }
  
  public static boolean controlerContexteMaintienEuropeen(IndividuSpec individu, Damj dateDebut)
  {
    ObjetChronoPeriodePriseEnCharge pec = OutillagePeriodes.recupererPeriodePECContenant(individu, dateDebut);
    return !OutillagePEC.estPecAutreEtatMembreCoordination(pec);
  }
  
  public static boolean ajouterGroupeMontantFormation(ConstituantsIndemnisation constituantsIndemnisation, Damj dateFin)
  {
    return (getDateMaintienEuropeen(constituantsIndemnisation) == null) || (dateFin.estAvant(getDateMaintienEuropeen(constituantsIndemnisation)));
  }
  
  public static boolean estProductionEnquetePendantMaintienEuropeen(int type, IndividuSpec individu, Damj dateEnquete)
  {
    if (estUneEnqueteANePasProduirePendantMaintienEuropeen(type)) {
      return controlerContexteMaintienEuropeen(individu, dateEnquete);
    }
    return true;
  }
  
  private static boolean estUneEnqueteANePasProduirePendantMaintienEuropeen(int type)
  {
    return LISTE_ENQUETE_NON_PRODUITE.get(Integer.valueOf(type)) != null;
  }
}

/* Location:
 * Qualified Name:     OutilsMaintienEuropeenEessiHorsGamme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */