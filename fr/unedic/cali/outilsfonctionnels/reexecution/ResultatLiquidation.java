package fr.unedic.cali.outilsfonctionnels.reexecution;

import fr.unedic.cali.dom.ElementComparaisonReexamen;
import java.util.ArrayList;
import java.util.List;

public class ResultatLiquidation
{
  public static final int ETAT_LIQUIDATION_ECHEC = 0;
  public static final int ETAT_LIQUIDATION_REMISE_EN_CAUSE = 1;
  public static final int ETAT_LIQUIDATION_RECONDUCTION_DECISION_NON_VALIDEE = 2;
  public static final int ETAT_LIQUIDATION_RECONDUCTION_DECISION_VALIDEE = 3;
  private int etatLiquidation;
  private List<ElementComparaisonReexamen> listeElementComparaison;
  
  public ResultatLiquidation()
  {
    listeElementComparaison = new ArrayList();
  }
  
  public int getEtatLiquidation()
  {
    return etatLiquidation;
  }
  
  public void setEtatLiquidation(int etatLiquidation)
  {
    this.etatLiquidation = etatLiquidation;
  }
  
  public List<ElementComparaisonReexamen> getListeElementComparaison()
  {
    return listeElementComparaison;
  }
  
  public void setListeElementComparaison(List p_listeElementComparaison)
  {
    listeElementComparaison = p_listeElementComparaison;
  }
}

/* Location:
 * Qualified Name:     ResultatLiquidation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */