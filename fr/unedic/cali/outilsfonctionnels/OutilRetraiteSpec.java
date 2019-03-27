package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.DureeCalendaire;

public abstract interface OutilRetraiteSpec
{
  public abstract DureeCalendaire getAgeMinDepartRetraite(IndividuSpec paramIndividuSpec)
    throws CoucheLogiqueException;
}

/* Location:
 * Qualified Name:     OutilRetraiteSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */