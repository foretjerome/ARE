package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.Prime;
import fr.unedic.cali.autresdoms.ga.dom.Salaire;
import fr.unedic.cali.autresdoms.ga.dom.spec.RemunerationSpec;
import fr.unedic.cali.autresdoms.ga.dom.spec.SalarieSpec;
import fr.unedic.cali.dom.ResultatRemunerationsParNature;
import fr.unedic.cali.fabriques.FabriqueStrategiePriseEnComptePrimeExceptionnelle;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePrimesExceptionnelles;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePrimesNormales;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategiePriseEnComptePrimeExceptionnelleSpec;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class DeterminationRemuneration
{
  private static final BigDecimal ZERO = new BigDecimal(0);
  
  public static BigDecimal determinerRemuneration(RemunerationSpec p_sourceRemuneration)
  {
    return p_sourceRemuneration.getMontantSoumisAContribution().getValeurMontant();
  }
  
  private static BigDecimal determinerRemunerationDansPeriodeRef(RemunerationSpec p_sourceRemuneration, Periode p_periodeReference, boolean p_proratiserSurPeriodeReference)
  {
    BigDecimal montantRemuneration = new BigDecimal("0");
    if ((p_periodeReference != null) && (p_sourceRemuneration.estType(ObjetChronoPeriode.class)))
    {
      montantRemuneration = determinerRemuneration(p_sourceRemuneration);
      
      ObjetChronoPeriode periodeSourceRemuneration = (ObjetChronoPeriode)p_sourceRemuneration;
      int nombreJoursChevauchantPeriodeRef = periodeSourceRemuneration.inter(p_periodeReference);
      if (nombreJoursChevauchantPeriodeRef == 0)
      {
        montantRemuneration = new BigDecimal("0");
      }
      else if (p_proratiserSurPeriodeReference)
      {
        BigDecimal nominateur1 = new BigDecimal(String.valueOf(nombreJoursChevauchantPeriodeRef));
        BigDecimal nominateur2 = montantRemuneration;
        BigDecimal denominateur = new BigDecimal(String.valueOf(periodeSourceRemuneration.getDuree()));
        BigDecimal montantProratiseSurPeriodeRef = Mathematiques.proratiser(nominateur1, nominateur2, denominateur);
        montantRemuneration = montantProratiseSurPeriodeRef;
      }
    }
    return montantRemuneration;
  }
  
  public static BigDecimal determinerRemunerationProratiseeDansPeriodeRef(RemunerationSpec p_sourceRemuneration, Periode p_periodeReference)
  {
    return determinerRemunerationDansPeriodeRef(p_sourceRemuneration, p_periodeReference, true);
  }
  
  public static BigDecimal determinerRemunerationActiviteSalarie(ActiviteSalarie p_periodeActiviteSalarie, Periode p_periodeReference)
  {
    return determinerRemunerationActiviteSalarie(p_periodeActiviteSalarie, p_periodeReference, null);
  }
  
  public static BigDecimal determinerRemunerationActiviteSalarie(ActiviteSalarie p_periodeActiviteSalarie, Periode p_periodeReference, ResultatRemunerationsParNature p_resultatRemuneration)
  {
    Chronologie listeSalaires = p_periodeActiviteSalarie.getListeSalaires();
    Chronologie listePrimesNormales = p_periodeActiviteSalarie.getListePrimesNormales();
    Chronologie listePrimesExceptionnelles = p_periodeActiviteSalarie.getListePrimesExceptionnelles();
    
    return determinerRemunerationActiviteSalariee(listeSalaires, listePrimesNormales, listePrimesExceptionnelles, p_periodeReference, p_resultatRemuneration);
  }
  
  public static BigDecimal determinerRemunerationActiviteSalarie(PeriodeActiviteSalarie p_periodeActiviteSalarie, Periode p_periodeReference)
  {
    Chronologie listeSalaires = p_periodeActiviteSalarie.getListeSalaires();
    Chronologie listePrimesNormales = p_periodeActiviteSalarie.getListePrimesNormales();
    Chronologie listePrimesExceptionnelles = p_periodeActiviteSalarie.getListePrimesExceptionnelles();
    
    return determinerRemunerationActiviteSalariee(listeSalaires, listePrimesNormales, listePrimesExceptionnelles, p_periodeReference);
  }
  
  public static BigDecimal determinerRemunerationActiviteSalarie(SalarieSpec p_activite, Periode p_periodeReference)
  {
    return determinerRemunerationActiviteSalariee(p_activite.getListeSalaires(), p_activite.getListePrimes().copier(new FiltrePrimesNormales()), p_activite.getListePrimes().copier(new FiltrePrimesExceptionnelles()), p_periodeReference);
  }
  
  private static BigDecimal determinerRemunerationActiviteSalariee(Chronologie p_listeSalaires, Chronologie p_listePrimesNormales, Chronologie p_listePrimesExceptionnelles, Periode p_periodeReference)
  {
    return determinerRemunerationActiviteSalariee(p_listeSalaires, p_listePrimesNormales, p_listePrimesExceptionnelles, p_periodeReference, null);
  }
  
  private static BigDecimal determinerRemunerationActiviteSalariee(Chronologie p_listeSalaires, Chronologie p_listePrimesNormales, Chronologie p_listePrimesExceptionnelles, Periode p_periodeReference, ResultatRemunerationsParNature p_resultatRemuneration)
  {
    BigDecimal cumulRemuneration = ZERO;
    BigDecimal cumulSalaires = ZERO;
    BigDecimal cumulPrimesNormales = ZERO;
    BigDecimal cumulPrimesExceptionnelles = ZERO;
    
    Chronologie listeSalaires = p_listeSalaires;
    if (listeSalaires != null)
    {
      Salaire periodeSalaireCourante = null;
      listeSalaires.iterer();
      while (listeSalaires.encoreSuivant())
      {
        periodeSalaireCourante = (Salaire)listeSalaires.elementSuivant();
        if (p_periodeReference == null) {
          cumulSalaires = cumulSalaires.add(determinerRemuneration(periodeSalaireCourante));
        } else {
          cumulSalaires = cumulSalaires.add(determinerRemunerationProratiseeDansPeriodeRef(periodeSalaireCourante, p_periodeReference));
        }
      }
    }
    cumulRemuneration = cumulRemuneration.add(cumulSalaires);
    
    Chronologie listePrimesNormales = p_listePrimesNormales;
    if (listePrimesNormales != null)
    {
      Prime primeNormaleCourante = null;
      listePrimesNormales.iterer();
      while (listePrimesNormales.encoreSuivant())
      {
        primeNormaleCourante = (Prime)listePrimesNormales.elementSuivant();
        if (p_periodeReference == null) {
          cumulPrimesNormales = cumulPrimesNormales.add(determinerRemuneration(primeNormaleCourante));
        } else {
          cumulPrimesNormales = cumulPrimesNormales.add(determinerRemunerationProratiseeDansPeriodeRef(primeNormaleCourante, p_periodeReference));
        }
      }
    }
    cumulRemuneration = cumulRemuneration.add(cumulPrimesNormales);
    
    CritereStrategie critereStrategie = new CritereStrategie();
    StrategiePriseEnComptePrimeExceptionnelleSpec strategiePriseEnComptePrimeExceptionnelle = null;
    
    Chronologie listePrimesExceptionnelles = p_listePrimesExceptionnelles;
    if (listePrimesExceptionnelles != null)
    {
      Prime primeExceptionnelleCourante = null;
      listePrimesExceptionnelles.iterer();
      while (listePrimesExceptionnelles.encoreSuivant())
      {
        primeExceptionnelleCourante = (Prime)listePrimesExceptionnelles.elementSuivant();
        
        critereStrategie.setDatePivot(primeExceptionnelleCourante.getDatePaie());
        strategiePriseEnComptePrimeExceptionnelle = (StrategiePriseEnComptePrimeExceptionnelleSpec)FabriqueStrategiePriseEnComptePrimeExceptionnelle.getInstance().getStrategie(critereStrategie);
        if (strategiePriseEnComptePrimeExceptionnelle.estApplicable())
        {
          if (p_periodeReference == null) {
            cumulPrimesExceptionnelles = cumulPrimesExceptionnelles.add(determinerRemuneration(primeExceptionnelleCourante));
          } else if (primeExceptionnelleCourante.getDatePaie().estContenueDans(p_periodeReference)) {
            cumulPrimesExceptionnelles = cumulPrimesExceptionnelles.add(determinerRemuneration(primeExceptionnelleCourante));
          }
        }
        else {
          cumulPrimesExceptionnelles = cumulPrimesExceptionnelles.add(determinerRemuneration(primeExceptionnelleCourante));
        }
      }
    }
    cumulRemuneration = cumulRemuneration.add(cumulPrimesExceptionnelles);
    if (p_resultatRemuneration != null) {
      alimenterResultatCalculRemuneration(p_resultatRemuneration, cumulSalaires, cumulPrimesNormales, cumulPrimesExceptionnelles);
    }
    return cumulRemuneration;
  }
  
  private static void alimenterResultatCalculRemuneration(ResultatRemunerationsParNature p_resultatRemuneration, BigDecimal p_salaires, BigDecimal p_primesNormales, BigDecimal p_primesExceptionnelles)
  {
    if (p_resultatRemuneration != null)
    {
      if (p_salaires != null) {
        p_resultatRemuneration.ajouterRemuneration(1, new QuantiteEuro(p_salaires));
      }
      if (p_primesNormales != null) {
        p_resultatRemuneration.ajouterRemuneration(2, new QuantiteEuro(p_primesNormales));
      }
      if (p_primesExceptionnelles != null) {
        p_resultatRemuneration.ajouterRemuneration(3, new QuantiteEuro(p_primesExceptionnelles));
      }
    }
  }
  
  public static BigDecimal determinerRemunerationActiviteSalarieConserveeSurMoisCivil(ActiviteSalarie p_activiteSalarieConservee, Periode p_moisCivil)
  {
    BigDecimal cumulRemuneration = new BigDecimal("0");
    Chronologie listeSalaires = p_activiteSalarieConservee.getListeSalaires();
    Chronologie listePrimesNormales = p_activiteSalarieConservee.getListePrimesNormales();
    Chronologie listePrimesExceptionnelles = p_activiteSalarieConservee.getListePrimesExceptionnelles();
    if (listeSalaires != null)
    {
      Salaire periodeSalaireCourante = null;
      listeSalaires.iterer();
      while (listeSalaires.encoreSuivant())
      {
        periodeSalaireCourante = (Salaire)listeSalaires.elementSuivant();
        cumulRemuneration = cumulRemuneration.add(determinerRemunerationProratiseeDansPeriodeRef(periodeSalaireCourante, p_moisCivil));
      }
    }
    if (listePrimesNormales != null)
    {
      Prime primeNormaleCourante = null;
      listePrimesNormales.iterer();
      Damj dateConsiderationPrime = null;
      while (listePrimesNormales.encoreSuivant())
      {
        primeNormaleCourante = (Prime)listePrimesNormales.elementSuivant();
        if (primeNormaleCourante.getDatePaie() != null) {
          dateConsiderationPrime = primeNormaleCourante.getDatePaie();
        } else if (primeNormaleCourante.getDateFin() != null) {
          dateConsiderationPrime = primeNormaleCourante.getDateFin();
        }
        if ((dateConsiderationPrime != null) && (dateConsiderationPrime.estContenueDans(p_moisCivil))) {
          cumulRemuneration = cumulRemuneration.add(determinerRemunerationProratiseeDansPeriodeRef(primeNormaleCourante, p_moisCivil));
        }
      }
    }
    if (listePrimesExceptionnelles != null)
    {
      Prime primeExceptionnelleCourante = null;
      listePrimesExceptionnelles.iterer();
      while (listePrimesExceptionnelles.encoreSuivant())
      {
        primeExceptionnelleCourante = (Prime)listePrimesExceptionnelles.elementSuivant();
        if (primeExceptionnelleCourante.getDatePaie().estContenueDans(p_moisCivil)) {
          cumulRemuneration = cumulRemuneration.add(determinerRemunerationProratiseeDansPeriodeRef(primeExceptionnelleCourante, p_moisCivil));
        }
      }
    }
    return cumulRemuneration;
  }
  
  private static RemunerationSpec construireRemunerationSurPeriode(BigDecimal p_montantRemuneration, Periode p_periodeRemunerationOrigine, Periode p_periodeRemunerationNouvelle, int p_natureRemuneration)
  {
    RemunerationSpec remunerationRetournee = null;
    BigDecimal valeurProratisee = null;
    BigDecimal nominateurProratisation = null;
    BigDecimal denominateurProratisation = null;
    switch (p_natureRemuneration)
    {
    case 1: 
      remunerationRetournee = new Salaire(p_periodeRemunerationNouvelle);
      break;
    case 2: 
      remunerationRetournee = new Prime(p_periodeRemunerationNouvelle);
      ((Prime)remunerationRetournee).setTypePrime(1);
      break;
    case 3: 
      remunerationRetournee = new Prime(p_periodeRemunerationNouvelle);
      ((Prime)remunerationRetournee).setTypePrime(2);
      break;
    case 5: 
      remunerationRetournee = new Prime(p_periodeRemunerationNouvelle);
      ((Prime)remunerationRetournee).setTypePrime(5);
    }
    nominateurProratisation = new BigDecimal(p_periodeRemunerationNouvelle.getDuree());
    denominateurProratisation = new BigDecimal(p_periodeRemunerationOrigine.getDuree());
    valeurProratisee = Mathematiques.proratiser(p_montantRemuneration, nominateurProratisation, denominateurProratisation);
    remunerationRetournee.setMontantSoumisAContribution(new QuantiteEuro(valeurProratisee));
    
    return remunerationRetournee;
  }
  
  public static Collection decouperRemunerationSurMoisCivils(Periode p_periodeRemunerationDansPrc, BigDecimal p_montantRemuneration, int p_natureRemuneration)
  {
    Collection collectionRemunerationsSurMoisCivils = new ArrayList();
    
    ArrayList listePeriodesMoisCivils = p_periodeRemunerationDansPrc.decouperEnMoisCivils();
    Periode periodeMoisCivilCourant = null;
    RemunerationSpec remunerationSurMoisCivil = null;
    for (int boucle = 0; boucle < listePeriodesMoisCivils.size(); boucle++)
    {
      periodeMoisCivilCourant = (Periode)listePeriodesMoisCivils.get(boucle);
      
      remunerationSurMoisCivil = construireRemunerationSurPeriode(p_montantRemuneration, p_periodeRemunerationDansPrc, periodeMoisCivilCourant, p_natureRemuneration);
      
      collectionRemunerationsSurMoisCivils.add(remunerationSurMoisCivil);
    }
    return collectionRemunerationsSurMoisCivils;
  }
}

/* Location:
 * Qualified Name:     DeterminationRemuneration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */