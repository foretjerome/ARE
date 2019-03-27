package fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.fabrique;

import fr.pe.cali.reglementaire.decors.fabrique.FabriqueCorpsRegle;
import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.outils.spec.IOutilCorpsRegleReglementApplicable;

public class FabriqueCorpsRegleReglementApplicable
  extends FabriqueCorpsRegle
{
  private static FabriqueCorpsRegleReglementApplicable instance = new FabriqueCorpsRegleReglementApplicable();
  
  private FabriqueCorpsRegleReglementApplicable()
  {
    setNomCorpsRegle("ConstitutionReglementApplicable");
  }
  
  public static FabriqueCorpsRegleReglementApplicable getInstance()
  {
    return instance;
  }
  
  public IOutilCorpsRegleReglementApplicable recupererOutilCorpsRegle(CriteresFabriqueReglementaire criteres)
  {
    return (IOutilCorpsRegleReglementApplicable)super.recupererOutilCorpsRegle(criteres);
  }
}

/* Location:
 * Qualified Name:     FabriqueCorpsRegleReglementApplicable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */