package fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.fabrique;

import fr.pe.cali.reglementaire.decors.fabrique.FabriqueCorpsRegle;
import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.outils.spec.IOutilConstitutionDelaisReports;

public class FabriqueCorpsRegleConstitutionDelaisReports
  extends FabriqueCorpsRegle
{
  private static FabriqueCorpsRegleConstitutionDelaisReports instance = new FabriqueCorpsRegleConstitutionDelaisReports();
  
  private FabriqueCorpsRegleConstitutionDelaisReports()
  {
    setNomCorpsRegle("ConstitutionDelaisReports");
  }
  
  public static FabriqueCorpsRegleConstitutionDelaisReports getInstance()
  {
    return instance;
  }
  
  public IOutilConstitutionDelaisReports recupererOutilCorpsRegle(CriteresFabriqueReglementaire criteres)
  {
    return (IOutilConstitutionDelaisReports)super.recupererOutilCorpsRegle(criteres);
  }
}

/* Location:
 * Qualified Name:     FabriqueCorpsRegleConstitutionDelaisReports
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */