package fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.changements;

import fr.pe.cali.reglementaire.decors.changements.ChangementCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.outils.impl.OutilConstitutionDelaisReportsClauseRattrapageSpectacle2016;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.outils.impl.OutilConstitutionDelaisReportsSpectacle2016;

public final class ChangementConstitutionDelaisReportsSpectacle2016
  extends ChangementCorpsRegle
{
  private static ChangementConstitutionDelaisReportsSpectacle2016 instance = new ChangementConstitutionDelaisReportsSpectacle2016();
  
  private ChangementConstitutionDelaisReportsSpectacle2016()
  {
    setNomCorpsRegle("ConstitutionDelaisReports");
    initialiserListeCorpsRegles();
    ajouterCorpsRegle(OutilConstitutionDelaisReportsSpectacle2016.getInstance());
    ajouterCorpsRegle(OutilConstitutionDelaisReportsClauseRattrapageSpectacle2016.getInstance());
  }
  
  public static ChangementConstitutionDelaisReportsSpectacle2016 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementConstitutionDelaisReportsSpectacle2016
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */