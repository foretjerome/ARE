package fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.changements;

import fr.pe.cali.reglementaire.decors.changements.ChangementCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.outils.impl.OutilConstitutionDelaisReportsFps2017;

public final class ChangementConstitutionDelaisReportsFps2017
  extends ChangementCorpsRegle
{
  private static ChangementConstitutionDelaisReportsFps2017 instance = new ChangementConstitutionDelaisReportsFps2017();
  
  private ChangementConstitutionDelaisReportsFps2017()
  {
    setNomCorpsRegle("ConstitutionDelaisReports");
    initialiserListeCorpsRegles();
    ajouterCorpsRegle(OutilConstitutionDelaisReportsFps2017.getInstance());
  }
  
  public static ChangementConstitutionDelaisReportsFps2017 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementConstitutionDelaisReportsFps2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */