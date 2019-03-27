package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.fabriques.FabriqueStrategieDeclarerSansGainOuHeure;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class StrategieDeterminationPriseEnCompteGainSurPANSApresMEP11SI1
  implements StrategieDeterminationPriseEnCompteGainSurPansSpec
{
  private static final BigDecimal PIVOT_DECLARE = new BigDecimal("0.90");
  
  public boolean priseEnCompteGainSurPANS()
  {
    return true;
  }
  
  public boolean comparerGainsHeuresDeclareJustifie(ProduitSpec produit, Damj datePivot, boolean pansSurMoisSeul, BigDecimal totalGainsJustifiees, BigDecimal totalGainsDeclares, BigDecimal totalHeuresJustifiees, BigDecimal totalHeuresDeclarees)
    throws CoucheLogiqueException
  {
    if (pansSurMoisSeul) {
      return totalGainsJustifiees.compareTo(totalGainsDeclares.multiply(PIVOT_DECLARE)) >= 0;
    }
    CritereStrategie critereStrategie = new CritereStrategie();
    critereStrategie.setDatePivot(datePivot);
    critereStrategie.setProduit(produit);
    StrategieDeclarerSansGainOuHeureSpec strategieDeclarerSansGainOuHeure = (StrategieDeclarerSansGainOuHeureSpec)FabriqueStrategieDeclarerSansGainOuHeure.getInstance().getStrategie(critereStrategie);
    
    return strategieDeclarerSansGainOuHeure.comparerSansGainsHeuresDeclare(datePivot, totalGainsJustifiees, totalGainsDeclares, totalHeuresJustifiees, totalHeuresDeclarees);
  }
}

/* Location:
 * Qualified Name:     StrategieDeterminationPriseEnCompteGainSurPANSApresMEP11SI1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */