package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification;

import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification.abstraite.ValidationAnnexeAbstraite;
import java.util.Collection;

public class ValidationAnnexe9B
  extends ValidationAnnexeAbstraite
{
  public boolean validerPeriode(PeriodeActiviteSalarie periode)
  {
    return (testCategorieExclue(periode)) && (testOriginePeriode(periode)) && (testPohf(periode));
  }
  
  private boolean testCategorieExclue(PeriodeActiviteSalarie periode)
  {
    switch (periode.getCategorieEmploiParticulier())
    {
    case 45: 
      return false;
    }
    return true;
  }
  
  protected boolean testOriginePeriode(PeriodeActiviteSalarie periode)
  {
    Collection<Integer> origines = periode.getCollectionOrigineInformationPAS();
    
    boolean resultat = false;
    if (testOrigineAe(origines, periode.getDateConnaissanceInfo())) {
      resultat = true;
    }
    if (testOrigineCrpCspCtp(origines)) {
      resultat = true;
    }
    if (origines.contains(Integer.valueOf(71))) {
      resultat = true;
    }
    if (origines.contains(Integer.valueOf(74))) {
      resultat = true;
    }
    if (testOrigineMultiple(origines)) {
      resultat = true;
    }
    if (origines.contains(Integer.valueOf(110))) {
      resultat = true;
    }
    return resultat;
  }
  
  private boolean testOrigineCrpCspCtp(Collection<Integer> origines)
  {
    boolean resultat = false;
    if (origines.contains(Integer.valueOf(33))) {
      resultat = true;
    } else if (origines.contains(Integer.valueOf(56))) {
      resultat = true;
    } else if (origines.contains(Integer.valueOf(34))) {
      resultat = true;
    }
    return resultat;
  }
  
  private boolean testOrigineMultiple(Collection<Integer> origines)
  {
    boolean resultat = false;
    if ((origines.contains(Integer.valueOf(3))) && (origines.contains(Integer.valueOf(12)))) {
      resultat = true;
    } else if ((origines.contains(Integer.valueOf(11))) && (origines.contains(Integer.valueOf(12)))) {
      resultat = true;
    } else if ((origines.contains(Integer.valueOf(3))) && (origines.contains(Integer.valueOf(15)))) {
      resultat = true;
    } else if ((origines.contains(Integer.valueOf(11))) && (origines.contains(Integer.valueOf(15)))) {
      resultat = true;
    }
    return resultat;
  }
  
  private boolean testPohf(PeriodeActiviteSalarie periode)
  {
    int pohf = periode.getContratTravail().getPohf();
    switch (pohf)
    {
    case 3: 
    case 5: 
    case 10: 
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     ValidationAnnexe9B
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */