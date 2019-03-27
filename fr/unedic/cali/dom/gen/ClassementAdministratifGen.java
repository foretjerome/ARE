package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public abstract class ClassementAdministratifGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_classementAdministratifPC;
  
  public ClassementAdministratifGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public ClassementAdministratifGen()
  {
    setPC(createPC());
  }
  
  protected abstract DomPCSpec createPC();
  
  public DomPCSpec getPC()
  {
    return m_classementAdministratifPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_classementAdministratifPC)
  {
    m_classementAdministratifPC = p_classementAdministratifPC;
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     ClassementAdministratifGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */