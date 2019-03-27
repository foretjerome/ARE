package fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.changements;

import fr.pe.cali.reglementaire.decors.changements.ChangementCorpsRegle;
import fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.outils.impl.OutilConditionBeneficiaireAAH;

public class ChangementConditionBeneficiaireAAH
  extends ChangementCorpsRegle
{
  private static ChangementConditionBeneficiaireAAH instance;
  
  private ChangementConditionBeneficiaireAAH()
  {
    setNomCorpsRegle("conditionBeneficiaireAAH");
    initialiserListeCorpsRegles();
    ajouterCorpsRegle(OutilConditionBeneficiaireAAH.getInstance());
  }
  
  public static ChangementConditionBeneficiaireAAH getInstance()
  {
    if (instance == null) {
      instance = new ChangementConditionBeneficiaireAAH();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementConditionBeneficiaireAAH
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */