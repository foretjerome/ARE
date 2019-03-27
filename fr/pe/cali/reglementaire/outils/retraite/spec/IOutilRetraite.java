package fr.pe.cali.reglementaire.outils.retraite.spec;

import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;

public abstract interface IOutilRetraite
{
  public abstract DureeCalendaire getAgeMinDepartRetraite(Damj paramDamj)
    throws CoucheLogiqueException;
}

/* Location:
 * Qualified Name:     IOutilRetraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */