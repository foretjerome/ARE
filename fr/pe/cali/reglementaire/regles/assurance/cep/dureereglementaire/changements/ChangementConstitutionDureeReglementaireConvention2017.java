package fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.changements;

import fr.pe.cali.reglementaire.decors.changements.ChangementCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.impl.OutilConstitutionDureeReglementaireConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.impl.OutilConstitutionDureeReglementaireRevisionConvention2017;

public final class ChangementConstitutionDureeReglementaireConvention2017
  extends ChangementCorpsRegle
{
  private static ChangementConstitutionDureeReglementaireConvention2017 instance = new ChangementConstitutionDureeReglementaireConvention2017();
  
  private ChangementConstitutionDureeReglementaireConvention2017()
  {
    setNomCorpsRegle("ConstitutionDureeReglementaire");
    initialiserListeCorpsRegles();
    ajouterCorpsRegle(OutilConstitutionDureeReglementaireConvention2017.getInstance());
    ajouterCorpsRegle(OutilConstitutionDureeReglementaireRevisionConvention2017.getInstance());
  }
  
  public static ChangementConstitutionDureeReglementaireConvention2017 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementConstitutionDureeReglementaireConvention2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */