package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.cali.dom.pc.ClassementSansObjetPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public abstract class ClassementSansObjetGen
  extends ClassementAdministratif
  implements DomGenSpec
{
  public ClassementSansObjetGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public ClassementSansObjetGen() {}
  
  protected DomPCSpec createPC()
  {
    return new ClassementSansObjetPC();
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    
    super.supprimerEnProfondeur(p_contexteSuppression);
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    super.copieElements(p_copie);
  }
}

/* Location:
 * Qualified Name:     ClassementSansObjetGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */