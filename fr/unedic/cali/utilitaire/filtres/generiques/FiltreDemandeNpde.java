package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.autresdoms.d12i.dom.DonneesNPDE;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.generiques.conteneur.ConteneurFiltredemandeNpde;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandeNpde
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private transient ConteneurFiltredemandeNpde conteneurFiltredemandeNpde;
  
  public FiltreDemandeNpde() {}
  
  public FiltreDemandeNpde(ConteneurFiltredemandeNpde conteneurFiltredemandeNpde)
  {
    this.conteneurFiltredemandeNpde = conteneurFiltredemandeNpde;
  }
  
  public int getTypeElementManipule()
  {
    return 2;
  }
  
  public boolean accepterElement(Temporel temporel)
  {
    boolean retour = false;
    DemandeSpec demande = (DemandeSpec)temporel;
    try
    {
      DonneesNPDE donneesNpde = demande.getDonneesNPDE();
      retour = (demande.isDemandeNPDE()) && (conditionConteneur(donneesNpde));
    }
    catch (UnsupportedOperationException e)
    {
      retour = false;
    }
    return retour;
  }
  
  private boolean conditionConteneur(DonneesNPDE donneesNpde)
  {
    return (conteneurFiltredemandeNpde == null) || ((donneesNpde != null) && (conditionDemandeComplete(donneesNpde)) && (conditionDemandeLiquidationStandardAutoPossible(donneesNpde)));
  }
  
  private boolean conditionDemandeComplete(DonneesNPDE donneesNpde)
  {
    return (conteneurFiltredemandeNpde.getEstComplete() == null) || (conteneurFiltredemandeNpde.getEstComplete().booleanValue() == donneesNpde.isEstDemandeComplete());
  }
  
  private boolean conditionDemandeLiquidationStandardAutoPossible(DonneesNPDE donneesNpde)
  {
    return (conteneurFiltredemandeNpde.getEstLiquidationStandardAutoPossible() == null) || (conteneurFiltredemandeNpde.getEstLiquidationStandardAutoPossible().booleanValue() == donneesNpde.isLiquidationStandardAutoPossible());
  }
}

/* Location:
 * Qualified Name:     FiltreDemandeNpde
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */