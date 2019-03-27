package fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements;

import fr.pe.cali.reglementaire.decors.changements.ChangementCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.outils.impl.OutilAccesListeUniteApresConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.outils.impl.OutilAccesListeUniteConsitutionAffiApresConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.outils.impl.OutilAccesListeUniteRechargementApresConvention2017;

public class ChangementAccesListeUniteReglementConvention2017
  extends ChangementCorpsRegle
{
  private static ChangementAccesListeUniteReglementConvention2017 instance = new ChangementAccesListeUniteReglementConvention2017();
  
  private ChangementAccesListeUniteReglementConvention2017()
  {
    setNomCorpsRegle("AccesListeUniteReglement");
    initialiserListeCorpsRegles();
    ajouterCorpsRegle(new OutilAccesListeUniteApresConvention2017());
    ajouterCorpsRegle(new OutilAccesListeUniteConsitutionAffiApresConvention2017());
    ajouterCorpsRegle(new OutilAccesListeUniteRechargementApresConvention2017());
  }
  
  public static final ChangementAccesListeUniteReglementConvention2017 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementAccesListeUniteReglementConvention2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */