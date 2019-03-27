package fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.spec;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Spec.StructureInSpec;
import fr.unedic.util.temps.Damj;

public abstract interface StructureInBlocageActuSpec
  extends StructureInSpec
{
  public abstract Damj getDateDebut();
  
  public abstract void setDateDebut(Damj paramDamj);
  
  public abstract Damj getDateFin();
  
  public abstract void setDateFin(Damj paramDamj);
}

/* Location:
 * Qualified Name:     StructureInBlocageActuSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */