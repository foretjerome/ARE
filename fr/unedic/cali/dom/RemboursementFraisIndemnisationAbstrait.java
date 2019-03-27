package fr.unedic.cali.dom;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeHomogene;
import fr.unedic.cali.dom.gen.RemboursementFraisIndemnisationAbstraitGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;

public abstract class RemboursementFraisIndemnisationAbstrait
  extends RemboursementFraisIndemnisationAbstraitGen
{
  public RemboursementFraisIndemnisationAbstrait() {}
  
  public RemboursementFraisIndemnisationAbstrait(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public abstract ObjetChronoPeriodeHomogene getPeriodeHomogene();
}

/* Location:
 * Qualified Name:     RemboursementFraisIndemnisationAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */