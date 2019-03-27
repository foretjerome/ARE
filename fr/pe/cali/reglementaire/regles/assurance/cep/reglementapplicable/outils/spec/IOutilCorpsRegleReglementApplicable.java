package fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.outils.spec;

import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.dom.DonneesEntreesRegleReglementApplicable;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.dom.ResultatRegleReglementApplicable;
import fr.unedic.archi.logique.exception.ApplicativeException;

public abstract interface IOutilCorpsRegleReglementApplicable
  extends IOutilCorpsRegle
{
  public abstract ResultatRegleReglementApplicable determinerReglementApplicable(DonneesEntreesRegleReglementApplicable paramDonneesEntreesRegleReglementApplicable)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     IOutilCorpsRegleReglementApplicable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */