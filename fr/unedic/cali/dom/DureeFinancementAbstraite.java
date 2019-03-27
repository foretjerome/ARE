package fr.unedic.cali.dom;

import fr.unedic.cali.dom.gen.DureeFinancementAbstraiteGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;

public abstract class DureeFinancementAbstraite
  extends DureeFinancementAbstraiteGen
{
  public DureeFinancementAbstraite() {}
  
  public DureeFinancementAbstraite(DomPCSpec p_pc)
  {
    super(p_pc);
  }
}

/* Location:
 * Qualified Name:     DureeFinancementAbstraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */