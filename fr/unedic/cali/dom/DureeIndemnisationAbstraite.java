package fr.unedic.cali.dom;

import fr.unedic.cali.dom.gen.DureeIndemnisationAbstraiteGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;

public abstract class DureeIndemnisationAbstraite
  extends DureeIndemnisationAbstraiteGen
{
  public DureeIndemnisationAbstraite() {}
  
  public DureeIndemnisationAbstraite(DomPCSpec p_pc)
  {
    super(p_pc);
  }
}

/* Location:
 * Qualified Name:     DureeIndemnisationAbstraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */