package fr.unedic.cali.autresdoms.ga.dom.spec;

import fr.unedic.util.temps.Temporel;

public abstract interface CertifieSpec
  extends Temporel
{
  public abstract boolean estAtteste();
  
  public abstract void setEstAtteste(boolean paramBoolean);
  
  public abstract boolean estQualifiable();
}

/* Location:
 * Qualified Name:     CertifieSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */