package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandePourEreAMettreEnBasePivot
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepterElement(Temporel p_temporel)
  {
    try
    {
      if ((((DemandeSpec)p_temporel).getEvenementReferenceExamen() != null) && (((DemandeSpec)p_temporel).getEvenementReferenceExamen().mettreEnBasePivot())) {
        return true;
      }
    }
    catch (ClassCastException e)
    {
      return false;
    }
    return false;
  }
  
  public int getTypeElementManipule()
  {
    return 2;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandePourEreAMettreEnBasePivot
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */