package fr.unedic.cali.calcul.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalcul;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public abstract class CalendrierExecutionCalculPonctuelGen
  extends CalendrierExecutionCalcul
  implements DomGenSpec
{
  public CalendrierExecutionCalculPonctuelGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public CalendrierExecutionCalculPonctuelGen() {}
  
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
 * Qualified Name:     CalendrierExecutionCalculPonctuelGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */