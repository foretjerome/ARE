package fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.spec;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Spec.CriteresSpec;
import fr.unedic.util.temps.Damj;

public abstract interface CriteresBlocageActuSpec
  extends CriteresSpec
{
  public abstract String getNumeroAllocataire();
  
  public abstract void setNumeroAllocataire(String paramString);
  
  public abstract Damj getDateDebut();
  
  public abstract void setDateDebut(Damj paramDamj);
  
  public abstract Damj getDateFin();
  
  public abstract void setDateFin(Damj paramDamj);
}

/* Location:
 * Qualified Name:     CriteresBlocageActuSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */