package fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.outils.spec;

import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.dom.DonneesEntreeDateLimiteSpectacle;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.dom.DonneesSortieDateLimiteSpectacle;
import fr.unedic.archi.logique.exception.ApplicativeException;

public abstract interface IOutilConstitutionDateLimiteSpectacle
  extends IOutilConstitutionDateLimite
{
  public abstract DonneesSortieDateLimiteSpectacle calculerDateLimiteIndemnisation(DonneesEntreeDateLimiteSpectacle paramDonneesEntreeDateLimiteSpectacle)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     IOutilConstitutionDateLimiteSpectacle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */