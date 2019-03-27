package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.ComportementExamenFilEauSpec;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.StatistiqueExamenAuFilEau;
import fr.unedic.cali.dom.affectation.FacadeLiquidationGammeAsuSpec;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreActiviteSalarieEtantFCT;
import fr.unedic.cali.utilitaire.filtres.composites.FiltreAttributionStandardAssurance;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreFinDansBornes;
import fr.unedic.util.temps.FiltresTemporel;

public class ExamenAuFilEauManager
{
  private static final int NOMBRE_FCT_MAX = 200;
  
  public static Resultat executerExamenFilEau(IndividuSpec p_individu, ComportementExamenFilEauSpec p_comportement)
    throws ApplicativeException
  {
    Damj dateEvenementDeclencheur = p_comportement.getDateEvenementDeclencheur();
    
    Damj dateFct = OutilExamenFilEau.getDateFctApresOuCoincideAvec(p_individu, dateEvenementDeclencheur);
    if (dateFct == null) {
      dateFct = dateEvenementDeclencheur;
    }
    int nbChronoAEtudier = trouverNbChronoAEtudier(p_individu, dateFct);
    
    FacadeLiquidationGammeAsuSpec facade = GammeAsu.getInstance();
    Resultat resultatEfe = null;
    if (nbChronoAEtudier <= 200) {
      try
      {
        resultatEfe = facade.executerExamenFilEau(p_individu, p_comportement, dateFct);
      }
      catch (CoucheLogiqueException exceptionEfe)
      {
        if (p_comportement.getIdentifiantComportement().equals(ComportementExamenFilEauSpec.ID_COMPORTEMENT_EFE_MANUEL)) {
          throw exceptionEfe;
        }
      }
    }
    return resultatEfe;
  }
  
  private static int trouverNbChronoAEtudier(IndividuSpec p_individu, Damj p_dateFct)
  {
    int nbChronoAEtudier = 0;
    Damj dateDebutRecherche = Damj.NUIT_DES_TEMPS;
    DecisionSpec decisionAssurance = OutilRecherche.rechercherDecisionPrecedente(p_individu.getChronoDemandeAssurance(), p_dateFct, new FiltreAttributionStandardAssurance(true, true, false, false, null));
    if (decisionAssurance != null) {
      dateDebutRecherche = decisionAssurance.getDateEffetDecision();
    }
    FiltresTemporel filtre = new FiltresTemporel();
    filtre.ajouterFiltre(new FiltreActiviteSalarieEtantFCT());
    filtre.ajouterFiltre(new FiltreFinDansBornes(dateDebutRecherche, p_dateFct));
    Chronologie passePro = p_individu.getChronoPeriodePasseProfessionnelLiquidation();
    if ((passePro != null) && (!passePro.estVide()))
    {
      Chronologie chronoPasseProFiltre = p_individu.getChronoPeriodePasseProfessionnelLiquidation().copier(filtre);
      if ((chronoPasseProFiltre != null) && (!chronoPasseProFiltre.estVide())) {
        nbChronoAEtudier = chronoPasseProFiltre.getTaille();
      }
    }
    return nbChronoAEtudier;
  }
  
  public static StatistiqueExamenAuFilEau initialiserStatistique(Damj p_dateEvenementDeclencheur, int p_natureEvenementDeclencheur)
  {
    StatistiqueExamenAuFilEau statExamenAuFilEau = new StatistiqueExamenAuFilEau();
    
    statExamenAuFilEau.setDateEvenement(new Damj());
    
    statExamenAuFilEau.setDateEvenementDeclencheur(p_dateEvenementDeclencheur);
    
    statExamenAuFilEau.setNatureDeclencheur(p_natureEvenementDeclencheur);
    
    return statExamenAuFilEau;
  }
  
  public static void mettreAJourStatistiqueFct(StatistiqueExamenAuFilEau p_statExamenAuFilEau, Damj p_dateFct, int p_nbreExamen, boolean p_affiliationSimplifieeSuffisante)
  {
    if (p_statExamenAuFilEau != null)
    {
      if (p_statExamenAuFilEau.getDatePremiereFctEtudiee() == null) {
        p_statExamenAuFilEau.setDatePremiereFctEtudiee(p_dateFct);
      }
      if ((p_statExamenAuFilEau.getDatePremiereFctEtudieeSansAffiSimplifiee() == null) && (p_affiliationSimplifieeSuffisante)) {
        p_statExamenAuFilEau.setDatePremiereFctEtudieeSansAffiSimplifiee(p_dateFct);
      }
      p_statExamenAuFilEau.setDateDerniereFctEtudiee(p_dateFct);
      
      p_statExamenAuFilEau.setNombreTotalFctEtudiees(p_nbreExamen);
    }
  }
  
  public static void mettreAJourStatistiqueResultat(StatistiqueExamenAuFilEau p_statExamenAuFilEau, int p_resultatExamen)
  {
    if (p_statExamenAuFilEau != null) {
      p_statExamenAuFilEau.setResultatExamen(p_resultatExamen);
    }
  }
  
  public static void ajouterStatistiqueSurIndividu(IndividuSpec p_individu, StatistiqueExamenAuFilEau p_statExamenAuFilEau)
  {
    if (p_statExamenAuFilEau != null) {
      p_individu.ajouterStatistiqueExamenAuFilEau(p_statExamenAuFilEau);
    }
  }
}

/* Location:
 * Qualified Name:     ExamenAuFilEauManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */