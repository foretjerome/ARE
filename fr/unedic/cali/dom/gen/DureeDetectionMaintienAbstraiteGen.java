package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.QuantiteDroit;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public abstract class DureeDetectionMaintienAbstraiteGen
  extends QuantiteDroit
  implements DomGenSpec
{
  public DureeDetectionMaintienAbstraiteGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public DureeDetectionMaintienAbstraiteGen() {}
  
  protected abstract DomPCSpec createPC();
  
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
 * Qualified Name:     DureeDetectionMaintienAbstraiteGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */