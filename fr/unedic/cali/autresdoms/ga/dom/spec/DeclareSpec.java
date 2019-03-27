package fr.unedic.cali.autresdoms.ga.dom.spec;

import fr.unedic.util.temps.Temporel;

public abstract interface DeclareSpec
  extends Temporel
{
  public abstract boolean estJustifie();
  
  public abstract void setEstJustifie(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     DeclareSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */