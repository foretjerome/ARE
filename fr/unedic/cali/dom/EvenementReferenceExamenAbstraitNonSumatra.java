package fr.unedic.cali.dom;

import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.temps.Damj;

public abstract class EvenementReferenceExamenAbstraitNonSumatra
  extends EvenementReferenceExamenAbstrait
  implements DomPCSpec
{
  public EvenementReferenceExamenAbstraitNonSumatra() {}
  
  public EvenementReferenceExamenAbstraitNonSumatra(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public EvenementReferenceExamenAbstraitNonSumatra(Damj p_dateEvenement)
  {
    super(p_dateEvenement);
  }
  
  protected DomPCSpec createPC()
  {
    return null;
  }
  
  public Object createOM()
  {
    return this;
  }
  
  public DomPCSpec getPC()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     EvenementReferenceExamenAbstraitNonSumatra
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */