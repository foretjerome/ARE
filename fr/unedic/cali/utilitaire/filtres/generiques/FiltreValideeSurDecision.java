package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.temps.Temporel;

public class FiltreValideeSurDecision
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepterElement(Temporel p_temporel)
  {
    return ((DecisionSpec)p_temporel).estValidee();
  }
  
  public int getTypeElementManipule()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     FiltreValideeSurDecision
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */