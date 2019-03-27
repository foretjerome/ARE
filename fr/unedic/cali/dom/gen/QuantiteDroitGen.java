package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.pc.QuantiteDroitPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;

public abstract class QuantiteDroitGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_quantiteDroitPC;
  private Quantite m_quantiteCourante;
  private Quantite m_quantiteInitial;
  
  public QuantiteDroitGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public QuantiteDroitGen()
  {
    setPC(createPC());
  }
  
  protected abstract DomPCSpec createPC();
  
  public DomPCSpec getPC()
  {
    return m_quantiteDroitPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_quantiteDroitPC)
  {
    m_quantiteDroitPC = p_quantiteDroitPC;
  }
  
  protected Quantite rawGetQuantiteInitial()
  {
    return ((QuantiteDroitPC)getPC()).getQuantiteInitial();
  }
  
  public Quantite getQuantiteInitial()
  {
    return ((QuantiteDroitPC)getPC()).getQuantiteInitial();
  }
  
  public void setQuantiteInitial(Quantite p_quantiteInitial)
  {
    if ((m_quantiteInitial == null) || (p_quantiteInitial == null))
    {
      m_quantiteInitial = p_quantiteInitial;
      ((QuantiteDroitPC)getPC()).setQuantiteInitial(p_quantiteInitial);
    }
    else if ((m_quantiteInitial != null) && (p_quantiteInitial != null) && (!p_quantiteInitial.equals(m_quantiteInitial)))
    {
      m_quantiteInitial = p_quantiteInitial;
      ((QuantiteDroitPC)getPC()).setQuantiteInitial(p_quantiteInitial);
    }
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     QuantiteDroitGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */