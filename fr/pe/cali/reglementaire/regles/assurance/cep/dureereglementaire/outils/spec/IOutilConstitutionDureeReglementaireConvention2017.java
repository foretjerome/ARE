package fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.spec;

import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.dom.DonneesEntreesDureeReglementaireConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.dom.ResultatDureeReglementaireConvention2017;
import fr.unedic.util.services.CoucheLogiqueException;

public abstract interface IOutilConstitutionDureeReglementaireConvention2017
  extends IOutilConstitutionDureeReglementaire
{
  public abstract ResultatDureeReglementaireConvention2017 determinerDureeReglementaire(DonneesEntreesDureeReglementaireConvention2017 paramDonneesEntreesDureeReglementaireConvention2017)
    throws CoucheLogiqueException;
}

/* Location:
 * Qualified Name:     IOutilConstitutionDureeReglementaireConvention2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */