package fr.unedic.cali.dom.pivot.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.dom.pivot.Aides;
import fr.unedic.cali.dom.pivot.AidesNcp;
import fr.unedic.cali.dom.pivot.Attribution;
import fr.unedic.cali.dom.pivot.Decision;
import fr.unedic.cali.dom.pivot.pc.DemandePivotPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public abstract class DemandePivotGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_demandePivotPC;
  private Attribution m_attribution;
  private Decision m_decision;
  private Aides m_aides;
  private AidesNcp m_aidesNcp;
  
  public DemandePivotGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public DemandePivotGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new DemandePivotPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_demandePivotPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_demandePivotPC)
  {
    m_demandePivotPC = p_demandePivotPC;
  }
  
  public Attribution getAttribution()
  {
    if (m_attribution == null)
    {
      DomPCSpec attributionPC = ((DemandePivotPC)getPC()).getAttribution();
      if (attributionPC != null) {
        m_attribution = ((Attribution)attributionPC.createOM());
      }
    }
    return m_attribution;
  }
  
  public void setAttribution(Attribution p_attribution)
  {
    if (p_attribution == null)
    {
      ((DemandePivotPC)getPC()).setAttribution(null);
      m_attribution = p_attribution;
    }
    else if (!p_attribution.equals(m_attribution))
    {
      ((DemandePivotPC)getPC()).setAttribution(p_attribution.getPC());
      m_attribution = p_attribution;
    }
  }
  
  public Decision getDecision()
  {
    if (m_decision == null)
    {
      DomPCSpec decisionPC = ((DemandePivotPC)getPC()).getDecision();
      if (decisionPC != null) {
        m_decision = ((Decision)decisionPC.createOM());
      }
    }
    return m_decision;
  }
  
  public void setDecision(Decision p_decision)
  {
    if (p_decision == null)
    {
      ((DemandePivotPC)getPC()).setDecision(null);
      m_decision = p_decision;
    }
    else if (!p_decision.equals(m_decision))
    {
      ((DemandePivotPC)getPC()).setDecision(p_decision.getPC());
      m_decision = p_decision;
    }
  }
  
  public Aides getAides()
  {
    if (m_aides == null)
    {
      DomPCSpec aidesPC = ((DemandePivotPC)getPC()).getAides();
      if (aidesPC != null) {
        m_aides = ((Aides)aidesPC.createOM());
      }
    }
    return m_aides;
  }
  
  public void setAides(Aides p_aides)
  {
    if (p_aides == null)
    {
      ((DemandePivotPC)getPC()).setAides(null);
      m_aides = p_aides;
    }
    else if (!p_aides.equals(m_aides))
    {
      ((DemandePivotPC)getPC()).setAides(p_aides.getPC());
      m_aides = p_aides;
    }
  }
  
  public AidesNcp getAidesNcp()
  {
    if (m_aidesNcp == null)
    {
      DomPCSpec aidesNcpPC = ((DemandePivotPC)getPC()).getAidesNcp();
      if (aidesNcpPC != null) {
        m_aidesNcp = ((AidesNcp)aidesNcpPC.createOM());
      }
    }
    return m_aidesNcp;
  }
  
  public void setAidesNcp(AidesNcp p_aidesNcp)
  {
    if (p_aidesNcp == null)
    {
      ((DemandePivotPC)getPC()).setAidesNcp(null);
      m_aidesNcp = p_aidesNcp;
    }
    else if (!p_aidesNcp.equals(m_aidesNcp))
    {
      ((DemandePivotPC)getPC()).setAidesNcp(p_aidesNcp.getPC());
      m_aidesNcp = p_aidesNcp;
    }
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    
    Object attribution = getAttribution();
    if ((attribution != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(attribution))) {
      DomManager.supprimer(getAttribution(), p_contexteSuppression);
    }
    Object decision = getDecision();
    if ((decision != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(decision))) {
      DomManager.supprimer(getDecision(), p_contexteSuppression);
    }
    Object aides = getAides();
    if ((aides != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(aides))) {
      DomManager.supprimer(getAides(), p_contexteSuppression);
    }
    Object aidesNcp = getAidesNcp();
    if ((aidesNcp != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(aidesNcp))) {
      DomManager.supprimer(getAidesNcp(), p_contexteSuppression);
    }
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     DemandePivotGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */