package fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.outils.spec;

import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.dom.DonneesEntreesDelaisReportsSpectacle;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.dom.ResultatDelaisReportsSpectacle;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public abstract interface IOutilConstitutionDelaisReportsSpectacle
  extends IOutilConstitutionDelaisReports
{
  public abstract ResultatDelaisReportsSpectacle calculerFranchiseCP(DonneesEntreesDelaisReportsSpectacle paramDonneesEntreesDelaisReportsSpectacle);
  
  public abstract int calculerMensualisationFranchiseCP(int paramInt);
  
  public abstract int calculerMensualisationFranchiseSalaire(int paramInt, Damj paramDamj1, Damj paramDamj2);
  
  public abstract int calculerReliquatCarenceDiffere7Jours(int paramInt, Periode paramPeriode, Damj paramDamj);
  
  public abstract ResultatDelaisReportsSpectacle estDiffereApplicable(DonneesEntreesDelaisReportsSpectacle paramDonneesEntreesDelaisReportsSpectacle);
  
  public abstract int calculerReliquatFranchise(int paramInt, Periode paramPeriode, Damj paramDamj);
}

/* Location:
 * Qualified Name:     IOutilConstitutionDelaisReportsSpectacle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */