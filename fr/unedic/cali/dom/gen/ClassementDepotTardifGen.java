package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.cali.dom.pc.ClassementDepotTardifPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public abstract class ClassementDepotTardifGen
  extends ClassementAdministratif
  implements DomGenSpec
{
  public ClassementDepotTardifGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public ClassementDepotTardifGen() {}
  
  protected DomPCSpec createPC()
  {
    return new ClassementDepotTardifPC();
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
 * Qualified Name:     ClassementDepotTardifGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */