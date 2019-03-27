package fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.fabrique;

import fr.pe.cali.reglementaire.decors.fabrique.FabriqueCorpsRegle;
import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.spec.IOutilConstitutionDureeReglementaire;

public final class FabriqueCorpsRegleConstitutionDureeReglementaire
  extends FabriqueCorpsRegle
{
  private static FabriqueCorpsRegleConstitutionDureeReglementaire instance = new FabriqueCorpsRegleConstitutionDureeReglementaire();
  
  private FabriqueCorpsRegleConstitutionDureeReglementaire()
  {
    setNomCorpsRegle("ConstitutionDureeReglementaire");
  }
  
  public static FabriqueCorpsRegleConstitutionDureeReglementaire getInstance()
  {
    return instance;
  }
  
  public IOutilConstitutionDureeReglementaire recupererOutilCorpsRegle(CriteresFabriqueReglementaire criteres)
  {
    return (IOutilConstitutionDureeReglementaire)super.recupererOutilCorpsRegle(criteres);
  }
}

/* Location:
 * Qualified Name:     FabriqueCorpsRegleConstitutionDureeReglementaire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */