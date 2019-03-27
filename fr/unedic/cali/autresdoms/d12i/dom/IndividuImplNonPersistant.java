package fr.unedic.cali.autresdoms.d12i.dom;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.IndividuChargementSpec;
import fr.unedic.cali.dom.IndividuIdSpec;
import java.util.HashMap;
import java.util.Map;

public class IndividuImplNonPersistant
  extends IndividuInstructionAbstrait
{
  private boolean sansRebond = false;
  
  public IndividuImplNonPersistant(IndividuIdSpec individuIdSpec)
  {
    super(individuIdSpec);
    demandesInstruction = new HashMap();
    setEstModifiable(true);
    setEstCharge(true);
  }
  
  public IndividuChargementSpec charger()
    throws ApplicativeException, TechniqueException
  {
    setEstCharge(true);
    return this;
  }
  
  public boolean isSansRebond()
  {
    return sansRebond;
  }
  
  public void setSansRebond(boolean sansRebond)
  {
    this.sansRebond = sansRebond;
  }
  
  public DemandeInstruction getDemandeInstruction(String referenceExterne)
  {
    return (DemandeInstruction)demandesInstruction.get(referenceExterne);
  }
}

/* Location:
 * Qualified Name:     IndividuImplNonPersistant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */