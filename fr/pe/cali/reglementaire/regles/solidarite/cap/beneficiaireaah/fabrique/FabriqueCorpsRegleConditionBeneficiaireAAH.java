package fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.fabrique;

import fr.pe.cali.reglementaire.decors.fabrique.FabriqueCorpsRegle;
import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.outils.spec.IOutilConditionBeneficiaireAAH;

public final class FabriqueCorpsRegleConditionBeneficiaireAAH
  extends FabriqueCorpsRegle
{
  private static FabriqueCorpsRegleConditionBeneficiaireAAH instance;
  
  private FabriqueCorpsRegleConditionBeneficiaireAAH()
  {
    setNomCorpsRegle("conditionBeneficiaireAAH");
  }
  
  public static FabriqueCorpsRegleConditionBeneficiaireAAH getInstance()
  {
    if (instance == null) {
      instance = new FabriqueCorpsRegleConditionBeneficiaireAAH();
    }
    return instance;
  }
  
  public IOutilConditionBeneficiaireAAH recupererOutilCorpsRegle(CriteresFabriqueReglementaire criteres)
  {
    return (IOutilConditionBeneficiaireAAH)super.recupererOutilCorpsRegle(criteres);
  }
}

/* Location:
 * Qualified Name:     FabriqueCorpsRegleConditionBeneficiaireAAH
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */