package fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.outils.spec;

import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.dom.DonneesEntreeListeUniteParReglement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.dom.ResultatListeUniteParReglement;

public abstract interface IOutilAccesListeUniteParReglement
  extends IOutilCorpsRegle
{
  public abstract ResultatListeUniteParReglement determinerListeUnite(DonneesEntreeListeUniteParReglement paramDonneesEntreeListeUniteParReglement);
}

/* Location:
 * Qualified Name:     IOutilAccesListeUniteParReglement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */