package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import java.util.Collection;

public class ValidationAnnexe4CasParticulier
  implements ValidationReglementSpec
{
  public boolean validerPeriode(PeriodeActiviteSalarie p_periode)
  {
    return (testOriginePeriode(p_periode)) && (testCategorieEmploiParticulierOuvrierTechnicienSpectacle(p_periode));
  }
  
  private boolean testCategorieEmploiParticulierOuvrierTechnicienSpectacle(PeriodeActiviteSalarie p_periode)
  {
    switch (p_periode.getCategorieEmploiParticulier())
    {
    case 21: 
    case 39: 
    case 43: 
    case 44: 
      return true;
    }
    return false;
  }
  
  private boolean testOriginePeriode(PeriodeActiviteSalarie p_periode)
  {
    Collection origines = p_periode.getCollectionOrigineInformationPAS();
    if (origines.contains(Integer.valueOf(4))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(5))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(71))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     ValidationAnnexe4CasParticulier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */