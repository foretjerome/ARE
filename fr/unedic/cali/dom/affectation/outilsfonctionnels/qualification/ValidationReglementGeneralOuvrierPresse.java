package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;

public class ValidationReglementGeneralOuvrierPresse
  extends ValidationReglementGeneral
{
  protected boolean testCategorieEmploiParticulierOuContratTypeParticulier1(PeriodeActiviteSalarie p_periode)
  {
    return p_periode.getCategorieEmploiParticulier() == 40;
  }
}

/* Location:
 * Qualified Name:     ValidationReglementGeneralOuvrierPresse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */