package fr.unedic.cali.dom.pivot;

import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.dom.pivot.gen.DerogationGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public class Derogation
  extends DerogationGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = 1L;
  
  public Derogation() {}
  
  public Derogation(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public ObjetMetierSpec copie()
  {
    Derogation copieAides = new Derogation();
    copieElements(copieAides);
    return copieAides;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    Derogation copie = (Derogation)p_copie;
    copie.setNatureDerogation(getNatureDerogation());
    copie.setTypeDerogation(getTypeDerogation());
  }
  
  public void marquerGraphePersistant() {}
}

/* Location:
 * Qualified Name:     Derogation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */