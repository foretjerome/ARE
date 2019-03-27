package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.temps.Temporel;

public class FiltreDecisionPourNatureDecision
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private int m_natureDecision;
  
  public FiltreDecisionPourNatureDecision(int p_natureDecision)
  {
    m_natureDecision = p_natureDecision;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    DecisionSpec decision = (DecisionSpec)p_temporel;
    
    return m_natureDecision == decision.getNatureDecision();
  }
  
  public int getTypeElementManipule()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     FiltreDecisionPourNatureDecision
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */