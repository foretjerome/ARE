package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification;

import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import java.util.Collection;

public class ValidationReglementGeneralParticulier
  implements ValidationReglementSpec
{
  public boolean validerPeriode(PeriodeActiviteSalarie periode)
  {
    return (testCasOrigineE301(periode)) || (testCasAutresOrigines(periode));
  }
  
  private boolean testCasOrigineE301(PeriodeActiviteSalarie periode)
  {
    return (testCasArtisteSpectacleVivant(periode)) && (testOrigineE301(periode)) && (testPohf1(periode));
  }
  
  private boolean testCasArtisteSpectacleVivant(PeriodeActiviteSalarie periode)
  {
    return periode.getCategorieEmploiParticulier() != 21;
  }
  
  private boolean testCasAutresOrigines(PeriodeActiviteSalarie periode)
  {
    return (testCategorieExclue(periode)) && (testOrigines2(periode)) && (testPohf2(periode));
  }
  
  private boolean testCategorieExclue(PeriodeActiviteSalarie periode)
  {
    switch (periode.getCategorieEmploiParticulier())
    {
    case 21: 
    case 45: 
      return false;
    }
    return true;
  }
  
  private boolean testOrigineE301(PeriodeActiviteSalarie periode)
  {
    Collection origines = periode.getCollectionOrigineInformationPAS();
    if (origines.contains(Integer.valueOf(10))) {
      return true;
    }
    return false;
  }
  
  private boolean testPohf1(PeriodeActiviteSalarie periode)
  {
    int pohf = periode.getContratTravail().getPohf();
    switch (pohf)
    {
    case 6: 
    case 8: 
    case 9: 
      return true;
    }
    return false;
  }
  
  private boolean testOrigines2(PeriodeActiviteSalarie periode)
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
  
  private boolean testPohf2(PeriodeActiviteSalarie periode)
  {
    int pohf = periode.getContratTravail().getPohf();
    switch (pohf)
    {
    case 8: 
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     ValidationReglementGeneralParticulier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */