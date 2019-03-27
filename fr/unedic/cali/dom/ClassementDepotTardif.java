package fr.unedic.cali.dom;

import fr.unedic.cali.dom.gen.ClassementDepotTardifGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public class ClassementDepotTardif
  extends ClassementDepotTardifGen
{
  private static final long serialVersionUID = -4234944668620191288L;
  
  public ClassementDepotTardif() {}
  
  public ClassementDepotTardif(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public String getTypeClassement()
  {
    return "DT";
  }
  
  public ObjetMetierSpec copie()
  {
    ClassementDepotTardif copie = new ClassementDepotTardif();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    super.copieElements(p_copie);
  }
  
  public boolean estClassementValide()
  {
    return true;
  }
  
  public void marquerGraphePersistant() {}
}

/* Location:
 * Qualified Name:     ClassementDepotTardif
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */