package fr.unedic.cali.autresdoms.cohab.dom.spec;

import fr.unedic.cali.dom.IndividuIdSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Temporel;

public abstract interface PeriodeCohabSpec
  extends Temporel, ObjetMetierSpec
{
  public abstract IndividuIdSpec getIdentifiantIndividu();
  
  public abstract void setIdentifiantIndividu(IndividuIdSpec paramIndividuIdSpec);
  
  public abstract int getDuree();
}

/* Location:
 * Qualified Name:     PeriodeCohabSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */