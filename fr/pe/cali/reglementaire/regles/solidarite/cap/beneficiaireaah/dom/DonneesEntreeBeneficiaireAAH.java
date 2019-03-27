package fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.dom;

import fr.unedic.cali.dom.PeriodeDroitAAH;
import fr.unedic.util.temps.Damj;
import java.util.List;

public class DonneesEntreeBeneficiaireAAH
{
  private List<PeriodeDroitAAH> periodesDroitAAH;
  private Damj dateExamen;
  private Boolean conditionNonCumulAahDF;
  
  public List<PeriodeDroitAAH> getPeriodesDroitAAH()
  {
    return periodesDroitAAH;
  }
  
  public void setPeriodesDroitAAH(List<PeriodeDroitAAH> periodesDroitAAH)
  {
    this.periodesDroitAAH = periodesDroitAAH;
  }
  
  public Damj getDateExamen()
  {
    return dateExamen;
  }
  
  public void setDateExamen(Damj dateExamen)
  {
    this.dateExamen = dateExamen;
  }
  
  public Boolean getConditionNonCumulAahDF()
  {
    return conditionNonCumulAahDF;
  }
  
  public void setConditionNonCumulAahDF(Boolean conditionNonCumulAAH)
  {
    conditionNonCumulAahDF = conditionNonCumulAAH;
  }
}

/* Location:
 * Qualified Name:     DonneesEntreeBeneficiaireAAH
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */