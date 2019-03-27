package fr.unedic.cali.dom;

import fr.unedic.cali.dom.gen.TestProductionGen;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public class TestProduction
  extends TestProductionGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = -5548576601677230615L;
  
  public TestProduction() {}
  
  public TestProduction(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void marquerGraphePersistant()
  {
    DomManager.persisterObjet(this);
  }
  
  public ObjetMetierSpec copie()
  {
    TestProduction copie = new TestProduction();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    TestProduction copie = (TestProduction)p_copie;
    copie.setDateJour(getDateJour());
  }
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void jdoPostLoad() {}
  
  public void jdoPreStore() {}
  
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    sb.append("TestProduction:");
    sb.append("\n\tDate du test:");
    sb.append("\n\t" + getDateJour());
    return sb.toString();
  }
}

/* Location:
 * Qualified Name:     TestProduction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */