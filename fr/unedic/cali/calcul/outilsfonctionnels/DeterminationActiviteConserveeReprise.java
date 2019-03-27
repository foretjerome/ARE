package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.dom.DeclareTravail;
import fr.unedic.cali.autresdoms.ga.dom.Entreprise;
import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import fr.unedic.cali.calcul.dom.EvenementBlocageActiviteConservee;
import fr.unedic.cali.calcul.dom.EvenementCalculSpec;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.UniteTraitementForcee;
import fr.unedic.cali.calcul.dom.periode.PansSpec;
import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;
import fr.unedic.cali.calcul.dom.periode.PeriodePrime;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalcul;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.Anomalie;
import fr.unedic.cali.outilsfonctionnels.GestionAnomalies;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import java.util.Collection;
import java.util.Iterator;

public class DeterminationActiviteConserveeReprise
{
  private static Chronologie determinerPeriodesConserveesUtilisees(Chronologie chronoPeriodesConserveesLiq, String identifiantEmployeur, String identifiant)
  {
    Chronologie chronoActiviteConserveesUtilisees = new ChronologiePeriodes();
    if (identifiantEmployeur != null)
    {
      chronoPeriodesConserveesLiq.iterer();
      while (chronoPeriodesConserveesLiq.encoreSuivant())
      {
        TravailSpec periodeConserveeLiq = (TravailSpec)chronoPeriodesConserveesLiq.elementSuivant();
        if ((!(periodeConserveeLiq instanceof DeclareTravail)) && (identifiantEmployeur.equals(periodeConserveeLiq.getEntreprise().getIdentifiantBNE()))) {
          chronoActiviteConserveesUtilisees.ajouter(periodeConserveeLiq);
        }
      }
    }
    return chronoActiviteConserveesUtilisees;
  }
  
  public static void genereEvenementBlocageActiviteConservee(UniteTraitement ut, IndividuSpec individu)
    throws CoucheLogiqueException
  {
    GestionAnomalies.ajouteAnomalie(new Anomalie("M03", ut.getDateDebut(), ""), individu);
    ajouterEvenementSurUt(ut);
  }
  
  public static void genereAnomalieEvenementBlocageActiviteConservee(UniteTraitement ut, IndividuSpec individu)
    throws CoucheLogiqueException
  {
    GestionAnomalies.ajouteAnomalie(new Anomalie("M12", ut.getDateDebut(), ""), individu);
    ajouterEvenementSurUt(ut);
  }
  
  public static void genereAlerteEvenementBlocageActiviteConservee(UniteTraitement ut, IndividuSpec individu)
    throws CoucheLogiqueException
  {
    GestionAnomalies.ajouteAnomalie(new Anomalie("I04", ut.getDateDebut(), ""), individu);
  }
  
  private static void ajouterEvenementSurUt(UniteTraitement ut)
  {
    Collection evtUT = ut.getCollectionEvenements();
    boolean evtDejaSurUt = false;
    if (evtUT != null)
    {
      Iterator itEvtUT = evtUT.iterator();
      while (itEvtUT.hasNext())
      {
        EvenementCalculSpec evtCalcul = (EvenementCalculSpec)itEvtUT.next();
        if ((evtCalcul instanceof EvenementBlocageActiviteConservee)) {
          evtDejaSurUt = true;
        }
      }
    }
    if (!evtDejaSurUt) {
      ut.ajouterEvenement(new EvenementBlocageActiviteConservee(ut.getDateDebut()));
    }
  }
  
  public static boolean determinerTypeActivite(Chronologie chronoPeriodesConserveesLiq, UniteTraitement ut, ObjetChronoPeriodeCalcul periodeTravailCalcul, AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    boolean periodeAIgnorer = false;
    boolean estPeriodeConservee = false;
    
    DemandeSpec demande = attribution.getDemande();
    if ((chronoPeriodesConserveesLiq != null) && (!chronoPeriodesConserveesLiq.estVide())) {
      if ((periodeTravailCalcul instanceof PeriodePrime))
      {
        PeriodePrime periodePrime = (PeriodePrime)periodeTravailCalcul;
        if (periodePrime.getIdentifiantEmployeur() != null)
        {
          Chronologie periodesConserveesUtilisees = determinerPeriodesConserveesUtilisees(chronoPeriodesConserveesLiq, periodePrime.getIdentifiantEmployeur(), periodePrime.getIdentifiant());
          
          periodesConserveesUtilisees.iterer();
          while ((periodesConserveesUtilisees.encoreSuivant()) && (!estPeriodeConservee))
          {
            TravailSpec periodeConserveeUtilisee = (TravailSpec)periodesConserveesUtilisees.elementSuivant();
            if (periodePrime.chevauche(periodeConserveeUtilisee.getPeriode()))
            {
              periodePrime.setTypeActivite(1);
              estPeriodeConservee = true;
            }
          }
        }
        else
        {
          boolean estChevauchante = estPeriodeChevauchantActiviteConservee(chronoPeriodesConserveesLiq, periodePrime);
          if (estChevauchante) {
            periodePrime.setTypeActivite(1);
          }
          if ((estChevauchante) && ((!demande.estMigree()) || (!periodePrime.estMigree())))
          {
            UniteTraitementForcee utForcee = GestionForcage.getUniteTraitementForcee(demande, ut.getDateDebut(), ut.getDateFin(), false);
            if ((utForcee == null) || (!utForcee.isCreditDecalageForce()))
            {
              periodeAIgnorer = true;
              genereEvenementBlocageActiviteConservee(ut, attribution.getDemandeur());
            }
          }
          else if (estChevauchante)
          {
            periodePrime.setTypeActivite(2);
          }
        }
      }
      else if ((periodeTravailCalcul instanceof PeriodeActiviteEmploiCalcul))
      {
        PeriodeActiviteEmploiCalcul periodeActiviteEmploiCalcul = (PeriodeActiviteEmploiCalcul)periodeTravailCalcul;
        if (periodeActiviteEmploiCalcul.getIdentifiantEmployeur() != null)
        {
          Chronologie periodesConserveesUtilisees = determinerPeriodesConserveesUtilisees(chronoPeriodesConserveesLiq, periodeActiviteEmploiCalcul.getIdentifiantEmployeur(), periodeActiviteEmploiCalcul.getIdentifiant());
          if (!periodesConserveesUtilisees.estVide())
          {
            periodesConserveesUtilisees.iterer();
            while ((periodesConserveesUtilisees.encoreSuivant()) && (!estPeriodeConservee))
            {
              TravailSpec periodeConserveeUtilisee = (TravailSpec)periodesConserveesUtilisees.elementSuivant();
              if (((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).chevauche(periodeConserveeUtilisee.getPeriode()))
              {
                ((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).setTypeActivite(1);
                ((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).setDateDebutActiviteConservee(periodeConserveeUtilisee.getDateDebut());
                
                estPeriodeConservee = true;
              }
              else
              {
                ((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).setTypeActivite(2);
              }
            }
          }
          ((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).setTypeActivite(2);
        }
        else
        {
          UniteTraitementForcee utForcee = GestionForcage.getUniteTraitementForcee(demande, ut.getDateDebut(), ut.getDateFin(), false);
          if ((utForcee != null) && (utForcee.isCreditDecalageForce()))
          {
            ((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).setTypeActivite(2);
          }
          else
          {
            boolean estPeriodeChevauchante = false;
            chronoPeriodesConserveesLiq.iterer();
            while ((chronoPeriodesConserveesLiq.encoreSuivant()) && (!estPeriodeChevauchante))
            {
              TravailSpec periodeConserveeLiq = (TravailSpec)chronoPeriodesConserveesLiq.elementSuivant();
              if (((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).chevauche(periodeConserveeLiq.getPeriode()))
              {
                estPeriodeChevauchante = true;
                if (demande.estMigree())
                {
                  ((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).setTypeActivite(1);
                  ((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).setDateDebutActiviteConservee(periodeConserveeLiq.getDateDebut());
                }
              }
            }
            if ((estPeriodeChevauchante) && ((!demande.estMigree()) || (!((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).estMigree())))
            {
              periodeAIgnorer = true;
              genereEvenementBlocageActiviteConservee(ut, attribution.getDemandeur());
            }
            else if (!estPeriodeChevauchante)
            {
              ((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).setTypeActivite(2);
            }
          }
        }
      }
      else if ((periodeTravailCalcul instanceof PansSpec))
      {
        chronoPeriodesConserveesLiq.iterer();
        while ((chronoPeriodesConserveesLiq.encoreSuivant()) && (!estPeriodeConservee))
        {
          TravailSpec periodeConserveeLiq = (TravailSpec)chronoPeriodesConserveesLiq.elementSuivant();
          if (periodeConserveeLiq != null)
          {
            if (periodeConserveeLiq.getIdentifiant().equals(((PansSpec)periodeTravailCalcul).getIdentifiant()))
            {
              estPeriodeConservee = true;
              ((PansSpec)periodeTravailCalcul).setTypeActivite(1);
              ((PansSpec)periodeTravailCalcul).setDateDebutActiviteConservee(periodeConserveeLiq.getDateDebut());
            }
            else
            {
              ((PansSpec)periodeTravailCalcul).setTypeActivite(2);
            }
          }
          else {
            ((PansSpec)periodeTravailCalcul).setTypeActivite(2);
          }
        }
      }
    }
    return periodeAIgnorer;
  }
  
  private static boolean estPeriodeChevauchantActiviteConservee(Chronologie chronoPeriodesConserveesLiq, ObjetChronoPeriodeCalcul periodeTravailCalcul)
  {
    boolean estPeriodeChevauchante = false;
    chronoPeriodesConserveesLiq.iterer();
    while ((chronoPeriodesConserveesLiq.encoreSuivant()) && (!estPeriodeChevauchante))
    {
      TravailSpec periodeConserveeLiq = (TravailSpec)chronoPeriodesConserveesLiq.elementSuivant();
      if (((PeriodePrime)periodeTravailCalcul).chevauche(periodeConserveeLiq.getPeriode())) {
        estPeriodeChevauchante = true;
      }
    }
    return estPeriodeChevauchante;
  }
  
  public static boolean determinerTypeActivitePourAvant(Chronologie chronoPeriodesConserveesLiq, ObjetChronoPeriodeCalcul periodeTravailCalcul, AttributionSpec attribution)
  {
    boolean periodeAIgnorer = false;
    boolean estPeriodeConservee = false;
    DemandeSpec demande = attribution.getDemande();
    if ((chronoPeriodesConserveesLiq != null) && (!chronoPeriodesConserveesLiq.estVide())) {
      if ((periodeTravailCalcul instanceof PeriodePrime))
      {
        PeriodePrime periodePrime = (PeriodePrime)periodeTravailCalcul;
        if (periodePrime.getIdentifiantEmployeur() != null)
        {
          Chronologie periodesConserveesUtilisees = determinerPeriodesConserveesUtilisees(chronoPeriodesConserveesLiq, periodePrime.getIdentifiantEmployeur(), periodePrime.getIdentifiant());
          
          periodesConserveesUtilisees.iterer();
          while ((periodesConserveesUtilisees.encoreSuivant()) && (!estPeriodeConservee))
          {
            TravailSpec periodeConserveeUtilisee = (TravailSpec)periodesConserveesUtilisees.elementSuivant();
            if (periodePrime.chevauche(periodeConserveeUtilisee.getPeriode()))
            {
              periodePrime.setTypeActivite(1);
              estPeriodeConservee = true;
            }
          }
        }
        else
        {
          boolean estChevauchante = estPeriodeChevauchantActiviteConservee(chronoPeriodesConserveesLiq, periodePrime);
          if (estChevauchante)
          {
            periodePrime.setTypeActivite(1);
            estPeriodeConservee = true;
          }
        }
      }
      else if ((periodeTravailCalcul instanceof PeriodeActiviteEmploiCalcul))
      {
        PeriodeActiviteEmploiCalcul periodeActiviteEmploiCalcul = (PeriodeActiviteEmploiCalcul)periodeTravailCalcul;
        if (periodeActiviteEmploiCalcul.getIdentifiantEmployeur() != null)
        {
          Chronologie periodesConserveesUtilisees = determinerPeriodesConserveesUtilisees(chronoPeriodesConserveesLiq, periodeActiviteEmploiCalcul.getIdentifiantEmployeur(), periodeActiviteEmploiCalcul.getIdentifiant());
          if (!periodesConserveesUtilisees.estVide())
          {
            periodesConserveesUtilisees.iterer();
            while ((periodesConserveesUtilisees.encoreSuivant()) && (!estPeriodeConservee))
            {
              TravailSpec periodeConserveeUtilisee = (TravailSpec)periodesConserveesUtilisees.elementSuivant();
              if (((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).chevauche(periodeConserveeUtilisee.getPeriode()))
              {
                ((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).setTypeActivite(1);
                ((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).setDateDebutActiviteConservee(periodeConserveeUtilisee.getDateDebut());
                estPeriodeConservee = true;
              }
              else
              {
                ((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).setTypeActivite(2);
              }
            }
          }
          ((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).setTypeActivite(2);
        }
        else
        {
          boolean estPeriodeChevauchante = false;
          chronoPeriodesConserveesLiq.iterer();
          while ((chronoPeriodesConserveesLiq.encoreSuivant()) && (!estPeriodeChevauchante))
          {
            TravailSpec periodeConserveeLiq = (TravailSpec)chronoPeriodesConserveesLiq.elementSuivant();
            if (((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).chevauche(periodeConserveeLiq.getPeriode()))
            {
              estPeriodeChevauchante = true;
              if (demande.estMigree())
              {
                ((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).setTypeActivite(1);
                ((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).setDateDebutActiviteConservee(periodeConserveeLiq.getDateDebut());
              }
            }
          }
          if ((estPeriodeChevauchante) && ((!demande.estMigree()) || (!((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).estMigree()))) {
            periodeAIgnorer = true;
          } else if (!estPeriodeChevauchante) {
            ((PeriodeActiviteEmploiCalcul)periodeTravailCalcul).setTypeActivite(2);
          }
        }
      }
      else if ((periodeTravailCalcul instanceof PansSpec))
      {
        chronoPeriodesConserveesLiq.iterer();
        while ((chronoPeriodesConserveesLiq.encoreSuivant()) && (!estPeriodeConservee))
        {
          TravailSpec periodeConserveeLiq = (TravailSpec)chronoPeriodesConserveesLiq.elementSuivant();
          if (periodeConserveeLiq != null)
          {
            if (periodeConserveeLiq.getIdentifiant().equals(((PansSpec)periodeTravailCalcul).getIdentifiant()))
            {
              estPeriodeConservee = true;
              ((PansSpec)periodeTravailCalcul).setTypeActivite(1);
              ((PansSpec)periodeTravailCalcul).setDateDebutActiviteConservee(periodeConserveeLiq.getDateDebut());
            }
            else
            {
              ((PansSpec)periodeTravailCalcul).setTypeActivite(2);
            }
          }
          else {
            ((PansSpec)periodeTravailCalcul).setTypeActivite(2);
          }
        }
      }
    }
    return (periodeAIgnorer) || (estPeriodeConservee);
  }
}

/* Location:
 * Qualified Name:     DeterminationActiviteConserveeReprise
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */