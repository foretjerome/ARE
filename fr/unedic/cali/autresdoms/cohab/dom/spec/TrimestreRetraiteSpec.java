package fr.unedic.cali.autresdoms.cohab.dom.spec;

import fr.unedic.util.temps.Temporel;

public abstract interface TrimestreRetraiteSpec
  extends Temporel
{
  public abstract Integer getNombreTrimestre();
  
  public abstract void setNombreTrimestre(Integer paramInteger);
}

/* Location:
 * Qualified Name:     TrimestreRetraiteSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */