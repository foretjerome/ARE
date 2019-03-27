package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.TravailSalarie;
import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListePrimes;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.Iterator;

class MapperPrime
{
  static void ajouter(TravailSalarie pasGaec, ListePrimes listePrimesGaec)
  {
    Periode periode = null;
    if (listePrimesGaec == null) {
      return;
    }
    for (int i = 0; i < listePrimesGaec.getNbListPrime(); i++)
    {
      fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Prime primeGaec = listePrimesGaec.getListePrimes(i);
      int typePrime = Integer.valueOf(primeGaec.getNaturePrime()).intValue();
      boolean exclusion = primeGaec.getBAExclure().booleanValue();
      fr.unedic.cali.autresdoms.ga.dom.Prime prime = null;
      switch (typePrime)
      {
      case 2: 
        periode = FabriquePeriode.creer(primeGaec.getDateDeb(), primeGaec.getDateFin());
        prime = creerPrimeNormale(periode, primeGaec);
        prime.setTypePrime(1);
        prime.setEstPrimeExclue(exclusion);
        break;
      case 0: 
        periode = FabriquePeriode.creer(primeGaec.getDateDeb(), primeGaec.getDateFin());
        prime = creerPrimeNormale(periode, primeGaec);
        prime.setTypePrime(1);
        prime.setEstPrimeExclue(exclusion);
        break;
      case 1: 
        prime = creerPrimeExceptionnelle(primeGaec);
        prime.setTypePrime(2);
        prime.setEstPrimeExclue(exclusion);
        break;
      case 3: 
        periode = FabriquePeriode.creer(primeGaec.getDateDeb(), primeGaec.getDateFin());
        prime = creerPrimeICRS(periode, primeGaec);
        prime.setTypePrime(5);
        prime.setEstPrimeExclue(exclusion);
        break;
      default: 
        throw new RuntimeException("type de prime GAEC non supporté : " + primeGaec.getNaturePrime());
      }
      if (prime != null) {
        pasGaec.ajouterPrime(prime);
      }
    }
  }
  
  static void repartir(ChronologiePeriodes listePASCali, ListePrimes listePrimesGaec)
  {
    if (listePrimesGaec == null) {
      return;
    }
    for (int i = 0; i < listePrimesGaec.getNbListPrime(); i++)
    {
      fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Prime primeGaec = listePrimesGaec.getListePrimes(i);
      int typePrime = Integer.valueOf(primeGaec.getNaturePrime()).intValue();
      if ((primeGaec.getBAExclure() == null) || (!primeGaec.getBAExclure().booleanValue())) {}
      switch (typePrime)
      {
      case 2: 
        ajouterPrimeNormale(listePASCali, primeGaec);
        break;
      case 0: 
      case 1: 
        ajouterPrimeExceptionnelle(listePASCali, primeGaec);
        break;
      case 3: 
        ajouterPrimeICRS(listePASCali, primeGaec);
        break;
      default: 
        throw new RuntimeException("type de prime GAEC non supporté : " + primeGaec.getNaturePrime());
        switch (typePrime)
        {
        case 2: 
          ajouterPrimeNormaleExclue(listePASCali, primeGaec);
          break;
        case 0: 
        case 1: 
          ajouterPrimeExceptionnelleExclue(listePASCali, primeGaec);
          break;
        case 3: 
          ajouterPrimeICRSExclue(listePASCali, primeGaec);
          break;
        default: 
          throw new RuntimeException("type de prime GAEC non supporté : " + primeGaec.getNaturePrime());
        }
        break;
      }
    }
  }
  
  private static void ajouterPrimeExceptionnelle(ChronologiePeriodes listePASCali, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Prime primeGaec)
  {
    TravailSpec pas = null;
    TravailSpec pasAMettreAJour = null;
    boolean bTrouve = false;
    Damj datePrime = null;
    if (primeGaec.getDatePaie() != null) {
      datePrime = primeGaec.getDatePaie();
    } else if (primeGaec.getDateFin() != null) {
      datePrime = primeGaec.getDateFin();
    }
    if (datePrime != null)
    {
      Iterator iter = listePASCali.iterer();
      while ((!bTrouve) && (iter.hasNext()))
      {
        pas = (TravailSpec)iter.next();
        bTrouve = datePrime.estContenueDans(pas.getPeriode());
        if (((pas instanceof ActiviteSalarie)) || (bTrouve)) {
          pasAMettreAJour = pas;
        }
      }
      if ((pasAMettreAJour instanceof ActiviteSalarie))
      {
        fr.unedic.cali.autresdoms.ga.dom.Prime primeExceptionnelleCali = creerPrimeExceptionnelle(primeGaec);
        primeExceptionnelleCali.setTypePrime(2);
        primeExceptionnelleCali.setEstPrimeExclue(false);
        ((ActiviteSalarie)pasAMettreAJour).getPeriodeActiviteSalarieGaec().ajouterPrime(primeExceptionnelleCali);
      }
    }
  }
  
  private static void ajouterPrimeExceptionnelleExclue(ChronologiePeriodes listePASCali, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Prime primeGaec)
  {
    TravailSpec pas = null;
    TravailSpec pasAMettreAJour = null;
    boolean bTrouve = false;
    Damj datePrime = null;
    if (primeGaec.getDatePaie() != null) {
      datePrime = primeGaec.getDatePaie();
    } else if (primeGaec.getDateFin() != null) {
      datePrime = primeGaec.getDateFin();
    }
    if (datePrime != null)
    {
      Iterator iter = listePASCali.iterer();
      while ((!bTrouve) && (iter.hasNext()))
      {
        pas = (TravailSpec)iter.next();
        bTrouve = datePrime.estContenueDans(pas.getPeriode());
        if (((pas instanceof ActiviteSalarie)) || (bTrouve)) {
          pasAMettreAJour = pas;
        }
      }
      if ((pasAMettreAJour instanceof ActiviteSalarie))
      {
        fr.unedic.cali.autresdoms.ga.dom.Prime primeExceptionnelleCali = creerPrimeExceptionnelle(primeGaec);
        primeExceptionnelleCali.setTypePrime(2);
        primeExceptionnelleCali.setEstPrimeExclue(true);
        ((ActiviteSalarie)pasAMettreAJour).getPeriodeActiviteSalarieGaec().ajouterPrime(primeExceptionnelleCali);
      }
    }
  }
  
  private static fr.unedic.cali.autresdoms.ga.dom.Prime creerPrimeExceptionnelle(fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Prime primeGaec)
  {
    fr.unedic.cali.autresdoms.ga.dom.Prime primeExceptionnelleCali = new fr.unedic.cali.autresdoms.ga.dom.Prime();
    if (primeGaec.getDatePaie() != null) {
      primeExceptionnelleCali.setDatePaie(primeGaec.getDatePaie());
    } else if (primeGaec.getDateFin() != null) {
      primeExceptionnelleCali.setDatePaie(primeGaec.getDateFin());
    }
    primeExceptionnelleCali.setMontantBrutBase(new QuantiteEuro(primeGaec.getMontantPrime()));
    primeExceptionnelleCali.setTauxAbattementFraisProfessionnel(CodeGa.valueOf(primeGaec.getAbattement()));
    primeExceptionnelleCali.calculerMontantSoumisContribution();
    return primeExceptionnelleCali;
  }
  
  private static void ajouterPrimeNormale(ChronologiePeriodes listePASCali, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Prime primeGaec)
  {
    Periode periodePrimeGaec = FabriquePeriode.creer(primeGaec.getDateDeb(), primeGaec.getDateFin());
    for (Iterator iter = listePASCali.iterer(); iter.hasNext();)
    {
      TravailSpec travail = (TravailSpec)iter.next();
      if ((travail instanceof ActiviteSalarie))
      {
        ActiviteSalarie pas = (ActiviteSalarie)travail;
        if (periodePrimeGaec.chevauche(pas.getPeriode()))
        {
          fr.unedic.cali.autresdoms.ga.dom.Prime primeNormaleCali = creerPrimeNormale(pas.getPeriode(), primeGaec);
          primeNormaleCali.setTypePrime(1);
          primeNormaleCali.setEstPrimeExclue(false);
          pas.getPeriodeActiviteSalarieGaec().ajouterPrime(primeNormaleCali);
        }
      }
    }
  }
  
  private static void ajouterPrimeNormaleExclue(ChronologiePeriodes listePASCali, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Prime primeGaec)
  {
    Periode periodePrimeGaec = FabriquePeriode.creer(primeGaec.getDateDeb(), primeGaec.getDateFin());
    for (Iterator iter = listePASCali.iterer(); iter.hasNext();)
    {
      TravailSpec travail = (TravailSpec)iter.next();
      if ((travail instanceof ActiviteSalarie))
      {
        ActiviteSalarie pas = (ActiviteSalarie)travail;
        if (periodePrimeGaec.chevauche(pas.getPeriode()))
        {
          fr.unedic.cali.autresdoms.ga.dom.Prime primeNormaleCali = creerPrimeNormale(pas.getPeriode(), primeGaec);
          primeNormaleCali.setTypePrime(1);
          primeNormaleCali.setEstPrimeExclue(true);
          pas.getPeriodeActiviteSalarieGaec().ajouterPrime(primeNormaleCali);
        }
      }
    }
  }
  
  private static fr.unedic.cali.autresdoms.ga.dom.Prime creerPrimeNormale(Periode periodeCali, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Prime primeGaec)
  {
    Periode periodeTotale = FabriquePeriode.creer(primeGaec.getDateDeb(), primeGaec.getDateFin());
    int dureeTotale = periodeTotale.getDuree();
    Periode periodeIncluse = periodeTotale.periodeIntersection(periodeCali);
    int dureeIncluse = periodeIncluse.getDuree();
    BigDecimal montant = primeGaec.getMontantPrime();
    if (dureeIncluse != dureeTotale) {
      montant = Mathematiques.proratiser(montant, new BigDecimal(dureeIncluse), new BigDecimal(dureeTotale));
    }
    fr.unedic.cali.autresdoms.ga.dom.Prime primeNormaleCali = new fr.unedic.cali.autresdoms.ga.dom.Prime(periodeIncluse);
    primeNormaleCali.setDatePaie(primeGaec.getDatePaie());
    primeNormaleCali.setMontantBrutBase(new QuantiteEuro(montant));
    primeNormaleCali.setTauxAbattementFraisProfessionnel(CodeGa.valueOf(primeGaec.getAbattement()));
    primeNormaleCali.calculerMontantSoumisContribution();
    return primeNormaleCali;
  }
  
  private static void ajouterPrimeICRS(ChronologiePeriodes listePASCali, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Prime primeGaec)
  {
    Periode periodePrimeGaec = FabriquePeriode.creer(primeGaec.getDateDeb(), primeGaec.getDateFin());
    for (Iterator iter = listePASCali.iterer(); iter.hasNext();)
    {
      TravailSpec travail = (TravailSpec)iter.next();
      if ((travail instanceof ActiviteSalarie))
      {
        ActiviteSalarie pas = (ActiviteSalarie)travail;
        if (periodePrimeGaec.chevauche(pas.getPeriode()))
        {
          fr.unedic.cali.autresdoms.ga.dom.Prime primeICRSCali = creerPrimeICRS(pas.getPeriode(), primeGaec);
          primeICRSCali.setTypePrime(5);
          primeICRSCali.setEstPrimeExclue(false);
          pas.getPeriodeActiviteSalarieGaec().ajouterPrime(primeICRSCali);
        }
      }
    }
  }
  
  private static void ajouterPrimeICRSExclue(ChronologiePeriodes listePASCali, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Prime primeGaec)
  {
    Periode periodePrimeGaec = FabriquePeriode.creer(primeGaec.getDateDeb(), primeGaec.getDateFin());
    for (Iterator iter = listePASCali.iterer(); iter.hasNext();)
    {
      TravailSpec travail = (TravailSpec)iter.next();
      if ((travail instanceof ActiviteSalarie))
      {
        ActiviteSalarie pas = (ActiviteSalarie)travail;
        if (periodePrimeGaec.chevauche(pas.getPeriode()))
        {
          fr.unedic.cali.autresdoms.ga.dom.Prime primeICRSCali = creerPrimeICRS(pas.getPeriode(), primeGaec);
          primeICRSCali.setTypePrime(5);
          primeICRSCali.setEstPrimeExclue(true);
          pas.getPeriodeActiviteSalarieGaec().ajouterPrime(primeICRSCali);
        }
      }
    }
  }
  
  private static fr.unedic.cali.autresdoms.ga.dom.Prime creerPrimeICRS(Periode periodeCali, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Prime primeGaec)
  {
    Periode periodeTotale = FabriquePeriode.creer(primeGaec.getDateDeb(), primeGaec.getDateFin());
    int dureeTotale = periodeTotale.getDuree();
    Periode periodeIncluse = periodeTotale.periodeIntersection(periodeCali);
    int dureeIncluse = periodeIncluse.getDuree();
    BigDecimal montant = primeGaec.getMontantPrime();
    if (dureeIncluse != dureeTotale) {
      montant = Mathematiques.proratiser(montant, new BigDecimal(dureeIncluse), new BigDecimal(dureeTotale));
    }
    fr.unedic.cali.autresdoms.ga.dom.Prime primeICRSCali = new fr.unedic.cali.autresdoms.ga.dom.Prime(periodeIncluse);
    primeICRSCali.setDatePaie(primeGaec.getDatePaie());
    primeICRSCali.setMontantBrutBase(new QuantiteEuro(montant));
    primeICRSCali.setTauxAbattementFraisProfessionnel(CodeGa.valueOf(primeGaec.getAbattement()));
    primeICRSCali.calculerMontantSoumisContribution();
    return primeICRSCali;
  }
}

/* Location:
 * Qualified Name:     MapperPrime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */