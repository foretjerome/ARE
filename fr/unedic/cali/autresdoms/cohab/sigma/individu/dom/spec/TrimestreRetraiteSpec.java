package fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.spec;

import fr.unedic.util.temps.Damj;

public abstract interface TrimestreRetraiteSpec
{
  public abstract int getNombreTrimestre();
  
  public abstract void setNombreTrimestre(int paramInt);
  
  public abstract Damj getDateValeurTrimestre();
  
  public abstract void setDateValeurTrimestre(Damj paramDamj);
  
  public abstract Damj getDateCentTrimestres();
  
  public abstract void setDateCentTrimestres(Damj paramDamj);
}

/* Location:
 * Qualified Name:     TrimestreRetraiteSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */