package fr.unedic.cali.dom;

import fr.unedic.cali.dom.gen.ClassementCompetenceSecteurPublicGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public class ClassementCompetenceSecteurPublic
  extends ClassementCompetenceSecteurPublicGen
{
  private static final long serialVersionUID = 5160520468424750804L;
  
  public ClassementCompetenceSecteurPublic() {}
  
  public ClassementCompetenceSecteurPublic(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public String getTypeClassement()
  {
    return "SP";
  }
  
  public ObjetMetierSpec copie()
  {
    ClassementCompetenceSecteurPublic copie = new ClassementCompetenceSecteurPublic();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    super.copieElements(p_copie);
    ((ClassementCompetenceSecteurPublic)p_copie).setMotifNotification(getMotifNotification());
    ((ClassementCompetenceSecteurPublic)p_copie).setEmployeurCompetent(getEmployeurCompetent());
  }
  
  public boolean estClassementValide()
  {
    return true;
  }
  
  public void marquerGraphePersistant() {}
}

/* Location:
 * Qualified Name:     ClassementCompetenceSecteurPublic
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */