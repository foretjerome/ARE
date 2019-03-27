package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public abstract class DemandeAbstraiteGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_demandeAbstraitePC;
  
  public DemandeAbstraiteGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public DemandeAbstraiteGen()
  {
    setPC(createPC());
  }
  
  protected abstract DomPCSpec createPC();
  
  public DomPCSpec getPC()
  {
    return m_demandeAbstraitePC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_demandeAbstraitePC)
  {
    m_demandeAbstraitePC = p_demandeAbstraitePC;
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     DemandeAbstraiteGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */