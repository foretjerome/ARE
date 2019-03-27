package fr.unedic.cali.utilitaire.filtres.composites;

import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionPourProduit;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreOU;
import fr.unedic.util.temps.Temporel;

public class FiltreAttributionAdr
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepterElement(Temporel p_temporel)
  {
    FiltreOU filtre = new FiltreOU();
    filtre.ajouterFiltre(new FiltreDecisionPourProduit(38));
    return filtre.accepter(p_temporel);
  }
  
  public int getTypeElementManipule()
  {
    return -1;
  }
}

/* Location:
 * Qualified Name:     FiltreAttributionAdr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */