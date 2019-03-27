package fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements;

import fr.pe.cali.reglementaire.decors.changements.ChangementCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.outils.impl.OutilAccesListeUniteApresConvention2017ClauseSauvegarde;

public class ChangementAccesListeUniteReglementConvention2017ClauseSauvegarde
  extends ChangementCorpsRegle
{
  private static ChangementAccesListeUniteReglementConvention2017ClauseSauvegarde instance = new ChangementAccesListeUniteReglementConvention2017ClauseSauvegarde();
  
  private ChangementAccesListeUniteReglementConvention2017ClauseSauvegarde()
  {
    setNomCorpsRegle("AccesListeUniteReglement");
    initialiserListeCorpsRegles();
    ajouterCorpsRegle(new OutilAccesListeUniteApresConvention2017ClauseSauvegarde());
  }
  
  public static final ChangementAccesListeUniteReglementConvention2017ClauseSauvegarde getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementAccesListeUniteReglementConvention2017ClauseSauvegarde
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */