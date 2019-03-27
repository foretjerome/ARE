package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.calcul.dom.gen.ConstituantsCalculActiviteReduiteGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;

public abstract class ConstituantsCalculActiviteReduite
  extends ConstituantsCalculActiviteReduiteGen
  implements ConstituantsCalculActiviteReduiteSpec
{
  private static final long serialVersionUID = 1L;
  
  public ConstituantsCalculActiviteReduite() {}
  
  public ConstituantsCalculActiviteReduite(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public boolean estConnuNbMoisInactivite()
  {
    return true;
  }
  
  public int getCumulMoisNonIndemnise()
  {
    return 0;
  }
  
  public void setCumulMoisNonIndemnise(int p_cumulMoisNonIndemnise) {}
  
  public void marquerGraphePersistant() {}
}

/* Location:
 * Qualified Name:     ConstituantsCalculActiviteReduite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */