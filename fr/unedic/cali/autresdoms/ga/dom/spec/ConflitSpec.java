package fr.unedic.cali.autresdoms.ga.dom.spec;

import fr.unedic.util.temps.Temporel;

public abstract interface ConflitSpec
  extends Temporel
{
  public abstract boolean estEnConflit();
  
  public abstract void setEnConflit(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     ConflitSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */