package fr.unedic.cali.dom;

import fr.unedic.cali.dom.gen.ClassementAdministratifGen;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import javax.jdo.JDOHelper;

public abstract class ClassementAdministratif
  extends ClassementAdministratifGen
  implements ObjetPersistantSpec, ClassementAdministratifSpec
{
  public ClassementAdministratif() {}
  
  public ClassementAdministratif(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public String getTypeClassement()
  {
    return "  ";
  }
  
  public String getIdentifiant()
  {
    if (!JDOHelper.isPersistent(this)) {
      return String.valueOf(hashCode());
    }
    return DomManager.getIdentifiant(this);
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void jdoPreStore() {}
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     ClassementAdministratif
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */