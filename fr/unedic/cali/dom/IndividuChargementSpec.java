package fr.unedic.cali.dom;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;

public abstract interface IndividuChargementSpec
{
  public abstract String getNomIndividu();
  
  public abstract boolean estCharge();
  
  public abstract void setEstCharge(boolean paramBoolean);
  
  public abstract IndividuChargementSpec charger()
    throws ApplicativeException, TechniqueException;
  
  public abstract boolean estModifiable();
  
  public abstract void setEstModifiable(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     IndividuChargementSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */