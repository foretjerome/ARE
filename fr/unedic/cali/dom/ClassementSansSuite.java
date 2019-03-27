package fr.unedic.cali.dom;

import fr.unedic.cali.dom.gen.ClassementSansSuiteGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public class ClassementSansSuite
  extends ClassementSansSuiteGen
{
  private static final long serialVersionUID = -7321041869644417301L;
  
  public ClassementSansSuite() {}
  
  public ClassementSansSuite(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public ObjetMetierSpec copie()
  {
    ClassementSansSuite copie = new ClassementSansSuite();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    super.copieElements(p_copie);
    ((ClassementSansSuite)p_copie).setMotif(getMotif());
  }
  
  public String getTypeClassement()
  {
    return "SS";
  }
  
  public boolean estClassementValide()
  {
    return true;
  }
  
  public void marquerGraphePersistant() {}
}

/* Location:
 * Qualified Name:     ClassementSansSuite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */