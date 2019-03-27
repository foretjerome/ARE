package fr.unedic.cali.autresdoms.cohab.sigma.formation.dom.spec;

import fr.unedic.util.temps.Damj;

public abstract interface StructureInFormationV1Spec
{
  public abstract Damj getDateRecherche();
  
  public abstract void setDateRecherche(Damj paramDamj);
  
  public abstract int getIdentifiantActionFormation();
  
  public abstract void setIdentifiantActionFormation(int paramInt);
}

/* Location:
 * Qualified Name:     StructureInFormationV1Spec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */