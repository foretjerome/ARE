package fr.unedic.cali.dom.pc;

import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.temps.ObjetChronoEvenementDebutPC;

public abstract class EvenementReferenceExamenAbstraitPC
  extends ObjetChronoEvenementDebutPC
  implements DomPCSpec
{
  public abstract Object createOM();
}

/* Location:
 * Qualified Name:     EvenementReferenceExamenAbstraitPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */