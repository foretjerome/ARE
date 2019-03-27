package fr.unedic.cali.dom.pivot;

import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.dom.pivot.gen.AidesNcpGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public class AidesNcp
  extends AidesNcpGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = -1822200704340209827L;
  
  public AidesNcp() {}
  
  public AidesNcp(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public void initInstance()
  {
    AidesNcp aideVide = new AidesNcp();
    aideVide.copieElements(this);
  }
  
  public ObjetMetierSpec copie()
  {
    AidesNcp copieAidesNcp = new AidesNcp();
    copieElements(copieAidesNcp);
    return copieAidesNcp;
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void marquerGraphePersistant() {}
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    AidesNcp copieAidesNcp = (AidesNcp)p_copie;
    copieAidesNcp.setCapitalBanalise1(getCapitalBanalise1());
    copieAidesNcp.setCapitalBanalise2(getCapitalBanalise2());
    copieAidesNcp.setCapitalBanalise3(getCapitalBanalise3());
    copieAidesNcp.setDateBanalisee1(getDateBanalisee1());
    copieAidesNcp.setDateBanalisee2(getDateBanalisee2());
    copieAidesNcp.setDateBanalisee3(getDateBanalisee3());
    copieAidesNcp.setDateBanalisee4(getDateBanalisee4());
    copieAidesNcp.setDateBanalisee5(getDateBanalisee5());
    copieAidesNcp.setIdentifiantBanalise1(getIdentifiantBanalise1());
    copieAidesNcp.setIdentifiantBanalise2(getIdentifiantBanalise2());
    copieAidesNcp.setIdentifiantBanalise3(getIdentifiantBanalise3());
    copieAidesNcp.setLibelleBanalise1(getLibelleBanalise1());
    copieAidesNcp.setLibelleBanalise2(getLibelleBanalise2());
    copieAidesNcp.setLibelleBanalise3(getLibelleBanalise3());
    copieAidesNcp.setLibelleBanalise4(getLibelleBanalise4());
    copieAidesNcp.setLibelleBanalise5(getLibelleBanalise5());
    copieAidesNcp.setNbJoursBanalise1(getNbJoursBanalise1());
    copieAidesNcp.setNbJoursBanalise2(getNbJoursBanalise2());
    copieAidesNcp.setNbJoursBanalise3(getNbJoursBanalise3());
  }
}

/* Location:
 * Qualified Name:     AidesNcp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */