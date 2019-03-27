package fr.unedic.cali.dom;

import fr.unedic.cali.dom.gen.DureeProlongationAbstraiteGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;

public abstract class DureeProlongationAbstraite
  extends DureeProlongationAbstraiteGen
{
  private static final long serialVersionUID = -8390355304178919805L;
  private transient boolean contexteAllongementAref = false;
  
  public boolean isContexteAllongementAref()
  {
    return contexteAllongementAref;
  }
  
  public void setContexteAllongementAref(boolean contexteAllongementAref)
  {
    this.contexteAllongementAref = contexteAllongementAref;
  }
  
  public DureeProlongationAbstraite() {}
  
  public DureeProlongationAbstraite(DomPCSpec pc)
  {
    super(pc);
  }
}

/* Location:
 * Qualified Name:     DureeProlongationAbstraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */