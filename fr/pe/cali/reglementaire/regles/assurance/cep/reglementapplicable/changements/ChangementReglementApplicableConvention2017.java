package fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.changements;

import fr.pe.cali.reglementaire.decors.changements.ChangementCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.outils.impl.OutilReglementApplicableAspSousJacent;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.outils.impl.OutilReglementApplicableConvention2017;

public class ChangementReglementApplicableConvention2017
  extends ChangementCorpsRegle
{
  private static ChangementReglementApplicableConvention2017 instance = new ChangementReglementApplicableConvention2017();
  
  private ChangementReglementApplicableConvention2017()
  {
    setNomCorpsRegle("ConstitutionReglementApplicable");
    initialiserListeCorpsRegles();
    ajouterCorpsRegle(OutilReglementApplicableConvention2017.getInstance());
    ajouterCorpsRegle(OutilReglementApplicableAspSousJacent.getInstance());
  }
  
  public static ChangementReglementApplicableConvention2017 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementReglementApplicableConvention2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */