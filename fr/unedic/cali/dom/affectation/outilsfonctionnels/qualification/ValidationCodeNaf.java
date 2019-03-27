package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.util.temps.Periode;

public class ValidationCodeNaf
{
  private Periode periodeValiditeDateDebut = null;
  private Periode periodeValiditeDateConnaissance = null;
  public static final ValidationCodeNaf TOUJOURS_VALIDE = new ValidationCodeNaf();
  
  private ValidationCodeNaf() {}
  
  public ValidationCodeNaf(Periode periodeValiditeDateDebut, Periode periodeValiditeDateConnaissance)
  {
    this.periodeValiditeDateDebut = periodeValiditeDateDebut;
    this.periodeValiditeDateConnaissance = periodeValiditeDateConnaissance;
  }
  
  public boolean estApplicable(PeriodeActiviteSalarie periode)
  {
    boolean applicable = true;
    if ((periodeValiditeDateDebut != null) && (!periodeValiditeDateDebut.contient(periode.getDateDebut()))) {
      applicable = false;
    }
    if ((periodeValiditeDateConnaissance != null) && (!periodeValiditeDateConnaissance.contient(periode.getDateConnaissanceInfo()))) {
      applicable = false;
    }
    return applicable;
  }
}

/* Location:
 * Qualified Name:     ValidationCodeNaf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */