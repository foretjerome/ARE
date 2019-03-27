package fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements;

import fr.pe.cali.reglementaire.decors.changements.ChangementCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.outils.impl.OutilAccesListeUniteAvantConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.outils.impl.OutilAccesListeUniteInopposabiliteAvantConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.outils.impl.OutilAccesListeUniteRechargementAvantConvention2017;

public class ChangementAccesListeUniteReglementAvantConvention2017
  extends ChangementCorpsRegle
{
  private static ChangementAccesListeUniteReglementAvantConvention2017 instance = new ChangementAccesListeUniteReglementAvantConvention2017();
  
  private ChangementAccesListeUniteReglementAvantConvention2017()
  {
    setNomCorpsRegle("AccesListeUniteReglement");
    initialiserListeCorpsRegles();
    ajouterCorpsRegle(new OutilAccesListeUniteAvantConvention2017());
    ajouterCorpsRegle(new OutilAccesListeUniteRechargementAvantConvention2017());
    ajouterCorpsRegle(new OutilAccesListeUniteInopposabiliteAvantConvention2017());
  }
  
  public static final ChangementAccesListeUniteReglementAvantConvention2017 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementAccesListeUniteReglementAvantConvention2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */