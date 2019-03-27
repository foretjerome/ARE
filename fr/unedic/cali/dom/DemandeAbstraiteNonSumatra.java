package fr.unedic.cali.dom;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.cali.calcul.dom.UniteTraitementForcee;
import fr.unedic.transverse.dom.spec.DomPCSpec;

public abstract class DemandeAbstraiteNonSumatra
  extends DemandeAbstraite
{
  private DemandeAbstraiteNonSumatraPC m_pc;
  
  public DemandeAbstraiteNonSumatra() {}
  
  public DemandeAbstraiteNonSumatra(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  protected DomPCSpec createPC()
  {
    m_pc = new DemandeAbstraiteNonSumatraPC(this);
    return m_pc;
  }
  
  public DomPCSpec getPC()
  {
    return m_pc;
  }
  
  public void ajouterForcageExecution(UniteTraitementForcee p_ut)
  {
    throw ExceptionUtil.shouldNotPassHere("");
  }
}

/* Location:
 * Qualified Name:     DemandeAbstraiteNonSumatra
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */