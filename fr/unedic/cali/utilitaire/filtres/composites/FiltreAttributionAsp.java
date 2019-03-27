package fr.unedic.cali.utilitaire.filtres.composites;

import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionPourTypeProduit;
import fr.unedic.util.temps.Temporel;

public class FiltreAttributionAsp
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepterElement(Temporel p_temporel)
  {
    FiltreDecisionPourTypeProduit filtreAsr = new FiltreDecisionPourTypeProduit(2);
    return filtreAsr.accepter(p_temporel);
  }
  
  public int getTypeElementManipule()
  {
    return -1;
  }
}

/* Location:
 * Qualified Name:     FiltreAttributionAsp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */