package fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.changements;

import fr.pe.cali.reglementaire.decors.changements.ChangementCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.outils.impl.OutilConstitutionDelaisReportsAfd2017;

public final class ChangementConstitutionDelaisReportsAfd2017
  extends ChangementCorpsRegle
{
  private static ChangementConstitutionDelaisReportsAfd2017 instance = new ChangementConstitutionDelaisReportsAfd2017();
  
  private ChangementConstitutionDelaisReportsAfd2017()
  {
    setNomCorpsRegle("ConstitutionDelaisReports");
    initialiserListeCorpsRegles();
    ajouterCorpsRegle(OutilConstitutionDelaisReportsAfd2017.getInstance());
  }
  
  public static ChangementConstitutionDelaisReportsAfd2017 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementConstitutionDelaisReportsAfd2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */