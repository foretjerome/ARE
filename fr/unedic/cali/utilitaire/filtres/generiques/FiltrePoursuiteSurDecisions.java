package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.NaturesDecisions;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.temps.Temporel;

public class FiltrePoursuiteSurDecisions
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  
  public int getTypeElementManipule()
  {
    return 1;
  }
  
  public boolean accepterElement(Temporel temporel)
  {
    DecisionSpec decision = (DecisionSpec)temporel;
    return NaturesDecisions.estdeTypePoursuite(decision.getNatureDecision());
  }
}

/* Location:
 * Qualified Name:     FiltrePoursuiteSurDecisions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */