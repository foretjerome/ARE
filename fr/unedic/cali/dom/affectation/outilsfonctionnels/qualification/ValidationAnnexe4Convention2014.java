package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;

public class ValidationAnnexe4Convention2014
  extends ValidationAnnexe4
{
  protected boolean testCategorieEmploiParticulier(PeriodeActiviteSalarie periode)
  {
    return 34 == periode.getCategorieEmploiParticulier();
  }
}

/* Location:
 * Qualified Name:     ValidationAnnexe4Convention2014
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */