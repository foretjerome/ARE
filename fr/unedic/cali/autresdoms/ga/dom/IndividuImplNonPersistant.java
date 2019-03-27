package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AppelGaecReduit;
import fr.unedic.cali.dom.IndividuChargementSpec;
import fr.unedic.cali.dom.IndividuIdSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;

public class IndividuImplNonPersistant
  extends IndividuGaecAbstrait
{
  private boolean sansRebond = false;
  
  public IndividuImplNonPersistant(IndividuIdSpec individuIdSpec)
  {
    super(individuIdSpec);
    setEstModifiable(true);
    setEstCharge(true);
  }
  
  public IndividuChargementSpec charger(AppelGaecReduit appelGaecReduit)
    throws ApplicativeException, TechniqueException
  {
    return charger();
  }
  
  public IndividuChargementSpec charger()
    throws ApplicativeException, TechniqueException
  {
    setEstCharge(true);
    return this;
  }
  
  public void enregistrerLA2K(IndividuSpec individu, Damj dateDebutExecution, ContexteService contexteService, int contexteExecution) {}
  
  public boolean isSansRebond()
  {
    return sansRebond;
  }
  
  public void setSansRebond(boolean sansRebond)
  {
    this.sansRebond = sansRebond;
  }
}

/* Location:
 * Qualified Name:     IndividuImplNonPersistant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */