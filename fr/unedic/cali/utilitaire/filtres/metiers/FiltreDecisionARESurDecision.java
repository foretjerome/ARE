package fr.unedic.cali.utilitaire.filtres.metiers;

import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionPourTypeProduit;
import fr.unedic.util.temps.Temporel;

public class FiltreDecisionARESurDecision
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepterElement(Temporel p_temporel)
  {
    FiltreDecisionPourTypeProduit filtreAre = new FiltreDecisionPourTypeProduit(5);
    return filtreAre.accepter(p_temporel);
  }
  
  public int getTypeElementManipule()
  {
    return -1;
  }
}

/* Location:
 * Qualified Name:     FiltreDecisionARESurDecision
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */