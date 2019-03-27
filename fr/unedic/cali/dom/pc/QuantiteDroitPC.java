package fr.unedic.cali.dom.pc;

import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.Quantite;

public abstract class QuantiteDroitPC
  implements DomPCSpec
{
  protected int m_etat = 0;
  protected Quantite m_quantiteCourante;
  protected Quantite m_quantiteInitial;
  
  public abstract Object createOM();
  
  public Quantite getQuantiteInitial()
  {
    return m_quantiteInitial;
  }
  
  public final void setQuantiteInitial(Quantite p_quantiteInitial)
  {
    m_quantiteInitial = p_quantiteInitial;
  }
}

/* Location:
 * Qualified Name:     QuantiteDroitPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */