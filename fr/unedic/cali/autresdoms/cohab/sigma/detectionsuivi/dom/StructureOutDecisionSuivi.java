package fr.unedic.cali.autresdoms.cohab.sigma.detectionsuivi.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.detectionsuivi.dom.spec.DecisionSuiviSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.detectionsuivi.dom.spec.StructureOutDecisionSuiviSpec;
import java.util.ArrayList;
import java.util.Collection;

public class StructureOutDecisionSuivi
  implements StructureOutDecisionSuiviSpec
{
  private Collection m_listeDecisions = new ArrayList();
  
  public Collection getListeDecisionsSuivi()
  {
    return m_listeDecisions;
  }
  
  public void ajouterDecision(DecisionSuiviSpec p_decision)
  {
    if (m_listeDecisions == null) {
      m_listeDecisions = new ArrayList();
    }
    m_listeDecisions.add(p_decision);
  }
}

/* Location:
 * Qualified Name:     StructureOutDecisionSuivi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */