package fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.outils.spec;

import fr.pe.cali.reglementaire.outils.spec.IOutilFonctionnel;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.util.temps.Damj;

public abstract interface IOutilFonctionnelDateLimiteSpectacle2016
  extends IOutilFonctionnel
{
  public abstract Damj getDateLimiteIndemnisationDroitPrecedent(Damj paramDamj)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     IOutilFonctionnelDateLimiteSpectacle2016
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */