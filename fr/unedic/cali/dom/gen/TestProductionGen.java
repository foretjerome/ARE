package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.pc.TestProductionPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public abstract class TestProductionGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_testProductionPC;
  private Damj m_dateJour = null;
  
  public TestProductionGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public TestProductionGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new TestProductionPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_testProductionPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_testProductionPC)
  {
    m_testProductionPC = p_testProductionPC;
  }
  
  protected Damj rawGetDateJour()
  {
    return ((TestProductionPC)getPC()).getDateJour();
  }
  
  public Damj getDateJour()
  {
    return ((TestProductionPC)getPC()).getDateJour();
  }
  
  public void setDateJour(Damj p_dateJour)
  {
    if ((m_dateJour == null) || (p_dateJour == null))
    {
      m_dateJour = p_dateJour;
      ((TestProductionPC)getPC()).setDateJour(p_dateJour);
    }
    else if ((m_dateJour != null) && (p_dateJour != null) && (!p_dateJour.equals(m_dateJour)))
    {
      m_dateJour = p_dateJour;
      ((TestProductionPC)getPC()).setDateJour(p_dateJour);
    }
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     TestProductionGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */