package fr.unedic.cali.dom;

import fr.unedic.cali.dom.gen.ClassementSansObjetGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public class ClassementSansObjet
  extends ClassementSansObjetGen
{
  private static final long serialVersionUID = 2160546199184643225L;
  
  public ClassementSansObjet() {}
  
  public ClassementSansObjet(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public String getTypeClassement()
  {
    return "SO";
  }
  
  public ObjetMetierSpec copie()
  {
    ClassementSansObjet copie = new ClassementSansObjet();
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
 * Qualified Name:     ClassementSansObjet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */