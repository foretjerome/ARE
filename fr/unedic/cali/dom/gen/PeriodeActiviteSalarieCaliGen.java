package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.pc.PeriodeActiviteSalarieCaliPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public abstract class PeriodeActiviteSalarieCaliGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_periodeActiviteSalarieCaliPC;
  
  public PeriodeActiviteSalarieCaliGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public PeriodeActiviteSalarieCaliGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new PeriodeActiviteSalarieCaliPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_periodeActiviteSalarieCaliPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_periodeActiviteSalarieCaliPC)
  {
    m_periodeActiviteSalarieCaliPC = p_periodeActiviteSalarieCaliPC;
  }
  
  protected boolean rawIsEstLiquidable()
  {
    return ((PeriodeActiviteSalarieCaliPC)getPC()).isEstLiquidable();
  }
  
  public boolean isEstLiquidable()
  {
    return ((PeriodeActiviteSalarieCaliPC)getPC()).isEstLiquidable();
  }
  
  public void setEstLiquidable(boolean p_estLiquidable)
  {
    ((PeriodeActiviteSalarieCaliPC)getPC()).setEstLiquidable(p_estLiquidable);
  }
  
  protected boolean rawIsEstFctPrincipale()
  {
    return ((PeriodeActiviteSalarieCaliPC)getPC()).isEstFctPrincipale();
  }
  
  public boolean isEstFctPrincipale()
  {
    return ((PeriodeActiviteSalarieCaliPC)getPC()).isEstFctPrincipale();
  }
  
  public void setEstFctPrincipale(boolean p_estFctPrincipale)
  {
    ((PeriodeActiviteSalarieCaliPC)getPC()).setEstFctPrincipale(p_estFctPrincipale);
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     PeriodeActiviteSalarieCaliGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */