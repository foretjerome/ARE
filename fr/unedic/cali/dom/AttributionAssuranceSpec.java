package fr.unedic.cali.dom;

import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public abstract interface AttributionAssuranceSpec
  extends AttributionSpec, DecisionAssuranceSpec
{
  public abstract boolean estTopeeRenoncement();
  
  public abstract OdAssuranceSpec getOuvertureDroit();
  
  public abstract String getContexteDateLimiteIndemnisation()
    throws CoucheLogiqueException;
  
  public abstract Damj getDateLimiteIndemnisation()
    throws CoucheLogiqueException;
  
  public abstract boolean estMaintenue();
}

/* Location:
 * Qualified Name:     AttributionAssuranceSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */