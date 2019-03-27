package fr.unedic.cali.migration;

import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class FabriqueGrapheLiquidation
{
  public static GrapheLiquidationSpec creerGraphe(String p_nomProduit, boolean p_classement, int p_natureDecision)
  {
    GrapheLiquidationSpec graphe = null;
    
    graphe = Parametres.getProduit(p_nomProduit).creerGraphe(p_natureDecision, p_classement);
    
    return graphe;
  }
}

/* Location:
 * Qualified Name:     FabriqueGrapheLiquidation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */