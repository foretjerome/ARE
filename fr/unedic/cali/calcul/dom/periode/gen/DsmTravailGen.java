package fr.unedic.cali.calcul.dom.periode.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.calcul.dom.periode.PeriodeTravailCREM;
import fr.unedic.cali.calcul.dom.periode.pc.DsmTravailPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public abstract class DsmTravailGen
  extends PeriodeTravailCREM
  implements DomGenSpec
{
  public DsmTravailGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public DsmTravailGen() {}
  
  public DsmTravailGen(Damj p_debut, Damj p_fin)
  {
    super(p_debut, p_fin);
  }
  
  protected DomPCSpec createPC()
  {
    return new DsmTravailPC();
  }
  
  protected boolean rawIsIsJustifiee()
  {
    return ((DsmTravailPC)getPC()).isIsJustifiee();
  }
  
  public boolean isIsJustifiee()
  {
    return ((DsmTravailPC)getPC()).isIsJustifiee();
  }
  
  public void setIsJustifiee(boolean p_isJustifiee)
  {
    ((DsmTravailPC)getPC()).setIsJustifiee(p_isJustifiee);
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
 * Qualified Name:     DsmTravailGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */