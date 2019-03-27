package fr.unedic.cali.calcul.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.calcul.dom.pc.DecalageDureePC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;

public abstract class DecalageDureeGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_decalageDureePC;
  private Quantite m_decalageCourant;
  
  public DecalageDureeGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public DecalageDureeGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new DecalageDureePC();
  }
  
  public DomPCSpec getPC()
  {
    return m_decalageDureePC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_decalageDureePC)
  {
    m_decalageDureePC = p_decalageDureePC;
  }
  
  protected Quantite rawGetDecalageCourant()
  {
    return ((DecalageDureePC)getPC()).getDecalageCourant();
  }
  
  public Quantite getDecalageCourant()
  {
    return ((DecalageDureePC)getPC()).getDecalageCourant();
  }
  
  public void setDecalageCourant(Quantite p_decalageCourant)
  {
    if ((m_decalageCourant == null) || (p_decalageCourant == null))
    {
      m_decalageCourant = p_decalageCourant;
      ((DecalageDureePC)getPC()).setDecalageCourant(p_decalageCourant);
    }
    else if ((m_decalageCourant != null) && (p_decalageCourant != null) && (!p_decalageCourant.equals(m_decalageCourant)))
    {
      m_decalageCourant = p_decalageCourant;
      ((DecalageDureePC)getPC()).setDecalageCourant(p_decalageCourant);
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
 * Qualified Name:     DecalageDureeGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */