package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.NaturesDecisions;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.temps.Temporel;

public class FiltreRepriseSurDecisions
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepterElement(Temporel p_temporel)
  {
    DecisionSpec decision = (DecisionSpec)p_temporel;
    return NaturesDecisions.estdeTypeReprise(decision.getNatureDecision());
  }
  
  public int getTypeElementManipule()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     FiltreRepriseSurDecisions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */