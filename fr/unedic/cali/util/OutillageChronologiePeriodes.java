package fr.unedic.cali.util;

import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.ComparateurTemporelsSurDateDebut;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreChevauchePeriode;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.ObjetChronoPeriodeConcrete;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public final class OutillageChronologiePeriodes
{
  public static final int PREMIER_MOIS_ANNEE = 1;
  public static final int DERNIER_MOIS_ANNEE = 12;
  public static final int PREMIER_JOUR_ANNEE = 1;
  public static final int DERNIER_JOUR_ANNEE = 31;
  
  public static ChronologiePeriodes donnerPeriodesComplementaires(ChronologiePeriodes chronoAParcourir, Periode periodeReference)
  {
    ChronologiePeriodes chronoPeriodesComplementaires = new ChronologiePeriodes();
    if (periodeReference != null) {
      if ((chronoAParcourir == null) || (chronoAParcourir.estVide()) || (periodeReference.inter(chronoAParcourir) == 0))
      {
        chronoPeriodesComplementaires.ajouter(new ObjetChronoPeriodeConcrete(periodeReference));
      }
      else
      {
        Damj dateFinobjetChronoPeriodePrecedent = periodeReference.getDebut().veille();
        
        ChronologiePeriodes chronoPeriodesFusionneesAParcourir = null;
        if (chronoAParcourir.contientChevauchementElements()) {
          chronoPeriodesFusionneesAParcourir = chronoAParcourir.fusionnerChevauchementPeriodes();
        } else {
          chronoPeriodesFusionneesAParcourir = (ChronologiePeriodes)chronoAParcourir.clone();
        }
        chronoPeriodesFusionneesAParcourir.setComparateur(new ComparateurTemporelsSurDateDebut());
        ObjetChronoPeriode objetChronoPeriodeCourant = null;
        Periode periodeComplementaire = null;
        chronoPeriodesFusionneesAParcourir.iterer();
        while (chronoPeriodesFusionneesAParcourir.encoreSuivant())
        {
          objetChronoPeriodeCourant = (ObjetChronoPeriode)chronoPeriodesFusionneesAParcourir.elementSuivant();
          if (objetChronoPeriodeCourant.getDateDebut().estApres(dateFinobjetChronoPeriodePrecedent.lendemain()))
          {
            periodeComplementaire = periodeReference.periodeIntersection(new Periode(dateFinobjetChronoPeriodePrecedent.lendemain(), objetChronoPeriodeCourant.getDateDebut().veille()));
            if (periodeComplementaire != null) {
              chronoPeriodesComplementaires.ajouter(new ObjetChronoPeriodeConcrete(periodeComplementaire));
            }
          }
          dateFinobjetChronoPeriodePrecedent = objetChronoPeriodeCourant.getDateFin();
        }
        if (dateFinobjetChronoPeriodePrecedent.estAvant(periodeReference.getFin()))
        {
          periodeComplementaire = new Periode(dateFinobjetChronoPeriodePrecedent.lendemain(), periodeReference.getFin());
          chronoPeriodesComplementaires.ajouter(new ObjetChronoPeriodeConcrete(periodeComplementaire));
        }
      }
    }
    return chronoPeriodesComplementaires;
  }
  
  public static List decouper(Periode periodeReference, Chronologie listeObjetChronoPeriode)
  {
    FiltreTemporel filtre = new FiltreChevauchePeriode(periodeReference);
    Chronologie listeObjetsParticipants = listeObjetChronoPeriode.copier(filtre);
    
    SortedSet listeEvenements = constituerEvenements(periodeReference, listeObjetsParticipants);
    
    return constituerListePeriode(listeEvenements);
  }
  
  public static SortedSet constituerEvenements(Periode periodeReference, Chronologie chronoPeriodes)
  {
    SortedSet listeEvenements = new TreeSet();
    for (Iterator iter = chronoPeriodes.iterer(); iter.hasNext();)
    {
      ObjetChronoPeriode objetChronoPeriode = (ObjetChronoPeriode)iter.next();
      
      Damj date = objetChronoPeriode.getDateDebut();
      if (date.estContenueDans(periodeReference)) {
        listeEvenements.add(new EvenementPeriode(date, 1));
      }
      date = objetChronoPeriode.getDateFin();
      if (date.estContenueDans(periodeReference)) {
        listeEvenements.add(new EvenementPeriode(date, 2));
      }
    }
    listeEvenements.add(new EvenementPeriode(periodeReference.getDebut(), 1));
    listeEvenements.add(new EvenementPeriode(periodeReference.getFin(), 2));
    
    return listeEvenements;
  }
  
  public static List constituerListePeriode(SortedSet listeEvenements)
  {
    List listePeriode = new ArrayList();
    
    Iterator iter = listeEvenements.iterator();
    EvenementPeriode evtPrec = (EvenementPeriode)iter.next();
    while (iter.hasNext())
    {
      EvenementPeriode evtCourant = (EvenementPeriode)iter.next();
      Damj dateDebut;
      Damj dateDebut;
      if (evtPrec.getTypeEvenement() == 1) {
        dateDebut = evtPrec.getDate();
      } else {
        dateDebut = evtPrec.getDate().lendemain();
      }
      Damj dateFin;
      Damj dateFin;
      if (evtCourant.getTypeEvenement() == 1) {
        dateFin = evtCourant.getDate().veille();
      } else {
        dateFin = evtCourant.getDate();
      }
      if (dateFin.estApresOuCoincideAvec(dateDebut))
      {
        Periode periode = new Periode(dateDebut, dateFin);
        listePeriode.add(periode);
      }
      evtPrec = evtCourant;
    }
    return listePeriode;
  }
  
  public static ChronologiePeriodes projeterPeriodesSurUneAnnee(ChronologiePeriodes chrono, int annee)
  {
    int anneeDebut = chrono.premierElement().getDateDebut().getAnnee();
    
    ChronologiePeriodes chronoPeriodeActivite = new ChronologiePeriodes();
    for (int i = anneeDebut; i <= annee; i++)
    {
      Periode periodeReferenceAnnee = new Periode(new Damj(i, 1, 1), new Damj(i, 12, 31));
      
      ChronologiePeriodes chronoFiltreAnneeCourante = (ChronologiePeriodes)chrono.copier(new FiltreChevauchePeriode(periodeReferenceAnnee));
      chronoFiltreAnneeCourante.iterer();
      while (chronoFiltreAnneeCourante.encoreSuivant())
      {
        ObjetChronoPeriode periodeCourante = (ObjetChronoPeriode)chronoFiltreAnneeCourante.elementSuivant();
        
        Periode periodeAnnee = periodeCourante.periodeIntersection(periodeReferenceAnnee);
        
        Damj dateDebutPeriodeProjetee = new Damj(annee, periodeAnnee.getDebut().getMois(), periodeAnnee.getDebut().getJour());
        Damj dateFinPeriodeProjetee = new Damj(annee, periodeAnnee.getFin().getMois(), periodeAnnee.getFin().getJour());
        Periode periodeProjetee = new Periode(dateDebutPeriodeProjetee, dateFinPeriodeProjetee);
        ObjetChronoPeriodeConcrete objetChrono = new ObjetChronoPeriodeConcrete(periodeProjetee);
        
        chronoPeriodeActivite.ajouter(objetChrono);
      }
    }
    return chronoPeriodeActivite.fusionnerChevauchementPeriodes();
  }
  
  public static ChronologiePeriodes fusionnerPeriodesAccolees(ChronologiePeriodes chrono)
  {
    ChronologiePeriodes chronoFinale = new ChronologiePeriodes();
    ObjetChronoPeriode periodeCourante = null;
    ObjetChronoPeriode periodeFusionnerCourante = null;
    Iterator itChrono = chrono.iterer();
    periodeFusionnerCourante = (ObjetChronoPeriode)itChrono.next();
    while (itChrono.hasNext())
    {
      periodeCourante = (ObjetChronoPeriode)itChrono.next();
      if (periodeFusionnerCourante.getDateFin().lendemain().coincideAvec(periodeCourante.getDateDebut()))
      {
        periodeFusionnerCourante.setDateFin(periodeCourante.getDateFin());
      }
      else
      {
        chronoFinale.ajouter(periodeFusionnerCourante);
        periodeFusionnerCourante = new ObjetChronoPeriodeConcrete(periodeCourante.getDateDebut(), periodeCourante.getDateFin());
      }
    }
    chronoFinale.ajouter(periodeFusionnerCourante);
    return chronoFinale;
  }
  
  public static Chronologie intersection(Chronologie chrono1, Chronologie chrono2)
  {
    Chronologie intersection = new ChronologiePeriodes();
    Iterator<Temporel> iterateurCollection1 = null;
    Iterator<Temporel> iterateurCollection2 = null;
    Temporel item = null;
    Temporel item2 = null;
    Periode periode = null;
    Periode periode2 = null;
    Periode periodeInter = null;
    if ((chrono1 != null) && (chrono2 != null))
    {
      iterateurCollection1 = chrono1.iterer();
      while (iterateurCollection1.hasNext())
      {
        item = (Temporel)iterateurCollection1.next();
        periode = new Periode(item.getDateDebut(), item.getDateFin());
        
        iterateurCollection2 = chrono2.iterer();
        while (iterateurCollection2.hasNext())
        {
          item2 = (Temporel)iterateurCollection2.next();
          periode2 = new Periode(item2.getDateDebut(), item2.getDateFin());
          if (periode.chevauche(periode2))
          {
            periodeInter = periode.periodeIntersection(periode2);
            intersection.ajouter(new ObjetChronoPeriodeConcrete(periodeInter));
          }
        }
      }
    }
    return intersection;
  }
}

/* Location:
 * Qualified Name:     OutillageChronologiePeriodes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */