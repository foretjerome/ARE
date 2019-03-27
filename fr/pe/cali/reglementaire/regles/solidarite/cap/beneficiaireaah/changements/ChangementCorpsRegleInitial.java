package fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.changements;

import fr.pe.cali.reglementaire.decors.changements.ChangementCorpsRegle;
import fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.outils.impl.OutilConditionSatisfaite;

public class ChangementCorpsRegleInitial
  extends ChangementCorpsRegle
{
  private static ChangementCorpsRegleInitial instance;
  
  private ChangementCorpsRegleInitial()
  {
    setNomCorpsRegle("conditionBeneficiaireAAH");
    initialiserListeCorpsRegles();
    ajouterCorpsRegle(OutilConditionSatisfaite.getInstance());
  }
  
  public static ChangementCorpsRegleInitial getInstance()
  {
    if (instance == null) {
      instance = new ChangementCorpsRegleInitial();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementCorpsRegleInitial
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */