package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification;

import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import java.util.Collection;

public class ValidationReglementGeneral
  implements ValidationReglementSpec
{
  public boolean validerPeriode(PeriodeActiviteSalarie periode)
  {
    return (testOriginePeriode1(periode)) && (testCategorieEmploiParticulierOuContratTypeParticulier1(periode)) && (testPohf(periode));
  }
  
  private boolean testOriginePeriode1(PeriodeActiviteSalarie periode)
  {
    Collection origines = periode.getCollectionOrigineInformationPAS();
    if (origines.contains(Integer.valueOf(1))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(39))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(33))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(56))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(34))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(71))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(74))) {
      return true;
    }
    if ((origines.contains(Integer.valueOf(3))) && (origines.contains(Integer.valueOf(12)))) {
      return true;
    }
    if ((origines.contains(Integer.valueOf(11))) && (origines.contains(Integer.valueOf(12)))) {
      return true;
    }
    if ((origines.contains(Integer.valueOf(3))) && (origines.contains(Integer.valueOf(15)))) {
      return true;
    }
    if ((origines.contains(Integer.valueOf(11))) && (origines.contains(Integer.valueOf(15)))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(110))) {
      return true;
    }
    return false;
  }
  
  protected boolean testCategorieEmploiParticulierOuContratTypeParticulier1(PeriodeActiviteSalarie periode)
  {
    boolean ok = false;
    switch (periode.getCategorieEmploiParticulier())
    {
    case 23: 
    case 29: 
    case 31: 
    case 48: 
    case 50: 
    case 51: 
    case 53: 
      ok = true;
      break;
    default: 
      ok = false;
    }
    return ok;
  }
  
  private boolean testPohf(PeriodeActiviteSalarie periode)
  {
    int pohf = periode.getContratTravail().getPohf();
    switch (pohf)
    {
    case 0: 
    case 1: 
    case 7: 
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     ValidationReglementGeneral
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */